package fr.smoney.android.izly.p005ui.privateview.addfunds.cards;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import java.util.Objects;
import org.apache.http.util.EncodingUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kxml2.wap.Wbxml;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadOldCardStep3Web3DSActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CardReloadOldCardStep3Web3DSActivity extends SmoneyABSActivity<AbstractC0995cb> {

    /* renamed from: D */
    public static final /* synthetic */ int f4741D = 0;

    /* renamed from: A */
    public SessionStateReceiver f4742A;

    /* renamed from: B */
    public String f4743B;

    /* renamed from: C */
    public String f4744C;

    /* renamed from: x */
    public C1787a f4745x;

    /* renamed from: y */
    public boolean f4746y;

    /* renamed from: z */
    public boolean f4747z;

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadOldCardStep3Web3DSActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1787a extends WebViewClient {
        public C1787a() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            if (C1880he.m753d(str, "ErreurRechargement", 0, false, 6) != -1) {
                webView.stopLoading();
                CardReloadOldCardStep3Web3DSActivity.this.setResult(0);
                CardReloadOldCardStep3Web3DSActivity.this.finish();
                return;
            }
            if (C1880he.m753d(str, "RetourRechargement", 0, false, 6) != -1) {
                webView.stopLoading();
                CardReloadOldCardStep3Web3DSActivity.this.setResult(-1);
                CardReloadOldCardStep3Web3DSActivity.this.f4197r.m129B();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity = CardReloadOldCardStep3Web3DSActivity.this;
            int i = CardReloadOldCardStep3Web3DSActivity.f4741D;
            Objects.requireNonNull(cardReloadOldCardStep3Web3DSActivity);
            CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity2 = CardReloadOldCardStep3Web3DSActivity.this;
            if (cardReloadOldCardStep3Web3DSActivity2.f4746y) {
                cardReloadOldCardStep3Web3DSActivity2.f4746y = false;
                cardReloadOldCardStep3Web3DSActivity2.f4197r.m117f();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity = CardReloadOldCardStep3Web3DSActivity.this;
            int i = CardReloadOldCardStep3Web3DSActivity.f4741D;
            Objects.requireNonNull(cardReloadOldCardStep3Web3DSActivity);
            CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity2 = CardReloadOldCardStep3Web3DSActivity.this;
            if (cardReloadOldCardStep3Web3DSActivity2.f4746y) {
                return;
            }
            cardReloadOldCardStep3Web3DSActivity2.f4746y = true;
            cardReloadOldCardStep3Web3DSActivity2.f4197r.m125F();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(webResourceRequest, "request");
            CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity = CardReloadOldCardStep3Web3DSActivity.this;
            int i = CardReloadOldCardStep3Web3DSActivity.f4741D;
            ((AbstractC0995cb) cardReloadOldCardStep3Web3DSActivity.f4202w).f3803b.scrollTo(0, 0);
            View view = ((AbstractC0995cb) CardReloadOldCardStep3Web3DSActivity.this.f4202w).f3802a;
            C0581Yd.m1767d(view, "mDataBinding.include");
            view.setVisibility(8);
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return true;
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadOldCardStep3Web3DSActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1788b implements InterfaceC1879hd {
        public C1788b() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            int intExtra = intent.getIntExtra("fr.smoney.android.izly.sessionState", -1);
            if (intExtra == 0) {
                CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity = CardReloadOldCardStep3Web3DSActivity.this;
                int i = CardReloadOldCardStep3Web3DSActivity.f4741D;
                cardReloadOldCardStep3Web3DSActivity.m979K();
            } else if (intExtra == 2) {
                CardReloadOldCardStep3Web3DSActivity cardReloadOldCardStep3Web3DSActivity2 = CardReloadOldCardStep3Web3DSActivity.this;
                C0580Yc m1771u = C0580Yc.m1771u(cardReloadOldCardStep3Web3DSActivity2, cardReloadOldCardStep3Web3DSActivity2, EnumC1631dd.ConnexionErrorDuringIsSessionValid);
                int i2 = CardReloadOldCardStep3Web3DSActivity.f4741D;
                cardReloadOldCardStep3Web3DSActivity2.f4197r.m126E(m1771u);
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadOldCardStep3Web3DSActivity$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnTouchListenerC1789c implements View.OnTouchListener {

        /* renamed from: a */
        public static final View$OnTouchListenerC1789c f4750a = new View$OnTouchListenerC1789c();

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
    public final void m924L() {
        if (this.f4747z) {
            return;
        }
        C0479U8 c0479u8 = this.f4197r.f6816a;
        ((AbstractC0995cb) this.f4202w).f3804c.postUrl("https://mon-espace.izly.fr/tools/PaymentCB/ValidatePayment3DSDalenys", EncodingUtils.getBytes(getString(2131689588, new Object[]{"actionUrl", this.f4743B, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, this.f4744C}), "BASE64"));
        this.f4747z = true;
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
        this.f4747z = false;
        m924L();
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

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689690), "getString(R.string.confirmer_rechargement)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, true);
        WebView webView = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        WebSettings settings = webView.getSettings();
        C0581Yd.m1767d(settings, "mDataBinding.webview.settings");
        settings.setJavaScriptEnabled(true);
        this.f4745x = new C1787a();
        WebView webView2 = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView2, "mDataBinding.webview");
        C1787a c1787a = this.f4745x;
        C0581Yd.m1768c(c1787a);
        webView2.setWebViewClient(c1787a);
        this.f4742A = new SessionStateReceiver(this, new C1788b());
        this.f4746y = false;
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f4743B = extras.getString("fr.smoney.android.izly.rdUrl");
            this.f4744C = extras.getString("fr.smoney.android.izly.rdParams");
        }
        m924L();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            setResult(0);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f4742A;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WebView webView = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        C1787a c1787a = this.f4745x;
        C0581Yd.m1768c(c1787a);
        webView.setWebViewClient(c1787a);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        ((AbstractC0995cb) this.f4202w).f3804c.restoreState(bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f4742A;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
        ((AbstractC0995cb) this.f4202w).f3804c.requestFocus(Wbxml.EXT_T_2);
        ((AbstractC0995cb) this.f4202w).f3804c.setOnTouchListener(View$OnTouchListenerC1789c.f4750a);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ((AbstractC0995cb) this.f4202w).f3804c.saveState(bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ((AbstractC0995cb) this.f4202w).f3804c.stopLoading();
        WebViewClient webViewClient = new WebViewClient();
        WebView webView = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        webView.setWebViewClient(webViewClient);
        super.onStop();
    }
}
