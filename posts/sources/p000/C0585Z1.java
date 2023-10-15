package p000;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import p000.AbstractC0410S1;
import p000.AbstractC1599d2;
import p000.AbstractC1638e2;

/* renamed from: Z1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0585Z1 {

    /* renamed from: a */
    public View f2072a;

    /* renamed from: b */
    public int f2073b;

    /* renamed from: h */
    public AbstractC0166H1[] f2079h;

    /* renamed from: i */
    public AbstractC0166H1 f2080i;

    /* renamed from: m */
    public int[] f2084m;

    /* renamed from: n */
    public double[] f2085n;

    /* renamed from: o */
    public double[] f2086o;

    /* renamed from: p */
    public String[] f2087p;

    /* renamed from: q */
    public int[] f2088q;

    /* renamed from: w */
    public HashMap<String, AbstractC1638e2> f2094w;

    /* renamed from: x */
    public HashMap<String, AbstractC1599d2> f2095x;

    /* renamed from: y */
    public HashMap<String, AbstractC0410S1> f2096y;

    /* renamed from: z */
    public C0548X1[] f2097z;

    /* renamed from: c */
    public int f2074c = -1;

    /* renamed from: d */
    public C0955b2 f2075d = new C0955b2();

    /* renamed from: e */
    public C0955b2 f2076e = new C0955b2();

    /* renamed from: f */
    public C0568Y1 f2077f = new C0568Y1();

    /* renamed from: g */
    public C0568Y1 f2078g = new C0568Y1();

    /* renamed from: j */
    public float f2081j = Float.NaN;

    /* renamed from: k */
    public float f2082k = 0.0f;

    /* renamed from: l */
    public float f2083l = 1.0f;

    /* renamed from: r */
    public int f2089r = 4;

    /* renamed from: s */
    public float[] f2090s = new float[4];

    /* renamed from: t */
    public ArrayList<C0955b2> f2091t = new ArrayList<>();

    /* renamed from: u */
    public float[] f2092u = new float[1];

    /* renamed from: v */
    public ArrayList<AbstractC0328O1> f2093v = new ArrayList<>();

    /* renamed from: A */
    public int f2071A = -1;

    public C0585Z1(View view) {
        this.f2072a = view;
        this.f2073b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            String str = ((ConstraintLayout.LayoutParams) layoutParams).f2860U;
        }
    }

    /* renamed from: a */
    public final float m1754a(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.f2083l;
            if (f3 != 1.0d) {
                float f4 = this.f2082k;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = (f - f4) * f3;
                }
            }
        }
        C0191I1 c0191i1 = this.f2075d.f3663a;
        float f5 = Float.NaN;
        Iterator<C0955b2> it = this.f2091t.iterator();
        while (it.hasNext()) {
            C0955b2 next = it.next();
            C0191I1 c0191i12 = next.f3663a;
            if (c0191i12 != null) {
                float f6 = next.f3665c;
                if (f6 < f) {
                    c0191i1 = c0191i12;
                    f2 = f6;
                } else if (Float.isNaN(f5)) {
                    f5 = next.f3665c;
                }
            }
        }
        if (c0191i1 != null) {
            float f7 = (Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f7;
            f = (((float) c0191i1.mo2393a(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) c0191i1.mo2392b(d);
            }
        }
        return f;
    }

    /* renamed from: b */
    public void m1753b(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float m1754a = m1754a(f, this.f2092u);
        AbstractC0166H1[] abstractC0166H1Arr = this.f2079h;
        int i = 0;
        if (abstractC0166H1Arr != null) {
            double d = m1754a;
            abstractC0166H1Arr[0].mo2351f(d, this.f2086o);
            this.f2079h[0].mo2354c(d, this.f2085n);
            float f4 = this.f2092u[0];
            while (true) {
                dArr = this.f2086o;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * f4;
                i++;
            }
            AbstractC0166H1 abstractC0166H1 = this.f2080i;
            if (abstractC0166H1 != null) {
                double[] dArr2 = this.f2085n;
                if (dArr2.length > 0) {
                    abstractC0166H1.mo2354c(d, dArr2);
                    this.f2080i.mo2351f(d, this.f2086o);
                    this.f2075d.m1191e(f2, f3, fArr, this.f2084m, this.f2086o, this.f2085n);
                    return;
                }
                return;
            }
            this.f2075d.m1191e(f2, f3, fArr, this.f2084m, dArr, this.f2085n);
            return;
        }
        C0955b2 c0955b2 = this.f2076e;
        float f5 = c0955b2.f3667f;
        C0955b2 c0955b22 = this.f2075d;
        float f6 = f5 - c0955b22.f3667f;
        float f7 = c0955b2.f3668g - c0955b22.f3668g;
        fArr[0] = (((c0955b2.f3669h - c0955b22.f3669h) + f6) * f2) + ((1.0f - f2) * f6);
        fArr[1] = (((c0955b2.f3670i - c0955b22.f3670i) + f7) * f3) + ((1.0f - f3) * f7);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0432 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1752c(android.view.View r24, float r25, long r26, p000.C0366Q1 r28) {
        /*
            Method dump skipped, instructions count: 1447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0585Z1.m1752c(android.view.View, float, long, Q1):boolean");
    }

    /* renamed from: d */
    public final void m1751d(C0955b2 c0955b2) {
        c0955b2.m1192d((int) this.f2072a.getX(), (int) this.f2072a.getY(), this.f2072a.getWidth(), this.f2072a.getHeight());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: e */
    public void m1750e(int i, int i2, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        Object obj;
        String str5;
        String str6;
        String str7;
        String str8;
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        Object obj2;
        Object obj3;
        C0585Z1 c0585z1;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Object obj9;
        char c;
        AbstractC0410S1 c0419i;
        Iterator<String> it;
        AbstractC0410S1.C0413c c0413c;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        double d;
        String str21;
        float f;
        String str22;
        String str23;
        double[][] dArr;
        int[] iArr;
        float[] fArr;
        Object obj10;
        HashSet<String> hashSet3;
        Object obj11;
        Object obj12;
        Object obj13;
        char c2;
        Object obj14;
        Object obj15;
        Iterator<String> it2;
        HashMap<String, Integer> hashMap;
        Object obj16;
        Object obj17;
        char c3;
        AbstractC1638e2.C1640b c1645g;
        Object obj18;
        C0393R2 c0393r2;
        Iterator<String> it3;
        Object obj19;
        String str24;
        String str25;
        String str26;
        String str27;
        HashSet<String> hashSet4;
        HashSet<String> hashSet5;
        Object obj20;
        Object obj21;
        char c4;
        AbstractC1599d2 c1608i;
        Object obj22;
        AbstractC1599d2.C1601b c1601b;
        C0393R2 c0393r22;
        String str28;
        String str29;
        String str30;
        int binarySearch;
        C0585Z1 c0585z12 = this;
        new HashSet();
        HashSet<String> hashSet6 = new HashSet<>();
        HashSet<String> hashSet7 = new HashSet<>();
        HashSet<String> hashSet8 = new HashSet<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        int i3 = c0585z12.f2071A;
        if (i3 != -1) {
            c0585z12.f2075d.f3672k = i3;
        }
        C0568Y1 c0568y1 = c0585z12.f2077f;
        C0568Y1 c0568y12 = c0585z12.f2078g;
        String str31 = "alpha";
        if (c0568y1.m1776b(c0568y1.f2023a, c0568y12.f2023a)) {
            hashSet7.add("alpha");
        }
        String str32 = "elevation";
        if (c0568y1.m1776b(c0568y1.f2026d, c0568y12.f2026d)) {
            hashSet7.add("elevation");
        }
        int i4 = c0568y1.f2025c;
        int i5 = c0568y12.f2025c;
        if (i4 != i5 && c0568y1.f2024b == 0 && (i4 == 0 || i5 == 0)) {
            hashSet7.add("alpha");
        }
        String str33 = "rotation";
        if (c0568y1.m1776b(c0568y1.f2027f, c0568y12.f2027f)) {
            hashSet7.add("rotation");
        }
        String str34 = "transitionPathRotate";
        if (!Float.isNaN(c0568y1.f2037p) || !Float.isNaN(c0568y12.f2037p)) {
            hashSet7.add("transitionPathRotate");
        }
        String str35 = "progress";
        if (!Float.isNaN(c0568y1.f2038q) || !Float.isNaN(c0568y12.f2038q)) {
            hashSet7.add("progress");
        }
        if (c0568y1.m1776b(c0568y1.f2028g, c0568y12.f2028g)) {
            hashSet7.add("rotationX");
        }
        if (c0568y1.m1776b(c0568y1.f2029h, c0568y12.f2029h)) {
            hashSet7.add("rotationY");
        }
        if (c0568y1.m1776b(c0568y1.f2032k, c0568y12.f2032k)) {
            hashSet7.add("transformPivotX");
        }
        if (c0568y1.m1776b(c0568y1.f2033l, c0568y12.f2033l)) {
            hashSet7.add("transformPivotY");
        }
        String str36 = "scaleX";
        if (c0568y1.m1776b(c0568y1.f2030i, c0568y12.f2030i)) {
            hashSet7.add("scaleX");
        }
        Object obj23 = "rotationX";
        String str37 = "scaleY";
        if (c0568y1.m1776b(c0568y1.f2031j, c0568y12.f2031j)) {
            hashSet7.add("scaleY");
        }
        Object obj24 = "rotationY";
        if (c0568y1.m1776b(c0568y1.f2034m, c0568y12.f2034m)) {
            hashSet7.add("translationX");
        }
        Object obj25 = "translationX";
        String str38 = "translationY";
        if (c0568y1.m1776b(c0568y1.f2035n, c0568y12.f2035n)) {
            hashSet7.add("translationY");
        }
        boolean m1776b = c0568y1.m1776b(c0568y1.f2036o, c0568y12.f2036o);
        String str39 = "translationZ";
        if (m1776b) {
            hashSet7.add("translationZ");
        }
        ArrayList<AbstractC0328O1> arrayList2 = c0585z12.f2093v;
        if (arrayList2 != null) {
            Iterator<AbstractC0328O1> it4 = arrayList2.iterator();
            arrayList = null;
            while (it4.hasNext()) {
                Iterator<AbstractC0328O1> it5 = it4;
                AbstractC0328O1 next = it4.next();
                String str40 = str38;
                if (next instanceof C0466U1) {
                    C0466U1 c0466u1 = (C0466U1) next;
                    str28 = str39;
                    str29 = str35;
                    C0955b2 c0955b2 = new C0955b2(i, i2, c0466u1, c0585z12.f2075d, c0585z12.f2076e);
                    if (Collections.binarySearch(c0585z12.f2091t, c0955b2) == 0) {
                        StringBuilder m253r = outline.m253r(" KeyPath positon \"");
                        str30 = str36;
                        m253r.append(c0955b2.f3666d);
                        m253r.append("\" outside of range");
                        Log.e("MotionController", m253r.toString());
                    } else {
                        str30 = str36;
                    }
                    c0585z12.f2091t.add((-binarySearch) - 1, c0955b2);
                    int i6 = c0466u1.f1791e;
                    if (i6 != -1) {
                        c0585z12.f2074c = i6;
                    }
                } else {
                    str28 = str39;
                    str29 = str35;
                    str30 = str36;
                    if (next instanceof C0391R1) {
                        next.mo1815b(hashSet8);
                    } else if (next instanceof C0531W1) {
                        next.mo1815b(hashSet6);
                    } else if (next instanceof C0548X1) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add((C0548X1) next);
                    } else {
                        next.mo1821d(hashMap2);
                        next.mo1815b(hashSet7);
                    }
                }
                str38 = str40;
                it4 = it5;
                str36 = str30;
                str39 = str28;
                str35 = str29;
            }
            str = str39;
            str2 = str35;
            str3 = str38;
            str4 = str36;
        } else {
            str = "translationZ";
            str2 = "progress";
            str3 = "translationY";
            str4 = "scaleX";
            arrayList = null;
        }
        if (arrayList != null) {
            c0585z12.f2097z = (C0548X1[]) arrayList.toArray(new C0548X1[0]);
        }
        char c5 = 1;
        if (hashSet7.isEmpty()) {
            obj = obj25;
            str5 = str3;
            str6 = str4;
            str7 = str;
            str8 = str2;
            hashSet = hashSet7;
            hashSet2 = hashSet8;
            obj2 = obj23;
            obj3 = obj24;
        } else {
            c0585z12.f2095x = new HashMap<>();
            Iterator<String> it6 = hashSet7.iterator();
            while (it6.hasNext()) {
                String next2 = it6.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str41 = next2.split(",")[c5];
                    Iterator<AbstractC0328O1> it7 = c0585z12.f2093v.iterator();
                    while (it7.hasNext()) {
                        AbstractC0328O1 next3 = it7.next();
                        Iterator<String> it8 = it6;
                        HashMap<String, C0393R2> hashMap3 = next3.f1116d;
                        if (hashMap3 != null && (c0393r22 = hashMap3.get(str41)) != null) {
                            sparseArray.append(next3.f1113a, c0393r22);
                        }
                        it6 = it8;
                    }
                    it3 = it6;
                    AbstractC1599d2.C1601b c1601b2 = new AbstractC1599d2.C1601b(next2, sparseArray);
                    obj19 = obj25;
                    str24 = str3;
                    str26 = str;
                    str27 = str2;
                    hashSet4 = hashSet7;
                    hashSet5 = hashSet8;
                    c1601b = c1601b2;
                    obj21 = obj24;
                    str25 = str4;
                    obj22 = obj23;
                } else {
                    it3 = it6;
                    switch (next2.hashCode()) {
                        case -1249320806:
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            if (next2.equals(obj20)) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -1249320805:
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet5 = hashSet8;
                            obj21 = obj24;
                            if (next2.equals(obj21)) {
                                hashSet4 = hashSet7;
                                obj20 = obj23;
                                c4 = 1;
                                break;
                            }
                            hashSet4 = hashSet7;
                            obj20 = obj23;
                            c4 = 65535;
                            break;
                        case -1225497657:
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            if (next2.equals(obj19)) {
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 2;
                                break;
                            }
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case -1225497656:
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            if (next2.equals(str24)) {
                                hashSet5 = hashSet8;
                                obj21 = obj24;
                                obj19 = obj25;
                                hashSet4 = hashSet7;
                                obj20 = obj23;
                                c4 = 3;
                                break;
                            } else {
                                hashSet5 = hashSet8;
                                obj21 = obj24;
                                obj19 = obj25;
                                hashSet4 = hashSet7;
                                obj20 = obj23;
                                c4 = 65535;
                                break;
                            }
                        case -1225497655:
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            if (next2.equals(str26)) {
                                obj19 = obj25;
                                str24 = str3;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 4;
                                break;
                            } else {
                                obj19 = obj25;
                                str24 = str3;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 65535;
                                break;
                            }
                        case -1001078227:
                            str25 = str4;
                            str27 = str2;
                            if (next2.equals(str27)) {
                                obj19 = obj25;
                                str24 = str3;
                                str26 = str;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 5;
                                break;
                            } else {
                                obj19 = obj25;
                                str24 = str3;
                                str26 = str;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 65535;
                                break;
                            }
                        case -908189618:
                            str25 = str4;
                            if (next2.equals(str25)) {
                                obj19 = obj25;
                                str24 = str3;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 6;
                                break;
                            } else {
                                obj19 = obj25;
                                str24 = str3;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 65535;
                                break;
                            }
                        case -908189617:
                            if (next2.equals("scaleY")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 7;
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case -797520672:
                            if (next2.equals("waveVariesBy")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = '\b';
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case -760884510:
                            if (next2.equals("transformPivotX")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = '\t';
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case -760884509:
                            if (next2.equals("transformPivotY")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = '\n';
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case -40300674:
                            if (next2.equals("rotation")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 11;
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case -4379043:
                            if (next2.equals("elevation")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = '\f';
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case 37232917:
                            if (next2.equals("transitionPathRotate")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = '\r';
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case 92909918:
                            if (next2.equals("alpha")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 14;
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        case 156108012:
                            if (next2.equals("waveOffset")) {
                                obj19 = obj25;
                                str24 = str3;
                                str25 = str4;
                                str26 = str;
                                str27 = str2;
                                hashSet4 = hashSet7;
                                hashSet5 = hashSet8;
                                obj20 = obj23;
                                obj21 = obj24;
                                c4 = 15;
                                break;
                            }
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                        default:
                            obj19 = obj25;
                            str24 = str3;
                            str25 = str4;
                            str26 = str;
                            str27 = str2;
                            hashSet4 = hashSet7;
                            hashSet5 = hashSet8;
                            obj20 = obj23;
                            obj21 = obj24;
                            c4 = 65535;
                            break;
                    }
                    switch (c4) {
                        case 0:
                            c1608i = new AbstractC1599d2.C1608i();
                            break;
                        case 1:
                            c1608i = new AbstractC1599d2.C1609j();
                            break;
                        case 2:
                            c1608i = new AbstractC1599d2.C1612m();
                            break;
                        case 3:
                            c1608i = new AbstractC1599d2.C1613n();
                            break;
                        case 4:
                            c1608i = new AbstractC1599d2.C1614o();
                            break;
                        case 5:
                            c1608i = new AbstractC1599d2.C1606g();
                            break;
                        case 6:
                            c1608i = new AbstractC1599d2.C1610k();
                            break;
                        case 7:
                            c1608i = new AbstractC1599d2.C1611l();
                            break;
                        case '\b':
                            c1608i = new AbstractC1599d2.C1600a();
                            break;
                        case '\t':
                            c1608i = new AbstractC1599d2.C1604e();
                            break;
                        case '\n':
                            c1608i = new AbstractC1599d2.C1605f();
                            break;
                        case 11:
                            c1608i = new AbstractC1599d2.C1607h();
                            break;
                        case '\f':
                            c1608i = new AbstractC1599d2.C1602c();
                            break;
                        case '\r':
                            c1608i = new AbstractC1599d2.C1603d();
                            break;
                        case 14:
                            c1608i = new AbstractC1599d2.C1600a();
                            break;
                        case 15:
                            c1608i = new AbstractC1599d2.C1600a();
                            break;
                        default:
                            c1608i = null;
                            break;
                    }
                    obj22 = obj20;
                    c1601b = c1608i;
                }
                if (c1601b == null) {
                    str4 = str25;
                    str2 = str27;
                    str = str26;
                    obj23 = obj22;
                    hashSet7 = hashSet4;
                    it6 = it3;
                    obj24 = obj21;
                    obj25 = obj19;
                    hashSet8 = hashSet5;
                    str3 = str24;
                    c5 = 1;
                } else {
                    c1601b.f3980e = next2;
                    Object obj26 = obj21;
                    c0585z12.f2095x.put(next2, c1601b);
                    str4 = str25;
                    str2 = str27;
                    str = str26;
                    hashSet7 = hashSet4;
                    hashSet8 = hashSet5;
                    it6 = it3;
                    str3 = str24;
                    obj25 = obj19;
                    c5 = 1;
                    Object obj27 = obj22;
                    obj24 = obj26;
                    obj23 = obj27;
                }
            }
            obj = obj25;
            str5 = str3;
            str6 = str4;
            str7 = str;
            str8 = str2;
            hashSet = hashSet7;
            hashSet2 = hashSet8;
            Object obj28 = obj24;
            obj2 = obj23;
            obj3 = obj28;
            ArrayList<AbstractC0328O1> arrayList3 = c0585z12.f2093v;
            if (arrayList3 != null) {
                Iterator<AbstractC0328O1> it9 = arrayList3.iterator();
                while (it9.hasNext()) {
                    AbstractC0328O1 next4 = it9.next();
                    if (next4 instanceof C0346P1) {
                        next4.mo1816a(c0585z12.f2095x);
                    }
                }
            }
            c0585z12.f2077f.m1777a(c0585z12.f2095x, 0);
            c0585z12.f2078g.m1777a(c0585z12.f2095x, 100);
            for (Iterator<String> it10 = c0585z12.f2095x.keySet().iterator(); it10.hasNext(); it10 = it10) {
                String next5 = it10.next();
                c0585z12.f2095x.get(next5).mo1034d(hashMap2.containsKey(next5) ? hashMap2.get(next5).intValue() : 0);
            }
        }
        if (hashSet6.isEmpty()) {
            c0585z1 = c0585z12;
            obj4 = obj;
            obj5 = obj3;
            obj6 = obj2;
        } else {
            if (c0585z12.f2094w == null) {
                c0585z12.f2094w = new HashMap<>();
            }
            Iterator<String> it11 = hashSet6.iterator();
            while (it11.hasNext()) {
                String next6 = it11.next();
                if (!c0585z12.f2094w.containsKey(next6)) {
                    if (next6.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str42 = next6.split(",")[1];
                        it2 = it11;
                        Iterator<AbstractC0328O1> it12 = c0585z12.f2093v.iterator();
                        while (it12.hasNext()) {
                            Iterator<AbstractC0328O1> it13 = it12;
                            AbstractC0328O1 next7 = it12.next();
                            HashMap<String, Integer> hashMap4 = hashMap2;
                            HashMap<String, C0393R2> hashMap5 = next7.f1116d;
                            if (hashMap5 != null && (c0393r2 = hashMap5.get(str42)) != null) {
                                sparseArray2.append(next7.f1113a, c0393r2);
                            }
                            hashMap2 = hashMap4;
                            it12 = it13;
                        }
                        hashMap = hashMap2;
                        c1645g = new AbstractC1638e2.C1640b(next6, sparseArray2);
                        obj16 = obj3;
                        obj17 = obj2;
                        obj18 = obj;
                    } else {
                        it2 = it11;
                        hashMap = hashMap2;
                        switch (next6.hashCode()) {
                            case -1249320806:
                                obj16 = obj3;
                                obj17 = obj2;
                                if (next6.equals(obj17)) {
                                    c3 = 0;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case -1249320805:
                                obj16 = obj3;
                                if (next6.equals(obj16)) {
                                    obj17 = obj2;
                                    c3 = 1;
                                    break;
                                }
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -1225497657:
                                if (next6.equals(obj)) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 2;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -1225497656:
                                if (next6.equals(str5)) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 3;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -1225497655:
                                if (next6.equals(str7)) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 4;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -1001078227:
                                if (next6.equals(str8)) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 5;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -908189618:
                                if (next6.equals(str6)) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 6;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -908189617:
                                if (next6.equals("scaleY")) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 7;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -40300674:
                                if (next6.equals("rotation")) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = '\b';
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case -4379043:
                                if (next6.equals("elevation")) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = '\t';
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case 37232917:
                                if (next6.equals("transitionPathRotate")) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = '\n';
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            case 92909918:
                                if (next6.equals("alpha")) {
                                    obj16 = obj3;
                                    obj17 = obj2;
                                    c3 = 11;
                                    break;
                                }
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                            default:
                                obj16 = obj3;
                                obj17 = obj2;
                                c3 = 65535;
                                break;
                        }
                        switch (c3) {
                            case 0:
                                c1645g = new AbstractC1638e2.C1645g();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 1:
                                c1645g = new AbstractC1638e2.C1646h();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 2:
                                c1645g = new AbstractC1638e2.C1649k();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 3:
                                c1645g = new AbstractC1638e2.C1650l();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 4:
                                c1645g = new AbstractC1638e2.C1651m();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 5:
                                c1645g = new AbstractC1638e2.C1643e();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 6:
                                c1645g = new AbstractC1638e2.C1647i();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 7:
                                c1645g = new AbstractC1638e2.C1648j();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case '\b':
                                c1645g = new AbstractC1638e2.C1644f();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case '\t':
                                c1645g = new AbstractC1638e2.C1641c();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case '\n':
                                c1645g = new AbstractC1638e2.C1642d();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            case 11:
                                c1645g = new AbstractC1638e2.C1639a();
                                obj18 = obj;
                                c1645g.f4128i = j;
                                break;
                            default:
                                obj18 = obj;
                                c1645g = null;
                                break;
                        }
                    }
                    if (c1645g != null) {
                        c1645g.f4125f = next6;
                        c0585z12.f2094w.put(next6, c1645g);
                    }
                    obj2 = obj17;
                    obj = obj18;
                    hashMap2 = hashMap;
                    obj3 = obj16;
                    it11 = it2;
                }
            }
            HashMap<String, Integer> hashMap6 = hashMap2;
            Object obj29 = obj3;
            Object obj30 = obj2;
            Object obj31 = obj;
            ArrayList<AbstractC0328O1> arrayList4 = c0585z12.f2093v;
            if (arrayList4 != null) {
                Iterator<AbstractC0328O1> it14 = arrayList4.iterator();
                while (it14.hasNext()) {
                    AbstractC0328O1 next8 = it14.next();
                    if (next8 instanceof C0531W1) {
                        C0531W1 c0531w1 = (C0531W1) next8;
                        HashMap<String, AbstractC1638e2> hashMap7 = c0585z12.f2094w;
                        Objects.requireNonNull(c0531w1);
                        Iterator<String> it15 = hashMap7.keySet().iterator();
                        while (it15.hasNext()) {
                            Iterator<AbstractC0328O1> it16 = it14;
                            String next9 = it15.next();
                            AbstractC1638e2 abstractC1638e2 = hashMap7.get(next9);
                            HashMap<String, AbstractC1638e2> hashMap8 = hashMap7;
                            if (next9.startsWith("CUSTOM")) {
                                C0393R2 c0393r23 = c0531w1.f1116d.get(next9.substring(7));
                                if (c0393r23 != null) {
                                    AbstractC1638e2.C1640b c1640b = (AbstractC1638e2.C1640b) abstractC1638e2;
                                    Iterator<String> it17 = it15;
                                    int i7 = c0531w1.f1113a;
                                    float f2 = c0531w1.f1887s;
                                    Object obj32 = obj30;
                                    int i8 = c0531w1.f1886r;
                                    Object obj33 = obj29;
                                    float f3 = c0531w1.f1888t;
                                    c1640b.f4131l.append(i7, c0393r23);
                                    c1640b.f4132m.append(i7, new float[]{f2, f3});
                                    c1640b.f4121b = Math.max(c1640b.f4121b, i8);
                                    it14 = it16;
                                    it15 = it17;
                                    hashMap7 = hashMap8;
                                    obj30 = obj32;
                                    obj29 = obj33;
                                    c0531w1 = c0531w1;
                                } else {
                                    it14 = it16;
                                    hashMap7 = hashMap8;
                                }
                            } else {
                                Object obj34 = obj29;
                                Object obj35 = obj30;
                                C0531W1 c0531w12 = c0531w1;
                                Iterator<String> it18 = it15;
                                switch (next9.hashCode()) {
                                    case -1249320806:
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        if (next9.equals(obj12)) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -1249320805:
                                        obj11 = obj31;
                                        obj13 = obj34;
                                        if (next9.equals(obj13)) {
                                            obj12 = obj35;
                                            c2 = 1;
                                            break;
                                        } else {
                                            obj12 = obj35;
                                            c2 = 65535;
                                            break;
                                        }
                                    case -1225497657:
                                        obj11 = obj31;
                                        if (next9.equals(obj11)) {
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 2;
                                            break;
                                        }
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -1225497656:
                                        if (next9.equals(str5)) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 3;
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -1225497655:
                                        if (next9.equals(str7)) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 4;
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -1001078227:
                                        if (next9.equals(str8)) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 5;
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -908189618:
                                        if (next9.equals(str6)) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 6;
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -908189617:
                                        if (next9.equals("scaleY")) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 7;
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -40300674:
                                        if (next9.equals("rotation")) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = '\b';
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case -4379043:
                                        if (next9.equals("elevation")) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = '\t';
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case 37232917:
                                        if (next9.equals("transitionPathRotate")) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = '\n';
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    case 92909918:
                                        if (next9.equals("alpha")) {
                                            obj11 = obj31;
                                            obj12 = obj35;
                                            obj13 = obj34;
                                            c2 = 11;
                                            break;
                                        }
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                    default:
                                        obj11 = obj31;
                                        obj12 = obj35;
                                        obj13 = obj34;
                                        c2 = 65535;
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1877i)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1877i, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 1:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1878j)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1878j, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 2:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1882n)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1882n, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 3:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1883o)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1883o, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 4:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1884p)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1884p, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 5:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1885q)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1885q, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 6:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1880l)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1880l, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 7:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1881m)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1881m, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case '\b':
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1876h)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1876h, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case '\t':
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1875g)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1875g, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case '\n':
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        if (!Float.isNaN(c0531w1.f1879k)) {
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1879k, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                        break;
                                    case 11:
                                        c0531w1 = c0531w12;
                                        if (Float.isNaN(c0531w1.f1874f)) {
                                            obj14 = obj13;
                                            obj15 = obj12;
                                            break;
                                        } else {
                                            obj15 = obj12;
                                            obj14 = obj13;
                                            abstractC1638e2.mo1000c(c0531w1.f1113a, c0531w1.f1874f, c0531w1.f1887s, c0531w1.f1886r, c0531w1.f1888t);
                                            break;
                                        }
                                    default:
                                        obj14 = obj13;
                                        obj15 = obj12;
                                        c0531w1 = c0531w12;
                                        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + next9 + "\"");
                                        break;
                                }
                                it14 = it16;
                                it15 = it18;
                                obj30 = obj15;
                                hashMap7 = hashMap8;
                                obj29 = obj14;
                                obj31 = obj11;
                            }
                        }
                    }
                    it14 = it14;
                    obj30 = obj30;
                    obj29 = obj29;
                    obj31 = obj31;
                    c0585z12 = this;
                }
            }
            obj5 = obj29;
            obj4 = obj31;
            obj6 = obj30;
            c0585z1 = this;
            for (String str43 : c0585z1.f2094w.keySet()) {
                HashMap<String, Integer> hashMap9 = hashMap6;
                c0585z1.f2094w.get(str43).mo999e(hashMap9.containsKey(str43) ? hashMap9.get(str43).intValue() : 0);
                hashMap6 = hashMap9;
            }
        }
        int size = c0585z1.f2091t.size() + 2;
        C0955b2[] c0955b2Arr = new C0955b2[size];
        c0955b2Arr[0] = c0585z1.f2075d;
        c0955b2Arr[size - 1] = c0585z1.f2076e;
        if (c0585z1.f2091t.size() > 0 && c0585z1.f2074c == -1) {
            c0585z1.f2074c = 0;
        }
        Iterator<C0955b2> it19 = c0585z1.f2091t.iterator();
        int i9 = 1;
        while (it19.hasNext()) {
            c0955b2Arr[i9] = it19.next();
            i9++;
        }
        HashSet hashSet9 = new HashSet();
        Iterator<String> it20 = c0585z1.f2076e.f3673l.keySet().iterator();
        while (it20.hasNext()) {
            String next10 = it20.next();
            Iterator<String> it21 = it20;
            if (c0585z1.f2075d.f3673l.containsKey(next10)) {
                StringBuilder sb = new StringBuilder();
                obj10 = obj4;
                sb.append("CUSTOM,");
                sb.append(next10);
                String sb2 = sb.toString();
                hashSet3 = hashSet;
                if (!hashSet3.contains(sb2)) {
                    hashSet9.add(next10);
                }
            } else {
                obj10 = obj4;
                hashSet3 = hashSet;
            }
            hashSet = hashSet3;
            obj4 = obj10;
            it20 = it21;
        }
        Object obj36 = obj4;
        String[] strArr = (String[]) hashSet9.toArray(new String[0]);
        c0585z1.f2087p = strArr;
        c0585z1.f2088q = new int[strArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr2 = c0585z1.f2087p;
            if (i10 < strArr2.length) {
                String str44 = strArr2[i10];
                c0585z1.f2088q[i10] = 0;
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (c0955b2Arr[i11].f3673l.containsKey(str44)) {
                        int[] iArr2 = c0585z1.f2088q;
                        iArr2[i10] = c0955b2Arr[i11].f3673l.get(str44).m2051d() + iArr2[i10];
                    } else {
                        i11++;
                    }
                }
                i10++;
            } else {
                boolean z = c0955b2Arr[0].f3672k != -1;
                int length = strArr2.length + 18;
                boolean[] zArr = new boolean[length];
                int i12 = 1;
                while (i12 < size) {
                    String str45 = str5;
                    C0955b2 c0955b22 = c0955b2Arr[i12];
                    String str46 = str7;
                    C0955b2 c0955b23 = c0955b2Arr[i12 - 1];
                    Objects.requireNonNull(c0955b22);
                    zArr[0] = zArr[0] | c0955b22.m1194b(c0955b22.f3666d, c0955b23.f3666d);
                    zArr[1] = zArr[1] | c0955b22.m1194b(c0955b22.f3667f, c0955b23.f3667f) | z;
                    zArr[2] = zArr[2] | c0955b22.m1194b(c0955b22.f3668g, c0955b23.f3668g) | z;
                    zArr[3] = c0955b22.m1194b(c0955b22.f3669h, c0955b23.f3669h) | zArr[3];
                    zArr[4] = zArr[4] | c0955b22.m1194b(c0955b22.f3670i, c0955b23.f3670i);
                    i12++;
                    str5 = str45;
                    str37 = str37;
                    str8 = str8;
                    str6 = str6;
                    str7 = str46;
                }
                String str47 = str6;
                String str48 = str8;
                String str49 = str7;
                String str50 = str5;
                String str51 = str37;
                int i13 = 0;
                for (int i14 = 1; i14 < length; i14++) {
                    if (zArr[i14]) {
                        i13++;
                    }
                }
                int[] iArr3 = new int[i13];
                c0585z1.f2084m = iArr3;
                c0585z1.f2085n = new double[iArr3.length];
                c0585z1.f2086o = new double[iArr3.length];
                int i15 = 0;
                for (int i16 = 1; i16 < length; i16++) {
                    if (zArr[i16]) {
                        c0585z1.f2084m[i15] = i16;
                        i15++;
                    }
                }
                double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, c0585z1.f2084m.length);
                double[] dArr3 = new double[size];
                for (int i17 = 0; i17 < size; i17++) {
                    C0955b2 c0955b24 = c0955b2Arr[i17];
                    double[] dArr4 = dArr2[i17];
                    int[] iArr4 = c0585z1.f2084m;
                    float[] fArr2 = {c0955b24.f3666d, c0955b24.f3667f, c0955b24.f3668g, c0955b24.f3669h, c0955b24.f3670i, c0955b24.f3671j};
                    int i18 = 0;
                    int i19 = 0;
                    while (i18 < iArr4.length) {
                        String str52 = str33;
                        if (iArr4[i18] < 6) {
                            iArr = iArr4;
                            fArr = fArr2;
                            dArr4[i19] = fArr2[iArr4[i18]];
                            i19++;
                        } else {
                            iArr = iArr4;
                            fArr = fArr2;
                        }
                        i18++;
                        str33 = str52;
                        iArr4 = iArr;
                        fArr2 = fArr;
                    }
                    dArr3[i17] = c0955b2Arr[i17].f3665c;
                }
                String str53 = str33;
                int i20 = 0;
                while (true) {
                    int[] iArr5 = c0585z1.f2084m;
                    if (i20 < iArr5.length) {
                        if (iArr5[i20] < C0955b2.f3662p.length) {
                            String m262i = outline.m262i(new StringBuilder(), C0955b2.f3662p[c0585z1.f2084m[i20]], " [");
                            for (int i21 = 0; i21 < size; i21++) {
                                StringBuilder m253r2 = outline.m253r(m262i);
                                m253r2.append(dArr2[i21][i20]);
                                m262i = m253r2.toString();
                            }
                        }
                        i20++;
                    } else {
                        c0585z1.f2079h = new AbstractC0166H1[c0585z1.f2087p.length + 1];
                        int i22 = 0;
                        while (true) {
                            String[] strArr3 = c0585z1.f2087p;
                            if (i22 < strArr3.length) {
                                String str54 = strArr3[i22];
                                int i23 = 0;
                                int i24 = 0;
                                double[] dArr5 = null;
                                double[][] dArr6 = null;
                                while (i23 < size) {
                                    if (c0955b2Arr[i23].f3673l.containsKey(str54)) {
                                        if (dArr6 == null) {
                                            dArr5 = new double[size];
                                            dArr6 = (double[][]) Array.newInstance(double.class, size, c0955b2Arr[i23].f3673l.get(str54).m2051d());
                                        }
                                        dArr5[i24] = c0955b2Arr[i23].f3665c;
                                        C0955b2 c0955b25 = c0955b2Arr[i23];
                                        double[] dArr7 = dArr6[i24];
                                        C0393R2 c0393r24 = c0955b25.f3673l.get(str54);
                                        str22 = str54;
                                        double[] dArr8 = dArr5;
                                        if (c0393r24.m2051d() == 1) {
                                            dArr = dArr6;
                                            dArr7[0] = c0393r24.m2053b();
                                        } else {
                                            dArr = dArr6;
                                            int m2051d = c0393r24.m2051d();
                                            float[] fArr3 = new float[m2051d];
                                            c0393r24.m2052c(fArr3);
                                            int i25 = 0;
                                            int i26 = 0;
                                            while (i25 < m2051d) {
                                                dArr7[i26] = fArr3[i25];
                                                i25++;
                                                m2051d = m2051d;
                                                i26++;
                                                str34 = str34;
                                                fArr3 = fArr3;
                                            }
                                        }
                                        str23 = str34;
                                        i24++;
                                        dArr5 = dArr8;
                                        dArr6 = dArr;
                                    } else {
                                        str22 = str54;
                                        str23 = str34;
                                    }
                                    i23++;
                                    str54 = str22;
                                    str34 = str23;
                                }
                                i22++;
                                c0585z1.f2079h[i22] = AbstractC0166H1.m2414a(c0585z1.f2074c, Arrays.copyOf(dArr5, i24), (double[][]) Arrays.copyOf(dArr6, i24));
                                str34 = str34;
                            } else {
                                String str55 = str34;
                                c0585z1.f2079h[0] = AbstractC0166H1.m2414a(c0585z1.f2074c, dArr3, dArr2);
                                if (c0955b2Arr[0].f3672k != -1) {
                                    int[] iArr6 = new int[size];
                                    double[] dArr9 = new double[size];
                                    double[][] dArr10 = (double[][]) Array.newInstance(double.class, size, 2);
                                    for (int i27 = 0; i27 < size; i27++) {
                                        iArr6[i27] = c0955b2Arr[i27].f3672k;
                                        dArr9[i27] = c0955b2Arr[i27].f3665c;
                                        dArr10[i27][0] = c0955b2Arr[i27].f3667f;
                                        dArr10[i27][1] = c0955b2Arr[i27].f3668g;
                                    }
                                    c0585z1.f2080i = new C0144G1(iArr6, dArr9, dArr10);
                                }
                                float f4 = Float.NaN;
                                c0585z1.f2096y = new HashMap<>();
                                if (c0585z1.f2093v != null) {
                                    Iterator<String> it22 = hashSet2.iterator();
                                    while (it22.hasNext()) {
                                        String next11 = it22.next();
                                        if (next11.startsWith("CUSTOM")) {
                                            it = it22;
                                            c0413c = new AbstractC0410S1.C0413c();
                                            obj7 = obj6;
                                            obj8 = obj36;
                                            str9 = str50;
                                            str10 = str51;
                                            str11 = str48;
                                            str12 = str47;
                                            str13 = str53;
                                            str14 = str55;
                                            str15 = str49;
                                            obj9 = obj5;
                                        } else {
                                            switch (next11.hashCode()) {
                                                case -1249320806:
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    if (next11.equals(obj7)) {
                                                        c = 0;
                                                        break;
                                                    }
                                                    c = 65535;
                                                    break;
                                                case -1249320805:
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    if (next11.equals(obj9)) {
                                                        obj7 = obj6;
                                                        c = 1;
                                                        break;
                                                    } else {
                                                        obj7 = obj6;
                                                        c = 65535;
                                                        break;
                                                    }
                                                case -1225497657:
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    if (next11.equals(obj8)) {
                                                        obj7 = obj6;
                                                        obj9 = obj5;
                                                        c = 2;
                                                        break;
                                                    } else {
                                                        obj7 = obj6;
                                                        obj9 = obj5;
                                                        c = 65535;
                                                        break;
                                                    }
                                                case -1225497656:
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    if (next11.equals(str9)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        obj9 = obj5;
                                                        c = 3;
                                                        break;
                                                    } else {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        obj9 = obj5;
                                                        c = 65535;
                                                        break;
                                                    }
                                                case -1225497655:
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    if (next11.equals(str15)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        obj9 = obj5;
                                                        c = 4;
                                                        break;
                                                    } else {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        obj9 = obj5;
                                                        c = 65535;
                                                        break;
                                                    }
                                                case -1001078227:
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    if (next11.equals(str11)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = 5;
                                                        break;
                                                    }
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case -908189618:
                                                    str10 = str51;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    if (next11.equals(str12)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str11 = str48;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = 6;
                                                        break;
                                                    } else {
                                                        str11 = str48;
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = 65535;
                                                        break;
                                                    }
                                                case -908189617:
                                                    str10 = str51;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    if (next11.equals(str10)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = 7;
                                                        break;
                                                    }
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case -797520672:
                                                    str13 = str53;
                                                    str14 = str55;
                                                    if (next11.equals("waveVariesBy")) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str10 = str51;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = '\b';
                                                        break;
                                                    }
                                                    str10 = str51;
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case -40300674:
                                                    str13 = str53;
                                                    str14 = str55;
                                                    if (next11.equals(str13)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str10 = str51;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = '\t';
                                                        break;
                                                    }
                                                    str10 = str51;
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case -4379043:
                                                    str14 = str55;
                                                    if (next11.equals(str32)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str10 = str51;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str13 = str53;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = '\n';
                                                        break;
                                                    }
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case 37232917:
                                                    str14 = str55;
                                                    if (next11.equals(str14)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str10 = str51;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str13 = str53;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = 11;
                                                        break;
                                                    }
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case 92909918:
                                                    if (next11.equals(str31)) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str10 = str51;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str13 = str53;
                                                        str14 = str55;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = '\f';
                                                        break;
                                                    }
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                case 156108012:
                                                    if (next11.equals("waveOffset")) {
                                                        obj7 = obj6;
                                                        obj8 = obj36;
                                                        str9 = str50;
                                                        str10 = str51;
                                                        str11 = str48;
                                                        str12 = str47;
                                                        str13 = str53;
                                                        str14 = str55;
                                                        str15 = str49;
                                                        obj9 = obj5;
                                                        c = '\r';
                                                        break;
                                                    }
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                                default:
                                                    obj7 = obj6;
                                                    obj8 = obj36;
                                                    str9 = str50;
                                                    str10 = str51;
                                                    str11 = str48;
                                                    str12 = str47;
                                                    str13 = str53;
                                                    str14 = str55;
                                                    str15 = str49;
                                                    obj9 = obj5;
                                                    c = 65535;
                                                    break;
                                            }
                                            switch (c) {
                                                case 0:
                                                    c0419i = new AbstractC0410S1.C0419i();
                                                    break;
                                                case 1:
                                                    c0419i = new AbstractC0410S1.C0420j();
                                                    break;
                                                case 2:
                                                    c0419i = new AbstractC0410S1.C0423m();
                                                    break;
                                                case 3:
                                                    c0419i = new AbstractC0410S1.C0424n();
                                                    break;
                                                case 4:
                                                    c0419i = new AbstractC0410S1.C0425o();
                                                    break;
                                                case 5:
                                                    c0419i = new AbstractC0410S1.C0417g();
                                                    break;
                                                case 6:
                                                    c0419i = new AbstractC0410S1.C0421k();
                                                    break;
                                                case 7:
                                                    c0419i = new AbstractC0410S1.C0422l();
                                                    break;
                                                case '\b':
                                                    c0419i = new AbstractC0410S1.C0412b();
                                                    break;
                                                case '\t':
                                                    c0419i = new AbstractC0410S1.C0418h();
                                                    break;
                                                case '\n':
                                                    c0419i = new AbstractC0410S1.C0415e();
                                                    break;
                                                case 11:
                                                    c0419i = new AbstractC0410S1.C0416f();
                                                    break;
                                                case '\f':
                                                    c0419i = new AbstractC0410S1.C0412b();
                                                    break;
                                                case '\r':
                                                    c0419i = new AbstractC0410S1.C0412b();
                                                    break;
                                                default:
                                                    c0419i = null;
                                                    break;
                                            }
                                            it = it22;
                                            c0413c = c0419i;
                                        }
                                        if (c0413c == null) {
                                            str55 = str14;
                                            str53 = str13;
                                            str51 = str10;
                                            str16 = str12;
                                            str17 = str31;
                                            str18 = str32;
                                            str19 = str11;
                                        } else {
                                            str55 = str14;
                                            str53 = str13;
                                            if ((c0413c.f1372e == 1) && Float.isNaN(f4)) {
                                                float[] fArr4 = new float[2];
                                                float f5 = 1.0f / 99;
                                                double d2 = ShadowDrawableWrapper.COS_45;
                                                float f6 = 0.0f;
                                                str51 = str10;
                                                str16 = str12;
                                                double d3 = 0.0d;
                                                int i28 = 0;
                                                while (i28 < 100) {
                                                    float f7 = i28 * f5;
                                                    String str56 = str31;
                                                    String str57 = str32;
                                                    double d4 = f7;
                                                    float f8 = f5;
                                                    C0191I1 c0191i1 = c0585z1.f2075d.f3663a;
                                                    Iterator<C0955b2> it23 = c0585z1.f2091t.iterator();
                                                    float f9 = Float.NaN;
                                                    float f10 = 0.0f;
                                                    C0191I1 c0191i12 = c0191i1;
                                                    while (it23.hasNext()) {
                                                        C0955b2 next12 = it23.next();
                                                        Iterator<C0955b2> it24 = it23;
                                                        C0191I1 c0191i13 = next12.f3663a;
                                                        if (c0191i13 != null) {
                                                            float f11 = next12.f3665c;
                                                            if (f11 < f7) {
                                                                f10 = f11;
                                                                c0191i12 = c0191i13;
                                                            } else if (Float.isNaN(f9)) {
                                                                f9 = next12.f3665c;
                                                            }
                                                        }
                                                        it23 = it24;
                                                    }
                                                    if (c0191i12 != null) {
                                                        if (Float.isNaN(f9)) {
                                                            f9 = 1.0f;
                                                        }
                                                        str20 = str11;
                                                        d = (((float) c0191i12.mo2393a((f7 - f10) / f)) * (f9 - f10)) + f10;
                                                    } else {
                                                        str20 = str11;
                                                        d = d4;
                                                    }
                                                    c0585z1.f2079h[0].mo2354c(d, c0585z1.f2085n);
                                                    c0585z1.f2075d.m1193c(c0585z1.f2084m, c0585z1.f2085n, fArr4, 0);
                                                    if (i28 > 0) {
                                                        str21 = str20;
                                                        f6 = (float) (Math.hypot(d2 - fArr4[1], d3 - fArr4[0]) + f6);
                                                    } else {
                                                        str21 = str20;
                                                    }
                                                    i28++;
                                                    f5 = f8;
                                                    d3 = fArr4[0];
                                                    d2 = fArr4[1];
                                                    str31 = str56;
                                                    str32 = str57;
                                                    str11 = str21;
                                                }
                                                str17 = str31;
                                                str18 = str32;
                                                str19 = str11;
                                                f4 = f6;
                                            } else {
                                                str51 = str10;
                                                str16 = str12;
                                                str17 = str31;
                                                str18 = str32;
                                                str19 = str11;
                                            }
                                            c0413c.f1370c = next11;
                                            c0585z1.f2096y.put(next11, c0413c);
                                        }
                                        it22 = it;
                                        str49 = str15;
                                        str50 = str9;
                                        obj36 = obj8;
                                        obj6 = obj7;
                                        str31 = str17;
                                        str32 = str18;
                                        str48 = str19;
                                        obj5 = obj9;
                                        str47 = str16;
                                    }
                                    Iterator<AbstractC0328O1> it25 = c0585z1.f2093v.iterator();
                                    while (it25.hasNext()) {
                                        AbstractC0328O1 next13 = it25.next();
                                        if (next13 instanceof C0391R1) {
                                            ((C0391R1) next13).m2055e(c0585z1.f2096y);
                                        }
                                    }
                                    for (AbstractC0410S1 abstractC0410S1 : c0585z1.f2096y.values()) {
                                        abstractC0410S1.m2042d(f4);
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder m253r = outline.m253r(" start: x: ");
        m253r.append(this.f2075d.f3667f);
        m253r.append(" y: ");
        m253r.append(this.f2075d.f3668g);
        m253r.append(" end: x: ");
        m253r.append(this.f2076e.f3667f);
        m253r.append(" y: ");
        m253r.append(this.f2076e.f3668g);
        return m253r.toString();
    }
}
