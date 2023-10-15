package p000;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: e2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1638e2 {

    /* renamed from: a */
    public AbstractC0166H1 f4120a;

    /* renamed from: e */
    public int f4124e;

    /* renamed from: f */
    public String f4125f;

    /* renamed from: i */
    public long f4128i;

    /* renamed from: b */
    public int f4121b = 0;

    /* renamed from: c */
    public int[] f4122c = new int[10];

    /* renamed from: d */
    public float[][] f4123d = (float[][]) Array.newInstance(float.class, 10, 3);

    /* renamed from: g */
    public float[] f4126g = new float[3];

    /* renamed from: h */
    public boolean f4127h = false;

    /* renamed from: j */
    public float f4129j = Float.NaN;

    /* renamed from: e2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1639a extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setAlpha(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1640b extends AbstractC1638e2 {

        /* renamed from: k */
        public String f4130k;

        /* renamed from: l */
        public SparseArray<C0393R2> f4131l;

        /* renamed from: m */
        public SparseArray<float[]> f4132m = new SparseArray<>();

        /* renamed from: n */
        public float[] f4133n;

        /* renamed from: o */
        public float[] f4134o;

        public C1640b(String str, SparseArray<C0393R2> sparseArray) {
            this.f4130k = str.split(",")[1];
            this.f4131l = sparseArray;
        }

        @Override // p000.AbstractC1638e2
        /* renamed from: c */
        public void mo1000c(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            this.f4120a.mo2353d(f, this.f4133n);
            float[] fArr = this.f4133n;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.f4128i;
            if (Float.isNaN(this.f4129j)) {
                float m2142a = c0366q1.m2142a(view, this.f4130k, 0);
                this.f4129j = m2142a;
                if (Float.isNaN(m2142a)) {
                    this.f4129j = 0.0f;
                }
            }
            float f4 = (float) ((((j2 * 1.0E-9d) * f2) + this.f4129j) % 1.0d);
            this.f4129j = f4;
            this.f4128i = j;
            float m1002a = m1002a(f4);
            this.f4127h = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.f4134o;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z = this.f4127h;
                float[] fArr3 = this.f4133n;
                this.f4127h = z | (((double) fArr3[i]) != ShadowDrawableWrapper.COS_45);
                fArr2[i] = (fArr3[i] * m1002a) + f3;
                i++;
            }
            this.f4131l.valueAt(0).m2048g(view, this.f4134o);
            if (f2 != 0.0f) {
                this.f4127h = true;
            }
            return this.f4127h;
        }

        @Override // p000.AbstractC1638e2
        /* renamed from: e */
        public void mo999e(int i) {
            int size = this.f4131l.size();
            int m2051d = this.f4131l.valueAt(0).m2051d();
            double[] dArr = new double[size];
            int i2 = m2051d + 2;
            this.f4133n = new float[i2];
            this.f4134o = new float[m2051d];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.f4131l.keyAt(i3);
                float[] valueAt = this.f4132m.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                this.f4131l.valueAt(i3).m2052c(this.f4133n);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f4133n;
                    if (i4 < fArr.length) {
                        dArr2[i3][i4] = fArr[i4];
                        i4++;
                    }
                }
                dArr2[i3][m2051d] = valueAt[0];
                dArr2[i3][m2051d + 1] = valueAt[1];
            }
            this.f4120a = AbstractC0166H1.m2414a(i, dArr, dArr2);
        }
    }

    /* renamed from: e2$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1641c extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setElevation(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1642d extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            return this.f4127h;
        }
    }

    /* renamed from: e2$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1643e extends AbstractC1638e2 {

        /* renamed from: k */
        public boolean f4135k = false;

        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(m1001b(f, j, view, c0366q1));
            } else if (this.f4135k) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f4135k = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(m1001b(f, j, view, c0366q1)));
                    } catch (IllegalAccessException e) {
                        Log.e("SplineSet", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    }
                }
            }
            return this.f4127h;
        }
    }

    /* renamed from: e2$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1644f extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setRotation(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1645g extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setRotationX(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1646h extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setRotationY(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1647i extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setScaleX(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1648j extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setScaleY(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1649k extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setTranslationX(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1650l extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setTranslationY(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: e2$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1651m extends AbstractC1638e2 {
        @Override // p000.AbstractC1638e2
        /* renamed from: d */
        public boolean mo998d(View view, float f, long j, C0366Q1 c0366q1) {
            view.setTranslationZ(m1001b(f, j, view, c0366q1));
            return this.f4127h;
        }
    }

    /* renamed from: a */
    public float m1002a(float f) {
        float abs;
        switch (this.f4121b) {
            case 1:
                return Math.signum(f * 6.2831855f);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f * 6.2831855f);
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f * 6.2831855f);
        }
        return 1.0f - abs;
    }

    /* renamed from: b */
    public float m1001b(float f, long j, View view, C0366Q1 c0366q1) {
        this.f4120a.mo2353d(f, this.f4126g);
        float[] fArr = this.f4126g;
        boolean z = true;
        float f2 = fArr[1];
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i == 0) {
            this.f4127h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f4129j)) {
            float m2142a = c0366q1.m2142a(view, this.f4125f, 0);
            this.f4129j = m2142a;
            if (Float.isNaN(m2142a)) {
                this.f4129j = 0.0f;
            }
        }
        float f3 = (float) (((((j - this.f4128i) * 1.0E-9d) * f2) + this.f4129j) % 1.0d);
        this.f4129j = f3;
        String str = this.f4125f;
        if (!c0366q1.f1247a.containsKey(view)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            hashMap.put(str, new float[]{f3});
            c0366q1.f1247a.put(view, hashMap);
        } else {
            HashMap<String, float[]> hashMap2 = c0366q1.f1247a.get(view);
            if (!hashMap2.containsKey(str)) {
                hashMap2.put(str, new float[]{f3});
                c0366q1.f1247a.put(view, hashMap2);
            } else {
                float[] fArr2 = hashMap2.get(str);
                if (fArr2.length <= 0) {
                    fArr2 = Arrays.copyOf(fArr2, 1);
                }
                fArr2[0] = f3;
                hashMap2.put(str, fArr2);
            }
        }
        this.f4128i = j;
        float f4 = this.f4126g[0];
        float m1002a = (m1002a(this.f4129j) * f4) + this.f4126g[2];
        if (f4 == 0.0f && i == 0) {
            z = false;
        }
        this.f4127h = z;
        return m1002a;
    }

    /* renamed from: c */
    public void mo1000c(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.f4122c;
        int i3 = this.f4124e;
        iArr[i3] = i;
        float[][] fArr = this.f4123d;
        fArr[i3][0] = f;
        fArr[i3][1] = f2;
        fArr[i3][2] = f3;
        this.f4121b = Math.max(this.f4121b, i2);
        this.f4124e++;
    }

    /* renamed from: d */
    public abstract boolean mo998d(View view, float f, long j, C0366Q1 c0366q1);

    /* renamed from: e */
    public void mo999e(int i) {
        int i2;
        int i3 = this.f4124e;
        if (i3 == 0) {
            StringBuilder m253r = outline.m253r("Error no points added to ");
            m253r.append(this.f4125f);
            Log.e("SplineSet", m253r.toString());
            return;
        }
        int[] iArr = this.f4122c;
        float[][] fArr = this.f4123d;
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i3 - 1;
        iArr2[1] = 0;
        int i4 = 2;
        while (i4 > 0) {
            int i5 = i4 - 1;
            int i6 = iArr2[i5];
            i4 = i5 - 1;
            int i7 = iArr2[i4];
            if (i6 < i7) {
                int i8 = iArr[i7];
                int i9 = i6;
                int i10 = i9;
                while (i9 < i7) {
                    if (iArr[i9] <= i8) {
                        int i11 = iArr[i10];
                        iArr[i10] = iArr[i9];
                        iArr[i9] = i11;
                        float[] fArr2 = fArr[i10];
                        fArr[i10] = fArr[i9];
                        fArr[i9] = fArr2;
                        i10++;
                    }
                    i9++;
                }
                int i12 = iArr[i10];
                iArr[i10] = iArr[i7];
                iArr[i7] = i12;
                float[] fArr3 = fArr[i10];
                fArr[i10] = fArr[i7];
                fArr[i7] = fArr3;
                int i13 = i4 + 1;
                iArr2[i4] = i10 - 1;
                int i14 = i13 + 1;
                iArr2[i13] = i6;
                int i15 = i14 + 1;
                iArr2[i14] = i7;
                i4 = i15 + 1;
                iArr2[i15] = i10 + 1;
            }
        }
        int i16 = 1;
        int i17 = 0;
        while (true) {
            int[] iArr3 = this.f4122c;
            if (i16 >= iArr3.length) {
                break;
            }
            if (iArr3[i16] != iArr3[i16 - 1]) {
                i17++;
            }
            i16++;
        }
        if (i17 == 0) {
            i17 = 1;
        }
        double[] dArr = new double[i17];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i17, 3);
        int i18 = 0;
        while (i2 < this.f4124e) {
            if (i2 > 0) {
                int[] iArr4 = this.f4122c;
                i2 = iArr4[i2] == iArr4[i2 + (-1)] ? i2 + 1 : 0;
            }
            dArr[i18] = this.f4122c[i2] * 0.01d;
            double[] dArr3 = dArr2[i18];
            float[][] fArr4 = this.f4123d;
            dArr3[0] = fArr4[i2][0];
            dArr2[i18][1] = fArr4[i2][1];
            dArr2[i18][2] = fArr4[i2][2];
            i18++;
        }
        this.f4120a = AbstractC0166H1.m2414a(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.f4125f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.f4124e; i++) {
            StringBuilder m252s = outline.m252s(str, "[");
            m252s.append(this.f4122c[i]);
            m252s.append(" , ");
            m252s.append(decimalFormat.format(this.f4123d[i]));
            m252s.append("] ");
            str = m252s.toString();
        }
        return str;
    }
}
