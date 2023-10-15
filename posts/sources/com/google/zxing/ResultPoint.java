package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ResultPoint {

    /* renamed from: x */
    private final float f3895x;

    /* renamed from: y */
    private final float f3896y;

    public ResultPoint(float f, float f2) {
        this.f3895x = f;
        this.f3896y = f2;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f3895x;
        float f2 = resultPoint2.f3896y;
        return ((resultPoint.f3896y - f2) * (resultPoint3.f3895x - f)) - ((resultPoint.f3895x - f) * (resultPoint3.f3896y - f2));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f3895x, resultPoint.f3896y, resultPoint2.f3895x, resultPoint2.f3896y);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (distance3 >= distance2 && distance3 >= distance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            return this.f3895x == resultPoint.f3895x && this.f3896y == resultPoint.f3896y;
        }
        return false;
    }

    public final float getX() {
        return this.f3895x;
    }

    public final float getY() {
        return this.f3896y;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f3896y) + (Float.floatToIntBits(this.f3895x) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f3895x);
        sb.append(',');
        sb.append(this.f3896y);
        sb.append(')');
        return sb.toString();
    }
}
