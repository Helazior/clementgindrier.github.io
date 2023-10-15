package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;

/* renamed from: O7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0335O7 {

    /* renamed from: O7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0336a extends AnimatorListenerAdapter implements Transition.InterfaceC0911f {

        /* renamed from: a */
        public final View f1129a;

        /* renamed from: b */
        public final View f1130b;

        /* renamed from: c */
        public final int f1131c;

        /* renamed from: d */
        public final int f1132d;

        /* renamed from: e */
        public int[] f1133e;

        /* renamed from: f */
        public float f1134f;

        /* renamed from: g */
        public float f1135g;

        /* renamed from: h */
        public final float f1136h;

        /* renamed from: i */
        public final float f1137i;

        public C0336a(View view, View view2, int i, int i2, float f, float f2) {
            this.f1130b = view;
            this.f1129a = view2;
            this.f1131c = i - Math.round(view.getTranslationX());
            this.f1132d = i2 - Math.round(view.getTranslationY());
            this.f1136h = f;
            this.f1137i = f2;
            int i3 = C0090D7.transition_position;
            int[] iArr = (int[]) view2.getTag(i3);
            this.f1133e = iArr;
            if (iArr != null) {
                view2.setTag(i3, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1133e == null) {
                this.f1133e = new int[2];
            }
            this.f1133e[0] = Math.round(this.f1130b.getTranslationX() + this.f1131c);
            this.f1133e[1] = Math.round(this.f1130b.getTranslationY() + this.f1132d);
            this.f1129a.setTag(C0090D7.transition_position, this.f1133e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f1134f = this.f1130b.getTranslationX();
            this.f1135g = this.f1130b.getTranslationY();
            this.f1130b.setTranslationX(this.f1136h);
            this.f1130b.setTranslationY(this.f1137i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f1130b.setTranslationX(this.f1134f);
            this.f1130b.setTranslationY(this.f1135g);
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            this.f1130b.setTranslationX(this.f1136h);
            this.f1130b.setTranslationY(this.f1137i);
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionResume(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: a */
    public static Animator m2161a(View view, C0290M7 c0290m7, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c0290m7.f971b.getTag(C0090D7.transition_position);
        if (iArr != null) {
            f5 = (iArr[0] - i) + translationX;
            f6 = (iArr[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = Math.round(f5 - translationX) + i;
        int round2 = Math.round(f6 - translationY) + i2;
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f6, f4));
        C0336a c0336a = new C0336a(view, c0290m7.f971b, round, round2, translationX, translationY);
        transition.addListener(c0336a);
        ofPropertyValuesHolder.addListener(c0336a);
        ofPropertyValuesHolder.addPauseListener(c0336a);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
