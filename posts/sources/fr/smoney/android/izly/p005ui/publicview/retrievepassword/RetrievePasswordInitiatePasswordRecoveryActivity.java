package fr.smoney.android.izly.p005ui.publicview.retrievepassword;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.publicview.login.LoginActivity;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.publicview.retrievepassword.RetrievePasswordInitiatePasswordRecoveryActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class RetrievePasswordInitiatePasswordRecoveryActivity extends SmoneyABSActivity<AbstractC0542Wb> implements SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: x */
    public int f4938x = -1;

    /* renamed from: y */
    public String f4939y;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493042;
    }

    /* renamed from: L */
    public final void m835L() {
        int i;
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        String str = this.f4939y;
        boolean z = this.f4938x == 1;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 191 && valueAt.getStringExtra("fr.smoney.android.izly.extras.initiatePasswordRecoveryUserId").equals(str) && valueAt.getBooleanExtra("fr.smoney.android.izly.extras.initiatePasswordRecoveryUnlockAccount", false) != z) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 191);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.initiatePasswordRecoveryUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.initiatePasswordRecoveryUnlockAccount", z);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                Objects.requireNonNull(smoneyRequestManager.f4693f);
                smoneyRequestManager.f4693f.f1698O = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 191, true);
    }

    /* renamed from: M */
    public final void m834M(ServerError serverError) {
        if (serverError != null) {
            if (serverError.f4601b == 140) {
                this.f4197r.m126E(C0564Xc.m1793t(serverError.f4604f, serverError.f4603d, getString(2131689575), this, EnumC1631dd.AlertType));
                return;
            }
            this.f4197r.m124G(serverError);
            return;
        }
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689800);
        C0581Yd.m1767d(string, "getString(R.string.email_activation_title)");
        c0297a.m2194a(this, string, 2131230957, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, false);
        m983F(this);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@Nullable EnumC1631dd enumC1631dd) {
        int ordinal;
        if (enumC1631dd == null || ((ordinal = enumC1631dd.ordinal()) != 0 && ordinal != 1)) {
            this.f4197r.m102u(enumC1631dd);
            return;
        }
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 191) {
                m834M(serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType && m982H() == 191) {
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
        } else if (m982H() == 191) {
            m835L();
        } else {
            this.f4197r.m100w(enumC1631dd, bundle);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m103t(enumC1631dd);
        } else if (m982H() == 191) {
            finish();
        } else {
            this.f4197r.m103t(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 191) {
            m834M(c0479u8.f1698O);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f4938x = extras.getInt("fr.smoney.android.izly.ui.intentExtraMode");
            this.f4939y = extras.getString("fr.smoney.android.izly.ui.intentUserId");
        }
        m835L();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        finish();
        return true;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent(this, LoginActivity.class));
        finish();
        return true;
    }
}
