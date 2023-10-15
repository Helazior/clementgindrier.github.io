package p000;

import android.util.Log;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;

/* renamed from: I1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0191I1 {

    /* renamed from: b */
    public static C0191I1 f624b = new C0191I1();

    /* renamed from: c */
    public static String[] f625c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a */
    public String f626a = "identity";

    /* renamed from: I1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0192a extends C0191I1 {

        /* renamed from: d */
        public double f627d;

        /* renamed from: e */
        public double f628e;

        /* renamed from: f */
        public double f629f;

        /* renamed from: g */
        public double f630g;

        public C0192a(String str) {
            this.f626a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f627d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.f628e = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.f629f = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.f630g = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        @Override // p000.C0191I1
        /* renamed from: a */
        public double mo2393a(double d) {
            if (d <= ShadowDrawableWrapper.COS_45) {
                return ShadowDrawableWrapper.COS_45;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > 0.01d) {
                d2 *= 0.5d;
                d3 = m2391d(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double m2391d = m2391d(d4);
            double d5 = d3 + d2;
            double m2391d2 = m2391d(d5);
            double m2390e = m2390e(d4);
            return (((d - m2391d) * (m2390e(d5) - m2390e)) / (m2391d2 - m2391d)) + m2390e;
        }

        @Override // p000.C0191I1
        /* renamed from: b */
        public double mo2392b(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > 1.0E-4d) {
                d2 *= 0.5d;
                d3 = m2391d(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (m2390e(d5) - m2390e(d4)) / (m2391d(d5) - m2391d(d4));
        }

        /* renamed from: d */
        public final double m2391d(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d2 * d3 * d;
            double d5 = d3 * d * d;
            return (this.f629f * d5) + (this.f627d * d4) + (d * d * d);
        }

        /* renamed from: e */
        public final double m2390e(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d2 * d3 * d;
            double d5 = d3 * d * d;
            return (this.f630g * d5) + (this.f628e * d4) + (d * d * d);
        }
    }

    /* renamed from: c */
    public static C0191I1 m2394c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new C0192a(str);
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new C0192a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new C0192a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new C0192a("cubic(1, 1, 0, 0)");
            case 3:
                return new C0192a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                StringBuilder m253r = outline.m253r("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                m253r.append(Arrays.toString(f625c));
                Log.e("ConstraintSet", m253r.toString());
                return f624b;
        }
    }

    /* renamed from: a */
    public double mo2393a(double d) {
        return d;
    }

    /* renamed from: b */
    public double mo2392b(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.f626a;
    }
}
