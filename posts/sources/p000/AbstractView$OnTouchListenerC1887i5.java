package p000;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: i5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractView$OnTouchListenerC1887i5 implements View.OnTouchListener {

    /* renamed from: r */
    public static final int f5247r = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    public final C1888a f5248a;

    /* renamed from: b */
    public final Interpolator f5249b;

    /* renamed from: c */
    public final View f5250c;

    /* renamed from: d */
    public Runnable f5251d;

    /* renamed from: f */
    public float[] f5252f;

    /* renamed from: g */
    public float[] f5253g;

    /* renamed from: h */
    public int f5254h;

    /* renamed from: i */
    public int f5255i;

    /* renamed from: j */
    public float[] f5256j;

    /* renamed from: k */
    public float[] f5257k;

    /* renamed from: l */
    public float[] f5258l;

    /* renamed from: m */
    public boolean f5259m;

    /* renamed from: n */
    public boolean f5260n;

    /* renamed from: o */
    public boolean f5261o;

    /* renamed from: p */
    public boolean f5262p;

    /* renamed from: q */
    public boolean f5263q;

    /* renamed from: i5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1888a {

        /* renamed from: a */
        public int f5264a;

        /* renamed from: b */
        public int f5265b;

        /* renamed from: c */
        public float f5266c;

        /* renamed from: d */
        public float f5267d;

        /* renamed from: j */
        public float f5273j;

        /* renamed from: k */
        public int f5274k;

        /* renamed from: e */
        public long f5268e = Long.MIN_VALUE;

        /* renamed from: i */
        public long f5272i = -1;

        /* renamed from: f */
        public long f5269f = 0;

        /* renamed from: g */
        public int f5270g = 0;

        /* renamed from: h */
        public int f5271h = 0;

        /* renamed from: a */
        public final float m744a(long j) {
            long j2 = this.f5268e;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.f5272i;
            if (j3 >= 0 && j >= j3) {
                float f = this.f5273j;
                return (AbstractView$OnTouchListenerC1887i5.m748b(((float) (j - j3)) / this.f5274k, 0.0f, 1.0f) * f) + (1.0f - f);
            }
            return AbstractView$OnTouchListenerC1887i5.m748b(((float) (j - j2)) / this.f5264a, 0.0f, 1.0f) * 0.5f;
        }
    }

    /* renamed from: i5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1889b implements Runnable {
        public RunnableC1889b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractView$OnTouchListenerC1887i5 abstractView$OnTouchListenerC1887i5 = AbstractView$OnTouchListenerC1887i5.this;
            if (abstractView$OnTouchListenerC1887i5.f5262p) {
                if (abstractView$OnTouchListenerC1887i5.f5260n) {
                    abstractView$OnTouchListenerC1887i5.f5260n = false;
                    C1888a c1888a = abstractView$OnTouchListenerC1887i5.f5248a;
                    Objects.requireNonNull(c1888a);
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    c1888a.f5268e = currentAnimationTimeMillis;
                    c1888a.f5272i = -1L;
                    c1888a.f5269f = currentAnimationTimeMillis;
                    c1888a.f5273j = 0.5f;
                    c1888a.f5270g = 0;
                    c1888a.f5271h = 0;
                }
                C1888a c1888a2 = AbstractView$OnTouchListenerC1887i5.this.f5248a;
                if (!(c1888a2.f5272i > 0 && AnimationUtils.currentAnimationTimeMillis() > c1888a2.f5272i + ((long) c1888a2.f5274k)) && AbstractView$OnTouchListenerC1887i5.this.m745e()) {
                    AbstractView$OnTouchListenerC1887i5 abstractView$OnTouchListenerC1887i52 = AbstractView$OnTouchListenerC1887i5.this;
                    if (abstractView$OnTouchListenerC1887i52.f5261o) {
                        abstractView$OnTouchListenerC1887i52.f5261o = false;
                        Objects.requireNonNull(abstractView$OnTouchListenerC1887i52);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        abstractView$OnTouchListenerC1887i52.f5250c.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (c1888a2.f5269f != 0) {
                        long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float m744a = c1888a2.m744a(currentAnimationTimeMillis2);
                        c1888a2.f5269f = currentAnimationTimeMillis2;
                        float f = ((float) (currentAnimationTimeMillis2 - c1888a2.f5269f)) * ((m744a * 4.0f) + ((-4.0f) * m744a * m744a));
                        c1888a2.f5270g = (int) (c1888a2.f5266c * f);
                        int i = (int) (f * c1888a2.f5267d);
                        c1888a2.f5271h = i;
                        ((C1937k5) AbstractView$OnTouchListenerC1887i5.this).f5383s.scrollListBy(i);
                        View view = AbstractView$OnTouchListenerC1887i5.this.f5250c;
                        AtomicInteger atomicInteger = C0492V4.f1798a;
                        C0492V4.C0495c.m1931m(view, this);
                        return;
                    }
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                AbstractView$OnTouchListenerC1887i5.this.f5262p = false;
            }
        }
    }

    public AbstractView$OnTouchListenerC1887i5(View view) {
        C1888a c1888a = new C1888a();
        this.f5248a = c1888a;
        this.f5249b = new AccelerateInterpolator();
        this.f5252f = new float[]{0.0f, 0.0f};
        this.f5253g = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f5256j = new float[]{0.0f, 0.0f};
        this.f5257k = new float[]{0.0f, 0.0f};
        this.f5258l = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f5250c = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f5258l;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr[0] = f2;
        fArr[1] = f2;
        float[] fArr2 = this.f5257k;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f3;
        fArr2[1] = f3;
        this.f5254h = 1;
        float[] fArr3 = this.f5253g;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f5252f;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f5256j;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.f5255i = f5247r;
        c1888a.f5264a = 500;
        c1888a.f5265b = 500;
    }

    /* renamed from: b */
    public static float m748b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float m749a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f5252f
            r0 = r0[r4]
            float[] r1 = r3.f5253g
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = m748b(r0, r2, r1)
            float r1 = r3.m747c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.m747c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L26
            android.view.animation.Interpolator r6 = r3.f5249b
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L30
        L26:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L39
            android.view.animation.Interpolator r6 = r3.f5249b
            float r5 = r6.getInterpolation(r5)
        L30:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = m748b(r5, r6, r0)
            goto L3a
        L39:
            r5 = 0
        L3a:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3f
            return r2
        L3f:
            float[] r0 = r3.f5256j
            r0 = r0[r4]
            float[] r1 = r3.f5257k
            r1 = r1[r4]
            float[] r2 = r3.f5258l
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L56
            float r5 = r5 * r0
            float r4 = m748b(r5, r1, r4)
            return r4
        L56:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = m748b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractView$OnTouchListenerC1887i5.m749a(int, float, float, float):float");
    }

    /* renamed from: c */
    public final float m747c(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f5254h;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f5262p && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    /* renamed from: d */
    public final void m746d() {
        int i = 0;
        if (this.f5260n) {
            this.f5262p = false;
            return;
        }
        C1888a c1888a = this.f5248a;
        Objects.requireNonNull(c1888a);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - c1888a.f5268e);
        int i3 = c1888a.f5265b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        c1888a.f5274k = i;
        c1888a.f5273j = c1888a.m744a(currentAnimationTimeMillis);
        c1888a.f5272i = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m745e() {
        /*
            r9 = this;
            i5$a r0 = r9.f5248a
            float r1 = r0.f5267d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.f5266c
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L53
            r4 = r9
            k5 r4 = (p000.C1937k5) r4
            android.widget.ListView r4 = r4.f5383s
            int r5 = r4.getCount()
            if (r5 != 0) goto L23
        L21:
            r1 = 0
            goto L51
        L23:
            int r6 = r4.getChildCount()
            int r7 = r4.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L41
            if (r8 < r5) goto L50
            int r6 = r6 - r2
            android.view.View r1 = r4.getChildAt(r6)
            int r1 = r1.getBottom()
            int r4 = r4.getHeight()
            if (r1 > r4) goto L50
            goto L21
        L41:
            if (r1 >= 0) goto L21
            if (r7 > 0) goto L50
            android.view.View r1 = r4.getChildAt(r3)
            int r1 = r1.getTop()
            if (r1 < 0) goto L50
            goto L21
        L50:
            r1 = 1
        L51:
            if (r1 != 0) goto L54
        L53:
            r2 = 0
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractView$OnTouchListenerC1887i5.m745e():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f5263q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L7f
        L16:
            r5.m746d()
            goto L7f
        L1a:
            r5.f5261o = r2
            r5.f5259m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f5250c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.m749a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f5250c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.m749a(r2, r7, r6, r3)
            i5$a r7 = r5.f5248a
            r7.f5266c = r0
            r7.f5267d = r6
            boolean r6 = r5.f5262p
            if (r6 != 0) goto L7f
            boolean r6 = r5.m745e()
            if (r6 == 0) goto L7f
            java.lang.Runnable r6 = r5.f5251d
            if (r6 != 0) goto L61
            i5$b r6 = new i5$b
            r6.<init>()
            r5.f5251d = r6
        L61:
            r5.f5262p = r2
            r5.f5260n = r2
            boolean r6 = r5.f5259m
            if (r6 != 0) goto L78
            int r6 = r5.f5255i
            if (r6 <= 0) goto L78
            android.view.View r7 = r5.f5250c
            java.lang.Runnable r0 = r5.f5251d
            long r3 = (long) r6
            java.util.concurrent.atomic.AtomicInteger r6 = p000.C0492V4.f1798a
            p000.C0492V4.C0495c.m1930n(r7, r0, r3)
            goto L7d
        L78:
            java.lang.Runnable r6 = r5.f5251d
            r6.run()
        L7d:
            r5.f5259m = r2
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractView$OnTouchListenerC1887i5.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
