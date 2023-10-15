package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BlockAccountData implements Parcelable {
    public static final Parcelable.Creator<BlockAccountData> CREATOR = new C1697a();

    /* renamed from: a */
    public BalanceData f4233a;

    /* renamed from: fr.smoney.android.izly.data.model.BlockAccountData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1697a implements Parcelable.Creator<BlockAccountData> {
        @Override // android.os.Parcelable.Creator
        public BlockAccountData createFromParcel(Parcel parcel) {
            return new BlockAccountData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BlockAccountData[] newArray(int i) {
            return new BlockAccountData[i];
        }
    }

    public BlockAccountData() {
        this.f4233a = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        BalanceData balanceData = this.f4233a;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public BlockAccountData(Parcel parcel) {
        this.f4233a = new BalanceData(parcel);
    }
}
