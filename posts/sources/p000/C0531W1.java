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

/* renamed from: W1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0531W1 extends AbstractC0328O1 {

    /* renamed from: e */
    public int f1873e = -1;

    /* renamed from: f */
    public float f1874f = Float.NaN;

    /* renamed from: g */
    public float f1875g = Float.NaN;

    /* renamed from: h */
    public float f1876h = Float.NaN;

    /* renamed from: i */
    public float f1877i = Float.NaN;

    /* renamed from: j */
    public float f1878j = Float.NaN;

    /* renamed from: k */
    public float f1879k = Float.NaN;

    /* renamed from: l */
    public float f1880l = Float.NaN;

    /* renamed from: m */
    public float f1881m = Float.NaN;

    /* renamed from: n */
    public float f1882n = Float.NaN;

    /* renamed from: o */
    public float f1883o = Float.NaN;

    /* renamed from: p */
    public float f1884p = Float.NaN;

    /* renamed from: q */
    public float f1885q = Float.NaN;

    /* renamed from: r */
    public int f1886r = 0;

    /* renamed from: s */
    public float f1887s = Float.NaN;

    /* renamed from: t */
    public float f1888t = 0.0f;

    /* renamed from: W1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0532a {

        /* renamed from: a */
        public static SparseIntArray f1889a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1889a = sparseIntArray;
            sparseIntArray.append(C0533W2.KeyTimeCycle_android_alpha, 1);
            f1889a.append(C0533W2.KeyTimeCycle_android_elevation, 2);
            f1889a.append(C0533W2.KeyTimeCycle_android_rotation, 4);
            f1889a.append(C0533W2.KeyTimeCycle_android_rotationX, 5);
            f1889a.append(C0533W2.KeyTimeCycle_android_rotationY, 6);
            f1889a.append(C0533W2.KeyTimeCycle_android_scaleX, 7);
            f1889a.append(C0533W2.KeyTimeCycle_transitionPathRotate, 8);
            f1889a.append(C0533W2.KeyTimeCycle_transitionEasing, 9);
            f1889a.append(C0533W2.KeyTimeCycle_motionTarget, 10);
            f1889a.append(C0533W2.KeyTimeCycle_framePosition, 12);
            f1889a.append(C0533W2.KeyTimeCycle_curveFit, 13);
            f1889a.append(C0533W2.KeyTimeCycle_android_scaleY, 14);
            f1889a.append(C0533W2.KeyTimeCycle_android_translationX, 15);
            f1889a.append(C0533W2.KeyTimeCycle_android_translationY, 16);
            f1889a.append(C0533W2.KeyTimeCycle_android_translationZ, 17);
            f1889a.append(C0533W2.KeyTimeCycle_motionProgress, 18);
            f1889a.append(C0533W2.KeyTimeCycle_wavePeriod, 20);
            f1889a.append(C0533W2.KeyTimeCycle_waveOffset, 21);
            f1889a.append(C0533W2.KeyTimeCycle_waveShape, 19);
        }
    }

    public C0531W1() {
        this.f1116d = new HashMap<>();
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: a */
    public void mo1816a(HashMap<String, AbstractC1599d2> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: b */
    public void mo1815b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1874f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1875g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1876h)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1877i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1878j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1882n)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1883o)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1884p)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f1879k)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1880l)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1881m)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1885q)) {
            hashSet.add("progress");
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.KeyTimeCycle);
        SparseIntArray sparseIntArray = C0532a.f1889a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            switch (C0532a.f1889a.get(index)) {
                case 1:
                    this.f1874f = obtainStyledAttributes.getFloat(index, this.f1874f);
                    break;
                case 2:
                    this.f1875g = obtainStyledAttributes.getDimension(index, this.f1875g);
                    break;
                case 3:
                case 11:
                default:
                    StringBuilder m253r = outline.m253r("unused attribute 0x");
                    m253r.append(Integer.toHexString(index));
                    m253r.append("   ");
                    m253r.append(C0532a.f1889a.get(index));
                    Log.e("KeyTimeCycle", m253r.toString());
                    break;
                case 4:
                    this.f1876h = obtainStyledAttributes.getFloat(index, this.f1876h);
                    break;
                case 5:
                    this.f1877i = obtainStyledAttributes.getFloat(index, this.f1877i);
                    break;
                case 6:
                    this.f1878j = obtainStyledAttributes.getFloat(index, this.f1878j);
                    break;
                case 7:
                    this.f1880l = obtainStyledAttributes.getFloat(index, this.f1880l);
                    break;
                case 8:
                    this.f1879k = obtainStyledAttributes.getFloat(index, this.f1879k);
                    break;
                case 9:
                    obtainStyledAttributes.getString(index);
                    break;
                case 10:
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
                case 12:
                    this.f1113a = obtainStyledAttributes.getInt(index, this.f1113a);
                    break;
                case 13:
                    this.f1873e = obtainStyledAttributes.getInteger(index, this.f1873e);
                    break;
                case 14:
                    this.f1881m = obtainStyledAttributes.getFloat(index, this.f1881m);
                    break;
                case 15:
                    this.f1882n = obtainStyledAttributes.getDimension(index, this.f1882n);
                    break;
                case 16:
                    this.f1883o = obtainStyledAttributes.getDimension(index, this.f1883o);
                    break;
                case 17:
                    this.f1884p = obtainStyledAttributes.getDimension(index, this.f1884p);
                    break;
                case 18:
                    this.f1885q = obtainStyledAttributes.getFloat(index, this.f1885q);
                    break;
                case 19:
                    this.f1886r = obtainStyledAttributes.getInt(index, this.f1886r);
                    break;
                case 20:
                    this.f1887s = obtainStyledAttributes.getFloat(index, this.f1887s);
                    break;
                case 21:
                    if (obtainStyledAttributes.peekValue(index).type == 5) {
                        this.f1888t = obtainStyledAttributes.getDimension(index, this.f1888t);
                        break;
                    } else {
                        this.f1888t = obtainStyledAttributes.getFloat(index, this.f1888t);
                        break;
                    }
            }
        }
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: d */
    public void mo1821d(HashMap<String, Integer> hashMap) {
        if (this.f1873e == -1) {
            return;
        }
        if (!Float.isNaN(this.f1874f)) {
            hashMap.put("alpha", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1875g)) {
            hashMap.put("elevation", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1876h)) {
            hashMap.put("rotation", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1877i)) {
            hashMap.put("rotationX", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1878j)) {
            hashMap.put("rotationY", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1882n)) {
            hashMap.put("translationX", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1883o)) {
            hashMap.put("translationY", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1884p)) {
            hashMap.put("translationZ", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1879k)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1880l)) {
            hashMap.put("scaleX", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1880l)) {
            hashMap.put("scaleY", Integer.valueOf(this.f1873e));
        }
        if (!Float.isNaN(this.f1885q)) {
            hashMap.put("progress", Integer.valueOf(this.f1873e));
        }
        if (this.f1116d.size() > 0) {
            for (String str : this.f1116d.keySet()) {
                hashMap.put(outline.m266e("CUSTOM,", str), Integer.valueOf(this.f1873e));
            }
        }
    }
}
