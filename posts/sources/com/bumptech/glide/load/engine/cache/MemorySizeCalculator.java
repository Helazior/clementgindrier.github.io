package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class MemorySizeCalculator {
    public static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Builder {
        public static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        public static final int BITMAP_POOL_TARGET_SCREENS;
        public static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        public static final float MAX_SIZE_MULTIPLIER = 0.4f;
        public static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        public ActivityManager activityManager;
        public float bitmapPoolScreens;
        public final Context context;
        public ScreenDimensions screenDimensions;
        public float memoryCacheScreens = 2.0f;
        public float maxSizeMultiplier = 0.4f;
        public float lowMemoryMaxSizeMultiplier = 0.33f;
        public int arrayPoolSizeBytes = 4194304;

        static {
            BITMAP_POOL_TARGET_SCREENS = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.context = context;
            this.activityManager = (ActivityManager) context.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                return;
            }
            this.bitmapPoolScreens = 0.0f;
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setActivityManager(ActivityManager activityManager) {
            this.activityManager = activityManager;
            return this;
        }

        public Builder setArrayPoolSize(int i) {
            this.arrayPoolSizeBytes = i;
            return this;
        }

        public Builder setBitmapPoolScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f;
            return this;
        }

        public Builder setMemoryCacheScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f;
            return this;
        }

        public Builder setScreenDimensions(ScreenDimensions screenDimensions) {
            this.screenDimensions = screenDimensions;
            return this;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i = builder.arrayPoolSizeBytes / 2;
        } else {
            i = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float heightPixels = builder.screenDimensions.getHeightPixels() * builder.screenDimensions.getWidthPixels() * 4;
        int round = Math.round(builder.bitmapPoolScreens * heightPixels);
        int round2 = Math.round(heightPixels * builder.memoryCacheScreens);
        int i2 = maxSize - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f = i2;
            float f2 = builder.bitmapPoolScreens;
            float f3 = builder.memoryCacheScreens;
            float f4 = f / (f2 + f3);
            this.memoryCacheSize = Math.round(f3 * f4);
            this.bitmapPoolSize = Math.round(f4 * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder m253r = outline.m253r("Calculation complete, Calculated memory cache size: ");
            m253r.append(toMb(this.memoryCacheSize));
            m253r.append(", pool size: ");
            m253r.append(toMb(this.bitmapPoolSize));
            m253r.append(", byte array size: ");
            m253r.append(toMb(i));
            m253r.append(", memory class limited? ");
            m253r.append(i3 > maxSize);
            m253r.append(", max size: ");
            m253r.append(toMb(maxSize));
            m253r.append(", memoryClass: ");
            m253r.append(builder.activityManager.getMemoryClass());
            m253r.append(", isLowMemoryDevice: ");
            m253r.append(isLowMemoryDevice(builder.activityManager));
            Log.d(TAG, m253r.toString());
        }
    }

    private static int getMaxSize(ActivityManager activityManager, float f, float f2) {
        boolean isLowMemoryDevice = isLowMemoryDevice(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (isLowMemoryDevice) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i) {
        return Formatter.formatFileSize(this.context, i);
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
