package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Objects;
import okhttp3.internal.http2.Settings;
import p000.AbstractC1917j6;
import p000.C1854h3;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FragmentActivity extends ComponentActivity implements C1854h3.InterfaceC1856b, C1854h3.InterfaceC1857c {

    /* renamed from: g */
    public final C0151G5 f3115g;

    /* renamed from: h */
    public final C2002n6 f3116h;

    /* renamed from: i */
    public boolean f3117i;

    /* renamed from: j */
    public boolean f3118j;

    /* renamed from: k */
    public boolean f3119k;

    /* renamed from: l */
    public boolean f3120l;

    /* renamed from: m */
    public boolean f3121m;

    /* renamed from: n */
    public boolean f3122n;

    /* renamed from: o */
    public int f3123o;

    /* renamed from: p */
    public C0127F1<String> f3124p;

    /* renamed from: androidx.fragment.app.FragmentActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0811a extends AbstractC0197I5<FragmentActivity> implements InterfaceC2402z6, InterfaceC1633e {
        public C0811a() {
            super(FragmentActivity.this);
        }

        @Override // p000.AbstractC0132F5
        /* renamed from: a */
        public View mo1441a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // p000.InterfaceC1633e
        /* renamed from: b */
        public OnBackPressedDispatcher mo1007b() {
            return FragmentActivity.this.f2196f;
        }

        @Override // p000.AbstractC0132F5
        /* renamed from: c */
        public boolean mo1440c() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: d */
        public void mo1439d(Fragment fragment) {
            FragmentActivity.this.m1443w();
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: e */
        public void mo1438e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, null, printWriter, strArr);
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: f */
        public FragmentActivity mo1437f() {
            return FragmentActivity.this;
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: g */
        public LayoutInflater mo1436g() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // p000.InterfaceC1979m6
        public AbstractC1917j6 getLifecycle() {
            return FragmentActivity.this.f3116h;
        }

        @Override // p000.InterfaceC2402z6
        public C2385y6 getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: h */
        public int mo1435h() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: i */
        public boolean mo1434i() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: j */
        public void mo1433j(Fragment fragment, String[] strArr, int i) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            Objects.requireNonNull(fragmentActivity);
            if (i == -1) {
                C1854h3.m783d(fragmentActivity, strArr, i);
                return;
            }
            FragmentActivity.m1446t(i);
            try {
                fragmentActivity.f3120l = true;
                C1854h3.m783d(fragmentActivity, strArr, ((fragmentActivity.m1447s(fragment) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
            } finally {
                fragmentActivity.f3120l = false;
            }
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: k */
        public boolean mo1432k(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: l */
        public boolean mo1431l(String str) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            int i = C1854h3.f5137c;
            if (Build.VERSION.SDK_INT >= 23) {
                return fragmentActivity.shouldShowRequestPermissionRationale(str);
            }
            return false;
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: m */
        public void mo1430m(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            fragmentActivity.f3122n = true;
            try {
                if (i == -1) {
                    int i2 = C1854h3.f5137c;
                    fragmentActivity.startActivityForResult(intent, -1, bundle);
                } else {
                    FragmentActivity.m1446t(i);
                    int m1447s = ((fragmentActivity.m1447s(fragment) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                    int i3 = C1854h3.f5137c;
                    fragmentActivity.startActivityForResult(intent, m1447s, bundle);
                }
            } finally {
                fragmentActivity.f3122n = false;
            }
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: n */
        public void mo1429n(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            fragmentActivity.f3121m = true;
            try {
                if (i == -1) {
                    int i5 = C1854h3.f5137c;
                    fragmentActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
                } else {
                    FragmentActivity.m1446t(i);
                    int m1447s = ((fragmentActivity.m1447s(fragment) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                    int i6 = C1854h3.f5137c;
                    fragmentActivity.startIntentSenderForResult(intentSender, m1447s, intent, i2, i3, i4, bundle);
                }
            } finally {
                fragmentActivity.f3121m = false;
            }
        }

        @Override // p000.AbstractC0197I5
        /* renamed from: o */
        public void mo1428o() {
            FragmentActivity.this.mo1442x();
        }
    }

    public FragmentActivity() {
        C0811a c0811a = new C0811a();
        LayoutInflater$Factory2C0000A.C0010h.m2637h(c0811a, "callbacks == null");
        this.f3115g = new C0151G5(c0811a);
        this.f3116h = new C2002n6(this);
        this.f3119k = true;
    }

    /* renamed from: t */
    public static void m1446t(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    /* renamed from: v */
    public static boolean m1444v(AbstractC0216J5 abstractC0216J5, AbstractC1917j6.EnumC1919b enumC1919b) {
        boolean z = false;
        for (Fragment fragment : abstractC0216J5.mo2299f()) {
            if (fragment != null) {
                if (((C2002n6) fragment.getLifecycle()).f5539b.compareTo(AbstractC1917j6.EnumC1919b.STARTED) >= 0) {
                    fragment.mLifecycleRegistry.m570f(enumC1919b);
                    z = true;
                }
                if (fragment.getHost() != null) {
                    z |= m1444v(fragment.getChildFragmentManager(), enumC1919b);
                }
            }
        }
        return z;
    }

    @Override // p000.C1854h3.InterfaceC1857c
    /* renamed from: a */
    public final void mo782a(int i) {
        if (this.f3120l || i == -1) {
            return;
        }
        m1446t(i);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f3117i);
        printWriter.print(" mResumed=");
        printWriter.print(this.f3118j);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3119k);
        if (getApplication() != null) {
            AbstractC0020A6.m2589b(this).mo2558a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f3115g.f497a.f642f.m2316T(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f3115g.m2427a();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String m2453d = this.f3124p.m2453d(i4);
            this.f3124p.m2449h(i4);
            if (m2453d == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment m2310Z = this.f3115g.f497a.f642f.m2310Z(m2453d);
            if (m2310Z == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + m2453d);
                return;
            }
            m2310Z.onActivityResult(i & Settings.DEFAULT_INITIAL_WINDOW_SIZE, i2, intent);
            return;
        }
        int i5 = C1854h3.f5137c;
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3115g.m2427a();
        this.f3115g.f497a.f642f.m2275r(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC0197I5<?> abstractC0197I5 = this.f3115g.f497a;
        abstractC0197I5.f642f.m2289k(abstractC0197I5, abstractC0197I5, null);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            AbstractC0197I5<?> abstractC0197I52 = this.f3115g.f497a;
            if (abstractC0197I52 instanceof InterfaceC2402z6) {
                abstractC0197I52.f642f.m2276q0(parcelable);
                if (bundle.containsKey("android:support:next_request_index")) {
                    this.f3123o = bundle.getInt("android:support:next_request_index");
                    int[] intArray = bundle.getIntArray("android:support:request_indicies");
                    String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                    if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                        this.f3124p = new C0127F1<>(intArray.length);
                        for (int i = 0; i < intArray.length; i++) {
                            this.f3124p.m2450g(intArray[i], stringArray[i]);
                        }
                    } else {
                        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                    }
                }
            } else {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
        if (this.f3124p == null) {
            this.f3124p = new C0127F1<>(10);
            this.f3123o = 0;
        }
        super.onCreate(bundle);
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_CREATE);
        this.f3115g.f497a.f642f.m2271t();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
            C0151G5 c0151g5 = this.f3115g;
            return onCreatePanelMenu | c0151g5.f497a.f642f.m2269u(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f3115g.f497a.f642f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3115g.f497a.f642f.m2267v();
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f3115g.f497a.f642f.m2265w();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.f3115g.f497a.f642f.m2273s(menuItem);
        }
        return this.f3115g.f497a.f642f.m2323M(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f3115g.f497a.f642f.m2263x(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f3115g.m2427a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f3115g.f497a.f642f.m2322N(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3118j = false;
        this.f3115g.f497a.f642f.m2318R(3);
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f3115g.f497a.f642f.m2320P(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_RESUME);
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f3115g.f497a.f642f;
        layoutInflater$Factory2C0236K5.f758v = false;
        layoutInflater$Factory2C0236K5.f759w = false;
        layoutInflater$Factory2C0236K5.m2318R(4);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return super.onPreparePanel(0, view, menu) | this.f3115g.f497a.f642f.m2319Q(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity, p000.C1854h3.InterfaceC1856b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f3115g.m2427a();
        int i2 = (i >> 16) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String m2453d = this.f3124p.m2453d(i3);
            this.f3124p.m2449h(i3);
            if (m2453d == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment m2310Z = this.f3115g.f497a.f642f.m2310Z(m2453d);
            if (m2310Z == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + m2453d);
                return;
            }
            m2310Z.onRequestPermissionsResult(i & Settings.DEFAULT_INITIAL_WINDOW_SIZE, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3118j = true;
        this.f3115g.m2427a();
        this.f3115g.f497a.f642f.m2313W();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        do {
        } while (m1444v(m1445u(), AbstractC1917j6.EnumC1919b.CREATED));
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_STOP);
        Parcelable m2274r0 = this.f3115g.f497a.f642f.m2274r0();
        if (m2274r0 != null) {
            bundle.putParcelable("android:support:fragments", m2274r0);
        }
        if (this.f3124p.m2448i() > 0) {
            bundle.putInt("android:support:next_request_index", this.f3123o);
            int[] iArr = new int[this.f3124p.m2448i()];
            String[] strArr = new String[this.f3124p.m2448i()];
            for (int i = 0; i < this.f3124p.m2448i(); i++) {
                iArr[i] = this.f3124p.m2451f(i);
                strArr[i] = this.f3124p.m2447j(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f3119k = false;
        if (!this.f3117i) {
            this.f3117i = true;
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f3115g.f497a.f642f;
            layoutInflater$Factory2C0236K5.f758v = false;
            layoutInflater$Factory2C0236K5.f759w = false;
            layoutInflater$Factory2C0236K5.m2318R(2);
        }
        this.f3115g.m2427a();
        this.f3115g.f497a.f642f.m2313W();
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_START);
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K52 = this.f3115g.f497a.f642f;
        layoutInflater$Factory2C0236K52.f758v = false;
        layoutInflater$Factory2C0236K52.f759w = false;
        layoutInflater$Factory2C0236K52.m2318R(3);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f3115g.m2427a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f3119k = true;
        do {
        } while (m1444v(m1445u(), AbstractC1917j6.EnumC1919b.CREATED));
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f3115g.f497a.f642f;
        layoutInflater$Factory2C0236K5.f759w = true;
        layoutInflater$Factory2C0236K5.m2318R(2);
        this.f3116h.m572d(AbstractC1917j6.EnumC1918a.ON_STOP);
    }

    /* renamed from: s */
    public final int m1447s(Fragment fragment) {
        if (this.f3124p.m2448i() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (true) {
            C0127F1<String> c0127f1 = this.f3124p;
            int i = this.f3123o;
            if (c0127f1.f433a) {
                c0127f1.m2454c();
            }
            if (C0015A1.m2597a(c0127f1.f434b, c0127f1.f436d, i) >= 0) {
                this.f3123o = (this.f3123o + 1) % 65534;
            } else {
                int i2 = this.f3123o;
                this.f3124p.m2450g(i2, fragment.mWho);
                this.f3123o = (this.f3123o + 1) % 65534;
                return i2;
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.f3122n && i != -1) {
            m1446t(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.f3121m && i != -1) {
            m1446t(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    /* renamed from: u */
    public AbstractC0216J5 m1445u() {
        return this.f3115g.f497a.f642f;
    }

    /* renamed from: w */
    public void m1443w() {
    }

    @Deprecated
    /* renamed from: x */
    public void mo1442x() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f3115g.f497a.f642f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.f3122n && i != -1) {
            m1446t(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.f3121m && i != -1) {
            m1446t(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
