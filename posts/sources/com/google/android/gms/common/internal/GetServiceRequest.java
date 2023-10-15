package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();
    @SafeParcelable.VersionField(m1096id = 1)
    public final int zza;
    @SafeParcelable.Field(m1098id = 2)
    public final int zzb;
    @SafeParcelable.Field(m1098id = 3)
    public int zzc;
    @SafeParcelable.Field(m1098id = 4)
    public String zzd;
    @SafeParcelable.Field(m1098id = 5)
    public IBinder zze;
    @SafeParcelable.Field(m1098id = 6)
    public Scope[] zzf;
    @SafeParcelable.Field(m1098id = 7)
    public Bundle zzg;
    @SafeParcelable.Field(m1098id = 8)
    public Account zzh;
    @SafeParcelable.Field(m1098id = 10)
    public Feature[] zzi;
    @SafeParcelable.Field(m1098id = 11)
    public Feature[] zzj;
    @SafeParcelable.Field(m1098id = 12)
    public boolean zzk;
    @SafeParcelable.Field(defaultValue = CrashlyticsReportDataCapture.SIGNAL_DEFAULT, m1098id = 13)
    public int zzl;
    @SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", m1098id = 14)
    public boolean zzm;
    @SafeParcelable.Field(getter = "getAttributionTag", m1098id = 15)
    private String zzn;

    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param(m1097id = 1) int i, @SafeParcelable.Param(m1097id = 2) int i2, @SafeParcelable.Param(m1097id = 3) int i3, @SafeParcelable.Param(m1097id = 4) String str, @SafeParcelable.Param(m1097id = 5) IBinder iBinder, @SafeParcelable.Param(m1097id = 6) Scope[] scopeArr, @SafeParcelable.Param(m1097id = 7) Bundle bundle, @SafeParcelable.Param(m1097id = 8) Account account, @SafeParcelable.Param(m1097id = 10) Feature[] featureArr, @SafeParcelable.Param(m1097id = 11) Feature[] featureArr2, @SafeParcelable.Param(m1097id = 12) boolean z, @SafeParcelable.Param(m1097id = 13) int i4, @SafeParcelable.Param(m1097id = 14) boolean z2, @SafeParcelable.Param(m1097id = 15) String str2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzd = "com.google.android.gms";
        } else {
            this.zzd = str;
        }
        if (i < 2) {
            this.zzh = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zze = iBinder;
            this.zzh = account;
        }
        this.zzf = scopeArr;
        this.zzg = bundle;
        this.zzi = featureArr;
        this.zzj = featureArr2;
        this.zzk = z;
        this.zzl = i4;
        this.zzm = z2;
        this.zzn = str2;
    }

    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.zzg;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public final String zza() {
        return this.zzn;
    }

    public GetServiceRequest(int i, String str) {
        this.zza = 6;
        this.zzc = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzb = i;
        this.zzk = true;
        this.zzn = str;
    }
}
