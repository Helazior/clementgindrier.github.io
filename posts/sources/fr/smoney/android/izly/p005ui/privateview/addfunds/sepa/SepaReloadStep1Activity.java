package fr.smoney.android.izly.p005ui.privateview.addfunds.sepa;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.IconButton;
import android.widget.LinearLayout;
import fr.smoney.android.izly.data.model.CheckMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.GetActiveMandateData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.Mandate;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep2ConfirmActivity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxWorkFlowObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.sepa.SepaReloadStep1Activity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class SepaReloadStep1Activity extends AllTrxStep1Activity implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, AbstractC1668ed.InterfaceC1669a {

    /* renamed from: E */
    public static final /* synthetic */ int f4774E = 0;

    /* renamed from: B */
    public final String f4775B = "mGetActiveMandateData";

    /* renamed from: C */
    public GetActiveMandateData f4776C;
    @Nullable

    /* renamed from: D */
    public SessionStateReceiver f4777D;

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.sepa.SepaReloadStep1Activity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1793a implements InterfaceC1879hd {
        public C1793a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("fr.smoney.android.izly.sessionState", -1)) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                SepaReloadStep1Activity sepaReloadStep1Activity = SepaReloadStep1Activity.this;
                int i = SepaReloadStep1Activity.f4774E;
                sepaReloadStep1Activity.m979K();
            } else if (valueOf != null && valueOf.intValue() == 1) {
                SepaReloadStep1Activity sepaReloadStep1Activity2 = SepaReloadStep1Activity.this;
                int i2 = SepaReloadStep1Activity.f4774E;
                sepaReloadStep1Activity2.m913Q();
            } else if (valueOf != null && valueOf.intValue() == 2) {
                SepaReloadStep1Activity sepaReloadStep1Activity3 = SepaReloadStep1Activity.this;
                C0580Yc m1771u = C0580Yc.m1771u(sepaReloadStep1Activity3, sepaReloadStep1Activity3, EnumC1631dd.ConnexionErrorDuringIsSessionValid);
                int i3 = SepaReloadStep1Activity.f4774E;
                sepaReloadStep1Activity3.f4197r.m126E(m1771u);
            }
        }
    }

    /* renamed from: P */
    public final void m914P() {
        int i;
        double m908L = m908L();
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 267 && valueAt.getStringExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountAmount").equals(Double.valueOf(m908L))) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 265);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountAmount", m908L);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                smoneyRequestManager.f4693f.f1741p0 = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 265, true);
    }

    /* renamed from: Q */
    public final void m913Q() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 264 && valueAt.getStringExtra("fr.smoney.android.izly.extras.getMandatesUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.getMandatesSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 264);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.getMandatesUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.getMandatesSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                smoneyRequestManager.f4693f.f1737n0 = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 264, true);
    }

    /* renamed from: R */
    public final void m912R(CheckMoneyInBankAccountData checkMoneyInBankAccountData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (checkMoneyInBankAccountData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            Intent intent = new Intent(this, AllTrxStep2ConfirmActivity.class);
            AllTrxWorkFlowObject allTrxWorkFlowObject = new AllTrxWorkFlowObject();
            allTrxWorkFlowObject.f4799b = EnumC0115E8.RELOAD_SEPA;
            allTrxWorkFlowObject.f4800c = getString(2131690099);
            allTrxWorkFlowObject.f4801d = getResources().getString(2131690178);
            GetActiveMandateData getActiveMandateData = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData);
            Mandate mandate = getActiveMandateData.f4278f;
            C0581Yd.m1767d(mandate, "mGetActiveMandateData!!.mandate");
            allTrxWorkFlowObject.f4802f = mandate.f4411d;
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", checkMoneyInBankAccountData);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", allTrxWorkFlowObject);
            startActivity(intent);
        }
    }

    /* renamed from: S */
    public final void m911S(GetActiveMandateData getActiveMandateData, ServerError serverError) {
        if (serverError != null) {
            if (serverError.f4601b == 1019) {
                this.f4197r.m126E(C0564Xc.m1793t(serverError.f4604f, serverError.f4603d, getString(2131689575), this, EnumC1631dd.AlertType));
            } else {
                this.f4197r.m124G(serverError);
            }
        } else if (getActiveMandateData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            this.f4776C = getActiveMandateData;
            m906N(getActiveMandateData.f4274a);
            Resources resources = getResources();
            GetActiveMandateData getActiveMandateData2 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData2);
            String string = resources.getString(2131689545, C0374Q7.m2089f(getActiveMandateData2.f4276c), AllTrxStep1Activity.f4781A);
            C0581Yd.m1767d(string, "resources.getString(\n   …mCurrencySymbol\n        )");
            GetActiveMandateData getActiveMandateData3 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData3);
            int[] iArr = getActiveMandateData3.f4277d;
            C0581Yd.m1767d(iArr, "mGetActiveMandateData!!.stepsArray");
            GetActiveMandateData getActiveMandateData4 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData4);
            double d = getActiveMandateData4.f4276c;
            GetActiveMandateData getActiveMandateData5 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData5);
            m907M(iArr, d, getActiveMandateData5.f4275b, string);
            GetActiveMandateData getActiveMandateData6 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData6);
            if (getActiveMandateData6.f4278f == null) {
                this.f4197r.m126E(C0564Xc.m1793t(getString(2131689782), getString(2131689775), getString(2131689575), this, EnumC1631dd.AlertType));
                return;
            }
            EditText editText = ((AbstractC2028oc) this.f4202w).f5617m.f2178a;
            GetActiveMandateData getActiveMandateData7 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData7);
            Mandate mandate = getActiveMandateData7.f4278f;
            C0581Yd.m1767d(mandate, "mGetActiveMandateData!!.mandate");
            editText.setText(mandate.f4409b);
            EditText editText2 = ((AbstractC2028oc) this.f4202w).f5617m.f2179b;
            GetActiveMandateData getActiveMandateData8 = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData8);
            Mandate mandate2 = getActiveMandateData8.f4278f;
            C0581Yd.m1767d(mandate2, "mGetActiveMandateData!!.mandate");
            editText2.setText(mandate2.f4411d);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 264) {
                m911S((GetActiveMandateData) bundle.getParcelable("fr.smoney.android.izly.extras.GetActiveMandate"), serverError);
            } else if (i2 != 265) {
            } else {
                m912R((CheckMoneyInBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.CheckMoneyInBankAccount"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.InputPasswordType) {
            finish();
        } else {
            this.f4197r.m106q(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView.InterfaceC1818a
    /* renamed from: j */
    public void mo826j(boolean z) {
        boolean z2 = false;
        if (z && this.f4776C != null) {
            double m908L = m908L();
            GetActiveMandateData getActiveMandateData = this.f4776C;
            C0581Yd.m1768c(getActiveMandateData);
            if (m908L >= getActiveMandateData.f4276c) {
                double m908L2 = m908L();
                GetActiveMandateData getActiveMandateData2 = this.f4776C;
                C0581Yd.m1768c(getActiveMandateData2);
                if (m908L2 <= getActiveMandateData2.f4275b) {
                    z2 = true;
                }
            }
        }
        IconButton iconButton = ((AbstractC2028oc) this.f4202w).f5608c.f6633a;
        C0581Yd.m1767d(iconButton, "mDataBinding.bSubmit.bSubmit");
        iconButton.setEnabled(z2);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m100w(enumC1631dd, bundle);
            return;
        }
        int m982H = m982H();
        if (m982H == 264) {
            m913Q();
        } else if (m982H == 265) {
            m914P();
        } else {
            this.f4197r.m100w(enumC1631dd, bundle);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m103t(enumC1631dd);
        } else if (m982H() == 264) {
            finish();
        } else {
            this.f4197r.m103t(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 264) {
            m911S(c0479u8.f1737n0, c0479u8.f1739o0);
        } else if (i != 265) {
        } else {
            m912R(c0479u8.f1741p0, c0479u8.f1743q0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC2028oc) obj).f5608c.f6633a) {
            m914P();
        } else if (view == ((AbstractC2028oc) obj).f5607b) {
            this.f2196f.m1721a();
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690183), "getString(R.string.sepa_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_TRANSPARENT, true, true);
        this.f4777D = new SessionStateReceiver(this, new C1793a());
        LinearLayout linearLayout = ((AbstractC2028oc) this.f4202w).f5617m.f2180c;
        C0581Yd.m1767d(linearLayout, "mDataBinding.sepaBicIbanLayout.sepaInputView");
        linearLayout.setVisibility(0);
        ((AbstractC2028oc) this.f4202w).f5608c.f6633a.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5607b.setOnClickListener(this);
        m913Q();
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        SessionStateReceiver sessionStateReceiver = this.f4777D;
        if (sessionStateReceiver != null) {
            sessionStateReceiver.m938b();
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f4777D;
        if (sessionStateReceiver != null) {
            sessionStateReceiver.m939a();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(this.f4775B, this.f4776C);
    }
}
