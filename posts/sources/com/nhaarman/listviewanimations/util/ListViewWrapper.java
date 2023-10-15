package com.nhaarman.listviewanimations.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ListViewWrapper {
    ListAdapter getAdapter();

    View getChildAt(int i);

    int getChildCount();

    int getCount();

    int getFirstVisiblePosition();

    int getHeaderViewsCount();

    int getLastVisiblePosition();

    ViewGroup getListView();

    int getPositionForView(View view);

    void smoothScrollBy(int i, int i2);
}
