package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BalanceData implements Parcelable {
    public static final Parcelable.Creator<BalanceData> CREATOR = new C1696a();

    /* renamed from: a */
    public double f4230a;

    /* renamed from: b */
    public double f4231b;

    /* renamed from: c */
    public long f4232c;

    /* renamed from: fr.smoney.android.izly.data.model.BalanceData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1696a implements Parcelable.Creator<BalanceData> {
        @Override // android.os.Parcelable.Creator
        public BalanceData createFromParcel(Parcel parcel) {
            return new BalanceData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BalanceData[] newArray(int i) {
            return new BalanceData[i];
        }
    }

    public BalanceData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f4230a);
        parcel.writeDouble(this.f4231b);
        parcel.writeLong(this.f4232c);
    }

    public BalanceData(Parcel parcel) {
        this.f4230a = parcel.readDouble();
        this.f4231b = parcel.readDouble();
        this.f4232c = parcel.readLong();
    }
}
