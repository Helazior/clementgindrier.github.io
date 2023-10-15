package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AccountStatement implements Parcelable {
    @NotNull
    public static final C1692a CREATOR = new C1692a(null);
    @NotNull

    /* renamed from: a */
    public String f4215a;
    @NotNull

    /* renamed from: b */
    public String f4216b;
    @NotNull

    /* renamed from: c */
    public String f4217c;

    /* renamed from: fr.smoney.android.izly.data.model.AccountStatement$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1692a implements Parcelable.Creator<AccountStatement> {
        public C1692a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public AccountStatement createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new AccountStatement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AccountStatement[] newArray(int i) {
            return new AccountStatement[i];
        }
    }

    public AccountStatement() {
        this.f4215a = "";
        this.f4216b = "";
        this.f4217c = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "dest");
        parcel.writeString(this.f4215a);
        parcel.writeString(this.f4216b);
        parcel.writeString(this.f4217c);
    }

    public AccountStatement(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        this.f4215a = "";
        this.f4216b = "";
        this.f4217c = "";
        this.f4215a = String.valueOf(parcel.readString());
        this.f4216b = String.valueOf(parcel.readString());
        this.f4217c = String.valueOf(parcel.readString());
    }
}
