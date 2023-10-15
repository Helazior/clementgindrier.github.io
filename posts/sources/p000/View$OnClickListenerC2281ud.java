package p000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import fr.smoney.android.izly.data.model.GetBankAccountData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.account.myaccount.AddTransferAccountActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mycards.CbListActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.security.opposite.BlockAccountActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.security.secretkey.ChangePasswordActivity;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: ud */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC2281ud extends AbstractC0044B8<AbstractC0996cc> implements View.OnClickListener, SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: j */
    public GetBankAccountData f6634j;

    /* renamed from: k */
    public SessionStateReceiver f6635k;

    /* renamed from: ud$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2282a implements InterfaceC1879hd {
        public C2282a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                View$OnClickListenerC2281ud.this.m296w();
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f197b.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 225) {
                m295x((GetBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.getBankAccountData"), serverError);
            }
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType && m2556r() == 225) {
            this.f197b.m130A();
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
            }
        } else if (enumC1631dd == EnumC1631dd.InputPasswordType) {
            AppCompatActivity appCompatActivity2 = this.f201g;
            if (appCompatActivity2 instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity2, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity2).mo681m();
            }
        } else {
            this.f197b.m106q(enumC1631dd);
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f197b.m100w(enumC1631dd, bundle);
        } else if (m2556r() == 225) {
            m296w();
        } else {
            this.f197b.m100w(enumC1631dd, bundle);
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f197b.m103t(enumC1631dd);
        } else if (m2556r() == 225) {
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
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
        return 2131493049;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f197b.f6816a;
        if (i == 225) {
            m295x(c0479u8.f1705V, c0479u8.f1706W);
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        C0296Md.C0297a c0297a = C0296Md.f999a;
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        String string = getString(2131690186);
        C0581Yd.m1767d(string, "getString(R.string.settings)");
        c0297a.m2194a(appCompatActivity, string, 2131230967, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, false);
        if (this.f6634j != null) {
            m294y();
        } else {
            m296w();
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 11 && i2 == -1) {
            m296w();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "v");
        Object obj = this.f202h;
        if (view == ((AbstractC0996cc) obj).f3808d) {
            Intent intent = new Intent(this.f201g, AddTransferAccountActivity.class);
            intent.putExtra("fr.smoney.android.izly.intentExtrasMode", 1);
            intent.putExtra("fr.smoney.android.izly.intentBankAccount", this.f6634j);
            startActivityForResult(intent, 11);
        } else if (view == ((AbstractC0996cc) obj).f3809f) {
            startActivity(new Intent(this.f201g, CbListActivity.class));
        } else if (view == ((AbstractC0996cc) obj).f3806b) {
            m2553v(new Intent(this.f201g, BlockAccountActivity.class), true);
        } else if (view == ((AbstractC0996cc) obj).f3807c) {
            m2553v(new Intent(this.f201g, ChangePasswordActivity.class), true);
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C0581Yd.m1766e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        this.f6635k = new SessionStateReceiver(appCompatActivity, new C2282a());
        setHasOptionsMenu(true);
        ((AbstractC0996cc) this.f202h).f3808d.setOnClickListener(this);
        ((AbstractC0996cc) this.f202h).f3806b.setOnClickListener(this);
        ((AbstractC0996cc) this.f202h).f3807c.setOnClickListener(this);
        ((AbstractC0996cc) this.f202h).f3809f.setOnClickListener(this);
        getActivity();
        Object obj = this.f202h;
        C0581Yd.m1767d(obj, "mDataBinding");
        return ((AbstractC0996cc) obj).getRoot();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f6635k;
        if (sessionStateReceiver != null) {
            sessionStateReceiver.m938b();
        }
        super.onPause();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f6635k;
        if (sessionStateReceiver != null) {
            sessionStateReceiver.m939a();
        }
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        ActionBar m1681z = appCompatActivity.m1681z();
        C0581Yd.m1768c(m1681z);
        m1681z.mo1702s(2131690241);
    }

    /* renamed from: w */
    public final void m296w() {
        int i;
        C2387y8 c2387y8 = this.f197b;
        C0479U8 c0479u8 = c2387y8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2387y8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 225 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetBankAccountUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetBankAccountSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 225);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.GetBankAccountUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.GetBankAccountSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1705V = null;
                c0479u82.f1706W = null;
                i = nextInt;
                break;
            }
        }
        this.f197b.m120c(i, 225, true);
    }

    /* renamed from: x */
    public final void m295x(GetBankAccountData getBankAccountData, ServerError serverError) {
        if (serverError != null) {
            this.f197b.m124G(serverError);
            Button button = ((AbstractC0996cc) this.f202h).f3808d;
            C0581Yd.m1767d(button, "mDataBinding.btnMyAccount");
            button.setEnabled(false);
        } else if (getBankAccountData == null) {
            this.f197b.m126E(C0580Yc.m1772t(this.f201g, this));
        } else {
            Button button2 = ((AbstractC0996cc) this.f202h).f3808d;
            C0581Yd.m1767d(button2, "mDataBinding.btnMyAccount");
            button2.setEnabled(true);
            this.f6634j = getBankAccountData;
            m294y();
        }
    }

    /* renamed from: y */
    public final void m294y() {
        GetBankAccountData getBankAccountData = this.f6634j;
        if ((getBankAccountData != null ? getBankAccountData.f4282d : null) != null) {
            TextView textView = ((AbstractC0996cc) this.f202h).f3811h;
            C0581Yd.m1767d(textView, "mDataBinding.tvItemIban");
            GetBankAccountData getBankAccountData2 = this.f6634j;
            C0581Yd.m1768c(getBankAccountData2);
            textView.setText(getBankAccountData2.f4282d);
        }
        ((AbstractC0996cc) this.f202h).f3808d.setText(2131690023);
    }
}
