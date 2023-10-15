package p000;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import fr.smoney.android.izly.data.network.ConnectivityBroadcastReceiver;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import java.util.Objects;
import p000.AbstractC1668ed;

/* renamed from: B8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0044B8<B extends ViewDataBinding> extends Fragment implements AbstractC1668ed.InterfaceC1669a, InterfaceC1899id {

    /* renamed from: a */
    public double f196a;

    /* renamed from: c */
    public ConnectivityBroadcastReceiver f198c;

    /* renamed from: d */
    public IntentFilter f199d;

    /* renamed from: f */
    public boolean f200f;

    /* renamed from: g */
    public AppCompatActivity f201g;

    /* renamed from: h */
    public B f202h;

    /* renamed from: b */
    public final C2387y8 f197b = new C2387y8();

    /* renamed from: i */
    public CountDownTimer f203i = null;

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(EnumC1631dd enumC1631dd) {
        this.f197b.m102u(enumC1631dd);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(EnumC1631dd enumC1631dd) {
        this.f197b.m106q(enumC1631dd);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(EnumC1631dd enumC1631dd, Bundle bundle) {
        this.f197b.m100w(enumC1631dd, bundle);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(EnumC1631dd enumC1631dd) {
        this.f197b.m103t(enumC1631dd);
    }

    /* renamed from: m */
    public abstract int mo236m();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Objects.requireNonNull(this.f197b);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f201g = (AppCompatActivity) activity;
        Objects.requireNonNull(this.f197b);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f197b.m105r(bundle, this.f201g, this, this instanceof SmoneyRequestManager.InterfaceC1778a ? (SmoneyRequestManager.InterfaceC1778a) this : null);
        new C2408zc(this.f201g);
        this.f196a = getResources().getDisplayMetrics().widthPixels;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        B b = (B) DataBindingUtil.inflate(layoutInflater, mo236m(), viewGroup, false);
        this.f202h = b;
        return b.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f197b.m104s();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f202h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Objects.requireNonNull(this.f197b);
        this.f201g = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f197b.mo101v();
        this.f201g.unregisterReceiver(this.f198c);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f197b.mo99x();
        this.f197b.m123H();
        this.f199d = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        ConnectivityBroadcastReceiver connectivityBroadcastReceiver = new ConnectivityBroadcastReceiver(this);
        this.f198c = connectivityBroadcastReceiver;
        this.f201g.registerReceiver(connectivityBroadcastReceiver, this.f199d);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_LOGON_STATE_CHANGE_ERROR_INTENT_URI");
        this.f201g.registerReceiver(this.f198c, intentFilter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f197b.m98y(bundle);
    }

    @Override // p000.InterfaceC1899id
    /* renamed from: p */
    public void mo725p(boolean z, boolean z2) {
        this.f200f = z;
    }

    @Override // p000.InterfaceC1899id
    /* renamed from: q */
    public void mo724q(boolean z, boolean z2) {
        this.f200f = z;
    }

    /* renamed from: r */
    public int m2556r() {
        return this.f197b.m113j();
    }

    /* renamed from: s */
    public boolean mo234s() {
        Objects.requireNonNull(this.f197b);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        this.f197b.m107p(intent, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        this.f197b.m107p(intent, false);
    }

    /* renamed from: t */
    public void m2555t(double d, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = (int) ((((this.f196a * 6.0d) / 16.0d) * d) + 50.0d);
        layoutParams.height = i / 2;
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: u */
    public void m2554u(double d, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = (int) ((this.f196a * d * 2.0d) + 50.0d);
        layoutParams.height = i;
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: v */
    public void m2553v(Intent intent, boolean z) {
        if (intent != null) {
            intent.putExtra("INTENT_EXTRA_IS_MODAL", true);
        }
        super.startActivity(intent);
        this.f197b.m107p(intent, z);
    }
}
