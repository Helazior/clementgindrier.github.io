package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;

/* renamed from: X2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0550X2 {

    /* renamed from: a */
    public int f1977a;

    /* renamed from: b */
    public SparseArray<C0551a> f1978b = new SparseArray<>();

    /* renamed from: X2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0551a {

        /* renamed from: a */
        public int f1979a;

        /* renamed from: b */
        public ArrayList<C0552b> f1980b = new ArrayList<>();

        /* renamed from: c */
        public int f1981c;

        public C0551a(Context context, XmlPullParser xmlPullParser) {
            this.f1981c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.State_android_id) {
                    this.f1979a = obtainStyledAttributes.getResourceId(index, this.f1979a);
                } else if (index == C0533W2.State_constraints) {
                    this.f1981c = obtainStyledAttributes.getResourceId(index, this.f1981c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1981c);
                    context.getResources().getResourceName(this.f1981c);
                    "layout".equals(resourceTypeName);
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public int m1811a(float f, float f2) {
            for (int i = 0; i < this.f1980b.size(); i++) {
                if (this.f1980b.get(i).m1810a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: X2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0552b {

        /* renamed from: a */
        public float f1982a;

        /* renamed from: b */
        public float f1983b;

        /* renamed from: c */
        public float f1984c;

        /* renamed from: d */
        public float f1985d;

        /* renamed from: e */
        public int f1986e;

        public C0552b(Context context, XmlPullParser xmlPullParser) {
            this.f1982a = Float.NaN;
            this.f1983b = Float.NaN;
            this.f1984c = Float.NaN;
            this.f1985d = Float.NaN;
            this.f1986e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.Variant_constraints) {
                    this.f1986e = obtainStyledAttributes.getResourceId(index, this.f1986e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1986e);
                    context.getResources().getResourceName(this.f1986e);
                    "layout".equals(resourceTypeName);
                } else if (index == C0533W2.Variant_region_heightLessThan) {
                    this.f1985d = obtainStyledAttributes.getDimension(index, this.f1985d);
                } else if (index == C0533W2.Variant_region_heightMoreThan) {
                    this.f1983b = obtainStyledAttributes.getDimension(index, this.f1983b);
                } else if (index == C0533W2.Variant_region_widthLessThan) {
                    this.f1984c = obtainStyledAttributes.getDimension(index, this.f1984c);
                } else if (index == C0533W2.Variant_region_widthMoreThan) {
                    this.f1982a = obtainStyledAttributes.getDimension(index, this.f1982a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public boolean m1810a(float f, float f2) {
            if (Float.isNaN(this.f1982a) || f >= this.f1982a) {
                if (Float.isNaN(this.f1983b) || f2 >= this.f1983b) {
                    if (Float.isNaN(this.f1984c) || f <= this.f1984c) {
                        return Float.isNaN(this.f1985d) || f2 <= this.f1985d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public C0550X2(Context context, XmlPullParser xmlPullParser) {
        char c;
        this.f1977a = -1;
        new SparseArray();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0533W2.StateSet_defaultState) {
                this.f1977a = obtainStyledAttributes.getResourceId(index, this.f1977a);
            }
        }
        obtainStyledAttributes.recycle();
        C0551a c0551a = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c != 0 && c != 1) {
                        if (c == 2) {
                            c0551a = new C0551a(context, xmlPullParser);
                            this.f1978b.put(c0551a.f1979a, c0551a);
                        } else if (c != 3) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            C0552b c0552b = new C0552b(context, xmlPullParser);
                            if (c0551a != null) {
                                c0551a.f1980b.add(c0552b);
                            }
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public int m1812a(int i, int i2, int i3) {
        int i4;
        C0551a c0551a;
        int m1811a;
        float f = i2;
        float f2 = i3;
        if (-1 == i) {
            if (i == -1) {
                c0551a = this.f1978b.valueAt(0);
            } else {
                c0551a = this.f1978b.get(-1);
            }
            if (c0551a == null || -1 == (m1811a = c0551a.m1811a(f, f2))) {
                return -1;
            }
            i4 = m1811a == -1 ? c0551a.f1981c : c0551a.f1980b.get(m1811a).f1986e;
        } else {
            C0551a c0551a2 = this.f1978b.get(i);
            if (c0551a2 == null) {
                return -1;
            }
            int m1811a2 = c0551a2.m1811a(f, f2);
            i4 = m1811a2 == -1 ? c0551a2.f1981c : c0551a2.f1980b.get(m1811a2).f1986e;
        }
        return i4;
    }
}
