package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    public boolean f2334a;

    /* renamed from: b */
    public View f2335b;

    /* renamed from: c */
    public View f2336c;

    /* renamed from: d */
    public View f2337d;

    /* renamed from: f */
    public Drawable f2338f;

    /* renamed from: g */
    public Drawable f2339g;

    /* renamed from: h */
    public Drawable f2340h;

    /* renamed from: i */
    public boolean f2341i;

    /* renamed from: j */
    public boolean f2342j;

    /* renamed from: k */
    public int f2343k;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final int m1674a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: b */
    public final boolean m1673b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2338f;
        if (drawable != null && drawable.isStateful()) {
            this.f2338f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2339g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2339g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2340h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2340h.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2338f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2339g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2340h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2336c = findViewById(C1930k.action_bar);
        this.f2337d = findViewById(C1930k.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2334a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f2335b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            int i5 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - i5, i3, measuredHeight - i5);
        }
        if (this.f2341i) {
            Drawable drawable2 = this.f2340h;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f2338f != null) {
                if (this.f2336c.getVisibility() == 0) {
                    this.f2338f.setBounds(this.f2336c.getLeft(), this.f2336c.getTop(), this.f2336c.getRight(), this.f2336c.getBottom());
                } else {
                    View view2 = this.f2337d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f2338f.setBounds(this.f2337d.getLeft(), this.f2337d.getTop(), this.f2337d.getRight(), this.f2337d.getBottom());
                    } else {
                        this.f2338f.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.f2342j = z4;
            if (!z4 || (drawable = this.f2339g) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int m1674a;
        int i3;
        if (this.f2336c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.f2343k) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f2336c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f2335b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!m1673b(this.f2336c)) {
            m1674a = m1674a(this.f2336c);
        } else {
            m1674a = !m1673b(this.f2337d) ? m1674a(this.f2337d) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(m1674a(this.f2335b) + m1674a, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2338f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2338f);
        }
        this.f2338f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2336c;
            if (view != null) {
                this.f2338f.setBounds(view.getLeft(), this.f2336c.getTop(), this.f2336c.getRight(), this.f2336c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2341i ? this.f2338f != null || this.f2339g != null : this.f2340h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2340h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2340h);
        }
        this.f2340h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2341i && (drawable2 = this.f2340h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2341i ? !(this.f2338f != null || this.f2339g != null) : this.f2340h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2339g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2339g);
        }
        this.f2339g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2342j && (drawable2 = this.f2339g) != null) {
                drawable2.setBounds(this.f2335b.getLeft(), this.f2335b.getTop(), this.f2335b.getRight(), this.f2335b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2341i ? this.f2338f != null || this.f2339g != null : this.f2340h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2335b;
        if (view != null) {
            removeView(view);
        }
        this.f2335b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f2334a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f2338f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f2339g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f2340h;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2338f && !this.f2341i) || (drawable == this.f2339g && this.f2342j) || ((drawable == this.f2340h && this.f2341i) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C2338x0 c2338x0 = new C2338x0(this);
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1927q(this, c2338x0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.ActionBar);
        this.f2338f = obtainStyledAttributes.getDrawable(C2012o.ActionBar_background);
        this.f2339g = obtainStyledAttributes.getDrawable(C2012o.ActionBar_backgroundStacked);
        this.f2343k = obtainStyledAttributes.getDimensionPixelSize(C2012o.ActionBar_height, -1);
        boolean z = true;
        if (getId() == C1930k.split_action_bar) {
            this.f2341i = true;
            this.f2340h = obtainStyledAttributes.getDrawable(C2012o.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f2341i ? this.f2338f != null || this.f2339g != null : this.f2340h != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
