package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import p000.C0445T2;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: k */
    public C2287v2 f2660k;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: l */
    public void mo1519l(AttributeSet attributeSet) {
        super.mo1519l(attributeSet);
        this.f2660k = new C2287v2();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ConstraintLayout_Layout_android_orientation) {
                    this.f2660k.f6669n1 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_padding) {
                    C2287v2 c2287v2 = this.f2660k;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c2287v2.f114K0 = dimensionPixelSize;
                    c2287v2.f115L0 = dimensionPixelSize;
                    c2287v2.f116M0 = dimensionPixelSize;
                    c2287v2.f117N0 = dimensionPixelSize;
                } else if (index == C0533W2.ConstraintLayout_Layout_android_paddingStart) {
                    C2287v2 c2287v22 = this.f2660k;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c2287v22.f116M0 = dimensionPixelSize2;
                    c2287v22.f118O0 = dimensionPixelSize2;
                    c2287v22.f119P0 = dimensionPixelSize2;
                } else if (index == C0533W2.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f2660k.f117N0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f2660k.f118O0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_paddingTop) {
                    this.f2660k.f114K0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_paddingRight) {
                    this.f2660k.f119P0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f2660k.f115L0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f2660k.f6667l1 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f2660k.f6651V0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f2660k.f6652W0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f2660k.f6653X0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f2660k.f6655Z0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f2660k.f6654Y0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f2660k.f6656a1 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f2660k.f6657b1 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f2660k.f6659d1 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f2660k.f6661f1 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f2660k.f6660e1 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f2660k.f6662g1 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f2660k.f6658c1 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f2660k.f6665j1 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f2660k.f6666k1 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f2660k.f6663h1 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f2660k.f6664i1 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == C0533W2.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f2660k.f6668m1 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2836d = this.f2660k;
        m1527t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: m */
    public void mo1533m(C0445T2.C0446a c0446a, C2363y2 c2363y2, ConstraintLayout.LayoutParams layoutParams, SparseArray<C2248t2> sparseArray) {
        super.mo1533m(c0446a, c2363y2, layoutParams, sparseArray);
        if (c2363y2 instanceof C2287v2) {
            C2287v2 c2287v2 = (C2287v2) c2363y2;
            int i = layoutParams.f2857R;
            if (i != -1) {
                c2287v2.f6669n1 = i;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: n */
    public void mo1532n(C2248t2 c2248t2, boolean z) {
        C2287v2 c2287v2 = this.f2660k;
        int i = c2287v2.f116M0;
        if (i > 0 || c2287v2.f117N0 > 0) {
            if (z) {
                c2287v2.f118O0 = c2287v2.f117N0;
                c2287v2.f119P0 = i;
                return;
            }
            c2287v2.f118O0 = i;
            c2287v2.f119P0 = c2287v2.f117N0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        mo1518u(this.f2660k, i, i2);
    }

    public void setFirstHorizontalBias(float f) {
        this.f2660k.f6659d1 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.f2660k.f6653X0 = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.f2660k.f6660e1 = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.f2660k.f6654Y0 = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.f2660k.f6665j1 = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.f2660k.f6657b1 = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.f2660k.f6663h1 = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.f2660k.f6651V0 = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.f2660k.f6668m1 = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.f2660k.f6669n1 = i;
        requestLayout();
    }

    public void setPadding(int i) {
        C2287v2 c2287v2 = this.f2660k;
        c2287v2.f114K0 = i;
        c2287v2.f115L0 = i;
        c2287v2.f116M0 = i;
        c2287v2.f117N0 = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.f2660k.f115L0 = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.f2660k.f118O0 = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.f2660k.f119P0 = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.f2660k.f114K0 = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.f2660k.f6666k1 = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.f2660k.f6658c1 = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.f2660k.f6664i1 = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.f2660k.f6652W0 = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.f2660k.f6667l1 = i;
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    /* renamed from: u */
    public void mo1518u(C0016A2 c0016a2, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (c0016a2 != null) {
            c0016a2.mo290X(mode, size, mode2, size2);
            setMeasuredDimension(c0016a2.f121R0, c0016a2.f122S0);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
