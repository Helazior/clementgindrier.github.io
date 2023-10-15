package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.data.model.NewsFeedChatItem;
import fr.smoney.android.izly.data.model.NewsFeedCommissionOrPass;
import fr.smoney.android.izly.data.model.NewsFeedItem;
import fr.smoney.android.izly.data.model.NewsFeedItemTransaction;
import fr.smoney.android.izly.data.model.NewsFeedMoneyOperationFeedItem;
import fr.smoney.android.izly.data.model.NewsFeedPreAuthorization;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Pc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0360Pc extends RecyclerView.AbstractC0832g<C0361a> {

    /* renamed from: a */
    public AbstractC0068Cb f1238a;

    /* renamed from: b */
    public List<NewsFeedItem> f1239b;

    /* renamed from: c */
    public final C0479U8 f1240c;

    /* renamed from: d */
    public final Context f1241d;

    /* renamed from: Pc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0361a extends RecyclerView.AbstractC0824B {
        @Nullable

        /* renamed from: a */
        public AbstractC0068Cb f1242a;
        @NotNull

        /* renamed from: b */
        public Context f1243b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0361a(@Nullable AbstractC0068Cb abstractC0068Cb, @NotNull Context context) {
            super(abstractC0068Cb.getRoot());
            C0581Yd.m1766e(context, "mContext");
            C0581Yd.m1768c(abstractC0068Cb);
            this.f1242a = abstractC0068Cb;
            this.f1243b = context;
        }
    }

    public C0360Pc(@NotNull C0479U8 c0479u8, @NotNull Context context) {
        C0581Yd.m1766e(c0479u8, "mMemoryProvider");
        C0581Yd.m1766e(context, "context");
        this.f1240c = c0479u8;
        this.f1241d = context;
        this.f1239b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f1239b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(C0361a c0361a, int i) {
        String str;
        NewsFeedItem.EnumC1743a enumC1743a;
        NewsFeedItem.EnumC1743a enumC1743a2;
        NewsFeedItemTransaction newsFeedItemTransaction;
        C0361a c0361a2 = c0361a;
        C0581Yd.m1766e(c0361a2, "holder");
        NewsFeedItem newsFeedItem = this.f1239b.get(i);
        C0479U8 c0479u8 = this.f1240c;
        NewsFeedItem.EnumC1743a enumC1743a3 = NewsFeedItem.EnumC1743a.MONEY_IN_BANK_ACCOUNT;
        NewsFeedItem.EnumC1743a enumC1743a4 = NewsFeedItem.EnumC1743a.TYPE_MONEY_IN_CB;
        NewsFeedItem.EnumC1743a enumC1743a5 = NewsFeedItem.EnumC1743a.TYPE_P2P_PAY_REQUEST;
        NewsFeedItem.EnumC1743a enumC1743a6 = NewsFeedItem.EnumC1743a.TYPE_P2P_PAY_OUT;
        C0581Yd.m1766e(newsFeedItem, "newsFeed");
        C0581Yd.m1766e(c0479u8, "mMemoryProvider");
        try {
            str = Currency.getInstance(c0479u8.f1712b.f4371k).getSymbol(Locale.FRANCE);
        } catch (NullPointerException unused) {
            str = ";-";
        }
        NewsFeedItem.EnumC1745c enumC1745c = newsFeedItem.f4482j;
        NewsFeedItem.EnumC1745c enumC1745c2 = NewsFeedItem.EnumC1745c.InDirection;
        if (enumC1745c == enumC1745c2) {
            newsFeedItem.f4476c = 2131099789;
        } else {
            newsFeedItem.f4476c = 2131099779;
        }
        Resources resources = c0361a2.f1243b.getResources();
        String str2 = null;
        if (newsFeedItem instanceof NewsFeedChatItem) {
            AbstractC0068Cb abstractC0068Cb = c0361a2.f1242a;
            C0581Yd.m1768c(abstractC0068Cb);
            abstractC0068Cb.f300a.setImageDrawable(resources.getDrawable(2131230962));
            AbstractC0068Cb abstractC0068Cb2 = c0361a2.f1242a;
            C0581Yd.m1768c(abstractC0068Cb2);
            CustomFontTextView customFontTextView = abstractC0068Cb2.f303d;
            C0581Yd.m1767d(customFontTextView, "binding!!.tvNewsFeedMessage");
            NewsFeedChatItem newsFeedChatItem = (NewsFeedChatItem) newsFeedItem;
            Context context = c0361a2.f1243b;
            NewsFeedItem.EnumC1745c enumC1745c3 = newsFeedChatItem.f4463o;
            if (enumC1745c3 == enumC1745c2) {
                str2 = context.getString(2131689844, newsFeedChatItem.f4480h.f4466b);
            } else if (enumC1745c3 == NewsFeedItem.EnumC1745c.OutDirection) {
                str2 = context.getString(2131689845, newsFeedChatItem.f4480h.f4466b);
            }
            customFontTextView.setText(Html.fromHtml(str2));
            AbstractC0068Cb abstractC0068Cb3 = c0361a2.f1242a;
            C0581Yd.m1768c(abstractC0068Cb3);
            CustomFontTextView customFontTextView2 = abstractC0068Cb3.f302c;
            C0581Yd.m1767d(customFontTextView2, "binding!!.tvNewsFeedDate");
            Context context2 = c0361a2.f1243b;
            Long l = newsFeedItem.f4481i;
            C0581Yd.m1767d(l, "item.mDateTime");
            customFontTextView2.setText(C0278Ld.m2216b(context2, l.longValue()));
            return;
        }
        boolean z = newsFeedItem instanceof NewsFeedMoneyOperationFeedItem;
        if (!z && !(newsFeedItem instanceof NewsFeedItemTransaction)) {
            if (newsFeedItem instanceof NewsFeedCommissionOrPass) {
                AbstractC0068Cb abstractC0068Cb4 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb4);
                CustomFontTextView customFontTextView3 = abstractC0068Cb4.f303d;
                C0581Yd.m1767d(customFontTextView3, "binding!!.tvNewsFeedMessage");
                customFontTextView3.setText(newsFeedItem.mo963b(c0361a2.f1243b, str));
                AbstractC0068Cb abstractC0068Cb5 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb5);
                CustomFontTextView customFontTextView4 = abstractC0068Cb5.f302c;
                C0581Yd.m1767d(customFontTextView4, "binding!!.tvNewsFeedDate");
                Context context3 = c0361a2.f1243b;
                Long l2 = newsFeedItem.f4481i;
                C0581Yd.m1767d(l2, "newsFeed.mDateTime");
                customFontTextView4.setText(C0278Ld.m2216b(context3, l2.longValue()));
                return;
            } else if (newsFeedItem instanceof NewsFeedPreAuthorization) {
                AbstractC0068Cb abstractC0068Cb6 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb6);
                CustomFontTextView customFontTextView5 = abstractC0068Cb6.f303d;
                C0581Yd.m1767d(customFontTextView5, "binding!!.tvNewsFeedMessage");
                customFontTextView5.setText(newsFeedItem.mo963b(c0361a2.f1243b, str));
                AbstractC0068Cb abstractC0068Cb7 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb7);
                CustomFontTextView customFontTextView6 = abstractC0068Cb7.f302c;
                C0581Yd.m1767d(customFontTextView6, "binding!!.tvNewsFeedDate");
                Context context4 = c0361a2.f1243b;
                Long l3 = newsFeedItem.f4481i;
                C0581Yd.m1767d(l3, "newsFeed.mDateTime");
                customFontTextView6.setText(C0278Ld.m2216b(context4, l3.longValue()));
                return;
            } else {
                return;
            }
        }
        if (z) {
            AbstractC0068Cb abstractC0068Cb8 = c0361a2.f1242a;
            C0581Yd.m1768c(abstractC0068Cb8);
            CustomFontTextView customFontTextView7 = abstractC0068Cb8.f303d;
            C0581Yd.m1767d(customFontTextView7, "binding!!.tvNewsFeedMessage");
            customFontTextView7.setText(newsFeedItem.mo963b(c0361a2.f1243b, null));
            AbstractC0068Cb abstractC0068Cb9 = c0361a2.f1242a;
            C0581Yd.m1768c(abstractC0068Cb9);
            CustomFontTextView customFontTextView8 = abstractC0068Cb9.f302c;
            C0581Yd.m1767d(customFontTextView8, "binding!!.tvNewsFeedDate");
            Context context5 = c0361a2.f1243b;
            Long l4 = newsFeedItem.f4481i;
            C0581Yd.m1767d(l4, "item.mDateTime");
            customFontTextView8.setText(C0278Ld.m2216b(context5, l4.longValue()));
            newsFeedItemTransaction = newsFeedItem;
            enumC1743a = enumC1743a5;
            enumC1743a2 = enumC1743a6;
        } else {
            NewsFeedItemTransaction newsFeedItemTransaction2 = (NewsFeedItemTransaction) newsFeedItem;
            NewsFeedItem.EnumC1743a enumC1743a7 = newsFeedItemTransaction2.f4479g;
            if (enumC1743a7 == enumC1743a6 || enumC1743a7 == enumC1743a5) {
                AbstractC0068Cb abstractC0068Cb10 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb10);
                CustomFontTextView customFontTextView9 = abstractC0068Cb10.f303d;
                C0581Yd.m1767d(customFontTextView9, "binding!!.tvNewsFeedMessage");
                customFontTextView9.setText(newsFeedItemTransaction2.mo963b(c0361a2.f1243b, newsFeedItemTransaction2.m964g().f4638r));
            } else if (enumC1743a7 != enumC1743a4 && enumC1743a7 != enumC1743a3) {
                AbstractC0068Cb abstractC0068Cb11 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb11);
                CustomFontTextView customFontTextView10 = abstractC0068Cb11.f303d;
                C0581Yd.m1767d(customFontTextView10, "binding!!.tvNewsFeedMessage");
                customFontTextView10.setText(newsFeedItemTransaction2.mo963b(c0361a2.f1243b, null));
            } else {
                AbstractC0068Cb abstractC0068Cb12 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb12);
                CustomFontTextView customFontTextView11 = abstractC0068Cb12.f303d;
                C0581Yd.m1767d(customFontTextView11, "binding!!.tvNewsFeedMessage");
                customFontTextView11.setText(newsFeedItemTransaction2.mo963b(c0361a2.f1243b, newsFeedItemTransaction2.m964g().f4636p));
            }
            if (!newsFeedItemTransaction2.m964g().f4620A.isEmpty()) {
                AbstractC0068Cb abstractC0068Cb13 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb13);
                CustomFontTextView customFontTextView12 = abstractC0068Cb13.f302c;
                C0581Yd.m1767d(customFontTextView12, "binding!!.tvNewsFeedDate");
                String string = c0361a2.f1243b.getString(2131689858);
                C0581Yd.m1767d(string, "mContext.getString(R.str…g.home_news_feed_offline)");
                Context context6 = c0361a2.f1243b;
                Long l5 = newsFeedItemTransaction2.f4481i;
                C0581Yd.m1767d(l5, "item.mDateTime");
                enumC1743a = enumC1743a5;
                enumC1743a2 = enumC1743a6;
                String format = String.format(string, Arrays.copyOf(new Object[]{C0278Ld.m2216b(context6, l5.longValue()), newsFeedItemTransaction2.m964g().f4620A.get(0).f4661d}, 2));
                C0581Yd.m1767d(format, "java.lang.String.format(format, *args)");
                customFontTextView12.setText(format);
                newsFeedItemTransaction = newsFeedItemTransaction2;
            } else {
                enumC1743a = enumC1743a5;
                enumC1743a2 = enumC1743a6;
                AbstractC0068Cb abstractC0068Cb14 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb14);
                CustomFontTextView customFontTextView13 = abstractC0068Cb14.f302c;
                C0581Yd.m1767d(customFontTextView13, "binding!!.tvNewsFeedDate");
                Context context7 = c0361a2.f1243b;
                Long l6 = newsFeedItemTransaction2.f4481i;
                C0581Yd.m1767d(l6, "item.mDateTime");
                customFontTextView13.setText(C0278Ld.m2216b(context7, l6.longValue()));
                newsFeedItemTransaction = newsFeedItemTransaction2;
            }
        }
        AbstractC0068Cb abstractC0068Cb15 = c0361a2.f1242a;
        C0581Yd.m1768c(abstractC0068Cb15);
        CustomFontTextView customFontTextView14 = abstractC0068Cb15.f304f;
        C0581Yd.m1767d(customFontTextView14, "binding!!.tvNewsFeedValue");
        customFontTextView14.setText(newsFeedItemTransaction.mo962c(c0361a2.f1243b, str));
        AbstractC0068Cb abstractC0068Cb16 = c0361a2.f1242a;
        C0581Yd.m1768c(abstractC0068Cb16);
        abstractC0068Cb16.f301b.setTextColor(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
        NewsFeedItem.EnumC1743a enumC1743a8 = newsFeedItemTransaction.f4479g;
        if (enumC1743a8 != NewsFeedItem.EnumC1743a.TYPE_PAY_IN && enumC1743a8 != enumC1743a4 && enumC1743a8 != enumC1743a3) {
            if (enumC1743a8 == NewsFeedItem.EnumC1743a.TYPE_MONEY_OUT_TRANSFER) {
                AbstractC0068Cb abstractC0068Cb17 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb17);
                abstractC0068Cb17.f300a.setImageDrawable(resources.getDrawable(2131230933, null));
                AbstractC0068Cb abstractC0068Cb18 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb18);
                abstractC0068Cb18.f300a.setColorFilter(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
                return;
            } else if (enumC1743a8 != enumC1743a2 && enumC1743a8 != enumC1743a) {
                if (enumC1743a8 == NewsFeedItem.EnumC1743a.TYPE_ECOMMERCE) {
                    AbstractC0068Cb abstractC0068Cb19 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb19);
                    abstractC0068Cb19.f300a.setImageDrawable(resources.getDrawable(2131231027, null));
                    AbstractC0068Cb abstractC0068Cb20 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb20);
                    abstractC0068Cb20.f300a.setColorFilter(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
                    return;
                } else if (enumC1743a8 == NewsFeedItem.EnumC1743a.TYPE_DISTRIBUTOR) {
                    AbstractC0068Cb abstractC0068Cb21 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb21);
                    abstractC0068Cb21.f300a.setImageDrawable(resources.getDrawable(2131230934, null));
                    AbstractC0068Cb abstractC0068Cb22 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb22);
                    abstractC0068Cb22.f300a.setColorFilter(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
                    return;
                } else if (enumC1743a8 != NewsFeedItem.EnumC1743a.TYPE_P2P_PAY_IN && enumC1743a8 != NewsFeedItem.EnumC1743a.TYPE_P2P_GET) {
                    AbstractC0068Cb abstractC0068Cb23 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb23);
                    abstractC0068Cb23.f300a.setImageDrawable(resources.getDrawable(2131230960, null));
                    AbstractC0068Cb abstractC0068Cb24 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb24);
                    ImageView imageView = abstractC0068Cb24.f300a;
                    C0581Yd.m1767d(imageView, "binding!!.aivNewsFeedRecipientPhoto");
                    imageView.setColorFilter((ColorFilter) null);
                    return;
                } else {
                    AbstractC0068Cb abstractC0068Cb25 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb25);
                    abstractC0068Cb25.f300a.setImageDrawable(resources.getDrawable(2131230947, null));
                    AbstractC0068Cb abstractC0068Cb26 = c0361a2.f1242a;
                    C0581Yd.m1768c(abstractC0068Cb26);
                    abstractC0068Cb26.f300a.setColorFilter(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
                    return;
                }
            } else {
                AbstractC0068Cb abstractC0068Cb27 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb27);
                abstractC0068Cb27.f300a.setImageDrawable(resources.getDrawable(2131230937, null));
                AbstractC0068Cb abstractC0068Cb28 = c0361a2.f1242a;
                C0581Yd.m1768c(abstractC0068Cb28);
                abstractC0068Cb28.f300a.setColorFilter(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
                return;
            }
        }
        AbstractC0068Cb abstractC0068Cb29 = c0361a2.f1242a;
        C0581Yd.m1768c(abstractC0068Cb29);
        abstractC0068Cb29.f300a.setImageDrawable(resources.getDrawable(2131230953, null));
        AbstractC0068Cb abstractC0068Cb30 = c0361a2.f1242a;
        C0581Yd.m1768c(abstractC0068Cb30);
        abstractC0068Cb30.f300a.setColorFilter(C0103E3.m2469a(resources, newsFeedItem.f4476c, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public C0361a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        this.f1238a = (AbstractC0068Cb) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), 2131492982, viewGroup, false);
        return new C0361a(this.f1238a, this.f1241d);
    }
}
