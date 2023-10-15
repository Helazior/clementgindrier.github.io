package p000;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import p000.C2248t2;

/* renamed from: D2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0083D2 {

    /* renamed from: a */
    public final ArrayList<C2248t2> f333a = new ArrayList<>();

    /* renamed from: b */
    public C0084a f334b = new C0084a();

    /* renamed from: c */
    public C2269u2 f335c;

    /* renamed from: D2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0084a {

        /* renamed from: a */
        public C2248t2.EnumC2249a f336a;

        /* renamed from: b */
        public C2248t2.EnumC2249a f337b;

        /* renamed from: c */
        public int f338c;

        /* renamed from: d */
        public int f339d;

        /* renamed from: e */
        public int f340e;

        /* renamed from: f */
        public int f341f;

        /* renamed from: g */
        public int f342g;

        /* renamed from: h */
        public boolean f343h;

        /* renamed from: i */
        public boolean f344i;

        /* renamed from: j */
        public boolean f345j;
    }

    /* renamed from: D2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0085b {
    }

    public C0083D2(C2269u2 c2269u2) {
        this.f335c = c2269u2;
    }

    /* renamed from: a */
    public final boolean m2485a(InterfaceC0085b interfaceC0085b, C2248t2 c2248t2, boolean z) {
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.FIXED;
        this.f334b.f336a = c2248t2.m359r();
        this.f334b.f337b = c2248t2.m355v();
        this.f334b.f338c = c2248t2.m354w();
        this.f334b.f339d = c2248t2.m360q();
        C0084a c0084a = this.f334b;
        c0084a.f344i = false;
        c0084a.f345j = z;
        C2248t2.EnumC2249a enumC2249a2 = c0084a.f336a;
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.MATCH_CONSTRAINT;
        boolean z2 = enumC2249a2 == enumC2249a3;
        boolean z3 = c0084a.f337b == enumC2249a3;
        boolean z4 = z2 && c2248t2.f6477V > 0.0f;
        boolean z5 = z3 && c2248t2.f6477V > 0.0f;
        if (z4 && c2248t2.f6510o[0] == 4) {
            c0084a.f336a = enumC2249a;
        }
        if (z5 && c2248t2.f6510o[1] == 4) {
            c0084a.f337b = enumC2249a;
        }
        ((ConstraintLayout.C0720a) interfaceC0085b).m1524b(c2248t2, c0084a);
        c2248t2.m370S(this.f334b.f340e);
        c2248t2.m375N(this.f334b.f341f);
        C0084a c0084a2 = this.f334b;
        c2248t2.f6450B = c0084a2.f343h;
        c2248t2.m378K(c0084a2.f342g);
        C0084a c0084a3 = this.f334b;
        c0084a3.f345j = false;
        return c0084a3.f344i;
    }

    /* renamed from: b */
    public final void m2484b(C2269u2 c2269u2, int i, int i2) {
        int i3 = c2269u2.f6491e0;
        int i4 = c2269u2.f6493f0;
        c2269u2.m372Q(0);
        c2269u2.m373P(0);
        c2269u2.f6475T = i;
        int i5 = c2269u2.f6491e0;
        if (i < i5) {
            c2269u2.f6475T = i5;
        }
        c2269u2.f6476U = i2;
        int i6 = c2269u2.f6493f0;
        if (i2 < i6) {
            c2269u2.f6476U = i6;
        }
        c2269u2.m372Q(i3);
        c2269u2.m373P(i4);
        this.f335c.mo315V();
    }
}
