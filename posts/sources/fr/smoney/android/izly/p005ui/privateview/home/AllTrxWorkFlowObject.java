package fr.smoney.android.izly.p005ui.privateview.home;

import android.os.Parcel;
import android.os.Parcelable;
import fr.smoney.android.izly.data.items.KeyValueObject;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* renamed from: fr.smoney.android.izly.ui.privateview.home.AllTrxWorkFlowObject */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AllTrxWorkFlowObject implements Parcelable {
    @NotNull
    public static final C1795a CREATOR = new C1795a(null);

    /* renamed from: a */
    public ArrayList<KeyValueObject> f4798a;

    /* renamed from: b */
    public EnumC0115E8 f4799b;

    /* renamed from: c */
    public String f4800c;

    /* renamed from: d */
    public String f4801d;

    /* renamed from: f */
    public String f4802f;

    /* renamed from: fr.smoney.android.izly.ui.privateview.home.AllTrxWorkFlowObject$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1795a implements Parcelable.Creator<AllTrxWorkFlowObject> {
        public C1795a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public AllTrxWorkFlowObject createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new AllTrxWorkFlowObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AllTrxWorkFlowObject[] newArray(int i) {
            return new AllTrxWorkFlowObject[i];
        }
    }

    public AllTrxWorkFlowObject() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int ordinal;
        C0581Yd.m1766e(parcel, "dest");
        parcel.writeTypedList(this.f4798a);
        EnumC0115E8 enumC0115E8 = this.f4799b;
        if (enumC0115E8 == null) {
            ordinal = -1;
        } else {
            C0581Yd.m1768c(enumC0115E8);
            ordinal = enumC0115E8.ordinal();
        }
        parcel.writeInt(ordinal);
        parcel.writeString(this.f4800c);
        parcel.writeString(this.f4801d);
        parcel.writeString(this.f4802f);
    }

    public AllTrxWorkFlowObject(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        this.f4798a = parcel.createTypedArrayList(KeyValueObject.CREATOR);
        int readInt = parcel.readInt();
        this.f4799b = readInt == -1 ? null : EnumC0115E8.values()[readInt];
        this.f4800c = parcel.readString();
        this.f4801d = parcel.readString();
        this.f4802f = parcel.readString();
    }
}
