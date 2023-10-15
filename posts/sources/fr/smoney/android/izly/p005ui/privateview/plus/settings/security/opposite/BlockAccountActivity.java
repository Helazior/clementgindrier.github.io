package fr.smoney.android.izly.p005ui.privateview.plus.settings.security.opposite;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.BlockAccountData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleSpinner;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.security.opposite.BlockAccountActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class BlockAccountActivity extends SmoneyABSActivity<AbstractC0436S9> implements View.OnClickListener, SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: x */
    public final String f4865x = "savedStateCurrentPassword";

    /* renamed from: y */
    public C0179Hc f4866y;

    /* renamed from: z */
    public String f4867z;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492910;
    }

    /* renamed from: L */
    public final void m865L() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC0436S9) this.f4202w).f1426d;
        C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.spMotif");
        Spinner spinner = customBorderSimpleSpinner.f4971a.f6629b;
        C0581Yd.m1767d(spinner, "mDataBinding.spMotif.spinner");
        String obj = spinner.getSelectedItem().toString();
        String str3 = this.f4867z;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 181 && valueAt.getStringExtra("fr.smoney.android.izly.extras.blockAccountUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.blockAccountSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.blockAccountMessage").equals(obj) && valueAt.getStringExtra("fr.smoney.android.izly.extras.blockAccountPassword").equals(str3)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 181);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.blockAccountUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.blockAccountSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.blockAccountMessage", obj);
                intent.putExtra("fr.smoney.android.izly.extras.blockAccountPassword", str3);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                Objects.requireNonNull(smoneyRequestManager.f4693f);
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 181, true);
    }

    /* renamed from: M */
    public final void m864M(ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
            return;
        }
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type fr.smoney.android.izly.SmoneyApplication");
        ((SmoneyApplication) application).m976c();
        startActivity(new Intent(this, BlockAccountResultActivity.class));
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 181) {
                BlockAccountData blockAccountData = (BlockAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.blockAccountData");
                m864M(serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null && enumC1631dd.ordinal() == 7) {
            return;
        }
        this.f4197r.m106q(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 7) {
                this.f4867z = bundle.getString("Data.Password");
                m865L();
                return;
            } else if (ordinal == 9) {
                if (m982H() == 181) {
                    m865L();
                    return;
                } else {
                    this.f4197r.m100w(enumC1631dd, bundle);
                    return;
                }
            }
        }
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 181) {
            Objects.requireNonNull(c0479u8);
            m864M(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC0436S9) obj).f1425c) {
            this.f4197r.m126E(C0617ad.m1725s(this, this));
        } else if (view == ((AbstractC0436S9) obj).f1424b) {
            finish();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689566);
        C0581Yd.m1767d(string, "getString(R.string.block_account_title_app_bar)");
        c0297a.m2194a(this, string, null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_RED, true, false);
        C0179Hc c0179Hc = new C0179Hc(this, 2131492974, EnumC0375Q8.values());
        this.f4866y = c0179Hc;
        ((AbstractC0436S9) this.f4202w).f1426d.setAdapter(c0179Hc);
        ((AbstractC0436S9) this.f4202w).f1424b.setOnClickListener(this);
        ((AbstractC0436S9) this.f4202w).f1425c.setOnClickListener(this);
        if (bundle != null) {
            this.f4867z = bundle.getString(this.f4865x);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        finish();
        return true;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(this.f4865x, this.f4867z);
    }
}
