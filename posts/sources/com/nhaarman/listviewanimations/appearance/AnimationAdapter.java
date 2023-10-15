package com.nhaarman.listviewanimations.appearance;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.AnimatorUtil;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AnimationAdapter extends BaseAdapterDecorator {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ALPHA = "alpha";
    private static final String SAVEDINSTANCESTATE_VIEWANIMATOR = "savedinstancestate_viewanimator";
    private int mGridViewMeasuringPosition;
    private boolean mGridViewPossiblyMeasuring;
    private boolean mIsRootAdapter;
    private ViewAnimator mViewAnimator;

    public AnimationAdapter(BaseAdapter baseAdapter) {
        super(baseAdapter);
        this.mGridViewPossiblyMeasuring = true;
        this.mGridViewMeasuringPosition = -1;
        this.mIsRootAdapter = true;
        if (baseAdapter instanceof AnimationAdapter) {
            ((AnimationAdapter) baseAdapter).setIsWrapped();
        }
    }

    private void animateViewIfNecessary(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z = this.mGridViewPossiblyMeasuring && ((i2 = this.mGridViewMeasuringPosition) == -1 || i2 == i);
        this.mGridViewPossiblyMeasuring = z;
        if (z) {
            this.mGridViewMeasuringPosition = i;
            this.mViewAnimator.setLastAnimatedPosition(-1);
        }
        this.mViewAnimator.animateViewIfNecessary(i, view, AnimatorUtil.concatAnimators(getDecoratedBaseAdapter() instanceof AnimationAdapter ? ((AnimationAdapter) getDecoratedBaseAdapter()).getAnimators(viewGroup, view) : new Animator[0], getAnimators(viewGroup, view), ObjectAnimator.ofFloat(view, ALPHA, 0.0f, 1.0f)));
    }

    private void setIsWrapped() {
        this.mIsRootAdapter = false;
    }

    public abstract Animator[] getAnimators(ViewGroup viewGroup, View view);

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.mIsRootAdapter) {
            if (getListViewWrapper() == null) {
                throw new IllegalStateException("Call setAbsListView() on this AnimationAdapter first!");
            }
            if (view != null) {
                this.mViewAnimator.cancelExistingAnimation(view);
            }
        }
        View view2 = super.getView(i, view, viewGroup);
        if (this.mIsRootAdapter) {
            animateViewIfNecessary(i, view2, viewGroup);
        }
        return view2;
    }

    public ViewAnimator getViewAnimator() {
        return this.mViewAnimator;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            ViewAnimator viewAnimator = this.mViewAnimator;
            if (viewAnimator != null) {
                viewAnimator.onRestoreInstanceState(bundle.getParcelable(SAVEDINSTANCESTATE_VIEWANIMATOR));
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        ViewAnimator viewAnimator = this.mViewAnimator;
        if (viewAnimator != null) {
            bundle.putParcelable(SAVEDINSTANCESTATE_VIEWANIMATOR, viewAnimator.onSaveInstanceState());
        }
        return bundle;
    }

    public void reset() {
        if (getListViewWrapper() != null) {
            this.mViewAnimator.reset();
            this.mGridViewPossiblyMeasuring = true;
            this.mGridViewMeasuringPosition = -1;
            if (getDecoratedBaseAdapter() instanceof AnimationAdapter) {
                ((AnimationAdapter) getDecoratedBaseAdapter()).reset();
                return;
            }
            return;
        }
        throw new IllegalStateException("Call setAbsListView() on this AnimationAdapter first!");
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, com.nhaarman.listviewanimations.util.ListViewWrapperSetter
    public void setListViewWrapper(ListViewWrapper listViewWrapper) {
        super.setListViewWrapper(listViewWrapper);
        this.mViewAnimator = new ViewAnimator(listViewWrapper);
    }
}
