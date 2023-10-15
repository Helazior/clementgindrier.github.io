package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CbDeleteData implements Parcelable {
    public static final Parcelable.Creator<CbDeleteData> CREATOR = new C1700a();

    /* renamed from: a */
    public String f4237a;

    /* renamed from: b */
    public BalanceData f4238b;

    /* renamed from: fr.smoney.android.izly.data.model.CbDeleteData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1700a implements Parcelable.Creator<CbDeleteData> {
        @Override // android.os.Parcelable.Creator
        public CbDeleteData createFromParcel(Parcel parcel) {
            return new CbDeleteData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public CbDeleteData[] newArray(int i) {
            return new CbDeleteData[i];
        }
    }

    public CbDeleteData() {
        this.f4238b = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4237a);
        BalanceData balanceData = this.f4238b;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public CbDeleteData(Parcel parcel, C1700a c1700a) {
        this.f4237a = parcel.readString();
        this.f4238b = new BalanceData(parcel);
    }
}
