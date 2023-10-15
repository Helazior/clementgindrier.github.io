package com.nhaarman.listviewanimations.appearance.simple;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.appearance.SingleAnimationAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SwingRightInAnimationAdapter extends SingleAnimationAdapter {
    private static final String TRANSLATION_X = "translationX";

    public SwingRightInAnimationAdapter(BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    @Override // com.nhaarman.listviewanimations.appearance.SingleAnimationAdapter
    public Animator getAnimator(ViewGroup viewGroup, View view) {
        return ObjectAnimator.ofFloat(view, TRANSLATION_X, viewGroup.getWidth(), 0.0f);
    }
}
