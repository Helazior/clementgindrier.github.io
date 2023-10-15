package p000;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import p000.C0083D2;
import p000.C2248t2;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: u2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2269u2 extends C0035B2 {

    /* renamed from: O0 */
    public int f6610O0;

    /* renamed from: P0 */
    public int f6611P0;

    /* renamed from: J0 */
    public C0083D2 f6605J0 = new C0083D2(this);

    /* renamed from: K0 */
    public C0146G2 f6606K0 = new C0146G2(this);

    /* renamed from: L0 */
    public C0083D2.InterfaceC0085b f6607L0 = null;

    /* renamed from: M0 */
    public boolean f6608M0 = false;

    /* renamed from: N0 */
    public C1953l2 f6609N0 = new C1953l2();

    /* renamed from: Q0 */
    public int f6612Q0 = 0;

    /* renamed from: R0 */
    public int f6613R0 = 0;

    /* renamed from: S0 */
    public C2207r2[] f6614S0 = new C2207r2[4];

    /* renamed from: T0 */
    public C2207r2[] f6615T0 = new C2207r2[4];

    /* renamed from: U0 */
    public int f6616U0 = 257;

    /* renamed from: V0 */
    public boolean f6617V0 = false;

    /* renamed from: W0 */
    public boolean f6618W0 = false;

    /* renamed from: X0 */
    public WeakReference<C2224s2> f6619X0 = null;

    /* renamed from: Y0 */
    public WeakReference<C2224s2> f6620Y0 = null;

    /* renamed from: Z0 */
    public WeakReference<C2224s2> f6621Z0 = null;

    /* renamed from: a1 */
    public WeakReference<C2224s2> f6622a1 = null;

    /* renamed from: b1 */
    public C0083D2.C0084a f6623b1 = new C0083D2.C0084a();

    /* renamed from: d0 */
    public static boolean m307d0(C2248t2 c2248t2, C0083D2.InterfaceC0085b interfaceC0085b, C0083D2.C0084a c0084a, boolean z) {
        int i;
        int i2;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.WRAP_CONTENT;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.FIXED;
        if (interfaceC0085b == null) {
            return false;
        }
        c0084a.f336a = c2248t2.m359r();
        c0084a.f337b = c2248t2.m355v();
        c0084a.f338c = c2248t2.m354w();
        c0084a.f339d = c2248t2.m360q();
        c0084a.f344i = false;
        c0084a.f345j = z;
        C2248t2.EnumC2249a enumC2249a3 = c0084a.f336a;
        C2248t2.EnumC2249a enumC2249a4 = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        boolean z2 = enumC2249a3 == enumC2249a4;
        boolean z3 = c0084a.f337b == enumC2249a4;
        boolean z4 = z2 && c2248t2.f6477V > 0.0f;
        boolean z5 = z3 && c2248t2.f6477V > 0.0f;
        if (z2 && c2248t2.m351z(0) && c2248t2.f6506m == 0 && !z4) {
            c0084a.f336a = enumC2249a;
            if (z3 && c2248t2.f6508n == 0) {
                c0084a.f336a = enumC2249a2;
            }
            z2 = false;
        }
        if (z3 && c2248t2.m351z(1) && c2248t2.f6508n == 0 && !z5) {
            c0084a.f337b = enumC2249a;
            if (z2 && c2248t2.f6506m == 0) {
                c0084a.f337b = enumC2249a2;
            }
            z3 = false;
        }
        if (c2248t2.mo219E()) {
            c0084a.f336a = enumC2249a2;
            z2 = false;
        }
        if (c2248t2.mo218F()) {
            c0084a.f337b = enumC2249a2;
            z3 = false;
        }
        if (z4) {
            if (c2248t2.f6510o[0] == 4) {
                c0084a.f336a = enumC2249a2;
            } else if (!z3) {
                if (c0084a.f337b == enumC2249a2) {
                    i2 = c0084a.f339d;
                } else {
                    c0084a.f336a = enumC2249a;
                    ((ConstraintLayout.C0720a) interfaceC0085b).m1524b(c2248t2, c0084a);
                    i2 = c0084a.f341f;
                }
                c0084a.f336a = enumC2249a2;
                int i3 = c2248t2.f6478W;
                if (i3 != 0 && i3 != -1) {
                    c0084a.f338c = (int) (c2248t2.f6477V / i2);
                } else {
                    c0084a.f338c = (int) (c2248t2.f6477V * i2);
                }
            }
        }
        if (z5) {
            if (c2248t2.f6510o[1] == 4) {
                c0084a.f337b = enumC2249a2;
            } else if (!z2) {
                if (c0084a.f336a == enumC2249a2) {
                    i = c0084a.f338c;
                } else {
                    c0084a.f337b = enumC2249a;
                    ((ConstraintLayout.C0720a) interfaceC0085b).m1524b(c2248t2, c0084a);
                    i = c0084a.f340e;
                }
                c0084a.f337b = enumC2249a2;
                int i4 = c2248t2.f6478W;
                if (i4 != 0 && i4 != -1) {
                    c0084a.f339d = (int) (i * c2248t2.f6477V);
                } else {
                    c0084a.f339d = (int) (i / c2248t2.f6477V);
                }
            }
        }
        ((ConstraintLayout.C0720a) interfaceC0085b).m1524b(c2248t2, c0084a);
        c2248t2.m370S(c0084a.f340e);
        c2248t2.m375N(c0084a.f341f);
        c2248t2.f6450B = c0084a.f343h;
        c2248t2.m378K(c0084a.f342g);
        c0084a.f345j = false;
        return c0084a.f344i;
    }

    @Override // p000.C0035B2, p000.C2248t2
    /* renamed from: G */
    public void mo317G() {
        this.f6609N0.m614u();
        this.f6610O0 = 0;
        this.f6611P0 = 0;
        super.mo317G();
    }

    @Override // p000.C2248t2
    /* renamed from: T */
    public void mo316T(boolean z, boolean z2) {
        super.mo316T(z, z2);
        int size = this.f174I0.size();
        for (int i = 0; i < size; i++) {
            this.f174I0.get(i).mo316T(z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:327:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0652 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x08c6  */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v17 */
    @Override // p000.C0035B2
    /* renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo315V() {
        /*
            Method dump skipped, instructions count: 2262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2269u2.mo315V():void");
    }

    /* renamed from: W */
    public void m314W(C2248t2 c2248t2, int i) {
        if (i == 0) {
            int i2 = this.f6612Q0 + 1;
            C2207r2[] c2207r2Arr = this.f6615T0;
            if (i2 >= c2207r2Arr.length) {
                this.f6615T0 = (C2207r2[]) Arrays.copyOf(c2207r2Arr, c2207r2Arr.length * 2);
            }
            C2207r2[] c2207r2Arr2 = this.f6615T0;
            int i3 = this.f6612Q0;
            c2207r2Arr2[i3] = new C2207r2(c2248t2, 0, this.f6608M0);
            this.f6612Q0 = i3 + 1;
        } else if (i == 1) {
            int i4 = this.f6613R0 + 1;
            C2207r2[] c2207r2Arr3 = this.f6614S0;
            if (i4 >= c2207r2Arr3.length) {
                this.f6614S0 = (C2207r2[]) Arrays.copyOf(c2207r2Arr3, c2207r2Arr3.length * 2);
            }
            C2207r2[] c2207r2Arr4 = this.f6614S0;
            int i5 = this.f6613R0;
            c2207r2Arr4[i5] = new C2207r2(c2248t2, 1, this.f6608M0);
            this.f6613R0 = i5 + 1;
        }
    }

    /* renamed from: X */
    public boolean m313X(C1953l2 c1953l2) {
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.FIXED;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.WRAP_CONTENT;
        boolean m306e0 = m306e0(64);
        mo214f(c1953l2, m306e0);
        int size = this.f174I0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C2248t2 c2248t2 = this.f174I0.get(i);
            boolean[] zArr = c2248t2.f6472Q;
            zArr[0] = false;
            zArr[1] = false;
            if (c2248t2 instanceof C2189q2) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                C2248t2 c2248t22 = this.f174I0.get(i2);
                if (c2248t22 instanceof C2189q2) {
                    C2189q2 c2189q2 = (C2189q2) c2248t22;
                    for (int i3 = 0; i3 < c2189q2.f6853J0; i3++) {
                        C2248t2 c2248t23 = c2189q2.f6852I0[i3];
                        int i4 = c2189q2.f6257K0;
                        if (i4 == 0 || i4 == 1) {
                            c2248t23.f6472Q[0] = true;
                        } else if (i4 == 2 || i4 == 3) {
                            c2248t23.f6472Q[1] = true;
                        }
                    }
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            C2248t2 c2248t24 = this.f174I0.get(i5);
            if (c2248t24.m368e()) {
                c2248t24.mo214f(c1953l2, m306e0);
            }
        }
        if (C1953l2.f5438p) {
            HashSet<C2248t2> hashSet = new HashSet<>();
            for (int i6 = 0; i6 < size; i6++) {
                C2248t2 c2248t25 = this.f174I0.get(i6);
                if (!c2248t25.m368e()) {
                    hashSet.add(c2248t25);
                }
            }
            m369d(this, c1953l2, hashSet, m359r() == enumC2249a2 ? 0 : 1, false);
            Iterator<C2248t2> it = hashSet.iterator();
            while (it.hasNext()) {
                C2248t2 next = it.next();
                C2397z2.m7a(this, c1953l2, next);
                next.mo214f(c1953l2, m306e0);
            }
        } else {
            for (int i7 = 0; i7 < size; i7++) {
                C2248t2 c2248t26 = this.f174I0.get(i7);
                if (c2248t26 instanceof C2269u2) {
                    C2248t2.EnumC2249a[] enumC2249aArr = c2248t26.f6473R;
                    C2248t2.EnumC2249a enumC2249a3 = enumC2249aArr[0];
                    C2248t2.EnumC2249a enumC2249a4 = enumC2249aArr[1];
                    if (enumC2249a3 == enumC2249a2) {
                        enumC2249aArr[0] = enumC2249a;
                    }
                    if (enumC2249a4 == enumC2249a2) {
                        enumC2249aArr[1] = enumC2249a;
                    }
                    c2248t26.mo214f(c1953l2, m306e0);
                    if (enumC2249a3 == enumC2249a2) {
                        c2248t26.m374O(enumC2249a3);
                    }
                    if (enumC2249a4 == enumC2249a2) {
                        c2248t26.m371R(enumC2249a4);
                    }
                } else {
                    C2397z2.m7a(this, c1953l2, c2248t26);
                    if (!c2248t26.m368e()) {
                        c2248t26.mo214f(c1953l2, m306e0);
                    }
                }
            }
        }
        if (this.f6612Q0 > 0) {
            LayoutInflater$Factory2C0000A.C0010h.m2649b(this, c1953l2, null, 0);
        }
        if (this.f6613R0 > 0) {
            LayoutInflater$Factory2C0000A.C0010h.m2649b(this, c1953l2, null, 1);
        }
        return true;
    }

    /* renamed from: Y */
    public void m312Y(C2224s2 c2224s2) {
        WeakReference<C2224s2> weakReference = this.f6622a1;
        if (weakReference == null || weakReference.get() == null || c2224s2.m411d() > this.f6622a1.get().m411d()) {
            this.f6622a1 = new WeakReference<>(c2224s2);
        }
    }

    /* renamed from: Z */
    public void m311Z(C2224s2 c2224s2) {
        WeakReference<C2224s2> weakReference = this.f6621Z0;
        if (weakReference == null || weakReference.get() == null || c2224s2.m411d() > this.f6621Z0.get().m411d()) {
            this.f6621Z0 = new WeakReference<>(c2224s2);
        }
    }

    /* renamed from: a0 */
    public void m310a0(C2224s2 c2224s2) {
        WeakReference<C2224s2> weakReference = this.f6619X0;
        if (weakReference == null || weakReference.get() == null || c2224s2.m411d() > this.f6619X0.get().m411d()) {
            this.f6619X0 = new WeakReference<>(c2224s2);
        }
    }

    /* renamed from: b0 */
    public boolean m309b0(boolean z, int i) {
        boolean z2;
        C0146G2 c0146g2 = this.f6606K0;
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_PARENT;
        C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.WRAP_CONTENT;
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.FIXED;
        boolean z3 = true;
        boolean z4 = z & true;
        C2248t2.EnumC2249a m361p = c0146g2.f487a.m361p(0);
        C2248t2.EnumC2249a m361p2 = c0146g2.f487a.m361p(1);
        int m353x = c0146g2.f487a.m353x();
        int m352y = c0146g2.f487a.m352y();
        if (z4 && (m361p == enumC2249a2 || m361p2 == enumC2249a2)) {
            Iterator<AbstractC0367Q2> it = c0146g2.f491e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC0367Q2 next = it.next();
                if (next.f1253f == i && !next.mo2131k()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && m361p == enumC2249a2) {
                    C2269u2 c2269u2 = c0146g2.f487a;
                    c2269u2.f6473R[0] = enumC2249a3;
                    c2269u2.m370S(c0146g2.m2435d(c2269u2, 0));
                    C2269u2 c2269u22 = c0146g2.f487a;
                    c2269u22.f6488d.f1252e.mo2389c(c2269u22.m354w());
                }
            } else if (z4 && m361p2 == enumC2249a2) {
                C2269u2 c2269u23 = c0146g2.f487a;
                c2269u23.f6473R[1] = enumC2249a3;
                c2269u23.m375N(c0146g2.m2435d(c2269u23, 1));
                C2269u2 c2269u24 = c0146g2.f487a;
                c2269u24.f6490e.f1252e.mo2389c(c2269u24.m360q());
            }
        }
        if (i == 0) {
            C2269u2 c2269u25 = c0146g2.f487a;
            C2248t2.EnumC2249a[] enumC2249aArr = c2269u25.f6473R;
            if (enumC2249aArr[0] == enumC2249a3 || enumC2249aArr[0] == enumC2249a) {
                int m354w = c2269u25.m354w() + m353x;
                c0146g2.f487a.f6488d.f1256i.mo2389c(m354w);
                c0146g2.f487a.f6488d.f1252e.mo2389c(m354w - m353x);
                z2 = true;
            }
            z2 = false;
        } else {
            C2269u2 c2269u26 = c0146g2.f487a;
            C2248t2.EnumC2249a[] enumC2249aArr2 = c2269u26.f6473R;
            if (enumC2249aArr2[1] == enumC2249a3 || enumC2249aArr2[1] == enumC2249a) {
                int m360q = c2269u26.m360q() + m352y;
                c0146g2.f487a.f6490e.f1256i.mo2389c(m360q);
                c0146g2.f487a.f6490e.f1252e.mo2389c(m360q - m352y);
                z2 = true;
            }
            z2 = false;
        }
        c0146g2.m2432g();
        Iterator<AbstractC0367Q2> it2 = c0146g2.f491e.iterator();
        while (it2.hasNext()) {
            AbstractC0367Q2 next2 = it2.next();
            if (next2.f1253f == i && (next2.f1249b != c0146g2.f487a || next2.f1254g)) {
                next2.mo2137e();
            }
        }
        Iterator<AbstractC0367Q2> it3 = c0146g2.f491e.iterator();
        while (it3.hasNext()) {
            AbstractC0367Q2 next3 = it3.next();
            if (next3.f1253f == i && (z2 || next3.f1249b != c0146g2.f487a)) {
                if (!next3.f1255h.f549j || !next3.f1256i.f549j || (!(next3 instanceof C0102E2) && !next3.f1252e.f549j)) {
                    z3 = false;
                    break;
                }
            }
        }
        c0146g2.f487a.m374O(m361p);
        c0146g2.f487a.m371R(m361p2);
        return z3;
    }

    /* renamed from: c0 */
    public void m308c0() {
        this.f6606K0.f488b = true;
    }

    /* renamed from: e0 */
    public boolean m306e0(int i) {
        return (this.f6616U0 & i) == i;
    }

    /* renamed from: f0 */
    public void m305f0(C0083D2.InterfaceC0085b interfaceC0085b) {
        this.f6607L0 = interfaceC0085b;
        this.f6606K0.f492f = interfaceC0085b;
    }

    /* renamed from: g0 */
    public void m304g0(int i) {
        this.f6616U0 = i;
        C1953l2.f5438p = m306e0(512);
    }

    /* renamed from: h0 */
    public void m303h0() {
        C0083D2 c0083d2 = this.f6605J0;
        c0083d2.f333a.clear();
        int size = this.f174I0.size();
        for (int i = 0; i < size; i++) {
            C2248t2 c2248t2 = this.f174I0.get(i);
            C2248t2.EnumC2249a m359r = c2248t2.m359r();
            C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
            if (m359r == enumC2249a || c2248t2.m355v() == enumC2249a) {
                c0083d2.f333a.add(c2248t2);
            }
        }
        m308c0();
    }
}
