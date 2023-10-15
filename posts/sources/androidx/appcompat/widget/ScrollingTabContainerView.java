package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import java.util.Objects;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    public Runnable f2551a;

    /* renamed from: b */
    public LinearLayoutCompat f2552b;

    /* renamed from: c */
    public Spinner f2553c;

    /* renamed from: d */
    public boolean f2554d;

    /* renamed from: f */
    public int f2555f;

    /* renamed from: g */
    public int f2556g;

    /* renamed from: h */
    public int f2557h;

    /* renamed from: i */
    public int f2558i;

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0676a extends BaseAdapter {
        public C0676a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f2552b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((C0677b) ScrollingTabContainerView.this.f2552b.getChildAt(i)).f2561b;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                ActionBar.AbstractC0630b abstractC0630b = ((C0677b) scrollingTabContainerView.f2552b.getChildAt(i)).f2561b;
                Objects.requireNonNull(scrollingTabContainerView);
                C0677b c0677b = new C0677b(scrollingTabContainerView.getContext(), abstractC0630b, true);
                c0677b.setBackgroundDrawable(null);
                c0677b.setLayoutParams(new AbsListView.LayoutParams(-1, scrollingTabContainerView.f2557h));
                return c0677b;
            }
            C0677b c0677b2 = (C0677b) view;
            c0677b2.f2561b = ((C0677b) ScrollingTabContainerView.this.f2552b.getChildAt(i)).f2561b;
            c0677b2.m1609a();
            return view;
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0677b extends LinearLayout {

        /* renamed from: a */
        public final int[] f2560a;

        /* renamed from: b */
        public ActionBar.AbstractC0630b f2561b;

        /* renamed from: c */
        public TextView f2562c;

        /* renamed from: d */
        public ImageView f2563d;

        /* renamed from: f */
        public View f2564f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C0677b(android.content.Context r6, androidx.appcompat.app.ActionBar.AbstractC0630b r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = p000.C1671f.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 0
                r3 = 16842964(0x10100d4, float:2.3694152E-38)
                r1[r2] = r3
                r4.f2560a = r1
                r4.f2561b = r7
                android.content.res.TypedArray r5 = r6.obtainStyledAttributes(r0, r1, r5, r2)
                boolean r7 = r5.hasValue(r2)
                if (r7 == 0) goto L37
                boolean r7 = r5.hasValue(r2)
                if (r7 == 0) goto L30
                int r7 = r5.getResourceId(r2, r2)
                if (r7 == 0) goto L30
                android.graphics.drawable.Drawable r6 = p000.C0279M.m2210b(r6, r7)
                goto L34
            L30:
                android.graphics.drawable.Drawable r6 = r5.getDrawable(r2)
            L34:
                r4.setBackgroundDrawable(r6)
            L37:
                r5.recycle()
                if (r8 == 0) goto L42
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L42:
                r4.m1609a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.C0677b.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$b, boolean):void");
        }

        /* renamed from: a */
        public void m1609a() {
            ActionBar.AbstractC0630b abstractC0630b = this.f2561b;
            View m1697b = abstractC0630b.m1697b();
            if (m1697b != null) {
                ViewParent parent = m1697b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(m1697b);
                    }
                    addView(m1697b);
                }
                this.f2564f = m1697b;
                TextView textView = this.f2562c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2563d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2563d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2564f;
            if (view != null) {
                removeView(view);
                this.f2564f = null;
            }
            Drawable m1696c = abstractC0630b.m1696c();
            CharSequence m1695d = abstractC0630b.m1695d();
            if (m1696c != null) {
                if (this.f2563d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2563d = appCompatImageView;
                }
                this.f2563d.setImageDrawable(m1696c);
                this.f2563d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2563d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2563d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(m1695d);
            if (z) {
                if (this.f2562c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, C1671f.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2562c = appCompatTextView;
                }
                this.f2562c.setText(m1695d);
                this.f2562c.setVisibility(0);
            } else {
                TextView textView2 = this.f2562c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2562c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f2563d;
            if (imageView3 != null) {
                imageView3.setContentDescription(abstractC0630b.m1698a());
            }
            LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, z ? null : abstractC0630b.m1698a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f2555f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = ScrollingTabContainerView.this.f2555f;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0678c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f2566a = false;

        public C0678c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2566a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2566a) {
                return;
            }
            Objects.requireNonNull(ScrollingTabContainerView.this);
            ScrollingTabContainerView.this.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f2566a = false;
        }
    }

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        new C0678c();
        setHorizontalScrollBarEnabled(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C2012o.ActionBar, C1671f.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C2012o.ActionBar_height, 0);
        layoutDimension = context.getResources().getBoolean(C1825g.abc_action_bar_embed_tabs) ? layoutDimension : Math.min(layoutDimension, context.getResources().getDimensionPixelSize(C1881i.abc_action_bar_stacked_max_height));
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.f2556g = context.getResources().getDimensionPixelSize(C1881i.abc_action_bar_stacked_tab_max_width);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, C1671f.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.f2552b = linearLayoutCompat;
        addView(linearLayoutCompat, new ViewGroup.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public final boolean m1610a() {
        Spinner spinner = this.f2553c;
        if (spinner != null && spinner.getParent() == this) {
            removeView(this.f2553c);
            addView(this.f2552b, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f2553c.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2551a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C2012o.ActionBar, C1671f.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C2012o.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!context.getResources().getBoolean(C1825g.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C1881i.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.f2556g = context.getResources().getDimensionPixelSize(C1881i.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2551a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0677b) view).f2561b.m1694e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f2552b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f2555f = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f2555f = View.MeasureSpec.getSize(i) / 2;
            }
            this.f2555f = Math.min(this.f2555f, this.f2556g);
        } else {
            this.f2555f = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2557h, 1073741824);
        if (!z2 && this.f2554d) {
            this.f2552b.measure(0, makeMeasureSpec);
            if (this.f2552b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                Spinner spinner = this.f2553c;
                if (!((spinner == null || spinner.getParent() != this) ? false : false)) {
                    if (this.f2553c == null) {
                        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C1671f.actionDropDownStyle);
                        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                        appCompatSpinner.setOnItemSelectedListener(this);
                        this.f2553c = appCompatSpinner;
                    }
                    removeView(this.f2552b);
                    addView(this.f2553c, new ViewGroup.LayoutParams(-2, -1));
                    if (this.f2553c.getAdapter() == null) {
                        this.f2553c.setAdapter((SpinnerAdapter) new C0676a());
                    }
                    Runnable runnable = this.f2551a;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.f2551a = null;
                    }
                    this.f2553c.setSelection(this.f2558i);
                }
            } else {
                m1610a();
            }
        } else {
            m1610a();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f2558i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2554d = z;
    }

    public void setContentHeight(int i) {
        this.f2557h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2558i = i;
        int childCount = this.f2552b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2552b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                View childAt2 = this.f2552b.getChildAt(i);
                Runnable runnable = this.f2551a;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                RunnableC0465U0 runnableC0465U0 = new RunnableC0465U0(this, childAt2);
                this.f2551a = runnableC0465U0;
                post(runnableC0465U0);
            }
            i2++;
        }
        Spinner spinner = this.f2553c;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }
}
