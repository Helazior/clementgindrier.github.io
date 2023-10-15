package fr.smoney.android.izly.p005ui.privateview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.HomeActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class HomeActivity extends SmoneyABSActivity<AbstractC2238sb> implements InterfaceC1928jd, SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: E */
    public static final /* synthetic */ int f4714E = 0;

    /* renamed from: A */
    public View$OnClickListenerC0599a f4715A;

    /* renamed from: D */
    public boolean f4716D;

    /* renamed from: y */
    public C0479U8 f4717y;

    /* renamed from: z */
    public AbstractC0216J5 f4718z;

    /* renamed from: x */
    public final String f4719x = HomeActivity.class.getSimpleName();

    /* renamed from: B */
    public int f4720B = -1;

    /* renamed from: C */
    public int f4721C = -1;

    /* renamed from: N */
    public static final void m935N(HomeActivity homeActivity) {
        C2202qd c2202qd;
        Objects.requireNonNull(homeActivity);
        try {
            c2202qd = (C2202qd) C2202qd.class.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            c2202qd = null;
            ConstraintLayout constraintLayout = ((AbstractC2238sb) homeActivity.f4200w).f6408b;
            C0581Yd.m1767d(constraintLayout, "mDataBinding.contentFragment");
            homeActivity.f4201r.m116g(constraintLayout.getId(), c2202qd);
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            c2202qd = null;
            ConstraintLayout constraintLayout2 = ((AbstractC2238sb) homeActivity.f4200w).f6408b;
            C0581Yd.m1767d(constraintLayout2, "mDataBinding.contentFragment");
            homeActivity.f4201r.m116g(constraintLayout2.getId(), c2202qd);
        }
        ConstraintLayout constraintLayout22 = ((AbstractC2238sb) homeActivity.f4200w).f6408b;
        C0581Yd.m1767d(constraintLayout22, "mDataBinding.contentFragment");
        homeActivity.f4201r.m116g(constraintLayout22.getId(), c2202qd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492975;
    }

    /* renamed from: L */
    public final boolean m937L() {
        AbstractC0216J5 abstractC0216J5 = this.f4718z;
        C0581Yd.m1768c(abstractC0216J5);
        Fragment mo2305c = abstractC0216J5.mo2305c(2131296459);
        return mo2305c != null && (mo2305c instanceof View$OnClickListenerC0599a);
    }

    /* renamed from: M */
    public final void m936M(Intent intent) {
        String str;
        C0581Yd.m1768c(intent);
        intent.getAction();
        intent.getDataString();
        Uri data = intent.getData();
        String str2 = this.f4719x + " AccengagePushHandler uri:'" + data;
        if (data == null) {
            return;
        }
        List<String> pathSegments = data.getPathSegments();
        String str3 = this.f4719x + " AccengagePushHandler uriFragments:'" + pathSegments;
        if (pathSegments == null || pathSegments.size() <= 0) {
            return;
        }
        String str4 = pathSegments.get(0);
        if (C0581Yd.m1770a(str4, "menuentries")) {
            Integer valueOf = Integer.valueOf(pathSegments.get(1));
            m931R();
            C0581Yd.m1767d(valueOf, "entryToDisplay");
            valueOf.intValue();
            m931R();
        } else if (C0581Yd.m1770a(str4, "gooddealsandservices")) {
            Integer valueOf2 = Integer.valueOf(pathSegments.get(1));
            C0581Yd.m1767d(valueOf2, "Integer.valueOf(uriFragments[1])");
            this.f4720B = valueOf2.intValue();
            if (pathSegments.size() >= 4 && (str = pathSegments.get(2)) != null && C0581Yd.m1770a(str, "services")) {
                Integer valueOf3 = Integer.valueOf(pathSegments.get(3));
                C0581Yd.m1767d(valueOf3, "Integer.valueOf(uriFragments[3])");
                this.f4721C = valueOf3.intValue();
            }
            m931R();
        }
    }

    /* renamed from: O */
    public final void m934O(Intent intent) {
        if (intent.getIntExtra("fr.smoney.android.izly.extras.launchActivity", -1) != 1) {
            String stringExtra = intent.getStringExtra("fr.smoney.android.izly.extras.toastMessage");
            if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                return;
            }
            Toast.makeText(this, stringExtra, 1).show();
            return;
        }
        String stringExtra2 = intent.getStringExtra("fr.smoney.android.izly.intentExtra.notifMessage");
        if (stringExtra2 != null) {
            this.f4201r.m126E(C0543Wc.m1819s(getString(2131689548), stringExtra2, getString(2131689765)));
        }
    }

    /* renamed from: P */
    public final void m933P(boolean z) {
        BottomNavigationView bottomNavigationView = ((AbstractC2238sb) this.f4200w).f6407a;
        C0581Yd.m1767d(bottomNavigationView, "mDataBinding.bottomNavigation");
        MenuItem findItem = bottomNavigationView.getMenu().findItem(2131296390);
        C0581Yd.m1767d(findItem, "mDataBinding.bottomNavig…ttom_navigation_recharge)");
        findItem.setEnabled(z);
        BottomNavigationView bottomNavigationView2 = ((AbstractC2238sb) this.f4200w).f6407a;
        C0581Yd.m1767d(bottomNavigationView2, "mDataBinding.bottomNavigation");
        MenuItem findItem2 = bottomNavigationView2.getMenu().findItem(2131296386);
        C0581Yd.m1767d(findItem2, "mDataBinding.bottomNavig…d.bottom_navigation_actu)");
        findItem2.setEnabled(z);
        BottomNavigationView bottomNavigationView3 = ((AbstractC2238sb) this.f4200w).f6407a;
        C0581Yd.m1767d(bottomNavigationView3, "mDataBinding.bottomNavigation");
        MenuItem findItem3 = bottomNavigationView3.getMenu().findItem(2131296389);
        C0581Yd.m1767d(findItem3, "mDataBinding.bottomNavig…d.bottom_navigation_plus)");
        findItem3.setEnabled(z);
    }

    /* renamed from: Q */
    public final void m932Q() {
        C0065C8 c0065c8 = SmoneyApplication.f4207g;
        C0581Yd.m1767d(c0065c8, "SmoneyApplication.mAuthentManager");
        String user_id = c0065c8.user_id();
        if (user_id != null) {
            this.f4201r.m120c(this.f4201r.f6817b.m954d(user_id), 228, true);
        }
    }

    /* renamed from: R */
    public final void m931R() {
        this.f4715A = new View$OnClickListenerC0599a();
        ConstraintLayout constraintLayout = ((AbstractC2238sb) this.f4200w).f6408b;
        C0581Yd.m1767d(constraintLayout, "mDataBinding.contentFragment");
        this.f4201r.m116g(constraintLayout.getId(), this.f4715A);
    }

    /* renamed from: S */
    public final void m930S(LoginData loginData, ServerError serverError) {
        if (serverError != null) {
            this.f4201r.m124G(serverError);
        } else if (loginData == null && this.f4199u) {
            this.f4201r.m126E(C0580Yc.m1772t(this, this));
        } else {
            Intent intent = getIntent();
            C0581Yd.m1767d(intent, "intent");
            m934O(intent);
            if (loginData != null) {
                m928U();
            }
            if (!m937L()) {
                AbstractC0216J5 abstractC0216J5 = this.f4718z;
                C0581Yd.m1768c(abstractC0216J5);
                if (abstractC0216J5.mo2305c(2131296459) != null) {
                    return;
                }
            }
            m929T();
        }
    }

    /* renamed from: T */
    public final void m929T() {
        BottomNavigationView bottomNavigationView = ((AbstractC2238sb) this.f4200w).f6407a;
        C0581Yd.m1767d(bottomNavigationView, "mDataBinding.bottomNavigation");
        bottomNavigationView.setSelectedItemId(2131296387);
        m931R();
    }

    /* renamed from: U */
    public final void m928U() {
        C2330w8 c2330w8 = this.f4201r;
        new AsyncTaskC1627d9(this, c2330w8.f6817b, c2330w8.f6816a).execute(null, null, null);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.f4063b) {
            this.f4201r.m119d(false);
        } else {
            this.f4201r.m102u(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4201r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 228) {
                m930S((LoginData) bundle.getParcelable("fr.smoney.android.izly.extras.GetLogonInfos"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.f4070f) {
            this.f4201r.m130A();
            this.f4201r.m119d(false);
            return;
        }
        this.f4201r.m106q(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@NotNull EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.f4080k) {
            if (m982H() == 228) {
                m932Q();
            } else {
                this.f4201r.m100w(enumC1631dd, bundle);
            }
        } else if (enumC1631dd == EnumC1631dd.f4047M) {
            startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } else {
            this.f4201r.m100w(enumC1631dd, bundle);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.f4080k) {
            if (m982H() == 228) {
                this.f4201r.m119d(false);
                return;
            } else {
                this.f4201r.m103t(enumC1631dd);
                return;
            }
        }
        this.f4201r.m103t(enumC1631dd);
    }

    @Override // p000.InterfaceC1928jd
    /* renamed from: m */
    public void mo681m() {
        m929T();
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        if (i == 228) {
            C0479U8 c0479u8 = this.f4717y;
            if (c0479u8 == null) {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
            LoginData loginData = c0479u8.f1707b;
            if (c0479u8 != null) {
                m930S(loginData, c0479u8.f1711d);
            } else {
                C0581Yd.m1761j("mMemoryProvider");
                throw null;
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        C0479U8 c0479u8 = this.f4201r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        this.f4717y = c0479u8;
        this.f4718z = m1445u();
        BottomNavigationView bottomNavigationView = ((AbstractC2238sb) this.f4200w).f6407a;
        C0581Yd.m1767d(bottomNavigationView, "mDataBinding.bottomNavigation");
        bottomNavigationView.setVisibility(0);
        BottomNavigationView bottomNavigationView2 = ((AbstractC2238sb) this.f4200w).f6407a;
        C0581Yd.m1767d(bottomNavigationView2, "mDataBinding.bottomNavigation");
        bottomNavigationView2.setOnNavigationItemSelectedListener(new C1945kd(this, bottomNavigationView2));
        if (this.f4716D) {
            mo725p(false, true);
            return;
        }
        C0479U8 c0479u82 = this.f4717y;
        if (c0479u82 != null) {
            if (c0479u82.f1707b == null) {
                m932Q();
            } else {
                Intent intent = getIntent();
                C0581Yd.m1767d(intent, "intent");
                m934O(intent);
                m928U();
                m929T();
            }
            m936M(getIntent());
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i == 4) {
            Fragment mo2305c = this.f4201r.f6819f.m1445u().mo2305c(2131296459);
            AbstractC0044B8 abstractC0044B8 = mo2305c != null ? (AbstractC0044B8) mo2305c : null;
            if (abstractC0044B8 != null && abstractC0044B8.mo234s()) {
                m929T();
                return true;
            } else if (!m937L()) {
                m929T();
                return true;
            } else {
                setResult(-1);
                return super.onKeyUp(i, keyEvent);
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        C0581Yd.m1766e(intent, "intent");
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra("fr.smoney.android.izly.logonStateError", false);
        this.f4202v = booleanExtra;
        if (booleanExtra) {
            mo725p(true, true);
        }
        if (intent.getBooleanExtra("fr.smoney.android.izly.extras.showHome", false)) {
            BottomNavigationView bottomNavigationView = ((AbstractC2238sb) this.f4200w).f6407a;
            C0581Yd.m1767d(bottomNavigationView, "mDataBinding.bottomNavigation");
            bottomNavigationView.setSelectedItemId(2131296387);
        }
        m936M(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, p000.C1854h3.InterfaceC1856b
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        C0581Yd.m1766e(strArr, "permissions");
        C0581Yd.m1766e(iArr, "grantResults");
        if (i == 118 && iArr.length > 0) {
            int i2 = iArr[0];
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.InterfaceC1899id
    /* renamed from: p */
    public void mo725p(boolean z, boolean z2) {
        this.f4716D = true;
        m933P(false);
        if (this.f4716D) {
            Intent intent = getIntent();
            C0581Yd.m1767d(intent, "intent");
            m934O(intent);
        }
        this.f4199u = z;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.InterfaceC1899id
    /* renamed from: q */
    public void mo724q(boolean z, boolean z2) {
        this.f4716D = false;
        m933P(true);
        C0479U8 c0479u8 = this.f4717y;
        if (c0479u8 != null) {
            C0581Yd.m1768c(c0479u8);
            if (c0479u8.f1707b == null) {
                m932Q();
            } else if (m937L()) {
                m929T();
            }
            this.f4199u = z;
            return;
        }
        C0581Yd.m1761j("mMemoryProvider");
        throw null;
    }
}
