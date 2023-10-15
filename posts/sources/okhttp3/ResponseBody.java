package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final InterfaceC1987me source;

        public BomAwareReader(InterfaceC1987me interfaceC1987me, Charset charset) {
            this.source = interfaceC1987me;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.source.mo93D(), Util.bomAwareCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        C1946ke m654a0 = new C1946ke().m654a0(str, 0, str.length(), charset);
        return create(mediaType, m654a0.f5398b, m654a0);
    }

    public final InputStream byteStream() {
        return source().mo93D();
    }

    public final byte[] bytes() {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            InterfaceC1987me source = source();
            try {
                byte[] mo87k = source.mo87k();
                Util.closeQuietly(source);
                if (contentLength == -1 || contentLength == mo87k.length) {
                    return mo87k;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Length (");
                sb.append(contentLength);
                sb.append(") and stream length (");
                throw new IOException(outline.m263h(sb, mo87k.length, ") disagree"));
            } catch (Throwable th) {
                Util.closeQuietly(source);
                throw th;
            }
        }
        throw new IOException(outline.m272I("Cannot buffer entire body for content length: ", contentLength));
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract InterfaceC1987me source();

    public final String string() {
        InterfaceC1987me source = source();
        try {
            return source.mo94C(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly(source);
        }
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        C1946ke c1946ke = new C1946ke();
        c1946ke.m662S(bArr);
        return create(mediaType, bArr.length, c1946ke);
    }

    public static ResponseBody create(@Nullable final MediaType mediaType, final long j, final InterfaceC1987me interfaceC1987me) {
        Objects.requireNonNull(interfaceC1987me, "source == null");
        return new ResponseBody() { // from class: okhttp3.ResponseBody.1
            @Override // okhttp3.ResponseBody
            public long contentLength() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.ResponseBody
            public InterfaceC1987me source() {
                return interfaceC1987me;
            }
        };
    }
}
