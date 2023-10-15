package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PlanAvailability implements Parcelable {
    public static final Parcelable.Creator<PlanAvailability> CREATOR = new C1754a();

    /* renamed from: a */
    public long f4539a;

    /* renamed from: b */
    public float f4540b;

    /* renamed from: c */
    public int f4541c;

    /* renamed from: d */
    public float f4542d;

    /* renamed from: fr.smoney.android.izly.data.model.PlanAvailability$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1754a implements Parcelable.Creator<PlanAvailability> {
        @Override // android.os.Parcelable.Creator
        public PlanAvailability createFromParcel(Parcel parcel) {
            return new PlanAvailability(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlanAvailability[] newArray(int i) {
            return new PlanAvailability[i];
        }
    }

    public PlanAvailability(Parcel parcel) {
        this.f4539a = parcel.readLong();
        this.f4540b = parcel.readFloat();
        this.f4541c = parcel.readInt();
        this.f4542d = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4539a);
        parcel.writeFloat(this.f4540b);
        parcel.writeInt(this.f4541c);
        parcel.writeFloat(this.f4542d);
    }
}
