package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CardPaymentsData implements Parcelable {
    public static final Parcelable.Creator<CardPaymentsData> CREATOR = new C1698a();

    /* renamed from: a */
    public String f4234a;

    /* renamed from: fr.smoney.android.izly.data.model.CardPaymentsData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1698a implements Parcelable.Creator<CardPaymentsData> {
        @Override // android.os.Parcelable.Creator
        public CardPaymentsData createFromParcel(Parcel parcel) {
            return new CardPaymentsData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CardPaymentsData[] newArray(int i) {
            return new CardPaymentsData[i];
        }
    }

    public CardPaymentsData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4234a);
    }

    public CardPaymentsData(Parcel parcel) {
        this.f4234a = parcel.readString();
    }
}
