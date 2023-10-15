package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, Util.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        String m265f = outline.m265f(str, ":", str2);
        char[] cArr = C2011ne.f5560d;
        if (m265f != null) {
            if (charset != null) {
                return outline.m266e("Basic ", new C2011ne(m265f.getBytes(charset)).mo562a());
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("s == null");
    }
}
