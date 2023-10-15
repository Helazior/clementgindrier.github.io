package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OAuthData implements Parcelable {
    public static final Parcelable.Creator<OAuthData> CREATOR = new C1752a();

    /* renamed from: a */
    public String f4533a;

    /* renamed from: b */
    public String f4534b;

    /* renamed from: c */
    public long f4535c;

    /* renamed from: fr.smoney.android.izly.data.model.OAuthData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1752a implements Parcelable.Creator<OAuthData> {
        @Override // android.os.Parcelable.Creator
        public OAuthData createFromParcel(Parcel parcel) {
            return new OAuthData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public OAuthData[] newArray(int i) {
            return new OAuthData[i];
        }
    }

    public OAuthData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4533a);
        parcel.writeString(this.f4534b);
        parcel.writeLong(this.f4535c);
    }

    public OAuthData(String str, String str2, long j) {
        this.f4533a = str;
        this.f4534b = str2;
        this.f4535c = j;
    }

    public OAuthData(Parcel parcel) {
        this.f4533a = parcel.readString();
        this.f4534b = parcel.readString();
        this.f4535c = parcel.readLong();
    }
}
