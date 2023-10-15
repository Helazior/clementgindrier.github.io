package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Fade extends Visibility {

    /* renamed from: androidx.transition.Fade$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0895a extends C0199I7 {

        /* renamed from: a */
        public final /* synthetic */ View f3451a;

        public C0895a(Fade fade, View view) {
            this.f3451a = view;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            View view = this.f3451a;
            C0559X7 c0559x7 = C0399R7.f1350a;
            c0559x7.mo1797f(view, 1.0f);
            c0559x7.mo1802a(this.f3451a);
            transition.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.Fade$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0896b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final View f3452a;

        /* renamed from: b */
        public boolean f3453b = false;

        public C0896b(View view) {
            this.f3452a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0399R7.f1350a.mo1797f(this.f3452a, 1.0f);
            if (this.f3453b) {
                this.f3452a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f3452a;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0495c.m1936h(view) && this.f3452a.getLayerType() == 0) {
                this.f3453b = true;
                this.f3452a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    /* renamed from: a */
    public final Animator m1272a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        C0399R7.f1350a.mo1797f(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, C0399R7.f1351b, f2);
        ofFloat.addListener(new C0896b(view));
        addListener(new C0895a(this, view));
        return ofFloat;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        super.captureStartValues(c0290m7);
        c0290m7.f970a.put("android:fade:transitionAlpha", Float.valueOf(C0399R7.m2046a(c0290m7.f971b)));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        Float f;
        float floatValue = (c0290m7 == null || (f = (Float) c0290m7.f970a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f.floatValue();
        return m1272a(view, floatValue != 1.0f ? floatValue : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        C0399R7.f1350a.mo1800c(view);
        Float f = (Float) c0290m7.f970a.get("android:fade:transitionAlpha");
        return m1272a(view, f != null ? f.floatValue() : 1.0f, 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f571d);
        setMode(LayoutInflater$Factory2C0000A.C0010h.m2669I(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
