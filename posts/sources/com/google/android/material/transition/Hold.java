package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Visibility;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Hold extends Visibility {
    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        return ValueAnimator.ofFloat(0.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
