package p000;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.CounterFamily;
import fr.smoney.android.izly.data.model.CounterListData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.LoginLightData;
import fr.smoney.android.izly.data.model.RequestData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.privateview.HomeActivity;
import fr.smoney.android.izly.p005ui.publicview.activation.PhoneValidationActivity;
import fr.smoney.android.izly.p005ui.publicview.login.LoginActivity;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import p000.AbstractC1668ed;

/* renamed from: x8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2353x8 {

    /* renamed from: t */
    public static AbstractC0216J5 f6815t;

    /* renamed from: a */
    public C0479U8 f6816a;

    /* renamed from: b */
    public SmoneyRequestManager f6817b;

    /* renamed from: c */
    public ArrayList<RequestData> f6818c;

    /* renamed from: f */
    public AppCompatActivity f6819f;

    /* renamed from: g */
    public AbstractC1668ed.InterfaceC1669a f6820g;

    /* renamed from: h */
    public SmoneyRequestManager.InterfaceC1778a f6821h;

    /* renamed from: i */
    public C0977bd f6822i;

    /* renamed from: k */
    public View f6823k;

    /* renamed from: l */
    public TextView f6824l;

    /* renamed from: m */
    public TextView f6825m;

    /* renamed from: n */
    public TextView f6826n;

    /* renamed from: o */
    public RelativeLayout f6827o;

    /* renamed from: p */
    public TextView f6828p;

    /* renamed from: q */
    public LinearLayout f6829q;

    /* renamed from: r */
    public String f6830r;

    /* renamed from: s */
    public SimpleDateFormat f6831s;

    /* renamed from: d */
    public boolean f6832d = false;

    /* renamed from: e */
    public RequestData f6833e = null;

    /* renamed from: j */
    public boolean f6834j = true;

    /* renamed from: A */
    public void m130A() {
        SmoneyRequestManager.InterfaceC1778a interfaceC1778a = this.f6821h;
        if (interfaceC1778a != null) {
            this.f6817b.m952i(interfaceC1778a);
        }
        this.f6833e = null;
        this.f6818c = new ArrayList<>();
    }

    /* renamed from: B */
    public void m129B() {
        Intent intent = new Intent(this.f6819f, HomeActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("fr.smoney.android.izly.extras.showHome", true);
        this.f6819f.startActivity(intent);
        this.f6819f.overridePendingTransition(2130771980, 2130771981);
    }

    /* renamed from: C */
    public final void m128C(boolean z) {
        m126E(C0564Xc.m1796t(this.f6819f.getString(2131689771), this.f6819f.getString(2131689770), this.f6819f.getString(17039370), this.f6820g, z ? EnumC1631dd.ErrorForNotMustBeRetryRequest : EnumC1631dd.ErrorType));
    }

    /* renamed from: D */
    public final void m127D(ServerError serverError) {
        m126E(C0564Xc.m1796t(serverError.f4604f, serverError.f4603d, this.f6819f.getString(17039370), this.f6820g, EnumC1631dd.ErrorType));
    }

    /* renamed from: E */
    public void m126E(AbstractC1668ed abstractC1668ed) {
        AbstractC0216J5 m1448u = this.f6819f.m1448u();
        f6815t = m1448u;
        AbstractC0352P5 mo2312a = m1448u.mo2312a();
        AbstractC1668ed abstractC1668ed2 = (AbstractC1668ed) f6815t.mo2306d("dialog");
        if (abstractC1668ed2 != null) {
            mo2312a.mo2152g(abstractC1668ed2);
        }
        try {
            abstractC1668ed.show(mo2312a, "dialog");
        } catch (IllegalStateException unused) {
        }
    }

    /* renamed from: F */
    public void m125F() {
        if (this.f6834j) {
            C0977bd c0977bd = this.f6822i;
            if (c0977bd == null) {
                String string = this.f6819f.getString(2131690085);
                String string2 = this.f6819f.getString(2131690084);
                AbstractC1668ed.InterfaceC1669a interfaceC1669a = this.f6820g;
                C0977bd c0977bd2 = new C0977bd();
                Bundle m994m = c0977bd2.m994m(interfaceC1669a, C0977bd.f3743g);
                m994m.putString("Argument.DialogTitle", string);
                m994m.putString("Argument.DialogMsg", string2);
                c0977bd2.setArguments(m994m);
                this.f6822i = c0977bd2;
            } else {
                c0977bd.f4164b = this.f6820g;
            }
            if (!this.f6822i.isAdded()) {
                m126E(this.f6822i);
            }
            this.f6834j = false;
        }
    }

    /* renamed from: G */
    public boolean m124G(ServerError serverError) {
        int i = serverError.f4601b;
        if (i != 570 && i != 571) {
            int i2 = serverError.f4605g;
            if (i2 == 0) {
                SmoneyApplication.f4207g.m2508d();
                SmoneyApplication.f4207g.m2509c();
                SmoneyApplication.f4207g.m2510b();
                ((SmoneyApplication) this.f6819f.getApplication()).m979c();
                m115h(serverError);
                return true;
            } else if (i2 == 1) {
                SmoneyApplication.f4207g.m2508d();
                SmoneyApplication.f4207g.m2510b();
                ((SmoneyApplication) this.f6819f.getApplication()).m979c();
                m115h(serverError);
                return true;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return false;
                }
                m127D(serverError);
                return true;
            } else {
                if (i == 105) {
                    m126E(C0564Xc.m1796t(serverError.f4604f, serverError.f4603d, this.f6819f.getString(17039370), this.f6820g, EnumC1631dd.ErrorPasswordType));
                } else if (i == 512) {
                    m126E(C0564Xc.m1796t(serverError.f4604f, serverError.f4603d, this.f6819f.getString(17039370), this.f6820g, EnumC1631dd.ErrorAuthentType));
                } else if (i != 140 && i != 141) {
                    m127D(serverError);
                } else {
                    this.f6816a.m1979a();
                    m126E(C0617ad.m1728s(this.f6819f, this.f6820g));
                }
                return true;
            }
        }
        SmoneyApplication.f4207g.m2508d();
        SmoneyApplication.f4207g.m2510b();
        ((SmoneyApplication) this.f6819f.getApplication()).m979c();
        m115h(serverError);
        return true;
    }

    /* renamed from: H */
    public void m123H() {
        LoginData loginData;
        if (this.f6824l == null || this.f6825m == null || this.f6826n == null || this.f6823k == null || (loginData = SmoneyApplication.f4205d.f1707b) == null || loginData.f4384D == null) {
            return;
        }
        if (loginData.f4368x == 98 && loginData.f4367w == 10) {
            this.f6828p.setText(2131690221);
        }
        LoginData loginData2 = this.f6816a.f1707b;
        if (loginData2 != null && loginData2.f4377H) {
            this.f6823k.setVisibility(8);
        } else {
            double d = loginData.f4384D.f4230a;
            if (d == ShadowDrawableWrapper.COS_45) {
                this.f6824l.setText(String.format("%1$.2f", Double.valueOf(d)));
            } else {
                this.f6824l.setText(String.format("+ %1$.2f", Double.valueOf(d)));
                SpannableString spannableString = new SpannableString(this.f6824l.getText().toString());
                spannableString.setSpan(new RelativeSizeSpan(0.6f), 0, 1, 17);
                this.f6824l.setText(spannableString);
            }
            this.f6825m.setText(Currency.getInstance(loginData.f4383k).getSymbol());
            TextView textView = this.f6826n;
            textView.setText(this.f6819f.getResources().getString(2131689552) + " " + this.f6831s.format(new Date(loginData.f4384D.f4232c)));
        }
        double d2 = loginData.f4384D.f4231b;
        CounterListData counterListData = SmoneyApplication.f4205d.f1716f0;
        if (this.f6827o == null || counterListData == null) {
            return;
        }
        this.f6829q.removeAllViews();
        ArrayList<CounterFamily> arrayList = counterListData.f4264a;
        if (!counterListData.f4265b.booleanValue() && (arrayList = counterListData.f4264a) != null && arrayList.size() > 0) {
            if (arrayList.size() > 3) {
                arrayList.remove(3);
            }
            Collections.reverse(arrayList);
            Collections.swap(arrayList, 1, 2);
            CounterListData counterListData2 = new CounterListData(arrayList);
            counterListData2.f4265b = Boolean.TRUE;
            SmoneyApplication.f4205d.f1716f0 = counterListData2;
        }
        Iterator<CounterFamily> it = arrayList.iterator();
        while (it.hasNext()) {
            CounterFamily next = it.next();
            View inflate = LayoutInflater.from(this.f6819f).inflate(2131492979, (ViewGroup) this.f6829q, false);
            TextView textView2 = (TextView) inflate.findViewById(2131296968);
            ((TextView) inflate.findViewById(2131296967)).setText(next.f4262b);
            if (next.f4261a == 3) {
                textView2.setText(String.format("%1$.2f%2$s", new BigDecimal(next.f4263c).divide(new BigDecimal(100)), Currency.getInstance(loginData.f4383k).getSymbol()));
            } else {
                textView2.setText(next.f4263c + "");
            }
            this.f6829q.addView(inflate);
        }
    }

    /* renamed from: a */
    public final boolean m122a(ArrayList<RequestData> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f4599c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m121b(String str) {
        String user_id;
        int i;
        SmoneyRequestManager smoneyRequestManager = this.f6817b;
        LoginData loginData = this.f6816a.f1707b;
        if (loginData == null || (user_id = loginData.f4380a) == null) {
            user_id = SmoneyApplication.f4207g.user_id();
        }
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 232 && valueAt.getStringExtra("fr.smoney.android.izly.extras.loginLightUserId").equals(user_id) && valueAt.getStringExtra("fr.smoney.android.izly.extras.loginLightPassword").equals(str)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 232);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.loginLightUserId", user_id);
                intent.putExtra("fr.smoney.android.izly.extras.loginLightPassword", str);
                smoneyRequestManager.m959b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u8 = smoneyRequestManager.f4693f;
                c0479u8.f1728l0 = null;
                c0479u8.f1730m0 = null;
                i = nextInt;
                break;
            }
        }
        m120c(i, 232, true);
    }

    /* renamed from: c */
    public void m120c(int i, int i2, boolean z) {
        if (z) {
            m125F();
        }
        this.f6833e = new RequestData(i, i2, z);
        synchronized (this.f6818c) {
            if (!this.f6818c.contains(this.f6833e)) {
                this.f6818c.add(this.f6833e);
            }
        }
        SmoneyRequestManager.InterfaceC1778a interfaceC1778a = this.f6821h;
        if (interfaceC1778a != null) {
            this.f6817b.m960a(interfaceC1778a);
        }
    }

    /* renamed from: d */
    public void m119d(boolean z) {
        if (z) {
            ((SmoneyApplication) this.f6819f.getApplication()).m979c();
        }
        Intent intent = new Intent(this.f6819f, LoginActivity.class);
        intent.addFlags(268468224);
        intent.putExtra("fr.smoney.android.izly.extras.launchActivity", 2);
        this.f6819f.startActivity(intent);
        this.f6819f.overridePendingTransition(2130771980, 2130771981);
    }

    /* renamed from: e */
    public void m118e(EnumC1631dd enumC1631dd) {
        AbstractC1668ed abstractC1668ed = (AbstractC1668ed) f6815t.mo2306d("dialog");
        if (abstractC1668ed != null && abstractC1668ed.f4163a == enumC1631dd && abstractC1668ed.isAdded()) {
            abstractC1668ed.dismiss();
        }
    }

    /* renamed from: f */
    public void m117f() {
        m118e(EnumC1631dd.ProgressType);
        this.f6834j = true;
    }

    /* renamed from: g */
    public void m116g(int i, Fragment fragment) {
        AbstractC0216J5 m1448u = this.f6819f.m1448u();
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = (LayoutInflater$Factory2C0236K5) m1448u;
        Objects.requireNonNull(layoutInflater$Factory2C0236K5);
        C0088D5 c0088d5 = new C0088D5(layoutInflater$Factory2C0236K5);
        Fragment mo2308c = m1448u.mo2308c(i);
        if (mo2308c != null) {
            c0088d5.mo2152g(mo2308c);
        }
        c0088d5.f1192f = 0;
        if (i != 0) {
            c0088d5.mo2153f(i, fragment, "fragment", 2);
            c0088d5.mo2156c();
            return;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    /* renamed from: h */
    public void m115h(ServerError serverError) {
        Intent intent = new Intent(this.f6819f, LoginActivity.class);
        intent.addFlags(335544320);
        intent.putExtra("fr.smoney.android.izly.extras.userId", this.f6816a.f1705a);
        intent.putExtra("fr.smoney.android.izly.extras.launchActivity", 4);
        intent.putExtra("fr.smoney.android.izly.intentExtra.sessionExpiredServerError", serverError);
        this.f6819f.startActivity(intent);
        AppCompatActivity appCompatActivity = this.f6819f;
        if (appCompatActivity instanceof LoginActivity) {
            appCompatActivity.overridePendingTransition(0, 0);
        } else {
            appCompatActivity.overridePendingTransition(2130771980, 2130771981);
        }
        this.f6819f.finish();
    }

    /* renamed from: i */
    public final ArrayList<RequestData> m114i() {
        SmoneyRequestManager smoneyRequestManager = this.f6817b;
        ArrayList<RequestData> arrayList = this.f6818c;
        Objects.requireNonNull(smoneyRequestManager);
        ArrayList<RequestData> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (smoneyRequestManager.f4688a.indexOfKey(arrayList.get(i).f4597a) >= 0) {
                arrayList2.add(arrayList.get(i));
            }
        }
        return arrayList2;
    }

    /* renamed from: j */
    public int m113j() {
        RequestData requestData = this.f6833e;
        if (requestData == null) {
            return -1;
        }
        return requestData.f4598b;
    }

    /* renamed from: k */
    public boolean m112k(int i) {
        int size = this.f6818c.size();
        for (int i2 = 0; i2 < size; i2++) {
            RequestData requestData = this.f6818c.get(i2);
            if (requestData.f4598b == i) {
                if (this.f6817b.f4688a.indexOfKey(requestData.f4597a) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: l */
    public void m111l() {
        boolean z = this.f6832d;
        if (this.f6819f.getClass() != HomeActivity.class) {
            if (z) {
                this.f6819f.overridePendingTransition(2130771982, 2130771983);
            } else {
                this.f6819f.overridePendingTransition(2130771980, 2130771981);
            }
        }
    }

    /* renamed from: m */
    public final void m110m(LoginLightData loginLightData, ServerError serverError) {
        if (serverError != null) {
            m124G(serverError);
        } else if (loginLightData == null) {
            m126E(C0580Yc.m1774u(this.f6819f, this.f6820g, EnumC1631dd.ConnexionErrorDuringReloginType));
        } else {
            SmoneyApplication.f4207g.editSharedPrefNsse(loginLightData.f4389c);
            this.f6830r = null;
            Intent intent = new Intent("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
            intent.putExtra("fr.smoney.android.izly.sessionState", 1);
            this.f6819f.sendBroadcast(intent);
        }
    }

    /* renamed from: n */
    public void m109n() {
        ArrayList<RequestData> m114i = m114i();
        if (m114i.size() > 0) {
            if (m122a(m114i)) {
                m125F();
            }
            SmoneyRequestManager.InterfaceC1778a interfaceC1778a = this.f6821h;
            if (interfaceC1778a != null) {
                this.f6817b.m960a(interfaceC1778a);
            }
        }
        synchronized (this.f6818c) {
            for (int i = 0; i < this.f6818c.size(); i++) {
                RequestData requestData = this.f6818c.get(i);
                if (!m114i.contains(requestData)) {
                    int i2 = requestData.f4598b;
                    if (i2 == 232) {
                        C0479U8 c0479u8 = this.f6816a;
                        m110m(c0479u8.f1728l0, c0479u8.f1730m0);
                    } else {
                        SmoneyRequestManager.InterfaceC1778a interfaceC1778a2 = this.f6821h;
                        if (interfaceC1778a2 != null) {
                            interfaceC1778a2.mo238n(i2);
                        }
                    }
                    this.f6818c.remove(requestData);
                }
            }
        }
    }

    /* renamed from: o */
    public boolean m108o(int i, int i2, int i3, Bundle bundle) {
        RequestData requestData;
        ArrayList<RequestData> arrayList = this.f6818c;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                requestData = this.f6818c.get(i4);
                if (requestData.f4597a == i) {
                    break;
                }
            }
        }
        requestData = null;
        if (requestData != null) {
            this.f6833e = requestData;
            synchronized (this.f6818c) {
                this.f6818c.remove(requestData);
            }
            ArrayList<RequestData> m114i = m114i();
            if (m114i.size() == 0) {
                SmoneyRequestManager.InterfaceC1778a interfaceC1778a = this.f6821h;
                if (interfaceC1778a != null) {
                    this.f6817b.m952i(interfaceC1778a);
                }
                m117f();
            } else if (!m122a(m114i)) {
                m117f();
            }
            if (i3 == -1) {
                if (i2 == 33 || i2 == 53) {
                    m128C(true);
                    return false;
                } else if (bundle != null) {
                    if (bundle.getInt("com.foxykeep.datadroid.extras.error", -1) == 2) {
                        m128C(false);
                        return false;
                    }
                    AppCompatActivity appCompatActivity = this.f6819f;
                    if (!(appCompatActivity instanceof HomeActivity)) {
                        m126E(C0580Yc.m1775t(appCompatActivity, this.f6820g));
                        return false;
                    }
                } else {
                    AppCompatActivity appCompatActivity2 = this.f6819f;
                    if (!(appCompatActivity2 instanceof HomeActivity)) {
                        m126E(C0580Yc.m1775t(appCompatActivity2, this.f6820g));
                        return false;
                    }
                }
            } else if (i2 == 232) {
                m110m((LoginLightData) bundle.getParcelable("fr.smoney.android.izly.extras.LoginLight"), (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError"));
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: p */
    public void m107p(Intent intent, boolean z) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            ComponentName componentName = new ComponentName(this.f6819f, HomeActivity.class);
            if (component != null && component.equals(componentName) && (intent.getFlags() & 67108864) != 0) {
                this.f6819f.overridePendingTransition(2130771980, 2130771981);
            } else if (z) {
                this.f6819f.overridePendingTransition(2130771984, 2130771985);
            } else {
                this.f6819f.overridePendingTransition(2130771986, 2130771987);
            }
        }
    }

    /* renamed from: q */
    public void m106q(EnumC1631dd enumC1631dd) {
        int ordinal = enumC1631dd.ordinal();
        if (ordinal == 4 || ordinal == 5) {
            m130A();
        } else if (ordinal != 7) {
        } else {
            AppCompatActivity appCompatActivity = this.f6819f;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                ((InterfaceC1928jd) appCompatActivity).mo684m();
            } else {
                m129B();
            }
        }
    }

    /* renamed from: r */
    public void m105r(Bundle bundle, AppCompatActivity appCompatActivity, AbstractC1668ed.InterfaceC1669a interfaceC1669a, SmoneyRequestManager.InterfaceC1778a interfaceC1778a) {
        this.f6819f = appCompatActivity;
        this.f6820g = interfaceC1669a;
        this.f6821h = interfaceC1778a;
        this.f6816a = SmoneyApplication.f4205d;
        this.f6817b = SmoneyApplication.f4206f;
        this.f6831s = new SimpleDateFormat(appCompatActivity.getResources().getString(2131689743), Locale.getDefault());
        if (bundle != null) {
            this.f6818c = bundle.getParcelableArrayList("savedStateRequestData");
            this.f6830r = bundle.getString("savedStateCurrentPassword");
            C0479U8 c0479u8 = this.f6816a;
            Objects.requireNonNull(c0479u8);
            c0479u8.f1707b = (LoginData) bundle.getParcelable("loginDataKEy");
        } else {
            this.f6818c = new ArrayList<>();
        }
        Intent intent = this.f6819f.getIntent();
        if (intent == null || !intent.hasExtra("INTENT_EXTRA_IS_MODAL")) {
            return;
        }
        this.f6832d = intent.getBooleanExtra("INTENT_EXTRA_IS_MODAL", false);
    }

    /* renamed from: s */
    public void m104s() {
        this.f6816a = null;
        this.f6817b = null;
        this.f6833e = null;
        this.f6818c = null;
        this.f6819f = null;
        this.f6821h = null;
        this.f6820g = null;
        this.f6819f = null;
    }

    /* renamed from: t */
    public void m103t(EnumC1631dd enumC1631dd) {
        if (enumC1631dd.ordinal() == 9 && m113j() == 232) {
            AppCompatActivity appCompatActivity = this.f6819f;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                ((InterfaceC1928jd) appCompatActivity).mo684m();
            } else {
                m129B();
            }
        }
    }

    /* renamed from: u */
    public void m102u(EnumC1631dd enumC1631dd) {
        int ordinal = enumC1631dd.ordinal();
        if (ordinal == 2 || ordinal == 3) {
            AppCompatActivity appCompatActivity = this.f6819f;
            if ((appCompatActivity instanceof LoginActivity) || (appCompatActivity instanceof PhoneValidationActivity)) {
                return;
            }
            m126E(C0617ad.m1728s(appCompatActivity, this.f6820g));
        } else if (ordinal != 49) {
        } else {
            C0479U8 c0479u8 = this.f6816a;
            c0479u8.f1758C0 = true;
            c0479u8.f1757B0 = true;
            c0479u8.f1759D0 = true;
            AppCompatActivity appCompatActivity2 = this.f6819f;
            if (appCompatActivity2 instanceof InterfaceC1928jd) {
                ((InterfaceC1928jd) appCompatActivity2).mo684m();
            } else {
                m129B();
            }
        }
    }

    /* renamed from: v */
    public void mo151v() {
        synchronized (this.f6818c) {
            if (this.f6818c.size() > 0) {
                SmoneyRequestManager.InterfaceC1778a interfaceC1778a = this.f6821h;
                if (interfaceC1778a != null) {
                    this.f6817b.m952i(interfaceC1778a);
                }
                m117f();
            }
        }
    }

    /* renamed from: w */
    public void m100w(EnumC1631dd enumC1631dd, Bundle bundle) {
        int ordinal = enumC1631dd.ordinal();
        if (ordinal == 7) {
            String string = bundle.getString("Data.Password");
            this.f6830r = string;
            m121b(string);
        } else if (ordinal == 9) {
            if (m113j() == 232) {
                m121b(this.f6830r);
            }
        } else if (ordinal != 10) {
        } else {
            LoginData loginData = this.f6816a.f1707b;
            if (loginData != null) {
                SmoneyRequestManager smoneyRequestManager = this.f6817b;
                String str = loginData.f4380a;
                String str2 = loginData.f4382c;
                Objects.requireNonNull(smoneyRequestManager);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 2);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("fr.smoney.android.izly.extras.logoutUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.logoutSessionId", str2);
                smoneyRequestManager.m959b(intent);
                C0479U8 c0479u8 = smoneyRequestManager.f4693f;
                c0479u8.f1707b = null;
                c0479u8.f1711d = null;
            }
            SmoneyApplication.f4207g.m2508d();
            SmoneyApplication.f4207g.m2510b();
            ((SmoneyApplication) this.f6819f.getApplication()).m979c();
            Intent intent2 = new Intent(this.f6819f, LoginActivity.class);
            intent2.addFlags(335544320);
            intent2.putExtra("fr.smoney.android.izly.extras.launchActivity", 3);
            this.f6819f.startActivity(intent2);
            this.f6819f.overridePendingTransition(2130771980, 2130771981);
            this.f6819f.finish();
        }
    }

    /* renamed from: x */
    public void mo150x() {
        f6815t = this.f6819f.m1448u();
        synchronized (this.f6818c) {
            if (this.f6818c.size() > 0) {
                m109n();
            }
        }
    }

    /* renamed from: y */
    public void m98y(Bundle bundle) {
        bundle.putParcelableArrayList("savedStateRequestData", this.f6818c);
        bundle.putString("savedStateCurrentPassword", this.f6830r);
        LoginData loginData = this.f6816a.f1707b;
        if (loginData != null) {
            bundle.putParcelable("loginDataKEy", loginData);
        }
    }

    /* renamed from: z */
    public void mo149z() {
    }
}
