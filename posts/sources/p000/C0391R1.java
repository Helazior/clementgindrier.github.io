package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: R1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0391R1 extends AbstractC0328O1 {

    /* renamed from: e */
    public int f1305e = 0;

    /* renamed from: f */
    public int f1306f = -1;

    /* renamed from: g */
    public float f1307g = Float.NaN;

    /* renamed from: h */
    public float f1308h = 0.0f;

    /* renamed from: i */
    public float f1309i = Float.NaN;

    /* renamed from: j */
    public int f1310j = -1;

    /* renamed from: k */
    public float f1311k = Float.NaN;

    /* renamed from: l */
    public float f1312l = Float.NaN;

    /* renamed from: m */
    public float f1313m = Float.NaN;

    /* renamed from: n */
    public float f1314n = Float.NaN;

    /* renamed from: o */
    public float f1315o = Float.NaN;

    /* renamed from: p */
    public float f1316p = Float.NaN;

    /* renamed from: q */
    public float f1317q = Float.NaN;

    /* renamed from: r */
    public float f1318r = Float.NaN;

    /* renamed from: s */
    public float f1319s = Float.NaN;

    /* renamed from: t */
    public float f1320t = Float.NaN;

    /* renamed from: u */
    public float f1321u = Float.NaN;

    /* renamed from: R1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0392a {

        /* renamed from: a */
        public static SparseIntArray f1322a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1322a = sparseIntArray;
            sparseIntArray.append(C0533W2.KeyCycle_motionTarget, 1);
            f1322a.append(C0533W2.KeyCycle_framePosition, 2);
            f1322a.append(C0533W2.KeyCycle_transitionEasing, 3);
            f1322a.append(C0533W2.KeyCycle_curveFit, 4);
            f1322a.append(C0533W2.KeyCycle_waveShape, 5);
            f1322a.append(C0533W2.KeyCycle_wavePeriod, 6);
            f1322a.append(C0533W2.KeyCycle_waveOffset, 7);
            f1322a.append(C0533W2.KeyCycle_waveVariesBy, 8);
            f1322a.append(C0533W2.KeyCycle_android_alpha, 9);
            f1322a.append(C0533W2.KeyCycle_android_elevation, 10);
            f1322a.append(C0533W2.KeyCycle_android_rotation, 11);
            f1322a.append(C0533W2.KeyCycle_android_rotationX, 12);
            f1322a.append(C0533W2.KeyCycle_android_rotationY, 13);
            f1322a.append(C0533W2.KeyCycle_transitionPathRotate, 14);
            f1322a.append(C0533W2.KeyCycle_android_scaleX, 15);
            f1322a.append(C0533W2.KeyCycle_android_scaleY, 16);
            f1322a.append(C0533W2.KeyCycle_android_translationX, 17);
            f1322a.append(C0533W2.KeyCycle_android_translationY, 18);
            f1322a.append(C0533W2.KeyCycle_android_translationZ, 19);
            f1322a.append(C0533W2.KeyCycle_motionProgress, 20);
        }
    }

    public C0391R1() {
        this.f1116d = new HashMap<>();
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: a */
    public void mo1816a(HashMap<String, AbstractC1599d2> hashMap) {
        StringBuilder m253r = outline.m253r("add ");
        m253r.append(hashMap.size());
        m253r.append(" values");
        String sb = m253r.toString();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(2, stackTrace.length - 1);
        String str = " ";
        for (int i = 1; i <= min; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            StringBuilder m253r2 = outline.m253r(".(");
            m253r2.append(stackTrace[i].getFileName());
            m253r2.append(":");
            m253r2.append(stackTrace[i].getLineNumber());
            m253r2.append(") ");
            m253r2.append(stackTrace[i].getMethodName());
            String sb2 = m253r2.toString();
            str = outline.m266e(str, " ");
            Log.v("KeyCycle", sb + str + sb2 + str);
        }
        for (String str2 : hashMap.keySet()) {
            AbstractC1599d2 abstractC1599d2 = hashMap.get(str2);
            str2.hashCode();
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1249320806:
                    if (str2.equals("rotationX")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str2.equals("rotationY")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str2.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str2.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str2.equals("translationZ")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str2.equals("progress")) {
                        c = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str2.equals("scaleX")) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str2.equals("scaleY")) {
                        c = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (str2.equals("rotation")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -4379043:
                    if (str2.equals("elevation")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 37232917:
                    if (str2.equals("transitionPathRotate")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 92909918:
                    if (str2.equals("alpha")) {
                        c = 11;
                        break;
                    }
                    break;
                case 156108012:
                    if (str2.equals("waveOffset")) {
                        c = '\f';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1315o);
                    break;
                case 1:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1316p);
                    break;
                case 2:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1319s);
                    break;
                case 3:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1320t);
                    break;
                case 4:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1321u);
                    break;
                case 5:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1309i);
                    break;
                case 6:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1317q);
                    break;
                case 7:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1318r);
                    break;
                case '\b':
                    abstractC1599d2.mo1035b(this.f1113a, this.f1313m);
                    break;
                case '\t':
                    abstractC1599d2.mo1035b(this.f1113a, this.f1312l);
                    break;
                case '\n':
                    abstractC1599d2.mo1035b(this.f1113a, this.f1314n);
                    break;
                case 11:
                    abstractC1599d2.mo1035b(this.f1113a, this.f1311k);
                    break;
                case '\f':
                    abstractC1599d2.mo1035b(this.f1113a, this.f1308h);
                    break;
                default:
                    Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  " + str2);
                    break;
            }
        }
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: b */
    public void mo1815b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1311k)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1312l)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1313m)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1315o)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1316p)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1317q)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1318r)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1314n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1319s)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1320t)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1321u)) {
            hashSet.add("translationZ");
        }
        if (this.f1116d.size() > 0) {
            Iterator<String> it = this.f1116d.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: c */
    public void mo1814c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.KeyCycle);
        SparseIntArray sparseIntArray = C0392a.f1322a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            switch (C0392a.f1322a.get(index)) {
                case 1:
                    if (MotionLayout.f2682l0) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1114b);
                        this.f1114b = resourceId;
                        if (resourceId == -1) {
                            this.f1115c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f1115c = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f1114b = obtainStyledAttributes.getResourceId(index, this.f1114b);
                        break;
                    }
                case 2:
                    this.f1113a = obtainStyledAttributes.getInt(index, this.f1113a);
                    break;
                case 3:
                    obtainStyledAttributes.getString(index);
                    break;
                case 4:
                    this.f1305e = obtainStyledAttributes.getInteger(index, this.f1305e);
                    break;
                case 5:
                    this.f1306f = obtainStyledAttributes.getInt(index, this.f1306f);
                    break;
                case 6:
                    this.f1307g = obtainStyledAttributes.getFloat(index, this.f1307g);
                    break;
                case 7:
                    if (obtainStyledAttributes.peekValue(index).type == 5) {
                        this.f1308h = obtainStyledAttributes.getDimension(index, this.f1308h);
                        break;
                    } else {
                        this.f1308h = obtainStyledAttributes.getFloat(index, this.f1308h);
                        break;
                    }
                case 8:
                    this.f1310j = obtainStyledAttributes.getInt(index, this.f1310j);
                    break;
                case 9:
                    this.f1311k = obtainStyledAttributes.getFloat(index, this.f1311k);
                    break;
                case 10:
                    this.f1312l = obtainStyledAttributes.getDimension(index, this.f1312l);
                    break;
                case 11:
                    this.f1313m = obtainStyledAttributes.getFloat(index, this.f1313m);
                    break;
                case 12:
                    this.f1315o = obtainStyledAttributes.getFloat(index, this.f1315o);
                    break;
                case 13:
                    this.f1316p = obtainStyledAttributes.getFloat(index, this.f1316p);
                    break;
                case 14:
                    this.f1314n = obtainStyledAttributes.getFloat(index, this.f1314n);
                    break;
                case 15:
                    this.f1317q = obtainStyledAttributes.getFloat(index, this.f1317q);
                    break;
                case 16:
                    this.f1318r = obtainStyledAttributes.getFloat(index, this.f1318r);
                    break;
                case 17:
                    this.f1319s = obtainStyledAttributes.getDimension(index, this.f1319s);
                    break;
                case 18:
                    this.f1320t = obtainStyledAttributes.getDimension(index, this.f1320t);
                    break;
                case 19:
                    this.f1321u = obtainStyledAttributes.getDimension(index, this.f1321u);
                    break;
                case 20:
                    this.f1309i = obtainStyledAttributes.getFloat(index, this.f1309i);
                    break;
                default:
                    StringBuilder m253r = outline.m253r("unused attribute 0x");
                    m253r.append(Integer.toHexString(index));
                    m253r.append("   ");
                    m253r.append(C0392a.f1322a.get(index));
                    Log.e("KeyCycle", m253r.toString());
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
        if (r1.equals("scaleY") == false) goto L9;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2055e(java.util.HashMap<java.lang.String, p000.AbstractC0410S1> r13) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0391R1.m2055e(java.util.HashMap):void");
    }
}
