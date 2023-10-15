package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MakeBankAccountUpdateData implements Parcelable {
    public static final Parcelable.Creator<MakeBankAccountUpdateData> CREATOR = new C1726a();

    /* renamed from: a */
    public String f4391a;

    /* renamed from: b */
    public String f4392b;

    /* renamed from: c */
    public String f4393c;

    /* renamed from: d */
    public String f4394d;

    /* renamed from: f */
    public String f4395f;

    /* renamed from: g */
    public String f4396g;

    /* renamed from: h */
    public long f4397h;

    /* renamed from: i */
    public boolean f4398i;

    /* renamed from: j */
    public boolean f4399j;

    /* renamed from: k */
    public String f4400k;

    /* renamed from: l */
    public String f4401l;

    /* renamed from: fr.smoney.android.izly.data.model.MakeBankAccountUpdateData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1726a implements Parcelable.Creator<MakeBankAccountUpdateData> {
        @Override // android.os.Parcelable.Creator
        public MakeBankAccountUpdateData createFromParcel(Parcel parcel) {
            return new MakeBankAccountUpdateData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MakeBankAccountUpdateData[] newArray(int i) {
            return new MakeBankAccountUpdateData[i];
        }
    }

    public MakeBankAccountUpdateData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4391a);
        parcel.writeString(this.f4392b);
        parcel.writeString(this.f4393c);
        parcel.writeString(this.f4394d);
        parcel.writeString(this.f4395f);
        parcel.writeString(this.f4396g);
        parcel.writeString(this.f4400k);
        parcel.writeLong(this.f4397h);
        parcel.writeInt(this.f4398i ? 1 : 0);
        parcel.writeInt(this.f4399j ? 1 : 0);
        parcel.writeString(this.f4401l);
    }

    public MakeBankAccountUpdateData(Parcel parcel, C1726a c1726a) {
        this.f4391a = parcel.readString();
        this.f4392b = parcel.readString();
        this.f4393c = parcel.readString();
        this.f4394d = parcel.readString();
        this.f4395f = parcel.readString();
        this.f4396g = parcel.readString();
        this.f4400k = parcel.readString();
        this.f4397h = parcel.readLong();
        this.f4398i = parcel.readInt() == 1;
        this.f4399j = parcel.readInt() == 1;
        this.f4401l = parcel.readString();
    }
}
