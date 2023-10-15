package p000;

import androidx.constraintlayout.widget.ConstraintLayout;
import p000.C0083D2;
import p000.C2248t2;

/* renamed from: A2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0016A2 extends C2363y2 {

    /* renamed from: K0 */
    public int f114K0 = 0;

    /* renamed from: L0 */
    public int f115L0 = 0;

    /* renamed from: M0 */
    public int f116M0 = 0;

    /* renamed from: N0 */
    public int f117N0 = 0;

    /* renamed from: O0 */
    public int f118O0 = 0;

    /* renamed from: P0 */
    public int f119P0 = 0;

    /* renamed from: Q0 */
    public boolean f120Q0 = false;

    /* renamed from: R0 */
    public int f121R0 = 0;

    /* renamed from: S0 */
    public int f122S0 = 0;

    /* renamed from: T0 */
    public C0083D2.C0084a f123T0 = new C0083D2.C0084a();

    /* renamed from: U0 */
    public C0083D2.InterfaceC0085b f124U0 = null;

    /* renamed from: W */
    public void m2591W() {
        for (int i = 0; i < this.f6853J0; i++) {
            C2248t2 c2248t2 = this.f6852I0[i];
            if (c2248t2 != null) {
                c2248t2.f6454D = true;
            }
        }
    }

    /* renamed from: X */
    public void mo290X(int i, int i2, int i3, int i4) {
    }

    /* renamed from: Y */
    public void m2590Y(C2248t2 c2248t2, C2248t2.EnumC2249a enumC2249a, int i, C2248t2.EnumC2249a enumC2249a2, int i2) {
        C0083D2.InterfaceC0085b interfaceC0085b;
        C2248t2 c2248t22;
        while (true) {
            interfaceC0085b = this.f124U0;
            if (interfaceC0085b != null || (c2248t22 = this.f6474S) == null) {
                break;
            }
            this.f124U0 = ((C2269u2) c2248t22).f6607L0;
        }
        C0083D2.C0084a c0084a = this.f123T0;
        c0084a.f336a = enumC2249a;
        c0084a.f337b = enumC2249a2;
        c0084a.f338c = i;
        c0084a.f339d = i2;
        ((ConstraintLayout.C0720a) interfaceC0085b).m1524b(c2248t2, c0084a);
        c2248t2.m370S(this.f123T0.f340e);
        c2248t2.m375N(this.f123T0.f341f);
        C0083D2.C0084a c0084a2 = this.f123T0;
        c2248t2.f6450B = c0084a2.f343h;
        c2248t2.m378K(c0084a2.f342g);
    }

    @Override // p000.C2363y2, p000.InterfaceC2341x2
    /* renamed from: b */
    public void mo66b(C2269u2 c2269u2) {
        m2591W();
    }
}
