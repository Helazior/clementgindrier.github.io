package com.nhaarman.listviewanimations.appearance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class SingleAnimationAdapter extends AnimationAdapter {
    public SingleAnimationAdapter(BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    public abstract Animator getAnimator(ViewGroup viewGroup, View view);

    @Override // com.nhaarman.listviewanimations.appearance.AnimationAdapter
    public Animator[] getAnimators(ViewGroup viewGroup, View view) {
        return new Animator[]{getAnimator(viewGroup, view)};
    }
}
