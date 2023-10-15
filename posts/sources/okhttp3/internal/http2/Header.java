package okhttp3.internal.http2;

import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Header {
    public final int hpackSize;
    public final C2011ne name;
    public final C2011ne value;
    public static final C2011ne PSEUDO_PREFIX = C2011ne.m557f(":");
    public static final C2011ne RESPONSE_STATUS = C2011ne.m557f(":status");
    public static final C2011ne TARGET_METHOD = C2011ne.m557f(":method");
    public static final C2011ne TARGET_PATH = C2011ne.m557f(":path");
    public static final C2011ne TARGET_SCHEME = C2011ne.m557f(":scheme");
    public static final C2011ne TARGET_AUTHORITY = C2011ne.m557f(":authority");

    public Header(String str, String str2) {
        this(C2011ne.m557f(str), C2011ne.m557f(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            return this.name.equals(header.name) && this.value.equals(header.value);
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() + ((this.name.hashCode() + 527) * 31);
    }

    public String toString() {
        return Util.format("%s: %s", this.name.mo546q(), this.value.mo546q());
    }

    public Header(C2011ne c2011ne, String str) {
        this(c2011ne, C2011ne.m557f(str));
    }

    public Header(C2011ne c2011ne, C2011ne c2011ne2) {
        this.name = c2011ne;
        this.value = c2011ne2;
        this.hpackSize = c2011ne2.mo550m() + c2011ne.mo550m() + 32;
    }
}
