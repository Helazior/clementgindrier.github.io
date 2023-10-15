package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4 = this.fabDiameter;
        if (f4 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f5 = ((this.fabMargin * 2.0f) + f4) / 2.0f;
        float f6 = f3 * this.roundedCornerRadius;
        float f7 = f2 + this.horizontalOffset;
        float m270a = outline.m270a(1.0f, f3, f5, this.cradleVerticalOffset * f3);
        if (m270a / f5 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f8 = f5 + f6;
        float f9 = m270a + f6;
        float sqrt = (float) Math.sqrt((f8 * f8) - (f9 * f9));
        float f10 = f7 - sqrt;
        float f11 = f7 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f9));
        float f12 = 90.0f - degrees;
        shapePath.lineTo(f10, 0.0f);
        float f13 = f6 * 2.0f;
        shapePath.addArc(f10 - f6, 0.0f, f10 + f6, f13, 270.0f, degrees);
        shapePath.addArc(f7 - f5, (-f5) - m270a, f7 + f5, f5 - m270a, 180.0f - f12, (f12 * 2.0f) - 180.0f);
        shapePath.addArc(f11 - f6, 0.0f, f11 + f6, f13, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(float f) {
        if (f >= 0.0f) {
            this.cradleVerticalOffset = f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
