package com.nhaarman.listviewanimations.itemmanipulation.dragdrop;

import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HoverDrawable extends BitmapDrawable {
    private float mDownY;
    private float mOriginalY;
    private float mScrollDistance;

    public HoverDrawable(View view, MotionEvent motionEvent) {
        this(view, motionEvent.getY());
    }

    public int getDeltaY() {
        return (int) (getBounds().top - this.mOriginalY);
    }

    public int getTop() {
        return getBounds().top;
    }

    public void handleMoveEvent(MotionEvent motionEvent) {
        setTop((int) (motionEvent.getY() + (this.mOriginalY - this.mDownY) + this.mScrollDistance));
    }

    public boolean isMovingUpwards() {
        return this.mOriginalY > ((float) getBounds().top);
    }

    public void onScroll(float f) {
        this.mScrollDistance = (this.mOriginalY - f) + this.mScrollDistance;
        this.mOriginalY = f;
    }

    public void setTop(int i) {
        setBounds(getBounds().left, i, getIntrinsicWidth() + getBounds().left, getIntrinsicHeight() + i);
    }

    public void shift(int i) {
        if (isMovingUpwards()) {
            i = -i;
        }
        float f = i;
        this.mOriginalY += f;
        this.mDownY += f;
    }

    public HoverDrawable(View view, float f) {
        super(view.getResources(), BitmapUtils.getBitmapFromView(view));
        this.mOriginalY = view.getTop();
        this.mDownY = f;
        setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
