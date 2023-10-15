package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t, int i, int i2, Options options);

    boolean handles(T t, Options options);
}
