package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zai extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void zae(TelemetryData telemetryData) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zac(zaa, telemetryData);
        zad(1, zaa);
    }
}
