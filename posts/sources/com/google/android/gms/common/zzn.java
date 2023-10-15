package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    @SafeParcelable.Field(getter = "getCallingPackage", m1098id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getAllowTestKeys", m1098id = 2)
    private final boolean zzb;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", m1098id = 3)
    private final boolean zzc;
    @SafeParcelable.Field(getter = "getCallingContextBinder", m1098id = 4, type = "android.os.IBinder")
    private final Context zzd;
    @SafeParcelable.Field(getter = "getIsChimeraPackage", m1098id = 5)
    private final boolean zze;

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(m1097id = 1) String str, @SafeParcelable.Param(m1097id = 2) boolean z, @SafeParcelable.Param(m1097id = 3) boolean z2, @SafeParcelable.Param(m1097id = 4) IBinder iBinder, @SafeParcelable.Param(m1097id = 5) boolean z3) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z3;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzd), false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
