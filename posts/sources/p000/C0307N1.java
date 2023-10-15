package p000;

/* renamed from: N1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0307N1 {

    /* renamed from: a */
    public float f1014a;

    /* renamed from: b */
    public float f1015b;

    /* renamed from: c */
    public float f1016c;

    /* renamed from: d */
    public float f1017d;

    /* renamed from: e */
    public float f1018e;

    /* renamed from: f */
    public float f1019f;

    /* renamed from: a */
    public void m2184a(float f, float f2, int i, int i2, float[] fArr) {
        float f3;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = f4 + this.f1016c;
        float f8 = f5 + this.f1017d;
        float f9 = (this.f1014a * (f - 0.5f) * 2.0f) + f7;
        float f10 = (this.f1015b * f6) + f8;
        float radians = (float) Math.toRadians(this.f1019f);
        float radians2 = (float) Math.toRadians(this.f1018e);
        double d = radians;
        double sin = Math.sin(d);
        double d2 = i2 * f6;
        double cos = Math.cos(d);
        fArr[0] = (((float) ((sin * ((-i) * f3)) - (Math.cos(d) * d2))) * radians2) + f9;
        fArr[1] = (radians2 * ((float) ((cos * (i * f3)) - (Math.sin(d) * d2)))) + f10;
    }

    /* renamed from: b */
    public void m2183b(AbstractC1599d2 abstractC1599d2, float f) {
        if (abstractC1599d2 != null) {
            double d = f;
            this.f1018e = (float) abstractC1599d2.f3976a.mo2352e(d, 0);
            this.f1019f = (float) abstractC1599d2.f3976a.mo2355b(d, 0);
        }
    }

    /* renamed from: c */
    public void m2182c(AbstractC0410S1 abstractC0410S1, AbstractC0410S1 abstractC0410S12, float f) {
        if (abstractC0410S1 == null && abstractC0410S12 == null) {
            return;
        }
        if (abstractC0410S1 == null) {
            this.f1014a = abstractC0410S1.m2043b(f);
        }
        if (abstractC0410S12 == null) {
            this.f1015b = abstractC0410S12.m2043b(f);
        }
    }

    /* renamed from: d */
    public void m2181d(AbstractC1599d2 abstractC1599d2, AbstractC1599d2 abstractC1599d22, float f) {
        if (abstractC1599d2 != null) {
            this.f1014a = (float) abstractC1599d2.f3976a.mo2352e(f, 0);
        }
        if (abstractC1599d22 != null) {
            this.f1015b = (float) abstractC1599d22.f3976a.mo2352e(f, 0);
        }
    }

    /* renamed from: e */
    public void m2180e(AbstractC1599d2 abstractC1599d2, AbstractC1599d2 abstractC1599d22, float f) {
        if (abstractC1599d2 != null) {
            this.f1016c = (float) abstractC1599d2.f3976a.mo2352e(f, 0);
        }
        if (abstractC1599d22 != null) {
            this.f1017d = (float) abstractC1599d22.f3976a.mo2352e(f, 0);
        }
    }
}
