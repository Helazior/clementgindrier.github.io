package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class UpdatePasswordData implements Parcelable {
    public static final Parcelable.Creator<UpdatePasswordData> CREATOR = new C1773a();

    /* renamed from: a */
    public String f4662a;

    /* renamed from: fr.smoney.android.izly.data.model.UpdatePasswordData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1773a implements Parcelable.Creator<UpdatePasswordData> {
        @Override // android.os.Parcelable.Creator
        public UpdatePasswordData createFromParcel(Parcel parcel) {
            return new UpdatePasswordData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UpdatePasswordData[] newArray(int i) {
            return new UpdatePasswordData[i];
        }
    }

    public UpdatePasswordData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4662a);
    }

    public UpdatePasswordData(Parcel parcel) {
        this.f4662a = parcel.readString();
    }
}
