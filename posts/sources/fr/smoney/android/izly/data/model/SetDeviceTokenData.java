package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SetDeviceTokenData implements Parcelable {
    public static final Parcelable.Creator<SetDeviceTokenData> CREATOR = new C1767a();

    /* renamed from: a */
    public String f4609a;

    /* renamed from: b */
    public BalanceData f4610b;

    /* renamed from: fr.smoney.android.izly.data.model.SetDeviceTokenData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1767a implements Parcelable.Creator<SetDeviceTokenData> {
        @Override // android.os.Parcelable.Creator
        public SetDeviceTokenData createFromParcel(Parcel parcel) {
            return new SetDeviceTokenData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SetDeviceTokenData[] newArray(int i) {
            return new SetDeviceTokenData[i];
        }
    }

    public SetDeviceTokenData() {
        this.f4610b = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4609a);
        BalanceData balanceData = this.f4610b;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public SetDeviceTokenData(Parcel parcel) {
        this.f4609a = parcel.readString();
        this.f4610b = new BalanceData(parcel);
    }
}
