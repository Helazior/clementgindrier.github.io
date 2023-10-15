package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a */
    public C0445T2 f2913a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* renamed from: a */
    public final void m1523a() {
        Log.v("Constraints", " ################# init");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1523a();
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1523a();
        super.setVisibility(8);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {

        /* renamed from: m0 */
        public float f2914m0;

        /* renamed from: n0 */
        public boolean f2915n0;

        /* renamed from: o0 */
        public float f2916o0;

        /* renamed from: p0 */
        public float f2917p0;

        /* renamed from: q0 */
        public float f2918q0;

        /* renamed from: r0 */
        public float f2919r0;

        /* renamed from: s0 */
        public float f2920s0;

        /* renamed from: t0 */
        public float f2921t0;

        /* renamed from: u0 */
        public float f2922u0;

        /* renamed from: v0 */
        public float f2923v0;

        /* renamed from: w0 */
        public float f2924w0;

        /* renamed from: x0 */
        public float f2925x0;

        /* renamed from: y0 */
        public float f2926y0;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2914m0 = 1.0f;
            this.f2915n0 = false;
            this.f2916o0 = 0.0f;
            this.f2917p0 = 0.0f;
            this.f2918q0 = 0.0f;
            this.f2919r0 = 0.0f;
            this.f2920s0 = 1.0f;
            this.f2921t0 = 1.0f;
            this.f2922u0 = 0.0f;
            this.f2923v0 = 0.0f;
            this.f2924w0 = 0.0f;
            this.f2925x0 = 0.0f;
            this.f2926y0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2914m0 = 1.0f;
            this.f2915n0 = false;
            this.f2916o0 = 0.0f;
            this.f2917p0 = 0.0f;
            this.f2918q0 = 0.0f;
            this.f2919r0 = 0.0f;
            this.f2920s0 = 1.0f;
            this.f2921t0 = 1.0f;
            this.f2922u0 = 0.0f;
            this.f2923v0 = 0.0f;
            this.f2924w0 = 0.0f;
            this.f2925x0 = 0.0f;
            this.f2926y0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ConstraintSet_android_alpha) {
                    this.f2914m0 = obtainStyledAttributes.getFloat(index, this.f2914m0);
                } else if (index == C0533W2.ConstraintSet_android_elevation) {
                    this.f2916o0 = obtainStyledAttributes.getFloat(index, this.f2916o0);
                    this.f2915n0 = true;
                } else if (index == C0533W2.ConstraintSet_android_rotationX) {
                    this.f2918q0 = obtainStyledAttributes.getFloat(index, this.f2918q0);
                } else if (index == C0533W2.ConstraintSet_android_rotationY) {
                    this.f2919r0 = obtainStyledAttributes.getFloat(index, this.f2919r0);
                } else if (index == C0533W2.ConstraintSet_android_rotation) {
                    this.f2917p0 = obtainStyledAttributes.getFloat(index, this.f2917p0);
                } else if (index == C0533W2.ConstraintSet_android_scaleX) {
                    this.f2920s0 = obtainStyledAttributes.getFloat(index, this.f2920s0);
                } else if (index == C0533W2.ConstraintSet_android_scaleY) {
                    this.f2921t0 = obtainStyledAttributes.getFloat(index, this.f2921t0);
                } else if (index == C0533W2.ConstraintSet_android_transformPivotX) {
                    this.f2922u0 = obtainStyledAttributes.getFloat(index, this.f2922u0);
                } else if (index == C0533W2.ConstraintSet_android_transformPivotY) {
                    this.f2923v0 = obtainStyledAttributes.getFloat(index, this.f2923v0);
                } else if (index == C0533W2.ConstraintSet_android_translationX) {
                    this.f2924w0 = obtainStyledAttributes.getFloat(index, this.f2924w0);
                } else if (index == C0533W2.ConstraintSet_android_translationY) {
                    this.f2925x0 = obtainStyledAttributes.getFloat(index, this.f2925x0);
                } else if (index == C0533W2.ConstraintSet_android_translationZ) {
                    this.f2926y0 = obtainStyledAttributes.getFloat(index, this.f2926y0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
