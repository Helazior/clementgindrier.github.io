package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FinderPattern extends ResultPoint {
    private int count;
    private final float estimatedModuleSize;

    public FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    public FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count;
        int i2 = i + 1;
        float x = (getX() * i) + f2;
        float f4 = i2;
        return new FinderPattern(x / f4, ((getY() * this.count) + f) / f4, ((this.count * this.estimatedModuleSize) + f3) / f4, i2);
    }

    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    public void incrementCount() {
        this.count++;
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i;
    }
}
