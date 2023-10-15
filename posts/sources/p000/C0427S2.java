package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;

/* renamed from: S2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0427S2 {

    /* renamed from: a */
    public final ConstraintLayout f1388a;

    /* renamed from: b */
    public int f1389b = -1;

    /* renamed from: c */
    public int f1390c = -1;

    /* renamed from: d */
    public SparseArray<C0428a> f1391d = new SparseArray<>();

    /* renamed from: e */
    public SparseArray<C0445T2> f1392e = new SparseArray<>();

    /* renamed from: S2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0428a {

        /* renamed from: a */
        public int f1393a;

        /* renamed from: b */
        public ArrayList<C0429b> f1394b = new ArrayList<>();

        /* renamed from: c */
        public int f1395c;

        /* renamed from: d */
        public C0445T2 f1396d;

        public C0428a(Context context, XmlPullParser xmlPullParser) {
            this.f1395c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.State_android_id) {
                    this.f1393a = obtainStyledAttributes.getResourceId(index, this.f1393a);
                } else if (index == C0533W2.State_constraints) {
                    this.f1395c = obtainStyledAttributes.getResourceId(index, this.f1395c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1395c);
                    context.getResources().getResourceName(this.f1395c);
                    if ("layout".equals(resourceTypeName)) {
                        C0445T2 c0445t2 = new C0445T2();
                        this.f1396d = c0445t2;
                        c0445t2.m2029d((ConstraintLayout) LayoutInflater.from(context).inflate(this.f1395c, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public int m2038a(float f, float f2) {
            for (int i = 0; i < this.f1394b.size(); i++) {
                if (this.f1394b.get(i).m2037a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: S2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0429b {

        /* renamed from: a */
        public float f1397a;

        /* renamed from: b */
        public float f1398b;

        /* renamed from: c */
        public float f1399c;

        /* renamed from: d */
        public float f1400d;

        /* renamed from: e */
        public int f1401e;

        /* renamed from: f */
        public C0445T2 f1402f;

        public C0429b(Context context, XmlPullParser xmlPullParser) {
            this.f1397a = Float.NaN;
            this.f1398b = Float.NaN;
            this.f1399c = Float.NaN;
            this.f1400d = Float.NaN;
            this.f1401e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.Variant_constraints) {
                    this.f1401e = obtainStyledAttributes.getResourceId(index, this.f1401e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1401e);
                    context.getResources().getResourceName(this.f1401e);
                    if ("layout".equals(resourceTypeName)) {
                        C0445T2 c0445t2 = new C0445T2();
                        this.f1402f = c0445t2;
                        c0445t2.m2029d((ConstraintLayout) LayoutInflater.from(context).inflate(this.f1401e, (ViewGroup) null));
                    }
                } else if (index == C0533W2.Variant_region_heightLessThan) {
                    this.f1400d = obtainStyledAttributes.getDimension(index, this.f1400d);
                } else if (index == C0533W2.Variant_region_heightMoreThan) {
                    this.f1398b = obtainStyledAttributes.getDimension(index, this.f1398b);
                } else if (index == C0533W2.Variant_region_widthLessThan) {
                    this.f1399c = obtainStyledAttributes.getDimension(index, this.f1399c);
                } else if (index == C0533W2.Variant_region_widthMoreThan) {
                    this.f1397a = obtainStyledAttributes.getDimension(index, this.f1397a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public boolean m2037a(float f, float f2) {
            if (Float.isNaN(this.f1397a) || f >= this.f1397a) {
                if (Float.isNaN(this.f1398b) || f2 >= this.f1398b) {
                    if (Float.isNaN(this.f1399c) || f <= this.f1399c) {
                        return Float.isNaN(this.f1400d) || f2 <= this.f1400d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public C0427S2(Context context, ConstraintLayout constraintLayout, int i) {
        char c;
        this.f1388a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            C0428a c0428a = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
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
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c = 0;
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
                            C0428a c0428a2 = new C0428a(context, xml);
                            this.f1391d.put(c0428a2.f1393a, c0428a2);
                            c0428a = c0428a2;
                            continue;
                        } else if (c == 3) {
                            C0429b c0429b = new C0429b(context, xml);
                            if (c0428a != null) {
                                c0428a.f1394b.add(c0429b);
                                continue;
                            } else {
                                continue;
                            }
                        } else if (c != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            continue;
                        } else {
                            m2040a(context, xml);
                            continue;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m2040a(Context context, XmlPullParser xmlPullParser) {
        C0445T2 c0445t2 = new C0445T2();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                c0445t2.m2023j(context, xmlPullParser);
                this.f1392e.put(identifier, c0445t2);
                return;
            }
        }
    }

    /* renamed from: b */
    public void m2039b(int i, float f, float f2) {
        C0445T2 c0445t2;
        C0428a c0428a;
        int m2038a;
        int i2 = this.f1389b;
        if (i2 == i) {
            if (i == -1) {
                c0428a = this.f1391d.valueAt(0);
            } else {
                c0428a = this.f1391d.get(i2);
            }
            int i3 = this.f1390c;
            if ((i3 == -1 || !c0428a.f1394b.get(i3).m2037a(f, f2)) && this.f1390c != (m2038a = c0428a.m2038a(f, f2))) {
                C0445T2 c0445t22 = m2038a == -1 ? null : c0428a.f1394b.get(m2038a).f1402f;
                if (m2038a != -1) {
                    int i4 = c0428a.f1394b.get(m2038a).f1401e;
                }
                if (c0445t22 == null) {
                    return;
                }
                this.f1390c = m2038a;
                c0445t22.m2031b(this.f1388a);
                return;
            }
            return;
        }
        this.f1389b = i;
        C0428a c0428a2 = this.f1391d.get(i);
        int m2038a2 = c0428a2.m2038a(f, f2);
        if (m2038a2 == -1) {
            c0445t2 = c0428a2.f1396d;
        } else {
            c0445t2 = c0428a2.f1394b.get(m2038a2).f1402f;
        }
        if (m2038a2 != -1) {
            int i5 = c0428a2.f1394b.get(m2038a2).f1401e;
        }
        if (c0445t2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f + ", " + f2);
            return;
        }
        this.f1390c = m2038a2;
        c0445t2.m2031b(this.f1388a);
    }
}
