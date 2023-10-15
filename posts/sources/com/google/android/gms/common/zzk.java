package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class zzk extends zzi {
    private static final WeakReference<byte[]> zza = new WeakReference<>(null);
    private WeakReference<byte[]> zzb;

    public zzk(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzi
    public final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
