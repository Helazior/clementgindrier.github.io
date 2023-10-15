package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class zaav implements Runnable {
    public final /* synthetic */ zaaw zab;

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        zabi zabiVar;
        Lock lock3;
        lock = this.zab.zab;
        lock.lock();
        try {
            try {
                if (Thread.interrupted()) {
                    lock3 = this.zab.zab;
                } else {
                    zaa();
                    lock3 = this.zab.zab;
                }
            } catch (RuntimeException e) {
                zabiVar = this.zab.zaa;
                zabiVar.zam(e);
                lock3 = this.zab.zab;
            }
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = this.zab.zab;
            lock2.unlock();
            throw th;
        }
    }

    public abstract void zaa();
}
