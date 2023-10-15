package fr.smoney.android.izly.p005ui.publicview.activation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.p005ui.publicview.login.LoginActivity;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.publicview.activation.EmailActivationActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class EmailActivationActivity extends SmoneyABSActivity<AbstractC0377Qa> {

    /* renamed from: z */
    public static final /* synthetic */ int f4905z = 0;

    /* renamed from: x */
    public C1807a f4906x;

    /* renamed from: y */
    public boolean f4907y;

    /* renamed from: fr.smoney.android.izly.ui.publicview.activation.EmailActivationActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1807a extends WebViewClient {
        public C1807a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            EmailActivationActivity emailActivationActivity = EmailActivationActivity.this;
            int i = EmailActivationActivity.f4905z;
            Objects.requireNonNull(emailActivationActivity);
            EmailActivationActivity emailActivationActivity2 = EmailActivationActivity.this;
            if (emailActivationActivity2.f4907y) {
                emailActivationActivity2.f4907y = false;
                emailActivationActivity2.f4197r.m117f();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
            EmailActivationActivity emailActivationActivity = EmailActivationActivity.this;
            int i = EmailActivationActivity.f4905z;
            Objects.requireNonNull(emailActivationActivity);
            EmailActivationActivity emailActivationActivity2 = EmailActivationActivity.this;
            if (emailActivationActivity2.f4907y) {
                return;
            }
            emailActivationActivity2.f4907y = true;
            emailActivationActivity2.f4197r.m125F();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492956;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
        this.f2196f.m1721a();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689800);
        C0581Yd.m1767d(string, "getString(R.string.email_activation_title)");
        C0296Md.C0297a.m2193b(c0297a, this, string, null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, false, 128);
        WebView webView = ((AbstractC0377Qa) this.f4202w).f1281b;
        C0581Yd.m1767d(webView, "mDataBinding.wvEmailActivation");
        WebSettings settings = webView.getSettings();
        C0581Yd.m1767d(settings, "mDataBinding.wvEmailActivation.settings");
        settings.setJavaScriptEnabled(true);
        this.f4906x = new C1807a();
        WebView webView2 = ((AbstractC0377Qa) this.f4202w).f1281b;
        C0581Yd.m1767d(webView2, "mDataBinding.wvEmailActivation");
        C1807a c1807a = this.f4906x;
        if (c1807a != null) {
            webView2.setWebViewClient(c1807a);
            ((AbstractC0377Qa) this.f4202w).f1281b.postUrl("https://mon-espace.izly.fr/Auth/SendActivationMail", new byte[0]);
            return;
        }
        C0581Yd.m1761j("mWebViewClient");
        throw null;
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

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ((AbstractC0377Qa) this.f4202w).f1281b.stopLoading();
        super.onStop();
    }
}
