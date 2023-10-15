package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CounterFamily implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1707a();

    /* renamed from: a */
    public long f4261a;

    /* renamed from: b */
    public String f4262b;

    /* renamed from: c */
    public int f4263c;

    /* renamed from: fr.smoney.android.izly.data.model.CounterFamily$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1707a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new CounterFamily(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new CounterFamily[i];
        }
    }

    public CounterFamily(long j, String str, int i) {
        this.f4261a = j;
        this.f4262b = str;
        this.f4263c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4261a);
        parcel.writeString(this.f4262b);
        parcel.writeInt(this.f4263c);
    }

    public CounterFamily(Parcel parcel) {
        this.f4261a = parcel.readLong();
        this.f4262b = parcel.readString();
        this.f4263c = parcel.readInt();
    }
}
