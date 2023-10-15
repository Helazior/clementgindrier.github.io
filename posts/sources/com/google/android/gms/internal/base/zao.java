package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zao implements zam {
    private zao() {
    }

    public /* synthetic */ zao(zan zanVar) {
    }

    @Override // com.google.android.gms.internal.base.zam
    public final ExecutorService zaa(ThreadFactory threadFactory, int i) {
        return zac(1, threadFactory, 1);
    }

    @Override // com.google.android.gms.internal.base.zam
    public final ExecutorService zab(int i, int i2) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.base.zam
    public final ExecutorService zac(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
