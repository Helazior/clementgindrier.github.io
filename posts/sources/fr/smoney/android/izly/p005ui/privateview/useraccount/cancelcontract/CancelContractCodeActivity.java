package fr.smoney.android.izly.p005ui.privateview.useraccount.cancelcontract;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.cancelcontract.CancelContractCodeActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CancelContractCodeActivity extends SmoneyABSActivity<AbstractC0577Y9> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, TextWatcher {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492913;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0577Y9) this.f4202w).f2052d;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.cbsetCancelContractCode");
        EditText editText = customBorderSimpleEditText.f4966a.f6403a;
        C0581Yd.m1767d(editText, "mDataBinding.cbsetCancelContractCode.editText");
        CharSequence text = editText.getText();
        C0581Yd.m1767d(text, "mDataBinding.cbsetCancelContractCode.editText.text");
        if (text.length() == 0) {
            return;
        }
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0577Y9) this.f4202w).f2052d;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.cbsetCancelContractCode");
        EditText editText2 = customBorderSimpleEditText2.f4966a.f6403a;
        C0581Yd.m1767d(editText2, "mDataBinding.cbsetCancelContractCode.editText");
        if (editText2.getText().length() == 6) {
            Button button = ((AbstractC0577Y9) this.f4202w).f2051c;
            C0581Yd.m1767d(button, "mDataBinding.btnConfirm");
            button.setEnabled(true);
        }
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
            if (i2 == 280) {
                String str = (String) bundle.getParcelable("fr.smoney.android.izly.extras.CheckResendConfirmationCode");
                if (serverError != null) {
                    this.f4197r.m124G(serverError);
                }
            } else if (i2 != 281) {
            } else {
                String str2 = (String) bundle.getParcelable("fr.smoney.android.izly.extras.TerminateContract");
                if (serverError != null) {
                    this.f4197r.m124G(serverError);
                } else if (str2 == null) {
                    startActivity(new Intent(this, CancelContractResultActivity.class));
                }
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        if (i == 280) {
            String str = c0479u8.f1757x0;
            ServerError serverError = c0479u8.f1759y0;
            if (serverError != null) {
                c2329w8.m124G(serverError);
            }
        } else if (i != 281) {
        } else {
            String str2 = c0479u8.f1761z0;
            ServerError serverError2 = c0479u8.f1679A0;
            if (serverError2 != null) {
                c2329w8.m124G(serverError2);
            } else if (str2 == null) {
                startActivity(new Intent(this, CancelContractResultActivity.class));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        int i;
        int i2;
        int i3 = -1;
        int i4 = 0;
        if (C0581Yd.m1770a(view, ((AbstractC0577Y9) this.f4202w).f2051c)) {
            CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0577Y9) this.f4202w).f2052d;
            C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.cbsetCancelContractCode");
            if (customBorderSimpleEditText.getChildCount() == 0) {
                return;
            }
            CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0577Y9) this.f4202w).f2052d;
            C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.cbsetCancelContractCode");
            String m824b = customBorderSimpleEditText2.m824b();
            C0581Yd.m1767d(m824b, "mDataBinding.cbsetCancelContractCode.text");
            C0581Yd.m1766e(m824b, "otp");
            C2329w8 c2329w8 = this.f4197r;
            SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
            LoginData loginData = c2329w8.f6816a.f1712b;
            String str = loginData.f4362a;
            String str2 = loginData.f4364c;
            int size = smoneyRequestManager.f4688a.size();
            while (true) {
                if (i4 < size) {
                    Intent valueAt = smoneyRequestManager.f4688a.valueAt(i4);
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", i3) == 279 && valueAt.getStringExtra("fr.smoney.android.izly.extras.confirmTerminateContractUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.confirmTerminateContractSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.confirmTerminateContractOtpCode").equals(m824b)) {
                        i2 = smoneyRequestManager.f4688a.keyAt(i4);
                        break;
                    } else {
                        i4++;
                        i3 = -1;
                    }
                } else {
                    int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                    intent.putExtra("com.foxykeep.datadroid.extras.workerType", 281);
                    intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                    intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                    intent.putExtra("fr.smoney.android.izly.extras.confirmTerminateContractUserId", str);
                    intent.putExtra("fr.smoney.android.izly.extras.confirmTerminateContractSessionId", str2);
                    intent.putExtra("fr.smoney.android.izly.extras.confirmTerminateContractOtpCode", m824b);
                    smoneyRequestManager.m956b(intent);
                    smoneyRequestManager.f4688a.append(nextInt, intent);
                    smoneyRequestManager.f4693f.f1722g = null;
                    i2 = nextInt;
                    break;
                }
            }
            this.f4197r.m120c(i2, 281, true);
        } else if (C0581Yd.m1770a(view, ((AbstractC0577Y9) this.f4202w).f2050b)) {
            this.f2196f.m1721a();
        } else if (C0581Yd.m1770a(view, ((AbstractC0577Y9) this.f4202w).f2055h)) {
            C2329w8 c2329w82 = this.f4197r;
            SmoneyRequestManager smoneyRequestManager2 = c2329w82.f6817b;
            LoginData loginData2 = c2329w82.f6816a.f1712b;
            String str3 = loginData2.f4362a;
            String str4 = loginData2.f4364c;
            int size2 = smoneyRequestManager2.f4688a.size();
            while (true) {
                if (i4 < size2) {
                    Intent valueAt2 = smoneyRequestManager2.f4688a.valueAt(i4);
                    if (valueAt2.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 280 && valueAt2.getStringExtra("fr.smoney.android.izly.extras.resendConfirmationCodeUserId").equals(str3) && valueAt2.getStringExtra("fr.smoney.android.izly.extras.resendConfirmationCodeSessionId").equals(str4)) {
                        i = smoneyRequestManager2.f4688a.keyAt(i4);
                        break;
                    }
                    i4++;
                } else {
                    int nextInt2 = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent2 = new Intent(smoneyRequestManager2.f4689b, SmoneyService.class);
                    intent2.putExtra("com.foxykeep.datadroid.extras.workerType", 280);
                    intent2.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager2.f4692e);
                    intent2.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt2);
                    intent2.putExtra("fr.smoney.android.izly.extras.resendConfirmationCodeUserId", str3);
                    intent2.putExtra("fr.smoney.android.izly.extras.resendConfirmationCodeSessionId", str4);
                    smoneyRequestManager2.m956b(intent2);
                    smoneyRequestManager2.f4688a.append(nextInt2, intent2);
                    smoneyRequestManager2.f4693f.f1722g = null;
                    i = nextInt2;
                    break;
                }
            }
            this.f4197r.m120c(i, 280, true);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690100), "getString(R.string.resiliation_compte)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_RED, true, false);
        ((AbstractC0577Y9) this.f4202w).f2051c.setOnClickListener(this);
        ((AbstractC0577Y9) this.f4202w).f2050b.setOnClickListener(this);
        ((AbstractC0577Y9) this.f4202w).f2055h.setOnClickListener(this);
        ((AbstractC0577Y9) this.f4202w).f2052d.f4966a.f6403a.addTextChangedListener(this);
        Button button = ((AbstractC0577Y9) this.f4202w).f2051c;
        C0581Yd.m1767d(button, "mDataBinding.btnConfirm");
        button.setEnabled(false);
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

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
