package p000;

import p000.C2248t2;

/* renamed from: Q2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0367Q2 implements InterfaceC0128F2 {

    /* renamed from: a */
    public int f1248a;

    /* renamed from: b */
    public C2248t2 f1249b;

    /* renamed from: c */
    public C0308N2 f1250c;

    /* renamed from: d */
    public C2248t2.EnumC2249a f1251d;

    /* renamed from: e */
    public C0193I2 f1252e = new C0193I2(this);

    /* renamed from: f */
    public int f1253f = 0;

    /* renamed from: g */
    public boolean f1254g = false;

    /* renamed from: h */
    public C0168H2 f1255h = new C0168H2(this);

    /* renamed from: i */
    public C0168H2 f1256i = new C0168H2(this);

    /* renamed from: j */
    public EnumC0368a f1257j = EnumC0368a.NONE;

    /* renamed from: Q2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC0368a {
        NONE,
        START,
        END,
        CENTER
    }

    public AbstractC0367Q2(C2248t2 c2248t2) {
        this.f1249b = c2248t2;
    }

    @Override // p000.InterfaceC0128F2
    /* renamed from: a */
    public void mo2141a(InterfaceC0128F2 interfaceC0128F2) {
    }

    /* renamed from: b */
    public final void m2140b(C0168H2 c0168h2, C0168H2 c0168h22, int i) {
        c0168h2.f551l.add(c0168h22);
        c0168h2.f545f = i;
        c0168h22.f550k.add(c0168h2);
    }

    /* renamed from: c */
    public final void m2139c(C0168H2 c0168h2, C0168H2 c0168h22, int i, C0193I2 c0193i2) {
        c0168h2.f551l.add(c0168h22);
        c0168h2.f551l.add(this.f1252e);
        c0168h2.f547h = i;
        c0168h2.f548i = c0193i2;
        c0168h22.f550k.add(c0168h2);
        c0193i2.f550k.add(c0168h2);
    }

    /* renamed from: d */
    public abstract void mo2138d();

    /* renamed from: e */
    public abstract void mo2137e();

    /* renamed from: f */
    public abstract void mo2136f();

    /* renamed from: g */
    public final int m2135g(int i, int i2) {
        int max;
        if (i2 == 0) {
            C2248t2 c2248t2 = this.f1249b;
            int i3 = c2248t2.f6514q;
            max = Math.max(c2248t2.f6512p, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            C2248t2 c2248t22 = this.f1249b;
            int i4 = c2248t22.f6520t;
            max = Math.max(c2248t22.f6518s, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    /* renamed from: h */
    public final C0168H2 m2134h(C2224s2 c2224s2) {
        C2224s2 c2224s22 = c2224s2.f6373f;
        if (c2224s22 == null) {
            return null;
        }
        C2248t2 c2248t2 = c2224s22.f6371d;
        int ordinal = c2224s22.f6372e.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal != 5) {
                            return null;
                        }
                        return c2248t2.f6490e.f1117k;
                    }
                    return c2248t2.f6490e.f1256i;
                }
                return c2248t2.f6488d.f1256i;
            }
            return c2248t2.f6490e.f1255h;
        }
        return c2248t2.f6488d.f1255h;
    }

    /* renamed from: i */
    public final C0168H2 m2133i(C2224s2 c2224s2, int i) {
        C2224s2 c2224s22 = c2224s2.f6373f;
        if (c2224s22 == null) {
            return null;
        }
        C2248t2 c2248t2 = c2224s22.f6371d;
        AbstractC0367Q2 abstractC0367Q2 = i == 0 ? c2248t2.f6488d : c2248t2.f6490e;
        int ordinal = c2224s22.f6372e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return abstractC0367Q2.f1255h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return abstractC0367Q2.f1256i;
        }
        return null;
    }

    /* renamed from: j */
    public long mo2132j() {
        C0193I2 c0193i2 = this.f1252e;
        if (c0193i2.f549j) {
            return c0193i2.f546g;
        }
        return 0L;
    }

    /* renamed from: k */
    public abstract boolean mo2131k();

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        if (r10.f1248a == 3) goto L47;
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2130l(p000.C2224s2 r13, p000.C2224s2 r14, int r15) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0367Q2.m2130l(s2, s2, int):void");
    }
}
