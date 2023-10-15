package p000;

import p000.AbstractC0367Q2;
import p000.C0168H2;
import p000.C2224s2;
import p000.C2248t2;

/* renamed from: O2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0329O2 extends AbstractC0367Q2 {

    /* renamed from: k */
    public C0168H2 f1117k;

    /* renamed from: l */
    public C0193I2 f1118l;

    public C0329O2(C2248t2 c2248t2) {
        super(c2248t2);
        C0168H2 c0168h2 = new C0168H2(this);
        this.f1117k = c0168h2;
        this.f1118l = null;
        this.f1255h.f544e = C0168H2.EnumC0169a.TOP;
        this.f1256i.f544e = C0168H2.EnumC0169a.BOTTOM;
        c0168h2.f544e = C0168H2.EnumC0169a.BASELINE;
        this.f1253f = 1;
    }

    @Override // p000.AbstractC0367Q2, p000.InterfaceC0128F2
    /* renamed from: a */
    public void mo2141a(InterfaceC0128F2 interfaceC0128F2) {
        C0193I2 c0193i2;
        float f;
        float f2;
        float f3;
        int i;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        int ordinal = this.f1257j.ordinal();
        if (ordinal != 1 && ordinal != 2 && ordinal == 3) {
            C2248t2 c2248t2 = this.f1249b;
            m2130l(c2248t2.f6462H, c2248t2.f6465J, 1);
            return;
        }
        C0193I2 c0193i22 = this.f1252e;
        if (c0193i22.f542c && !c0193i22.f549j && this.f1251d == enumC2249a) {
            C2248t2 c2248t22 = this.f1249b;
            int i2 = c2248t22.f6508n;
            if (i2 == 2) {
                C2248t2 c2248t23 = c2248t22.f6474S;
                if (c2248t23 != null) {
                    if (c2248t23.f6490e.f1252e.f549j) {
                        c0193i22.mo2389c((int) ((c0193i2.f546g * c2248t22.f6522u) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                C0193I2 c0193i23 = c2248t22.f6488d.f1252e;
                if (c0193i23.f549j) {
                    int i3 = c2248t22.f6478W;
                    if (i3 == -1) {
                        f = c0193i23.f546g;
                        f2 = c2248t22.f6477V;
                    } else if (i3 == 0) {
                        f3 = c0193i23.f546g * c2248t22.f6477V;
                        i = (int) (f3 + 0.5f);
                        c0193i22.mo2389c(i);
                    } else if (i3 == 1) {
                        f = c0193i23.f546g;
                        f2 = c2248t22.f6477V;
                    } else {
                        i = 0;
                        c0193i22.mo2389c(i);
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    c0193i22.mo2389c(i);
                }
            }
        }
        C0168H2 c0168h2 = this.f1255h;
        if (c0168h2.f542c) {
            C0168H2 c0168h22 = this.f1256i;
            if (c0168h22.f542c) {
                if (c0168h2.f549j && c0168h22.f549j && this.f1252e.f549j) {
                    return;
                }
                if (!this.f1252e.f549j && this.f1251d == enumC2249a) {
                    C2248t2 c2248t24 = this.f1249b;
                    if (c2248t24.f6506m == 0 && !c2248t24.m383C()) {
                        int i4 = this.f1255h.f551l.get(0).f546g;
                        C0168H2 c0168h23 = this.f1255h;
                        int i5 = i4 + c0168h23.f545f;
                        int i6 = this.f1256i.f551l.get(0).f546g + this.f1256i.f545f;
                        c0168h23.mo2389c(i5);
                        this.f1256i.mo2389c(i6);
                        this.f1252e.mo2389c(i6 - i5);
                        return;
                    }
                }
                if (!this.f1252e.f549j && this.f1251d == enumC2249a && this.f1248a == 1 && this.f1255h.f551l.size() > 0 && this.f1256i.f551l.size() > 0) {
                    int i7 = (this.f1256i.f551l.get(0).f546g + this.f1256i.f545f) - (this.f1255h.f551l.get(0).f546g + this.f1255h.f545f);
                    C0193I2 c0193i24 = this.f1252e;
                    int i8 = c0193i24.f631m;
                    if (i7 < i8) {
                        c0193i24.mo2389c(i7);
                    } else {
                        c0193i24.mo2389c(i8);
                    }
                }
                if (this.f1252e.f549j && this.f1255h.f551l.size() > 0 && this.f1256i.f551l.size() > 0) {
                    C0168H2 c0168h24 = this.f1255h.f551l.get(0);
                    C0168H2 c0168h25 = this.f1256i.f551l.get(0);
                    int i9 = c0168h24.f546g;
                    C0168H2 c0168h26 = this.f1255h;
                    int i10 = c0168h26.f545f + i9;
                    int i11 = c0168h25.f546g;
                    int i12 = this.f1256i.f545f + i11;
                    float f4 = this.f1249b.f6497h0;
                    if (c0168h24 == c0168h25) {
                        f4 = 0.5f;
                    } else {
                        i9 = i10;
                        i11 = i12;
                    }
                    c0168h26.mo2389c((int) ((((i11 - i9) - this.f1252e.f546g) * f4) + i9 + 0.5f));
                    this.f1256i.mo2389c(this.f1255h.f546g + this.f1252e.f546g);
                }
            }
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: d */
    public void mo2138d() {
        C2248t2 c2248t2;
        C2248t2 c2248t22;
        C2248t2 c2248t23;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_PARENT;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.FIXED;
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        C2248t2 c2248t24 = this.f1249b;
        if (c2248t24.f6482a) {
            this.f1252e.mo2389c(c2248t24.m360q());
        }
        if (!this.f1252e.f549j) {
            this.f1251d = this.f1249b.m355v();
            if (this.f1249b.f6450B) {
                this.f1118l = new C0054C2(this);
            }
            C2248t2.EnumC2249a enumC2249a4 = this.f1251d;
            if (enumC2249a4 != enumC2249a3) {
                if (enumC2249a4 == enumC2249a && (c2248t23 = this.f1249b.f6474S) != null && c2248t23.m355v() == enumC2249a2) {
                    int m360q = (c2248t23.m360q() - this.f1249b.f6462H.m410e()) - this.f1249b.f6465J.m410e();
                    m2140b(this.f1255h, c2248t23.f6490e.f1255h, this.f1249b.f6462H.m410e());
                    m2140b(this.f1256i, c2248t23.f6490e.f1256i, -this.f1249b.f6465J.m410e());
                    this.f1252e.mo2389c(m360q);
                    return;
                } else if (this.f1251d == enumC2249a2) {
                    this.f1252e.mo2389c(this.f1249b.m360q());
                }
            }
        } else if (this.f1251d == enumC2249a && (c2248t2 = this.f1249b.f6474S) != null && c2248t2.m355v() == enumC2249a2) {
            m2140b(this.f1255h, c2248t2.f6490e.f1255h, this.f1249b.f6462H.m410e());
            m2140b(this.f1256i, c2248t2.f6490e.f1256i, -this.f1249b.f6465J.m410e());
            return;
        }
        C0193I2 c0193i2 = this.f1252e;
        boolean z = c0193i2.f549j;
        if (z) {
            C2248t2 c2248t25 = this.f1249b;
            if (c2248t25.f6482a) {
                C2224s2[] c2224s2Arr = c2248t25.f6470O;
                if (c2224s2Arr[2].f6373f != null && c2224s2Arr[3].f6373f != null) {
                    if (c2248t25.m383C()) {
                        this.f1255h.f545f = this.f1249b.f6470O[2].m410e();
                        this.f1256i.f545f = -this.f1249b.f6470O[3].m410e();
                    } else {
                        C0168H2 m2134h = m2134h(this.f1249b.f6470O[2]);
                        if (m2134h != null) {
                            C0168H2 c0168h2 = this.f1255h;
                            int m410e = this.f1249b.f6470O[2].m410e();
                            c0168h2.f551l.add(m2134h);
                            c0168h2.f545f = m410e;
                            m2134h.f550k.add(c0168h2);
                        }
                        C0168H2 m2134h2 = m2134h(this.f1249b.f6470O[3]);
                        if (m2134h2 != null) {
                            C0168H2 c0168h22 = this.f1256i;
                            c0168h22.f551l.add(m2134h2);
                            c0168h22.f545f = -this.f1249b.f6470O[3].m410e();
                            m2134h2.f550k.add(c0168h22);
                        }
                        this.f1255h.f541b = true;
                        this.f1256i.f541b = true;
                    }
                    C2248t2 c2248t26 = this.f1249b;
                    if (c2248t26.f6450B) {
                        m2140b(this.f1117k, this.f1255h, c2248t26.f6489d0);
                        return;
                    }
                    return;
                } else if (c2224s2Arr[2].f6373f != null) {
                    C0168H2 m2134h3 = m2134h(c2224s2Arr[2]);
                    if (m2134h3 != null) {
                        C0168H2 c0168h23 = this.f1255h;
                        int m410e2 = this.f1249b.f6470O[2].m410e();
                        c0168h23.f551l.add(m2134h3);
                        c0168h23.f545f = m410e2;
                        m2134h3.f550k.add(c0168h23);
                        m2140b(this.f1256i, this.f1255h, this.f1252e.f546g);
                        C2248t2 c2248t27 = this.f1249b;
                        if (c2248t27.f6450B) {
                            m2140b(this.f1117k, this.f1255h, c2248t27.f6489d0);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (c2224s2Arr[3].f6373f != null) {
                    C0168H2 m2134h4 = m2134h(c2224s2Arr[3]);
                    if (m2134h4 != null) {
                        C0168H2 c0168h24 = this.f1256i;
                        c0168h24.f551l.add(m2134h4);
                        c0168h24.f545f = -this.f1249b.f6470O[3].m410e();
                        m2134h4.f550k.add(c0168h24);
                        m2140b(this.f1255h, this.f1256i, -this.f1252e.f546g);
                    }
                    C2248t2 c2248t28 = this.f1249b;
                    if (c2248t28.f6450B) {
                        m2140b(this.f1117k, this.f1255h, c2248t28.f6489d0);
                        return;
                    }
                    return;
                } else if (c2224s2Arr[4].f6373f != null) {
                    C0168H2 m2134h5 = m2134h(c2224s2Arr[4]);
                    if (m2134h5 != null) {
                        C0168H2 c0168h25 = this.f1117k;
                        c0168h25.f551l.add(m2134h5);
                        c0168h25.f545f = 0;
                        m2134h5.f550k.add(c0168h25);
                        m2140b(this.f1255h, this.f1117k, -this.f1249b.f6489d0);
                        m2140b(this.f1256i, this.f1255h, this.f1252e.f546g);
                        return;
                    }
                    return;
                } else if ((c2248t25 instanceof InterfaceC2341x2) || c2248t25.f6474S == null || c2248t25.mo212n(C2224s2.EnumC2225a.CENTER).f6373f != null) {
                    return;
                } else {
                    C2248t2 c2248t29 = this.f1249b;
                    m2140b(this.f1255h, c2248t29.f6474S.f6490e.f1255h, c2248t29.m352y());
                    m2140b(this.f1256i, this.f1255h, this.f1252e.f546g);
                    C2248t2 c2248t210 = this.f1249b;
                    if (c2248t210.f6450B) {
                        m2140b(this.f1117k, this.f1255h, c2248t210.f6489d0);
                        return;
                    }
                    return;
                }
            }
        }
        if (!z && this.f1251d == enumC2249a3) {
            C2248t2 c2248t211 = this.f1249b;
            int i = c2248t211.f6508n;
            if (i != 2) {
                if (i == 3 && !c2248t211.m383C()) {
                    C2248t2 c2248t212 = this.f1249b;
                    if (c2248t212.f6506m != 3) {
                        C0193I2 c0193i22 = c2248t212.f6488d.f1252e;
                        this.f1252e.f551l.add(c0193i22);
                        c0193i22.f550k.add(this.f1252e);
                        C0193I2 c0193i23 = this.f1252e;
                        c0193i23.f541b = true;
                        c0193i23.f550k.add(this.f1255h);
                        this.f1252e.f550k.add(this.f1256i);
                    }
                }
            } else {
                C2248t2 c2248t213 = c2248t211.f6474S;
                if (c2248t213 != null) {
                    C0193I2 c0193i24 = c2248t213.f6490e.f1252e;
                    c0193i2.f551l.add(c0193i24);
                    c0193i24.f550k.add(this.f1252e);
                    C0193I2 c0193i25 = this.f1252e;
                    c0193i25.f541b = true;
                    c0193i25.f550k.add(this.f1255h);
                    this.f1252e.f550k.add(this.f1256i);
                }
            }
        } else {
            c0193i2.f550k.add(this);
            if (c0193i2.f549j) {
                mo2141a(this);
            }
        }
        C2248t2 c2248t214 = this.f1249b;
        C2224s2[] c2224s2Arr2 = c2248t214.f6470O;
        if (c2224s2Arr2[2].f6373f != null && c2224s2Arr2[3].f6373f != null) {
            if (c2248t214.m383C()) {
                this.f1255h.f545f = this.f1249b.f6470O[2].m410e();
                this.f1256i.f545f = -this.f1249b.f6470O[3].m410e();
            } else {
                C0168H2 m2134h6 = m2134h(this.f1249b.f6470O[2]);
                C0168H2 m2134h7 = m2134h(this.f1249b.f6470O[3]);
                m2134h6.f550k.add(this);
                if (m2134h6.f549j) {
                    mo2141a(this);
                }
                m2134h7.f550k.add(this);
                if (m2134h7.f549j) {
                    mo2141a(this);
                }
                this.f1257j = AbstractC0367Q2.EnumC0368a.CENTER;
            }
            if (this.f1249b.f6450B) {
                m2139c(this.f1117k, this.f1255h, 1, this.f1118l);
            }
        } else if (c2224s2Arr2[2].f6373f != null) {
            C0168H2 m2134h8 = m2134h(c2224s2Arr2[2]);
            if (m2134h8 != null) {
                C0168H2 c0168h26 = this.f1255h;
                int m410e3 = this.f1249b.f6470O[2].m410e();
                c0168h26.f551l.add(m2134h8);
                c0168h26.f545f = m410e3;
                m2134h8.f550k.add(c0168h26);
                m2139c(this.f1256i, this.f1255h, 1, this.f1252e);
                if (this.f1249b.f6450B) {
                    m2139c(this.f1117k, this.f1255h, 1, this.f1118l);
                }
                if (this.f1251d == enumC2249a3) {
                    C2248t2 c2248t215 = this.f1249b;
                    if (c2248t215.f6477V > 0.0f) {
                        C0285M2 c0285m2 = c2248t215.f6488d;
                        if (c0285m2.f1251d == enumC2249a3) {
                            c0285m2.f1252e.f550k.add(this.f1252e);
                            this.f1252e.f551l.add(this.f1249b.f6488d.f1252e);
                            this.f1252e.f540a = this;
                        }
                    }
                }
            }
        } else if (c2224s2Arr2[3].f6373f != null) {
            C0168H2 m2134h9 = m2134h(c2224s2Arr2[3]);
            if (m2134h9 != null) {
                C0168H2 c0168h27 = this.f1256i;
                c0168h27.f551l.add(m2134h9);
                c0168h27.f545f = -this.f1249b.f6470O[3].m410e();
                m2134h9.f550k.add(c0168h27);
                m2139c(this.f1255h, this.f1256i, -1, this.f1252e);
                if (this.f1249b.f6450B) {
                    m2139c(this.f1117k, this.f1255h, 1, this.f1118l);
                }
            }
        } else if (c2224s2Arr2[4].f6373f != null) {
            C0168H2 m2134h10 = m2134h(c2224s2Arr2[4]);
            if (m2134h10 != null) {
                C0168H2 c0168h28 = this.f1117k;
                c0168h28.f551l.add(m2134h10);
                c0168h28.f545f = 0;
                m2134h10.f550k.add(c0168h28);
                m2139c(this.f1255h, this.f1117k, -1, this.f1118l);
                m2139c(this.f1256i, this.f1255h, 1, this.f1252e);
            }
        } else if (!(c2248t214 instanceof InterfaceC2341x2) && (c2248t22 = c2248t214.f6474S) != null) {
            m2140b(this.f1255h, c2248t22.f6490e.f1255h, c2248t214.m352y());
            m2139c(this.f1256i, this.f1255h, 1, this.f1252e);
            if (this.f1249b.f6450B) {
                m2139c(this.f1117k, this.f1255h, 1, this.f1118l);
            }
            if (this.f1251d == enumC2249a3) {
                C2248t2 c2248t216 = this.f1249b;
                if (c2248t216.f6477V > 0.0f) {
                    C0285M2 c0285m22 = c2248t216.f6488d;
                    if (c0285m22.f1251d == enumC2249a3) {
                        c0285m22.f1252e.f550k.add(this.f1252e);
                        this.f1252e.f551l.add(this.f1249b.f6488d.f1252e);
                        this.f1252e.f540a = this;
                    }
                }
            }
        }
        if (this.f1252e.f551l.size() == 0) {
            this.f1252e.f542c = true;
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: e */
    public void mo2137e() {
        C0168H2 c0168h2 = this.f1255h;
        if (c0168h2.f549j) {
            this.f1249b.f6480Y = c0168h2.f546g;
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: f */
    public void mo2136f() {
        this.f1250c = null;
        this.f1255h.m2413b();
        this.f1256i.m2413b();
        this.f1117k.m2413b();
        this.f1252e.m2413b();
        this.f1254g = false;
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: k */
    public boolean mo2131k() {
        return this.f1251d != C2248t2.EnumC2249a.MATCH_CONSTRAINT || this.f1249b.f6508n == 0;
    }

    /* renamed from: m */
    public void m2164m() {
        this.f1254g = false;
        this.f1255h.m2413b();
        this.f1255h.f549j = false;
        this.f1256i.m2413b();
        this.f1256i.f549j = false;
        this.f1117k.m2413b();
        this.f1117k.f549j = false;
        this.f1252e.f549j = false;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("VerticalRun ");
        m253r.append(this.f1249b.f6505l0);
        return m253r.toString();
    }
}
