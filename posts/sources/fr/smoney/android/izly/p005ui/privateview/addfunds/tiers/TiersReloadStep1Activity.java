package fr.smoney.android.izly.p005ui.privateview.addfunds.tiers;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MakeMoneyInTiersData;
import fr.smoney.android.izly.data.model.MoneyInCbCbListData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep2ConfirmActivity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxWorkFlowObject;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.tiers.TiersReloadStep1Activity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class TiersReloadStep1Activity extends AllTrxStep1Activity implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, AbstractC1668ed.InterfaceC1669a, TextWatcher {

    /* renamed from: B */
    public final String f4779B = "moneyInCbCbListData";

    /* renamed from: C */
    public MoneyInCbCbListData f4780C;

    /* renamed from: P */
    public final void m910P() {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        LoginData loginData = c0479u8.f1712b;
        this.f4197r.m120c(smoneyRequestManager.m950h(loginData.f4362a, loginData.f4364c), 31, true);
    }

    /* renamed from: Q */
    public final void m909Q(MoneyInCbCbListData moneyInCbCbListData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (moneyInCbCbListData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            this.f4780C = moneyInCbCbListData;
            m906N(moneyInCbCbListData.f4425c);
            C0479U8 c0479u8 = this.f4197r.f6816a;
            C0581Yd.m1767d(c0479u8, "memoryProvider");
            String string = getResources().getString(2131689545, C0374Q7.m2089f(c0479u8.f1712b.f4367g), AllTrxStep1Activity.f4781A);
            C0581Yd.m1767d(string, "resources.getString(R.st…         mCurrencySymbol)");
            MoneyInCbCbListData moneyInCbCbListData2 = this.f4780C;
            C0581Yd.m1768c(moneyInCbCbListData2);
            int[] iArr = moneyInCbCbListData2.f4424b;
            C0581Yd.m1767d(iArr, "mMoneyInCbCbListData!!.stepArray");
            LoginData loginData = c0479u8.f1712b;
            m907M(iArr, loginData.f4367g, loginData.f4368h, string);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
        if ((r5.m824b().toString().length() > 0) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r5) {
        /*
            r4 = this;
            B extends androidx.databinding.ViewDataBinding r5 = r4.f4202w
            oc r5 = (p000.AbstractC2028oc) r5
            kc r5 = r5.f5620p
            androidx.constraintlayout.widget.ConstraintLayout r5 = r5.f5393b
            java.lang.String r0 = "mDataBinding.tiersInputView.tiersInputView"
            p000.C0581Yd.m1767d(r5, r0)
            int r5 = r5.getVisibility()
            java.lang.String r0 = "mDataBinding.tiersInputView.atvRecipient"
            r1 = 1
            if (r5 == 0) goto L34
            B extends androidx.databinding.ViewDataBinding r5 = r4.f4202w
            oc r5 = (p000.AbstractC2028oc) r5
            kc r5 = r5.f5620p
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r5 = r5.f5392a
            p000.C0581Yd.m1767d(r5, r0)
            java.lang.String r5 = r5.m824b()
            java.lang.String r5 = r5.toString()
            int r5 = r5.length()
            if (r5 <= 0) goto L31
            r5 = 1
            goto L32
        L31:
            r5 = 0
        L32:
            if (r5 == 0) goto L51
        L34:
            Kd r5 = p000.C0257Kd.f842a
            B extends androidx.databinding.ViewDataBinding r5 = r4.f4202w
            oc r5 = (p000.AbstractC2028oc) r5
            kc r5 = r5.f5620p
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r5 = r5.f5392a
            p000.C0581Yd.m1767d(r5, r0)
            java.lang.String r5 = r5.m824b()
            java.lang.String r5 = r5.toString()
            boolean r5 = p000.C0257Kd.m2234a(r5)
            if (r5 == 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.f4782x = r5
            B extends androidx.databinding.ViewDataBinding r5 = r4.f4202w
            oc r5 = (p000.AbstractC2028oc) r5
            Gb r5 = r5.f5613i
            android.widget.EditText r5 = r5.f503a
            java.lang.String r2 = "mDataBinding.layoutMessage.etMessage"
            p000.C0581Yd.m1767d(r5, r2)
            android.text.Editable r5 = r5.getText()
            int r5 = r5.length()
            r3 = 140(0x8c, float:1.96E-43)
            if (r5 <= r3) goto L8e
            B extends androidx.databinding.ViewDataBinding r5 = r4.f4202w
            oc r5 = (p000.AbstractC2028oc) r5
            Gb r5 = r5.f5613i
            android.widget.EditText r5 = r5.f503a
            p000.C0581Yd.m1767d(r5, r2)
            android.text.Editable r5 = r5.getText()
            java.lang.String r2 = "mDataBinding.layoutMessage.etMessage.text"
            p000.C0581Yd.m1767d(r5, r2)
            int r5 = r5.length()
            if (r5 != 0) goto L89
            r5 = 1
            goto L8a
        L89:
            r5 = 0
        L8a:
            if (r5 == 0) goto L8d
            goto L8e
        L8d:
            r1 = 0
        L8e:
            r4.f4783y = r1
            Kd r5 = p000.C0257Kd.f842a
            B extends androidx.databinding.ViewDataBinding r5 = r4.f4202w
            oc r5 = (p000.AbstractC2028oc) r5
            kc r5 = r5.f5620p
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r5 = r5.f5392a
            p000.C0581Yd.m1767d(r5, r0)
            java.lang.String r5 = r5.m824b()
            java.lang.String r5 = r5.toString()
            boolean r5 = p000.C0257Kd.m2234a(r5)
            r4.mo826j(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.addfunds.tiers.TiersReloadStep1Activity.afterTextChanged(android.text.Editable):void");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 != 31) {
                return;
            }
            m909Q((MoneyInCbCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbCbListData"), serverError);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType && m982H() == 31) {
            this.f4197r.m130A();
            finish();
            return;
        }
        this.f4197r.m106q(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m100w(enumC1631dd, bundle);
        } else if (m982H() == 31) {
            m910P();
        } else {
            this.f4197r.m100w(enumC1631dd, bundle);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m103t(enumC1631dd);
        } else if (m982H() == 31) {
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
        if (i != 31) {
            return;
        }
        m909Q(c0479u8.f1732l, c0479u8.f1734m);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC2028oc) obj).f5608c.f6633a) {
            C0257Kd c0257Kd = C0257Kd.f842a;
            CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2028oc) obj).f5620p.f5392a;
            C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.tiersInputView.atvRecipient");
            if (C0257Kd.m2234a(customBorderSimpleEditText.m824b().toString())) {
                Intent intent = new Intent(this, AllTrxStep2ConfirmActivity.class);
                AllTrxWorkFlowObject allTrxWorkFlowObject = new AllTrxWorkFlowObject();
                allTrxWorkFlowObject.f4799b = EnumC0115E8.RELOAD_TIERS;
                allTrxWorkFlowObject.f4800c = getString(2131690099);
                allTrxWorkFlowObject.f4801d = getString(2131689762);
                CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2028oc) this.f4202w).f5620p.f5392a;
                C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.tiersInputView.atvRecipient");
                allTrxWorkFlowObject.f4802f = customBorderSimpleEditText2.m824b().toString();
                double m908L = m908L();
                CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC2028oc) this.f4202w).f5620p.f5392a;
                C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.tiersInputView.atvRecipient");
                String str = customBorderSimpleEditText3.m824b().toString();
                EditText editText = ((AbstractC2028oc) this.f4202w).f5613i.f503a;
                C0581Yd.m1767d(editText, "mDataBinding.layoutMessage.etMessage");
                intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", new MakeMoneyInTiersData(null, m908L, str, editText.getText().toString()));
                intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", allTrxWorkFlowObject);
                startActivity(intent);
                return;
            }
            CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC2028oc) this.f4202w).f5620p.f5392a;
            C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.tiersInputView.atvRecipient");
            customBorderSimpleEditText4.setText(getString(2131689894));
        } else if (C0581Yd.m1770a(view, ((AbstractC2028oc) obj).f5607b)) {
            finish();
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131690093);
        C0581Yd.m1767d(string, "getString(R.string.recharge_par_tiers)");
        String upperCase = string.toUpperCase();
        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase()");
        c0297a.m2194a(this, upperCase, 2131230939, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_TRANSPARENT, true, (r19 & 128) != 0 ? false : false);
        ConstraintLayout constraintLayout = ((AbstractC2028oc) this.f4202w).f5620p.f5393b;
        C0581Yd.m1767d(constraintLayout, "mDataBinding.tiersInputView.tiersInputView");
        constraintLayout.setVisibility(0);
        ConstraintLayout constraintLayout2 = ((AbstractC2028oc) this.f4202w).f5613i.f504b;
        C0581Yd.m1767d(constraintLayout2, "mDataBinding.layoutMessage.layoutMessage");
        constraintLayout2.setVisibility(0);
        ((AbstractC2028oc) this.f4202w).f5608c.f6633a.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5607b.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5620p.f5392a.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5620p.f5392a.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC2028oc) this.f4202w).f5613i.f503a.addTextChangedListener(this);
        m910P();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        MoneyInCbCbListData moneyInCbCbListData = this.f4780C;
        if (moneyInCbCbListData != null) {
            bundle.putParcelable(this.f4779B, moneyInCbCbListData);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
