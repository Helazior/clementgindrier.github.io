package p000;

import android.util.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import p000.AbstractC1599d2;
import p000.C0393R2;
import p000.C0445T2;

/* renamed from: Y1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0568Y1 implements Comparable<C0568Y1> {

    /* renamed from: c */
    public int f2025c;

    /* renamed from: a */
    public float f2023a = 1.0f;

    /* renamed from: b */
    public int f2024b = 0;

    /* renamed from: d */
    public float f2026d = 0.0f;

    /* renamed from: f */
    public float f2027f = 0.0f;

    /* renamed from: g */
    public float f2028g = 0.0f;

    /* renamed from: h */
    public float f2029h = 0.0f;

    /* renamed from: i */
    public float f2030i = 1.0f;

    /* renamed from: j */
    public float f2031j = 1.0f;

    /* renamed from: k */
    public float f2032k = Float.NaN;

    /* renamed from: l */
    public float f2033l = Float.NaN;

    /* renamed from: m */
    public float f2034m = 0.0f;

    /* renamed from: n */
    public float f2035n = 0.0f;

    /* renamed from: o */
    public float f2036o = 0.0f;

    /* renamed from: p */
    public float f2037p = Float.NaN;

    /* renamed from: q */
    public float f2038q = Float.NaN;

    /* renamed from: r */
    public LinkedHashMap<String, C0393R2> f2039r = new LinkedHashMap<>();

    /* renamed from: a */
    public void m1777a(HashMap<String, AbstractC1599d2> hashMap, int i) {
        for (String str : hashMap.keySet()) {
            AbstractC1599d2 abstractC1599d2 = hashMap.get(str);
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c = '\r';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2028g) ? 0.0f : this.f2028g);
                    break;
                case 1:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2029h) ? 0.0f : this.f2029h);
                    break;
                case 2:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2034m) ? 0.0f : this.f2034m);
                    break;
                case 3:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2035n) ? 0.0f : this.f2035n);
                    break;
                case 4:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2036o) ? 0.0f : this.f2036o);
                    break;
                case 5:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2038q) ? 0.0f : this.f2038q);
                    break;
                case 6:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2030i) ? 1.0f : this.f2030i);
                    break;
                case 7:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2031j) ? 1.0f : this.f2031j);
                    break;
                case '\b':
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2032k) ? 0.0f : this.f2032k);
                    break;
                case '\t':
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2033l) ? 0.0f : this.f2033l);
                    break;
                case '\n':
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2027f) ? 0.0f : this.f2027f);
                    break;
                case 11:
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2026d) ? 0.0f : this.f2026d);
                    break;
                case '\f':
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2037p) ? 0.0f : this.f2037p);
                    break;
                case '\r':
                    abstractC1599d2.mo1035b(i, Float.isNaN(this.f2023a) ? 1.0f : this.f2023a);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        if (!this.f2039r.containsKey(str2)) {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                            break;
                        } else {
                            C0393R2 c0393r2 = this.f2039r.get(str2);
                            if (abstractC1599d2 instanceof AbstractC1599d2.C1601b) {
                                ((AbstractC1599d2.C1601b) abstractC1599d2).f3981f.append(i, c0393r2);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i + ", value" + c0393r2.m2053b() + abstractC1599d2);
                                break;
                            }
                        }
                    }
            }
        }
    }

    /* renamed from: b */
    public final boolean m1776b(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* renamed from: c */
    public void m1775c(C2248t2 c2248t2, C0445T2 c0445t2, int i) {
        c2248t2.m353x();
        c2248t2.m352y();
        C0445T2.C0446a m2025h = c0445t2.m2025h(i);
        C0445T2.C0449d c0449d = m2025h.f1457b;
        int i2 = c0449d.f1535c;
        this.f2024b = i2;
        int i3 = c0449d.f1534b;
        this.f2025c = i3;
        this.f2023a = (i3 == 0 || i2 != 0) ? c0449d.f1536d : 0.0f;
        C0445T2.C0450e c0450e = m2025h.f1460e;
        boolean z = c0450e.f1550l;
        this.f2026d = c0450e.f1551m;
        this.f2027f = c0450e.f1540b;
        this.f2028g = c0450e.f1541c;
        this.f2029h = c0450e.f1542d;
        this.f2030i = c0450e.f1543e;
        this.f2031j = c0450e.f1544f;
        this.f2032k = c0450e.f1545g;
        this.f2033l = c0450e.f1546h;
        this.f2034m = c0450e.f1547i;
        this.f2035n = c0450e.f1548j;
        this.f2036o = c0450e.f1549k;
        C0191I1.m2394c(m2025h.f1458c.f1528c);
        this.f2037p = m2025h.f1458c.f1532g;
        this.f2038q = m2025h.f1457b.f1537e;
        for (String str : m2025h.f1461f.keySet()) {
            C0393R2 c0393r2 = m2025h.f1461f.get(str);
            if (c0393r2.f1324b != C0393R2.EnumC0394a.STRING_TYPE) {
                this.f2039r.put(str, c0393r2);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(C0568Y1 c0568y1) {
        Objects.requireNonNull(c0568y1);
        return Float.compare(0.0f, 0.0f);
    }
}
