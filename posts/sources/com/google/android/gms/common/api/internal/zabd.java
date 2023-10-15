package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zabd extends zabw {
    private final WeakReference<zabe> zaa;

    public zabd(zabe zabeVar) {
        this.zaa = new WeakReference<>(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = this.zaa.get();
        if (zabeVar == null) {
            return;
        }
        zabe.zai(zabeVar);
    }
}
