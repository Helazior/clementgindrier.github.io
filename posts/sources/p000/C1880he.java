package p000;

import org.jetbrains.annotations.NotNull;

/* renamed from: he */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1880he extends C1848ge {
    /* renamed from: a */
    public static boolean m756a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        C0581Yd.m1766e(charSequence, "$this$contains");
        C0581Yd.m1766e(charSequence2, "other");
        return m753d(charSequence, (String) charSequence2, 0, z, 2) >= 0;
    }

    /* renamed from: b */
    public static final int m755b(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        C0581Yd.m1766e(charSequence, "$this$indexOf");
        C0581Yd.m1766e(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return m754c(charSequence, str, i, charSequence.length(), z, false, 16);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4 A[EDGE_INSN: B:64:0x00b4->B:57:0x00b4 ?: BREAK  , SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m754c(java.lang.CharSequence r8, java.lang.CharSequence r9, int r10, int r11, boolean r12, boolean r13, int r14) {
        /*
            r14 = r14 & 16
            r0 = 0
            if (r14 == 0) goto L6
            r13 = 0
        L6:
            r14 = -1
            if (r13 != 0) goto L19
            if (r10 >= 0) goto Lc
            r10 = 0
        Lc:
            be r13 = new be
            int r1 = r8.length()
            if (r11 <= r1) goto L15
            r11 = r1
        L15:
            r13.<init>(r10, r11)
            goto L2e
        L19:
            java.lang.String r13 = "$this$lastIndex"
            p000.C0581Yd.m1766e(r8, r13)
            int r13 = r8.length()
            int r13 = r13 + r14
            if (r10 <= r13) goto L26
            r10 = r13
        L26:
            if (r11 >= 0) goto L29
            r11 = 0
        L29:
            Zd r13 = new Zd
            r13.<init>(r10, r11, r14)
        L2e:
            boolean r10 = r8 instanceof java.lang.String
            java.lang.String r11 = "other"
            if (r10 == 0) goto L6c
            boolean r10 = r9 instanceof java.lang.String
            if (r10 == 0) goto L6c
            int r10 = r13.f2118a
            int r1 = r13.f2119b
            int r13 = r13.f2120c
            if (r13 < 0) goto L43
            if (r10 > r1) goto Lba
            goto L45
        L43:
            if (r10 < r1) goto Lba
        L45:
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
            int r7 = r9.length()
            java.lang.String r3 = "$this$regionMatches"
            p000.C0581Yd.m1766e(r2, r3)
            p000.C0581Yd.m1766e(r5, r11)
            if (r12 != 0) goto L5e
            boolean r2 = r2.regionMatches(r0, r5, r10, r7)
            goto L65
        L5e:
            r4 = 0
            r3 = r12
            r6 = r10
            boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
        L65:
            if (r2 == 0) goto L68
            goto Lb4
        L68:
            if (r10 == r1) goto Lba
            int r10 = r10 + r13
            goto L45
        L6c:
            int r10 = r13.f2118a
            int r1 = r13.f2119b
            int r13 = r13.f2120c
            if (r13 < 0) goto L77
            if (r10 > r1) goto Lba
            goto L79
        L77:
            if (r10 < r1) goto Lba
        L79:
            int r2 = r9.length()
            java.lang.String r3 = "$this$regionMatchesImpl"
            p000.C0581Yd.m1766e(r9, r3)
            p000.C0581Yd.m1766e(r8, r11)
            if (r10 < 0) goto Lb1
            int r3 = r9.length()
            int r3 = r3 - r2
            if (r3 < 0) goto Lb1
            int r3 = r8.length()
            int r3 = r3 - r2
            if (r10 <= r3) goto L96
            goto Lb1
        L96:
            r3 = 0
        L97:
            if (r3 >= r2) goto Laf
            int r4 = r0 + r3
            char r4 = r9.charAt(r4)
            int r5 = r10 + r3
            char r5 = r8.charAt(r5)
            boolean r4 = p000.C0374Q7.m2090e(r4, r5, r12)
            if (r4 != 0) goto Lac
            goto Lb1
        Lac:
            int r3 = r3 + 1
            goto L97
        Laf:
            r2 = 1
            goto Lb2
        Lb1:
            r2 = 0
        Lb2:
            if (r2 == 0) goto Lb6
        Lb4:
            r14 = r10
            goto Lba
        Lb6:
            if (r10 == r1) goto Lba
            int r10 = r10 + r13
            goto L79
        Lba:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1880he.m754c(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, boolean, int):int");
    }

    /* renamed from: d */
    public static /* synthetic */ int m753d(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m755b(charSequence, str, i, z);
    }
}
