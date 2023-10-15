package p000;

import java.util.LinkedHashMap;
import p000.C0393R2;
import p000.C0445T2;

/* renamed from: b2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0955b2 implements Comparable<C0955b2> {

    /* renamed from: p */
    public static String[] f3662p = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a */
    public C0191I1 f3663a;

    /* renamed from: b */
    public int f3664b;

    /* renamed from: c */
    public float f3665c;

    /* renamed from: d */
    public float f3666d;

    /* renamed from: f */
    public float f3667f;

    /* renamed from: g */
    public float f3668g;

    /* renamed from: h */
    public float f3669h;

    /* renamed from: i */
    public float f3670i;

    /* renamed from: j */
    public float f3671j;

    /* renamed from: k */
    public int f3672k;

    /* renamed from: l */
    public LinkedHashMap<String, C0393R2> f3673l;

    /* renamed from: m */
    public int f3674m;

    /* renamed from: n */
    public double[] f3675n;

    /* renamed from: o */
    public double[] f3676o;

    public C0955b2() {
        this.f3664b = 0;
        this.f3671j = Float.NaN;
        this.f3672k = -1;
        this.f3673l = new LinkedHashMap<>();
        this.f3674m = 0;
        this.f3675n = new double[18];
        this.f3676o = new double[18];
    }

    /* renamed from: a */
    public void m1195a(C0445T2.C0446a c0446a) {
        this.f3663a = C0191I1.m2394c(c0446a.f1458c.f1528c);
        C0445T2.C0448c c0448c = c0446a.f1458c;
        this.f3672k = c0448c.f1529d;
        this.f3671j = c0448c.f1532g;
        this.f3664b = c0448c.f1530e;
        float f = c0446a.f1457b.f1537e;
        for (String str : c0446a.f1461f.keySet()) {
            C0393R2 c0393r2 = c0446a.f1461f.get(str);
            if (c0393r2.f1324b != C0393R2.EnumC0394a.STRING_TYPE) {
                this.f3673l.put(str, c0393r2);
            }
        }
    }

    /* renamed from: b */
    public final boolean m1194b(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* renamed from: c */
    public void m1193c(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f3667f;
        float f2 = this.f3668g;
        float f3 = this.f3669h;
        float f4 = this.f3670i;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        fArr[i] = (f3 / 2.0f) + f + 0.0f;
        fArr[i + 1] = (f4 / 2.0f) + f2 + 0.0f;
    }

    @Override // java.lang.Comparable
    public int compareTo(C0955b2 c0955b2) {
        return Float.compare(this.f3666d, c0955b2.f3666d);
    }

    /* renamed from: d */
    public void m1192d(float f, float f2, float f3, float f4) {
        this.f3667f = f;
        this.f3668g = f2;
        this.f3669h = f3;
        this.f3670i = f4;
    }

    /* renamed from: e */
    public void m1191e(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (((f4 * 1.0f) + f8) * f) + ((1.0f - f) * f8) + 0.0f;
        fArr[1] = (((f6 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
    }

    public C0955b2(int i, int i2, C0466U1 c0466u1, C0955b2 c0955b2, C0955b2 c0955b22) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        this.f3664b = 0;
        this.f3671j = Float.NaN;
        this.f3672k = -1;
        this.f3673l = new LinkedHashMap<>();
        this.f3674m = 0;
        this.f3675n = new double[18];
        this.f3676o = new double[18];
        int i3 = c0466u1.f1629m;
        if (i3 == 1) {
            float f7 = c0466u1.f1113a / 100.0f;
            this.f3665c = f7;
            this.f3664b = c0466u1.f1624h;
            float f8 = Float.isNaN(c0466u1.f1625i) ? f7 : c0466u1.f1625i;
            float f9 = Float.isNaN(c0466u1.f1626j) ? f7 : c0466u1.f1626j;
            float f10 = c0955b22.f3669h - c0955b2.f3669h;
            float f11 = c0955b22.f3670i - c0955b2.f3670i;
            this.f3666d = this.f3665c;
            f7 = Float.isNaN(c0466u1.f1627k) ? f7 : c0466u1.f1627k;
            float f12 = c0955b2.f3667f;
            float f13 = c0955b2.f3669h;
            float f14 = c0955b2.f3668g;
            float f15 = c0955b2.f3670i;
            float f16 = ((c0955b22.f3669h / 2.0f) + c0955b22.f3667f) - ((f13 / 2.0f) + f12);
            float f17 = ((c0955b22.f3670i / 2.0f) + c0955b22.f3668g) - ((f15 / 2.0f) + f14);
            float f18 = f16 * f7;
            float f19 = (f10 * f8) / 2.0f;
            this.f3667f = (int) ((f12 + f18) - f19);
            float f20 = f7 * f17;
            float f21 = (f11 * f9) / 2.0f;
            this.f3668g = (int) ((f14 + f20) - f21);
            this.f3669h = (int) (f13 + f);
            this.f3670i = (int) (f15 + f2);
            float f22 = Float.isNaN(c0466u1.f1628l) ? 0.0f : c0466u1.f1628l;
            this.f3674m = 1;
            float f23 = (int) ((c0955b2.f3667f + f18) - f19);
            this.f3667f = f23;
            float f24 = (int) ((c0955b2.f3668g + f20) - f21);
            this.f3668g = f24;
            this.f3667f = f23 + ((-f17) * f22);
            this.f3668g = f24 + (f16 * f22);
            this.f3663a = C0191I1.m2394c(c0466u1.f1622f);
            this.f3672k = c0466u1.f1623g;
        } else if (i3 != 2) {
            float f25 = c0466u1.f1113a / 100.0f;
            this.f3665c = f25;
            this.f3664b = c0466u1.f1624h;
            float f26 = Float.isNaN(c0466u1.f1625i) ? f25 : c0466u1.f1625i;
            float f27 = Float.isNaN(c0466u1.f1626j) ? f25 : c0466u1.f1626j;
            float f28 = c0955b22.f3669h;
            float f29 = c0955b2.f3669h;
            float f30 = f28 - f29;
            float f31 = c0955b22.f3670i;
            float f32 = c0955b2.f3670i;
            float f33 = f31 - f32;
            this.f3666d = this.f3665c;
            float f34 = c0955b2.f3667f;
            float f35 = c0955b2.f3668g;
            float f36 = ((f28 / 2.0f) + c0955b22.f3667f) - ((f29 / 2.0f) + f34);
            float f37 = ((f31 / 2.0f) + c0955b22.f3668g) - ((f32 / 2.0f) + f35);
            float f38 = (f30 * f26) / 2.0f;
            this.f3667f = (int) (((f36 * f25) + f34) - f38);
            float f39 = (f37 * f25) + f35;
            float f40 = (f33 * f27) / 2.0f;
            this.f3668g = (int) (f39 - f40);
            this.f3669h = (int) (f29 + f5);
            this.f3670i = (int) (f32 + f6);
            float f41 = Float.isNaN(c0466u1.f1627k) ? f25 : c0466u1.f1627k;
            float f42 = Float.isNaN(Float.NaN) ? 0.0f : Float.NaN;
            f25 = Float.isNaN(c0466u1.f1628l) ? f25 : c0466u1.f1628l;
            float f43 = Float.isNaN(Float.NaN) ? 0.0f : Float.NaN;
            this.f3674m = 2;
            this.f3667f = (int) (((f43 * f37) + ((f41 * f36) + c0955b2.f3667f)) - f38);
            this.f3668g = (int) (((f37 * f25) + ((f36 * f42) + c0955b2.f3668g)) - f40);
            this.f3663a = C0191I1.m2394c(c0466u1.f1622f);
            this.f3672k = c0466u1.f1623g;
        } else {
            float f44 = c0466u1.f1113a / 100.0f;
            this.f3665c = f44;
            this.f3664b = c0466u1.f1624h;
            float f45 = Float.isNaN(c0466u1.f1625i) ? f44 : c0466u1.f1625i;
            float f46 = Float.isNaN(c0466u1.f1626j) ? f44 : c0466u1.f1626j;
            float f47 = c0955b22.f3669h;
            float f48 = f47 - c0955b2.f3669h;
            float f49 = c0955b22.f3670i;
            float f50 = f49 - c0955b2.f3670i;
            this.f3666d = this.f3665c;
            float f51 = c0955b2.f3667f;
            float f52 = c0955b2.f3668g;
            float f53 = (f47 / 2.0f) + c0955b22.f3667f;
            float f54 = (f49 / 2.0f) + c0955b22.f3668g;
            float f55 = f48 * f45;
            this.f3667f = (int) ((((f53 - ((f3 / 2.0f) + f51)) * f44) + f51) - (f55 / 2.0f));
            float f56 = f50 * f46;
            this.f3668g = (int) ((((f54 - ((f4 / 2.0f) + f52)) * f44) + f52) - (f56 / 2.0f));
            this.f3669h = (int) (f3 + f55);
            this.f3670i = (int) (f4 + f56);
            this.f3674m = 3;
            if (!Float.isNaN(c0466u1.f1627k)) {
                this.f3667f = (int) (c0466u1.f1627k * ((int) (i - this.f3669h)));
            }
            if (!Float.isNaN(c0466u1.f1628l)) {
                this.f3668g = (int) (c0466u1.f1628l * ((int) (i2 - this.f3670i)));
            }
            this.f3663a = C0191I1.m2394c(c0466u1.f1622f);
            this.f3672k = c0466u1.f1623g;
        }
    }
}
