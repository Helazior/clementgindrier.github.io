package p000;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: S1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0410S1 {

    /* renamed from: a */
    public C0414d f1368a;

    /* renamed from: b */
    public C0393R2 f1369b;

    /* renamed from: c */
    public String f1370c;

    /* renamed from: d */
    public int f1371d = 0;

    /* renamed from: e */
    public int f1372e = 0;

    /* renamed from: f */
    public ArrayList<C0426p> f1373f = new ArrayList<>();

    /* renamed from: S1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0411a implements Comparator<C0426p> {
        public C0411a(AbstractC0410S1 abstractC0410S1) {
        }

        @Override // java.util.Comparator
        public int compare(C0426p c0426p, C0426p c0426p2) {
            return Integer.compare(c0426p.f1384a, c0426p2.f1384a);
        }
    }

    /* renamed from: S1$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0412b extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setAlpha(m2044a(f));
        }
    }

    /* renamed from: S1$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0413c extends AbstractC0410S1 {

        /* renamed from: g */
        public float[] f1374g = new float[1];

        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            this.f1374g[0] = m2044a(f);
            this.f1369b.m2048g(view, this.f1374g);
        }
    }

    /* renamed from: S1$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0414d {

        /* renamed from: a */
        public C0264L1 f1375a = new C0264L1();

        /* renamed from: b */
        public float[] f1376b;

        /* renamed from: c */
        public double[] f1377c;

        /* renamed from: d */
        public float[] f1378d;

        /* renamed from: e */
        public float[] f1379e;

        /* renamed from: f */
        public AbstractC0166H1 f1380f;

        /* renamed from: g */
        public double[] f1381g;

        /* renamed from: h */
        public double[] f1382h;

        public C0414d(int i, int i2, int i3) {
            new HashMap();
            this.f1375a.f885d = i;
            this.f1376b = new float[i3];
            this.f1377c = new double[i3];
            this.f1378d = new float[i3];
            this.f1379e = new float[i3];
            float[] fArr = new float[i3];
        }
    }

    /* renamed from: S1$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0415e extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setElevation(m2044a(f));
        }
    }

    /* renamed from: S1$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0416f extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
        }
    }

    /* renamed from: S1$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0417g extends AbstractC0410S1 {

        /* renamed from: g */
        public boolean f1383g = false;

        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(m2044a(f));
            } else if (this.f1383g) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f1383g = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(m2044a(f)));
                    } catch (IllegalAccessException e) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    /* renamed from: S1$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0418h extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setRotation(m2044a(f));
        }
    }

    /* renamed from: S1$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0419i extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setRotationX(m2044a(f));
        }
    }

    /* renamed from: S1$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0420j extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setRotationY(m2044a(f));
        }
    }

    /* renamed from: S1$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0421k extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setScaleX(m2044a(f));
        }
    }

    /* renamed from: S1$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0422l extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setScaleY(m2044a(f));
        }
    }

    /* renamed from: S1$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0423m extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setTranslationX(m2044a(f));
        }
    }

    /* renamed from: S1$n */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0424n extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setTranslationY(m2044a(f));
        }
    }

    /* renamed from: S1$o */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0425o extends AbstractC0410S1 {
        @Override // p000.AbstractC0410S1
        /* renamed from: c */
        public void mo2041c(View view, float f) {
            view.setTranslationZ(m2044a(f));
        }
    }

    /* renamed from: S1$p */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0426p {

        /* renamed from: a */
        public int f1384a;

        /* renamed from: b */
        public float f1385b;

        /* renamed from: c */
        public float f1386c;

        /* renamed from: d */
        public float f1387d;

        public C0426p(int i, float f, float f2, float f3) {
            this.f1384a = i;
            this.f1385b = f3;
            this.f1386c = f2;
            this.f1387d = f;
        }
    }

    /* renamed from: a */
    public float m2044a(float f) {
        C0414d c0414d = this.f1368a;
        AbstractC0166H1 abstractC0166H1 = c0414d.f1380f;
        if (abstractC0166H1 != null) {
            abstractC0166H1.mo2354c(f, c0414d.f1381g);
        } else {
            double[] dArr = c0414d.f1381g;
            dArr[0] = c0414d.f1379e[0];
            dArr[1] = c0414d.f1376b[0];
        }
        return (float) ((c0414d.f1375a.m2222d(f) * c0414d.f1381g[1]) + c0414d.f1381g[0]);
    }

    /* renamed from: b */
    public float m2043b(float f) {
        double m2224b;
        double signum;
        double m2224b2;
        C0414d c0414d = this.f1368a;
        AbstractC0166H1 abstractC0166H1 = c0414d.f1380f;
        double d = ShadowDrawableWrapper.COS_45;
        if (abstractC0166H1 != null) {
            double d2 = f;
            abstractC0166H1.mo2351f(d2, c0414d.f1382h);
            c0414d.f1380f.mo2354c(d2, c0414d.f1381g);
        } else {
            double[] dArr = c0414d.f1382h;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        double d3 = f;
        double m2222d = c0414d.f1375a.m2222d(d3);
        C0264L1 c0264l1 = c0414d.f1375a;
        double d4 = 2.0d;
        switch (c0264l1.f885d) {
            case 1:
                double[] dArr2 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr2[1]) + dArr2[0]);
            case 2:
                m2224b = c0264l1.m2224b(d3) * 4.0d;
                signum = Math.signum((((c0264l1.m2223c(d3) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                d = m2224b * signum;
                double[] dArr22 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr22[1]) + dArr22[0]);
            case 3:
                m2224b2 = c0264l1.m2224b(d3);
                d = m2224b2 * d4;
                double[] dArr222 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr222[1]) + dArr222[0]);
            case 4:
                m2224b2 = -c0264l1.m2224b(d3);
                d = m2224b2 * d4;
                double[] dArr2222 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr2222[1]) + dArr2222[0]);
            case 5:
                d4 = c0264l1.m2224b(d3) * (-6.283185307179586d);
                m2224b2 = Math.sin(c0264l1.m2223c(d3) * 6.283185307179586d);
                d = m2224b2 * d4;
                double[] dArr22222 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr22222[1]) + dArr22222[0]);
            case 6:
                m2224b = c0264l1.m2224b(d3) * 4.0d;
                signum = (((c0264l1.m2223c(d3) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                d = m2224b * signum;
                double[] dArr222222 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr222222[1]) + dArr222222[0]);
            default:
                m2224b = c0264l1.m2224b(d3) * 6.283185307179586d;
                signum = Math.cos(c0264l1.m2223c(d3) * 6.283185307179586d);
                d = m2224b * signum;
                double[] dArr2222222 = c0414d.f1382h;
                return (float) ((d * c0414d.f1381g[1]) + (m2222d * dArr2222222[1]) + dArr2222222[0]);
        }
    }

    /* renamed from: c */
    public abstract void mo2041c(View view, float f);

    @TargetApi(19)
    /* renamed from: d */
    public void m2042d(float f) {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i;
        int i2;
        float[] fArr4;
        int size = this.f1373f.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f1373f, new C0411a(this));
        double[] dArr = new double[size];
        char c = 1;
        char c2 = 0;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, 2);
        this.f1368a = new C0414d(this.f1371d, this.f1372e, size);
        Iterator<C0426p> it = this.f1373f.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            C0426p next = it.next();
            float f2 = next.f1387d;
            dArr[i3] = f2 * 0.01d;
            double[] dArr3 = dArr2[i3];
            float f3 = next.f1385b;
            dArr3[c2] = f3;
            double[] dArr4 = dArr2[i3];
            float f4 = next.f1386c;
            dArr4[c] = f4;
            C0414d c0414d = this.f1368a;
            c0414d.f1377c[i3] = next.f1384a / 100.0d;
            c0414d.f1378d[i3] = f2;
            c0414d.f1379e[i3] = f4;
            c0414d.f1376b[i3] = f3;
            i3++;
            c = 1;
            c2 = 0;
        }
        C0414d c0414d2 = this.f1368a;
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, c0414d2.f1377c.length, 2);
        float[] fArr5 = c0414d2.f1376b;
        c0414d2.f1381g = new double[fArr5.length + 1];
        c0414d2.f1382h = new double[fArr5.length + 1];
        if (c0414d2.f1377c[0] > ShadowDrawableWrapper.COS_45) {
            c0414d2.f1375a.m2225a(ShadowDrawableWrapper.COS_45, c0414d2.f1378d[0]);
        }
        double[] dArr6 = c0414d2.f1377c;
        int length = dArr6.length - 1;
        if (dArr6[length] < 1.0d) {
            c0414d2.f1375a.m2225a(1.0d, c0414d2.f1378d[length]);
        }
        for (int i4 = 0; i4 < dArr5.length; i4++) {
            dArr5[i4][0] = c0414d2.f1379e[i4];
            int i5 = 0;
            while (true) {
                if (i5 < c0414d2.f1376b.length) {
                    dArr5[i5][1] = fArr4[i5];
                    i5++;
                }
            }
            c0414d2.f1375a.m2225a(c0414d2.f1377c[i4], c0414d2.f1378d[i4]);
        }
        C0264L1 c0264l1 = c0414d2.f1375a;
        double d = 0.0d;
        int i6 = 0;
        while (true) {
            if (i6 >= c0264l1.f882a.length) {
                break;
            }
            d += fArr[i6];
            i6++;
        }
        double d2 = 0.0d;
        int i7 = 1;
        while (true) {
            if (i7 >= c0264l1.f882a.length) {
                break;
            }
            double[] dArr7 = c0264l1.f883b;
            d2 = ((dArr7[i7] - dArr7[i7 - 1]) * ((fArr2[i2] + fArr2[i7]) / 2.0f)) + d2;
            i7++;
        }
        int i8 = 0;
        while (true) {
            float[] fArr6 = c0264l1.f882a;
            if (i8 >= fArr6.length) {
                break;
            }
            fArr6[i8] = (float) (fArr6[i8] * (d / d2));
            i8++;
        }
        c0264l1.f884c[0] = 0.0d;
        int i9 = 1;
        while (true) {
            if (i9 >= c0264l1.f882a.length) {
                break;
            }
            int i10 = i9 - 1;
            double[] dArr8 = c0264l1.f883b;
            double d3 = dArr8[i9] - dArr8[i10];
            double[] dArr9 = c0264l1.f884c;
            dArr9[i9] = (d3 * ((fArr3[i10] + fArr3[i9]) / 2.0f)) + dArr9[i10];
            i9++;
        }
        double[] dArr10 = c0414d2.f1377c;
        if (dArr10.length > 1) {
            i = 0;
            c0414d2.f1380f = AbstractC0166H1.m2414a(0, dArr10, dArr5);
        } else {
            i = 0;
            c0414d2.f1380f = null;
        }
        AbstractC0166H1.m2414a(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.f1370c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<C0426p> it = this.f1373f.iterator();
        while (it.hasNext()) {
            C0426p next = it.next();
            StringBuilder m252s = outline.m252s(str, "[");
            m252s.append(next.f1384a);
            m252s.append(" , ");
            m252s.append(decimalFormat.format(next.f1385b));
            m252s.append("] ");
            str = m252s.toString();
        }
        return str;
    }
}
