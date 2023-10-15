package p000;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.BalanceData;
import fr.smoney.android.izly.data.model.CounterListData;
import fr.smoney.android.izly.data.model.GetNewsFeedData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.NewsFeedItem;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.privateview.useraccount.PreMyAccountDetailsActivity;
import fr.smoney.android.izly.p005ui.widget.CustomEmptyView;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: a */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC0599a extends AbstractC0044B8<AbstractC1897ib> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, SwipeRefreshLayout.InterfaceC0875h {

    /* renamed from: j */
    public C0479U8 f2121j;

    /* renamed from: k */
    public EnumC2029od f2122k;

    /* renamed from: l */
    public C0341Oc f2123l;

    /* renamed from: m */
    public boolean f2124m;

    /* renamed from: n */
    public SessionStateReceiver f2125n;

    /* compiled from: java-style lambda group */
    /* renamed from: a$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnClickListenerC0600a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f2126a;

        /* renamed from: b */
        public final /* synthetic */ Object f2127b;

        public View$OnClickListenerC0600a(int i, Object obj) {
            this.f2126a = i;
            this.f2127b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f2126a;
            if (i == 0) {
                View$OnClickListenerC0599a.m1733x((View$OnClickListenerC0599a) this.f2127b, 1, C0441Sd.m2036a(0, 2));
                View$OnClickListenerC0599a.m1734w((View$OnClickListenerC0599a) this.f2127b, EnumC2029od.RECHARGE);
            } else if (i == 1) {
                View$OnClickListenerC0599a.m1733x((View$OnClickListenerC0599a) this.f2127b, 2, C0441Sd.m2036a(0, 1));
                View$OnClickListenerC0599a.m1734w((View$OnClickListenerC0599a) this.f2127b, EnumC2029od.TRANSFER);
            } else if (i == 2) {
                View$OnClickListenerC0599a.m1733x((View$OnClickListenerC0599a) this.f2127b, 0, C0441Sd.m2036a(1, 2));
                View$OnClickListenerC0599a.m1734w((View$OnClickListenerC0599a) this.f2127b, EnumC2029od.PAYMENT);
            } else {
                throw null;
            }
        }
    }

    /* renamed from: a$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0601b implements InterfaceC1879hd {
        public C0601b() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                View$OnClickListenerC0599a.this.m1731z();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00aa -> B:52:0x00ad). Please submit an issue!!! */
    /* renamed from: w */
    public static final void m1734w(View$OnClickListenerC0599a view$OnClickListenerC0599a, EnumC2029od enumC2029od) {
        List<NewsFeedItem> list;
        List<NewsFeedItem> list2;
        List<NewsFeedItem> list3;
        RecyclerView recyclerView = ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5295i;
        C0581Yd.m1767d(recyclerView, "mDataBinding.lvHomeNewsFeed");
        recyclerView.setVisibility(0);
        ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5295i.setHasFixedSize(true);
        RecyclerView recyclerView2 = ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5295i;
        C0581Yd.m1767d(recyclerView2, "mDataBinding.lvHomeNewsFeed");
        recyclerView2.setAdapter(view$OnClickListenerC0599a.f2123l);
        int ordinal = enumC2029od.ordinal();
        if (ordinal == 0) {
            C0479U8 c0479u8 = view$OnClickListenerC0599a.f2121j;
            if (c0479u8 != null) {
                GetNewsFeedData getNewsFeedData = c0479u8.f1708b0;
                if (getNewsFeedData != null && (list = getNewsFeedData.f4341g) != null && !c0479u8.f1757B0) {
                    view$OnClickListenerC0599a.m1737F(list);
                    return;
                }
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        } else if (ordinal == 1) {
            C0479U8 c0479u82 = view$OnClickListenerC0599a.f2121j;
            if (c0479u82 != null) {
                GetNewsFeedData getNewsFeedData2 = c0479u82.f1702X;
                if (getNewsFeedData2 != null && (list2 = getNewsFeedData2.f4341g) != null && !c0479u82.f1758C0) {
                    view$OnClickListenerC0599a.m1737F(list2);
                    return;
                }
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        } else if (ordinal == 2) {
            C0479U8 c0479u83 = view$OnClickListenerC0599a.f2121j;
            if (c0479u83 != null) {
                GetNewsFeedData getNewsFeedData3 = c0479u83.f1704Z;
                if (getNewsFeedData3 != null && (list3 = getNewsFeedData3.f4341g) != null && !c0479u83.f1759D0) {
                    view$OnClickListenerC0599a.m1737F(list3);
                    return;
                }
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        }
        try {
            int ordinal2 = enumC2029od.ordinal();
            if (ordinal2 == 0) {
                EnumC2029od enumC2029od2 = EnumC2029od.RECHARGE;
                view$OnClickListenerC0599a.m1742A(true, enumC2029od2.toString());
                view$OnClickListenerC0599a.f2122k = enumC2029od2;
            } else if (ordinal2 == 1) {
                EnumC2029od enumC2029od3 = EnumC2029od.PAYMENT;
                view$OnClickListenerC0599a.m1742A(true, enumC2029od3.toString());
                view$OnClickListenerC0599a.f2122k = enumC2029od3;
            } else if (ordinal2 == 2) {
                EnumC2029od enumC2029od4 = EnumC2029od.TRANSFER;
                view$OnClickListenerC0599a.m1742A(true, enumC2029od4.toString());
                view$OnClickListenerC0599a.f2122k = enumC2029od4;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    /* renamed from: x */
    public static final void m1733x(View$OnClickListenerC0599a view$OnClickListenerC0599a, int i, List list) {
        Objects.requireNonNull(view$OnClickListenerC0599a);
        if (i == 0) {
            C2294v8.m279B(view$OnClickListenerC0599a, 2131099799, null, ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f656f.f5390a);
            ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f656f.f5391b.setTextColor(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), 2131099799, null));
        } else if (i == 1) {
            C2294v8.m279B(view$OnClickListenerC0599a, 2131099799, null, ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f657g.f5390a);
            ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f657g.f5391b.setTextColor(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), 2131099799, null));
        } else if (i == 2) {
            C2294v8.m279B(view$OnClickListenerC0599a, 2131099799, null, ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f658h.f5390a);
            ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f658h.f5391b.setTextColor(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), 2131099799, null));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (intValue == 0) {
                C2294v8.m279B(view$OnClickListenerC0599a, 2131099684, null, ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f656f.f5390a);
                ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f656f.f5391b.setTextColor(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), 2131099684, null));
            } else if (intValue == 1) {
                C2294v8.m279B(view$OnClickListenerC0599a, 2131099684, null, ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f657g.f5390a);
                ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f657g.f5391b.setTextColor(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), 2131099684, null));
            } else if (intValue == 2) {
                C2294v8.m279B(view$OnClickListenerC0599a, 2131099684, null, ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f658h.f5390a);
                ((AbstractC1897ib) view$OnClickListenerC0599a.f201h).f5290c.f658h.f5391b.setTextColor(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), 2131099684, null));
            }
        }
    }

    /* renamed from: A */
    public final void m1742A(boolean z, String str) {
        int i;
        this.f2124m = z;
        SwipeRefreshLayout swipeRefreshLayout = ((AbstractC1897ib) this.f201h).f5298l;
        C0581Yd.m1767d(swipeRefreshLayout, "mDataBinding.swlHomeNewsFeed");
        swipeRefreshLayout.setRefreshing(true);
        this.f200g.m1683E();
        SmoneyRequestManager smoneyRequestManager = this.f202b.f6817b;
        C0479U8 c0479u8 = this.f2121j;
        if (c0479u8 == null) {
            C0581Yd.m1761j("mMemoryProvider");
            throw null;
        }
        LoginData loginData = c0479u8.f1707b;
        String str2 = loginData.f4380a;
        if (c0479u8 != null) {
            String str3 = loginData.f4382c;
            int size = smoneyRequestManager.f4688a.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 227 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListUserId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListSessionId").equals(str3) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListItem").equals(str)) {
                        i = smoneyRequestManager.f4688a.keyAt(i2);
                        break;
                    }
                    i2++;
                } else {
                    int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                    intent.putExtra("com.foxykeep.datadroid.extras.workerType", 227);
                    intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                    intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                    intent.putExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListUserId", str2);
                    intent.putExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListSessionId", str3);
                    intent.putExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListItem", str);
                    smoneyRequestManager.m956b(intent);
                    smoneyRequestManager.f4688a.append(nextInt, intent);
                    Objects.requireNonNull(smoneyRequestManager.f4693f);
                    C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                    c0479u82.f1703Y = null;
                    c0479u82.f1706a0 = null;
                    c0479u82.f1710c0 = null;
                    i = nextInt;
                    break;
                }
            }
            this.f202b.m120c(i, 227, false);
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }

    /* renamed from: B */
    public final void m1741B(boolean z) {
        Button button = ((AbstractC1897ib) this.f201h).f5289b;
        C0581Yd.m1767d(button, "mDataBinding.btnAdd");
        button.setEnabled(z);
        ImageView imageView = ((AbstractC1897ib) this.f201h).f5294h;
        C0581Yd.m1767d(imageView, "mDataBinding.ivProfileHomepage");
        imageView.setEnabled(z);
        m1736G(z);
        C2294v8.m279B(this, 2131099684, null, ((AbstractC1897ib) this.f201h).f5290c.f656f.f5390a);
        ((AbstractC1897ib) this.f201h).f5290c.f656f.f5391b.setTextColor(C0103E3.m2469a(getResources(), 2131099684, null));
        C2294v8.m279B(this, 2131099684, null, ((AbstractC1897ib) this.f201h).f5290c.f657g.f5390a);
        ((AbstractC1897ib) this.f201h).f5290c.f657g.f5391b.setTextColor(C0103E3.m2469a(getResources(), 2131099684, null));
        C2294v8.m279B(this, 2131099684, null, ((AbstractC1897ib) this.f201h).f5290c.f658h.f5390a);
        ((AbstractC1897ib) this.f201h).f5290c.f658h.f5391b.setTextColor(C0103E3.m2469a(getResources(), 2131099684, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
        if ((r7 == null || r7.isEmpty()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
        if ((r7 == null || r7.isEmpty()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ac, code lost:
        if ((r7 == null || r7.isEmpty()) == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1740C(boolean r7) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnClickListenerC0599a.m1740C(boolean):void");
    }

    /* renamed from: D */
    public final void m1739D(CounterListData counterListData, ServerError serverError) {
        if (serverError != null) {
            this.f202b.m124G(serverError);
        } else if (counterListData == null) {
            this.f202b.m126E(C0580Yc.m1772t(this.f200g, this));
        } else {
            this.f202b.m123H();
        }
    }

    /* renamed from: E */
    public final void m1738E(GetNewsFeedData getNewsFeedData, ServerError serverError) {
        this.f200g.m1683E();
        SwipeRefreshLayout swipeRefreshLayout = ((AbstractC1897ib) this.f201h).f5298l;
        C0581Yd.m1767d(swipeRefreshLayout, "mDataBinding.swlHomeNewsFeed");
        swipeRefreshLayout.setRefreshing(false);
        if (serverError != null) {
            this.f202b.m124G(serverError);
            m1735H(false);
        } else if (getNewsFeedData == null) {
            this.f202b.m126E(C0580Yc.m1772t(this.f200g, this));
            m1735H(false);
        } else {
            if (this.f2124m) {
                C0479U8 c0479u8 = this.f2121j;
                if (c0479u8 != null) {
                    c0479u8.f1759D0 = false;
                    if (c0479u8 != null) {
                        c0479u8.f1757B0 = false;
                        if (c0479u8 != null) {
                            c0479u8.f1758C0 = false;
                        } else {
                            C0581Yd.m1761j("mMemoryProvider");
                            throw null;
                        }
                    } else {
                        C0581Yd.m1761j("mMemoryProvider");
                        throw null;
                    }
                } else {
                    C0581Yd.m1761j("mMemoryProvider");
                    throw null;
                }
            }
            BalanceData balanceData = getNewsFeedData.f4336a;
            if (balanceData != null) {
                C0479U8 c0479u82 = this.f2121j;
                if (c0479u82 == null) {
                    C0581Yd.m1761j("mMemoryProvider");
                    throw null;
                }
                LoginData loginData = c0479u82.f1707b;
                if (loginData != null) {
                    if (c0479u82 != null) {
                        loginData.f4384D = balanceData;
                        this.f202b.m123H();
                    } else {
                        C0581Yd.m1761j("mMemoryProvider");
                        throw null;
                    }
                }
            }
            CountDownTimerC0023A8 countDownTimerC0023A8 = new CountDownTimerC0023A8(this, 60000L, 1000L);
            this.f203i = countDownTimerC0023A8;
            countDownTimerC0023A8.start();
            m1737F(getNewsFeedData.f4341g);
        }
    }

    /* renamed from: F */
    public final void m1737F(List<? extends NewsFeedItem> list) {
        C0341Oc c0341Oc = this.f2123l;
        if (c0341Oc != null) {
            c0341Oc.f1152b.clear();
            c0341Oc.notifyDataSetChanged();
        }
        if (list != null && (!list.isEmpty())) {
            for (NewsFeedItem newsFeedItem : list) {
                C0341Oc c0341Oc2 = this.f2123l;
                if (c0341Oc2 != null) {
                    C0581Yd.m1766e(newsFeedItem, "item");
                    c0341Oc2.f1152b.add(newsFeedItem);
                }
            }
            m1740C(false);
        } else {
            m1735H(false);
        }
        C0341Oc c0341Oc3 = this.f2123l;
        if (c0341Oc3 != null) {
            c0341Oc3.notifyDataSetChanged();
        }
    }

    /* renamed from: G */
    public final void m1736G(boolean z) {
        if (!z) {
            AbstractC1943kb abstractC1943kb = ((AbstractC1897ib) this.f201h).f5290c.f657g;
            C0581Yd.m1767d(abstractC1943kb, "mDataBinding.clButtons.incRecharge");
            abstractC1943kb.getRoot().setOnClickListener(null);
            AbstractC1943kb abstractC1943kb2 = ((AbstractC1897ib) this.f201h).f5290c.f658h;
            C0581Yd.m1767d(abstractC1943kb2, "mDataBinding.clButtons.incTransfer");
            abstractC1943kb2.getRoot().setOnClickListener(null);
            AbstractC1943kb abstractC1943kb3 = ((AbstractC1897ib) this.f201h).f5290c.f656f;
            C0581Yd.m1767d(abstractC1943kb3, "mDataBinding.clButtons.incPayments");
            abstractC1943kb3.getRoot().setOnClickListener(null);
            return;
        }
        AbstractC1943kb abstractC1943kb4 = ((AbstractC1897ib) this.f201h).f5290c.f657g;
        C0581Yd.m1767d(abstractC1943kb4, "mDataBinding.clButtons.incRecharge");
        abstractC1943kb4.getRoot().setOnClickListener(new View$OnClickListenerC0600a(0, this));
        AbstractC1943kb abstractC1943kb5 = ((AbstractC1897ib) this.f201h).f5290c.f658h;
        C0581Yd.m1767d(abstractC1943kb5, "mDataBinding.clButtons.incTransfer");
        abstractC1943kb5.getRoot().setOnClickListener(new View$OnClickListenerC0600a(1, this));
        AbstractC1943kb abstractC1943kb6 = ((AbstractC1897ib) this.f201h).f5290c.f656f;
        C0581Yd.m1767d(abstractC1943kb6, "mDataBinding.clButtons.incPayments");
        abstractC1943kb6.getRoot().setOnClickListener(new View$OnClickListenerC0600a(2, this));
    }

    /* renamed from: H */
    public final void m1735H(boolean z) {
        if (z) {
            RecyclerView recyclerView = ((AbstractC1897ib) this.f201h).f5295i;
            C0581Yd.m1767d(recyclerView, "mDataBinding.lvHomeNewsFeed");
            recyclerView.setVisibility(8);
            View view = ((AbstractC1897ib) this.f201h).f5288a;
            C0581Yd.m1767d(view, "mDataBinding.accountBalance");
            view.setVisibility(8);
            View view2 = ((AbstractC1897ib) this.f201h).f5296j;
            C0581Yd.m1767d(view2, "mDataBinding.networkstate");
            if (view2.getVisibility() == 8) {
                View view3 = ((AbstractC1897ib) this.f201h).f5296j;
                C0581Yd.m1767d(view3, "mDataBinding.networkstate");
                view3.setVisibility(0);
                RelativeLayout relativeLayout = ((AbstractC1897ib) this.f201h).f5291d.f407b;
                C0581Yd.m1767d(relativeLayout, "mDataBinding.counterBar.counterLayout");
                relativeLayout.setVisibility(8);
                SwipeRefreshLayout swipeRefreshLayout = ((AbstractC1897ib) this.f201h).f5298l;
                C0581Yd.m1767d(swipeRefreshLayout, "mDataBinding.swlHomeNewsFeed");
                swipeRefreshLayout.setRefreshing(false);
                if (this.f199f) {
                    ((AbstractC1897ib) this.f201h).f5296j.startAnimation(AnimationUtils.loadAnimation(this.f200g, 17432578));
                }
            }
            CustomEmptyView customEmptyView = ((AbstractC1897ib) this.f201h).f5292f;
            Objects.requireNonNull(this.f202b);
            customEmptyView.setVisibility(8);
        } else if (this.f202b.m112k(227)) {
        } else {
            CustomEmptyView customEmptyView2 = ((AbstractC1897ib) this.f201h).f5292f;
            String string = getString(2131689836);
            C2388y8 c2388y8 = this.f202b;
            CustomEmptyView.EnumC1819a enumC1819a = CustomEmptyView.EnumC1819a.WARNING;
            Objects.requireNonNull(c2388y8);
            customEmptyView2.setVisibility(0);
            customEmptyView2.setLayout(null, string, enumC1819a);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f202b.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 227) {
                m1738E((GetNewsFeedData) bundle.getParcelable("fr.smoney.android.izly.extras.GetNewsFeed"), serverError);
            } else if (i2 == 261) {
                m1739D((CounterListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMyCounterList"), serverError);
            }
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.InterfaceC0875h
    /* renamed from: i */
    public void mo848i() {
        C0341Oc c0341Oc = this.f2123l;
        if (c0341Oc != null) {
            c0341Oc.f1152b.clear();
            c0341Oc.notifyDataSetChanged();
        }
        RecyclerView recyclerView = ((AbstractC1897ib) this.f201h).f5295i;
        C0581Yd.m1767d(recyclerView, "mDataBinding.lvHomeNewsFeed");
        recyclerView.setVisibility(8);
        CustomEmptyView customEmptyView = ((AbstractC1897ib) this.f201h).f5292f;
        C0581Yd.m1767d(customEmptyView, "mDataBinding.customEmptyView");
        customEmptyView.setVisibility(8);
        SwipeRefreshLayout swipeRefreshLayout = ((AbstractC1897ib) this.f201h).f5298l;
        C0581Yd.m1767d(swipeRefreshLayout, "mDataBinding.swlHomeNewsFeed");
        swipeRefreshLayout.setRefreshing(false);
        m1741B(this.f199f);
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo236m() {
        return 2131492969;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        if (i != 227) {
            if (i == 261) {
                C0479U8 c0479u8 = this.f2121j;
                if (c0479u8 == null) {
                    C0581Yd.m1761j("mMemoryProvider");
                    throw null;
                }
                CounterListData counterListData = c0479u8.f1716f0;
                if (c0479u8 != null) {
                    m1739D(counterListData, c0479u8.f1718g0);
                    return;
                } else {
                    C0581Yd.m1761j("mMemoryProvider");
                    throw null;
                }
            }
            return;
        }
        EnumC2029od enumC2029od = this.f2122k;
        if (enumC2029od == null) {
            return;
        }
        int ordinal = enumC2029od.ordinal();
        if (ordinal == 0) {
            C0479U8 c0479u82 = this.f2121j;
            if (c0479u82 == null) {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
            GetNewsFeedData getNewsFeedData = c0479u82.f1708b0;
            if (c0479u82 != null) {
                m1738E(getNewsFeedData, c0479u82.f1710c0);
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        } else if (ordinal == 1) {
            C0479U8 c0479u83 = this.f2121j;
            if (c0479u83 == null) {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
            GetNewsFeedData getNewsFeedData2 = c0479u83.f1702X;
            if (c0479u83 != null) {
                m1738E(getNewsFeedData2, c0479u83.f1703Y);
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        } else if (ordinal != 2) {
        } else {
            C0479U8 c0479u84 = this.f2121j;
            if (c0479u84 == null) {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
            GetNewsFeedData getNewsFeedData3 = c0479u84.f1704Z;
            if (c0479u84 != null) {
                m1738E(getNewsFeedData3, c0479u84.f1706a0);
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        boolean z;
        super.onActivityCreated(bundle);
        ((AbstractC1897ib) this.f201h).f5298l.setOnRefreshListener(this);
        ((AbstractC1897ib) this.f201h).f5298l.setColorSchemeResources(2131099785);
        ((AbstractC1897ib) this.f201h).f5294h.setOnClickListener(this);
        ((AbstractC1897ib) this.f201h).f5289b.setOnClickListener(this);
        ((AbstractC1897ib) this.f201h).f5291d.f407b.setOnClickListener(this);
        Objects.requireNonNull(this.f202b);
        setHasOptionsMenu(true);
        C0479U8 c0479u8 = this.f202b.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        this.f2121j = c0479u8;
        m2554u(0.27075d, ((AbstractC1897ib) this.f201h).f5293g);
        m2554u(0.36d, ((AbstractC1897ib) this.f201h).f5297k);
        m2554u(0.494d, ((AbstractC1897ib) this.f201h).f5299m);
        AppCompatActivity appCompatActivity = this.f200g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        this.f2125n = new SessionStateReceiver(appCompatActivity, new C0601b());
        AbstractC1897ib abstractC1897ib = (AbstractC1897ib) this.f201h;
        View view = abstractC1897ib.f5288a;
        RelativeLayout relativeLayout = abstractC1897ib.f5291d.f407b;
        C2388y8 c2388y8 = this.f202b;
        Objects.requireNonNull(c2388y8);
        if (view != null) {
            c2388y8.f6823k = view.findViewById(2131296780);
            c2388y8.f6824l = (TextView) view.findViewById(2131296938);
            c2388y8.f6825m = (TextView) view.findViewById(2131296936);
            c2388y8.f6826n = (TextView) view.findViewById(2131296937);
            if (relativeLayout != null) {
                RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(2131296467);
                c2388y8.f6827o = relativeLayout2;
                relativeLayout2.setVisibility(0);
                c2388y8.f6828p = (TextView) relativeLayout.findViewById(2131296884);
                c2388y8.f6829q = (LinearLayout) relativeLayout.findViewById(2131296653);
            }
        }
        C0479U8 c0479u82 = this.f2121j;
        if (c0479u82 != null) {
            AppCompatActivity appCompatActivity2 = this.f200g;
            C0581Yd.m1767d(appCompatActivity2, "mActivity");
            this.f2123l = new C0341Oc(c0479u82, appCompatActivity2);
            RecyclerView recyclerView = ((AbstractC1897ib) this.f201h).f5295i;
            C0581Yd.m1767d(recyclerView, "mDataBinding.lvHomeNewsFeed");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f202b.m123H();
            AbstractC1943kb abstractC1943kb = ((AbstractC1897ib) this.f201h).f5290c.f656f;
            TextView textView = abstractC1943kb.f5391b;
            C0581Yd.m1767d(textView, "tvImageLabel");
            textView.setText(getString(2131689839));
            ImageView imageView = abstractC1943kb.f5390a;
            Resources resources = getResources();
            ThreadLocal<TypedValue> threadLocal = C0103E3.f375a;
            imageView.setImageDrawable(resources.getDrawable(2131230971, null));
            TextView textView2 = ((AbstractC1897ib) this.f201h).f5290c.f657g.f5391b;
            C0581Yd.m1767d(textView2, "tvImageLabel");
            String string = getString(2131690231);
            C0581Yd.m1767d(string, "getString(R.string.top_up_homescreen_label)");
            C0581Yd.m1766e(string, "$this$capitalize");
            Locale locale = Locale.getDefault();
            C0581Yd.m1767d(locale, "Locale.getDefault()");
            String lowerCase = string.toLowerCase(locale);
            C0581Yd.m1767d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            char charAt = string.charAt(0);
            char upperCase = Character.toUpperCase(string.charAt(0));
            C0581Yd.m1766e(lowerCase, "$this$replaceFirst");
            C0581Yd.m1766e(lowerCase, "$this$indexOf");
            int i = -1;
            char[] cArr = {charAt};
            C0581Yd.m1766e(lowerCase, "$this$indexOfAny");
            C0581Yd.m1766e(cArr, "chars");
            C0581Yd.m1766e(lowerCase, "$this$lastIndex");
            int length = lowerCase.length() - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    char charAt2 = lowerCase.charAt(i2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 1) {
                            z = false;
                            break;
                        } else if (C0374Q7.m2090e(cArr[i3], charAt2, true)) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        if (i2 == length) {
                            break;
                        }
                        i2++;
                    } else {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= 0) {
                int i4 = i + 1;
                String valueOf = String.valueOf(upperCase);
                C0581Yd.m1766e(lowerCase, "$this$replaceRange");
                C0581Yd.m1766e(valueOf, "replacement");
                if (i4 >= i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((CharSequence) lowerCase, 0, i);
                    C0581Yd.m1767d(sb, "this.append(value, startIndex, endIndex)");
                    sb.append((CharSequence) valueOf);
                    sb.append((CharSequence) lowerCase, i4, lowerCase.length());
                    C0581Yd.m1767d(sb, "this.append(value, startIndex, endIndex)");
                    lowerCase = sb.toString();
                } else {
                    throw new IndexOutOfBoundsException("End index (" + i4 + ") is less than start index (" + i + ").");
                }
            }
            textView2.setText(lowerCase);
            AbstractC1943kb abstractC1943kb2 = ((AbstractC1897ib) this.f201h).f5290c.f658h;
            TextView textView3 = abstractC1943kb2.f5391b;
            C0581Yd.m1767d(textView3, "tvImageLabel");
            textView3.setText(getString(2131689841));
            ImageView imageView2 = abstractC1943kb2.f5390a;
            imageView2.setImageDrawable(imageView2.getResources().getDrawable(2131230990, null));
            imageView2.setColorFilter(C0103E3.m2469a(imageView2.getResources(), 2131099684, null));
            m1736G(true);
            AbstractC1984mb abstractC1984mb = ((AbstractC1897ib) this.f201h).f5290c.f653b;
            CustomFontTextView customFontTextView = abstractC1984mb.f5500b;
            C0581Yd.m1767d(customFontTextView, "tvSupportName");
            customFontTextView.setText(getString(2131689881));
            C2294v8.m279B(this, 2131099805, null, abstractC1984mb.f5499a);
            AbstractC1984mb abstractC1984mb2 = ((AbstractC1897ib) this.f201h).f5290c.f654c;
            CustomFontTextView customFontTextView2 = abstractC1984mb2.f5500b;
            C0581Yd.m1767d(customFontTextView2, "tvSupportName");
            customFontTextView2.setText(getString(2131689882));
            C2294v8.m279B(this, 2131099806, null, abstractC1984mb2.f5499a);
            AbstractC1984mb abstractC1984mb3 = ((AbstractC1897ib) this.f201h).f5290c.f652a;
            CustomFontTextView customFontTextView3 = abstractC1984mb3.f5500b;
            C0581Yd.m1767d(customFontTextView3, "tvSupportName");
            customFontTextView3.setText(getString(2131689880));
            C2294v8.m279B(this, 2131099808, null, abstractC1984mb3.f5499a);
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f201h;
        if (view == ((AbstractC1897ib) obj).f5294h) {
            m1732y(false);
            m2553v(new Intent(this.f200g, PreMyAccountDetailsActivity.class), true);
            return;
        }
        Fragment fragment = null;
        if (view == ((AbstractC1897ib) obj).f5291d.f407b) {
            C0479U8 c0479u8 = this.f2121j;
            if (c0479u8 != null) {
                if (c0479u8.f1716f0 == null) {
                    try {
                        m1731z();
                    } catch (NullPointerException unused) {
                    }
                }
                LinearLayout linearLayout = ((AbstractC1897ib) this.f201h).f5291d.f410f;
                C0581Yd.m1767d(linearLayout, "mDataBinding.counterBar.llCounterDetails");
                if (linearLayout.getVisibility() == 0) {
                    LinearLayout linearLayout2 = ((AbstractC1897ib) this.f201h).f5291d.f410f;
                    C0581Yd.m1767d(linearLayout2, "mDataBinding.counterBar.llCounterDetails");
                    C0581Yd.m1766e(linearLayout2, "v");
                    C1986md c1986md = new C1986md(linearLayout2, linearLayout2.getMeasuredHeight());
                    c1986md.setDuration(500L);
                    linearLayout2.startAnimation(c1986md);
                    ((AbstractC1897ib) this.f201h).f5291d.f406a.setImageResource(2131230882);
                    return;
                }
                LinearLayout linearLayout3 = ((AbstractC1897ib) this.f201h).f5291d.f410f;
                C0581Yd.m1767d(linearLayout3, "mDataBinding.counterBar.llCounterDetails");
                C0581Yd.m1766e(linearLayout3, "v");
                linearLayout3.measure(-1, -2);
                int measuredHeight = linearLayout3.getMeasuredHeight();
                linearLayout3.getLayoutParams().height = 1;
                linearLayout3.setVisibility(0);
                C2010nd c2010nd = new C2010nd(linearLayout3, measuredHeight);
                c2010nd.setDuration(500L);
                linearLayout3.startAnimation(c2010nd);
                ((AbstractC1897ib) this.f201h).f5291d.f406a.setImageResource(2131230883);
                return;
            }
            C0581Yd.m1761j("mMemoryProvider");
            throw null;
        } else if (view == ((AbstractC1897ib) obj).f5289b) {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) this.f200g.findViewById(2131296385);
            C0581Yd.m1767d(bottomNavigationView, "b");
            bottomNavigationView.setSelectedItemId(2131296390);
            try {
                fragment = (Fragment) C1965ld.class.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
            this.f202b.m116g(2131296459, fragment);
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f2125n;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m1732y(true);
        SessionStateReceiver sessionStateReceiver = this.f2125n;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
        if (this.f2121j != null) {
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }

    @Override // p000.AbstractC0044B8, p000.InterfaceC1899id
    /* renamed from: p */
    public void mo725p(boolean z, boolean z2) {
        m1741B(false);
        m1735H(true);
        this.f199f = z;
    }

    @Override // p000.AbstractC0044B8, p000.InterfaceC1899id
    /* renamed from: q */
    public void mo724q(boolean z, boolean z2) {
        m1741B(true);
        m1740C(true);
        C0479U8 c0479u8 = this.f2121j;
        if (c0479u8 != null) {
            if (c0479u8.f1707b == null) {
                C0065C8 c0065c8 = SmoneyApplication.f4207g;
                C0581Yd.m1767d(c0065c8, "SmoneyApplication.mAuthentManager");
                this.f202b.m120c(this.f202b.f6817b.m954d(c0065c8.user_id()), 228, true);
            }
            this.f199f = z;
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: s */
    public boolean mo234s() {
        this.f202b.m119d(false);
        return true;
    }

    /* renamed from: y */
    public final void m1732y(boolean z) {
        ImageView imageView = ((AbstractC1897ib) this.f201h).f5294h;
        C0581Yd.m1767d(imageView, "mDataBinding.ivProfileHomepage");
        imageView.setEnabled(z);
        if (z) {
            ImageView imageView2 = ((AbstractC1897ib) this.f201h).f5294h;
            Resources resources = getResources();
            ThreadLocal<TypedValue> threadLocal = C0103E3.f375a;
            imageView2.setImageDrawable(resources.getDrawable(2131230985, null));
            return;
        }
        ImageView imageView3 = ((AbstractC1897ib) this.f201h).f5294h;
        Resources resources2 = getResources();
        ThreadLocal<TypedValue> threadLocal2 = C0103E3.f375a;
        imageView3.setImageDrawable(resources2.getDrawable(2131230983, null));
    }

    /* renamed from: z */
    public final void m1731z() {
        int i;
        SmoneyRequestManager smoneyRequestManager = this.f202b.f6817b;
        C0479U8 c0479u8 = this.f2121j;
        if (c0479u8 == null) {
            C0581Yd.m1761j("mMemoryProvider");
            throw null;
        }
        LoginData loginData = c0479u8.f1707b;
        String str = loginData.f4380a;
        if (c0479u8 != null) {
            String str2 = loginData.f4382c;
            int size = smoneyRequestManager.f4688a.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 261 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetMyCounterListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetMyCounterListSessionId").equals(str2)) {
                        i = smoneyRequestManager.f4688a.keyAt(i2);
                        break;
                    }
                    i2++;
                } else {
                    int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                    intent.putExtra("com.foxykeep.datadroid.extras.workerType", 261);
                    intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                    intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                    intent.putExtra("fr.smoney.android.izly.extras.GetMyCounterListUserId", str);
                    intent.putExtra("fr.smoney.android.izly.extras.GetMyCounterListSessionId", str2);
                    smoneyRequestManager.m956b(intent);
                    smoneyRequestManager.f4688a.append(nextInt, intent);
                    C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                    c0479u82.f1716f0 = null;
                    c0479u82.f1718g0 = null;
                    i = nextInt;
                    break;
                }
            }
            this.f202b.m120c(i, 261, true);
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }
}
