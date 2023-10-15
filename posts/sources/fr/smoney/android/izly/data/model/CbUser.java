package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CbUser implements Parcelable {
    public static final Parcelable.Creator<CbUser> CREATOR = new C1701a();

    /* renamed from: a */
    public String f4239a;

    /* renamed from: b */
    public String f4240b;

    /* renamed from: fr.smoney.android.izly.data.model.CbUser$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1701a implements Parcelable.Creator<CbUser> {
        @Override // android.os.Parcelable.Creator
        public CbUser createFromParcel(Parcel parcel) {
            return new CbUser(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CbUser[] newArray(int i) {
            return new CbUser[i];
        }
    }

    public CbUser() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4239a);
        parcel.writeString(this.f4240b);
    }

    public CbUser(Parcel parcel) {
        this.f4239a = parcel.readString();
        this.f4240b = parcel.readString();
    }
}
