package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AnimationUtils {
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new C1621d6();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new C0989c6();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new C1658e6();
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float f, float f2, float f3) {
        return outline.m270a(f2, f, f3, f);
    }

    public static int lerp(int i, int i2, float f) {
        return Math.round(f * (i2 - i)) + i;
    }

    public static float lerp(float f, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? f : f5 > f4 ? f2 : lerp(f, f2, (f5 - f3) / (f4 - f3));
    }
}
