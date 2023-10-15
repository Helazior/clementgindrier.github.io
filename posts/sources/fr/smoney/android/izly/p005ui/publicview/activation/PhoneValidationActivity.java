package fr.smoney.android.izly.p005ui.publicview.activation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.UserData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.p005ui.privateview.HomeActivity;
import fr.smoney.android.izly.p005ui.publicview.login.CGUActivity;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.publicview.activation.PhoneValidationActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PhoneValidationActivity extends SmoneyABSActivity<AbstractC0118Eb> implements View.OnClickListener, SmoneyRequestManager.InterfaceC1778a, TextWatcher, TextView.OnEditorActionListener {

    /* renamed from: C */
    public static final /* synthetic */ int f4909C = 0;

    /* renamed from: A */
    public final int f4910A = 20;

    /* renamed from: B */
    public final int f4911B = 30;

    /* renamed from: x */
    public String f4912x;

    /* renamed from: y */
    public String f4913y;

    /* renamed from: z */
    public LoginData f4914z;

    /* compiled from: java-style lambda group */
    /* renamed from: fr.smoney.android.izly.ui.publicview.activation.PhoneValidationActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class RunnableC1808a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f4915a;

        /* renamed from: b */
        public final /* synthetic */ Object f4916b;

        public RunnableC1808a(int i, Object obj) {
            this.f4915a = i;
            this.f4916b = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.f4915a;
            if (i == 0) {
                int i2 = PhoneValidationActivity.f4909C;
                ((PhoneValidationActivity) this.f4916b).m847O();
            } else if (i == 1) {
                PhoneValidationActivity phoneValidationActivity = (PhoneValidationActivity) this.f4916b;
                int i3 = PhoneValidationActivity.f4909C;
                phoneValidationActivity.f4201r.m126E(C0564Xc.m1796t(phoneValidationActivity.getString(2131689905), phoneValidationActivity.getString(2131689904), phoneValidationActivity.getString(17039370), phoneValidationActivity, EnumC1631dd.CGUNotAcceptedType));
            } else {
                throw null;
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo839G() {
        return 2131492983;
    }

    /* renamed from: L */
    public final void m850L(boolean z) {
        String obj;
        boolean z2;
        if (z) {
            obj = null;
        } else {
            EditText editText = ((AbstractC0118Eb) this.f4200w).f415c;
            C0581Yd.m1770d(editText, "mDataBinding.etPassword");
            obj = editText.getEditableText().toString();
        }
        String str = obj;
        SmoneyRequestManager smoneyRequestManager = this.f4201r.f6817b;
        String str2 = this.f4912x;
        if (new File("/system/app/Superuser.apk").exists()) {
            z2 = true;
            this.f4201r.m120c(smoneyRequestManager.m954g(str2, str, true, z2, this.f4913y), 1, true);
        }
        z2 = false;
        this.f4201r.m120c(smoneyRequestManager.m954g(str2, str, true, z2, this.f4913y), 1, true);
    }

    /* renamed from: M */
    public final void m849M() {
        this.f4201r.m126E(C0564Xc.m1796t(getString(2131690068), getString(2131690067), getString(17039370), this, EnumC1631dd.BadSchemeType));
    }

    /* renamed from: N */
    public final void m848N(LoginData loginData, UserData userData, ServerError serverError) {
        if (serverError != null) {
            EditText editText = ((AbstractC0118Eb) this.f4200w).f415c;
            if (editText != null) {
                editText.setText("");
            }
            if (serverError.f4601b == 120) {
                this.f4201r.m126E(C0543Wc.m1822s(serverError.f4604f, serverError.f4603d, getString(17039370)));
                return;
            }
            this.f4201r.m124G(serverError);
        } else if (loginData == null && userData == null) {
            this.f4201r.m126E(C0580Yc.m1775t(this, this));
        } else if (loginData != null) {
            this.f4914z = loginData;
            if (loginData.f4379J) {
                if (loginData.f4377H) {
                    this.f4201r.m126E(C0564Xc.m1796t(getString(2131689905), getString(2131689903), getString(17039370), this, EnumC1631dd.CGUNotAcceptedType));
                    return;
                }
                Intent intent = new Intent(this, CGUActivity.class);
                intent.putExtra("fr.smoney.android.izly.extras.displayCase", CGUActivity.EnumC1809a.CGU_CHANGED);
                startActivityForResult(intent, this.f4910A);
            } else if (loginData.f4378I) {
                m847O();
            } else {
                Intent intent2 = new Intent(this, HomeActivity.class);
                C0581Yd.m1770d(intent2, "ActivityUtils.createInte…HomeActivity::class.java)");
                startActivity(intent2);
                if (this.f4913y != null) {
                    C0065C8 c0065c8 = SmoneyApplication.f4207g;
                    LoginData loginData2 = this.f4914z;
                    C0581Yd.m1771c(loginData2);
                    String str = loginData2.f4354M;
                    SharedPreferences.Editor edit = c0065c8.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
                    edit.putString("sharedPrefHotpActivationCode", str);
                    edit.putString("sharedPrefHotpCounter", Base64.encodeToString(C0374Q7.m2089i(0), 8));
                    edit.commit();
                    C0065C8 c0065c82 = SmoneyApplication.f4207g;
                    LoginData loginData3 = this.f4914z;
                    C0581Yd.m1771c(loginData3);
                    c0065c82.editSharedPrefNsse(loginData3.f4355N);
                    this.f4913y = null;
                }
                finish();
            }
        } else {
            startActivity(new Intent(this, PhoneNonValidatedActivity.class));
            finish();
        }
    }

    /* renamed from: O */
    public final void m847O() {
        this.f4201r.m126E(C0525Vc.m1829s(getString(2131689912), getString(2131689911), getString(2131689902), getString(2131689901), this, EnumC1631dd.AppNewVersionType));
    }

    /* renamed from: P */
    public final void m846P() {
        EditText editText = ((AbstractC0118Eb) this.f4200w).f415c;
        C0581Yd.m1770d(editText, "mDataBinding.etPassword");
        if (editText.getText().toString().length() >= 6) {
            m850L(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        m846P();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo244d(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 1) {
                SmoneyApplication.f4207g.m2511a();
                ((AbstractC0118Eb) this.f4200w).f415c.setText("");
                return;
            } else if (ordinal == 22) {
                finish();
                return;
            } else if (ordinal == 51) {
                SmoneyApplication.f4207g.m2508d();
                return;
            }
        }
        this.f4201r.m102u(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo243g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1769e(bundle, "payload");
        if (this.f4201r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 1) {
                m848N((LoginData) bundle.getParcelable("fr.smoney.android.izly.extras.loginData"), (UserData) bundle.getParcelable("fr.smoney.android.izly.extras.userData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo242h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1769e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType) {
            this.f4201r.m130A();
            SmoneyApplication.f4207g.m2511a();
            finish();
            return;
        }
        this.f4201r.m106q(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo241k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m985H() == 1) {
                    m850L(false);
                    return;
                } else {
                    this.f4201r.m100w(enumC1631dd, bundle);
                    return;
                }
            } else if (ordinal == 50) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://mon-espace.izly.fr/Home/Mobile"));
                startActivity(intent);
                return;
            }
        }
        this.f4201r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo240l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null) {
            return;
        }
        int ordinal = enumC1631dd.ordinal();
        if (ordinal == 27) {
            finish();
        } else if (ordinal != 50) {
        } else {
            startActivityForResult(new Intent(this, HomeActivity.class), this.f4911B);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo238n(int i) {
        C0479U8 c0479u8 = this.f4201r.f6816a;
        if (i == 1) {
            m848N(c0479u8.f1707b, c0479u8.f1709c, c0479u8.f1711d);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == this.f4911B) {
            if (i2 != -1) {
                finish();
            }
        } else if (i == this.f4910A) {
            if (i2 == -1) {
                LoginData loginData = this.f4914z;
                C0581Yd.m1771c(loginData);
                if (loginData.f4378I) {
                    new Handler().post(new RunnableC1808a(0, this));
                } else {
                    Intent intent2 = new Intent(this, HomeActivity.class);
                    C0581Yd.m1770d(intent2, "ActivityUtils.createInte…HomeActivity::class.java)");
                    startActivity(intent2);
                    finish();
                }
            } else {
                SmoneyApplication.f4207g.m2508d();
                if (i2 == 2) {
                    new Handler().post(new RunnableC1808a(1, this));
                }
            }
            super.onActivityResult(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        finish();
        startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
        if (p000.C0208Id.m2387a(r7.getText().toString()) != false) goto L22;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(@org.jetbrains.annotations.NotNull android.view.View r7) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            p000.C0581Yd.m1769e(r7, r0)
            B extends androidx.databinding.ViewDataBinding r0 = r6.f4200w
            r1 = r0
            Eb r1 = (p000.AbstractC0118Eb) r1
            android.widget.LinearLayout r1 = r1.f416d
            if (r7 != r1) goto L20
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r0 = "https://help.izly.fr/"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r1 = "android.intent.action.VIEW"
            r7.<init>(r1, r0)
            r6.startActivity(r7)
            goto Lbe
        L20:
            r1 = r0
            Eb r1 = (p000.AbstractC0118Eb) r1
            android.widget.TextView r1 = r1.f417f
            if (r7 != r1) goto L33
            java.lang.Class<fr.smoney.android.izly.ui.publicview.activation.EmailActivationActivity> r7 = fr.smoney.android.izly.p005ui.publicview.activation.EmailActivationActivity.class
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6, r7)
            r6.startActivity(r0)
            goto Lbe
        L33:
            r1 = r0
            Eb r1 = (p000.AbstractC0118Eb) r1
            android.widget.TextView r1 = r1.f419h
            r2 = 0
            if (r7 != r1) goto Lb5
            C8 r7 = fr.smoney.android.izly.SmoneyApplication.f4207g
            java.lang.String r0 = "SmoneyApplication.mAuthentManager"
            p000.C0581Yd.m1770d(r7, r0)
            boolean r7 = r7.is_user_id_null()
            if (r7 == 0) goto L8d
            B extends androidx.databinding.ViewDataBinding r7 = r6.f4200w
            Eb r7 = (p000.AbstractC0118Eb) r7
            android.widget.EditText r7 = r7.f414b
            java.lang.String r0 = "mDataBinding.etLogin"
            p000.C0581Yd.m1770d(r7, r0)
            android.text.Editable r7 = r7.getText()
            java.lang.String r1 = "mDataBinding.etLogin.text"
            p000.C0581Yd.m1770d(r7, r1)
            int r7 = r7.length()
            r1 = 1
            if (r7 <= 0) goto L64
            r2 = 1
        L64:
            if (r2 == 0) goto L7e
            B extends androidx.databinding.ViewDataBinding r7 = r6.f4200w
            Eb r7 = (p000.AbstractC0118Eb) r7
            android.widget.EditText r7 = r7.f414b
            p000.C0581Yd.m1770d(r7, r0)
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = p000.C0208Id.m2387a(r7)
            if (r7 == 0) goto L7e
            goto L8d
        L7e:
            r7 = 2131689916(0x7f0f01bc, float:1.900886E38)
            java.lang.String r7 = r6.getString(r7)
            android.widget.Toast r7 = android.widget.Toast.makeText(r6, r7, r1)
            r7.show()
            goto Lbe
        L8d:
            r7 = 2131689548(0x7f0f004c, float:1.9008114E38)
            java.lang.String r0 = r6.getString(r7)
            r7 = 2131689906(0x7f0f01b2, float:1.900884E38)
            java.lang.String r1 = r6.getString(r7)
            r7 = 2131689766(0x7f0f0126, float:1.9008557E38)
            java.lang.String r2 = r6.getString(r7)
            r7 = 17039360(0x1040000, float:2.424457E-38)
            java.lang.String r3 = r6.getString(r7)
            dd r5 = p000.EnumC1631dd.RetrievePasswordType
            r4 = r6
            Vc r7 = p000.C0525Vc.m1829s(r0, r1, r2, r3, r4, r5)
            w8 r0 = r6.f4201r
            r0.m126E(r7)
            goto Lbe
        Lb5:
            Eb r0 = (p000.AbstractC0118Eb) r0
            android.widget.Button r0 = r0.f413a
            if (r7 != r0) goto Lbe
            r6.m850L(r2)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.publicview.activation.PhoneValidationActivity.onClick(android.view.View):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.publicview.activation.PhoneValidationActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
        Button button = ((AbstractC0118Eb) this.f4200w).f413a;
        C0581Yd.m1770d(button, "mDataBinding.bSubmit");
        if (button.isEnabled()) {
            m850L(false);
        }
        return false;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        EditText editText = ((AbstractC0118Eb) this.f4200w).f415c;
        if (editText != null) {
            editText.setText("");
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
