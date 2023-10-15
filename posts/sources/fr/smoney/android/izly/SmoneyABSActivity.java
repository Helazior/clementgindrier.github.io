package fr.smoney.android.izly;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import fr.smoney.android.izly.data.network.ConnectivityBroadcastReceiver;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import java.util.Locale;
import java.util.Objects;
import p000.AbstractC1668ed;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class SmoneyABSActivity<B extends ViewDataBinding> extends AppCompatActivity implements AbstractC1668ed.InterfaceC1669a, InterfaceC1899id {

    /* renamed from: s */
    public IntentFilter f4198s;

    /* renamed from: t */
    public ConnectivityBroadcastReceiver f4199t;

    /* renamed from: u */
    public boolean f4200u;

    /* renamed from: w */
    public B f4202w;

    /* renamed from: r */
    public C2329w8 f4197r = new C2329w8();

    /* renamed from: v */
    public boolean f4201v = false;

    /* renamed from: F */
    public void m983F(Activity activity) {
        if (Locale.getDefault().getLanguage().equals("fr")) {
            ((ImageView) activity.findViewById(2131296532)).setImageAlpha(77);
        } else {
            ((ImageView) activity.findViewById(2131296566)).setImageAlpha(77);
        }
    }

    /* renamed from: G */
    public abstract int mo836G();

    /* renamed from: H */
    public int m982H() {
        return this.f4197r.m113j();
    }

    /* renamed from: I */
    public boolean m981I(int i) {
        return this.f4197r.m112k(i);
    }

    /* renamed from: J */
    public void m980J(int i) {
        this.f4197r.m128C(i == 33 || i == 53);
    }

    /* renamed from: K */
    public void m979K() {
        C2329w8 c2329w8 = this.f4197r;
        c2329w8.m126E(C0617ad.m1725s(c2329w8.f6821f, c2329w8.f6822g));
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(EnumC1631dd enumC1631dd) {
        this.f4197r.m102u(enumC1631dd);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f4197r.m111l();
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(EnumC1631dd enumC1631dd) {
        this.f4197r.m106q(enumC1631dd);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(EnumC1631dd enumC1631dd, Bundle bundle) {
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(EnumC1631dd enumC1631dd) {
        this.f4197r.m103t(enumC1631dd);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new C2408zc(this);
        this.f4202w = (B) DataBindingUtil.setContentView(this, mo836G());
        this.f4197r.m105r(bundle, this, this, this instanceof SmoneyRequestManager.InterfaceC1778a ? (SmoneyRequestManager.InterfaceC1778a) this : null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f4197r.m104s();
        this.f4202w = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C2329w8 c2329w8 = this.f4197r;
        Objects.requireNonNull(c2329w8);
        if (menuItem.getItemId() == 16908332) {
            c2329w8.m129B();
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f4197r.mo101v();
        if (!this.f4201v) {
            unregisterReceiver(this.f4199t);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f4197r.mo99x();
        if (this.f4201v) {
            return;
        }
        this.f4198s = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        ConnectivityBroadcastReceiver connectivityBroadcastReceiver = new ConnectivityBroadcastReceiver(this);
        this.f4199t = connectivityBroadcastReceiver;
        registerReceiver(connectivityBroadcastReceiver, this.f4198s);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_LOGON_STATE_CHANGE_ERROR_INTENT_URI");
        registerReceiver(this.f4199t, intentFilter);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f4197r.m98y(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        SmoneyApplication smoneyApplication = (SmoneyApplication) this.f4197r.f6821f.getApplication();
        if (!smoneyApplication.f4211a) {
            smoneyApplication.f4212b = false;
        }
        super.onStop();
    }

    @Override // p000.InterfaceC1899id
    /* renamed from: p */
    public void mo725p(boolean z, boolean z2) {
        this.f4200u = z;
    }

    @Override // p000.InterfaceC1899id
    /* renamed from: q */
    public void mo724q(boolean z, boolean z2) {
        this.f4200u = z;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        m1682y().mo27s(i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (intent != null) {
            intent.putExtra("INTENT_EXTRA_IS_MODAL", false);
        }
        super.startActivity(intent);
        this.f4197r.m107p(intent, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        this.f4197r.m107p(intent, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1682y().mo25u(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
    }
}
