package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: X1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0548X1 extends AbstractC0328O1 {

    /* renamed from: q */
    public Method f1969q;

    /* renamed from: r */
    public Method f1970r;

    /* renamed from: s */
    public Method f1971s;

    /* renamed from: t */
    public float f1972t;

    /* renamed from: e */
    public String f1957e = null;

    /* renamed from: f */
    public int f1958f = -1;

    /* renamed from: g */
    public String f1959g = null;

    /* renamed from: h */
    public String f1960h = null;

    /* renamed from: i */
    public int f1961i = -1;

    /* renamed from: j */
    public int f1962j = -1;

    /* renamed from: k */
    public View f1963k = null;

    /* renamed from: l */
    public float f1964l = 0.1f;

    /* renamed from: m */
    public boolean f1965m = true;

    /* renamed from: n */
    public boolean f1966n = true;

    /* renamed from: o */
    public boolean f1967o = true;

    /* renamed from: p */
    public float f1968p = Float.NaN;

    /* renamed from: u */
    public boolean f1973u = false;

    /* renamed from: v */
    public RectF f1974v = new RectF();

    /* renamed from: w */
    public RectF f1975w = new RectF();

    /* renamed from: X1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0549a {

        /* renamed from: a */
        public static SparseIntArray f1976a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1976a = sparseIntArray;
            sparseIntArray.append(C0533W2.KeyTrigger_framePosition, 8);
            f1976a.append(C0533W2.KeyTrigger_onCross, 4);
            f1976a.append(C0533W2.KeyTrigger_onNegativeCross, 1);
            f1976a.append(C0533W2.KeyTrigger_onPositiveCross, 2);
            f1976a.append(C0533W2.KeyTrigger_motionTarget, 7);
            f1976a.append(C0533W2.KeyTrigger_triggerId, 6);
            f1976a.append(C0533W2.KeyTrigger_triggerSlack, 5);
            f1976a.append(C0533W2.KeyTrigger_motion_triggerOnCollision, 9);
            f1976a.append(C0533W2.KeyTrigger_motion_postLayoutCollision, 10);
            f1976a.append(C0533W2.KeyTrigger_triggerReceiver, 11);
        }
    }

    public C0548X1() {
        this.f1116d = new HashMap<>();
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: a */
    public void mo1816a(HashMap<String, AbstractC1599d2> hashMap) {
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: b */
    public void mo1815b(HashSet<String> hashSet) {
    }

    @Override // p000.AbstractC0328O1
    /* renamed from: c */
    public void mo1814c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.KeyTrigger);
        SparseIntArray sparseIntArray = C0549a.f1976a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            switch (C0549a.f1976a.get(index)) {
                case 1:
                    this.f1959g = obtainStyledAttributes.getString(index);
                    continue;
                case 2:
                    this.f1960h = obtainStyledAttributes.getString(index);
                    continue;
                case 4:
                    this.f1957e = obtainStyledAttributes.getString(index);
                    continue;
                case 5:
                    this.f1964l = obtainStyledAttributes.getFloat(index, this.f1964l);
                    continue;
                case 6:
                    this.f1961i = obtainStyledAttributes.getResourceId(index, this.f1961i);
                    continue;
                case 7:
                    if (MotionLayout.f2682l0) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1114b);
                        this.f1114b = resourceId;
                        if (resourceId == -1) {
                            this.f1115c = obtainStyledAttributes.getString(index);
                        } else {
                            continue;
                        }
                    } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f1115c = obtainStyledAttributes.getString(index);
                    } else {
                        this.f1114b = obtainStyledAttributes.getResourceId(index, this.f1114b);
                    }
                case 8:
                    int integer = obtainStyledAttributes.getInteger(index, this.f1113a);
                    this.f1113a = integer;
                    this.f1968p = (integer + 0.5f) / 100.0f;
                    continue;
                case 9:
                    this.f1962j = obtainStyledAttributes.getResourceId(index, this.f1962j);
                    continue;
                case 10:
                    this.f1973u = obtainStyledAttributes.getBoolean(index, this.f1973u);
                    continue;
                case 11:
                    this.f1958f = obtainStyledAttributes.getResourceId(index, this.f1958f);
                    break;
            }
            StringBuilder m253r = outline.m253r("unused attribute 0x");
            m253r.append(Integer.toHexString(index));
            m253r.append("   ");
            m253r.append(C0549a.f1976a.get(index));
            Log.e("KeyTrigger", m253r.toString());
        }
    }

    /* renamed from: e */
    public final void m1813e(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }
}
