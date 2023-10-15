package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ServiceData implements Parcelable {
    public static final Parcelable.Creator<ServiceData> CREATOR = new C1765a();

    /* renamed from: a */
    public int f4606a;

    /* renamed from: b */
    public boolean f4607b;

    /* renamed from: fr.smoney.android.izly.data.model.ServiceData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1765a implements Parcelable.Creator<ServiceData> {
        @Override // android.os.Parcelable.Creator
        public ServiceData createFromParcel(Parcel parcel) {
            return new ServiceData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ServiceData[] newArray(int i) {
            return new ServiceData[i];
        }
    }

    public ServiceData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4606a);
        parcel.writeInt(this.f4607b ? 1 : 0);
    }

    public ServiceData(Parcel parcel) {
        this.f4606a = parcel.readInt();
        this.f4607b = parcel.readInt() == 1;
    }
}
