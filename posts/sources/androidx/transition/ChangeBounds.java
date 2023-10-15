package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChangeBounds extends Transition {

    /* renamed from: c */
    public static final String[] f3391c = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: d */
    public static final Property<Drawable, PointF> f3392d = new C0876a(PointF.class, "boundsOrigin");

    /* renamed from: f */
    public static final Property<C0885j, PointF> f3393f = new C0877b(PointF.class, "topLeft");

    /* renamed from: g */
    public static final Property<C0885j, PointF> f3394g = new C0878c(PointF.class, "bottomRight");

    /* renamed from: h */
    public static final Property<View, PointF> f3395h = new C0879d(PointF.class, "bottomRight");

    /* renamed from: i */
    public static final Property<View, PointF> f3396i = new C0880e(PointF.class, "topLeft");

    /* renamed from: j */
    public static final Property<View, PointF> f3397j = new C0881f(PointF.class, "position");

    /* renamed from: k */
    public static C0114E7 f3398k = new C0114E7();

    /* renamed from: a */
    public int[] f3399a;

    /* renamed from: b */
    public boolean f3400b;

    /* renamed from: androidx.transition.ChangeBounds$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0876a extends Property<Drawable, PointF> {

        /* renamed from: a */
        public Rect f3401a;

        public C0876a(Class cls, String str) {
            super(cls, str);
            this.f3401a = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3401a);
            Rect rect = this.f3401a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.f3401a);
            this.f3401a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.f3401a);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0877b extends Property<C0885j, PointF> {
        public C0877b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(C0885j c0885j) {
            return null;
        }

        @Override // android.util.Property
        public void set(C0885j c0885j, PointF pointF) {
            C0885j c0885j2 = c0885j;
            PointF pointF2 = pointF;
            Objects.requireNonNull(c0885j2);
            c0885j2.f3412a = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            c0885j2.f3413b = round;
            int i = c0885j2.f3417f + 1;
            c0885j2.f3417f = i;
            if (i == c0885j2.f3418g) {
                C0399R7.m2045b(c0885j2.f3416e, c0885j2.f3412a, round, c0885j2.f3414c, c0885j2.f3415d);
                c0885j2.f3417f = 0;
                c0885j2.f3418g = 0;
            }
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0878c extends Property<C0885j, PointF> {
        public C0878c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(C0885j c0885j) {
            return null;
        }

        @Override // android.util.Property
        public void set(C0885j c0885j, PointF pointF) {
            C0885j c0885j2 = c0885j;
            PointF pointF2 = pointF;
            Objects.requireNonNull(c0885j2);
            c0885j2.f3414c = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            c0885j2.f3415d = round;
            int i = c0885j2.f3418g + 1;
            c0885j2.f3418g = i;
            if (c0885j2.f3417f == i) {
                C0399R7.m2045b(c0885j2.f3416e, c0885j2.f3412a, c0885j2.f3413b, c0885j2.f3414c, round);
                c0885j2.f3417f = 0;
                c0885j2.f3418g = 0;
            }
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0879d extends Property<View, PointF> {
        public C0879d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            C0399R7.m2045b(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0880e extends Property<View, PointF> {
        public C0880e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            C0399R7.m2045b(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0881f extends Property<View, PointF> {
        public C0881f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            C0399R7.m2045b(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0882g extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C0885j f3402a;
        private C0885j mViewBounds;

        public C0882g(ChangeBounds changeBounds, C0885j c0885j) {
            this.f3402a = c0885j;
            this.mViewBounds = c0885j;
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0883h extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f3403a;

        /* renamed from: b */
        public final /* synthetic */ View f3404b;

        /* renamed from: c */
        public final /* synthetic */ Rect f3405c;

        /* renamed from: d */
        public final /* synthetic */ int f3406d;

        /* renamed from: e */
        public final /* synthetic */ int f3407e;

        /* renamed from: f */
        public final /* synthetic */ int f3408f;

        /* renamed from: g */
        public final /* synthetic */ int f3409g;

        public C0883h(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f3404b = view;
            this.f3405c = rect;
            this.f3406d = i;
            this.f3407e = i2;
            this.f3408f = i3;
            this.f3409g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3403a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3403a) {
                return;
            }
            View view = this.f3404b;
            Rect rect = this.f3405c;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0497e.m1911c(view, rect);
            C0399R7.m2045b(this.f3404b, this.f3406d, this.f3407e, this.f3408f, this.f3409g);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0884i extends C0199I7 {

        /* renamed from: a */
        public boolean f3410a = false;

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f3411b;

        public C0884i(ChangeBounds changeBounds, ViewGroup viewGroup) {
            this.f3411b = viewGroup;
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionCancel(Transition transition) {
            C0355P7.m2148a(this.f3411b, false);
            this.f3410a = true;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            if (!this.f3410a) {
                C0355P7.m2148a(this.f3411b, false);
            }
            transition.removeListener(this);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionPause(Transition transition) {
            C0355P7.m2148a(this.f3411b, false);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionResume(Transition transition) {
            C0355P7.m2148a(this.f3411b, true);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0885j {

        /* renamed from: a */
        public int f3412a;

        /* renamed from: b */
        public int f3413b;

        /* renamed from: c */
        public int f3414c;

        /* renamed from: d */
        public int f3415d;

        /* renamed from: e */
        public View f3416e;

        /* renamed from: f */
        public int f3417f;

        /* renamed from: g */
        public int f3418g;

        public C0885j(View view) {
            this.f3416e = view;
        }
    }

    public ChangeBounds() {
        this.f3399a = new int[2];
        this.f3400b = false;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    public final void captureValues(C0290M7 c0290m7) {
        View view = c0290m7.f971b;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (!C0492V4.C0498f.m1908c(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c0290m7.f970a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c0290m7.f970a.put("android:changeBounds:parent", c0290m7.f971b.getParent());
        if (this.f3400b) {
            c0290m7.f970a.put("android:changeBounds:clip", C0492V4.C0497e.m1913a(view));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        int i;
        View view;
        int i2;
        Rect rect;
        boolean z;
        ObjectAnimator objectAnimator;
        Animator m2218a;
        if (c0290m7 == null || c0290m72 == null) {
            return null;
        }
        Map<String, Object> map = c0290m7.f970a;
        Map<String, Object> map2 = c0290m72.f970a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c0290m72.f971b;
        Rect rect2 = (Rect) c0290m7.f970a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) c0290m72.f970a.get("android:changeBounds:bounds");
        int i3 = rect2.left;
        int i4 = rect3.left;
        int i5 = rect2.top;
        int i6 = rect3.top;
        int i7 = rect2.right;
        int i8 = rect3.right;
        int i9 = rect2.bottom;
        int i10 = rect3.bottom;
        int i11 = i7 - i3;
        int i12 = i9 - i5;
        int i13 = i8 - i4;
        int i14 = i10 - i6;
        Rect rect4 = (Rect) c0290m7.f970a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) c0290m72.f970a.get("android:changeBounds:clip");
        if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
            i = 0;
        } else {
            i = (i3 == i4 && i5 == i6) ? 0 : 1;
            if (i7 != i8 || i9 != i10) {
                i++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i++;
        }
        int i15 = i;
        if (i15 > 0) {
            if (!this.f3400b) {
                view = view2;
                C0399R7.m2045b(view, i3, i5, i7, i9);
                if (i15 == 2) {
                    if (i11 == i13 && i12 == i14) {
                        m2218a = LayoutInflater$Factory2C0000A.C0010h.m2653Y(view, f3397j, getPathMotion().getPath(i3, i5, i4, i6));
                    } else {
                        C0885j c0885j = new C0885j(view);
                        ObjectAnimator m2653Y = LayoutInflater$Factory2C0000A.C0010h.m2653Y(c0885j, f3393f, getPathMotion().getPath(i3, i5, i4, i6));
                        ObjectAnimator m2653Y2 = LayoutInflater$Factory2C0000A.C0010h.m2653Y(c0885j, f3394g, getPathMotion().getPath(i7, i9, i8, i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(m2653Y, m2653Y2);
                        animatorSet.addListener(new C0882g(this, c0885j));
                        m2218a = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    m2218a = LayoutInflater$Factory2C0000A.C0010h.m2653Y(view, f3395h, getPathMotion().getPath(i7, i9, i8, i10));
                } else {
                    m2218a = LayoutInflater$Factory2C0000A.C0010h.m2653Y(view, f3396i, getPathMotion().getPath(i3, i5, i4, i6));
                }
                z = true;
            } else {
                view = view2;
                C0399R7.m2045b(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator m2653Y3 = (i3 == i4 && i5 == i6) ? null : LayoutInflater$Factory2C0000A.C0010h.m2653Y(view, f3397j, getPathMotion().getPath(i3, i5, i4, i6));
                if (rect4 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                if (rect.equals(rect6)) {
                    z = true;
                    objectAnimator = null;
                } else {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0497e.m1911c(view, rect);
                    C0114E7 c0114e7 = f3398k;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", c0114e7, objArr);
                    z = true;
                    ofObject.addListener(new C0883h(this, view, rect5, i4, i6, i8, i10));
                    objectAnimator = ofObject;
                }
                m2218a = C0271L7.m2218a(m2653Y3, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                C0355P7.m2148a(viewGroup4, z);
                addListener(new C0884i(this, viewGroup4));
            }
            return m2218a;
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3391c;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3399a = new int[2];
        this.f3400b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f569b);
        boolean m2672F = LayoutInflater$Factory2C0000A.C0010h.m2672F(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.f3400b = m2672F;
    }
}
