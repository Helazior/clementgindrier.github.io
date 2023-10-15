package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import p000.AbstractC1917j6;
import p000.C0195I4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ComponentActivity extends Activity implements InterfaceC1979m6, C0195I4.InterfaceC0196a {

    /* renamed from: a */
    public C2002n6 f2954a;

    public ComponentActivity() {
        new C0101E1();
        this.f2954a = new C2002n6(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0195I4.m2386a(decorView, keyEvent)) {
            return C0195I4.m2385b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0195I4.m2386a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // p000.C0195I4.InterfaceC0196a
    /* renamed from: e */
    public boolean mo1514e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public AbstractC1917j6 getLifecycle() {
        return this.f2954a;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentC2274u6.m300b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f2954a.m570f(AbstractC1917j6.EnumC1919b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
