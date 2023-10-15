package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.p006io.FileSystem;
import okhttp3.internal.platform.Platform;
import p000.C1946ke;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    public final DiskLruCache cache;
    private int hitCount;
    public final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    public int writeAbortCount;
    public int writeSuccessCount;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class CacheRequestImpl implements CacheRequest {
        private InterfaceC0050Be body;
        private InterfaceC0050Be cacheOut;
        public boolean done;
        private final DiskLruCache.Editor editor;

        public CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.editor = editor;
            InterfaceC0050Be newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new AbstractC2030oe(newSink) { // from class: okhttp3.Cache.CacheRequestImpl.1
                @Override // p000.AbstractC2030oe, p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Cache.this) {
                        CacheRequestImpl cacheRequestImpl = CacheRequestImpl.this;
                        if (cacheRequestImpl.done) {
                            return;
                        }
                        cacheRequestImpl.done = true;
                        Cache.this.writeSuccessCount++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (Cache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache.this.writeAbortCount++;
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public InterfaceC0050Be body() {
            return this.body;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CacheResponseBody extends ResponseBody {
        private final InterfaceC1987me bodySource;
        @Nullable
        private final String contentLength;
        @Nullable
        private final String contentType;
        public final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            AbstractC2184pe abstractC2184pe = new AbstractC2184pe(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // p000.AbstractC2184pe, p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    snapshot.close();
                    super.close();
                }
            };
            Logger logger = C2263te.f6595a;
            this.bodySource = new C2358xe(abstractC2184pe);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            try {
                String str = this.contentLength;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public InterfaceC1987me source() {
            return this.bodySource;
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    private void abortQuietly(@Nullable DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return C2011ne.m557f(httpUrl.toString()).m558e("MD5").mo555h();
    }

    public static int readInt(InterfaceC1987me interfaceC1987me) {
        try {
            long mo81u = interfaceC1987me.mo81u();
            String mo88j = interfaceC1987me.mo88j();
            if (mo81u < 0 || mo81u > 2147483647L || !mo88j.isEmpty()) {
                throw new IOException("expected an int but was \"" + mo81u + mo88j + "\"");
            }
            return (int) mo81u;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public void delete() {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    @Nullable
    public Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    @Nullable
    public CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
            }
        }
    }

    public void remove(Request request) {
        this.cache.remove(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() {
        return this.cache.size();
    }

    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    public void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                    abortQuietly(editor);
                }
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    public Iterator<String> urls() {
        return new Iterator<String>() { // from class: okhttp3.Cache.2
            public boolean canRemove;
            public final Iterator<DiskLruCache.Snapshot> delegate;
            @Nullable
            public String nextUrl;

            {
                this.delegate = Cache.this.cache.snapshots();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        InterfaceC0073Ce source = next.getSource(0);
                        Logger logger = C2263te.f6595a;
                        this.nextUrl = new C2358xe(source).mo88j();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.canRemove) {
                    this.delegate.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }

            @Override // java.util.Iterator
            public String next() {
                if (hasNext()) {
                    String str = this.nextUrl;
                    this.nextUrl = null;
                    this.canRemove = true;
                    return str;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new InternalCache() { // from class: okhttp3.Cache.1
            @Override // okhttp3.internal.cache.InternalCache
            public Response get(Request request) {
                return Cache.this.get(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public CacheRequest put(Response response) {
                return Cache.this.put(response);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void remove(Request request) {
                Cache.this.remove(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void update(Response response, Response response2) {
                Cache.this.update(response, response2);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Entry {
        private final int code;
        @Nullable
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;
        private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
        private static final String RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";

        public Entry(InterfaceC0073Ce interfaceC0073Ce) {
            TlsVersion tlsVersion;
            try {
                Logger logger = C2263te.f6595a;
                C2358xe c2358xe = new C2358xe(interfaceC0073Ce);
                this.url = c2358xe.mo88j();
                this.requestMethod = c2358xe.mo88j();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(c2358xe);
                for (int i = 0; i < readInt; i++) {
                    builder.addLenient(c2358xe.mo88j());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(c2358xe.mo88j());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(c2358xe);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    builder2.addLenient(c2358xe.mo88j());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String mo88j = c2358xe.mo88j();
                    if (mo88j.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.forJavaName(c2358xe.mo88j());
                        List<Certificate> readCertificateList = readCertificateList(c2358xe);
                        List<Certificate> readCertificateList2 = readCertificateList(c2358xe);
                        if (!c2358xe.mo85m()) {
                            tlsVersion = TlsVersion.forJavaName(c2358xe.mo88j());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + mo88j + "\"");
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                interfaceC0073Ce.close();
            }
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(InterfaceC1987me interfaceC1987me) {
            int readInt = Cache.readInt(interfaceC1987me);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String mo88j = interfaceC1987me.mo88j();
                    C1946ke c1946ke = new C1946ke();
                    c1946ke.m663R(C2011ne.m561b(mo88j));
                    arrayList.add(certificateFactory.generateCertificate(new C1946ke.C1947a()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(InterfaceC1966le interfaceC1966le, List<Certificate> list) {
            try {
                interfaceC1966le.mo137y(list.size()).mo142n(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    interfaceC1966le.mo138x(C2011ne.m554i(list.get(i).getEncoded()).mo562a()).mo142n(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && HttpHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public void writeTo(DiskLruCache.Editor editor) {
            InterfaceC0050Be newSink = editor.newSink(0);
            Logger logger = C2263te.f6595a;
            C2335we c2335we = new C2335we(newSink);
            c2335we.mo138x(this.url);
            c2335we.mo142n(10);
            c2335we.mo138x(this.requestMethod);
            c2335we.mo142n(10);
            c2335we.mo137y(this.varyHeaders.size());
            c2335we.mo142n(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                c2335we.mo138x(this.varyHeaders.name(i));
                c2335we.mo138x(": ");
                c2335we.mo138x(this.varyHeaders.value(i));
                c2335we.mo142n(10);
            }
            c2335we.mo138x(new StatusLine(this.protocol, this.code, this.message).toString());
            c2335we.mo142n(10);
            c2335we.mo137y(this.responseHeaders.size() + 2);
            c2335we.mo142n(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                c2335we.mo138x(this.responseHeaders.name(i2));
                c2335we.mo138x(": ");
                c2335we.mo138x(this.responseHeaders.value(i2));
                c2335we.mo142n(10);
            }
            c2335we.mo138x(SENT_MILLIS);
            c2335we.mo138x(": ");
            c2335we.mo137y(this.sentRequestMillis);
            c2335we.mo142n(10);
            c2335we.mo138x(RECEIVED_MILLIS);
            c2335we.mo138x(": ");
            c2335we.mo137y(this.receivedResponseMillis);
            c2335we.mo142n(10);
            if (isHttps()) {
                c2335we.mo142n(10);
                c2335we.mo138x(this.handshake.cipherSuite().javaName());
                c2335we.mo142n(10);
                writeCertList(c2335we, this.handshake.peerCertificates());
                writeCertList(c2335we, this.handshake.localCertificates());
                c2335we.mo138x(this.handshake.tlsVersion().javaName());
                c2335we.mo142n(10);
            }
            c2335we.close();
        }

        public Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
