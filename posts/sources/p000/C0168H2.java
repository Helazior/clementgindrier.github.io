package p000;

import java.util.ArrayList;
import java.util.List;

/* renamed from: H2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0168H2 implements InterfaceC0128F2 {

    /* renamed from: d */
    public AbstractC0367Q2 f543d;

    /* renamed from: f */
    public int f545f;

    /* renamed from: g */
    public int f546g;

    /* renamed from: a */
    public InterfaceC0128F2 f540a = null;

    /* renamed from: b */
    public boolean f541b = false;

    /* renamed from: c */
    public boolean f542c = false;

    /* renamed from: e */
    public EnumC0169a f544e = EnumC0169a.UNKNOWN;

    /* renamed from: h */
    public int f547h = 1;

    /* renamed from: i */
    public C0193I2 f548i = null;

    /* renamed from: j */
    public boolean f549j = false;

    /* renamed from: k */
    public List<InterfaceC0128F2> f550k = new ArrayList();

    /* renamed from: l */
    public List<C0168H2> f551l = new ArrayList();

    /* renamed from: H2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC0169a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public C0168H2(AbstractC0367Q2 abstractC0367Q2) {
        this.f543d = abstractC0367Q2;
    }

    @Override // p000.InterfaceC0128F2
    /* renamed from: a */
    public void mo2141a(InterfaceC0128F2 interfaceC0128F2) {
        for (C0168H2 c0168h2 : this.f551l) {
            if (!c0168h2.f549j) {
                return;
            }
        }
        this.f542c = true;
        InterfaceC0128F2 interfaceC0128F22 = this.f540a;
        if (interfaceC0128F22 != null) {
            interfaceC0128F22.mo2141a(this);
        }
        if (this.f541b) {
            this.f543d.mo2141a(this);
            return;
        }
        C0168H2 c0168h22 = null;
        int i = 0;
        for (C0168H2 c0168h23 : this.f551l) {
            if (!(c0168h23 instanceof C0193I2)) {
                i++;
                c0168h22 = c0168h23;
            }
        }
        if (c0168h22 != null && i == 1 && c0168h22.f549j) {
            C0193I2 c0193i2 = this.f548i;
            if (c0193i2 != null) {
                if (!c0193i2.f549j) {
                    return;
                }
                this.f545f = this.f547h * c0193i2.f546g;
            }
            mo2389c(c0168h22.f546g + this.f545f);
        }
        InterfaceC0128F2 interfaceC0128F23 = this.f540a;
        if (interfaceC0128F23 != null) {
            interfaceC0128F23.mo2141a(this);
        }
    }

    /* renamed from: b */
    public void m2413b() {
        this.f551l.clear();
        this.f550k.clear();
        this.f549j = false;
        this.f546g = 0;
        this.f542c = false;
        this.f541b = false;
    }

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f543d.f1249b.f6505l0);
        sb.append(":");
        sb.append(this.f544e);
        sb.append("(");
        sb.append(this.f549j ? Integer.valueOf(this.f546g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f551l.size());
        sb.append(":d=");
        sb.append(this.f550k.size());
        sb.append(">");
        return sb.toString();
    }
}
