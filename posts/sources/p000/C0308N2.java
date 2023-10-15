package p000;

import java.util.ArrayList;

/* renamed from: N2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0308N2 {

    /* renamed from: c */
    public static int f1020c;

    /* renamed from: a */
    public AbstractC0367Q2 f1021a;

    /* renamed from: b */
    public ArrayList<AbstractC0367Q2> f1022b = new ArrayList<>();

    public C0308N2(AbstractC0367Q2 abstractC0367Q2, int i) {
        this.f1021a = null;
        f1020c++;
        this.f1021a = abstractC0367Q2;
    }

    /* renamed from: a */
    public final long m2179a(C0168H2 c0168h2, long j) {
        AbstractC0367Q2 abstractC0367Q2 = c0168h2.f543d;
        if (abstractC0367Q2 instanceof C0265L2) {
            return j;
        }
        int size = c0168h2.f550k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            InterfaceC0128F2 interfaceC0128F2 = c0168h2.f550k.get(i);
            if (interfaceC0128F2 instanceof C0168H2) {
                C0168H2 c0168h22 = (C0168H2) interfaceC0128F2;
                if (c0168h22.f543d != abstractC0367Q2) {
                    j2 = Math.min(j2, m2179a(c0168h22, c0168h22.f545f + j));
                }
            }
        }
        if (c0168h2 == abstractC0367Q2.f1256i) {
            long mo2132j = j - abstractC0367Q2.mo2132j();
            return Math.min(Math.min(j2, m2179a(abstractC0367Q2.f1255h, mo2132j)), mo2132j - abstractC0367Q2.f1255h.f545f);
        }
        return j2;
    }

    /* renamed from: b */
    public final long m2178b(C0168H2 c0168h2, long j) {
        AbstractC0367Q2 abstractC0367Q2 = c0168h2.f543d;
        if (abstractC0367Q2 instanceof C0265L2) {
            return j;
        }
        int size = c0168h2.f550k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            InterfaceC0128F2 interfaceC0128F2 = c0168h2.f550k.get(i);
            if (interfaceC0128F2 instanceof C0168H2) {
                C0168H2 c0168h22 = (C0168H2) interfaceC0128F2;
                if (c0168h22.f543d != abstractC0367Q2) {
                    j2 = Math.max(j2, m2178b(c0168h22, c0168h22.f545f + j));
                }
            }
        }
        if (c0168h2 == abstractC0367Q2.f1255h) {
            long mo2132j = j + abstractC0367Q2.mo2132j();
            return Math.max(Math.max(j2, m2178b(abstractC0367Q2.f1256i, mo2132j)), mo2132j - abstractC0367Q2.f1256i.f545f);
        }
        return j2;
    }
}
