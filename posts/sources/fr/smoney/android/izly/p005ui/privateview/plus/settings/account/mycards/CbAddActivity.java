package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mycards;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.ViewDataBinding;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.GetMyCbListData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.http.util.EncodingUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kxml2.wap.Wbxml;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbAddActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CbAddActivity extends SmoneyABSActivity<ViewDataBinding> implements SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: N */
    public static final /* synthetic */ int f4816N = 0;

    /* renamed from: D */
    public WebView f4820D;

    /* renamed from: E */
    public boolean f4821E;

    /* renamed from: F */
    public boolean f4822F;

    /* renamed from: G */
    public boolean f4823G;

    /* renamed from: H */
    public int f4824H;

    /* renamed from: J */
    public C1799b f4826J;

    /* renamed from: K */
    public SessionStateReceiver f4827K;

    /* renamed from: M */
    public MenuItem f4829M;
    @NotNull

    /* renamed from: x */
    public final String f4830x = "fr.smoney.android.izly.intentExtraMode";
    @NotNull

    /* renamed from: y */
    public final String f4831y = "fr.smoney.android.izly.cbListExtra";

    /* renamed from: z */
    public final String f4832z = "savedInstanceStateCheckStep";

    /* renamed from: A */
    public final String f4817A = "savedInstanceStateisDialogShown";

    /* renamed from: B */
    public final String f4818B = "savedInstanceStateCbCount";

    /* renamed from: C */
    public final String f4819C = CbAddActivity.class.getSimpleName();

    /* renamed from: I */
    public int f4825I = 0;

    /* renamed from: L */
    public EnumC1798a f4828L = EnumC1798a.InitStep;

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbAddActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1798a {
        InitStep,
        VerificationStep
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbAddActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1799b extends WebViewClient {

        /* renamed from: a */
        public boolean f4836a;

        public C1799b() {
        }

        /* renamed from: a */
        public final boolean m884a(String str) {
            return (C1880he.m753d(str, "exec.cancel.a", 0, false, 6) == -1 && C1880he.m753d(str, "exec.success.a", 0, false, 6) == -1 && C1880he.m753d(str, "exec.refused.a", 0, false, 6) == -1 && C1880he.m753d(str, "80.11.255.231", 0, false, 6) == -1) ? false : true;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            if (CbAddActivity.this.f4825I == 0) {
                if (m884a(str)) {
                    CbAddActivity.this.f4822F = true;
                    webView.stopLoading();
                    CbAddActivity.this.m887L();
                    return;
                }
                return;
            }
            if (!(C1880he.m753d(str, "exec.cancel.a", 0, false, 6) != -1)) {
                if (!(C1880he.m753d(str, "exec.refused.a", 0, false, 6) != -1)) {
                    if (C1880he.m753d(str, "exec.success.a", 0, false, 6) != -1) {
                        webView.stopLoading();
                        CbAddActivity.this.m887L();
                        return;
                    }
                    return;
                }
            }
            CbAddActivity.this.setResult(0);
            CbAddActivity.this.finish();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            if (C1880he.m753d(str, "exec.paymentChoice.a", 0, false, 6) != -1) {
                this.f4836a = true;
                CbAddActivity.this.mo1442x();
            } else if (this.f4836a) {
                this.f4836a = false;
                CbAddActivity.this.mo1442x();
            }
            CbAddActivity cbAddActivity = CbAddActivity.this;
            if (cbAddActivity.f4822F || !cbAddActivity.f4821E) {
                return;
            }
            cbAddActivity.f4821E = false;
            cbAddActivity.f4197r.m117f();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            if (m884a(str)) {
                CbAddActivity.this.f4822F = true;
                webView.stopLoading();
                CbAddActivity.this.m887L();
            }
            CbAddActivity cbAddActivity = CbAddActivity.this;
            if (cbAddActivity.f4822F || cbAddActivity.f4821E) {
                return;
            }
            cbAddActivity.f4821E = true;
            cbAddActivity.f4197r.m125F();
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbAddActivity$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1800c implements InterfaceC1879hd {
        public C1800c() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            int intExtra = intent.getIntExtra("fr.smoney.android.izly.sessionState", -1);
            if (intExtra == 0) {
                CbAddActivity cbAddActivity = CbAddActivity.this;
                int i = CbAddActivity.f4816N;
                cbAddActivity.m979K();
            } else if (intExtra == 1) {
                CbAddActivity cbAddActivity2 = CbAddActivity.this;
                int i2 = CbAddActivity.f4816N;
                cbAddActivity2.m887L();
            } else if (intExtra == 2) {
                CbAddActivity cbAddActivity3 = CbAddActivity.this;
                C0580Yc m1771u = C0580Yc.m1771u(cbAddActivity3, cbAddActivity3, EnumC1631dd.ConnexionErrorDuringIsSessionValid);
                int i3 = CbAddActivity.f4816N;
                cbAddActivity3.f4197r.m126E(m1771u);
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mycards.CbAddActivity$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnTouchListenerC1801d implements View.OnTouchListener {

        /* renamed from: a */
        public static final View$OnTouchListenerC1801d f4839a = new View$OnTouchListenerC1801d();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            C0581Yd.m1767d(motionEvent, Constants.FirelogAnalytics.PARAM_EVENT);
            int action = motionEvent.getAction();
            if ((action == 0 || action == 1) && !view.hasFocus()) {
                view.requestFocus();
                return false;
            }
            return false;
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492966;
    }

    /* renamed from: L */
    public final void m887L() {
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        this.f4197r.m120c(smoneyRequestManager.m953e(loginData.f4362a, loginData.f4364c), 230, true);
    }

    /* renamed from: M */
    public final void m886M() {
        if (this.f4823G) {
            return;
        }
        C0479U8 c0479u8 = this.f4197r.f6816a;
        WebView webView = this.f4820D;
        C0581Yd.m1768c(webView);
        LoginData loginData = c0479u8.f1712b;
        webView.postUrl("https://mon-espace.izly.fr/tools/addCB", EncodingUtils.getBytes(getString(2131689590, new Object[]{"phoneNumber", loginData.f4362a, "sessionId", loginData.f4364c}), "BASE64"));
        this.f4823G = true;
        LoginData loginData2 = c0479u8.f1712b;
        C0581Yd.m1767d(String.format("Url : %s | Post Params : %s", Arrays.copyOf(new Object[]{"https://mon-espace.izly.fr/tools/addCB", getString(2131689590, new Object[]{"phoneNumber", loginData2.f4362a, "sessionId", loginData2.f4364c})}, 2)), "java.lang.String.format(format, *args)");
    }

    /* renamed from: N */
    public final void m885N(GetMyCbListData getMyCbListData, ServerError serverError) {
        EnumC1798a enumC1798a = EnumC1798a.VerificationStep;
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (getMyCbListData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            EnumC1798a enumC1798a2 = this.f4828L;
            if (enumC1798a2 == EnumC1798a.InitStep) {
                this.f4824H = getMyCbListData.f4333a.size();
                this.f4828L = enumC1798a;
                m886M();
            } else if (enumC1798a2 == enumC1798a) {
                if (getMyCbListData.f4333a.size() > this.f4824H) {
                    Intent intent = new Intent();
                    intent.putExtra(this.f4831y, getMyCbListData.f4333a);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                this.f4197r.m126E(C0525Vc.m1826s(getString(2131689773), getString(2131689772), getString(17039379), getString(17039369), this, EnumC1631dd.NoCBType));
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 230) {
                m885N((GetMyCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMyCbList"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType) {
            finish();
        } else {
            this.f4197r.m106q(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 20) {
            this.f4197r.m100w(enumC1631dd, bundle);
            return;
        }
        this.f4823G = false;
        m886M();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 20) {
            this.f4197r.m103t(enumC1631dd);
            return;
        }
        setResult(0);
        finish();
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 230) {
            m885N(c0479u8.f1717d0, c0479u8.f1734m);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f4820D = webView;
        C0581Yd.m1768c(webView);
        WebSettings settings = webView.getSettings();
        C0581Yd.m1767d(settings, "mWebView!!.settings");
        settings.setJavaScriptEnabled(true);
        setContentView(this.f4820D);
        ActionBar m1681z = m1681z();
        C0581Yd.m1768c(m1681z);
        m1681z.mo1704q(true);
        this.f4827K = new SessionStateReceiver(this, new C1800c());
        m1681z.mo1708m(true);
        this.f4826J = new C1799b();
        WebView webView2 = this.f4820D;
        C0581Yd.m1768c(webView2);
        C1799b c1799b = this.f4826J;
        C0581Yd.m1768c(c1799b);
        webView2.setWebViewClient(c1799b);
        this.f4821E = false;
        this.f4822F = false;
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f4825I = extras.getInt(this.f4830x, 0);
        }
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable(this.f4832z);
            if (serializable != null && (serializable instanceof EnumC1798a)) {
                this.f4828L = (EnumC1798a) serializable;
            }
            this.f4823G = bundle.getBoolean(this.f4817A);
            this.f4824H = bundle.getInt(this.f4818B, 0);
        }
        if (this.f4823G) {
            return;
        }
        m887L();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        C0581Yd.m1766e(menu, "menu");
        MenuItem icon = menu.add("Scanner votre carte").setIcon(2131231100);
        C0581Yd.m1767d(icon, "menu.add(\"Scanner votre …(R.drawable.pict_scanpay)");
        this.f4829M = icon;
        if (icon != null) {
            icon.setShowAsAction(2);
            return super.onCreateOptionsMenu(menu);
        }
        C0581Yd.m1761j("mScanMenuItem");
        throw null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i == 4 && this.f4823G) {
            m887L();
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            m887L();
            return true;
        }
        MenuItem menuItem2 = this.f4829M;
        if (menuItem2 == null) {
            C0581Yd.m1761j("mScanMenuItem");
            throw null;
        } else if (menuItem == menuItem2) {
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f4827K;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        MenuItem menuItem = this.f4829M;
        if (menuItem != null) {
            C0581Yd.m1768c(menuItem);
            menuItem.setVisible(false);
            return super.onPrepareOptionsMenu(menu);
        }
        C0581Yd.m1761j("mScanMenuItem");
        throw null;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WebView webView = this.f4820D;
        C0581Yd.m1768c(webView);
        C1799b c1799b = this.f4826J;
        C0581Yd.m1768c(c1799b);
        webView.setWebViewClient(c1799b);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        WebView webView = this.f4820D;
        C0581Yd.m1768c(webView);
        webView.restoreState(bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f4827K;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
        WebView webView = this.f4820D;
        C0581Yd.m1768c(webView);
        webView.requestFocus(Wbxml.EXT_T_2);
        WebView webView2 = this.f4820D;
        C0581Yd.m1768c(webView2);
        webView2.setOnTouchListener(View$OnTouchListenerC1801d.f4839a);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(this.f4832z, this.f4828L);
        bundle.putInt(this.f4818B, this.f4824H);
        bundle.putBoolean(this.f4817A, this.f4823G);
        WebView webView = this.f4820D;
        C0581Yd.m1768c(webView);
        webView.saveState(bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        WebView webView = this.f4820D;
        C0581Yd.m1768c(webView);
        webView.stopLoading();
        WebViewClient webViewClient = new WebViewClient();
        WebView webView2 = this.f4820D;
        C0581Yd.m1768c(webView2);
        webView2.setWebViewClient(webViewClient);
        super.onStop();
    }
}
