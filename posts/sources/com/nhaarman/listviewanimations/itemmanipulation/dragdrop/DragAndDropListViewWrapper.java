package com.nhaarman.listviewanimations.itemmanipulation.dragdrop;

import android.widget.AbsListView;
import com.nhaarman.listviewanimations.util.ListViewWrapper;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface DragAndDropListViewWrapper extends ListViewWrapper {
    int computeVerticalScrollExtent();

    int computeVerticalScrollOffset();

    int computeVerticalScrollRange();

    int pointToPosition(int i, int i2);

    void setOnScrollListener(AbsListView.OnScrollListener onScrollListener);
}
