package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyInCbData implements Parcelable {
    public static final Parcelable.Creator<MoneyInCbData> CREATOR = new C1734a();

    /* renamed from: a */
    public MoneyInCb f4434a;

    /* renamed from: b */
    public CbUser f4435b;

    /* renamed from: c */
    public BalanceData f4436c;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyInCbData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1734a implements Parcelable.Creator<MoneyInCbData> {
        @Override // android.os.Parcelable.Creator
        public MoneyInCbData createFromParcel(Parcel parcel) {
            return new MoneyInCbData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyInCbData[] newArray(int i) {
            return new MoneyInCbData[i];
        }
    }

    public MoneyInCbData() {
        this.f4434a = new MoneyInCb();
        this.f4435b = new CbUser();
        this.f4436c = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.f4434a.writeToParcel(parcel, i);
        CbUser cbUser = this.f4435b;
        parcel.writeString(cbUser.f4239a);
        parcel.writeString(cbUser.f4240b);
        BalanceData balanceData = this.f4436c;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public MoneyInCbData(Parcel parcel, C1734a c1734a) {
        this.f4434a = new MoneyInCb(parcel);
        this.f4435b = new CbUser(parcel);
        this.f4436c = new BalanceData(parcel);
    }
}
