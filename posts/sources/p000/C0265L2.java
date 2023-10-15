package p000;

import p000.C0168H2;

/* renamed from: L2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0265L2 extends AbstractC0367Q2 {
    public C0265L2(C2248t2 c2248t2) {
        super(c2248t2);
    }

    @Override // p000.AbstractC0367Q2, p000.InterfaceC0128F2
    /* renamed from: a */
    public void mo2141a(InterfaceC0128F2 interfaceC0128F2) {
        C2189q2 c2189q2 = (C2189q2) this.f1249b;
        int i = c2189q2.f6257K0;
        int i2 = 0;
        int i3 = -1;
        for (C0168H2 c0168h2 : this.f1255h.f551l) {
            int i4 = c0168h2.f546g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i != 0 && i != 2) {
            this.f1255h.mo2389c(i2 + c2189q2.f6259M0);
        } else {
            this.f1255h.mo2389c(i3 + c2189q2.f6259M0);
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: d */
    public void mo2138d() {
        C2248t2 c2248t2 = this.f1249b;
        if (c2248t2 instanceof C2189q2) {
            C0168H2 c0168h2 = this.f1255h;
            c0168h2.f541b = true;
            C2189q2 c2189q2 = (C2189q2) c2248t2;
            int i = c2189q2.f6257K0;
            boolean z = c2189q2.f6258L0;
            int i2 = 0;
            if (i == 0) {
                c0168h2.f544e = C0168H2.EnumC0169a.LEFT;
                while (i2 < c2189q2.f6853J0) {
                    C2248t2 c2248t22 = c2189q2.f6852I0[i2];
                    if (z || c2248t22.f6503k0 != 8) {
                        C0168H2 c0168h22 = c2248t22.f6488d.f1255h;
                        c0168h22.f550k.add(this.f1255h);
                        this.f1255h.f551l.add(c0168h22);
                    }
                    i2++;
                }
                m2221m(this.f1249b.f6488d.f1255h);
                m2221m(this.f1249b.f6488d.f1256i);
            } else if (i == 1) {
                c0168h2.f544e = C0168H2.EnumC0169a.RIGHT;
                while (i2 < c2189q2.f6853J0) {
                    C2248t2 c2248t23 = c2189q2.f6852I0[i2];
                    if (z || c2248t23.f6503k0 != 8) {
                        C0168H2 c0168h23 = c2248t23.f6488d.f1256i;
                        c0168h23.f550k.add(this.f1255h);
                        this.f1255h.f551l.add(c0168h23);
                    }
                    i2++;
                }
                m2221m(this.f1249b.f6488d.f1255h);
                m2221m(this.f1249b.f6488d.f1256i);
            } else if (i == 2) {
                c0168h2.f544e = C0168H2.EnumC0169a.TOP;
                while (i2 < c2189q2.f6853J0) {
                    C2248t2 c2248t24 = c2189q2.f6852I0[i2];
                    if (z || c2248t24.f6503k0 != 8) {
                        C0168H2 c0168h24 = c2248t24.f6490e.f1255h;
                        c0168h24.f550k.add(this.f1255h);
                        this.f1255h.f551l.add(c0168h24);
                    }
                    i2++;
                }
                m2221m(this.f1249b.f6490e.f1255h);
                m2221m(this.f1249b.f6490e.f1256i);
            } else if (i != 3) {
            } else {
                c0168h2.f544e = C0168H2.EnumC0169a.BOTTOM;
                while (i2 < c2189q2.f6853J0) {
                    C2248t2 c2248t25 = c2189q2.f6852I0[i2];
                    if (z || c2248t25.f6503k0 != 8) {
                        C0168H2 c0168h25 = c2248t25.f6490e.f1256i;
                        c0168h25.f550k.add(this.f1255h);
                        this.f1255h.f551l.add(c0168h25);
                    }
                    i2++;
                }
                m2221m(this.f1249b.f6490e.f1255h);
                m2221m(this.f1249b.f6490e.f1256i);
            }
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: e */
    public void mo2137e() {
        C2248t2 c2248t2 = this.f1249b;
        if (c2248t2 instanceof C2189q2) {
            int i = ((C2189q2) c2248t2).f6257K0;
            if (i != 0 && i != 1) {
                c2248t2.f6480Y = this.f1255h.f546g;
            } else {
                c2248t2.f6479X = this.f1255h.f546g;
            }
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: f */
    public void mo2136f() {
        this.f1250c = null;
        this.f1255h.m2413b();
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: k */
    public boolean mo2131k() {
        return false;
    }

    /* renamed from: m */
    public final void m2221m(C0168H2 c0168h2) {
        this.f1255h.f550k.add(c0168h2);
        c0168h2.f551l.add(this.f1255h);
    }
}
