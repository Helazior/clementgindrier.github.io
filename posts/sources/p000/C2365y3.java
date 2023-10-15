package p000;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* renamed from: y3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2364y3 {

    /* renamed from: a */
    public final Shader f6854a;

    /* renamed from: b */
    public final ColorStateList f6855b;

    /* renamed from: c */
    public int f6856c;

    public C2364y3(Shader shader, ColorStateList colorStateList, int i) {
        this.f6854a = shader;
        this.f6855b = colorStateList;
        this.f6856c = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fa, code lost:
        if (r9 == 2) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fc, code lost:
        r4 = r0.f346a;
        r0 = r0.f347b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0202, code lost:
        if (r6 == 1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0204, code lost:
        if (r6 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0206, code lost:
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0209, code lost:
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x020c, code lost:
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x020e, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, r25, r24, r4, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x021f, code lost:
        r3 = new android.graphics.SweepGradient(r20, r22, r0.f346a, r0.f347b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0234, code lost:
        if (r21 <= 0.0f) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0236, code lost:
        r1 = r0.f346a;
        r0 = r0.f347b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x023d, code lost:
        if (r6 == 1) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0240, code lost:
        if (r6 == 2) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0242, code lost:
        r2 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0245, code lost:
        r2 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0248, code lost:
        r2 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x024a, code lost:
        r3 = new android.graphics.RadialGradient(r20, r22, r21, r1, r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0262, code lost:
        return new p000.C2364y3(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x026a, code lost:
        throw new org.xmlpull.p019v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01dc, code lost:
        if (r8.size() <= 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01de, code lost:
        r0 = new p000.C0086D3(r8, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e4, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e5, code lost:
        if (r0 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e9, code lost:
        if (r18 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01eb, code lost:
        r0 = new p000.C0086D3(r5, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f1, code lost:
        r0 = new p000.C0086D3(r5, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f7, code lost:
        if (r9 == 1) goto L80;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000.C2364y3 m63a(android.content.res.Resources r28, int r29, android.content.res.Resources.Theme r30) {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2364y3.m63a(android.content.res.Resources, int, android.content.res.Resources$Theme):y3");
    }

    /* renamed from: b */
    public boolean m62b() {
        return this.f6854a != null;
    }

    /* renamed from: c */
    public boolean m61c() {
        ColorStateList colorStateList;
        return this.f6854a == null && (colorStateList = this.f6855b) != null && colorStateList.isStateful();
    }

    /* renamed from: d */
    public boolean m60d(int[] iArr) {
        if (m61c()) {
            ColorStateList colorStateList = this.f6855b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f6856c) {
                this.f6856c = colorForState;
                return true;
            }
        }
        return false;
    }
}
