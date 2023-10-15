package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ServerError implements Parcelable {
    public static final Parcelable.Creator<ServerError> CREATOR = new C1764a();

    /* renamed from: a */
    public String f4600a;

    /* renamed from: b */
    public int f4601b;

    /* renamed from: c */
    public int f4602c;

    /* renamed from: d */
    public String f4603d;

    /* renamed from: f */
    public String f4604f;

    /* renamed from: g */
    public int f4605g;

    /* renamed from: fr.smoney.android.izly.data.model.ServerError$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1764a implements Parcelable.Creator<ServerError> {
        @Override // android.os.Parcelable.Creator
        public ServerError createFromParcel(Parcel parcel) {
            return new ServerError(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public ServerError[] newArray(int i) {
            return new ServerError[i];
        }
    }

    public ServerError() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4600a);
        parcel.writeInt(this.f4601b);
        parcel.writeString(this.f4603d);
        parcel.writeString(this.f4604f);
        parcel.writeInt(this.f4605g);
    }

    public ServerError(Parcel parcel, C1764a c1764a) {
        this.f4600a = parcel.readString();
        this.f4601b = parcel.readInt();
        this.f4603d = parcel.readString();
        this.f4604f = parcel.readString();
        this.f4605g = parcel.readInt();
    }
}
