package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class InitiatePasswordRecoveryData implements Parcelable {
    public static final Parcelable.Creator<InitiatePasswordRecoveryData> CREATOR = new C1721a();

    /* renamed from: fr.smoney.android.izly.data.model.InitiatePasswordRecoveryData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1721a implements Parcelable.Creator<InitiatePasswordRecoveryData> {
        @Override // android.os.Parcelable.Creator
        public InitiatePasswordRecoveryData createFromParcel(Parcel parcel) {
            return new InitiatePasswordRecoveryData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InitiatePasswordRecoveryData[] newArray(int i) {
            return new InitiatePasswordRecoveryData[i];
        }
    }

    public InitiatePasswordRecoveryData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public InitiatePasswordRecoveryData(Parcel parcel) {
    }
}
