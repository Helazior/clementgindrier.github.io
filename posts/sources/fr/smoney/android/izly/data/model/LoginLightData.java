package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LoginLightData implements Parcelable {
    public static final Parcelable.Creator<LoginLightData> CREATOR = new C1725a();

    /* renamed from: a */
    public String f4387a;

    /* renamed from: b */
    public int f4388b;

    /* renamed from: c */
    public String f4389c;

    /* renamed from: d */
    public BalanceData f4390d;

    /* renamed from: fr.smoney.android.izly.data.model.LoginLightData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1725a implements Parcelable.Creator<LoginLightData> {
        @Override // android.os.Parcelable.Creator
        public LoginLightData createFromParcel(Parcel parcel) {
            return new LoginLightData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LoginLightData[] newArray(int i) {
            return new LoginLightData[i];
        }
    }

    public LoginLightData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4387a);
        parcel.writeInt(this.f4388b);
        parcel.writeString(this.f4389c);
        BalanceData balanceData = this.f4390d;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public LoginLightData(Parcel parcel) {
        this.f4387a = parcel.readString();
        this.f4388b = parcel.readInt();
        this.f4389c = parcel.readString();
        this.f4390d = new BalanceData(parcel);
    }
}
