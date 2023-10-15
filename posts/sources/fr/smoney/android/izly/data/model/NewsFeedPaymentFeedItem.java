package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedPaymentFeedItem extends NewsFeedItem {
    public static final Parcelable.Creator<NewsFeedPaymentFeedItem> CREATOR = new C1750a();

    /* renamed from: o */
    public double f4530o;

    /* renamed from: p */
    public boolean f4531p;

    /* renamed from: q */
    public boolean f4532q;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1750a implements Parcelable.Creator<NewsFeedPaymentFeedItem> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedPaymentFeedItem createFromParcel(Parcel parcel) {
            return new NewsFeedPaymentFeedItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedPaymentFeedItem[] newArray(int i) {
            return new NewsFeedPaymentFeedItem[i];
        }
    }

    public NewsFeedPaymentFeedItem() {
        this.f4530o = -1.0d;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        boolean z = this.f4480h.f4468d;
        String m965d = m965d(context, str, this.f4530o);
        int ordinal = this.f4479g.ordinal();
        int i = 2131689863;
        if (ordinal == 0) {
            i = 2131689862;
        } else if (ordinal != 1) {
            if (ordinal == 4) {
                i = m965d == null ? 2131689869 : 2131689868;
            } else if (ordinal == 6) {
                i = 2131689867;
            } else if (ordinal != 8) {
                i = -1;
            }
        } else if (this.f4480h.f4468d) {
            i = 2131689864;
        }
        return Html.fromHtml(context.getString(i, this.f4480h.f4466b, m965d)).toString();
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
        this.f4530o = parcel.readDouble();
        this.f4531p = parcel.readInt() == 1;
        this.f4532q = parcel.readInt() == 1;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f4530o);
        parcel.writeInt(this.f4531p ? 1 : 0);
        parcel.writeInt(this.f4532q ? 1 : 0);
    }

    public NewsFeedPaymentFeedItem(Parcel parcel) {
        mo961e(parcel);
        this.f4530o = -1.0d;
    }
}
