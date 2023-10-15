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
import fr.smoney.android.izly.data.model.GetMyCbListData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import java.text.DecimalFormat;
import java.util.Objects;
import org.apache.http.util.EncodingUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kxml2.wap.Wbxml;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadNewCardStep2WebActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CardReloadNewCardStep2WebActivity extends SmoneyABSActivity<AbstractC0995cb> implements SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: I */
    public static final /* synthetic */ int f4723I = 0;

    /* renamed from: A */
    public boolean f4724A;

    /* renamed from: B */
    public boolean f4725B;

    /* renamed from: C */
    public int f4726C;

    /* renamed from: D */
    public C1784b f4727D;

    /* renamed from: E */
    public SessionStateReceiver f4728E;

    /* renamed from: F */
    public double f4729F;

    /* renamed from: G */
    public boolean f4730G;

    /* renamed from: x */
    public final String f4732x = "savedInstanceStateCheckStep";

    /* renamed from: y */
    public final String f4733y = "savedInstanceStateisDialogShown";

    /* renamed from: z */
    public final String f4734z = "savedInstanceStateCbCount";

    /* renamed from: H */
    public EnumC1783a f4731H = EnumC1783a.InitStep;

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadNewCardStep2WebActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1783a {
        InitStep,
        VerificationStep
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadNewCardStep2WebActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1784b extends WebViewClient {
        public C1784b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            if (C1880he.m753d(str, "ErreurRechargement", 0, false, 6) != -1) {
                webView.stopLoading();
                CardReloadNewCardStep2WebActivity.this.setResult(0);
                CardReloadNewCardStep2WebActivity.this.finish();
                return;
            }
            if (C1880he.m753d(str, "RetourRechargement", 0, false, 6) != -1) {
                webView.stopLoading();
                CardReloadNewCardStep2WebActivity.this.setResult(-1);
                CardReloadNewCardStep2WebActivity.this.f4197r.m129B();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity = CardReloadNewCardStep2WebActivity.this;
            int i = CardReloadNewCardStep2WebActivity.f4723I;
            Objects.requireNonNull(cardReloadNewCardStep2WebActivity);
            CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity2 = CardReloadNewCardStep2WebActivity.this;
            if (cardReloadNewCardStep2WebActivity2.f4724A) {
                cardReloadNewCardStep2WebActivity2.f4724A = false;
                cardReloadNewCardStep2WebActivity2.f4197r.m117f();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NotNull WebView webView, @NotNull String str, @Nullable Bitmap bitmap) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(str, "url");
            CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity = CardReloadNewCardStep2WebActivity.this;
            int i = CardReloadNewCardStep2WebActivity.f4723I;
            Objects.requireNonNull(cardReloadNewCardStep2WebActivity);
            CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity2 = CardReloadNewCardStep2WebActivity.this;
            if (cardReloadNewCardStep2WebActivity2.f4724A) {
                return;
            }
            cardReloadNewCardStep2WebActivity2.f4724A = true;
            cardReloadNewCardStep2WebActivity2.f4197r.m125F();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
            C0581Yd.m1766e(webView, "view");
            C0581Yd.m1766e(webResourceRequest, "request");
            CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity = CardReloadNewCardStep2WebActivity.this;
            ((AbstractC0995cb) cardReloadNewCardStep2WebActivity.f4202w).f3803b.scrollTo(0, 0);
            View view = ((AbstractC0995cb) cardReloadNewCardStep2WebActivity.f4202w).f3802a;
            C0581Yd.m1767d(view, "mDataBinding.include");
            view.setVisibility(8);
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return true;
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadNewCardStep2WebActivity$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1785c implements InterfaceC1879hd {
        public C1785c() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            int intExtra = intent.getIntExtra("fr.smoney.android.izly.sessionState", -1);
            if (intExtra == 0) {
                CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity = CardReloadNewCardStep2WebActivity.this;
                int i = CardReloadNewCardStep2WebActivity.f4723I;
                cardReloadNewCardStep2WebActivity.m979K();
            } else if (intExtra == 1) {
                CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity2 = CardReloadNewCardStep2WebActivity.this;
                int i2 = CardReloadNewCardStep2WebActivity.f4723I;
                cardReloadNewCardStep2WebActivity2.m927L();
            } else if (intExtra == 2) {
                CardReloadNewCardStep2WebActivity cardReloadNewCardStep2WebActivity3 = CardReloadNewCardStep2WebActivity.this;
                C0580Yc m1771u = C0580Yc.m1771u(cardReloadNewCardStep2WebActivity3, cardReloadNewCardStep2WebActivity3, EnumC1631dd.ConnexionErrorDuringIsSessionValid);
                int i3 = CardReloadNewCardStep2WebActivity.f4723I;
                cardReloadNewCardStep2WebActivity3.f4197r.m126E(m1771u);
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.cards.CardReloadNewCardStep2WebActivity$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnTouchListenerC1786d implements View.OnTouchListener {

        /* renamed from: a */
        public static final View$OnTouchListenerC1786d f4740a = new View$OnTouchListenerC1786d();

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
    public final void m927L() {
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        this.f4197r.m120c(smoneyRequestManager.m953e(loginData.f4362a, loginData.f4364c), 230, true);
    }

    /* renamed from: M */
    public final void m926M() {
        if (this.f4725B) {
            return;
        }
        C0479U8 c0479u8 = this.f4197r.f6816a;
        WebView webView = ((AbstractC0995cb) this.f4202w).f3804c;
        LoginData loginData = c0479u8.f1712b;
        webView.postUrl("https://mon-espace.izly.fr/tools/PaymentCB/CreatePaymentWithUpdateStatus", EncodingUtils.getBytes(getString(2131689633, new Object[]{"phoneNumber", loginData.f4362a, "sessionId", loginData.f4364c, "amount", new DecimalFormat("#").format(this.f4729F * 100), "registered", String.valueOf(this.f4730G)}), "BASE64"));
        this.f4725B = true;
    }

    /* renamed from: N */
    public final void m925N(GetMyCbListData getMyCbListData, ServerError serverError) {
        EnumC1783a enumC1783a = EnumC1783a.VerificationStep;
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (getMyCbListData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            EnumC1783a enumC1783a2 = this.f4731H;
            if (enumC1783a2 == EnumC1783a.InitStep) {
                this.f4726C = getMyCbListData.f4333a.size();
                this.f4731H = enumC1783a;
                m926M();
            } else if (enumC1783a2 == enumC1783a) {
                if (getMyCbListData.f4333a.size() > this.f4726C) {
                    Intent intent = new Intent();
                    intent.putExtra("fr.smoney.android.izly.cbListExtra", getMyCbListData.f4333a);
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
                m925N((GetMyCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMyCbList"), serverError);
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
        this.f4725B = false;
        m926M();
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
            m925N(c0479u8.f1717d0, c0479u8.f1734m);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690095), "getString(R.string.recharge_with_cb)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, true);
        WebView webView = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        WebSettings settings = webView.getSettings();
        C0581Yd.m1767d(settings, "mDataBinding.webview.settings");
        settings.setJavaScriptEnabled(true);
        this.f4727D = new C1784b();
        WebView webView2 = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView2, "mDataBinding.webview");
        C1784b c1784b = this.f4727D;
        C0581Yd.m1768c(c1784b);
        webView2.setWebViewClient(c1784b);
        this.f4724A = false;
        this.f4728E = new SessionStateReceiver(this, new C1785c());
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.getInt("fr.smoney.android.izly.intentExtraMode", 0);
            this.f4729F = extras.getDouble("fr.smoney.android.izly.ui.privateview.classic.AllTrxStep1Activity.MoneyInAmount");
            this.f4730G = extras.getBoolean("fr.smoney.android.izly.ui.privateview.classic.AllTrxStep1Activity.MoneyInRegisteredCard");
        }
        m927L();
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
        SessionStateReceiver sessionStateReceiver = this.f4728E;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WebView webView = ((AbstractC0995cb) this.f4202w).f3804c;
        C0581Yd.m1767d(webView, "mDataBinding.webview");
        C1784b c1784b = this.f4727D;
        C0581Yd.m1768c(c1784b);
        webView.setWebViewClient(c1784b);
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
        SessionStateReceiver sessionStateReceiver = this.f4728E;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
        ((AbstractC0995cb) this.f4202w).f3804c.requestFocus(Wbxml.EXT_T_2);
        ((AbstractC0995cb) this.f4202w).f3804c.setOnTouchListener(View$OnTouchListenerC1786d.f4740a);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(this.f4732x, this.f4731H);
        bundle.putInt(this.f4734z, this.f4726C);
        bundle.putBoolean(this.f4733y, this.f4725B);
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
