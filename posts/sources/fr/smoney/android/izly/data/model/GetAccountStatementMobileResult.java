package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class GetAccountStatementMobileResult implements Parcelable {
    @NotNull
    public static final C1711a CREATOR = new C1711a(null);

    /* renamed from: a */
    public AccountStatement f4273a;

    /* renamed from: fr.smoney.android.izly.data.model.GetAccountStatementMobileResult$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1711a implements Parcelable.Creator<GetAccountStatementMobileResult> {
        public C1711a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public GetAccountStatementMobileResult createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new GetAccountStatementMobileResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetAccountStatementMobileResult[] newArray(int i) {
            return new GetAccountStatementMobileResult[i];
        }
    }

    public GetAccountStatementMobileResult() {
    }

    @NotNull
    /* renamed from: a */
    public final AccountStatement m972a() {
        AccountStatement accountStatement = this.f4273a;
        if (accountStatement != null) {
            return accountStatement;
        }
        C0581Yd.m1761j("accountStatement");
        throw null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            AccountStatement accountStatement = this.f4273a;
            if (accountStatement != null) {
                parcel.writeParcelable(accountStatement, 1);
            } else {
                C0581Yd.m1761j("accountStatement");
                throw null;
            }
        }
    }

    public GetAccountStatementMobileResult(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
        AccountStatement accountStatement = this.f4273a;
        if (accountStatement != null) {
            String valueOf = String.valueOf(parcel.readString());
            C0581Yd.m1766e(valueOf, "<set-?>");
            accountStatement.f4217c = valueOf;
            return;
        }
        C0581Yd.m1761j("accountStatement");
        throw null;
    }
}
