package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SetConfidentialitySettingsData implements Parcelable {
    public static final Parcelable.Creator<SetConfidentialitySettingsData> CREATOR = new C1766a();

    /* renamed from: a */
    public BalanceData f4608a;

    /* renamed from: fr.smoney.android.izly.data.model.SetConfidentialitySettingsData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1766a implements Parcelable.Creator<SetConfidentialitySettingsData> {
        @Override // android.os.Parcelable.Creator
        public SetConfidentialitySettingsData createFromParcel(Parcel parcel) {
            return new SetConfidentialitySettingsData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SetConfidentialitySettingsData[] newArray(int i) {
            return new SetConfidentialitySettingsData[i];
        }
    }

    public SetConfidentialitySettingsData() {
        this.f4608a = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        BalanceData balanceData = this.f4608a;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public SetConfidentialitySettingsData(Parcel parcel) {
        this.f4608a = new BalanceData(parcel);
    }
}
