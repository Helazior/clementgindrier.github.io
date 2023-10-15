package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.InterfaceC0712h {

    /* renamed from: i */
    public boolean f2679i;

    /* renamed from: j */
    public boolean f2680j;

    /* renamed from: k */
    public View[] f2681k;

    public MotionHelper(Context context) {
        super(context);
        this.f2679i = false;
        this.f2680j = false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0712h
    /* renamed from: a */
    public void mo1550a(MotionLayout motionLayout, int i, int i2, float f) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0712h
    /* renamed from: b */
    public void mo1549b(MotionLayout motionLayout, int i, int i2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0712h
    /* renamed from: c */
    public void mo1548c(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0712h
    /* renamed from: d */
    public void mo1547d(MotionLayout motionLayout, int i) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: l */
    public void mo1519l(AttributeSet attributeSet) {
        super.mo1519l(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.MotionHelper_onShow) {
                    this.f2679i = obtainStyledAttributes.getBoolean(index, this.f2679i);
                } else if (index == C0533W2.MotionHelper_onHide) {
                    this.f2680j = obtainStyledAttributes.getBoolean(index, this.f2680j);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f) {
        int i = 0;
        if (this.f2834b > 0) {
            this.f2681k = m1534k((ConstraintLayout) getParent());
            while (i < this.f2834b) {
                setProgress(this.f2681k[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f);
            }
            i++;
        }
    }

    public void setProgress(View view, float f) {
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2679i = false;
        this.f2680j = false;
        mo1519l(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2679i = false;
        this.f2680j = false;
        mo1519l(attributeSet);
    }
}
