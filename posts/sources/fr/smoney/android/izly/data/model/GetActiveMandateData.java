package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetActiveMandateData implements Parcelable {
    public static final Parcelable.Creator<GetActiveMandateData> CREATOR = new C1712a();

    /* renamed from: a */
    public BalanceData f4274a;

    /* renamed from: b */
    public double f4275b;

    /* renamed from: c */
    public double f4276c;

    /* renamed from: d */
    public int[] f4277d;

    /* renamed from: f */
    public Mandate f4278f;

    /* renamed from: fr.smoney.android.izly.data.model.GetActiveMandateData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1712a implements Parcelable.Creator<GetActiveMandateData> {
        @Override // android.os.Parcelable.Creator
        public GetActiveMandateData createFromParcel(Parcel parcel) {
            return new GetActiveMandateData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetActiveMandateData[] newArray(int i) {
            return new GetActiveMandateData[i];
        }
    }

    public GetActiveMandateData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        BalanceData balanceData = this.f4274a;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
        parcel.writeDouble(this.f4275b);
        parcel.writeDouble(this.f4276c);
        int[] iArr = this.f4277d;
        parcel.writeInt(iArr == null ? -1 : iArr.length);
        parcel.writeIntArray(this.f4277d);
        parcel.writeParcelable(this.f4278f, 0);
    }

    public GetActiveMandateData(Parcel parcel) {
        this.f4274a = new BalanceData(parcel);
        this.f4275b = parcel.readDouble();
        this.f4276c = parcel.readDouble();
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            int[] iArr = new int[readInt];
            this.f4277d = iArr;
            parcel.readIntArray(iArr);
        }
        this.f4278f = (Mandate) parcel.readParcelable(GetActiveMandateData.class.getClassLoader());
    }
}
