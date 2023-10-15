package p000;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.p005ui.privateview.addfunds.campus.PaymentInfoActivity;
import fr.smoney.android.izly.p005ui.privateview.addfunds.cards.CardReloadStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.addfunds.initiation.InitiationStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.addfunds.tiers.TiersReloadStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.useraccount.PreMyAccountDetailsActivity;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0119Ec;
import p000.C0296Md;

/* renamed from: ld */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1965ld extends AbstractC0044B8<AbstractC0340Ob> implements C0119Ec.InterfaceC0120a {
    @Override // p000.C0119Ec.InterfaceC0120a
    /* renamed from: a */
    public void mo608a(@Nullable EnumC0435S8 enumC0435S8) {
        if (enumC0435S8 != null) {
            LoginData loginData = this.f197b.f6816a.f1712b;
            Intent intent = null;
            if (loginData != null) {
                if (loginData.f4354G == 0) {
                    this.f197b.m126E(C0525Vc.m1826s(getString(2131689536), getString(2131689681), getString(2131689682), getString(2131689583), this, EnumC1631dd.AdressCompletedType));
                } else {
                    int ordinal = enumC0435S8.ordinal();
                    if (ordinal == 0) {
                        intent = new Intent(this.f201g, InitiationStep1Activity.class);
                    } else if (ordinal == 1) {
                        intent = new Intent(this.f201g, CardReloadStep1Activity.class);
                    } else if (ordinal == 2) {
                        intent = new Intent(this.f201g, TiersReloadStep1Activity.class);
                    } else if (ordinal == 3) {
                        intent = new Intent(this.f201g, PaymentInfoActivity.class);
                        intent.putExtra("info_extra", 2131689587);
                        C0581Yd.m1767d(intent.putExtra("title_extra", 2131690094), "intent.putExtra(PaymentI…mentType.CASH.resIdTitle)");
                    }
                }
            }
            if (intent != null) {
                m2553v(intent, true);
            }
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.AdressCompletedType) {
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
                return;
            }
            return;
        }
        this.f197b.m103t(enumC1631dd);
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@NotNull EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.AdressCompletedType) {
            m2553v(new Intent(this.f201g, PreMyAccountDetailsActivity.class), true);
        } else {
            this.f197b.m100w(enumC1631dd, bundle);
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.AdressCompletedType) {
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
                return;
            }
            return;
        }
        this.f197b.m103t(enumC1631dd);
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo236m() {
        return 2131493038;
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        String string = this.f201g.getString(2131690232);
        C0581Yd.m1767d(string, "mActivity.getString(R.string.top_up_title)");
        c0297a.m2194a(appCompatActivity, string, 2131230939, getString(2131690230), EnumC1687fd.LONG_APPBAR_WITH_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, false, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = ((AbstractC0340Ob) this.f202h).f1150b;
        C0581Yd.m1767d(recyclerView, "mDataBinding.fundsListRv");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((AbstractC0340Ob) this.f202h).f1150b.setHasFixedSize(true);
        RecyclerView recyclerView2 = ((AbstractC0340Ob) this.f202h).f1150b;
        C0581Yd.m1767d(recyclerView2, "mDataBinding.fundsListRv");
        recyclerView2.setAdapter(new C0119Ec(this));
    }
}
