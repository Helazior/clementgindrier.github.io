package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedMoneyDemandFeedItem extends NewsFeedPaymentFeedItem {
    public static final Parcelable.Creator<NewsFeedMoneyDemandFeedItem> CREATOR = new C1748a();

    /* renamed from: r */
    public int f4528r;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedMoneyDemandFeedItem$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1748a implements Parcelable.Creator<NewsFeedMoneyDemandFeedItem> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedMoneyDemandFeedItem createFromParcel(Parcel parcel) {
            return new NewsFeedMoneyDemandFeedItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedMoneyDemandFeedItem[] newArray(int i) {
            return new NewsFeedMoneyDemandFeedItem[i];
        }
    }

    public NewsFeedMoneyDemandFeedItem() {
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem, fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        boolean z = this.f4480h.f4468d;
        String m965d = m965d(context, str, this.f4530o);
        if (this.f4528r == 1) {
            return m965d == null ? Html.fromHtml(context.getString(2131689866, this.f4480h.f4466b, m965d)).toString() : Html.fromHtml(context.getString(2131689865, this.f4480h.f4466b, m965d)).toString();
        } else if (m965d == null) {
            Resources resources = context.getResources();
            int i = this.f4528r;
            return Html.fromHtml(resources.getQuantityString(2131623937, i - 1, this.f4480h.f4466b, Integer.valueOf(i - 1))).toString();
        } else {
            Resources resources2 = context.getResources();
            int i2 = this.f4528r;
            return Html.fromHtml(resources2.getQuantityString(2131623936, i2 - 1, this.f4480h.f4466b, m965d, Integer.valueOf(i2 - 1))).toString();
        }
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem, fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: e */
    public void mo961e(Parcel parcel) {
        super.mo961e(parcel);
        this.f4528r = parcel.readInt();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem, fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f4528r);
    }

    public NewsFeedMoneyDemandFeedItem(Parcel parcel) {
        super(parcel);
    }
}
