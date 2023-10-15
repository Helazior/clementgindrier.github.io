package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MakeMoneyInBankAccountData implements Parcelable {
    public static final Parcelable.Creator<MakeMoneyInBankAccountData> CREATOR = new C1727a();

    /* renamed from: a */
    public String f4402a;

    /* renamed from: b */
    public double f4403b;

    /* renamed from: fr.smoney.android.izly.data.model.MakeMoneyInBankAccountData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1727a implements Parcelable.Creator<MakeMoneyInBankAccountData> {
        @Override // android.os.Parcelable.Creator
        public MakeMoneyInBankAccountData createFromParcel(Parcel parcel) {
            return new MakeMoneyInBankAccountData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MakeMoneyInBankAccountData[] newArray(int i) {
            return new MakeMoneyInBankAccountData[i];
        }
    }

    public MakeMoneyInBankAccountData(String str, double d) {
        this.f4402a = str;
        this.f4403b = d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4402a);
        parcel.writeDouble(this.f4403b);
    }

    public MakeMoneyInBankAccountData() {
    }

    public MakeMoneyInBankAccountData(Parcel parcel) {
        this.f4402a = parcel.readString();
        this.f4403b = parcel.readDouble();
    }
}
