package com.google.android.gms.internal.firebase_messaging;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzl extends zzi {
    private final zzk zza = new zzk();

    @Override // com.google.android.gms.internal.firebase_messaging.zzi
    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
