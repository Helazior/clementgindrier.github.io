package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyInCbCbListData implements Parcelable {
    public static final Parcelable.Creator<MoneyInCbCbListData> CREATOR = new C1732a();

    /* renamed from: a */
    public ArrayList<MoneyInCbCb> f4423a;

    /* renamed from: b */
    public int[] f4424b;

    /* renamed from: c */
    public BalanceData f4425c;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyInCbCbListData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1732a implements Parcelable.Creator<MoneyInCbCbListData> {
        @Override // android.os.Parcelable.Creator
        public MoneyInCbCbListData createFromParcel(Parcel parcel) {
            return new MoneyInCbCbListData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyInCbCbListData[] newArray(int i) {
            return new MoneyInCbCbListData[i];
        }
    }

    public MoneyInCbCbListData() {
        this.f4423a = new ArrayList<>();
        this.f4425c = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4423a);
        int[] iArr = this.f4424b;
        parcel.writeInt(iArr == null ? -1 : iArr.length);
        parcel.writeIntArray(this.f4424b);
        BalanceData balanceData = this.f4425c;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public MoneyInCbCbListData(Parcel parcel, C1732a c1732a) {
        ArrayList<MoneyInCbCb> arrayList = new ArrayList<>();
        this.f4423a = arrayList;
        parcel.readTypedList(arrayList, MoneyInCbCb.CREATOR);
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            int[] iArr = new int[readInt];
            this.f4424b = iArr;
            parcel.readIntArray(iArr);
        }
        this.f4425c = new BalanceData(parcel);
    }
}
