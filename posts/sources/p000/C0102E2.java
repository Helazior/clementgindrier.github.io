package p000;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: E2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0102E2 extends AbstractC0367Q2 {

    /* renamed from: k */
    public ArrayList<AbstractC0367Q2> f373k;

    /* renamed from: l */
    public int f374l;

    public C0102E2(C2248t2 c2248t2, int i) {
        super(c2248t2);
        C2248t2 c2248t22;
        AbstractC0367Q2 abstractC0367Q2;
        int i2;
        AbstractC0367Q2 abstractC0367Q22;
        this.f373k = new ArrayList<>();
        this.f1253f = i;
        C2248t2 c2248t23 = this.f1249b;
        C2248t2 m357t = c2248t23.m357t(i);
        while (true) {
            C2248t2 c2248t24 = m357t;
            c2248t22 = c2248t23;
            c2248t23 = c2248t24;
            if (c2248t23 == null) {
                break;
            }
            m357t = c2248t23.m357t(this.f1253f);
        }
        this.f1249b = c2248t22;
        ArrayList<AbstractC0367Q2> arrayList = this.f373k;
        int i3 = this.f1253f;
        if (i3 == 0) {
            abstractC0367Q2 = c2248t22.f6488d;
        } else {
            abstractC0367Q2 = i3 == 1 ? c2248t22.f6490e : null;
        }
        arrayList.add(abstractC0367Q2);
        C2248t2 m358s = c2248t22.m358s(this.f1253f);
        while (m358s != null) {
            ArrayList<AbstractC0367Q2> arrayList2 = this.f373k;
            int i4 = this.f1253f;
            if (i4 == 0) {
                abstractC0367Q22 = m358s.f6488d;
            } else {
                abstractC0367Q22 = i4 == 1 ? m358s.f6490e : null;
            }
            arrayList2.add(abstractC0367Q22);
            m358s = m358s.m358s(this.f1253f);
        }
        Iterator<AbstractC0367Q2> it = this.f373k.iterator();
        while (it.hasNext()) {
            AbstractC0367Q2 next = it.next();
            int i5 = this.f1253f;
            if (i5 == 0) {
                next.f1249b.f6484b = this;
            } else if (i5 == 1) {
                next.f1249b.f6486c = this;
            }
        }
        if ((this.f1253f == 0 && ((C2269u2) this.f1249b.f6474S).f6608M0) && this.f373k.size() > 1) {
            ArrayList<AbstractC0367Q2> arrayList3 = this.f373k;
            this.f1249b = arrayList3.get(arrayList3.size() - 1).f1249b;
        }
        if (this.f1253f == 0) {
            i2 = this.f1249b.f6529x0;
        } else {
            i2 = this.f1249b.f6531y0;
        }
        this.f374l = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:279:0x03f5, code lost:
        r10 = r10 - r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dd  */
    @Override // p000.AbstractC0367Q2, p000.InterfaceC0128F2
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo2141a(p000.InterfaceC0128F2 r27) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0102E2.mo2141a(F2):void");
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: d */
    public void mo2138d() {
        Iterator<AbstractC0367Q2> it = this.f373k.iterator();
        while (it.hasNext()) {
            it.next().mo2138d();
        }
        int size = this.f373k.size();
        if (size < 1) {
            return;
        }
        C2248t2 c2248t2 = this.f373k.get(0).f1249b;
        C2248t2 c2248t22 = this.f373k.get(size - 1).f1249b;
        if (this.f1253f == 0) {
            C2224s2 c2224s2 = c2248t2.f6460G;
            C2224s2 c2224s22 = c2248t22.f6464I;
            C0168H2 m2133i = m2133i(c2224s2, 0);
            int m410e = c2224s2.m410e();
            C2248t2 m2471m = m2471m();
            if (m2471m != null) {
                m410e = m2471m.f6460G.m410e();
            }
            if (m2133i != null) {
                C0168H2 c0168h2 = this.f1255h;
                c0168h2.f551l.add(m2133i);
                c0168h2.f545f = m410e;
                m2133i.f550k.add(c0168h2);
            }
            C0168H2 m2133i2 = m2133i(c2224s22, 0);
            int m410e2 = c2224s22.m410e();
            C2248t2 m2470n = m2470n();
            if (m2470n != null) {
                m410e2 = m2470n.f6464I.m410e();
            }
            if (m2133i2 != null) {
                C0168H2 c0168h22 = this.f1256i;
                c0168h22.f551l.add(m2133i2);
                c0168h22.f545f = -m410e2;
                m2133i2.f550k.add(c0168h22);
            }
        } else {
            C2224s2 c2224s23 = c2248t2.f6462H;
            C2224s2 c2224s24 = c2248t22.f6465J;
            C0168H2 m2133i3 = m2133i(c2224s23, 1);
            int m410e3 = c2224s23.m410e();
            C2248t2 m2471m2 = m2471m();
            if (m2471m2 != null) {
                m410e3 = m2471m2.f6462H.m410e();
            }
            if (m2133i3 != null) {
                C0168H2 c0168h23 = this.f1255h;
                c0168h23.f551l.add(m2133i3);
                c0168h23.f545f = m410e3;
                m2133i3.f550k.add(c0168h23);
            }
            C0168H2 m2133i4 = m2133i(c2224s24, 1);
            int m410e4 = c2224s24.m410e();
            C2248t2 m2470n2 = m2470n();
            if (m2470n2 != null) {
                m410e4 = m2470n2.f6465J.m410e();
            }
            if (m2133i4 != null) {
                C0168H2 c0168h24 = this.f1256i;
                c0168h24.f551l.add(m2133i4);
                c0168h24.f545f = -m410e4;
                m2133i4.f550k.add(c0168h24);
            }
        }
        this.f1255h.f540a = this;
        this.f1256i.f540a = this;
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: e */
    public void mo2137e() {
        for (int i = 0; i < this.f373k.size(); i++) {
            this.f373k.get(i).mo2137e();
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: f */
    public void mo2136f() {
        this.f1250c = null;
        Iterator<AbstractC0367Q2> it = this.f373k.iterator();
        while (it.hasNext()) {
            it.next().mo2136f();
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: j */
    public long mo2132j() {
        int size = this.f373k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            AbstractC0367Q2 abstractC0367Q2 = this.f373k.get(i);
            j = abstractC0367Q2.f1256i.f545f + abstractC0367Q2.mo2132j() + j + abstractC0367Q2.f1255h.f545f;
        }
        return j;
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: k */
    public boolean mo2131k() {
        int size = this.f373k.size();
        for (int i = 0; i < size; i++) {
            if (!this.f373k.get(i).mo2131k()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: m */
    public final C2248t2 m2471m() {
        for (int i = 0; i < this.f373k.size(); i++) {
            C2248t2 c2248t2 = this.f373k.get(i).f1249b;
            if (c2248t2.f6503k0 != 8) {
                return c2248t2;
            }
        }
        return null;
    }

    /* renamed from: n */
    public final C2248t2 m2470n() {
        for (int size = this.f373k.size() - 1; size >= 0; size--) {
            C2248t2 c2248t2 = this.f373k.get(size).f1249b;
            if (c2248t2.f6503k0 != 8) {
                return c2248t2;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("ChainRun ");
        m253r.append(this.f1253f == 0 ? "horizontal : " : "vertical : ");
        String sb = m253r.toString();
        Iterator<AbstractC0367Q2> it = this.f373k.iterator();
        while (it.hasNext()) {
            String m266e = outline.m266e(sb, "<");
            sb = outline.m266e(m266e + it.next(), "> ");
        }
        return sb;
    }
}
