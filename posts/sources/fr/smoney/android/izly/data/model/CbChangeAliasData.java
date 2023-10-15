package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CbChangeAliasData implements Parcelable {
    public static final Parcelable.Creator<CbChangeAliasData> CREATOR = new C1699a();

    /* renamed from: a */
    public MoneyInCbCb f4235a;

    /* renamed from: b */
    public BalanceData f4236b;

    /* renamed from: fr.smoney.android.izly.data.model.CbChangeAliasData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1699a implements Parcelable.Creator<CbChangeAliasData> {
        @Override // android.os.Parcelable.Creator
        public CbChangeAliasData createFromParcel(Parcel parcel) {
            return new CbChangeAliasData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public CbChangeAliasData[] newArray(int i) {
            return new CbChangeAliasData[i];
        }
    }

    public CbChangeAliasData() {
        this.f4235a = new MoneyInCbCb();
        this.f4236b = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.f4235a.writeToParcel(parcel, 0);
        BalanceData balanceData = this.f4236b;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public CbChangeAliasData(Parcel parcel, C1699a c1699a) {
        this.f4235a = MoneyInCbCb.CREATOR.createFromParcel(parcel);
        this.f4236b = new BalanceData(parcel);
    }
}
