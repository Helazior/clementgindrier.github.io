package p000;

import java.util.ArrayList;
import java.util.HashMap;
import p000.C2248t2;

/* renamed from: v2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2287v2 extends C0016A2 {

    /* renamed from: s1 */
    public C2248t2[] f6674s1;

    /* renamed from: V0 */
    public int f6651V0 = -1;

    /* renamed from: W0 */
    public int f6652W0 = -1;

    /* renamed from: X0 */
    public int f6653X0 = -1;

    /* renamed from: Y0 */
    public int f6654Y0 = -1;

    /* renamed from: Z0 */
    public int f6655Z0 = -1;

    /* renamed from: a1 */
    public int f6656a1 = -1;

    /* renamed from: b1 */
    public float f6657b1 = 0.5f;

    /* renamed from: c1 */
    public float f6658c1 = 0.5f;

    /* renamed from: d1 */
    public float f6659d1 = 0.5f;

    /* renamed from: e1 */
    public float f6660e1 = 0.5f;

    /* renamed from: f1 */
    public float f6661f1 = 0.5f;

    /* renamed from: g1 */
    public float f6662g1 = 0.5f;

    /* renamed from: h1 */
    public int f6663h1 = 0;

    /* renamed from: i1 */
    public int f6664i1 = 0;

    /* renamed from: j1 */
    public int f6665j1 = 2;

    /* renamed from: k1 */
    public int f6666k1 = 2;

    /* renamed from: l1 */
    public int f6667l1 = 0;

    /* renamed from: m1 */
    public int f6668m1 = -1;

    /* renamed from: n1 */
    public int f6669n1 = 0;

    /* renamed from: o1 */
    public ArrayList<C2288a> f6670o1 = new ArrayList<>();

    /* renamed from: p1 */
    public C2248t2[] f6671p1 = null;

    /* renamed from: q1 */
    public C2248t2[] f6672q1 = null;

    /* renamed from: r1 */
    public int[] f6673r1 = null;

    /* renamed from: t1 */
    public int f6675t1 = 0;

    /* renamed from: v2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2288a {

        /* renamed from: a */
        public int f6676a;

        /* renamed from: d */
        public C2224s2 f6679d;

        /* renamed from: e */
        public C2224s2 f6680e;

        /* renamed from: f */
        public C2224s2 f6681f;

        /* renamed from: g */
        public C2224s2 f6682g;

        /* renamed from: h */
        public int f6683h;

        /* renamed from: i */
        public int f6684i;

        /* renamed from: j */
        public int f6685j;

        /* renamed from: k */
        public int f6686k;

        /* renamed from: q */
        public int f6692q;

        /* renamed from: b */
        public C2248t2 f6677b = null;

        /* renamed from: c */
        public int f6678c = 0;

        /* renamed from: l */
        public int f6687l = 0;

        /* renamed from: m */
        public int f6688m = 0;

        /* renamed from: n */
        public int f6689n = 0;

        /* renamed from: o */
        public int f6690o = 0;

        /* renamed from: p */
        public int f6691p = 0;

        public C2288a(int i, C2224s2 c2224s2, C2224s2 c2224s22, C2224s2 c2224s23, C2224s2 c2224s24, int i2) {
            this.f6676a = 0;
            this.f6683h = 0;
            this.f6684i = 0;
            this.f6685j = 0;
            this.f6686k = 0;
            this.f6692q = 0;
            this.f6676a = i;
            this.f6679d = c2224s2;
            this.f6680e = c2224s22;
            this.f6681f = c2224s23;
            this.f6682g = c2224s24;
            this.f6683h = C2287v2.this.f118O0;
            this.f6684i = C2287v2.this.f114K0;
            this.f6685j = C2287v2.this.f119P0;
            this.f6686k = C2287v2.this.f115L0;
            this.f6692q = i2;
        }

        /* renamed from: a */
        public void m287a(C2248t2 c2248t2) {
            C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
            if (this.f6676a == 0) {
                int m288a0 = C2287v2.this.m288a0(c2248t2, this.f6692q);
                if (c2248t2.m359r() == enumC2249a) {
                    this.f6691p++;
                    m288a0 = 0;
                }
                C2287v2 c2287v2 = C2287v2.this;
                this.f6687l = m288a0 + (c2248t2.f6503k0 != 8 ? c2287v2.f6663h1 : 0) + this.f6687l;
                int m289Z = c2287v2.m289Z(c2248t2, this.f6692q);
                if (this.f6677b == null || this.f6678c < m289Z) {
                    this.f6677b = c2248t2;
                    this.f6678c = m289Z;
                    this.f6688m = m289Z;
                }
            } else {
                int m288a02 = C2287v2.this.m288a0(c2248t2, this.f6692q);
                int m289Z2 = C2287v2.this.m289Z(c2248t2, this.f6692q);
                if (c2248t2.m355v() == enumC2249a) {
                    this.f6691p++;
                    m289Z2 = 0;
                }
                this.f6688m = m289Z2 + (c2248t2.f6503k0 != 8 ? C2287v2.this.f6664i1 : 0) + this.f6688m;
                if (this.f6677b == null || this.f6678c < m288a02) {
                    this.f6677b = c2248t2;
                    this.f6678c = m288a02;
                    this.f6687l = m288a02;
                }
            }
            this.f6690o++;
        }

        /* renamed from: b */
        public void m286b(boolean z, int i, boolean z2) {
            int i2;
            float f;
            C2248t2 c2248t2;
            int i3;
            float f2;
            int i4 = this.f6690o;
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = this.f6689n + i5;
                C2287v2 c2287v2 = C2287v2.this;
                if (i6 >= c2287v2.f6675t1) {
                    break;
                }
                C2248t2 c2248t22 = c2287v2.f6674s1[i6];
                if (c2248t22 != null) {
                    c2248t22.m381H();
                }
            }
            if (i4 == 0 || this.f6677b == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i7 = -1;
            int i8 = -1;
            for (int i9 = 0; i9 < i4; i9++) {
                int i10 = this.f6689n + (z ? (i4 - 1) - i9 : i9);
                C2287v2 c2287v22 = C2287v2.this;
                if (i10 >= c2287v22.f6675t1) {
                    break;
                }
                if (c2287v22.f6674s1[i10].f6503k0 == 0) {
                    if (i7 == -1) {
                        i7 = i9;
                    }
                    i8 = i9;
                }
            }
            C2248t2 c2248t23 = null;
            if (this.f6676a == 0) {
                C2248t2 c2248t24 = this.f6677b;
                C2287v2 c2287v23 = C2287v2.this;
                c2248t24.f6531y0 = c2287v23.f6652W0;
                int i11 = this.f6684i;
                if (i > 0) {
                    i11 += c2287v23.f6664i1;
                }
                c2248t24.f6462H.m414a(this.f6680e, i11);
                if (z2) {
                    c2248t24.f6465J.m414a(this.f6682g, this.f6686k);
                }
                if (i > 0) {
                    this.f6680e.f6371d.f6465J.m414a(c2248t24.f6462H, 0);
                }
                if (C2287v2.this.f6666k1 == 3 && !c2248t24.f6450B) {
                    for (int i12 = 0; i12 < i4; i12++) {
                        int i13 = this.f6689n + (z ? (i4 - 1) - i12 : i12);
                        C2287v2 c2287v24 = C2287v2.this;
                        if (i13 >= c2287v24.f6675t1) {
                            break;
                        }
                        c2248t2 = c2287v24.f6674s1[i13];
                        if (c2248t2.f6450B) {
                            break;
                        }
                    }
                }
                c2248t2 = c2248t24;
                int i14 = 0;
                while (i14 < i4) {
                    int i15 = z ? (i4 - 1) - i14 : i14;
                    int i16 = this.f6689n + i15;
                    C2287v2 c2287v25 = C2287v2.this;
                    if (i16 >= c2287v25.f6675t1) {
                        return;
                    }
                    C2248t2 c2248t25 = c2287v25.f6674s1[i16];
                    if (i14 == 0) {
                        c2248t25.m365j(c2248t25.f6460G, this.f6679d, this.f6683h);
                    }
                    if (i15 == 0) {
                        C2287v2 c2287v26 = C2287v2.this;
                        int i17 = c2287v26.f6651V0;
                        float f3 = c2287v26.f6657b1;
                        if (this.f6689n == 0 && (i3 = c2287v26.f6653X0) != -1) {
                            f2 = c2287v26.f6659d1;
                        } else {
                            if (z2 && (i3 = c2287v26.f6655Z0) != -1) {
                                f2 = c2287v26.f6661f1;
                            }
                            c2248t25.f6529x0 = i17;
                            c2248t25.f6495g0 = f3;
                        }
                        f3 = f2;
                        i17 = i3;
                        c2248t25.f6529x0 = i17;
                        c2248t25.f6495g0 = f3;
                    }
                    if (i14 == i4 - 1) {
                        c2248t25.m365j(c2248t25.f6464I, this.f6681f, this.f6685j);
                    }
                    if (c2248t23 != null) {
                        c2248t25.f6460G.m414a(c2248t23.f6464I, C2287v2.this.f6663h1);
                        if (i14 == i7) {
                            c2248t25.f6460G.m401n(this.f6683h);
                        }
                        c2248t23.f6464I.m414a(c2248t25.f6460G, 0);
                        if (i14 == i8 + 1) {
                            c2248t23.f6464I.m401n(this.f6685j);
                        }
                    }
                    if (c2248t25 != c2248t24) {
                        int i18 = C2287v2.this.f6666k1;
                        if (i18 == 3 && c2248t2.f6450B && c2248t25 != c2248t2 && c2248t25.f6450B) {
                            c2248t25.f6466K.m414a(c2248t2.f6466K, 0);
                        } else if (i18 == 0) {
                            c2248t25.f6462H.m414a(c2248t24.f6462H, 0);
                        } else if (i18 == 1) {
                            c2248t25.f6465J.m414a(c2248t24.f6465J, 0);
                        } else if (z3) {
                            c2248t25.f6462H.m414a(this.f6680e, this.f6684i);
                            c2248t25.f6465J.m414a(this.f6682g, this.f6686k);
                        } else {
                            c2248t25.f6462H.m414a(c2248t24.f6462H, 0);
                            c2248t25.f6465J.m414a(c2248t24.f6465J, 0);
                        }
                    }
                    i14++;
                    c2248t23 = c2248t25;
                }
                return;
            }
            C2248t2 c2248t26 = this.f6677b;
            C2287v2 c2287v27 = C2287v2.this;
            c2248t26.f6529x0 = c2287v27.f6651V0;
            int i19 = this.f6683h;
            if (i > 0) {
                i19 += c2287v27.f6663h1;
            }
            if (z) {
                c2248t26.f6464I.m414a(this.f6681f, i19);
                if (z2) {
                    c2248t26.f6460G.m414a(this.f6679d, this.f6685j);
                }
                if (i > 0) {
                    this.f6681f.f6371d.f6460G.m414a(c2248t26.f6464I, 0);
                }
            } else {
                c2248t26.f6460G.m414a(this.f6679d, i19);
                if (z2) {
                    c2248t26.f6464I.m414a(this.f6681f, this.f6685j);
                }
                if (i > 0) {
                    this.f6679d.f6371d.f6464I.m414a(c2248t26.f6460G, 0);
                }
            }
            int i20 = 0;
            while (i20 < i4) {
                int i21 = this.f6689n + i20;
                C2287v2 c2287v28 = C2287v2.this;
                if (i21 >= c2287v28.f6675t1) {
                    return;
                }
                C2248t2 c2248t27 = c2287v28.f6674s1[i21];
                if (i20 == 0) {
                    c2248t27.m365j(c2248t27.f6462H, this.f6680e, this.f6684i);
                    C2287v2 c2287v29 = C2287v2.this;
                    int i22 = c2287v29.f6652W0;
                    float f4 = c2287v29.f6658c1;
                    if (this.f6689n == 0 && (i2 = c2287v29.f6654Y0) != -1) {
                        f = c2287v29.f6660e1;
                    } else {
                        if (z2 && (i2 = c2287v29.f6656a1) != -1) {
                            f = c2287v29.f6662g1;
                        }
                        c2248t27.f6531y0 = i22;
                        c2248t27.f6497h0 = f4;
                    }
                    f4 = f;
                    i22 = i2;
                    c2248t27.f6531y0 = i22;
                    c2248t27.f6497h0 = f4;
                }
                if (i20 == i4 - 1) {
                    c2248t27.m365j(c2248t27.f6465J, this.f6682g, this.f6686k);
                }
                if (c2248t23 != null) {
                    c2248t27.f6462H.m414a(c2248t23.f6465J, C2287v2.this.f6664i1);
                    if (i20 == i7) {
                        c2248t27.f6462H.m401n(this.f6684i);
                    }
                    c2248t23.f6465J.m414a(c2248t27.f6462H, 0);
                    if (i20 == i8 + 1) {
                        c2248t23.f6465J.m401n(this.f6686k);
                    }
                }
                if (c2248t27 != c2248t26) {
                    if (z) {
                        int i23 = C2287v2.this.f6665j1;
                        if (i23 == 0) {
                            c2248t27.f6464I.m414a(c2248t26.f6464I, 0);
                        } else if (i23 == 1) {
                            c2248t27.f6460G.m414a(c2248t26.f6460G, 0);
                        } else if (i23 == 2) {
                            c2248t27.f6460G.m414a(c2248t26.f6460G, 0);
                            c2248t27.f6464I.m414a(c2248t26.f6464I, 0);
                        }
                    } else {
                        int i24 = C2287v2.this.f6665j1;
                        if (i24 == 0) {
                            c2248t27.f6460G.m414a(c2248t26.f6460G, 0);
                        } else if (i24 == 1) {
                            c2248t27.f6464I.m414a(c2248t26.f6464I, 0);
                        } else if (i24 == 2) {
                            if (z3) {
                                c2248t27.f6460G.m414a(this.f6679d, this.f6683h);
                                c2248t27.f6464I.m414a(this.f6681f, this.f6685j);
                            } else {
                                c2248t27.f6460G.m414a(c2248t26.f6460G, 0);
                                c2248t27.f6464I.m414a(c2248t26.f6464I, 0);
                            }
                        }
                        i20++;
                        c2248t23 = c2248t27;
                    }
                }
                i20++;
                c2248t23 = c2248t27;
            }
        }

        /* renamed from: c */
        public int m285c() {
            if (this.f6676a == 1) {
                return this.f6688m - C2287v2.this.f6664i1;
            }
            return this.f6688m;
        }

        /* renamed from: d */
        public int m284d() {
            if (this.f6676a == 0) {
                return this.f6687l - C2287v2.this.f6663h1;
            }
            return this.f6687l;
        }

        /* renamed from: e */
        public void m283e(int i) {
            C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.FIXED;
            C2248t2.EnumC2249a enumC2249a2 = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
            int i2 = this.f6691p;
            if (i2 == 0) {
                return;
            }
            int i3 = this.f6690o;
            int i4 = i / i2;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = this.f6689n;
                int i7 = i6 + i5;
                C2287v2 c2287v2 = C2287v2.this;
                if (i7 >= c2287v2.f6675t1) {
                    break;
                }
                C2248t2 c2248t2 = c2287v2.f6674s1[i6 + i5];
                if (this.f6676a == 0) {
                    if (c2248t2 != null && c2248t2.m359r() == enumC2249a2 && c2248t2.f6506m == 0) {
                        C2287v2.this.m2590Y(c2248t2, enumC2249a, i4, c2248t2.m355v(), c2248t2.m360q());
                    }
                } else if (c2248t2 != null && c2248t2.m355v() == enumC2249a2 && c2248t2.f6508n == 0) {
                    C2287v2.this.m2590Y(c2248t2, c2248t2.m359r(), c2248t2.m354w(), enumC2249a, i4);
                }
            }
            this.f6687l = 0;
            this.f6688m = 0;
            this.f6677b = null;
            this.f6678c = 0;
            int i8 = this.f6690o;
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = this.f6689n + i9;
                C2287v2 c2287v22 = C2287v2.this;
                if (i10 >= c2287v22.f6675t1) {
                    return;
                }
                C2248t2 c2248t22 = c2287v22.f6674s1[i10];
                if (this.f6676a == 0) {
                    int m354w = c2248t22.m354w();
                    C2287v2 c2287v23 = C2287v2.this;
                    int i11 = c2287v23.f6663h1;
                    if (c2248t22.f6503k0 == 8) {
                        i11 = 0;
                    }
                    this.f6687l = m354w + i11 + this.f6687l;
                    int m289Z = c2287v23.m289Z(c2248t22, this.f6692q);
                    if (this.f6677b == null || this.f6678c < m289Z) {
                        this.f6677b = c2248t22;
                        this.f6678c = m289Z;
                        this.f6688m = m289Z;
                    }
                } else {
                    int m288a0 = c2287v22.m288a0(c2248t22, this.f6692q);
                    int m289Z2 = C2287v2.this.m289Z(c2248t22, this.f6692q);
                    int i12 = C2287v2.this.f6664i1;
                    if (c2248t22.f6503k0 == 8) {
                        i12 = 0;
                    }
                    this.f6688m = m289Z2 + i12 + this.f6688m;
                    if (this.f6677b == null || this.f6678c < m288a0) {
                        this.f6677b = c2248t22;
                        this.f6678c = m288a0;
                        this.f6687l = m288a0;
                    }
                }
            }
        }

        /* renamed from: f */
        public void m282f(int i, C2224s2 c2224s2, C2224s2 c2224s22, C2224s2 c2224s23, C2224s2 c2224s24, int i2, int i3, int i4, int i5, int i6) {
            this.f6676a = i;
            this.f6679d = c2224s2;
            this.f6680e = c2224s22;
            this.f6681f = c2224s23;
            this.f6682g = c2224s24;
            this.f6683h = i2;
            this.f6684i = i3;
            this.f6685j = i4;
            this.f6686k = i5;
            this.f6692q = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x061d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x029e -> B:191:0x02a9). Please submit an issue!!! */
    @Override // p000.C0016A2
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo290X(int r34, int r35, int r36, int r37) {
        /*
            Method dump skipped, instructions count: 1569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2287v2.mo290X(int, int, int, int):void");
    }

    /* renamed from: Z */
    public final int m289Z(C2248t2 c2248t2, int i) {
        if (c2248t2 == null) {
            return 0;
        }
        if (c2248t2.m355v() == C2248t2.EnumC2249a.MATCH_CONSTRAINT) {
            int i2 = c2248t2.f6508n;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (c2248t2.f6522u * i);
                if (i3 != c2248t2.m360q()) {
                    c2248t2.f6496h = true;
                    m2590Y(c2248t2, c2248t2.m359r(), c2248t2.m354w(), C2248t2.EnumC2249a.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return c2248t2.m360q();
            } else {
                if (i2 == 3) {
                    return (int) ((c2248t2.m354w() * c2248t2.f6477V) + 0.5f);
                }
            }
        }
        return c2248t2.m360q();
    }

    /* renamed from: a0 */
    public final int m288a0(C2248t2 c2248t2, int i) {
        if (c2248t2 == null) {
            return 0;
        }
        if (c2248t2.m359r() == C2248t2.EnumC2249a.MATCH_CONSTRAINT) {
            int i2 = c2248t2.f6506m;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (c2248t2.f6516r * i);
                if (i3 != c2248t2.m354w()) {
                    c2248t2.f6496h = true;
                    m2590Y(c2248t2, C2248t2.EnumC2249a.FIXED, i3, c2248t2.m355v(), c2248t2.m360q());
                }
                return i3;
            } else if (i2 == 1) {
                return c2248t2.m354w();
            } else {
                if (i2 == 3) {
                    return (int) ((c2248t2.m360q() * c2248t2.f6477V) + 0.5f);
                }
            }
        }
        return c2248t2.m354w();
    }

    @Override // p000.C2248t2
    /* renamed from: f */
    public void mo214f(C1953l2 c1953l2, boolean z) {
        C2248t2 c2248t2;
        super.mo214f(c1953l2, z);
        C2248t2 c2248t22 = this.f6474S;
        boolean z2 = c2248t22 != null ? ((C2269u2) c2248t22).f6608M0 : false;
        int i = this.f6667l1;
        if (i != 0) {
            if (i != 1) {
                if (i == 2 && this.f6673r1 != null && this.f6672q1 != null && this.f6671p1 != null) {
                    for (int i2 = 0; i2 < this.f6675t1; i2++) {
                        this.f6674s1[i2].m381H();
                    }
                    int[] iArr = this.f6673r1;
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    C2248t2 c2248t23 = null;
                    for (int i5 = 0; i5 < i3; i5++) {
                        C2248t2 c2248t24 = this.f6672q1[z2 ? (i3 - i5) - 1 : i5];
                        if (c2248t24 != null && c2248t24.f6503k0 != 8) {
                            if (i5 == 0) {
                                c2248t24.m365j(c2248t24.f6460G, this.f6460G, this.f118O0);
                                c2248t24.f6529x0 = this.f6651V0;
                                c2248t24.f6495g0 = this.f6657b1;
                            }
                            if (i5 == i3 - 1) {
                                c2248t24.m365j(c2248t24.f6464I, this.f6464I, this.f119P0);
                            }
                            if (i5 > 0) {
                                c2248t24.m365j(c2248t24.f6460G, c2248t23.f6464I, this.f6663h1);
                                c2248t23.m365j(c2248t23.f6464I, c2248t24.f6460G, 0);
                            }
                            c2248t23 = c2248t24;
                        }
                    }
                    for (int i6 = 0; i6 < i4; i6++) {
                        C2248t2 c2248t25 = this.f6671p1[i6];
                        if (c2248t25 != null && c2248t25.f6503k0 != 8) {
                            if (i6 == 0) {
                                c2248t25.m365j(c2248t25.f6462H, this.f6462H, this.f114K0);
                                c2248t25.f6531y0 = this.f6652W0;
                                c2248t25.f6497h0 = this.f6658c1;
                            }
                            if (i6 == i4 - 1) {
                                c2248t25.m365j(c2248t25.f6465J, this.f6465J, this.f115L0);
                            }
                            if (i6 > 0) {
                                c2248t25.m365j(c2248t25.f6462H, c2248t23.f6465J, this.f6664i1);
                                c2248t23.m365j(c2248t23.f6465J, c2248t25.f6462H, 0);
                            }
                            c2248t23 = c2248t25;
                        }
                    }
                    for (int i7 = 0; i7 < i3; i7++) {
                        for (int i8 = 0; i8 < i4; i8++) {
                            int i9 = (i8 * i3) + i7;
                            if (this.f6669n1 == 1) {
                                i9 = (i7 * i4) + i8;
                            }
                            C2248t2[] c2248t2Arr = this.f6674s1;
                            if (i9 < c2248t2Arr.length && (c2248t2 = c2248t2Arr[i9]) != null && c2248t2.f6503k0 != 8) {
                                C2248t2 c2248t26 = this.f6672q1[i7];
                                C2248t2 c2248t27 = this.f6671p1[i8];
                                if (c2248t2 != c2248t26) {
                                    c2248t2.m365j(c2248t2.f6460G, c2248t26.f6460G, 0);
                                    c2248t2.m365j(c2248t2.f6464I, c2248t26.f6464I, 0);
                                }
                                if (c2248t2 != c2248t27) {
                                    c2248t2.m365j(c2248t2.f6462H, c2248t27.f6462H, 0);
                                    c2248t2.m365j(c2248t2.f6465J, c2248t27.f6465J, 0);
                                }
                            }
                        }
                    }
                }
            } else {
                int size = this.f6670o1.size();
                int i10 = 0;
                while (i10 < size) {
                    this.f6670o1.get(i10).m286b(z2, i10, i10 == size + (-1));
                    i10++;
                }
            }
        } else if (this.f6670o1.size() > 0) {
            this.f6670o1.get(0).m286b(z2, 0, true);
        }
        this.f120Q0 = false;
    }

    @Override // p000.C2363y2, p000.C2248t2
    /* renamed from: k */
    public void mo64k(C2248t2 c2248t2, HashMap<C2248t2, C2248t2> hashMap) {
        super.mo64k(c2248t2, hashMap);
        C2287v2 c2287v2 = (C2287v2) c2248t2;
        this.f6651V0 = c2287v2.f6651V0;
        this.f6652W0 = c2287v2.f6652W0;
        this.f6653X0 = c2287v2.f6653X0;
        this.f6654Y0 = c2287v2.f6654Y0;
        this.f6655Z0 = c2287v2.f6655Z0;
        this.f6656a1 = c2287v2.f6656a1;
        this.f6657b1 = c2287v2.f6657b1;
        this.f6658c1 = c2287v2.f6658c1;
        this.f6659d1 = c2287v2.f6659d1;
        this.f6660e1 = c2287v2.f6660e1;
        this.f6661f1 = c2287v2.f6661f1;
        this.f6662g1 = c2287v2.f6662g1;
        this.f6663h1 = c2287v2.f6663h1;
        this.f6664i1 = c2287v2.f6664i1;
        this.f6665j1 = c2287v2.f6665j1;
        this.f6666k1 = c2287v2.f6666k1;
        this.f6667l1 = c2287v2.f6667l1;
        this.f6668m1 = c2287v2.f6668m1;
        this.f6669n1 = c2287v2.f6669n1;
    }
}
