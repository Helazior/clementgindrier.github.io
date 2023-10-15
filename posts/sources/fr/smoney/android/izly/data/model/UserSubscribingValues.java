package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class UserSubscribingValues implements Parcelable {
    public static final Parcelable.Creator<UserSubscribingValues> CREATOR = new C1776a();

    /* renamed from: a */
    public int f4667a;

    /* renamed from: b */
    public String f4668b;

    /* renamed from: c */
    public String f4669c;

    /* renamed from: d */
    public String f4670d;

    /* renamed from: f */
    public String f4671f;

    /* renamed from: g */
    public String f4672g;

    /* renamed from: h */
    public String f4673h;

    /* renamed from: i */
    public String f4674i;

    /* renamed from: j */
    public String f4675j;

    /* renamed from: k */
    public String f4676k;

    /* renamed from: l */
    public boolean f4677l;

    /* renamed from: m */
    public boolean f4678m;

    /* renamed from: n */
    public byte[] f4679n;

    /* renamed from: fr.smoney.android.izly.data.model.UserSubscribingValues$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1776a implements Parcelable.Creator<UserSubscribingValues> {
        @Override // android.os.Parcelable.Creator
        public UserSubscribingValues createFromParcel(Parcel parcel) {
            return new UserSubscribingValues(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UserSubscribingValues[] newArray(int i) {
            return new UserSubscribingValues[i];
        }
    }

    public UserSubscribingValues(Parcel parcel) {
        this.f4667a = parcel.readInt();
        this.f4668b = parcel.readString();
        this.f4669c = parcel.readString();
        this.f4670d = parcel.readString();
        this.f4671f = parcel.readString();
        this.f4672g = parcel.readString();
        this.f4673h = parcel.readString();
        this.f4674i = parcel.readString();
        this.f4675j = parcel.readString();
        this.f4676k = parcel.readString();
        this.f4677l = parcel.readInt() == 1;
        this.f4678m = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            this.f4679n = bArr;
            parcel.readByteArray(bArr);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4667a);
        parcel.writeString(this.f4668b);
        parcel.writeString(this.f4669c);
        parcel.writeString(this.f4670d);
        parcel.writeString(this.f4671f);
        parcel.writeString(this.f4672g);
        parcel.writeString(this.f4673h);
        parcel.writeString(this.f4674i);
        parcel.writeString(this.f4675j);
        parcel.writeString(this.f4676k);
        parcel.writeInt(this.f4677l ? 1 : 0);
        parcel.writeInt(this.f4678m ? 1 : 0);
        byte[] bArr = this.f4679n;
        if (bArr != null) {
            int length = bArr.length;
            parcel.writeInt(length);
            parcel.writeByteArray(this.f4679n, 0, length);
            return;
        }
        parcel.writeInt(0);
    }
}
