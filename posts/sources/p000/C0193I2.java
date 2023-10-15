package p000;

import p000.C0168H2;

/* renamed from: I2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0193I2 extends C0168H2 {

    /* renamed from: m */
    public int f631m;

    public C0193I2(AbstractC0367Q2 abstractC0367Q2) {
        super(abstractC0367Q2);
        if (abstractC0367Q2 instanceof C0285M2) {
            this.f544e = C0168H2.EnumC0169a.HORIZONTAL_DIMENSION;
        } else {
            this.f544e = C0168H2.EnumC0169a.VERTICAL_DIMENSION;
        }
    }

    @Override // p000.C0168H2
    /* renamed from: c */
    public void mo2389c(int i) {
        if (this.f549j) {
            return;
        }
        this.f549j = true;
        this.f546g = i;
        for (InterfaceC0128F2 interfaceC0128F2 : this.f550k) {
            interfaceC0128F2.mo2141a(interfaceC0128F2);
        }
    }
}
