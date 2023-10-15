package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C0958b5;
import p000.InterfaceC2165p0;

@SuppressLint({"UnknownNullness"})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0210J0, InterfaceC0267L4, InterfaceC0287M4 {

    /* renamed from: G */
    public static final int[] f2356G = {C1671f.actionBarSize, 16842841};

    /* renamed from: A */
    public OverScroller f2357A;

    /* renamed from: B */
    public ViewPropertyAnimator f2358B;

    /* renamed from: C */
    public final AnimatorListenerAdapter f2359C;

    /* renamed from: D */
    public final Runnable f2360D;

    /* renamed from: E */
    public final Runnable f2361E;

    /* renamed from: F */
    public final C0310N4 f2362F;

    /* renamed from: a */
    public int f2363a;

    /* renamed from: b */
    public int f2364b;

    /* renamed from: c */
    public ContentFrameLayout f2365c;

    /* renamed from: d */
    public ActionBarContainer f2366d;

    /* renamed from: f */
    public InterfaceC0231K0 f2367f;

    /* renamed from: g */
    public Drawable f2368g;

    /* renamed from: h */
    public boolean f2369h;

    /* renamed from: i */
    public boolean f2370i;

    /* renamed from: j */
    public boolean f2371j;

    /* renamed from: k */
    public boolean f2372k;

    /* renamed from: l */
    public boolean f2373l;

    /* renamed from: m */
    public int f2374m;

    /* renamed from: n */
    public int f2375n;

    /* renamed from: o */
    public final Rect f2376o;

    /* renamed from: p */
    public final Rect f2377p;

    /* renamed from: q */
    public final Rect f2378q;

    /* renamed from: r */
    public final Rect f2379r;

    /* renamed from: s */
    public final Rect f2380s;

    /* renamed from: t */
    public final Rect f2381t;

    /* renamed from: u */
    public final Rect f2382u;

    /* renamed from: v */
    public C0958b5 f2383v;

    /* renamed from: w */
    public C0958b5 f2384w;

    /* renamed from: x */
    public C0958b5 f2385x;

    /* renamed from: y */
    public C0958b5 f2386y;

    /* renamed from: z */
    public InterfaceC0641d f2387z;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0638a extends AnimatorListenerAdapter {
        public C0638a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2358B = null;
            actionBarOverlayLayout.f2373l = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2358B = null;
            actionBarOverlayLayout.f2373l = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0639b implements Runnable {
        public RunnableC0639b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m1661i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2358B = actionBarOverlayLayout.f2366d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f2359C);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0640c implements Runnable {
        public RunnableC0640c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m1661i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2358B = actionBarOverlayLayout.f2366d.animate().translationY(-ActionBarOverlayLayout.this.f2366d.getHeight()).setListener(ActionBarOverlayLayout.this.f2359C);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0641d {
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: a */
    public boolean mo1669a() {
        m1659k();
        return this.f2367f.mo1061a();
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: b */
    public boolean mo1668b() {
        m1659k();
        return this.f2367f.mo1060b();
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: c */
    public boolean mo1667c() {
        m1659k();
        return this.f2367f.mo1059c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: d */
    public boolean mo1666d() {
        m1659k();
        return this.f2367f.mo1058d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f2368g == null || this.f2369h) {
            return;
        }
        if (this.f2366d.getVisibility() == 0) {
            i = (int) (this.f2366d.getTranslationY() + this.f2366d.getBottom() + 0.5f);
        } else {
            i = 0;
        }
        this.f2368g.setBounds(0, i, getWidth(), this.f2368g.getIntrinsicHeight() + i);
        this.f2368g.draw(canvas);
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: e */
    public boolean mo1665e() {
        m1659k();
        return this.f2367f.mo1057e();
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: f */
    public void mo1664f(int i) {
        m1659k();
        if (i == 2) {
            this.f2367f.mo1043s();
        } else if (i == 5) {
            this.f2367f.mo1042t();
        } else if (i != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // p000.InterfaceC0210J0
    /* renamed from: g */
    public void mo1663g() {
        m1659k();
        this.f2367f.mo1056f();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2362F.m2175a();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m1662h(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.m1662h(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* renamed from: i */
    public void m1661i() {
        removeCallbacks(this.f2360D);
        removeCallbacks(this.f2361E);
        ViewPropertyAnimator viewPropertyAnimator = this.f2358B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: j */
    public final void m1660j(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2356G);
        this.f2363a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f2368g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f2369h = context.getApplicationInfo().targetSdkVersion < 19;
        this.f2357A = new OverScroller(context);
    }

    /* renamed from: k */
    public void m1659k() {
        InterfaceC0231K0 wrapper;
        if (this.f2365c == null) {
            this.f2365c = (ContentFrameLayout) findViewById(C1930k.action_bar_activity_content);
            this.f2366d = (ActionBarContainer) findViewById(C1930k.action_bar_container);
            View findViewById = findViewById(C1930k.action_bar);
            if (findViewById instanceof InterfaceC0231K0) {
                wrapper = (InterfaceC0231K0) findViewById;
            } else if (findViewById instanceof Toolbar) {
                wrapper = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder m253r = outline.m253r("Can't make a decor toolbar out of ");
                m253r.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(m253r.toString());
            }
            this.f2367f = wrapper;
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m1659k();
        C0958b5 m1179k = C0958b5.m1179k(windowInsets, null);
        boolean m1662h = m1662h(this.f2366d, new Rect(m1179k.m1187c(), m1179k.m1185e(), m1179k.m1186d(), m1179k.m1188b()), true, true, false, true);
        Rect rect = this.f2376o;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0500h.m1899b(this, m1179k, rect);
        Rect rect2 = this.f2376o;
        C0958b5 mo1167i = m1179k.f3682a.mo1167i(rect2.left, rect2.top, rect2.right, rect2.bottom);
        this.f2383v = mo1167i;
        boolean z = true;
        if (!this.f2384w.equals(mo1167i)) {
            this.f2384w = this.f2383v;
            m1662h = true;
        }
        if (this.f2377p.equals(this.f2376o)) {
            z = m1662h;
        } else {
            this.f2377p.set(this.f2376o);
        }
        if (z) {
            requestLayout();
        }
        return m1179k.f3682a.mo1175a().m1189a().f3682a.mo1174b().m1181i();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1660j(getContext());
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0499g.m1901c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1661i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        C0958b5.C0963e c0960b;
        m1659k();
        measureChildWithMargins(this.f2366d, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f2366d.getLayoutParams();
        int max = Math.max(0, this.f2366d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.f2366d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2366d.getMeasuredState());
        AtomicInteger atomicInteger = C0492V4.f1798a;
        boolean z = (C0492V4.C0495c.m1937g(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f2363a;
            if (this.f2371j && this.f2366d.f2335b != null) {
                measuredHeight += measuredHeight;
            }
        } else {
            measuredHeight = this.f2366d.getVisibility() != 8 ? this.f2366d.getMeasuredHeight() : 0;
        }
        this.f2378q.set(this.f2376o);
        C0958b5 c0958b5 = this.f2383v;
        this.f2385x = c0958b5;
        if (!this.f2370i && !z) {
            Rect rect = this.f2378q;
            rect.top += measuredHeight;
            rect.bottom += 0;
            this.f2385x = c0958b5.f3682a.mo1167i(0, measuredHeight, 0, 0);
        } else {
            C0170H3 m2412a = C0170H3.m2412a(c0958b5.m1187c(), this.f2385x.m1185e() + measuredHeight, this.f2385x.m1186d(), this.f2385x.m1188b() + 0);
            C0958b5 c0958b52 = this.f2385x;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                c0960b = new C0958b5.C0962d(c0958b52);
            } else if (i3 >= 29) {
                c0960b = new C0958b5.C0961c(c0958b52);
            } else {
                c0960b = new C0958b5.C0960b(c0958b52);
            }
            c0960b.mo1176c(m2412a);
            this.f2385x = c0960b.mo1178a();
        }
        m1662h(this.f2365c, this.f2378q, true, true, true, true);
        if (!this.f2386y.equals(this.f2385x)) {
            C0958b5 c0958b53 = this.f2385x;
            this.f2386y = c0958b53;
            C0492V4.m1966e(this.f2365c, c0958b53);
        }
        measureChildWithMargins(this.f2365c, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f2365c.getLayoutParams();
        int max3 = Math.max(max, this.f2365c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.f2365c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f2365c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.f2372k && z) {
            this.f2357A.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (this.f2357A.getFinalY() > this.f2366d.getHeight()) {
                m1661i();
                this.f2361E.run();
            } else {
                m1661i();
                this.f2360D.run();
            }
            this.f2373l = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // p000.InterfaceC0267L4
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // p000.InterfaceC0267L4
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        m1659k();
        int i2 = this.f2375n ^ i;
        this.f2375n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        InterfaceC0641d interfaceC0641d = this.f2387z;
        if (interfaceC0641d != null) {
            ((C0258L) interfaceC0641d).f860p = !z2;
            if (!z && z2) {
                C0258L c0258l = (C0258L) interfaceC0641d;
                if (!c0258l.f861q) {
                    c0258l.f861q = true;
                    c0258l.m2229z(true);
                }
            } else {
                C0258L c0258l2 = (C0258L) interfaceC0641d;
                if (c0258l2.f861q) {
                    c0258l2.f861q = false;
                    c0258l2.m2229z(true);
                }
            }
        }
        if ((i2 & 256) == 0 || this.f2387z == null) {
            return;
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0499g.m1901c(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f2364b = i;
        InterfaceC0641d interfaceC0641d = this.f2387z;
        if (interfaceC0641d != null) {
            ((C0258L) interfaceC0641d).f859o = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        m1661i();
        this.f2366d.setTranslationY(-Math.max(0, Math.min(i, this.f2366d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0641d interfaceC0641d) {
        this.f2387z = interfaceC0641d;
        if (getWindowToken() != null) {
            ((C0258L) this.f2387z).f859o = this.f2364b;
            int i = this.f2375n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0499g.m1901c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f2371j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f2372k) {
            this.f2372k = z;
            if (z) {
                return;
            }
            m1661i();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        m1659k();
        this.f2367f.setIcon(i);
    }

    public void setLogo(int i) {
        m1659k();
        this.f2367f.mo1046p(i);
    }

    @Override // p000.InterfaceC0210J0
    public void setMenu(Menu menu, InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        m1659k();
        this.f2367f.setMenu(menu, interfaceC2166a);
    }

    @Override // p000.InterfaceC0210J0
    public void setMenuPrepared() {
        m1659k();
        this.f2367f.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.f2370i = z;
        this.f2369h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // p000.InterfaceC0210J0
    public void setWindowCallback(Window.Callback callback) {
        m1659k();
        this.f2367f.setWindowCallback(callback);
    }

    @Override // p000.InterfaceC0210J0
    public void setWindowTitle(CharSequence charSequence) {
        m1659k();
        this.f2367f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2364b = 0;
        this.f2376o = new Rect();
        this.f2377p = new Rect();
        this.f2378q = new Rect();
        this.f2379r = new Rect();
        this.f2380s = new Rect();
        this.f2381t = new Rect();
        this.f2382u = new Rect();
        C0958b5 c0958b5 = C0958b5.f3681b;
        this.f2383v = c0958b5;
        this.f2384w = c0958b5;
        this.f2385x = c0958b5;
        this.f2386y = c0958b5;
        this.f2359C = new C0638a();
        this.f2360D = new RunnableC0639b();
        this.f2361E = new RunnableC0640c();
        m1660j(context);
        this.f2362F = new C0310N4();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // p000.InterfaceC0287M4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        C0258L c0258l;
        C0952b0 c0952b0;
        this.f2362F.f1023a = i;
        ActionBarContainer actionBarContainer = this.f2366d;
        this.f2374m = actionBarContainer != null ? -((int) actionBarContainer.getTranslationY()) : 0;
        m1661i();
        InterfaceC0641d interfaceC0641d = this.f2387z;
        if (interfaceC0641d == null || (c0952b0 = (c0258l = (C0258L) interfaceC0641d).f864t) == null) {
            return;
        }
        c0952b0.m1215a();
        c0258l.f864t = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f2366d.getVisibility() != 0) {
            return false;
        }
        return this.f2372k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f2372k && !this.f2373l) {
            if (this.f2374m <= this.f2366d.getHeight()) {
                m1661i();
                postDelayed(this.f2360D, 600L);
            } else {
                m1661i();
                postDelayed(this.f2361E, 600L);
            }
        }
        InterfaceC0641d interfaceC0641d = this.f2387z;
        if (interfaceC0641d != null) {
            Objects.requireNonNull((C0258L) interfaceC0641d);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f2374m + i2;
        this.f2374m = i5;
        setActionBarHideOffset(i5);
    }

    public void setIcon(Drawable drawable) {
        m1659k();
        this.f2367f.setIcon(drawable);
    }
}
