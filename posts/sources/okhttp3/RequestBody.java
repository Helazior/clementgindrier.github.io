package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class RequestBody {
    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() {
        return -1L;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(InterfaceC1966le interfaceC1966le);

    public static RequestBody create(@Nullable final MediaType mediaType, final C2011ne c2011ne) {
        return new RequestBody() { // from class: okhttp3.RequestBody.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return c2011ne.mo550m();
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(InterfaceC1966le interfaceC1966le) {
                interfaceC1966le.mo140q(c2011ne);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new RequestBody() { // from class: okhttp3.RequestBody.2
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return i2;
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(InterfaceC1966le interfaceC1966le) {
                interfaceC1966le.mo148b(bArr, i, i2);
            }
        };
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        Objects.requireNonNull(file, "content == null");
        return new RequestBody() { // from class: okhttp3.RequestBody.3
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(InterfaceC1966le interfaceC1966le) {
                try {
                    File file2 = file;
                    Logger logger = C2263te.f6595a;
                    if (file2 != null) {
                        InterfaceC0073Ce m334f = C2263te.m334f(new FileInputStream(file2));
                        interfaceC1966le.mo147c(m334f);
                        Util.closeQuietly(m334f);
                        return;
                    }
                    throw new IllegalArgumentException("file == null");
                } catch (Throwable th) {
                    Util.closeQuietly((Closeable) null);
                    throw th;
                }
            }
        };
    }
}
