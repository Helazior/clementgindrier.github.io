package fr.smoney.android.izly.p005ui.privateview.addfunds.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import fr.smoney.android.izly.data.model.MoneyInCbCbListData;
import fr.smoney.android.izly.data.model.MoneyInCbData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep2ConfirmActivity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxWorkFlowObject;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleSpinner;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadStep1Activity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CardReloadStep1Activity extends AllTrxStep1Activity implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, AbstractC1668ed.InterfaceC1669a {

    /* renamed from: B */
    public final int f4751B = 3;

    /* renamed from: C */
    public final String f4752C = "moneyInCbCbListData";
    @Nullable

    /* renamed from: D */
    public C0277Lc f4753D;

    /* renamed from: E */
    public MoneyInCbCbListData f4754E;

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadStep1Activity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1790a implements AdapterView.OnItemSelectedListener {
        public C1790a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> adapterView, @NotNull View view, int i, long j) {
            C0581Yd.m1766e(view, "view");
            View findViewById = CardReloadStep1Activity.this.findViewById(2131296773);
            C0581Yd.m1767d(findViewById, "findViewById<View>(R.id.register_credit_card_view)");
            findViewById.setVisibility(8);
            C0277Lc c0277Lc = CardReloadStep1Activity.this.f4753D;
            C0581Yd.m1768c(c0277Lc);
            MoneyInCbCb item = c0277Lc.getItem(i);
            C0581Yd.m1768c(item);
            if (C0581Yd.m1770a(item.f4418a, "-1")) {
                View findViewById2 = CardReloadStep1Activity.this.findViewById(2131296773);
                C0581Yd.m1767d(findViewById2, "findViewById<View>(R.id.register_credit_card_view)");
                findViewById2.setVisibility(0);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
        }
    }

    /* renamed from: P */
    public final void m923P() {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        LoginData loginData = c0479u8.f1712b;
        this.f4197r.m120c(smoneyRequestManager.m950h(loginData.f4362a, loginData.f4364c), 31, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m922Q() {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.addfunds.cards.CardReloadStep1Activity.m922Q():void");
    }

    /* renamed from: R */
    public final void m921R(MoneyInCbCbListData moneyInCbCbListData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (moneyInCbCbListData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            this.f4754E = moneyInCbCbListData;
            m906N(moneyInCbCbListData.f4425c);
            ArrayList<MoneyInCbCb> arrayList = moneyInCbCbListData.f4423a;
            C0581Yd.m1767d(arrayList, "data.cbList");
            m918U(arrayList);
            m919T();
        }
    }

    /* renamed from: S */
    public final void m920S(MoneyInCbData moneyInCbData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (moneyInCbData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            m906N(moneyInCbData.f4436c);
            Intent intent = new Intent(this, AllTrxStep2ConfirmActivity.class);
            AllTrxWorkFlowObject allTrxWorkFlowObject = new AllTrxWorkFlowObject();
            allTrxWorkFlowObject.f4799b = EnumC0115E8.RELOAD_CB;
            allTrxWorkFlowObject.f4800c = getString(2131690099);
            MoneyInCbCb moneyInCbCb = moneyInCbData.f4434a.f4414c;
            allTrxWorkFlowObject.f4801d = moneyInCbCb.f4419b;
            allTrxWorkFlowObject.f4802f = moneyInCbCb.f4421d;
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", moneyInCbData);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", allTrxWorkFlowObject);
            startActivityForResult(intent, 55);
        }
    }

    /* renamed from: T */
    public final void m919T() {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        String string = getResources().getString(2131689545, C0374Q7.m2089f(c0479u8.f1712b.f4367g), AllTrxStep1Activity.f4781A);
        C0581Yd.m1767d(string, "resources.getString(R.st…Amount), mCurrencySymbol)");
        MoneyInCbCbListData moneyInCbCbListData = this.f4754E;
        C0581Yd.m1768c(moneyInCbCbListData);
        int[] iArr = moneyInCbCbListData.f4424b;
        C0581Yd.m1767d(iArr, "mMoneyInCbCbListData!!.stepArray");
        LoginData loginData = c0479u8.f1712b;
        m907M(iArr, loginData.f4367g, loginData.f4368h, string);
    }

    /* renamed from: U */
    public final void m918U(ArrayList<MoneyInCbCb> arrayList) {
        int i = 0;
        if (arrayList.size() == 0) {
            View findViewById = findViewById(2131296835);
            C0581Yd.m1767d(findViewById, "findViewById<View>(R.id.sp_card)");
            findViewById.setVisibility(8);
            View findViewById2 = findViewById(2131296773);
            C0581Yd.m1767d(findViewById2, "findViewById<View>(R.id.register_credit_card_view)");
            findViewById2.setVisibility(0);
            return;
        }
        arrayList.add(new MoneyInCbCb("-1", getString(2131689974)));
        if (this.f4753D == null) {
            this.f4753D = new C0277Lc(this);
            CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC2028oc) this.f4202w).f5618n;
            C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.spCard");
            Spinner spinner = customBorderSimpleSpinner.f4971a.f6629b;
            C0581Yd.m1767d(spinner, "mDataBinding.spCard.spinner");
            spinner.setAdapter((SpinnerAdapter) this.f4753D);
        }
        C0277Lc c0277Lc = this.f4753D;
        C0581Yd.m1768c(c0277Lc);
        c0277Lc.setNotifyOnChange(false);
        int i2 = 0;
        for (MoneyInCbCb moneyInCbCb : arrayList) {
            C0277Lc c0277Lc2 = this.f4753D;
            C0581Yd.m1768c(c0277Lc2);
            c0277Lc2.add(moneyInCbCb);
            if (moneyInCbCb.f4422f) {
                i = i2;
            }
            i2++;
        }
        ((AbstractC2028oc) this.f4202w).f5618n.setSelection(i);
        C0277Lc c0277Lc3 = this.f4753D;
        C0581Yd.m1768c(c0277Lc3);
        c0277Lc3.notifyDataSetChanged();
        CustomBorderSimpleSpinner customBorderSimpleSpinner2 = ((AbstractC2028oc) this.f4202w).f5618n;
        C0581Yd.m1767d(customBorderSimpleSpinner2, "mDataBinding.spCard");
        Spinner spinner2 = customBorderSimpleSpinner2.f4971a.f6629b;
        C0581Yd.m1767d(spinner2, "mDataBinding.spCard.spinner");
        spinner2.setOnItemSelectedListener(new C1790a());
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 31) {
                m921R((MoneyInCbCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbCbListData"), serverError);
            } else if (i2 != 32) {
            } else {
                m920S((MoneyInCbData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbData"), serverError);
            }
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

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0.getSelectedItemPosition() != (-1)) goto L9;
     */
    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView.InterfaceC1818a
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo826j(boolean r5) {
        /*
            r4 = this;
            Lc r0 = r4.f4753D
            if (r0 == 0) goto L1f
            B extends androidx.databinding.ViewDataBinding r0 = r4.f4202w
            oc r0 = (p000.AbstractC2028oc) r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleSpinner r0 = r0.f5618n
            java.lang.String r1 = "mDataBinding.spCard"
            p000.C0581Yd.m1767d(r0, r1)
            ua r0 = r0.f4971a
            android.widget.Spinner r0 = r0.f6629b
            java.lang.String r1 = "mDataBinding.spCard.spinner"
            p000.C0581Yd.m1767d(r0, r1)
            int r0 = r0.getSelectedItemPosition()
            r1 = -1
            if (r0 == r1) goto L43
        L1f:
            if (r5 == 0) goto L43
            double r0 = r4.m908L()
            w8 r5 = r4.f4197r
            U8 r5 = r5.f6816a
            fr.smoney.android.izly.data.model.LoginData r5 = r5.f1712b
            double r2 = r5.f4367g
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L43
            double r0 = r4.m908L()
            w8 r5 = r4.f4197r
            U8 r5 = r5.f6816a
            fr.smoney.android.izly.data.model.LoginData r5 = r5.f1712b
            double r2 = r5.f4368h
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 > 0) goto L43
            r5 = 1
            goto L44
        L43:
            r5 = 0
        L44:
            B extends androidx.databinding.ViewDataBinding r0 = r4.f4202w
            oc r0 = (p000.AbstractC2028oc) r0
            uc r0 = r0.f5608c
            android.widget.IconButton r0 = r0.f6633a
            java.lang.String r1 = "mDataBinding.bSubmit.bSubmit"
            p000.C0581Yd.m1767d(r0, r1)
            r0.setEnabled(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.addfunds.cards.CardReloadStep1Activity.mo826j(boolean):void");
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m100w(enumC1631dd, bundle);
            return;
        }
        int m982H = m982H();
        if (m982H == 31) {
            m923P();
        } else if (m982H != 32) {
            this.f4197r.m100w(enumC1631dd, bundle);
        } else {
            m922Q();
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
        if (i == 31) {
            m921R(c0479u8.f1732l, c0479u8.f1734m);
        } else if (i != 32) {
        } else {
            m920S(c0479u8.f1740p, c0479u8.f1742q);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == this.f4751B) {
            if (i2 == -1) {
                finish();
            }
        } else if (i != 55) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC2028oc) obj).f5608c.f6633a) {
            CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC2028oc) obj).f5618n;
            C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.spCard");
            Spinner spinner = customBorderSimpleSpinner.f4971a.f6629b;
            C0581Yd.m1767d(spinner, "mDataBinding.spCard.spinner");
            if (spinner.getAdapter() != null) {
                CustomBorderSimpleSpinner customBorderSimpleSpinner2 = ((AbstractC2028oc) this.f4202w).f5618n;
                C0581Yd.m1767d(customBorderSimpleSpinner2, "mDataBinding.spCard");
                Spinner spinner2 = customBorderSimpleSpinner2.f4971a.f6629b;
                C0581Yd.m1767d(spinner2, "mDataBinding.spCard.spinner");
                SpinnerAdapter adapter = spinner2.getAdapter();
                C0581Yd.m1767d(adapter, "mDataBinding.spCard.spinner.adapter");
                if (adapter.getCount() > 1) {
                    CustomBorderSimpleSpinner customBorderSimpleSpinner3 = ((AbstractC2028oc) this.f4202w).f5618n;
                    C0581Yd.m1767d(customBorderSimpleSpinner3, "mDataBinding.spCard");
                    Spinner spinner3 = customBorderSimpleSpinner3.f4971a.f6629b;
                    C0581Yd.m1767d(spinner3, "mDataBinding.spCard.spinner");
                    int selectedItemPosition = spinner3.getSelectedItemPosition();
                    CustomBorderSimpleSpinner customBorderSimpleSpinner4 = ((AbstractC2028oc) this.f4202w).f5618n;
                    C0581Yd.m1767d(customBorderSimpleSpinner4, "mDataBinding.spCard");
                    Spinner spinner4 = customBorderSimpleSpinner4.f4971a.f6629b;
                    C0581Yd.m1767d(spinner4, "mDataBinding.spCard.spinner");
                    SpinnerAdapter adapter2 = spinner4.getAdapter();
                    C0581Yd.m1767d(adapter2, "mDataBinding.spCard.spinner.adapter");
                    if (selectedItemPosition != adapter2.getCount() - 1) {
                        m922Q();
                        return;
                    }
                }
            }
            double m908L = m908L();
            Intent intent = new Intent(this, CardReloadNewCardStep2WebActivity.class);
            intent.putExtra("fr.smoney.android.izly.intentExtraMode", 1);
            intent.putExtra("fr.smoney.android.izly.ui.privateview.classic.AllTrxStep1Activity.MoneyInAmount", m908L);
            CheckBox checkBox = ((AbstractC2028oc) this.f4202w).f5614j.f1766a;
            C0581Yd.m1767d(checkBox, "mDataBinding.registerCreditCardView.cbRegisterCard");
            intent.putExtra("fr.smoney.android.izly.ui.privateview.classic.AllTrxStep1Activity.MoneyInRegisteredCard", checkBox.isChecked());
            startActivityForResult(intent, this.f4751B);
            finish();
        } else if (C0581Yd.m1770a(view, ((AbstractC2028oc) obj).f5607b)) {
            finish();
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690095), "getString(R.string.recharge_with_cb)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_TRANSPARENT, true, true);
        CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC2028oc) this.f4202w).f5618n;
        C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.spCard");
        customBorderSimpleSpinner.setVisibility(0);
        ((AbstractC2028oc) this.f4202w).f5608c.f6633a.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5607b.setOnClickListener(this);
        if (bundle != null) {
            this.f4754E = (MoneyInCbCbListData) bundle.getParcelable(this.f4752C);
        }
        MoneyInCbCbListData moneyInCbCbListData = this.f4754E;
        if (moneyInCbCbListData != null) {
            C0581Yd.m1768c(moneyInCbCbListData);
            ArrayList<MoneyInCbCb> arrayList = moneyInCbCbListData.f4423a;
            C0581Yd.m1767d(arrayList, "mMoneyInCbCbListData!!.cbList");
            m918U(arrayList);
            m919T();
            return;
        }
        m923P();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        MoneyInCbCbListData moneyInCbCbListData = this.f4754E;
        if (moneyInCbCbListData != null) {
            bundle.putParcelable(this.f4752C, moneyInCbCbListData);
        }
    }
}
