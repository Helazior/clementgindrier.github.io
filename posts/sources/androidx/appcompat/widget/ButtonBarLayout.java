package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a */
    public boolean f2497a;

    /* renamed from: b */
    public int f2498b;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2498b = -1;
        int[] iArr = C2012o.ButtonBarLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        C0492V4.m1951t(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f2497a = obtainStyledAttributes.getBoolean(C2012o.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final int m1622a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: b */
    public final boolean m1621b() {
        return getOrientation() == 1;
    }

    /* renamed from: c */
    public final void m1620c(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C1930k.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(0, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.f2497a) {
            if (size > this.f2498b && m1621b()) {
                m1620c(false);
            }
            this.f2498b = size;
        }
        if (m1621b() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f2497a && !m1621b()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                m1620c(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int m1622a = m1622a(0);
        if (m1622a >= 0) {
            View childAt = getChildAt(m1622a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (m1621b()) {
                int m1622a2 = m1622a(m1622a + 1);
                i4 = m1622a2 >= 0 ? getChildAt(m1622a2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                i4 = getPaddingBottom() + measuredHeight;
            }
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0495c.m1940d(this) != i4) {
            setMinimumHeight(i4);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f2497a != z) {
            this.f2497a = z;
            if (!z && getOrientation() == 1) {
                m1620c(false);
            }
            requestLayout();
        }
    }
}
