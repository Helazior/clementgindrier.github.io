package p000;

import p000.C2248t2;

/* renamed from: z2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2397z2 {

    /* renamed from: a */
    public static boolean[] f6913a = new boolean[3];

    /* renamed from: a */
    public static void m7a(C2269u2 c2269u2, C1953l2 c1953l2, C2248t2 c2248t2) {
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.MATCH_PARENT;
        c2248t2.f6502k = -1;
        c2248t2.f6504l = -1;
        C2248t2.EnumC2249a enumC2249a2 = c2269u2.f6473R[0];
        C2248t2.EnumC2249a enumC2249a3 = C2248t2.EnumC2249a.WRAP_CONTENT;
        if (enumC2249a2 != enumC2249a3 && c2248t2.f6473R[0] == enumC2249a) {
            int i = c2248t2.f6460G.f6374g;
            int m354w = c2269u2.m354w() - c2248t2.f6464I.f6374g;
            C2224s2 c2224s2 = c2248t2.f6460G;
            c2224s2.f6376i = c1953l2.m623l(c2224s2);
            C2224s2 c2224s22 = c2248t2.f6464I;
            c2224s22.f6376i = c1953l2.m623l(c2224s22);
            c1953l2.m630e(c2248t2.f6460G.f6376i, i);
            c1953l2.m630e(c2248t2.f6464I.f6376i, m354w);
            c2248t2.f6502k = 2;
            c2248t2.f6479X = i;
            int i2 = m354w - i;
            c2248t2.f6475T = i2;
            int i3 = c2248t2.f6491e0;
            if (i2 < i3) {
                c2248t2.f6475T = i3;
            }
        }
        if (c2269u2.f6473R[1] == enumC2249a3 || c2248t2.f6473R[1] != enumC2249a) {
            return;
        }
        int i4 = c2248t2.f6462H.f6374g;
        int m360q = c2269u2.m360q() - c2248t2.f6465J.f6374g;
        C2224s2 c2224s23 = c2248t2.f6462H;
        c2224s23.f6376i = c1953l2.m623l(c2224s23);
        C2224s2 c2224s24 = c2248t2.f6465J;
        c2224s24.f6376i = c1953l2.m623l(c2224s24);
        c1953l2.m630e(c2248t2.f6462H.f6376i, i4);
        c1953l2.m630e(c2248t2.f6465J.f6376i, m360q);
        if (c2248t2.f6489d0 > 0 || c2248t2.f6503k0 == 8) {
            C2224s2 c2224s25 = c2248t2.f6466K;
            c2224s25.f6376i = c1953l2.m623l(c2224s25);
            c1953l2.m630e(c2248t2.f6466K.f6376i, c2248t2.f6489d0 + i4);
        }
        c2248t2.f6504l = 2;
        c2248t2.f6480Y = i4;
        int i5 = m360q - i4;
        c2248t2.f6476U = i5;
        int i6 = c2248t2.f6493f0;
        if (i5 < i6) {
            c2248t2.f6476U = i6;
        }
    }

    /* renamed from: b */
    public static final boolean m6b(int i, int i2) {
        return (i & i2) == i2;
    }
}
