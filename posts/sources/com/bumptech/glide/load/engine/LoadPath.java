package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final InterfaceC0037B4<List<Throwable>> listPool;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, InterfaceC0037B4<List<Throwable>> interfaceC0037B4) {
        this.dataClass = cls;
        this.listPool = interfaceC0037B4;
        this.decodePaths = (List) Preconditions.checkNotEmpty(list);
        StringBuilder m253r = outline.m253r("Failed LoadPath{");
        m253r.append(cls.getSimpleName());
        m253r.append("->");
        m253r.append(cls2.getSimpleName());
        m253r.append("->");
        m253r.append(cls3.getSimpleName());
        m253r.append("}");
        this.failureMessage = m253r.toString();
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) {
        int size = this.decodePaths.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = this.decodePaths.get(i3).decode(dataRewinder, i, i2, options, decodeCallback);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, new ArrayList(list));
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback<ResourceType> decodeCallback) {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return loadWithExceptionList(dataRewinder, options, i, i2, decodeCallback, list);
        } finally {
            this.listPool.release(list);
        }
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("LoadPath{decodePaths=");
        m253r.append(Arrays.toString(this.decodePaths.toArray()));
        m253r.append('}');
        return m253r.toString();
    }
}
