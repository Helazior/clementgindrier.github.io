package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

@Deprecated
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder m253r = outline.m253r("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        m253r.append(this.width);
        m253r.append(" and height: ");
        throw new IllegalArgumentException(outline.m263h(m253r, this.height, ", either provide dimensions in the constructor or call override()"));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
