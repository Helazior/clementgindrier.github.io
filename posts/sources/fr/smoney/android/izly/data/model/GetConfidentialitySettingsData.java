package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetConfidentialitySettingsData implements Parcelable {
    public static final Parcelable.Creator<GetConfidentialitySettingsData> CREATOR = new C1714a();

    /* renamed from: a */
    public int f4288a;

    /* renamed from: b */
    public int f4289b;

    /* renamed from: c */
    public int f4290c;

    /* renamed from: d */
    public int f4291d;

    /* renamed from: f */
    public int f4292f;

    /* renamed from: g */
    public int f4293g;

    /* renamed from: h */
    public BalanceData f4294h;

    /* renamed from: fr.smoney.android.izly.data.model.GetConfidentialitySettingsData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1714a implements Parcelable.Creator<GetConfidentialitySettingsData> {
        @Override // android.os.Parcelable.Creator
        public GetConfidentialitySettingsData createFromParcel(Parcel parcel) {
            return new GetConfidentialitySettingsData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetConfidentialitySettingsData[] newArray(int i) {
            return new GetConfidentialitySettingsData[i];
        }
    }

    public GetConfidentialitySettingsData() {
        this.f4294h = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4288a);
        parcel.writeInt(this.f4289b);
        parcel.writeInt(this.f4290c);
        parcel.writeInt(this.f4291d);
        parcel.writeInt(this.f4292f);
        parcel.writeInt(this.f4293g);
        BalanceData balanceData = this.f4294h;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public GetConfidentialitySettingsData(Parcel parcel) {
        this.f4288a = parcel.readInt();
        this.f4289b = parcel.readInt();
        this.f4290c = parcel.readInt();
        this.f4291d = parcel.readInt();
        this.f4292f = parcel.readInt();
        this.f4293g = parcel.readInt();
        this.f4294h = new BalanceData(parcel);
    }
}
