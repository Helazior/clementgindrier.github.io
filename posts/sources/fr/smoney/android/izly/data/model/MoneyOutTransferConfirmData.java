package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyOutTransferConfirmData implements Parcelable {
    public static final Parcelable.Creator<MoneyOutTransferConfirmData> CREATOR = new C1736a();

    /* renamed from: a */
    public long f4442a;

    /* renamed from: b */
    public long f4443b;

    /* renamed from: c */
    public String f4444c;

    /* renamed from: d */
    public String f4445d;

    /* renamed from: f */
    public double f4446f;

    /* renamed from: g */
    public double f4447g;

    /* renamed from: h */
    public double f4448h;

    /* renamed from: i */
    public double f4449i;

    /* renamed from: j */
    public BalanceData f4450j;

    /* renamed from: k */
    public String f4451k;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyOutTransferConfirmData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1736a implements Parcelable.Creator<MoneyOutTransferConfirmData> {
        @Override // android.os.Parcelable.Creator
        public MoneyOutTransferConfirmData createFromParcel(Parcel parcel) {
            return new MoneyOutTransferConfirmData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyOutTransferConfirmData[] newArray(int i) {
            return new MoneyOutTransferConfirmData[i];
        }
    }

    public MoneyOutTransferConfirmData() {
        this.f4450j = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4442a);
        parcel.writeLong(this.f4443b);
        parcel.writeString(this.f4444c);
        parcel.writeString(this.f4445d);
        parcel.writeDouble(this.f4446f);
        parcel.writeDouble(this.f4447g);
        parcel.writeDouble(this.f4448h);
        parcel.writeDouble(this.f4449i);
        BalanceData balanceData = this.f4450j;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
        parcel.writeString(this.f4451k);
    }

    public MoneyOutTransferConfirmData(Parcel parcel, C1736a c1736a) {
        this.f4442a = parcel.readLong();
        this.f4443b = parcel.readLong();
        this.f4444c = parcel.readString();
        this.f4445d = parcel.readString();
        this.f4446f = parcel.readDouble();
        this.f4447g = parcel.readDouble();
        this.f4448h = parcel.readDouble();
        this.f4449i = parcel.readDouble();
        this.f4450j = new BalanceData(parcel);
        this.f4451k = parcel.readString();
    }
}
