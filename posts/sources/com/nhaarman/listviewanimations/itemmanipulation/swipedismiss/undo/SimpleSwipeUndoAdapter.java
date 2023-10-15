package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SimpleSwipeUndoAdapter extends SwipeUndoAdapter implements UndoCallback {
    private final Context mContext;
    private final OnDismissCallback mOnDismissCallback;
    private final UndoAdapter mUndoAdapter;
    private final Collection<Integer> mUndoPositions;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class UndoClickListener implements View.OnClickListener {
        private final int mPosition;
        private final SwipeUndoView mView;

        public UndoClickListener(SwipeUndoView swipeUndoView, int i) {
            this.mView = swipeUndoView;
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SimpleSwipeUndoAdapter.this.undo(this.mView);
        }
    }

    public SimpleSwipeUndoAdapter(BaseAdapter baseAdapter, Context context, OnDismissCallback onDismissCallback) {
        super(baseAdapter, null);
        this.mUndoPositions = new ArrayList();
        setUndoCallback(this);
        while (baseAdapter instanceof BaseAdapterDecorator) {
            baseAdapter = ((BaseAdapterDecorator) baseAdapter).getDecoratedBaseAdapter();
        }
        if (baseAdapter instanceof UndoAdapter) {
            this.mUndoAdapter = (UndoAdapter) baseAdapter;
            this.mContext = context;
            this.mOnDismissCallback = onDismissCallback;
            return;
        }
        throw new IllegalStateException("BaseAdapter must implement UndoAdapter!");
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoCallback
    public View getPrimaryView(View view) {
        View primaryView = ((SwipeUndoView) view).getPrimaryView();
        if (primaryView != null) {
            return primaryView;
        }
        throw new IllegalStateException("primaryView == null");
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoCallback
    public View getUndoView(View view) {
        View undoView = ((SwipeUndoView) view).getUndoView();
        if (undoView != null) {
            return undoView;
        }
        throw new IllegalStateException("undoView == null");
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SwipeUndoAdapter, com.nhaarman.listviewanimations.BaseAdapterDecorator, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        SwipeUndoView swipeUndoView = (SwipeUndoView) view;
        if (swipeUndoView == null) {
            swipeUndoView = new SwipeUndoView(this.mContext);
        }
        View view2 = super.getView(i, swipeUndoView.getPrimaryView(), swipeUndoView);
        swipeUndoView.setPrimaryView(view2);
        View undoView = this.mUndoAdapter.getUndoView(i, swipeUndoView.getUndoView(), swipeUndoView);
        swipeUndoView.setUndoView(undoView);
        this.mUndoAdapter.getUndoClickView(undoView).setOnClickListener(new UndoClickListener(swipeUndoView, i));
        boolean contains = this.mUndoPositions.contains(Integer.valueOf(i));
        view2.setVisibility(contains ? 8 : 0);
        undoView.setVisibility(contains ? 0 : 8);
        return swipeUndoView;
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoCallback
    public void onDismiss(View view, int i) {
        this.mUndoPositions.remove(Integer.valueOf(i));
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoCallback
    public void onUndo(View view, int i) {
        this.mUndoPositions.remove(Integer.valueOf(i));
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoCallback
    public void onUndoShown(View view, int i) {
        this.mUndoPositions.add(Integer.valueOf(i));
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback
    public void onDismiss(ViewGroup viewGroup, int[] iArr) {
        this.mOnDismissCallback.onDismiss(viewGroup, iArr);
        Collection<Integer> processDeletions = Util.processDeletions(this.mUndoPositions, iArr);
        this.mUndoPositions.clear();
        this.mUndoPositions.addAll(processDeletions);
    }
}
