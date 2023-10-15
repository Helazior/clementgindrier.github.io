package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements InterfaceC1979m6, InterfaceC2402z6, InterfaceC1959l7, InterfaceC1633e {

    /* renamed from: b */
    public final C2002n6 f2193b;

    /* renamed from: c */
    public final C1939k7 f2194c;

    /* renamed from: d */
    public C2385y6 f2195d;

    /* renamed from: f */
    public final OnBackPressedDispatcher f2196f;

    /* renamed from: androidx.activity.ComponentActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0626a implements Runnable {
        public RunnableC0626a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0627b {

        /* renamed from: a */
        public C2385y6 f2200a;
    }

    public ComponentActivity() {
        C2002n6 c2002n6 = new C2002n6(this);
        this.f2193b = c2002n6;
        this.f2194c = new C1939k7(this);
        this.f2196f = new OnBackPressedDispatcher(new RunnableC0626a());
        int i = Build.VERSION.SDK_INT;
        c2002n6.mo575a(new InterfaceC1938k6() { // from class: androidx.activity.ComponentActivity.2
            @Override // p000.InterfaceC1938k6
            /* renamed from: d */
            public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
                if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        c2002n6.mo575a(new InterfaceC1938k6() { // from class: androidx.activity.ComponentActivity.3
            @Override // p000.InterfaceC1938k6
            /* renamed from: d */
            public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
                if (enumC1918a != AbstractC1917j6.EnumC1918a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.getViewModelStore().m51a();
            }
        });
        if (i <= 23) {
            c2002n6.mo575a(new ImmLeaksCleaner(this));
        }
    }

    @Override // p000.InterfaceC1633e
    /* renamed from: b */
    public final OnBackPressedDispatcher mo1007b() {
        return this.f2196f;
    }

    @Override // androidx.core.app.ComponentActivity, p000.InterfaceC1979m6
    public AbstractC1917j6 getLifecycle() {
        return this.f2193b;
    }

    @Override // p000.InterfaceC1959l7
    public final C1920j7 getSavedStateRegistry() {
        return this.f2194c.f5385b;
    }

    @Override // p000.InterfaceC2402z6
    public C2385y6 getViewModelStore() {
        if (getApplication() != null) {
            if (this.f2195d == null) {
                C0627b c0627b = (C0627b) getLastNonConfigurationInstance();
                if (c0627b != null) {
                    this.f2195d = c0627b.f2200a;
                }
                if (this.f2195d == null) {
                    this.f2195d = new C2385y6();
                }
            }
            return this.f2195d;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f2196f.m1721a();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2194c.m679a(bundle);
        FragmentC2274u6.m300b(this);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        C0627b c0627b;
        C2385y6 c2385y6 = this.f2195d;
        if (c2385y6 == null && (c0627b = (C0627b) getLastNonConfigurationInstance()) != null) {
            c2385y6 = c0627b.f2200a;
        }
        if (c2385y6 == null) {
            return null;
        }
        C0627b c0627b2 = new C0627b();
        c0627b2.f2200a = c2385y6;
        return c0627b2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C2002n6 c2002n6 = this.f2193b;
        if (c2002n6 instanceof C2002n6) {
            c2002n6.m570f(AbstractC1917j6.EnumC1919b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f2194c.m678b(bundle);
    }
}
