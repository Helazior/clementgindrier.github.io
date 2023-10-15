package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public Resource<Bitmap> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder m253r = outline.m253r("Decoded [");
            m253r.append(decodeBitmap.getWidth());
            m253r.append("x");
            m253r.append(decodeBitmap.getHeight());
            m253r.append("] for [");
            m253r.append(i);
            m253r.append("x");
            m253r.append(i2);
            m253r.append("]");
            Log.v(TAG, m253r.toString());
        }
        return new BitmapResource(decodeBitmap, this.bitmapPool);
    }
}
