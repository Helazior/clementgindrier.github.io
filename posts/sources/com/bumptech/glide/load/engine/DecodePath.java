package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final InterfaceC0037B4<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface DecodeCallback<ResourceType> {
        Resource<ResourceType> onResourceDecoded(Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, InterfaceC0037B4<List<Throwable>> interfaceC0037B4) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = interfaceC0037B4;
        StringBuilder m253r = outline.m253r("Failed DecodePath{");
        m253r.append(cls.getSimpleName());
        m253r.append("->");
        m253r.append(cls2.getSimpleName());
        m253r.append("->");
        m253r.append(cls3.getSimpleName());
        m253r.append("}");
        this.failureMessage = m253r.toString();
    }

    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i, int i2, Options options) {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i, i2, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, List<Throwable> list) {
        int size = this.decoders.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.decoders.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Failed to decode data for " + resourceDecoder, e);
                }
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

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, DecodeCallback<ResourceType> decodeCallback) {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i, i2, options)), options);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("DecodePath{ dataClass=");
        m253r.append(this.dataClass);
        m253r.append(", decoders=");
        m253r.append(this.decoders);
        m253r.append(", transcoder=");
        m253r.append(this.transcoder);
        m253r.append('}');
        return m253r.toString();
    }
}
