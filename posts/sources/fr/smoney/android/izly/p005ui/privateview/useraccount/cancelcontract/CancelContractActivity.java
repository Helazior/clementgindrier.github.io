package fr.smoney.android.izly.p005ui.privateview.useraccount.cancelcontract;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.cancelcontract.CancelContractActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CancelContractActivity extends SmoneyABSActivity<AbstractC0540W9> implements View.OnClickListener, SmoneyRequestManager.InterfaceC1778a {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492912;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 != 278) {
                return;
            }
            String str = (String) bundle.getParcelable("fr.smoney.android.izly.extras.GetContactDetails");
            if (serverError != null) {
                this.f4197r.m124G(serverError);
            } else if (str == null) {
                startActivity(new Intent(this, CancelContractConfirmationActivity.class));
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        if (i != 278) {
            return;
        }
        String str = c0479u8.f1749t0;
        ServerError serverError = c0479u8.f1751u0;
        if (serverError != null) {
            c2329w8.m124G(serverError);
        } else if (str == null) {
            startActivity(new Intent(this, CancelContractConfirmationActivity.class));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        int i;
        if (C0581Yd.m1770a(view, ((AbstractC0540W9) this.f4202w).f1940b)) {
            this.f2196f.m1721a();
        } else if (C0581Yd.m1770a(view, ((AbstractC0540W9) this.f4202w).f1941c)) {
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
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 278 && valueAt.getStringExtra("fr.smoney.android.izly.extras.terminateContractUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.terminateContractSessionId").equals(str2)) {
                        i = smoneyRequestManager.f4688a.keyAt(i2);
                        break;
                    }
                    i2++;
                } else {
                    int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                    intent.putExtra("com.foxykeep.datadroid.extras.workerType", 278);
                    intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                    intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                    intent.putExtra("fr.smoney.android.izly.extras.terminateContractUserId", str);
                    intent.putExtra("fr.smoney.android.izly.extras.terminateContractSessionId", str2);
                    smoneyRequestManager.m956b(intent);
                    smoneyRequestManager.f4688a.append(nextInt, intent);
                    smoneyRequestManager.f4693f.f1722g = null;
                    i = nextInt;
                    break;
                }
            }
            this.f4197r.m120c(i, 278, true);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690100), "getString(R.string.resiliation_compte)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_RED, true, false);
        ((AbstractC0540W9) this.f4202w).f1940b.setOnClickListener(this);
        ((AbstractC0540W9) this.f4202w).f1941c.setOnClickListener(this);
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
}
