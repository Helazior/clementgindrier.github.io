package com.pdfview.subsamplincscaleimageview.decoder;

import android.graphics.Bitmap;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // com.pdfview.subsamplincscaleimageview.decoder.DecoderFactory
    public T make() {
        return this.bitmapConfig == null ? this.clazz.newInstance() : this.clazz.getConstructor(Bitmap.Config.class).newInstance(this.bitmapConfig);
    }

    public CompatDecoderFactory(Class<? extends T> cls, Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }
}
