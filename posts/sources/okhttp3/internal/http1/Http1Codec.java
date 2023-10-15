package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    public final OkHttpClient client;
    public final InterfaceC1966le sink;
    public final InterfaceC1987me source;
    public final StreamAllocation streamAllocation;
    public int state = 0;
    private long headerLimit = 262144;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public abstract class AbstractSource implements InterfaceC0073Ce {
        public long bytesRead;
        public boolean closed;
        public final C2203qe timeout;

        private AbstractSource() {
            this.timeout = new C2203qe(Http1Codec.this.source.timeout());
            this.bytesRead = 0L;
        }

        @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close();

        public final void endOfInput(boolean z, IOException iOException) {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.state;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                http1Codec.detachTimeout(this.timeout);
                Http1Codec http1Codec2 = Http1Codec.this;
                http1Codec2.state = 6;
                StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                if (streamAllocation != null) {
                    streamAllocation.streamFinished(!z, http1Codec2, this.bytesRead, iOException);
                    return;
                }
                return;
            }
            StringBuilder m253r = outline.m253r("state: ");
            m253r.append(Http1Codec.this.state);
            throw new IllegalStateException(m253r.toString());
        }

        @Override // p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            try {
                long read = Http1Codec.this.source.read(c1946ke, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(false, e);
                throw e;
            }
        }

        @Override // p000.InterfaceC0073Ce
        public C0097De timeout() {
            return this.timeout;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class ChunkedSink implements InterfaceC0050Be {
        private boolean closed;
        private final C2203qe timeout;

        public ChunkedSink() {
            this.timeout = new C2203qe(Http1Codec.this.sink.timeout());
        }

        @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1Codec.this.sink.mo138x("0\r\n\r\n");
            Http1Codec.this.detachTimeout(this.timeout);
            Http1Codec.this.state = 3;
        }

        @Override // p000.InterfaceC0050Be, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1Codec.this.sink.flush();
        }

        @Override // p000.InterfaceC0050Be
        public C0097De timeout() {
            return this.timeout;
        }

        @Override // p000.InterfaceC0050Be
        public void write(C1946ke c1946ke, long j) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1Codec.this.sink.mo146d(j);
            Http1Codec.this.sink.mo138x("\r\n");
            Http1Codec.this.sink.write(c1946ke, j);
            Http1Codec.this.sink.mo138x("\r\n");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpUrl url;

        public ChunkedSource(HttpUrl httpUrl) {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = httpUrl;
        }

        private void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.source.mo88j();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.mo95B();
                String trim = Http1Codec.this.source.mo88j().trim();
                if (this.bytesRemainingInChunk >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.bytesRemainingInChunk == 0) {
                        this.hasMoreChunks = false;
                        HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                        endOfInput(true, null);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            if (j >= 0) {
                if (!this.closed) {
                    if (this.hasMoreChunks) {
                        long j2 = this.bytesRemainingInChunk;
                        if (j2 == 0 || j2 == -1) {
                            readChunkSize();
                            if (!this.hasMoreChunks) {
                                return -1L;
                            }
                        }
                        long read = super.read(c1946ke, Math.min(j, this.bytesRemainingInChunk));
                        if (read != -1) {
                            this.bytesRemainingInChunk -= read;
                            return read;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        endOfInput(false, protocolException);
                        throw protocolException;
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class FixedLengthSink implements InterfaceC0050Be {
        private long bytesRemaining;
        private boolean closed;
        private final C2203qe timeout;

        public FixedLengthSink(long j) {
            this.timeout = new C2203qe(Http1Codec.this.sink.timeout());
            this.bytesRemaining = j;
        }

        @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining <= 0) {
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // p000.InterfaceC0050Be, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            Http1Codec.this.sink.flush();
        }

        @Override // p000.InterfaceC0050Be
        public C0097De timeout() {
            return this.timeout;
        }

        @Override // p000.InterfaceC0050Be
        public void write(C1946ke c1946ke, long j) {
            if (!this.closed) {
                Util.checkOffsetAndCount(c1946ke.f5398b, 0L, j);
                if (j <= this.bytesRemaining) {
                    Http1Codec.this.sink.write(c1946ke, j);
                    this.bytesRemaining -= j;
                    return;
                }
                StringBuilder m253r = outline.m253r("expected ");
                m253r.append(this.bytesRemaining);
                m253r.append(" bytes but received ");
                m253r.append(j);
                throw new ProtocolException(m253r.toString());
            }
            throw new IllegalStateException("closed");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true, null);
            }
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            if (j >= 0) {
                if (!this.closed) {
                    long j2 = this.bytesRemaining;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long read = super.read(c1946ke, Math.min(j2, j));
                    if (read != -1) {
                        long j3 = this.bytesRemaining - read;
                        this.bytesRemaining = j3;
                        if (j3 == 0) {
                            endOfInput(true, null);
                        }
                        return read;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    endOfInput(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        public UnknownLengthSource() {
            super();
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            if (j >= 0) {
                if (!this.closed) {
                    if (this.inputExhausted) {
                        return -1L;
                    }
                    long read = super.read(c1946ke, j);
                    if (read == -1) {
                        this.inputExhausted = true;
                        endOfInput(true, null);
                        return -1L;
                    }
                    return read;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, InterfaceC1987me interfaceC1987me, InterfaceC1966le interfaceC1966le) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = interfaceC1987me;
        this.sink = interfaceC1966le;
    }

    private String readHeaderLine() {
        String mo80v = this.source.mo80v(this.headerLimit);
        this.headerLimit -= mo80v.length();
        return mo80v;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public InterfaceC0050Be createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void detachTimeout(C2203qe c2203qe) {
        C0097De c0097De = c2203qe.f6310a;
        C0097De c0097De2 = C0097De.NONE;
        if (c0097De2 != null) {
            c2203qe.f6310a = c0097De2;
            c0097De.clearDeadline();
            c0097De.clearTimeout();
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public InterfaceC0050Be newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        StringBuilder m253r = outline.m253r("state: ");
        m253r.append(this.state);
        throw new IllegalStateException(m253r.toString());
    }

    public InterfaceC0073Ce newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpUrl);
        }
        StringBuilder m253r = outline.m253r("state: ");
        m253r.append(this.state);
        throw new IllegalStateException(m253r.toString());
    }

    public InterfaceC0050Be newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        StringBuilder m253r = outline.m253r("state: ");
        m253r.append(this.state);
        throw new IllegalStateException(m253r.toString());
    }

    public InterfaceC0073Ce newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        StringBuilder m253r = outline.m253r("state: ");
        m253r.append(this.state);
        throw new IllegalStateException(m253r.toString());
    }

    public InterfaceC0073Ce newUnknownLengthSource() {
        if (this.state == 4) {
            StreamAllocation streamAllocation = this.streamAllocation;
            if (streamAllocation != null) {
                this.state = 5;
                streamAllocation.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder m253r = outline.m253r("state: ");
        m253r.append(this.state);
        throw new IllegalStateException(m253r.toString());
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) {
        StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            InterfaceC0073Ce newFixedLengthSource = newFixedLengthSource(0L);
            Logger logger = C2263te.f6595a;
            return new RealResponseBody(header, 0L, new C2358xe(newFixedLengthSource));
        } else if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            InterfaceC0073Ce newChunkedSource = newChunkedSource(response.request().url());
            Logger logger2 = C2263te.f6595a;
            return new RealResponseBody(header, -1L, new C2358xe(newChunkedSource));
        } else {
            long contentLength = HttpHeaders.contentLength(response);
            if (contentLength != -1) {
                InterfaceC0073Ce newFixedLengthSource2 = newFixedLengthSource(contentLength);
                Logger logger3 = C2263te.f6595a;
                return new RealResponseBody(header, contentLength, new C2358xe(newFixedLengthSource2));
            }
            InterfaceC0073Ce newUnknownLengthSource = newUnknownLengthSource();
            Logger logger4 = C2263te.f6595a;
            return new RealResponseBody(header, -1L, new C2358xe(newUnknownLengthSource));
        }
    }

    public Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() != 0) {
                Internal.instance.addLenient(builder, readHeaderLine);
            } else {
                return builder.build();
            }
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) {
        int i = this.state;
        if (i != 1 && i != 3) {
            StringBuilder m253r = outline.m253r("state: ");
            m253r.append(this.state);
            throw new IllegalStateException(m253r.toString());
        }
        try {
            StatusLine parse = StatusLine.parse(readHeaderLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            if (z && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.state = 3;
                return headers;
            }
            this.state = 4;
            return headers;
        } catch (EOFException e) {
            StringBuilder m253r2 = outline.m253r("unexpected end of stream on ");
            m253r2.append(this.streamAllocation);
            IOException iOException = new IOException(m253r2.toString());
            iOException.initCause(e);
            throw iOException;
        }
    }

    public void writeRequest(Headers headers, String str) {
        if (this.state == 0) {
            this.sink.mo138x(str).mo138x("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.mo138x(headers.name(i)).mo138x(": ").mo138x(headers.value(i)).mo138x("\r\n");
            }
            this.sink.mo138x("\r\n");
            this.state = 1;
            return;
        }
        StringBuilder m253r = outline.m253r("state: ");
        m253r.append(this.state);
        throw new IllegalStateException(m253r.toString());
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }
}
