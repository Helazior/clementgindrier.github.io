package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface UndoAdapter {
    View getUndoClickView(View view);

    View getUndoView(int i, View view, ViewGroup viewGroup);
}
