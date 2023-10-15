package p000;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import p000.AbstractC2366y5;

/* renamed from: B5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0038B5 {

    /* renamed from: a */
    public double f181a;

    /* renamed from: b */
    public double f182b;

    /* renamed from: c */
    public boolean f183c;

    /* renamed from: d */
    public double f184d;

    /* renamed from: e */
    public double f185e;

    /* renamed from: f */
    public double f186f;

    /* renamed from: g */
    public double f187g;

    /* renamed from: h */
    public double f188h;

    /* renamed from: i */
    public double f189i;

    /* renamed from: j */
    public final AbstractC2366y5.C2381o f190j;

    public C0038B5() {
        this.f181a = Math.sqrt(1500.0d);
        this.f182b = 0.5d;
        this.f183c = false;
        this.f189i = Double.MAX_VALUE;
        this.f190j = new AbstractC2366y5.C2381o();
    }

    /* renamed from: a */
    public C0038B5 m2560a(float f) {
        if (f > 0.0f) {
            this.f181a = Math.sqrt(f);
            this.f183c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* renamed from: b */
    public AbstractC2366y5.C2381o m2559b(double d, double d2, long j) {
        double cos;
        double d3;
        if (!this.f183c) {
            if (this.f189i != Double.MAX_VALUE) {
                double d4 = this.f182b;
                if (d4 > 1.0d) {
                    double d5 = this.f181a;
                    this.f186f = (Math.sqrt((d4 * d4) - 1.0d) * d5) + ((-d4) * d5);
                    double d6 = this.f182b;
                    double d7 = this.f181a;
                    this.f187g = ((-d6) * d7) - (Math.sqrt((d6 * d6) - 1.0d) * d7);
                } else if (d4 >= ShadowDrawableWrapper.COS_45 && d4 < 1.0d) {
                    this.f188h = Math.sqrt(1.0d - (d4 * d4)) * this.f181a;
                }
                this.f183c = true;
            } else {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
        }
        double d8 = j / 1000.0d;
        double d9 = d - this.f189i;
        double d10 = this.f182b;
        if (d10 > 1.0d) {
            double d11 = this.f187g;
            double d12 = this.f186f;
            double d13 = d9 - (((d11 * d9) - d2) / (d11 - d12));
            double d14 = ((d9 * d11) - d2) / (d11 - d12);
            d3 = (Math.pow(2.718281828459045d, this.f186f * d8) * d14) + (Math.pow(2.718281828459045d, d11 * d8) * d13);
            double d15 = this.f187g;
            double pow = Math.pow(2.718281828459045d, d15 * d8) * d13 * d15;
            double d16 = this.f186f;
            cos = (Math.pow(2.718281828459045d, d16 * d8) * d14 * d16) + pow;
        } else if (d10 == 1.0d) {
            double d17 = this.f181a;
            double d18 = (d17 * d9) + d2;
            double d19 = (d18 * d8) + d9;
            double pow2 = Math.pow(2.718281828459045d, (-d17) * d8) * d19;
            double pow3 = Math.pow(2.718281828459045d, (-this.f181a) * d8) * d19;
            double d20 = this.f181a;
            cos = (Math.pow(2.718281828459045d, (-d20) * d8) * d18) + (pow3 * (-d20));
            d3 = pow2;
        } else {
            double d21 = 1.0d / this.f188h;
            double d22 = this.f181a;
            double d23 = ((d10 * d22 * d9) + d2) * d21;
            double sin = ((Math.sin(this.f188h * d8) * d23) + (Math.cos(this.f188h * d8) * d9)) * Math.pow(2.718281828459045d, (-d10) * d22 * d8);
            double d24 = this.f181a;
            double d25 = this.f182b;
            double d26 = (-d24) * sin * d25;
            double pow4 = Math.pow(2.718281828459045d, (-d25) * d24 * d8);
            double d27 = this.f188h;
            double d28 = (-d27) * d9;
            double d29 = this.f188h;
            cos = (((Math.cos(d29 * d8) * d23 * d29) + (Math.sin(d27 * d8) * d28)) * pow4) + d26;
            d3 = sin;
        }
        AbstractC2366y5.C2381o c2381o = this.f190j;
        c2381o.f6874a = (float) (d3 + this.f189i);
        c2381o.f6875b = (float) cos;
        return c2381o;
    }

    public C0038B5(float f) {
        this.f181a = Math.sqrt(1500.0d);
        this.f182b = 0.5d;
        this.f183c = false;
        this.f189i = Double.MAX_VALUE;
        this.f190j = new AbstractC2366y5.C2381o();
        this.f189i = f;
    }
}
