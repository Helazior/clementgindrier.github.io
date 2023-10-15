package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.p019v1.XmlPullParserException;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: T2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0445T2 {

    /* renamed from: d */
    public static final int[] f1451d = {0, 4, 8};

    /* renamed from: e */
    public static SparseIntArray f1452e;

    /* renamed from: a */
    public HashMap<String, C0393R2> f1453a = new HashMap<>();

    /* renamed from: b */
    public boolean f1454b = true;

    /* renamed from: c */
    public HashMap<Integer, C0446a> f1455c = new HashMap<>();

    /* renamed from: T2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0446a {

        /* renamed from: a */
        public int f1456a;

        /* renamed from: b */
        public final C0449d f1457b = new C0449d();

        /* renamed from: c */
        public final C0448c f1458c = new C0448c();

        /* renamed from: d */
        public final C0447b f1459d = new C0447b();

        /* renamed from: e */
        public final C0450e f1460e = new C0450e();

        /* renamed from: f */
        public HashMap<String, C0393R2> f1461f = new HashMap<>();

        /* renamed from: a */
        public void m2021a(ConstraintLayout.LayoutParams layoutParams) {
            C0447b c0447b = this.f1459d;
            layoutParams.f2872d = c0447b.f1503h;
            layoutParams.f2874e = c0447b.f1505i;
            layoutParams.f2876f = c0447b.f1507j;
            layoutParams.f2878g = c0447b.f1509k;
            layoutParams.f2880h = c0447b.f1510l;
            layoutParams.f2882i = c0447b.f1511m;
            layoutParams.f2884j = c0447b.f1512n;
            layoutParams.f2886k = c0447b.f1513o;
            layoutParams.f2888l = c0447b.f1514p;
            layoutParams.f2893p = c0447b.f1515q;
            layoutParams.f2894q = c0447b.f1516r;
            layoutParams.f2895r = c0447b.f1517s;
            layoutParams.f2896s = c0447b.f1518t;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = c0447b.f1466D;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = c0447b.f1467E;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = c0447b.f1468F;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = c0447b.f1469G;
            layoutParams.f2901x = c0447b.f1477O;
            layoutParams.f2902y = c0447b.f1476N;
            layoutParams.f2898u = c0447b.f1473K;
            layoutParams.f2900w = c0447b.f1475M;
            layoutParams.f2903z = c0447b.f1519u;
            layoutParams.f2840A = c0447b.f1520v;
            layoutParams.f2890m = c0447b.f1522x;
            layoutParams.f2891n = c0447b.f1523y;
            C0447b c0447b2 = this.f1459d;
            layoutParams.f2892o = c0447b2.f1524z;
            layoutParams.f2841B = c0447b2.f1521w;
            layoutParams.f2855P = c0447b2.f1463A;
            layoutParams.f2856Q = c0447b2.f1464B;
            layoutParams.f2844E = c0447b2.f1478P;
            layoutParams.f2843D = c0447b2.f1479Q;
            layoutParams.f2846G = c0447b2.f1481S;
            layoutParams.f2845F = c0447b2.f1480R;
            layoutParams.f2858S = c0447b2.f1504h0;
            layoutParams.f2859T = c0447b2.f1506i0;
            layoutParams.f2847H = c0447b2.f1482T;
            layoutParams.f2848I = c0447b2.f1483U;
            layoutParams.f2851L = c0447b2.f1484V;
            layoutParams.f2852M = c0447b2.f1485W;
            layoutParams.f2849J = c0447b2.f1486X;
            layoutParams.f2850K = c0447b2.f1487Y;
            layoutParams.f2853N = c0447b2.f1488Z;
            layoutParams.f2854O = c0447b2.f1490a0;
            layoutParams.f2857R = c0447b2.f1465C;
            layoutParams.f2870c = c0447b2.f1501g;
            layoutParams.f2866a = c0447b2.f1497e;
            layoutParams.f2868b = c0447b2.f1499f;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = c0447b2.f1493c;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = c0447b2.f1495d;
            String str = c0447b2.f1502g0;
            if (str != null) {
                layoutParams.f2860U = str;
            }
            layoutParams.setMarginStart(this.f1459d.f1471I);
            layoutParams.setMarginEnd(this.f1459d.f1470H);
            layoutParams.m1526a();
        }

        /* renamed from: b */
        public final void m2020b(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f1456a = i;
            C0447b c0447b = this.f1459d;
            c0447b.f1503h = layoutParams.f2872d;
            c0447b.f1505i = layoutParams.f2874e;
            c0447b.f1507j = layoutParams.f2876f;
            c0447b.f1509k = layoutParams.f2878g;
            c0447b.f1510l = layoutParams.f2880h;
            c0447b.f1511m = layoutParams.f2882i;
            c0447b.f1512n = layoutParams.f2884j;
            c0447b.f1513o = layoutParams.f2886k;
            c0447b.f1514p = layoutParams.f2888l;
            c0447b.f1515q = layoutParams.f2893p;
            c0447b.f1516r = layoutParams.f2894q;
            c0447b.f1517s = layoutParams.f2895r;
            c0447b.f1518t = layoutParams.f2896s;
            c0447b.f1519u = layoutParams.f2903z;
            c0447b.f1520v = layoutParams.f2840A;
            c0447b.f1521w = layoutParams.f2841B;
            c0447b.f1522x = layoutParams.f2890m;
            c0447b.f1523y = layoutParams.f2891n;
            c0447b.f1524z = layoutParams.f2892o;
            c0447b.f1463A = layoutParams.f2855P;
            c0447b.f1464B = layoutParams.f2856Q;
            c0447b.f1465C = layoutParams.f2857R;
            c0447b.f1501g = layoutParams.f2870c;
            c0447b.f1497e = layoutParams.f2866a;
            c0447b.f1499f = layoutParams.f2868b;
            C0447b c0447b2 = this.f1459d;
            c0447b2.f1493c = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            c0447b2.f1495d = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            c0447b2.f1466D = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            c0447b2.f1467E = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            c0447b2.f1468F = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            c0447b2.f1469G = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            c0447b2.f1478P = layoutParams.f2844E;
            c0447b2.f1479Q = layoutParams.f2843D;
            c0447b2.f1481S = layoutParams.f2846G;
            c0447b2.f1480R = layoutParams.f2845F;
            c0447b2.f1504h0 = layoutParams.f2858S;
            c0447b2.f1506i0 = layoutParams.f2859T;
            c0447b2.f1482T = layoutParams.f2847H;
            c0447b2.f1483U = layoutParams.f2848I;
            c0447b2.f1484V = layoutParams.f2851L;
            c0447b2.f1485W = layoutParams.f2852M;
            c0447b2.f1486X = layoutParams.f2849J;
            c0447b2.f1487Y = layoutParams.f2850K;
            c0447b2.f1488Z = layoutParams.f2853N;
            c0447b2.f1490a0 = layoutParams.f2854O;
            c0447b2.f1502g0 = layoutParams.f2860U;
            c0447b2.f1473K = layoutParams.f2898u;
            c0447b2.f1475M = layoutParams.f2900w;
            c0447b2.f1472J = layoutParams.f2897t;
            c0447b2.f1474L = layoutParams.f2899v;
            C0447b c0447b3 = this.f1459d;
            c0447b3.f1477O = layoutParams.f2901x;
            c0447b3.f1476N = layoutParams.f2902y;
            c0447b3.f1470H = layoutParams.getMarginEnd();
            this.f1459d.f1471I = layoutParams.getMarginStart();
        }

        /* renamed from: c */
        public final void m2019c(int i, Constraints.LayoutParams layoutParams) {
            m2020b(i, layoutParams);
            this.f1457b.f1536d = layoutParams.f2914m0;
            C0450e c0450e = this.f1460e;
            c0450e.f1540b = layoutParams.f2917p0;
            c0450e.f1541c = layoutParams.f2918q0;
            c0450e.f1542d = layoutParams.f2919r0;
            c0450e.f1543e = layoutParams.f2920s0;
            c0450e.f1544f = layoutParams.f2921t0;
            c0450e.f1545g = layoutParams.f2922u0;
            c0450e.f1546h = layoutParams.f2923v0;
            c0450e.f1547i = layoutParams.f2924w0;
            c0450e.f1548j = layoutParams.f2925x0;
            c0450e.f1549k = layoutParams.f2926y0;
            c0450e.f1551m = layoutParams.f2916o0;
            c0450e.f1550l = layoutParams.f2915n0;
        }

        public Object clone() {
            C0446a c0446a = new C0446a();
            c0446a.f1459d.m2018a(this.f1459d);
            c0446a.f1458c.m2016a(this.f1458c);
            c0446a.f1457b.m2014a(this.f1457b);
            c0446a.f1460e.m2012a(this.f1460e);
            c0446a.f1456a = this.f1456a;
            return c0446a;
        }
    }

    /* renamed from: T2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0447b {

        /* renamed from: k0 */
        public static SparseIntArray f1462k0;

        /* renamed from: c */
        public int f1493c;

        /* renamed from: d */
        public int f1495d;

        /* renamed from: e0 */
        public int[] f1498e0;

        /* renamed from: f0 */
        public String f1500f0;

        /* renamed from: g0 */
        public String f1502g0;

        /* renamed from: a */
        public boolean f1489a = false;

        /* renamed from: b */
        public boolean f1491b = false;

        /* renamed from: e */
        public int f1497e = -1;

        /* renamed from: f */
        public int f1499f = -1;

        /* renamed from: g */
        public float f1501g = -1.0f;

        /* renamed from: h */
        public int f1503h = -1;

        /* renamed from: i */
        public int f1505i = -1;

        /* renamed from: j */
        public int f1507j = -1;

        /* renamed from: k */
        public int f1509k = -1;

        /* renamed from: l */
        public int f1510l = -1;

        /* renamed from: m */
        public int f1511m = -1;

        /* renamed from: n */
        public int f1512n = -1;

        /* renamed from: o */
        public int f1513o = -1;

        /* renamed from: p */
        public int f1514p = -1;

        /* renamed from: q */
        public int f1515q = -1;

        /* renamed from: r */
        public int f1516r = -1;

        /* renamed from: s */
        public int f1517s = -1;

        /* renamed from: t */
        public int f1518t = -1;

        /* renamed from: u */
        public float f1519u = 0.5f;

        /* renamed from: v */
        public float f1520v = 0.5f;

        /* renamed from: w */
        public String f1521w = null;

        /* renamed from: x */
        public int f1522x = -1;

        /* renamed from: y */
        public int f1523y = 0;

        /* renamed from: z */
        public float f1524z = 0.0f;

        /* renamed from: A */
        public int f1463A = -1;

        /* renamed from: B */
        public int f1464B = -1;

        /* renamed from: C */
        public int f1465C = -1;

        /* renamed from: D */
        public int f1466D = -1;

        /* renamed from: E */
        public int f1467E = -1;

        /* renamed from: F */
        public int f1468F = -1;

        /* renamed from: G */
        public int f1469G = -1;

        /* renamed from: H */
        public int f1470H = -1;

        /* renamed from: I */
        public int f1471I = -1;

        /* renamed from: J */
        public int f1472J = -1;

        /* renamed from: K */
        public int f1473K = -1;

        /* renamed from: L */
        public int f1474L = -1;

        /* renamed from: M */
        public int f1475M = -1;

        /* renamed from: N */
        public int f1476N = -1;

        /* renamed from: O */
        public int f1477O = -1;

        /* renamed from: P */
        public float f1478P = -1.0f;

        /* renamed from: Q */
        public float f1479Q = -1.0f;

        /* renamed from: R */
        public int f1480R = 0;

        /* renamed from: S */
        public int f1481S = 0;

        /* renamed from: T */
        public int f1482T = 0;

        /* renamed from: U */
        public int f1483U = 0;

        /* renamed from: V */
        public int f1484V = -1;

        /* renamed from: W */
        public int f1485W = -1;

        /* renamed from: X */
        public int f1486X = -1;

        /* renamed from: Y */
        public int f1487Y = -1;

        /* renamed from: Z */
        public float f1488Z = 1.0f;

        /* renamed from: a0 */
        public float f1490a0 = 1.0f;

        /* renamed from: b0 */
        public int f1492b0 = -1;

        /* renamed from: c0 */
        public int f1494c0 = 0;

        /* renamed from: d0 */
        public int f1496d0 = -1;

        /* renamed from: h0 */
        public boolean f1504h0 = false;

        /* renamed from: i0 */
        public boolean f1506i0 = false;

        /* renamed from: j0 */
        public boolean f1508j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1462k0 = sparseIntArray;
            sparseIntArray.append(C0533W2.Layout_layout_constraintLeft_toLeftOf, 24);
            f1462k0.append(C0533W2.Layout_layout_constraintLeft_toRightOf, 25);
            f1462k0.append(C0533W2.Layout_layout_constraintRight_toLeftOf, 28);
            f1462k0.append(C0533W2.Layout_layout_constraintRight_toRightOf, 29);
            f1462k0.append(C0533W2.Layout_layout_constraintTop_toTopOf, 35);
            f1462k0.append(C0533W2.Layout_layout_constraintTop_toBottomOf, 34);
            f1462k0.append(C0533W2.Layout_layout_constraintBottom_toTopOf, 4);
            f1462k0.append(C0533W2.Layout_layout_constraintBottom_toBottomOf, 3);
            f1462k0.append(C0533W2.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f1462k0.append(C0533W2.Layout_layout_editor_absoluteX, 6);
            f1462k0.append(C0533W2.Layout_layout_editor_absoluteY, 7);
            f1462k0.append(C0533W2.Layout_layout_constraintGuide_begin, 17);
            f1462k0.append(C0533W2.Layout_layout_constraintGuide_end, 18);
            f1462k0.append(C0533W2.Layout_layout_constraintGuide_percent, 19);
            f1462k0.append(C0533W2.Layout_android_orientation, 26);
            f1462k0.append(C0533W2.Layout_layout_constraintStart_toEndOf, 31);
            f1462k0.append(C0533W2.Layout_layout_constraintStart_toStartOf, 32);
            f1462k0.append(C0533W2.Layout_layout_constraintEnd_toStartOf, 10);
            f1462k0.append(C0533W2.Layout_layout_constraintEnd_toEndOf, 9);
            f1462k0.append(C0533W2.Layout_layout_goneMarginLeft, 13);
            f1462k0.append(C0533W2.Layout_layout_goneMarginTop, 16);
            f1462k0.append(C0533W2.Layout_layout_goneMarginRight, 14);
            f1462k0.append(C0533W2.Layout_layout_goneMarginBottom, 11);
            f1462k0.append(C0533W2.Layout_layout_goneMarginStart, 15);
            f1462k0.append(C0533W2.Layout_layout_goneMarginEnd, 12);
            f1462k0.append(C0533W2.Layout_layout_constraintVertical_weight, 38);
            f1462k0.append(C0533W2.Layout_layout_constraintHorizontal_weight, 37);
            f1462k0.append(C0533W2.Layout_layout_constraintHorizontal_chainStyle, 39);
            f1462k0.append(C0533W2.Layout_layout_constraintVertical_chainStyle, 40);
            f1462k0.append(C0533W2.Layout_layout_constraintHorizontal_bias, 20);
            f1462k0.append(C0533W2.Layout_layout_constraintVertical_bias, 36);
            f1462k0.append(C0533W2.Layout_layout_constraintDimensionRatio, 5);
            f1462k0.append(C0533W2.Layout_layout_constraintLeft_creator, 76);
            f1462k0.append(C0533W2.Layout_layout_constraintTop_creator, 76);
            f1462k0.append(C0533W2.Layout_layout_constraintRight_creator, 76);
            f1462k0.append(C0533W2.Layout_layout_constraintBottom_creator, 76);
            f1462k0.append(C0533W2.Layout_layout_constraintBaseline_creator, 76);
            f1462k0.append(C0533W2.Layout_android_layout_marginLeft, 23);
            f1462k0.append(C0533W2.Layout_android_layout_marginRight, 27);
            f1462k0.append(C0533W2.Layout_android_layout_marginStart, 30);
            f1462k0.append(C0533W2.Layout_android_layout_marginEnd, 8);
            f1462k0.append(C0533W2.Layout_android_layout_marginTop, 33);
            f1462k0.append(C0533W2.Layout_android_layout_marginBottom, 2);
            f1462k0.append(C0533W2.Layout_android_layout_width, 22);
            f1462k0.append(C0533W2.Layout_android_layout_height, 21);
            f1462k0.append(C0533W2.Layout_layout_constraintCircle, 61);
            f1462k0.append(C0533W2.Layout_layout_constraintCircleRadius, 62);
            f1462k0.append(C0533W2.Layout_layout_constraintCircleAngle, 63);
            f1462k0.append(C0533W2.Layout_layout_constraintWidth_percent, 69);
            f1462k0.append(C0533W2.Layout_layout_constraintHeight_percent, 70);
            f1462k0.append(C0533W2.Layout_chainUseRtl, 71);
            f1462k0.append(C0533W2.Layout_barrierDirection, 72);
            f1462k0.append(C0533W2.Layout_barrierMargin, 73);
            f1462k0.append(C0533W2.Layout_constraint_referenced_ids, 74);
            f1462k0.append(C0533W2.Layout_barrierAllowsGoneWidgets, 75);
        }

        /* renamed from: a */
        public void m2018a(C0447b c0447b) {
            this.f1489a = c0447b.f1489a;
            this.f1493c = c0447b.f1493c;
            this.f1491b = c0447b.f1491b;
            this.f1495d = c0447b.f1495d;
            this.f1497e = c0447b.f1497e;
            this.f1499f = c0447b.f1499f;
            this.f1501g = c0447b.f1501g;
            this.f1503h = c0447b.f1503h;
            this.f1505i = c0447b.f1505i;
            this.f1507j = c0447b.f1507j;
            this.f1509k = c0447b.f1509k;
            this.f1510l = c0447b.f1510l;
            this.f1511m = c0447b.f1511m;
            this.f1512n = c0447b.f1512n;
            this.f1513o = c0447b.f1513o;
            this.f1514p = c0447b.f1514p;
            this.f1515q = c0447b.f1515q;
            this.f1516r = c0447b.f1516r;
            this.f1517s = c0447b.f1517s;
            this.f1518t = c0447b.f1518t;
            this.f1519u = c0447b.f1519u;
            this.f1520v = c0447b.f1520v;
            this.f1521w = c0447b.f1521w;
            this.f1522x = c0447b.f1522x;
            this.f1523y = c0447b.f1523y;
            this.f1524z = c0447b.f1524z;
            this.f1463A = c0447b.f1463A;
            this.f1464B = c0447b.f1464B;
            this.f1465C = c0447b.f1465C;
            this.f1466D = c0447b.f1466D;
            this.f1467E = c0447b.f1467E;
            this.f1468F = c0447b.f1468F;
            this.f1469G = c0447b.f1469G;
            this.f1470H = c0447b.f1470H;
            this.f1471I = c0447b.f1471I;
            this.f1472J = c0447b.f1472J;
            this.f1473K = c0447b.f1473K;
            this.f1474L = c0447b.f1474L;
            this.f1475M = c0447b.f1475M;
            this.f1476N = c0447b.f1476N;
            this.f1477O = c0447b.f1477O;
            this.f1478P = c0447b.f1478P;
            this.f1479Q = c0447b.f1479Q;
            this.f1480R = c0447b.f1480R;
            this.f1481S = c0447b.f1481S;
            this.f1482T = c0447b.f1482T;
            this.f1483U = c0447b.f1483U;
            this.f1484V = c0447b.f1484V;
            this.f1485W = c0447b.f1485W;
            this.f1486X = c0447b.f1486X;
            this.f1487Y = c0447b.f1487Y;
            this.f1488Z = c0447b.f1488Z;
            this.f1490a0 = c0447b.f1490a0;
            this.f1492b0 = c0447b.f1492b0;
            this.f1494c0 = c0447b.f1494c0;
            this.f1496d0 = c0447b.f1496d0;
            this.f1502g0 = c0447b.f1502g0;
            int[] iArr = c0447b.f1498e0;
            if (iArr != null) {
                this.f1498e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f1498e0 = null;
            }
            this.f1500f0 = c0447b.f1500f0;
            this.f1504h0 = c0447b.f1504h0;
            this.f1506i0 = c0447b.f1506i0;
            this.f1508j0 = c0447b.f1508j0;
        }

        /* renamed from: b */
        public void m2017b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.Layout);
            this.f1491b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = f1462k0.get(index);
                if (i2 == 80) {
                    this.f1504h0 = obtainStyledAttributes.getBoolean(index, this.f1504h0);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            int i3 = this.f1514p;
                            int[] iArr = C0445T2.f1451d;
                            int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1514p = resourceId;
                            continue;
                        case 2:
                            this.f1469G = obtainStyledAttributes.getDimensionPixelSize(index, this.f1469G);
                            continue;
                        case 3:
                            int i4 = this.f1513o;
                            int[] iArr2 = C0445T2.f1451d;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i4);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1513o = resourceId2;
                            continue;
                        case 4:
                            int i5 = this.f1512n;
                            int[] iArr3 = C0445T2.f1451d;
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId3 == -1) {
                                resourceId3 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1512n = resourceId3;
                            continue;
                        case 5:
                            this.f1521w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.f1463A = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1463A);
                            continue;
                        case 7:
                            this.f1464B = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1464B);
                            continue;
                        case 8:
                            this.f1470H = obtainStyledAttributes.getDimensionPixelSize(index, this.f1470H);
                            continue;
                        case 9:
                            int i6 = this.f1518t;
                            int[] iArr4 = C0445T2.f1451d;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i6);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1518t = resourceId4;
                            continue;
                        case 10:
                            int i7 = this.f1517s;
                            int[] iArr5 = C0445T2.f1451d;
                            int resourceId5 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId5 == -1) {
                                resourceId5 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1517s = resourceId5;
                            continue;
                        case 11:
                            this.f1475M = obtainStyledAttributes.getDimensionPixelSize(index, this.f1475M);
                            continue;
                        case 12:
                            this.f1476N = obtainStyledAttributes.getDimensionPixelSize(index, this.f1476N);
                            continue;
                        case 13:
                            this.f1472J = obtainStyledAttributes.getDimensionPixelSize(index, this.f1472J);
                            continue;
                        case 14:
                            this.f1474L = obtainStyledAttributes.getDimensionPixelSize(index, this.f1474L);
                            continue;
                        case 15:
                            this.f1477O = obtainStyledAttributes.getDimensionPixelSize(index, this.f1477O);
                            continue;
                        case 16:
                            this.f1473K = obtainStyledAttributes.getDimensionPixelSize(index, this.f1473K);
                            continue;
                        case 17:
                            this.f1497e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1497e);
                            continue;
                        case 18:
                            this.f1499f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1499f);
                            continue;
                        case 19:
                            this.f1501g = obtainStyledAttributes.getFloat(index, this.f1501g);
                            continue;
                        case 20:
                            this.f1519u = obtainStyledAttributes.getFloat(index, this.f1519u);
                            continue;
                        case 21:
                            this.f1495d = obtainStyledAttributes.getLayoutDimension(index, this.f1495d);
                            continue;
                        case 22:
                            this.f1493c = obtainStyledAttributes.getLayoutDimension(index, this.f1493c);
                            continue;
                        case 23:
                            this.f1466D = obtainStyledAttributes.getDimensionPixelSize(index, this.f1466D);
                            continue;
                        case 24:
                            int i8 = this.f1503h;
                            int[] iArr6 = C0445T2.f1451d;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i8);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1503h = resourceId6;
                            continue;
                        case 25:
                            int i9 = this.f1505i;
                            int[] iArr7 = C0445T2.f1451d;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1505i = resourceId7;
                            continue;
                        case 26:
                            this.f1465C = obtainStyledAttributes.getInt(index, this.f1465C);
                            continue;
                        case 27:
                            this.f1467E = obtainStyledAttributes.getDimensionPixelSize(index, this.f1467E);
                            continue;
                        case 28:
                            int i10 = this.f1507j;
                            int[] iArr8 = C0445T2.f1451d;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i10);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1507j = resourceId8;
                            continue;
                        case 29:
                            int i11 = this.f1509k;
                            int[] iArr9 = C0445T2.f1451d;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1509k = resourceId9;
                            continue;
                        case 30:
                            this.f1471I = obtainStyledAttributes.getDimensionPixelSize(index, this.f1471I);
                            continue;
                        case 31:
                            int i12 = this.f1515q;
                            int[] iArr10 = C0445T2.f1451d;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i12);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1515q = resourceId10;
                            continue;
                        case 32:
                            int i13 = this.f1516r;
                            int[] iArr11 = C0445T2.f1451d;
                            int resourceId11 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId11 == -1) {
                                resourceId11 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1516r = resourceId11;
                            continue;
                        case 33:
                            this.f1468F = obtainStyledAttributes.getDimensionPixelSize(index, this.f1468F);
                            continue;
                        case 34:
                            int i14 = this.f1511m;
                            int[] iArr12 = C0445T2.f1451d;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i14);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1511m = resourceId12;
                            continue;
                        case 35:
                            int i15 = this.f1510l;
                            int[] iArr13 = C0445T2.f1451d;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.f1510l = resourceId13;
                            continue;
                        case 36:
                            this.f1520v = obtainStyledAttributes.getFloat(index, this.f1520v);
                            continue;
                        case 37:
                            this.f1479Q = obtainStyledAttributes.getFloat(index, this.f1479Q);
                            continue;
                        case 38:
                            this.f1478P = obtainStyledAttributes.getFloat(index, this.f1478P);
                            continue;
                        case 39:
                            this.f1480R = obtainStyledAttributes.getInt(index, this.f1480R);
                            continue;
                        case 40:
                            this.f1481S = obtainStyledAttributes.getInt(index, this.f1481S);
                            continue;
                        default:
                            switch (i2) {
                                case 54:
                                    this.f1482T = obtainStyledAttributes.getInt(index, this.f1482T);
                                    continue;
                                case 55:
                                    this.f1483U = obtainStyledAttributes.getInt(index, this.f1483U);
                                    continue;
                                case 56:
                                    this.f1484V = obtainStyledAttributes.getDimensionPixelSize(index, this.f1484V);
                                    continue;
                                case 57:
                                    this.f1485W = obtainStyledAttributes.getDimensionPixelSize(index, this.f1485W);
                                    continue;
                                case 58:
                                    this.f1486X = obtainStyledAttributes.getDimensionPixelSize(index, this.f1486X);
                                    continue;
                                case 59:
                                    this.f1487Y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1487Y);
                                    continue;
                                default:
                                    switch (i2) {
                                        case 61:
                                            int i16 = this.f1522x;
                                            int[] iArr14 = C0445T2.f1451d;
                                            int resourceId14 = obtainStyledAttributes.getResourceId(index, i16);
                                            if (resourceId14 == -1) {
                                                resourceId14 = obtainStyledAttributes.getInt(index, -1);
                                            }
                                            this.f1522x = resourceId14;
                                            continue;
                                        case 62:
                                            this.f1523y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1523y);
                                            continue;
                                        case 63:
                                            this.f1524z = obtainStyledAttributes.getFloat(index, this.f1524z);
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.f1488Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.f1490a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.f1492b0 = obtainStyledAttributes.getInt(index, this.f1492b0);
                                                    continue;
                                                case 73:
                                                    this.f1494c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1494c0);
                                                    continue;
                                                case 74:
                                                    this.f1500f0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.f1508j0 = obtainStyledAttributes.getBoolean(index, this.f1508j0);
                                                    continue;
                                                case 76:
                                                    StringBuilder m253r = outline.m253r("unused attribute 0x");
                                                    m253r.append(Integer.toHexString(index));
                                                    m253r.append("   ");
                                                    m253r.append(f1462k0.get(index));
                                                    Log.w("ConstraintSet", m253r.toString());
                                                    continue;
                                                case 77:
                                                    this.f1502g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    StringBuilder m253r2 = outline.m253r("Unknown attribute 0x");
                                                    m253r2.append(Integer.toHexString(index));
                                                    m253r2.append("   ");
                                                    m253r2.append(f1462k0.get(index));
                                                    Log.w("ConstraintSet", m253r2.toString());
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.f1506i0 = obtainStyledAttributes.getBoolean(index, this.f1506i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: T2$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0448c {

        /* renamed from: h */
        public static SparseIntArray f1525h;

        /* renamed from: a */
        public boolean f1526a = false;

        /* renamed from: b */
        public int f1527b = -1;

        /* renamed from: c */
        public String f1528c = null;

        /* renamed from: d */
        public int f1529d = -1;

        /* renamed from: e */
        public int f1530e = 0;

        /* renamed from: f */
        public float f1531f = Float.NaN;

        /* renamed from: g */
        public float f1532g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1525h = sparseIntArray;
            sparseIntArray.append(C0533W2.Motion_motionPathRotate, 1);
            f1525h.append(C0533W2.Motion_pathMotionArc, 2);
            f1525h.append(C0533W2.Motion_transitionEasing, 3);
            f1525h.append(C0533W2.Motion_drawPath, 4);
            f1525h.append(C0533W2.Motion_animate_relativeTo, 5);
            f1525h.append(C0533W2.Motion_motionStagger, 6);
        }

        /* renamed from: a */
        public void m2016a(C0448c c0448c) {
            this.f1526a = c0448c.f1526a;
            this.f1527b = c0448c.f1527b;
            this.f1528c = c0448c.f1528c;
            this.f1529d = c0448c.f1529d;
            this.f1530e = c0448c.f1530e;
            this.f1532g = c0448c.f1532g;
            this.f1531f = c0448c.f1531f;
        }

        /* renamed from: b */
        public void m2015b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.Motion);
            this.f1526a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f1525h.get(index)) {
                    case 1:
                        this.f1532g = obtainStyledAttributes.getFloat(index, this.f1532g);
                        break;
                    case 2:
                        this.f1529d = obtainStyledAttributes.getInt(index, this.f1529d);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f1528c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f1528c = C0191I1.f625c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f1530e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i2 = this.f1527b;
                        int[] iArr = C0445T2.f1451d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i2);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.f1527b = resourceId;
                        break;
                    case 6:
                        this.f1531f = obtainStyledAttributes.getFloat(index, this.f1531f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: T2$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0449d {

        /* renamed from: a */
        public boolean f1533a = false;

        /* renamed from: b */
        public int f1534b = 0;

        /* renamed from: c */
        public int f1535c = 0;

        /* renamed from: d */
        public float f1536d = 1.0f;

        /* renamed from: e */
        public float f1537e = Float.NaN;

        /* renamed from: a */
        public void m2014a(C0449d c0449d) {
            this.f1533a = c0449d.f1533a;
            this.f1534b = c0449d.f1534b;
            this.f1536d = c0449d.f1536d;
            this.f1537e = c0449d.f1537e;
            this.f1535c = c0449d.f1535c;
        }

        /* renamed from: b */
        public void m2013b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.PropertySet);
            this.f1533a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.PropertySet_android_alpha) {
                    this.f1536d = obtainStyledAttributes.getFloat(index, this.f1536d);
                } else if (index == C0533W2.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.f1534b);
                    this.f1534b = i2;
                    int[] iArr = C0445T2.f1451d;
                    this.f1534b = C0445T2.f1451d[i2];
                } else if (index == C0533W2.PropertySet_visibilityMode) {
                    this.f1535c = obtainStyledAttributes.getInt(index, this.f1535c);
                } else if (index == C0533W2.PropertySet_motionProgress) {
                    this.f1537e = obtainStyledAttributes.getFloat(index, this.f1537e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: T2$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0450e {

        /* renamed from: n */
        public static SparseIntArray f1538n;

        /* renamed from: a */
        public boolean f1539a = false;

        /* renamed from: b */
        public float f1540b = 0.0f;

        /* renamed from: c */
        public float f1541c = 0.0f;

        /* renamed from: d */
        public float f1542d = 0.0f;

        /* renamed from: e */
        public float f1543e = 1.0f;

        /* renamed from: f */
        public float f1544f = 1.0f;

        /* renamed from: g */
        public float f1545g = Float.NaN;

        /* renamed from: h */
        public float f1546h = Float.NaN;

        /* renamed from: i */
        public float f1547i = 0.0f;

        /* renamed from: j */
        public float f1548j = 0.0f;

        /* renamed from: k */
        public float f1549k = 0.0f;

        /* renamed from: l */
        public boolean f1550l = false;

        /* renamed from: m */
        public float f1551m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1538n = sparseIntArray;
            sparseIntArray.append(C0533W2.Transform_android_rotation, 1);
            f1538n.append(C0533W2.Transform_android_rotationX, 2);
            f1538n.append(C0533W2.Transform_android_rotationY, 3);
            f1538n.append(C0533W2.Transform_android_scaleX, 4);
            f1538n.append(C0533W2.Transform_android_scaleY, 5);
            f1538n.append(C0533W2.Transform_android_transformPivotX, 6);
            f1538n.append(C0533W2.Transform_android_transformPivotY, 7);
            f1538n.append(C0533W2.Transform_android_translationX, 8);
            f1538n.append(C0533W2.Transform_android_translationY, 9);
            f1538n.append(C0533W2.Transform_android_translationZ, 10);
            f1538n.append(C0533W2.Transform_android_elevation, 11);
        }

        /* renamed from: a */
        public void m2012a(C0450e c0450e) {
            this.f1539a = c0450e.f1539a;
            this.f1540b = c0450e.f1540b;
            this.f1541c = c0450e.f1541c;
            this.f1542d = c0450e.f1542d;
            this.f1543e = c0450e.f1543e;
            this.f1544f = c0450e.f1544f;
            this.f1545g = c0450e.f1545g;
            this.f1546h = c0450e.f1546h;
            this.f1547i = c0450e.f1547i;
            this.f1548j = c0450e.f1548j;
            this.f1549k = c0450e.f1549k;
            this.f1550l = c0450e.f1550l;
            this.f1551m = c0450e.f1551m;
        }

        /* renamed from: b */
        public void m2011b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.Transform);
            this.f1539a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f1538n.get(index)) {
                    case 1:
                        this.f1540b = obtainStyledAttributes.getFloat(index, this.f1540b);
                        break;
                    case 2:
                        this.f1541c = obtainStyledAttributes.getFloat(index, this.f1541c);
                        break;
                    case 3:
                        this.f1542d = obtainStyledAttributes.getFloat(index, this.f1542d);
                        break;
                    case 4:
                        this.f1543e = obtainStyledAttributes.getFloat(index, this.f1543e);
                        break;
                    case 5:
                        this.f1544f = obtainStyledAttributes.getFloat(index, this.f1544f);
                        break;
                    case 6:
                        this.f1545g = obtainStyledAttributes.getDimension(index, this.f1545g);
                        break;
                    case 7:
                        this.f1546h = obtainStyledAttributes.getDimension(index, this.f1546h);
                        break;
                    case 8:
                        this.f1547i = obtainStyledAttributes.getDimension(index, this.f1547i);
                        break;
                    case 9:
                        this.f1548j = obtainStyledAttributes.getDimension(index, this.f1548j);
                        break;
                    case 10:
                        this.f1549k = obtainStyledAttributes.getDimension(index, this.f1549k);
                        break;
                    case 11:
                        this.f1550l = true;
                        this.f1551m = obtainStyledAttributes.getDimension(index, this.f1551m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1452e = sparseIntArray;
        sparseIntArray.append(C0533W2.Constraint_layout_constraintLeft_toLeftOf, 25);
        f1452e.append(C0533W2.Constraint_layout_constraintLeft_toRightOf, 26);
        f1452e.append(C0533W2.Constraint_layout_constraintRight_toLeftOf, 29);
        f1452e.append(C0533W2.Constraint_layout_constraintRight_toRightOf, 30);
        f1452e.append(C0533W2.Constraint_layout_constraintTop_toTopOf, 36);
        f1452e.append(C0533W2.Constraint_layout_constraintTop_toBottomOf, 35);
        f1452e.append(C0533W2.Constraint_layout_constraintBottom_toTopOf, 4);
        f1452e.append(C0533W2.Constraint_layout_constraintBottom_toBottomOf, 3);
        f1452e.append(C0533W2.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f1452e.append(C0533W2.Constraint_layout_editor_absoluteX, 6);
        f1452e.append(C0533W2.Constraint_layout_editor_absoluteY, 7);
        f1452e.append(C0533W2.Constraint_layout_constraintGuide_begin, 17);
        f1452e.append(C0533W2.Constraint_layout_constraintGuide_end, 18);
        f1452e.append(C0533W2.Constraint_layout_constraintGuide_percent, 19);
        f1452e.append(C0533W2.Constraint_android_orientation, 27);
        f1452e.append(C0533W2.Constraint_layout_constraintStart_toEndOf, 32);
        f1452e.append(C0533W2.Constraint_layout_constraintStart_toStartOf, 33);
        f1452e.append(C0533W2.Constraint_layout_constraintEnd_toStartOf, 10);
        f1452e.append(C0533W2.Constraint_layout_constraintEnd_toEndOf, 9);
        f1452e.append(C0533W2.Constraint_layout_goneMarginLeft, 13);
        f1452e.append(C0533W2.Constraint_layout_goneMarginTop, 16);
        f1452e.append(C0533W2.Constraint_layout_goneMarginRight, 14);
        f1452e.append(C0533W2.Constraint_layout_goneMarginBottom, 11);
        f1452e.append(C0533W2.Constraint_layout_goneMarginStart, 15);
        f1452e.append(C0533W2.Constraint_layout_goneMarginEnd, 12);
        f1452e.append(C0533W2.Constraint_layout_constraintVertical_weight, 40);
        f1452e.append(C0533W2.Constraint_layout_constraintHorizontal_weight, 39);
        f1452e.append(C0533W2.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f1452e.append(C0533W2.Constraint_layout_constraintVertical_chainStyle, 42);
        f1452e.append(C0533W2.Constraint_layout_constraintHorizontal_bias, 20);
        f1452e.append(C0533W2.Constraint_layout_constraintVertical_bias, 37);
        f1452e.append(C0533W2.Constraint_layout_constraintDimensionRatio, 5);
        f1452e.append(C0533W2.Constraint_layout_constraintLeft_creator, 82);
        f1452e.append(C0533W2.Constraint_layout_constraintTop_creator, 82);
        f1452e.append(C0533W2.Constraint_layout_constraintRight_creator, 82);
        f1452e.append(C0533W2.Constraint_layout_constraintBottom_creator, 82);
        f1452e.append(C0533W2.Constraint_layout_constraintBaseline_creator, 82);
        f1452e.append(C0533W2.Constraint_android_layout_marginLeft, 24);
        f1452e.append(C0533W2.Constraint_android_layout_marginRight, 28);
        f1452e.append(C0533W2.Constraint_android_layout_marginStart, 31);
        f1452e.append(C0533W2.Constraint_android_layout_marginEnd, 8);
        f1452e.append(C0533W2.Constraint_android_layout_marginTop, 34);
        f1452e.append(C0533W2.Constraint_android_layout_marginBottom, 2);
        f1452e.append(C0533W2.Constraint_android_layout_width, 23);
        f1452e.append(C0533W2.Constraint_android_layout_height, 21);
        f1452e.append(C0533W2.Constraint_android_visibility, 22);
        f1452e.append(C0533W2.Constraint_android_alpha, 43);
        f1452e.append(C0533W2.Constraint_android_elevation, 44);
        f1452e.append(C0533W2.Constraint_android_rotationX, 45);
        f1452e.append(C0533W2.Constraint_android_rotationY, 46);
        f1452e.append(C0533W2.Constraint_android_rotation, 60);
        f1452e.append(C0533W2.Constraint_android_scaleX, 47);
        f1452e.append(C0533W2.Constraint_android_scaleY, 48);
        f1452e.append(C0533W2.Constraint_android_transformPivotX, 49);
        f1452e.append(C0533W2.Constraint_android_transformPivotY, 50);
        f1452e.append(C0533W2.Constraint_android_translationX, 51);
        f1452e.append(C0533W2.Constraint_android_translationY, 52);
        f1452e.append(C0533W2.Constraint_android_translationZ, 53);
        f1452e.append(C0533W2.Constraint_layout_constraintWidth_default, 54);
        f1452e.append(C0533W2.Constraint_layout_constraintHeight_default, 55);
        f1452e.append(C0533W2.Constraint_layout_constraintWidth_max, 56);
        f1452e.append(C0533W2.Constraint_layout_constraintHeight_max, 57);
        f1452e.append(C0533W2.Constraint_layout_constraintWidth_min, 58);
        f1452e.append(C0533W2.Constraint_layout_constraintHeight_min, 59);
        f1452e.append(C0533W2.Constraint_layout_constraintCircle, 61);
        f1452e.append(C0533W2.Constraint_layout_constraintCircleRadius, 62);
        f1452e.append(C0533W2.Constraint_layout_constraintCircleAngle, 63);
        f1452e.append(C0533W2.Constraint_animate_relativeTo, 64);
        f1452e.append(C0533W2.Constraint_transitionEasing, 65);
        f1452e.append(C0533W2.Constraint_drawPath, 66);
        f1452e.append(C0533W2.Constraint_transitionPathRotate, 67);
        f1452e.append(C0533W2.Constraint_motionStagger, 79);
        f1452e.append(C0533W2.Constraint_android_id, 38);
        f1452e.append(C0533W2.Constraint_motionProgress, 68);
        f1452e.append(C0533W2.Constraint_layout_constraintWidth_percent, 69);
        f1452e.append(C0533W2.Constraint_layout_constraintHeight_percent, 70);
        f1452e.append(C0533W2.Constraint_chainUseRtl, 71);
        f1452e.append(C0533W2.Constraint_barrierDirection, 72);
        f1452e.append(C0533W2.Constraint_barrierMargin, 73);
        f1452e.append(C0533W2.Constraint_constraint_referenced_ids, 74);
        f1452e.append(C0533W2.Constraint_barrierAllowsGoneWidgets, 75);
        f1452e.append(C0533W2.Constraint_pathMotionArc, 76);
        f1452e.append(C0533W2.Constraint_layout_constraintTag, 77);
        f1452e.append(C0533W2.Constraint_visibilityMode, 78);
        f1452e.append(C0533W2.Constraint_layout_constrainedWidth, 80);
        f1452e.append(C0533W2.Constraint_layout_constrainedHeight, 81);
    }

    /* renamed from: a */
    public void m2032a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.f1455c.containsKey(Integer.valueOf(id))) {
                StringBuilder m253r = outline.m253r("id unknown ");
                m253r.append(LayoutInflater$Factory2C0000A.C0010h.m2673E(childAt));
                Log.v("ConstraintSet", m253r.toString());
            } else if (this.f1454b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (this.f1455c.containsKey(Integer.valueOf(id))) {
                    C0393R2.m2049f(childAt, this.f1455c.get(Integer.valueOf(id)).f1461f);
                }
            }
        }
    }

    /* renamed from: b */
    public void m2031b(ConstraintLayout constraintLayout) {
        m2030c(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* renamed from: c */
    public void m2030c(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1455c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.f1455c.containsKey(Integer.valueOf(id))) {
                StringBuilder m253r = outline.m253r("id unknown ");
                m253r.append(LayoutInflater$Factory2C0000A.C0010h.m2673E(childAt));
                Log.w("ConstraintSet", m253r.toString());
            } else if (this.f1454b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.f1455c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        C0446a c0446a = this.f1455c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            c0446a.f1459d.f1496d0 = 1;
                        }
                        int i2 = c0446a.f1459d.f1496d0;
                        if (i2 != -1 && i2 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(c0446a.f1459d.f1492b0);
                            barrier.setMargin(c0446a.f1459d.f1494c0);
                            barrier.setAllowsGoneWidget(c0446a.f1459d.f1508j0);
                            C0447b c0447b = c0446a.f1459d;
                            int[] iArr = c0447b.f1498e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = c0447b.f1500f0;
                                if (str != null) {
                                    c0447b.f1498e0 = m2027f(barrier, str);
                                    barrier.setReferencedIds(c0446a.f1459d.f1498e0);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.m1526a();
                        c0446a.m2021a(layoutParams);
                        if (z) {
                            C0393R2.m2049f(childAt, c0446a.f1461f);
                        }
                        childAt.setLayoutParams(layoutParams);
                        C0449d c0449d = c0446a.f1457b;
                        if (c0449d.f1535c == 0) {
                            childAt.setVisibility(c0449d.f1534b);
                        }
                        childAt.setAlpha(c0446a.f1457b.f1536d);
                        childAt.setRotation(c0446a.f1460e.f1540b);
                        childAt.setRotationX(c0446a.f1460e.f1541c);
                        childAt.setRotationY(c0446a.f1460e.f1542d);
                        childAt.setScaleX(c0446a.f1460e.f1543e);
                        childAt.setScaleY(c0446a.f1460e.f1544f);
                        if (!Float.isNaN(c0446a.f1460e.f1545g)) {
                            childAt.setPivotX(c0446a.f1460e.f1545g);
                        }
                        if (!Float.isNaN(c0446a.f1460e.f1546h)) {
                            childAt.setPivotY(c0446a.f1460e.f1546h);
                        }
                        childAt.setTranslationX(c0446a.f1460e.f1547i);
                        childAt.setTranslationY(c0446a.f1460e.f1548j);
                        childAt.setTranslationZ(c0446a.f1460e.f1549k);
                        C0450e c0450e = c0446a.f1460e;
                        if (c0450e.f1550l) {
                            childAt.setElevation(c0450e.f1551m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0446a c0446a2 = this.f1455c.get(num);
            int i3 = c0446a2.f1459d.f1496d0;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                C0447b c0447b2 = c0446a2.f1459d;
                int[] iArr2 = c0447b2.f1498e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = c0447b2.f1500f0;
                    if (str2 != null) {
                        c0447b2.f1498e0 = m2027f(barrier2, str2);
                        barrier2.setReferencedIds(c0446a2.f1459d.f1498e0);
                    }
                }
                barrier2.setType(c0446a2.f1459d.f1492b0);
                barrier2.setMargin(c0446a2.f1459d.f1494c0);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.m1527t();
                c0446a2.m2021a(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (c0446a2.f1459d.f1489a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                c0446a2.m2021a(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    /* renamed from: d */
    public void m2029d(ConstraintLayout constraintLayout) {
        C0445T2 c0445t2 = this;
        int childCount = constraintLayout.getChildCount();
        c0445t2.f1455c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (c0445t2.f1454b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!c0445t2.f1455c.containsKey(Integer.valueOf(id))) {
                c0445t2.f1455c.put(Integer.valueOf(id), new C0446a());
            }
            C0446a c0446a = c0445t2.f1455c.get(Integer.valueOf(id));
            HashMap<String, C0393R2> hashMap = c0445t2.f1453a;
            HashMap<String, C0393R2> hashMap2 = new HashMap<>();
            Class<?> cls = childAt.getClass();
            for (String str : hashMap.keySet()) {
                C0393R2 c0393r2 = hashMap.get(str);
                try {
                } catch (IllegalAccessException e) {
                    e = e;
                } catch (NoSuchMethodException e2) {
                    e = e2;
                } catch (InvocationTargetException e3) {
                    e = e3;
                }
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new C0393R2(c0393r2, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                } else {
                    try {
                        hashMap2.put(str, new C0393R2(c0393r2, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        e.printStackTrace();
                    } catch (NoSuchMethodException e5) {
                        e = e5;
                        e.printStackTrace();
                    } catch (InvocationTargetException e6) {
                        e = e6;
                        e.printStackTrace();
                    }
                }
            }
            c0446a.f1461f = hashMap2;
            c0446a.m2020b(id, layoutParams);
            c0446a.f1457b.f1534b = childAt.getVisibility();
            c0446a.f1457b.f1536d = childAt.getAlpha();
            c0446a.f1460e.f1540b = childAt.getRotation();
            c0446a.f1460e.f1541c = childAt.getRotationX();
            c0446a.f1460e.f1542d = childAt.getRotationY();
            c0446a.f1460e.f1543e = childAt.getScaleX();
            c0446a.f1460e.f1544f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != ShadowDrawableWrapper.COS_45 || pivotY != ShadowDrawableWrapper.COS_45) {
                C0450e c0450e = c0446a.f1460e;
                c0450e.f1545g = pivotX;
                c0450e.f1546h = pivotY;
            }
            c0446a.f1460e.f1547i = childAt.getTranslationX();
            c0446a.f1460e.f1548j = childAt.getTranslationY();
            c0446a.f1460e.f1549k = childAt.getTranslationZ();
            C0450e c0450e2 = c0446a.f1460e;
            if (c0450e2.f1550l) {
                c0450e2.f1551m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                C0447b c0447b = c0446a.f1459d;
                c0447b.f1508j0 = barrier.f2832k.f6258L0;
                c0447b.f1498e0 = barrier.m1535j();
                C0447b c0447b2 = c0446a.f1459d;
                c0447b2.f1492b0 = barrier.f2830i;
                c0447b2.f1494c0 = barrier.f2832k.f6259M0;
            }
            i++;
            c0445t2 = this;
        }
    }

    /* renamed from: e */
    public void m2028e(int i, int i2, int i3, int i4) {
        if (!this.f1455c.containsKey(Integer.valueOf(i))) {
            this.f1455c.put(Integer.valueOf(i), new C0446a());
        }
        C0446a c0446a = this.f1455c.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    C0447b c0447b = c0446a.f1459d;
                    c0447b.f1503h = i3;
                    c0447b.f1505i = -1;
                    return;
                } else if (i4 == 2) {
                    C0447b c0447b2 = c0446a.f1459d;
                    c0447b2.f1505i = i3;
                    c0447b2.f1503h = -1;
                    return;
                } else {
                    StringBuilder m253r = outline.m253r("left to ");
                    m253r.append(m2022k(i4));
                    m253r.append(" undefined");
                    throw new IllegalArgumentException(m253r.toString());
                }
            case 2:
                if (i4 == 1) {
                    C0447b c0447b3 = c0446a.f1459d;
                    c0447b3.f1507j = i3;
                    c0447b3.f1509k = -1;
                    return;
                } else if (i4 == 2) {
                    C0447b c0447b4 = c0446a.f1459d;
                    c0447b4.f1509k = i3;
                    c0447b4.f1507j = -1;
                    return;
                } else {
                    StringBuilder m253r2 = outline.m253r("right to ");
                    m253r2.append(m2022k(i4));
                    m253r2.append(" undefined");
                    throw new IllegalArgumentException(m253r2.toString());
                }
            case 3:
                if (i4 == 3) {
                    C0447b c0447b5 = c0446a.f1459d;
                    c0447b5.f1510l = i3;
                    c0447b5.f1511m = -1;
                    c0447b5.f1514p = -1;
                    return;
                } else if (i4 == 4) {
                    C0447b c0447b6 = c0446a.f1459d;
                    c0447b6.f1511m = i3;
                    c0447b6.f1510l = -1;
                    c0447b6.f1514p = -1;
                    return;
                } else {
                    StringBuilder m253r3 = outline.m253r("right to ");
                    m253r3.append(m2022k(i4));
                    m253r3.append(" undefined");
                    throw new IllegalArgumentException(m253r3.toString());
                }
            case 4:
                if (i4 == 4) {
                    C0447b c0447b7 = c0446a.f1459d;
                    c0447b7.f1513o = i3;
                    c0447b7.f1512n = -1;
                    c0447b7.f1514p = -1;
                    return;
                } else if (i4 == 3) {
                    C0447b c0447b8 = c0446a.f1459d;
                    c0447b8.f1512n = i3;
                    c0447b8.f1513o = -1;
                    c0447b8.f1514p = -1;
                    return;
                } else {
                    StringBuilder m253r4 = outline.m253r("right to ");
                    m253r4.append(m2022k(i4));
                    m253r4.append(" undefined");
                    throw new IllegalArgumentException(m253r4.toString());
                }
            case 5:
                if (i4 == 5) {
                    C0447b c0447b9 = c0446a.f1459d;
                    c0447b9.f1514p = i3;
                    c0447b9.f1513o = -1;
                    c0447b9.f1512n = -1;
                    c0447b9.f1510l = -1;
                    c0447b9.f1511m = -1;
                    return;
                }
                StringBuilder m253r5 = outline.m253r("right to ");
                m253r5.append(m2022k(i4));
                m253r5.append(" undefined");
                throw new IllegalArgumentException(m253r5.toString());
            case 6:
                if (i4 == 6) {
                    C0447b c0447b10 = c0446a.f1459d;
                    c0447b10.f1516r = i3;
                    c0447b10.f1515q = -1;
                    return;
                } else if (i4 == 7) {
                    C0447b c0447b11 = c0446a.f1459d;
                    c0447b11.f1515q = i3;
                    c0447b11.f1516r = -1;
                    return;
                } else {
                    StringBuilder m253r6 = outline.m253r("right to ");
                    m253r6.append(m2022k(i4));
                    m253r6.append(" undefined");
                    throw new IllegalArgumentException(m253r6.toString());
                }
            case 7:
                if (i4 == 7) {
                    C0447b c0447b12 = c0446a.f1459d;
                    c0447b12.f1518t = i3;
                    c0447b12.f1517s = -1;
                    return;
                } else if (i4 == 6) {
                    C0447b c0447b13 = c0446a.f1459d;
                    c0447b13.f1517s = i3;
                    c0447b13.f1518t = -1;
                    return;
                } else {
                    StringBuilder m253r7 = outline.m253r("right to ");
                    m253r7.append(m2022k(i4));
                    m253r7.append(" undefined");
                    throw new IllegalArgumentException(m253r7.toString());
                }
            default:
                throw new IllegalArgumentException(m2022k(i2) + " to " + m2022k(i4) + " unknown");
        }
    }

    /* renamed from: f */
    public final int[] m2027f(View view, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = C0490V2.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    /* renamed from: g */
    public final C0446a m2026g(Context context, AttributeSet attributeSet) {
        C0446a c0446a = new C0446a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.Constraint);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index != C0533W2.Constraint_android_id && C0533W2.Constraint_android_layout_marginStart != index && C0533W2.Constraint_android_layout_marginEnd != index) {
                c0446a.f1458c.f1526a = true;
                c0446a.f1459d.f1491b = true;
                c0446a.f1457b.f1533a = true;
                c0446a.f1460e.f1539a = true;
            }
            switch (f1452e.get(index)) {
                case 1:
                    C0447b c0447b = c0446a.f1459d;
                    int resourceId = obtainStyledAttributes.getResourceId(index, c0447b.f1514p);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b.f1514p = resourceId;
                    break;
                case 2:
                    C0447b c0447b2 = c0446a.f1459d;
                    c0447b2.f1469G = obtainStyledAttributes.getDimensionPixelSize(index, c0447b2.f1469G);
                    break;
                case 3:
                    C0447b c0447b3 = c0446a.f1459d;
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, c0447b3.f1513o);
                    if (resourceId2 == -1) {
                        resourceId2 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b3.f1513o = resourceId2;
                    break;
                case 4:
                    C0447b c0447b4 = c0446a.f1459d;
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, c0447b4.f1512n);
                    if (resourceId3 == -1) {
                        resourceId3 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b4.f1512n = resourceId3;
                    break;
                case 5:
                    c0446a.f1459d.f1521w = obtainStyledAttributes.getString(index);
                    break;
                case 6:
                    C0447b c0447b5 = c0446a.f1459d;
                    c0447b5.f1463A = obtainStyledAttributes.getDimensionPixelOffset(index, c0447b5.f1463A);
                    break;
                case 7:
                    C0447b c0447b6 = c0446a.f1459d;
                    c0447b6.f1464B = obtainStyledAttributes.getDimensionPixelOffset(index, c0447b6.f1464B);
                    break;
                case 8:
                    C0447b c0447b7 = c0446a.f1459d;
                    c0447b7.f1470H = obtainStyledAttributes.getDimensionPixelSize(index, c0447b7.f1470H);
                    break;
                case 9:
                    C0447b c0447b8 = c0446a.f1459d;
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, c0447b8.f1518t);
                    if (resourceId4 == -1) {
                        resourceId4 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b8.f1518t = resourceId4;
                    break;
                case 10:
                    C0447b c0447b9 = c0446a.f1459d;
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, c0447b9.f1517s);
                    if (resourceId5 == -1) {
                        resourceId5 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b9.f1517s = resourceId5;
                    break;
                case 11:
                    C0447b c0447b10 = c0446a.f1459d;
                    c0447b10.f1475M = obtainStyledAttributes.getDimensionPixelSize(index, c0447b10.f1475M);
                    break;
                case 12:
                    C0447b c0447b11 = c0446a.f1459d;
                    c0447b11.f1476N = obtainStyledAttributes.getDimensionPixelSize(index, c0447b11.f1476N);
                    break;
                case 13:
                    C0447b c0447b12 = c0446a.f1459d;
                    c0447b12.f1472J = obtainStyledAttributes.getDimensionPixelSize(index, c0447b12.f1472J);
                    break;
                case 14:
                    C0447b c0447b13 = c0446a.f1459d;
                    c0447b13.f1474L = obtainStyledAttributes.getDimensionPixelSize(index, c0447b13.f1474L);
                    break;
                case 15:
                    C0447b c0447b14 = c0446a.f1459d;
                    c0447b14.f1477O = obtainStyledAttributes.getDimensionPixelSize(index, c0447b14.f1477O);
                    break;
                case 16:
                    C0447b c0447b15 = c0446a.f1459d;
                    c0447b15.f1473K = obtainStyledAttributes.getDimensionPixelSize(index, c0447b15.f1473K);
                    break;
                case 17:
                    C0447b c0447b16 = c0446a.f1459d;
                    c0447b16.f1497e = obtainStyledAttributes.getDimensionPixelOffset(index, c0447b16.f1497e);
                    break;
                case 18:
                    C0447b c0447b17 = c0446a.f1459d;
                    c0447b17.f1499f = obtainStyledAttributes.getDimensionPixelOffset(index, c0447b17.f1499f);
                    break;
                case 19:
                    C0447b c0447b18 = c0446a.f1459d;
                    c0447b18.f1501g = obtainStyledAttributes.getFloat(index, c0447b18.f1501g);
                    break;
                case 20:
                    C0447b c0447b19 = c0446a.f1459d;
                    c0447b19.f1519u = obtainStyledAttributes.getFloat(index, c0447b19.f1519u);
                    break;
                case 21:
                    C0447b c0447b20 = c0446a.f1459d;
                    c0447b20.f1495d = obtainStyledAttributes.getLayoutDimension(index, c0447b20.f1495d);
                    break;
                case 22:
                    C0449d c0449d = c0446a.f1457b;
                    c0449d.f1534b = obtainStyledAttributes.getInt(index, c0449d.f1534b);
                    C0449d c0449d2 = c0446a.f1457b;
                    c0449d2.f1534b = f1451d[c0449d2.f1534b];
                    break;
                case 23:
                    C0447b c0447b21 = c0446a.f1459d;
                    c0447b21.f1493c = obtainStyledAttributes.getLayoutDimension(index, c0447b21.f1493c);
                    break;
                case 24:
                    C0447b c0447b22 = c0446a.f1459d;
                    c0447b22.f1466D = obtainStyledAttributes.getDimensionPixelSize(index, c0447b22.f1466D);
                    break;
                case 25:
                    C0447b c0447b23 = c0446a.f1459d;
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, c0447b23.f1503h);
                    if (resourceId6 == -1) {
                        resourceId6 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b23.f1503h = resourceId6;
                    break;
                case 26:
                    C0447b c0447b24 = c0446a.f1459d;
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, c0447b24.f1505i);
                    if (resourceId7 == -1) {
                        resourceId7 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b24.f1505i = resourceId7;
                    break;
                case 27:
                    C0447b c0447b25 = c0446a.f1459d;
                    c0447b25.f1465C = obtainStyledAttributes.getInt(index, c0447b25.f1465C);
                    break;
                case 28:
                    C0447b c0447b26 = c0446a.f1459d;
                    c0447b26.f1467E = obtainStyledAttributes.getDimensionPixelSize(index, c0447b26.f1467E);
                    break;
                case 29:
                    C0447b c0447b27 = c0446a.f1459d;
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, c0447b27.f1507j);
                    if (resourceId8 == -1) {
                        resourceId8 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b27.f1507j = resourceId8;
                    break;
                case 30:
                    C0447b c0447b28 = c0446a.f1459d;
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, c0447b28.f1509k);
                    if (resourceId9 == -1) {
                        resourceId9 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b28.f1509k = resourceId9;
                    break;
                case 31:
                    C0447b c0447b29 = c0446a.f1459d;
                    c0447b29.f1471I = obtainStyledAttributes.getDimensionPixelSize(index, c0447b29.f1471I);
                    break;
                case 32:
                    C0447b c0447b30 = c0446a.f1459d;
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, c0447b30.f1515q);
                    if (resourceId10 == -1) {
                        resourceId10 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b30.f1515q = resourceId10;
                    break;
                case 33:
                    C0447b c0447b31 = c0446a.f1459d;
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, c0447b31.f1516r);
                    if (resourceId11 == -1) {
                        resourceId11 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b31.f1516r = resourceId11;
                    break;
                case 34:
                    C0447b c0447b32 = c0446a.f1459d;
                    c0447b32.f1468F = obtainStyledAttributes.getDimensionPixelSize(index, c0447b32.f1468F);
                    break;
                case 35:
                    C0447b c0447b33 = c0446a.f1459d;
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, c0447b33.f1511m);
                    if (resourceId12 == -1) {
                        resourceId12 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b33.f1511m = resourceId12;
                    break;
                case 36:
                    C0447b c0447b34 = c0446a.f1459d;
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, c0447b34.f1510l);
                    if (resourceId13 == -1) {
                        resourceId13 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b34.f1510l = resourceId13;
                    break;
                case 37:
                    C0447b c0447b35 = c0446a.f1459d;
                    c0447b35.f1520v = obtainStyledAttributes.getFloat(index, c0447b35.f1520v);
                    break;
                case 38:
                    c0446a.f1456a = obtainStyledAttributes.getResourceId(index, c0446a.f1456a);
                    break;
                case 39:
                    C0447b c0447b36 = c0446a.f1459d;
                    c0447b36.f1479Q = obtainStyledAttributes.getFloat(index, c0447b36.f1479Q);
                    break;
                case 40:
                    C0447b c0447b37 = c0446a.f1459d;
                    c0447b37.f1478P = obtainStyledAttributes.getFloat(index, c0447b37.f1478P);
                    break;
                case 41:
                    C0447b c0447b38 = c0446a.f1459d;
                    c0447b38.f1480R = obtainStyledAttributes.getInt(index, c0447b38.f1480R);
                    break;
                case 42:
                    C0447b c0447b39 = c0446a.f1459d;
                    c0447b39.f1481S = obtainStyledAttributes.getInt(index, c0447b39.f1481S);
                    break;
                case 43:
                    C0449d c0449d3 = c0446a.f1457b;
                    c0449d3.f1536d = obtainStyledAttributes.getFloat(index, c0449d3.f1536d);
                    break;
                case 44:
                    C0450e c0450e = c0446a.f1460e;
                    c0450e.f1550l = true;
                    c0450e.f1551m = obtainStyledAttributes.getDimension(index, c0450e.f1551m);
                    break;
                case 45:
                    C0450e c0450e2 = c0446a.f1460e;
                    c0450e2.f1541c = obtainStyledAttributes.getFloat(index, c0450e2.f1541c);
                    break;
                case 46:
                    C0450e c0450e3 = c0446a.f1460e;
                    c0450e3.f1542d = obtainStyledAttributes.getFloat(index, c0450e3.f1542d);
                    break;
                case 47:
                    C0450e c0450e4 = c0446a.f1460e;
                    c0450e4.f1543e = obtainStyledAttributes.getFloat(index, c0450e4.f1543e);
                    break;
                case 48:
                    C0450e c0450e5 = c0446a.f1460e;
                    c0450e5.f1544f = obtainStyledAttributes.getFloat(index, c0450e5.f1544f);
                    break;
                case 49:
                    C0450e c0450e6 = c0446a.f1460e;
                    c0450e6.f1545g = obtainStyledAttributes.getDimension(index, c0450e6.f1545g);
                    break;
                case 50:
                    C0450e c0450e7 = c0446a.f1460e;
                    c0450e7.f1546h = obtainStyledAttributes.getDimension(index, c0450e7.f1546h);
                    break;
                case 51:
                    C0450e c0450e8 = c0446a.f1460e;
                    c0450e8.f1547i = obtainStyledAttributes.getDimension(index, c0450e8.f1547i);
                    break;
                case 52:
                    C0450e c0450e9 = c0446a.f1460e;
                    c0450e9.f1548j = obtainStyledAttributes.getDimension(index, c0450e9.f1548j);
                    break;
                case 53:
                    C0450e c0450e10 = c0446a.f1460e;
                    c0450e10.f1549k = obtainStyledAttributes.getDimension(index, c0450e10.f1549k);
                    break;
                case 54:
                    C0447b c0447b40 = c0446a.f1459d;
                    c0447b40.f1482T = obtainStyledAttributes.getInt(index, c0447b40.f1482T);
                    break;
                case 55:
                    C0447b c0447b41 = c0446a.f1459d;
                    c0447b41.f1483U = obtainStyledAttributes.getInt(index, c0447b41.f1483U);
                    break;
                case 56:
                    C0447b c0447b42 = c0446a.f1459d;
                    c0447b42.f1484V = obtainStyledAttributes.getDimensionPixelSize(index, c0447b42.f1484V);
                    break;
                case 57:
                    C0447b c0447b43 = c0446a.f1459d;
                    c0447b43.f1485W = obtainStyledAttributes.getDimensionPixelSize(index, c0447b43.f1485W);
                    break;
                case 58:
                    C0447b c0447b44 = c0446a.f1459d;
                    c0447b44.f1486X = obtainStyledAttributes.getDimensionPixelSize(index, c0447b44.f1486X);
                    break;
                case 59:
                    C0447b c0447b45 = c0446a.f1459d;
                    c0447b45.f1487Y = obtainStyledAttributes.getDimensionPixelSize(index, c0447b45.f1487Y);
                    break;
                case 60:
                    C0450e c0450e11 = c0446a.f1460e;
                    c0450e11.f1540b = obtainStyledAttributes.getFloat(index, c0450e11.f1540b);
                    break;
                case 61:
                    C0447b c0447b46 = c0446a.f1459d;
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, c0447b46.f1522x);
                    if (resourceId14 == -1) {
                        resourceId14 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0447b46.f1522x = resourceId14;
                    break;
                case 62:
                    C0447b c0447b47 = c0446a.f1459d;
                    c0447b47.f1523y = obtainStyledAttributes.getDimensionPixelSize(index, c0447b47.f1523y);
                    break;
                case 63:
                    C0447b c0447b48 = c0446a.f1459d;
                    c0447b48.f1524z = obtainStyledAttributes.getFloat(index, c0447b48.f1524z);
                    break;
                case 64:
                    C0448c c0448c = c0446a.f1458c;
                    int resourceId15 = obtainStyledAttributes.getResourceId(index, c0448c.f1527b);
                    if (resourceId15 == -1) {
                        resourceId15 = obtainStyledAttributes.getInt(index, -1);
                    }
                    c0448c.f1527b = resourceId15;
                    break;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        c0446a.f1458c.f1528c = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        c0446a.f1458c.f1528c = C0191I1.f625c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    c0446a.f1458c.f1530e = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 67:
                    C0448c c0448c2 = c0446a.f1458c;
                    c0448c2.f1532g = obtainStyledAttributes.getFloat(index, c0448c2.f1532g);
                    break;
                case 68:
                    C0449d c0449d4 = c0446a.f1457b;
                    c0449d4.f1537e = obtainStyledAttributes.getFloat(index, c0449d4.f1537e);
                    break;
                case 69:
                    c0446a.f1459d.f1488Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    c0446a.f1459d.f1490a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    C0447b c0447b49 = c0446a.f1459d;
                    c0447b49.f1492b0 = obtainStyledAttributes.getInt(index, c0447b49.f1492b0);
                    break;
                case 73:
                    C0447b c0447b50 = c0446a.f1459d;
                    c0447b50.f1494c0 = obtainStyledAttributes.getDimensionPixelSize(index, c0447b50.f1494c0);
                    break;
                case 74:
                    c0446a.f1459d.f1500f0 = obtainStyledAttributes.getString(index);
                    break;
                case 75:
                    C0447b c0447b51 = c0446a.f1459d;
                    c0447b51.f1508j0 = obtainStyledAttributes.getBoolean(index, c0447b51.f1508j0);
                    break;
                case 76:
                    C0448c c0448c3 = c0446a.f1458c;
                    c0448c3.f1529d = obtainStyledAttributes.getInt(index, c0448c3.f1529d);
                    break;
                case 77:
                    c0446a.f1459d.f1502g0 = obtainStyledAttributes.getString(index);
                    break;
                case 78:
                    C0449d c0449d5 = c0446a.f1457b;
                    c0449d5.f1535c = obtainStyledAttributes.getInt(index, c0449d5.f1535c);
                    break;
                case 79:
                    C0448c c0448c4 = c0446a.f1458c;
                    c0448c4.f1531f = obtainStyledAttributes.getFloat(index, c0448c4.f1531f);
                    break;
                case 80:
                    C0447b c0447b52 = c0446a.f1459d;
                    c0447b52.f1504h0 = obtainStyledAttributes.getBoolean(index, c0447b52.f1504h0);
                    break;
                case 81:
                    C0447b c0447b53 = c0446a.f1459d;
                    c0447b53.f1506i0 = obtainStyledAttributes.getBoolean(index, c0447b53.f1506i0);
                    break;
                case 82:
                    StringBuilder m253r = outline.m253r("unused attribute 0x");
                    m253r.append(Integer.toHexString(index));
                    m253r.append("   ");
                    m253r.append(f1452e.get(index));
                    Log.w("ConstraintSet", m253r.toString());
                    break;
                default:
                    StringBuilder m253r2 = outline.m253r("Unknown attribute 0x");
                    m253r2.append(Integer.toHexString(index));
                    m253r2.append("   ");
                    m253r2.append(f1452e.get(index));
                    Log.w("ConstraintSet", m253r2.toString());
                    break;
            }
        }
        obtainStyledAttributes.recycle();
        return c0446a;
    }

    /* renamed from: h */
    public final C0446a m2025h(int i) {
        if (!this.f1455c.containsKey(Integer.valueOf(i))) {
            this.f1455c.put(Integer.valueOf(i), new C0446a());
        }
        return this.f1455c.get(Integer.valueOf(i));
    }

    /* renamed from: i */
    public void m2024i(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    C0446a m2026g = m2026g(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        m2026g.f1459d.f1489a = true;
                    }
                    this.f1455c.put(Integer.valueOf(m2026g.f1456a), m2026g);
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0178, code lost:
        continue;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2023j(android.content.Context r9, org.xmlpull.p019v1.XmlPullParser r10) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0445T2.m2023j(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* renamed from: k */
    public final String m2022k(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }
}
