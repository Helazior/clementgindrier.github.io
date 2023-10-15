package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mycards;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.CbChangeAliasData;
import fr.smoney.android.izly.data.model.CbDeleteData;
import fr.smoney.android.izly.data.model.ChooseDefaultCbData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbEditActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CbEditActivity extends SmoneyABSActivity<AbstractC1665ea> implements View.OnClickListener, SmoneyRequestManager.InterfaceC1778a, TextWatcher {

    /* renamed from: x */
    public MoneyInCbCb f4840x;

    /* renamed from: y */
    public String f4841y;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492916;
    }

    /* renamed from: L */
    public final void m883L() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        MoneyInCbCb moneyInCbCb = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb);
        String str3 = moneyInCbCb.f4418a;
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC1665ea) this.f4202w).f4154g;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etAlias");
        String m824b = customBorderSimpleEditText.m824b();
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 81 && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasCardId").equals(str3) && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasNewAlias").equals(m824b)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 81);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.cbChangeAliasUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.cbChangeAliasSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.cbChangeAliasCardId", str3);
                intent.putExtra("fr.smoney.android.izly.extras.cbChangeAliasNewAlias", m824b);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1678A = null;
                c0479u82.f1680B = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 81, true);
    }

    /* renamed from: M */
    public final void m882M() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        MoneyInCbCb moneyInCbCb = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb);
        String str3 = moneyInCbCb.f4418a;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 82 && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbDeleteUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbDeleteSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.cbDeletCardId").equals(str3)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 82);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.cbDeleteUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.cbDeleteSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.cbDeletCardId", str3);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1682C = null;
                c0479u82.f1684D = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 82, true);
    }

    /* renamed from: N */
    public final void m881N(CbChangeAliasData cbChangeAliasData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (cbChangeAliasData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC1665ea) this.f4202w).f4154g;
            C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etAlias");
            this.f4841y = customBorderSimpleEditText.m824b();
            setResult(-1);
            finish();
        }
    }

    /* renamed from: O */
    public final void m880O(ChooseDefaultCbData chooseDefaultCbData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (chooseDefaultCbData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            MoneyInCbCb moneyInCbCb = this.f4840x;
            C0581Yd.m1768c(moneyInCbCb);
            moneyInCbCb.f4422f = true;
            Toast.makeText(this, 2131689603, 1).show();
            m879P();
        }
    }

    /* renamed from: P */
    public final void m879P() {
        MoneyInCbCb moneyInCbCb = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb);
        if (!moneyInCbCb.f4422f) {
            TextView textView = ((AbstractC1665ea) this.f4202w).f4157j;
            C0581Yd.m1767d(textView, "mDataBinding.tvCheckbox");
            textView.setVisibility(8);
            ImageView imageView = ((AbstractC1665ea) this.f4202w).f4153f;
            C0581Yd.m1767d(imageView, "mDataBinding.checkbox");
            imageView.setVisibility(8);
        } else {
            TextView textView2 = ((AbstractC1665ea) this.f4202w).f4157j;
            C0581Yd.m1767d(textView2, "mDataBinding.tvCheckbox");
            textView2.setVisibility(0);
            ImageView imageView2 = ((AbstractC1665ea) this.f4202w).f4153f;
            C0581Yd.m1767d(imageView2, "mDataBinding.checkbox");
            imageView2.setVisibility(0);
        }
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC1665ea) this.f4202w).f4154g;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etAlias");
        MoneyInCbCb moneyInCbCb2 = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb2);
        customBorderSimpleEditText.setText(moneyInCbCb2.f4419b);
        TextView textView3 = ((AbstractC1665ea) this.f4202w).f4158k;
        C0581Yd.m1767d(textView3, "mDataBinding.tvType");
        MoneyInCbCb moneyInCbCb3 = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb3);
        textView3.setText(MoneyInCbCb.m968a(this, moneyInCbCb3.f4420c));
        TextView textView4 = ((AbstractC1665ea) this.f4202w).f4155h;
        C0581Yd.m1767d(textView4, "mDataBinding.tvCardNumber");
        MoneyInCbCb moneyInCbCb4 = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb4);
        textView4.setText(moneyInCbCb4.f4421d);
        Button button = ((AbstractC1665ea) this.f4202w).f4150b;
        C0581Yd.m1767d(button, "mDataBinding.bDefault");
        MoneyInCbCb moneyInCbCb5 = this.f4840x;
        C0581Yd.m1768c(moneyInCbCb5);
        button.setEnabled(!moneyInCbCb5.f4422f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        if ((r5.length() > 0) != false) goto L7;
     */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void afterTextChanged(@org.jetbrains.annotations.NotNull android.text.Editable r5) {
        /*
            r4 = this;
            java.lang.String r0 = "s"
            p000.C0581Yd.m1766e(r5, r0)
            java.lang.String r5 = r5.toString()
            B extends androidx.databinding.ViewDataBinding r0 = r4.f4202w
            ea r0 = (p000.AbstractC1665ea) r0
            android.widget.Button r0 = r0.f4152d
            java.lang.String r1 = "mDataBinding.bSubmit"
            p000.C0581Yd.m1767d(r0, r1)
            java.lang.String r1 = r4.f4841y
            boolean r1 = p000.C0581Yd.m1770a(r5, r1)
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            if (r1 == 0) goto L2b
            int r5 = r5.length()
            if (r5 <= 0) goto L27
            r5 = 1
            goto L28
        L27:
            r5 = 0
        L28:
            if (r5 == 0) goto L2b
            goto L2c
        L2b:
            r2 = 0
        L2c:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mycards.CbEditActivity.afterTextChanged(android.text.Editable):void");
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
            if (i2 == 81) {
                m881N((CbChangeAliasData) bundle.getParcelable("fr.smoney.android.izly.extras.cbChangeAliasData"), serverError);
            } else if (i2 != 82) {
                if (i2 != 211) {
                    return;
                }
                m880O((ChooseDefaultCbData) bundle.getParcelable("fr.smoney.android.izly.extras.chooseDefaultIdData"), serverError);
            } else {
                CbDeleteData cbDeleteData = (CbDeleteData) bundle.getParcelable("fr.smoney.android.izly.extras.chooseDefaultIdData");
                if (serverError != null) {
                    this.f4197r.m124G(serverError);
                    return;
                }
                setResult(-1);
                finish();
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        int i;
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                int m982H = m982H();
                if (m982H == 81) {
                    m883L();
                    return;
                } else if (m982H == 82) {
                    m882M();
                    return;
                } else {
                    this.f4197r.m100w(enumC1631dd, bundle);
                    return;
                }
            } else if (ordinal == 21) {
                m882M();
                return;
            } else if (ordinal == 47) {
                MoneyInCbCb moneyInCbCb = this.f4840x;
                C0581Yd.m1768c(moneyInCbCb);
                String str = moneyInCbCb.f4418a;
                C0581Yd.m1767d(str, "mCb!!.id");
                C2329w8 c2329w8 = this.f4197r;
                C0479U8 c0479u8 = c2329w8.f6816a;
                SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
                LoginData loginData = c0479u8.f1712b;
                String str2 = loginData.f4362a;
                String str3 = loginData.f4364c;
                int size = smoneyRequestManager.f4688a.size();
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                        if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 211 && valueAt.getStringExtra("fr.smoney.android.izly.extras.chooseDefaultCbUserId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.chooseDefaultCbSessionId").equals(str3) && valueAt.getStringExtra("fr.smoney.android.izly.extras.chooseDefaultCbCardId").equals(str)) {
                            i = smoneyRequestManager.f4688a.keyAt(i2);
                            break;
                        }
                        i2++;
                    } else {
                        int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                        Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 211);
                        intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                        intent.putExtra("fr.smoney.android.izly.extras.chooseDefaultCbUserId", str2);
                        intent.putExtra("fr.smoney.android.izly.extras.chooseDefaultCbSessionId", str3);
                        intent.putExtra("fr.smoney.android.izly.extras.chooseDefaultCbCardId", str);
                        smoneyRequestManager.m956b(intent);
                        smoneyRequestManager.f4688a.append(nextInt, intent);
                        C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                        c0479u82.f1699P = null;
                        c0479u82.f1700Q = null;
                        i = nextInt;
                        break;
                    }
                }
                this.f4197r.m120c(i, 211, true);
                return;
            }
        }
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        if (i == 81) {
            m881N(c0479u8.f1678A, c0479u8.f1680B);
        } else if (i != 82) {
            if (i != 211) {
                return;
            }
            m880O(c0479u8.f1699P, c0479u8.f1700Q);
        } else {
            CbDeleteData cbDeleteData = c0479u8.f1682C;
            ServerError serverError = c0479u8.f1684D;
            if (serverError != null) {
                c2329w8.m124G(serverError);
                return;
            }
            setResult(-1);
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        this.f2196f.m1721a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC1665ea) obj).f4152d) {
            m883L();
        } else if (view == ((AbstractC1665ea) obj).f4151c) {
            this.f4197r.m126E(C0525Vc.m1826s(getString(2131689601), getString(2131689600, new Object[]{this.f4841y}), getString(2131689599), getString(2131689583), this, EnumC1631dd.CBDeleteType));
        } else if (view == ((AbstractC1665ea) obj).f4150b) {
            this.f4197r.m126E(C0525Vc.m1826s(getString(2131689604), "", getString(2131689599), getString(2131689583), this, EnumC1631dd.SelectDefaultCbType));
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689597);
        C0581Yd.m1767d(string, "getString(R.string.cb_edit_card_title)");
        c0297a.m2194a(this, string, null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_GREY, true, false);
        ((AbstractC1665ea) this.f4202w).f4154g.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC1665ea) this.f4202w).f4152d.setOnClickListener(this);
        ((AbstractC1665ea) this.f4202w).f4151c.setOnClickListener(this);
        ((AbstractC1665ea) this.f4202w).f4150b.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            MoneyInCbCb moneyInCbCb = (MoneyInCbCb) intent.getParcelableExtra("intentExtraCb");
            this.f4840x = moneyInCbCb;
            C0581Yd.m1768c(moneyInCbCb);
            this.f4841y = moneyInCbCb.f4419b;
        }
        m879P();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
