package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedContactLight implements Parcelable {
    public static final Parcelable.Creator<NewsFeedContactLight> CREATOR = new C1741a();

    /* renamed from: a */
    public String f4465a;

    /* renamed from: b */
    public String f4466b;

    /* renamed from: c */
    public boolean f4467c;

    /* renamed from: d */
    public boolean f4468d;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedContactLight$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1741a implements Parcelable.Creator<NewsFeedContactLight> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedContactLight createFromParcel(Parcel parcel) {
            return new NewsFeedContactLight(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedContactLight[] newArray(int i) {
            return new NewsFeedContactLight[i];
        }
    }

    public NewsFeedContactLight() {
        this.f4467c = false;
        this.f4468d = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4465a);
        parcel.writeString(this.f4466b);
        parcel.writeInt(this.f4467c ? 1 : 0);
        parcel.writeInt(this.f4468d ? 1 : 0);
    }

    public NewsFeedContactLight(Parcel parcel) {
        this.f4467c = false;
        this.f4468d = false;
        this.f4465a = parcel.readString();
        this.f4466b = parcel.readString();
        this.f4467c = parcel.readInt() == 1;
        this.f4468d = parcel.readInt() == 1;
    }
}
