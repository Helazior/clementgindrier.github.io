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

/* renamed from: P1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0346P1 extends AbstractC0328O1 {

    /* renamed from: e */
    public int f1163e = -1;

    /* renamed from: f */
    public float f1164f = Float.NaN;

    /* renamed from: g */
    public float f1165g = Float.NaN;

    /* renamed from: h */
    public float f1166h = Float.NaN;

    /* renamed from: i */
    public float f1167i = Float.NaN;

    /* renamed from: j */
    public float f1168j = Float.NaN;

    /* renamed from: k */
    public float f1169k = Float.NaN;

    /* renamed from: l */
    public float f1170l = Float.NaN;

    /* renamed from: m */
    public float f1171m = Float.NaN;

    /* renamed from: n */
    public float f1172n = Float.NaN;

    /* renamed from: o */
    public float f1173o = Float.NaN;

    /* renamed from: p */
    public float f1174p = Float.NaN;

    /* renamed from: q */
    public float f1175q = Float.NaN;

    /* renamed from: r */
    public float f1176r = Float.NaN;

    /* renamed from: s */
    public float f1177s = Float.NaN;

    /* renamed from: P1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0347a {

        /* renamed from: a */
        public static SparseIntArray f1178a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1178a = sparseIntArray;
            sparseIntArray.append(C0533W2.KeyAttribute_android_alpha, 1);
            f1178a.append(C0533W2.KeyAttribute_android_elevation, 2);
            f1178a.append(C0533W2.KeyAttribute_android_rotation, 4);
            f1178a.append(C0533W2.KeyAttribute_android_rotationX, 5);
            f1178a.append(C0533W2.KeyAttribute_android_rotationY, 6);
            f1178a.append(C0533W2.KeyAttribute_android_transformPivotX, 19);
            f1178a.append(C0533W2.KeyAttribute_android_transformPivotY, 20);
            f1178a.append(C0533W2.KeyAttribute_android_scaleX, 7);
            f1178a.append(C0533W2.KeyAttribute_transitionPathRotate, 8);
            f1178a.append(C0533W2.KeyAttribute_transitionEasing, 9);
            f1178a.append(C0533W2.KeyAttribute_motionTarget, 10);
            f1178a.append(C0533W2.KeyAttribute_framePosition, 12);
            f1178a.append(C0533W2.KeyAttribute_curveFit, 13);
            f1178a.append(C0533W2.KeyAttribute_android_scaleY, 14);
            f1178a.append(C0533W2.KeyAttribute_android_translationX, 15);
            f1178a.append(C0533W2.KeyAttribute_android_translationY, 16);
            f1178a.append(C0533W2.KeyAttribute_android_translationZ, 17);
            f1178a.append(C0533W2.KeyAttribute_motionProgress, 18);
        }
    }

    public C0346P1() {
        this.f1116d = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
        if (r1.equals("scaleY") == false) goto L153;
     */
    @Override // p000.AbstractC0328O1
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1816a(java.util.HashMap<java.lang.String, p000.AbstractC1599d2> r6) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0346P1.mo1816a(java.util.HashMap):void");
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: b */
    public void mo1815b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1164f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1165g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1166h)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1167i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1168j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1169k)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f1170l)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f1174p)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1175q)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1176r)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f1171m)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1172n)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1173o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1177s)) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.KeyAttribute);
        SparseIntArray sparseIntArray = C0347a.f1178a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            switch (C0347a.f1178a.get(index)) {
                case 1:
                    this.f1164f = obtainStyledAttributes.getFloat(index, this.f1164f);
                    break;
                case 2:
                    this.f1165g = obtainStyledAttributes.getDimension(index, this.f1165g);
                    break;
                case 3:
                case 11:
                default:
                    StringBuilder m253r = outline.m253r("unused attribute 0x");
                    m253r.append(Integer.toHexString(index));
                    m253r.append("   ");
                    m253r.append(C0347a.f1178a.get(index));
                    Log.e("KeyAttribute", m253r.toString());
                    break;
                case 4:
                    this.f1166h = obtainStyledAttributes.getFloat(index, this.f1166h);
                    break;
                case 5:
                    this.f1167i = obtainStyledAttributes.getFloat(index, this.f1167i);
                    break;
                case 6:
                    this.f1168j = obtainStyledAttributes.getFloat(index, this.f1168j);
                    break;
                case 7:
                    this.f1172n = obtainStyledAttributes.getFloat(index, this.f1172n);
                    break;
                case 8:
                    this.f1171m = obtainStyledAttributes.getFloat(index, this.f1171m);
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
                    this.f1163e = obtainStyledAttributes.getInteger(index, this.f1163e);
                    break;
                case 14:
                    this.f1173o = obtainStyledAttributes.getFloat(index, this.f1173o);
                    break;
                case 15:
                    this.f1174p = obtainStyledAttributes.getDimension(index, this.f1174p);
                    break;
                case 16:
                    this.f1175q = obtainStyledAttributes.getDimension(index, this.f1175q);
                    break;
                case 17:
                    this.f1176r = obtainStyledAttributes.getDimension(index, this.f1176r);
                    break;
                case 18:
                    this.f1177s = obtainStyledAttributes.getFloat(index, this.f1177s);
                    break;
                case 19:
                    this.f1169k = obtainStyledAttributes.getDimension(index, this.f1169k);
                    break;
                case 20:
                    this.f1170l = obtainStyledAttributes.getDimension(index, this.f1170l);
                    break;
            }
        }
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: d */
    public void mo1821d(HashMap<String, Integer> hashMap) {
        if (this.f1163e == -1) {
            return;
        }
        if (!Float.isNaN(this.f1164f)) {
            hashMap.put("alpha", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1165g)) {
            hashMap.put("elevation", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1166h)) {
            hashMap.put("rotation", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1167i)) {
            hashMap.put("rotationX", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1168j)) {
            hashMap.put("rotationY", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1169k)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1170l)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1174p)) {
            hashMap.put("translationX", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1175q)) {
            hashMap.put("translationY", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1176r)) {
            hashMap.put("translationZ", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1171m)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1172n)) {
            hashMap.put("scaleX", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1173o)) {
            hashMap.put("scaleY", Integer.valueOf(this.f1163e));
        }
        if (!Float.isNaN(this.f1177s)) {
            hashMap.put("progress", Integer.valueOf(this.f1163e));
        }
        if (this.f1116d.size() > 0) {
            for (String str : this.f1116d.keySet()) {
                hashMap.put(outline.m266e("CUSTOM,", str), Integer.valueOf(this.f1163e));
            }
        }
    }
}
