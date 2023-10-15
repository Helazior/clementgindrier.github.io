package fr.smoney.android.izly.data.items;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KeyValueObject implements Parcelable {
    public static final Parcelable.Creator<KeyValueObject> CREATOR = new C1691a();

    /* renamed from: a */
    public String f4213a;

    /* renamed from: b */
    public String f4214b;

    /* renamed from: fr.smoney.android.izly.data.items.KeyValueObject$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1691a implements Parcelable.Creator<KeyValueObject> {
        @Override // android.os.Parcelable.Creator
        public KeyValueObject createFromParcel(Parcel parcel) {
            return new KeyValueObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public KeyValueObject[] newArray(int i) {
            return new KeyValueObject[i];
        }
    }

    public KeyValueObject(String str, String str2) {
        this.f4213a = str;
        this.f4214b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4213a);
        parcel.writeString(this.f4214b);
    }

    public KeyValueObject(Parcel parcel) {
        this.f4213a = parcel.readString();
        this.f4214b = parcel.readString();
    }
}
