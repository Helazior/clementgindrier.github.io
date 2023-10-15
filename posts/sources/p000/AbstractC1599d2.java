package p000;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* renamed from: d2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1599d2 {

    /* renamed from: a */
    public AbstractC0166H1 f3976a;

    /* renamed from: b */
    public int[] f3977b = new int[10];

    /* renamed from: c */
    public float[] f3978c = new float[10];

    /* renamed from: d */
    public int f3979d;

    /* renamed from: e */
    public String f3980e;

    /* renamed from: d2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1600a extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setAlpha((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1601b extends AbstractC1599d2 {

        /* renamed from: f */
        public SparseArray<C0393R2> f3981f;

        /* renamed from: g */
        public float[] f3982g;

        public C1601b(String str, SparseArray<C0393R2> sparseArray) {
            String str2 = str.split(",")[1];
            this.f3981f = sparseArray;
        }

        @Override // p000.AbstractC1599d2
        /* renamed from: b */
        public void mo1035b(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            this.f3976a.mo2353d(f, this.f3982g);
            this.f3981f.valueAt(0).m2048g(view, this.f3982g);
        }

        @Override // p000.AbstractC1599d2
        /* renamed from: d */
        public void mo1034d(int i) {
            int size = this.f3981f.size();
            int m2051d = this.f3981f.valueAt(0).m2051d();
            double[] dArr = new double[size];
            this.f3982g = new float[m2051d];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, m2051d);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = this.f3981f.keyAt(i2) * 0.01d;
                this.f3981f.valueAt(i2).m2052c(this.f3982g);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.f3982g;
                    if (i3 < fArr.length) {
                        dArr2[i2][i3] = fArr[i3];
                        i3++;
                    }
                }
            }
            this.f3976a = AbstractC0166H1.m2414a(i, dArr, dArr2);
        }
    }

    /* renamed from: d2$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1602c extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setElevation((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1603d extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
        }
    }

    /* renamed from: d2$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1604e extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setPivotX((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1605f extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setPivotY((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1606g extends AbstractC1599d2 {

        /* renamed from: f */
        public boolean f3983f = false;

        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress((float) this.f3976a.mo2355b(f, 0));
            } else if (this.f3983f) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f3983f = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf((float) this.f3976a.mo2355b(f, 0)));
                    } catch (IllegalAccessException e) {
                        Log.e("SplineSet", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    /* renamed from: d2$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1607h extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setRotation((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1608i extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setRotationX((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1609j extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setRotationY((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1610k extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setScaleX((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1611l extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setScaleY((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1612m extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setTranslationX((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$n */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1613n extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setTranslationY((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: d2$o */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1614o extends AbstractC1599d2 {
        @Override // p000.AbstractC1599d2
        /* renamed from: c */
        public void mo1033c(View view, float f) {
            view.setTranslationZ((float) this.f3976a.mo2355b(f, 0));
        }
    }

    /* renamed from: a */
    public float m1036a(float f) {
        return (float) this.f3976a.mo2355b(f, 0);
    }

    /* renamed from: b */
    public void mo1035b(int i, float f) {
        int[] iArr = this.f3977b;
        if (iArr.length < this.f3979d + 1) {
            this.f3977b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f3978c;
            this.f3978c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f3977b;
        int i2 = this.f3979d;
        iArr2[i2] = i;
        this.f3978c[i2] = f;
        this.f3979d = i2 + 1;
    }

    /* renamed from: c */
    public abstract void mo1033c(View view, float f);

    /* renamed from: d */
    public void mo1034d(int i) {
        int i2;
        int i3 = this.f3979d;
        if (i3 == 0) {
            return;
        }
        int[] iArr = this.f3977b;
        float[] fArr = this.f3978c;
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
                        float f = fArr[i10];
                        fArr[i10] = fArr[i9];
                        fArr[i9] = f;
                        i10++;
                    }
                    i9++;
                }
                int i12 = iArr[i10];
                iArr[i10] = iArr[i7];
                iArr[i7] = i12;
                float f2 = fArr[i10];
                fArr[i10] = fArr[i7];
                fArr[i7] = f2;
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
        for (int i17 = 1; i17 < this.f3979d; i17++) {
            int[] iArr3 = this.f3977b;
            if (iArr3[i17 - 1] != iArr3[i17]) {
                i16++;
            }
        }
        double[] dArr = new double[i16];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i16, 1);
        int i18 = 0;
        while (i2 < this.f3979d) {
            if (i2 > 0) {
                int[] iArr4 = this.f3977b;
                i2 = iArr4[i2] == iArr4[i2 + (-1)] ? i2 + 1 : 0;
            }
            dArr[i18] = this.f3977b[i2] * 0.01d;
            dArr2[i18][0] = this.f3978c[i2];
            i18++;
        }
        this.f3976a = AbstractC0166H1.m2414a(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.f3980e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.f3979d; i++) {
            StringBuilder m252s = outline.m252s(str, "[");
            m252s.append(this.f3977b[i]);
            m252s.append(" , ");
            m252s.append(decimalFormat.format(this.f3978c[i]));
            m252s.append("] ");
            str = m252s.toString();
        }
        return str;
    }
}
