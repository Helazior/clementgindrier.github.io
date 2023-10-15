package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChooseDefaultCbData implements Parcelable {
    public static final Parcelable.Creator<ChooseDefaultCbData> CREATOR = new C1703a();

    /* renamed from: fr.smoney.android.izly.data.model.ChooseDefaultCbData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1703a implements Parcelable.Creator<ChooseDefaultCbData> {
        @Override // android.os.Parcelable.Creator
        public ChooseDefaultCbData createFromParcel(Parcel parcel) {
            return new ChooseDefaultCbData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ChooseDefaultCbData[] newArray(int i) {
            return new ChooseDefaultCbData[i];
        }
    }

    public ChooseDefaultCbData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public ChooseDefaultCbData(Parcel parcel) {
    }
}
