package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CurrentUserSubscriptionPlan implements Parcelable {
    public static final Parcelable.Creator<CurrentUserSubscriptionPlan> CREATOR = new C1709a();

    /* renamed from: a */
    public ArrayList<PlanAvailability> f4266a;

    /* renamed from: b */
    public int f4267b;

    /* renamed from: c */
    public long f4268c;

    /* renamed from: d */
    public long f4269d;

    /* renamed from: f */
    public float f4270f;

    /* renamed from: fr.smoney.android.izly.data.model.CurrentUserSubscriptionPlan$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1709a implements Parcelable.Creator<CurrentUserSubscriptionPlan> {
        @Override // android.os.Parcelable.Creator
        public CurrentUserSubscriptionPlan createFromParcel(Parcel parcel) {
            return new CurrentUserSubscriptionPlan(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CurrentUserSubscriptionPlan[] newArray(int i) {
            return new CurrentUserSubscriptionPlan[i];
        }
    }

    public CurrentUserSubscriptionPlan() {
        this.f4266a = new ArrayList<>();
        this.f4267b = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4266a);
        parcel.writeInt(this.f4267b);
        parcel.writeLong(this.f4268c);
        parcel.writeLong(this.f4269d);
        parcel.writeFloat(this.f4270f);
    }

    public CurrentUserSubscriptionPlan(Parcel parcel) {
        ArrayList<PlanAvailability> arrayList = new ArrayList<>();
        this.f4266a = arrayList;
        this.f4267b = -1;
        parcel.readTypedList(arrayList, PlanAvailability.CREATOR);
        this.f4267b = parcel.readInt();
        this.f4268c = parcel.readLong();
        this.f4269d = parcel.readLong();
        this.f4270f = parcel.readFloat();
    }
}
