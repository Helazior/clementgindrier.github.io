package p000;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC2366y5;
import p000.C0492V4;
import p000.C2344x5;

/* renamed from: y5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2366y5<T extends AbstractC2366y5<T>> implements C2344x5.InterfaceC2346b {

    /* renamed from: l */
    public static final AbstractC2384r f6857l;

    /* renamed from: m */
    public static final AbstractC2384r f6858m;

    /* renamed from: n */
    public static final AbstractC2384r f6859n;

    /* renamed from: o */
    public static final AbstractC2384r f6860o;

    /* renamed from: p */
    public static final AbstractC2384r f6861p;

    /* renamed from: q */
    public static final AbstractC2384r f6862q;

    /* renamed from: d */
    public final Object f6866d;

    /* renamed from: e */
    public final AbstractC2400z5 f6867e;

    /* renamed from: i */
    public float f6871i;

    /* renamed from: a */
    public float f6863a = 0.0f;

    /* renamed from: b */
    public float f6864b = Float.MAX_VALUE;

    /* renamed from: c */
    public boolean f6865c = false;

    /* renamed from: f */
    public boolean f6868f = false;

    /* renamed from: g */
    public float f6869g = -3.4028235E38f;

    /* renamed from: h */
    public long f6870h = 0;

    /* renamed from: j */
    public final ArrayList<InterfaceC2382p> f6872j = new ArrayList<>();

    /* renamed from: k */
    public final ArrayList<InterfaceC2383q> f6873k = new ArrayList<>();

    /* renamed from: y5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2367a extends AbstractC2384r {
        public C2367a(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getY();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setY(f);
        }
    }

    /* renamed from: y5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2368b extends AbstractC2384r {
        public C2368b(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            return C0492V4.C0500h.m1888m(view);
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1877x(view, f);
        }
    }

    /* renamed from: y5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2369c extends AbstractC2384r {
        public C2369c(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getAlpha();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setAlpha(f);
        }
    }

    /* renamed from: y5$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2370d extends AbstractC2384r {
        public C2370d(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getScrollX();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    /* renamed from: y5$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2371e extends AbstractC2384r {
        public C2371e(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getScrollY();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    /* renamed from: y5$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2372f extends AbstractC2384r {
        public C2372f(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setTranslationX(f);
        }
    }

    /* renamed from: y5$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2373g extends AbstractC2384r {
        public C2373g(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setTranslationY(f);
        }
    }

    /* renamed from: y5$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2374h extends AbstractC2384r {
        public C2374h(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            return C0492V4.C0500h.m1889l(view);
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1878w(view, f);
        }
    }

    /* renamed from: y5$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2375i extends AbstractC2384r {
        public C2375i(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getScaleX();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setScaleX(f);
        }
    }

    /* renamed from: y5$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2376j extends AbstractC2384r {
        public C2376j(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getScaleY();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setScaleY(f);
        }
    }

    /* renamed from: y5$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2377k extends AbstractC2384r {
        public C2377k(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getRotation();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setRotation(f);
        }
    }

    /* renamed from: y5$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2378l extends AbstractC2384r {
        public C2378l(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getRotationX();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setRotationX(f);
        }
    }

    /* renamed from: y5$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2379m extends AbstractC2384r {
        public C2379m(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getRotationY();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setRotationY(f);
        }
    }

    /* renamed from: y5$n */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2380n extends AbstractC2384r {
        public C2380n(String str) {
            super(str, null);
        }

        @Override // p000.AbstractC2400z5
        public float getValue(View view) {
            return view.getX();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(View view, float f) {
            view.setX(f);
        }
    }

    /* renamed from: y5$o */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2381o {

        /* renamed from: a */
        public float f6874a;

        /* renamed from: b */
        public float f6875b;
    }

    /* renamed from: y5$p */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC2382p {
        /* renamed from: a */
        void m53a(AbstractC2366y5 abstractC2366y5, boolean z, float f, float f2);
    }

    /* renamed from: y5$q */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC2383q {
        /* renamed from: a */
        void m52a(AbstractC2366y5 abstractC2366y5, float f, float f2);
    }

    /* renamed from: y5$r */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC2384r extends AbstractC2400z5<View> {
        public AbstractC2384r(String str, C2372f c2372f) {
            super(str);
        }
    }

    static {
        new C2372f("translationX");
        new C2373g("translationY");
        new C2374h("translationZ");
        f6857l = new C2375i("scaleX");
        f6858m = new C2376j("scaleY");
        f6859n = new C2377k("rotation");
        f6860o = new C2378l("rotationX");
        f6861p = new C2379m("rotationY");
        new C2380n("x");
        new C2367a("y");
        new C2368b("z");
        f6862q = new C2369c("alpha");
        new C2370d("scrollX");
        new C2371e("scrollY");
    }

    public <K> AbstractC2366y5(K k, AbstractC2400z5<K> abstractC2400z5) {
        this.f6866d = k;
        this.f6867e = abstractC2400z5;
        if (abstractC2400z5 != f6859n && abstractC2400z5 != f6860o && abstractC2400z5 != f6861p) {
            if (abstractC2400z5 == f6862q) {
                this.f6871i = 0.00390625f;
                return;
            } else if (abstractC2400z5 != f6857l && abstractC2400z5 != f6858m) {
                this.f6871i = 1.0f;
                return;
            } else {
                this.f6871i = 0.00390625f;
                return;
            }
        }
        this.f6871i = 0.1f;
    }

    /* renamed from: d */
    public static <T> void m55d(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // p000.C2344x5.InterfaceC2346b
    /* renamed from: a */
    public boolean mo58a(long j) {
        long j2 = this.f6870h;
        if (j2 == 0) {
            this.f6870h = j;
            m54e(this.f6864b);
            return false;
        }
        long j3 = j - j2;
        this.f6870h = j;
        C0019A5 c0019a5 = (C0019A5) this;
        if (c0019a5.f129s != Float.MAX_VALUE) {
            C0038B5 c0038b5 = c0019a5.f128r;
            double d = c0038b5.f189i;
            long j4 = j3 / 2;
            C2381o m2559b = c0038b5.m2559b(c0019a5.f6864b, c0019a5.f6863a, j4);
            C0038B5 c0038b52 = c0019a5.f128r;
            c0038b52.f189i = c0019a5.f129s;
            c0019a5.f129s = Float.MAX_VALUE;
            C2381o m2559b2 = c0038b52.m2559b(m2559b.f6874a, m2559b.f6875b, j4);
            c0019a5.f6864b = m2559b2.f6874a;
            c0019a5.f6863a = m2559b2.f6875b;
        } else {
            C2381o m2559b3 = c0019a5.f128r.m2559b(c0019a5.f6864b, c0019a5.f6863a, j3);
            c0019a5.f6864b = m2559b3.f6874a;
            c0019a5.f6863a = m2559b3.f6875b;
        }
        float max = Math.max(c0019a5.f6864b, c0019a5.f6869g);
        c0019a5.f6864b = max;
        float min = Math.min(max, Float.MAX_VALUE);
        c0019a5.f6864b = min;
        float f = c0019a5.f6863a;
        C0038B5 c0038b53 = c0019a5.f128r;
        Objects.requireNonNull(c0038b53);
        boolean z = true;
        if (((double) Math.abs(f)) < c0038b53.f185e && ((double) Math.abs(min - ((float) c0038b53.f189i))) < c0038b53.f184d) {
            c0019a5.f6864b = (float) c0019a5.f128r.f189i;
            c0019a5.f6863a = 0.0f;
        } else {
            z = false;
        }
        float min2 = Math.min(this.f6864b, Float.MAX_VALUE);
        this.f6864b = min2;
        float max2 = Math.max(min2, this.f6869g);
        this.f6864b = max2;
        m54e(max2);
        if (z) {
            m56c(false);
        }
        return z;
    }

    /* renamed from: b */
    public void m57b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f6868f) {
                m56c(true);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    /* renamed from: c */
    public final void m56c(boolean z) {
        this.f6868f = false;
        C2344x5 m133a = C2344x5.m133a();
        m133a.f6804a.remove(this);
        int indexOf = m133a.f6805b.indexOf(this);
        if (indexOf >= 0) {
            m133a.f6805b.set(indexOf, null);
            m133a.f6809f = true;
        }
        this.f6870h = 0L;
        this.f6865c = false;
        for (int i = 0; i < this.f6872j.size(); i++) {
            if (this.f6872j.get(i) != null) {
                this.f6872j.get(i).m53a(this, z, this.f6864b, this.f6863a);
            }
        }
        m55d(this.f6872j);
    }

    /* renamed from: e */
    public void m54e(float f) {
        this.f6867e.setValue(this.f6866d, f);
        for (int i = 0; i < this.f6873k.size(); i++) {
            if (this.f6873k.get(i) != null) {
                this.f6873k.get(i).m52a(this, this.f6864b, this.f6863a);
            }
        }
        m55d(this.f6873k);
    }
}
