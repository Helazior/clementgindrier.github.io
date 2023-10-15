package p000;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import java.util.Locale;
import p000.C2314w4;

/* renamed from: t4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2251t4 {

    /* renamed from: d */
    public static final InterfaceC2290v4 f6539d;

    /* renamed from: e */
    public static final String f6540e;

    /* renamed from: f */
    public static final String f6541f;

    /* renamed from: g */
    public static final C2251t4 f6542g;

    /* renamed from: h */
    public static final C2251t4 f6543h;

    /* renamed from: a */
    public final boolean f6544a;

    /* renamed from: b */
    public final int f6545b;

    /* renamed from: c */
    public final InterfaceC2290v4 f6546c;

    /* renamed from: t4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2252a {

        /* renamed from: e */
        public static final byte[] f6547e = new byte[1792];

        /* renamed from: a */
        public final CharSequence f6548a;

        /* renamed from: b */
        public final int f6549b;

        /* renamed from: c */
        public int f6550c;

        /* renamed from: d */
        public char f6551d;

        static {
            for (int i = 0; i < 1792; i++) {
                f6547e[i] = Character.getDirectionality(i);
            }
        }

        public C2252a(CharSequence charSequence, boolean z) {
            this.f6548a = charSequence;
            this.f6549b = charSequence.length();
        }

        /* renamed from: a */
        public byte m346a() {
            char charAt = this.f6548a.charAt(this.f6550c - 1);
            this.f6551d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f6548a, this.f6550c);
                this.f6550c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f6550c--;
            char c = this.f6551d;
            return c < 1792 ? f6547e[c] : Character.getDirectionality(c);
        }
    }

    static {
        InterfaceC2290v4 interfaceC2290v4 = C2314w4.f6746c;
        f6539d = interfaceC2290v4;
        f6540e = Character.toString((char) 8206);
        f6541f = Character.toString((char) 8207);
        f6542g = new C2251t4(false, 2, interfaceC2290v4);
        f6543h = new C2251t4(true, 2, interfaceC2290v4);
    }

    public C2251t4(boolean z, int i, InterfaceC2290v4 interfaceC2290v4) {
        this.f6544a = z;
        this.f6545b = i;
        this.f6546c = interfaceC2290v4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r3 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r4 == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r0.f6550c <= 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        switch(r0.m346a()) {
            case 14: goto L62;
            case 15: goto L62;
            case 16: goto L57;
            case 17: goto L57;
            case 18: goto L53;
            default: goto L65;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
        if (r3 != r5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0088, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
        if (r3 != r5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return 0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m350a(java.lang.CharSequence r9) {
        /*
            t4$a r0 = new t4$a
            r1 = 0
            r0.<init>(r9, r1)
            r0.f6550c = r1
            r9 = -1
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
        Ld:
            int r6 = r0.f6550c
            int r7 = r0.f6549b
            if (r6 >= r7) goto L70
            if (r3 != 0) goto L70
            java.lang.CharSequence r7 = r0.f6548a
            char r6 = r7.charAt(r6)
            r0.f6551d = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L39
            java.lang.CharSequence r6 = r0.f6548a
            int r7 = r0.f6550c
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.f6550c
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.f6550c = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L4d
        L39:
            int r6 = r0.f6550c
            int r6 = r6 + r2
            r0.f6550c = r6
            char r6 = r0.f6551d
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L49
            byte[] r7 = p000.C2251t4.C2252a.f6547e
            r6 = r7[r6]
            goto L4d
        L49:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L4d:
            if (r6 == 0) goto L6b
            if (r6 == r2) goto L68
            r7 = 2
            if (r6 == r7) goto L68
            r7 = 9
            if (r6 == r7) goto Ld
            switch(r6) {
                case 14: goto L64;
                case 15: goto L64;
                case 16: goto L60;
                case 17: goto L60;
                case 18: goto L5c;
                default: goto L5b;
            }
        L5b:
            goto L6e
        L5c:
            int r5 = r5 + (-1)
            r4 = 0
            goto Ld
        L60:
            int r5 = r5 + 1
            r4 = 1
            goto Ld
        L64:
            int r5 = r5 + 1
            r4 = -1
            goto Ld
        L68:
            if (r5 != 0) goto L6e
            goto L88
        L6b:
            if (r5 != 0) goto L6e
            goto L8c
        L6e:
            r3 = r5
            goto Ld
        L70:
            if (r3 != 0) goto L73
            goto L91
        L73:
            if (r4 == 0) goto L77
            r1 = r4
            goto L91
        L77:
            int r4 = r0.f6550c
            if (r4 <= 0) goto L91
            byte r4 = r0.m346a()
            switch(r4) {
                case 14: goto L8a;
                case 15: goto L8a;
                case 16: goto L86;
                case 17: goto L86;
                case 18: goto L83;
                default: goto L82;
            }
        L82:
            goto L77
        L83:
            int r5 = r5 + 1
            goto L77
        L86:
            if (r3 != r5) goto L8e
        L88:
            r1 = 1
            goto L91
        L8a:
            if (r3 != r5) goto L8e
        L8c:
            r1 = -1
            goto L91
        L8e:
            int r5 = r5 + (-1)
            goto L77
        L91:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2251t4.m350a(java.lang.CharSequence):int");
    }

    /* renamed from: b */
    public static int m349b(CharSequence charSequence) {
        C2252a c2252a = new C2252a(charSequence, false);
        c2252a.f6550c = c2252a.f6549b;
        int i = 0;
        int i2 = 0;
        while (c2252a.f6550c > 0) {
            byte m346a = c2252a.m346a();
            if (m346a != 0) {
                if (m346a == 1 || m346a == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (m346a != 9) {
                    switch (m346a) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else if (i == 0) {
                return -1;
            } else {
                if (i2 == 0) {
                    i2 = i;
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    public static C2251t4 m348c() {
        Locale locale = Locale.getDefault();
        Locale locale2 = C2343x4.f6802a;
        boolean z = TextUtils.getLayoutDirectionFromLocale(locale) == 1;
        InterfaceC2290v4 interfaceC2290v4 = f6539d;
        if (interfaceC2290v4 == f6539d) {
            return z ? f6543h : f6542g;
        }
        return new C2251t4(z, 2, interfaceC2290v4);
    }

    /* renamed from: d */
    public CharSequence m347d(CharSequence charSequence, InterfaceC2290v4 interfaceC2290v4, boolean z) {
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean m193b = ((C2314w4.AbstractC2317c) interfaceC2290v4).m193b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = "";
        if (((this.f6545b & 2) != 0) && z) {
            boolean m193b2 = ((C2314w4.AbstractC2317c) (m193b ? C2314w4.f6745b : C2314w4.f6744a)).m193b(charSequence, 0, charSequence.length());
            if (!this.f6544a && (m193b2 || m350a(charSequence) == 1)) {
                str = f6540e;
            } else {
                str = (!this.f6544a || (m193b2 && m350a(charSequence) != -1)) ? "" : f6541f;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        if (m193b != this.f6544a) {
            spannableStringBuilder.append(m193b ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean m193b3 = ((C2314w4.AbstractC2317c) (m193b ? C2314w4.f6745b : C2314w4.f6744a)).m193b(charSequence, 0, charSequence.length());
            if (!this.f6544a && (m193b3 || m349b(charSequence) == 1)) {
                str2 = f6540e;
            } else if (this.f6544a && (!m193b3 || m349b(charSequence) == -1)) {
                str2 = f6541f;
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        return spannableStringBuilder;
    }
}
