package p000;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;

/* renamed from: G1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0144G1 extends AbstractC0166H1 {

    /* renamed from: a */
    public final double[] f466a;

    /* renamed from: b */
    public C0145a[] f467b;

    /* renamed from: G1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0145a {

        /* renamed from: s */
        public static double[] f468s = new double[91];

        /* renamed from: a */
        public double[] f469a;

        /* renamed from: b */
        public double f470b;

        /* renamed from: c */
        public double f471c;

        /* renamed from: d */
        public double f472d;

        /* renamed from: e */
        public double f473e;

        /* renamed from: f */
        public double f474f;

        /* renamed from: g */
        public double f475g;

        /* renamed from: h */
        public double f476h;

        /* renamed from: i */
        public double f477i;

        /* renamed from: j */
        public double f478j;

        /* renamed from: k */
        public double f479k;

        /* renamed from: l */
        public double f480l;

        /* renamed from: m */
        public double f481m;

        /* renamed from: n */
        public double f482n;

        /* renamed from: o */
        public double f483o;

        /* renamed from: p */
        public double f484p;

        /* renamed from: q */
        public boolean f485q;

        /* renamed from: r */
        public boolean f486r;

        public C0145a(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            double[] dArr;
            double[] dArr2;
            double d7 = d3;
            this.f486r = false;
            this.f485q = i == 1;
            this.f471c = d;
            this.f472d = d2;
            this.f477i = 1.0d / (d2 - d);
            if (3 == i) {
                this.f486r = true;
            }
            double d8 = d5 - d7;
            double d9 = d6 - d4;
            if (!this.f486r && Math.abs(d8) >= 0.001d && Math.abs(d9) >= 0.001d) {
                this.f469a = new double[101];
                boolean z = this.f485q;
                this.f478j = (z ? -1 : 1) * d8;
                this.f479k = d9 * (z ? 1 : -1);
                this.f480l = z ? d5 : d7;
                this.f481m = z ? d4 : d6;
                double d10 = d4 - d6;
                int i2 = 0;
                double d11 = ShadowDrawableWrapper.COS_45;
                double d12 = ShadowDrawableWrapper.COS_45;
                double d13 = ShadowDrawableWrapper.COS_45;
                while (true) {
                    if (i2 >= f468s.length) {
                        break;
                    }
                    double radians = Math.toRadians((i2 * 90.0d) / (dArr.length - 1));
                    double sin = Math.sin(radians) * d8;
                    double cos = Math.cos(radians) * d10;
                    if (i2 > 0) {
                        d11 += Math.hypot(sin - d12, cos - d13);
                        f468s[i2] = d11;
                    }
                    i2++;
                    d13 = cos;
                    d12 = sin;
                }
                this.f470b = d11;
                int i3 = 0;
                while (true) {
                    double[] dArr3 = f468s;
                    if (i3 >= dArr3.length) {
                        break;
                    }
                    dArr3[i3] = dArr3[i3] / d11;
                    i3++;
                }
                int i4 = 0;
                while (true) {
                    if (i4 < this.f469a.length) {
                        double length = i4 / (dArr2.length - 1);
                        int binarySearch = Arrays.binarySearch(f468s, length);
                        if (binarySearch >= 0) {
                            this.f469a[i4] = binarySearch / (f468s.length - 1);
                        } else if (binarySearch == -1) {
                            this.f469a[i4] = 0.0d;
                        } else {
                            int i5 = -binarySearch;
                            int i6 = i5 - 2;
                            double[] dArr4 = f468s;
                            this.f469a[i4] = (((length - dArr4[i6]) / (dArr4[i5 - 1] - dArr4[i6])) + i6) / (dArr4.length - 1);
                        }
                        i4++;
                    } else {
                        this.f482n = this.f470b * this.f477i;
                        return;
                    }
                }
            } else {
                this.f486r = true;
                this.f473e = d7;
                this.f474f = d5;
                this.f475g = d4;
                this.f476h = d6;
                double hypot = Math.hypot(d9, d8);
                this.f470b = hypot;
                this.f482n = hypot * this.f477i;
                double d14 = this.f472d;
                double d15 = this.f471c;
                this.f480l = d8 / (d14 - d15);
                this.f481m = d9 / (d14 - d15);
            }
        }

        /* renamed from: a */
        public double m2445a() {
            double d = this.f478j * this.f484p;
            double hypot = this.f482n / Math.hypot(d, (-this.f479k) * this.f483o);
            if (this.f485q) {
                d = -d;
            }
            return d * hypot;
        }

        /* renamed from: b */
        public double m2444b() {
            double d = this.f478j * this.f484p;
            double d2 = (-this.f479k) * this.f483o;
            double hypot = this.f482n / Math.hypot(d, d2);
            return this.f485q ? (-d2) * hypot : d2 * hypot;
        }

        /* renamed from: c */
        public double m2443c(double d) {
            double d2 = (d - this.f471c) * this.f477i;
            double d3 = this.f473e;
            return ((this.f474f - d3) * d2) + d3;
        }

        /* renamed from: d */
        public double m2442d(double d) {
            double d2 = (d - this.f471c) * this.f477i;
            double d3 = this.f475g;
            return ((this.f476h - d3) * d2) + d3;
        }

        /* renamed from: e */
        public double m2441e() {
            return (this.f478j * this.f483o) + this.f480l;
        }

        /* renamed from: f */
        public double m2440f() {
            return (this.f479k * this.f484p) + this.f481m;
        }

        /* renamed from: g */
        public void m2439g(double d) {
            double d2 = (this.f485q ? this.f472d - d : d - this.f471c) * this.f477i;
            double d3 = ShadowDrawableWrapper.COS_45;
            if (d2 > ShadowDrawableWrapper.COS_45) {
                d3 = 1.0d;
                if (d2 < 1.0d) {
                    double[] dArr = this.f469a;
                    double length = d2 * (dArr.length - 1);
                    int i = (int) length;
                    d3 = ((dArr[i + 1] - dArr[i]) * (length - i)) + dArr[i];
                }
            }
            double d4 = d3 * 1.5707963267948966d;
            this.f483o = Math.sin(d4);
            this.f484p = Math.cos(d4);
        }
    }

    public C0144G1(int[] iArr, double[] dArr, double[][] dArr2) {
        this.f466a = dArr;
        this.f467b = new C0145a[dArr.length - 1];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            C0145a[] c0145aArr = this.f467b;
            if (i >= c0145aArr.length) {
                return;
            }
            int i4 = iArr[i];
            if (i4 == 0) {
                i3 = 3;
            } else if (i4 == 1) {
                i2 = 1;
                i3 = 1;
            } else if (i4 == 2) {
                i2 = 2;
                i3 = 2;
            } else if (i4 == 3) {
                i2 = i2 == 1 ? 2 : 1;
                i3 = i2;
            }
            int i5 = i + 1;
            c0145aArr[i] = new C0145a(i3, dArr[i], dArr[i5], dArr2[i][0], dArr2[i][1], dArr2[i5][0], dArr2[i5][1]);
            i = i5;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: b */
    public double mo2355b(double d, int i) {
        C0145a[] c0145aArr = this.f467b;
        int i2 = 0;
        if (d < c0145aArr[0].f471c) {
            d = c0145aArr[0].f471c;
        } else if (d > c0145aArr[c0145aArr.length - 1].f472d) {
            d = c0145aArr[c0145aArr.length - 1].f472d;
        }
        while (true) {
            C0145a[] c0145aArr2 = this.f467b;
            if (i2 >= c0145aArr2.length) {
                return Double.NaN;
            }
            if (d <= c0145aArr2[i2].f472d) {
                if (c0145aArr2[i2].f486r) {
                    if (i == 0) {
                        return c0145aArr2[i2].m2443c(d);
                    }
                    return c0145aArr2[i2].m2442d(d);
                }
                c0145aArr2[i2].m2439g(d);
                if (i == 0) {
                    return this.f467b[i2].m2441e();
                }
                return this.f467b[i2].m2440f();
            }
            i2++;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: c */
    public void mo2354c(double d, double[] dArr) {
        C0145a[] c0145aArr = this.f467b;
        if (d < c0145aArr[0].f471c) {
            d = c0145aArr[0].f471c;
        }
        if (d > c0145aArr[c0145aArr.length - 1].f472d) {
            d = c0145aArr[c0145aArr.length - 1].f472d;
        }
        int i = 0;
        while (true) {
            C0145a[] c0145aArr2 = this.f467b;
            if (i >= c0145aArr2.length) {
                return;
            }
            if (d <= c0145aArr2[i].f472d) {
                if (c0145aArr2[i].f486r) {
                    dArr[0] = c0145aArr2[i].m2443c(d);
                    dArr[1] = this.f467b[i].m2442d(d);
                    return;
                }
                c0145aArr2[i].m2439g(d);
                dArr[0] = this.f467b[i].m2441e();
                dArr[1] = this.f467b[i].m2440f();
                return;
            }
            i++;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: d */
    public void mo2353d(double d, float[] fArr) {
        C0145a[] c0145aArr = this.f467b;
        if (d < c0145aArr[0].f471c) {
            d = c0145aArr[0].f471c;
        } else if (d > c0145aArr[c0145aArr.length - 1].f472d) {
            d = c0145aArr[c0145aArr.length - 1].f472d;
        }
        int i = 0;
        while (true) {
            C0145a[] c0145aArr2 = this.f467b;
            if (i >= c0145aArr2.length) {
                return;
            }
            if (d <= c0145aArr2[i].f472d) {
                if (c0145aArr2[i].f486r) {
                    fArr[0] = (float) c0145aArr2[i].m2443c(d);
                    fArr[1] = (float) this.f467b[i].m2442d(d);
                    return;
                }
                c0145aArr2[i].m2439g(d);
                fArr[0] = (float) this.f467b[i].m2441e();
                fArr[1] = (float) this.f467b[i].m2440f();
                return;
            }
            i++;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: e */
    public double mo2352e(double d, int i) {
        C0145a[] c0145aArr = this.f467b;
        int i2 = 0;
        if (d < c0145aArr[0].f471c) {
            d = c0145aArr[0].f471c;
        }
        if (d > c0145aArr[c0145aArr.length - 1].f472d) {
            d = c0145aArr[c0145aArr.length - 1].f472d;
        }
        while (true) {
            C0145a[] c0145aArr2 = this.f467b;
            if (i2 >= c0145aArr2.length) {
                return Double.NaN;
            }
            if (d <= c0145aArr2[i2].f472d) {
                if (c0145aArr2[i2].f486r) {
                    if (i == 0) {
                        return c0145aArr2[i2].f480l;
                    }
                    return c0145aArr2[i2].f481m;
                }
                c0145aArr2[i2].m2439g(d);
                if (i == 0) {
                    return this.f467b[i2].m2445a();
                }
                return this.f467b[i2].m2444b();
            }
            i2++;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: f */
    public void mo2351f(double d, double[] dArr) {
        C0145a[] c0145aArr = this.f467b;
        if (d < c0145aArr[0].f471c) {
            d = c0145aArr[0].f471c;
        } else if (d > c0145aArr[c0145aArr.length - 1].f472d) {
            d = c0145aArr[c0145aArr.length - 1].f472d;
        }
        int i = 0;
        while (true) {
            C0145a[] c0145aArr2 = this.f467b;
            if (i >= c0145aArr2.length) {
                return;
            }
            if (d <= c0145aArr2[i].f472d) {
                if (c0145aArr2[i].f486r) {
                    dArr[0] = c0145aArr2[i].f480l;
                    dArr[1] = c0145aArr2[i].f481m;
                    return;
                }
                c0145aArr2[i].m2439g(d);
                dArr[0] = this.f467b[i].m2445a();
                dArr[1] = this.f467b[i].m2444b();
                return;
            }
            i++;
        }
    }

    @Override // p000.AbstractC0166H1
    /* renamed from: g */
    public double[] mo2350g() {
        return this.f466a;
    }
}
