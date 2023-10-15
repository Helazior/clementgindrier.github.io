package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C2307w3;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: f0 */
    public static final int[] f3534f0 = {16842931};

    /* renamed from: g0 */
    public static final Comparator<C0928f> f3535g0 = new C0923a();

    /* renamed from: h0 */
    public static final Interpolator f3536h0 = new animationInterpolatorC0924b();

    /* renamed from: i0 */
    public static final C0934l f3537i0 = new C0934l();

    /* renamed from: A */
    public int f3538A;

    /* renamed from: B */
    public int f3539B;

    /* renamed from: C */
    public int f3540C;

    /* renamed from: D */
    public float f3541D;

    /* renamed from: E */
    public float f3542E;

    /* renamed from: F */
    public float f3543F;

    /* renamed from: G */
    public float f3544G;

    /* renamed from: H */
    public int f3545H;

    /* renamed from: I */
    public VelocityTracker f3546I;

    /* renamed from: J */
    public int f3547J;

    /* renamed from: K */
    public int f3548K;

    /* renamed from: L */
    public int f3549L;

    /* renamed from: M */
    public int f3550M;

    /* renamed from: N */
    public EdgeEffect f3551N;

    /* renamed from: O */
    public EdgeEffect f3552O;

    /* renamed from: P */
    public boolean f3553P;

    /* renamed from: Q */
    public boolean f3554Q;

    /* renamed from: R */
    public int f3555R;

    /* renamed from: S */
    public List<InterfaceC0931i> f3556S;

    /* renamed from: T */
    public InterfaceC0931i f3557T;

    /* renamed from: U */
    public InterfaceC0931i f3558U;

    /* renamed from: V */
    public List<InterfaceC0930h> f3559V;

    /* renamed from: W */
    public InterfaceC0932j f3560W;

    /* renamed from: a */
    public int f3561a;

    /* renamed from: a0 */
    public int f3562a0;

    /* renamed from: b */
    public final ArrayList<C0928f> f3563b;

    /* renamed from: b0 */
    public int f3564b0;

    /* renamed from: c */
    public final C0928f f3565c;

    /* renamed from: c0 */
    public ArrayList<View> f3566c0;

    /* renamed from: d */
    public final Rect f3567d;

    /* renamed from: d0 */
    public final Runnable f3568d0;

    /* renamed from: e0 */
    public int f3569e0;

    /* renamed from: f */
    public AbstractC1960l8 f3570f;

    /* renamed from: g */
    public int f3571g;

    /* renamed from: h */
    public int f3572h;

    /* renamed from: i */
    public Parcelable f3573i;

    /* renamed from: j */
    public ClassLoader f3574j;

    /* renamed from: k */
    public Scroller f3575k;

    /* renamed from: l */
    public boolean f3576l;

    /* renamed from: m */
    public C0933k f3577m;

    /* renamed from: n */
    public int f3578n;

    /* renamed from: o */
    public Drawable f3579o;

    /* renamed from: p */
    public int f3580p;

    /* renamed from: q */
    public int f3581q;

    /* renamed from: r */
    public float f3582r;

    /* renamed from: s */
    public float f3583s;

    /* renamed from: t */
    public int f3584t;

    /* renamed from: u */
    public boolean f3585u;

    /* renamed from: v */
    public boolean f3586v;

    /* renamed from: w */
    public boolean f3587w;

    /* renamed from: x */
    public int f3588x;

    /* renamed from: y */
    public boolean f3589y;

    /* renamed from: z */
    public boolean f3590z;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0922a();

        /* renamed from: a */
        public int f3597a;

        /* renamed from: b */
        public Parcelable f3598b;

        /* renamed from: c */
        public ClassLoader f3599c;

        /* renamed from: androidx.viewpager.widget.ViewPager$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0922a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("FragmentPager.SavedState{");
            m253r.append(Integer.toHexString(System.identityHashCode(this)));
            m253r.append(" position=");
            return outline.m263h(m253r, this.f3597a, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3597a);
            parcel.writeParcelable(this.f3598b, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.f3597a = parcel.readInt();
            this.f3598b = parcel.readParcelable(classLoader);
            this.f3599c = classLoader;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0923a implements Comparator<C0928f> {
        @Override // java.util.Comparator
        public int compare(C0928f c0928f, C0928f c0928f2) {
            return c0928f.f3603a - c0928f2.f3603a;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$b  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class animationInterpolatorC0924b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0925c implements Runnable {
        public RunnableC0925c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.m1230y(0);
            ViewPager viewPager = ViewPager.this;
            viewPager.m1236s(viewPager.f3571g);
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0926d implements InterfaceC0331O4 {

        /* renamed from: a */
        public final Rect f3601a = new Rect();

        public C0926d() {
        }

        @Override // p000.InterfaceC0331O4
        public C0958b5 onApplyWindowInsets(View view, C0958b5 c0958b5) {
            C0958b5 m1955p = C0492V4.m1955p(view, c0958b5);
            if (m1955p.m1183g()) {
                return m1955p;
            }
            Rect rect = this.f3601a;
            rect.left = m1955p.m1187c();
            rect.top = m1955p.m1185e();
            rect.right = m1955p.m1186d();
            rect.bottom = m1955p.m1188b();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                C0958b5 m1966e = C0492V4.m1966e(ViewPager.this.getChildAt(i), m1955p);
                rect.left = Math.min(m1966e.m1187c(), rect.left);
                rect.top = Math.min(m1966e.m1185e(), rect.top);
                rect.right = Math.min(m1966e.m1186d(), rect.right);
                rect.bottom = Math.min(m1966e.m1188b(), rect.bottom);
            }
            return m1955p.m1182h(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.viewpager.widget.ViewPager$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public @interface InterfaceC0927e {
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0928f {

        /* renamed from: a */
        public int f3603a;

        /* renamed from: b */
        public boolean f3604b;

        /* renamed from: c */
        public float f3605c;

        /* renamed from: d */
        public float f3606d;
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0929g extends C0130F4 {
        public C0929g() {
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AbstractC1960l8 abstractC1960l8;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AbstractC1960l8 abstractC1960l82 = ViewPager.this.f3570f;
            boolean z = true;
            accessibilityEvent.setScrollable((abstractC1960l82 == null || abstractC1960l82.m611b() <= 1) ? false : false);
            if (accessibilityEvent.getEventType() != 4096 || (abstractC1960l8 = ViewPager.this.f3570f) == null) {
                return;
            }
            accessibilityEvent.setItemCount(abstractC1960l8.m611b());
            accessibilityEvent.setFromIndex(ViewPager.this.f3571g);
            accessibilityEvent.setToIndex(ViewPager.this.f3571g);
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
            super.onInitializeAccessibilityNodeInfo(view, c1617d5);
            c1617d5.f3986a.setClassName(ViewPager.class.getName());
            AbstractC1960l8 abstractC1960l8 = ViewPager.this.f3570f;
            c1617d5.f3986a.setScrollable(abstractC1960l8 != null && abstractC1960l8.m611b() > 1);
            if (ViewPager.this.canScrollHorizontally(1)) {
                c1617d5.f3986a.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                c1617d5.f3986a.addAction(8192);
            }
        }

        @Override // p000.C0130F4
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i == 8192 && ViewPager.this.canScrollHorizontally(-1)) {
                    ViewPager viewPager = ViewPager.this;
                    viewPager.setCurrentItem(viewPager.f3571g - 1);
                    return true;
                }
                return false;
            } else if (ViewPager.this.canScrollHorizontally(1)) {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f3571g + 1);
                return true;
            } else {
                return false;
            }
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0930h {
        void onAdapterChanged(ViewPager viewPager, AbstractC1960l8 abstractC1960l8, AbstractC1960l8 abstractC1960l82);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0931i {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0932j {
        /* renamed from: a */
        void m1228a(View view, float f);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0933k extends DataSetObserver {
        public C0933k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.m1250e();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.m1250e();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0934l implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f3591a;
            if (z != layoutParams2.f3591a) {
                return z ? 1 : -1;
            }
            return layoutParams.f3595e - layoutParams2.f3595e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f3563b = new ArrayList<>();
        this.f3565c = new C0928f();
        this.f3567d = new Rect();
        this.f3572h = -1;
        this.f3573i = null;
        this.f3574j = null;
        this.f3582r = -3.4028235E38f;
        this.f3583s = Float.MAX_VALUE;
        this.f3588x = 1;
        this.f3545H = -1;
        this.f3553P = true;
        this.f3568d0 = new RunnableC0925c();
        this.f3569e0 = 0;
        m1243l();
    }

    /* renamed from: A */
    public final void m1255A() {
        if (this.f3564b0 != 0) {
            ArrayList<View> arrayList = this.f3566c0;
            if (arrayList == null) {
                this.f3566c0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f3566c0.add(getChildAt(i));
            }
            Collections.sort(this.f3566c0, f3537i0);
        }
    }

    /* renamed from: a */
    public C0928f m1254a(int i, int i2) {
        Objects.requireNonNull(this.f3570f);
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C0928f m1246i;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (m1246i = m1246i(childAt)) != null && m1246i.f3603a == this.f3571g) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C0928f m1246i;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (m1246i = m1246i(childAt)) != null && m1246i.f3603a == this.f3571g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.f3591a | (view.getClass().getAnnotation(InterfaceC0927e.class) != null);
        layoutParams2.f3591a = z;
        if (!this.f3585u) {
            super.addView(view, i, layoutParams);
        } else if (!z) {
            layoutParams2.f3594d = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1253b(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto La
            goto L63
        La:
            if (r0 == 0) goto L64
            android.view.ViewParent r4 = r0.getParent()
        L10:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1d
            if (r4 != r6) goto L18
            r4 = 1
            goto L1e
        L18:
            android.view.ViewParent r4 = r4.getParent()
            goto L10
        L1d:
            r4 = 0
        L1e:
            if (r4 != 0) goto L64
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L34:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L34
        L4d:
            java.lang.String r0 = "arrowScroll tried to find focus based on non-child current focused view "
            java.lang.StringBuilder r0 = p000.outline.m253r(r0)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
        L63:
            r0 = r3
        L64:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lb5
            if (r3 == r0) goto Lb5
            if (r7 != r5) goto L95
            android.graphics.Rect r1 = r6.f3567d
            android.graphics.Rect r1 = r6.m1248g(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f3567d
            android.graphics.Rect r2 = r6.m1248g(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L8f
            if (r1 < r2) goto L8f
            boolean r0 = r6.m1240o()
            goto L93
        L8f:
            boolean r0 = r3.requestFocus()
        L93:
            r2 = r0
            goto Lc8
        L95:
            if (r7 != r4) goto Lc8
            android.graphics.Rect r1 = r6.f3567d
            android.graphics.Rect r1 = r6.m1248g(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f3567d
            android.graphics.Rect r2 = r6.m1248g(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto Lb0
            if (r1 > r2) goto Lb0
            boolean r0 = r6.m1239p()
            goto L93
        Lb0:
            boolean r0 = r3.requestFocus()
            goto L93
        Lb5:
            if (r7 == r5) goto Lc4
            if (r7 != r1) goto Lba
            goto Lc4
        Lba:
            if (r7 == r4) goto Lbf
            r0 = 2
            if (r7 != r0) goto Lc8
        Lbf:
            boolean r2 = r6.m1239p()
            goto Lc8
        Lc4:
            boolean r2 = r6.m1240o()
        Lc8:
            if (r2 == 0) goto Ld1
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m1253b(int):boolean");
    }

    /* renamed from: c */
    public boolean m1252c(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && m1252c(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f3570f == null) {
            return false;
        }
        int m1247h = m1247h();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) m1247h) * this.f3582r)) : i > 0 && scrollX < ((int) (((float) m1247h) * this.f3583s));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f3576l = true;
        if (!this.f3575k.isFinished() && this.f3575k.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f3575k.getCurrX();
            int currY = this.f3575k.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m1238q(currX)) {
                    this.f3575k.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
            return;
        }
        m1251d(true);
    }

    /* renamed from: d */
    public final void m1251d(boolean z) {
        boolean z2 = this.f3569e0 == 2;
        if (z2) {
            m1229z(false);
            if (!this.f3575k.isFinished()) {
                this.f3575k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f3575k.getCurrX();
                int currY = this.f3575k.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1238q(currX);
                    }
                }
            }
        }
        this.f3587w = false;
        for (int i = 0; i < this.f3563b.size(); i++) {
            C0928f c0928f = this.f3563b.get(i);
            if (c0928f.f3604b) {
                c0928f.f3604b = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                Runnable runnable = this.f3568d0;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1931m(this, runnable);
                return;
            }
            this.f3568d0.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L5d
            int r0 = r6.getAction()
            if (r0 != 0) goto L5a
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L5a
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r6 = r5.m1253b(r4)
            goto L5b
        L2b:
            boolean r6 = r6.hasModifiers(r2)
            if (r6 == 0) goto L5a
            boolean r6 = r5.m1253b(r2)
            goto L5b
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r6 = r5.m1239p()
            goto L5b
        L41:
            r6 = 66
            boolean r6 = r5.m1253b(r6)
            goto L5b
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L53
            boolean r6 = r5.m1240o()
            goto L5b
        L53:
            r6 = 17
            boolean r6 = r5.m1253b(r6)
            goto L5b
        L5a:
            r6 = 0
        L5b:
            if (r6 == 0) goto L5e
        L5d:
            r1 = 1
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C0928f m1246i;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (m1246i = m1246i(childAt)) != null && m1246i.f3603a == this.f3571g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        AbstractC1960l8 abstractC1960l8;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (abstractC1960l8 = this.f3570f) == null || abstractC1960l8.m611b() <= 1)) {
            this.f3551N.finish();
            this.f3552O.finish();
        } else {
            if (!this.f3551N.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f3582r * width);
                this.f3551N.setSize(height, width);
                z = false | this.f3551N.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f3552O.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f3583s + 1.0f)) * width2);
                this.f3552O.setSize(height2, width2);
                z |= this.f3552O.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3579o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    /* renamed from: e */
    public void m1250e() {
        int m611b = this.f3570f.m611b();
        this.f3561a = m611b;
        boolean z = this.f3563b.size() < (this.f3588x * 2) + 1 && this.f3563b.size() < m611b;
        int i = this.f3571g;
        for (int i2 = 0; i2 < this.f3563b.size(); i2++) {
            AbstractC1960l8 abstractC1960l8 = this.f3570f;
            Objects.requireNonNull(this.f3563b.get(i2));
            Objects.requireNonNull(abstractC1960l8);
        }
        Collections.sort(this.f3563b, f3535g0);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.f3591a) {
                    layoutParams.f3593c = 0.0f;
                }
            }
            m1231x(i, false, true, 0);
            requestLayout();
        }
    }

    /* renamed from: f */
    public final void m1249f(int i) {
        InterfaceC0931i interfaceC0931i = this.f3557T;
        if (interfaceC0931i != null) {
            interfaceC0931i.onPageSelected(i);
        }
        List<InterfaceC0931i> list = this.f3556S;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0931i interfaceC0931i2 = this.f3556S.get(i2);
                if (interfaceC0931i2 != null) {
                    interfaceC0931i2.onPageSelected(i);
                }
            }
        }
        InterfaceC0931i interfaceC0931i3 = this.f3558U;
        if (interfaceC0931i3 != null) {
            interfaceC0931i3.onPageSelected(i);
        }
    }

    /* renamed from: g */
    public final Rect m1248g(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f3564b0 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f3566c0.get(i2).getLayoutParams()).f3596f;
    }

    /* renamed from: h */
    public final int m1247h() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: i */
    public C0928f m1246i(View view) {
        for (int i = 0; i < this.f3563b.size(); i++) {
            C0928f c0928f = this.f3563b.get(i);
            AbstractC1960l8 abstractC1960l8 = this.f3570f;
            Objects.requireNonNull(c0928f);
            if (abstractC1960l8.m610c(view, null)) {
                return c0928f;
            }
        }
        return null;
    }

    /* renamed from: j */
    public final C0928f m1245j() {
        int i;
        int m1247h = m1247h();
        float f = 0.0f;
        float scrollX = m1247h > 0 ? getScrollX() / m1247h : 0.0f;
        float f2 = m1247h > 0 ? this.f3578n / m1247h : 0.0f;
        C0928f c0928f = null;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.f3563b.size()) {
            C0928f c0928f2 = this.f3563b.get(i3);
            if (!z && c0928f2.f3603a != (i = i2 + 1)) {
                c0928f2 = this.f3565c;
                c0928f2.f3606d = f + f3 + f2;
                c0928f2.f3603a = i;
                Objects.requireNonNull(this.f3570f);
                c0928f2.f3605c = 1.0f;
                i3--;
            }
            f = c0928f2.f3606d;
            float f4 = c0928f2.f3605c + f + f2;
            if (!z && scrollX < f) {
                return c0928f;
            }
            if (scrollX < f4 || i3 == this.f3563b.size() - 1) {
                return c0928f2;
            }
            i2 = c0928f2.f3603a;
            f3 = c0928f2.f3605c;
            i3++;
            c0928f = c0928f2;
            z = false;
        }
        return c0928f;
    }

    /* renamed from: k */
    public C0928f m1244k(int i) {
        for (int i2 = 0; i2 < this.f3563b.size(); i2++) {
            C0928f c0928f = this.f3563b.get(i2);
            if (c0928f.f3603a == i) {
                return c0928f;
            }
        }
        return null;
    }

    /* renamed from: l */
    public void m1243l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f3575k = new Scroller(context, f3536h0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3540C = viewConfiguration.getScaledPagingTouchSlop();
        this.f3547J = (int) (400.0f * f);
        this.f3548K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3551N = new EdgeEffect(context);
        this.f3552O = new EdgeEffect(context);
        this.f3549L = (int) (25.0f * f);
        this.f3550M = (int) (2.0f * f);
        this.f3538A = (int) (f * 16.0f);
        C0492V4.m1950u(this, new C0929g());
        if (C0492V4.C0495c.m1941c(this) == 0) {
            C0492V4.C0495c.m1925s(this, 1);
        }
        C0492V4.C0500h.m1880u(this, new C0926d());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1242m(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f3555R
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f3591a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f3592b
            r9 = r9 & 7
            if (r9 == r2) goto L4d
            r10 = 3
            if (r9 == r10) goto L47
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5c
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L59
        L47:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L59:
            r11 = r9
            r9 = r3
            r3 = r11
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            androidx.viewpager.widget.ViewPager$i r0 = r12.f3557T
            if (r0 == 0) goto L72
            r0.onPageScrolled(r13, r14, r15)
        L72:
            java.util.List<androidx.viewpager.widget.ViewPager$i> r0 = r12.f3556S
            if (r0 == 0) goto L8d
            int r0 = r0.size()
            r3 = 0
        L7b:
            if (r3 >= r0) goto L8d
            java.util.List<androidx.viewpager.widget.ViewPager$i> r4 = r12.f3556S
            java.lang.Object r4 = r4.get(r3)
            androidx.viewpager.widget.ViewPager$i r4 = (androidx.viewpager.widget.ViewPager.InterfaceC0931i) r4
            if (r4 == 0) goto L8a
            r4.onPageScrolled(r13, r14, r15)
        L8a:
            int r3 = r3 + 1
            goto L7b
        L8d:
            androidx.viewpager.widget.ViewPager$i r0 = r12.f3558U
            if (r0 == 0) goto L94
            r0.onPageScrolled(r13, r14, r15)
        L94:
            androidx.viewpager.widget.ViewPager$j r13 = r12.f3560W
            if (r13 == 0) goto Lc5
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        La0:
            if (r1 >= r14) goto Lc5
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f3591a
            if (r0 == 0) goto Lb1
            goto Lc2
        Lb1:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.m1247h()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$j r3 = r12.f3560W
            r3.m1228a(r15, r0)
        Lc2:
            int r1 = r1 + 1
            goto La0
        Lc5:
            r12.f3554Q = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m1242m(int, float, int):void");
    }

    /* renamed from: n */
    public final void m1241n(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3545H) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f3541D = motionEvent.getX(i);
            this.f3545H = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f3546I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: o */
    public boolean m1240o() {
        int i = this.f3571g;
        if (i > 0) {
            setCurrentItem(i - 1, true);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3553P = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f3568d0);
        Scroller scroller = this.f3575k;
        if (scroller != null && !scroller.isFinished()) {
            this.f3575k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int i;
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.f3578n <= 0 || this.f3579o == null || this.f3563b.size() <= 0 || this.f3570f == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f3 = this.f3578n / width2;
        int i2 = 0;
        C0928f c0928f = this.f3563b.get(0);
        float f4 = c0928f.f3606d;
        int size = this.f3563b.size();
        int i3 = c0928f.f3603a;
        int i4 = this.f3563b.get(size - 1).f3603a;
        while (i3 < i4) {
            while (true) {
                i = c0928f.f3603a;
                if (i3 <= i || i2 >= size) {
                    break;
                }
                i2++;
                c0928f = this.f3563b.get(i2);
            }
            if (i3 == i) {
                float f5 = c0928f.f3606d;
                float f6 = c0928f.f3605c;
                f = (f5 + f6) * width2;
                f4 = f5 + f6 + f3;
            } else {
                Objects.requireNonNull(this.f3570f);
                f = (f4 + 1.0f) * width2;
                f4 = 1.0f + f3 + f4;
            }
            if (this.f3578n + f > scrollX) {
                f2 = f3;
                this.f3579o.setBounds(Math.round(f), this.f3580p, Math.round(this.f3578n + f), this.f3581q);
                this.f3579o.draw(canvas);
            } else {
                f2 = f3;
            }
            if (f > scrollX + width) {
                return;
            }
            i3++;
            f3 = f2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f3589y) {
                    return true;
                }
                if (this.f3590z) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.f3543F = x;
                this.f3541D = x;
                float y = motionEvent.getY();
                this.f3544G = y;
                this.f3542E = y;
                this.f3545H = motionEvent.getPointerId(0);
                this.f3590z = false;
                this.f3576l = true;
                this.f3575k.computeScrollOffset();
                if (this.f3569e0 == 2 && Math.abs(this.f3575k.getFinalX() - this.f3575k.getCurrX()) > this.f3550M) {
                    this.f3575k.abortAnimation();
                    this.f3587w = false;
                    m1236s(this.f3571g);
                    this.f3589y = true;
                    m1234u(true);
                    m1230y(1);
                } else {
                    m1251d(false);
                    this.f3589y = false;
                }
            } else if (action == 2) {
                int i = this.f3545H;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f = x2 - this.f3541D;
                    float abs = Math.abs(f);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f3544G);
                    int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                    if (i2 != 0) {
                        float f2 = this.f3541D;
                        if (!((f2 < ((float) this.f3539B) && i2 > 0) || (f2 > ((float) (getWidth() - this.f3539B)) && f < 0.0f)) && m1252c(this, false, (int) f, (int) x2, (int) y2)) {
                            this.f3541D = x2;
                            this.f3542E = y2;
                            this.f3590z = true;
                            return false;
                        }
                    }
                    int i3 = this.f3540C;
                    if (abs > i3 && abs * 0.5f > abs2) {
                        this.f3589y = true;
                        m1234u(true);
                        m1230y(1);
                        float f3 = this.f3543F;
                        float f4 = this.f3540C;
                        this.f3541D = i2 > 0 ? f3 + f4 : f3 - f4;
                        this.f3542E = y2;
                        m1229z(true);
                    } else if (abs2 > i3) {
                        this.f3590z = true;
                    }
                    if (this.f3589y && m1237r(x2)) {
                        AtomicInteger atomicInteger = C0492V4.f1798a;
                        C0492V4.C0495c.m1933k(this);
                    }
                }
            } else if (action == 6) {
                m1241n(motionEvent);
            }
            if (this.f3546I == null) {
                this.f3546I = VelocityTracker.obtain();
            }
            this.f3546I.addMovement(motionEvent);
            return this.f3589y;
        }
        m1233v();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        C0928f m1246i;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (m1246i = m1246i(childAt)) != null && m1246i.f3603a == this.f3571g && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f3570f != null) {
            m1231x(savedState.f3597a, false, true, 0);
            return;
        }
        this.f3572h = savedState.f3597a;
        this.f3573i = savedState.f3598b;
        this.f3574j = savedState.f3599c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3597a = this.f3571g;
        AbstractC1960l8 abstractC1960l8 = this.f3570f;
        if (abstractC1960l8 != null) {
            Objects.requireNonNull(abstractC1960l8);
            savedState.f3598b = null;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.f3578n;
            m1235t(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractC1960l8 abstractC1960l8;
        ArrayList<C0928f> arrayList;
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (abstractC1960l8 = this.f3570f) == null || abstractC1960l8.m611b() == 0) {
            return false;
        }
        if (this.f3546I == null) {
            this.f3546I = VelocityTracker.obtain();
        }
        this.f3546I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f3575k.abortAnimation();
            this.f3587w = false;
            m1236s(this.f3571g);
            float x = motionEvent.getX();
            this.f3543F = x;
            this.f3541D = x;
            float y = motionEvent.getY();
            this.f3544G = y;
            this.f3542E = y;
            this.f3545H = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f3589y) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f3545H);
                    if (findPointerIndex == -1) {
                        z = m1233v();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.f3541D);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f3542E);
                        if (abs > this.f3540C && abs > abs2) {
                            this.f3589y = true;
                            m1234u(true);
                            float f = this.f3543F;
                            this.f3541D = x2 - f > 0.0f ? f + this.f3540C : f - this.f3540C;
                            this.f3542E = y2;
                            m1230y(1);
                            m1229z(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f3589y) {
                    z = false | m1237r(motionEvent.getX(motionEvent.findPointerIndex(this.f3545H)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.f3541D = motionEvent.getX(actionIndex);
                    this.f3545H = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    m1241n(motionEvent);
                    this.f3541D = motionEvent.getX(motionEvent.findPointerIndex(this.f3545H));
                }
            } else if (this.f3589y) {
                m1232w(this.f3571g, true, 0, false);
                z = m1233v();
            }
        } else if (this.f3589y) {
            VelocityTracker velocityTracker = this.f3546I;
            velocityTracker.computeCurrentVelocity(1000, this.f3548K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f3545H);
            this.f3587w = true;
            int m1247h = m1247h();
            int scrollX = getScrollX();
            C0928f m1245j = m1245j();
            float f2 = m1247h;
            int i = m1245j.f3603a;
            float f3 = ((scrollX / f2) - m1245j.f3606d) / (m1245j.f3605c + (this.f3578n / f2));
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.f3545H)) - this.f3543F)) <= this.f3549L || Math.abs(xVelocity) <= this.f3547J) {
                i += (int) (f3 + (i >= this.f3571g ? 0.4f : 0.6f));
            } else if (xVelocity <= 0) {
                i++;
            }
            if (this.f3563b.size() > 0) {
                i = Math.max(this.f3563b.get(0).f3603a, Math.min(i, this.f3563b.get(arrayList.size() - 1).f3603a));
            }
            m1231x(i, true, true, xVelocity);
            z = m1233v();
        }
        if (z) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
        }
        return true;
    }

    /* renamed from: p */
    public boolean m1239p() {
        AbstractC1960l8 abstractC1960l8 = this.f3570f;
        if (abstractC1960l8 == null || this.f3571g >= abstractC1960l8.m611b() - 1) {
            return false;
        }
        setCurrentItem(this.f3571g + 1, true);
        return true;
    }

    /* renamed from: q */
    public final boolean m1238q(int i) {
        if (this.f3563b.size() == 0) {
            if (this.f3553P) {
                return false;
            }
            this.f3554Q = false;
            m1242m(0, 0.0f, 0);
            if (this.f3554Q) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0928f m1245j = m1245j();
        int m1247h = m1247h();
        int i2 = this.f3578n;
        int i3 = m1247h + i2;
        float f = m1247h;
        int i4 = m1245j.f3603a;
        float f2 = ((i / f) - m1245j.f3606d) / (m1245j.f3605c + (i2 / f));
        this.f3554Q = false;
        m1242m(i4, f2, (int) (i3 * f2));
        if (this.f3554Q) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* renamed from: r */
    public final boolean m1237r(float f) {
        boolean z;
        boolean z2;
        float f2 = this.f3541D - f;
        this.f3541D = f;
        float scrollX = getScrollX() + f2;
        float m1247h = m1247h();
        float f3 = this.f3582r * m1247h;
        float f4 = this.f3583s * m1247h;
        boolean z3 = false;
        C0928f c0928f = this.f3563b.get(0);
        ArrayList<C0928f> arrayList = this.f3563b;
        C0928f c0928f2 = arrayList.get(arrayList.size() - 1);
        if (c0928f.f3603a != 0) {
            f3 = c0928f.f3606d * m1247h;
            z = false;
        } else {
            z = true;
        }
        if (c0928f2.f3603a != this.f3570f.m611b() - 1) {
            f4 = c0928f2.f3606d * m1247h;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f3551N.onPull(Math.abs(f3 - scrollX) / m1247h);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f3552O.onPull(Math.abs(scrollX - f4) / m1247h);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f3541D = (scrollX - i) + this.f3541D;
        scrollTo(i, getScrollY());
        m1238q(i);
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f3585u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r6 == r7) goto L27;
     */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1236s(int r15) {
        /*
            Method dump skipped, instructions count: 849
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m1236s(int):void");
    }

    public void setAdapter(AbstractC1960l8 abstractC1960l8) {
        AbstractC1960l8 abstractC1960l82 = this.f3570f;
        if (abstractC1960l82 != null) {
            synchronized (abstractC1960l82) {
            }
            Objects.requireNonNull(this.f3570f);
            if (this.f3563b.size() <= 0) {
                Objects.requireNonNull(this.f3570f);
                this.f3563b.clear();
                int i = 0;
                while (i < getChildCount()) {
                    if (!((LayoutParams) getChildAt(i).getLayoutParams()).f3591a) {
                        removeViewAt(i);
                        i--;
                    }
                    i++;
                }
                this.f3571g = 0;
                scrollTo(0, 0);
            } else {
                this.f3570f.m612a(this, this.f3563b.get(0).f3603a, null);
                throw null;
            }
        }
        AbstractC1960l8 abstractC1960l83 = this.f3570f;
        this.f3570f = abstractC1960l8;
        this.f3561a = 0;
        if (abstractC1960l8 != null) {
            if (this.f3577m == null) {
                this.f3577m = new C0933k();
            }
            synchronized (this.f3570f) {
            }
            this.f3587w = false;
            boolean z = this.f3553P;
            this.f3553P = true;
            this.f3561a = this.f3570f.m611b();
            if (this.f3572h >= 0) {
                Objects.requireNonNull(this.f3570f);
                m1231x(this.f3572h, false, true, 0);
                this.f3572h = -1;
                this.f3573i = null;
                this.f3574j = null;
            } else if (!z) {
                m1236s(this.f3571g);
            } else {
                requestLayout();
            }
        }
        List<InterfaceC0930h> list = this.f3559V;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f3559V.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3559V.get(i2).onAdapterChanged(this, abstractC1960l83, abstractC1960l8);
        }
    }

    public void setCurrentItem(int i) {
        this.f3587w = false;
        m1231x(i, !this.f3553P, false, 0);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f3588x) {
            this.f3588x = i;
            m1236s(this.f3571g);
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC0931i interfaceC0931i) {
        this.f3557T = interfaceC0931i;
    }

    public void setPageMargin(int i) {
        int i2 = this.f3578n;
        this.f3578n = i;
        int width = getWidth();
        m1235t(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f3579o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, InterfaceC0932j interfaceC0932j) {
        setPageTransformer(z, interfaceC0932j, 2);
    }

    /* renamed from: t */
    public final void m1235t(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f3563b.isEmpty()) {
            if (!this.f3575k.isFinished()) {
                this.f3575k.setFinalX(m1247h() * this.f3571g);
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        C0928f m1244k = m1244k(this.f3571g);
        int min = (int) ((m1244k != null ? Math.min(m1244k.f3606d, this.f3583s) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            m1251d(false);
            scrollTo(min, getScrollY());
        }
    }

    /* renamed from: u */
    public final void m1234u(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: v */
    public final boolean m1233v() {
        this.f3545H = -1;
        this.f3589y = false;
        this.f3590z = false;
        VelocityTracker velocityTracker = this.f3546I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3546I = null;
        }
        this.f3551N.onRelease();
        this.f3552O.onRelease();
        return this.f3551N.isFinished() || this.f3552O.isFinished();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3579o;
    }

    /* renamed from: w */
    public final void m1232w(int i, boolean z, int i2, boolean z2) {
        int scrollX;
        int abs;
        C0928f m1244k = m1244k(i);
        int max = m1244k != null ? (int) (Math.max(this.f3582r, Math.min(m1244k.f3606d, this.f3583s)) * m1247h()) : 0;
        if (z) {
            if (getChildCount() == 0) {
                m1229z(false);
            } else {
                Scroller scroller = this.f3575k;
                if ((scroller == null || scroller.isFinished()) ? false : true) {
                    scrollX = this.f3576l ? this.f3575k.getCurrX() : this.f3575k.getStartX();
                    this.f3575k.abortAnimation();
                    m1229z(false);
                } else {
                    scrollX = getScrollX();
                }
                int i3 = scrollX;
                int scrollY = getScrollY();
                int i4 = max - i3;
                int i5 = 0 - scrollY;
                if (i4 == 0 && i5 == 0) {
                    m1251d(false);
                    m1236s(this.f3571g);
                    m1230y(0);
                } else {
                    m1229z(true);
                    m1230y(2);
                    int m1247h = m1247h();
                    int i6 = m1247h / 2;
                    float f = m1247h;
                    float f2 = i6;
                    float sin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i4) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                    int abs2 = Math.abs(i2);
                    if (abs2 > 0) {
                        abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
                    } else {
                        Objects.requireNonNull(this.f3570f);
                        abs = (int) (((Math.abs(i4) / ((f * 1.0f) + this.f3578n)) + 1.0f) * 100.0f);
                    }
                    int min = Math.min(abs, 600);
                    this.f3576l = false;
                    this.f3575k.startScroll(i3, scrollY, i4, i5, min);
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0495c.m1933k(this);
                }
            }
            if (z2) {
                m1249f(i);
                return;
            }
            return;
        }
        if (z2) {
            m1249f(i);
        }
        m1251d(false);
        scrollTo(max, 0);
        m1238q(max);
    }

    /* renamed from: x */
    public void m1231x(int i, boolean z, boolean z2, int i2) {
        AbstractC1960l8 abstractC1960l8 = this.f3570f;
        if (abstractC1960l8 != null && abstractC1960l8.m611b() > 0) {
            if (!z2 && this.f3571g == i && this.f3563b.size() != 0) {
                m1229z(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.f3570f.m611b()) {
                i = this.f3570f.m611b() - 1;
            }
            int i3 = this.f3588x;
            int i4 = this.f3571g;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.f3563b.size(); i5++) {
                    this.f3563b.get(i5).f3604b = true;
                }
            }
            boolean z3 = this.f3571g != i;
            if (this.f3553P) {
                this.f3571g = i;
                if (z3) {
                    m1249f(i);
                }
                requestLayout();
                return;
            }
            m1236s(i);
            m1232w(i, z, i2, z3);
            return;
        }
        m1229z(false);
    }

    /* renamed from: y */
    public void m1230y(int i) {
        if (this.f3569e0 == i) {
            return;
        }
        this.f3569e0 = i;
        if (this.f3560W != null) {
            boolean z = i != 0;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).setLayerType(z ? this.f3562a0 : 0, null);
            }
        }
        InterfaceC0931i interfaceC0931i = this.f3557T;
        if (interfaceC0931i != null) {
            interfaceC0931i.onPageScrollStateChanged(i);
        }
        List<InterfaceC0931i> list = this.f3556S;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                InterfaceC0931i interfaceC0931i2 = this.f3556S.get(i3);
                if (interfaceC0931i2 != null) {
                    interfaceC0931i2.onPageScrollStateChanged(i);
                }
            }
        }
        InterfaceC0931i interfaceC0931i3 = this.f3558U;
        if (interfaceC0931i3 != null) {
            interfaceC0931i3.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: z */
    public final void m1229z(boolean z) {
        if (this.f3586v != z) {
            this.f3586v = z;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f3591a;

        /* renamed from: b */
        public int f3592b;

        /* renamed from: c */
        public float f3593c;

        /* renamed from: d */
        public boolean f3594d;

        /* renamed from: e */
        public int f3595e;

        /* renamed from: f */
        public int f3596f;

        public LayoutParams() {
            super(-1, -1);
            this.f3593c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3593c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f3534f0);
            this.f3592b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, InterfaceC0932j interfaceC0932j, int i) {
        boolean z2 = interfaceC0932j != null;
        boolean z3 = z2 != (this.f3560W != null);
        this.f3560W = interfaceC0932j;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.f3564b0 = z ? 2 : 1;
            this.f3562a0 = i;
        } else {
            this.f3564b0 = 0;
        }
        if (z3) {
            m1236s(this.f3571g);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        this.f3587w = false;
        m1231x(i, z, false, 0);
    }

    public void setPageMarginDrawable(int i) {
        Context context = getContext();
        Object obj = C2307w3.f6741a;
        setPageMarginDrawable(C2307w3.C2310c.m202b(context, i));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3563b = new ArrayList<>();
        this.f3565c = new C0928f();
        this.f3567d = new Rect();
        this.f3572h = -1;
        this.f3573i = null;
        this.f3574j = null;
        this.f3582r = -3.4028235E38f;
        this.f3583s = Float.MAX_VALUE;
        this.f3588x = 1;
        this.f3545H = -1;
        this.f3553P = true;
        this.f3568d0 = new RunnableC0925c();
        this.f3569e0 = 0;
        m1243l();
    }
}
