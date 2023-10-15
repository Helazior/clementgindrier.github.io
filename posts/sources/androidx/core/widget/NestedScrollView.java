package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.kxml2.wap.Wbxml;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import p000.C0492V4;
import p000.C1617d5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0287M4, InterfaceC0215J4 {

    /* renamed from: B */
    public static final C0741a f2999B = new C0741a();

    /* renamed from: C */
    public static final int[] f3000C = {16843130};

    /* renamed from: A */
    public InterfaceC0742b f3001A;

    /* renamed from: a */
    public long f3002a;

    /* renamed from: b */
    public final Rect f3003b;

    /* renamed from: c */
    public OverScroller f3004c;

    /* renamed from: d */
    public EdgeEffect f3005d;

    /* renamed from: f */
    public EdgeEffect f3006f;

    /* renamed from: g */
    public int f3007g;

    /* renamed from: h */
    public boolean f3008h;

    /* renamed from: i */
    public boolean f3009i;

    /* renamed from: j */
    public View f3010j;

    /* renamed from: k */
    public boolean f3011k;

    /* renamed from: l */
    public VelocityTracker f3012l;

    /* renamed from: m */
    public boolean f3013m;

    /* renamed from: n */
    public boolean f3014n;

    /* renamed from: o */
    public int f3015o;

    /* renamed from: p */
    public int f3016p;

    /* renamed from: q */
    public int f3017q;

    /* renamed from: r */
    public int f3018r;

    /* renamed from: s */
    public final int[] f3019s;

    /* renamed from: t */
    public final int[] f3020t;

    /* renamed from: u */
    public int f3021u;

    /* renamed from: v */
    public int f3022v;

    /* renamed from: w */
    public SavedState f3023w;

    /* renamed from: x */
    public final C0310N4 f3024x;

    /* renamed from: y */
    public final C0235K4 f3025y;

    /* renamed from: z */
    public float f3026z;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0740a();

        /* renamed from: a */
        public int f3027a;

        /* renamed from: androidx.core.widget.NestedScrollView$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0740a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("HorizontalScrollView.SavedState{");
            m253r.append(Integer.toHexString(System.identityHashCode(this)));
            m253r.append(" scrollPosition=");
            return outline.m263h(m253r, this.f3027a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3027a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3027a = parcel.readInt();
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0741a extends C0130F4 {
        @Override // p000.C0130F4
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.m1482l() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.m1482l());
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
            int m1482l;
            super.onInitializeAccessibilityNodeInfo(view, c1617d5);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c1617d5.f3986a.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (m1482l = nestedScrollView.m1482l()) <= 0) {
                return;
            }
            c1617d5.f3986a.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                c1617d5.m1032a(C1617d5.C1618a.f3993i);
                c1617d5.m1032a(C1617d5.C1618a.f3997m);
            }
            if (nestedScrollView.getScrollY() < m1482l) {
                c1617d5.m1032a(C1617d5.C1618a.f3992h);
                c1617d5.m1032a(C1617d5.C1618a.f3998n);
            }
        }

        @Override // p000.C0130F4
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                if (i != 4096) {
                    if (i == 8192 || i == 16908344) {
                        int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                        if (max != nestedScrollView.getScrollY()) {
                            nestedScrollView.m1471w(0 - nestedScrollView.getScrollX(), max - nestedScrollView.getScrollY(), BaseTransientBottomBar.ANIMATION_DURATION, true);
                            return true;
                        }
                        return false;
                    } else if (i != 16908346) {
                        return false;
                    }
                }
                int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.m1482l());
                if (min != nestedScrollView.getScrollY()) {
                    nestedScrollView.m1471w(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), BaseTransientBottomBar.ANIMATION_DURATION, true);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0742b {
        /* renamed from: a */
        void mo459a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    public static int m1491c(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* renamed from: n */
    public static boolean m1480n(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m1480n((View) parent, view2);
    }

    /* renamed from: a */
    public final void m1493a() {
        this.f3004c.abortAnimation();
        this.f3025y.m2336i(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: b */
    public boolean m1492b(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int height = (int) (getHeight() * 0.5f);
        if (findNextFocus != null && m1479o(findNextFocus, height, getHeight())) {
            findNextFocus.getDrawingRect(this.f3003b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f3003b);
            m1488f(m1490d(this.f3003b));
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < height) {
                height = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                height = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), height);
            }
            if (height == 0) {
                return false;
            }
            if (i != 130) {
                height = -height;
            }
            m1488f(height);
        }
        if (findFocus != null && findFocus.isFocused() && (!m1479o(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(PKIFailureInfo.unsupportedVersion);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f3004c.isFinished()) {
            return;
        }
        this.f3004c.computeScrollOffset();
        int currY = this.f3004c.getCurrY();
        int i = currY - this.f3022v;
        this.f3022v = currY;
        int[] iArr = this.f3020t;
        boolean z = false;
        iArr[1] = 0;
        m1489e(0, i, iArr, null, 1);
        int i2 = i - this.f3020t[1];
        int m1482l = m1482l();
        if (i2 != 0) {
            int scrollY = getScrollY();
            m1476r(0, i2, getScrollX(), scrollY, 0, m1482l, 0, 0);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.f3020t;
            iArr2[1] = 0;
            this.f3025y.m2340e(0, scrollY2, 0, i3, this.f3019s, 1, iArr2);
            i2 = i3 - this.f3020t[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && m1482l > 0)) {
                z = true;
            }
            if (z) {
                m1486h();
                if (i2 < 0) {
                    if (this.f3005d.isFinished()) {
                        this.f3005d.onAbsorb((int) this.f3004c.getCurrVelocity());
                    }
                } else if (this.f3006f.isFinished()) {
                    this.f3006f.onAbsorb((int) this.f3004c.getCurrVelocity());
                }
            }
            m1493a();
        }
        if (!this.f3004c.isFinished()) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
            return;
        }
        this.f3025y.m2336i(1);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    /* renamed from: d */
    public int m1490d(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        } else if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        } else {
            if (rect.height() > height) {
                i = 0 - (i4 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            return Math.max(i, -getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1485i(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3025y.m2344a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3025y.m2343b(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return m1489e(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f3025y.m2341d(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f3005d != null) {
            int scrollY = getScrollY();
            int i2 = 0;
            if (!this.f3005d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingRight() + getPaddingLeft();
                    i = getPaddingLeft() + 0;
                } else {
                    i = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingBottom() + getPaddingTop();
                    min += getPaddingTop();
                }
                canvas.translate(i, min);
                this.f3005d.setSize(width, height);
                if (this.f3005d.draw(canvas)) {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0495c.m1933k(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.f3006f.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(m1482l(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i2 = 0 + getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate(i2 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f3006f.setSize(width2, height2);
            if (this.f3006f.draw(canvas)) {
                AtomicInteger atomicInteger2 = C0492V4.f1798a;
                C0492V4.C0495c.m1933k(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* renamed from: e */
    public boolean m1489e(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f3025y.m2342c(i, i2, iArr, iArr2, i3);
    }

    /* renamed from: f */
    public final void m1488f(int i) {
        if (i != 0) {
            if (this.f3014n) {
                m1471w(0, i, BaseTransientBottomBar.ANIMATION_DURATION, false);
            } else {
                scrollBy(0, i);
            }
        }
    }

    /* renamed from: g */
    public final void m1487g() {
        this.f3011k = false;
        m1475s();
        this.f3025y.m2336i(0);
        EdgeEffect edgeEffect = this.f3005d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f3006f.onRelease();
        }
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3024x.m2175a();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    /* renamed from: h */
    public final void m1486h() {
        if (getOverScrollMode() != 2) {
            if (this.f3005d == null) {
                Context context = getContext();
                this.f3005d = new EdgeEffect(context);
                this.f3006f = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.f3005d = null;
        this.f3006f = null;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return m1481m(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1485i(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m1485i(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f3025y.f729d;
    }

    /* renamed from: j */
    public void m1484j(int i) {
        if (getChildCount() > 0) {
            this.f3004c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m1474t(true);
        }
    }

    /* renamed from: k */
    public boolean m1483k(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f3003b;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3003b.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.f3003b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f3003b;
        return m1473u(i, rect3.top, rect3.bottom);
    }

    /* renamed from: l */
    public int m1482l() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    /* renamed from: m */
    public boolean m1481m(int i) {
        return this.f3025y.m2339f(i) != null;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    /* renamed from: o */
    public final boolean m1479o(View view, int i, int i2) {
        view.getDrawingRect(this.f3003b);
        offsetDescendantRectToMyCoords(view, this.f3003b);
        return this.f3003b.bottom + i >= getScrollY() && this.f3003b.top - i <= getScrollY() + i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3009i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f3011k) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                if (this.f3026z == 0.0f) {
                    TypedValue typedValue = new TypedValue();
                    Context context = getContext();
                    if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                        this.f3026z = typedValue.getDimension(context.getResources().getDisplayMetrics());
                    } else {
                        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                    }
                }
                int m1482l = m1482l();
                int scrollY = getScrollY();
                int i = scrollY - ((int) (axisValue * this.f3026z));
                if (i < 0) {
                    m1482l = 0;
                } else if (i <= m1482l) {
                    m1482l = i;
                }
                if (m1482l != scrollY) {
                    super.scrollTo(getScrollX(), m1482l);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.f3008h = false;
        View view = this.f3010j;
        if (view != null && m1480n(view, this)) {
            m1472v(this.f3010j);
        }
        this.f3010j = null;
        if (!this.f3009i) {
            if (this.f3023w != null) {
                scrollTo(getScrollX(), this.f3023w.f3027a);
                this.f3023w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int m1491c = m1491c(scrollY, paddingTop, i5);
            if (m1491c != scrollY) {
                scrollTo(getScrollX(), m1491c);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3009i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3013m && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        m1484j((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        m1489e(i, i2, iArr, null, 0);
    }

    @Override // p000.InterfaceC0287M4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        m1478p(i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3024x.f1023a = i;
        m1470x(2, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = Wbxml.EXT_T_2;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || (true ^ m1479o(findNextFocusFromRect, 0, getHeight()))) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3023w = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3027a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        InterfaceC0742b interfaceC0742b = this.f3001A;
        if (interfaceC0742b != null) {
            interfaceC0742b.mo459a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !m1479o(findFocus, 0, i4)) {
            return;
        }
        findFocus.getDrawingRect(this.f3003b);
        offsetDescendantRectToMyCoords(findFocus, this.f3003b);
        m1488f(m1490d(this.f3003b));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // p000.InterfaceC0267L4
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f3024x.f1023a = 0;
        m1469y(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.f3012l == null) {
            this.f3012l = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3021u = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f3021u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f3012l;
                velocityTracker.computeCurrentVelocity(1000, this.f3017q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f3018r);
                if (Math.abs(yVelocity) >= this.f3016p) {
                    int i = -yVelocity;
                    float f = i;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        m1484j(i);
                    }
                } else if (this.f3004c.springBack(getScrollX(), getScrollY(), 0, 0, 0, m1482l())) {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0495c.m1933k(this);
                }
                this.f3018r = -1;
                m1487g();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f3018r);
                if (findPointerIndex == -1) {
                    StringBuilder m253r = outline.m253r("Invalid pointerId=");
                    m253r.append(this.f3018r);
                    m253r.append(" in onTouchEvent");
                    Log.e("NestedScrollView", m253r.toString());
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.f3007g - y;
                    if (!this.f3011k && Math.abs(i2) > this.f3015o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3011k = true;
                        i2 = i2 > 0 ? i2 - this.f3015o : i2 + this.f3015o;
                    }
                    int i3 = i2;
                    if (this.f3011k) {
                        if (m1489e(0, i3, this.f3020t, this.f3019s, 0)) {
                            i3 -= this.f3020t[1];
                            this.f3021u += this.f3019s[1];
                        }
                        int i4 = i3;
                        this.f3007g = y - this.f3019s[1];
                        int scrollY = getScrollY();
                        int m1482l = m1482l();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && m1482l > 0);
                        if (m1476r(0, i4, 0, getScrollY(), 0, m1482l, 0, 0) && !m1481m(0)) {
                            this.f3012l.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f3020t;
                        iArr[1] = 0;
                        this.f3025y.m2340e(0, scrollY2, 0, i4 - scrollY2, this.f3019s, 0, iArr);
                        int i5 = this.f3007g;
                        int[] iArr2 = this.f3019s;
                        this.f3007g = i5 - iArr2[1];
                        this.f3021u += iArr2[1];
                        if (z) {
                            int i6 = i4 - this.f3020t[1];
                            m1486h();
                            int i7 = scrollY + i6;
                            if (i7 < 0) {
                                this.f3005d.onPull(i6 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.f3006f.isFinished()) {
                                    this.f3006f.onRelease();
                                }
                            } else if (i7 > m1482l) {
                                this.f3006f.onPull(i6 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.f3005d.isFinished()) {
                                    this.f3005d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f3005d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f3006f.isFinished())) {
                                AtomicInteger atomicInteger2 = C0492V4.f1798a;
                                C0492V4.C0495c.m1933k(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f3011k && getChildCount() > 0 && this.f3004c.springBack(getScrollX(), getScrollY(), 0, 0, 0, m1482l())) {
                    AtomicInteger atomicInteger3 = C0492V4.f1798a;
                    C0492V4.C0495c.m1933k(this);
                }
                this.f3018r = -1;
                m1487g();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3007g = (int) motionEvent.getY(actionIndex);
                this.f3018r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m1477q(motionEvent);
                this.f3007g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f3018r));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z2 = !this.f3004c.isFinished();
            this.f3011k = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3004c.isFinished()) {
                m1493a();
            }
            this.f3007g = (int) motionEvent.getY();
            this.f3018r = motionEvent.getPointerId(0);
            m1470x(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f3012l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* renamed from: p */
    public final void m1478p(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3025y.m2340e(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    /* renamed from: q */
    public final void m1477q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3018r) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f3007g = (int) motionEvent.getY(i);
            this.f3018r = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f3012l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1476r(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.m1481m(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f3004c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.m1482l()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m1476r(int, int, int, int, int, int, int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3008h) {
            m1472v(view2);
        } else {
            this.f3010j = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int m1490d = m1490d(rect);
        boolean z2 = m1490d != 0;
        if (z2) {
            if (z) {
                scrollBy(0, m1490d);
            } else {
                m1471w(0, m1490d, BaseTransientBottomBar.ANIMATION_DURATION, false);
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m1475s();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f3008h = true;
        super.requestLayout();
    }

    /* renamed from: s */
    public final void m1475s() {
        VelocityTracker velocityTracker = this.f3012l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3012l = null;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int m1491c = m1491c(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int m1491c2 = m1491c(i2, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (m1491c == getScrollX() && m1491c2 == getScrollY()) {
                return;
            }
            super.scrollTo(m1491c, m1491c2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f3013m) {
            this.f3013m = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0235K4 c0235k4 = this.f3025y;
        if (c0235k4.f729d) {
            View view = c0235k4.f728c;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1875z(view);
        }
        c0235k4.f729d = z;
    }

    public void setOnScrollChangeListener(InterfaceC0742b interfaceC0742b) {
        this.f3001A = interfaceC0742b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f3014n = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f3025y.m2337h(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f3025y.m2336i(0);
    }

    /* renamed from: t */
    public final void m1474t(boolean z) {
        if (z) {
            m1470x(2, 1);
        } else {
            this.f3025y.m2336i(1);
        }
        this.f3022v = getScrollY();
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1933k(this);
    }

    /* renamed from: u */
    public final boolean m1473u(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else {
                        if (!z5) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m1488f(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    /* renamed from: v */
    public final void m1472v(View view) {
        view.getDrawingRect(this.f3003b);
        offsetDescendantRectToMyCoords(view, this.f3003b);
        int m1490d = m1490d(this.f3003b);
        if (m1490d != 0) {
            scrollBy(0, m1490d);
        }
    }

    /* renamed from: w */
    public final void m1471w(int i, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3002a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f3004c;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i3);
            m1474t(z);
        } else {
            if (!this.f3004c.isFinished()) {
                m1493a();
            }
            scrollBy(i, i2);
        }
        this.f3002a = AnimationUtils.currentAnimationTimeMillis();
    }

    /* renamed from: x */
    public boolean m1470x(int i, int i2) {
        return this.f3025y.m2337h(i, i2);
    }

    /* renamed from: y */
    public void m1469y(int i) {
        this.f3025y.m2336i(i);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1615d3.nestedScrollViewStyle);
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        m1489e(i, i2, iArr, null, i3);
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        m1478p(i4, i5, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3003b = new Rect();
        this.f3008h = true;
        this.f3009i = false;
        this.f3010j = null;
        this.f3011k = false;
        this.f3014n = true;
        this.f3018r = -1;
        this.f3019s = new int[2];
        this.f3020t = new int[2];
        this.f3004c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3015o = viewConfiguration.getScaledTouchSlop();
        this.f3016p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3017q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3000C, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f3024x = new C0310N4();
        this.f3025y = new C0235K4(this);
        setNestedScrollingEnabled(true);
        C0492V4.m1950u(this, f2999B);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m1478p(i4, 0, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        C0310N4 c0310n4 = this.f3024x;
        if (i2 == 1) {
            c0310n4.f1024b = i;
        } else {
            c0310n4.f1023a = i;
        }
        m1470x(2, i2);
    }

    @Override // p000.InterfaceC0267L4
    public void onStopNestedScroll(View view, int i) {
        C0310N4 c0310n4 = this.f3024x;
        if (i == 1) {
            c0310n4.f1024b = 0;
        } else {
            c0310n4.f1023a = 0;
        }
        m1469y(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
