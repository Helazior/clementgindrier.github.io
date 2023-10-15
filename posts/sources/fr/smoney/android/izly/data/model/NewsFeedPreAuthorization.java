package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedPreAuthorization extends NewsFeedItem {
    public static final Parcelable.Creator<NewsFeedPreAuthorization> CREATOR = new C1751a();

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedPreAuthorization$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1751a implements Parcelable.Creator<NewsFeedPreAuthorization> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedPreAuthorization createFromParcel(Parcel parcel) {
            return new NewsFeedPreAuthorization(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedPreAuthorization[] newArray(int i) {
            return new NewsFeedPreAuthorization[i];
        }
    }

    public NewsFeedPreAuthorization(Parcel parcel) {
        mo961e(parcel);
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        return Html.fromHtml(context.getString(2131689870, this.f4480h.f4466b)).toString();
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
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
