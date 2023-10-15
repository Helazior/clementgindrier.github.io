package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import p000.C0445T2;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: i */
    public int f2830i;

    /* renamed from: j */
    public int f2831j;

    /* renamed from: k */
    public C2189q2 f2832k;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: l */
    public void mo1519l(AttributeSet attributeSet) {
        super.mo1519l(attributeSet);
        this.f2832k = new C2189q2();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == C0533W2.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2832k.f6258L0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == C0533W2.ConstraintLayout_Layout_barrierMargin) {
                    this.f2832k.f6259M0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2836d = this.f2832k;
        m1527t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: m */
    public void mo1533m(C0445T2.C0446a c0446a, C2363y2 c2363y2, ConstraintLayout.LayoutParams layoutParams, SparseArray<C2248t2> sparseArray) {
        super.mo1533m(c0446a, c2363y2, layoutParams, sparseArray);
        if (c2363y2 instanceof C2189q2) {
            C2189q2 c2189q2 = (C2189q2) c2363y2;
            m1541u(c2189q2, c0446a.f1459d.f1492b0, ((C2269u2) c2363y2.f6474S).f6608M0);
            C0445T2.C0447b c0447b = c0446a.f1459d;
            c2189q2.f6258L0 = c0447b.f1508j0;
            c2189q2.f6259M0 = c0447b.f1494c0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: n */
    public void mo1532n(C2248t2 c2248t2, boolean z) {
        m1541u(c2248t2, this.f2830i, z);
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2832k.f6258L0 = z;
    }

    public void setDpMargin(int i) {
        this.f2832k.f6259M0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.f2832k.f6259M0 = i;
    }

    public void setType(int i) {
        this.f2830i = i;
    }

    /* renamed from: u */
    public final void m1541u(C2248t2 c2248t2, int i, boolean z) {
        this.f2831j = i;
        if (z) {
            int i2 = this.f2830i;
            if (i2 == 5) {
                this.f2831j = 1;
            } else if (i2 == 6) {
                this.f2831j = 0;
            }
        } else {
            int i3 = this.f2830i;
            if (i3 == 5) {
                this.f2831j = 0;
            } else if (i3 == 6) {
                this.f2831j = 1;
            }
        }
        if (c2248t2 instanceof C2189q2) {
            ((C2189q2) c2248t2).f6257K0 = this.f2831j;
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }
}
