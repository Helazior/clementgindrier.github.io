package fr.smoney.android.izly.p005ui.privateview.addfunds.initiation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.IconButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.PaymentInitiationLimits;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity;
import fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep1Activity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class InitiationStep1Activity extends AllTrxStep1Activity implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, AbstractC1668ed.InterfaceC1669a {

    /* renamed from: F */
    public static final /* synthetic */ int f4756F = 0;

    /* renamed from: B */
    public final int f4757B = 4;

    /* renamed from: C */
    public final String f4758C = "PaymentInitiationLimits";

    /* renamed from: D */
    public PaymentInitiationLimits f4759D;

    /* renamed from: E */
    public PaymentInititationSessionStateReceiver f4760E;

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep1Activity$PaymentInititationSessionStateReceiver */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class PaymentInititationSessionStateReceiver extends BroadcastReceiver {
        public PaymentInititationSessionStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1766e(intent, "intent");
            int intExtra = intent.getIntExtra("fr.smoney.android.izly.sessionState", -1);
            if (intExtra == 0) {
                InitiationStep1Activity initiationStep1Activity = InitiationStep1Activity.this;
                int i = InitiationStep1Activity.f4756F;
                initiationStep1Activity.m979K();
            } else if (intExtra == 1) {
                InitiationStep1Activity initiationStep1Activity2 = InitiationStep1Activity.this;
                int i2 = InitiationStep1Activity.f4756F;
                initiationStep1Activity2.m917P();
            } else if (intExtra == 2) {
                InitiationStep1Activity initiationStep1Activity3 = InitiationStep1Activity.this;
                C0580Yc m1771u = C0580Yc.m1771u(initiationStep1Activity3, initiationStep1Activity3, EnumC1631dd.ConnexionErrorDuringIsSessionValid);
                int i3 = InitiationStep1Activity.f4756F;
                initiationStep1Activity3.f4197r.m126E(m1771u);
            }
        }
    }

    /* renamed from: P */
    public final void m917P() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c2329w8.f6816a.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 264 && valueAt.getStringExtra("fr.smoney.android.izly.extras.paymentInitiationLimitsUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.paymentInitiationLimitsSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 34);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.paymentInitiationLimitsUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.paymentInitiationLimitsSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                smoneyRequestManager.f4693f.f1737n0 = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 34, true);
    }

    /* renamed from: Q */
    public final void m916Q(PaymentInitiationLimits paymentInitiationLimits, ServerError serverError) {
        if (serverError != null) {
            if (serverError.f4601b == 1075) {
                this.f4197r.m126E(C0564Xc.m1793t(serverError.f4604f, serverError.f4603d, getString(2131689575), this, EnumC1631dd.AlertType));
            } else {
                this.f4197r.m124G(serverError);
            }
        } else if (paymentInitiationLimits == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            ConstraintLayout constraintLayout = ((AbstractC2028oc) this.f4202w).f5616l.f2057b;
            C0581Yd.m1767d(constraintLayout, "mDataBinding.secureTrans…iew.secureTransactionView");
            constraintLayout.setVisibility(0);
            this.f4759D = paymentInitiationLimits;
            C0581Yd.m1767d(this.f4197r.f6816a, "memoryProvider");
            Resources resources = getResources();
            PaymentInitiationLimits paymentInitiationLimits2 = this.f4759D;
            C0581Yd.m1768c(paymentInitiationLimits2);
            String string = resources.getString(2131689545, C0374Q7.m2089f(paymentInitiationLimits2.f4537b), AllTrxStep1Activity.f4781A);
            C0581Yd.m1767d(string, "resources.getString(R.st…!!.min), mCurrencySymbol)");
            PaymentInitiationLimits paymentInitiationLimits3 = this.f4759D;
            C0581Yd.m1768c(paymentInitiationLimits3);
            int[] iArr = paymentInitiationLimits3.f4538c;
            if (iArr != null) {
                PaymentInitiationLimits paymentInitiationLimits4 = this.f4759D;
                C0581Yd.m1768c(paymentInitiationLimits4);
                double d = paymentInitiationLimits4.f4537b;
                PaymentInitiationLimits paymentInitiationLimits5 = this.f4759D;
                C0581Yd.m1768c(paymentInitiationLimits5);
                m907M(iArr, d, paymentInitiationLimits5.f4536a, string);
                return;
            }
            C0581Yd.m1761j("stepsArray");
            throw null;
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd.ordinal() != 60) {
            super.mo241d(enumC1631dd);
            return;
        }
        this.f4197r.m118e(EnumC1631dd.InformationType);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 != 34) {
                return;
            }
            m916Q((PaymentInitiationLimits) bundle.getParcelable("fr.smoney.android.izly.extras.PaymentInititationLimits"), serverError);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType && m982H() == 34) {
            this.f4197r.m130A();
            finish();
        } else if (enumC1631dd == EnumC1631dd.InputPasswordType) {
            finish();
        } else {
            this.f4197r.m106q(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView.InterfaceC1818a
    /* renamed from: j */
    public void mo826j(boolean z) {
        boolean z2;
        if (z) {
            double m908L = m908L();
            PaymentInitiationLimits paymentInitiationLimits = this.f4759D;
            C0581Yd.m1768c(paymentInitiationLimits);
            if (m908L >= paymentInitiationLimits.f4537b) {
                double m908L2 = m908L();
                PaymentInitiationLimits paymentInitiationLimits2 = this.f4759D;
                C0581Yd.m1768c(paymentInitiationLimits2);
                if (m908L2 <= paymentInitiationLimits2.f4536a) {
                    z2 = true;
                    IconButton iconButton = ((AbstractC2028oc) this.f4202w).f5608c.f6633a;
                    C0581Yd.m1767d(iconButton, "mDataBinding.bSubmit.bSubmit");
                    iconButton.setEnabled(z2);
                }
            }
        }
        z2 = false;
        IconButton iconButton2 = ((AbstractC2028oc) this.f4202w).f5608c.f6633a;
        C0581Yd.m1767d(iconButton2, "mDataBinding.bSubmit.bSubmit");
        iconButton2.setEnabled(z2);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m100w(enumC1631dd, bundle);
        } else if (m982H() == 34) {
            m917P();
        } else {
            this.f4197r.m100w(enumC1631dd, bundle);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m103t(enumC1631dd);
        } else if (m982H() == 34) {
            finish();
        } else {
            this.f4197r.m103t(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        if (i != 34) {
            return;
        }
        m916Q(c0479u8.f1736n, c0479u8.f1738o);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC2028oc) obj).f5608c.f6633a) {
            Intent intent = new Intent(this, InitiationStep2WebviewActivity.class);
            intent.putExtra("fr.smoney.android.izly.ui.privateview.classic.AllTrxStep1Activity.MoneyAmountInCents", String.valueOf((int) (((AbstractC2028oc) obj).f5606a.m832a(this.f4197r) * 100)));
            startActivityForResult(intent, this.f4757B);
            finish();
        } else if (C0581Yd.m1770a(view, ((AbstractC2028oc) obj).f5607b)) {
            finish();
        } else if (C0581Yd.m1770a(view, ((AbstractC2028oc) this.f4202w).f5616l.f2056a)) {
            C0596Zc c0596Zc = C0596Zc.f2114h;
            C0581Yd.m1766e(this, "context");
            C0581Yd.m1766e(this, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            C0596Zc c0596Zc2 = new C0596Zc();
            Bundle m991m = c0596Zc2.m991m(this, C0596Zc.f2113g);
            C0581Yd.m1767d(m991m, "frag.addDefaultArguments…AGMENT_TYPE\n            )");
            m991m.putString("Argument.DialogTitle", getString(2131690069));
            c0596Zc2.setArguments(m991m);
            this.f4197r.m126E(c0596Zc2);
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690065), "getString(R.string.payment_initiation_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_TRANSPARENT, true, true);
        ((AbstractC2028oc) this.f4202w).f5608c.f6633a.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5607b.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5616l.f2056a.setOnClickListener(this);
        C0445T2 c0445t2 = new C0445T2();
        c0445t2.m2029d(((AbstractC2028oc) this.f4202w).f5610f);
        ConstraintLayout constraintLayout = ((AbstractC2028oc) this.f4202w).f5616l.f2057b;
        C0581Yd.m1767d(constraintLayout, "mDataBinding.secureTrans…iew.secureTransactionView");
        int id = constraintLayout.getId();
        CustomAmountToogleButtonView customAmountToogleButtonView = ((AbstractC2028oc) this.f4202w).f5606a;
        C0581Yd.m1767d(customAmountToogleButtonView, "mDataBinding.amountCustomView");
        c0445t2.m2028e(id, 3, customAmountToogleButtonView.getId(), 4);
        Button button = ((AbstractC2028oc) this.f4202w).f5607b;
        C0581Yd.m1767d(button, "mDataBinding.bAnuller");
        int id2 = button.getId();
        ConstraintLayout constraintLayout2 = ((AbstractC2028oc) this.f4202w).f5616l.f2057b;
        C0581Yd.m1767d(constraintLayout2, "mDataBinding.secureTrans…iew.secureTransactionView");
        c0445t2.m2028e(id2, 3, constraintLayout2.getId(), 4);
        c0445t2.m2031b(((AbstractC2028oc) this.f4202w).f5610f);
        m917P();
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.f4760E);
        this.f4760E = null;
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
        if (this.f4760E == null) {
            this.f4760E = new PaymentInititationSessionStateReceiver();
        }
        registerReceiver(this.f4760E, intentFilter);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PaymentInitiationLimits paymentInitiationLimits = this.f4759D;
        if (paymentInitiationLimits != null) {
            bundle.putParcelable(this.f4758C, paymentInitiationLimits);
        }
    }
}
