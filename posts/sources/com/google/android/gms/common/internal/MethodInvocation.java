package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;

@KeepForSdk
@SafeParcelable.Class(creator = "MethodInvocationCreator")
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();
    @SafeParcelable.Field(getter = "getMethodKey", m1098id = 1)
    private final int zaa;
    @SafeParcelable.Field(getter = "getResultStatusCode", m1098id = 2)
    private final int zab;
    @SafeParcelable.Field(getter = "getConnectionResultStatusCode", m1098id = 3)
    private final int zac;
    @SafeParcelable.Field(getter = "getStartTimeMillis", m1098id = 4)
    private final long zad;
    @SafeParcelable.Field(getter = "getEndTimeMillis", m1098id = 5)
    private final long zae;
    @SafeParcelable.Field(getter = "getCallingModuleId", m1098id = 6)
    private final String zaf;
    @SafeParcelable.Field(getter = "getCallingEntryPoint", m1098id = 7)
    private final String zag;
    @SafeParcelable.Field(defaultValue = CrashlyticsReportDataCapture.SIGNAL_DEFAULT, getter = "getServiceId", m1098id = 8)
    private final int zah;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLatencyMillis", m1098id = 9)
    private final int zai;

    @KeepForSdk
    @Deprecated
    public MethodInvocation(int i, int i2, int i3, long j, long j2, String str, String str2, int i4) {
        this(i, i2, i3, j, j2, str, str2, i4, -1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeLong(parcel, 4, this.zad);
        SafeParcelWriter.writeLong(parcel, 5, this.zae);
        SafeParcelWriter.writeString(parcel, 6, this.zaf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zag, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zah);
        SafeParcelWriter.writeInt(parcel, 9, this.zai);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param(m1097id = 1) int i, @SafeParcelable.Param(m1097id = 2) int i2, @SafeParcelable.Param(m1097id = 3) int i3, @SafeParcelable.Param(m1097id = 4) long j, @SafeParcelable.Param(m1097id = 5) long j2, @SafeParcelable.Param(m1097id = 6) String str, @SafeParcelable.Param(m1097id = 7) String str2, @SafeParcelable.Param(m1097id = 8) int i4, @SafeParcelable.Param(m1097id = 9) int i5) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i3;
        this.zad = j;
        this.zae = j2;
        this.zaf = str;
        this.zag = str2;
        this.zah = i4;
        this.zai = i5;
    }
}
