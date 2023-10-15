package p000;

import java.util.ArrayList;
import p000.C1953l2;
import p000.C2168p2;

/* renamed from: j2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1909j2 implements C1953l2.InterfaceC1954a {

    /* renamed from: d */
    public InterfaceC1910a f5316d;

    /* renamed from: a */
    public C2168p2 f5313a = null;

    /* renamed from: b */
    public float f5314b = 0.0f;

    /* renamed from: c */
    public ArrayList<C2168p2> f5315c = new ArrayList<>();

    /* renamed from: e */
    public boolean f5317e = false;

    /* renamed from: j2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1910a {
        /* renamed from: a */
        float mo712a(int i);

        /* renamed from: b */
        void mo711b(C2168p2 c2168p2, float f, boolean z);

        /* renamed from: c */
        float mo710c(C2168p2 c2168p2);

        void clear();

        /* renamed from: d */
        boolean mo709d(C2168p2 c2168p2);

        /* renamed from: e */
        float mo708e(C1909j2 c1909j2, boolean z);

        /* renamed from: f */
        void mo707f(C2168p2 c2168p2, float f);

        /* renamed from: g */
        float mo706g(C2168p2 c2168p2, boolean z);

        int getCurrentSize();

        /* renamed from: h */
        C2168p2 mo705h(int i);

        /* renamed from: i */
        void mo704i(float f);

        /* renamed from: j */
        void mo703j();
    }

    public C1909j2() {
    }

    @Override // p000.C1953l2.InterfaceC1954a
    /* renamed from: a */
    public void mo538a(C2168p2 c2168p2) {
        float f;
        int i = c2168p2.f6180d;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
            this.f5316d.mo707f(c2168p2, f);
        }
        f = 1.0f;
        this.f5316d.mo707f(c2168p2, f);
    }

    @Override // p000.C1953l2.InterfaceC1954a
    /* renamed from: b */
    public C2168p2 mo537b(C1953l2 c1953l2, boolean[] zArr) {
        return m715i(zArr, null);
    }

    /* renamed from: c */
    public C1909j2 m721c(C1953l2 c1953l2, int i) {
        this.f5316d.mo707f(c1953l2.m624k(i, "ep"), 1.0f);
        this.f5316d.mo707f(c1953l2.m624k(i, "em"), -1.0f);
        return this;
    }

    @Override // p000.C1953l2.InterfaceC1954a
    public void clear() {
        this.f5316d.clear();
        this.f5313a = null;
        this.f5314b = 0.0f;
    }

    /* renamed from: d */
    public C1909j2 m720d(C2168p2 c2168p2, C2168p2 c2168p22, C2168p2 c2168p23, C2168p2 c2168p24, float f) {
        this.f5316d.mo707f(c2168p2, -1.0f);
        this.f5316d.mo707f(c2168p22, 1.0f);
        this.f5316d.mo707f(c2168p23, f);
        this.f5316d.mo707f(c2168p24, -f);
        return this;
    }

    /* renamed from: e */
    public C1909j2 m719e(C2168p2 c2168p2, C2168p2 c2168p22, C2168p2 c2168p23, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f5314b = i;
        }
        if (!z) {
            this.f5316d.mo707f(c2168p2, -1.0f);
            this.f5316d.mo707f(c2168p22, 1.0f);
            this.f5316d.mo707f(c2168p23, 1.0f);
        } else {
            this.f5316d.mo707f(c2168p2, 1.0f);
            this.f5316d.mo707f(c2168p22, -1.0f);
            this.f5316d.mo707f(c2168p23, -1.0f);
        }
        return this;
    }

    /* renamed from: f */
    public C1909j2 m718f(C2168p2 c2168p2, C2168p2 c2168p22, C2168p2 c2168p23, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f5314b = i;
        }
        if (!z) {
            this.f5316d.mo707f(c2168p2, -1.0f);
            this.f5316d.mo707f(c2168p22, 1.0f);
            this.f5316d.mo707f(c2168p23, -1.0f);
        } else {
            this.f5316d.mo707f(c2168p2, 1.0f);
            this.f5316d.mo707f(c2168p22, -1.0f);
            this.f5316d.mo707f(c2168p23, 1.0f);
        }
        return this;
    }

    /* renamed from: g */
    public C1909j2 m717g(C2168p2 c2168p2, C2168p2 c2168p22, C2168p2 c2168p23, C2168p2 c2168p24, float f) {
        this.f5316d.mo707f(c2168p23, 0.5f);
        this.f5316d.mo707f(c2168p24, 0.5f);
        this.f5316d.mo707f(c2168p2, -0.5f);
        this.f5316d.mo707f(c2168p22, -0.5f);
        this.f5314b = -f;
        return this;
    }

    /* renamed from: h */
    public final boolean m716h(C2168p2 c2168p2) {
        return c2168p2.f6188l <= 1;
    }

    /* renamed from: i */
    public final C2168p2 m715i(boolean[] zArr, C2168p2 c2168p2) {
        C2168p2.EnumC2169a enumC2169a;
        int currentSize = this.f5316d.getCurrentSize();
        C2168p2 c2168p22 = null;
        float f = 0.0f;
        for (int i = 0; i < currentSize; i++) {
            float mo712a = this.f5316d.mo712a(i);
            if (mo712a < 0.0f) {
                C2168p2 mo705h = this.f5316d.mo705h(i);
                if ((zArr == null || !zArr[mo705h.f6178b]) && mo705h != c2168p2 && (((enumC2169a = mo705h.f6185i) == C2168p2.EnumC2169a.SLACK || enumC2169a == C2168p2.EnumC2169a.ERROR) && mo712a < f)) {
                    f = mo712a;
                    c2168p22 = mo705h;
                }
            }
        }
        return c2168p22;
    }

    @Override // p000.C1953l2.InterfaceC1954a
    public boolean isEmpty() {
        return this.f5313a == null && this.f5314b == 0.0f && this.f5316d.getCurrentSize() == 0;
    }

    /* renamed from: j */
    public void m714j(C2168p2 c2168p2) {
        C2168p2 c2168p22 = this.f5313a;
        if (c2168p22 != null) {
            this.f5316d.mo707f(c2168p22, -1.0f);
            this.f5313a.f6179c = -1;
            this.f5313a = null;
        }
        float mo706g = this.f5316d.mo706g(c2168p2, true) * (-1.0f);
        this.f5313a = c2168p2;
        if (mo706g == 1.0f) {
            return;
        }
        this.f5314b /= mo706g;
        this.f5316d.mo704i(mo706g);
    }

    /* renamed from: k */
    public void m713k(C1953l2 c1953l2, C2168p2 c2168p2, boolean z) {
        if (c2168p2.f6182f) {
            float mo710c = this.f5316d.mo710c(c2168p2);
            this.f5314b = (c2168p2.f6181e * mo710c) + this.f5314b;
            this.f5316d.mo706g(c2168p2, z);
            if (z) {
                c2168p2.m456b(this);
            }
            if (this.f5316d.getCurrentSize() == 0) {
                this.f5317e = true;
                c1953l2.f5441a = true;
            }
        }
    }

    /* renamed from: l */
    public void mo536l(C1953l2 c1953l2, C1909j2 c1909j2, boolean z) {
        float mo708e = this.f5316d.mo708e(c1909j2, z);
        this.f5314b = (c1909j2.f5314b * mo708e) + this.f5314b;
        if (z) {
            c1909j2.f5313a.m456b(this);
        }
        if (this.f5313a == null || this.f5316d.getCurrentSize() != 0) {
            return;
        }
        this.f5317e = true;
        c1953l2.f5441a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r9 = this;
            p2 r0 = r9.f5313a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L16
        L7:
            java.lang.String r0 = ""
            java.lang.StringBuilder r0 = p000.outline.m253r(r0)
            p2 r1 = r9.f5313a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L16:
            java.lang.String r1 = " = "
            java.lang.String r0 = p000.outline.m266e(r0, r1)
            float r1 = r9.f5314b
            r2 = 0
            r3 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L33
            java.lang.StringBuilder r0 = p000.outline.m253r(r0)
            float r1 = r9.f5314b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L34
        L33:
            r1 = 0
        L34:
            j2$a r4 = r9.f5316d
            int r4 = r4.getCurrentSize()
        L3a:
            if (r3 >= r4) goto L9a
            j2$a r5 = r9.f5316d
            p2 r5 = r5.mo705h(r3)
            if (r5 != 0) goto L45
            goto L97
        L45:
            j2$a r6 = r9.f5316d
            float r6 = r6.mo712a(r3)
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 != 0) goto L50
            goto L97
        L50:
            java.lang.String r5 = r5.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L63
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 >= 0) goto L74
            java.lang.String r1 = "- "
            java.lang.String r0 = p000.outline.m266e(r0, r1)
            goto L72
        L63:
            if (r7 <= 0) goto L6c
            java.lang.String r1 = " + "
            java.lang.String r0 = p000.outline.m266e(r0, r1)
            goto L74
        L6c:
            java.lang.String r1 = " - "
            java.lang.String r0 = p000.outline.m266e(r0, r1)
        L72:
            float r6 = r6 * r8
        L74:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 != 0) goto L7f
            java.lang.String r0 = p000.outline.m266e(r0, r5)
            goto L96
        L7f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = r1.toString()
        L96:
            r1 = 1
        L97:
            int r3 = r3 + 1
            goto L3a
        L9a:
            if (r1 != 0) goto La2
            java.lang.String r1 = "0.0"
            java.lang.String r0 = p000.outline.m266e(r0, r1)
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1909j2.toString():java.lang.String");
    }

    public C1909j2(C1934k2 c1934k2) {
        this.f5316d = new C1884i2(this, c1934k2);
    }
}
