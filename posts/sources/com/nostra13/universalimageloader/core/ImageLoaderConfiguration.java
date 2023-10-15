package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.C1564L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ImageLoaderConfiguration {
    public final boolean customExecutor;
    public final boolean customExecutorForCachedImages;
    public final ImageDecoder decoder;
    public final DisplayImageOptions defaultDisplayImageOptions;
    public final DiskCache diskCache;
    public final ImageDownloader downloader;
    public final int maxImageHeightForDiskCache;
    public final int maxImageHeightForMemoryCache;
    public final int maxImageWidthForDiskCache;
    public final int maxImageWidthForMemoryCache;
    public final MemoryCache memoryCache;
    public final ImageDownloader networkDeniedDownloader;
    public final BitmapProcessor processorForDiskCache;
    public final Resources resources;
    public final ImageDownloader slowNetworkDownloader;
    public final Executor taskExecutor;
    public final Executor taskExecutorForCachedImages;
    public final QueueProcessingType tasksProcessingType;
    public final int threadPoolSize;
    public final int threadPriority;

    /* renamed from: com.nostra13.universalimageloader.core.ImageLoaderConfiguration$1 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15551 {

        /* renamed from: $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme */
        public static final /* synthetic */ int[] f3932x4730d1a3;

        static {
            ImageDownloader.Scheme.values();
            int[] iArr = new int[7];
            f3932x4730d1a3 = iArr;
            try {
                ImageDownloader.Scheme scheme = ImageDownloader.Scheme.HTTP;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3932x4730d1a3;
                ImageDownloader.Scheme scheme2 = ImageDownloader.Scheme.HTTPS;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Builder {
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        private Context context;
        private ImageDecoder decoder;
        private int maxImageWidthForMemoryCache = 0;
        private int maxImageHeightForMemoryCache = 0;
        private int maxImageWidthForDiskCache = 0;
        private int maxImageHeightForDiskCache = 0;
        private BitmapProcessor processorForDiskCache = null;
        private Executor taskExecutor = null;
        private Executor taskExecutorForCachedImages = null;
        private boolean customExecutor = false;
        private boolean customExecutorForCachedImages = false;
        private int threadPoolSize = 3;
        private int threadPriority = 3;
        private boolean denyCacheImageMultipleSizesInMemory = false;
        private QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        private int memoryCacheSize = 0;
        private long diskCacheSize = 0;
        private int diskCacheFileCount = 0;
        private MemoryCache memoryCache = null;
        private DiskCache diskCache = null;
        private FileNameGenerator diskCacheFileNameGenerator = null;
        private ImageDownloader downloader = null;
        private DisplayImageOptions defaultDisplayImageOptions = null;
        private boolean writeLogs = false;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.diskCache == null) {
                if (this.diskCacheFileNameGenerator == null) {
                    this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache) {
            return diskCache(diskCache);
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i, int i2, BitmapProcessor bitmapProcessor) {
            return diskCacheExtraOptions(i, i2, bitmapProcessor);
        }

        @Deprecated
        public Builder discCacheFileCount(int i) {
            return diskCacheFileCount(i);
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            return diskCacheFileNameGenerator(fileNameGenerator);
        }

        @Deprecated
        public Builder discCacheSize(int i) {
            return diskCacheSize(i);
        }

        public Builder diskCache(DiskCache diskCache) {
            if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                C1564L.m1065w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            if (this.diskCacheFileNameGenerator != null) {
                C1564L.m1065w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCache = diskCache;
            return this;
        }

        public Builder diskCacheExtraOptions(int i, int i2, BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiskCache = i;
            this.maxImageHeightForDiskCache = i2;
            this.processorForDiskCache = bitmapProcessor;
            return this;
        }

        public Builder diskCacheFileCount(int i) {
            if (i > 0) {
                if (this.diskCache != null) {
                    C1564L.m1065w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheFileCount = i;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.diskCache != null) {
                C1564L.m1065w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder diskCacheSize(int i) {
            if (i > 0) {
                if (this.diskCache != null) {
                    C1564L.m1065w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheSize = i;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memoryCache) {
            if (this.memoryCacheSize != 0) {
                C1564L.m1065w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCache = memoryCache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i, int i2) {
            this.maxImageWidthForMemoryCache = i;
            this.maxImageHeightForMemoryCache = i2;
            return this;
        }

        public Builder memoryCacheSize(int i) {
            if (i > 0) {
                if (this.memoryCache != null) {
                    C1564L.m1065w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = i;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public Builder memoryCacheSizePercentage(int i) {
            if (i > 0 && i < 100) {
                if (this.memoryCache != null) {
                    C1564L.m1065w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = (int) ((i / 100.0f) * ((float) Runtime.getRuntime().maxMemory()));
                return this;
            }
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }

        public Builder taskExecutor(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                C1564L.m1065w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                C1564L.m1065w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                C1564L.m1065w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public Builder threadPoolSize(int i) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                C1564L.m1065w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.threadPoolSize = i;
            return this;
        }

        public Builder threadPriority(int i) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                C1564L.m1065w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            if (i < 1) {
                this.threadPriority = 1;
            } else if (i > 10) {
                this.threadPriority = 10;
            } else {
                this.threadPriority = i;
            }
            return this;
        }

        public Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class NetworkDeniedImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            int ordinal = ImageDownloader.Scheme.ofUri(str).ordinal();
            if (ordinal != 0 && ordinal != 1) {
                return this.wrappedDownloader.getStream(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SlowNetworkImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            InputStream stream = this.wrappedDownloader.getStream(str, obj);
            int ordinal = ImageDownloader.Scheme.ofUri(str).ordinal();
            return (ordinal == 0 || ordinal == 1) ? new FlushedInputStream(stream) : stream;
        }
    }

    public /* synthetic */ ImageLoaderConfiguration(Builder builder, C15551 c15551) {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    public ImageSize getMaxImageSize() {
        DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i = this.maxImageWidthForMemoryCache;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.maxImageHeightForMemoryCache;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new ImageSize(i, i2);
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.diskCache = builder.diskCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        ImageDownloader imageDownloader = builder.downloader;
        this.downloader = imageDownloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(imageDownloader);
        this.slowNetworkDownloader = new SlowNetworkImageDownloader(imageDownloader);
        C1564L.writeDebugLogs(builder.writeLogs);
    }
}
