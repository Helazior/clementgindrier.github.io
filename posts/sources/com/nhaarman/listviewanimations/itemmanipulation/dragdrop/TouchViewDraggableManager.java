package com.nhaarman.listviewanimations.itemmanipulation.dragdrop;

import android.view.View;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TouchViewDraggableManager implements DraggableManager {
    private final int mTouchViewResId;

    public TouchViewDraggableManager(int i) {
        this.mTouchViewResId = i;
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DraggableManager
    public boolean isDraggable(View view, int i, float f, float f2) {
        View findViewById = view.findViewById(this.mTouchViewResId);
        if (findViewById != null) {
            return ((((float) findViewById.getLeft()) > f ? 1 : (((float) findViewById.getLeft()) == f ? 0 : -1)) <= 0 && (((float) findViewById.getRight()) > f ? 1 : (((float) findViewById.getRight()) == f ? 0 : -1)) >= 0) && ((((float) findViewById.getTop()) > f2 ? 1 : (((float) findViewById.getTop()) == f2 ? 0 : -1)) <= 0 && (((float) findViewById.getBottom()) > f2 ? 1 : (((float) findViewById.getBottom()) == f2 ? 0 : -1)) >= 0);
        }
        return false;
    }
}
