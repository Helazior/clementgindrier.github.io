package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetMySupportListData implements Parcelable {
    public static final Parcelable.Creator<GetMySupportListData> CREATOR = new C1718a();

    /* renamed from: a */
    public ArrayList<Support> f4335a;

    /* renamed from: fr.smoney.android.izly.data.model.GetMySupportListData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1718a implements Parcelable.Creator<GetMySupportListData> {
        @Override // android.os.Parcelable.Creator
        public GetMySupportListData createFromParcel(Parcel parcel) {
            return new GetMySupportListData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetMySupportListData[] newArray(int i) {
            return new GetMySupportListData[i];
        }
    }

    public GetMySupportListData() {
        this.f4335a = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4335a);
    }

    public GetMySupportListData(Parcel parcel) {
        ArrayList<Support> arrayList = new ArrayList<>();
        this.f4335a = arrayList;
        parcel.readTypedList(arrayList, Support.CREATOR);
    }
}
