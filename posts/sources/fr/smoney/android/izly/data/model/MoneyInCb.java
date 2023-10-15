package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyInCb implements Parcelable {
    public static final Parcelable.Creator<MoneyInCb> CREATOR = new C1730a();

    /* renamed from: a */
    public long f4412a;

    /* renamed from: b */
    public long f4413b;

    /* renamed from: c */
    public MoneyInCbCb f4414c;

    /* renamed from: d */
    public double f4415d;

    /* renamed from: f */
    public double f4416f;

    /* renamed from: g */
    public double f4417g;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyInCb$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1730a implements Parcelable.Creator<MoneyInCb> {
        @Override // android.os.Parcelable.Creator
        public MoneyInCb createFromParcel(Parcel parcel) {
            return new MoneyInCb(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyInCb[] newArray(int i) {
            return new MoneyInCb[i];
        }
    }

    public MoneyInCb() {
        this.f4414c = new MoneyInCbCb();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4412a);
        parcel.writeLong(this.f4413b);
        MoneyInCbCb moneyInCbCb = this.f4414c;
        parcel.writeString(moneyInCbCb.f4418a);
        parcel.writeString(moneyInCbCb.f4419b);
        parcel.writeInt(moneyInCbCb.f4420c);
        parcel.writeString(moneyInCbCb.f4421d);
        parcel.writeInt(moneyInCbCb.f4422f ? 1 : 0);
        parcel.writeDouble(this.f4415d);
        parcel.writeDouble(this.f4416f);
        parcel.writeDouble(this.f4417g);
    }

    public MoneyInCb(Parcel parcel) {
        this.f4412a = parcel.readLong();
        this.f4413b = parcel.readLong();
        this.f4414c = new MoneyInCbCb(parcel);
        this.f4415d = parcel.readDouble();
        this.f4416f = parcel.readDouble();
        this.f4417g = parcel.readDouble();
    }
}
