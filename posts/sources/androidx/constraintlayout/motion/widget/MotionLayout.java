package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import p000.C0445T2;
import p000.C0550X2;
import p000.C0982c2;
import p000.C2248t2;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MotionLayout extends ConstraintLayout implements InterfaceC0287M4 {

    /* renamed from: l0 */
    public static boolean f2682l0;

    /* renamed from: A */
    public C0706b f2683A;

    /* renamed from: B */
    public int f2684B;

    /* renamed from: C */
    public int f2685C;

    /* renamed from: D */
    public boolean f2686D;

    /* renamed from: E */
    public float f2687E;

    /* renamed from: F */
    public float f2688F;

    /* renamed from: G */
    public long f2689G;

    /* renamed from: H */
    public float f2690H;

    /* renamed from: I */
    public boolean f2691I;

    /* renamed from: J */
    public ArrayList<MotionHelper> f2692J;

    /* renamed from: K */
    public ArrayList<MotionHelper> f2693K;

    /* renamed from: L */
    public ArrayList<InterfaceC0712h> f2694L;

    /* renamed from: M */
    public int f2695M;

    /* renamed from: N */
    public long f2696N;

    /* renamed from: O */
    public float f2697O;

    /* renamed from: P */
    public int f2698P;

    /* renamed from: Q */
    public float f2699Q;

    /* renamed from: R */
    public boolean f2700R;

    /* renamed from: S */
    public int f2701S;

    /* renamed from: T */
    public int f2702T;

    /* renamed from: U */
    public int f2703U;

    /* renamed from: V */
    public int f2704V;

    /* renamed from: W */
    public int f2705W;

    /* renamed from: a */
    public C0982c2 f2706a;

    /* renamed from: a0 */
    public int f2707a0;

    /* renamed from: b */
    public Interpolator f2708b;

    /* renamed from: b0 */
    public float f2709b0;

    /* renamed from: c */
    public float f2710c;

    /* renamed from: c0 */
    public C0366Q1 f2711c0;

    /* renamed from: d */
    public int f2712d;

    /* renamed from: d0 */
    public boolean f2713d0;

    /* renamed from: e0 */
    public C0711g f2714e0;

    /* renamed from: f */
    public int f2715f;

    /* renamed from: f0 */
    public EnumC0713i f2716f0;

    /* renamed from: g */
    public int f2717g;

    /* renamed from: g0 */
    public C0708d f2718g0;

    /* renamed from: h */
    public int f2719h;

    /* renamed from: h0 */
    public boolean f2720h0;

    /* renamed from: i */
    public int f2721i;

    /* renamed from: i0 */
    public RectF f2722i0;

    /* renamed from: j */
    public boolean f2723j;

    /* renamed from: j0 */
    public View f2724j0;

    /* renamed from: k */
    public HashMap<View, C0585Z1> f2725k;

    /* renamed from: k0 */
    public ArrayList<Integer> f2726k0;

    /* renamed from: l */
    public long f2727l;

    /* renamed from: m */
    public float f2728m;

    /* renamed from: n */
    public float f2729n;

    /* renamed from: o */
    public float f2730o;

    /* renamed from: p */
    public long f2731p;

    /* renamed from: q */
    public float f2732q;

    /* renamed from: r */
    public boolean f2733r;

    /* renamed from: s */
    public boolean f2734s;

    /* renamed from: t */
    public InterfaceC0712h f2735t;

    /* renamed from: u */
    public float f2736u;

    /* renamed from: v */
    public float f2737v;

    /* renamed from: w */
    public int f2738w;

    /* renamed from: x */
    public C0707c f2739x;

    /* renamed from: y */
    public boolean f2740y;

    /* renamed from: z */
    public C0284M1 f2741z;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0705a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f2742a;

        public RunnableC0705a(MotionLayout motionLayout, View view) {
            this.f2742a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2742a.setNestedScrollingEnabled(true);
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0706b extends AbstractanimationInterpolatorC0606a2 {

        /* renamed from: a */
        public float f2743a = 0.0f;

        /* renamed from: b */
        public float f2744b = 0.0f;

        /* renamed from: c */
        public float f2745c;

        public C0706b() {
        }

        @Override // p000.AbstractanimationInterpolatorC0606a2
        /* renamed from: a */
        public float mo1565a() {
            return MotionLayout.this.f2710c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.f2743a;
            if (f2 > 0.0f) {
                float f3 = this.f2745c;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                MotionLayout.this.f2710c = f2 - (f3 * f);
                return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.f2744b;
            }
            float f4 = this.f2745c;
            if ((-f2) / f4 < f) {
                f = (-f2) / f4;
            }
            MotionLayout.this.f2710c = (f4 * f) + f2;
            return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.f2744b;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0707c {

        /* renamed from: a */
        public float[] f2747a;

        /* renamed from: b */
        public int[] f2748b;

        /* renamed from: c */
        public float[] f2749c;

        /* renamed from: d */
        public Path f2750d;

        /* renamed from: e */
        public Paint f2751e;

        /* renamed from: f */
        public Paint f2752f;

        /* renamed from: g */
        public Paint f2753g;

        /* renamed from: h */
        public Paint f2754h;

        /* renamed from: i */
        public Paint f2755i;

        /* renamed from: j */
        public float[] f2756j;

        /* renamed from: k */
        public DashPathEffect f2757k;

        /* renamed from: l */
        public int f2758l;

        /* renamed from: m */
        public Rect f2759m = new Rect();

        /* renamed from: n */
        public int f2760n = 1;

        public C0707c() {
            Paint paint = new Paint();
            this.f2751e = paint;
            paint.setAntiAlias(true);
            this.f2751e.setColor(-21965);
            this.f2751e.setStrokeWidth(2.0f);
            this.f2751e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f2752f = paint2;
            paint2.setAntiAlias(true);
            this.f2752f.setColor(-2067046);
            this.f2752f.setStrokeWidth(2.0f);
            this.f2752f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f2753g = paint3;
            paint3.setAntiAlias(true);
            this.f2753g.setColor(-13391360);
            this.f2753g.setStrokeWidth(2.0f);
            this.f2753g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f2754h = paint4;
            paint4.setAntiAlias(true);
            this.f2754h.setColor(-13391360);
            this.f2754h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f2756j = new float[8];
            Paint paint5 = new Paint();
            this.f2755i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f2757k = dashPathEffect;
            this.f2753g.setPathEffect(dashPathEffect);
            this.f2749c = new float[100];
            this.f2748b = new int[50];
        }

        /* renamed from: a */
        public void m1564a(Canvas canvas, int i, int i2, C0585Z1 c0585z1) {
            int i3;
            int i4;
            float f;
            float f2;
            int i5;
            if (i == 4) {
                boolean z = false;
                boolean z2 = false;
                for (int i6 = 0; i6 < this.f2758l; i6++) {
                    int[] iArr = this.f2748b;
                    if (iArr[i6] == 1) {
                        z = true;
                    }
                    if (iArr[i6] == 2) {
                        z2 = true;
                    }
                }
                if (z) {
                    m1561d(canvas);
                }
                if (z2) {
                    m1563b(canvas);
                }
            }
            if (i == 2) {
                m1561d(canvas);
            }
            if (i == 3) {
                m1563b(canvas);
            }
            canvas.drawLines(this.f2747a, this.f2751e);
            View view = c0585z1.f2072a;
            if (view != null) {
                i3 = view.getWidth();
                i4 = c0585z1.f2072a.getHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            int i7 = 1;
            while (i7 < i2 - 1) {
                if (i == 4 && this.f2748b[i7 - 1] == 0) {
                    i5 = i7;
                } else {
                    float[] fArr = this.f2749c;
                    int i8 = i7 * 2;
                    float f3 = fArr[i8];
                    float f4 = fArr[i8 + 1];
                    this.f2750d.reset();
                    this.f2750d.moveTo(f3, f4 + 10.0f);
                    this.f2750d.lineTo(f3 + 10.0f, f4);
                    this.f2750d.lineTo(f3, f4 - 10.0f);
                    this.f2750d.lineTo(f3 - 10.0f, f4);
                    this.f2750d.close();
                    int i9 = i7 - 1;
                    c0585z1.f2091t.get(i9);
                    if (i == 4) {
                        int[] iArr2 = this.f2748b;
                        if (iArr2[i9] == 1) {
                            m1560e(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr2[i9] == 2) {
                            m1562c(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr2[i9] == 3) {
                            f = f4;
                            f2 = f3;
                            i5 = i7;
                            m1559f(canvas, f3 - 0.0f, f4 - 0.0f, i3, i4);
                            canvas.drawPath(this.f2750d, this.f2755i);
                        }
                        f = f4;
                        f2 = f3;
                        i5 = i7;
                        canvas.drawPath(this.f2750d, this.f2755i);
                    } else {
                        f = f4;
                        f2 = f3;
                        i5 = i7;
                    }
                    if (i == 2) {
                        m1560e(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 3) {
                        m1562c(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        m1559f(canvas, f2 - 0.0f, f - 0.0f, i3, i4);
                    }
                    canvas.drawPath(this.f2750d, this.f2755i);
                }
                i7 = i5 + 1;
            }
            float[] fArr2 = this.f2747a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f2752f);
                float[] fArr3 = this.f2747a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f2752f);
            }
        }

        /* renamed from: b */
        public final void m1563b(Canvas canvas) {
            float[] fArr = this.f2747a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.f2753g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.f2753g);
        }

        /* renamed from: c */
        public final void m1562c(Canvas canvas, float f, float f2) {
            float[] fArr = this.f2747a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            StringBuilder m253r = outline.m253r("");
            m253r.append(((int) (((min2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
            String sb = m253r.toString();
            m1558g(sb, this.f2754h);
            canvas.drawText(sb, ((min2 / 2.0f) - (this.f2759m.width() / 2)) + min, f2 - 20.0f, this.f2754h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.f2753g);
            StringBuilder m253r2 = outline.m253r("");
            m253r2.append(((int) (((max2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            String sb2 = m253r2.toString();
            m1558g(sb2, this.f2754h);
            canvas.drawText(sb2, f + 5.0f, max - ((max2 / 2.0f) - (this.f2759m.height() / 2)), this.f2754h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.f2753g);
        }

        /* renamed from: d */
        public final void m1561d(Canvas canvas) {
            float[] fArr = this.f2747a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f2753g);
        }

        /* renamed from: e */
        public final void m1560e(Canvas canvas, float f, float f2) {
            float[] fArr = this.f2747a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f2 - f4) * f8) + ((f - f3) * f7)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            StringBuilder m253r = outline.m253r("");
            m253r.append(((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            String sb = m253r.toString();
            m1558g(sb, this.f2754h);
            canvas.drawTextOnPath(sb, path, (hypot2 / 2.0f) - (this.f2759m.width() / 2), -20.0f, this.f2754h);
            canvas.drawLine(f, f2, f10, f11, this.f2753g);
        }

        /* renamed from: f */
        public final void m1559f(Canvas canvas, float f, float f2, int i, int i2) {
            StringBuilder m253r = outline.m253r("");
            m253r.append(((int) ((((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i)) + 0.5d)) / 100.0f);
            String sb = m253r.toString();
            m1558g(sb, this.f2754h);
            canvas.drawText(sb, ((f / 2.0f) - (this.f2759m.width() / 2)) + 0.0f, f2 - 20.0f, this.f2754h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.f2753g);
            StringBuilder m253r2 = outline.m253r("");
            m253r2.append(((int) ((((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2)) + 0.5d)) / 100.0f);
            String sb2 = m253r2.toString();
            m1558g(sb2, this.f2754h);
            canvas.drawText(sb2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.f2759m.height() / 2)), this.f2754h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.f2753g);
        }

        /* renamed from: g */
        public void m1558g(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f2759m);
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0708d {

        /* renamed from: a */
        public C2269u2 f2762a = new C2269u2();

        /* renamed from: b */
        public C2269u2 f2763b = new C2269u2();

        /* renamed from: c */
        public C0445T2 f2764c = null;

        /* renamed from: d */
        public C0445T2 f2765d = null;

        /* renamed from: e */
        public int f2766e;

        /* renamed from: f */
        public int f2767f;

        public C0708d() {
        }

        /* renamed from: a */
        public void m1557a() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f2725k.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = MotionLayout.this.getChildAt(i);
                MotionLayout.this.f2725k.put(childAt, new C0585Z1(childAt));
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = MotionLayout.this.getChildAt(i2);
                C0585Z1 c0585z1 = MotionLayout.this.f2725k.get(childAt2);
                if (c0585z1 != null) {
                    if (this.f2764c != null) {
                        C2248t2 m1555c = m1555c(this.f2762a, childAt2);
                        if (m1555c != null) {
                            C0445T2 c0445t2 = this.f2764c;
                            C0955b2 c0955b2 = c0585z1.f2075d;
                            c0955b2.f3665c = 0.0f;
                            c0955b2.f3666d = 0.0f;
                            c0585z1.m1751d(c0955b2);
                            c0585z1.f2075d.m1192d(m1555c.m353x(), m1555c.m352y(), m1555c.m354w(), m1555c.m360q());
                            C0445T2.C0446a m2025h = c0445t2.m2025h(c0585z1.f2073b);
                            c0585z1.f2075d.m1195a(m2025h);
                            c0585z1.f2081j = m2025h.f1458c.f1531f;
                            c0585z1.f2077f.m1775c(m1555c, c0445t2, c0585z1.f2073b);
                        } else if (MotionLayout.this.f2738w != 0) {
                            Log.e("MotionLayout", LayoutInflater$Factory2C0000A.C0010h.m2675C() + "no widget for  " + LayoutInflater$Factory2C0000A.C0010h.m2673E(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.f2765d != null) {
                        C2248t2 m1555c2 = m1555c(this.f2763b, childAt2);
                        if (m1555c2 != null) {
                            C0445T2 c0445t22 = this.f2765d;
                            C0955b2 c0955b22 = c0585z1.f2076e;
                            c0955b22.f3665c = 1.0f;
                            c0955b22.f3666d = 1.0f;
                            c0585z1.m1751d(c0955b22);
                            c0585z1.f2076e.m1192d(m1555c2.m353x(), m1555c2.m352y(), m1555c2.m354w(), m1555c2.m360q());
                            c0585z1.f2076e.m1195a(c0445t22.m2025h(c0585z1.f2073b));
                            c0585z1.f2078g.m1775c(m1555c2, c0445t22, c0585z1.f2073b);
                        } else if (MotionLayout.this.f2738w != 0) {
                            Log.e("MotionLayout", LayoutInflater$Factory2C0000A.C0010h.m2675C() + "no widget for  " + LayoutInflater$Factory2C0000A.C0010h.m2673E(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        /* renamed from: b */
        public void m1556b(C2269u2 c2269u2, C2269u2 c2269u22) {
            C2248t2 c2248t2;
            ArrayList<C2248t2> arrayList = c2269u2.f174I0;
            HashMap<C2248t2, C2248t2> hashMap = new HashMap<>();
            hashMap.put(c2269u2, c2269u22);
            c2269u22.f174I0.clear();
            c2269u22.mo64k(c2269u2, hashMap);
            Iterator<C2248t2> it = arrayList.iterator();
            while (it.hasNext()) {
                C2248t2 next = it.next();
                if (next instanceof C2189q2) {
                    c2248t2 = new C2189q2();
                } else if (next instanceof C2306w2) {
                    c2248t2 = new C2306w2();
                } else if (next instanceof C2287v2) {
                    c2248t2 = new C2287v2();
                } else if (next instanceof InterfaceC2341x2) {
                    c2248t2 = new C2363y2();
                } else {
                    c2248t2 = new C2248t2();
                }
                c2269u22.m2561a(c2248t2);
                hashMap.put(next, c2248t2);
            }
            Iterator<C2248t2> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C2248t2 next2 = it2.next();
                hashMap.get(next2).mo64k(next2, hashMap);
            }
        }

        /* renamed from: c */
        public C2248t2 m1555c(C2269u2 c2269u2, View view) {
            if (c2269u2.f6499i0 == view) {
                return c2269u2;
            }
            ArrayList<C2248t2> arrayList = c2269u2.f174I0;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                C2248t2 c2248t2 = arrayList.get(i);
                if (c2248t2.f6499i0 == view) {
                    return c2248t2;
                }
            }
            return null;
        }

        /* renamed from: d */
        public void m1554d(C0445T2 c0445t2, C0445T2 c0445t22) {
            C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.WRAP_CONTENT;
            this.f2764c = c0445t2;
            this.f2765d = c0445t22;
            this.f2762a = new C2269u2();
            this.f2763b = new C2269u2();
            C2269u2 c2269u2 = this.f2762a;
            MotionLayout motionLayout = MotionLayout.this;
            boolean z = MotionLayout.f2682l0;
            c2269u2.m305f0(motionLayout.mLayoutWidget.f6607L0);
            this.f2763b.m305f0(MotionLayout.this.mLayoutWidget.f6607L0);
            this.f2762a.f174I0.clear();
            this.f2763b.f174I0.clear();
            m1556b(MotionLayout.this.mLayoutWidget, this.f2762a);
            m1556b(MotionLayout.this.mLayoutWidget, this.f2763b);
            if (MotionLayout.this.f2730o > 0.5d) {
                if (c0445t2 != null) {
                    m1552f(this.f2762a, c0445t2);
                }
                m1552f(this.f2763b, c0445t22);
            } else {
                m1552f(this.f2763b, c0445t22);
                if (c0445t2 != null) {
                    m1552f(this.f2762a, c0445t2);
                }
            }
            this.f2762a.f6608M0 = MotionLayout.this.isRtl();
            this.f2762a.m303h0();
            this.f2763b.f6608M0 = MotionLayout.this.isRtl();
            this.f2763b.m303h0();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.f2762a.f6473R[0] = enumC2249a;
                    this.f2763b.f6473R[0] = enumC2249a;
                }
                if (layoutParams.height == -2) {
                    this.f2762a.f6473R[1] = enumC2249a;
                    this.f2763b.f6473R[1] = enumC2249a;
                }
            }
        }

        /* renamed from: e */
        public void m1553e() {
            MotionLayout motionLayout = MotionLayout.this;
            int i = motionLayout.f2719h;
            int i2 = motionLayout.f2721i;
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout2 = MotionLayout.this;
            motionLayout2.f2705W = mode;
            motionLayout2.f2707a0 = mode2;
            int optimizationLevel = motionLayout2.getOptimizationLevel();
            MotionLayout motionLayout3 = MotionLayout.this;
            if (motionLayout3.f2715f == motionLayout3.f2712d) {
                motionLayout3.resolveSystem(this.f2763b, optimizationLevel, i, i2);
                if (this.f2764c != null) {
                    MotionLayout.this.resolveSystem(this.f2762a, optimizationLevel, i, i2);
                }
            } else {
                if (this.f2764c != null) {
                    motionLayout3.resolveSystem(this.f2762a, optimizationLevel, i, i2);
                }
                MotionLayout.this.resolveSystem(this.f2763b, optimizationLevel, i, i2);
            }
            int i3 = 0;
            boolean z = true;
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout4 = MotionLayout.this;
                motionLayout4.f2705W = mode;
                motionLayout4.f2707a0 = mode2;
                if (motionLayout4.f2715f == motionLayout4.f2712d) {
                    motionLayout4.resolveSystem(this.f2763b, optimizationLevel, i, i2);
                    if (this.f2764c != null) {
                        MotionLayout.this.resolveSystem(this.f2762a, optimizationLevel, i, i2);
                    }
                } else {
                    if (this.f2764c != null) {
                        motionLayout4.resolveSystem(this.f2762a, optimizationLevel, i, i2);
                    }
                    MotionLayout.this.resolveSystem(this.f2763b, optimizationLevel, i, i2);
                }
                MotionLayout.this.f2701S = this.f2762a.m354w();
                MotionLayout.this.f2702T = this.f2762a.m360q();
                MotionLayout.this.f2703U = this.f2763b.m354w();
                MotionLayout.this.f2704V = this.f2763b.m360q();
                MotionLayout motionLayout5 = MotionLayout.this;
                motionLayout5.f2700R = (motionLayout5.f2701S == motionLayout5.f2703U && motionLayout5.f2702T == motionLayout5.f2704V) ? false : true;
            }
            MotionLayout motionLayout6 = MotionLayout.this;
            int i4 = motionLayout6.f2701S;
            int i5 = motionLayout6.f2702T;
            int i6 = motionLayout6.f2705W;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                i4 = (int) ((motionLayout6.f2709b0 * (motionLayout6.f2703U - i4)) + i4);
            }
            int i7 = motionLayout6.f2707a0;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i5 = (int) ((motionLayout6.f2709b0 * (motionLayout6.f2704V - i5)) + i5);
            }
            int i8 = i5;
            C2269u2 c2269u2 = this.f2762a;
            motionLayout6.resolveMeasuredDimension(i, i2, i4, i8, c2269u2.f6617V0 || this.f2763b.f6617V0, c2269u2.f6618W0 || this.f2763b.f6618W0);
            MotionLayout motionLayout7 = MotionLayout.this;
            int childCount = motionLayout7.getChildCount();
            motionLayout7.f2718g0.m1557a();
            motionLayout7.f2734s = true;
            int width = motionLayout7.getWidth();
            int height = motionLayout7.getHeight();
            C0982c2.C0984b c0984b = motionLayout7.f2706a.f3751c;
            int i9 = c0984b != null ? c0984b.f3783p : -1;
            if (i9 != -1) {
                for (int i10 = 0; i10 < childCount; i10++) {
                    C0585Z1 c0585z1 = motionLayout7.f2725k.get(motionLayout7.getChildAt(i10));
                    if (c0585z1 != null) {
                        c0585z1.f2071A = i9;
                    }
                }
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                C0585Z1 c0585z12 = motionLayout7.f2725k.get(motionLayout7.getChildAt(i11));
                if (c0585z12 != null) {
                    motionLayout7.f2706a.m1136g(c0585z12);
                    c0585z12.m1750e(width, height, System.nanoTime());
                }
            }
            C0982c2.C0984b c0984b2 = motionLayout7.f2706a.f3751c;
            float f = c0984b2 != null ? c0984b2.f3776i : 0.0f;
            if (f != 0.0f) {
                boolean z2 = ((double) f) < ShadowDrawableWrapper.COS_45;
                float abs = Math.abs(f);
                float f2 = -3.4028235E38f;
                float f3 = Float.MAX_VALUE;
                int i12 = 0;
                float f4 = Float.MAX_VALUE;
                float f5 = -3.4028235E38f;
                while (true) {
                    if (i12 >= childCount) {
                        z = false;
                        break;
                    }
                    C0585Z1 c0585z13 = motionLayout7.f2725k.get(motionLayout7.getChildAt(i12));
                    if (!Float.isNaN(c0585z13.f2081j)) {
                        break;
                    }
                    C0955b2 c0955b2 = c0585z13.f2076e;
                    float f6 = c0955b2.f3667f;
                    float f7 = c0955b2.f3668g;
                    float f8 = z2 ? f7 - f6 : f7 + f6;
                    f4 = Math.min(f4, f8);
                    f5 = Math.max(f5, f8);
                    i12++;
                }
                if (!z) {
                    while (i3 < childCount) {
                        C0585Z1 c0585z14 = motionLayout7.f2725k.get(motionLayout7.getChildAt(i3));
                        C0955b2 c0955b22 = c0585z14.f2076e;
                        float f9 = c0955b22.f3667f;
                        float f10 = c0955b22.f3668g;
                        float f11 = z2 ? f10 - f9 : f10 + f9;
                        c0585z14.f2083l = 1.0f / (1.0f - abs);
                        c0585z14.f2082k = abs - (((f11 - f4) * abs) / (f5 - f4));
                        i3++;
                    }
                    return;
                }
                for (int i13 = 0; i13 < childCount; i13++) {
                    C0585Z1 c0585z15 = motionLayout7.f2725k.get(motionLayout7.getChildAt(i13));
                    if (!Float.isNaN(c0585z15.f2081j)) {
                        f3 = Math.min(f3, c0585z15.f2081j);
                        f2 = Math.max(f2, c0585z15.f2081j);
                    }
                }
                while (i3 < childCount) {
                    C0585Z1 c0585z16 = motionLayout7.f2725k.get(motionLayout7.getChildAt(i3));
                    if (!Float.isNaN(c0585z16.f2081j)) {
                        c0585z16.f2083l = 1.0f / (1.0f - abs);
                        if (z2) {
                            c0585z16.f2082k = abs - (((f2 - c0585z16.f2081j) / (f2 - f3)) * abs);
                        } else {
                            c0585z16.f2082k = abs - (((c0585z16.f2081j - f3) * abs) / (f2 - f3));
                        }
                    }
                    i3++;
                }
            }
        }

        /* renamed from: f */
        public final void m1552f(C2269u2 c2269u2, C0445T2 c0445t2) {
            SparseArray<C2248t2> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, c2269u2);
            sparseArray.put(MotionLayout.this.getId(), c2269u2);
            Iterator<C2248t2> it = c2269u2.f174I0.iterator();
            while (it.hasNext()) {
                C2248t2 next = it.next();
                sparseArray.put(((View) next.f6499i0).getId(), next);
            }
            Iterator<C2248t2> it2 = c2269u2.f174I0.iterator();
            while (it2.hasNext()) {
                C2248t2 next2 = it2.next();
                View view = (View) next2.f6499i0;
                int id = view.getId();
                if (c0445t2.f1455c.containsKey(Integer.valueOf(id))) {
                    c0445t2.f1455c.get(Integer.valueOf(id)).m2021a(layoutParams);
                }
                next2.m370S(c0445t2.m2025h(view.getId()).f1459d.f1493c);
                next2.m375N(c0445t2.m2025h(view.getId()).f1459d.f1495d);
                if (view instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) view;
                    int id2 = constraintHelper.getId();
                    if (c0445t2.f1455c.containsKey(Integer.valueOf(id2))) {
                        C0445T2.C0446a c0446a = c0445t2.f1455c.get(Integer.valueOf(id2));
                        if (next2 instanceof C2363y2) {
                            constraintHelper.mo1533m(c0446a, (C2363y2) next2, layoutParams, sparseArray);
                        }
                    }
                    if (view instanceof Barrier) {
                        ((Barrier) view).m1527t();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout motionLayout = MotionLayout.this;
                boolean z = MotionLayout.f2682l0;
                motionLayout.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (c0445t2.m2025h(view.getId()).f1457b.f1535c == 1) {
                    next2.f6503k0 = view.getVisibility();
                } else {
                    next2.f6503k0 = c0445t2.m2025h(view.getId()).f1457b.f1534b;
                }
            }
            Iterator<C2248t2> it3 = c2269u2.f174I0.iterator();
            while (it3.hasNext()) {
                C2248t2 next3 = it3.next();
                if (next3 instanceof C0016A2) {
                    InterfaceC2341x2 interfaceC2341x2 = (InterfaceC2341x2) next3;
                    ((ConstraintHelper) next3.f6499i0).m1528s(interfaceC2341x2, sparseArray);
                    ((C0016A2) interfaceC2341x2).m2591W();
                }
            }
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0709e {
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0710f implements InterfaceC0709e {

        /* renamed from: b */
        public static C0710f f2769b = new C0710f();

        /* renamed from: a */
        public VelocityTracker f2770a;
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0711g {

        /* renamed from: a */
        public float f2771a = Float.NaN;

        /* renamed from: b */
        public float f2772b = Float.NaN;

        /* renamed from: c */
        public int f2773c = -1;

        /* renamed from: d */
        public int f2774d = -1;

        public C0711g() {
        }

        /* renamed from: a */
        public void m1551a() {
            int i = this.f2773c;
            if (i != -1 || this.f2774d != -1) {
                if (i == -1) {
                    MotionLayout.this.m1566n(this.f2774d);
                } else {
                    int i2 = this.f2774d;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.m1569k(EnumC0713i.SETUP);
            }
            if (Float.isNaN(this.f2772b)) {
                if (Float.isNaN(this.f2771a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f2771a);
                return;
            }
            MotionLayout.this.setProgress(this.f2771a, this.f2772b);
            this.f2771a = Float.NaN;
            this.f2772b = Float.NaN;
            this.f2773c = -1;
            this.f2774d = -1;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0712h {
        /* renamed from: a */
        void mo1550a(MotionLayout motionLayout, int i, int i2, float f);

        /* renamed from: b */
        void mo1549b(MotionLayout motionLayout, int i, int i2);

        /* renamed from: c */
        void mo1548c(MotionLayout motionLayout, int i, boolean z, float f);

        /* renamed from: d */
        void mo1547d(MotionLayout motionLayout, int i);
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC0713i {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.f2710c = 0.0f;
        this.f2712d = -1;
        this.f2715f = -1;
        this.f2717g = -1;
        this.f2719h = 0;
        this.f2721i = 0;
        this.f2723j = true;
        this.f2725k = new HashMap<>();
        this.f2727l = 0L;
        this.f2728m = 1.0f;
        this.f2729n = 0.0f;
        this.f2730o = 0.0f;
        this.f2732q = 0.0f;
        this.f2734s = false;
        this.f2738w = 0;
        this.f2740y = false;
        this.f2741z = new C0284M1();
        this.f2683A = new C0706b();
        this.f2686D = false;
        this.f2691I = false;
        this.f2692J = null;
        this.f2693K = null;
        this.f2694L = null;
        this.f2695M = 0;
        this.f2696N = -1L;
        this.f2697O = 0.0f;
        this.f2698P = 0;
        this.f2699Q = 0.0f;
        this.f2700R = false;
        this.f2711c0 = new C0366Q1();
        this.f2713d0 = false;
        this.f2716f0 = EnumC0713i.UNDEFINED;
        this.f2718g0 = new C0708d();
        this.f2720h0 = false;
        this.f2722i0 = new RectF();
        this.f2724j0 = null;
        this.f2726k0 = new ArrayList<>();
        m1573g(null);
    }

    /* renamed from: a */
    public void m1579a(float f) {
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 == null) {
            return;
        }
        float f2 = this.f2730o;
        float f3 = this.f2729n;
        if (f2 != f3 && this.f2733r) {
            this.f2730o = f3;
        }
        float f4 = this.f2730o;
        if (f4 == f) {
            return;
        }
        this.f2740y = false;
        this.f2732q = f;
        this.f2728m = c0982c2.m1140c() / 1000.0f;
        setProgress(this.f2732q);
        this.f2708b = this.f2706a.m1137f();
        this.f2733r = false;
        this.f2727l = System.nanoTime();
        this.f2734s = true;
        this.f2729n = f4;
        this.f2730o = f4;
        invalidate();
    }

    /* renamed from: b */
    public void m1578b(boolean z) {
        float f;
        boolean z2;
        int i;
        float interpolation;
        boolean z3;
        EnumC0713i enumC0713i = EnumC0713i.FINISHED;
        if (this.f2731p == -1) {
            this.f2731p = System.nanoTime();
        }
        float f2 = this.f2730o;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f2715f = -1;
        }
        boolean z4 = false;
        if (this.f2691I || (this.f2734s && (z || this.f2732q != f2))) {
            float signum = Math.signum(this.f2732q - f2);
            long nanoTime = System.nanoTime();
            Interpolator interpolator = this.f2708b;
            if (interpolator instanceof AbstractanimationInterpolatorC0606a2) {
                f = 0.0f;
            } else {
                f = ((((float) (nanoTime - this.f2731p)) * signum) * 1.0E-9f) / this.f2728m;
                this.f2710c = f;
            }
            float f3 = this.f2730o + f;
            if (this.f2733r) {
                f3 = this.f2732q;
            }
            int i2 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i2 <= 0 || f3 < this.f2732q) && (signum > 0.0f || f3 > this.f2732q)) {
                z2 = false;
            } else {
                f3 = this.f2732q;
                this.f2734s = false;
                z2 = true;
            }
            this.f2730o = f3;
            this.f2729n = f3;
            this.f2731p = nanoTime;
            if (interpolator != null && !z2) {
                if (this.f2740y) {
                    interpolation = interpolator.getInterpolation(((float) (nanoTime - this.f2727l)) * 1.0E-9f);
                    this.f2730o = interpolation;
                    this.f2731p = nanoTime;
                    Interpolator interpolator2 = this.f2708b;
                    if (interpolator2 instanceof AbstractanimationInterpolatorC0606a2) {
                        float mo1565a = ((AbstractanimationInterpolatorC0606a2) interpolator2).mo1565a();
                        this.f2710c = mo1565a;
                        if (Math.abs(mo1565a) * this.f2728m <= 1.0E-5f) {
                            this.f2734s = false;
                        }
                        if (mo1565a > 0.0f && interpolation >= 1.0f) {
                            this.f2730o = 1.0f;
                            this.f2734s = false;
                            interpolation = 1.0f;
                        }
                        if (mo1565a < 0.0f && interpolation <= 0.0f) {
                            this.f2730o = 0.0f;
                            this.f2734s = false;
                            f3 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f3);
                    Interpolator interpolator3 = this.f2708b;
                    if (interpolator3 instanceof AbstractanimationInterpolatorC0606a2) {
                        this.f2710c = ((AbstractanimationInterpolatorC0606a2) interpolator3).mo1565a();
                    } else {
                        this.f2710c = ((interpolator3.getInterpolation(f3 + f) - interpolation) * signum) / f;
                    }
                }
                f3 = interpolation;
            }
            if (Math.abs(this.f2710c) > 1.0E-5f) {
                m1569k(EnumC0713i.MOVING);
            }
            if ((i2 > 0 && f3 >= this.f2732q) || (signum <= 0.0f && f3 <= this.f2732q)) {
                f3 = this.f2732q;
                this.f2734s = false;
            }
            int i3 = (f3 > 1.0f ? 1 : (f3 == 1.0f ? 0 : -1));
            if (i3 >= 0 || f3 <= 0.0f) {
                this.f2734s = false;
                m1569k(enumC0713i);
            }
            int childCount = getChildCount();
            this.f2691I = false;
            long nanoTime2 = System.nanoTime();
            this.f2709b0 = f3;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                C0585Z1 c0585z1 = this.f2725k.get(childAt);
                if (c0585z1 != null) {
                    this.f2691I = c0585z1.m1752c(childAt, f3, nanoTime2, this.f2711c0) | this.f2691I;
                }
            }
            boolean z5 = (i2 > 0 && f3 >= this.f2732q) || (signum <= 0.0f && f3 <= this.f2732q);
            if (!this.f2691I && !this.f2734s && z5) {
                m1569k(enumC0713i);
            }
            if (this.f2700R) {
                requestLayout();
            }
            this.f2691I = (!z5) | this.f2691I;
            if (f3 > 0.0f || (i = this.f2712d) == -1 || this.f2715f == i) {
                z4 = false;
            } else {
                this.f2715f = i;
                this.f2706a.m1141b(i).m2032a(this);
                m1569k(enumC0713i);
                z4 = true;
            }
            if (f3 >= 1.0d) {
                int i5 = this.f2715f;
                int i6 = this.f2717g;
                if (i5 != i6) {
                    this.f2715f = i6;
                    this.f2706a.m1141b(i6).m2032a(this);
                    m1569k(enumC0713i);
                    z4 = true;
                }
            }
            if (this.f2691I || this.f2734s) {
                invalidate();
            } else if ((i2 > 0 && i3 == 0) || (signum < 0.0f && f3 == 0.0f)) {
                m1569k(enumC0713i);
            }
            if ((!this.f2691I && this.f2734s && i2 > 0 && i3 == 0) || (signum < 0.0f && f3 == 0.0f)) {
                m1572h();
            }
        }
        float f4 = this.f2730o;
        if (f4 >= 1.0f) {
            int i7 = this.f2715f;
            int i8 = this.f2717g;
            z3 = i7 == i8 ? z4 : true;
            this.f2715f = i8;
        } else {
            if (f4 <= 0.0f) {
                int i9 = this.f2715f;
                int i10 = this.f2712d;
                z3 = i9 == i10 ? z4 : true;
                this.f2715f = i10;
            }
            this.f2720h0 |= z4;
            if (z4 && !this.f2713d0) {
                requestLayout();
            }
            this.f2729n = this.f2730o;
        }
        z4 = z3;
        this.f2720h0 |= z4;
        if (z4) {
            requestLayout();
        }
        this.f2729n = this.f2730o;
    }

    /* renamed from: c */
    public final void m1577c() {
        ArrayList<InterfaceC0712h> arrayList;
        if ((this.f2735t == null && ((arrayList = this.f2694L) == null || arrayList.isEmpty())) || this.f2699Q == this.f2729n) {
            return;
        }
        if (this.f2698P != -1) {
            InterfaceC0712h interfaceC0712h = this.f2735t;
            if (interfaceC0712h != null) {
                interfaceC0712h.mo1549b(this, this.f2712d, this.f2717g);
            }
            ArrayList<InterfaceC0712h> arrayList2 = this.f2694L;
            if (arrayList2 != null) {
                Iterator<InterfaceC0712h> it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next().mo1549b(this, this.f2712d, this.f2717g);
                }
            }
        }
        this.f2698P = -1;
        float f = this.f2729n;
        this.f2699Q = f;
        InterfaceC0712h interfaceC0712h2 = this.f2735t;
        if (interfaceC0712h2 != null) {
            interfaceC0712h2.mo1550a(this, this.f2712d, this.f2717g, f);
        }
        ArrayList<InterfaceC0712h> arrayList3 = this.f2694L;
        if (arrayList3 != null) {
            Iterator<InterfaceC0712h> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().mo1550a(this, this.f2712d, this.f2717g, this.f2729n);
            }
        }
    }

    /* renamed from: d */
    public void m1576d() {
        int i;
        ArrayList<InterfaceC0712h> arrayList;
        if ((this.f2735t != null || ((arrayList = this.f2694L) != null && !arrayList.isEmpty())) && this.f2698P == -1) {
            this.f2698P = this.f2715f;
            if (this.f2726k0.isEmpty()) {
                i = -1;
            } else {
                ArrayList<Integer> arrayList2 = this.f2726k0;
                i = arrayList2.get(arrayList2.size() - 1).intValue();
            }
            int i2 = this.f2715f;
            if (i != i2 && i2 != -1) {
                this.f2726k0.add(Integer.valueOf(i2));
            }
        }
        m1571i();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033b  */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispatchDraw(android.graphics.Canvas r28) {
        /*
            Method dump skipped, instructions count: 1145
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    /* renamed from: e */
    public void m1575e(int i, float f, float f2, float f3, float[] fArr) {
        String resourceName;
        HashMap<View, C0585Z1> hashMap = this.f2725k;
        View viewById = getViewById(i);
        C0585Z1 c0585z1 = hashMap.get(viewById);
        if (c0585z1 != null) {
            c0585z1.m1753b(f, f2, f3, fArr);
            float y = viewById.getY();
            this.f2736u = f;
            this.f2737v = y;
            return;
        }
        if (viewById == null) {
            resourceName = outline.m273H("", i);
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    /* renamed from: f */
    public final boolean m1574f(float f, float f2, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (m1574f(view.getLeft() + f, view.getTop() + f2, viewGroup.getChildAt(i), motionEvent)) {
                    return true;
                }
            }
        }
        this.f2722i0.set(view.getLeft() + f, view.getTop() + f2, f + view.getRight(), f2 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.f2722i0.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public final void m1573g(AttributeSet attributeSet) {
        C0982c2 c0982c2;
        String sb;
        f2682l0 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.MotionLayout_layoutDescription) {
                    this.f2706a = new C0982c2(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == C0533W2.MotionLayout_currentState) {
                    this.f2715f = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == C0533W2.MotionLayout_motionProgress) {
                    this.f2732q = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f2734s = true;
                } else if (index == C0533W2.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == C0533W2.MotionLayout_showPaths) {
                    if (this.f2738w == 0) {
                        this.f2738w = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == C0533W2.MotionLayout_motionDebug) {
                    this.f2738w = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f2706a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.f2706a = null;
            }
        }
        if (this.f2738w != 0) {
            C0982c2 c0982c22 = this.f2706a;
            if (c0982c22 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int m1134i = c0982c22.m1134i();
                C0982c2 c0982c23 = this.f2706a;
                C0445T2 m1141b = c0982c23.m1141b(c0982c23.m1134i());
                String m2674D = LayoutInflater$Factory2C0000A.C0010h.m2674D(getContext(), m1134i);
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    int id = childAt.getId();
                    if (id == -1) {
                        StringBuilder m251t = outline.m251t("CHECK: ", m2674D, " ALL VIEWS SHOULD HAVE ID's ");
                        m251t.append(childAt.getClass().getName());
                        m251t.append(" does not!");
                        Log.w("MotionLayout", m251t.toString());
                    }
                    if ((m1141b.f1455c.containsKey(Integer.valueOf(id)) ? m1141b.f1455c.get(Integer.valueOf(id)) : null) == null) {
                        StringBuilder m251t2 = outline.m251t("CHECK: ", m2674D, " NO CONSTRAINTS for ");
                        m251t2.append(LayoutInflater$Factory2C0000A.C0010h.m2673E(childAt));
                        Log.w("MotionLayout", m251t2.toString());
                    }
                }
                Integer[] numArr = (Integer[]) m1141b.f1455c.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = numArr[i3].intValue();
                }
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    String m2674D2 = LayoutInflater$Factory2C0000A.C0010h.m2674D(getContext(), i5);
                    if (findViewById(iArr[i4]) == null) {
                        Log.w("MotionLayout", "CHECK: " + m2674D + " NO View matches id " + m2674D2);
                    }
                    if (m1141b.m2025h(i5).f1459d.f1495d == -1) {
                        Log.w("MotionLayout", "CHECK: " + m2674D + "(" + m2674D2 + ") no LAYOUT_HEIGHT");
                    }
                    if (m1141b.m2025h(i5).f1459d.f1493c == -1) {
                        Log.w("MotionLayout", "CHECK: " + m2674D + "(" + m2674D2 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator<C0982c2.C0984b> it = this.f2706a.f3752d.iterator();
                while (it.hasNext()) {
                    C0982c2.C0984b next = it.next();
                    if (next == this.f2706a.f3751c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    StringBuilder m253r = outline.m253r("CHECK: transition = ");
                    Context context = getContext();
                    String resourceEntryName = next.f3771d == -1 ? "null" : context.getResources().getResourceEntryName(next.f3771d);
                    if (next.f3770c == -1) {
                        sb = outline.m266e(resourceEntryName, " -> null");
                    } else {
                        StringBuilder m252s = outline.m252s(resourceEntryName, " -> ");
                        m252s.append(context.getResources().getResourceEntryName(next.f3770c));
                        sb = m252s.toString();
                    }
                    m253r.append(sb);
                    Log.v("MotionLayout", m253r.toString());
                    Log.v("MotionLayout", "CHECK: transition.setDuration = " + next.f3775h);
                    if (next.f3771d == next.f3770c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i6 = next.f3771d;
                    int i7 = next.f3770c;
                    String m2674D3 = LayoutInflater$Factory2C0000A.C0010h.m2674D(getContext(), i6);
                    String m2674D4 = LayoutInflater$Factory2C0000A.C0010h.m2674D(getContext(), i7);
                    if (sparseIntArray.get(i6) == i7) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + m2674D3 + "->" + m2674D4);
                    }
                    if (sparseIntArray2.get(i7) == i6) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + m2674D3 + "->" + m2674D4);
                    }
                    sparseIntArray.put(i6, i7);
                    sparseIntArray2.put(i7, i6);
                    if (this.f2706a.m1141b(i6) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + m2674D3);
                    }
                    if (this.f2706a.m1141b(i7) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + m2674D3);
                    }
                }
            }
        }
        if (this.f2715f != -1 || (c0982c2 = this.f2706a) == null) {
            return;
        }
        this.f2715f = c0982c2.m1134i();
        this.f2712d = this.f2706a.m1134i();
        this.f2717g = this.f2706a.m1139d();
    }

    /* renamed from: h */
    public void m1572h() {
        C0982c2.C0984b c0984b;
        C1853h2 c1853h2;
        View view;
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 == null) {
            return;
        }
        if (c0982c2.m1142a(this, this.f2715f)) {
            requestLayout();
            return;
        }
        int i = this.f2715f;
        if (i != -1) {
            C0982c2 c0982c22 = this.f2706a;
            Iterator<C0982c2.C0984b> it = c0982c22.f3752d.iterator();
            while (it.hasNext()) {
                C0982c2.C0984b next = it.next();
                if (next.f3780m.size() > 0) {
                    Iterator<C0982c2.C0984b.View$OnClickListenerC0985a> it2 = next.f3780m.iterator();
                    while (it2.hasNext()) {
                        it2.next().m1125b(this);
                    }
                }
            }
            Iterator<C0982c2.C0984b> it3 = c0982c22.f3754f.iterator();
            while (it3.hasNext()) {
                C0982c2.C0984b next2 = it3.next();
                if (next2.f3780m.size() > 0) {
                    Iterator<C0982c2.C0984b.View$OnClickListenerC0985a> it4 = next2.f3780m.iterator();
                    while (it4.hasNext()) {
                        it4.next().m1125b(this);
                    }
                }
            }
            Iterator<C0982c2.C0984b> it5 = c0982c22.f3752d.iterator();
            while (it5.hasNext()) {
                C0982c2.C0984b next3 = it5.next();
                if (next3.f3780m.size() > 0) {
                    Iterator<C0982c2.C0984b.View$OnClickListenerC0985a> it6 = next3.f3780m.iterator();
                    while (it6.hasNext()) {
                        it6.next().m1126a(this, i, next3);
                    }
                }
            }
            Iterator<C0982c2.C0984b> it7 = c0982c22.f3754f.iterator();
            while (it7.hasNext()) {
                C0982c2.C0984b next4 = it7.next();
                if (next4.f3780m.size() > 0) {
                    Iterator<C0982c2.C0984b.View$OnClickListenerC0985a> it8 = next4.f3780m.iterator();
                    while (it8.hasNext()) {
                        it8.next().m1126a(this, i, next4);
                    }
                }
            }
        }
        if (!this.f2706a.m1127p() || (c0984b = this.f2706a.f3751c) == null || (c1853h2 = c0984b.f3779l) == null) {
            return;
        }
        int i2 = c1853h2.f5119d;
        if (i2 != -1) {
            view = c1853h2.f5130o.findViewById(i2);
            if (view == null) {
                StringBuilder m253r = outline.m253r("cannot find TouchAnchorId @id/");
                m253r.append(LayoutInflater$Factory2C0000A.C0010h.m2674D(c1853h2.f5130o.getContext(), c1853h2.f5119d));
                Log.e("TouchResponse", m253r.toString());
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View$OnTouchListenerC1674f2(c1853h2));
            nestedScrollView.setOnScrollChangeListener(new C1833g2(c1853h2));
        }
    }

    /* renamed from: i */
    public final void m1571i() {
        ArrayList<InterfaceC0712h> arrayList;
        if (this.f2735t == null && ((arrayList = this.f2694L) == null || arrayList.isEmpty())) {
            return;
        }
        Iterator<Integer> it = this.f2726k0.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            InterfaceC0712h interfaceC0712h = this.f2735t;
            if (interfaceC0712h != null) {
                interfaceC0712h.mo1547d(this, next.intValue());
            }
            ArrayList<InterfaceC0712h> arrayList2 = this.f2694L;
            if (arrayList2 != null) {
                Iterator<InterfaceC0712h> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().mo1547d(this, next.intValue());
                }
            }
        }
        this.f2726k0.clear();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    /* renamed from: j */
    public void m1570j() {
        this.f2718g0.m1553e();
        invalidate();
    }

    /* renamed from: k */
    public void m1569k(EnumC0713i enumC0713i) {
        EnumC0713i enumC0713i2 = EnumC0713i.FINISHED;
        if (enumC0713i == enumC0713i2 && this.f2715f == -1) {
            return;
        }
        EnumC0713i enumC0713i3 = this.f2716f0;
        this.f2716f0 = enumC0713i;
        EnumC0713i enumC0713i4 = EnumC0713i.MOVING;
        if (enumC0713i3 == enumC0713i4 && enumC0713i == enumC0713i4) {
            m1577c();
        }
        int ordinal = enumC0713i3.ordinal();
        if (ordinal != 0 && ordinal != 1) {
            if (ordinal == 2 && enumC0713i == enumC0713i2) {
                m1576d();
                return;
            }
            return;
        }
        if (enumC0713i == enumC0713i4) {
            m1577c();
        }
        if (enumC0713i == enumC0713i2) {
            m1576d();
        }
    }

    /* renamed from: l */
    public void m1568l(C0982c2.C0984b c0984b) {
        C1853h2 c1853h2;
        C0982c2 c0982c2 = this.f2706a;
        c0982c2.f3751c = c0984b;
        if (c0984b != null && (c1853h2 = c0984b.f3779l) != null) {
            c1853h2.m784b(c0982c2.f3764p);
        }
        m1569k(EnumC0713i.SETUP);
        if (this.f2715f == this.f2706a.m1139d()) {
            this.f2730o = 1.0f;
            this.f2729n = 1.0f;
            this.f2732q = 1.0f;
        } else {
            this.f2730o = 0.0f;
            this.f2729n = 0.0f;
            this.f2732q = 0.0f;
        }
        this.f2731p = (c0984b.f3785r & 1) != 0 ? -1L : System.nanoTime();
        int m1134i = this.f2706a.m1134i();
        int m1139d = this.f2706a.m1139d();
        if (m1134i == this.f2712d && m1139d == this.f2717g) {
            return;
        }
        this.f2712d = m1134i;
        this.f2717g = m1139d;
        this.f2706a.m1128o(m1134i, m1139d);
        this.f2718g0.m1554d(this.f2706a.m1141b(this.f2712d), this.f2706a.m1141b(this.f2717g));
        C0708d c0708d = this.f2718g0;
        int i = this.f2712d;
        int i2 = this.f2717g;
        c0708d.f2766e = i;
        c0708d.f2767f = i2;
        c0708d.m1553e();
        m1570j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.f2706a = new C0982c2(getContext(), this, i);
                if (isAttachedToWindow()) {
                    this.f2706a.m1130m(this);
                    this.f2718g0.m1554d(this.f2706a.m1141b(this.f2712d), this.f2706a.m1141b(this.f2717g));
                    m1570j();
                    this.f2706a.m1129n(isRtl());
                    return;
                }
                return;
            } catch (Exception e) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e);
            }
        }
        this.f2706a = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        if ((((r15 * r6) - (((r1 * r6) * r6) / 2.0f)) + r13) > 1.0f) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        if ((((((r1 * r3) * r3) / 2.0f) + (r15 * r3)) + r13) < 0.0f) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (r0 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        r13 = r12.f2683A;
        r14 = r12.f2730o;
        r0 = r12.f2706a.m1135h();
        r13.f2743a = r15;
        r13.f2744b = r14;
        r13.f2745c = r0;
        r12.f2708b = r12.f2683A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
        r5 = r12.f2741z;
        r6 = r12.f2730o;
        r9 = r12.f2728m;
        r10 = r12.f2706a.m1135h();
        r13 = r12.f2706a.f3751c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
        if (r13 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
        r13 = r13.f3779l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
        if (r13 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        r11 = r13.f5131p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
        r11 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        r5.m2206b(r6, r14, r15, r9, r10, r11);
        r12.f2710c = 0.0f;
        r13 = r12.f2715f;
        r12.f2732q = r14;
        r12.f2715f = r13;
        r12.f2708b = r12.f2741z;
     */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1567m(int r13, float r14, float r15) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.m1567m(int, float, float):void");
    }

    /* renamed from: n */
    public void m1566n(int i) {
        C0550X2 c0550x2;
        if (!isAttachedToWindow()) {
            if (this.f2714e0 == null) {
                this.f2714e0 = new C0711g();
            }
            this.f2714e0.f2774d = i;
            return;
        }
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null && (c0550x2 = c0982c2.f3750b) != null) {
            int i2 = this.f2715f;
            float f = -1;
            C0550X2.C0551a c0551a = c0550x2.f1978b.get(i);
            if (c0551a == null) {
                i2 = i;
            } else {
                int i3 = (f > (-1.0f) ? 1 : (f == (-1.0f) ? 0 : -1));
                if (i3 != 0 && i3 != 0) {
                    Iterator<C0550X2.C0552b> it = c0551a.f1980b.iterator();
                    C0550X2.C0552b c0552b = null;
                    while (true) {
                        if (it.hasNext()) {
                            C0550X2.C0552b next = it.next();
                            if (next.m1810a(f, f)) {
                                if (i2 == next.f1986e) {
                                    break;
                                }
                                c0552b = next;
                            }
                        } else {
                            i2 = c0552b != null ? c0552b.f1986e : c0551a.f1981c;
                        }
                    }
                } else if (c0551a.f1981c != i2) {
                    Iterator<C0550X2.C0552b> it2 = c0551a.f1980b.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (i2 == it2.next().f1986e) {
                                break;
                            }
                        } else {
                            i2 = c0551a.f1981c;
                            break;
                        }
                    }
                }
            }
            if (i2 != -1) {
                i = i2;
            }
        }
        int i4 = this.f2715f;
        if (i4 == i) {
            return;
        }
        if (this.f2712d == i) {
            m1579a(0.0f);
        } else if (this.f2717g == i) {
            m1579a(1.0f);
        } else {
            this.f2717g = i;
            if (i4 != -1) {
                setTransition(i4, i);
                m1579a(1.0f);
                this.f2730o = 0.0f;
                m1579a(1.0f);
                return;
            }
            this.f2740y = false;
            this.f2732q = 1.0f;
            this.f2729n = 0.0f;
            this.f2730o = 0.0f;
            this.f2731p = System.nanoTime();
            this.f2727l = System.nanoTime();
            this.f2733r = false;
            this.f2708b = null;
            this.f2728m = this.f2706a.m1140c() / 1000.0f;
            this.f2712d = -1;
            this.f2706a.m1128o(-1, this.f2717g);
            this.f2706a.m1134i();
            int childCount = getChildCount();
            this.f2725k.clear();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                this.f2725k.put(childAt, new C0585Z1(childAt));
            }
            this.f2734s = true;
            this.f2718g0.m1554d(null, this.f2706a.m1141b(i));
            m1570j();
            this.f2718g0.m1557a();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                C0585Z1 c0585z1 = this.f2725k.get(childAt2);
                if (c0585z1 != null) {
                    C0955b2 c0955b2 = c0585z1.f2075d;
                    c0955b2.f3665c = 0.0f;
                    c0955b2.f3666d = 0.0f;
                    c0955b2.m1192d(childAt2.getX(), childAt2.getY(), childAt2.getWidth(), childAt2.getHeight());
                    C0568Y1 c0568y1 = c0585z1.f2077f;
                    Objects.requireNonNull(c0568y1);
                    childAt2.getX();
                    childAt2.getY();
                    childAt2.getWidth();
                    childAt2.getHeight();
                    c0568y1.f2025c = childAt2.getVisibility();
                    c0568y1.f2023a = childAt2.getVisibility() != 0 ? 0.0f : childAt2.getAlpha();
                    c0568y1.f2026d = childAt2.getElevation();
                    c0568y1.f2027f = childAt2.getRotation();
                    c0568y1.f2028g = childAt2.getRotationX();
                    c0568y1.f2029h = childAt2.getRotationY();
                    c0568y1.f2030i = childAt2.getScaleX();
                    c0568y1.f2031j = childAt2.getScaleY();
                    c0568y1.f2032k = childAt2.getPivotX();
                    c0568y1.f2033l = childAt2.getPivotY();
                    c0568y1.f2034m = childAt2.getTranslationX();
                    c0568y1.f2035n = childAt2.getTranslationY();
                    c0568y1.f2036o = childAt2.getTranslationZ();
                }
            }
            int width = getWidth();
            int height = getHeight();
            for (int i7 = 0; i7 < childCount; i7++) {
                C0585Z1 c0585z12 = this.f2725k.get(getChildAt(i7));
                this.f2706a.m1136g(c0585z12);
                c0585z12.m1750e(width, height, System.nanoTime());
            }
            C0982c2.C0984b c0984b = this.f2706a.f3751c;
            float f2 = c0984b != null ? c0984b.f3776i : 0.0f;
            if (f2 != 0.0f) {
                float f3 = Float.MAX_VALUE;
                float f4 = -3.4028235E38f;
                for (int i8 = 0; i8 < childCount; i8++) {
                    C0955b2 c0955b22 = this.f2725k.get(getChildAt(i8)).f2076e;
                    float f5 = c0955b22.f3668g + c0955b22.f3667f;
                    f3 = Math.min(f3, f5);
                    f4 = Math.max(f4, f5);
                }
                for (int i9 = 0; i9 < childCount; i9++) {
                    C0585Z1 c0585z13 = this.f2725k.get(getChildAt(i9));
                    C0955b2 c0955b23 = c0585z13.f2076e;
                    float f6 = c0955b23.f3667f;
                    float f7 = c0955b23.f3668g;
                    c0585z13.f2083l = 1.0f / (1.0f - f2);
                    c0585z13.f2082k = f2 - ((((f6 + f7) - f3) * f2) / (f4 - f3));
                }
            }
            this.f2729n = 0.0f;
            this.f2730o = 0.0f;
            this.f2734s = true;
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null && (i = this.f2715f) != -1) {
            C0445T2 m1141b = c0982c2.m1141b(i);
            this.f2706a.m1130m(this);
            if (m1141b != null) {
                m1141b.m2030c(this, true);
                setConstraintSet(null);
                requestLayout();
            }
            this.f2712d = this.f2715f;
        }
        m1572h();
        C0711g c0711g = this.f2714e0;
        if (c0711g != null) {
            c0711g.m1551a();
        } else if (this.f2706a.f3751c.f3781n == 4) {
            m1579a(1.0f);
            m1569k(EnumC0713i.SETUP);
            m1569k(EnumC0713i.MOVING);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C0982c2.C0984b c0984b;
        C1853h2 c1853h2;
        int i;
        RectF m785a;
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null && this.f2723j && (c0984b = c0982c2.f3751c) != null && (!c0984b.f3782o) && (c1853h2 = c0984b.f3779l) != null && ((motionEvent.getAction() != 0 || (m785a = c1853h2.m785a(this, new RectF())) == null || m785a.contains(motionEvent.getX(), motionEvent.getY())) && (i = c1853h2.f5120e) != -1)) {
            View view = this.f2724j0;
            if (view == null || view.getId() != i) {
                this.f2724j0 = findViewById(i);
            }
            View view2 = this.f2724j0;
            if (view2 != null) {
                this.f2722i0.set(view2.getLeft(), this.f2724j0.getTop(), this.f2724j0.getRight(), this.f2724j0.getBottom());
                if (this.f2722i0.contains(motionEvent.getX(), motionEvent.getY()) && !m1574f(0.0f, 0.0f, this.f2724j0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2713d0 = true;
        try {
            if (this.f2706a == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.f2684B != i5 || this.f2685C != i6) {
                m1570j();
                m1578b(true);
            }
            this.f2684B = i5;
            this.f2685C = i6;
        } finally {
            this.f2713d0 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (((r6 == r3.f2766e && r7 == r3.f2767f) ? false : true) != false) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        C0982c2.C0984b c0984b;
        boolean z;
        C1853h2 c1853h2;
        float f;
        float f2;
        C1853h2 c1853h22;
        C1853h2 c1853h23;
        int i4;
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 == null || (c0984b = c0982c2.f3751c) == null || !(!c0984b.f3782o)) {
            return;
        }
        if (!z || (c1853h23 = c0984b.f3779l) == null || (i4 = c1853h23.f5120e) == -1 || view.getId() == i4) {
            C0982c2 c0982c22 = this.f2706a;
            if (c0982c22 != null) {
                C0982c2.C0984b c0984b2 = c0982c22.f3751c;
                if ((c0984b2 == null || (c1853h22 = c0984b2.f3779l) == null) ? false : c1853h22.f5133r) {
                    float f3 = this.f2729n;
                    if ((f3 == 1.0f || f3 == 0.0f) && view.canScrollVertically(-1)) {
                        return;
                    }
                }
            }
            if (c0984b.f3779l != null) {
                C1853h2 c1853h24 = this.f2706a.f3751c.f3779l;
                if ((c1853h24.f5135t & 1) != 0) {
                    float f4 = i;
                    float f5 = i2;
                    MotionLayout motionLayout = c1853h24.f5130o;
                    motionLayout.m1575e(c1853h24.f5119d, motionLayout.f2730o, c1853h24.f5123h, c1853h24.f5122g, c1853h24.f5127l);
                    float f6 = c1853h24.f5124i;
                    if (f6 != 0.0f) {
                        float[] fArr = c1853h24.f5127l;
                        if (fArr[0] == 0.0f) {
                            fArr[0] = 1.0E-7f;
                        }
                        f2 = (f4 * f6) / fArr[0];
                    } else {
                        float[] fArr2 = c1853h24.f5127l;
                        if (fArr2[1] == 0.0f) {
                            fArr2[1] = 1.0E-7f;
                        }
                        f2 = (f5 * c1853h24.f5125j) / fArr2[1];
                    }
                    float f7 = this.f2730o;
                    if ((f7 <= 0.0f && f2 < 0.0f) || (f7 >= 1.0f && f2 > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new RunnableC0705a(this, view));
                        return;
                    }
                }
            }
            float f8 = this.f2729n;
            long nanoTime = System.nanoTime();
            float f9 = i;
            this.f2687E = f9;
            float f10 = i2;
            this.f2688F = f10;
            this.f2690H = (float) ((nanoTime - this.f2689G) * 1.0E-9d);
            this.f2689G = nanoTime;
            C0982c2.C0984b c0984b3 = this.f2706a.f3751c;
            if (c0984b3 != null && (c1853h2 = c0984b3.f3779l) != null) {
                MotionLayout motionLayout2 = c1853h2.f5130o;
                float f11 = motionLayout2.f2730o;
                if (!c1853h2.f5126k) {
                    c1853h2.f5126k = true;
                    motionLayout2.setProgress(f11);
                }
                c1853h2.f5130o.m1575e(c1853h2.f5119d, f11, c1853h2.f5123h, c1853h2.f5122g, c1853h2.f5127l);
                float f12 = c1853h2.f5124i;
                float[] fArr3 = c1853h2.f5127l;
                if (Math.abs((c1853h2.f5125j * fArr3[1]) + (f12 * fArr3[0])) < 0.01d) {
                    float[] fArr4 = c1853h2.f5127l;
                    fArr4[0] = 0.01f;
                    fArr4[1] = 0.01f;
                }
                float f13 = c1853h2.f5124i;
                if (f13 != 0.0f) {
                    f = (f9 * f13) / c1853h2.f5127l[0];
                } else {
                    f = (f10 * c1853h2.f5125j) / c1853h2.f5127l[1];
                }
                float max = Math.max(Math.min(f11 + f, 1.0f), 0.0f);
                MotionLayout motionLayout3 = c1853h2.f5130o;
                if (max != motionLayout3.f2730o) {
                    motionLayout3.setProgress(max);
                }
            }
            if (f8 != this.f2729n) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            m1578b(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f2686D = true;
        }
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // p000.InterfaceC0287M4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.f2686D || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.f2686D = false;
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null) {
            c0982c2.m1129n(isRtl());
        }
    }

    @Override // p000.InterfaceC0267L4
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        C0982c2.C0984b c0984b;
        C1853h2 c1853h2;
        C0982c2 c0982c2 = this.f2706a;
        return (c0982c2 == null || (c0984b = c0982c2.f3751c) == null || (c1853h2 = c0984b.f3779l) == null || (c1853h2.f5135t & 2) != 0) ? false : true;
    }

    @Override // p000.InterfaceC0267L4
    public void onStopNestedScroll(View view, int i) {
        C1853h2 c1853h2;
        float f;
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 == null) {
            return;
        }
        float f2 = this.f2687E;
        float f3 = this.f2690H;
        float f4 = f2 / f3;
        float f5 = this.f2688F / f3;
        C0982c2.C0984b c0984b = c0982c2.f3751c;
        if (c0984b == null || (c1853h2 = c0984b.f3779l) == null) {
            return;
        }
        c1853h2.f5126k = false;
        MotionLayout motionLayout = c1853h2.f5130o;
        float f6 = motionLayout.f2730o;
        motionLayout.m1575e(c1853h2.f5119d, f6, c1853h2.f5123h, c1853h2.f5122g, c1853h2.f5127l);
        float f7 = c1853h2.f5124i;
        float[] fArr = c1853h2.f5127l;
        float f8 = fArr[0];
        float f9 = c1853h2.f5125j;
        float f10 = fArr[1];
        if (f7 != 0.0f) {
            f = (f4 * f7) / fArr[0];
        } else {
            f = (f5 * f9) / fArr[1];
        }
        if (!Float.isNaN(f)) {
            f6 += f / 3.0f;
        }
        if (f6 != 0.0f) {
            boolean z = f6 != 1.0f;
            int i2 = c1853h2.f5118c;
            if ((i2 != 3) && z) {
                c1853h2.f5130o.m1567m(i2, ((double) f6) >= 0.5d ? 1.0f : 0.0f, f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0982c2.C0984b c0984b;
        InterfaceC0709e interfaceC0709e;
        C1853h2 c1853h2;
        char c;
        char c2;
        float f;
        int i;
        float f2;
        char c3;
        char c4;
        char c5;
        char c6;
        float f3;
        RectF rectF;
        View findViewById;
        MotionEvent motionEvent2;
        C0982c2.C0984b c0984b2;
        int i2;
        C1853h2 c1853h22;
        RectF m785a;
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null && this.f2723j && c0982c2.m1127p()) {
            C0982c2 c0982c22 = this.f2706a;
            if (c0982c22.f3751c != null && !(!c0984b.f3782o)) {
                return super.onTouchEvent(motionEvent);
            }
            int i3 = this.f2715f;
            Objects.requireNonNull(c0982c22);
            RectF rectF2 = new RectF();
            if (c0982c22.f3763o == null) {
                Objects.requireNonNull(c0982c22.f3749a);
                C0710f.f2769b.f2770a = VelocityTracker.obtain();
                c0982c22.f3763o = C0710f.f2769b;
            }
            VelocityTracker velocityTracker = ((C0710f) c0982c22.f3763o).f2770a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (i3 != -1) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 2 && !c0982c22.f3761m) {
                        float rawY = motionEvent.getRawY() - c0982c22.f3766r;
                        float rawX = motionEvent.getRawX() - c0982c22.f3765q;
                        if ((rawX == ShadowDrawableWrapper.COS_45 && rawY == ShadowDrawableWrapper.COS_45) || (motionEvent2 = c0982c22.f3760l) == null) {
                            return true;
                        }
                        if (i3 != -1) {
                            C0550X2 c0550x2 = c0982c22.f3750b;
                            if (c0550x2 == null || (i2 = c0550x2.m1812a(i3, -1, -1)) == -1) {
                                i2 = i3;
                            }
                            ArrayList arrayList = new ArrayList();
                            Iterator<C0982c2.C0984b> it = c0982c22.f3752d.iterator();
                            while (it.hasNext()) {
                                C0982c2.C0984b next = it.next();
                                if (next.f3771d == i2 || next.f3770c == i2) {
                                    arrayList.add(next);
                                }
                            }
                            RectF rectF3 = new RectF();
                            Iterator it2 = arrayList.iterator();
                            float f4 = 0.0f;
                            c0984b2 = null;
                            while (it2.hasNext()) {
                                C0982c2.C0984b c0984b3 = (C0982c2.C0984b) it2.next();
                                if (!c0984b3.f3782o && (c1853h22 = c0984b3.f3779l) != null) {
                                    c1853h22.m784b(c0982c22.f3764p);
                                    RectF m785a2 = c0984b3.f3779l.m785a(c0982c22.f3749a, rectF3);
                                    if ((m785a2 == null || m785a2.contains(motionEvent2.getX(), motionEvent2.getY())) && ((m785a = c0984b3.f3779l.m785a(c0982c22.f3749a, rectF3)) == null || m785a.contains(motionEvent2.getX(), motionEvent2.getY()))) {
                                        C1853h2 c1853h23 = c0984b3.f3779l;
                                        float f5 = ((c1853h23.f5125j * rawY) + (c1853h23.f5124i * rawX)) * (c0984b3.f3770c == i3 ? -1.0f : 1.1f);
                                        if (f5 > f4) {
                                            f4 = f5;
                                            c0984b2 = c0984b3;
                                        }
                                    }
                                }
                            }
                        } else {
                            c0984b2 = c0982c22.f3751c;
                        }
                        if (c0984b2 != null) {
                            m1568l(c0984b2);
                            RectF m785a3 = c0982c22.f3751c.f3779l.m785a(c0982c22.f3749a, rectF2);
                            c0982c22.f3762n = (m785a3 == null || m785a3.contains(c0982c22.f3760l.getX(), c0982c22.f3760l.getY())) ? false : true;
                            C1853h2 c1853h24 = c0982c22.f3751c.f3779l;
                            float f6 = c0982c22.f3765q;
                            float f7 = c0982c22.f3766r;
                            c1853h24.f5128m = f6;
                            c1853h24.f5129n = f7;
                            c1853h24.f5126k = false;
                        }
                    }
                } else {
                    c0982c22.f3765q = motionEvent.getRawX();
                    c0982c22.f3766r = motionEvent.getRawY();
                    c0982c22.f3760l = motionEvent;
                    c0982c22.f3761m = false;
                    C1853h2 c1853h25 = c0982c22.f3751c.f3779l;
                    if (c1853h25 != null) {
                        MotionLayout motionLayout = c0982c22.f3749a;
                        int i4 = c1853h25.f5121f;
                        if (i4 == -1 || (findViewById = motionLayout.findViewById(i4)) == null) {
                            rectF = null;
                        } else {
                            rectF2.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
                            rectF = rectF2;
                        }
                        if (rectF != null && !rectF.contains(c0982c22.f3760l.getX(), c0982c22.f3760l.getY())) {
                            c0982c22.f3760l = null;
                            c0982c22.f3761m = true;
                            return true;
                        }
                        RectF m785a4 = c0982c22.f3751c.f3779l.m785a(c0982c22.f3749a, rectF2);
                        if (m785a4 != null && !m785a4.contains(c0982c22.f3760l.getX(), c0982c22.f3760l.getY())) {
                            c0982c22.f3762n = true;
                        } else {
                            c0982c22.f3762n = false;
                        }
                        C1853h2 c1853h26 = c0982c22.f3751c.f3779l;
                        float f8 = c0982c22.f3765q;
                        float f9 = c0982c22.f3766r;
                        c1853h26.f5128m = f8;
                        c1853h26.f5129n = f9;
                        return true;
                    }
                    return true;
                }
            }
            if (c0982c22.f3761m) {
                return true;
            }
            C0982c2.C0984b c0984b4 = c0982c22.f3751c;
            if (c0984b4 != null && (c1853h2 = c0984b4.f3779l) != null && !c0982c22.f3762n) {
                InterfaceC0709e interfaceC0709e2 = c0982c22.f3763o;
                EnumC0713i enumC0713i = EnumC0713i.FINISHED;
                C0710f c0710f = (C0710f) interfaceC0709e2;
                VelocityTracker velocityTracker2 = c0710f.f2770a;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    c1853h2.f5128m = motionEvent.getRawX();
                    c1853h2.f5129n = motionEvent.getRawY();
                    c1853h2.f5126k = false;
                } else if (action2 == 1) {
                    c1853h2.f5126k = false;
                    c0710f.f2770a.computeCurrentVelocity(1000);
                    float xVelocity = c0710f.f2770a.getXVelocity();
                    float yVelocity = c0710f.f2770a.getYVelocity();
                    MotionLayout motionLayout2 = c1853h2.f5130o;
                    float f10 = motionLayout2.f2730o;
                    int i5 = c1853h2.f5119d;
                    if (i5 != -1) {
                        motionLayout2.m1575e(i5, f10, c1853h2.f5123h, c1853h2.f5122g, c1853h2.f5127l);
                        c2 = 0;
                        c = 1;
                    } else {
                        float min = Math.min(motionLayout2.getWidth(), c1853h2.f5130o.getHeight());
                        float[] fArr = c1853h2.f5127l;
                        c = 1;
                        fArr[1] = c1853h2.f5125j * min;
                        c2 = 0;
                        fArr[0] = min * c1853h2.f5124i;
                    }
                    float f11 = c1853h2.f5124i;
                    float[] fArr2 = c1853h2.f5127l;
                    float f12 = fArr2[c2];
                    float f13 = fArr2[c];
                    if (f11 != 0.0f) {
                        f = xVelocity / fArr2[c2];
                    } else {
                        f = yVelocity / fArr2[c];
                    }
                    float f14 = !Float.isNaN(f) ? (f / 3.0f) + f10 : f10;
                    if (f14 != 0.0f && f14 != 1.0f && (i = c1853h2.f5118c) != 3) {
                        c1853h2.f5130o.m1567m(i, ((double) f14) < 0.5d ? 0.0f : 1.0f, f);
                        if (0.0f >= f10 || 1.0f <= f10) {
                            c1853h2.f5130o.m1569k(enumC0713i);
                        }
                    } else if (0.0f >= f14 || 1.0f <= f14) {
                        c1853h2.f5130o.m1569k(enumC0713i);
                    }
                } else if (action2 == 2) {
                    float rawY2 = motionEvent.getRawY() - c1853h2.f5129n;
                    float rawX2 = motionEvent.getRawX() - c1853h2.f5128m;
                    if (Math.abs((c1853h2.f5125j * rawY2) + (c1853h2.f5124i * rawX2)) > c1853h2.f5136u || c1853h2.f5126k) {
                        MotionLayout motionLayout3 = c1853h2.f5130o;
                        float f15 = motionLayout3.f2730o;
                        if (!c1853h2.f5126k) {
                            c1853h2.f5126k = true;
                            motionLayout3.setProgress(f15);
                        }
                        int i6 = c1853h2.f5119d;
                        if (i6 != -1) {
                            f2 = f15;
                            c1853h2.f5130o.m1575e(i6, f15, c1853h2.f5123h, c1853h2.f5122g, c1853h2.f5127l);
                            c4 = 0;
                            c3 = 1;
                        } else {
                            f2 = f15;
                            float min2 = Math.min(c1853h2.f5130o.getWidth(), c1853h2.f5130o.getHeight());
                            float[] fArr3 = c1853h2.f5127l;
                            c3 = 1;
                            fArr3[1] = c1853h2.f5125j * min2;
                            c4 = 0;
                            fArr3[0] = min2 * c1853h2.f5124i;
                        }
                        float f16 = c1853h2.f5124i;
                        float[] fArr4 = c1853h2.f5127l;
                        if (Math.abs(((c1853h2.f5125j * fArr4[c3]) + (f16 * fArr4[c4])) * c1853h2.f5134s) < 0.01d) {
                            float[] fArr5 = c1853h2.f5127l;
                            c5 = 0;
                            fArr5[0] = 0.01f;
                            c6 = 1;
                            fArr5[1] = 0.01f;
                        } else {
                            c5 = 0;
                            c6 = 1;
                        }
                        if (c1853h2.f5124i != 0.0f) {
                            f3 = rawX2 / c1853h2.f5127l[c5];
                        } else {
                            f3 = rawY2 / c1853h2.f5127l[c6];
                        }
                        float max = Math.max(Math.min(f2 + f3, 1.0f), 0.0f);
                        MotionLayout motionLayout4 = c1853h2.f5130o;
                        if (max != motionLayout4.f2730o) {
                            motionLayout4.setProgress(max);
                            c0710f.f2770a.computeCurrentVelocity(1000);
                            c1853h2.f5130o.f2710c = c1853h2.f5124i != 0.0f ? c0710f.f2770a.getXVelocity() / c1853h2.f5127l[0] : c0710f.f2770a.getYVelocity() / c1853h2.f5127l[1];
                        } else {
                            motionLayout4.f2710c = 0.0f;
                        }
                        c1853h2.f5128m = motionEvent.getRawX();
                        c1853h2.f5129n = motionEvent.getRawY();
                    }
                }
            }
            c0982c22.f3765q = motionEvent.getRawX();
            c0982c22.f3766r = motionEvent.getRawY();
            if (motionEvent.getAction() != 1 || (interfaceC0709e = c0982c22.f3763o) == null) {
                return true;
            }
            C0710f c0710f2 = (C0710f) interfaceC0709e;
            c0710f2.f2770a.recycle();
            c0710f2.f2770a = null;
            c0982c22.f3763o = null;
            int i7 = this.f2715f;
            if (i7 != -1) {
                c0982c22.m1142a(this, i7);
                return true;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f2694L == null) {
                this.f2694L = new ArrayList<>();
            }
            this.f2694L.add(motionHelper);
            if (motionHelper.f2679i) {
                if (this.f2692J == null) {
                    this.f2692J = new ArrayList<>();
                }
                this.f2692J.add(motionHelper);
            }
            if (motionHelper.f2680j) {
                if (this.f2693K == null) {
                    this.f2693K = new ArrayList<>();
                }
                this.f2693K.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f2692J;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f2693K;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        C0982c2 c0982c2;
        C0982c2.C0984b c0984b;
        if (this.f2700R || this.f2715f != -1 || (c0982c2 = this.f2706a) == null || (c0984b = c0982c2.f3751c) == null || c0984b.f3784q != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i) {
        this.f2738w = i;
        invalidate();
    }

    public void setInteractionEnabled(boolean z) {
        this.f2723j = z;
    }

    public void setInterpolatedProgress(float f) {
        if (this.f2706a != null) {
            m1569k(EnumC0713i.MOVING);
            Interpolator m1137f = this.f2706a.m1137f();
            if (m1137f != null) {
                setProgress(m1137f.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.f2693K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2693K.get(i).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.f2692J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2692J.get(i).setProgress(f);
            }
        }
    }

    public void setProgress(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.f2714e0 == null) {
                this.f2714e0 = new C0711g();
            }
            C0711g c0711g = this.f2714e0;
            c0711g.f2771a = f;
            c0711g.f2772b = f2;
            return;
        }
        setProgress(f);
        m1569k(EnumC0713i.MOVING);
        this.f2710c = f2;
        m1579a(1.0f);
    }

    public void setScene(C0982c2 c0982c2) {
        this.f2706a = c0982c2;
        c0982c2.m1129n(isRtl());
        m1570j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        m1569k(EnumC0713i.SETUP);
        this.f2715f = i;
        this.f2712d = -1;
        this.f2717g = -1;
        C0427S2 c0427s2 = this.mConstraintLayoutSpec;
        if (c0427s2 != null) {
            c0427s2.m2039b(i, i2, i3);
            return;
        }
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null) {
            c0982c2.m1141b(i).m2030c(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.f2714e0 == null) {
                this.f2714e0 = new C0711g();
            }
            C0711g c0711g = this.f2714e0;
            c0711g.f2773c = i;
            c0711g.f2774d = i2;
            return;
        }
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null) {
            this.f2712d = i;
            this.f2717g = i2;
            c0982c2.m1128o(i, i2);
            this.f2718g0.m1554d(this.f2706a.m1141b(i), this.f2706a.m1141b(i2));
            m1570j();
            this.f2730o = 0.0f;
            m1579a(0.0f);
        }
    }

    public void setTransitionDuration(int i) {
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        C0982c2.C0984b c0984b = c0982c2.f3751c;
        if (c0984b != null) {
            c0984b.f3775h = i;
        } else {
            c0982c2.f3758j = i;
        }
    }

    public void setTransitionListener(InterfaceC0712h interfaceC0712h) {
        this.f2735t = interfaceC0712h;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f2714e0 == null) {
            this.f2714e0 = new C0711g();
        }
        C0711g c0711g = this.f2714e0;
        Objects.requireNonNull(c0711g);
        c0711g.f2771a = bundle.getFloat("motion.progress");
        c0711g.f2772b = bundle.getFloat("motion.velocity");
        c0711g.f2773c = bundle.getInt("motion.StartState");
        c0711g.f2774d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.f2714e0.m1551a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return LayoutInflater$Factory2C0000A.C0010h.m2674D(context, this.f2712d) + "->" + LayoutInflater$Factory2C0000A.C0010h.m2674D(context, this.f2717g) + " (pos:" + this.f2730o + " Dpos/Dt:" + this.f2710c;
    }

    public void setProgress(float f) {
        EnumC0713i enumC0713i = EnumC0713i.FINISHED;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i < 0 || f > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f2714e0 == null) {
                this.f2714e0 = new C0711g();
            }
            this.f2714e0.f2771a = f;
            return;
        }
        if (i <= 0) {
            this.f2715f = this.f2712d;
            if (this.f2730o == 0.0f) {
                m1569k(enumC0713i);
            }
        } else if (f >= 1.0f) {
            this.f2715f = this.f2717g;
            if (this.f2730o == 1.0f) {
                m1569k(enumC0713i);
            }
        } else {
            this.f2715f = -1;
            m1569k(EnumC0713i.MOVING);
        }
        if (this.f2706a == null) {
            return;
        }
        this.f2733r = true;
        this.f2732q = f;
        this.f2729n = f;
        this.f2731p = -1L;
        this.f2727l = -1L;
        this.f2708b = null;
        this.f2734s = true;
        invalidate();
    }

    public void setTransition(int i) {
        C0982c2.C0984b c0984b;
        C0982c2 c0982c2 = this.f2706a;
        if (c0982c2 != null) {
            Iterator<C0982c2.C0984b> it = c0982c2.f3752d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0984b = null;
                    break;
                }
                c0984b = it.next();
                if (c0984b.f3768a == i) {
                    break;
                }
            }
            this.f2712d = c0984b.f3771d;
            this.f2717g = c0984b.f3770c;
            if (!isAttachedToWindow()) {
                if (this.f2714e0 == null) {
                    this.f2714e0 = new C0711g();
                }
                C0711g c0711g = this.f2714e0;
                c0711g.f2773c = this.f2712d;
                c0711g.f2774d = this.f2717g;
                return;
            }
            float f = Float.NaN;
            int i2 = this.f2715f;
            if (i2 == this.f2712d) {
                f = 0.0f;
            } else if (i2 == this.f2717g) {
                f = 1.0f;
            }
            C0982c2 c0982c22 = this.f2706a;
            c0982c22.f3751c = c0984b;
            C1853h2 c1853h2 = c0984b.f3779l;
            if (c1853h2 != null) {
                c1853h2.m784b(c0982c22.f3764p);
            }
            this.f2718g0.m1554d(this.f2706a.m1141b(this.f2712d), this.f2706a.m1141b(this.f2717g));
            m1570j();
            this.f2730o = Float.isNaN(f) ? 0.0f : f;
            if (Float.isNaN(f)) {
                Log.v("MotionLayout", LayoutInflater$Factory2C0000A.C0010h.m2675C() + " transitionToStart ");
                m1579a(0.0f);
                return;
            }
            setProgress(f);
        }
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2710c = 0.0f;
        this.f2712d = -1;
        this.f2715f = -1;
        this.f2717g = -1;
        this.f2719h = 0;
        this.f2721i = 0;
        this.f2723j = true;
        this.f2725k = new HashMap<>();
        this.f2727l = 0L;
        this.f2728m = 1.0f;
        this.f2729n = 0.0f;
        this.f2730o = 0.0f;
        this.f2732q = 0.0f;
        this.f2734s = false;
        this.f2738w = 0;
        this.f2740y = false;
        this.f2741z = new C0284M1();
        this.f2683A = new C0706b();
        this.f2686D = false;
        this.f2691I = false;
        this.f2692J = null;
        this.f2693K = null;
        this.f2694L = null;
        this.f2695M = 0;
        this.f2696N = -1L;
        this.f2697O = 0.0f;
        this.f2698P = 0;
        this.f2699Q = 0.0f;
        this.f2700R = false;
        this.f2711c0 = new C0366Q1();
        this.f2713d0 = false;
        this.f2716f0 = EnumC0713i.UNDEFINED;
        this.f2718g0 = new C0708d();
        this.f2720h0 = false;
        this.f2722i0 = new RectF();
        this.f2724j0 = null;
        this.f2726k0 = new ArrayList<>();
        m1573g(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2710c = 0.0f;
        this.f2712d = -1;
        this.f2715f = -1;
        this.f2717g = -1;
        this.f2719h = 0;
        this.f2721i = 0;
        this.f2723j = true;
        this.f2725k = new HashMap<>();
        this.f2727l = 0L;
        this.f2728m = 1.0f;
        this.f2729n = 0.0f;
        this.f2730o = 0.0f;
        this.f2732q = 0.0f;
        this.f2734s = false;
        this.f2738w = 0;
        this.f2740y = false;
        this.f2741z = new C0284M1();
        this.f2683A = new C0706b();
        this.f2686D = false;
        this.f2691I = false;
        this.f2692J = null;
        this.f2693K = null;
        this.f2694L = null;
        this.f2695M = 0;
        this.f2696N = -1L;
        this.f2697O = 0.0f;
        this.f2698P = 0;
        this.f2699Q = 0.0f;
        this.f2700R = false;
        this.f2711c0 = new C0366Q1();
        this.f2713d0 = false;
        this.f2716f0 = EnumC0713i.UNDEFINED;
        this.f2718g0 = new C0708d();
        this.f2720h0 = false;
        this.f2722i0 = new RectF();
        this.f2724j0 = null;
        this.f2726k0 = new ArrayList<>();
        m1573g(attributeSet);
    }
}
