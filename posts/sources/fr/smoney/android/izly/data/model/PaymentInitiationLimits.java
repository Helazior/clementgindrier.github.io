package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PaymentInitiationLimits implements Parcelable {
    @NotNull
    public static final C1753a CREATOR = new C1753a(null);

    /* renamed from: a */
    public double f4536a;

    /* renamed from: b */
    public double f4537b;

    /* renamed from: c */
    public int[] f4538c;

    /* renamed from: fr.smoney.android.izly.data.model.PaymentInitiationLimits$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1753a implements Parcelable.Creator<PaymentInitiationLimits> {
        public C1753a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public PaymentInitiationLimits createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new PaymentInitiationLimits(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PaymentInitiationLimits[] newArray(int i) {
            return new PaymentInitiationLimits[i];
        }
    }

    public PaymentInitiationLimits() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "parcel");
        parcel.writeDouble(this.f4536a);
        parcel.writeDouble(this.f4537b);
        int[] iArr = this.f4538c;
        if (iArr != null) {
            parcel.writeIntArray(iArr);
        } else {
            C0581Yd.m1761j("stepsArray");
            throw null;
        }
    }

    public PaymentInitiationLimits(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        this.f4536a = parcel.readDouble();
        this.f4537b = parcel.readDouble();
        int[] createIntArray = parcel.createIntArray();
        C0581Yd.m1768c(createIntArray);
        this.f4538c = createIntArray;
    }
}
