package fr.smoney.android.izly.p005ui.privateview.addfunds.initiation;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.LoginData;
import java.util.Objects;
import org.apache.http.util.EncodingUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kxml2.wap.Wbxml;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class InitiationStep2WebviewActivity extends SmoneyABSActivity<AbstractC1666eb> {

    /* renamed from: F */
    public static final /* synthetic */ int f4762F = 0;

    /* renamed from: A */
    public SessionStateReceiver f4763A;

    /* renamed from: D */
    public boolean f4766D;

    /* renamed from: x */
    public boolean f4768x;

    /* renamed from: y */
    public boolean f4769y;

    /* renamed from: z */
    public C1791a f4770z;

    /* renamed from: B */
    public String f4764B = "";

    /* renamed from: C */
    public final InitiationStep2WebviewActivity f4765C = this;

    /* renamed from: E */
    public boolean f4767E = true;

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity$SessionStateReceiver */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class SessionStateReceiver extends BroadcastReceiver {
        public SessionStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1766e(intent, "intent");
            int intExtra = intent.getIntExtra("fr.smoney.android.izly.sessionState", -1);
            if (intExtra == 0) {
                InitiationStep2WebviewActivity initiationStep2WebviewActivity = InitiationStep2WebviewActivity.this;
                int i = InitiationStep2WebviewActivity.f4762F;
                initiationStep2WebviewActivity.m979K();
            } else if (intExtra == 2) {
                InitiationStep2WebviewActivity initiationStep2WebviewActivity2 = InitiationStep2WebviewActivity.this;
                InitiationStep2WebviewActivity initiationStep2WebviewActivity3 = initiationStep2WebviewActivity2.f4765C;
                initiationStep2WebviewActivity2.f4197r.m126E(C0580Yc.m1771u(initiationStep2WebviewActivity3, initiationStep2WebviewActivity3, EnumC1631dd.ConnexionErrorDuringIsSessionValid));
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1791a extends WebViewClient {
        public C1791a() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NotNull WebView webView, @Nullable String str) {
            C0581Yd.m1766e(webView, "view");
            if (C1880he.m756a(String.valueOf(str), "RetourRechargement", false, 2)) {
                InitiationStep2WebviewActivity initiationStep2WebviewActivity = InitiationStep2WebviewActivity.this;
                boolean z = initiationStep2WebviewActivity.f4766D;
                if (z && !initiationStep2WebviewActivity.f4767E) {
                    initiationStep2WebviewActivity.setResult(-1);
                    InitiationStep2WebviewActivity.this.f4197r.m129B();
                } else if (z || !initiationStep2WebviewActivity.f4767E) {
                } else {
                    initiationStep2WebviewActivity.setResult(0);
                    InitiationStep2WebviewActivity.this.f4765C.finish();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            InitiationStep2WebviewActivity initiationStep2WebviewActivity = InitiationStep2WebviewActivity.this;
            int i = InitiationStep2WebviewActivity.f4762F;
            Objects.requireNonNull(initiationStep2WebviewActivity);
            InitiationStep2WebviewActivity initiationStep2WebviewActivity2 = InitiationStep2WebviewActivity.this;
            if (initiationStep2WebviewActivity2.f4768x) {
                initiationStep2WebviewActivity2.f4768x = false;
                initiationStep2WebviewActivity2.f4197r.m117f();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            InitiationStep2WebviewActivity initiationStep2WebviewActivity = InitiationStep2WebviewActivity.this;
            int i = InitiationStep2WebviewActivity.f4762F;
            Objects.requireNonNull(initiationStep2WebviewActivity);
            InitiationStep2WebviewActivity initiationStep2WebviewActivity2 = InitiationStep2WebviewActivity.this;
            if (initiationStep2WebviewActivity2.f4768x) {
                return;
            }
            initiationStep2WebviewActivity2.f4768x = true;
            initiationStep2WebviewActivity2.f4197r.m125F();
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0066, code lost:
            if (p000.C1880he.m756a(r0, "Redirect", false, 2) != false) goto L11;
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.NotNull android.webkit.WebView r9, @org.jetbrains.annotations.NotNull android.webkit.WebResourceRequest r10) {
            /*
                r8 = this;
                java.lang.String r0 = "view"
                p000.C0581Yd.m1766e(r9, r0)
                java.lang.String r0 = "request"
                p000.C0581Yd.m1766e(r10, r0)
                android.net.Uri r0 = r10.getUrl()
                r0.toString()
                android.net.Uri r0 = r10.getUrl()
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "request.url.toString()"
                p000.C0581Yd.m1767d(r0, r1)
                java.lang.String r2 = "payment_created"
                r3 = 0
                r4 = 2
                boolean r0 = p000.C1880he.m756a(r0, r2, r3, r4)
                r2 = 8
                java.lang.String r5 = "mDataBinding.include"
                r6 = 1
                if (r0 == 0) goto L42
                fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity r0 = fr.smoney.android.izly.p005ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity.this
                r0.f4766D = r6
                r0.f4767E = r3
                int r1 = fr.smoney.android.izly.p005ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity.f4762F
                B extends androidx.databinding.ViewDataBinding r0 = r0.f4202w
                eb r0 = (p000.AbstractC1666eb) r0
                android.view.View r0 = r0.f4160a
                p000.C0581Yd.m1767d(r0, r5)
                r0.setVisibility(r2)
                goto L7c
            L42:
                android.net.Uri r0 = r10.getUrl()
                java.lang.String r0 = r0.toString()
                p000.C0581Yd.m1767d(r0, r1)
                java.lang.String r7 = "payment_unsuccessful"
                boolean r0 = p000.C1880he.m756a(r0, r7, r3, r4)
                if (r0 != 0) goto L68
                android.net.Uri r0 = r10.getUrl()
                java.lang.String r0 = r0.toString()
                p000.C0581Yd.m1767d(r0, r1)
                java.lang.String r1 = "Redirect"
                boolean r0 = p000.C1880he.m756a(r0, r1, r3, r4)
                if (r0 == 0) goto L7c
            L68:
                fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity r0 = fr.smoney.android.izly.p005ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity.this
                r0.f4767E = r6
                r0.f4766D = r3
                int r1 = fr.smoney.android.izly.p005ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity.f4762F
                B extends androidx.databinding.ViewDataBinding r0 = r0.f4202w
                eb r0 = (p000.AbstractC1666eb) r0
                android.view.View r0 = r0.f4160a
                p000.C0581Yd.m1767d(r0, r5)
                r0.setVisibility(r2)
            L7c:
                android.net.Uri r10 = r10.getUrl()
                java.lang.String r10 = r10.toString()
                r9.loadUrl(r10)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity.C1791a.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnTouchListenerC1792b implements View.OnTouchListener {

        /* renamed from: a */
        public static final View$OnTouchListenerC1792b f4773a = new View$OnTouchListenerC1792b();

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
        return 2131492967;
    }

    /* renamed from: L */
    public final void m915L() {
        if (this.f4769y) {
            return;
        }
        WebView webView = ((AbstractC1666eb) this.f4202w).f4161b;
        LoginData loginData = this.f4197r.f6816a.f1712b;
        webView.postUrl("https://mon-espace.izly.fr/tools/PaymentInitiation/", EncodingUtils.getBytes(getString(2131690064, new Object[]{"phoneNumber", loginData.f4362a, "sessionId", loginData.f4364c, "amount", this.f4764B}), "BASE64"));
        this.f4769y = true;
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
        if (enumC1631dd == EnumC1631dd.InputPasswordType) {
            this.f4197r.m100w(enumC1631dd, bundle);
            m915L();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        this.f4197r.m103t(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690065), "getString(R.string.payment_initiation_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, true);
        WebView webView = ((AbstractC1666eb) this.f4202w).f4161b;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        WebSettings settings = webView.getSettings();
        C0581Yd.m1767d(settings, "mDataBinding.webview.settings");
        settings.setJavaScriptEnabled(true);
        WebView webView2 = ((AbstractC1666eb) this.f4202w).f4161b;
        C0581Yd.m1767d(webView2, "mDataBinding.webview");
        WebSettings settings2 = webView2.getSettings();
        C0581Yd.m1767d(settings2, "mDataBinding.webview.settings");
        settings2.setDomStorageEnabled(true);
        this.f4770z = new C1791a();
        WebView webView3 = ((AbstractC1666eb) this.f4202w).f4161b;
        C0581Yd.m1767d(webView3, "mDataBinding.webview");
        C1791a c1791a = this.f4770z;
        Objects.requireNonNull(c1791a, "null cannot be cast to non-null type fr.smoney.android.izly.ui.privateview.addfunds.initiation.InitiationStep2WebviewActivity.MyWebViewClient");
        webView3.setWebViewClient(c1791a);
        this.f4768x = false;
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f4764B = String.valueOf(extras.getString("fr.smoney.android.izly.ui.privateview.classic.AllTrxStep1Activity.MoneyAmountInCents"));
        }
        String str = this.f4197r.f6816a.f1712b.f4364c;
        C0581Yd.m1767d(str, "memoryProvider.loginData.sessionId");
        if (str.length() == 0) {
            m979K();
        } else {
            m915L();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        unregisterReceiver(this.f4763A);
        this.f4763A = null;
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WebView webView = ((AbstractC1666eb) this.f4202w).f4161b;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        C1791a c1791a = this.f4770z;
        C0581Yd.m1768c(c1791a);
        webView.setWebViewClient(c1791a);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        ((AbstractC1666eb) this.f4202w).f4161b.restoreState(bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
        if (this.f4763A == null) {
            this.f4763A = new SessionStateReceiver();
        }
        registerReceiver(this.f4763A, intentFilter);
        ((AbstractC1666eb) this.f4202w).f4161b.requestFocus(Wbxml.EXT_T_2);
        ((AbstractC1666eb) this.f4202w).f4161b.setOnTouchListener(View$OnTouchListenerC1792b.f4773a);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ((AbstractC1666eb) this.f4202w).f4161b.saveState(bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ((AbstractC1666eb) this.f4202w).f4161b.stopLoading();
        super.onStop();
    }
}
