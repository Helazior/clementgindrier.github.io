package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IsEnrollmentOpenData implements Parcelable {
    public static final Parcelable.Creator<IsEnrollmentOpenData> CREATOR = new C1722a();

    /* renamed from: a */
    public boolean f4345a;

    /* renamed from: fr.smoney.android.izly.data.model.IsEnrollmentOpenData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1722a implements Parcelable.Creator<IsEnrollmentOpenData> {
        @Override // android.os.Parcelable.Creator
        public IsEnrollmentOpenData createFromParcel(Parcel parcel) {
            return new IsEnrollmentOpenData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IsEnrollmentOpenData[] newArray(int i) {
            return new IsEnrollmentOpenData[i];
        }
    }

    public IsEnrollmentOpenData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4345a ? 1 : 0);
    }

    public IsEnrollmentOpenData(Parcel parcel) {
        this.f4345a = parcel.readInt() == 1;
    }
}
