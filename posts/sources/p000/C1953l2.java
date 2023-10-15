package p000;

import java.util.Arrays;
import java.util.Objects;
import p000.C2168p2;

/* renamed from: l2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1953l2 {

    /* renamed from: p */
    public static boolean f5438p = false;

    /* renamed from: q */
    public static int f5439q = 1000;

    /* renamed from: r */
    public static long f5440r;

    /* renamed from: c */
    public InterfaceC1954a f5443c;

    /* renamed from: f */
    public C1909j2[] f5446f;

    /* renamed from: l */
    public final C1934k2 f5452l;

    /* renamed from: o */
    public InterfaceC1954a f5455o;

    /* renamed from: a */
    public boolean f5441a = false;

    /* renamed from: b */
    public int f5442b = 0;

    /* renamed from: d */
    public int f5444d = 32;

    /* renamed from: e */
    public int f5445e = 32;

    /* renamed from: g */
    public boolean f5447g = false;

    /* renamed from: h */
    public boolean[] f5448h = new boolean[32];

    /* renamed from: i */
    public int f5449i = 1;

    /* renamed from: j */
    public int f5450j = 0;

    /* renamed from: k */
    public int f5451k = 32;

    /* renamed from: m */
    public C2168p2[] f5453m = new C2168p2[f5439q];

    /* renamed from: n */
    public int f5454n = 0;

    /* renamed from: l2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1954a {
        /* renamed from: a */
        void mo538a(C2168p2 c2168p2);

        /* renamed from: b */
        C2168p2 mo537b(C1953l2 c1953l2, boolean[] zArr);

        void clear();

        boolean isEmpty();
    }

    public C1953l2() {
        this.f5446f = null;
        this.f5446f = new C1909j2[32];
        m615t();
        C1934k2 c1934k2 = new C1934k2();
        this.f5452l = c1934k2;
        this.f5443c = new C2016o2(c1934k2);
        this.f5455o = new C1909j2(c1934k2);
    }

    /* renamed from: a */
    public final C2168p2 m634a(C2168p2.EnumC2169a enumC2169a, String str) {
        C2168p2 m579a = this.f5452l.f5378c.m579a();
        if (m579a == null) {
            m579a = new C2168p2(enumC2169a);
            m579a.f6185i = enumC2169a;
        } else {
            m579a.m455c();
            m579a.f6185i = enumC2169a;
        }
        int i = this.f5454n;
        int i2 = f5439q;
        if (i >= i2) {
            int i3 = i2 * 2;
            f5439q = i3;
            this.f5453m = (C2168p2[]) Arrays.copyOf(this.f5453m, i3);
        }
        C2168p2[] c2168p2Arr = this.f5453m;
        int i4 = this.f5454n;
        this.f5454n = i4 + 1;
        c2168p2Arr[i4] = m579a;
        return m579a;
    }

    /* renamed from: b */
    public void m633b(C2168p2 c2168p2, C2168p2 c2168p22, int i, float f, C2168p2 c2168p23, C2168p2 c2168p24, int i2, int i3) {
        C1909j2 m622m = m622m();
        if (c2168p22 == c2168p23) {
            m622m.f5316d.mo707f(c2168p2, 1.0f);
            m622m.f5316d.mo707f(c2168p24, 1.0f);
            m622m.f5316d.mo707f(c2168p22, -2.0f);
        } else if (f == 0.5f) {
            m622m.f5316d.mo707f(c2168p2, 1.0f);
            m622m.f5316d.mo707f(c2168p22, -1.0f);
            m622m.f5316d.mo707f(c2168p23, -1.0f);
            m622m.f5316d.mo707f(c2168p24, 1.0f);
            if (i > 0 || i2 > 0) {
                m622m.f5314b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            m622m.f5316d.mo707f(c2168p2, -1.0f);
            m622m.f5316d.mo707f(c2168p22, 1.0f);
            m622m.f5314b = i;
        } else if (f >= 1.0f) {
            m622m.f5316d.mo707f(c2168p24, -1.0f);
            m622m.f5316d.mo707f(c2168p23, 1.0f);
            m622m.f5314b = -i2;
        } else {
            float f2 = 1.0f - f;
            m622m.f5316d.mo707f(c2168p2, f2 * 1.0f);
            m622m.f5316d.mo707f(c2168p22, f2 * (-1.0f));
            m622m.f5316d.mo707f(c2168p23, (-1.0f) * f);
            m622m.f5316d.mo707f(c2168p24, 1.0f * f);
            if (i > 0 || i2 > 0) {
                m622m.f5314b = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            m622m.m721c(this, i3);
        }
        m632c(m622m);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01bc  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m632c(p000.C1909j2 r17) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1953l2.m632c(j2):void");
    }

    /* renamed from: d */
    public C1909j2 m631d(C2168p2 c2168p2, C2168p2 c2168p22, int i, int i2) {
        if (i2 == 8 && c2168p22.f6182f && c2168p2.f6179c == -1) {
            c2168p2.m454d(this, c2168p22.f6181e + i);
            return null;
        }
        C1909j2 m622m = m622m();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            m622m.f5314b = i;
        }
        if (!z) {
            m622m.f5316d.mo707f(c2168p2, -1.0f);
            m622m.f5316d.mo707f(c2168p22, 1.0f);
        } else {
            m622m.f5316d.mo707f(c2168p2, 1.0f);
            m622m.f5316d.mo707f(c2168p22, -1.0f);
        }
        if (i2 != 8) {
            m622m.m721c(this, i2);
        }
        m632c(m622m);
        return m622m;
    }

    /* renamed from: e */
    public void m630e(C2168p2 c2168p2, int i) {
        int i2 = c2168p2.f6179c;
        if (i2 == -1) {
            c2168p2.m454d(this, i);
            for (int i3 = 0; i3 < this.f5442b + 1; i3++) {
                C2168p2 c2168p22 = this.f5452l.f5379d[i3];
            }
        } else if (i2 != -1) {
            C1909j2 c1909j2 = this.f5446f[i2];
            if (c1909j2.f5317e) {
                c1909j2.f5314b = i;
            } else if (c1909j2.f5316d.getCurrentSize() == 0) {
                c1909j2.f5317e = true;
                c1909j2.f5314b = i;
            } else {
                C1909j2 m622m = m622m();
                if (i < 0) {
                    m622m.f5314b = i * (-1);
                    m622m.f5316d.mo707f(c2168p2, 1.0f);
                } else {
                    m622m.f5314b = i;
                    m622m.f5316d.mo707f(c2168p2, -1.0f);
                }
                m632c(m622m);
            }
        } else {
            C1909j2 m622m2 = m622m();
            m622m2.f5313a = c2168p2;
            float f = i;
            c2168p2.f6181e = f;
            m622m2.f5314b = f;
            m622m2.f5317e = true;
            m632c(m622m2);
        }
    }

    /* renamed from: f */
    public void m629f(C2168p2 c2168p2, C2168p2 c2168p22, int i, int i2) {
        C1909j2 m622m = m622m();
        C2168p2 m621n = m621n();
        m621n.f6180d = 0;
        m622m.m719e(c2168p2, c2168p22, m621n, i);
        if (i2 != 8) {
            m622m.f5316d.mo707f(m624k(i2, null), (int) (m622m.f5316d.mo710c(m621n) * (-1.0f)));
        }
        m632c(m622m);
    }

    /* renamed from: g */
    public void m628g(C2168p2 c2168p2, C2168p2 c2168p22, int i, int i2) {
        C1909j2 m622m = m622m();
        C2168p2 m621n = m621n();
        m621n.f6180d = 0;
        m622m.m718f(c2168p2, c2168p22, m621n, i);
        if (i2 != 8) {
            m622m.f5316d.mo707f(m624k(i2, null), (int) (m622m.f5316d.mo710c(m621n) * (-1.0f)));
        }
        m632c(m622m);
    }

    /* renamed from: h */
    public void m627h(C2168p2 c2168p2, C2168p2 c2168p22, C2168p2 c2168p23, C2168p2 c2168p24, float f, int i) {
        C1909j2 m622m = m622m();
        m622m.m720d(c2168p2, c2168p22, c2168p23, c2168p24, f);
        if (i != 8) {
            m622m.m721c(this, i);
        }
        m632c(m622m);
    }

    /* renamed from: i */
    public final void m626i(C1909j2 c1909j2) {
        int i;
        if (c1909j2.f5317e) {
            c1909j2.f5313a.m454d(this, c1909j2.f5314b);
        } else {
            C1909j2[] c1909j2Arr = this.f5446f;
            int i2 = this.f5450j;
            c1909j2Arr[i2] = c1909j2;
            C2168p2 c2168p2 = c1909j2.f5313a;
            c2168p2.f6179c = i2;
            this.f5450j = i2 + 1;
            c2168p2.m453e(this, c1909j2);
        }
        if (this.f5441a) {
            int i3 = 0;
            while (i3 < this.f5450j) {
                if (this.f5446f[i3] == null) {
                    System.out.println("WTF");
                }
                C1909j2[] c1909j2Arr2 = this.f5446f;
                if (c1909j2Arr2[i3] != null && c1909j2Arr2[i3].f5317e) {
                    C1909j2 c1909j22 = c1909j2Arr2[i3];
                    c1909j22.f5313a.m454d(this, c1909j22.f5314b);
                    this.f5452l.f5377b.m578b(c1909j22);
                    this.f5446f[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.f5450j;
                        if (i4 >= i) {
                            break;
                        }
                        C1909j2[] c1909j2Arr3 = this.f5446f;
                        int i6 = i4 - 1;
                        c1909j2Arr3[i6] = c1909j2Arr3[i4];
                        if (c1909j2Arr3[i6].f5313a.f6179c == i4) {
                            c1909j2Arr3[i6].f5313a.f6179c = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.f5446f[i5] = null;
                    }
                    this.f5450j = i - 1;
                    i3--;
                }
                i3++;
            }
            this.f5441a = false;
        }
    }

    /* renamed from: j */
    public final void m625j() {
        for (int i = 0; i < this.f5450j; i++) {
            C1909j2 c1909j2 = this.f5446f[i];
            c1909j2.f5313a.f6181e = c1909j2.f5314b;
        }
    }

    /* renamed from: k */
    public C2168p2 m624k(int i, String str) {
        if (this.f5449i + 1 >= this.f5445e) {
            m619p();
        }
        C2168p2 m634a = m634a(C2168p2.EnumC2169a.ERROR, str);
        int i2 = this.f5442b + 1;
        this.f5442b = i2;
        this.f5449i++;
        m634a.f6178b = i2;
        m634a.f6180d = i;
        this.f5452l.f5379d[i2] = m634a;
        this.f5443c.mo538a(m634a);
        return m634a;
    }

    /* renamed from: l */
    public C2168p2 m623l(Object obj) {
        C2168p2 c2168p2 = null;
        if (obj == null) {
            return null;
        }
        if (this.f5449i + 1 >= this.f5445e) {
            m619p();
        }
        if (obj instanceof C2224s2) {
            C2224s2 c2224s2 = (C2224s2) obj;
            c2168p2 = c2224s2.f6376i;
            if (c2168p2 == null) {
                c2224s2.m403l();
                c2168p2 = c2224s2.f6376i;
            }
            int i = c2168p2.f6178b;
            if (i == -1 || i > this.f5442b || this.f5452l.f5379d[i] == null) {
                if (i != -1) {
                    c2168p2.m455c();
                }
                int i2 = this.f5442b + 1;
                this.f5442b = i2;
                this.f5449i++;
                c2168p2.f6178b = i2;
                c2168p2.f6185i = C2168p2.EnumC2169a.UNRESTRICTED;
                this.f5452l.f5379d[i2] = c2168p2;
            }
        }
        return c2168p2;
    }

    /* renamed from: m */
    public C1909j2 m622m() {
        C1909j2 m579a = this.f5452l.f5377b.m579a();
        if (m579a == null) {
            m579a = new C1909j2(this.f5452l);
            f5440r++;
        } else {
            m579a.f5313a = null;
            m579a.f5316d.clear();
            m579a.f5314b = 0.0f;
            m579a.f5317e = false;
        }
        C2168p2.f6176n++;
        return m579a;
    }

    /* renamed from: n */
    public C2168p2 m621n() {
        if (this.f5449i + 1 >= this.f5445e) {
            m619p();
        }
        C2168p2 m634a = m634a(C2168p2.EnumC2169a.SLACK, null);
        int i = this.f5442b + 1;
        this.f5442b = i;
        this.f5449i++;
        m634a.f6178b = i;
        this.f5452l.f5379d[i] = m634a;
        return m634a;
    }

    /* renamed from: o */
    public int m620o(Object obj) {
        C2168p2 c2168p2 = ((C2224s2) obj).f6376i;
        if (c2168p2 != null) {
            return (int) (c2168p2.f6181e + 0.5f);
        }
        return 0;
    }

    /* renamed from: p */
    public final void m619p() {
        int i = this.f5444d * 2;
        this.f5444d = i;
        this.f5446f = (C1909j2[]) Arrays.copyOf(this.f5446f, i);
        C1934k2 c1934k2 = this.f5452l;
        c1934k2.f5379d = (C2168p2[]) Arrays.copyOf(c1934k2.f5379d, this.f5444d);
        int i2 = this.f5444d;
        this.f5448h = new boolean[i2];
        this.f5445e = i2;
        this.f5451k = i2;
    }

    /* renamed from: q */
    public void m618q() {
        if (this.f5443c.isEmpty()) {
            m625j();
        } else if (!this.f5447g) {
            m617r(this.f5443c);
        } else {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.f5450j) {
                    z = true;
                    break;
                } else if (!this.f5446f[i].f5317e) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                m617r(this.f5443c);
            } else {
                m625j();
            }
        }
    }

    /* renamed from: r */
    public void m617r(InterfaceC1954a interfaceC1954a) {
        float f;
        int i;
        boolean z;
        C2168p2.EnumC2169a enumC2169a = C2168p2.EnumC2169a.UNRESTRICTED;
        int i2 = 0;
        while (true) {
            f = 0.0f;
            i = 1;
            if (i2 >= this.f5450j) {
                z = false;
                break;
            }
            C1909j2[] c1909j2Arr = this.f5446f;
            if (c1909j2Arr[i2].f5313a.f6185i != enumC2169a && c1909j2Arr[i2].f5314b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3 += i;
                float f2 = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                while (i4 < this.f5450j) {
                    C1909j2 c1909j2 = this.f5446f[i4];
                    if (c1909j2.f5313a.f6185i != enumC2169a && !c1909j2.f5317e && c1909j2.f5314b < f) {
                        int currentSize = c1909j2.f5316d.getCurrentSize();
                        int i8 = 0;
                        while (i8 < currentSize) {
                            C2168p2 mo705h = c1909j2.f5316d.mo705h(i8);
                            float mo710c = c1909j2.f5316d.mo710c(mo705h);
                            if (mo710c > f) {
                                for (int i9 = 0; i9 < 9; i9++) {
                                    float f3 = mo705h.f6183g[i9] / mo710c;
                                    if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                        i6 = mo705h.f6178b;
                                        i7 = i9;
                                        f2 = f3;
                                        i5 = i4;
                                    }
                                }
                            }
                            i8++;
                            f = 0.0f;
                        }
                    }
                    i4++;
                    f = 0.0f;
                }
                if (i5 != -1) {
                    C1909j2 c1909j22 = this.f5446f[i5];
                    c1909j22.f5313a.f6179c = -1;
                    c1909j22.m714j(this.f5452l.f5379d[i6]);
                    C2168p2 c2168p2 = c1909j22.f5313a;
                    c2168p2.f6179c = i5;
                    c2168p2.m453e(this, c1909j22);
                } else {
                    z2 = true;
                }
                if (i3 > this.f5449i / 2) {
                    z2 = true;
                }
                f = 0.0f;
                i = 1;
            }
        }
        m616s(interfaceC1954a);
        m625j();
    }

    /* renamed from: s */
    public final int m616s(InterfaceC1954a interfaceC1954a) {
        for (int i = 0; i < this.f5449i; i++) {
            this.f5448h[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.f5449i * 2) {
                return i2;
            }
            C2168p2 c2168p2 = ((C1909j2) interfaceC1954a).f5313a;
            if (c2168p2 != null) {
                this.f5448h[c2168p2.f6178b] = true;
            }
            C2168p2 mo537b = interfaceC1954a.mo537b(this, this.f5448h);
            if (mo537b != null) {
                boolean[] zArr = this.f5448h;
                int i3 = mo537b.f6178b;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (mo537b != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.f5450j; i5++) {
                    C1909j2 c1909j2 = this.f5446f[i5];
                    if (c1909j2.f5313a.f6185i != C2168p2.EnumC2169a.UNRESTRICTED && !c1909j2.f5317e && c1909j2.f5316d.mo709d(mo537b)) {
                        float mo710c = c1909j2.f5316d.mo710c(mo537b);
                        if (mo710c < 0.0f) {
                            float f2 = (-c1909j2.f5314b) / mo710c;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    C1909j2 c1909j22 = this.f5446f[i4];
                    c1909j22.f5313a.f6179c = -1;
                    c1909j22.m714j(mo537b);
                    C2168p2 c2168p22 = c1909j22.f5313a;
                    c2168p22.f6179c = i4;
                    c2168p22.m453e(this, c1909j22);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    /* renamed from: t */
    public final void m615t() {
        for (int i = 0; i < this.f5450j; i++) {
            C1909j2 c1909j2 = this.f5446f[i];
            if (c1909j2 != null) {
                this.f5452l.f5377b.m578b(c1909j2);
            }
            this.f5446f[i] = null;
        }
    }

    /* renamed from: u */
    public void m614u() {
        C1934k2 c1934k2;
        int i = 0;
        while (true) {
            c1934k2 = this.f5452l;
            C2168p2[] c2168p2Arr = c1934k2.f5379d;
            if (i >= c2168p2Arr.length) {
                break;
            }
            C2168p2 c2168p2 = c2168p2Arr[i];
            if (c2168p2 != null) {
                c2168p2.m455c();
            }
            i++;
        }
        C1997n2<C2168p2> c1997n2 = c1934k2.f5378c;
        C2168p2[] c2168p2Arr2 = this.f5453m;
        int i2 = this.f5454n;
        Objects.requireNonNull(c1997n2);
        if (i2 > c2168p2Arr2.length) {
            i2 = c2168p2Arr2.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            C2168p2 c2168p22 = c2168p2Arr2[i3];
            int i4 = c1997n2.f5522b;
            Object[] objArr = c1997n2.f5521a;
            if (i4 < objArr.length) {
                objArr[i4] = c2168p22;
                c1997n2.f5522b = i4 + 1;
            }
        }
        this.f5454n = 0;
        Arrays.fill(this.f5452l.f5379d, (Object) null);
        this.f5442b = 0;
        this.f5443c.clear();
        this.f5449i = 1;
        for (int i5 = 0; i5 < this.f5450j; i5++) {
            C1909j2[] c1909j2Arr = this.f5446f;
            if (c1909j2Arr[i5] != null) {
                Objects.requireNonNull(c1909j2Arr[i5]);
            }
        }
        m615t();
        this.f5450j = 0;
        this.f5455o = new C1909j2(this.f5452l);
    }
}
