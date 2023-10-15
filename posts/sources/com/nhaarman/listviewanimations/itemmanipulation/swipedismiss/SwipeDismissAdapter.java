package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.ArrayAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.ListViewWrapper;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SwipeDismissAdapter extends BaseAdapterDecorator {
    private SwipeDismissTouchListener mDismissTouchListener;
    private final OnDismissCallback mOnDismissCallback;
    private boolean mParentIsHorizontalScrollContainer;
    private int mSwipeTouchChildResId;

    public SwipeDismissAdapter(BaseAdapter baseAdapter, OnDismissCallback onDismissCallback) {
        super(baseAdapter);
        this.mOnDismissCallback = onDismissCallback;
    }

    public void dismiss(int i) {
        SwipeDismissTouchListener swipeDismissTouchListener = this.mDismissTouchListener;
        if (swipeDismissTouchListener != null) {
            swipeDismissTouchListener.dismiss(i);
            return;
        }
        throw new IllegalStateException("Call setListViewWrapper on this SwipeDismissAdapter!");
    }

    public SwipeDismissTouchListener getDismissTouchListener() {
        return this.mDismissTouchListener;
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        SwipeDismissTouchListener swipeDismissTouchListener = this.mDismissTouchListener;
        if (swipeDismissTouchListener != null) {
            swipeDismissTouchListener.notifyDataSetChanged();
        }
    }

    public void setDismissableManager(DismissableManager dismissableManager) {
        SwipeDismissTouchListener swipeDismissTouchListener = this.mDismissTouchListener;
        if (swipeDismissTouchListener != null) {
            swipeDismissTouchListener.setDismissableManager(dismissableManager);
            return;
        }
        throw new IllegalStateException("You must call setAbsListView() first.");
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, com.nhaarman.listviewanimations.util.ListViewWrapperSetter
    public void setListViewWrapper(ListViewWrapper listViewWrapper) {
        super.setListViewWrapper(listViewWrapper);
        if (getDecoratedBaseAdapter() instanceof ArrayAdapter) {
            ((ArrayAdapter) getDecoratedBaseAdapter()).propagateNotifyDataSetChanged(this);
        }
        SwipeDismissTouchListener swipeDismissTouchListener = new SwipeDismissTouchListener(listViewWrapper, this.mOnDismissCallback);
        this.mDismissTouchListener = swipeDismissTouchListener;
        if (this.mParentIsHorizontalScrollContainer) {
            swipeDismissTouchListener.setParentIsHorizontalScrollContainer();
        }
        int i = this.mSwipeTouchChildResId;
        if (i != 0) {
            this.mDismissTouchListener.setTouchChild(i);
        }
        listViewWrapper.getListView().setOnTouchListener(this.mDismissTouchListener);
    }

    public void setParentIsHorizontalScrollContainer() {
        this.mParentIsHorizontalScrollContainer = true;
        this.mSwipeTouchChildResId = 0;
        SwipeDismissTouchListener swipeDismissTouchListener = this.mDismissTouchListener;
        if (swipeDismissTouchListener != null) {
            swipeDismissTouchListener.setParentIsHorizontalScrollContainer();
        }
    }

    public void setSwipeTouchChildResId(int i) {
        this.mSwipeTouchChildResId = i;
        SwipeDismissTouchListener swipeDismissTouchListener = this.mDismissTouchListener;
        if (swipeDismissTouchListener != null) {
            swipeDismissTouchListener.setTouchChild(i);
        }
    }
}
