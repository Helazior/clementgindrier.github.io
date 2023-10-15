package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* renamed from: U1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0466U1 extends AbstractC0489V1 {

    /* renamed from: f */
    public String f1622f = null;

    /* renamed from: g */
    public int f1623g = -1;

    /* renamed from: h */
    public int f1624h = 0;

    /* renamed from: i */
    public float f1625i = Float.NaN;

    /* renamed from: j */
    public float f1626j = Float.NaN;

    /* renamed from: k */
    public float f1627k = Float.NaN;

    /* renamed from: l */
    public float f1628l = Float.NaN;

    /* renamed from: m */
    public int f1629m = 0;

    /* renamed from: U1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0467a {

        /* renamed from: a */
        public static SparseIntArray f1630a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1630a = sparseIntArray;
            sparseIntArray.append(C0533W2.KeyPosition_motionTarget, 1);
            f1630a.append(C0533W2.KeyPosition_framePosition, 2);
            f1630a.append(C0533W2.KeyPosition_transitionEasing, 3);
            f1630a.append(C0533W2.KeyPosition_curveFit, 4);
            f1630a.append(C0533W2.KeyPosition_drawPath, 5);
            f1630a.append(C0533W2.KeyPosition_percentX, 6);
            f1630a.append(C0533W2.KeyPosition_percentY, 7);
            f1630a.append(C0533W2.KeyPosition_keyPositionType, 9);
            f1630a.append(C0533W2.KeyPosition_sizePercent, 8);
            f1630a.append(C0533W2.KeyPosition_percentWidth, 11);
            f1630a.append(C0533W2.KeyPosition_percentHeight, 12);
            f1630a.append(C0533W2.KeyPosition_pathMotionArc, 10);
        }
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: a */
    public void mo1816a(HashMap<String, AbstractC1599d2> hashMap) {
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: c */
    public void mo1814c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.KeyPosition);
        SparseIntArray sparseIntArray = C0467a.f1630a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            switch (C0467a.f1630a.get(index)) {
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
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f1622f = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f1622f = C0191I1.f625c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    this.f1791e = obtainStyledAttributes.getInteger(index, this.f1791e);
                    break;
                case 5:
                    this.f1624h = obtainStyledAttributes.getInt(index, this.f1624h);
                    break;
                case 6:
                    this.f1627k = obtainStyledAttributes.getFloat(index, this.f1627k);
                    break;
                case 7:
                    this.f1628l = obtainStyledAttributes.getFloat(index, this.f1628l);
                    break;
                case 8:
                    float f = obtainStyledAttributes.getFloat(index, this.f1626j);
                    this.f1625i = f;
                    this.f1626j = f;
                    break;
                case 9:
                    this.f1629m = obtainStyledAttributes.getInt(index, this.f1629m);
                    break;
                case 10:
                    this.f1623g = obtainStyledAttributes.getInt(index, this.f1623g);
                    break;
                case 11:
                    this.f1625i = obtainStyledAttributes.getFloat(index, this.f1625i);
                    break;
                case 12:
                    this.f1626j = obtainStyledAttributes.getFloat(index, this.f1626j);
                    break;
                default:
                    StringBuilder m253r = outline.m253r("unused attribute 0x");
                    m253r.append(Integer.toHexString(index));
                    m253r.append("   ");
                    m253r.append(C0467a.f1630a.get(index));
                    Log.e("KeyPosition", m253r.toString());
                    break;
            }
        }
        if (this.f1113a == -1) {
            Log.e("KeyPosition", "no frame position");
        }
    }
}
