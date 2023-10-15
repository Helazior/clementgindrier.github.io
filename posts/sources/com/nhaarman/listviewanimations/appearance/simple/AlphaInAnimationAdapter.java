package com.nhaarman.listviewanimations.appearance.simple;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.nineoldandroids.animation.Animator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AlphaInAnimationAdapter extends AnimationAdapter {
    public AlphaInAnimationAdapter(BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    @Override // com.nhaarman.listviewanimations.appearance.AnimationAdapter
    public Animator[] getAnimators(ViewGroup viewGroup, View view) {
        return new Animator[0];
    }
}
