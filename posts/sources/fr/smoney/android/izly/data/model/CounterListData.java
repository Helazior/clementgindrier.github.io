package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CounterListData implements Parcelable {
    public static final Parcelable.Creator<CounterListData> CREATOR = new C1708a();

    /* renamed from: a */
    public final ArrayList<CounterFamily> f4264a;

    /* renamed from: b */
    public Boolean f4265b = Boolean.FALSE;

    /* renamed from: fr.smoney.android.izly.data.model.CounterListData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1708a implements Parcelable.Creator<CounterListData> {
        @Override // android.os.Parcelable.Creator
        public CounterListData createFromParcel(Parcel parcel) {
            return new CounterListData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CounterListData[] newArray(int i) {
            return new CounterListData[i];
        }
    }

    public CounterListData(ArrayList<CounterFamily> arrayList) {
        this.f4264a = arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4264a);
    }

    public CounterListData(Parcel parcel) {
        ArrayList<CounterFamily> arrayList = new ArrayList<>();
        this.f4264a = arrayList;
        parcel.readTypedList(arrayList, CounterFamily.CREATOR);
    }
}
