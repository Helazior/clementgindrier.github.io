package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActivateUserData implements Parcelable {
    public static final Parcelable.Creator<ActivateUserData> CREATOR = new C1693a();

    /* renamed from: a */
    public int f4218a;

    /* renamed from: b */
    public String f4219b;

    /* renamed from: c */
    public String f4220c;

    /* renamed from: fr.smoney.android.izly.data.model.ActivateUserData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1693a implements Parcelable.Creator<ActivateUserData> {
        @Override // android.os.Parcelable.Creator
        public ActivateUserData createFromParcel(Parcel parcel) {
            return new ActivateUserData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivateUserData[] newArray(int i) {
            return new ActivateUserData[i];
        }
    }

    public ActivateUserData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4218a);
        parcel.writeString(this.f4219b);
        parcel.writeString(this.f4220c);
    }

    public ActivateUserData(String str, String str2, int i) {
        this.f4220c = str;
        this.f4219b = str2;
        this.f4218a = i;
    }

    public ActivateUserData(Parcel parcel) {
        this.f4218a = parcel.readInt();
        this.f4219b = parcel.readString();
        this.f4220c = parcel.readString();
    }
}
