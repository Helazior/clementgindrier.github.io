package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Layer extends ConstraintHelper {

    /* renamed from: i */
    public float f2661i;

    /* renamed from: j */
    public float f2662j;

    /* renamed from: k */
    public float f2663k;

    /* renamed from: l */
    public ConstraintLayout f2664l;

    /* renamed from: m */
    public float f2665m;

    /* renamed from: n */
    public float f2666n;

    /* renamed from: o */
    public float f2667o;

    /* renamed from: p */
    public float f2668p;

    /* renamed from: q */
    public float f2669q;

    /* renamed from: r */
    public float f2670r;

    /* renamed from: s */
    public float f2671s;

    /* renamed from: t */
    public float f2672t;

    /* renamed from: u */
    public boolean f2673u;

    /* renamed from: v */
    public View[] f2674v;

    /* renamed from: w */
    public float f2675w;

    /* renamed from: x */
    public float f2676x;

    /* renamed from: y */
    public boolean f2677y;

    /* renamed from: z */
    public boolean f2678z;

    public Layer(Context context) {
        super(context);
        this.f2661i = Float.NaN;
        this.f2662j = Float.NaN;
        this.f2663k = Float.NaN;
        this.f2665m = 1.0f;
        this.f2666n = 1.0f;
        this.f2667o = Float.NaN;
        this.f2668p = Float.NaN;
        this.f2669q = Float.NaN;
        this.f2670r = Float.NaN;
        this.f2671s = Float.NaN;
        this.f2672t = Float.NaN;
        this.f2673u = true;
        this.f2674v = null;
        this.f2675w = 0.0f;
        this.f2676x = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: l */
    public void mo1519l(AttributeSet attributeSet) {
        super.mo1519l(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ConstraintLayout_Layout_android_visibility) {
                    this.f2677y = true;
                } else if (index == C0533W2.ConstraintLayout_Layout_android_elevation) {
                    this.f2678z = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2664l = (ConstraintLayout) getParent();
        if (this.f2677y || this.f2678z) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.f2834b; i++) {
                View viewById = this.f2664l.getViewById(this.f2833a[i]);
                if (viewById != null) {
                    if (this.f2677y) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f2678z && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: p */
    public void mo1522p(ConstraintLayout constraintLayout) {
        m1581v();
        this.f2667o = Float.NaN;
        this.f2668p = Float.NaN;
        C2248t2 c2248t2 = ((ConstraintLayout.LayoutParams) getLayoutParams()).f2889l0;
        c2248t2.m370S(0);
        c2248t2.m375N(0);
        m1582u();
        layout(((int) this.f2671s) - getPaddingLeft(), ((int) this.f2672t) - getPaddingTop(), getPaddingRight() + ((int) this.f2669q), getPaddingBottom() + ((int) this.f2670r));
        m1580w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: r */
    public void mo1529r(ConstraintLayout constraintLayout) {
        this.f2664l = constraintLayout;
        float rotation = getRotation();
        if (rotation == 0.0f) {
            if (Float.isNaN(this.f2663k)) {
                return;
            }
            this.f2663k = rotation;
            return;
        }
        this.f2663k = rotation;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        m1538g();
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.f2661i = f;
        m1580w();
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.f2662j = f;
        m1580w();
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.f2663k = f;
        m1580w();
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.f2665m = f;
        m1580w();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        this.f2666n = f;
        m1580w();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        this.f2675w = f;
        m1580w();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        this.f2676x = f;
        m1580w();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        m1538g();
    }

    /* renamed from: u */
    public void m1582u() {
        if (this.f2664l == null) {
            return;
        }
        if (this.f2673u || Float.isNaN(this.f2667o) || Float.isNaN(this.f2668p)) {
            if (!Float.isNaN(this.f2661i) && !Float.isNaN(this.f2662j)) {
                this.f2668p = this.f2662j;
                this.f2667o = this.f2661i;
                return;
            }
            View[] m1534k = m1534k(this.f2664l);
            int left = m1534k[0].getLeft();
            int top = m1534k[0].getTop();
            int right = m1534k[0].getRight();
            int bottom = m1534k[0].getBottom();
            for (int i = 0; i < this.f2834b; i++) {
                View view = m1534k[i];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f2669q = right;
            this.f2670r = bottom;
            this.f2671s = left;
            this.f2672t = top;
            if (Float.isNaN(this.f2661i)) {
                this.f2667o = (left + right) / 2;
            } else {
                this.f2667o = this.f2661i;
            }
            if (Float.isNaN(this.f2662j)) {
                this.f2668p = (top + bottom) / 2;
            } else {
                this.f2668p = this.f2662j;
            }
        }
    }

    /* renamed from: v */
    public final void m1581v() {
        int i;
        if (this.f2664l == null || (i = this.f2834b) == 0) {
            return;
        }
        View[] viewArr = this.f2674v;
        if (viewArr == null || viewArr.length != i) {
            this.f2674v = new View[i];
        }
        for (int i2 = 0; i2 < this.f2834b; i2++) {
            this.f2674v[i2] = this.f2664l.getViewById(this.f2833a[i2]);
        }
    }

    /* renamed from: w */
    public final void m1580w() {
        if (this.f2664l == null) {
            return;
        }
        if (this.f2674v == null) {
            m1581v();
        }
        m1582u();
        double radians = Float.isNaN(this.f2663k) ? ShadowDrawableWrapper.COS_45 : Math.toRadians(this.f2663k);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f = this.f2665m;
        float f2 = f * cos;
        float f3 = this.f2666n;
        float f4 = (-f3) * sin;
        float f5 = f * sin;
        float f6 = f3 * cos;
        for (int i = 0; i < this.f2834b; i++) {
            View view = this.f2674v[i];
            int left = view.getLeft();
            int top = view.getTop();
            float right = ((view.getRight() + left) / 2) - this.f2667o;
            float bottom = ((view.getBottom() + top) / 2) - this.f2668p;
            view.setTranslationX((((f4 * bottom) + (f2 * right)) - right) + this.f2675w);
            view.setTranslationY((((f6 * bottom) + (right * f5)) - bottom) + this.f2676x);
            view.setScaleY(this.f2666n);
            view.setScaleX(this.f2665m);
            if (!Float.isNaN(this.f2663k)) {
                view.setRotation(this.f2663k);
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2661i = Float.NaN;
        this.f2662j = Float.NaN;
        this.f2663k = Float.NaN;
        this.f2665m = 1.0f;
        this.f2666n = 1.0f;
        this.f2667o = Float.NaN;
        this.f2668p = Float.NaN;
        this.f2669q = Float.NaN;
        this.f2670r = Float.NaN;
        this.f2671s = Float.NaN;
        this.f2672t = Float.NaN;
        this.f2673u = true;
        this.f2674v = null;
        this.f2675w = 0.0f;
        this.f2676x = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2661i = Float.NaN;
        this.f2662j = Float.NaN;
        this.f2663k = Float.NaN;
        this.f2665m = 1.0f;
        this.f2666n = 1.0f;
        this.f2667o = Float.NaN;
        this.f2668p = Float.NaN;
        this.f2669q = Float.NaN;
        this.f2670r = Float.NaN;
        this.f2671s = Float.NaN;
        this.f2672t = Float.NaN;
        this.f2673u = true;
        this.f2674v = null;
        this.f2675w = 0.0f;
        this.f2676x = 0.0f;
    }
}
