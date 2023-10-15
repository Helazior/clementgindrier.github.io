package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import java.util.Locale;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedCommissionOrPass extends NewsFeedItem {
    public static final Parcelable.Creator<NewsFeedCommissionOrPass> CREATOR = new C1740a();

    /* renamed from: o */
    public double f4464o;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedCommissionOrPass$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1740a implements Parcelable.Creator<NewsFeedCommissionOrPass> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedCommissionOrPass createFromParcel(Parcel parcel) {
            return new NewsFeedCommissionOrPass(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedCommissionOrPass[] newArray(int i) {
            return new NewsFeedCommissionOrPass[i];
        }
    }

    public NewsFeedCommissionOrPass() {
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        int ordinal = this.f4479g.ordinal();
        return Html.fromHtml(context.getString(ordinal != 9 ? ordinal != 12 ? ordinal != 13 ? -1 : 2131689843 : 2131689847 : 2131689846, String.format(Locale.getDefault(), "%1$.2f%2$s", Double.valueOf(this.f4464o), str))).toString();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: c */
    public Spanned mo962c(Context context, String str) {
        return null;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: e */
    public void mo961e(Parcel parcel) {
        super.mo961e(parcel);
        this.f4464o = parcel.readDouble();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f4464o);
    }

    public NewsFeedCommissionOrPass(Parcel parcel) {
        mo961e(parcel);
    }
}
