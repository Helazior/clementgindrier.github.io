package com.nhaarman.listviewanimations.appearance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.AnimatorUtil;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nhaarman.listviewanimations.util.StickyListHeadersListViewWrapper;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class StickyListHeadersAdapterDecorator extends BaseAdapterDecorator implements StickyListHeadersAdapter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ALPHA = "alpha";
    private final StickyListHeadersAdapter mStickyListHeadersAdapter;
    private ViewAnimator mViewAnimator;

    public StickyListHeadersAdapterDecorator(BaseAdapter baseAdapter) {
        super(baseAdapter);
        while (baseAdapter instanceof BaseAdapterDecorator) {
            baseAdapter = ((BaseAdapterDecorator) baseAdapter).getDecoratedBaseAdapter();
        }
        if (baseAdapter instanceof StickyListHeadersAdapter) {
            this.mStickyListHeadersAdapter = (StickyListHeadersAdapter) baseAdapter;
            return;
        }
        throw new IllegalArgumentException(baseAdapter.getClass().getCanonicalName() + " does not implement StickyListHeadersAdapter");
    }

    private void animateViewIfNecessary(int i, View view, ViewGroup viewGroup) {
        this.mViewAnimator.animateViewIfNecessary(i, view, AnimatorUtil.concatAnimators(getDecoratedBaseAdapter() instanceof AnimationAdapter ? ((AnimationAdapter) getDecoratedBaseAdapter()).getAnimators(viewGroup, view) : new Animator[0], new Animator[0], ObjectAnimator.ofFloat(view, ALPHA, 0.0f, 1.0f)));
    }

    public long getHeaderId(int i) {
        return this.mStickyListHeadersAdapter.getHeaderId(i);
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        if (getListViewWrapper() != null) {
            if (view != null) {
                this.mViewAnimator.cancelExistingAnimation(view);
            }
            View headerView = this.mStickyListHeadersAdapter.getHeaderView(i, view, viewGroup);
            animateViewIfNecessary(i, headerView, viewGroup);
            return headerView;
        }
        throw new IllegalStateException("Call setStickyListHeadersListView() on this AnimationAdapter first!");
    }

    public ViewAnimator getViewAnimator() {
        return this.mViewAnimator;
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, com.nhaarman.listviewanimations.util.ListViewWrapperSetter
    public void setListViewWrapper(ListViewWrapper listViewWrapper) {
        super.setListViewWrapper(listViewWrapper);
        this.mViewAnimator = new ViewAnimator(listViewWrapper);
    }

    public void setStickyListHeadersListView(StickyListHeadersListView stickyListHeadersListView) {
        setListViewWrapper(new StickyListHeadersListViewWrapper(stickyListHeadersListView));
    }
}
