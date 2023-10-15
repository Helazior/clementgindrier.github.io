package p000;

/* renamed from: K2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0233K2 extends AbstractC0367Q2 {
    public C0233K2(C2248t2 c2248t2) {
        super(c2248t2);
        c2248t2.f6488d.mo2136f();
        c2248t2.f6490e.mo2136f();
        this.f1253f = ((C2306w2) c2248t2).f6739M0;
    }

    @Override // p000.AbstractC0367Q2, p000.InterfaceC0128F2
    /* renamed from: a */
    public void mo2141a(InterfaceC0128F2 interfaceC0128F2) {
        C0168H2 c0168h2 = this.f1255h;
        if (c0168h2.f542c && !c0168h2.f549j) {
            this.f1255h.mo2389c((int) ((c0168h2.f551l.get(0).f546g * ((C2306w2) this.f1249b).f6735I0) + 0.5f));
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: d */
    public void mo2138d() {
        C2248t2 c2248t2 = this.f1249b;
        C2306w2 c2306w2 = (C2306w2) c2248t2;
        int i = c2306w2.f6736J0;
        int i2 = c2306w2.f6737K0;
        if (c2306w2.f6739M0 == 1) {
            if (i != -1) {
                this.f1255h.f551l.add(c2248t2.f6474S.f6488d.f1255h);
                this.f1249b.f6474S.f6488d.f1255h.f550k.add(this.f1255h);
                this.f1255h.f545f = i;
            } else if (i2 != -1) {
                this.f1255h.f551l.add(c2248t2.f6474S.f6488d.f1256i);
                this.f1249b.f6474S.f6488d.f1256i.f550k.add(this.f1255h);
                this.f1255h.f545f = -i2;
            } else {
                C0168H2 c0168h2 = this.f1255h;
                c0168h2.f541b = true;
                c0168h2.f551l.add(c2248t2.f6474S.f6488d.f1256i);
                this.f1249b.f6474S.f6488d.f1256i.f550k.add(this.f1255h);
            }
            m2347m(this.f1249b.f6488d.f1255h);
            m2347m(this.f1249b.f6488d.f1256i);
            return;
        }
        if (i != -1) {
            this.f1255h.f551l.add(c2248t2.f6474S.f6490e.f1255h);
            this.f1249b.f6474S.f6490e.f1255h.f550k.add(this.f1255h);
            this.f1255h.f545f = i;
        } else if (i2 != -1) {
            this.f1255h.f551l.add(c2248t2.f6474S.f6490e.f1256i);
            this.f1249b.f6474S.f6490e.f1256i.f550k.add(this.f1255h);
            this.f1255h.f545f = -i2;
        } else {
            C0168H2 c0168h22 = this.f1255h;
            c0168h22.f541b = true;
            c0168h22.f551l.add(c2248t2.f6474S.f6490e.f1256i);
            this.f1249b.f6474S.f6490e.f1256i.f550k.add(this.f1255h);
        }
        m2347m(this.f1249b.f6490e.f1255h);
        m2347m(this.f1249b.f6490e.f1256i);
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: e */
    public void mo2137e() {
        C2248t2 c2248t2 = this.f1249b;
        if (((C2306w2) c2248t2).f6739M0 == 1) {
            c2248t2.f6479X = this.f1255h.f546g;
        } else {
            c2248t2.f6480Y = this.f1255h.f546g;
        }
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: f */
    public void mo2136f() {
        this.f1255h.m2413b();
    }

    @Override // p000.AbstractC0367Q2
    /* renamed from: k */
    public boolean mo2131k() {
        return false;
    }

    /* renamed from: m */
    public final void m2347m(C0168H2 c0168h2) {
        this.f1255h.f550k.add(c0168h2);
        c0168h2.f551l.add(this.f1255h);
    }
}
