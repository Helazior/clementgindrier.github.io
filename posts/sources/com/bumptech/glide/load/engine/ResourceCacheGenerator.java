package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;

    /* renamed from: cb */
    private final DataFetcherGenerator.FetcherReadyCallback f3838cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private Key sourceKey;

    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f3838cb = fetcherReadyCallback;
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.f3838cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception exc) {
        this.f3838cb.onDataFetcherFailed(this.currentKey, exc, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        List<Key> cacheKeys = this.helper.getCacheKeys();
        boolean z = false;
        if (cacheKeys.isEmpty()) {
            return false;
        }
        List<Class<?>> registeredResourceClasses = this.helper.getRegisteredResourceClasses();
        if (registeredResourceClasses.isEmpty()) {
            if (File.class.equals(this.helper.getTranscodeClass())) {
                return false;
            }
            StringBuilder m253r = outline.m253r("Failed to find any load path from ");
            m253r.append(this.helper.getModelClass());
            m253r.append(" to ");
            m253r.append(this.helper.getTranscodeClass());
            throw new IllegalStateException(m253r.toString());
        }
        while (true) {
            if (this.modelLoaders != null && hasNextModelLoader()) {
                this.loadData = null;
                while (!z && hasNextModelLoader()) {
                    List<ModelLoader<File, ?>> list = this.modelLoaders;
                    int i = this.modelLoaderIndex;
                    this.modelLoaderIndex = i + 1;
                    this.loadData = list.get(i).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.resourceClassIndex + 1;
            this.resourceClassIndex = i2;
            if (i2 >= registeredResourceClasses.size()) {
                int i3 = this.sourceIdIndex + 1;
                this.sourceIdIndex = i3;
                if (i3 >= cacheKeys.size()) {
                    return false;
                }
                this.resourceClassIndex = 0;
            }
            Key key = cacheKeys.get(this.sourceIdIndex);
            Class<?> cls = registeredResourceClasses.get(this.resourceClassIndex);
            this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), key, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(cls), cls, this.helper.getOptions());
            File file = this.helper.getDiskCache().get(this.currentKey);
            this.cacheFile = file;
            if (file != null) {
                this.sourceKey = key;
                this.modelLoaders = this.helper.getModelLoaders(file);
                this.modelLoaderIndex = 0;
            }
        }
    }
}
