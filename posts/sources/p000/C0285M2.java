package p000;

import p000.AbstractC0367Q2;
import p000.C0168H2;
import p000.C2224s2;
import p000.C2248t2;

/* renamed from: M2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0285M2 extends AbstractC0367Q2 {

    /* renamed from: k */
    public static int[] f956k = new int[2];

    public C0285M2(C2248t2 c2248t2) {
        super(c2248t2);
        this.f1255h.f544e = C0168H2.EnumC0169a.LEFT;
        this.f1256i.f544e = C0168H2.EnumC0169a.RIGHT;
        this.f1253f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x028f, code lost:
        if (r15 != 1) goto L132;
     */
    @Override // p000.AbstractC0367Q2, p000.InterfaceC0128F2
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo2141a(p000.InterfaceC0128F2 r18) {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0285M2.mo2141a(F2):void");
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: d */
    public void mo2138d() {
        C2248t2 c2248t2;
        C2248t2 c2248t22;
        C2248t2 c2248t23;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.MATCH_PARENT;
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.FIXED;
        C2248t2 c2248t24 = this.f1249b;
        if (c2248t24.f6482a) {
            this.f1252e.mo2389c(c2248t24.m354w());
        }
        if (!this.f1252e.f549j) {
            C2248t2.EnumC2249a m359r = this.f1249b.m359r();
            this.f1251d = m359r;
            if (m359r != enumC2249a) {
                if (m359r == enumC2249a2 && (((c2248t23 = this.f1249b.f6474S) != null && c2248t23.m359r() == enumC2249a3) || c2248t23.m359r() == enumC2249a2)) {
                    int m354w = (c2248t23.m354w() - this.f1249b.f6460G.m410e()) - this.f1249b.f6464I.m410e();
                    m2140b(this.f1255h, c2248t23.f6488d.f1255h, this.f1249b.f6460G.m410e());
                    m2140b(this.f1256i, c2248t23.f6488d.f1256i, -this.f1249b.f6464I.m410e());
                    this.f1252e.mo2389c(m354w);
                    return;
                } else if (this.f1251d == enumC2249a3) {
                    this.f1252e.mo2389c(this.f1249b.m354w());
                }
            }
        } else if (this.f1251d == enumC2249a2 && (((c2248t2 = this.f1249b.f6474S) != null && c2248t2.m359r() == enumC2249a3) || c2248t2.m359r() == enumC2249a2)) {
            m2140b(this.f1255h, c2248t2.f6488d.f1255h, this.f1249b.f6460G.m410e());
            m2140b(this.f1256i, c2248t2.f6488d.f1256i, -this.f1249b.f6464I.m410e());
            return;
        }
        C0193I2 c0193i2 = this.f1252e;
        if (c0193i2.f549j) {
            C2248t2 c2248t25 = this.f1249b;
            if (c2248t25.f6482a) {
                C2224s2[] c2224s2Arr = c2248t25.f6470O;
                if (c2224s2Arr[0].f6373f != null && c2224s2Arr[1].f6373f != null) {
                    if (c2248t25.m384B()) {
                        this.f1255h.f545f = this.f1249b.f6470O[0].m410e();
                        this.f1256i.f545f = -this.f1249b.f6470O[1].m410e();
                        return;
                    }
                    C0168H2 m2134h = m2134h(this.f1249b.f6470O[0]);
                    if (m2134h != null) {
                        C0168H2 c0168h2 = this.f1255h;
                        int m410e = this.f1249b.f6470O[0].m410e();
                        c0168h2.f551l.add(m2134h);
                        c0168h2.f545f = m410e;
                        m2134h.f550k.add(c0168h2);
                    }
                    C0168H2 m2134h2 = m2134h(this.f1249b.f6470O[1]);
                    if (m2134h2 != null) {
                        C0168H2 c0168h22 = this.f1256i;
                        c0168h22.f551l.add(m2134h2);
                        c0168h22.f545f = -this.f1249b.f6470O[1].m410e();
                        m2134h2.f550k.add(c0168h22);
                    }
                    this.f1255h.f541b = true;
                    this.f1256i.f541b = true;
                    return;
                } else if (c2224s2Arr[0].f6373f != null) {
                    C0168H2 m2134h3 = m2134h(c2224s2Arr[0]);
                    if (m2134h3 != null) {
                        C0168H2 c0168h23 = this.f1255h;
                        int m410e2 = this.f1249b.f6470O[0].m410e();
                        c0168h23.f551l.add(m2134h3);
                        c0168h23.f545f = m410e2;
                        m2134h3.f550k.add(c0168h23);
                        m2140b(this.f1256i, this.f1255h, this.f1252e.f546g);
                        return;
                    }
                    return;
                } else if (c2224s2Arr[1].f6373f != null) {
                    C0168H2 m2134h4 = m2134h(c2224s2Arr[1]);
                    if (m2134h4 != null) {
                        C0168H2 c0168h24 = this.f1256i;
                        c0168h24.f551l.add(m2134h4);
                        c0168h24.f545f = -this.f1249b.f6470O[1].m410e();
                        m2134h4.f550k.add(c0168h24);
                        m2140b(this.f1255h, this.f1256i, -this.f1252e.f546g);
                        return;
                    }
                    return;
                } else if ((c2248t25 instanceof InterfaceC2341x2) || c2248t25.f6474S == null || c2248t25.mo212n(C2224s2.EnumC2225a.CENTER).f6373f != null) {
                    return;
                } else {
                    C2248t2 c2248t26 = this.f1249b;
                    m2140b(this.f1255h, c2248t26.f6474S.f6488d.f1255h, c2248t26.m353x());
                    m2140b(this.f1256i, this.f1255h, this.f1252e.f546g);
                    return;
                }
            }
        }
        if (this.f1251d == enumC2249a) {
            C2248t2 c2248t27 = this.f1249b;
            int i = c2248t27.f6506m;
            if (i == 2) {
                C2248t2 c2248t28 = c2248t27.f6474S;
                if (c2248t28 != null) {
                    C0193I2 c0193i22 = c2248t28.f6490e.f1252e;
                    c0193i2.f551l.add(c0193i22);
                    c0193i22.f550k.add(this.f1252e);
                    C0193I2 c0193i23 = this.f1252e;
                    c0193i23.f541b = true;
                    c0193i23.f550k.add(this.f1255h);
                    this.f1252e.f550k.add(this.f1256i);
                }
            } else if (i == 3) {
                if (c2248t27.f6508n == 3) {
                    this.f1255h.f540a = this;
                    this.f1256i.f540a = this;
                    C0329O2 c0329o2 = c2248t27.f6490e;
                    c0329o2.f1255h.f540a = this;
                    c0329o2.f1256i.f540a = this;
                    c0193i2.f540a = this;
                    if (c2248t27.m383C()) {
                        this.f1252e.f551l.add(this.f1249b.f6490e.f1252e);
                        this.f1249b.f6490e.f1252e.f550k.add(this.f1252e);
                        C0329O2 c0329o22 = this.f1249b.f6490e;
                        c0329o22.f1252e.f540a = this;
                        this.f1252e.f551l.add(c0329o22.f1255h);
                        this.f1252e.f551l.add(this.f1249b.f6490e.f1256i);
                        this.f1249b.f6490e.f1255h.f550k.add(this.f1252e);
                        this.f1249b.f6490e.f1256i.f550k.add(this.f1252e);
                    } else if (this.f1249b.m384B()) {
                        this.f1249b.f6490e.f1252e.f551l.add(this.f1252e);
                        this.f1252e.f550k.add(this.f1249b.f6490e.f1252e);
                    } else {
                        this.f1249b.f6490e.f1252e.f551l.add(this.f1252e);
                    }
                } else {
                    C0193I2 c0193i24 = c2248t27.f6490e.f1252e;
                    c0193i2.f551l.add(c0193i24);
                    c0193i24.f550k.add(this.f1252e);
                    this.f1249b.f6490e.f1255h.f550k.add(this.f1252e);
                    this.f1249b.f6490e.f1256i.f550k.add(this.f1252e);
                    C0193I2 c0193i25 = this.f1252e;
                    c0193i25.f541b = true;
                    c0193i25.f550k.add(this.f1255h);
                    this.f1252e.f550k.add(this.f1256i);
                    this.f1255h.f551l.add(this.f1252e);
                    this.f1256i.f551l.add(this.f1252e);
                }
            }
        }
        C2248t2 c2248t29 = this.f1249b;
        C2224s2[] c2224s2Arr2 = c2248t29.f6470O;
        if (c2224s2Arr2[0].f6373f != null && c2224s2Arr2[1].f6373f != null) {
            if (c2248t29.m384B()) {
                this.f1255h.f545f = this.f1249b.f6470O[0].m410e();
                this.f1256i.f545f = -this.f1249b.f6470O[1].m410e();
                return;
            }
            C0168H2 m2134h5 = m2134h(this.f1249b.f6470O[0]);
            C0168H2 m2134h6 = m2134h(this.f1249b.f6470O[1]);
            m2134h5.f550k.add(this);
            if (m2134h5.f549j) {
                mo2141a(this);
            }
            m2134h6.f550k.add(this);
            if (m2134h6.f549j) {
                mo2141a(this);
            }
            this.f1257j = AbstractC0367Q2.EnumC0368a.CENTER;
        } else if (c2224s2Arr2[0].f6373f != null) {
            C0168H2 m2134h7 = m2134h(c2224s2Arr2[0]);
            if (m2134h7 != null) {
                C0168H2 c0168h25 = this.f1255h;
                int m410e3 = this.f1249b.f6470O[0].m410e();
                c0168h25.f551l.add(m2134h7);
                c0168h25.f545f = m410e3;
                m2134h7.f550k.add(c0168h25);
                m2139c(this.f1256i, this.f1255h, 1, this.f1252e);
            }
        } else if (c2224s2Arr2[1].f6373f != null) {
            C0168H2 m2134h8 = m2134h(c2224s2Arr2[1]);
            if (m2134h8 != null) {
                C0168H2 c0168h26 = this.f1256i;
                c0168h26.f551l.add(m2134h8);
                c0168h26.f545f = -this.f1249b.f6470O[1].m410e();
                m2134h8.f550k.add(c0168h26);
                m2139c(this.f1255h, this.f1256i, -1, this.f1252e);
            }
        } else if ((c2248t29 instanceof InterfaceC2341x2) || (c2248t22 = c2248t29.f6474S) == null) {
        } else {
            m2140b(this.f1255h, c2248t22.f6488d.f1255h, c2248t29.m353x());
            m2139c(this.f1256i, this.f1255h, 1, this.f1252e);
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: e */
    public void mo2137e() {
        C0168H2 c0168h2 = this.f1255h;
        if (c0168h2.f549j) {
            this.f1249b.f6479X = c0168h2.f546g;
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: f */
    public void mo2136f() {
        this.f1250c = null;
        this.f1255h.m2413b();
        this.f1256i.m2413b();
        this.f1252e.m2413b();
        this.f1254g = false;
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: k */
    public boolean mo2131k() {
        return this.f1251d != C2248t2.EnumC2249a.MATCH_CONSTRAINT || this.f1249b.f6506m == 0;
    }

    /* renamed from: m */
    public final void m2203m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else if (i5 != 1) {
                return;
            } else {
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6 && i7 <= i7) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i6 > i6 || i9 > i7) {
        } else {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* renamed from: n */
    public void m2202n() {
        this.f1254g = false;
        this.f1255h.m2413b();
        this.f1255h.f549j = false;
        this.f1256i.m2413b();
        this.f1256i.f549j = false;
        this.f1252e.f549j = false;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("HorizontalRun ");
        m253r.append(this.f1249b.f6505l0);
        return m253r.toString();
    }
}
