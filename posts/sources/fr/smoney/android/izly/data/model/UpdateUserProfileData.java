package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class UpdateUserProfileData implements Parcelable {
    public static final Parcelable.Creator<UpdateUserProfileData> CREATOR = new C1774a();

    /* renamed from: a */
    public BalanceData f4663a;

    /* renamed from: b */
    public int f4664b;

    /* renamed from: fr.smoney.android.izly.data.model.UpdateUserProfileData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1774a implements Parcelable.Creator<UpdateUserProfileData> {
        @Override // android.os.Parcelable.Creator
        public UpdateUserProfileData createFromParcel(Parcel parcel) {
            return new UpdateUserProfileData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UpdateUserProfileData[] newArray(int i) {
            return new UpdateUserProfileData[i];
        }
    }

    public UpdateUserProfileData() {
        this.f4663a = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        BalanceData balanceData = this.f4663a;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
        parcel.writeInt(this.f4664b);
    }

    public UpdateUserProfileData(Parcel parcel) {
        this.f4663a = new BalanceData(parcel);
        this.f4664b = parcel.readInt();
    }
}
