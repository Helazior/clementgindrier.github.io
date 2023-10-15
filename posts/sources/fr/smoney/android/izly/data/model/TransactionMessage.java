package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TransactionMessage implements Parcelable {
    public static final Parcelable.Creator<TransactionMessage> CREATOR = new C1772a();

    /* renamed from: a */
    public long f4658a;

    /* renamed from: b */
    public long f4659b;

    /* renamed from: c */
    public String f4660c;

    /* renamed from: d */
    public String f4661d;

    /* renamed from: fr.smoney.android.izly.data.model.TransactionMessage$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1772a implements Parcelable.Creator<TransactionMessage> {
        @Override // android.os.Parcelable.Creator
        public TransactionMessage createFromParcel(Parcel parcel) {
            return new TransactionMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TransactionMessage[] newArray(int i) {
            return new TransactionMessage[i];
        }
    }

    public TransactionMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4658a);
        parcel.writeLong(this.f4659b);
        parcel.writeString(this.f4660c);
        parcel.writeString(this.f4661d);
    }

    public TransactionMessage(Parcel parcel) {
        this.f4658a = parcel.readLong();
        this.f4659b = parcel.readLong();
        this.f4660c = parcel.readString();
        this.f4661d = parcel.readString();
    }
}
