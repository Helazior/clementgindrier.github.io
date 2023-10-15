package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzn extends zzq<Void> {
    public zzn(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzq
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zza((zzn) null);
        } else {
            zza(new zzp(4, "Invalid response to one way request"));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzq
    public final boolean zza() {
        return true;
    }
}
