package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetMyCbListData implements Parcelable {
    public static final Parcelable.Creator<GetMyCbListData> CREATOR = new C1717a();

    /* renamed from: a */
    public ArrayList<MoneyInCbCb> f4333a;

    /* renamed from: b */
    public BalanceData f4334b;

    /* renamed from: fr.smoney.android.izly.data.model.GetMyCbListData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1717a implements Parcelable.Creator<GetMyCbListData> {
        @Override // android.os.Parcelable.Creator
        public GetMyCbListData createFromParcel(Parcel parcel) {
            return new GetMyCbListData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetMyCbListData[] newArray(int i) {
            return new GetMyCbListData[i];
        }
    }

    public GetMyCbListData() {
        this.f4334b = new BalanceData();
        this.f4333a = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4333a);
        BalanceData balanceData = this.f4334b;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public GetMyCbListData(Parcel parcel) {
        ArrayList<MoneyInCbCb> arrayList = new ArrayList<>();
        this.f4333a = arrayList;
        parcel.readTypedList(arrayList, MoneyInCbCb.CREATOR);
        this.f4334b = new BalanceData(parcel);
    }
}
