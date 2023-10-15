package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import p000.C1905j0;
import p000.InterfaceC2165p0;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements C1905j0.InterfaceC1907b, InterfaceC2186q0 {

    /* renamed from: a */
    public C1905j0 f2417a;

    /* renamed from: b */
    public Context f2418b;

    /* renamed from: c */
    public int f2419c;

    /* renamed from: d */
    public boolean f2420d;

    /* renamed from: f */
    public ActionMenuPresenter f2421f;

    /* renamed from: g */
    public InterfaceC2165p0.InterfaceC2166a f2422g;

    /* renamed from: h */
    public C1905j0.InterfaceC1906a f2423h;

    /* renamed from: i */
    public boolean f2424i;

    /* renamed from: j */
    public int f2425j;

    /* renamed from: k */
    public int f2426k;

    /* renamed from: l */
    public int f2427l;

    /* renamed from: m */
    public InterfaceC0653d f2428m;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: c */
        public boolean f2429c;
        @ViewDebug.ExportedProperty

        /* renamed from: d */
        public int f2430d;
        @ViewDebug.ExportedProperty

        /* renamed from: e */
        public int f2431e;
        @ViewDebug.ExportedProperty

        /* renamed from: f */
        public boolean f2432f;
        @ViewDebug.ExportedProperty

        /* renamed from: g */
        public boolean f2433g;

        /* renamed from: h */
        public boolean f2434h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2429c = layoutParams.f2429c;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2429c = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0650a {
        /* renamed from: a */
        boolean mo1647a();

        /* renamed from: b */
        boolean mo1646b();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0651b implements InterfaceC2165p0.InterfaceC2166a {
        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        /* renamed from: a */
        public boolean mo458a(C1905j0 c1905j0) {
            return false;
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        public void onCloseMenu(C1905j0 c1905j0, boolean z) {
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0652c implements C1905j0.InterfaceC1906a {
        public C0652c() {
        }

        @Override // p000.C1905j0.InterfaceC1906a
        public boolean onMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
            InterfaceC0653d interfaceC0653d = ActionMenuView.this.f2428m;
            if (interfaceC0653d != null) {
                Toolbar.InterfaceC0702e interfaceC0702e = Toolbar.this.mOnMenuItemClickListener;
                return interfaceC0702e != null ? C0181I.this.f598c.onMenuItemSelected(0, menuItem) : false;
            }
            return false;
        }

        @Override // p000.C1905j0.InterfaceC1906a
        public void onMenuModeChange(C1905j0 c1905j0) {
            C1905j0.InterfaceC1906a interfaceC1906a = ActionMenuView.this.f2423h;
            if (interfaceC1906a != null) {
                interfaceC1906a.onMenuModeChange(c1905j0);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0653d {
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* renamed from: h */
    public static int m1648h(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m1680c();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!layoutParams.f2429c && z2) {
            z = true;
        }
        layoutParams.f2432f = z;
        layoutParams.f2430d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    @Override // p000.C1905j0.InterfaceC1907b
    /* renamed from: a */
    public boolean mo723a(C1950l0 c1950l0) {
        return this.f2417a.performItemAction(c1950l0, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: d */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f2510b = 16;
        return layoutParams;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (layoutParams2.f2510b <= 0) {
                layoutParams2.f2510b = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    /* renamed from: f */
    public Menu m1650f() {
        if (this.f2417a == null) {
            Context context = getContext();
            C1905j0 c1905j0 = new C1905j0(context);
            this.f2417a = c1905j0;
            c1905j0.setCallback(new C0652c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f2421f = actionMenuPresenter;
            actionMenuPresenter.f2395n = true;
            actionMenuPresenter.f2396o = true;
            InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f2422g;
            if (interfaceC2166a == null) {
                interfaceC2166a = new C0651b();
            }
            actionMenuPresenter.f4102f = interfaceC2166a;
            this.f2417a.addMenuPresenter(actionMenuPresenter, this.f2418b);
            ActionMenuPresenter actionMenuPresenter2 = this.f2421f;
            actionMenuPresenter2.f4105i = this;
            this.f2417a = actionMenuPresenter2.f4100c;
        }
        return this.f2417a;
    }

    /* renamed from: g */
    public boolean m1649g(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0650a)) {
            z = false | ((InterfaceC0650a) childAt).mo1647a();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC0650a)) ? z : z | ((InterfaceC0650a) childAt2).mo1646b();
    }

    @Override // p000.InterfaceC2186q0
    public void initialize(C1905j0 c1905j0) {
        this.f2417a = c1905j0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f2421f;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.f2421f.m1654e()) {
                this.f2421f.m1656c();
                this.f2421f.m1653f();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f2421f;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m1658a();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i5;
        if (!this.f2424i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean m786b = C1852h1.m786b(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2429c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m1649g(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m786b) {
                        i5 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        width = i5 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        i5 = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(i5, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    m1649g(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (m786b) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f2429c) {
                    int i16 = width2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f2429c) {
                int i19 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft = outline.m269b(measuredWidth4, ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, max, i19);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v39 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int i6;
        ?? r3;
        C1905j0 c1905j0;
        boolean z3 = this.f2424i;
        boolean z4 = View.MeasureSpec.getMode(i) == 1073741824;
        this.f2424i = z4;
        if (z3 != z4) {
            this.f2425j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f2424i && (c1905j0 = this.f2417a) != null && size != this.f2425j) {
            this.f2425j = size;
            c1905j0.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.f2424i && childCount > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i2);
            int paddingRight = getPaddingRight() + getPaddingLeft();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
            int i7 = size2 - paddingRight;
            int i8 = this.f2426k;
            int i9 = i7 / i8;
            int i10 = i7 % i8;
            if (i9 == 0) {
                setMeasuredDimension(i7, 0);
                return;
            }
            int i11 = (i10 / i9) + i8;
            int childCount2 = getChildCount();
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            boolean z5 = false;
            long j = 0;
            while (i16 < childCount2) {
                View childAt = getChildAt(i16);
                int i17 = size3;
                int i18 = i7;
                if (childAt.getVisibility() != 8) {
                    boolean z6 = childAt instanceof ActionMenuItemView;
                    int i19 = i12 + 1;
                    if (z6) {
                        int i20 = this.f2427l;
                        i6 = i19;
                        r3 = 0;
                        childAt.setPadding(i20, 0, i20, 0);
                    } else {
                        i6 = i19;
                        r3 = 0;
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f2434h = r3;
                    layoutParams.f2431e = r3;
                    layoutParams.f2430d = r3;
                    layoutParams.f2432f = r3;
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = r3;
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = r3;
                    layoutParams.f2433g = z6 && ((ActionMenuItemView) childAt).m1680c();
                    int m1648h = m1648h(childAt, i11, layoutParams.f2429c ? 1 : i9, childMeasureSpec, paddingBottom);
                    i14 = Math.max(i14, m1648h);
                    if (layoutParams.f2432f) {
                        i15++;
                    }
                    if (layoutParams.f2429c) {
                        z5 = true;
                    }
                    i9 -= m1648h;
                    i13 = Math.max(i13, childAt.getMeasuredHeight());
                    if (m1648h == 1) {
                        j |= 1 << i16;
                    }
                    i12 = i6;
                }
                i16++;
                size3 = i17;
                i7 = i18;
            }
            int i21 = i7;
            int i22 = size3;
            boolean z7 = z5 && i12 == 2;
            boolean z8 = false;
            while (i15 > 0 && i9 > 0) {
                int i23 = Integer.MAX_VALUE;
                int i24 = 0;
                int i25 = 0;
                long j2 = 0;
                while (i24 < childCount2) {
                    int i26 = i13;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i24).getLayoutParams();
                    boolean z9 = z8;
                    if (layoutParams2.f2432f) {
                        int i27 = layoutParams2.f2430d;
                        if (i27 < i23) {
                            j2 = 1 << i24;
                            i23 = i27;
                            i25 = 1;
                        } else if (i27 == i23) {
                            i25++;
                            j2 |= 1 << i24;
                        }
                    }
                    i24++;
                    z8 = z9;
                    i13 = i26;
                }
                i3 = i13;
                z = z8;
                j |= j2;
                if (i25 > i9) {
                    break;
                }
                int i28 = i23 + 1;
                int i29 = 0;
                while (i29 < childCount2) {
                    View childAt2 = getChildAt(i29);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i30 = i15;
                    long j3 = 1 << i29;
                    if ((j2 & j3) == 0) {
                        if (layoutParams3.f2430d == i28) {
                            j |= j3;
                        }
                        z2 = z7;
                    } else {
                        if (z7 && layoutParams3.f2433g && i9 == 1) {
                            int i31 = this.f2427l;
                            z2 = z7;
                            childAt2.setPadding(i31 + i11, 0, i31, 0);
                        } else {
                            z2 = z7;
                        }
                        layoutParams3.f2430d++;
                        layoutParams3.f2434h = true;
                        i9--;
                    }
                    i29++;
                    i15 = i30;
                    z7 = z2;
                }
                i13 = i3;
                z8 = true;
            }
            i3 = i13;
            z = z8;
            boolean z10 = !z5 && i12 == 1;
            if (i9 > 0 && j != 0 && (i9 < i12 - 1 || z10 || i14 > 1)) {
                float bitCount = Long.bitCount(j);
                if (!z10) {
                    if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f2433g) {
                        bitCount -= 0.5f;
                    }
                    int i32 = childCount2 - 1;
                    if ((j & (1 << i32)) != 0 && !((LayoutParams) getChildAt(i32).getLayoutParams()).f2433g) {
                        bitCount -= 0.5f;
                    }
                }
                int i33 = bitCount > 0.0f ? (int) ((i9 * i11) / bitCount) : 0;
                for (int i34 = 0; i34 < childCount2; i34++) {
                    if ((j & (1 << i34)) != 0) {
                        View childAt3 = getChildAt(i34);
                        LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            layoutParams4.f2431e = i33;
                            layoutParams4.f2434h = true;
                            if (i34 == 0 && !layoutParams4.f2433g) {
                                ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (-i33) / 2;
                            }
                        } else if (layoutParams4.f2429c) {
                            layoutParams4.f2431e = i33;
                            layoutParams4.f2434h = true;
                            ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (-i33) / 2;
                        } else {
                            if (i34 != 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = i33 / 2;
                            }
                            if (i34 != childCount2 - 1) {
                                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = i33 / 2;
                            }
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                for (int i35 = 0; i35 < childCount2; i35++) {
                    View childAt4 = getChildAt(i35);
                    LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                    if (layoutParams5.f2434h) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f2430d * i11) + layoutParams5.f2431e, 1073741824), childMeasureSpec);
                    }
                }
            }
            if (mode != 1073741824) {
                i5 = i21;
                i4 = i3;
            } else {
                i4 = i22;
                i5 = i21;
            }
            setMeasuredDimension(i5, i4);
            return;
        }
        for (int i36 = 0; i36 < childCount; i36++) {
            LayoutParams layoutParams6 = (LayoutParams) getChildAt(i36).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f2421f.f2400s = z;
    }

    public void setMenuCallbacks(InterfaceC2165p0.InterfaceC2166a interfaceC2166a, C1905j0.InterfaceC1906a interfaceC1906a) {
        this.f2422g = interfaceC2166a;
        this.f2423h = interfaceC1906a;
    }

    public void setOnMenuItemClickListener(InterfaceC0653d interfaceC0653d) {
        this.f2428m = interfaceC0653d;
    }

    public void setOverflowIcon(Drawable drawable) {
        m1650f();
        ActionMenuPresenter actionMenuPresenter = this.f2421f;
        ActionMenuPresenter.C0646d c0646d = actionMenuPresenter.f2392k;
        if (c0646d != null) {
            c0646d.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.f2394m = true;
        actionMenuPresenter.f2393l = drawable;
    }

    public void setOverflowReserved(boolean z) {
        this.f2420d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f2419c != i) {
            this.f2419c = i;
            if (i == 0) {
                this.f2418b = getContext();
            } else {
                this.f2418b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f2421f = actionMenuPresenter;
        actionMenuPresenter.f4105i = this;
        this.f2417a = actionMenuPresenter.f4100c;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f2426k = (int) (56.0f * f);
        this.f2427l = (int) (f * 4.0f);
        this.f2418b = context;
        this.f2419c = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
