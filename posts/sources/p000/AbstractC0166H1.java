package p000;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* renamed from: H1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0166H1 {

    /* renamed from: H1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0167a extends AbstractC0166H1 {

        /* renamed from: a */
        public double f538a;

        /* renamed from: b */
        public double[] f539b;

        public C0167a(double d, double[] dArr) {
            this.f538a = d;
            this.f539b = dArr;
        }

        @Override // p000.AbstractC0166H1
        /* renamed from: b */
        public double mo2355b(double d, int i) {
            return this.f539b[i];
        }

        @Override // p000.AbstractC0166H1
        /* renamed from: c */
        public void mo2354c(double d, double[] dArr) {
            double[] dArr2 = this.f539b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // p000.AbstractC0166H1
        /* renamed from: d */
        public void mo2353d(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.f539b;
                if (i >= dArr.length) {
                    return;
                }
                fArr[i] = (float) dArr[i];
                i++;
            }
        }

        @Override // p000.AbstractC0166H1
        /* renamed from: e */
        public double mo2352e(double d, int i) {
            return ShadowDrawableWrapper.COS_45;
        }

        @Override // p000.AbstractC0166H1
        /* renamed from: f */
        public void mo2351f(double d, double[] dArr) {
            for (int i = 0; i < this.f539b.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        @Override // p000.AbstractC0166H1
        /* renamed from: g */
        public double[] mo2350g() {
            return new double[]{this.f538a};
        }
    }

    /* renamed from: a */
    public static AbstractC0166H1 m2414a(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i != 0) {
            if (i != 2) {
                return new C0211J1(dArr, dArr2);
            }
            return new C0167a(dArr[0], dArr2[0]);
        }
        return new C0232K1(dArr, dArr2);
    }

    /* renamed from: b */
    public abstract double mo2355b(double d, int i);

    /* renamed from: c */
    public abstract void mo2354c(double d, double[] dArr);

    /* renamed from: d */
    public abstract void mo2353d(double d, float[] fArr);

    /* renamed from: e */
    public abstract double mo2352e(double d, int i);

    /* renamed from: f */
    public abstract void mo2351f(double d, double[] dArr);

    /* renamed from: g */
    public abstract double[] mo2350g();
}
