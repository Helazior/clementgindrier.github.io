package p000;

import java.util.HashMap;
import p000.C2224s2;
import p000.C2248t2;

/* renamed from: w2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2306w2 extends C2248t2 {

    /* renamed from: I0 */
    public float f6735I0 = -1.0f;

    /* renamed from: J0 */
    public int f6736J0 = -1;

    /* renamed from: K0 */
    public int f6737K0 = -1;

    /* renamed from: L0 */
    public C2224s2 f6738L0 = this.f6462H;

    /* renamed from: M0 */
    public int f6739M0 = 0;

    /* renamed from: N0 */
    public boolean f6740N0;

    public C2306w2() {
        this.f6471P.clear();
        this.f6471P.add(this.f6738L0);
        int length = this.f6470O.length;
        for (int i = 0; i < length; i++) {
            this.f6470O[i] = this.f6738L0;
        }
    }

    @Override // p000.C2248t2
    /* renamed from: E */
    public boolean mo219E() {
        return this.f6740N0;
    }

    @Override // p000.C2248t2
    /* renamed from: F */
    public boolean mo218F() {
        return this.f6740N0;
    }

    @Override // p000.C2248t2
    /* renamed from: U */
    public void mo217U(C1953l2 c1953l2, boolean z) {
        if (this.f6474S == null) {
            return;
        }
        int m620o = c1953l2.m620o(this.f6738L0);
        if (this.f6739M0 == 1) {
            this.f6479X = m620o;
            this.f6480Y = 0;
            m375N(this.f6474S.m360q());
            m370S(0);
            return;
        }
        this.f6479X = 0;
        this.f6480Y = m620o;
        m370S(this.f6474S.m354w());
        m375N(0);
    }

    /* renamed from: V */
    public void m216V(int i) {
        C2224s2 c2224s2 = this.f6738L0;
        c2224s2.f6369b = i;
        c2224s2.f6370c = true;
        this.f6740N0 = true;
    }

    /* renamed from: W */
    public void m215W(int i) {
        if (this.f6739M0 == i) {
            return;
        }
        this.f6739M0 = i;
        this.f6471P.clear();
        if (this.f6739M0 == 1) {
            this.f6738L0 = this.f6460G;
        } else {
            this.f6738L0 = this.f6462H;
        }
        this.f6471P.add(this.f6738L0);
        int length = this.f6470O.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f6470O[i2] = this.f6738L0;
        }
    }

    @Override // p000.C2248t2
    /* renamed from: f */
    public void mo214f(C1953l2 c1953l2, boolean z) {
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.WRAP_CONTENT;
        C2269u2 c2269u2 = (C2269u2) this.f6474S;
        if (c2269u2 == null) {
            return;
        }
        Object mo212n = c2269u2.mo212n(C2224s2.EnumC2225a.LEFT);
        Object mo212n2 = c2269u2.mo212n(C2224s2.EnumC2225a.RIGHT);
        C2248t2 c2248t2 = this.f6474S;
        boolean z2 = true;
        boolean z3 = c2248t2 != null && c2248t2.f6473R[0] == enumC2249a;
        if (this.f6739M0 == 0) {
            mo212n = c2269u2.mo212n(C2224s2.EnumC2225a.TOP);
            mo212n2 = c2269u2.mo212n(C2224s2.EnumC2225a.BOTTOM);
            C2248t2 c2248t22 = this.f6474S;
            z3 = (c2248t22 == null || c2248t22.f6473R[1] != enumC2249a) ? false : false;
        }
        if (this.f6740N0) {
            C2224s2 c2224s2 = this.f6738L0;
            if (c2224s2.f6370c) {
                C2168p2 m623l = c1953l2.m623l(c2224s2);
                c1953l2.m630e(m623l, this.f6738L0.m411d());
                if (this.f6736J0 != -1) {
                    if (z3) {
                        c1953l2.m629f(c1953l2.m623l(mo212n2), m623l, 0, 5);
                    }
                } else if (this.f6737K0 != -1 && z3) {
                    C2168p2 m623l2 = c1953l2.m623l(mo212n2);
                    c1953l2.m629f(m623l, c1953l2.m623l(mo212n), 0, 5);
                    c1953l2.m629f(m623l2, m623l, 0, 5);
                }
                this.f6740N0 = false;
                return;
            }
        }
        if (this.f6736J0 != -1) {
            C2168p2 m623l3 = c1953l2.m623l(this.f6738L0);
            c1953l2.m631d(m623l3, c1953l2.m623l(mo212n), this.f6736J0, 8);
            if (z3) {
                c1953l2.m629f(c1953l2.m623l(mo212n2), m623l3, 0, 5);
            }
        } else if (this.f6737K0 != -1) {
            C2168p2 m623l4 = c1953l2.m623l(this.f6738L0);
            C2168p2 m623l5 = c1953l2.m623l(mo212n2);
            c1953l2.m631d(m623l4, m623l5, -this.f6737K0, 8);
            if (z3) {
                c1953l2.m629f(m623l4, c1953l2.m623l(mo212n), 0, 5);
                c1953l2.m629f(m623l5, m623l4, 0, 5);
            }
        } else if (this.f6735I0 != -1.0f) {
            C2168p2 m623l6 = c1953l2.m623l(this.f6738L0);
            C2168p2 m623l7 = c1953l2.m623l(mo212n2);
            float f = this.f6735I0;
            C1909j2 m622m = c1953l2.m622m();
            m622m.f5316d.mo707f(m623l6, -1.0f);
            m622m.f5316d.mo707f(m623l7, f);
            c1953l2.m632c(m622m);
        }
    }

    @Override // p000.C2248t2
    /* renamed from: g */
    public boolean mo213g() {
        return true;
    }

    @Override // p000.C2248t2
    /* renamed from: k */
    public void mo64k(C2248t2 c2248t2, HashMap<C2248t2, C2248t2> hashMap) {
        super.mo64k(c2248t2, hashMap);
        C2306w2 c2306w2 = (C2306w2) c2248t2;
        this.f6735I0 = c2306w2.f6735I0;
        this.f6736J0 = c2306w2.f6736J0;
        this.f6737K0 = c2306w2.f6737K0;
        m215W(c2306w2.f6739M0);
    }

    @Override // p000.C2248t2
    /* renamed from: n */
    public C2224s2 mo212n(C2224s2.EnumC2225a enumC2225a) {
        switch (enumC2225a.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.f6739M0 == 1) {
                    return this.f6738L0;
                }
                break;
            case 2:
            case 4:
                if (this.f6739M0 == 0) {
                    return this.f6738L0;
                }
                break;
        }
        throw new AssertionError(enumC2225a.name());
    }
}
