package com.squareup.picasso;

import android.graphics.Bitmap;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Transformation {
    String key();

    Bitmap transform(Bitmap bitmap);
}
