package com.pdfview.subsamplincscaleimageview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri);
}
