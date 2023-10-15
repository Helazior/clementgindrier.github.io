package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.DismissableManager;
import com.nhaarman.listviewanimations.util.ListViewWrapper;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class SwipeUndoAdapter extends BaseAdapterDecorator {
    private SwipeUndoTouchListener mSwipeUndoTouchListener;
    private UndoCallback mUndoCallback;

    public SwipeUndoAdapter(BaseAdapter baseAdapter, UndoCallback undoCallback) {
        super(baseAdapter);
        this.mUndoCallback = undoCallback;
    }

    public void dismiss(int i) {
        this.mSwipeUndoTouchListener.dismiss(i);
    }

    public UndoCallback getUndoCallback() {
        return this.mUndoCallback;
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getListViewWrapper() != null) {
            return super.getView(i, view, viewGroup);
        }
        throw new IllegalArgumentException("Call setAbsListView() on this SwipeUndoAdapter before setAdapter()!");
    }

    public void setDismissableManager(DismissableManager dismissableManager) {
        SwipeUndoTouchListener swipeUndoTouchListener = this.mSwipeUndoTouchListener;
        if (swipeUndoTouchListener != null) {
            swipeUndoTouchListener.setDismissableManager(dismissableManager);
            return;
        }
        throw new IllegalStateException("You must call setAbsListView() first.");
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, com.nhaarman.listviewanimations.util.ListViewWrapperSetter
    public void setListViewWrapper(ListViewWrapper listViewWrapper) {
        super.setListViewWrapper(listViewWrapper);
        this.mSwipeUndoTouchListener = new SwipeUndoTouchListener(listViewWrapper, this.mUndoCallback);
        if (listViewWrapper.getListView() instanceof DynamicListView) {
            return;
        }
        listViewWrapper.getListView().setOnTouchListener(this.mSwipeUndoTouchListener);
    }

    public void setSwipeUndoTouchListener(SwipeUndoTouchListener swipeUndoTouchListener) {
        this.mSwipeUndoTouchListener = swipeUndoTouchListener;
    }

    public void setUndoCallback(UndoCallback undoCallback) {
        this.mUndoCallback = undoCallback;
    }

    public void undo(View view) {
        this.mSwipeUndoTouchListener.undo(view);
    }
}
