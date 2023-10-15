package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Transformation<T> extends Key {
    Resource<T> transform(Context context, Resource<T> resource, int i, int i2);
}
