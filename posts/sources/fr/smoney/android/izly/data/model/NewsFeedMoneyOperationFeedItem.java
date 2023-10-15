package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedMoneyOperationFeedItem extends NewsFeedItem {
    public static final Parcelable.Creator<NewsFeedMoneyOperationFeedItem> CREATOR = new C1749a();

    /* renamed from: o */
    public double f4529o;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedMoneyOperationFeedItem$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1749a implements Parcelable.Creator<NewsFeedMoneyOperationFeedItem> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedMoneyOperationFeedItem createFromParcel(Parcel parcel) {
            return new NewsFeedMoneyOperationFeedItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedMoneyOperationFeedItem[] newArray(int i) {
            return new NewsFeedMoneyOperationFeedItem[i];
        }
    }

    public NewsFeedMoneyOperationFeedItem() {
        this.f4529o = -1.0d;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        m965d(context, str, this.f4529o);
        switch (this.f4479g.ordinal()) {
            case 0:
            case 5:
                return context.getString(2131689877);
            case 1:
            case 4:
                return context.getString(2131689856);
            case 2:
                return context.getString(2131689853);
            case 3:
                return context.getString(2131689856);
            case 6:
                return context.getString(2131689872);
            case 7:
                return context.getString(2131689842);
            case 8:
                return context.getString(2131689876);
            case 9:
                return context.getString(2131689850);
            case 10:
                return context.getString(2131689854);
            case 11:
                return context.getString(2131689857);
            case 12:
                return context.getString(2131689851);
            case 13:
            default:
                return context.getString(2131689859);
            case 14:
                return context.getString(2131689860);
            case 15:
                return context.getString(2131689861);
            case 16:
                context.getString(2131689852);
                return "";
        }
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: c */
    public Spanned mo962c(Context context, String str) {
        String m265f;
        String replace = m965d(context, str, this.f4529o).replace("€", "");
        int ordinal = this.f4479g.ordinal();
        if (ordinal != 1 && ordinal != 2 && ordinal != 5 && ordinal != 6 && ordinal != 8 && ordinal != 10 && ordinal != 11 && ordinal != 14 && ordinal != 15) {
            m265f = outline.m265f("<font color=\"#000000\">-", replace, "</font>");
        } else {
            m265f = outline.m265f("<font color=\"#0087B0\">+", replace, "</font>");
        }
        return Html.fromHtml(m265f);
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: e */
    public void mo961e(Parcel parcel) {
        super.mo961e(parcel);
        this.f4529o = parcel.readDouble();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f4529o);
    }

    public NewsFeedMoneyOperationFeedItem(Parcel parcel) {
        mo961e(parcel);
        this.f4529o = -1.0d;
    }
}
