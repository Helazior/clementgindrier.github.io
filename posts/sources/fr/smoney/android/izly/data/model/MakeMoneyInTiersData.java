package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MakeMoneyInTiersData implements Parcelable {
    public static final Parcelable.Creator<MakeMoneyInTiersData> CREATOR = new C1728a();

    /* renamed from: a */
    public String f4404a;

    /* renamed from: b */
    public double f4405b;

    /* renamed from: c */
    public String f4406c;

    /* renamed from: d */
    public String f4407d;

    /* renamed from: fr.smoney.android.izly.data.model.MakeMoneyInTiersData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1728a implements Parcelable.Creator<MakeMoneyInTiersData> {
        @Override // android.os.Parcelable.Creator
        public MakeMoneyInTiersData createFromParcel(Parcel parcel) {
            return new MakeMoneyInTiersData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MakeMoneyInTiersData[] newArray(int i) {
            return new MakeMoneyInTiersData[i];
        }
    }

    public MakeMoneyInTiersData(String str, double d, String str2, String str3) {
        this.f4404a = null;
        this.f4405b = d;
        this.f4407d = str2;
        this.f4406c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4404a);
        parcel.writeDouble(this.f4405b);
        parcel.writeString(this.f4406c);
        parcel.writeString(this.f4407d);
    }

    public MakeMoneyInTiersData() {
    }

    public MakeMoneyInTiersData(Parcel parcel) {
        this.f4404a = parcel.readString();
        this.f4405b = parcel.readDouble();
        this.f4406c = parcel.readString();
        this.f4407d = parcel.readString();
    }
}
