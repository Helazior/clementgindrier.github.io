package p000;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* renamed from: J1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0211J1 extends AbstractC0166H1 {

    /* renamed from: a */
    public double[] f675a;

    /* renamed from: b */
    public double[][] f676b;

    public C0211J1(double[] dArr, double[][] dArr2) {
        int length = dArr2[0].length;
        this.f675a = dArr;
        this.f676b = dArr2;
        if (length > 2) {
            double d = ShadowDrawableWrapper.COS_45;
            double d2 = 0.0d;
            int i = 0;
            while (i < dArr.length) {
                double d3 = dArr2[i][0];
                double d4 = dArr2[i][0];
                if (i > 0) {
                    Math.hypot(d3 - d, d4 - d2);
                }
                i++;
                d = d3;
                d2 = d4;
            }
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: b */
    public double mo2355b(double d, int i) {
        double[] dArr = this.f675a;
        int length = dArr.length;
        int i2 = 0;
        if (d <= dArr[0]) {
            return this.f676b[0][i];
        }
        int i3 = length - 1;
        if (d >= dArr[i3]) {
            return this.f676b[i3][i];
        }
        while (i2 < i3) {
            double[] dArr2 = this.f675a;
            if (d == dArr2[i2]) {
                return this.f676b[i2][i];
            }
            int i4 = i2 + 1;
            if (d < dArr2[i4]) {
                double d2 = (d - dArr2[i2]) / (dArr2[i4] - dArr2[i2]);
                double[][] dArr3 = this.f676b;
                return (dArr3[i4][i] * d2) + ((1.0d - d2) * dArr3[i2][i]);
            }
            i2 = i4;
        }
        return ShadowDrawableWrapper.COS_45;
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: c */
    public void mo2354c(double d, double[] dArr) {
        double[] dArr2 = this.f675a;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.f676b[0].length;
        if (d <= dArr2[0]) {
            for (int i2 = 0; i2 < length2; i2++) {
                dArr[i2] = this.f676b[0][i2];
            }
            return;
        }
        int i3 = length - 1;
        if (d >= dArr2[i3]) {
            while (i < length2) {
                dArr[i] = this.f676b[i3][i];
                i++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            if (d == this.f675a[i4]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.f676b[i4][i5];
                }
            }
            double[] dArr3 = this.f675a;
            int i6 = i4 + 1;
            if (d < dArr3[i6]) {
                double d2 = (d - dArr3[i4]) / (dArr3[i6] - dArr3[i4]);
                while (i < length2) {
                    double[][] dArr4 = this.f676b;
                    dArr[i] = (dArr4[i6][i] * d2) + ((1.0d - d2) * dArr4[i4][i]);
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: d */
    public void mo2353d(double d, float[] fArr) {
        double[] dArr = this.f675a;
        int length = dArr.length;
        int i = 0;
        int length2 = this.f676b[0].length;
        if (d <= dArr[0]) {
            for (int i2 = 0; i2 < length2; i2++) {
                fArr[i2] = (float) this.f676b[0][i2];
            }
            return;
        }
        int i3 = length - 1;
        if (d >= dArr[i3]) {
            while (i < length2) {
                fArr[i] = (float) this.f676b[i3][i];
                i++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            if (d == this.f675a[i4]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) this.f676b[i4][i5];
                }
            }
            double[] dArr2 = this.f675a;
            int i6 = i4 + 1;
            if (d < dArr2[i6]) {
                double d2 = (d - dArr2[i4]) / (dArr2[i6] - dArr2[i4]);
                while (i < length2) {
                    double[][] dArr3 = this.f676b;
                    fArr[i] = (float) ((dArr3[i6][i] * d2) + ((1.0d - d2) * dArr3[i4][i]));
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: e */
    public double mo2352e(double d, int i) {
        double[] dArr = this.f675a;
        int length = dArr.length;
        int i2 = 0;
        if (d < dArr[0]) {
            d = dArr[0];
        } else {
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                d = dArr[i3];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f675a;
            int i4 = i2 + 1;
            if (d <= dArr2[i4]) {
                double d2 = dArr2[i4] - dArr2[i2];
                double d3 = dArr2[i2];
                double[][] dArr3 = this.f676b;
                return (dArr3[i4][i] - dArr3[i2][i]) / d2;
            }
            i2 = i4;
        }
        return ShadowDrawableWrapper.COS_45;
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: f */
    public void mo2351f(double d, double[] dArr) {
        double[] dArr2 = this.f675a;
        int length = dArr2.length;
        int length2 = this.f676b[0].length;
        if (d <= dArr2[0]) {
            d = dArr2[0];
        } else {
            int i = length - 1;
            if (d >= dArr2[i]) {
                d = dArr2[i];
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.f675a;
            int i3 = i2 + 1;
            if (d <= dArr3[i3]) {
                double d2 = dArr3[i3] - dArr3[i2];
                double d3 = dArr3[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.f676b;
                    dArr[i4] = (dArr4[i3][i4] - dArr4[i2][i4]) / d2;
                }
                return;
            }
            i2 = i3;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: g */
    public double[] mo2350g() {
        return this.f675a;
    }
}
