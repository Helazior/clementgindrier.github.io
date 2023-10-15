package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: i */
    public boolean f2930i;

    /* renamed from: j */
    public boolean f2931j;

    public VirtualLayout(Context context) {
        super(context);
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
                    this.f2930i = true;
                } else if (index == C0533W2.ConstraintLayout_Layout_android_elevation) {
                    this.f2931j = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f2930i || this.f2931j) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.f2834b; i++) {
                View viewById = constraintLayout.getViewById(this.f2833a[i]);
                if (viewById != null) {
                    if (this.f2930i) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f2931j && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        m1538g();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        m1538g();
    }

    /* renamed from: u */
    public void mo1518u(C0016A2 c0016a2, int i, int i2) {
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
