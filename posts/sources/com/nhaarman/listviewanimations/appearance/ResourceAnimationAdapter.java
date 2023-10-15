package com.nhaarman.listviewanimations.appearance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorInflater;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ResourceAnimationAdapter extends AnimationAdapter {
    private final Context mContext;

    public ResourceAnimationAdapter(BaseAdapter baseAdapter, Context context) {
        super(baseAdapter);
        this.mContext = context;
    }

    public abstract int getAnimationResourceId();

    @Override // com.nhaarman.listviewanimations.appearance.AnimationAdapter
    public Animator[] getAnimators(ViewGroup viewGroup, View view) {
        return new Animator[]{AnimatorInflater.loadAnimator(this.mContext, getAnimationResourceId())};
    }
}
