package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class UserData implements Parcelable {
    public static final Parcelable.Creator<UserData> CREATOR = new C1775a();

    /* renamed from: a */
    public String f4665a;

    /* renamed from: b */
    public String f4666b;

    /* renamed from: fr.smoney.android.izly.data.model.UserData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1775a implements Parcelable.Creator<UserData> {
        @Override // android.os.Parcelable.Creator
        public UserData createFromParcel(Parcel parcel) {
            return new UserData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public UserData[] newArray(int i) {
            return new UserData[i];
        }
    }

    public UserData() {
        this.f4665a = "";
        this.f4666b = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4665a);
        parcel.writeString(this.f4666b);
    }

    public UserData(Parcel parcel, C1775a c1775a) {
        this.f4665a = parcel.readString();
        this.f4666b = parcel.readString();
    }
}
