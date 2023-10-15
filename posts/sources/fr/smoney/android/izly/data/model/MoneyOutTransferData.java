package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyOutTransferData implements Parcelable {
    public static final Parcelable.Creator<MoneyOutTransferData> CREATOR = new C1737a();

    /* renamed from: a */
    public long f4452a;

    /* renamed from: b */
    public String f4453b;

    /* renamed from: c */
    public String f4454c;

    /* renamed from: d */
    public double f4455d;

    /* renamed from: f */
    public double f4456f;

    /* renamed from: g */
    public double f4457g;

    /* renamed from: h */
    public double f4458h;

    /* renamed from: i */
    public BalanceData f4459i;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyOutTransferData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1737a implements Parcelable.Creator<MoneyOutTransferData> {
        @Override // android.os.Parcelable.Creator
        public MoneyOutTransferData createFromParcel(Parcel parcel) {
            return new MoneyOutTransferData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyOutTransferData[] newArray(int i) {
            return new MoneyOutTransferData[i];
        }
    }

    public MoneyOutTransferData() {
        this.f4459i = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4452a);
        parcel.writeString(this.f4453b);
        parcel.writeString(this.f4454c);
        parcel.writeDouble(this.f4455d);
        parcel.writeDouble(this.f4456f);
        parcel.writeDouble(this.f4457g);
        parcel.writeDouble(this.f4458h);
        BalanceData balanceData = this.f4459i;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public MoneyOutTransferData(Parcel parcel, C1737a c1737a) {
        this.f4452a = parcel.readLong();
        this.f4453b = parcel.readString();
        this.f4454c = parcel.readString();
        this.f4455d = parcel.readDouble();
        this.f4456f = parcel.readDouble();
        this.f4457g = parcel.readDouble();
        this.f4458h = parcel.readDouble();
        this.f4459i = new BalanceData(parcel);
    }
}
