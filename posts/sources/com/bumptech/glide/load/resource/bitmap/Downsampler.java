package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    private static final DecodeCallbacks EMPTY_CALLBACKS;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE;
    public static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap);

        void onObtainBounds();
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(WBMP_MIME_TYPE, ICO_MIME_TYPE)));
        EMPTY_CALLBACKS = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onObtainBounds() {
            }
        };
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        int round = round(densityMultiplier * d);
        return round((d / (round / densityMultiplier)) * round);
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, z, z2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            boolean z3 = false;
            try {
                z3 = imageReader.getImageType().hasAlpha();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        int i6;
        int i7;
        int min;
        int i8;
        int floor;
        double floor2;
        int i9;
        if (i2 > 0 && i3 > 0) {
            if (isRotationRequired(i)) {
                i7 = i2;
                i6 = i3;
            } else {
                i6 = i2;
                i7 = i3;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(i6, i7, i4, i5);
            if (scaleFactor > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i6, i7, i4, i5);
                if (sampleSizeRounding != null) {
                    float f = i6;
                    float f2 = i7;
                    int round = i6 / round(scaleFactor * f);
                    int round2 = i7 / round(scaleFactor * f2);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (sampleSizeRounding == sampleSizeRounding2) {
                        min = Math.max(round, round2);
                    } else {
                        min = Math.min(round, round2);
                    }
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options.outMimeType)) {
                        int max = Math.max(1, Integer.highestOneBit(min));
                        if (sampleSizeRounding == sampleSizeRounding2 && max < 1.0f / scaleFactor) {
                            max <<= 1;
                        }
                        i8 = max;
                    } else {
                        i8 = 1;
                    }
                    options.inSampleSize = i8;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(i8, 8);
                        floor = (int) Math.ceil(f / min2);
                        i9 = (int) Math.ceil(f2 / min2);
                        int i11 = i8 / 8;
                        if (i11 > 0) {
                            floor /= i11;
                            i9 /= i11;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                                if (i10 >= 24) {
                                    float f3 = i8;
                                    floor = Math.round(f / f3);
                                    i9 = Math.round(f2 / f3);
                                } else {
                                    float f4 = i8;
                                    floor = (int) Math.floor(f / f4);
                                    floor2 = Math.floor(f2 / f4);
                                }
                            } else if (i6 % i8 == 0 && i7 % i8 == 0) {
                                floor = i6 / i8;
                                i9 = i7 / i8;
                            } else {
                                int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, bitmapPool);
                                floor = dimensions[0];
                                i9 = dimensions[1];
                            }
                        } else {
                            float f5 = i8;
                            floor = (int) Math.floor(f / f5);
                            floor2 = Math.floor(f2 / f5);
                        }
                        i9 = (int) floor2;
                    }
                    double scaleFactor2 = downsampleStrategy.getScaleFactor(floor, i9, i4, i5);
                    options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
                    options.inDensity = getDensityMultiplier(scaleFactor2);
                    if (isScaling(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Calculate scaling, source: [" + i2 + "x" + i3 + "], degreesToRotate: " + i + ", target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + i9 + "], exact scale factor: " + scaleFactor + ", power of 2 sample size: " + i8 + ", adjusted scale factor: " + scaleFactor2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        } else if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + "]");
        }
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) {
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        ColorSpace colorSpace;
        int round;
        int round2;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, this.bitmapPool);
        boolean z3 = false;
        int i7 = dimensions[0];
        int i8 = dimensions[1];
        String str2 = options.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        if (i == Integer.MIN_VALUE) {
            i3 = i2;
            i4 = isRotationRequired(exifOrientationDegrees) ? i8 : i7;
        } else {
            i3 = i2;
            i4 = i;
        }
        if (i3 == Integer.MIN_VALUE) {
            i5 = isRotationRequired(exifOrientationDegrees) ? i7 : i8;
        } else {
            i5 = i3;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i7, i8, i4, i5, options);
        calculateConfig(imageReader, decodeFormat, z4, isExifOrientationRequired, options, i4, i5);
        int i9 = Build.VERSION.SDK_INT;
        int i10 = options.inSampleSize;
        if (shouldUsePool(imageType)) {
            if (i7 < 0 || i8 < 0 || !z2) {
                float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i11 = options.inSampleSize;
                float f2 = i11;
                round = Math.round(((int) Math.ceil(i7 / f2)) * f);
                round2 = Math.round(((int) Math.ceil(i8 / f2)) * f);
                str = TAG;
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + round + "x" + round2 + "] for source [" + i7 + "x" + i8 + "], sampleSize: " + i11 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                }
            } else {
                str = TAG;
                round = i4;
                round2 = i5;
            }
            if (round > 0 && round2 > 0) {
                setInBitmap(options, this.bitmapPool, round, round2);
            }
        } else {
            str = TAG;
        }
        if (i9 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i9 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap decodeStream = decodeStream(imageReader, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(str, 2)) {
            i6 = imageOrientation;
            logDecode(i7, i8, str2, options, decodeStream, i, i2, logTime);
        } else {
            i6 = imageOrientation;
        }
        Bitmap bitmap = null;
        if (decodeStream != null) {
            decodeStream.setDensity(this.displayMetrics.densityDpi);
            bitmap = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i6);
            if (!decodeStream.equals(bitmap)) {
                this.bitmapPool.put(decodeStream);
            }
        }
        return bitmap;
    }

    private static Bitmap decodeStream(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.onObtainBounds();
            imageReader.stopGrowingBuffers();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            try {
                Bitmap decodeBitmap = imageReader.decodeBitmap(options);
                TransformationUtils.getBitmapDrawableLock().unlock();
                return decodeBitmap;
            } catch (IllegalArgumentException e) {
                IOException newIoExceptionForInBitmapAssertion = newIoExceptionForInBitmapAssertion(e, i, i2, str, options);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", newIoExceptionForInBitmapAssertion);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        bitmapPool.put(bitmap);
                        options.inBitmap = null;
                        Bitmap decodeStream = decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
                        TransformationUtils.getBitmapDrawableLock().unlock();
                        return decodeStream;
                    } catch (IOException unused) {
                        throw newIoExceptionForInBitmapAssertion;
                    }
                }
                throw newIoExceptionForInBitmapAssertion;
            }
        } catch (Throwable th) {
            TransformationUtils.getBitmapDrawableLock().unlock();
            throw th;
        }
    }

    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder m253r = outline.m253r(" (");
        m253r.append(bitmap.getAllocationByteCount());
        m253r.append(")");
        String sb = m253r.toString();
        StringBuilder m253r2 = outline.m253r("[");
        m253r2.append(bitmap.getWidth());
        m253r2.append("x");
        m253r2.append(bitmap.getHeight());
        m253r2.append("] ");
        m253r2.append(bitmap.getConfig());
        m253r2.append(sb);
        return m253r2.toString();
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        StringBuilder m253r = outline.m253r("Decoded ");
        m253r.append(getBitmapString(bitmap));
        m253r.append(" from [");
        m253r.append(i);
        m253r.append("x");
        m253r.append(i2);
        m253r.append("] ");
        m253r.append(str);
        m253r.append(" with inBitmap ");
        m253r.append(getInBitmapString(options));
        m253r.append(" for [");
        m253r.append(i3);
        m253r.append("x");
        m253r.append(i4);
        m253r.append("], sample size: ");
        m253r.append(options.inSampleSize);
        m253r.append(", density: ");
        m253r.append(options.inDensity);
        m253r.append(", target density: ");
        m253r.append(options.inTargetDensity);
        m253r.append(", thread: ");
        m253r.append(Thread.currentThread().getName());
        m253r.append(", duration: ");
        m253r.append(LogTime.getElapsedMillis(j));
        Log.v(TAG, m253r.toString());
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i, i2, config);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        return decode(new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) {
        return decode(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i, i2, booleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }
}
