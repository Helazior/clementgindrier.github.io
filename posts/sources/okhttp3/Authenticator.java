package okhttp3;

import javax.annotation.Nullable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: okhttp3.Authenticator.1
        @Override // okhttp3.Authenticator
        public Request authenticate(Route route, Response response) {
            return null;
        }
    };

    @Nullable
    Request authenticate(Route route, Response response);
}
