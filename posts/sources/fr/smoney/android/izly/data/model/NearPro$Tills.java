package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NearPro$Tills implements Parcelable {
    public static final Parcelable.Creator<NearPro$Tills> CREATOR = new C1738a();

    /* renamed from: a */
    public String f4460a;

    /* renamed from: b */
    public String f4461b;

    /* renamed from: c */
    public boolean f4462c;

    /* renamed from: fr.smoney.android.izly.data.model.NearPro$Tills$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1738a implements Parcelable.Creator<NearPro$Tills> {
        @Override // android.os.Parcelable.Creator
        public NearPro$Tills createFromParcel(Parcel parcel) {
            return new NearPro$Tills(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NearPro$Tills[] newArray(int i) {
            return new NearPro$Tills[i];
        }
    }

    public NearPro$Tills(Parcel parcel) {
        this.f4460a = parcel.readString();
        this.f4461b = parcel.readString();
        this.f4462c = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4460a);
        parcel.writeString(this.f4461b);
        parcel.writeInt(this.f4462c ? 1 : 0);
    }

    public NearPro$Tills() {
    }
}
