package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: m */
    public Paint f2823m;

    /* renamed from: n */
    public MotionLayout f2824n;

    /* renamed from: o */
    public float[] f2825o;

    /* renamed from: p */
    public Matrix f2826p;

    /* renamed from: q */
    public int f2827q;

    /* renamed from: r */
    public int f2828r;

    /* renamed from: s */
    public float f2829s;

    public MotionTelltales(Context context) {
        super(context);
        this.f2823m = new Paint();
        this.f2825o = new float[2];
        this.f2826p = new Matrix();
        this.f2827q = 0;
        this.f2828r = -65281;
        this.f2829s = 0.25f;
        m1542a(context, null);
    }

    /* renamed from: a */
    private void m1542a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.MotionTelltales_telltales_tailColor) {
                    this.f2828r = obtainStyledAttributes.getColor(index, this.f2828r);
                } else if (index == C0533W2.MotionTelltales_telltales_velocityMode) {
                    this.f2827q = obtainStyledAttributes.getInt(index, this.f2827q);
                } else if (index == C0533W2.MotionTelltales_telltales_tailScale) {
                    this.f2829s = obtainStyledAttributes.getFloat(index, this.f2829s);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2823m.setColor(this.f2828r);
        this.f2823m.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        float f;
        float[] fArr;
        int i3;
        int i4;
        float[] fArr2;
        int i5;
        AbstractC1599d2 abstractC1599d2;
        int i6;
        AbstractC1599d2 abstractC1599d22;
        AbstractC1599d2 abstractC1599d23;
        AbstractC1599d2 abstractC1599d24;
        double[] dArr;
        int i7;
        float[] fArr3;
        float f2;
        C0307N1 c0307n1;
        float f3;
        int i8;
        MotionTelltales motionTelltales = this;
        super.onDraw(canvas);
        getMatrix().invert(motionTelltales.f2826p);
        if (motionTelltales.f2824n == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.f2824n = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i9 = 5;
        float[] fArr4 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i10 = 0;
        while (i10 < i9) {
            float f4 = fArr4[i10];
            int i11 = 0;
            while (i11 < i9) {
                float f5 = fArr4[i11];
                MotionLayout motionLayout = motionTelltales.f2824n;
                float[] fArr5 = motionTelltales.f2825o;
                int i12 = motionTelltales.f2827q;
                float f6 = motionLayout.f2710c;
                float f7 = motionLayout.f2730o;
                if (motionLayout.f2708b != null) {
                    float signum = Math.signum(motionLayout.f2732q - f7);
                    float interpolation = motionLayout.f2708b.getInterpolation(motionLayout.f2730o + 1.0E-5f);
                    float interpolation2 = motionLayout.f2708b.getInterpolation(motionLayout.f2730o);
                    f6 = (((interpolation - interpolation2) / 1.0E-5f) * signum) / motionLayout.f2728m;
                    f7 = interpolation2;
                }
                Interpolator interpolator = motionLayout.f2708b;
                if (interpolator instanceof AbstractanimationInterpolatorC0606a2) {
                    f6 = ((AbstractanimationInterpolatorC0606a2) interpolator).mo1565a();
                }
                float f8 = f6;
                C0585Z1 c0585z1 = motionLayout.f2725k.get(motionTelltales);
                if ((i12 & 1) == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float m1754a = c0585z1.m1754a(f7, c0585z1.f2092u);
                    HashMap<String, AbstractC1599d2> hashMap = c0585z1.f2095x;
                    AbstractC1599d2 abstractC1599d25 = hashMap == null ? null : hashMap.get("translationX");
                    HashMap<String, AbstractC1599d2> hashMap2 = c0585z1.f2095x;
                    fArr = fArr4;
                    if (hashMap2 == null) {
                        i6 = i12;
                        abstractC1599d2 = null;
                    } else {
                        abstractC1599d2 = hashMap2.get("translationY");
                        i6 = i12;
                    }
                    HashMap<String, AbstractC1599d2> hashMap3 = c0585z1.f2095x;
                    i3 = i10;
                    if (hashMap3 == null) {
                        i5 = i11;
                        abstractC1599d22 = null;
                    } else {
                        abstractC1599d22 = hashMap3.get("rotation");
                        i5 = i11;
                    }
                    HashMap<String, AbstractC1599d2> hashMap4 = c0585z1.f2095x;
                    i2 = height;
                    if (hashMap4 == null) {
                        i = width;
                        abstractC1599d23 = null;
                    } else {
                        abstractC1599d23 = hashMap4.get("scaleX");
                        i = width;
                    }
                    HashMap<String, AbstractC1599d2> hashMap5 = c0585z1.f2095x;
                    if (hashMap5 == null) {
                        f = f8;
                        abstractC1599d24 = null;
                    } else {
                        abstractC1599d24 = hashMap5.get("scaleY");
                        f = f8;
                    }
                    HashMap<String, AbstractC0410S1> hashMap6 = c0585z1.f2096y;
                    AbstractC0410S1 abstractC0410S1 = hashMap6 == null ? null : hashMap6.get("translationX");
                    HashMap<String, AbstractC0410S1> hashMap7 = c0585z1.f2096y;
                    AbstractC0410S1 abstractC0410S12 = hashMap7 == null ? null : hashMap7.get("translationY");
                    HashMap<String, AbstractC0410S1> hashMap8 = c0585z1.f2096y;
                    AbstractC0410S1 abstractC0410S13 = hashMap8 == null ? null : hashMap8.get("rotation");
                    HashMap<String, AbstractC0410S1> hashMap9 = c0585z1.f2096y;
                    AbstractC0410S1 abstractC0410S14 = hashMap9 == null ? null : hashMap9.get("scaleX");
                    HashMap<String, AbstractC0410S1> hashMap10 = c0585z1.f2096y;
                    AbstractC0410S1 abstractC0410S15 = hashMap10 == null ? null : hashMap10.get("scaleY");
                    C0307N1 c0307n12 = new C0307N1();
                    c0307n12.f1018e = 0.0f;
                    c0307n12.f1017d = 0.0f;
                    c0307n12.f1016c = 0.0f;
                    c0307n12.f1015b = 0.0f;
                    c0307n12.f1014a = 0.0f;
                    c0307n12.m2183b(abstractC1599d22, m1754a);
                    c0307n12.m2180e(abstractC1599d25, abstractC1599d2, m1754a);
                    c0307n12.m2181d(abstractC1599d23, abstractC1599d24, m1754a);
                    if (abstractC0410S13 != null) {
                        c0307n12.f1018e = abstractC0410S13.m2043b(m1754a);
                    }
                    if (abstractC0410S1 != null) {
                        c0307n12.f1016c = abstractC0410S1.m2043b(m1754a);
                    }
                    if (abstractC0410S12 != null) {
                        c0307n12.f1017d = abstractC0410S12.m2043b(m1754a);
                    }
                    c0307n12.m2182c(abstractC0410S14, abstractC0410S15, m1754a);
                    AbstractC0166H1 abstractC0166H1 = c0585z1.f2080i;
                    if (abstractC0166H1 != null) {
                        double[] dArr2 = c0585z1.f2085n;
                        if (dArr2.length > 0) {
                            double d = m1754a;
                            abstractC0166H1.mo2354c(d, dArr2);
                            c0585z1.f2080i.mo2351f(d, c0585z1.f2086o);
                            c0307n1 = c0307n12;
                            i8 = i6;
                            fArr3 = fArr5;
                            f3 = f5;
                            c0585z1.f2075d.m1191e(f5, f4, fArr5, c0585z1.f2084m, c0585z1.f2086o, c0585z1.f2085n);
                        } else {
                            c0307n1 = c0307n12;
                            f3 = f5;
                            fArr3 = fArr5;
                            i8 = i6;
                        }
                        c0307n1.m2184a(f3, f4, width2, height2, fArr3);
                        i7 = i8;
                        f2 = f3;
                    } else if (c0585z1.f2079h != null) {
                        double m1754a2 = c0585z1.m1754a(m1754a, c0585z1.f2092u);
                        c0585z1.f2079h[0].mo2351f(m1754a2, c0585z1.f2086o);
                        c0585z1.f2079h[0].mo2354c(m1754a2, c0585z1.f2085n);
                        float f9 = c0585z1.f2092u[0];
                        int i13 = 0;
                        while (true) {
                            dArr = c0585z1.f2086o;
                            if (i13 >= dArr.length) {
                                break;
                            }
                            dArr[i13] = dArr[i13] * f9;
                            i13++;
                        }
                        i7 = i6;
                        fArr3 = fArr5;
                        f2 = f5;
                        c0585z1.f2075d.m1191e(f5, f4, fArr5, c0585z1.f2084m, dArr, c0585z1.f2085n);
                        c0307n12.m2184a(f2, f4, width2, height2, fArr3);
                    } else {
                        C0955b2 c0955b2 = c0585z1.f2076e;
                        AbstractC0410S1 abstractC0410S16 = abstractC0410S15;
                        float f10 = c0955b2.f3667f;
                        C0955b2 c0955b22 = c0585z1.f2075d;
                        AbstractC0410S1 abstractC0410S17 = abstractC0410S14;
                        float f11 = f10 - c0955b22.f3667f;
                        AbstractC0410S1 abstractC0410S18 = abstractC0410S12;
                        float f12 = c0955b2.f3668g - c0955b22.f3668g;
                        AbstractC0410S1 abstractC0410S19 = abstractC0410S1;
                        fArr5[0] = (((c0955b2.f3669h - c0955b22.f3669h) + f11) * f5) + ((1.0f - f5) * f11);
                        fArr5[1] = (((c0955b2.f3670i - c0955b22.f3670i) + f12) * f4) + ((1.0f - f4) * f12);
                        c0307n12.f1018e = 0.0f;
                        c0307n12.f1017d = 0.0f;
                        c0307n12.f1016c = 0.0f;
                        c0307n12.f1015b = 0.0f;
                        c0307n12.f1014a = 0.0f;
                        c0307n12.m2183b(abstractC1599d22, m1754a);
                        c0307n12.m2180e(abstractC1599d25, abstractC1599d2, m1754a);
                        c0307n12.m2181d(abstractC1599d23, abstractC1599d24, m1754a);
                        if (abstractC0410S13 != null) {
                            c0307n12.f1018e = abstractC0410S13.m2043b(m1754a);
                        }
                        if (abstractC0410S19 != null) {
                            c0307n12.f1016c = abstractC0410S19.m2043b(m1754a);
                        }
                        if (abstractC0410S18 != null) {
                            c0307n12.f1017d = abstractC0410S18.m2043b(m1754a);
                        }
                        c0307n12.m2182c(abstractC0410S17, abstractC0410S16, m1754a);
                        i4 = i6;
                        fArr2 = fArr5;
                        c0307n12.m2184a(f5, f4, width2, height2, fArr5);
                    }
                    i4 = i7;
                    f5 = f2;
                    fArr2 = fArr3;
                } else {
                    i = width;
                    i2 = height;
                    f = f8;
                    fArr = fArr4;
                    i3 = i10;
                    i4 = i12;
                    fArr2 = fArr5;
                    i5 = i11;
                    c0585z1.m1753b(f7, f5, f4, fArr2);
                }
                if (i4 < 2) {
                    fArr2[0] = fArr2[0] * f;
                    fArr2[1] = fArr2[1] * f;
                }
                motionTelltales = this;
                motionTelltales.f2826p.mapVectors(motionTelltales.f2825o);
                width = i;
                float f13 = width * f5;
                height = i2;
                float f14 = height * f4;
                float[] fArr6 = motionTelltales.f2825o;
                float f15 = fArr6[0];
                float f16 = motionTelltales.f2829s;
                float f17 = f14 - (fArr6[1] * f16);
                motionTelltales.f2826p.mapVectors(fArr6);
                canvas.drawLine(f13, f14, f13 - (f15 * f16), f17, motionTelltales.f2823m);
                i11 = i5 + 1;
                fArr4 = fArr;
                i10 = i3;
                i9 = 5;
            }
            i10++;
            i9 = 5;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f2817g = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2823m = new Paint();
        this.f2825o = new float[2];
        this.f2826p = new Matrix();
        this.f2827q = 0;
        this.f2828r = -65281;
        this.f2829s = 0.25f;
        m1542a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2823m = new Paint();
        this.f2825o = new float[2];
        this.f2826p = new Matrix();
        this.f2827q = 0;
        this.f2828r = -65281;
        this.f2829s = 0.25f;
        m1542a(context, attributeSet);
    }
}
