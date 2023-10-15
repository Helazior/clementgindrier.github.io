package p000;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Objects;
import org.xmlpull.p019v1.XmlPullParser;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: e8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1661e8 {

    /* renamed from: e8$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1662a implements TypeEvaluator<C0194I3[]> {

        /* renamed from: a */
        public C0194I3[] f4143a;

        @Override // android.animation.TypeEvaluator
        public C0194I3[] evaluate(float f, C0194I3[] c0194i3Arr, C0194I3[] c0194i3Arr2) {
            C0194I3[] c0194i3Arr3 = c0194i3Arr;
            C0194I3[] c0194i3Arr4 = c0194i3Arr2;
            if (LayoutInflater$Factory2C0000A.C0010h.m2641f(c0194i3Arr3, c0194i3Arr4)) {
                if (!LayoutInflater$Factory2C0000A.C0010h.m2641f(this.f4143a, c0194i3Arr3)) {
                    this.f4143a = LayoutInflater$Factory2C0000A.C0010h.m2611u(c0194i3Arr3);
                }
                for (int i = 0; i < c0194i3Arr3.length; i++) {
                    C0194I3 c0194i3 = this.f4143a[i];
                    C0194I3 c0194i32 = c0194i3Arr3[i];
                    C0194I3 c0194i33 = c0194i3Arr4[i];
                    Objects.requireNonNull(c0194i3);
                    c0194i3.f632a = c0194i32.f632a;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = c0194i32.f633b;
                        if (i2 < fArr.length) {
                            c0194i3.f633b[i2] = (c0194i33.f633b[i2] * f) + ((1.0f - f) * fArr[i2]);
                            i2++;
                        }
                    }
                }
                return this.f4143a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:0x034d, code lost:
        if (r26 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x034f, code lost:
        if (r13 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0351, code lost:
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0360, code lost:
        if (r2.hasNext() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0362, code lost:
        r1[r3] = (android.animation.Animator) r2.next();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x036e, code lost:
        if (r27 != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0370, code lost:
        r26.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0374, code lost:
        r26.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0377, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.animation.Animator m997a(android.content.Context r21, android.content.res.Resources r22, android.content.res.Resources.Theme r23, org.xmlpull.p019v1.XmlPullParser r24, android.util.AttributeSet r25, android.animation.AnimatorSet r26, int r27, float r28) {
        /*
            Method dump skipped, instructions count: 888
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1661e8.m997a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    /* renamed from: b */
    public static Keyframe m996b(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    /* renamed from: c */
    public static PropertyValuesHolder m995c(TypedArray typedArray, int i, int i2, int i3, String str) {
        int i4;
        PropertyValuesHolder ofInt;
        int i5;
        int i6;
        float f;
        float f2;
        float f3;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && m994d(i7)) || (z2 && m994d(i8))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            C0194I3[] m2615s = LayoutInflater$Factory2C0000A.C0010h.m2615s(string);
            C0194I3[] m2615s2 = LayoutInflater$Factory2C0000A.C0010h.m2615s(string2);
            if (m2615s == null && m2615s2 == null) {
                return null;
            }
            if (m2615s == null) {
                if (m2615s2 != null) {
                    return PropertyValuesHolder.ofObject(str, new C1662a(), m2615s2);
                }
                return null;
            }
            C1662a c1662a = new C1662a();
            if (m2615s2 != null) {
                if (LayoutInflater$Factory2C0000A.C0010h.m2641f(m2615s, m2615s2)) {
                    ofObject = PropertyValuesHolder.ofObject(str, c1662a, m2615s, m2615s2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
            } else {
                ofObject = PropertyValuesHolder.ofObject(str, c1662a, m2615s);
            }
            return ofObject;
        }
        C1682f8 c1682f8 = i == 3 ? C1682f8.f4181a : null;
        if (z3) {
            if (z) {
                if (i7 == 5) {
                    f2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    ofInt = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    ofInt = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i8 == 5) {
                    f = typedArray.getDimension(i3, 0.0f);
                } else {
                    f = typedArray.getFloat(i3, 0.0f);
                }
                ofInt = PropertyValuesHolder.ofFloat(str, f);
            }
        } else if (!z) {
            if (z2) {
                if (i8 == 5) {
                    i4 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m994d(i8)) {
                    i4 = typedArray.getColor(i3, 0);
                } else {
                    i4 = typedArray.getInt(i3, 0);
                }
                ofInt = PropertyValuesHolder.ofInt(str, i4);
            }
            if (propertyValuesHolder == null && c1682f8 != null) {
                propertyValuesHolder.setEvaluator(c1682f8);
                return propertyValuesHolder;
            }
        } else {
            if (i7 == 5) {
                i5 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (m994d(i7)) {
                i5 = typedArray.getColor(i2, 0);
            } else {
                i5 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m994d(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                ofInt = PropertyValuesHolder.ofInt(str, i5, i6);
            } else {
                ofInt = PropertyValuesHolder.ofInt(str, i5);
            }
        }
        propertyValuesHolder = ofInt;
        return propertyValuesHolder == null ? propertyValuesHolder : propertyValuesHolder;
    }

    /* renamed from: d */
    public static boolean m994d(int i) {
        return i >= 28 && i <= 31;
    }

    /* renamed from: e */
    public static ValueAnimator m993e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator2;
        TypedArray typedArray;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        TypedArray m2654X = LayoutInflater$Factory2C0000A.C0010h.m2654X(resources, theme, attributeSet, C0972b8.f3721g);
        TypedArray m2654X2 = LayoutInflater$Factory2C0000A.C0010h.m2654X(resources, theme, attributeSet, C0972b8.f3725k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        long j = LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "duration") ? m2654X.getInt(1, 300) : 300;
        int i = 0;
        long j2 = !LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "startOffset") ? 0 : m2654X.getInt(2, 0);
        int i2 = !LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "valueType") ? 4 : m2654X.getInt(7, 4);
        if (LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "valueFrom") && LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "valueTo")) {
            if (i2 == 4) {
                TypedValue peekValue = m2654X.peekValue(5);
                boolean z = peekValue != null;
                int i3 = z ? peekValue.type : 0;
                TypedValue peekValue2 = m2654X.peekValue(6);
                boolean z2 = peekValue2 != null;
                i2 = ((z && m994d(i3)) || (z2 && m994d(z2 ? peekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder m995c = m995c(m2654X, i2, 5, 6, "");
            if (m995c != null) {
                valueAnimator4.setValues(m995c);
            }
        }
        valueAnimator4.setDuration(j);
        valueAnimator4.setStartDelay(j2);
        valueAnimator4.setRepeatCount(!LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "repeatCount") ? 0 : m2654X.getInt(3, 0));
        valueAnimator4.setRepeatMode(!LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "repeatMode") ? 1 : m2654X.getInt(4, 1));
        if (m2654X2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String m2667K = LayoutInflater$Factory2C0000A.C0010h.m2667K(m2654X2, xmlPullParser, "pathData", 1);
            if (m2667K != null) {
                String m2667K2 = LayoutInflater$Factory2C0000A.C0010h.m2667K(m2654X2, xmlPullParser, "propertyXName", 2);
                String m2667K3 = LayoutInflater$Factory2C0000A.C0010h.m2667K(m2654X2, xmlPullParser, "propertyYName", 3);
                if (m2667K2 == null && m2667K3 == null) {
                    throw new InflateException(m2654X2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path m2613t = LayoutInflater$Factory2C0000A.C0010h.m2613t(m2667K);
                float f2 = 0.5f * f;
                PathMeasure pathMeasure = new PathMeasure(m2613t, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f3 = 0.0f;
                do {
                    f3 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f3));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(m2613t, false);
                int min = Math.min(100, ((int) (f3 / f2)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f4 = f3 / (min - 1);
                valueAnimator2 = valueAnimator4;
                typedArray = m2654X;
                int i4 = 0;
                float f5 = 0.0f;
                while (true) {
                    if (i >= min) {
                        break;
                    }
                    int i5 = min;
                    pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i4)).floatValue(), fArr3, null);
                    fArr[i] = fArr3[0];
                    fArr2[i] = fArr3[1];
                    f5 += f4;
                    int i6 = i4 + 1;
                    if (i6 < arrayList.size() && f5 > ((Float) arrayList.get(i6)).floatValue()) {
                        pathMeasure2.nextContour();
                        i4 = i6;
                    }
                    i++;
                    min = i5;
                }
                PropertyValuesHolder ofFloat = m2667K2 != null ? PropertyValuesHolder.ofFloat(m2667K2, fArr) : null;
                PropertyValuesHolder ofFloat2 = m2667K3 != null ? PropertyValuesHolder.ofFloat(m2667K3, fArr2) : null;
                if (ofFloat == null) {
                    i = 0;
                    objectAnimator.setValues(ofFloat2);
                } else {
                    i = 0;
                    if (ofFloat2 == null) {
                        objectAnimator.setValues(ofFloat);
                    } else {
                        objectAnimator.setValues(ofFloat, ofFloat2);
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = m2654X;
                objectAnimator.setPropertyName(LayoutInflater$Factory2C0000A.C0010h.m2667K(m2654X2, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = m2654X;
        }
        if (LayoutInflater$Factory2C0000A.C0010h.m2660R(xmlPullParser, "interpolator")) {
            typedArray2 = typedArray;
            i = typedArray2.getResourceId(i, i);
        } else {
            typedArray2 = typedArray;
        }
        if (i > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (m2654X2 != null) {
            m2654X2.recycle();
        }
        return valueAnimator3;
    }
}
