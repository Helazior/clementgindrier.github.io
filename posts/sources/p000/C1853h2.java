package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import org.xmlpull.p019v1.XmlPullParser;

/* renamed from: h2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1853h2 {

    /* renamed from: v */
    public static final float[][] f5114v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: w */
    public static final float[][] f5115w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: a */
    public int f5116a;

    /* renamed from: b */
    public int f5117b;

    /* renamed from: c */
    public int f5118c;

    /* renamed from: d */
    public int f5119d;

    /* renamed from: e */
    public int f5120e;

    /* renamed from: f */
    public int f5121f;

    /* renamed from: g */
    public float f5122g;

    /* renamed from: h */
    public float f5123h;

    /* renamed from: i */
    public float f5124i;

    /* renamed from: j */
    public float f5125j;

    /* renamed from: k */
    public boolean f5126k = false;

    /* renamed from: l */
    public float[] f5127l = new float[2];

    /* renamed from: m */
    public float f5128m;

    /* renamed from: n */
    public float f5129n;

    /* renamed from: o */
    public final MotionLayout f5130o;

    /* renamed from: p */
    public float f5131p;

    /* renamed from: q */
    public float f5132q;

    /* renamed from: r */
    public boolean f5133r;

    /* renamed from: s */
    public float f5134s;

    /* renamed from: t */
    public int f5135t;

    /* renamed from: u */
    public float f5136u;

    public C1853h2(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f5116a = 0;
        this.f5117b = 0;
        this.f5118c = 0;
        this.f5119d = -1;
        this.f5120e = -1;
        this.f5121f = -1;
        this.f5122g = 0.5f;
        this.f5123h = 0.5f;
        this.f5124i = 0.0f;
        this.f5125j = 1.0f;
        this.f5131p = 4.0f;
        this.f5132q = 1.2f;
        this.f5133r = true;
        this.f5134s = 1.0f;
        this.f5135t = 0;
        this.f5136u = 10.0f;
        this.f5130o = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0533W2.OnSwipe_touchAnchorId) {
                this.f5119d = obtainStyledAttributes.getResourceId(index, this.f5119d);
            } else if (index == C0533W2.OnSwipe_touchAnchorSide) {
                int i2 = obtainStyledAttributes.getInt(index, this.f5116a);
                this.f5116a = i2;
                float[][] fArr = f5114v;
                this.f5123h = fArr[i2][0];
                this.f5122g = fArr[i2][1];
            } else if (index == C0533W2.OnSwipe_dragDirection) {
                int i3 = obtainStyledAttributes.getInt(index, this.f5117b);
                this.f5117b = i3;
                float[][] fArr2 = f5115w;
                this.f5124i = fArr2[i3][0];
                this.f5125j = fArr2[i3][1];
            } else if (index == C0533W2.OnSwipe_maxVelocity) {
                this.f5131p = obtainStyledAttributes.getFloat(index, this.f5131p);
            } else if (index == C0533W2.OnSwipe_maxAcceleration) {
                this.f5132q = obtainStyledAttributes.getFloat(index, this.f5132q);
            } else if (index == C0533W2.OnSwipe_moveWhenScrollAtTop) {
                this.f5133r = obtainStyledAttributes.getBoolean(index, this.f5133r);
            } else if (index == C0533W2.OnSwipe_dragScale) {
                this.f5134s = obtainStyledAttributes.getFloat(index, this.f5134s);
            } else if (index == C0533W2.OnSwipe_dragThreshold) {
                this.f5136u = obtainStyledAttributes.getFloat(index, this.f5136u);
            } else if (index == C0533W2.OnSwipe_touchRegionId) {
                this.f5120e = obtainStyledAttributes.getResourceId(index, this.f5120e);
            } else if (index == C0533W2.OnSwipe_onTouchUp) {
                this.f5118c = obtainStyledAttributes.getInt(index, this.f5118c);
            } else if (index == C0533W2.OnSwipe_nestedScrollFlags) {
                this.f5135t = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == C0533W2.OnSwipe_limitBoundsTo) {
                this.f5121f = obtainStyledAttributes.getResourceId(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public RectF m785a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.f5120e;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* renamed from: b */
    public void m784b(boolean z) {
        if (z) {
            float[][] fArr = f5115w;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = f5114v;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f5115w;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = f5114v;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = f5114v;
        int i = this.f5116a;
        this.f5123h = fArr5[i][0];
        this.f5122g = fArr5[i][1];
        float[][] fArr6 = f5115w;
        int i2 = this.f5117b;
        this.f5124i = fArr6[i2][0];
        this.f5125j = fArr6[i2][1];
    }

    public String toString() {
        return this.f5124i + " , " + this.f5125j;
    }
}
