package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C1617d5;
import p000.C2307w3;
import p000.C2319w5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: F */
    public static final int[] f3030F = {16843828};

    /* renamed from: G */
    public static final int[] f3031G = {16842931};

    /* renamed from: A */
    public Object f3032A;

    /* renamed from: B */
    public boolean f3033B;

    /* renamed from: C */
    public final ArrayList<View> f3034C;

    /* renamed from: D */
    public Rect f3035D;

    /* renamed from: E */
    public Matrix f3036E;

    /* renamed from: a */
    public final C0798c f3037a;

    /* renamed from: b */
    public float f3038b;

    /* renamed from: c */
    public int f3039c;

    /* renamed from: d */
    public int f3040d;

    /* renamed from: f */
    public float f3041f;

    /* renamed from: g */
    public Paint f3042g;

    /* renamed from: h */
    public final C2319w5 f3043h;

    /* renamed from: i */
    public final C2319w5 f3044i;

    /* renamed from: j */
    public final C0800e f3045j;

    /* renamed from: k */
    public final C0800e f3046k;

    /* renamed from: l */
    public int f3047l;

    /* renamed from: m */
    public boolean f3048m;

    /* renamed from: n */
    public boolean f3049n;

    /* renamed from: o */
    public int f3050o;

    /* renamed from: p */
    public int f3051p;

    /* renamed from: q */
    public int f3052q;

    /* renamed from: r */
    public int f3053r;

    /* renamed from: s */
    public boolean f3054s;

    /* renamed from: t */
    public InterfaceC0799d f3055t;

    /* renamed from: u */
    public List<InterfaceC0799d> f3056u;

    /* renamed from: v */
    public float f3057v;

    /* renamed from: w */
    public float f3058w;

    /* renamed from: x */
    public Drawable f3059x;

    /* renamed from: y */
    public CharSequence f3060y;

    /* renamed from: z */
    public CharSequence f3061z;

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnApplyWindowInsetsListenerC0796a implements View.OnApplyWindowInsetsListener {
        public View$OnApplyWindowInsetsListenerC0796a(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0797b extends C0130F4 {

        /* renamed from: a */
        public final Rect f3071a = new Rect();

        public C0797b() {
        }

        @Override // p000.C0130F4
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence charSequence;
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View m1463f = DrawerLayout.this.m1463f();
                if (m1463f != null) {
                    int m1461h = DrawerLayout.this.m1461h(m1463f);
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    Objects.requireNonNull(drawerLayout);
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    int absoluteGravity = Gravity.getAbsoluteGravity(m1461h, C0492V4.C0496d.m1921d(drawerLayout));
                    if (absoluteGravity == 3) {
                        charSequence = drawerLayout.f3060y;
                    } else {
                        charSequence = absoluteGravity == 5 ? drawerLayout.f3061z : null;
                    }
                    if (charSequence != null) {
                        text.add(charSequence);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
            int[] iArr = DrawerLayout.f3030F;
            super.onInitializeAccessibilityNodeInfo(view, c1617d5);
            c1617d5.f3986a.setClassName(DrawerLayout.class.getName());
            c1617d5.f3986a.setFocusable(false);
            c1617d5.f3986a.setFocused(false);
            c1617d5.m1021l(C1617d5.C1618a.f3989e);
            c1617d5.m1021l(C1617d5.C1618a.f3990f);
        }

        @Override // p000.C0130F4
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            int[] iArr = DrawerLayout.f3030F;
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0798c extends C0130F4 {
        @Override // p000.C0130F4
        public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
            super.onInitializeAccessibilityNodeInfo(view, c1617d5);
            if (DrawerLayout.m1460i(view)) {
                return;
            }
            c1617d5.m1016q(null);
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0799d {
        /* renamed from: a */
        void m1453a(int i);

        /* renamed from: b */
        void m1452b(View view, float f);

        /* renamed from: c */
        void m1451c(View view);

        /* renamed from: d */
        void m1450d(View view);
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0800e extends C2319w5.AbstractC2322c {

        /* renamed from: a */
        public final int f3073a;

        /* renamed from: b */
        public C2319w5 f3074b;

        /* renamed from: c */
        public final Runnable f3075c = new RunnableC0801a();

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$e$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class RunnableC0801a implements Runnable {
            public RunnableC0801a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View m1465d;
                int width;
                C0800e c0800e = C0800e.this;
                int i = c0800e.f3074b.f6766o;
                boolean z = c0800e.f3073a == 3;
                if (z) {
                    m1465d = DrawerLayout.this.m1465d(3);
                    width = (m1465d != null ? -m1465d.getWidth() : 0) + i;
                } else {
                    m1465d = DrawerLayout.this.m1465d(5);
                    width = DrawerLayout.this.getWidth() - i;
                }
                if (m1465d != null) {
                    if (((!z || m1465d.getLeft() >= width) && (z || m1465d.getLeft() <= width)) || DrawerLayout.this.m1462g(m1465d) != 0) {
                        return;
                    }
                    c0800e.f3074b.m168x(m1465d, width, m1465d.getTop());
                    ((LayoutParams) m1465d.getLayoutParams()).f3064c = true;
                    DrawerLayout.this.invalidate();
                    c0800e.m1449a();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (drawerLayout.f3054s) {
                        return;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        drawerLayout.getChildAt(i2).dispatchTouchEvent(obtain);
                    }
                    obtain.recycle();
                    drawerLayout.f3054s = true;
                }
            }
        }

        public C0800e(int i) {
            this.f3073a = i;
        }

        /* renamed from: a */
        public final void m1449a() {
            View m1465d = DrawerLayout.this.m1465d(this.f3073a == 3 ? 5 : 3);
            if (m1465d != null) {
                DrawerLayout.this.m1467b(m1465d);
            }
        }

        /* renamed from: b */
        public void m1448b() {
            DrawerLayout.this.removeCallbacks(this.f3075c);
        }

        @Override // p000.C2319w5.AbstractC2322c
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.m1468a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // p000.C2319w5.AbstractC2322c
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // p000.C2319w5.AbstractC2322c
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.m1458k(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onEdgeDragStarted(int i, int i2) {
            View m1465d;
            if ((i & 1) == 1) {
                m1465d = DrawerLayout.this.m1465d(3);
            } else {
                m1465d = DrawerLayout.this.m1465d(5);
            }
            if (m1465d == null || DrawerLayout.this.m1462g(m1465d) != 0) {
                return;
            }
            this.f3074b.m190b(m1465d, i2);
        }

        @Override // p000.C2319w5.AbstractC2322c
        public boolean onEdgeLock(int i) {
            return false;
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f3075c, 160L);
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f3064c = false;
            m1449a();
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.m1454o(i, this.f3074b.f6770s);
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.m1468a(view, 3) ? i + width : DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.m1456m(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewReleased(View view, float f, float f2) {
            int i;
            Objects.requireNonNull(DrawerLayout.this);
            float f3 = ((LayoutParams) view.getLayoutParams()).f3063b;
            int width = view.getWidth();
            if (DrawerLayout.this.m1468a(view, 3)) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                i = (i2 > 0 || (i2 == 0 && f3 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f3074b.m170v(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // p000.C2319w5.AbstractC2322c
        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.m1458k(view) && DrawerLayout.this.m1468a(view, this.f3073a) && DrawerLayout.this.m1462g(view) == 0;
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    /* renamed from: i */
    public static boolean m1460i(View view) {
        AtomicInteger atomicInteger = C0492V4.f1798a;
        return (C0492V4.C0495c.m1941c(view) == 4 || C0492V4.C0495c.m1941c(view) == 2) ? false : true;
    }

    /* renamed from: a */
    public boolean m1468a(View view, int i) {
        return (m1461h(view) & i) == i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (m1458k(childAt)) {
                if (m1458k(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).f3065d & 1) == 1) {
                        childAt.addFocusables(arrayList, i, i2);
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            } else {
                this.f3034C.add(childAt);
            }
        }
        if (!z) {
            int size = this.f3034C.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f3034C.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.f3034C.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m1464e() == null && !m1458k(view)) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1925s(view, 1);
            return;
        }
        AtomicInteger atomicInteger2 = C0492V4.f1798a;
        C0492V4.C0495c.m1925s(view, 4);
    }

    /* renamed from: b */
    public void m1467b(View view) {
        if (m1458k(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f3049n) {
                layoutParams.f3063b = 0.0f;
                layoutParams.f3065d = 0;
            } else {
                layoutParams.f3065d |= 4;
                if (m1468a(view, 3)) {
                    this.f3043h.m168x(view, -view.getWidth(), view.getTop());
                } else {
                    this.f3044i.m168x(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* renamed from: c */
    public void m1466c(boolean z) {
        boolean m168x;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m1458k(childAt) && (!z || layoutParams.f3064c)) {
                int width = childAt.getWidth();
                if (m1468a(childAt, 3)) {
                    m168x = this.f3043h.m168x(childAt, -width, childAt.getTop());
                } else {
                    m168x = this.f3044i.m168x(childAt, getWidth(), childAt.getTop());
                }
                z2 |= m168x;
                layoutParams.f3064c = false;
            }
        }
        this.f3045j.m1448b();
        this.f3046k.m1448b();
        if (z2) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f3063b);
        }
        this.f3041f = f;
        boolean m183i = this.f3043h.m183i(true);
        boolean m183i2 = this.f3044i.m183i(true);
        if (m183i || m183i2) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
        }
    }

    /* renamed from: d */
    public View m1465d(int i) {
        AtomicInteger atomicInteger = C0492V4.f1798a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, C0492V4.C0496d.m1921d(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m1461h(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f3041f > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                for (int i = childCount - 1; i >= 0; i--) {
                    View childAt = getChildAt(i);
                    if (this.f3035D == null) {
                        this.f3035D = new Rect();
                    }
                    childAt.getHitRect(this.f3035D);
                    if (this.f3035D.contains((int) x, (int) y) && !m1459j(childAt)) {
                        if (!childAt.getMatrix().isIdentity()) {
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.offsetLocation(getScrollX() - childAt.getLeft(), getScrollY() - childAt.getTop());
                            Matrix matrix = childAt.getMatrix();
                            if (!matrix.isIdentity()) {
                                if (this.f3036E == null) {
                                    this.f3036E = new Matrix();
                                }
                                matrix.invert(this.f3036E);
                                obtain.transform(this.f3036E);
                            }
                            dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                            obtain.recycle();
                        } else {
                            float scrollX = getScrollX() - childAt.getLeft();
                            float scrollY = getScrollY() - childAt.getTop();
                            motionEvent.offsetLocation(scrollX, scrollY);
                            dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                            motionEvent.offsetLocation(-scrollX, -scrollY);
                        }
                        if (dispatchGenericMotionEvent) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean m1459j = m1459j(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (m1459j) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if ((background != null && background.getOpacity() == -1) && m1458k(childAt) && childAt.getHeight() >= height) {
                        if (m1468a(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i2) {
                                i2 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.f3041f;
        if (f > 0.0f && m1459j) {
            int i4 = this.f3040d;
            this.f3042g.setColor((((int) ((((-16777216) & i4) >>> 24) * f)) << 24) | (i4 & 16777215));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f3042g);
        }
        return drawChild;
    }

    /* renamed from: e */
    public View m1464e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f3065d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: f */
    public View m1463f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1458k(childAt)) {
                if (m1458k(childAt)) {
                    if (((LayoutParams) childAt.getLayoutParams()).f3063b > 0.0f) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    /* renamed from: g */
    public int m1462g(View view) {
        if (m1458k(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).f3062a;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            int m1921d = C0492V4.C0496d.m1921d(this);
            if (i == 3) {
                int i2 = this.f3050o;
                if (i2 != 3) {
                    return i2;
                }
                int i3 = m1921d == 0 ? this.f3052q : this.f3053r;
                if (i3 != 3) {
                    return i3;
                }
            } else if (i == 5) {
                int i4 = this.f3051p;
                if (i4 != 3) {
                    return i4;
                }
                int i5 = m1921d == 0 ? this.f3053r : this.f3052q;
                if (i5 != 3) {
                    return i5;
                }
            } else if (i == 8388611) {
                int i6 = this.f3052q;
                if (i6 != 3) {
                    return i6;
                }
                int i7 = m1921d == 0 ? this.f3050o : this.f3051p;
                if (i7 != 3) {
                    return i7;
                }
            } else if (i == 8388613) {
                int i8 = this.f3053r;
                if (i8 != 3) {
                    return i8;
                }
                int i9 = m1921d == 0 ? this.f3051p : this.f3050o;
                if (i9 != 3) {
                    return i9;
                }
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* renamed from: h */
    public int m1461h(View view) {
        int i = ((LayoutParams) view.getLayoutParams()).f3062a;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        return Gravity.getAbsoluteGravity(i, C0492V4.C0496d.m1921d(this));
    }

    /* renamed from: j */
    public boolean m1459j(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3062a == 0;
    }

    /* renamed from: k */
    public boolean m1458k(View view) {
        int i = ((LayoutParams) view.getLayoutParams()).f3062a;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, C0492V4.C0496d.m1921d(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    /* renamed from: l */
    public void m1457l(View view) {
        if (m1458k(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f3049n) {
                layoutParams.f3063b = 1.0f;
                layoutParams.f3065d = 1;
                m1455n(view, true);
            } else {
                layoutParams.f3065d |= 2;
                if (m1468a(view, 3)) {
                    this.f3043h.m168x(view, 0, view.getTop());
                } else {
                    this.f3044i.m168x(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* renamed from: m */
    public void m1456m(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.f3063b) {
            return;
        }
        layoutParams.f3063b = f;
        List<InterfaceC0799d> list = this.f3056u;
        if (list == null) {
            return;
        }
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            this.f3056u.get(size).m1452b(view, f);
        }
    }

    /* renamed from: n */
    public final void m1455n(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !m1458k(childAt)) || (z && childAt == view)) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1925s(childAt, 1);
            } else {
                AtomicInteger atomicInteger2 = C0492V4.f1798a;
                C0492V4.C0495c.m1925s(childAt, 4);
            }
        }
    }

    /* renamed from: o */
    public void m1454o(int i, View view) {
        View rootView;
        int i2 = this.f3043h.f6752a;
        int i3 = this.f3044i.f6752a;
        int i4 = 2;
        if (i2 == 1 || i3 == 1) {
            i4 = 1;
        } else if (i2 != 2 && i3 != 2) {
            i4 = 0;
        }
        if (view != null && i == 0) {
            float f = ((LayoutParams) view.getLayoutParams()).f3063b;
            if (f == 0.0f) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.f3065d & 1) == 1) {
                    layoutParams.f3065d = 0;
                    List<InterfaceC0799d> list = this.f3056u;
                    if (list != null) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            this.f3056u.get(size).m1450d(view);
                        }
                    }
                    m1455n(view, false);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f == 1.0f) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                if ((layoutParams2.f3065d & 1) == 0) {
                    layoutParams2.f3065d = 1;
                    List<InterfaceC0799d> list2 = this.f3056u;
                    if (list2 != null) {
                        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                            this.f3056u.get(size2).m1451c(view);
                        }
                    }
                    m1455n(view, true);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i4 != this.f3047l) {
            this.f3047l = i4;
            List<InterfaceC0799d> list3 = this.f3056u;
            if (list3 != null) {
                for (int size3 = list3.size() - 1; size3 >= 0; size3--) {
                    this.f3056u.get(size3).m1453a(i4);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3049n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3049n = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3033B || this.f3059x == null) {
            return;
        }
        Object obj = this.f3032A;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f3059x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f3059x.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[LOOP:1: B:11:0x0024->B:21:0x0054, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0052 A[SYNTHETIC] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            w5 r1 = r8.f3043h
            boolean r1 = r1.m169w(r9)
            w5 r2 = r8.f3044i
            boolean r2 = r2.m169w(r9)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L6c
            if (r0 == r2) goto L65
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L65
            goto L6a
        L1e:
            w5 r9 = r8.f3043h
            float[] r0 = r9.f6755d
            int r0 = r0.length
            r4 = 0
        L24:
            if (r4 >= r0) goto L57
            boolean r5 = r9.m178n(r4)
            if (r5 != 0) goto L2d
            goto L4f
        L2d:
            float[] r5 = r9.f6757f
            r5 = r5[r4]
            float[] r6 = r9.f6755d
            r6 = r6[r4]
            float r5 = r5 - r6
            float[] r6 = r9.f6758g
            r6 = r6[r4]
            float[] r7 = r9.f6756e
            r7 = r7[r4]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r9.f6753b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L4f
            r5 = 1
            goto L50
        L4f:
            r5 = 0
        L50:
            if (r5 == 0) goto L54
            r9 = 1
            goto L58
        L54:
            int r4 = r4 + 1
            goto L24
        L57:
            r9 = 0
        L58:
            if (r9 == 0) goto L6a
            androidx.drawerlayout.widget.DrawerLayout$e r9 = r8.f3045j
            r9.m1448b()
            androidx.drawerlayout.widget.DrawerLayout$e r9 = r8.f3046k
            r9.m1448b()
            goto L6a
        L65:
            r8.m1466c(r2)
            r8.f3054s = r3
        L6a:
            r9 = 0
            goto L94
        L6c:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.f3057v = r0
            r8.f3058w = r9
            float r4 = r8.f3041f
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L91
            w5 r4 = r8.f3043h
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r4.m180l(r0, r9)
            if (r9 == 0) goto L91
            boolean r9 = r8.m1459j(r9)
            if (r9 == 0) goto L91
            r9 = 1
            goto L92
        L91:
            r9 = 0
        L92:
            r8.f3054s = r3
        L94:
            if (r1 != 0) goto Lbb
            if (r9 != 0) goto Lbb
            int r9 = r8.getChildCount()
            r0 = 0
        L9d:
            if (r0 >= r9) goto Lb2
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r1 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r1
            boolean r1 = r1.f3064c
            if (r1 == 0) goto Laf
            r9 = 1
            goto Lb3
        Laf:
            int r0 = r0 + 1
            goto L9d
        Lb2:
            r9 = 0
        Lb3:
            if (r9 != 0) goto Lbb
            boolean r9 = r8.f3054s
            if (r9 == 0) goto Lba
            goto Lbb
        Lba:
            r2 = 0
        Lbb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (m1463f() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View m1463f = m1463f();
            if (m1463f != null && m1462g(m1463f) == 0) {
                m1466c(false);
            }
            return m1463f != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        this.f3048m = true;
        int i7 = i3 - i;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m1459j(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m1468a(childAt, 3)) {
                        float f2 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.f3063b * f2));
                        f = (measuredWidth + i6) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i7 - i5) / f3;
                        i6 = i7 - ((int) (layoutParams.f3063b * f3));
                    }
                    boolean z2 = f != layoutParams.f3063b;
                    int i10 = layoutParams.f3062a & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z2) {
                        m1456m(childAt, f);
                    }
                    int i18 = layoutParams.f3063b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.f3048m = false;
        this.f3049n = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View m1465d;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f3066a;
        if (i != 0 && (m1465d = m1465d(i)) != null) {
            m1457l(m1465d);
        }
        int i2 = savedState.f3067b;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = savedState.f3068c;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = savedState.f3069d;
        if (i4 != 3) {
            setDrawerLockMode(i4, 8388611);
        }
        int i5 = savedState.f3070f;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int i2 = layoutParams.f3065d;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                savedState.f3066a = layoutParams.f3062a;
                break;
            }
        }
        savedState.f3067b = this.f3050o;
        savedState.f3068c = this.f3051p;
        savedState.f3069d = this.f3052q;
        savedState.f3070f = this.f3053r;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (m1462g(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            w5 r0 = r6.f3043h
            r0.m176p(r7)
            w5 r0 = r6.f3044i
            r0.m176p(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L60
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6e
        L1a:
            r6.m1466c(r2)
            r6.f3054s = r1
            goto L6e
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            w5 r3 = r6.f3043h
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.m180l(r4, r5)
            if (r3 == 0) goto L5b
            boolean r3 = r6.m1459j(r3)
            if (r3 == 0) goto L5b
            float r3 = r6.f3057v
            float r0 = r0 - r3
            float r3 = r6.f3058w
            float r7 = r7 - r3
            w5 r3 = r6.f3043h
            int r3 = r3.f6753b
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r7 = r7 + r0
            int r3 = r3 * r3
            float r0 = (float) r3
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L5b
            android.view.View r7 = r6.m1464e()
            if (r7 == 0) goto L5b
            int r7 = r6.m1462g(r7)
            r0 = 2
            if (r7 != r0) goto L5c
        L5b:
            r1 = 1
        L5c:
            r6.m1466c(r1)
            goto L6e
        L60:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f3057v = r0
            r6.f3058w = r7
            r6.f3054s = r1
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m1466c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3048m) {
            return;
        }
        super.requestLayout();
    }

    public void setChildInsets(Object obj, boolean z) {
        this.f3032A = obj;
        this.f3033B = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f3038b = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m1458k(childAt)) {
                float f2 = this.f3038b;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0500h.m1882s(childAt, f2);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(InterfaceC0799d interfaceC0799d) {
        List<InterfaceC0799d> list;
        InterfaceC0799d interfaceC0799d2 = this.f3055t;
        if (interfaceC0799d2 != null && interfaceC0799d2 != null && (list = this.f3056u) != null) {
            list.remove(interfaceC0799d2);
        }
        if (interfaceC0799d != null) {
            if (this.f3056u == null) {
                this.f3056u = new ArrayList();
            }
            this.f3056u.add(interfaceC0799d);
        }
        this.f3055t = interfaceC0799d;
    }

    public void setDrawerLockMode(int i, int i2) {
        View m1465d;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, C0492V4.C0496d.m1921d(this));
        if (i2 == 3) {
            this.f3050o = i;
        } else if (i2 == 5) {
            this.f3051p = i;
        } else if (i2 == 8388611) {
            this.f3052q = i;
        } else if (i2 == 8388613) {
            this.f3053r = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f3043h : this.f3044i).m191a();
        }
        if (i != 1) {
            if (i == 2 && (m1465d = m1465d(absoluteGravity)) != null) {
                m1457l(m1465d);
                return;
            }
            return;
        }
        View m1465d2 = m1465d(absoluteGravity);
        if (m1465d2 != null) {
            m1467b(m1465d2);
        }
    }

    public void setDrawerShadow(int i, int i2) {
        Context context = getContext();
        Object obj = C2307w3.f6741a;
        setDrawerShadow(C2307w3.C2310c.m202b(context, i), i2);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        AtomicInteger atomicInteger = C0492V4.f1798a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, C0492V4.C0496d.m1921d(this));
        if (absoluteGravity == 3) {
            this.f3060y = charSequence;
        } else if (absoluteGravity == 5) {
            this.f3061z = charSequence;
        }
    }

    public void setScrimColor(int i) {
        this.f3040d = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f3059x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f3059x = new ColorDrawable(i);
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3037a = new C0798c();
        this.f3040d = -1728053248;
        this.f3042g = new Paint();
        this.f3049n = true;
        this.f3050o = 3;
        this.f3051p = 3;
        this.f3052q = 3;
        this.f3053r = 3;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f3039c = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        C0800e c0800e = new C0800e(3);
        this.f3045j = c0800e;
        C0800e c0800e2 = new C0800e(5);
        this.f3046k = c0800e2;
        C2319w5 m182j = C2319w5.m182j(this, 1.0f, c0800e);
        this.f3043h = m182j;
        m182j.f6767p = 1;
        m182j.f6765n = f2;
        c0800e.f3074b = m182j;
        C2319w5 m182j2 = C2319w5.m182j(this, 1.0f, c0800e2);
        this.f3044i = m182j2;
        m182j2.f6767p = 2;
        m182j2.f6765n = f2;
        c0800e2.f3074b = m182j2;
        setFocusableInTouchMode(true);
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1925s(this, 1);
        C0492V4.m1950u(this, new C0797b());
        setMotionEventSplittingEnabled(false);
        if (C0492V4.C0495c.m1942b(this)) {
            setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListenerC0796a(this));
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f3030F);
            try {
                this.f3059x = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f3038b = f * 10.0f;
        this.f3034C = new ArrayList<>();
    }

    public void setStatusBarBackground(int i) {
        Drawable drawable;
        if (i != 0) {
            Context context = getContext();
            Object obj = C2307w3.f6741a;
            drawable = C2307w3.C2310c.m202b(context, i);
        } else {
            drawable = null;
        }
        this.f3059x = drawable;
        invalidate();
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f3062a;

        /* renamed from: b */
        public float f3063b;

        /* renamed from: c */
        public boolean f3064c;

        /* renamed from: d */
        public int f3065d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3062a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f3031G);
            this.f3062a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3062a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f3062a = 0;
            this.f3062a = layoutParams.f3062a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3062a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3062a = 0;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0795a();

        /* renamed from: a */
        public int f3066a;

        /* renamed from: b */
        public int f3067b;

        /* renamed from: c */
        public int f3068c;

        /* renamed from: d */
        public int f3069d;

        /* renamed from: f */
        public int f3070f;

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0795a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3066a = 0;
            this.f3066a = parcel.readInt();
            this.f3067b = parcel.readInt();
            this.f3068c = parcel.readInt();
            this.f3069d = parcel.readInt();
            this.f3070f = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3066a);
            parcel.writeInt(this.f3067b);
            parcel.writeInt(this.f3068c);
            parcel.writeInt(this.f3069d);
            parcel.writeInt(this.f3070f);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f3066a = 0;
        }
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, View view) {
        if (m1458k(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).f3062a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }
}
