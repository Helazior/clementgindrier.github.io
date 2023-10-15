package com.pdfview.subsamplincscaleimageview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ImageRegionDecoder {
    Bitmap decodeRegion(Rect rect, int i);

    Point init(Context context, Uri uri);

    boolean isReady();

    void recycle();
}
