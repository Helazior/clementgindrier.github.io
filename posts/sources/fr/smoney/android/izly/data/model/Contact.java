package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Contact implements Parcelable, Comparable<Contact> {
    public static final Parcelable.Creator<Contact> CREATOR = new C1704a();

    /* renamed from: a */
    public String f4243a;

    /* renamed from: b */
    public String f4244b;

    /* renamed from: c */
    public String f4245c;

    /* renamed from: d */
    public String f4246d;

    /* renamed from: f */
    public String f4247f;

    /* renamed from: g */
    public EnumC1706c f4248g;

    /* renamed from: h */
    public EnumC1705b f4249h;

    /* renamed from: i */
    public int f4250i;

    /* renamed from: j */
    public boolean f4251j;

    /* renamed from: k */
    public String f4252k;

    /* renamed from: fr.smoney.android.izly.data.model.Contact$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1704a implements Parcelable.Creator<Contact> {
        @Override // android.os.Parcelable.Creator
        public Contact createFromParcel(Parcel parcel) {
            return new Contact(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Contact[] newArray(int i) {
            return new Contact[i];
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.Contact$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1705b {
        BOOKMARKED,
        DISTANT,
        LOCAL
    }

    /* renamed from: fr.smoney.android.izly.data.model.Contact$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1706c {
        Unknown,
        SmoneyUserPart,
        SmoneyUserPro
    }

    public Contact() {
        this.f4249h = EnumC1705b.DISTANT;
        this.f4251j = false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Contact contact) {
        return this.f4244b.compareToIgnoreCase(contact.f4244b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4243a);
        parcel.writeString(this.f4244b);
        parcel.writeString(this.f4245c);
        parcel.writeString(this.f4246d);
        parcel.writeString(this.f4247f);
        parcel.writeSerializable(this.f4248g);
        parcel.writeInt(this.f4251j ? 1 : 0);
        parcel.writeString(this.f4252k);
        parcel.writeInt(this.f4249h.ordinal());
        parcel.writeInt(this.f4250i);
    }

    public Contact(Parcel parcel) {
        this.f4249h = EnumC1705b.DISTANT;
        this.f4251j = false;
        this.f4243a = parcel.readString();
        this.f4244b = parcel.readString();
        this.f4245c = parcel.readString();
        this.f4246d = parcel.readString();
        this.f4247f = parcel.readString();
        this.f4248g = (EnumC1706c) parcel.readSerializable();
        this.f4251j = parcel.readInt() == 1;
        this.f4252k = parcel.readString();
        this.f4249h = EnumC1705b.values()[parcel.readInt()];
        this.f4250i = parcel.readInt();
    }
}
