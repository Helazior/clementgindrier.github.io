package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;
import p000.C0445T2;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: c2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0982c2 {

    /* renamed from: a */
    public final MotionLayout f3749a;

    /* renamed from: b */
    public C0550X2 f3750b;

    /* renamed from: c */
    public C0984b f3751c;

    /* renamed from: e */
    public C0984b f3753e;

    /* renamed from: l */
    public MotionEvent f3760l;

    /* renamed from: o */
    public MotionLayout.InterfaceC0709e f3763o;

    /* renamed from: p */
    public boolean f3764p;

    /* renamed from: q */
    public float f3765q;

    /* renamed from: r */
    public float f3766r;

    /* renamed from: d */
    public ArrayList<C0984b> f3752d = new ArrayList<>();

    /* renamed from: f */
    public ArrayList<C0984b> f3754f = new ArrayList<>();

    /* renamed from: g */
    public SparseArray<C0445T2> f3755g = new SparseArray<>();

    /* renamed from: h */
    public HashMap<String, Integer> f3756h = new HashMap<>();

    /* renamed from: i */
    public SparseIntArray f3757i = new SparseIntArray();

    /* renamed from: j */
    public int f3758j = 400;

    /* renamed from: k */
    public int f3759k = 0;

    /* renamed from: m */
    public boolean f3761m = false;

    /* renamed from: n */
    public boolean f3762n = false;

    /* renamed from: c2$a  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class animationInterpolatorC0983a implements Interpolator {

        /* renamed from: a */
        public final /* synthetic */ C0191I1 f3767a;

        public animationInterpolatorC0983a(C0982c2 c0982c2, C0191I1 c0191i1) {
            this.f3767a = c0191i1;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.f3767a.mo2393a(f);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public C0982c2(Context context, MotionLayout motionLayout, int i) {
        int eventType;
        C0984b c0984b = null;
        this.f3750b = null;
        this.f3751c = null;
        this.f3753e = null;
        this.f3749a = motionLayout;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            eventType = xml.getEventType();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
        while (true) {
            char c = 1;
            if (eventType != 1) {
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
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            c = 65535;
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 793277014:
                            if (name.equals("MotionScene")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            m1132k(context, xml);
                            continue;
                        case 1:
                            ArrayList<C0984b> arrayList = this.f3752d;
                            C0984b c0984b2 = new C0984b(this, context, xml);
                            arrayList.add(c0984b2);
                            if (this.f3751c == null && !c0984b2.f3769b) {
                                this.f3751c = c0984b2;
                                C1853h2 c1853h2 = c0984b2.f3779l;
                                if (c1853h2 != null) {
                                    c1853h2.m784b(this.f3764p);
                                }
                            }
                            if (c0984b2.f3769b) {
                                if (c0984b2.f3770c == -1) {
                                    this.f3753e = c0984b2;
                                } else {
                                    this.f3754f.add(c0984b2);
                                }
                                this.f3752d.remove(c0984b2);
                            }
                            c0984b = c0984b2;
                            continue;
                        case 2:
                            if (c0984b == null) {
                                String resourceEntryName = context.getResources().getResourceEntryName(i);
                                int lineNumber = xml.getLineNumber();
                                Log.v("MotionScene", " OnSwipe (" + resourceEntryName + ".xml:" + lineNumber + ")");
                            }
                            c0984b.f3779l = new C1853h2(context, this.f3749a, xml);
                            continue;
                        case 3:
                            c0984b.f3780m.add(new C0984b.View$OnClickListenerC0985a(context, c0984b, xml));
                            continue;
                        case 4:
                            this.f3750b = new C0550X2(context, xml);
                            continue;
                        case 5:
                            m1133j(context, xml);
                            continue;
                        case 6:
                            c0984b.f3778k.add(new C0444T1(context, xml));
                            continue;
                        default:
                            Log.v("MotionScene", "WARNING UNKNOWN ATTRIBUTE " + name);
                            continue;
                    }
                }
                eventType = xml.next();
            } else {
                SparseArray<C0445T2> sparseArray = this.f3755g;
                int i2 = C0490V2.motion_base;
                sparseArray.put(i2, new C0445T2());
                this.f3756h.put("motion_base", Integer.valueOf(i2));
                return;
            }
        }
    }

    /* renamed from: a */
    public boolean m1142a(MotionLayout motionLayout, int i) {
        MotionLayout.EnumC0713i enumC0713i = MotionLayout.EnumC0713i.FINISHED;
        MotionLayout.EnumC0713i enumC0713i2 = MotionLayout.EnumC0713i.MOVING;
        MotionLayout.EnumC0713i enumC0713i3 = MotionLayout.EnumC0713i.SETUP;
        if (this.f3763o != null) {
            return false;
        }
        Iterator<C0984b> it = this.f3752d.iterator();
        while (it.hasNext()) {
            C0984b next = it.next();
            int i2 = next.f3781n;
            if (i2 != 0 && this.f3751c != next) {
                if (i == next.f3771d && (i2 == 4 || i2 == 2)) {
                    motionLayout.m1569k(enumC0713i);
                    motionLayout.m1568l(next);
                    if (next.f3781n == 4) {
                        motionLayout.m1579a(1.0f);
                        motionLayout.m1569k(enumC0713i3);
                        motionLayout.m1569k(enumC0713i2);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.m1578b(true);
                        motionLayout.m1569k(enumC0713i3);
                        motionLayout.m1569k(enumC0713i2);
                        motionLayout.m1569k(enumC0713i);
                        motionLayout.m1572h();
                    }
                    return true;
                } else if (i == next.f3770c && (i2 == 3 || i2 == 1)) {
                    motionLayout.m1569k(enumC0713i);
                    motionLayout.m1568l(next);
                    if (next.f3781n == 3) {
                        motionLayout.m1579a(0.0f);
                        motionLayout.m1569k(enumC0713i3);
                        motionLayout.m1569k(enumC0713i2);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.m1578b(true);
                        motionLayout.m1569k(enumC0713i3);
                        motionLayout.m1569k(enumC0713i2);
                        motionLayout.m1569k(enumC0713i);
                        motionLayout.m1572h();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public C0445T2 m1141b(int i) {
        int m1812a;
        C0550X2 c0550x2 = this.f3750b;
        if (c0550x2 != null && (m1812a = c0550x2.m1812a(i, -1, -1)) != -1) {
            i = m1812a;
        }
        if (this.f3755g.get(i) == null) {
            StringBuilder m253r = outline.m253r("Warning could not find ConstraintSet id/");
            m253r.append(LayoutInflater$Factory2C0000A.C0010h.m2674D(this.f3749a.getContext(), i));
            m253r.append(" In MotionScene");
            Log.e("MotionScene", m253r.toString());
            SparseArray<C0445T2> sparseArray = this.f3755g;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.f3755g.get(i);
    }

    /* renamed from: c */
    public int m1140c() {
        C0984b c0984b = this.f3751c;
        if (c0984b != null) {
            return c0984b.f3775h;
        }
        return this.f3758j;
    }

    /* renamed from: d */
    public int m1139d() {
        C0984b c0984b = this.f3751c;
        if (c0984b == null) {
            return -1;
        }
        return c0984b.f3770c;
    }

    /* renamed from: e */
    public final int m1138e(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i = -1;
        }
        if (i == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
            return i;
        }
        return i;
    }

    /* renamed from: f */
    public Interpolator m1137f() {
        C0984b c0984b = this.f3751c;
        int i = c0984b.f3772e;
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return new BounceInterpolator();
                            }
                            return new AnticipateInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new animationInterpolatorC0983a(this, C0191I1.m2394c(c0984b.f3773f));
        }
        return AnimationUtils.loadInterpolator(this.f3749a.getContext(), this.f3751c.f3774g);
    }

    /* renamed from: g */
    public void m1136g(C0585Z1 c0585z1) {
        C0984b c0984b = this.f3751c;
        if (c0984b == null) {
            C0984b c0984b2 = this.f3753e;
            if (c0984b2 != null) {
                Iterator<C0444T1> it = c0984b2.f3778k.iterator();
                while (it.hasNext()) {
                    it.next().m2034a(c0585z1);
                }
                return;
            }
            return;
        }
        Iterator<C0444T1> it2 = c0984b.f3778k.iterator();
        while (it2.hasNext()) {
            it2.next().m2034a(c0585z1);
        }
    }

    /* renamed from: h */
    public float m1135h() {
        C1853h2 c1853h2;
        C0984b c0984b = this.f3751c;
        if (c0984b == null || (c1853h2 = c0984b.f3779l) == null) {
            return 0.0f;
        }
        return c1853h2.f5132q;
    }

    /* renamed from: i */
    public int m1134i() {
        C0984b c0984b = this.f3751c;
        if (c0984b == null) {
            return -1;
        }
        return c0984b.f3771d;
    }

    /* renamed from: j */
    public final void m1133j(Context context, XmlPullParser xmlPullParser) {
        C0445T2 c0445t2 = new C0445T2();
        c0445t2.f1454b = false;
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                i2 = m1138e(context, attributeValue);
            } else if (attributeName.equals("id")) {
                i = m1138e(context, attributeValue);
                HashMap<String, Integer> hashMap = this.f3756h;
                int indexOf = attributeValue.indexOf(47);
                if (indexOf >= 0) {
                    attributeValue = attributeValue.substring(indexOf + 1);
                }
                hashMap.put(attributeValue, Integer.valueOf(i));
            }
        }
        if (i != -1) {
            int i4 = this.f3749a.f2738w;
            c0445t2.m2023j(context, xmlPullParser);
            if (i2 != -1) {
                this.f3757i.put(i, i2);
            }
            this.f3755g.put(i, c0445t2);
        }
    }

    /* renamed from: k */
    public final void m1132k(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0533W2.MotionScene_defaultDuration) {
                this.f3758j = obtainStyledAttributes.getInt(index, this.f3758j);
            } else if (index == C0533W2.MotionScene_layoutDuringTransition) {
                this.f3759k = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: l */
    public final void m1131l(int i) {
        int i2 = this.f3757i.get(i);
        if (i2 > 0) {
            m1131l(this.f3757i.get(i));
            C0445T2 c0445t2 = this.f3755g.get(i);
            C0445T2 c0445t22 = this.f3755g.get(i2);
            if (c0445t22 == null) {
                StringBuilder m253r = outline.m253r("ERROR! invalid deriveConstraintsFrom: @id/");
                m253r.append(LayoutInflater$Factory2C0000A.C0010h.m2674D(this.f3749a.getContext(), i2));
                Log.e("MotionScene", m253r.toString());
                return;
            }
            Objects.requireNonNull(c0445t2);
            for (Integer num : c0445t22.f1455c.keySet()) {
                int intValue = num.intValue();
                C0445T2.C0446a c0446a = c0445t22.f1455c.get(num);
                if (!c0445t2.f1455c.containsKey(Integer.valueOf(intValue))) {
                    c0445t2.f1455c.put(Integer.valueOf(intValue), new C0445T2.C0446a());
                }
                C0445T2.C0446a c0446a2 = c0445t2.f1455c.get(Integer.valueOf(intValue));
                C0445T2.C0447b c0447b = c0446a2.f1459d;
                if (!c0447b.f1491b) {
                    c0447b.m2018a(c0446a.f1459d);
                }
                C0445T2.C0449d c0449d = c0446a2.f1457b;
                if (!c0449d.f1533a) {
                    c0449d.m2014a(c0446a.f1457b);
                }
                C0445T2.C0450e c0450e = c0446a2.f1460e;
                if (!c0450e.f1539a) {
                    c0450e.m2012a(c0446a.f1460e);
                }
                C0445T2.C0448c c0448c = c0446a2.f1458c;
                if (!c0448c.f1526a) {
                    c0448c.m2016a(c0446a.f1458c);
                }
                for (String str : c0446a.f1461f.keySet()) {
                    if (!c0446a2.f1461f.containsKey(str)) {
                        c0446a2.f1461f.put(str, c0446a.f1461f.get(str));
                    }
                }
            }
            this.f3757i.put(i, -1);
        }
    }

    /* renamed from: m */
    public void m1130m(MotionLayout motionLayout) {
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < this.f3755g.size()) {
                int keyAt = this.f3755g.keyAt(i);
                int i2 = this.f3757i.get(keyAt);
                int size = this.f3757i.size();
                while (true) {
                    if (i2 <= 0) {
                        z = false;
                        break;
                    } else if (i2 == keyAt) {
                        break;
                    } else {
                        int i3 = size - 1;
                        if (size < 0) {
                            break;
                        }
                        i2 = this.f3757i.get(i2);
                        size = i3;
                    }
                }
                if (z) {
                    Log.e("MotionScene", "Cannot be derived from yourself");
                    return;
                } else {
                    m1131l(keyAt);
                    i++;
                }
            } else {
                for (int i4 = 0; i4 < this.f3755g.size(); i4++) {
                    C0445T2 valueAt = this.f3755g.valueAt(i4);
                    Objects.requireNonNull(valueAt);
                    int childCount = motionLayout.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = motionLayout.getChildAt(i5);
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        int id = childAt.getId();
                        if (valueAt.f1454b && id == -1) {
                            throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                        }
                        if (!valueAt.f1455c.containsKey(Integer.valueOf(id))) {
                            valueAt.f1455c.put(Integer.valueOf(id), new C0445T2.C0446a());
                        }
                        C0445T2.C0446a c0446a = valueAt.f1455c.get(Integer.valueOf(id));
                        if (!c0446a.f1459d.f1491b) {
                            c0446a.m2020b(id, layoutParams);
                            if (childAt instanceof ConstraintHelper) {
                                c0446a.f1459d.f1498e0 = ((ConstraintHelper) childAt).m1535j();
                                if (childAt instanceof Barrier) {
                                    Barrier barrier = (Barrier) childAt;
                                    C0445T2.C0447b c0447b = c0446a.f1459d;
                                    C2189q2 c2189q2 = barrier.f2832k;
                                    c0447b.f1508j0 = c2189q2.f6258L0;
                                    c0447b.f1492b0 = barrier.f2830i;
                                    c0447b.f1494c0 = c2189q2.f6259M0;
                                }
                            }
                            c0446a.f1459d.f1491b = true;
                        }
                        C0445T2.C0449d c0449d = c0446a.f1457b;
                        if (!c0449d.f1533a) {
                            c0449d.f1534b = childAt.getVisibility();
                            c0446a.f1457b.f1536d = childAt.getAlpha();
                            c0446a.f1457b.f1533a = true;
                        }
                        C0445T2.C0450e c0450e = c0446a.f1460e;
                        if (!c0450e.f1539a) {
                            c0450e.f1539a = true;
                            c0450e.f1540b = childAt.getRotation();
                            c0446a.f1460e.f1541c = childAt.getRotationX();
                            c0446a.f1460e.f1542d = childAt.getRotationY();
                            c0446a.f1460e.f1543e = childAt.getScaleX();
                            c0446a.f1460e.f1544f = childAt.getScaleY();
                            float pivotX = childAt.getPivotX();
                            float pivotY = childAt.getPivotY();
                            if (pivotX != ShadowDrawableWrapper.COS_45 || pivotY != ShadowDrawableWrapper.COS_45) {
                                C0445T2.C0450e c0450e2 = c0446a.f1460e;
                                c0450e2.f1545g = pivotX;
                                c0450e2.f1546h = pivotY;
                            }
                            c0446a.f1460e.f1547i = childAt.getTranslationX();
                            c0446a.f1460e.f1548j = childAt.getTranslationY();
                            c0446a.f1460e.f1549k = childAt.getTranslationZ();
                            C0445T2.C0450e c0450e3 = c0446a.f1460e;
                            if (c0450e3.f1550l) {
                                c0450e3.f1551m = childAt.getElevation();
                            }
                        }
                    }
                }
                return;
            }
        }
    }

    /* renamed from: n */
    public void m1129n(boolean z) {
        C1853h2 c1853h2;
        this.f3764p = z;
        C0984b c0984b = this.f3751c;
        if (c0984b == null || (c1853h2 = c0984b.f3779l) == null) {
            return;
        }
        c1853h2.m784b(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r2 != (-1)) goto L9;
     */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1128o(int r8, int r9) {
        /*
            r7 = this;
            X2 r0 = r7.f3750b
            r1 = -1
            if (r0 == 0) goto L16
            int r0 = r0.m1812a(r8, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r8
        Ld:
            X2 r2 = r7.f3750b
            int r2 = r2.m1812a(r9, r1, r1)
            if (r2 == r1) goto L17
            goto L18
        L16:
            r0 = r8
        L17:
            r2 = r9
        L18:
            java.util.ArrayList<c2$b> r3 = r7.f3752d
            java.util.Iterator r3 = r3.iterator()
        L1e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            java.lang.Object r4 = r3.next()
            c2$b r4 = (p000.C0982c2.C0984b) r4
            int r5 = r4.f3770c
            if (r5 != r2) goto L32
            int r6 = r4.f3771d
            if (r6 == r0) goto L38
        L32:
            if (r5 != r9) goto L1e
            int r5 = r4.f3771d
            if (r5 != r8) goto L1e
        L38:
            r7.f3751c = r4
            h2 r8 = r4.f3779l
            if (r8 == 0) goto L43
            boolean r9 = r7.f3764p
            r8.m784b(r9)
        L43:
            return
        L44:
            c2$b r8 = r7.f3753e
            java.util.ArrayList<c2$b> r3 = r7.f3754f
            java.util.Iterator r3 = r3.iterator()
        L4c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r3.next()
            c2$b r4 = (p000.C0982c2.C0984b) r4
            int r5 = r4.f3770c
            if (r5 != r9) goto L4c
            r8 = r4
            goto L4c
        L5e:
            c2$b r9 = new c2$b
            r9.<init>(r7, r8)
            r9.f3771d = r0
            r9.f3770c = r2
            if (r0 == r1) goto L6e
            java.util.ArrayList<c2$b> r8 = r7.f3752d
            r8.add(r9)
        L6e:
            r7.f3751c = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0982c2.m1128o(int, int):void");
    }

    /* renamed from: p */
    public boolean m1127p() {
        Iterator<C0984b> it = this.f3752d.iterator();
        while (it.hasNext()) {
            if (it.next().f3779l != null) {
                return true;
            }
        }
        C0984b c0984b = this.f3751c;
        return (c0984b == null || c0984b.f3779l == null) ? false : true;
    }

    /* renamed from: c2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0984b {

        /* renamed from: a */
        public int f3768a;

        /* renamed from: b */
        public boolean f3769b;

        /* renamed from: c */
        public int f3770c;

        /* renamed from: d */
        public int f3771d;

        /* renamed from: e */
        public int f3772e;

        /* renamed from: f */
        public String f3773f;

        /* renamed from: g */
        public int f3774g;

        /* renamed from: h */
        public int f3775h;

        /* renamed from: i */
        public float f3776i;

        /* renamed from: j */
        public final C0982c2 f3777j;

        /* renamed from: k */
        public ArrayList<C0444T1> f3778k;

        /* renamed from: l */
        public C1853h2 f3779l;

        /* renamed from: m */
        public ArrayList<View$OnClickListenerC0985a> f3780m;

        /* renamed from: n */
        public int f3781n;

        /* renamed from: o */
        public boolean f3782o;

        /* renamed from: p */
        public int f3783p;

        /* renamed from: q */
        public int f3784q;

        /* renamed from: r */
        public int f3785r;

        /* renamed from: c2$b$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class View$OnClickListenerC0985a implements View.OnClickListener {

            /* renamed from: a */
            public final C0984b f3786a;

            /* renamed from: b */
            public int f3787b;

            /* renamed from: c */
            public int f3788c;

            public View$OnClickListenerC0985a(Context context, C0984b c0984b, XmlPullParser xmlPullParser) {
                this.f3787b = -1;
                this.f3788c = 17;
                this.f3786a = c0984b;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == C0533W2.OnClick_targetId) {
                        this.f3787b = obtainStyledAttributes.getResourceId(index, this.f3787b);
                    } else if (index == C0533W2.OnClick_clickAction) {
                        this.f3788c = obtainStyledAttributes.getInt(index, this.f3788c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View] */
            /* renamed from: a */
            public void m1126a(MotionLayout motionLayout, int i, C0984b c0984b) {
                int i2 = this.f3787b;
                MotionLayout motionLayout2 = motionLayout;
                if (i2 != -1) {
                    motionLayout2 = motionLayout.findViewById(i2);
                }
                if (motionLayout2 == null) {
                    StringBuilder m253r = outline.m253r("OnClick could not find id ");
                    m253r.append(this.f3787b);
                    Log.e("MotionScene", m253r.toString());
                    return;
                }
                int i3 = c0984b.f3771d;
                int i4 = c0984b.f3770c;
                if (i3 == -1) {
                    motionLayout2.setOnClickListener(this);
                    return;
                }
                int i5 = this.f3788c;
                int i6 = i5 & 1;
                boolean z = false;
                boolean z2 = (i6 != 0 && i == i3) | (i6 != 0 && i == i3) | ((i5 & 256) != 0 && i == i3) | ((i5 & 16) != 0 && i == i4);
                if ((i5 & 4096) != 0 && i == i4) {
                    z = true;
                }
                if (z2 || z) {
                    motionLayout2.setOnClickListener(this);
                }
            }

            /* renamed from: b */
            public void m1125b(MotionLayout motionLayout) {
                int i = this.f3787b;
                if (i == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i);
                if (findViewById == null) {
                    StringBuilder m253r = outline.m253r(" (*)  could not find id ");
                    m253r.append(this.f3787b);
                    Log.e("MotionScene", m253r.toString());
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            /* JADX WARN: Removed duplicated region for block: B:54:0x0087  */
            /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r10) {
                /*
                    Method dump skipped, instructions count: 195
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: p000.C0982c2.C0984b.View$OnClickListenerC0985a.onClick(android.view.View):void");
            }
        }

        public C0984b(C0982c2 c0982c2, C0984b c0984b) {
            this.f3768a = -1;
            this.f3769b = false;
            this.f3770c = -1;
            this.f3771d = -1;
            this.f3772e = 0;
            this.f3773f = null;
            this.f3774g = -1;
            this.f3775h = 400;
            this.f3776i = 0.0f;
            this.f3778k = new ArrayList<>();
            this.f3779l = null;
            this.f3780m = new ArrayList<>();
            this.f3781n = 0;
            this.f3782o = false;
            this.f3783p = -1;
            this.f3784q = 0;
            this.f3785r = 0;
            this.f3777j = c0982c2;
            if (c0984b != null) {
                this.f3783p = c0984b.f3783p;
                this.f3772e = c0984b.f3772e;
                this.f3773f = c0984b.f3773f;
                this.f3774g = c0984b.f3774g;
                this.f3775h = c0984b.f3775h;
                this.f3778k = c0984b.f3778k;
                this.f3776i = c0984b.f3776i;
                this.f3784q = c0984b.f3784q;
            }
        }

        public C0984b(C0982c2 c0982c2, Context context, XmlPullParser xmlPullParser) {
            this.f3768a = -1;
            this.f3769b = false;
            this.f3770c = -1;
            this.f3771d = -1;
            this.f3772e = 0;
            this.f3773f = null;
            this.f3774g = -1;
            this.f3775h = 400;
            this.f3776i = 0.0f;
            this.f3778k = new ArrayList<>();
            this.f3779l = null;
            this.f3780m = new ArrayList<>();
            this.f3781n = 0;
            this.f3782o = false;
            this.f3783p = -1;
            this.f3784q = 0;
            this.f3785r = 0;
            this.f3775h = c0982c2.f3758j;
            this.f3784q = c0982c2.f3759k;
            this.f3777j = c0982c2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.Transition);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.Transition_constraintSetEnd) {
                    this.f3770c = obtainStyledAttributes.getResourceId(index, this.f3770c);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f3770c))) {
                        C0445T2 c0445t2 = new C0445T2();
                        c0445t2.m2024i(context, this.f3770c);
                        c0982c2.f3755g.append(this.f3770c, c0445t2);
                    }
                } else if (index == C0533W2.Transition_constraintSetStart) {
                    this.f3771d = obtainStyledAttributes.getResourceId(index, this.f3771d);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f3771d))) {
                        C0445T2 c0445t22 = new C0445T2();
                        c0445t22.m2024i(context, this.f3771d);
                        c0982c2.f3755g.append(this.f3771d, c0445t22);
                    }
                } else if (index == C0533W2.Transition_motionInterpolator) {
                    int i2 = obtainStyledAttributes.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.f3774g = resourceId;
                        if (resourceId != -1) {
                            this.f3772e = -2;
                        }
                    } else if (i2 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f3773f = string;
                        if (string.indexOf("/") > 0) {
                            this.f3774g = obtainStyledAttributes.getResourceId(index, -1);
                            this.f3772e = -2;
                        } else {
                            this.f3772e = -1;
                        }
                    } else {
                        this.f3772e = obtainStyledAttributes.getInteger(index, this.f3772e);
                    }
                } else if (index == C0533W2.Transition_duration) {
                    this.f3775h = obtainStyledAttributes.getInt(index, this.f3775h);
                } else if (index == C0533W2.Transition_staggered) {
                    this.f3776i = obtainStyledAttributes.getFloat(index, this.f3776i);
                } else if (index == C0533W2.Transition_autoTransition) {
                    this.f3781n = obtainStyledAttributes.getInteger(index, this.f3781n);
                } else if (index == C0533W2.Transition_android_id) {
                    this.f3768a = obtainStyledAttributes.getResourceId(index, this.f3768a);
                } else if (index == C0533W2.Transition_transitionDisable) {
                    this.f3782o = obtainStyledAttributes.getBoolean(index, this.f3782o);
                } else if (index == C0533W2.Transition_pathMotionArc) {
                    this.f3783p = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == C0533W2.Transition_layoutDuringTransition) {
                    this.f3784q = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == C0533W2.Transition_transitionFlags) {
                    this.f3785r = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.f3771d == -1) {
                this.f3769b = true;
            }
            obtainStyledAttributes.recycle();
        }
    }
}
