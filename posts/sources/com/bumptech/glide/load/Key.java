package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Key {
    public static final String STRING_CHARSET_NAME = "UTF-8";
    public static final Charset CHARSET = Charset.forName(STRING_CHARSET_NAME);

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
