package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Event implements Parcelable {
    @NotNull
    public static final C1710a CREATOR = new C1710a(null);
    @NotNull

    /* renamed from: a */
    public String f4271a;
    @NotNull

    /* renamed from: b */
    public String f4272b;

    /* renamed from: fr.smoney.android.izly.data.model.Event$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1710a implements Parcelable.Creator<Event> {
        public C1710a(C0565Xd c0565Xd) {
        }

        @NotNull
        /* renamed from: a */
        public Event[] m973a(int i) {
            return m973a(i);
        }

        @Override // android.os.Parcelable.Creator
        public Event createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new Event(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Event[] newArray(int i) {
            return m973a(i);
        }
    }

    public Event() {
        this.f4271a = "";
        this.f4272b = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "parcel");
        parcel.writeString(this.f4271a);
        parcel.writeString(this.f4272b);
    }

    public Event(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        this.f4271a = "";
        this.f4272b = "";
        this.f4271a = String.valueOf(parcel.readString());
        this.f4272b = String.valueOf(parcel.readString());
    }
}
