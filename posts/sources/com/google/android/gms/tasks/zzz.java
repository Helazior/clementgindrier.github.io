package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzz implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ Callable zzb;

    public zzz(zzw zzwVar, Callable callable) {
        this.zza = zzwVar;
        this.zzb = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.zzb(this.zzb.call());
        } catch (Exception e) {
            this.zza.zza(e);
        } catch (Throwable th) {
            this.zza.zza(new RuntimeException(th));
        }
    }
}
