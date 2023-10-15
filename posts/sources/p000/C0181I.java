package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C1905j0;
import p000.InterfaceC2165p0;

/* renamed from: I */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0181I extends ActionBar {

    /* renamed from: a */
    public InterfaceC0231K0 f596a;

    /* renamed from: b */
    public boolean f597b;

    /* renamed from: c */
    public Window.Callback f598c;

    /* renamed from: d */
    public boolean f599d;

    /* renamed from: e */
    public boolean f600e;

    /* renamed from: f */
    public ArrayList<ActionBar.InterfaceC0629a> f601f = new ArrayList<>();

    /* renamed from: g */
    public final Runnable f602g = new RunnableC0182a();

    /* renamed from: h */
    public final Toolbar.InterfaceC0702e f603h;

    /* renamed from: I$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0182a implements Runnable {
        public RunnableC0182a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0181I c0181i = C0181I.this;
            Menu m2408v = c0181i.m2408v();
            C1905j0 c1905j0 = m2408v instanceof C1905j0 ? (C1905j0) m2408v : null;
            if (c1905j0 != null) {
                c1905j0.stopDispatchingItemsChanged();
            }
            try {
                m2408v.clear();
                if (!c0181i.f598c.onCreatePanelMenu(0, m2408v) || !c0181i.f598c.onPreparePanel(0, null, m2408v)) {
                    m2408v.clear();
                }
            } finally {
                if (c1905j0 != null) {
                    c1905j0.startDispatchingItemsChanged();
                }
            }
        }
    }

    /* renamed from: I$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0183b implements Toolbar.InterfaceC0702e {
        public C0183b() {
        }
    }

    /* renamed from: I$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0184c implements InterfaceC2165p0.InterfaceC2166a {

        /* renamed from: a */
        public boolean f606a;

        public C0184c() {
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        /* renamed from: a */
        public boolean mo458a(C1905j0 c1905j0) {
            Window.Callback callback = C0181I.this.f598c;
            if (callback != null) {
                callback.onMenuOpened(108, c1905j0);
                return true;
            }
            return false;
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        public void onCloseMenu(C1905j0 c1905j0, boolean z) {
            if (this.f606a) {
                return;
            }
            this.f606a = true;
            C0181I.this.f596a.mo1056f();
            Window.Callback callback = C0181I.this.f598c;
            if (callback != null) {
                callback.onPanelClosed(108, c1905j0);
            }
            this.f606a = false;
        }
    }

    /* renamed from: I$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0185d implements C1905j0.InterfaceC1906a {
        public C0185d() {
        }

        @Override // p000.C1905j0.InterfaceC1906a
        public boolean onMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
            return false;
        }

        @Override // p000.C1905j0.InterfaceC1906a
        public void onMenuModeChange(C1905j0 c1905j0) {
            C0181I c0181i = C0181I.this;
            if (c0181i.f598c != null) {
                if (c0181i.f596a.mo1061a()) {
                    C0181I.this.f598c.onPanelClosed(108, c1905j0);
                } else if (C0181I.this.f598c.onPreparePanel(0, null, c1905j0)) {
                    C0181I.this.f598c.onMenuOpened(108, c1905j0);
                }
            }
        }
    }

    /* renamed from: I$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0186e extends Window$CallbackC0980c0 {
        public C0186e(Window.Callback callback) {
            super(callback);
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(C0181I.this.f596a.mo1051k());
            }
            return this.f3746a.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = this.f3746a.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                C0181I c0181i = C0181I.this;
                if (!c0181i.f597b) {
                    c0181i.f596a.setMenuPrepared();
                    C0181I.this.f597b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public C0181I(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        C0183b c0183b = new C0183b();
        this.f603h = c0183b;
        this.f596a = new C1597d1(toolbar, false);
        C0186e c0186e = new C0186e(callback);
        this.f598c = c0186e;
        this.f596a.setWindowCallback(c0186e);
        toolbar.setOnMenuItemClickListener(c0183b);
        this.f596a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: a */
    public boolean mo1720a() {
        return this.f596a.mo1059c();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: b */
    public boolean mo1719b() {
        if (this.f596a.mo1050l()) {
            this.f596a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: c */
    public void mo1718c(boolean z) {
        if (z == this.f600e) {
            return;
        }
        this.f600e = z;
        int size = this.f601f.size();
        for (int i = 0; i < size; i++) {
            this.f601f.get(i).m1699a(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: d */
    public int mo1717d() {
        return this.f596a.mo1048n();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: e */
    public Context mo1716e() {
        return this.f596a.mo1051k();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: f */
    public boolean mo1715f() {
        this.f596a.mo1053i().removeCallbacks(this.f602g);
        ViewGroup mo1053i = this.f596a.mo1053i();
        Runnable runnable = this.f602g;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1931m(mo1053i, runnable);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: g */
    public void mo1714g(Configuration configuration) {
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: h */
    public void mo1713h() {
        this.f596a.mo1053i().removeCallbacks(this.f602g);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: i */
    public boolean mo1712i(int i, KeyEvent keyEvent) {
        Menu m2408v = m2408v();
        if (m2408v != null) {
            m2408v.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return m2408v.performShortcut(i, keyEvent, 0);
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: j */
    public boolean mo1711j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.f596a.mo1058d();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: k */
    public boolean mo1710k() {
        return this.f596a.mo1058d();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: l */
    public void mo1709l(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: m */
    public void mo1708m(boolean z) {
        m2407w(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: n */
    public void mo1707n(boolean z) {
        m2407w(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: o */
    public void mo1706o(boolean z) {
        m2407w(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: p */
    public void mo1705p(int i) {
        this.f596a.mo1040v(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: q */
    public void mo1704q(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: r */
    public void mo1703r(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: s */
    public void mo1702s(int i) {
        InterfaceC0231K0 interfaceC0231K0 = this.f596a;
        interfaceC0231K0.setTitle(i != 0 ? interfaceC0231K0.mo1051k().getText(i) : null);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: t */
    public void mo1701t(CharSequence charSequence) {
        this.f596a.setWindowTitle(charSequence);
    }

    /* renamed from: v */
    public final Menu m2408v() {
        if (!this.f599d) {
            this.f596a.mo1055g(new C0184c(), new C0185d());
            this.f599d = true;
        }
        return this.f596a.mo1047o();
    }

    /* renamed from: w */
    public void m2407w(int i, int i2) {
        this.f596a.mo1049m((i & i2) | ((~i2) & this.f596a.mo1048n()));
    }
}
