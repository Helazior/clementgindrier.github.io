package p000;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p000.C0083D2;
import p000.C2248t2;

/* renamed from: G2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0146G2 {

    /* renamed from: a */
    public C2269u2 f487a;

    /* renamed from: d */
    public C2269u2 f490d;

    /* renamed from: f */
    public C0083D2.InterfaceC0085b f492f;

    /* renamed from: g */
    public C0083D2.C0084a f493g;

    /* renamed from: h */
    public ArrayList<C0308N2> f494h;

    /* renamed from: b */
    public boolean f488b = true;

    /* renamed from: c */
    public boolean f489c = true;

    /* renamed from: e */
    public ArrayList<AbstractC0367Q2> f491e = new ArrayList<>();

    public C0146G2(C2269u2 c2269u2) {
        new ArrayList();
        this.f492f = null;
        this.f493g = new C0083D2.C0084a();
        this.f494h = new ArrayList<>();
        this.f487a = c2269u2;
        this.f490d = c2269u2;
    }

    /* renamed from: a */
    public final void m2438a(C0168H2 c0168h2, int i, int i2, C0168H2 c0168h22, ArrayList<C0308N2> arrayList, C0308N2 c0308n2) {
        AbstractC0367Q2 abstractC0367Q2 = c0168h2.f543d;
        if (abstractC0367Q2.f1250c == null) {
            C2269u2 c2269u2 = this.f487a;
            if (abstractC0367Q2 == c2269u2.f6488d || abstractC0367Q2 == c2269u2.f6490e) {
                return;
            }
            if (c0308n2 == null) {
                c0308n2 = new C0308N2(abstractC0367Q2, i2);
                arrayList.add(c0308n2);
            }
            abstractC0367Q2.f1250c = c0308n2;
            c0308n2.f1022b.add(abstractC0367Q2);
            for (InterfaceC0128F2 interfaceC0128F2 : abstractC0367Q2.f1255h.f550k) {
                if (interfaceC0128F2 instanceof C0168H2) {
                    m2438a((C0168H2) interfaceC0128F2, i, 0, c0168h22, arrayList, c0308n2);
                }
            }
            for (InterfaceC0128F2 interfaceC0128F22 : abstractC0367Q2.f1256i.f550k) {
                if (interfaceC0128F22 instanceof C0168H2) {
                    m2438a((C0168H2) interfaceC0128F22, i, 1, c0168h22, arrayList, c0308n2);
                }
            }
            if (i == 1 && (abstractC0367Q2 instanceof C0329O2)) {
                for (InterfaceC0128F2 interfaceC0128F23 : ((C0329O2) abstractC0367Q2).f1117k.f550k) {
                    if (interfaceC0128F23 instanceof C0168H2) {
                        m2438a((C0168H2) interfaceC0128F23, i, 2, c0168h22, arrayList, c0308n2);
                    }
                }
            }
            for (C0168H2 c0168h23 : abstractC0367Q2.f1255h.f551l) {
                m2438a(c0168h23, i, 0, c0168h22, arrayList, c0308n2);
            }
            for (C0168H2 c0168h24 : abstractC0367Q2.f1256i.f551l) {
                m2438a(c0168h24, i, 1, c0168h22, arrayList, c0308n2);
            }
            if (i == 1 && (abstractC0367Q2 instanceof C0329O2)) {
                for (C0168H2 c0168h25 : ((C0329O2) abstractC0367Q2).f1117k.f551l) {
                    m2438a(c0168h25, i, 2, c0168h22, arrayList, c0308n2);
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean m2437b(C2269u2 c2269u2) {
        C2248t2.EnumC2249a enumC2249a;
        int i;
        int i2;
        C2248t2.EnumC2249a enumC2249a2;
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        C2248t2.EnumC2249a enumC2249a4 = C2248t2.EnumC2249a.WRAP_CONTENT;
        C2248t2.EnumC2249a enumC2249a5 = C2248t2.EnumC2249a.FIXED;
        Iterator<C2248t2> it = c2269u2.f174I0.iterator();
        while (it.hasNext()) {
            C2248t2 next = it.next();
            C2248t2.EnumC2249a[] enumC2249aArr = next.f6473R;
            C2248t2.EnumC2249a enumC2249a6 = enumC2249aArr[0];
            C2248t2.EnumC2249a enumC2249a7 = enumC2249aArr[1];
            if (next.f6503k0 == 8) {
                next.f6482a = true;
            } else {
                float f = next.f6516r;
                if (f < 1.0f && enumC2249a6 == enumC2249a3) {
                    next.f6506m = 2;
                }
                float f2 = next.f6522u;
                if (f2 < 1.0f && enumC2249a7 == enumC2249a3) {
                    next.f6508n = 2;
                }
                if (next.f6477V > 0.0f) {
                    if (enumC2249a6 == enumC2249a3 && (enumC2249a7 == enumC2249a4 || enumC2249a7 == enumC2249a5)) {
                        next.f6506m = 3;
                    } else if (enumC2249a7 == enumC2249a3 && (enumC2249a6 == enumC2249a4 || enumC2249a6 == enumC2249a5)) {
                        next.f6508n = 3;
                    } else if (enumC2249a6 == enumC2249a3 && enumC2249a7 == enumC2249a3) {
                        if (next.f6506m == 0) {
                            next.f6506m = 3;
                        }
                        if (next.f6508n == 0) {
                            next.f6508n = 3;
                        }
                    }
                }
                if (enumC2249a6 == enumC2249a3 && next.f6506m == 1 && (next.f6460G.f6373f == null || next.f6464I.f6373f == null)) {
                    enumC2249a6 = enumC2249a4;
                }
                C2248t2.EnumC2249a enumC2249a8 = (enumC2249a7 == enumC2249a3 && next.f6508n == 1 && (next.f6462H.f6373f == null || next.f6465J.f6373f == null)) ? enumC2249a4 : enumC2249a7;
                C0285M2 c0285m2 = next.f6488d;
                c0285m2.f1251d = enumC2249a6;
                int i3 = next.f6506m;
                c0285m2.f1248a = i3;
                C0329O2 c0329o2 = next.f6490e;
                c0329o2.f1251d = enumC2249a8;
                int i4 = next.f6508n;
                c0329o2.f1248a = i4;
                C2248t2.EnumC2249a enumC2249a9 = C2248t2.EnumC2249a.MATCH_PARENT;
                if ((enumC2249a6 == enumC2249a9 || enumC2249a6 == enumC2249a5 || enumC2249a6 == enumC2249a4) && (enumC2249a8 == enumC2249a9 || enumC2249a8 == enumC2249a5 || enumC2249a8 == enumC2249a4)) {
                    int m354w = next.m354w();
                    if (enumC2249a6 == enumC2249a9) {
                        i = (c2269u2.m354w() - next.f6460G.f6374g) - next.f6464I.f6374g;
                        enumC2249a = enumC2249a5;
                    } else {
                        enumC2249a = enumC2249a6;
                        i = m354w;
                    }
                    int m360q = next.m360q();
                    if (enumC2249a8 == enumC2249a9) {
                        i2 = (c2269u2.m360q() - next.f6462H.f6374g) - next.f6465J.f6374g;
                        enumC2249a2 = enumC2249a5;
                    } else {
                        i2 = m360q;
                        enumC2249a2 = enumC2249a8;
                    }
                    m2433f(next, enumC2249a, i, enumC2249a2, i2);
                    next.f6488d.f1252e.mo2389c(next.m354w());
                    next.f6490e.f1252e.mo2389c(next.m360q());
                    next.f6482a = true;
                } else {
                    if (enumC2249a6 == enumC2249a3 && (enumC2249a8 == enumC2249a4 || enumC2249a8 == enumC2249a5)) {
                        if (i3 == 3) {
                            if (enumC2249a8 == enumC2249a4) {
                                m2433f(next, enumC2249a4, 0, enumC2249a4, 0);
                            }
                            int m360q2 = next.m360q();
                            m2433f(next, enumC2249a5, (int) ((m360q2 * next.f6477V) + 0.5f), enumC2249a5, m360q2);
                            next.f6488d.f1252e.mo2389c(next.m354w());
                            next.f6490e.f1252e.mo2389c(next.m360q());
                            next.f6482a = true;
                        } else if (i3 == 1) {
                            m2433f(next, enumC2249a4, 0, enumC2249a8, 0);
                            next.f6488d.f1252e.f631m = next.m354w();
                        } else if (i3 == 2) {
                            C2248t2.EnumC2249a[] enumC2249aArr2 = c2269u2.f6473R;
                            if (enumC2249aArr2[0] == enumC2249a5 || enumC2249aArr2[0] == enumC2249a9) {
                                m2433f(next, enumC2249a5, (int) ((f * c2269u2.m354w()) + 0.5f), enumC2249a8, next.m360q());
                                next.f6488d.f1252e.mo2389c(next.m354w());
                                next.f6490e.f1252e.mo2389c(next.m360q());
                                next.f6482a = true;
                            }
                        } else {
                            C2224s2[] c2224s2Arr = next.f6470O;
                            if (c2224s2Arr[0].f6373f == null || c2224s2Arr[1].f6373f == null) {
                                m2433f(next, enumC2249a4, 0, enumC2249a8, 0);
                                next.f6488d.f1252e.mo2389c(next.m354w());
                                next.f6490e.f1252e.mo2389c(next.m360q());
                                next.f6482a = true;
                            }
                        }
                    }
                    if (enumC2249a8 == enumC2249a3 && (enumC2249a6 == enumC2249a4 || enumC2249a6 == enumC2249a5)) {
                        if (i4 == 3) {
                            if (enumC2249a6 == enumC2249a4) {
                                m2433f(next, enumC2249a4, 0, enumC2249a4, 0);
                            }
                            int m354w2 = next.m354w();
                            float f3 = next.f6477V;
                            if (next.f6478W == -1) {
                                f3 = 1.0f / f3;
                            }
                            m2433f(next, enumC2249a5, m354w2, enumC2249a5, (int) ((m354w2 * f3) + 0.5f));
                            next.f6488d.f1252e.mo2389c(next.m354w());
                            next.f6490e.f1252e.mo2389c(next.m360q());
                            next.f6482a = true;
                        } else if (i4 == 1) {
                            m2433f(next, enumC2249a6, 0, enumC2249a4, 0);
                            next.f6490e.f1252e.f631m = next.m360q();
                        } else if (i4 == 2) {
                            C2248t2.EnumC2249a[] enumC2249aArr3 = c2269u2.f6473R;
                            if (enumC2249aArr3[1] == enumC2249a5 || enumC2249aArr3[1] == enumC2249a9) {
                                m2433f(next, enumC2249a6, next.m354w(), enumC2249a5, (int) ((f2 * c2269u2.m360q()) + 0.5f));
                                next.f6488d.f1252e.mo2389c(next.m354w());
                                next.f6490e.f1252e.mo2389c(next.m360q());
                                next.f6482a = true;
                            }
                        } else {
                            C2224s2[] c2224s2Arr2 = next.f6470O;
                            if (c2224s2Arr2[2].f6373f == null || c2224s2Arr2[3].f6373f == null) {
                                m2433f(next, enumC2249a4, 0, enumC2249a8, 0);
                                next.f6488d.f1252e.mo2389c(next.m354w());
                                next.f6490e.f1252e.mo2389c(next.m360q());
                                next.f6482a = true;
                            }
                        }
                    }
                    if (enumC2249a6 == enumC2249a3 && enumC2249a8 == enumC2249a3) {
                        if (i3 == 1 || i4 == 1) {
                            m2433f(next, enumC2249a4, 0, enumC2249a4, 0);
                            next.f6488d.f1252e.f631m = next.m354w();
                            next.f6490e.f1252e.f631m = next.m360q();
                        } else if (i4 == 2 && i3 == 2) {
                            C2248t2.EnumC2249a[] enumC2249aArr4 = c2269u2.f6473R;
                            if (enumC2249aArr4[0] == enumC2249a5 || enumC2249aArr4[0] == enumC2249a5) {
                                if (enumC2249aArr4[1] == enumC2249a5 || enumC2249aArr4[1] == enumC2249a5) {
                                    m2433f(next, enumC2249a5, (int) ((f * c2269u2.m354w()) + 0.5f), enumC2249a5, (int) ((f2 * c2269u2.m360q()) + 0.5f));
                                    next.f6488d.f1252e.mo2389c(next.m354w());
                                    next.f6490e.f1252e.mo2389c(next.m360q());
                                    next.f6482a = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m2436c() {
        ArrayList<AbstractC0367Q2> arrayList = this.f491e;
        arrayList.clear();
        this.f490d.f6488d.mo2136f();
        this.f490d.f6490e.mo2136f();
        arrayList.add(this.f490d.f6488d);
        arrayList.add(this.f490d.f6490e);
        Iterator<C2248t2> it = this.f490d.f174I0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            C2248t2 next = it.next();
            if (next instanceof C2306w2) {
                arrayList.add(new C0233K2(next));
            } else {
                if (next.m384B()) {
                    if (next.f6484b == null) {
                        next.f6484b = new C0102E2(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f6484b);
                } else {
                    arrayList.add(next.f6488d);
                }
                if (next.m383C()) {
                    if (next.f6486c == null) {
                        next.f6486c = new C0102E2(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f6486c);
                } else {
                    arrayList.add(next.f6490e);
                }
                if (next instanceof C2363y2) {
                    arrayList.add(new C0265L2(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<AbstractC0367Q2> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().mo2136f();
        }
        Iterator<AbstractC0367Q2> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            AbstractC0367Q2 next2 = it3.next();
            if (next2.f1249b != this.f490d) {
                next2.mo2138d();
            }
        }
        this.f494h.clear();
        C0308N2.f1020c = 0;
        m2434e(this.f487a.f6488d, 0, this.f494h);
        m2434e(this.f487a.f6490e, 1, this.f494h);
        this.f488b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m2435d(p000.C2269u2 r18, int r19) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0146G2.m2435d(u2, int):int");
    }

    /* renamed from: e */
    public final void m2434e(AbstractC0367Q2 abstractC0367Q2, int i, ArrayList<C0308N2> arrayList) {
        for (InterfaceC0128F2 interfaceC0128F2 : abstractC0367Q2.f1255h.f550k) {
            if (interfaceC0128F2 instanceof C0168H2) {
                m2438a((C0168H2) interfaceC0128F2, i, 0, abstractC0367Q2.f1256i, arrayList, null);
            } else if (interfaceC0128F2 instanceof AbstractC0367Q2) {
                m2438a(((AbstractC0367Q2) interfaceC0128F2).f1255h, i, 0, abstractC0367Q2.f1256i, arrayList, null);
            }
        }
        for (InterfaceC0128F2 interfaceC0128F22 : abstractC0367Q2.f1256i.f550k) {
            if (interfaceC0128F22 instanceof C0168H2) {
                m2438a((C0168H2) interfaceC0128F22, i, 1, abstractC0367Q2.f1255h, arrayList, null);
            } else if (interfaceC0128F22 instanceof AbstractC0367Q2) {
                m2438a(((AbstractC0367Q2) interfaceC0128F22).f1256i, i, 1, abstractC0367Q2.f1255h, arrayList, null);
            }
        }
        if (i == 1) {
            for (InterfaceC0128F2 interfaceC0128F23 : ((C0329O2) abstractC0367Q2).f1117k.f550k) {
                if (interfaceC0128F23 instanceof C0168H2) {
                    m2438a((C0168H2) interfaceC0128F23, i, 2, null, arrayList, null);
                }
            }
        }
    }

    /* renamed from: f */
    public final void m2433f(C2248t2 c2248t2, C2248t2.EnumC2249a enumC2249a, int i, C2248t2.EnumC2249a enumC2249a2, int i2) {
        C0083D2.C0084a c0084a = this.f493g;
        c0084a.f336a = enumC2249a;
        c0084a.f337b = enumC2249a2;
        c0084a.f338c = i;
        c0084a.f339d = i2;
        ((ConstraintLayout.C0720a) this.f492f).m1524b(c2248t2, c0084a);
        c2248t2.m370S(this.f493g.f340e);
        c2248t2.m375N(this.f493g.f341f);
        C0083D2.C0084a c0084a2 = this.f493g;
        c2248t2.f6450B = c0084a2.f343h;
        c2248t2.m378K(c0084a2.f342g);
    }

    /* renamed from: g */
    public void m2432g() {
        C0193I2 c0193i2;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.FIXED;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        Iterator<C2248t2> it = this.f487a.f174I0.iterator();
        while (it.hasNext()) {
            C2248t2 next = it.next();
            if (!next.f6482a) {
                C2248t2.EnumC2249a[] enumC2249aArr = next.f6473R;
                boolean z = false;
                C2248t2.EnumC2249a enumC2249a3 = enumC2249aArr[0];
                C2248t2.EnumC2249a enumC2249a4 = enumC2249aArr[1];
                int i = next.f6506m;
                int i2 = next.f6508n;
                C2248t2.EnumC2249a enumC2249a5 = C2248t2.EnumC2249a.WRAP_CONTENT;
                boolean z2 = enumC2249a3 == enumC2249a5 || (enumC2249a3 == enumC2249a2 && i == 1);
                if (enumC2249a4 == enumC2249a5 || (enumC2249a4 == enumC2249a2 && i2 == 1)) {
                    z = true;
                }
                C0193I2 c0193i22 = next.f6488d.f1252e;
                boolean z3 = c0193i22.f549j;
                C0193I2 c0193i23 = next.f6490e.f1252e;
                boolean z4 = c0193i23.f549j;
                if (z3 && z4) {
                    m2433f(next, enumC2249a, c0193i22.f546g, enumC2249a, c0193i23.f546g);
                    next.f6482a = true;
                } else if (z3 && z) {
                    m2433f(next, enumC2249a, c0193i22.f546g, enumC2249a5, c0193i23.f546g);
                    if (enumC2249a4 == enumC2249a2) {
                        next.f6490e.f1252e.f631m = next.m360q();
                    } else {
                        next.f6490e.f1252e.mo2389c(next.m360q());
                        next.f6482a = true;
                    }
                } else if (z4 && z2) {
                    m2433f(next, enumC2249a5, c0193i22.f546g, enumC2249a, c0193i23.f546g);
                    if (enumC2249a3 == enumC2249a2) {
                        next.f6488d.f1252e.f631m = next.m354w();
                    } else {
                        next.f6488d.f1252e.mo2389c(next.m354w());
                        next.f6482a = true;
                    }
                }
                if (next.f6482a && (c0193i2 = next.f6490e.f1118l) != null) {
                    c0193i2.mo2389c(next.f6489d0);
                }
            }
        }
    }
}
