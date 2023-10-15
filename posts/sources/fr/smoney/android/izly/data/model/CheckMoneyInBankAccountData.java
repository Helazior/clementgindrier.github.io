package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CheckMoneyInBankAccountData implements Parcelable {
    public static final Parcelable.Creator<CheckMoneyInBankAccountData> CREATOR = new C1702a();

    /* renamed from: a */
    public String f4241a;

    /* renamed from: b */
    public double f4242b;

    /* renamed from: fr.smoney.android.izly.data.model.CheckMoneyInBankAccountData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1702a implements Parcelable.Creator<CheckMoneyInBankAccountData> {
        @Override // android.os.Parcelable.Creator
        public CheckMoneyInBankAccountData createFromParcel(Parcel parcel) {
            return new CheckMoneyInBankAccountData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CheckMoneyInBankAccountData[] newArray(int i) {
            return new CheckMoneyInBankAccountData[i];
        }
    }

    public CheckMoneyInBankAccountData(String str, double d) {
        this.f4241a = str;
        this.f4242b = d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4241a);
        parcel.writeDouble(this.f4242b);
    }

    public CheckMoneyInBankAccountData() {
    }

    public CheckMoneyInBankAccountData(Parcel parcel) {
        this.f4241a = parcel.readString();
        this.f4242b = parcel.readDouble();
    }
}
