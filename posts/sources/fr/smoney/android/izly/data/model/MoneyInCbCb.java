package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyInCbCb implements Parcelable {
    public static final Parcelable.Creator<MoneyInCbCb> CREATOR = new C1731a();

    /* renamed from: a */
    public String f4418a;

    /* renamed from: b */
    public String f4419b;

    /* renamed from: c */
    public int f4420c;

    /* renamed from: d */
    public String f4421d;

    /* renamed from: f */
    public boolean f4422f;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyInCbCb$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1731a implements Parcelable.Creator<MoneyInCbCb> {
        @Override // android.os.Parcelable.Creator
        public MoneyInCbCb createFromParcel(Parcel parcel) {
            return new MoneyInCbCb(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyInCbCb[] newArray(int i) {
            return new MoneyInCbCb[i];
        }
    }

    public MoneyInCbCb() {
    }

    /* renamed from: a */
    public static String m968a(Context context, int i) {
        EnumC0592Z8[] values = EnumC0592Z8.values();
        for (int i2 = 0; i2 < 26; i2++) {
            EnumC0592Z8 enumC0592Z8 = values[i2];
            if (i == enumC0592Z8.f2102a) {
                return context.getString(enumC0592Z8.f2103b);
            }
        }
        return "UNKNOWN";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4418a);
        parcel.writeString(this.f4419b);
        parcel.writeInt(this.f4420c);
        parcel.writeString(this.f4421d);
        parcel.writeInt(this.f4422f ? 1 : 0);
    }

    public MoneyInCbCb(String str, String str2) {
        this.f4418a = str;
        this.f4419b = str2;
    }

    public MoneyInCbCb(Parcel parcel) {
        this.f4418a = parcel.readString();
        this.f4419b = parcel.readString();
        this.f4420c = parcel.readInt();
        this.f4421d = parcel.readString();
        this.f4422f = parcel.readInt() == 1;
    }
}
