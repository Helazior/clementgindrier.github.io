package p000;

import java.util.HashMap;
import p000.C2224s2;
import p000.C2248t2;

/* renamed from: q2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2189q2 extends C2363y2 {

    /* renamed from: K0 */
    public int f6257K0 = 0;

    /* renamed from: L0 */
    public boolean f6258L0 = true;

    /* renamed from: M0 */
    public int f6259M0 = 0;

    /* renamed from: N0 */
    public boolean f6260N0 = false;

    @Override // p000.C2248t2
    /* renamed from: E */
    public boolean mo219E() {
        return this.f6260N0;
    }

    @Override // p000.C2248t2
    /* renamed from: F */
    public boolean mo218F() {
        return this.f6260N0;
    }

    /* renamed from: W */
    public boolean m435W() {
        int i;
        int i2;
        int i3;
        C2224s2.EnumC2225a enumC2225a = C2224s2.EnumC2225a.BOTTOM;
        C2224s2.EnumC2225a enumC2225a2 = C2224s2.EnumC2225a.TOP;
        C2224s2.EnumC2225a enumC2225a3 = C2224s2.EnumC2225a.RIGHT;
        C2224s2.EnumC2225a enumC2225a4 = C2224s2.EnumC2225a.LEFT;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.f6853J0;
            if (i4 >= i) {
                break;
            }
            C2248t2 c2248t2 = this.f6852I0[i4];
            if ((this.f6258L0 || c2248t2.mo213g()) && ((((i2 = this.f6257K0) == 0 || i2 == 1) && !c2248t2.mo219E()) || (((i3 = this.f6257K0) == 2 || i3 == 3) && !c2248t2.mo218F()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.f6853J0; i6++) {
            C2248t2 c2248t22 = this.f6852I0[i6];
            if (this.f6258L0 || c2248t22.mo213g()) {
                if (!z2) {
                    int i7 = this.f6257K0;
                    if (i7 == 0) {
                        i5 = c2248t22.mo212n(enumC2225a4).m411d();
                    } else if (i7 == 1) {
                        i5 = c2248t22.mo212n(enumC2225a3).m411d();
                    } else if (i7 == 2) {
                        i5 = c2248t22.mo212n(enumC2225a2).m411d();
                    } else if (i7 == 3) {
                        i5 = c2248t22.mo212n(enumC2225a).m411d();
                    }
                    z2 = true;
                }
                int i8 = this.f6257K0;
                if (i8 == 0) {
                    i5 = Math.min(i5, c2248t22.mo212n(enumC2225a4).m411d());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, c2248t22.mo212n(enumC2225a3).m411d());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, c2248t22.mo212n(enumC2225a2).m411d());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, c2248t22.mo212n(enumC2225a).m411d());
                }
            }
        }
        int i9 = i5 + this.f6259M0;
        int i10 = this.f6257K0;
        if (i10 != 0 && i10 != 1) {
            m376M(i9, i9);
        } else {
            m377L(i9, i9);
        }
        this.f6260N0 = true;
        return true;
    }

    /* renamed from: X */
    public int m434X() {
        int i = this.f6257K0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // p000.C2248t2
    /* renamed from: f */
    public void mo214f(C1953l2 c1953l2, boolean z) {
        Object[] objArr;
        boolean z2;
        int i;
        int i2;
        int i3;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        C2224s2[] c2224s2Arr = this.f6470O;
        c2224s2Arr[0] = this.f6460G;
        c2224s2Arr[2] = this.f6462H;
        c2224s2Arr[1] = this.f6464I;
        c2224s2Arr[3] = this.f6465J;
        int i4 = 0;
        while (true) {
            objArr = this.f6470O;
            if (i4 >= objArr.length) {
                break;
            }
            objArr[i4].f6376i = c1953l2.m623l(objArr[i4]);
            i4++;
        }
        int i5 = this.f6257K0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        C2224s2 c2224s2 = objArr[i5];
        if (!this.f6260N0) {
            m435W();
        }
        if (this.f6260N0) {
            this.f6260N0 = false;
            int i6 = this.f6257K0;
            if (i6 == 0 || i6 == 1) {
                c1953l2.m630e(this.f6460G.f6376i, this.f6479X);
                c1953l2.m630e(this.f6464I.f6376i, this.f6479X);
                return;
            } else if (i6 == 2 || i6 == 3) {
                c1953l2.m630e(this.f6462H.f6376i, this.f6480Y);
                c1953l2.m630e(this.f6465J.f6376i, this.f6480Y);
                return;
            } else {
                return;
            }
        }
        for (int i7 = 0; i7 < this.f6853J0; i7++) {
            C2248t2 c2248t2 = this.f6852I0[i7];
            if ((this.f6258L0 || c2248t2.mo213g()) && ((((i2 = this.f6257K0) == 0 || i2 == 1) && c2248t2.m359r() == enumC2249a && c2248t2.f6460G.f6373f != null && c2248t2.f6464I.f6373f != null) || (((i3 = this.f6257K0) == 2 || i3 == 3) && c2248t2.m355v() == enumC2249a && c2248t2.f6462H.f6373f != null && c2248t2.f6465J.f6373f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.f6460G.m408g() || this.f6464I.m408g();
        boolean z4 = this.f6462H.m408g() || this.f6465J.m408g();
        int i8 = !z2 && (((i = this.f6257K0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4)))) ? 5 : 4;
        for (int i9 = 0; i9 < this.f6853J0; i9++) {
            C2248t2 c2248t22 = this.f6852I0[i9];
            if (this.f6258L0 || c2248t22.mo213g()) {
                C2168p2 m623l = c1953l2.m623l(c2248t22.f6470O[this.f6257K0]);
                C2224s2[] c2224s2Arr2 = c2248t22.f6470O;
                int i10 = this.f6257K0;
                c2224s2Arr2[i10].f6376i = m623l;
                int i11 = (c2224s2Arr2[i10].f6373f == null || c2224s2Arr2[i10].f6373f.f6371d != this) ? 0 : c2224s2Arr2[i10].f6374g + 0;
                if (i10 != 0 && i10 != 2) {
                    C1909j2 m622m = c1953l2.m622m();
                    C2168p2 m621n = c1953l2.m621n();
                    m621n.f6180d = 0;
                    m622m.m719e(c2224s2.f6376i, m623l, m621n, this.f6259M0 + i11);
                    c1953l2.m632c(m622m);
                } else {
                    C1909j2 m622m2 = c1953l2.m622m();
                    C2168p2 m621n2 = c1953l2.m621n();
                    m621n2.f6180d = 0;
                    m622m2.m718f(c2224s2.f6376i, m623l, m621n2, this.f6259M0 - i11);
                    c1953l2.m632c(m622m2);
                }
                c1953l2.m631d(c2224s2.f6376i, m623l, this.f6259M0 + i11, i8);
            }
        }
        int i12 = this.f6257K0;
        if (i12 == 0) {
            c1953l2.m631d(this.f6464I.f6376i, this.f6460G.f6376i, 0, 8);
            c1953l2.m631d(this.f6460G.f6376i, this.f6474S.f6464I.f6376i, 0, 4);
            c1953l2.m631d(this.f6460G.f6376i, this.f6474S.f6460G.f6376i, 0, 0);
        } else if (i12 == 1) {
            c1953l2.m631d(this.f6460G.f6376i, this.f6464I.f6376i, 0, 8);
            c1953l2.m631d(this.f6460G.f6376i, this.f6474S.f6460G.f6376i, 0, 4);
            c1953l2.m631d(this.f6460G.f6376i, this.f6474S.f6464I.f6376i, 0, 0);
        } else if (i12 == 2) {
            c1953l2.m631d(this.f6465J.f6376i, this.f6462H.f6376i, 0, 8);
            c1953l2.m631d(this.f6462H.f6376i, this.f6474S.f6465J.f6376i, 0, 4);
            c1953l2.m631d(this.f6462H.f6376i, this.f6474S.f6462H.f6376i, 0, 0);
        } else if (i12 == 3) {
            c1953l2.m631d(this.f6462H.f6376i, this.f6465J.f6376i, 0, 8);
            c1953l2.m631d(this.f6462H.f6376i, this.f6474S.f6462H.f6376i, 0, 4);
            c1953l2.m631d(this.f6462H.f6376i, this.f6474S.f6465J.f6376i, 0, 0);
        }
    }

    @Override // p000.C2248t2
    /* renamed from: g */
    public boolean mo213g() {
        return true;
    }

    @Override // p000.C2363y2, p000.C2248t2
    /* renamed from: k */
    public void mo64k(C2248t2 c2248t2, HashMap<C2248t2, C2248t2> hashMap) {
        super.mo64k(c2248t2, hashMap);
        C2189q2 c2189q2 = (C2189q2) c2248t2;
        this.f6257K0 = c2189q2.f6257K0;
        this.f6258L0 = c2189q2.f6258L0;
        this.f6259M0 = c2189q2.f6259M0;
    }

    @Override // p000.C2248t2
    public String toString() {
        String m262i = outline.m262i(outline.m253r("[Barrier] "), this.f6505l0, " {");
        for (int i = 0; i < this.f6853J0; i++) {
            C2248t2 c2248t2 = this.f6852I0[i];
            if (i > 0) {
                m262i = outline.m266e(m262i, ", ");
            }
            StringBuilder m253r = outline.m253r(m262i);
            m253r.append(c2248t2.f6505l0);
            m262i = m253r.toString();
        }
        return outline.m266e(m262i, "}");
    }
}
