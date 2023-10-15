package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IsSessionValidData implements Parcelable {
    public static final Parcelable.Creator<IsSessionValidData> CREATOR = new C1723a();

    /* renamed from: a */
    public boolean f4346a;

    /* renamed from: b */
    public BalanceData f4347b;

    /* renamed from: fr.smoney.android.izly.data.model.IsSessionValidData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1723a implements Parcelable.Creator<IsSessionValidData> {
        @Override // android.os.Parcelable.Creator
        public IsSessionValidData createFromParcel(Parcel parcel) {
            return new IsSessionValidData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IsSessionValidData[] newArray(int i) {
            return new IsSessionValidData[i];
        }
    }

    public IsSessionValidData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4346a ? 1 : 0);
        BalanceData balanceData = this.f4347b;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public IsSessionValidData(Parcel parcel) {
        this.f4346a = parcel.readInt() == 1;
        this.f4347b = new BalanceData(parcel);
    }
}
