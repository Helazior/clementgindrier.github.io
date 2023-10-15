package p000;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;

/* renamed from: L1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0264L1 {

    /* renamed from: a */
    public float[] f882a = new float[0];

    /* renamed from: b */
    public double[] f883b = new double[0];

    /* renamed from: c */
    public double[] f884c;

    /* renamed from: d */
    public int f885d;

    /* renamed from: a */
    public void m2225a(double d, float f) {
        int length = this.f882a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f883b, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f883b = Arrays.copyOf(this.f883b, length);
        this.f882a = Arrays.copyOf(this.f882a, length);
        this.f884c = new double[length];
        double[] dArr = this.f883b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f883b[binarySearch] = d;
        this.f882a[binarySearch] = f;
    }

    /* renamed from: b */
    public double m2224b(double d) {
        if (d <= ShadowDrawableWrapper.COS_45) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f883b, d);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.f882a;
            int i2 = i - 1;
            double d2 = fArr[i] - fArr[i2];
            double[] dArr = this.f883b;
            double d3 = d2 / (dArr[i] - dArr[i2]);
            return (fArr[i2] - (d3 * dArr[i2])) + (d * d3);
        }
        return ShadowDrawableWrapper.COS_45;
    }

    /* renamed from: c */
    public double m2223c(double d) {
        if (d < ShadowDrawableWrapper.COS_45) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f883b, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.f882a;
            int i2 = i - 1;
            double d2 = fArr[i] - fArr[i2];
            double[] dArr = this.f883b;
            double d3 = d2 / (dArr[i] - dArr[i2]);
            return ((((d * d) - (dArr[i2] * dArr[i2])) * d3) / 2.0d) + ((d - dArr[i2]) * (fArr[i2] - (dArr[i2] * d3))) + this.f884c[i2];
        }
        return ShadowDrawableWrapper.COS_45;
    }

    /* renamed from: d */
    public double m2222d(double d) {
        double abs;
        switch (this.f885d) {
            case 1:
                return Math.signum(0.5d - (m2223c(d) % 1.0d));
            case 2:
                abs = Math.abs((((m2223c(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((m2223c(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((m2223c(d) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(m2223c(d) * 6.283185307179586d);
            case 6:
                double abs2 = 1.0d - Math.abs(((m2223c(d) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(m2223c(d) * 6.283185307179586d);
        }
        return 1.0d - abs;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("pos =");
        m253r.append(Arrays.toString(this.f883b));
        m253r.append(" period=");
        m253r.append(Arrays.toString(this.f882a));
        return m253r.toString();
    }
}
