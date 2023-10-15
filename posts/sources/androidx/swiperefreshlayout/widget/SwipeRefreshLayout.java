package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C2195q7;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC0287M4, InterfaceC0267L4, InterfaceC0215J4 {

    /* renamed from: Q */
    public static final String f3335Q = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: R */
    public static final int[] f3336R = {16842766};

    /* renamed from: A */
    public int f3337A;

    /* renamed from: B */
    public int f3338B;

    /* renamed from: C */
    public C2195q7 f3339C;

    /* renamed from: D */
    public Animation f3340D;

    /* renamed from: E */
    public Animation f3341E;

    /* renamed from: F */
    public Animation f3342F;

    /* renamed from: G */
    public Animation f3343G;

    /* renamed from: H */
    public Animation f3344H;

    /* renamed from: I */
    public boolean f3345I;

    /* renamed from: J */
    public int f3346J;

    /* renamed from: K */
    public boolean f3347K;

    /* renamed from: L */
    public InterfaceC0874g f3348L;

    /* renamed from: M */
    public boolean f3349M;

    /* renamed from: N */
    public Animation.AnimationListener f3350N;

    /* renamed from: O */
    public final Animation f3351O;

    /* renamed from: P */
    public final Animation f3352P;

    /* renamed from: a */
    public View f3353a;

    /* renamed from: b */
    public InterfaceC0875h f3354b;

    /* renamed from: c */
    public boolean f3355c;

    /* renamed from: d */
    public int f3356d;

    /* renamed from: f */
    public float f3357f;

    /* renamed from: g */
    public float f3358g;

    /* renamed from: h */
    public final C0310N4 f3359h;

    /* renamed from: i */
    public final C0235K4 f3360i;

    /* renamed from: j */
    public final int[] f3361j;

    /* renamed from: k */
    public final int[] f3362k;

    /* renamed from: l */
    public final int[] f3363l;

    /* renamed from: m */
    public boolean f3364m;

    /* renamed from: n */
    public int f3365n;

    /* renamed from: o */
    public int f3366o;

    /* renamed from: p */
    public float f3367p;

    /* renamed from: q */
    public float f3368q;

    /* renamed from: r */
    public boolean f3369r;

    /* renamed from: s */
    public int f3370s;

    /* renamed from: t */
    public boolean f3371t;

    /* renamed from: u */
    public final DecelerateInterpolator f3372u;

    /* renamed from: v */
    public C2004n7 f3373v;

    /* renamed from: w */
    public int f3374w;

    /* renamed from: x */
    public int f3375x;

    /* renamed from: y */
    public float f3376y;

    /* renamed from: z */
    public int f3377z;

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$a  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class animationAnimation$AnimationListenerC0868a implements Animation.AnimationListener {
        public animationAnimation$AnimationListenerC0868a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            InterfaceC0875h interfaceC0875h;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3355c) {
                swipeRefreshLayout.f3339C.setAlpha(255);
                SwipeRefreshLayout.this.f3339C.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.f3345I && (interfaceC0875h = swipeRefreshLayout2.f3354b) != null) {
                    interfaceC0875h.mo848i();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f3366o = swipeRefreshLayout3.f3373v.getTop();
                return;
            }
            swipeRefreshLayout.m1286h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0869b extends Animation {
        public C0869b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.m1285i(1.0f - f);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0870c extends Animation {

        /* renamed from: a */
        public final /* synthetic */ int f3381a;

        /* renamed from: b */
        public final /* synthetic */ int f3382b;

        public C0870c(int i, int i2) {
            this.f3381a = i;
            this.f3382b = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            C2195q7 c2195q7 = SwipeRefreshLayout.this.f3339C;
            int i = this.f3381a;
            c2195q7.setAlpha((int) (((this.f3382b - i) * f) + i));
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$d  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class animationAnimation$AnimationListenerC0871d implements Animation.AnimationListener {
        public animationAnimation$AnimationListenerC0871d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3371t) {
                return;
            }
            swipeRefreshLayout.m1280n(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0872e extends Animation {
        public C0872e() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f3347K) {
                i = swipeRefreshLayout.f3337A - Math.abs(swipeRefreshLayout.f3377z);
            } else {
                i = swipeRefreshLayout.f3337A;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i2 = swipeRefreshLayout2.f3375x;
            SwipeRefreshLayout.this.m1283k((i2 + ((int) ((i - i2) * f))) - swipeRefreshLayout2.f3373v.getTop());
            C2195q7 c2195q7 = SwipeRefreshLayout.this.f3339C;
            float f2 = 1.0f - f;
            C2195q7.C2196a c2196a = c2195q7.f6267a;
            if (f2 != c2196a.f6288p) {
                c2196a.f6288p = f2;
            }
            c2195q7.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0873f extends Animation {
        public C0873f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.m1288f(f);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0874g {
        /* renamed from: a */
        boolean m1279a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0875h {
        /* renamed from: i */
        void mo848i();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public boolean m1293a() {
        InterfaceC0874g interfaceC0874g = this.f3348L;
        if (interfaceC0874g != null) {
            return interfaceC0874g.m1279a(this, this.f3353a);
        }
        View view = this.f3353a;
        if (view instanceof ListView) {
            return ((ListView) view).canScrollList(-1);
        }
        return view.canScrollVertically(-1);
    }

    /* renamed from: b */
    public final void m1292b() {
        if (this.f3353a == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f3373v)) {
                    this.f3353a = childAt;
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public final void m1291c(float f) {
        if (f > this.f3357f) {
            m1284j(true, true);
            return;
        }
        this.f3355c = false;
        C2195q7 c2195q7 = this.f3339C;
        C2195q7.C2196a c2196a = c2195q7.f6267a;
        c2196a.f6277e = 0.0f;
        c2196a.f6278f = 0.0f;
        c2195q7.invalidateSelf();
        boolean z = this.f3371t;
        animationAnimation$AnimationListenerC0871d animationanimation_animationlistenerc0871d = z ? null : new animationAnimation$AnimationListenerC0871d();
        int i = this.f3366o;
        if (z) {
            this.f3375x = i;
            this.f3376y = this.f3373v.getScaleX();
            C2234s7 c2234s7 = new C2234s7(this);
            this.f3344H = c2234s7;
            c2234s7.setDuration(150L);
            if (animationanimation_animationlistenerc0871d != null) {
                this.f3373v.f5547a = animationanimation_animationlistenerc0871d;
            }
            this.f3373v.clearAnimation();
            this.f3373v.startAnimation(this.f3344H);
        } else {
            this.f3375x = i;
            this.f3352P.reset();
            this.f3352P.setDuration(200L);
            this.f3352P.setInterpolator(this.f3372u);
            if (animationanimation_animationlistenerc0871d != null) {
                this.f3373v.f5547a = animationanimation_animationlistenerc0871d;
            }
            this.f3373v.clearAnimation();
            this.f3373v.startAnimation(this.f3352P);
        }
        C2195q7 c2195q72 = this.f3339C;
        C2195q7.C2196a c2196a2 = c2195q72.f6267a;
        if (c2196a2.f6286n) {
            c2196a2.f6286n = false;
        }
        c2195q72.invalidateSelf();
    }

    /* renamed from: d */
    public final boolean m1290d(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3360i.m2344a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3360i.m2343b(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f3360i.m2342c(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f3360i.m2341d(i, i2, i3, i4, iArr);
    }

    /* renamed from: e */
    public final void m1289e(float f) {
        C2195q7 c2195q7 = this.f3339C;
        C2195q7.C2196a c2196a = c2195q7.f6267a;
        if (!c2196a.f6286n) {
            c2196a.f6286n = true;
        }
        c2195q7.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f / this.f3357f));
        float max = (((float) Math.max(min - 0.4d, (double) ShadowDrawableWrapper.COS_45)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f3357f;
        int i = this.f3338B;
        if (i <= 0) {
            if (this.f3347K) {
                i = this.f3337A - this.f3377z;
            } else {
                i = this.f3337A;
            }
        }
        float f2 = i;
        double max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.f3377z + ((int) ((f2 * min) + (f2 * pow * 2.0f)));
        if (this.f3373v.getVisibility() != 0) {
            this.f3373v.setVisibility(0);
        }
        if (!this.f3371t) {
            this.f3373v.setScaleX(1.0f);
            this.f3373v.setScaleY(1.0f);
        }
        if (this.f3371t) {
            m1285i(Math.min(1.0f, f / this.f3357f));
        }
        if (f < this.f3357f) {
            if (this.f3339C.f6267a.f6292t > 76 && !m1290d(this.f3342F)) {
                this.f3342F = m1282l(this.f3339C.f6267a.f6292t, 76);
            }
        } else if (this.f3339C.f6267a.f6292t < 255 && !m1290d(this.f3343G)) {
            this.f3343G = m1282l(this.f3339C.f6267a.f6292t, 255);
        }
        C2195q7 c2195q72 = this.f3339C;
        float min2 = Math.min(0.8f, max * 0.8f);
        C2195q7.C2196a c2196a2 = c2195q72.f6267a;
        c2196a2.f6277e = 0.0f;
        c2196a2.f6278f = min2;
        c2195q72.invalidateSelf();
        C2195q7 c2195q73 = this.f3339C;
        float min3 = Math.min(1.0f, max);
        C2195q7.C2196a c2196a3 = c2195q73.f6267a;
        if (min3 != c2196a3.f6288p) {
            c2196a3.f6288p = min3;
        }
        c2195q73.invalidateSelf();
        C2195q7 c2195q74 = this.f3339C;
        c2195q74.f6267a.f6279g = ((pow * 2.0f) + ((max * 0.4f) - 0.25f)) * 0.5f;
        c2195q74.invalidateSelf();
        m1283k(i2 - this.f3366o);
    }

    /* renamed from: f */
    public void m1288f(float f) {
        int i = this.f3375x;
        m1283k((i + ((int) ((this.f3377z - i) * f))) - this.f3373v.getTop());
    }

    /* renamed from: g */
    public final void m1287g(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3370s) {
            this.f3370s = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.f3374w;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3359h.m2175a();
    }

    /* renamed from: h */
    public void m1286h() {
        this.f3373v.clearAnimation();
        this.f3339C.stop();
        this.f3373v.setVisibility(8);
        this.f3373v.getBackground().setAlpha(255);
        C2195q7 c2195q7 = this.f3339C;
        c2195q7.f6267a.f6292t = 255;
        c2195q7.invalidateSelf();
        if (this.f3371t) {
            m1285i(0.0f);
        } else {
            m1283k(this.f3377z - this.f3366o);
        }
        this.f3366o = this.f3373v.getTop();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f3360i.m2338g(0);
    }

    /* renamed from: i */
    public void m1285i(float f) {
        this.f3373v.setScaleX(f);
        this.f3373v.setScaleY(f);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f3360i.f729d;
    }

    /* renamed from: j */
    public final void m1284j(boolean z, boolean z2) {
        if (this.f3355c != z) {
            this.f3345I = z2;
            m1292b();
            this.f3355c = z;
            if (z) {
                int i = this.f3366o;
                Animation.AnimationListener animationListener = this.f3350N;
                this.f3375x = i;
                this.f3351O.reset();
                this.f3351O.setDuration(200L);
                this.f3351O.setInterpolator(this.f3372u);
                if (animationListener != null) {
                    this.f3373v.f5547a = animationListener;
                }
                this.f3373v.clearAnimation();
                this.f3373v.startAnimation(this.f3351O);
                return;
            }
            m1280n(this.f3350N);
        }
    }

    /* renamed from: k */
    public void m1283k(int i) {
        this.f3373v.bringToFront();
        C0492V4.m1956o(this.f3373v, i);
        this.f3366o = this.f3373v.getTop();
    }

    /* renamed from: l */
    public final Animation m1282l(int i, int i2) {
        C0870c c0870c = new C0870c(i, i2);
        c0870c.setDuration(300L);
        C2004n7 c2004n7 = this.f3373v;
        c2004n7.f5547a = null;
        c2004n7.clearAnimation();
        this.f3373v.startAnimation(c0870c);
        return c0870c;
    }

    /* renamed from: m */
    public final void m1281m(float f) {
        float f2 = this.f3368q;
        int i = this.f3356d;
        if (f - f2 <= i || this.f3369r) {
            return;
        }
        this.f3367p = f2 + i;
        this.f3369r = true;
        this.f3339C.setAlpha(76);
    }

    /* renamed from: n */
    public void m1280n(Animation.AnimationListener animationListener) {
        C0869b c0869b = new C0869b();
        this.f3341E = c0869b;
        c0869b.setDuration(150L);
        C2004n7 c2004n7 = this.f3373v;
        c2004n7.f5547a = animationListener;
        c2004n7.clearAnimation();
        this.f3373v.startAnimation(this.f3341E);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1286h();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m1292b();
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || m1293a() || this.f3355c || this.f3364m) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f3370s;
                    if (i == -1) {
                        Log.e(f3335Q, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    m1281m(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        m1287g(motionEvent);
                    }
                }
            }
            this.f3369r = false;
            this.f3370s = -1;
        } else {
            m1283k(this.f3377z - this.f3373v.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f3370s = pointerId;
            this.f3369r = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f3368q = motionEvent.getY(findPointerIndex2);
        }
        return this.f3369r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f3353a == null) {
            m1292b();
        }
        View view = this.f3353a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f3373v.getMeasuredWidth();
        int measuredHeight2 = this.f3373v.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.f3366o;
        this.f3373v.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3353a == null) {
            m1292b();
        }
        View view = this.f3353a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f3373v.measure(View.MeasureSpec.makeMeasureSpec(this.f3346J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f3346J, 1073741824));
        this.f3374w = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.f3373v) {
                this.f3374w = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // p000.InterfaceC0287M4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i5 != 0) {
            return;
        }
        int i6 = iArr[1];
        int[] iArr2 = this.f3362k;
        if (i5 == 0) {
            this.f3360i.m2340e(i, i2, i3, i4, iArr2, i5, iArr);
        }
        int i7 = i4 - (iArr[1] - i6);
        int i8 = i7 == 0 ? i4 + this.f3362k[1] : i7;
        if (i8 >= 0 || m1293a()) {
            return;
        }
        float abs = this.f3358g + Math.abs(i8);
        this.f3358g = abs;
        m1289e(abs);
        iArr[1] = iArr[1] + i7;
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f3378a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f3355c);
    }

    @Override // p000.InterfaceC0267L4
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    @Override // p000.InterfaceC0267L4
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || m1293a() || this.f3355c || this.f3364m) {
            return false;
        }
        if (actionMasked == 0) {
            this.f3370s = motionEvent.getPointerId(0);
            this.f3369r = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f3370s);
            if (findPointerIndex < 0) {
                Log.e(f3335Q, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f3369r) {
                this.f3369r = false;
                m1291c((motionEvent.getY(findPointerIndex) - this.f3367p) * 0.5f);
            }
            this.f3370s = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f3370s);
            if (findPointerIndex2 < 0) {
                Log.e(f3335Q, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            m1281m(y);
            if (this.f3369r) {
                float f = (y - this.f3367p) * 0.5f;
                if (f <= 0.0f) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                m1289e(f);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f3335Q, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f3370s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m1287g(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        View view = this.f3353a;
        if (view != null) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (!C0492V4.C0500h.m1885p(view)) {
                if (this.f3349M || (parent = getParent()) == null) {
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(z);
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        m1292b();
        C2195q7 c2195q7 = this.f3339C;
        C2195q7.C2196a c2196a = c2195q7.f6267a;
        c2196a.f6281i = iArr;
        c2196a.m426a(0);
        c2195q7.f6267a.m426a(0);
        c2195q7.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = C2307w3.m210b(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f3357f = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        m1286h();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.f3349M = z;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0235K4 c0235k4 = this.f3360i;
        if (c0235k4.f729d) {
            View view = c0235k4.f728c;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1875z(view);
        }
        c0235k4.f729d = z;
    }

    public void setOnChildScrollUpCallback(InterfaceC0874g interfaceC0874g) {
        this.f3348L = interfaceC0874g;
    }

    public void setOnRefreshListener(InterfaceC0875h interfaceC0875h) {
        this.f3354b = interfaceC0875h;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f3373v.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(C2307w3.m210b(getContext(), i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.f3337A = i;
        this.f3371t = z;
        this.f3373v.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.f3371t = z;
        this.f3377z = i;
        this.f3337A = i2;
        this.f3347K = true;
        m1286h();
        this.f3355c = false;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.f3355c != z) {
            this.f3355c = z;
            if (!this.f3347K) {
                i = this.f3337A + this.f3377z;
            } else {
                i = this.f3337A;
            }
            m1283k(i - this.f3366o);
            this.f3345I = false;
            Animation.AnimationListener animationListener = this.f3350N;
            this.f3373v.setVisibility(0);
            this.f3339C.setAlpha(255);
            C2213r7 c2213r7 = new C2213r7(this);
            this.f3340D = c2213r7;
            c2213r7.setDuration(this.f3365n);
            if (animationListener != null) {
                this.f3373v.f5547a = animationListener;
            }
            this.f3373v.clearAnimation();
            this.f3373v.startAnimation(this.f3340D);
            return;
        }
        m1284j(z, false);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f3346J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f3346J = (int) (displayMetrics.density * 40.0f);
            }
            this.f3373v.setImageDrawable(null);
            this.f3339C.m428c(i);
            this.f3373v.setImageDrawable(this.f3339C);
        }
    }

    public void setSlingshotDistance(int i) {
        this.f3338B = i;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f3360i.m2337h(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f3360i.m2336i(0);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0867a();

        /* renamed from: a */
        public final boolean f3378a;

        /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0867a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f3378a = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f3378a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3378a = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3355c = false;
        this.f3357f = -1.0f;
        this.f3361j = new int[2];
        this.f3362k = new int[2];
        this.f3363l = new int[2];
        this.f3370s = -1;
        this.f3374w = -1;
        this.f3350N = new animationAnimation$AnimationListenerC0868a();
        this.f3351O = new C0872e();
        this.f3352P = new C0873f();
        this.f3356d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3365n = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f3372u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3346J = (int) (displayMetrics.density * 40.0f);
        this.f3373v = new C2004n7(getContext());
        C2195q7 c2195q7 = new C2195q7(getContext());
        this.f3339C = c2195q7;
        c2195q7.m428c(1);
        this.f3373v.setImageDrawable(this.f3339C);
        this.f3373v.setVisibility(8);
        addView(this.f3373v);
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.f3337A = i;
        this.f3357f = i;
        this.f3359h = new C0310N4();
        this.f3360i = new C0235K4(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.f3346J;
        this.f3366o = i2;
        this.f3377z = i2;
        m1288f(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3336R);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.f3358g;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = (int) f;
                    this.f3358g = 0.0f;
                } else {
                    this.f3358g = f - f2;
                    iArr[1] = i2;
                }
                m1289e(this.f3358g);
            }
        }
        if (this.f3347K && i2 > 0 && this.f3358g == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f3373v.setVisibility(8);
        }
        int[] iArr2 = this.f3361j;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3359h.f1023a = i;
        startNestedScroll(i & 2);
        this.f3358g = 0.0f;
        this.f3364m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f3355c || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f3359h.m2174b(0);
        this.f3364m = false;
        float f = this.f3358g;
        if (f > 0.0f) {
            m1291c(f);
            this.f3358g = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // p000.InterfaceC0267L4
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, i5, this.f3363l);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.f3363l);
    }
}
