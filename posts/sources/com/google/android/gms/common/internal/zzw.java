package com.google.android.gms.common.internal;

import android.os.IBinder;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzw extends com.google.android.gms.internal.common.zza implements ICancelToken {
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    @Override // com.google.android.gms.common.internal.ICancelToken
    public final void cancel() {
        zzD(2, zza());
    }
}
