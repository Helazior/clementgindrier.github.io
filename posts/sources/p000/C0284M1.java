package p000;

/* renamed from: M1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0284M1 extends AbstractanimationInterpolatorC0606a2 {

    /* renamed from: a */
    public float f943a;

    /* renamed from: b */
    public float f944b;

    /* renamed from: c */
    public float f945c;

    /* renamed from: d */
    public float f946d;

    /* renamed from: e */
    public float f947e;

    /* renamed from: f */
    public float f948f;

    /* renamed from: g */
    public float f949g;

    /* renamed from: h */
    public float f950h;

    /* renamed from: i */
    public float f951i;

    /* renamed from: j */
    public int f952j;

    /* renamed from: k */
    public boolean f953k = false;

    /* renamed from: l */
    public float f954l;

    /* renamed from: m */
    public float f955m;

    @Override // p000.AbstractanimationInterpolatorC0606a2
    /* renamed from: a */
    public float mo1565a() {
        return this.f953k ? -m2205c(this.f955m) : m2205c(this.f955m);
    }

    /* renamed from: b */
    public void m2206b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f954l = f;
        boolean z = f > f2;
        this.f953k = z;
        if (z) {
            m2204d(-f3, f - f2, f5, f6, f4);
        } else {
            m2204d(f3, f2 - f, f5, f6, f4);
        }
    }

    /* renamed from: c */
    public float m2205c(float f) {
        float f2;
        float f3;
        float f4 = this.f946d;
        if (f <= f4) {
            f2 = this.f943a;
            f3 = this.f944b;
        } else {
            int i = this.f952j;
            if (i == 1) {
                return 0.0f;
            }
            f -= f4;
            f4 = this.f947e;
            if (f >= f4) {
                if (i == 2) {
                    return this.f950h;
                }
                float f5 = f - f4;
                float f6 = this.f948f;
                if (f5 < f6) {
                    float f7 = this.f945c;
                    return f7 - ((f5 * f7) / f6);
                }
                return this.f951i;
            }
            f2 = this.f944b;
            f3 = this.f945c;
        }
        return (((f3 - f2) * f) / f4) + f2;
    }

    /* renamed from: d */
    public final void m2204d(float f, float f2, float f3, float f4, float f5) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.f943a = f;
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float sqrt = (float) Math.sqrt((f2 - ((((-f) / f3) * f) / 2.0f)) * f3);
            if (sqrt < f4) {
                this.f952j = 2;
                this.f943a = f;
                this.f944b = sqrt;
                this.f945c = 0.0f;
                float f8 = (sqrt - f) / f3;
                this.f946d = f8;
                this.f947e = sqrt / f3;
                this.f949g = ((f + sqrt) * f8) / 2.0f;
                this.f950h = f2;
                this.f951i = f2;
                return;
            }
            this.f952j = 3;
            this.f943a = f;
            this.f944b = f4;
            this.f945c = f4;
            float f9 = (f4 - f) / f3;
            this.f946d = f9;
            float f10 = f4 / f3;
            this.f948f = f10;
            float f11 = ((f + f4) * f9) / 2.0f;
            float f12 = (f10 * f4) / 2.0f;
            this.f947e = ((f2 - f11) - f12) / f4;
            this.f949g = f11;
            this.f950h = f2 - f12;
            this.f951i = f2;
        } else if (f7 >= f2) {
            this.f952j = 1;
            this.f943a = f;
            this.f944b = 0.0f;
            this.f949g = f2;
            this.f946d = (2.0f * f2) / f;
        } else {
            float f13 = f2 - f7;
            float f14 = f13 / f;
            if (f14 + f6 < f5) {
                this.f952j = 2;
                this.f943a = f;
                this.f944b = f;
                this.f945c = 0.0f;
                this.f949g = f13;
                this.f950h = f2;
                this.f946d = f14;
                this.f947e = f6;
                return;
            }
            float sqrt2 = (float) Math.sqrt(((f * f) / 2.0f) + (f3 * f2));
            float f15 = (sqrt2 - f) / f3;
            this.f946d = f15;
            float f16 = sqrt2 / f3;
            this.f947e = f16;
            if (sqrt2 < f4) {
                this.f952j = 2;
                this.f943a = f;
                this.f944b = sqrt2;
                this.f945c = 0.0f;
                this.f946d = f15;
                this.f947e = f16;
                this.f949g = ((f + sqrt2) * f15) / 2.0f;
                this.f950h = f2;
                return;
            }
            this.f952j = 3;
            this.f943a = f;
            this.f944b = f4;
            this.f945c = f4;
            float f17 = (f4 - f) / f3;
            this.f946d = f17;
            float f18 = f4 / f3;
            this.f948f = f18;
            float f19 = ((f + f4) * f17) / 2.0f;
            float f20 = (f18 * f4) / 2.0f;
            this.f947e = ((f2 - f19) - f20) / f4;
            this.f949g = f19;
            this.f950h = f2 - f20;
            this.f951i = f2;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2;
        float f3 = this.f946d;
        if (f <= f3) {
            float f4 = this.f943a;
            f2 = ((((this.f944b - f4) * f) * f) / (f3 * 2.0f)) + (f4 * f);
        } else {
            int i = this.f952j;
            if (i == 1) {
                f2 = this.f949g;
            } else {
                float f5 = f - f3;
                float f6 = this.f947e;
                if (f5 < f6) {
                    float f7 = this.f949g;
                    float f8 = this.f944b;
                    f2 = ((((this.f945c - f8) * f5) * f5) / (f6 * 2.0f)) + (f8 * f5) + f7;
                } else if (i == 2) {
                    f2 = this.f950h;
                } else {
                    float f9 = f5 - f6;
                    float f10 = this.f948f;
                    if (f9 < f10) {
                        float f11 = this.f950h;
                        float f12 = this.f945c * f9;
                        f2 = (f11 + f12) - ((f12 * f9) / (f10 * 2.0f));
                    } else {
                        f2 = this.f951i;
                    }
                }
            }
        }
        this.f955m = f;
        return this.f953k ? this.f954l - f2 : this.f954l + f2;
    }
}
