package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(m1098id = 1)
    public Bundle zza;
    @SafeParcelable.Field(m1098id = 2)
    public Feature[] zzb;
    @SafeParcelable.Field(defaultValue = CrashlyticsReportDataCapture.SIGNAL_DEFAULT, m1098id = 3)
    public int zzc;
    @SafeParcelable.Field(m1098id = 4)
    public ConnectionTelemetryConfiguration zzd;

    public zzj() {
    }

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(m1097id = 1) Bundle bundle, @SafeParcelable.Param(m1097id = 2) Feature[] featureArr, @SafeParcelable.Param(m1097id = 3) int i, @SafeParcelable.Param(m1097id = 4) ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.zza = bundle;
        this.zzb = featureArr;
        this.zzc = i;
        this.zzd = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
