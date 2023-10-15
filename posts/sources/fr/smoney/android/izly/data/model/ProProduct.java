package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ProProduct implements Parcelable {
    public static final Parcelable.Creator<ProProduct> CREATOR = new C1759a();

    /* renamed from: a */
    public int f4573a;

    /* renamed from: b */
    public String f4574b;

    /* renamed from: c */
    public String f4575c;

    /* renamed from: d */
    public String f4576d;

    /* renamed from: f */
    public String f4577f;

    /* renamed from: g */
    public String f4578g;

    /* renamed from: h */
    public String f4579h;

    /* renamed from: fr.smoney.android.izly.data.model.ProProduct$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1759a implements Parcelable.Creator<ProProduct> {
        @Override // android.os.Parcelable.Creator
        public ProProduct createFromParcel(Parcel parcel) {
            return new ProProduct(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProProduct[] newArray(int i) {
            return new ProProduct[i];
        }
    }

    public ProProduct() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4573a);
        parcel.writeString(this.f4574b);
        parcel.writeString(this.f4575c);
        parcel.writeString(this.f4576d);
        parcel.writeString(this.f4577f);
        parcel.writeString(this.f4578g);
        parcel.writeString(this.f4579h);
    }

    public ProProduct(Parcel parcel) {
        this.f4573a = parcel.readInt();
        this.f4574b = parcel.readString();
        this.f4575c = parcel.readString();
        this.f4576d = parcel.readString();
        this.f4577f = parcel.readString();
        this.f4578g = parcel.readString();
        this.f4579h = parcel.readString();
    }
}
