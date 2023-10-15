package fr.smoney.android.izly.p005ui.privateview.useraccount.eventlist;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.Event;
import fr.smoney.android.izly.data.model.GetEventList;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.widget.CustomEmptyView;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.eventlist.EventListActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class EventListActivity extends SmoneyABSActivity<AbstractC0437Sa> implements SmoneyRequestManager.InterfaceC1778a, SwipeRefreshLayout.InterfaceC0875h {

    /* renamed from: A */
    public C0318Nc f4888A;

    /* renamed from: B */
    public boolean f4889B;

    /* renamed from: C */
    public boolean f4890C;

    /* renamed from: D */
    public boolean f4891D;

    /* renamed from: x */
    public final String f4892x = "savedStateIsRequestARefresh";

    /* renamed from: y */
    public final String f4893y = "savedStateIsLastRequestInError";

    /* renamed from: z */
    public SessionStateReceiver f4894z;

    /* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.eventlist.EventListActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1805a implements InterfaceC1879hd {
        public C1805a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                EventListActivity.m852L(EventListActivity.this, 0, 0, true, true, 3);
            }
        }
    }

    /* renamed from: L */
    public static void m852L(EventListActivity eventListActivity, int i, int i2, boolean z, boolean z2, int i3) {
        int m955c;
        if ((i3 & 1) != 0) {
            i = 1;
        }
        if ((i3 & 2) != 0) {
            i2 = 10;
        }
        eventListActivity.f4889B = true;
        eventListActivity.f4890C = z2;
        if (z) {
            CustomEmptyView customEmptyView = ((AbstractC0437Sa) eventListActivity.f4202w).f1429b;
            C0581Yd.m1767d(customEmptyView, "mDataBinding.customEmptyView");
            customEmptyView.setVisibility(8);
        }
        if (z2) {
            C2329w8 c2329w8 = eventListActivity.f4197r;
            SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
            LoginData loginData = c2329w8.f6816a.f1712b;
            m955c = smoneyRequestManager.m955c(loginData.f4362a, loginData.f4364c, String.valueOf(i), String.valueOf(i2), z2);
        } else {
            C0318Nc c0318Nc = eventListActivity.f4888A;
            if (c0318Nc != null) {
                C2329w8 c2329w82 = eventListActivity.f4197r;
                SmoneyRequestManager smoneyRequestManager2 = c2329w82.f6817b;
                LoginData loginData2 = c2329w82.f6816a.f1712b;
                m955c = smoneyRequestManager2.m955c(loginData2.f4362a, loginData2.f4364c, String.valueOf((c0318Nc.getItemCount() / 10) + 1), String.valueOf(i2), z2);
            } else {
                C0581Yd.m1761j("mAdapter");
                throw null;
            }
        }
        eventListActivity.f4197r.m120c(m955c, 23, z);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492957;
    }

    /* renamed from: M */
    public final void m851M(GetEventList getEventList, ServerError serverError) {
        if (serverError != null) {
            this.f4891D = true;
            this.f4197r.m124G(serverError);
        } else if (getEventList == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            if (this.f4890C) {
                this.f4197r.f6816a.f1689F0 = false;
            }
            ArrayList<Event> arrayList = getEventList.f4332a;
            if (arrayList != null) {
                C0318Nc c0318Nc = this.f4888A;
                if (c0318Nc != null) {
                    c0318Nc.f1049b.clear();
                    c0318Nc.notifyDataSetChanged();
                    if (arrayList.size() > 0) {
                        CustomEmptyView customEmptyView = ((AbstractC0437Sa) this.f4202w).f1429b;
                        C0581Yd.m1767d(customEmptyView, "mDataBinding.customEmptyView");
                        customEmptyView.setVisibility(8);
                        Iterator<Event> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Event next = it.next();
                            C0318Nc c0318Nc2 = this.f4888A;
                            if (c0318Nc2 != null) {
                                C0581Yd.m1767d(next, "transaction");
                                C0581Yd.m1766e(next, "item");
                                c0318Nc2.f1049b.add(next);
                            } else {
                                C0581Yd.m1761j("mAdapter");
                                throw null;
                            }
                        }
                    } else {
                        CustomEmptyView customEmptyView2 = ((AbstractC0437Sa) this.f4202w).f1429b;
                        C0581Yd.m1767d(customEmptyView2, "mDataBinding.customEmptyView");
                        customEmptyView2.setVisibility(0);
                    }
                    C0318Nc c0318Nc3 = this.f4888A;
                    if (c0318Nc3 == null) {
                        C0581Yd.m1761j("mAdapter");
                        throw null;
                    }
                    c0318Nc3.notifyDataSetChanged();
                } else {
                    C0581Yd.m1761j("mAdapter");
                    throw null;
                }
            } else {
                C0581Yd.m1761j("eventList");
                throw null;
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = ((AbstractC0437Sa) this.f4202w).f1430c;
        C0581Yd.m1767d(swipeRefreshLayout, "mDataBinding.rlEvents");
        swipeRefreshLayout.setRefreshing(false);
        this.f4889B = false;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 23) {
                m851M((GetEventList) bundle.getParcelable("fr.smoney.android.izly.extras.EventListData"), serverError);
                return;
            }
            return;
        }
        this.f4889B = false;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 4) {
            this.f4197r.m106q(enumC1631dd);
            return;
        }
        this.f4197r.m130A();
        this.f4197r.m129B();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.InterfaceC0875h
    /* renamed from: i */
    public void mo848i() {
        if (this.f4889B) {
            return;
        }
        m852L(this, 0, 0, false, true, 3);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m982H() == 23 && !this.f4889B) {
                    this.f4891D = false;
                    m852L(this, 0, 0, this.f4197r.f6816a.f1728j == null, this.f4890C, 3);
                    return;
                }
                this.f4197r.m100w(enumC1631dd, bundle);
                return;
            } else if (ordinal == 52) {
                C2329w8 c2329w8 = this.f4197r;
                LoginData loginData = c2329w8.f6816a.f1712b;
                if (loginData != null) {
                    c2329w8.f6817b.m952f(loginData.f4362a, loginData.f4364c);
                    return;
                }
                return;
            }
        }
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m982H() == 23 && SmoneyApplication.f4205d.f1728j == null) {
                    this.f4197r.m129B();
                    return;
                } else {
                    this.f4197r.m103t(enumC1631dd);
                    return;
                }
            } else if (ordinal == 52) {
                this.f4197r.m129B();
                return;
            }
        }
        this.f4197r.m103t(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        if (i == 23) {
            C0479U8 c0479u8 = this.f4197r.f6816a;
            m851M(c0479u8.f1728j, c0479u8.f1730k);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689803), "getString(R.string.events_profile)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, (r19 & 128) != 0 ? false : false);
        this.f4894z = new SessionStateReceiver(this, new C1805a());
        if (bundle != null) {
            this.f4891D = bundle.getBoolean(this.f4893y);
            this.f4890C = bundle.getBoolean(this.f4892x);
        }
        ((AbstractC0437Sa) this.f4202w).f1430c.setOnRefreshListener(this);
        ((AbstractC0437Sa) this.f4202w).f1430c.setColorSchemeResources(2131099785);
        this.f4888A = new C0318Nc(this);
        RecyclerView recyclerView = ((AbstractC0437Sa) this.f4202w).f1431d;
        C0581Yd.m1767d(recyclerView, "this");
        C0318Nc c0318Nc = this.f4888A;
        if (c0318Nc != null) {
            recyclerView.setAdapter(c0318Nc);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            ((AbstractC0437Sa) this.f4202w).f1431d.addOnScrollListener(new C2334wd(this));
            m852L(this, 0, 0, true, true, 3);
            return;
        }
        C0581Yd.m1761j("mAdapter");
        throw null;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            this.f2196f.m1721a();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        unregisterReceiver(this.f4894z);
        this.f4894z = null;
        super.onPause();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
        if (this.f4894z == null) {
            this.f4894z = new SessionStateReceiver(this, new C2357xd(this));
        }
        registerReceiver(this.f4894z, intentFilter);
        super.onResume();
        if (!this.f4197r.f6816a.f1689F0 || m981I(23) || this.f4889B) {
            return;
        }
        m852L(this, 0, 0, this.f4197r.f6816a.f1728j == null, true, 3);
    }
}
