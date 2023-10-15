package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class GetEventList implements Parcelable {
    @NotNull
    public static final C1716a CREATOR = new C1716a(null);

    /* renamed from: a */
    public ArrayList<Event> f4332a;

    /* renamed from: fr.smoney.android.izly.data.model.GetEventList$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1716a implements Parcelable.Creator<GetEventList> {
        public C1716a(C0565Xd c0565Xd) {
        }

        @NotNull
        /* renamed from: a */
        public GetEventList[] m971a(int i) {
            return m971a(i);
        }

        @Override // android.os.Parcelable.Creator
        public GetEventList createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new GetEventList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetEventList[] newArray(int i) {
            return m971a(i);
        }
    }

    public GetEventList() {
        this.f4332a = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "parcel");
        ArrayList<Event> arrayList = this.f4332a;
        if (arrayList != null) {
            parcel.writeTypedList(arrayList);
        } else {
            C0581Yd.m1761j("eventList");
            throw null;
        }
    }

    public GetEventList(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        ArrayList<Event> arrayList = new ArrayList<>();
        this.f4332a = arrayList;
        parcel.readTypedList(arrayList, Event.CREATOR);
    }
}
