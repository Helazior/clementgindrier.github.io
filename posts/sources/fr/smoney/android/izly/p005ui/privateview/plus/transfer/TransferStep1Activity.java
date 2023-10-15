package fr.smoney.android.izly.p005ui.privateview.plus.transfer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.smoney.android.izly.data.model.BalanceData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MoneyOutTransferAccountData;
import fr.smoney.android.izly.data.model.MoneyOutTransferData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep2ConfirmActivity;
import fr.smoney.android.izly.p005ui.privateview.home.AllTrxWorkFlowObject;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.account.myaccount.AddTransferAccountActivity;
import fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.transfer.TransferStep1Activity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class TransferStep1Activity extends AllTrxStep1Activity implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, AbstractC1668ed.InterfaceC1669a, TextWatcher {

    /* renamed from: B */
    public final int f4876B = 10;

    /* renamed from: C */
    public double f4877C;

    /* renamed from: P */
    public final void m861P() {
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
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 51 && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferAccountUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferAccountSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 51);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferAccountUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferAccountSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1750u = null;
                c0479u82.f1752v = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 51, true);
    }

    /* renamed from: Q */
    public final void m860Q() {
        int i;
        double d = this.f4877C;
        if (m859R(d)) {
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
                    int i3 = size;
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 52 && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferSessionId").equals(str2) && valueAt.getDoubleExtra("fr.smoney.android.izly.extras.moneyOutTransferAmount", -1.0d) == d && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferLabel").equals("")) {
                        i = smoneyRequestManager.f4688a.keyAt(i2);
                        break;
                    } else {
                        i2++;
                        size = i3;
                    }
                } else {
                    int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                    intent.putExtra("com.foxykeep.datadroid.extras.workerType", 52);
                    intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                    intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                    intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferUserId", str);
                    intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferSessionId", str2);
                    intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferAmount", d);
                    intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferLabel", "");
                    smoneyRequestManager.m956b(intent);
                    smoneyRequestManager.f4688a.append(nextInt, intent);
                    C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                    c0479u82.f1754w = null;
                    c0479u82.f1756x = null;
                    i = nextInt;
                    break;
                }
            }
            this.f4197r.m120c(i, 52, true);
        }
    }

    /* renamed from: R */
    public boolean m859R(double d) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        double d2 = 0;
        if (d <= d2) {
            this.f4197r.m126E(C0543Wc.m1819s(getString(2131689826), getString(2131689825), getString(17039370)));
            return false;
        }
        LoginData loginData = c0479u8.f1712b;
        double d3 = loginData.f4369i;
        if (d < d3 && d3 >= d2) {
            this.f4197r.m126E(C0543Wc.m1819s(getString(2131689824), getString(2131689823), getString(17039370)));
            return false;
        }
        double d4 = loginData.f4370j;
        if (d > d4 && d4 >= d2) {
            this.f4197r.m126E(C0543Wc.m1819s(getString(2131689819), getString(2131689818), getString(17039370)));
            return false;
        } else if (d > loginData.f4351D.f4230a) {
            this.f4197r.m126E(C0543Wc.m1819s(getString(2131689819), getString(2131689820), getString(17039370)));
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: S */
    public final void m858S(MoneyOutTransferAccountData moneyOutTransferAccountData, ServerError serverError) {
        int[] iArr = new int[0];
        if (serverError != null) {
            m856U(iArr);
            int i = serverError.f4601b;
            if (i == 302) {
                this.f4197r.m126E(C0525Vc.m1826s(getString(2131689536), getString(2131689535), getString(2131689829), getString(2131689583), this, EnumC1631dd.NoTransferDetails));
            } else if (i != 390) {
                this.f4197r.m124G(serverError);
            } else {
                this.f4197r.m126E(C0564Xc.m1793t(serverError.f4604f, serverError.f4603d, getString(2131689575), this, EnumC1631dd.ErrorType));
            }
        } else if (moneyOutTransferAccountData == null) {
            m856U(iArr);
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            LoginData loginData = this.f4197r.f6816a.f1712b;
            BalanceData balanceData = moneyOutTransferAccountData.f4441f;
            loginData.f4351D = balanceData;
            m906N(balanceData);
            TextView textView = ((AbstractC2028oc) this.f4202w).f5622r.f5502b;
            C0581Yd.m1767d(textView, "mDataBinding.transfer.accountToCreditTv");
            textView.setText(moneyOutTransferAccountData.f4437a);
            m856U(iArr);
        }
    }

    /* renamed from: T */
    public final void m857T(MoneyOutTransferData moneyOutTransferData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (moneyOutTransferData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            m906N(moneyOutTransferData.f4459i);
            AllTrxWorkFlowObject allTrxWorkFlowObject = new AllTrxWorkFlowObject();
            allTrxWorkFlowObject.f4799b = EnumC0115E8.TRANSFER;
            allTrxWorkFlowObject.f4800c = getString(2131690244);
            allTrxWorkFlowObject.f4801d = moneyOutTransferData.f4453b;
            allTrxWorkFlowObject.f4802f = moneyOutTransferData.f4454c;
            Intent intent = new Intent(this, AllTrxStep2ConfirmActivity.class);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", moneyOutTransferData);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", allTrxWorkFlowObject);
            startActivity(intent);
        }
    }

    /* renamed from: U */
    public final void m856U(int[] iArr) {
        String string = getResources().getString(2131690245, C0374Q7.m2089f(this.f4197r.f6816a.f1712b.f4369i), C0374Q7.m2089f(this.f4197r.f6816a.f1712b.f4370j));
        C0581Yd.m1767d(string, "resources.getString(R.st…nData.moneyOutMaxAmount))");
        LoginData loginData = this.f4197r.f6816a.f1712b;
        m907M(iArr, loginData.f4369i, loginData.f4370j, string);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        mo826j(true);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd.ordinal() != 1) {
            super.mo241d(enumC1631dd);
        } else {
            finish();
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 51) {
                m858S((MoneyOutTransferAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyOutTransferAccountData"), serverError);
            } else if (i2 == 52) {
                m857T((MoneyOutTransferData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyOutTransferData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType && m982H() == 51) {
            this.f4197r.m130A();
            finish();
        } else if (enumC1631dd == EnumC1631dd.NoTransferDetails) {
            finish();
        } else {
            this.f4197r.m106q(enumC1631dd);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006c, code lost:
        if (r0 <= r8.f4370j) goto L11;
     */
    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView.InterfaceC1818a
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo826j(boolean r8) {
        /*
            r7 = this;
            B extends androidx.databinding.ViewDataBinding r0 = r7.f4202w
            oc r0 = (p000.AbstractC2028oc) r0
            mc r0 = r0.f5622r
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r0 = r0.f5503c
            java.lang.String r1 = "mDataBinding.transfer.customTransferAmout"
            p000.C0581Yd.m1767d(r0, r1)
            sa r0 = r0.f4966a
            android.widget.EditText r0 = r0.f6403a
            java.lang.String r2 = "mDataBinding.transfer.customTransferAmout.editText"
            p000.C0581Yd.m1767d(r0, r2)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r3 = "mDataBinding.transfer.cu…ansferAmout.editText.text"
            p000.C0581Yd.m1767d(r0, r3)
            int r0 = r0.length()
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 != 0) goto L58
            ce r0 = new ce
            java.lang.String r6 = ","
            r0.<init>(r6)
            B extends androidx.databinding.ViewDataBinding r6 = r7.f4202w
            oc r6 = (p000.AbstractC2028oc) r6
            mc r6 = r6.f5622r
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r6 = r6.f5503c
            p000.C0581Yd.m1767d(r6, r1)
            sa r1 = r6.f4966a
            android.widget.EditText r1 = r1.f6403a
            p000.C0581Yd.m1767d(r1, r2)
            java.lang.CharSequence r1 = r1.getText()
            p000.C0581Yd.m1767d(r1, r3)
            java.lang.String r2 = "."
            java.lang.String r0 = r0.m1120a(r1, r2)
            double r0 = java.lang.Double.parseDouble(r0)
            r7.f4877C = r0
        L58:
            if (r8 == 0) goto L6f
            double r0 = r7.f4877C
            w8 r8 = r7.f4197r
            U8 r8 = r8.f6816a
            fr.smoney.android.izly.data.model.LoginData r8 = r8.f1712b
            double r2 = r8.f4369i
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 < 0) goto L6f
            double r2 = r8.f4370j
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 > 0) goto L6f
            goto L70
        L6f:
            r4 = 0
        L70:
            B extends androidx.databinding.ViewDataBinding r8 = r7.f4202w
            oc r8 = (p000.AbstractC2028oc) r8
            uc r8 = r8.f5608c
            android.widget.IconButton r8 = r8.f6633a
            java.lang.String r0 = "mDataBinding.bSubmit.bSubmit"
            p000.C0581Yd.m1767d(r8, r0)
            r8.setEnabled(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.plus.transfer.TransferStep1Activity.mo826j(boolean):void");
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                int m982H = m982H();
                if (m982H == 51) {
                    m861P();
                    return;
                } else if (m982H != 52) {
                    this.f4197r.m100w(enumC1631dd, bundle);
                    return;
                } else {
                    m860Q();
                    return;
                }
            } else if (ordinal == 59) {
                Intent intent = new Intent(this, AddTransferAccountActivity.class);
                intent.putExtra("fr.smoney.android.izly.intentExtrasMode", 0);
                startActivityForResult(intent, this.f4876B);
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
                if (m982H() == 51) {
                    finish();
                    return;
                } else {
                    this.f4197r.m103t(enumC1631dd);
                    return;
                }
            } else if (ordinal == 59) {
                finish();
                return;
            }
        }
        this.f4197r.m103t(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 51) {
            m858S(c0479u8.f1750u, c0479u8.f1752v);
        } else if (i == 52) {
            m857T(c0479u8.f1754w, c0479u8.f1756x);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != this.f4876B) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            m861P();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC2028oc) obj).f5608c.f6633a) {
            m860Q();
        } else if (C0581Yd.m1770a(view, ((AbstractC2028oc) obj).f5607b)) {
            finish();
        }
    }

    @Override // fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep1Activity, fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689946), "getString(R.string.menu_entries_money_out)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230932, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, false);
        ImageView imageView = ((AbstractC2028oc) this.f4202w).f5609d;
        C0581Yd.m1767d(imageView, "mDataBinding.bigSquare");
        imageView.setVisibility(8);
        LinearLayout linearLayout = ((AbstractC2028oc) this.f4202w).f5612h;
        C0581Yd.m1767d(linearLayout, "mDataBinding.firstCircle");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = ((AbstractC2028oc) this.f4202w).f5615k;
        C0581Yd.m1767d(linearLayout2, "mDataBinding.secondCircle");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = ((AbstractC2028oc) this.f4202w).f5619o;
        C0581Yd.m1767d(linearLayout3, "mDataBinding.thirdCircle");
        linearLayout3.setVisibility(8);
        ConstraintLayout constraintLayout = ((AbstractC2028oc) this.f4202w).f5622r.f5504d;
        C0581Yd.m1767d(constraintLayout, "mDataBinding.transfer.transferLayoutConstraint");
        constraintLayout.setVisibility(0);
        CustomAmountToogleButtonView customAmountToogleButtonView = ((AbstractC2028oc) this.f4202w).f5606a;
        C0581Yd.m1767d(customAmountToogleButtonView, "mDataBinding.amountCustomView");
        customAmountToogleButtonView.setVisibility(8);
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2028oc) this.f4202w).f5622r.f5503c;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.transfer.customTransferAmout");
        EditText editText = customBorderSimpleEditText.f4966a.f6403a;
        C0581Yd.m1767d(editText, "mDataBinding.transfer.customTransferAmout.editText");
        editText.setHint(getString(2131689763, new Object[]{C0374Q7.m2089f(this.f4197r.f6816a.f1712b.f4369i)}));
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2028oc) this.f4202w).f5622r.f5503c;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.transfer.customTransferAmout");
        EditText editText2 = customBorderSimpleEditText2.f4966a.f6403a;
        C0581Yd.m1767d(editText2, "mDataBinding.transfer.customTransferAmout.editText");
        editText2.setInputType(8192);
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC2028oc) this.f4202w).f5622r.f5503c;
        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.transfer.customTransferAmout");
        customBorderSimpleEditText3.f4966a.f6403a.addTextChangedListener(this);
        CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC2028oc) this.f4202w).f5622r.f5503c;
        C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.transfer.customTransferAmout");
        EditText editText3 = customBorderSimpleEditText4.f4966a.f6403a;
        C0581Yd.m1767d(editText3, "mDataBinding.transfer.customTransferAmout.editText");
        editText3.setKeyListener(new C0180Hd(true, 3, 2, 7));
        TextView textView = ((AbstractC2028oc) this.f4202w).f5622r.f5501a;
        C0581Yd.m1767d(textView, "mDataBinding.transfer.accountToCreditLabel");
        textView.setText(getString(2131690242));
        ((AbstractC2028oc) this.f4202w).f5608c.f6633a.setOnClickListener(this);
        ((AbstractC2028oc) this.f4202w).f5607b.setOnClickListener(this);
        m861P();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
