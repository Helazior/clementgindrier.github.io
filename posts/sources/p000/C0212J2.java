package p000;

import java.util.HashSet;
import java.util.Iterator;
import p000.C0083D2;
import p000.C2224s2;
import p000.C2248t2;

/* renamed from: J2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0212J2 {

    /* renamed from: a */
    public static C0083D2.C0084a f677a = new C0083D2.C0084a();

    /* renamed from: a */
    public static boolean m2382a(C2248t2 c2248t2) {
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.WRAP_CONTENT;
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.FIXED;
        C2248t2.EnumC2249a m359r = c2248t2.m359r();
        C2248t2.EnumC2249a m355v = c2248t2.m355v();
        C2248t2 c2248t22 = c2248t2.f6474S;
        C2269u2 c2269u2 = c2248t22 != null ? (C2269u2) c2248t22 : null;
        if (c2269u2 != null) {
            c2269u2.m359r();
        }
        if (c2269u2 != null) {
            c2269u2.m355v();
        }
        boolean z = m359r == enumC2249a3 || m359r == enumC2249a2 || (m359r == enumC2249a && c2248t2.f6506m == 0 && c2248t2.f6477V == 0.0f && c2248t2.m351z(0)) || c2248t2.mo219E();
        boolean z2 = m355v == enumC2249a3 || m355v == enumC2249a2 || (m355v == enumC2249a && c2248t2.f6508n == 0 && c2248t2.f6477V == 0.0f && c2248t2.m351z(1)) || c2248t2.mo218F();
        if (c2248t2.f6477V <= 0.0f || !(z || z2)) {
            return z && z2;
        }
        return true;
    }

    /* renamed from: b */
    public static void m2381b(C2248t2 c2248t2, C0083D2.InterfaceC0085b interfaceC0085b) {
        HashSet<C2224s2> hashSet;
        C2224s2 c2224s2;
        C2224s2 c2224s22;
        C2224s2 c2224s23;
        C2224s2 c2224s24;
        C2224s2 c2224s25;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        if (!(c2248t2 instanceof C2269u2) && c2248t2.m382D() && m2382a(c2248t2)) {
            C2269u2.m307d0(c2248t2, interfaceC0085b, new C0083D2.C0084a(), false);
        }
        C2224s2 mo212n = c2248t2.mo212n(C2224s2.EnumC2225a.LEFT);
        C2224s2 mo212n2 = c2248t2.mo212n(C2224s2.EnumC2225a.RIGHT);
        int m411d = mo212n.m411d();
        int m411d2 = mo212n2.m411d();
        HashSet<C2224s2> hashSet2 = mo212n.f6368a;
        if (hashSet2 != null && mo212n.f6370c) {
            Iterator<C2224s2> it = hashSet2.iterator();
            while (it.hasNext()) {
                C2224s2 next = it.next();
                C2248t2 c2248t22 = next.f6371d;
                boolean m2382a = m2382a(c2248t22);
                if (c2248t22.m382D() && m2382a) {
                    C2269u2.m307d0(c2248t22, interfaceC0085b, new C0083D2.C0084a(), false);
                }
                if (c2248t22.m359r() == enumC2249a && !m2382a) {
                    if (c2248t22.m359r() == enumC2249a && (c2248t22.f6503k0 == 8 || (c2248t22.f6506m == 0 && c2248t22.f6477V == 0.0f))) {
                        if (!c2248t22.m384B() && !c2248t22.f6454D) {
                            C2224s2 c2224s26 = c2248t22.f6460G;
                            if (((next == c2224s26 && (c2224s25 = c2248t22.f6464I.f6373f) != null && c2224s25.f6370c) || (next == c2248t22.f6464I && (c2224s24 = c2224s26.f6373f) != null && c2224s24.f6370c)) && !c2248t22.m384B()) {
                                m2379d(c2248t2, interfaceC0085b, c2248t22);
                            }
                        }
                    }
                } else if (!c2248t22.m382D()) {
                    C2224s2 c2224s27 = c2248t22.f6460G;
                    if (next == c2224s27 && c2248t22.f6464I.f6373f == null) {
                        int m410e = c2224s27.m410e() + m411d;
                        c2248t22.m377L(m410e, c2248t22.m354w() + m410e);
                        m2381b(c2248t22, interfaceC0085b);
                    } else {
                        C2224s2 c2224s28 = c2248t22.f6464I;
                        if (next == c2224s28 && c2224s27.f6373f == null) {
                            int m410e2 = m411d - c2224s28.m410e();
                            c2248t22.m377L(m410e2 - c2248t22.m354w(), m410e2);
                            m2381b(c2248t22, interfaceC0085b);
                        } else if (next == c2224s27 && (c2224s23 = c2224s28.f6373f) != null && c2224s23.f6370c && !c2248t22.m384B()) {
                            m2380c(interfaceC0085b, c2248t22);
                        }
                    }
                }
            }
        }
        if ((c2248t2 instanceof C2306w2) || (hashSet = mo212n2.f6368a) == null || !mo212n2.f6370c) {
            return;
        }
        Iterator<C2224s2> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            C2224s2 next2 = it2.next();
            C2248t2 c2248t23 = next2.f6371d;
            boolean m2382a2 = m2382a(c2248t23);
            if (c2248t23.m382D() && m2382a2) {
                C2269u2.m307d0(c2248t23, interfaceC0085b, new C0083D2.C0084a(), false);
            }
            C2224s2 c2224s29 = c2248t23.f6460G;
            boolean z = (next2 == c2224s29 && (c2224s22 = c2248t23.f6464I.f6373f) != null && c2224s22.f6370c) || (next2 == c2248t23.f6464I && (c2224s2 = c2224s29.f6373f) != null && c2224s2.f6370c);
            if (c2248t23.m359r() == enumC2249a && !m2382a2) {
                if (c2248t23.m359r() == enumC2249a && (c2248t23.f6503k0 == 8 || (c2248t23.f6506m == 0 && c2248t23.f6477V == 0.0f))) {
                    if (!c2248t23.m384B() && !c2248t23.f6454D && z && !c2248t23.m384B()) {
                        m2379d(c2248t2, interfaceC0085b, c2248t23);
                    }
                }
            } else if (!c2248t23.m382D()) {
                C2224s2 c2224s210 = c2248t23.f6460G;
                if (next2 == c2224s210 && c2248t23.f6464I.f6373f == null) {
                    int m410e3 = c2224s210.m410e() + m411d2;
                    c2248t23.m377L(m410e3, c2248t23.m354w() + m410e3);
                    m2381b(c2248t23, interfaceC0085b);
                } else {
                    C2224s2 c2224s211 = c2248t23.f6464I;
                    if (next2 == c2224s211 && c2224s210.f6373f == null) {
                        int m410e4 = m411d2 - c2224s211.m410e();
                        c2248t23.m377L(m410e4 - c2248t23.m354w(), m410e4);
                        m2381b(c2248t23, interfaceC0085b);
                    } else if (z && !c2248t23.m384B()) {
                        m2380c(interfaceC0085b, c2248t23);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static void m2380c(C0083D2.InterfaceC0085b interfaceC0085b, C2248t2 c2248t2) {
        float f = c2248t2.f6495g0;
        int m411d = c2248t2.f6460G.f6373f.m411d();
        int m411d2 = c2248t2.f6464I.f6373f.m411d();
        int m410e = c2248t2.f6460G.m410e() + m411d;
        int m410e2 = m411d2 - c2248t2.f6464I.m410e();
        if (m411d == m411d2) {
            f = 0.5f;
        } else {
            m411d = m410e;
            m411d2 = m410e2;
        }
        int m354w = c2248t2.m354w();
        int i = (m411d2 - m411d) - m354w;
        if (m411d > m411d2) {
            i = (m411d - m411d2) - m354w;
        }
        if (((C2269u2) c2248t2.f6474S).f6608M0) {
            f = 1.0f - f;
        }
        int i2 = ((int) ((f * i) + 0.5f)) + m411d;
        int i3 = i2 + m354w;
        if (m411d > m411d2) {
            i3 = i2 - m354w;
        }
        c2248t2.m377L(i2, i3);
        m2381b(c2248t2, interfaceC0085b);
    }

    /* renamed from: d */
    public static void m2379d(C2248t2 c2248t2, C0083D2.InterfaceC0085b interfaceC0085b, C2248t2 c2248t22) {
        int m354w;
        float f = c2248t22.f6495g0;
        int m410e = c2248t22.f6460G.m410e() + c2248t22.f6460G.f6373f.m411d();
        int m411d = c2248t22.f6464I.f6373f.m411d() - c2248t22.f6464I.m410e();
        if (m411d >= m410e) {
            int m354w2 = c2248t22.m354w();
            if (c2248t22.f6503k0 != 8) {
                int i = c2248t22.f6506m;
                if (i == 2) {
                    if (c2248t2 instanceof C2269u2) {
                        m354w = c2248t2.m354w();
                    } else {
                        m354w = c2248t2.f6474S.m354w();
                    }
                    m354w2 = (int) (c2248t22.f6495g0 * 0.5f * m354w);
                } else if (i == 0) {
                    m354w2 = m411d - m410e;
                }
                m354w2 = Math.max(c2248t22.f6512p, m354w2);
                int i2 = c2248t22.f6514q;
                if (i2 > 0) {
                    m354w2 = Math.min(i2, m354w2);
                }
            }
            int i3 = m410e + ((int) ((f * ((m411d - m410e) - m354w2)) + 0.5f));
            c2248t22.m377L(i3, m354w2 + i3);
            m2381b(c2248t22, interfaceC0085b);
        }
    }

    /* renamed from: e */
    public static void m2378e(C0083D2.InterfaceC0085b interfaceC0085b, C2248t2 c2248t2) {
        float f = c2248t2.f6497h0;
        int m411d = c2248t2.f6462H.f6373f.m411d();
        int m411d2 = c2248t2.f6465J.f6373f.m411d();
        int m410e = c2248t2.f6462H.m410e() + m411d;
        int m410e2 = m411d2 - c2248t2.f6465J.m410e();
        if (m411d == m411d2) {
            f = 0.5f;
        } else {
            m411d = m410e;
            m411d2 = m410e2;
        }
        int m360q = c2248t2.m360q();
        int i = (m411d2 - m411d) - m360q;
        if (m411d > m411d2) {
            i = (m411d - m411d2) - m360q;
        }
        int i2 = (int) ((f * i) + 0.5f);
        int i3 = m411d + i2;
        int i4 = i3 + m360q;
        if (m411d > m411d2) {
            i3 = m411d - i2;
            i4 = i3 - m360q;
        }
        c2248t2.m376M(i3, i4);
        m2376g(c2248t2, interfaceC0085b);
    }

    /* renamed from: f */
    public static void m2377f(C2248t2 c2248t2, C0083D2.InterfaceC0085b interfaceC0085b, C2248t2 c2248t22) {
        int m360q;
        float f = c2248t22.f6497h0;
        int m410e = c2248t22.f6462H.m410e() + c2248t22.f6462H.f6373f.m411d();
        int m411d = c2248t22.f6465J.f6373f.m411d() - c2248t22.f6465J.m410e();
        if (m411d >= m410e) {
            int m360q2 = c2248t22.m360q();
            if (c2248t22.f6503k0 != 8) {
                int i = c2248t22.f6508n;
                if (i == 2) {
                    if (c2248t2 instanceof C2269u2) {
                        m360q = c2248t2.m360q();
                    } else {
                        m360q = c2248t2.f6474S.m360q();
                    }
                    m360q2 = (int) (f * 0.5f * m360q);
                } else if (i == 0) {
                    m360q2 = m411d - m410e;
                }
                m360q2 = Math.max(c2248t22.f6518s, m360q2);
                int i2 = c2248t22.f6520t;
                if (i2 > 0) {
                    m360q2 = Math.min(i2, m360q2);
                }
            }
            int i3 = m410e + ((int) ((f * ((m411d - m410e) - m360q2)) + 0.5f));
            c2248t22.m376M(i3, m360q2 + i3);
            m2376g(c2248t22, interfaceC0085b);
        }
    }

    /* renamed from: g */
    public static void m2376g(C2248t2 c2248t2, C0083D2.InterfaceC0085b interfaceC0085b) {
        C2224s2 c2224s2;
        C2224s2 c2224s22;
        C2224s2 c2224s23;
        C2224s2 c2224s24;
        C2224s2 c2224s25;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        if (!(c2248t2 instanceof C2269u2) && c2248t2.m382D() && m2382a(c2248t2)) {
            C2269u2.m307d0(c2248t2, interfaceC0085b, new C0083D2.C0084a(), false);
        }
        C2224s2 mo212n = c2248t2.mo212n(C2224s2.EnumC2225a.TOP);
        C2224s2 mo212n2 = c2248t2.mo212n(C2224s2.EnumC2225a.BOTTOM);
        int m411d = mo212n.m411d();
        int m411d2 = mo212n2.m411d();
        HashSet<C2224s2> hashSet = mo212n.f6368a;
        if (hashSet != null && mo212n.f6370c) {
            Iterator<C2224s2> it = hashSet.iterator();
            while (it.hasNext()) {
                C2224s2 next = it.next();
                C2248t2 c2248t22 = next.f6371d;
                boolean m2382a = m2382a(c2248t22);
                if (c2248t22.m382D() && m2382a) {
                    C2269u2.m307d0(c2248t22, interfaceC0085b, new C0083D2.C0084a(), false);
                }
                if (c2248t22.m355v() == enumC2249a && !m2382a) {
                    if (c2248t22.m355v() == enumC2249a && (c2248t22.f6503k0 == 8 || (c2248t22.f6508n == 0 && c2248t22.f6477V == 0.0f))) {
                        if (!c2248t22.m383C() && !c2248t22.f6454D) {
                            C2224s2 c2224s26 = c2248t22.f6462H;
                            if (((next == c2224s26 && (c2224s25 = c2248t22.f6465J.f6373f) != null && c2224s25.f6370c) || (next == c2248t22.f6465J && (c2224s24 = c2224s26.f6373f) != null && c2224s24.f6370c)) && !c2248t22.m383C()) {
                                m2377f(c2248t2, interfaceC0085b, c2248t22);
                            }
                        }
                    }
                } else if (!c2248t22.m382D()) {
                    C2224s2 c2224s27 = c2248t22.f6462H;
                    if (next == c2224s27 && c2248t22.f6465J.f6373f == null) {
                        int m410e = c2224s27.m410e() + m411d;
                        c2248t22.m376M(m410e, c2248t22.m360q() + m410e);
                        m2376g(c2248t22, interfaceC0085b);
                    } else {
                        C2224s2 c2224s28 = c2248t22.f6465J;
                        if (next == c2224s28 && c2224s28.f6373f == null) {
                            int m410e2 = m411d - c2224s28.m410e();
                            c2248t22.m376M(m410e2 - c2248t22.m360q(), m410e2);
                            m2376g(c2248t22, interfaceC0085b);
                        } else if (next == c2224s27 && (c2224s23 = c2224s28.f6373f) != null && c2224s23.f6370c) {
                            m2378e(interfaceC0085b, c2248t22);
                        }
                    }
                }
            }
        }
        if (c2248t2 instanceof C2306w2) {
            return;
        }
        HashSet<C2224s2> hashSet2 = mo212n2.f6368a;
        if (hashSet2 != null && mo212n2.f6370c) {
            Iterator<C2224s2> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                C2224s2 next2 = it2.next();
                C2248t2 c2248t23 = next2.f6371d;
                boolean m2382a2 = m2382a(c2248t23);
                if (c2248t23.m382D() && m2382a2) {
                    C2269u2.m307d0(c2248t23, interfaceC0085b, new C0083D2.C0084a(), false);
                }
                C2224s2 c2224s29 = c2248t23.f6462H;
                boolean z = (next2 == c2224s29 && (c2224s22 = c2248t23.f6465J.f6373f) != null && c2224s22.f6370c) || (next2 == c2248t23.f6465J && (c2224s2 = c2224s29.f6373f) != null && c2224s2.f6370c);
                if (c2248t23.m355v() == enumC2249a && !m2382a2) {
                    if (c2248t23.m355v() == enumC2249a && (c2248t23.f6503k0 == 8 || (c2248t23.f6508n == 0 && c2248t23.f6477V == 0.0f))) {
                        if (!c2248t23.m383C() && !c2248t23.f6454D && z && !c2248t23.m383C()) {
                            m2377f(c2248t2, interfaceC0085b, c2248t23);
                        }
                    }
                } else if (!c2248t23.m382D()) {
                    C2224s2 c2224s210 = c2248t23.f6462H;
                    if (next2 == c2224s210 && c2248t23.f6465J.f6373f == null) {
                        int m410e3 = c2224s210.m410e() + m411d2;
                        c2248t23.m376M(m410e3, c2248t23.m360q() + m410e3);
                        m2376g(c2248t23, interfaceC0085b);
                    } else {
                        C2224s2 c2224s211 = c2248t23.f6465J;
                        if (next2 == c2224s211 && c2224s210.f6373f == null) {
                            int m410e4 = m411d2 - c2224s211.m410e();
                            c2248t23.m376M(m410e4 - c2248t23.m360q(), m410e4);
                            m2376g(c2248t23, interfaceC0085b);
                        } else if (z && !c2248t23.m383C()) {
                            m2378e(interfaceC0085b, c2248t23);
                        }
                    }
                }
            }
        }
        C2224s2 mo212n3 = c2248t2.mo212n(C2224s2.EnumC2225a.BASELINE);
        if (mo212n3.f6368a == null || !mo212n3.f6370c) {
            return;
        }
        int m411d3 = mo212n3.m411d();
        Iterator<C2224s2> it3 = mo212n3.f6368a.iterator();
        while (it3.hasNext()) {
            C2224s2 next3 = it3.next();
            C2248t2 c2248t24 = next3.f6371d;
            boolean m2382a3 = m2382a(c2248t24);
            if (c2248t24.m382D() && m2382a3) {
                C2269u2.m307d0(c2248t24, interfaceC0085b, new C0083D2.C0084a(), false);
            }
            if (c2248t24.m355v() != enumC2249a || m2382a3) {
                if (!c2248t24.m382D() && next3 == c2248t24.f6466K) {
                    if (c2248t24.f6450B) {
                        int i = m411d3 - c2248t24.f6489d0;
                        int i2 = c2248t24.f6476U + i;
                        c2248t24.f6480Y = i;
                        c2248t24.f6462H.m402m(i);
                        c2248t24.f6465J.m402m(i2);
                        C2224s2 c2224s212 = c2248t24.f6466K;
                        c2224s212.f6369b = m411d3;
                        c2224s212.f6370c = true;
                        c2248t24.f6500j = true;
                    }
                    m2376g(c2248t24, interfaceC0085b);
                }
            }
        }
    }
}
