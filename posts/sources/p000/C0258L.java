package p000;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC0485V;
import p000.C0492V4;
import p000.C1905j0;

/* renamed from: L */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0258L extends ActionBar implements ActionBarOverlayLayout.InterfaceC0641d {

    /* renamed from: a */
    public Context f845a;

    /* renamed from: b */
    public Context f846b;

    /* renamed from: c */
    public ActionBarOverlayLayout f847c;

    /* renamed from: d */
    public ActionBarContainer f848d;

    /* renamed from: e */
    public InterfaceC0231K0 f849e;

    /* renamed from: f */
    public ActionBarContextView f850f;

    /* renamed from: g */
    public View f851g;

    /* renamed from: h */
    public boolean f852h;

    /* renamed from: i */
    public C0262d f853i;

    /* renamed from: j */
    public AbstractC0485V f854j;

    /* renamed from: k */
    public AbstractC0485V.InterfaceC0486a f855k;

    /* renamed from: l */
    public boolean f856l;

    /* renamed from: m */
    public ArrayList<ActionBar.InterfaceC0629a> f857m;

    /* renamed from: n */
    public boolean f858n;

    /* renamed from: o */
    public int f859o;

    /* renamed from: p */
    public boolean f860p;

    /* renamed from: q */
    public boolean f861q;

    /* renamed from: r */
    public boolean f862r;

    /* renamed from: s */
    public boolean f863s;

    /* renamed from: t */
    public C0952b0 f864t;

    /* renamed from: u */
    public boolean f865u;

    /* renamed from: v */
    public boolean f866v;

    /* renamed from: w */
    public final InterfaceC0571Y4 f867w;

    /* renamed from: x */
    public final InterfaceC0571Y4 f868x;

    /* renamed from: y */
    public final InterfaceC0609a5 f869y;

    /* renamed from: z */
    public static final Interpolator f844z = new AccelerateInterpolator();

    /* renamed from: A */
    public static final Interpolator f843A = new DecelerateInterpolator();

    /* renamed from: L$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0259a extends C0588Z4 {
        public C0259a() {
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: b */
        public void mo223b(View view) {
            View view2;
            C0258L c0258l = C0258L.this;
            if (c0258l.f860p && (view2 = c0258l.f851g) != null) {
                view2.setTranslationY(0.0f);
                C0258L.this.f848d.setTranslationY(0.0f);
            }
            C0258L.this.f848d.setVisibility(8);
            C0258L.this.f848d.setTransitioning(false);
            C0258L c0258l2 = C0258L.this;
            c0258l2.f864t = null;
            AbstractC0485V.InterfaceC0486a interfaceC0486a = c0258l2.f855k;
            if (interfaceC0486a != null) {
                interfaceC0486a.mo1759b(c0258l2.f854j);
                c0258l2.f854j = null;
                c0258l2.f855k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = C0258L.this.f847c;
            if (actionBarOverlayLayout != null) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0499g.m1901c(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: L$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0260b extends C0588Z4 {
        public C0260b() {
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: b */
        public void mo223b(View view) {
            C0258L c0258l = C0258L.this;
            c0258l.f864t = null;
            c0258l.f848d.requestLayout();
        }
    }

    /* renamed from: L$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0261c implements InterfaceC0609a5 {
        public C0261c() {
        }
    }

    /* renamed from: L$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0262d extends AbstractC0485V implements C1905j0.InterfaceC1906a {

        /* renamed from: c */
        public final Context f873c;

        /* renamed from: d */
        public final C1905j0 f874d;

        /* renamed from: f */
        public AbstractC0485V.InterfaceC0486a f875f;

        /* renamed from: g */
        public WeakReference<View> f876g;

        public C0262d(Context context, AbstractC0485V.InterfaceC0486a interfaceC0486a) {
            this.f873c = context;
            this.f875f = interfaceC0486a;
            C1905j0 defaultShowAsAction = new C1905j0(context).setDefaultShowAsAction(1);
            this.f874d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // p000.AbstractC0485V
        /* renamed from: a */
        public void mo1792a() {
            C0258L c0258l = C0258L.this;
            if (c0258l.f853i != this) {
                return;
            }
            if (!(!c0258l.f861q)) {
                c0258l.f854j = this;
                c0258l.f855k = this.f875f;
            } else {
                this.f875f.mo1759b(this);
            }
            this.f875f = null;
            C0258L.this.m2233v(false);
            ActionBarContextView actionBarContextView = C0258L.this.f850f;
            if (actionBarContextView.f2346l == null) {
                actionBarContextView.m1670h();
            }
            C0258L.this.f849e.mo1053i().sendAccessibilityEvent(32);
            C0258L c0258l2 = C0258L.this;
            c0258l2.f847c.setHideOnContentScrollEnabled(c0258l2.f866v);
            C0258L.this.f853i = null;
        }

        @Override // p000.AbstractC0485V
        /* renamed from: b */
        public View mo1791b() {
            WeakReference<View> weakReference = this.f876g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // p000.AbstractC0485V
        /* renamed from: c */
        public Menu mo1790c() {
            return this.f874d;
        }

        @Override // p000.AbstractC0485V
        /* renamed from: d */
        public MenuInflater mo1789d() {
            return new C0602a0(this.f873c);
        }

        @Override // p000.AbstractC0485V
        /* renamed from: e */
        public CharSequence mo1788e() {
            return C0258L.this.f850f.f2345k;
        }

        @Override // p000.AbstractC0485V
        /* renamed from: f */
        public CharSequence mo1787f() {
            return C0258L.this.f850f.f2344j;
        }

        @Override // p000.AbstractC0485V
        /* renamed from: g */
        public void mo1786g() {
            if (C0258L.this.f853i != this) {
                return;
            }
            this.f874d.stopDispatchingItemsChanged();
            try {
                this.f875f.mo1760a(this, this.f874d);
            } finally {
                this.f874d.startDispatchingItemsChanged();
            }
        }

        @Override // p000.AbstractC0485V
        /* renamed from: h */
        public boolean mo1785h() {
            return C0258L.this.f850f.f2353s;
        }

        @Override // p000.AbstractC0485V
        /* renamed from: i */
        public void mo1784i(View view) {
            C0258L.this.f850f.setCustomView(view);
            this.f876g = new WeakReference<>(view);
        }

        @Override // p000.AbstractC0485V
        /* renamed from: j */
        public void mo1783j(int i) {
            C0258L.this.f850f.setSubtitle(C0258L.this.f845a.getResources().getString(i));
        }

        @Override // p000.AbstractC0485V
        /* renamed from: k */
        public void mo1782k(CharSequence charSequence) {
            C0258L.this.f850f.setSubtitle(charSequence);
        }

        @Override // p000.AbstractC0485V
        /* renamed from: l */
        public void mo1781l(int i) {
            C0258L.this.f850f.setTitle(C0258L.this.f845a.getResources().getString(i));
        }

        @Override // p000.AbstractC0485V
        /* renamed from: m */
        public void mo1780m(CharSequence charSequence) {
            C0258L.this.f850f.setTitle(charSequence);
        }

        @Override // p000.AbstractC0485V
        /* renamed from: n */
        public void mo1779n(boolean z) {
            this.f1771b = z;
            C0258L.this.f850f.setTitleOptional(z);
        }

        @Override // p000.C1905j0.InterfaceC1906a
        public boolean onMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
            AbstractC0485V.InterfaceC0486a interfaceC0486a = this.f875f;
            if (interfaceC0486a != null) {
                return interfaceC0486a.mo1758c(this, menuItem);
            }
            return false;
        }

        @Override // p000.C1905j0.InterfaceC1906a
        public void onMenuModeChange(C1905j0 c1905j0) {
            if (this.f875f == null) {
                return;
            }
            mo1786g();
            ActionMenuPresenter actionMenuPresenter = C0258L.this.f850f.f6726d;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.m1653f();
            }
        }
    }

    public C0258L(Activity activity, boolean z) {
        new ArrayList();
        this.f857m = new ArrayList<>();
        this.f859o = 0;
        this.f860p = true;
        this.f863s = true;
        this.f867w = new C0259a();
        this.f868x = new C0260b();
        this.f869y = new C0261c();
        View decorView = activity.getWindow().getDecorView();
        m2232w(decorView);
        if (z) {
            return;
        }
        this.f851g = decorView.findViewById(16908290);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: b */
    public boolean mo1719b() {
        InterfaceC0231K0 interfaceC0231K0 = this.f849e;
        if (interfaceC0231K0 == null || !interfaceC0231K0.mo1050l()) {
            return false;
        }
        this.f849e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: c */
    public void mo1718c(boolean z) {
        if (z == this.f856l) {
            return;
        }
        this.f856l = z;
        int size = this.f857m.size();
        for (int i = 0; i < size; i++) {
            this.f857m.get(i).m1699a(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: d */
    public int mo1717d() {
        return this.f849e.mo1048n();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: e */
    public Context mo1716e() {
        if (this.f846b == null) {
            TypedValue typedValue = new TypedValue();
            this.f845a.getTheme().resolveAttribute(C1671f.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f846b = new ContextThemeWrapper(this.f845a, i);
            } else {
                this.f846b = this.f845a;
            }
        }
        return this.f846b;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: g */
    public void mo1714g(Configuration configuration) {
        m2230y(this.f845a.getResources().getBoolean(C1825g.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: i */
    public boolean mo1712i(int i, KeyEvent keyEvent) {
        C1905j0 c1905j0;
        C0262d c0262d = this.f853i;
        if (c0262d == null || (c1905j0 = c0262d.f874d) == null) {
            return false;
        }
        c1905j0.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c1905j0.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: l */
    public void mo1709l(boolean z) {
        if (this.f852h) {
            return;
        }
        m2231x(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: m */
    public void mo1708m(boolean z) {
        m2231x(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: n */
    public void mo1707n(boolean z) {
        m2231x(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: o */
    public void mo1706o(boolean z) {
        m2231x(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: p */
    public void mo1705p(int i) {
        this.f849e.mo1040v(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: q */
    public void mo1704q(boolean z) {
        this.f849e.mo1052j(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: r */
    public void mo1703r(boolean z) {
        C0952b0 c0952b0;
        this.f865u = z;
        if (z || (c0952b0 = this.f864t) == null) {
            return;
        }
        c0952b0.m1215a();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: s */
    public void mo1702s(int i) {
        this.f849e.setTitle(this.f845a.getString(i));
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: t */
    public void mo1701t(CharSequence charSequence) {
        this.f849e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: u */
    public AbstractC0485V mo1700u(AbstractC0485V.InterfaceC0486a interfaceC0486a) {
        C0262d c0262d = this.f853i;
        if (c0262d != null) {
            c0262d.mo1792a();
        }
        this.f847c.setHideOnContentScrollEnabled(false);
        this.f850f.m1670h();
        C0262d c0262d2 = new C0262d(this.f850f.getContext(), interfaceC0486a);
        c0262d2.f874d.stopDispatchingItemsChanged();
        try {
            if (c0262d2.f875f.mo1757d(c0262d2, c0262d2.f874d)) {
                this.f853i = c0262d2;
                c0262d2.mo1786g();
                this.f850f.m1672f(c0262d2);
                m2233v(true);
                this.f850f.sendAccessibilityEvent(32);
                return c0262d2;
            }
            return null;
        } finally {
            c0262d2.f874d.startDispatchingItemsChanged();
        }
    }

    /* renamed from: v */
    public void m2233v(boolean z) {
        C0554X4 mo1044r;
        C0554X4 m225e;
        if (z) {
            if (!this.f862r) {
                this.f862r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f847c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                m2229z(false);
            }
        } else if (this.f862r) {
            this.f862r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f847c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            m2229z(false);
        }
        ActionBarContainer actionBarContainer = this.f848d;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (!C0492V4.C0498f.m1908c(actionBarContainer)) {
            if (z) {
                this.f849e.setVisibility(4);
                this.f850f.setVisibility(0);
                return;
            }
            this.f849e.setVisibility(0);
            this.f850f.setVisibility(8);
            return;
        }
        if (z) {
            m225e = this.f849e.mo1044r(4, 100L);
            mo1044r = this.f850f.m225e(0, 200L);
        } else {
            mo1044r = this.f849e.mo1044r(0, 200L);
            m225e = this.f850f.m225e(8, 100L);
        }
        C0952b0 c0952b0 = new C0952b0();
        c0952b0.f3650a.add(m225e);
        View view = m225e.f1987a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = mo1044r.f1987a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        c0952b0.f3650a.add(mo1044r);
        c0952b0.m1214b();
    }

    /* renamed from: w */
    public final void m2232w(View view) {
        InterfaceC0231K0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(C1930k.decor_content_parent);
        this.f847c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(C1930k.action_bar);
        if (findViewById instanceof InterfaceC0231K0) {
            wrapper = (InterfaceC0231K0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder m253r = outline.m253r("Can't make a decor toolbar out of ");
            m253r.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(m253r.toString());
        }
        this.f849e = wrapper;
        this.f850f = (ActionBarContextView) view.findViewById(C1930k.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(C1930k.action_bar_container);
        this.f848d = actionBarContainer;
        InterfaceC0231K0 interfaceC0231K0 = this.f849e;
        if (interfaceC0231K0 != null && this.f850f != null && actionBarContainer != null) {
            this.f845a = interfaceC0231K0.mo1051k();
            boolean z = (this.f849e.mo1048n() & 4) != 0;
            if (z) {
                this.f852h = true;
            }
            Context context = this.f845a;
            this.f849e.mo1052j((context.getApplicationInfo().targetSdkVersion < 14) || z);
            m2230y(context.getResources().getBoolean(C1825g.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.f845a.obtainStyledAttributes(null, C2012o.ActionBar, C1671f.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(C2012o.ActionBar_hideOnContentScroll, false)) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f847c;
                if (actionBarOverlayLayout2.f2370i) {
                    this.f866v = true;
                    actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C2012o.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                ActionBarContainer actionBarContainer2 = this.f848d;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0500h.m1882s(actionBarContainer2, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(C0258L.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    /* renamed from: x */
    public void m2231x(int i, int i2) {
        int mo1048n = this.f849e.mo1048n();
        if ((i2 & 4) != 0) {
            this.f852h = true;
        }
        this.f849e.mo1049m((i & i2) | ((~i2) & mo1048n));
    }

    /* renamed from: y */
    public final void m2230y(boolean z) {
        this.f858n = z;
        if (!z) {
            this.f849e.mo1054h(null);
            this.f848d.setTabContainer(null);
        } else {
            this.f848d.setTabContainer(null);
            this.f849e.mo1054h(null);
        }
        boolean z2 = true;
        boolean z3 = this.f849e.mo1045q() == 2;
        this.f849e.mo1041u(!this.f858n && z3);
        this.f847c.setHasNonEmbeddedTabs((this.f858n || !z3) ? false : false);
    }

    /* renamed from: z */
    public final void m2229z(boolean z) {
        View view;
        int[] iArr;
        View view2;
        View view3;
        int[] iArr2;
        if (this.f862r || !this.f861q) {
            if (this.f863s) {
                return;
            }
            this.f863s = true;
            C0952b0 c0952b0 = this.f864t;
            if (c0952b0 != null) {
                c0952b0.m1215a();
            }
            this.f848d.setVisibility(0);
            if (this.f859o == 0 && (this.f865u || z)) {
                this.f848d.setTranslationY(0.0f);
                float f = -this.f848d.getHeight();
                if (z) {
                    this.f848d.getLocationInWindow(new int[]{0, 0});
                    f -= iArr2[1];
                }
                this.f848d.setTranslationY(f);
                C0952b0 c0952b02 = new C0952b0();
                C0554X4 m1969b = C0492V4.m1969b(this.f848d);
                m1969b.m1803g(0.0f);
                m1969b.m1804f(this.f869y);
                if (!c0952b02.f3654e) {
                    c0952b02.f3650a.add(m1969b);
                }
                if (this.f860p && (view3 = this.f851g) != null) {
                    view3.setTranslationY(f);
                    C0554X4 m1969b2 = C0492V4.m1969b(this.f851g);
                    m1969b2.m1803g(0.0f);
                    if (!c0952b02.f3654e) {
                        c0952b02.f3650a.add(m1969b2);
                    }
                }
                Interpolator interpolator = f843A;
                boolean z2 = c0952b02.f3654e;
                if (!z2) {
                    c0952b02.f3652c = interpolator;
                }
                if (!z2) {
                    c0952b02.f3651b = 250L;
                }
                InterfaceC0571Y4 interfaceC0571Y4 = this.f868x;
                if (!z2) {
                    c0952b02.f3653d = interfaceC0571Y4;
                }
                this.f864t = c0952b02;
                c0952b02.m1214b();
            } else {
                this.f848d.setAlpha(1.0f);
                this.f848d.setTranslationY(0.0f);
                if (this.f860p && (view2 = this.f851g) != null) {
                    view2.setTranslationY(0.0f);
                }
                this.f868x.mo223b(null);
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.f847c;
            if (actionBarOverlayLayout != null) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0499g.m1901c(actionBarOverlayLayout);
            }
        } else if (this.f863s) {
            this.f863s = false;
            C0952b0 c0952b03 = this.f864t;
            if (c0952b03 != null) {
                c0952b03.m1215a();
            }
            if (this.f859o == 0 && (this.f865u || z)) {
                this.f848d.setAlpha(1.0f);
                this.f848d.setTransitioning(true);
                C0952b0 c0952b04 = new C0952b0();
                float f2 = -this.f848d.getHeight();
                if (z) {
                    this.f848d.getLocationInWindow(new int[]{0, 0});
                    f2 -= iArr[1];
                }
                C0554X4 m1969b3 = C0492V4.m1969b(this.f848d);
                m1969b3.m1803g(f2);
                m1969b3.m1804f(this.f869y);
                if (!c0952b04.f3654e) {
                    c0952b04.f3650a.add(m1969b3);
                }
                if (this.f860p && (view = this.f851g) != null) {
                    C0554X4 m1969b4 = C0492V4.m1969b(view);
                    m1969b4.m1803g(f2);
                    if (!c0952b04.f3654e) {
                        c0952b04.f3650a.add(m1969b4);
                    }
                }
                Interpolator interpolator2 = f844z;
                boolean z3 = c0952b04.f3654e;
                if (!z3) {
                    c0952b04.f3652c = interpolator2;
                }
                if (!z3) {
                    c0952b04.f3651b = 250L;
                }
                InterfaceC0571Y4 interfaceC0571Y42 = this.f867w;
                if (!z3) {
                    c0952b04.f3653d = interfaceC0571Y42;
                }
                this.f864t = c0952b04;
                c0952b04.m1214b();
                return;
            }
            this.f867w.mo223b(null);
        }
    }

    public C0258L(Dialog dialog) {
        new ArrayList();
        this.f857m = new ArrayList<>();
        this.f859o = 0;
        this.f860p = true;
        this.f863s = true;
        this.f867w = new C0259a();
        this.f868x = new C0260b();
        this.f869y = new C0261c();
        m2232w(dialog.getWindow().getDecorView());
    }
}
