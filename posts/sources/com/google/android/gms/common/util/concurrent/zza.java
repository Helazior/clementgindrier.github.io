package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zza implements Runnable {
    private final Runnable zza;

    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.zza.run();
    }
}
