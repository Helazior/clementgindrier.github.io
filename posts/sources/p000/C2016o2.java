package p000;

import java.util.Arrays;
import java.util.Comparator;
import p000.C1909j2;

/* renamed from: o2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2016o2 extends C1909j2 {

    /* renamed from: f */
    public int f5578f;

    /* renamed from: g */
    public C2168p2[] f5579g;

    /* renamed from: h */
    public C2168p2[] f5580h;

    /* renamed from: i */
    public int f5581i;

    /* renamed from: j */
    public C2018b f5582j;

    /* renamed from: o2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2017a implements Comparator<C2168p2> {
        public C2017a(C2016o2 c2016o2) {
        }

        @Override // java.util.Comparator
        public int compare(C2168p2 c2168p2, C2168p2 c2168p22) {
            return c2168p2.f6178b - c2168p22.f6178b;
        }
    }

    /* renamed from: o2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2018b implements Comparable {

        /* renamed from: a */
        public C2168p2 f5583a;

        public C2018b(C2016o2 c2016o2) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f5583a.f6178b - ((C2168p2) obj).f6178b;
        }

        public String toString() {
            String str = "[ ";
            if (this.f5583a != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder m253r = outline.m253r(str);
                    m253r.append(this.f5583a.f6184h[i]);
                    m253r.append(" ");
                    str = m253r.toString();
                }
            }
            StringBuilder m252s = outline.m252s(str, "] ");
            m252s.append(this.f5583a);
            return m252s.toString();
        }
    }

    public C2016o2(C1934k2 c1934k2) {
        super(c1934k2);
        this.f5578f = 128;
        this.f5579g = new C2168p2[128];
        this.f5580h = new C2168p2[128];
        this.f5581i = 0;
        this.f5582j = new C2018b(this);
    }

    @Override // p000.C1909j2, p000.C1953l2.InterfaceC1954a
    /* renamed from: a */
    public void mo538a(C2168p2 c2168p2) {
        this.f5582j.f5583a = c2168p2;
        Arrays.fill(c2168p2.f6184h, 0.0f);
        c2168p2.f6184h[c2168p2.f6180d] = 1.0f;
        m535m(c2168p2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r8 < r7) goto L33;
     */
    @Override // p000.C1909j2, p000.C1953l2.InterfaceC1954a
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p000.C2168p2 mo537b(p000.C1953l2 r11, boolean[] r12) {
        /*
            r10 = this;
            r11 = 0
            r0 = -1
            r1 = 0
            r2 = -1
        L4:
            int r3 = r10.f5581i
            if (r1 >= r3) goto L5d
            p2[] r3 = r10.f5579g
            r4 = r3[r1]
            int r5 = r4.f6178b
            boolean r5 = r12[r5]
            if (r5 == 0) goto L13
            goto L5a
        L13:
            o2$b r5 = r10.f5582j
            r5.f5583a = r4
            r4 = 8
            r6 = 1
            if (r2 != r0) goto L39
            java.util.Objects.requireNonNull(r5)
        L1f:
            if (r4 < 0) goto L35
            p2 r3 = r5.f5583a
            float[] r3 = r3.f6184h
            r3 = r3[r4]
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L2d
            goto L35
        L2d:
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L32
            goto L36
        L32:
            int r4 = r4 + (-1)
            goto L1f
        L35:
            r6 = 0
        L36:
            if (r6 == 0) goto L5a
            goto L59
        L39:
            r3 = r3[r2]
            java.util.Objects.requireNonNull(r5)
        L3e:
            if (r4 < 0) goto L56
            float[] r7 = r3.f6184h
            r7 = r7[r4]
            p2 r8 = r5.f5583a
            float[] r8 = r8.f6184h
            r8 = r8[r4]
            int r9 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r9 != 0) goto L51
            int r4 = r4 + (-1)
            goto L3e
        L51:
            int r3 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r3 >= 0) goto L56
            goto L57
        L56:
            r6 = 0
        L57:
            if (r6 == 0) goto L5a
        L59:
            r2 = r1
        L5a:
            int r1 = r1 + 1
            goto L4
        L5d:
            if (r2 != r0) goto L61
            r11 = 0
            return r11
        L61:
            p2[] r11 = r10.f5579g
            r11 = r11[r2]
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2016o2.mo537b(l2, boolean[]):p2");
    }

    @Override // p000.C1909j2, p000.C1953l2.InterfaceC1954a
    public void clear() {
        this.f5581i = 0;
        this.f5314b = 0.0f;
    }

    @Override // p000.C1909j2, p000.C1953l2.InterfaceC1954a
    public boolean isEmpty() {
        return this.f5581i == 0;
    }

    @Override // p000.C1909j2
    /* renamed from: l */
    public void mo536l(C1953l2 c1953l2, C1909j2 c1909j2, boolean z) {
        C2168p2 c2168p2 = c1909j2.f5313a;
        if (c2168p2 == null) {
            return;
        }
        C1909j2.InterfaceC1910a interfaceC1910a = c1909j2.f5316d;
        int currentSize = interfaceC1910a.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            C2168p2 mo705h = interfaceC1910a.mo705h(i);
            float mo712a = interfaceC1910a.mo712a(i);
            C2018b c2018b = this.f5582j;
            c2018b.f5583a = mo705h;
            boolean z2 = true;
            if (mo705h.f6177a) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = c2018b.f5583a.f6184h;
                    fArr[i2] = (c2168p2.f6184h[i2] * mo712a) + fArr[i2];
                    if (Math.abs(fArr[i2]) < 1.0E-4f) {
                        c2018b.f5583a.f6184h[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    C2016o2.this.m534n(c2018b.f5583a);
                }
                z2 = false;
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f = c2168p2.f6184h[i3];
                    if (f != 0.0f) {
                        float f2 = f * mo712a;
                        if (Math.abs(f2) < 1.0E-4f) {
                            f2 = 0.0f;
                        }
                        c2018b.f5583a.f6184h[i3] = f2;
                    } else {
                        c2018b.f5583a.f6184h[i3] = 0.0f;
                    }
                }
            }
            if (z2) {
                m535m(mo705h);
            }
            this.f5314b = (c1909j2.f5314b * mo712a) + this.f5314b;
        }
        m534n(c2168p2);
    }

    /* renamed from: m */
    public final void m535m(C2168p2 c2168p2) {
        int i;
        int i2 = this.f5581i + 1;
        C2168p2[] c2168p2Arr = this.f5579g;
        if (i2 > c2168p2Arr.length) {
            C2168p2[] c2168p2Arr2 = (C2168p2[]) Arrays.copyOf(c2168p2Arr, c2168p2Arr.length * 2);
            this.f5579g = c2168p2Arr2;
            this.f5580h = (C2168p2[]) Arrays.copyOf(c2168p2Arr2, c2168p2Arr2.length * 2);
        }
        C2168p2[] c2168p2Arr3 = this.f5579g;
        int i3 = this.f5581i;
        c2168p2Arr3[i3] = c2168p2;
        int i4 = i3 + 1;
        this.f5581i = i4;
        if (i4 > 1 && c2168p2Arr3[i4 - 1].f6178b > c2168p2.f6178b) {
            int i5 = 0;
            while (true) {
                i = this.f5581i;
                if (i5 >= i) {
                    break;
                }
                this.f5580h[i5] = this.f5579g[i5];
                i5++;
            }
            Arrays.sort(this.f5580h, 0, i, new C2017a(this));
            for (int i6 = 0; i6 < this.f5581i; i6++) {
                this.f5579g[i6] = this.f5580h[i6];
            }
        }
        c2168p2.f6177a = true;
        c2168p2.m457a(this);
    }

    /* renamed from: n */
    public final void m534n(C2168p2 c2168p2) {
        int i = 0;
        while (i < this.f5581i) {
            if (this.f5579g[i] == c2168p2) {
                while (true) {
                    int i2 = this.f5581i;
                    if (i < i2 - 1) {
                        C2168p2[] c2168p2Arr = this.f5579g;
                        int i3 = i + 1;
                        c2168p2Arr[i] = c2168p2Arr[i3];
                        i = i3;
                    } else {
                        this.f5581i = i2 - 1;
                        c2168p2.f6177a = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // p000.C1909j2
    public String toString() {
        StringBuilder m252s = outline.m252s("", " goal -> (");
        m252s.append(this.f5314b);
        m252s.append(") : ");
        String sb = m252s.toString();
        for (int i = 0; i < this.f5581i; i++) {
            this.f5582j.f5583a = this.f5579g[i];
            StringBuilder m253r = outline.m253r(sb);
            m253r.append(this.f5582j);
            m253r.append(" ");
            sb = m253r.toString();
        }
        return sb;
    }
}
