package com.nhaarman.listviewanimations.util;

import android.view.View;
import android.widget.ListAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class StickyListHeadersListViewWrapper implements ListViewWrapper {
    private final StickyListHeadersListView mListView;

    public StickyListHeadersListViewWrapper(StickyListHeadersListView stickyListHeadersListView) {
        this.mListView = stickyListHeadersListView;
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public ListAdapter getAdapter() {
        return this.mListView.getAdapter();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public View getChildAt(int i) {
        return this.mListView.getListChildAt(i);
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public int getChildCount() {
        return this.mListView.getChildCount();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public int getCount() {
        return this.mListView.getCount();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public int getFirstVisiblePosition() {
        return this.mListView.getFirstVisiblePosition();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public int getHeaderViewsCount() {
        return this.mListView.getHeaderViewsCount();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public int getLastVisiblePosition() {
        return this.mListView.getLastVisiblePosition();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public int getPositionForView(View view) {
        return this.mListView.getPositionForView(view);
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public void smoothScrollBy(int i, int i2) {
        this.mListView.smoothScrollBy(i, i2);
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapper
    public StickyListHeadersListView getListView() {
        return this.mListView;
    }
}
