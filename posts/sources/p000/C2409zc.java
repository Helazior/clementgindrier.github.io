package p000;

import android.content.Context;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: zc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2408zc {

    /* renamed from: a */
    public ImageLoader f6934a;

    public C2408zc(Context context) {
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(context).memoryCache(new LruMemoryCache(PKIFailureInfo.badSenderNonce)).defaultDisplayImageOptions(new DisplayImageOptions.Builder().cacheInMemory(true).build()).build();
        new DisplayImageOptions.Builder().cacheInMemory(true).displayer(new C0140Fd((int) context.getResources().getDimension(2131165583))).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        this.f6934a = imageLoader;
        imageLoader.init(build);
    }
}
