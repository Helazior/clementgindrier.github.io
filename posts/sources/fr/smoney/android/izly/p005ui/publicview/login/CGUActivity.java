package fr.smoney.android.izly.p005ui.publicview.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.ViewDataBinding;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.UserSubscribingValues;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.publicview.login.CGUActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CGUActivity extends SmoneyABSActivity<ViewDataBinding> implements SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: C */
    public static final /* synthetic */ int f4917C = 0;

    /* renamed from: A */
    public EnumC1809a f4918A;

    /* renamed from: B */
    public final C0479U8 f4919B = this.f4197r.f6816a;

    /* renamed from: x */
    public WebView f4920x;

    /* renamed from: y */
    public C1810b f4921y;

    /* renamed from: z */
    public MenuItem f4922z;

    /* renamed from: fr.smoney.android.izly.ui.publicview.login.CGUActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1809a {
        CGU_FOR_SUBSCRIBE,
        CGU_CHANGED
    }

    /* renamed from: fr.smoney.android.izly.ui.publicview.login.CGUActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1810b extends WebViewClient {

        /* renamed from: a */
        public boolean f4926a;

        public C1810b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            MenuItem menuItem = CGUActivity.this.f4922z;
            if (menuItem != null) {
                C0581Yd.m1768c(menuItem);
                menuItem.setVisible(true);
                this.f4926a = false;
                return;
            }
            C0581Yd.m1761j("mMenuItemRefresh");
            throw null;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            MenuItem menuItem = CGUActivity.this.f4922z;
            if (menuItem != null) {
                C0581Yd.m1768c(menuItem);
                menuItem.setVisible(false);
                this.f4926a = true;
                return;
            }
            C0581Yd.m1761j("mMenuItemRefresh");
            throw null;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
            int i;
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            Uri parse = Uri.parse(str);
            C0581Yd.m1767d(parse, "Uri.parse(url)");
            String lastPathSegment = parse.getLastPathSegment();
            int i2 = 0;
            if (C0581Yd.m1770a(lastPathSegment, "app_cgu_accept")) {
                CGUActivity cGUActivity = CGUActivity.this;
                if (cGUActivity.f4918A == EnumC1809a.CGU_FOR_SUBSCRIBE) {
                    cGUActivity.setResult(-1);
                    CGUActivity.this.finish();
                } else {
                    C2329w8 c2329w8 = cGUActivity.f4197r;
                    LoginData loginData = c2329w8.f6816a.f1712b;
                    SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
                    String str2 = loginData.f4362a;
                    String str3 = loginData.f4364c;
                    int size = smoneyRequestManager.f4688a.size();
                    while (true) {
                        if (i2 < size) {
                            Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 233 && valueAt.getStringExtra("fr.smoney.android.izly.extras.acceptCGUUserId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.acceptCGUSessionId").equals(str3)) {
                                i = smoneyRequestManager.f4688a.keyAt(i2);
                                break;
                            }
                            i2++;
                        } else {
                            int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                            Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                            intent.putExtra("com.foxykeep.datadroid.extras.workerType", 233);
                            intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                            intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                            intent.putExtra("fr.smoney.android.izly.extras.acceptCGUUserId", str2);
                            intent.putExtra("fr.smoney.android.izly.extras.acceptCGUSessionId", str3);
                            smoneyRequestManager.m956b(intent);
                            smoneyRequestManager.f4688a.append(nextInt, intent);
                            smoneyRequestManager.f4693f.f1718e = null;
                            i = nextInt;
                            break;
                        }
                    }
                    cGUActivity.f4197r.m120c(i, 233, true);
                }
                return true;
            } else if (C0581Yd.m1770a(lastPathSegment, "app_cgu_decline")) {
                CGUActivity cGUActivity2 = CGUActivity.this;
                int i3 = CGUActivity.f4917C;
                cGUActivity2.setResult(2);
                CGUActivity.this.finish();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492966;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 233) {
                if (serverError != null) {
                    this.f4197r.m124G(serverError);
                    return;
                }
                setResult(-1);
                finish();
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        if (i == 233) {
            ServerError serverError = c0479u8.f1718e;
            if (serverError != null) {
                c2329w8.m124G(serverError);
                return;
            }
            setResult(-1);
            finish();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        requestWindowFeature(5);
        super.onCreate(bundle);
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            UserSubscribingValues userSubscribingValues = (UserSubscribingValues) extras.getParcelable("fr.smoney.android.izly.extras.userSubscribingValues");
            this.f4918A = (EnumC1809a) extras.getSerializable("fr.smoney.android.izly.extras.displayCase");
        }
        WebView webView = new WebView(this);
        this.f4920x = webView;
        C0581Yd.m1768c(webView);
        WebSettings settings = webView.getSettings();
        C0581Yd.m1767d(settings, "mWebView!!.settings");
        settings.setJavaScriptEnabled(true);
        this.f4921y = new C1810b();
        WebView webView2 = this.f4920x;
        C0581Yd.m1768c(webView2);
        C1810b c1810b = this.f4921y;
        C0581Yd.m1768c(c1810b);
        webView2.setWebViewClient(c1810b);
        setContentView(this.f4920x);
        ActionBar m1681z = m1681z();
        C0581Yd.m1768c(m1681z);
        m1681z.mo1704q(false);
        mo1442x();
        C0479U8 c0479u8 = this.f4919B;
        if (c0479u8 != null) {
            LoginData loginData = c0479u8.f1712b;
            str = "https://mon-espace.izly.fr/home/cguembedded?user=";
            if (loginData != null && loginData.f4362a != null) {
                StringBuilder m253r = outline.m253r("https://mon-espace.izly.fr/home/cguembedded?user=");
                m253r.append(this.f4197r.f6816a.f1712b.f4362a);
                str = m253r.toString();
            }
        } else {
            str = "";
        }
        WebView webView3 = this.f4920x;
        C0581Yd.m1768c(webView3);
        webView3.loadUrl(str);
        WebView webView4 = this.f4920x;
        C0581Yd.m1768c(webView4);
        webView4.setBackgroundColor(0);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        C0581Yd.m1766e(menu, "menu");
        MenuItem add = menu.add(2131689953);
        C0581Yd.m1767d(add, "menu.add(R.string.menu_item_refresh)");
        this.f4922z = add;
        if (add != null) {
            add.setIcon(2131231099);
            MenuItem menuItem = this.f4922z;
            if (menuItem != null) {
                menuItem.setShowAsAction(2);
                return super.onCreateOptionsMenu(menu);
            }
            C0581Yd.m1761j("mMenuItemRefresh");
            throw null;
        }
        C0581Yd.m1761j("mMenuItemRefresh");
        throw null;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        MenuItem menuItem2 = this.f4922z;
        if (menuItem2 == null) {
            C0581Yd.m1761j("mMenuItemRefresh");
            throw null;
        } else if (menuItem == menuItem2) {
            WebView webView = this.f4920x;
            C0581Yd.m1768c(webView);
            webView.reload();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        MenuItem menuItem = this.f4922z;
        if (menuItem != null) {
            C1810b c1810b = this.f4921y;
            C0581Yd.m1768c(c1810b);
            menuItem.setVisible(!c1810b.f4926a);
            return super.onPrepareOptionsMenu(menu);
        }
        C0581Yd.m1761j("mMenuItemRefresh");
        throw null;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WebView webView = this.f4920x;
        C0581Yd.m1768c(webView);
        C1810b c1810b = this.f4921y;
        C0581Yd.m1768c(c1810b);
        webView.setWebViewClient(c1810b);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        WebView webView = this.f4920x;
        C0581Yd.m1768c(webView);
        webView.stopLoading();
        super.onStop();
    }
}
