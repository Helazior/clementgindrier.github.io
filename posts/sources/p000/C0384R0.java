package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;
import p000.C0032B0;
import p000.C2307w3;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: R0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0384R0 {

    /* renamed from: i */
    public static C0384R0 f1296i;

    /* renamed from: a */
    public WeakHashMap<Context, C0127F1<ColorStateList>> f1298a;

    /* renamed from: b */
    public C0101E1<String, InterfaceC0388d> f1299b;

    /* renamed from: c */
    public C0127F1<String> f1300c;

    /* renamed from: d */
    public final WeakHashMap<Context, C0034B1<WeakReference<Drawable.ConstantState>>> f1301d = new WeakHashMap<>(0);

    /* renamed from: e */
    public TypedValue f1302e;

    /* renamed from: f */
    public boolean f1303f;

    /* renamed from: g */
    public InterfaceC0389e f1304g;

    /* renamed from: h */
    public static final PorterDuff.Mode f1295h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j */
    public static final C0387c f1297j = new C0387c(6);

    /* renamed from: R0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0385a implements InterfaceC0388d {
        @Override // p000.C0384R0.InterfaceC0388d
        /* renamed from: a */
        public Drawable mo2056a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0298N.m2192g(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* renamed from: R0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0386b implements InterfaceC0388d {
        @Override // p000.C0384R0.InterfaceC0388d
        /* renamed from: a */
        public Drawable mo2056a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                C1623d8 c1623d8 = new C1623d8(context, null, null);
                c1623d8.inflate(resources, xmlPullParser, attributeSet, theme);
                return c1623d8;
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: R0$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0387c extends C0053C1<Integer, PorterDuffColorFilter> {
        public C0387c(int i) {
            super(i);
        }
    }

    /* renamed from: R0$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0388d {
        /* renamed from: a */
        Drawable mo2056a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* renamed from: R0$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0389e {
    }

    /* renamed from: R0$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0390f implements InterfaceC0388d {
        @Override // p000.C0384R0.InterfaceC0388d
        /* renamed from: a */
        public Drawable mo2056a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C1865h8.m766a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: d */
    public static synchronized C0384R0 m2065d() {
        C0384R0 c0384r0;
        synchronized (C0384R0.class) {
            if (f1296i == null) {
                C0384R0 c0384r02 = new C0384R0();
                f1296i = c0384r02;
                if (Build.VERSION.SDK_INT < 24) {
                    c0384r02.m2068a("vector", new C0390f());
                    c0384r02.m2068a("animated-vector", new C0386b());
                    c0384r02.m2068a("animated-selector", new C0385a());
                }
            }
            c0384r0 = f1296i;
        }
        return c0384r0;
    }

    /* renamed from: h */
    public static synchronized PorterDuffColorFilter m2061h(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (C0384R0.class) {
            C0387c c0387c = f1297j;
            Objects.requireNonNull(c0387c);
            int i2 = (i + 31) * 31;
            porterDuffColorFilter = c0387c.get(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                Objects.requireNonNull(c0387c);
                c0387c.put(Integer.valueOf(mode.hashCode() + i2), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    /* renamed from: a */
    public final void m2068a(String str, InterfaceC0388d interfaceC0388d) {
        if (this.f1299b == null) {
            this.f1299b = new C0101E1<>();
        }
        this.f1299b.put(str, interfaceC0388d);
    }

    /* renamed from: b */
    public final synchronized boolean m2067b(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            C0034B1<WeakReference<Drawable.ConstantState>> c0034b1 = this.f1301d.get(context);
            if (c0034b1 == null) {
                c0034b1 = new C0034B1<>();
                this.f1301d.put(context, c0034b1);
            }
            c0034b1.m2564g(j, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public final Drawable m2066c(Context context, int i) {
        if (this.f1302e == null) {
            this.f1302e = new TypedValue();
        }
        TypedValue typedValue = this.f1302e;
        context.getResources().getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable m2064e = m2064e(context, j);
        if (m2064e != null) {
            return m2064e;
        }
        InterfaceC0389e interfaceC0389e = this.f1304g;
        LayerDrawable layerDrawable = null;
        if (interfaceC0389e != null) {
            C0032B0.C0033a c0033a = (C0032B0.C0033a) interfaceC0389e;
            if (i == C1904j.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{m2063f(context, C1904j.abc_cab_background_internal_bg), m2063f(context, C1904j.abc_cab_background_top_mtrl_alpha)});
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            m2067b(context, j, layerDrawable);
        }
        return layerDrawable;
    }

    /* renamed from: e */
    public final synchronized Drawable m2064e(Context context, long j) {
        C0034B1<WeakReference<Drawable.ConstantState>> c0034b1 = this.f1301d.get(context);
        if (c0034b1 == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> m2565f = c0034b1.m2565f(j, null);
        if (m2565f != null) {
            Drawable.ConstantState constantState = m2565f.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int m2596b = C0015A1.m2596b(c0034b1.f171b, c0034b1.f173d, j);
            if (m2596b >= 0) {
                Object[] objArr = c0034b1.f172c;
                Object obj = objArr[m2596b];
                Object obj2 = C0034B1.f169f;
                if (obj != obj2) {
                    objArr[m2596b] = obj2;
                    c0034b1.f170a = true;
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    public synchronized Drawable m2063f(Context context, int i) {
        return m2062g(context, i, false);
    }

    /* renamed from: g */
    public synchronized Drawable m2062g(Context context, int i, boolean z) {
        Drawable m2059j;
        if (!this.f1303f) {
            boolean z2 = true;
            this.f1303f = true;
            Drawable m2063f = m2063f(context, C0408S.abc_vector_test);
            if (m2063f != null) {
                if (!(m2063f instanceof C1865h8) && !"android.graphics.drawable.VectorDrawable".equals(m2063f.getClass().getName())) {
                    z2 = false;
                }
            }
            this.f1303f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        m2059j = m2059j(context, i);
        if (m2059j == null) {
            m2059j = m2066c(context, i);
        }
        if (m2059j == null) {
            Object obj = C2307w3.f6741a;
            m2059j = C2307w3.C2310c.m202b(context, i);
        }
        if (m2059j != null) {
            m2059j = m2058k(context, i, z, m2059j);
        }
        if (m2059j != null) {
            int[] iArr = C0263L0.f878a;
        }
        return m2059j;
    }

    /* renamed from: i */
    public synchronized ColorStateList m2060i(Context context, int i) {
        ColorStateList m2452e;
        C0127F1<ColorStateList> c0127f1;
        WeakHashMap<Context, C0127F1<ColorStateList>> weakHashMap = this.f1298a;
        ColorStateList colorStateList = null;
        m2452e = (weakHashMap == null || (c0127f1 = weakHashMap.get(context)) == null) ? null : c0127f1.m2452e(i, null);
        if (m2452e == null) {
            InterfaceC0389e interfaceC0389e = this.f1304g;
            if (interfaceC0389e != null) {
                colorStateList = ((C0032B0.C0033a) interfaceC0389e).m2572c(context, i);
            }
            if (colorStateList != null) {
                if (this.f1298a == null) {
                    this.f1298a = new WeakHashMap<>();
                }
                C0127F1<ColorStateList> c0127f12 = this.f1298a.get(context);
                if (c0127f12 == null) {
                    c0127f12 = new C0127F1<>(10);
                    this.f1298a.put(context, c0127f12);
                }
                c0127f12.m2456a(i, colorStateList);
            }
            m2452e = colorStateList;
        }
        return m2452e;
    }

    /* renamed from: j */
    public final Drawable m2059j(Context context, int i) {
        int next;
        C0101E1<String, InterfaceC0388d> c0101e1 = this.f1299b;
        if (c0101e1 == null || c0101e1.isEmpty()) {
            return null;
        }
        C0127F1<String> c0127f1 = this.f1300c;
        if (c0127f1 != null) {
            String m2452e = c0127f1.m2452e(i, null);
            if ("appcompat_skip_skip".equals(m2452e) || (m2452e != null && this.f1299b.get(m2452e) == null)) {
                return null;
            }
        } else {
            this.f1300c = new C0127F1<>(10);
        }
        if (this.f1302e == null) {
            this.f1302e = new TypedValue();
        }
        TypedValue typedValue = this.f1302e;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable m2064e = m2064e(context, j);
        if (m2064e != null) {
            return m2064e;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f1300c.m2456a(i, name);
                    InterfaceC0388d interfaceC0388d = this.f1299b.get(name);
                    if (interfaceC0388d != null) {
                        m2064e = interfaceC0388d.mo2056a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (m2064e != null) {
                        m2064e.setChangingConfigurations(typedValue.changingConfigurations);
                        m2067b(context, j, m2064e);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (m2064e == null) {
            this.f1300c.m2456a(i, "appcompat_skip_skip");
        }
        return m2064e;
    }

    /* renamed from: k */
    public final Drawable m2058k(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList m2060i = m2060i(context, i);
        PorterDuff.Mode mode = null;
        if (m2060i != null) {
            if (C0263L0.m2228a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable m2604x0 = LayoutInflater$Factory2C0000A.C0010h.m2604x0(drawable);
            m2604x0.setTintList(m2060i);
            InterfaceC0389e interfaceC0389e = this.f1304g;
            if (interfaceC0389e != null) {
                C0032B0.C0033a c0033a = (C0032B0.C0033a) interfaceC0389e;
                if (i == C1904j.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode != null) {
                m2604x0.setTintMode(mode);
                return m2604x0;
            }
            return m2604x0;
        }
        InterfaceC0389e interfaceC0389e2 = this.f1304g;
        if (interfaceC0389e2 != null) {
            C0032B0.C0033a c0033a2 = (C0032B0.C0033a) interfaceC0389e2;
            Objects.requireNonNull(c0033a2);
            boolean z2 = true;
            if (i == C1904j.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i2 = C1671f.colorControlNormal;
                int m1823c = C0530W0.m1823c(context, i2);
                PorterDuff.Mode mode2 = C0032B0.f160b;
                c0033a2.m2571d(findDrawableByLayerId, m1823c, mode2);
                c0033a2.m2571d(layerDrawable.findDrawableByLayerId(16908303), C0530W0.m1823c(context, i2), mode2);
                c0033a2.m2571d(layerDrawable.findDrawableByLayerId(16908301), C0530W0.m1823c(context, C1671f.colorControlActivated), mode2);
            } else if (i == C1904j.abc_ratingbar_material || i == C1904j.abc_ratingbar_indicator_material || i == C1904j.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
                int m1824b = C0530W0.m1824b(context, C1671f.colorControlNormal);
                PorterDuff.Mode mode3 = C0032B0.f160b;
                c0033a2.m2571d(findDrawableByLayerId2, m1824b, mode3);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i3 = C1671f.colorControlActivated;
                c0033a2.m2571d(findDrawableByLayerId3, C0530W0.m1823c(context, i3), mode3);
                c0033a2.m2571d(layerDrawable2.findDrawableByLayerId(16908301), C0530W0.m1823c(context, i3), mode3);
            } else {
                z2 = false;
            }
            if (z2) {
                return drawable;
            }
        }
        if (m2057l(context, i, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2057l(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            R0$e r0 = r7.f1304g
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            B0$a r0 = (p000.C0032B0.C0033a) r0
            java.util.Objects.requireNonNull(r0)
            android.graphics.PorterDuff$Mode r3 = p000.C0032B0.f160b
            int[] r4 = r0.f163a
            boolean r4 = r0.m2574a(r4, r9)
            r5 = 16842801(0x1010031, float:2.3693695E-38)
            r6 = -1
            if (r4 == 0) goto L1c
            int r5 = p000.C1671f.colorControlNormal
            goto L45
        L1c:
            int[] r4 = r0.f165c
            boolean r4 = r0.m2574a(r4, r9)
            if (r4 == 0) goto L27
            int r5 = p000.C1671f.colorControlActivated
            goto L45
        L27:
            int[] r4 = r0.f166d
            boolean r0 = r0.m2574a(r4, r9)
            if (r0 == 0) goto L32
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L45
        L32:
            int r0 = p000.C1904j.abc_list_divider_mtrl_alpha
            if (r9 != r0) goto L41
            r9 = 16842800(0x1010030, float:2.3693693E-38)
            r0 = 1109603123(0x42233333, float:40.8)
            int r0 = java.lang.Math.round(r0)
            goto L47
        L41:
            int r0 = p000.C1904j.abc_dialog_material_background
            if (r9 != r0) goto L49
        L45:
            r9 = r5
            r0 = -1
        L47:
            r4 = 1
            goto L4c
        L49:
            r9 = 0
            r0 = -1
            r4 = 0
        L4c:
            if (r4 == 0) goto L6a
            boolean r4 = p000.C0263L0.m2228a(r10)
            if (r4 == 0) goto L58
            android.graphics.drawable.Drawable r10 = r10.mutate()
        L58:
            int r8 = p000.C0530W0.m1823c(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = p000.C0032B0.m2578c(r8, r3)
            r10.setColorFilter(r8)
            if (r0 == r6) goto L68
            r10.setAlpha(r0)
        L68:
            r8 = 1
            goto L6b
        L6a:
            r8 = 0
        L6b:
            if (r8 == 0) goto L6e
            goto L6f
        L6e:
            r1 = 0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0384R0.m2057l(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
