package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import fr.smoney.android.izly.data.model.NewsFeedItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class NewsFeedItemTransaction extends NewsFeedItem {
    @NotNull
    public static final C1747a CREATOR = new C1747a(null);

    /* renamed from: o */
    public Transaction f4527o;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedItemTransaction$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1747a implements Parcelable.Creator<NewsFeedItemTransaction> {
        public C1747a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedItemTransaction createFromParcel(Parcel parcel) {
            C0581Yd.m1766e(parcel, "parcel");
            return new NewsFeedItemTransaction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedItemTransaction[] newArray(int i) {
            return new NewsFeedItemTransaction[i];
        }
    }

    public NewsFeedItemTransaction() {
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    @NotNull
    /* renamed from: b */
    public String mo963b(@NotNull Context context, @Nullable String str) {
        C0581Yd.m1766e(context, "context");
        NewsFeedItem.EnumC1743a enumC1743a = this.f4479g;
        if (enumC1743a != null) {
            switch (enumC1743a.ordinal()) {
                case 0:
                case 5:
                    String string = context.getString(2131689877);
                    C0581Yd.m1767d(string, "context.getString(R.stri….home_news_receive_funds)");
                    return string;
                case 1:
                case 4:
                    String string2 = context.getString(2131690240);
                    C0581Yd.m1767d(string2, "context.getString(R.stri…nsaction_news_send_funds)");
                    return outline.m254q(new Object[]{str}, 1, string2, "java.lang.String.format(format, *args)");
                case 2:
                    String string3 = context.getString(2131690239);
                    C0581Yd.m1767d(string3, "context.getString(R.stri…ction_news_feed_money_in)");
                    return outline.m254q(new Object[]{str}, 1, string3, "java.lang.String.format(format, *args)");
                case 3:
                    String string4 = context.getString(2131689856);
                    C0581Yd.m1767d(string4, "context.getString(R.stri…home_news_feed_money_out)");
                    return string4;
                case 6:
                    String string5 = context.getString(2131689872);
                    C0581Yd.m1767d(string5, "context.getString(R.string.home_news_feed_refund)");
                    return string5;
                case 7:
                    String string6 = context.getString(2131689842);
                    C0581Yd.m1767d(string6, "context.getString(R.string.home_news_e_commerce)");
                    return string6;
                case 8:
                    String string7 = context.getString(2131689876);
                    C0581Yd.m1767d(string7, "context.getString(R.string.home_news_kiosk)");
                    return string7;
                case 9:
                    String string8 = context.getString(2131689850);
                    C0581Yd.m1767d(string8, "context.getString(R.string.home_news_feed_fee)");
                    return string8;
                case 10:
                    String string9 = context.getString(2131689854);
                    C0581Yd.m1767d(string9, "context.getString(R.stri…ews_feed_money_in_refund)");
                    return string9;
                case 11:
                    String string10 = context.getString(2131689857);
                    C0581Yd.m1767d(string10, "context.getString(R.stri…e_news_feed_money_refund)");
                    return string10;
                case 12:
                    String string11 = context.getString(2131689851);
                    C0581Yd.m1767d(string11, "context.getString(R.stri…ome_news_feed_fee_refund)");
                    return string11;
                case 13:
                    Transaction transaction = this.f4527o;
                    if (transaction != null) {
                        int ordinal = transaction.f4640t.ordinal();
                        String string12 = context.getString(ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? 2131689798 : 2131689797 : 2131689794 : 2131689796 : 2131689793 : 2131689795);
                        C0581Yd.m1767d(string12, "context.getString(getAchatMessage())");
                        return string12;
                    }
                    C0581Yd.m1761j("mTransaction");
                    throw null;
                case 14:
                    String string13 = context.getString(2131689860);
                    C0581Yd.m1767d(string13, "context.getString(R.stri…me_news_feed_pay_in_card)");
                    return string13;
                case 15:
                    String string14 = context.getString(2131689861);
                    C0581Yd.m1767d(string14, "context.getString(R.stri…_feed_pay_in_card_refund)");
                    return string14;
                case 16:
                    String string15 = context.getString(2131690238);
                    C0581Yd.m1767d(string15, "context.getString(R.stri…ews_feed_in_bank_account)");
                    return outline.m254q(new Object[]{str}, 1, string15, "java.lang.String.format(format, *args)");
            }
        }
        String string16 = context.getString(2131689859);
        C0581Yd.m1767d(string16, "context.getString(R.string.home_news_feed_other)");
        return string16;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    @Nullable
    /* renamed from: c */
    public Spanned mo962c(@Nullable Context context, @Nullable String str) {
        String m965d = m965d(context, str, this.f4474a);
        C0581Yd.m1767d(m965d, "price");
        C0581Yd.m1766e(m965d, "$this$replace");
        C0581Yd.m1766e("€", "oldValue");
        C0581Yd.m1766e("", "newValue");
        int m755b = C1880he.m755b(m965d, "€", 0, false);
        if (m755b >= 0) {
            int length = (m965d.length() - 1) + 0;
            if (length >= 0) {
                StringBuilder sb = new StringBuilder(length);
                int i = 0;
                do {
                    sb.append((CharSequence) m965d, i, m755b);
                    sb.append("");
                    i = m755b + 1;
                    if (m755b >= m965d.length()) {
                        break;
                    }
                    m755b = C1880he.m755b(m965d, "€", m755b + 1, false);
                } while (m755b > 0);
                sb.append((CharSequence) m965d, i, m965d.length());
                m965d = sb.toString();
                C0581Yd.m1767d(m965d, "stringBuilder.append(this, i, length).toString()");
            } else {
                throw new OutOfMemoryError();
            }
        }
        int i2 = this.f4476c;
        if (i2 == 2131099779) {
            m965d = outline.m265f("<font color=\"#000000\">-", m965d, "</font>");
        } else if (i2 == 2131099789) {
            m965d = outline.m265f("<font color=\"#0087B0\">+", m965d, "</font>");
        }
        return Html.fromHtml(m965d);
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    @NotNull
    /* renamed from: g */
    public final Transaction m964g() {
        Transaction transaction = this.f4527o;
        if (transaction != null) {
            return transaction;
        }
        C0581Yd.m1761j("mTransaction");
        throw null;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "parcel");
        super.writeToParcel(parcel, i);
    }

    public NewsFeedItemTransaction(@NotNull Parcel parcel) {
        C0581Yd.m1766e(parcel, "parcel");
    }
}
