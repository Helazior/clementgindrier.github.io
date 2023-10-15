package com.nhaarman.listviewanimations.itemmanipulation.dragdrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GripView extends View {
    private static final int[] ATTRS = {16843173};
    public static final int DEFAULT_COLUMN_COUNT = 2;
    public static final int DEFAULT_DOT_COLOR = 17170432;
    public static final float DEFAULT_DOT_SIZE_RADIUS_DP = 2.0f;
    private int mColumnCount;
    private final Paint mDotPaint;
    private float mDotSizeRadiusPx;
    private float mPaddingTop;
    private int mRowCount;

    public GripView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.mColumnCount; i++) {
            float paddingLeft = (i * 2 * this.mDotSizeRadiusPx * 2.0f) + getPaddingLeft();
            for (int i2 = 0; i2 < this.mRowCount; i2++) {
                float f = this.mPaddingTop;
                float f2 = this.mDotSizeRadiusPx;
                canvas.drawCircle(paddingLeft + f2, (i2 * 2 * f2 * 2.0f) + f + f2, f2, this.mDotPaint);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getPaddingRight() + getPaddingLeft() + ((int) (((this.mDotSizeRadiusPx * 4.0f) - 2.0f) * this.mColumnCount)), 1073741824), i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = this.mDotSizeRadiusPx;
        int paddingTop = (int) (((i2 - getPaddingTop()) - getPaddingBottom()) / (4.0f * f));
        this.mRowCount = paddingTop;
        this.mPaddingTop = ((i2 - ((paddingTop * f) * 2.0f)) - (((paddingTop - 1) * f) * 2.0f)) / 2.0f;
    }

    public void setColor(int i) {
        this.mDotPaint.setColor(getResources().getColor(i));
    }

    public void setColumnCount(int i) {
        this.mColumnCount = i;
        requestLayout();
    }

    public void setDotSizeRadiusPx(float f) {
        this.mDotSizeRadiusPx = f;
    }

    public GripView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GripView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColumnCount = 2;
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        int color = getResources().getColor(DEFAULT_DOT_COLOR);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            color = obtainStyledAttributes.getColor(0, color);
            obtainStyledAttributes.recycle();
        }
        paint.setColor(color);
        this.mDotSizeRadiusPx = (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
    }
}
