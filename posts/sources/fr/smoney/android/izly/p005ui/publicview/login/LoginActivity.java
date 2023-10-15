package fr.smoney.android.izly.p005ui.publicview.login;

import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.GoogleApiAvailability;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.IsEnrollmentOpenData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.UserData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.privateview.HomeActivity;
import fr.smoney.android.izly.p005ui.publicview.activation.EmailActivationActivity;
import fr.smoney.android.izly.p005ui.publicview.activation.PhoneNonValidatedActivity;
import fr.smoney.android.izly.p005ui.publicview.activation.PhoneValidationActivity;
import fr.smoney.android.izly.p005ui.publicview.login.CGUActivity;
import fr.smoney.android.izly.p005ui.publicview.retrievepassword.RetrievePasswordInitiatePasswordRecoveryActivity;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.publicview.login.LoginActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class LoginActivity extends SmoneyABSActivity<AbstractC0118Eb> implements View.OnClickListener, TextWatcher, SmoneyRequestManager.InterfaceC1778a, TextView.OnEditorActionListener {

    /* renamed from: D */
    public static final /* synthetic */ int f4928D = 0;

    /* renamed from: A */
    public String f4929A;

    /* renamed from: B */
    public LoginData f4930B;

    /* renamed from: y */
    public String f4931y;

    /* renamed from: z */
    public String f4932z;

    /* renamed from: x */
    public final String f4933x = "savedStateCurrentPassword";

    /* renamed from: C */
    public final TextWatcher f4934C = new C1812b();

    /* compiled from: java-style lambda group */
    /* renamed from: fr.smoney.android.izly.ui.publicview.login.LoginActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class RunnableC1811a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f4935a;

        /* renamed from: b */
        public final /* synthetic */ Object f4936b;

        public RunnableC1811a(int i, Object obj) {
            this.f4935a = i;
            this.f4936b = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.f4935a;
            if (i == 0) {
                int i2 = LoginActivity.f4928D;
                ((LoginActivity) this.f4936b).m840Q();
            } else if (i == 1) {
                LoginActivity loginActivity = (LoginActivity) this.f4936b;
                int i3 = LoginActivity.f4928D;
                loginActivity.f4201r.m126E(C0564Xc.m1796t(loginActivity.getString(2131689905), loginActivity.getString(2131689904), loginActivity.getString(17039370), loginActivity, EnumC1631dd.CGUNotAcceptedType));
            } else {
                throw null;
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.publicview.login.LoginActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1812b implements TextWatcher {
        public C1812b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            C0581Yd.m1769e(editable, "s");
            LoginActivity loginActivity = LoginActivity.this;
            int i = LoginActivity.f4928D;
            EditText editText = ((AbstractC0118Eb) loginActivity.f4200w).f415c;
            C0581Yd.m1770d(editText, "mDataBinding.etPassword");
            String obj = editText.getText().toString();
            EditText editText2 = ((AbstractC0118Eb) LoginActivity.this.f4200w).f414b;
            C0581Yd.m1770d(editText2, "mDataBinding.etLogin");
            if (TextUtils.isEmpty(editText2.getText().toString()) || obj.length() < 6) {
                return;
            }
            LoginActivity.this.m841P();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            C0581Yd.m1769e(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            C0581Yd.m1769e(charSequence, "s");
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo839G() {
        return 2131492983;
    }

    /* renamed from: L */
    public final void m845L(boolean z) {
        boolean z2;
        EditText editText = ((AbstractC0118Eb) this.f4200w).f414b;
        C0581Yd.m1770d(editText, "mDataBinding.etLogin");
        String obj = editText.getEditableText().toString();
        C2330w8 c2330w8 = this.f4201r;
        c2330w8.f6816a.f1705a = obj;
        SmoneyRequestManager smoneyRequestManager = c2330w8.f6817b;
        String str = this.f4931y;
        if (new File("/system/app/Superuser.apk").exists()) {
            z2 = true;
            this.f4201r.m120c(smoneyRequestManager.m954g(obj, str, z, z2, null), 1, true);
        }
        z2 = false;
        this.f4201r.m120c(smoneyRequestManager.m954g(obj, str, z, z2, null), 1, true);
    }

    /* renamed from: M */
    public final void m844M() {
        startActivityForResult(new Intent(this, HomeActivity.class), 30);
    }

    /* renamed from: N */
    public final void m843N(LoginData loginData, UserData userData, ServerError serverError) {
        if (serverError != null) {
            ((AbstractC0118Eb) this.f4200w).f415c.setText("");
            if (serverError.f4601b == 120) {
                this.f4201r.m126E(C0543Wc.m1822s(serverError.f4604f, serverError.f4603d, getString(17039370)));
                return;
            }
            this.f4201r.m124G(serverError);
        } else if (loginData == null && userData == null) {
            this.f4201r.m126E(C0580Yc.m1775t(this, this));
        } else if (loginData != null) {
            this.f4930B = loginData;
            if (loginData.f4379J) {
                if (loginData.f4377H) {
                    this.f4201r.m126E(C0564Xc.m1796t(getString(2131689905), getString(2131689903), getString(17039370), this, EnumC1631dd.CGUNotAcceptedType));
                    return;
                }
                Intent intent = new Intent(this, CGUActivity.class);
                intent.putExtra("fr.smoney.android.izly.extras.displayCase", CGUActivity.EnumC1809a.CGU_CHANGED);
                startActivityForResult(intent, 20);
            } else if (loginData.f4378I) {
                m840Q();
            } else {
                C0065C8 c0065c8 = SmoneyApplication.f4207g;
                C0581Yd.m1770d(c0065c8, "SmoneyApplication.mAuthentManager");
                if (c0065c8.user_id() != null) {
                    C0065C8 c0065c82 = SmoneyApplication.f4207g;
                    C0581Yd.m1770d(c0065c82, "SmoneyApplication.mAuthentManager");
                    if (c0065c82.m2503i() != null) {
                        m844M();
                        C0065C8 c0065c83 = SmoneyApplication.f4207g;
                        LoginData loginData2 = this.f4930B;
                        C0581Yd.m1771c(loginData2);
                        c0065c83.editSharedPrefNsse(loginData2.f4355N);
                    }
                }
            }
        } else {
            C0065C8 c0065c84 = SmoneyApplication.f4207g;
            C0581Yd.m1771c(userData);
            c0065c84.m2497o(userData.f4665a);
            startActivity(new Intent(this, PhoneNonValidatedActivity.class));
            finish();
        }
    }

    /* renamed from: O */
    public final void m842O() {
        C0065C8 c0065c8 = SmoneyApplication.f4207g;
        C0581Yd.m1770d(c0065c8, "SmoneyApplication.mAuthentManager");
        if (!c0065c8.is_user_id_null()) {
            C0065C8 c0065c82 = SmoneyApplication.f4207g;
            C0581Yd.m1770d(c0065c82, "SmoneyApplication.mAuthentManager");
            ((AbstractC0118Eb) this.f4200w).f414b.setText(c0065c82.user_id());
            EditText editText = ((AbstractC0118Eb) this.f4200w).f414b;
            C0581Yd.m1770d(editText, "mDataBinding.etLogin");
            editText.setFocusable(false);
            return;
        }
        ((AbstractC0118Eb) this.f4200w).f414b.setText("");
    }

    /* renamed from: P */
    public final void m841P() {
        EditText editText = ((AbstractC0118Eb) this.f4200w).f414b;
        C0581Yd.m1770d(editText, "mDataBinding.etLogin");
        this.f4929A = editText.getText().toString();
        C0065C8 c0065c8 = SmoneyApplication.f4207g;
        C0581Yd.m1770d(c0065c8, "SmoneyApplication.mAuthentManager");
        if (c0065c8.is_user_id_null()) {
            EditText editText2 = ((AbstractC0118Eb) this.f4200w).f415c;
            C0581Yd.m1770d(editText2, "mDataBinding.etPassword");
            this.f4931y = editText2.getEditableText().toString();
            m845L(false);
            return;
        }
        C0065C8 c0065c82 = SmoneyApplication.f4207g;
        EditText editText3 = ((AbstractC0118Eb) this.f4200w).f414b;
        C0581Yd.m1770d(editText3, "mDataBinding.etLogin");
        if (c0065c82.format_phonenumber(editText3.getEditableText().toString())) {
            EditText editText4 = ((AbstractC0118Eb) this.f4200w).f415c;
            C0581Yd.m1770d(editText4, "mDataBinding.etPassword");
            this.f4931y = editText4.getEditableText().toString();
            m845L(true);
            return;
        }
        this.f4201r.m126E(C0525Vc.m1829s(getString(2131689908), getString(2131689907), getString(17039370), getString(17039360), this, EnumC1631dd.OverWriteUserType));
    }

    /* renamed from: Q */
    public final void m840Q() {
        this.f4201r.m126E(C0525Vc.m1829s(getString(2131689912), getString(2131689911), getString(2131689902), getString(2131689901), this, EnumC1631dd.AppNewVersionType));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        EditText editText = ((AbstractC0118Eb) this.f4200w).f415c;
        C0581Yd.m1770d(editText, "mDataBinding.etPassword");
        String obj = editText.getText().toString();
        Button button = ((AbstractC0118Eb) this.f4200w).f413a;
        C0581Yd.m1770d(button, "mDataBinding.bSubmit");
        EditText editText2 = ((AbstractC0118Eb) this.f4200w).f414b;
        C0581Yd.m1770d(editText2, "mDataBinding.etLogin");
        button.setEnabled((TextUtils.isEmpty(editText2.getText().toString()) || TextUtils.isEmpty(obj) || obj.length() != 6) ? false : true);
        Button button2 = ((AbstractC0118Eb) this.f4200w).f413a;
        C0581Yd.m1770d(button2, "mDataBinding.bSubmit");
        if (button2.isEnabled()) {
            ((AbstractC0118Eb) this.f4200w).f413a.setTextColor(C0103E3.m2472a(getResources(), 2131099938, null));
        } else {
            ((AbstractC0118Eb) this.f4200w).f413a.setTextColor(C0103E3.m2472a(getResources(), 2131099797, null));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo244d(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 46) {
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
                m843N((LoginData) bundle.getParcelable("fr.smoney.android.izly.extras.loginData"), (UserData) bundle.getParcelable("fr.smoney.android.izly.extras.userData"), serverError);
            } else if (i2 == 218) {
                IsEnrollmentOpenData isEnrollmentOpenData = (IsEnrollmentOpenData) bundle.getParcelable("fr.smoney.android.izly.extras.IsEnrollementOpen");
                if (serverError != null) {
                    this.f4201r.m124G(serverError);
                }
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo241k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        int i;
        String obj;
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            int i2 = 0;
            if (ordinal == 9) {
                int m985H = m985H();
                if (m985H == 1) {
                    C0065C8 c0065c8 = SmoneyApplication.f4207g;
                    EditText editText = ((AbstractC0118Eb) this.f4200w).f414b;
                    C0581Yd.m1770d(editText, "mDataBinding.etLogin");
                    m845L(c0065c8.format_phonenumber(editText.getText().toString()));
                    return;
                } else if (m985H == 218) {
                    SmoneyRequestManager smoneyRequestManager = this.f4201r.f6817b;
                    C0581Yd.m1770d(smoneyRequestManager, "requestManager");
                    int size = smoneyRequestManager.f4688a.size();
                    while (true) {
                        if (i2 < size) {
                            if (smoneyRequestManager.f4688a.valueAt(i2).getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 218) {
                                i = smoneyRequestManager.f4688a.keyAt(i2);
                                break;
                            }
                            i2++;
                        } else {
                            int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                            Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                            intent.putExtra("com.foxykeep.datadroid.extras.workerType", 218);
                            intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                            intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                            smoneyRequestManager.m959b(intent);
                            smoneyRequestManager.f4688a.append(nextInt, intent);
                            C0479U8 c0479u8 = smoneyRequestManager.f4693f;
                            c0479u8.f1696R = null;
                            c0479u8.f1697S = null;
                            i = nextInt;
                            break;
                        }
                    }
                    this.f4201r.m120c(i, 218, true);
                    return;
                } else {
                    this.f4201r.m100w(enumC1631dd, bundle);
                    return;
                }
            } else if (ordinal != 50) {
                switch (ordinal) {
                    case 24:
                        SmoneyApplication.f4207g.m2509c();
                        SmoneyApplication.f4207g.m2508d();
                        m845L(false);
                        return;
                    case 25:
                        Intent intent2 = new Intent(this, RetrievePasswordInitiatePasswordRecoveryActivity.class);
                        intent2.putExtra("fr.smoney.android.izly.ui.intentExtraMode", 0);
                        EditText editText2 = ((AbstractC0118Eb) this.f4200w).f414b;
                        C0581Yd.m1770d(editText2, "mDataBinding.etLogin");
                        intent2.putExtra("fr.smoney.android.izly.ui.intentUserId", editText2.getText().toString());
                        startActivity(intent2);
                        return;
                    case 26:
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(Uri.parse("https://mon-espace.izly.fr/Home/Mobile"));
                        startActivity(intent3);
                        return;
                    case 27:
                        Intent intent4 = new Intent(this, RetrievePasswordInitiatePasswordRecoveryActivity.class);
                        intent4.putExtra("fr.smoney.android.izly.ui.intentExtraMode", 1);
                        EditText editText3 = ((AbstractC0118Eb) this.f4200w).f414b;
                        C0581Yd.m1770d(editText3, "mDataBinding.etLogin");
                        String obj2 = editText3.getText().toString();
                        Locale locale = Locale.getDefault();
                        C0581Yd.m1770d(locale, "Locale.getDefault()");
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.String");
                        String lowerCase = obj2.toLowerCase(locale);
                        C0581Yd.m1770d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        if (C0581Yd.m1773a(lowerCase, "")) {
                            obj = this.f4929A;
                        } else {
                            EditText editText4 = ((AbstractC0118Eb) this.f4200w).f414b;
                            C0581Yd.m1770d(editText4, "mDataBinding.etLogin");
                            obj = editText4.getText().toString();
                        }
                        intent4.putExtra("fr.smoney.android.izly.ui.intentUserId", obj);
                        startActivity(intent4);
                        return;
                }
            } else {
                Intent intent5 = new Intent("android.intent.action.VIEW");
                intent5.setData(Uri.parse("https://mon-espace.izly.fr/Home/Mobile"));
                startActivity(intent5);
                return;
            }
        }
        this.f4201r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo240l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 27) {
                finish();
                return;
            } else if (ordinal == 50) {
                m844M();
                return;
            }
        }
        this.f4201r.m103t(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo238n(int i) {
        C2330w8 c2330w8 = this.f4201r;
        C0479U8 c0479u8 = c2330w8.f6816a;
        if (i == 1) {
            m843N(c0479u8.f1707b, c0479u8.f1709c, c0479u8.f1711d);
        } else if (i == 218) {
            IsEnrollmentOpenData isEnrollmentOpenData = c0479u8.f1696R;
            ServerError serverError = c0479u8.f1697S;
            if (serverError != null) {
                c2330w8.m124G(serverError);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 10) {
            if (i2 != -1) {
                finish();
            }
        } else if (i != 20) {
            if (i != 30) {
                super.onActivityResult(i, i2, intent);
            } else if (i2 != -1) {
                finish();
            }
        } else {
            if (i2 == -1) {
                LoginData loginData = this.f4930B;
                C0581Yd.m1771c(loginData);
                if (loginData.f4378I) {
                    new Handler().post(new RunnableC1811a(0, this));
                } else {
                    m844M();
                }
            } else {
                SmoneyApplication.f4207g.m2508d();
                if (i2 == 2) {
                    new Handler().post(new RunnableC1811a(1, this));
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1769e(view, "view");
        Object obj = this.f4200w;
        if (view == ((AbstractC0118Eb) obj).f416d) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://help.izly.fr/")));
        } else if (view == ((AbstractC0118Eb) obj).f417f) {
            startActivity(new Intent(this, EmailActivationActivity.class));
        } else if (view == ((AbstractC0118Eb) obj).f419h) {
            C0065C8 c0065c8 = SmoneyApplication.f4207g;
            C0581Yd.m1770d(c0065c8, "SmoneyApplication.mAuthentManager");
            if (c0065c8.is_user_id_null()) {
                EditText editText = ((AbstractC0118Eb) this.f4200w).f414b;
                C0581Yd.m1770d(editText, "mDataBinding.etLogin");
                Editable text = editText.getText();
                C0581Yd.m1770d(text, "mDataBinding.etLogin.text");
                if (!(text.length() > 0)) {
                    Toast.makeText(this, getString(2131689916), 1).show();
                    return;
                }
            }
            this.f4201r.m126E(C0525Vc.m1829s(getString(2131689548), getString(2131689906), getString(2131689766), getString(17039360), this, EnumC1631dd.RetrievePasswordType));
        } else if (view == ((AbstractC0118Eb) obj).f413a) {
            EditText editText2 = ((AbstractC0118Eb) obj).f414b;
            C0581Yd.m1770d(editText2, "mDataBinding.etLogin");
            if (TextUtils.isEmpty(editText2.getText().toString()) || ((AbstractC0118Eb) this.f4200w).f415c.length() < 6) {
                return;
            }
            m841P();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type fr.smoney.android.izly.SmoneyApplication");
        SmoneyApplication smoneyApplication = (SmoneyApplication) application;
        ((AbstractC0118Eb) this.f4200w).f414b.addTextChangedListener(this);
        ((AbstractC0118Eb) this.f4200w).f417f.setOnClickListener(this);
        ((AbstractC0118Eb) this.f4200w).f416d.setOnClickListener(this);
        ((AbstractC0118Eb) this.f4200w).f419h.setOnClickListener(this);
        ((AbstractC0118Eb) this.f4200w).f415c.addTextChangedListener(this);
        ((AbstractC0118Eb) this.f4200w).f415c.addTextChangedListener(this.f4934C);
        ((AbstractC0118Eb) this.f4200w).f415c.setOnEditorActionListener(this);
        m986F(this);
        ((AbstractC0118Eb) this.f4200w).f413a.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("fr.smoney.android.izly.config.sp", 0);
        if (sharedPreferences.getBoolean("sharedPrefAppFolderRightModified", true)) {
            try {
                Runtime runtime = Runtime.getRuntime();
                StringBuilder sb = new StringBuilder();
                sb.append("/system/bin/chmod 751 ");
                File filesDir = getFilesDir();
                C0581Yd.m1770d(filesDir, "filesDir");
                sb.append(filesDir.getParent());
                runtime.exec(sb.toString());
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("sharedPrefAppFolderRightModified", false);
                edit.commit();
            } catch (IOException e) {
                String str = "Can not unrestrain application folder right :" + e;
            }
        }
        if (bundle != null) {
            this.f4931y = bundle.getString(this.f4933x);
        }
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("fr.smoney.android.izly.extras.launchActivity", -1);
            if (intExtra == 1) {
                this.f4932z = intent.getStringExtra("fr.smoney.android.izly.intentExtra.notifMessage");
            } else if (intExtra == 2) {
                finish();
            } else if (intExtra == 3) {
                m842O();
            } else if (intExtra == 4) {
                m842O();
                ServerError serverError = (ServerError) intent.getParcelableExtra("fr.smoney.android.izly.intentExtra.sessionExpiredServerError");
                C0581Yd.m1771c(serverError);
                int i = serverError.f4601b;
                if (i != 102) {
                    if (i == 324) {
                        this.f4201r.m126E(C0525Vc.m1829s(serverError.f4604f, serverError.f4603d, getString(2131689902), getString(17039360), this, EnumC1631dd.AppOutdatedType));
                        return;
                    } else if (i == 500) {
                        this.f4201r.m126E(C0525Vc.m1829s(serverError.f4604f, serverError.f4603d, getString(2131689909), getString(17039360), this, EnumC1631dd.AccountBlockedType));
                        return;
                    } else if (i != 506) {
                        if (i != 573 && i != 576 && i != 570 && i != 571) {
                            this.f4201r.m126E(C0543Wc.m1822s(!TextUtils.isEmpty(serverError.f4604f) ? serverError.f4604f : getString(2131689771), !TextUtils.isEmpty(serverError.f4603d) ? serverError.f4603d : getString(2131689770), getString(17039370)));
                            return;
                        } else {
                            this.f4201r.m126E(C0543Wc.m1822s(!TextUtils.isEmpty(serverError.f4604f) ? serverError.f4604f : getString(2131689771), serverError.f4603d, getString(17039370)));
                            return;
                        }
                    }
                }
                this.f4201r.m126E(C0525Vc.m1829s(serverError.f4604f, serverError.f4603d, getString(2131689910), getString(17039360), this, EnumC1631dd.AccountBlockedType));
            } else if (intExtra != 5) {
                C0065C8 c0065c8 = SmoneyApplication.f4207g;
                C0581Yd.m1770d(c0065c8, "SmoneyApplication.mAuthentManager");
                if (c0065c8.user_id() != null) {
                    C0065C8 c0065c82 = SmoneyApplication.f4207g;
                    C0581Yd.m1770d(c0065c82, "SmoneyApplication.mAuthentManager");
                    if (c0065c82.m2503i() != null) {
                        m844M();
                        return;
                    }
                }
                m842O();
            } else {
                Intent intent2 = new Intent(this, PhoneValidationActivity.class);
                C0581Yd.m1770d(intent2, "activityStarterIntent");
                intent2.setData(intent.getData());
                Intent intent3 = getIntent();
                C0581Yd.m1770d(intent3, "getIntent()");
                Bundle extras = intent3.getExtras();
                C0581Yd.m1771c(extras);
                intent2.putExtra("fr.smoney.android.izly.extras.startByBrowser", extras.getBoolean("fr.smoney.android.izly.extras.startByBrowser"));
                intent2.setFlags(335544320);
                startActivity(intent2);
                finish();
            }
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
        EditText editText = ((AbstractC0118Eb) this.f4200w).f415c;
        C0581Yd.m1770d(editText, "mDataBinding.etPassword");
        String obj = editText.getText().toString();
        EditText editText2 = ((AbstractC0118Eb) this.f4200w).f414b;
        C0581Yd.m1770d(editText2, "mDataBinding.etLogin");
        if (TextUtils.isEmpty(editText2.getText().toString()) || TextUtils.isEmpty(obj)) {
            return false;
        }
        m841P();
        return true;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((AbstractC0118Eb) this.f4200w).f415c.setText("");
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        boolean z = true;
        if (isGooglePlayServicesAvailable != 0) {
            if (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 2 || isGooglePlayServicesAvailable == 3) {
                Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog(this, isGooglePlayServicesAvailable, 10, new DialogInterface$OnCancelListenerC0029Ad(this));
                if (errorDialog != null) {
                    errorDialog.show();
                }
            } else if (isGooglePlayServicesAvailable == 9) {
                this.f4201r.m126E(C0564Xc.m1796t(getString(2131689781), getString(2131689780), getString(17039370), this, EnumC1631dd.PlayStoreInvalidStatusType));
            }
            z = false;
        }
        if (!z || this.f4932z == null) {
            return;
        }
        this.f4201r.m126E(C0543Wc.m1822s(getString(2131689548), this.f4932z, getString(2131689765)));
        this.f4932z = null;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1769e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(this.f4933x, this.f4931y);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
