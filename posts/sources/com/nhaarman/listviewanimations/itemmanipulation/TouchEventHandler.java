package com.nhaarman.listviewanimations.itemmanipulation;

import android.view.MotionEvent;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TouchEventHandler {
    boolean isInteracting();

    boolean onTouchEvent(MotionEvent motionEvent);
}
