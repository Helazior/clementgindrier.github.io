package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RemoveDeviceTokenData implements Parcelable {
    public static final Parcelable.Creator<RemoveDeviceTokenData> CREATOR = new C1762a();

    /* renamed from: a */
    public BalanceData f4596a;

    /* renamed from: fr.smoney.android.izly.data.model.RemoveDeviceTokenData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1762a implements Parcelable.Creator<RemoveDeviceTokenData> {
        @Override // android.os.Parcelable.Creator
        public RemoveDeviceTokenData createFromParcel(Parcel parcel) {
            return new RemoveDeviceTokenData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RemoveDeviceTokenData[] newArray(int i) {
            return new RemoveDeviceTokenData[i];
        }
    }

    public RemoveDeviceTokenData() {
        this.f4596a = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        BalanceData balanceData = this.f4596a;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public RemoveDeviceTokenData(Parcel parcel) {
        this.f4596a = new BalanceData(parcel);
    }
}
