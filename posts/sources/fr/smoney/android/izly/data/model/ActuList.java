package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ActuList implements Parcelable {
    @NotNull
    public static final C1695a CREATOR = new C1695a(null);

    /* renamed from: a */
    public ArrayList<ActuDetail> f4229a;

    /* renamed from: fr.smoney.android.izly.data.model.ActuList$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1695a implements Parcelable.Creator<ActuList> {
        public C1695a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public ActuList createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new ActuList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActuList[] newArray(int i) {
            return new ActuList[i];
        }
    }

    public ActuList() {
        this.f4229a = new ArrayList<>();
    }

    @NotNull
    /* renamed from: a */
    public final ArrayList<ActuDetail> m974a() {
        ArrayList<ActuDetail> arrayList = this.f4229a;
        if (arrayList != null) {
            return arrayList;
        }
        C0581Yd.m1761j("actuList");
        throw null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "parcel");
        ArrayList<ActuDetail> arrayList = this.f4229a;
        if (arrayList != null) {
            parcel.writeTypedList(arrayList);
        } else {
            C0581Yd.m1761j("actuList");
            throw null;
        }
    }

    public ActuList(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        ArrayList<ActuDetail> arrayList = new ArrayList<>();
        this.f4229a = arrayList;
        parcel.readTypedList(arrayList, ActuDetail.CREATOR);
    }
}
