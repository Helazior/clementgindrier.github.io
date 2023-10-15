package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Preconditions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PreFillType {
    public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i) {
            this(i, i);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public Builder setWeight(int i) {
            if (i > 0) {
                this.weight = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 > 0) {
                this.width = i;
                this.height = i2;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    public PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.width = i;
        this.height = i2;
        this.weight = i3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
        }
        return false;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.config.hashCode() + (((this.width * 31) + this.height) * 31)) * 31) + this.weight;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("PreFillSize{width=");
        m253r.append(this.width);
        m253r.append(", height=");
        m253r.append(this.height);
        m253r.append(", config=");
        m253r.append(this.config);
        m253r.append(", weight=");
        m253r.append(this.weight);
        m253r.append('}');
        return m253r.toString();
    }
}
