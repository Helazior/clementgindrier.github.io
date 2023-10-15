package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChangeClipBounds extends Transition {

    /* renamed from: a */
    public static final String[] f3419a = {"android:clipBounds:clip"};

    /* renamed from: androidx.transition.ChangeClipBounds$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0886a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ View f3420a;

        public C0886a(ChangeClipBounds changeClipBounds, View view) {
            this.f3420a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f3420a;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0497e.m1911c(view, null);
        }
    }

    public ChangeClipBounds() {
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
        if (view.getVisibility() == 8) {
            return;
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        Rect m1913a = C0492V4.C0497e.m1913a(view);
        c0290m7.f970a.put("android:clipBounds:clip", m1913a);
        if (m1913a == null) {
            c0290m7.f970a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        ObjectAnimator objectAnimator = null;
        if (c0290m7 != null && c0290m72 != null && c0290m7.f970a.containsKey("android:clipBounds:clip") && c0290m72.f970a.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) c0290m7.f970a.get("android:clipBounds:clip");
            Rect rect2 = (Rect) c0290m72.f970a.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) c0290m7.f970a.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) c0290m72.f970a.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            View view = c0290m72.f971b;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0497e.m1911c(view, rect);
            objectAnimator = ObjectAnimator.ofObject(c0290m72.f971b, (Property<View, V>) C0399R7.f1352c, (TypeEvaluator) new C0114E7(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                objectAnimator.addListener(new C0886a(this, c0290m72.f971b));
            }
        }
        return objectAnimator;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3419a;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
