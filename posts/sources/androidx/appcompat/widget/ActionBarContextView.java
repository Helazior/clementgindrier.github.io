package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionBarContextView extends AbstractC2303w0 {

    /* renamed from: j */
    public CharSequence f2344j;

    /* renamed from: k */
    public CharSequence f2345k;

    /* renamed from: l */
    public View f2346l;

    /* renamed from: m */
    public View f2347m;

    /* renamed from: n */
    public LinearLayout f2348n;

    /* renamed from: o */
    public TextView f2349o;

    /* renamed from: p */
    public TextView f2350p;

    /* renamed from: q */
    public int f2351q;

    /* renamed from: r */
    public int f2352r;

    /* renamed from: s */
    public boolean f2353s;

    /* renamed from: t */
    public int f2354t;

    /* renamed from: androidx.appcompat.widget.ActionBarContextView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0637a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0485V f2355a;

        public View$OnClickListenerC0637a(ActionBarContextView actionBarContextView, AbstractC0485V abstractC0485V) {
            this.f2355a = abstractC0485V;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2355a.mo1792a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    /* renamed from: f */
    public void m1672f(AbstractC0485V abstractC0485V) {
        View view = this.f2346l;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f2354t, (ViewGroup) this, false);
            this.f2346l = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f2346l);
        }
        this.f2346l.findViewById(C1930k.action_mode_close_button).setOnClickListener(new View$OnClickListenerC0637a(this, abstractC0485V));
        C1905j0 c1905j0 = (C1905j0) abstractC0485V.mo1790c();
        ActionMenuPresenter actionMenuPresenter = this.f6726d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m1658a();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f6726d = actionMenuPresenter2;
        actionMenuPresenter2.f2395n = true;
        actionMenuPresenter2.f2396o = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c1905j0.addMenuPresenter(this.f6726d, this.f6724b);
        ActionMenuPresenter actionMenuPresenter3 = this.f6726d;
        InterfaceC2186q0 interfaceC2186q0 = actionMenuPresenter3.f4105i;
        if (interfaceC2186q0 == null) {
            InterfaceC2186q0 interfaceC2186q02 = (InterfaceC2186q0) actionMenuPresenter3.f4101d.inflate(actionMenuPresenter3.f4103g, (ViewGroup) this, false);
            actionMenuPresenter3.f4105i = interfaceC2186q02;
            interfaceC2186q02.initialize(actionMenuPresenter3.f4100c);
            actionMenuPresenter3.updateMenuView(true);
        }
        InterfaceC2186q0 interfaceC2186q03 = actionMenuPresenter3.f4105i;
        if (interfaceC2186q0 != interfaceC2186q03) {
            ((ActionMenuView) interfaceC2186q03).setPresenter(actionMenuPresenter3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) interfaceC2186q03;
        this.f6725c = actionMenuView;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1927q(actionMenuView, null);
        addView(this.f6725c, layoutParams);
    }

    /* renamed from: g */
    public final void m1671g() {
        if (this.f2348n == null) {
            LayoutInflater.from(getContext()).inflate(C1949l.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2348n = linearLayout;
            this.f2349o = (TextView) linearLayout.findViewById(C1930k.action_bar_title);
            this.f2350p = (TextView) this.f2348n.findViewById(C1930k.action_bar_subtitle);
            if (this.f2351q != 0) {
                this.f2349o.setTextAppearance(getContext(), this.f2351q);
            }
            if (this.f2352r != 0) {
                this.f2350p.setTextAppearance(getContext(), this.f2352r);
            }
        }
        this.f2349o.setText(this.f2344j);
        this.f2350p.setText(this.f2345k);
        boolean z = !TextUtils.isEmpty(this.f2344j);
        boolean z2 = !TextUtils.isEmpty(this.f2345k);
        int i = 0;
        this.f2350p.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.f2348n;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.f2348n.getParent() == null) {
            addView(this.f2348n);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* renamed from: h */
    public void m1670h() {
        removeAllViews();
        this.f2347m = null;
        this.f6725c = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f6726d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m1656c();
            this.f6726d.m1655d();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f2344j);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean m786b = C1852h1.m786b(this);
        int paddingRight = m786b ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2346l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2346l.getLayoutParams();
            int i5 = m786b ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = m786b ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = m786b ? paddingRight - i5 : paddingRight + i5;
            int m226d = i7 + m226d(this.f2346l, i7, paddingTop, paddingTop2, m786b);
            paddingRight = m786b ? m226d - i6 : m226d + i6;
        }
        int i8 = paddingRight;
        LinearLayout linearLayout = this.f2348n;
        if (linearLayout != null && this.f2347m == null && linearLayout.getVisibility() != 8) {
            i8 += m226d(this.f2348n, i8, paddingTop, paddingTop2, m786b);
        }
        int i9 = i8;
        View view2 = this.f2347m;
        if (view2 != null) {
            m226d(view2, i9, paddingTop, paddingTop2, m786b);
        }
        int paddingLeft = m786b ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f6725c;
        if (actionMenuView != null) {
            m226d(actionMenuView, paddingLeft, paddingTop, paddingTop2, !m786b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i2) != 0) {
                int size = View.MeasureSpec.getSize(i);
                int i3 = this.f6727f;
                if (i3 <= 0) {
                    i3 = View.MeasureSpec.getSize(i2);
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i4 = i3 - paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                View view = this.f2346l;
                if (view != null) {
                    int m227c = m227c(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2346l.getLayoutParams();
                    paddingLeft = m227c - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f6725c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = m227c(this.f6725c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f2348n;
                if (linearLayout != null && this.f2347m == null) {
                    if (this.f2353s) {
                        this.f2348n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f2348n.getMeasuredWidth();
                        boolean z = measuredWidth <= paddingLeft;
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        this.f2348n.setVisibility(z ? 0 : 8);
                    } else {
                        paddingLeft = m227c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f2347m;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i5 = layoutParams.width;
                    int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
                    if (i5 >= 0) {
                        paddingLeft = Math.min(i5, paddingLeft);
                    }
                    int i7 = layoutParams.height;
                    int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
                    if (i7 >= 0) {
                        i4 = Math.min(i7, i4);
                    }
                    this.f2347m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i4, i8));
                }
                if (this.f6727f <= 0) {
                    int childCount = getChildCount();
                    int i9 = 0;
                    for (int i10 = 0; i10 < childCount; i10++) {
                        int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingBottom;
                        if (measuredHeight > i9) {
                            i9 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i9);
                    return;
                }
                setMeasuredDimension(size, i3);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // p000.AbstractC2303w0
    public void setContentHeight(int i) {
        this.f6727f = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2347m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2347m = view;
        if (view != null && (linearLayout = this.f2348n) != null) {
            removeView(linearLayout);
            this.f2348n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2345k = charSequence;
        m1671g();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2344j = charSequence;
        m1671g();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f2353s) {
            requestLayout();
        }
        this.f2353s = z;
    }

    @Override // p000.AbstractC2303w0, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.ActionMode, i, 0);
        int i2 = C2012o.ActionMode_background;
        if (obtainStyledAttributes.hasValue(i2) && (resourceId = obtainStyledAttributes.getResourceId(i2, 0)) != 0) {
            drawable = C0279M.m2210b(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(i2);
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1927q(this, drawable);
        this.f2351q = obtainStyledAttributes.getResourceId(C2012o.ActionMode_titleTextStyle, 0);
        this.f2352r = obtainStyledAttributes.getResourceId(C2012o.ActionMode_subtitleTextStyle, 0);
        this.f6727f = obtainStyledAttributes.getLayoutDimension(C2012o.ActionMode_height, 0);
        this.f2354t = obtainStyledAttributes.getResourceId(C2012o.ActionMode_closeItemLayout, C1949l.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
