package okhttp3;

import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Challenge {
    private final Charset charset;
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this(str, str2, Util.ISO_8859_1);
    }

    public Charset charset() {
        return this.charset;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (challenge.scheme.equals(this.scheme) && challenge.realm.equals(this.realm) && challenge.charset.equals(this.charset)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.scheme.hashCode();
        return this.charset.hashCode() + ((hashCode + ((this.realm.hashCode() + 899) * 31)) * 31);
    }

    public String realm() {
        return this.realm;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\" charset=\"" + this.charset + "\"";
    }

    public Challenge withCharset(Charset charset) {
        return new Challenge(this.scheme, this.realm, charset);
    }

    private Challenge(String str, String str2, Charset charset) {
        Objects.requireNonNull(str, "scheme == null");
        Objects.requireNonNull(str2, "realm == null");
        Objects.requireNonNull(charset, "charset == null");
        this.scheme = str;
        this.realm = str2;
        this.charset = charset;
    }
}
