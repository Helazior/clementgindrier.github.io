package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RequestData implements Parcelable {
    public static final Parcelable.Creator<RequestData> CREATOR = new C1763a();

    /* renamed from: a */
    public int f4597a;

    /* renamed from: b */
    public int f4598b;

    /* renamed from: c */
    public boolean f4599c;

    /* renamed from: fr.smoney.android.izly.data.model.RequestData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1763a implements Parcelable.Creator<RequestData> {
        @Override // android.os.Parcelable.Creator
        public RequestData createFromParcel(Parcel parcel) {
            return new RequestData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RequestData[] newArray(int i) {
            return new RequestData[i];
        }
    }

    public RequestData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RequestData.class != obj.getClass()) {
            return false;
        }
        RequestData requestData = (RequestData) obj;
        return this.f4597a == requestData.f4597a && this.f4598b == requestData.f4598b;
    }

    public int hashCode() {
        return (this.f4597a * 31) + this.f4598b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4597a);
        parcel.writeInt(this.f4598b);
        parcel.writeInt(this.f4599c ? 1 : 0);
    }

    public RequestData(int i, int i2, boolean z) {
        this.f4597a = i;
        this.f4598b = i2;
        this.f4599c = z;
    }

    public RequestData(Parcel parcel) {
        this.f4597a = parcel.readInt();
        this.f4598b = parcel.readInt();
        this.f4599c = parcel.readInt() == 1;
    }
}
