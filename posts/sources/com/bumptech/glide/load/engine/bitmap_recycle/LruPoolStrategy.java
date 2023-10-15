package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface LruPoolStrategy {
    Bitmap get(int i, int i2, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i, int i2, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    Bitmap removeLast();
}
