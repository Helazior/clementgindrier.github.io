package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: z0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2395z0 {

    /* renamed from: a */
    public final View f6897a;

    /* renamed from: d */
    public C0584Z0 f6900d;

    /* renamed from: e */
    public C0584Z0 f6901e;

    /* renamed from: f */
    public C0584Z0 f6902f;

    /* renamed from: c */
    public int f6899c = -1;

    /* renamed from: b */
    public final C0032B0 f6898b = C0032B0.m2580a();

    public C2395z0(View view) {
        this.f6897a = view;
    }

    /* renamed from: a */
    public void m21a() {
        Drawable background = this.f6897a.getBackground();
        if (background != null) {
            boolean z = true;
            if (this.f6900d != null) {
                if (this.f6902f == null) {
                    this.f6902f = new C0584Z0();
                }
                C0584Z0 c0584z0 = this.f6902f;
                c0584z0.f2067a = null;
                c0584z0.f2070d = false;
                c0584z0.f2068b = null;
                c0584z0.f2069c = false;
                View view = this.f6897a;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                ColorStateList m1894g = C0492V4.C0500h.m1894g(view);
                if (m1894g != null) {
                    c0584z0.f2070d = true;
                    c0584z0.f2067a = m1894g;
                }
                PorterDuff.Mode m1893h = C0492V4.C0500h.m1893h(this.f6897a);
                if (m1893h != null) {
                    c0584z0.f2069c = true;
                    c0584z0.f2068b = m1893h;
                }
                if (c0584z0.f2070d || c0584z0.f2069c) {
                    C0032B0.m2575f(background, c0584z0, this.f6897a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            C0584Z0 c0584z02 = this.f6901e;
            if (c0584z02 != null) {
                C0032B0.m2575f(background, c0584z02, this.f6897a.getDrawableState());
                return;
            }
            C0584Z0 c0584z03 = this.f6900d;
            if (c0584z03 != null) {
                C0032B0.m2575f(background, c0584z03, this.f6897a.getDrawableState());
            }
        }
    }

    /* renamed from: b */
    public ColorStateList m20b() {
        C0584Z0 c0584z0 = this.f6901e;
        if (c0584z0 != null) {
            return c0584z0.f2067a;
        }
        return null;
    }

    /* renamed from: c */
    public PorterDuff.Mode m19c() {
        C0584Z0 c0584z0 = this.f6901e;
        if (c0584z0 != null) {
            return c0584z0.f2068b;
        }
        return null;
    }

    /* renamed from: d */
    public void m18d(AttributeSet attributeSet, int i) {
        Context context = this.f6897a.getContext();
        int[] iArr = C2012o.ViewBackgroundHelper;
        C0954b1 m1196r = C0954b1.m1196r(context, attributeSet, iArr, i, 0);
        View view = this.f6897a;
        C0492V4.m1951t(view, view.getContext(), iArr, attributeSet, m1196r.f3660b, i, 0);
        try {
            int i2 = C2012o.ViewBackgroundHelper_android_background;
            if (m1196r.m1198p(i2)) {
                this.f6899c = m1196r.m1201m(i2, -1);
                ColorStateList m2577d = this.f6898b.m2577d(this.f6897a.getContext(), this.f6899c);
                if (m2577d != null) {
                    m15g(m2577d);
                }
            }
            int i3 = C2012o.ViewBackgroundHelper_backgroundTint;
            if (m1196r.m1198p(i3)) {
                C0492V4.C0500h.m1884q(this.f6897a, m1196r.m1211c(i3));
            }
            int i4 = C2012o.ViewBackgroundHelper_backgroundTintMode;
            if (m1196r.m1198p(i4)) {
                C0492V4.C0500h.m1883r(this.f6897a, C0263L0.m2226c(m1196r.m1204j(i4, -1), null));
            }
            m1196r.f3660b.recycle();
        } catch (Throwable th) {
            m1196r.f3660b.recycle();
            throw th;
        }
    }

    /* renamed from: e */
    public void m17e() {
        this.f6899c = -1;
        m15g(null);
        m21a();
    }

    /* renamed from: f */
    public void m16f(int i) {
        this.f6899c = i;
        C0032B0 c0032b0 = this.f6898b;
        m15g(c0032b0 != null ? c0032b0.m2577d(this.f6897a.getContext(), i) : null);
        m21a();
    }

    /* renamed from: g */
    public void m15g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f6900d == null) {
                this.f6900d = new C0584Z0();
            }
            C0584Z0 c0584z0 = this.f6900d;
            c0584z0.f2067a = colorStateList;
            c0584z0.f2070d = true;
        } else {
            this.f6900d = null;
        }
        m21a();
    }

    /* renamed from: h */
    public void m14h(ColorStateList colorStateList) {
        if (this.f6901e == null) {
            this.f6901e = new C0584Z0();
        }
        C0584Z0 c0584z0 = this.f6901e;
        c0584z0.f2067a = colorStateList;
        c0584z0.f2070d = true;
        m21a();
    }

    /* renamed from: i */
    public void m13i(PorterDuff.Mode mode) {
        if (this.f6901e == null) {
            this.f6901e = new C0584Z0();
        }
        C0584Z0 c0584z0 = this.f6901e;
        c0584z0.f2068b = mode;
        c0584z0.f2069c = true;
        m21a();
    }
}
