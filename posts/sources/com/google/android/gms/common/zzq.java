package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getResult", m1098id = 1)
    private final boolean zza;
    @Nullable
    @SafeParcelable.Field(getter = "getErrorMessage", m1098id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getStatusValue", m1098id = 3)
    private final int zzc;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(m1097id = 1) boolean z, @SafeParcelable.Param(m1097id = 2) String str, @SafeParcelable.Param(m1097id = 3) int i) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzp.zza(i) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public final int zzc() {
        return zzp.zza(this.zzc);
    }
}
