package fr.smoney.android.izly;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import p000.AbstractC1668ed;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SmoneyActivityWrapper extends AppCompatActivity implements AbstractC1668ed.InterfaceC1669a {

    /* renamed from: r */
    public C2352x8 f4203r = new C2352x8();

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(EnumC1631dd enumC1631dd) {
        this.f4203r.m102u(enumC1631dd);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f4203r.m111l();
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(EnumC1631dd enumC1631dd) {
        this.f4203r.m106q(enumC1631dd);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(EnumC1631dd enumC1631dd, Bundle bundle) {
        this.f4203r.m100w(enumC1631dd, bundle);
    }

    @Override // p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(EnumC1631dd enumC1631dd) {
        this.f4203r.m103t(enumC1631dd);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4203r.m105r(bundle, this, this, this instanceof SmoneyRequestManager.InterfaceC1778a ? (SmoneyRequestManager.InterfaceC1778a) this : null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f4203r.m104s();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f4203r.mo101v();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f4203r.mo99x();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f4203r.m98y(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f4203r.mo97z();
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        this.f4203r.m107p(intent, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        this.f4203r.m107p(intent, false);
    }
}
