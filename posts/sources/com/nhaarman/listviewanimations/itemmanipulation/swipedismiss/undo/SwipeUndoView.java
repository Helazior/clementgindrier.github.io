package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SwipeUndoView extends FrameLayout {
    private View mPrimaryView;
    private View mUndoView;

    public SwipeUndoView(Context context) {
        super(context);
    }

    public View getPrimaryView() {
        return this.mPrimaryView;
    }

    public View getUndoView() {
        return this.mUndoView;
    }

    public void setPrimaryView(View view) {
        View view2 = this.mPrimaryView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mPrimaryView = view;
        addView(view);
    }

    public void setUndoView(View view) {
        View view2 = this.mUndoView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mUndoView = view;
        view.setVisibility(8);
        addView(this.mUndoView);
    }
}
