package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class EngineKey implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class<?> resourceClass;
    private final Key signature;
    private final Class<?> transcodeClass;
    private final Map<Class<?>, Transformation<?>> transformations;
    private final int width;

    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.model = Preconditions.checkNotNull(obj);
        this.signature = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.transformations = (Map) Preconditions.checkNotNull(map);
        this.resourceClass = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof EngineKey) {
            EngineKey engineKey = (EngineKey) obj;
            return this.model.equals(engineKey.model) && this.signature.equals(engineKey.signature) && this.height == engineKey.height && this.width == engineKey.width && this.transformations.equals(engineKey.transformations) && this.resourceClass.equals(engineKey.resourceClass) && this.transcodeClass.equals(engineKey.transcodeClass) && this.options.equals(engineKey.options);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.model.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = this.signature.hashCode() + (hashCode * 31);
            this.hashCode = hashCode2;
            int i = (hashCode2 * 31) + this.width;
            this.hashCode = i;
            int i2 = (i * 31) + this.height;
            this.hashCode = i2;
            int hashCode3 = this.transformations.hashCode() + (i2 * 31);
            this.hashCode = hashCode3;
            int hashCode4 = this.resourceClass.hashCode() + (hashCode3 * 31);
            this.hashCode = hashCode4;
            int hashCode5 = this.transcodeClass.hashCode() + (hashCode4 * 31);
            this.hashCode = hashCode5;
            this.hashCode = this.options.hashCode() + (hashCode5 * 31);
        }
        return this.hashCode;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("EngineKey{model=");
        m253r.append(this.model);
        m253r.append(", width=");
        m253r.append(this.width);
        m253r.append(", height=");
        m253r.append(this.height);
        m253r.append(", resourceClass=");
        m253r.append(this.resourceClass);
        m253r.append(", transcodeClass=");
        m253r.append(this.transcodeClass);
        m253r.append(", signature=");
        m253r.append(this.signature);
        m253r.append(", hashCode=");
        m253r.append(this.hashCode);
        m253r.append(", transformations=");
        m253r.append(this.transformations);
        m253r.append(", options=");
        m253r.append(this.options);
        m253r.append('}');
        return m253r.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
