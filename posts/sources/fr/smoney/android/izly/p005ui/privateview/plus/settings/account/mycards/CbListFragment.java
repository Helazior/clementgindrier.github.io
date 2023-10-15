package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mycards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.data.model.GetMyCbListData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import java.util.ArrayList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0204Ic;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbListFragment */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CbListFragment extends AbstractC0044B8<AbstractC1896ia> implements SmoneyRequestManager.InterfaceC1778a, C0204Ic.InterfaceC0205a {

    /* renamed from: n */
    public static final /* synthetic */ int f4842n = 0;

    /* renamed from: j */
    public final String f4843j = "GetMyCbListData";

    /* renamed from: k */
    public GetMyCbListData f4844k;

    /* renamed from: l */
    public C0204Ic f4845l;

    /* renamed from: m */
    public SessionStateReceiver f4846m;

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbListFragment$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1802a implements InterfaceC1879hd {
        public C1802a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                CbListFragment cbListFragment = CbListFragment.this;
                int i = CbListFragment.f4842n;
                cbListFragment.m876x();
            }
        }
    }

    @Override // p000.C0204Ic.InterfaceC0205a
    /* renamed from: c */
    public void mo878c(@NotNull MoneyInCbCb moneyInCbCb) {
        C0581Yd.m1766e(moneyInCbCb, "item");
        Intent intent = new Intent(this.f201g, CbEditActivity.class);
        intent.putExtra("intentExtraCb", moneyInCbCb);
        startActivityForResult(intent, 1);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        this.f197b.m108o(i, i2, i3, bundle);
        ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
        if (i2 == 230) {
            m875y((GetMyCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMyCbList"), serverError);
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType) {
            this.f197b.m130A();
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof CbListActivity) {
                appCompatActivity.finish();
                return;
            } else if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
                return;
            } else {
                return;
            }
        }
        this.f197b.m106q(enumC1631dd);
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m2556r() == 230) {
                    m876x();
                    return;
                } else {
                    this.f197b.m100w(enumC1631dd, bundle);
                    return;
                }
            } else if (ordinal == 23) {
                return;
            }
        }
        this.f197b.m100w(enumC1631dd, bundle);
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f197b.m103t(enumC1631dd);
        } else if (m2556r() == 230) {
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof CbListActivity) {
                appCompatActivity.finish();
            } else if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
            }
        } else {
            this.f197b.m103t(enumC1631dd);
        }
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo236m() {
        return 2131492917;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f197b.f6816a;
        if (i == 230) {
            m875y(c0479u8.f1717d0, c0479u8.f1719e0);
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        C0296Md.C0297a c0297a = C0296Md.f999a;
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        String string = getString(2131690211);
        C0581Yd.m1767d(string, "getString(R.string.subtitle_my_cards)");
        c0297a.m2194a(appCompatActivity, string, null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, false);
        if (bundle != null) {
            this.f4844k = (GetMyCbListData) bundle.getParcelable(this.f4843j);
        }
        if (this.f4844k != null) {
            m877w();
        } else {
            m876x();
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                m876x();
            }
        } else if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            GetMyCbListData getMyCbListData = intent != null ? (GetMyCbListData) intent.getParcelableExtra("fr.smoney.android.izly.cbListExtra") : null;
            if (getMyCbListData != null) {
                this.f4844k = getMyCbListData;
            } else {
                m876x();
            }
        } else {
            m876x();
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        this.f4846m = new SessionStateReceiver(appCompatActivity, new C1802a());
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C0581Yd.m1766e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        getActivity();
        Object obj = this.f202h;
        C0581Yd.m1767d(obj, "mDataBinding");
        View root = ((AbstractC1896ia) obj).getRoot();
        C0581Yd.m1767d(root, "mDataBinding.root");
        return root;
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f4846m;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f4846m;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        ActionBar m1681z = appCompatActivity.m1681z();
        C0581Yd.m1768c(m1681z);
        m1681z.mo1702s(2131689631);
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        GetMyCbListData getMyCbListData = this.f4844k;
        if (getMyCbListData != null) {
            bundle.putParcelable(this.f4843j, getMyCbListData);
        }
    }

    /* renamed from: w */
    public final void m877w() {
        GetMyCbListData getMyCbListData = this.f4844k;
        C0581Yd.m1768c(getMyCbListData);
        if (getMyCbListData.f4333a.isEmpty()) {
            LinearLayout linearLayout = ((AbstractC1896ia) this.f202h).f5286b;
            C0581Yd.m1767d(linearLayout, "mDataBinding.ivNoCb");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = ((AbstractC1896ia) this.f202h).f5287c;
            C0581Yd.m1767d(recyclerView, "mDataBinding.lvCb");
            recyclerView.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = ((AbstractC1896ia) this.f202h).f5286b;
            C0581Yd.m1767d(linearLayout2, "mDataBinding.ivNoCb");
            linearLayout2.setVisibility(8);
        }
        GetMyCbListData getMyCbListData2 = this.f4844k;
        C0581Yd.m1768c(getMyCbListData2);
        ArrayList<MoneyInCbCb> arrayList = getMyCbListData2.f4333a;
        C0581Yd.m1767d(arrayList, "mGetMyCbListData!!.cbList");
        Context context = getContext();
        C0581Yd.m1768c(context);
        C0581Yd.m1767d(context, "context!!");
        this.f4845l = new C0204Ic(arrayList, context, this);
        RecyclerView recyclerView2 = ((AbstractC1896ia) this.f202h).f5287c;
        C0581Yd.m1767d(recyclerView2, "mDataBinding.lvCb");
        recyclerView2.setAdapter(this.f4845l);
        RecyclerView recyclerView3 = ((AbstractC1896ia) this.f202h).f5287c;
        C0581Yd.m1767d(recyclerView3, "mDataBinding.lvCb");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /* renamed from: x */
    public final void m876x() {
        C2387y8 c2387y8 = this.f197b;
        C0479U8 c0479u8 = c2387y8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2387y8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        this.f197b.m120c(smoneyRequestManager.m953e(loginData.f4362a, loginData.f4364c), 230, true);
    }

    /* renamed from: y */
    public final void m875y(GetMyCbListData getMyCbListData, ServerError serverError) {
        if (serverError != null) {
            this.f197b.m124G(serverError);
        } else if (getMyCbListData == null) {
            this.f197b.m126E(C0580Yc.m1772t(this.f201g, this));
        } else {
            this.f4844k = getMyCbListData;
            m877w();
        }
    }
}
