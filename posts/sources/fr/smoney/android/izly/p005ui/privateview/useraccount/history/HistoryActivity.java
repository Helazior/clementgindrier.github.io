package fr.smoney.android.izly.p005ui.privateview.useraccount.history;

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
import fr.smoney.android.izly.data.model.BalanceData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.NewsFeedItem;
import fr.smoney.android.izly.data.model.NewsFeedItemTransaction;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.Transaction;
import fr.smoney.android.izly.data.model.TransactionListData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.widget.CustomEmptyView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.history.HistoryActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class HistoryActivity extends SmoneyABSActivity<AbstractC1845gb> implements SmoneyRequestManager.InterfaceC1778a, SwipeRefreshLayout.InterfaceC0875h {

    /* renamed from: E */
    public static final /* synthetic */ int f4896E = 0;

    /* renamed from: A */
    public boolean f4897A;

    /* renamed from: B */
    public boolean f4898B;

    /* renamed from: C */
    public boolean f4899C;

    /* renamed from: D */
    public SessionStateReceiver f4900D;

    /* renamed from: x */
    public final String f4901x = "savedStateIsRequestARefresh";

    /* renamed from: y */
    public final String f4902y = "savedStateIsLastRequestInError";

    /* renamed from: z */
    public C0360Pc f4903z;

    /* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.history.HistoryActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1806a implements InterfaceC1879hd {
        public C1806a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                HistoryActivity historyActivity = HistoryActivity.this;
                int i = HistoryActivity.f4896E;
                historyActivity.m850L(true, true);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492968;
    }

    /* renamed from: L */
    public final void m850L(boolean z, boolean z2) {
        long j;
        int m948j;
        this.f4899C = true;
        this.f4898B = z;
        if (z2) {
            CustomEmptyView customEmptyView = ((AbstractC1845gb) this.f4202w).f5089b;
            C0581Yd.m1767d(customEmptyView, "mDataBinding.evHistory");
            customEmptyView.setVisibility(8);
        }
        if (z) {
            C2329w8 c2329w8 = this.f4197r;
            SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
            LoginData loginData = c2329w8.f6816a.f1712b;
            m948j = smoneyRequestManager.m948j(loginData.f4362a, loginData.f4364c, -1L, 0, -1, z);
        } else {
            C0360Pc c0360Pc = this.f4903z;
            if (c0360Pc != null) {
                int itemCount = c0360Pc.getItemCount();
                if (itemCount > 0) {
                    C0360Pc c0360Pc2 = this.f4903z;
                    if (c0360Pc2 != null) {
                        Objects.requireNonNull(c0360Pc2);
                        j = 0;
                    } else {
                        C0581Yd.m1761j("mAdapter");
                        throw null;
                    }
                } else {
                    j = -1;
                }
                C2329w8 c2329w82 = this.f4197r;
                SmoneyRequestManager smoneyRequestManager2 = c2329w82.f6817b;
                LoginData loginData2 = c2329w82.f6816a.f1712b;
                m948j = smoneyRequestManager2.m948j(loginData2.f4362a, loginData2.f4364c, j, itemCount, -1, z);
            } else {
                C0581Yd.m1761j("mAdapter");
                throw null;
            }
        }
        this.f4197r.m120c(m948j, 21, z2);
    }

    /* renamed from: M */
    public final void m849M(TransactionListData transactionListData, ServerError serverError) {
        if (serverError != null) {
            this.f4897A = true;
            this.f4197r.m124G(serverError);
        } else if (transactionListData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            if (this.f4898B) {
                this.f4197r.f6816a.f1687E0 = false;
            }
            BalanceData balanceData = transactionListData.f4657c;
            if (balanceData != null) {
                C2329w8 c2329w8 = this.f4197r;
                c2329w8.f6816a.f1712b.f4351D = balanceData;
                c2329w8.m123H();
            }
            ArrayList<Transaction> arrayList = transactionListData.f4656b;
            C0581Yd.m1767d(arrayList, "transactionListData.transactionList");
            C0360Pc c0360Pc = this.f4903z;
            if (c0360Pc != null) {
                c0360Pc.f1239b.clear();
                c0360Pc.notifyDataSetChanged();
                if (arrayList.size() > 0) {
                    CustomEmptyView customEmptyView = ((AbstractC1845gb) this.f4202w).f5089b;
                    C0581Yd.m1767d(customEmptyView, "mDataBinding.evHistory");
                    customEmptyView.setVisibility(8);
                    Iterator<Transaction> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Transaction next = it.next();
                        NewsFeedItemTransaction newsFeedItemTransaction = new NewsFeedItemTransaction();
                        C0581Yd.m1767d(next, "transaction");
                        C0581Yd.m1766e(next, "mTransaction");
                        newsFeedItemTransaction.f4527o = next;
                        newsFeedItemTransaction.f4479g = NewsFeedItem.m966a(next.f4634n);
                        Transaction transaction = newsFeedItemTransaction.f4527o;
                        if (transaction != null) {
                            switch (transaction.f4634n) {
                                case 0:
                                case 2:
                                case 5:
                                case 6:
                                case 10:
                                case 11:
                                case 15:
                                case 19:
                                    newsFeedItemTransaction.f4474a = transaction.f4627g;
                                    break;
                                case 1:
                                case 3:
                                case 4:
                                case 7:
                                case 8:
                                case 9:
                                case 17:
                                case 18:
                                    newsFeedItemTransaction.f4474a = transaction.f4625d;
                                    break;
                            }
                            newsFeedItemTransaction.f4475b = transaction.f4622a;
                            newsFeedItemTransaction.f4482j = NewsFeedItem.f4472m.get(transaction.f4635o);
                            Transaction transaction2 = newsFeedItemTransaction.f4527o;
                            if (transaction2 != null) {
                                newsFeedItemTransaction.f4481i = Long.valueOf(transaction2.f4631k);
                                C0360Pc c0360Pc2 = this.f4903z;
                                if (c0360Pc2 != null) {
                                    C0581Yd.m1766e(newsFeedItemTransaction, "item");
                                    c0360Pc2.f1239b.add(newsFeedItemTransaction);
                                } else {
                                    C0581Yd.m1761j("mAdapter");
                                    throw null;
                                }
                            } else {
                                C0581Yd.m1761j("mTransaction");
                                throw null;
                            }
                        } else {
                            C0581Yd.m1761j("mTransaction");
                            throw null;
                        }
                    }
                } else {
                    ((AbstractC1845gb) this.f4202w).f5089b.setLayout(getString(2131690049), getString(2131689836), CustomEmptyView.EnumC1819a.WARNING);
                    CustomEmptyView customEmptyView2 = ((AbstractC1845gb) this.f4202w).f5089b;
                    C0581Yd.m1767d(customEmptyView2, "mDataBinding.evHistory");
                    customEmptyView2.setVisibility(0);
                }
                C0360Pc c0360Pc3 = this.f4903z;
                if (c0360Pc3 == null) {
                    C0581Yd.m1761j("mAdapter");
                    throw null;
                }
                c0360Pc3.notifyDataSetChanged();
            } else {
                C0581Yd.m1761j("mAdapter");
                throw null;
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = ((AbstractC1845gb) this.f4202w).f5090c;
        C0581Yd.m1767d(swipeRefreshLayout, "mDataBinding.rlHistory");
        swipeRefreshLayout.setRefreshing(false);
        this.f4899C = false;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 21) {
                m849M((TransactionListData) bundle.getParcelable("fr.smoney.android.izly.extras.transactionListData"), serverError);
                return;
            }
            return;
        }
        this.f4899C = false;
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
        if (this.f4899C) {
            return;
        }
        m850L(true, false);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m982H() == 21 && !this.f4899C) {
                    this.f4897A = false;
                    m850L(this.f4898B, this.f4197r.f6816a.f1720f == null);
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
                if (m982H() == 21 && SmoneyApplication.f4205d.f1720f == null) {
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
        if (i == 21) {
            C0479U8 c0479u8 = this.f4197r.f6816a;
            m849M(c0479u8.f1720f, c0479u8.f1722g);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690083), "getString(R.string.profile_subtitle_history)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, false);
        this.f4900D = new SessionStateReceiver(this, new C1806a());
        if (bundle != null) {
            this.f4897A = bundle.getBoolean(this.f4902y);
            this.f4898B = bundle.getBoolean(this.f4901x);
        }
        ((AbstractC1845gb) this.f4202w).f5090c.setOnRefreshListener(this);
        ((AbstractC1845gb) this.f4202w).f5090c.setColorSchemeResources(2131099785);
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        this.f4903z = new C0360Pc(c0479u8, this);
        RecyclerView recyclerView = ((AbstractC1845gb) this.f4202w).f5091d;
        C0581Yd.m1767d(recyclerView, "this");
        C0360Pc c0360Pc = this.f4903z;
        if (c0360Pc != null) {
            recyclerView.setAdapter(c0360Pc);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            ((AbstractC1845gb) this.f4202w).f5091d.addOnScrollListener(new C2392yd(this));
            m850L(true, true);
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
        unregisterReceiver(this.f4900D);
        this.f4900D = null;
        super.onPause();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
        if (this.f4900D == null) {
            this.f4900D = new SessionStateReceiver(this, new C2409zd(this));
        }
        registerReceiver(this.f4900D, intentFilter);
        super.onResume();
        if (!this.f4197r.f6816a.f1687E0 || m981I(21) || this.f4899C) {
            return;
        }
        m850L(true, this.f4197r.f6816a.f1720f == null);
    }
}
