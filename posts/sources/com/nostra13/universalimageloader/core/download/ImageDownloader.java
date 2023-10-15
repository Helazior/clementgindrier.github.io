package com.nostra13.universalimageloader.core.download;

import java.io.InputStream;
import java.util.Locale;
import org.ksoap2.transport.HttpsTransportSE;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ImageDownloader {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum Scheme {
        HTTP("http"),
        HTTPS(HttpsTransportSE.PROTOCOL),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        
        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = outline.m266e(str, "://");
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                Scheme[] values = values();
                for (int i = 0; i < 7; i++) {
                    Scheme scheme = values[i];
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        public String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }

        public String wrap(String str) {
            return outline.m262i(new StringBuilder(), this.uriPrefix, str);
        }
    }

    InputStream getStream(String str, Object obj);
}
