package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyOutTransferAccountData implements Parcelable {
    public static final Parcelable.Creator<MoneyOutTransferAccountData> CREATOR = new C1735a();

    /* renamed from: a */
    public String f4437a;

    /* renamed from: b */
    public String f4438b;

    /* renamed from: c */
    public String f4439c;

    /* renamed from: d */
    public float[] f4440d;

    /* renamed from: f */
    public BalanceData f4441f;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyOutTransferAccountData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1735a implements Parcelable.Creator<MoneyOutTransferAccountData> {
        @Override // android.os.Parcelable.Creator
        public MoneyOutTransferAccountData createFromParcel(Parcel parcel) {
            return new MoneyOutTransferAccountData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyOutTransferAccountData[] newArray(int i) {
            return new MoneyOutTransferAccountData[i];
        }
    }

    public MoneyOutTransferAccountData() {
        this.f4441f = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4437a);
        parcel.writeString(this.f4438b);
        parcel.writeString(this.f4439c);
        float[] fArr = this.f4440d;
        parcel.writeInt(fArr == null ? -1 : fArr.length);
        parcel.writeFloatArray(this.f4440d);
        BalanceData balanceData = this.f4441f;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public MoneyOutTransferAccountData(Parcel parcel, C1735a c1735a) {
        this.f4437a = parcel.readString();
        this.f4438b = parcel.readString();
        this.f4439c = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            float[] fArr = new float[readInt];
            this.f4440d = fArr;
            parcel.readFloatArray(fArr);
        }
        this.f4441f = new BalanceData(parcel);
    }
}
