package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Mandate implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1729a();

    /* renamed from: a */
    public String f4408a;

    /* renamed from: b */
    public String f4409b;

    /* renamed from: c */
    public String f4410c;

    /* renamed from: d */
    public String f4411d;

    /* renamed from: fr.smoney.android.izly.data.model.Mandate$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1729a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new Mandate(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new Mandate[i];
        }
    }

    public Mandate(String str, String str2, String str3, String str4) {
        this.f4408a = str;
        this.f4409b = str2;
        this.f4410c = str3;
        this.f4411d = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4408a);
        parcel.writeString(this.f4409b);
        parcel.writeString(this.f4410c);
        parcel.writeString(this.f4411d);
    }

    public Mandate(Parcel parcel) {
        this.f4408a = parcel.readString();
        this.f4409b = parcel.readString();
        this.f4410c = parcel.readString();
        this.f4411d = parcel.readString();
    }
}
