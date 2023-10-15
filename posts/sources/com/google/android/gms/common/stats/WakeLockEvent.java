package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(m1096id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getTimeMillis", m1098id = 2)
    private final long zzb;
    @SafeParcelable.Field(getter = "getEventType", m1098id = 11)
    private int zzc;
    @SafeParcelable.Field(getter = "getWakeLockName", m1098id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", m1098id = 10)
    private final String zze;
    @SafeParcelable.Field(getter = "getCodePackage", m1098id = 17)
    private final String zzf;
    @SafeParcelable.Field(getter = "getWakeLockType", m1098id = 5)
    private final int zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackages", m1098id = 6)
    private final List<String> zzh;
    @SafeParcelable.Field(getter = "getEventKey", m1098id = 12)
    private final String zzi;
    @SafeParcelable.Field(getter = "getElapsedRealtime", m1098id = 8)
    private final long zzj;
    @SafeParcelable.Field(getter = "getDeviceState", m1098id = 14)
    private int zzk;
    @SafeParcelable.Field(getter = "getHostPackage", m1098id = 13)
    private final String zzl;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", m1098id = 15)
    private final float zzm;
    @SafeParcelable.Field(getter = "getTimeout", m1098id = 16)
    private final long zzn;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", m1098id = 18)
    private final boolean zzo;
    private long zzp = -1;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(m1097id = 1) int i, @SafeParcelable.Param(m1097id = 2) long j, @SafeParcelable.Param(m1097id = 11) int i2, @SafeParcelable.Param(m1097id = 4) String str, @SafeParcelable.Param(m1097id = 5) int i3, @SafeParcelable.Param(m1097id = 6) @Nullable List<String> list, @SafeParcelable.Param(m1097id = 12) String str2, @SafeParcelable.Param(m1097id = 8) long j2, @SafeParcelable.Param(m1097id = 14) int i4, @SafeParcelable.Param(m1097id = 10) String str3, @SafeParcelable.Param(m1097id = 13) String str4, @SafeParcelable.Param(m1097id = 15) float f, @SafeParcelable.Param(m1097id = 16) long j3, @SafeParcelable.Param(m1097id = 17) String str5, @SafeParcelable.Param(m1097id = 18) boolean z) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i3;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i4;
        this.zzl = str4;
        this.zzm = f;
        this.zzn = j3;
        this.zzo = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzd() {
        List<String> list = this.zzh;
        String str = this.zzd;
        int i = this.zzg;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.zzk;
        String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.zzm;
        String str4 = this.zzf;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.zzo;
        StringBuilder sb = new StringBuilder(str5.length() + str3.length() + str2.length() + String.valueOf(str).length() + 51 + String.valueOf(join).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
