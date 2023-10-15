package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TransactionListData implements Parcelable {
    public static final Parcelable.Creator<TransactionListData> CREATOR = new C1771a();

    /* renamed from: a */
    public boolean f4655a;

    /* renamed from: b */
    public ArrayList<Transaction> f4656b;

    /* renamed from: c */
    public BalanceData f4657c;

    /* renamed from: fr.smoney.android.izly.data.model.TransactionListData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1771a implements Parcelable.Creator<TransactionListData> {
        @Override // android.os.Parcelable.Creator
        public TransactionListData createFromParcel(Parcel parcel) {
            return new TransactionListData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public TransactionListData[] newArray(int i) {
            return new TransactionListData[i];
        }
    }

    public TransactionListData() {
        this.f4657c = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4655a ? 1 : 0);
        parcel.writeTypedList(this.f4656b);
        BalanceData balanceData = this.f4657c;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }

    public TransactionListData(Parcel parcel, C1771a c1771a) {
        this.f4655a = parcel.readInt() == 1;
        ArrayList<Transaction> arrayList = new ArrayList<>();
        this.f4656b = arrayList;
        parcel.readTypedList(arrayList, Transaction.CREATOR);
        this.f4657c = new BalanceData(parcel);
    }
}
