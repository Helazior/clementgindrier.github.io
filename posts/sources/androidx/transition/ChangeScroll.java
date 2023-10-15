package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChangeScroll extends Transition {

    /* renamed from: a */
    public static final String[] f3425a = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
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
        c0290m7.f970a.put("android:changeScroll:x", Integer.valueOf(c0290m7.f971b.getScrollX()));
        c0290m7.f970a.put("android:changeScroll:y", Integer.valueOf(c0290m7.f971b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (c0290m7 == null || c0290m72 == null) {
            return null;
        }
        View view = c0290m72.f971b;
        int intValue = ((Integer) c0290m7.f970a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) c0290m72.f970a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) c0290m7.f970a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) c0290m72.f970a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return C0271L7.m2218a(objectAnimator, objectAnimator2);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3425a;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
