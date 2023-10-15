package fr.smoney.android.izly.p005ui.helpers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.ViewDataBinding;
import fr.smoney.android.izly.SmoneyABSActivity;

/* renamed from: fr.smoney.android.izly.ui.helpers.WebViewHelperActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WebViewHelperActivity extends SmoneyABSActivity<ViewDataBinding> {

    /* renamed from: B */
    public static final /* synthetic */ int f4707B = 0;

    /* renamed from: A */
    public boolean f4708A = true;

    /* renamed from: x */
    public WebView f4709x;

    /* renamed from: y */
    public C1782b f4710y;

    /* renamed from: z */
    public MenuItem f4711z;

    /* renamed from: fr.smoney.android.izly.ui.helpers.WebViewHelperActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1782b extends WebViewClient {

        /* renamed from: a */
        public boolean f4712a = false;

        public C1782b(C1781a c1781a) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewHelperActivity webViewHelperActivity = WebViewHelperActivity.this;
            int i = WebViewHelperActivity.f4707B;
            webViewHelperActivity.m1683E();
            MenuItem menuItem = webViewHelperActivity.f4711z;
            if (menuItem != null) {
                menuItem.setVisible(true);
            }
            this.f4712a = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (str != null && str.compareTo("https://mon-espace.izly.fr/") == 0) {
                WebViewHelperActivity.this.finish();
                return;
            }
            if (str.indexOf("http://80.11.255.231") != -1) {
                webView.stopLoading();
                Uri parse = Uri.parse(str);
                Intent intent = new Intent();
                int i = WebViewHelperActivity.f4707B;
                intent.putExtra("fr.smoney.android.izly.ui.notused.addfunds.MoneyInActivity.VMeAmount", parse.getQueryParameter("vads_amount"));
                intent.putExtra("fr.smoney.android.izly.ui.notused.addfunds.MoneyInActivity.VMeDate", parse.getQueryParameter("vads_effective_creation_date"));
                WebViewHelperActivity.this.setResult(-1, intent);
                WebViewHelperActivity.this.finish();
                return;
            }
            WebViewHelperActivity webViewHelperActivity = WebViewHelperActivity.this;
            int i2 = WebViewHelperActivity.f4707B;
            webViewHelperActivity.m1683E();
            MenuItem menuItem = webViewHelperActivity.f4711z;
            if (menuItem != null) {
                menuItem.setVisible(false);
            }
            this.f4712a = true;
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 0;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f4709x.canGoBack()) {
            this.f4709x.goBack();
            return;
        }
        setResult(0);
        finish();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("webview_url");
        if (stringExtra == null) {
            finish();
        }
        int intExtra = getIntent().getIntExtra("title_tag", 2131689548);
        this.f4708A = getIntent().getBooleanExtra("should_go_back", true);
        WebView webView = new WebView(this);
        this.f4709x = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        C1782b c1782b = new C1782b(null);
        this.f4710y = c1782b;
        this.f4709x.setWebViewClient(c1782b);
        setContentView(this.f4709x);
        ActionBar m1681z = m1681z();
        m1681z.mo1704q(true);
        m1681z.mo1708m(true);
        m1681z.mo1702s(intExtra);
        mo1442x();
        CookieManager.getInstance().removeAllCookie();
        this.f4709x.clearCache(true);
        this.f4709x.loadUrl(stringExtra);
        this.f4709x.setBackgroundColor(0);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(2131689953);
        this.f4711z = add;
        add.setIcon(2131231099);
        this.f4711z.setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == this.f4711z) {
            this.f4709x.reload();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            if (this.f4709x.canGoBack() && this.f4708A) {
                this.f4709x.goBack();
            } else {
                setResult(0);
                finish();
            }
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.f4711z.setVisible(!this.f4710y.f4712a);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.f4709x.setWebViewClient(this.f4710y);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f4709x.stopLoading();
        this.f4709x.setWebViewClient(null);
        super.onStop();
    }
}
