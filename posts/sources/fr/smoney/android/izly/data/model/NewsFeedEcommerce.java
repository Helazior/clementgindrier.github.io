package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedEcommerce extends NewsFeedPaymentFeedItem {
    public static final Parcelable.Creator<NewsFeedPaymentFeedItem> CREATOR = new C1742a();

    /* renamed from: r */
    public String f4469r;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedEcommerce$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1742a implements Parcelable.Creator<NewsFeedPaymentFeedItem> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedPaymentFeedItem createFromParcel(Parcel parcel) {
            return new NewsFeedEcommerce(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedPaymentFeedItem[] newArray(int i) {
            return new NewsFeedEcommerce[i];
        }
    }

    public NewsFeedEcommerce() {
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem, fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        boolean z = this.f4480h.f4468d;
        return Html.fromHtml(context.getString(this.f4479g.ordinal() != 7 ? -1 : 2131689848, this.f4480h.f4466b, m965d(context, str, this.f4530o))).toString();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem, fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: e */
    public void mo961e(Parcel parcel) {
        super.mo961e(parcel);
        this.f4469r = parcel.readString();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem, fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4469r);
    }

    public NewsFeedEcommerce(Parcel parcel) {
        super(parcel);
    }
}
