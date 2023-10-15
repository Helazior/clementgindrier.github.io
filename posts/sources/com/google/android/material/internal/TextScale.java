package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(C0290M7 c0290m7) {
        View view = c0290m7.f971b;
        if (view instanceof TextView) {
            c0290m7.f970a.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        if (c0290m7 == null || c0290m72 == null || !(c0290m7.f971b instanceof TextView)) {
            return null;
        }
        View view = c0290m72.f971b;
        if (view instanceof TextView) {
            final TextView textView = (TextView) view;
            Map<String, Object> map = c0290m7.f970a;
            Map<String, Object> map2 = c0290m72.f970a;
            float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
            float floatValue2 = map2.get(PROPNAME_SCALE) != null ? ((Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
            if (floatValue == floatValue2) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    textView.setScaleX(floatValue3);
                    textView.setScaleY(floatValue3);
                }
            });
            return ofFloat;
        }
        return null;
    }
}
