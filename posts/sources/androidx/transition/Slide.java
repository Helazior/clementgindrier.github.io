package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.concurrent.atomic.AtomicInteger;
import org.xmlpull.p019v1.XmlPullParser;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Slide extends Visibility {

    /* renamed from: b */
    public static final TimeInterpolator f3456b = new DecelerateInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator f3457c = new AccelerateInterpolator();

    /* renamed from: d */
    public static final InterfaceC0903g f3458d = new C0897a();

    /* renamed from: f */
    public static final InterfaceC0903g f3459f = new C0898b();

    /* renamed from: g */
    public static final InterfaceC0903g f3460g = new C0899c();

    /* renamed from: h */
    public static final InterfaceC0903g f3461h = new C0900d();

    /* renamed from: i */
    public static final InterfaceC0903g f3462i = new C0901e();

    /* renamed from: j */
    public static final InterfaceC0903g f3463j = new C0902f();

    /* renamed from: a */
    public InterfaceC0903g f3464a;

    /* renamed from: androidx.transition.Slide$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0897a extends AbstractC0904h {
        public C0897a() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: b */
        public float mo1268b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0898b extends AbstractC0904h {
        public C0898b() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: b */
        public float mo1268b(ViewGroup viewGroup, View view) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0496d.m1921d(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0899c extends AbstractC0905i {
        public C0899c() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: a */
        public float mo1269a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    /* renamed from: androidx.transition.Slide$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0900d extends AbstractC0904h {
        public C0900d() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: b */
        public float mo1268b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0901e extends AbstractC0904h {
        public C0901e() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: b */
        public float mo1268b(ViewGroup viewGroup, View view) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0496d.m1921d(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0902f extends AbstractC0905i {
        public C0902f() {
            super(null);
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: a */
        public float mo1269a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    /* renamed from: androidx.transition.Slide$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0903g {
        /* renamed from: a */
        float mo1269a(ViewGroup viewGroup, View view);

        /* renamed from: b */
        float mo1268b(ViewGroup viewGroup, View view);
    }

    /* renamed from: androidx.transition.Slide$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0904h implements InterfaceC0903g {
        public AbstractC0904h(C0897a c0897a) {
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: a */
        public float mo1269a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    /* renamed from: androidx.transition.Slide$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0905i implements InterfaceC0903g {
        public AbstractC0905i(C0897a c0897a) {
        }

        @Override // androidx.transition.Slide.InterfaceC0903g
        /* renamed from: b */
        public float mo1268b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        this.f3464a = f3463j;
        m1270a(80);
    }

    /* renamed from: a */
    public void m1270a(int i) {
        if (i == 3) {
            this.f3464a = f3458d;
        } else if (i == 5) {
            this.f3464a = f3461h;
        } else if (i == 48) {
            this.f3464a = f3460g;
        } else if (i == 80) {
            this.f3464a = f3463j;
        } else if (i == 8388611) {
            this.f3464a = f3459f;
        } else if (i == 8388613) {
            this.f3464a = f3462i;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        C0153G7 c0153g7 = new C0153G7();
        c0153g7.f498b = i;
        setPropagation(c0153g7);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        super.captureEndValues(c0290m7);
        int[] iArr = new int[2];
        c0290m7.f971b.getLocationOnScreen(iArr);
        c0290m7.f970a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        super.captureStartValues(c0290m7);
        int[] iArr = new int[2];
        c0290m7.f971b.getLocationOnScreen(iArr);
        c0290m7.f970a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        int[] iArr = (int[]) c0290m72.f970a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return C0335O7.m2161a(view, c0290m72, iArr[0], iArr[1], this.f3464a.mo1268b(viewGroup, view), this.f3464a.mo1269a(viewGroup, view), translationX, translationY, f3456b, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        int[] iArr = (int[]) c0290m7.f970a.get("android:slide:screenPosition");
        return C0335O7.m2161a(view, c0290m7, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f3464a.mo1268b(viewGroup, view), this.f3464a.mo1269a(viewGroup, view), f3457c, this);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3464a = f3463j;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f573f);
        int m2669I = LayoutInflater$Factory2C0000A.C0010h.m2669I(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        m1270a(m2669I);
    }
}
