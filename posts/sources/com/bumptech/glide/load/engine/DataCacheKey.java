package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    public DataCacheKey(Key key, Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            return this.sourceKey.equals(dataCacheKey.sourceKey) && this.signature.equals(dataCacheKey.signature);
        }
        return false;
    }

    public Key getSourceKey() {
        return this.sourceKey;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode() + (this.sourceKey.hashCode() * 31);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("DataCacheKey{sourceKey=");
        m253r.append(this.sourceKey);
        m253r.append(", signature=");
        m253r.append(this.signature);
        m253r.append('}');
        return m253r.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
