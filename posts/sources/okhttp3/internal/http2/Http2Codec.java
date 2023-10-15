package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Http2Codec implements HttpCodec {
    private static final C2011ne CONNECTION;
    private static final C2011ne ENCODING;
    private static final C2011ne HOST;
    private static final List<C2011ne> HTTP_2_SKIPPED_REQUEST_HEADERS;
    private static final List<C2011ne> HTTP_2_SKIPPED_RESPONSE_HEADERS;
    private static final C2011ne KEEP_ALIVE;
    private static final C2011ne PROXY_CONNECTION;

    /* renamed from: TE */
    private static final C2011ne f5628TE;
    private static final C2011ne TRANSFER_ENCODING;
    private static final C2011ne UPGRADE;
    private final Interceptor.Chain chain;
    private final OkHttpClient client;
    private final Http2Connection connection;
    private Http2Stream stream;
    public final StreamAllocation streamAllocation;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class StreamFinishingSource extends AbstractC2184pe {
        public long bytesRead;
        public boolean completed;

        public StreamFinishingSource(InterfaceC0073Ce interfaceC0073Ce) {
            super(interfaceC0073Ce);
            this.completed = false;
            this.bytesRead = 0L;
        }

        private void endOfInput(IOException iOException) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
        }

        @Override // p000.AbstractC2184pe, p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            endOfInput(null);
        }

        @Override // p000.AbstractC2184pe, p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            try {
                long read = delegate().read(c1946ke, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(e);
                throw e;
            }
        }
    }

    static {
        C2011ne m557f = C2011ne.m557f("connection");
        CONNECTION = m557f;
        C2011ne m557f2 = C2011ne.m557f("host");
        HOST = m557f2;
        C2011ne m557f3 = C2011ne.m557f("keep-alive");
        KEEP_ALIVE = m557f3;
        C2011ne m557f4 = C2011ne.m557f("proxy-connection");
        PROXY_CONNECTION = m557f4;
        C2011ne m557f5 = C2011ne.m557f("transfer-encoding");
        TRANSFER_ENCODING = m557f5;
        C2011ne m557f6 = C2011ne.m557f("te");
        f5628TE = m557f6;
        C2011ne m557f7 = C2011ne.m557f("encoding");
        ENCODING = m557f7;
        C2011ne m557f8 = C2011ne.m557f("upgrade");
        UPGRADE = m557f8;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(m557f, m557f2, m557f3, m557f4, m557f6, m557f5, m557f7, m557f8, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY);
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(m557f, m557f2, m557f3, m557f4, m557f6, m557f5, m557f7, m557f8);
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.client = okHttpClient;
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            C2011ne m557f = C2011ne.m557f(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(m557f)) {
                arrayList.add(new Header(m557f, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = list.get(i);
            if (header == null) {
                if (statusLine != null && statusLine.code == 100) {
                    builder = new Headers.Builder();
                    statusLine = null;
                }
            } else {
                C2011ne c2011ne = header.name;
                String mo546q = header.value.mo546q();
                if (c2011ne.equals(Header.RESPONSE_STATUS)) {
                    statusLine = StatusLine.parse("HTTP/1.1 " + mo546q);
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(c2011ne)) {
                    Internal.instance.addLenient(builder, c2011ne.mo546q(), mo546q);
                }
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public InterfaceC0050Be createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) {
        StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        String header = response.header("Content-Type");
        long contentLength = HttpHeaders.contentLength(response);
        StreamFinishingSource streamFinishingSource = new StreamFinishingSource(this.stream.getSource());
        Logger logger = C2263te.f6595a;
        return new RealResponseBody(header, contentLength, new C2358xe(streamFinishingSource));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders());
        if (z && Internal.instance.code(readHttp2HeadersList) == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) {
        if (this.stream != null) {
            return;
        }
        Http2Stream newStream = this.connection.newStream(http2HeadersList(request), request.body() != null);
        this.stream = newStream;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newStream.readTimeout().timeout(this.chain.readTimeoutMillis(), timeUnit);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }
}
