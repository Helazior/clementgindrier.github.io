package p000;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: b5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0958b5 {

    /* renamed from: b */
    public static final C0958b5 f3681b;

    /* renamed from: a */
    public final C0969k f3682a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* renamed from: b5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0959a {

        /* renamed from: a */
        public static Field f3683a;

        /* renamed from: b */
        public static Field f3684b;

        /* renamed from: c */
        public static Field f3685c;

        /* renamed from: d */
        public static boolean f3686d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f3683a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f3684b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f3685c = declaredField3;
                declaredField3.setAccessible(true);
                f3686d = true;
            } catch (ReflectiveOperationException e) {
                StringBuilder m253r = outline.m253r("Failed to get visible insets from AttachInfo ");
                m253r.append(e.getMessage());
                Log.w("WindowInsetsCompat", m253r.toString(), e);
            }
        }
    }

    /* renamed from: b5$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0962d extends C0961c {
        public C0962d() {
        }

        public C0962d(C0958b5 c0958b5) {
            super(c0958b5);
        }
    }

    /* renamed from: b5$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0964f extends C0969k {

        /* renamed from: h */
        public static boolean f3695h = false;

        /* renamed from: i */
        public static Method f3696i;

        /* renamed from: j */
        public static Class<?> f3697j;

        /* renamed from: k */
        public static Field f3698k;

        /* renamed from: l */
        public static Field f3699l;

        /* renamed from: c */
        public final WindowInsets f3700c;

        /* renamed from: d */
        public C0170H3[] f3701d;

        /* renamed from: e */
        public C0170H3 f3702e;

        /* renamed from: f */
        public C0958b5 f3703f;

        /* renamed from: g */
        public C0170H3 f3704g;

        public C0964f(C0958b5 c0958b5, WindowInsets windowInsets) {
            super(c0958b5);
            this.f3702e = null;
            this.f3700c = windowInsets;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: d */
        public void mo1172d(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f3695h) {
                    try {
                        f3696i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                        Class<?> cls = Class.forName("android.view.View$AttachInfo");
                        f3697j = cls;
                        f3698k = cls.getDeclaredField("mVisibleInsets");
                        f3699l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                        f3698k.setAccessible(true);
                        f3699l.setAccessible(true);
                    } catch (ReflectiveOperationException e) {
                        StringBuilder m253r = outline.m253r("Failed to get visible insets. (Reflection error). ");
                        m253r.append(e.getMessage());
                        Log.e("WindowInsetsCompat", m253r.toString(), e);
                    }
                    f3695h = true;
                }
                Method method = f3696i;
                C0170H3 c0170h3 = null;
                if (method != null && f3697j != null && f3698k != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        } else {
                            Rect rect = (Rect) f3698k.get(f3699l.get(invoke));
                            if (rect != null) {
                                c0170h3 = C0170H3.m2412a(rect.left, rect.top, rect.right, rect.bottom);
                            }
                        }
                    } catch (ReflectiveOperationException e2) {
                        StringBuilder m253r2 = outline.m253r("Failed to get visible insets. (Reflection error). ");
                        m253r2.append(e2.getMessage());
                        Log.e("WindowInsetsCompat", m253r2.toString(), e2);
                    }
                }
                if (c0170h3 == null) {
                    c0170h3 = C0170H3.f561e;
                }
                this.f3704g = c0170h3;
                return;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // p000.C0958b5.C0969k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f3704g, ((C0964f) obj).f3704g);
            }
            return false;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: h */
        public final C0170H3 mo1168h() {
            if (this.f3702e == null) {
                this.f3702e = C0170H3.m2412a(this.f3700c.getSystemWindowInsetLeft(), this.f3700c.getSystemWindowInsetTop(), this.f3700c.getSystemWindowInsetRight(), this.f3700c.getSystemWindowInsetBottom());
            }
            return this.f3702e;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: i */
        public C0958b5 mo1167i(int i, int i2, int i3, int i4) {
            C0963e c0960b;
            C0958b5 m1180j = C0958b5.m1180j(this.f3700c);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                c0960b = new C0962d(m1180j);
            } else if (i5 >= 29) {
                c0960b = new C0961c(m1180j);
            } else {
                c0960b = new C0960b(m1180j);
            }
            c0960b.mo1176c(C0958b5.m1184f(mo1168h(), i, i2, i3, i4));
            c0960b.mo1177b(C0958b5.m1184f(mo1169g(), i, i2, i3, i4));
            return c0960b.mo1178a();
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: k */
        public boolean mo1165k() {
            return this.f3700c.isRound();
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: l */
        public void mo1164l(C0170H3[] c0170h3Arr) {
            this.f3701d = c0170h3Arr;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: m */
        public void mo1163m(C0958b5 c0958b5) {
            this.f3703f = c0958b5;
        }
    }

    /* renamed from: b5$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0965g extends C0964f {

        /* renamed from: m */
        public C0170H3 f3705m;

        public C0965g(C0958b5 c0958b5, WindowInsets windowInsets) {
            super(c0958b5, windowInsets);
            this.f3705m = null;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: b */
        public C0958b5 mo1174b() {
            return C0958b5.m1180j(this.f3700c.consumeStableInsets());
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: c */
        public C0958b5 mo1173c() {
            return C0958b5.m1180j(this.f3700c.consumeSystemWindowInsets());
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: g */
        public final C0170H3 mo1169g() {
            if (this.f3705m == null) {
                this.f3705m = C0170H3.m2412a(this.f3700c.getStableInsetLeft(), this.f3700c.getStableInsetTop(), this.f3700c.getStableInsetRight(), this.f3700c.getStableInsetBottom());
            }
            return this.f3705m;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: j */
        public boolean mo1166j() {
            return this.f3700c.isConsumed();
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: n */
        public void mo1162n(C0170H3 c0170h3) {
            this.f3705m = c0170h3;
        }
    }

    /* renamed from: b5$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0966h extends C0965g {
        public C0966h(C0958b5 c0958b5, WindowInsets windowInsets) {
            super(c0958b5, windowInsets);
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: a */
        public C0958b5 mo1175a() {
            return C0958b5.m1180j(this.f3700c.consumeDisplayCutout());
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: e */
        public C0171H4 mo1171e() {
            DisplayCutout displayCutout = this.f3700c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new C0171H4(displayCutout);
        }

        @Override // p000.C0958b5.C0964f, p000.C0958b5.C0969k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0966h) {
                C0966h c0966h = (C0966h) obj;
                return Objects.equals(this.f3700c, c0966h.f3700c) && Objects.equals(this.f3704g, c0966h.f3704g);
            }
            return false;
        }

        @Override // p000.C0958b5.C0969k
        public int hashCode() {
            return this.f3700c.hashCode();
        }
    }

    /* renamed from: b5$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0967i extends C0966h {

        /* renamed from: n */
        public C0170H3 f3706n;

        /* renamed from: o */
        public C0170H3 f3707o;

        /* renamed from: p */
        public C0170H3 f3708p;

        public C0967i(C0958b5 c0958b5, WindowInsets windowInsets) {
            super(c0958b5, windowInsets);
            this.f3706n = null;
            this.f3707o = null;
            this.f3708p = null;
        }

        @Override // p000.C0958b5.C0969k
        /* renamed from: f */
        public C0170H3 mo1170f() {
            if (this.f3707o == null) {
                this.f3707o = C0170H3.m2411b(this.f3700c.getMandatorySystemGestureInsets());
            }
            return this.f3707o;
        }

        @Override // p000.C0958b5.C0964f, p000.C0958b5.C0969k
        /* renamed from: i */
        public C0958b5 mo1167i(int i, int i2, int i3, int i4) {
            return C0958b5.m1180j(this.f3700c.inset(i, i2, i3, i4));
        }

        @Override // p000.C0958b5.C0965g, p000.C0958b5.C0969k
        /* renamed from: n */
        public void mo1162n(C0170H3 c0170h3) {
        }
    }

    /* renamed from: b5$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0968j extends C0967i {

        /* renamed from: q */
        public static final C0958b5 f3709q = C0958b5.m1180j(WindowInsets.CONSUMED);

        public C0968j(C0958b5 c0958b5, WindowInsets windowInsets) {
            super(c0958b5, windowInsets);
        }

        @Override // p000.C0958b5.C0964f, p000.C0958b5.C0969k
        /* renamed from: d */
        public final void mo1172d(View view) {
        }
    }

    /* renamed from: b5$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0969k {

        /* renamed from: b */
        public static final C0958b5 f3710b;

        /* renamed from: a */
        public final C0958b5 f3711a;

        static {
            C0963e c0960b;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                c0960b = new C0962d();
            } else if (i >= 29) {
                c0960b = new C0961c();
            } else {
                c0960b = new C0960b();
            }
            f3710b = c0960b.mo1178a().f3682a.mo1175a().f3682a.mo1174b().m1189a();
        }

        public C0969k(C0958b5 c0958b5) {
            this.f3711a = c0958b5;
        }

        /* renamed from: a */
        public C0958b5 mo1175a() {
            return this.f3711a;
        }

        /* renamed from: b */
        public C0958b5 mo1174b() {
            return this.f3711a;
        }

        /* renamed from: c */
        public C0958b5 mo1173c() {
            return this.f3711a;
        }

        /* renamed from: d */
        public void mo1172d(View view) {
        }

        /* renamed from: e */
        public C0171H4 mo1171e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0969k) {
                C0969k c0969k = (C0969k) obj;
                return mo1165k() == c0969k.mo1165k() && mo1166j() == c0969k.mo1166j() && Objects.equals(mo1168h(), c0969k.mo1168h()) && Objects.equals(mo1169g(), c0969k.mo1169g()) && Objects.equals(mo1171e(), c0969k.mo1171e());
            }
            return false;
        }

        /* renamed from: f */
        public C0170H3 mo1170f() {
            return mo1168h();
        }

        /* renamed from: g */
        public C0170H3 mo1169g() {
            return C0170H3.f561e;
        }

        /* renamed from: h */
        public C0170H3 mo1168h() {
            return C0170H3.f561e;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(mo1165k()), Boolean.valueOf(mo1166j()), mo1168h(), mo1169g(), mo1171e());
        }

        /* renamed from: i */
        public C0958b5 mo1167i(int i, int i2, int i3, int i4) {
            return f3710b;
        }

        /* renamed from: j */
        public boolean mo1166j() {
            return false;
        }

        /* renamed from: k */
        public boolean mo1165k() {
            return false;
        }

        /* renamed from: l */
        public void mo1164l(C0170H3[] c0170h3Arr) {
        }

        /* renamed from: m */
        public void mo1163m(C0958b5 c0958b5) {
        }

        /* renamed from: n */
        public void mo1162n(C0170H3 c0170h3) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f3681b = C0968j.f3709q;
        } else {
            f3681b = C0969k.f3710b;
        }
    }

    public C0958b5(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f3682a = new C0968j(this, windowInsets);
        } else if (i >= 29) {
            this.f3682a = new C0967i(this, windowInsets);
        } else if (i >= 28) {
            this.f3682a = new C0966h(this, windowInsets);
        } else {
            this.f3682a = new C0965g(this, windowInsets);
        }
    }

    /* renamed from: f */
    public static C0170H3 m1184f(C0170H3 c0170h3, int i, int i2, int i3, int i4) {
        int max = Math.max(0, c0170h3.f562a - i);
        int max2 = Math.max(0, c0170h3.f563b - i2);
        int max3 = Math.max(0, c0170h3.f564c - i3);
        int max4 = Math.max(0, c0170h3.f565d - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? c0170h3 : C0170H3.m2412a(max, max2, max3, max4);
    }

    /* renamed from: j */
    public static C0958b5 m1180j(WindowInsets windowInsets) {
        return m1179k(windowInsets, null);
    }

    /* renamed from: k */
    public static C0958b5 m1179k(WindowInsets windowInsets, View view) {
        Objects.requireNonNull(windowInsets);
        C0958b5 c0958b5 = new C0958b5(windowInsets);
        if (view != null) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0498f.m1909b(view)) {
                c0958b5.f3682a.mo1163m(C0492V4.m1959l(view));
                c0958b5.f3682a.mo1172d(view.getRootView());
            }
        }
        return c0958b5;
    }

    @Deprecated
    /* renamed from: a */
    public C0958b5 m1189a() {
        return this.f3682a.mo1173c();
    }

    @Deprecated
    /* renamed from: b */
    public int m1188b() {
        return this.f3682a.mo1168h().f565d;
    }

    @Deprecated
    /* renamed from: c */
    public int m1187c() {
        return this.f3682a.mo1168h().f562a;
    }

    @Deprecated
    /* renamed from: d */
    public int m1186d() {
        return this.f3682a.mo1168h().f564c;
    }

    @Deprecated
    /* renamed from: e */
    public int m1185e() {
        return this.f3682a.mo1168h().f563b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0958b5) {
            return Objects.equals(this.f3682a, ((C0958b5) obj).f3682a);
        }
        return false;
    }

    /* renamed from: g */
    public boolean m1183g() {
        return this.f3682a.mo1166j();
    }

    @Deprecated
    /* renamed from: h */
    public C0958b5 m1182h(int i, int i2, int i3, int i4) {
        C0963e c0960b;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            c0960b = new C0962d(this);
        } else if (i5 >= 29) {
            c0960b = new C0961c(this);
        } else {
            c0960b = new C0960b(this);
        }
        c0960b.mo1176c(C0170H3.m2412a(i, i2, i3, i4));
        return c0960b.mo1178a();
    }

    public int hashCode() {
        C0969k c0969k = this.f3682a;
        if (c0969k == null) {
            return 0;
        }
        return c0969k.hashCode();
    }

    /* renamed from: i */
    public WindowInsets m1181i() {
        C0969k c0969k = this.f3682a;
        if (c0969k instanceof C0964f) {
            return ((C0964f) c0969k).f3700c;
        }
        return null;
    }

    /* renamed from: b5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0961c extends C0963e {

        /* renamed from: b */
        public final WindowInsets.Builder f3693b;

        public C0961c() {
            this.f3693b = new WindowInsets.Builder();
        }

        @Override // p000.C0958b5.C0963e
        /* renamed from: a */
        public C0958b5 mo1178a() {
            C0958b5 m1180j = C0958b5.m1180j(this.f3693b.build());
            m1180j.f3682a.mo1164l(null);
            return m1180j;
        }

        @Override // p000.C0958b5.C0963e
        /* renamed from: b */
        public void mo1177b(C0170H3 c0170h3) {
            this.f3693b.setStableInsets(c0170h3.m2410c());
        }

        @Override // p000.C0958b5.C0963e
        /* renamed from: c */
        public void mo1176c(C0170H3 c0170h3) {
            this.f3693b.setSystemWindowInsets(c0170h3.m2410c());
        }

        public C0961c(C0958b5 c0958b5) {
            super(c0958b5);
            WindowInsets.Builder builder;
            WindowInsets m1181i = c0958b5.m1181i();
            if (m1181i != null) {
                builder = new WindowInsets.Builder(m1181i);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f3693b = builder;
        }
    }

    /* renamed from: b5$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0963e {

        /* renamed from: a */
        public final C0958b5 f3694a;

        public C0963e() {
            this.f3694a = new C0958b5((C0958b5) null);
        }

        /* renamed from: a */
        public C0958b5 mo1178a() {
            throw null;
        }

        /* renamed from: b */
        public void mo1177b(C0170H3 c0170h3) {
            throw null;
        }

        /* renamed from: c */
        public void mo1176c(C0170H3 c0170h3) {
            throw null;
        }

        public C0963e(C0958b5 c0958b5) {
            this.f3694a = c0958b5;
        }
    }

    public C0958b5(C0958b5 c0958b5) {
        this.f3682a = new C0969k(this);
    }

    /* renamed from: b5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0960b extends C0963e {

        /* renamed from: d */
        public static Field f3687d = null;

        /* renamed from: e */
        public static boolean f3688e = false;

        /* renamed from: f */
        public static Constructor<WindowInsets> f3689f = null;

        /* renamed from: g */
        public static boolean f3690g = false;

        /* renamed from: b */
        public WindowInsets f3691b;

        /* renamed from: c */
        public C0170H3 f3692c;

        public C0960b() {
            WindowInsets windowInsets;
            if (!f3688e) {
                try {
                    f3687d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                f3688e = true;
            }
            Field field = f3687d;
            WindowInsets windowInsets2 = null;
            if (field != null) {
                try {
                    windowInsets = (WindowInsets) field.get(null);
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
                if (windowInsets != null) {
                    windowInsets2 = new WindowInsets(windowInsets);
                    this.f3691b = windowInsets2;
                }
            }
            if (!f3690g) {
                try {
                    f3689f = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                f3690g = true;
            }
            Constructor<WindowInsets> constructor = f3689f;
            if (constructor != null) {
                try {
                    windowInsets2 = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            this.f3691b = windowInsets2;
        }

        @Override // p000.C0958b5.C0963e
        /* renamed from: a */
        public C0958b5 mo1178a() {
            C0958b5 m1180j = C0958b5.m1180j(this.f3691b);
            m1180j.f3682a.mo1164l(null);
            m1180j.f3682a.mo1162n(this.f3692c);
            return m1180j;
        }

        @Override // p000.C0958b5.C0963e
        /* renamed from: b */
        public void mo1177b(C0170H3 c0170h3) {
            this.f3692c = c0170h3;
        }

        @Override // p000.C0958b5.C0963e
        /* renamed from: c */
        public void mo1176c(C0170H3 c0170h3) {
            WindowInsets windowInsets = this.f3691b;
            if (windowInsets != null) {
                this.f3691b = windowInsets.replaceSystemWindowInsets(c0170h3.f562a, c0170h3.f563b, c0170h3.f564c, c0170h3.f565d);
            }
        }

        public C0960b(C0958b5 c0958b5) {
            super(c0958b5);
            this.f3691b = c0958b5.m1181i();
        }
    }
}
