package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zac extends zaf {
    public zac(zae zaeVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(zah zahVar) {
        ((zal) zahVar.getService()).zae(new zad(this));
    }
}
