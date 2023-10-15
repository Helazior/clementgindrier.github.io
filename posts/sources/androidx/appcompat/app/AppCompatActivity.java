package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p000.AbstractC0485V;
import p000.C2307w3;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatActivity extends FragmentActivity implements InterfaceC2360y {

    /* renamed from: q */
    public AbstractC2394z f2302q;

    /* renamed from: A */
    public Intent m1687A() {
        return LayoutInflater$Factory2C0000A.C0010h.m2666L(this);
    }

    /* renamed from: B */
    public void m1686B() {
    }

    /* renamed from: C */
    public void m1685C() {
    }

    /* renamed from: D */
    public void m1684D(Toolbar toolbar) {
        m1682y().mo24v(toolbar);
    }

    @Deprecated
    /* renamed from: E */
    public void m1683E() {
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1682y().mo45a(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(m1682y().mo44b(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar m1681z = m1681z();
        if (getWindow().hasFeature(0)) {
            if (m1681z == null || !m1681z.mo1720a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar m1681z = m1681z();
        if (keyCode == 82 && m1681z != null && m1681z.mo1711j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) m1682y().mo43c(i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m1682y().mo41e();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = C1832g1.f5071a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m1682y().mo38h();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1682y().mo37i(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC2394z m1682y = m1682y();
        m1682y.mo39g();
        m1682y.mo36j(bundle);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m1682y().mo35k();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if ((Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent m2666L;
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar m1681z = m1681z();
        if (menuItem.getItemId() != 16908332 || m1681z == null || (m1681z.mo1717d() & 4) == 0 || (m2666L = LayoutInflater$Factory2C0000A.C0010h.m2666L(this)) == null) {
            return false;
        }
        if (shouldUpRecreateTask(m2666L)) {
            ArrayList arrayList = new ArrayList();
            Intent m1687A = m1687A();
            if (m1687A == null) {
                m1687A = LayoutInflater$Factory2C0000A.C0010h.m2666L(this);
            }
            if (m1687A != null) {
                ComponentName component = m1687A.getComponent();
                if (component == null) {
                    component = m1687A.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent m2665M = LayoutInflater$Factory2C0000A.C0010h.m2665M(this, component);
                    while (m2665M != null) {
                        arrayList.add(size, m2665M);
                        m2665M = LayoutInflater$Factory2C0000A.C0010h.m2665M(this, m2665M.getComponent());
                    }
                    arrayList.add(m1687A);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            m1685C();
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                Object obj = C2307w3.f6741a;
                C2307w3.C2308a.m208a(this, intentArr, null);
                try {
                    int i2 = C1854h3.f5137c;
                    finishAffinity();
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        navigateUpTo(m2666L);
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m1682y().mo34l(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        m1682y().mo33m();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m1682y().mo32n(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m1682y().mo31o();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m1682y().mo30p();
    }

    @Override // p000.InterfaceC2360y
    public void onSupportActionModeFinished(AbstractC0485V abstractC0485V) {
    }

    @Override // p000.InterfaceC2360y
    public void onSupportActionModeStarted(AbstractC0485V abstractC0485V) {
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m1682y().mo22x(charSequence);
    }

    @Override // p000.InterfaceC2360y
    public AbstractC0485V onWindowStartingSupportActionMode(AbstractC0485V.InterfaceC0486a interfaceC0486a) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar m1681z = m1681z();
        if (getWindow().hasFeature(0)) {
            if (m1681z == null || !m1681z.mo1710k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        m1682y().mo27s(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        m1682y().mo23w(i);
    }

    @Override // androidx.fragment.app.FragmentActivity
    /* renamed from: x */
    public void mo1442x() {
        m1682y().mo38h();
    }

    /* renamed from: y */
    public AbstractC2394z m1682y() {
        if (this.f2302q == null) {
            C2396z1<WeakReference<AbstractC2394z>> c2396z1 = AbstractC2394z.f6895a;
            this.f2302q = new LayoutInflater$Factory2C0000A(this, null, this, this);
        }
        return this.f2302q;
    }

    /* renamed from: z */
    public ActionBar m1681z() {
        return m1682y().mo40f();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        m1682y().mo26t(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1682y().mo25u(view, layoutParams);
    }
}
