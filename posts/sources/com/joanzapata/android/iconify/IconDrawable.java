package com.joanzapata.android.iconify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IconDrawable extends Drawable {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;
    private final Context context;
    private final BaseIconValue icon;
    private TextPaint paint;
    private int size = -1;
    private int alpha = 255;

    public IconDrawable(Context context, BaseIconValue baseIconValue) {
        this.context = context;
        this.icon = baseIconValue;
        TextPaint textPaint = new TextPaint();
        this.paint = textPaint;
        textPaint.setTypeface(Iconify.getTypeface(context, baseIconValue.getTtfFilename()));
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setTextAlign(Paint.Align.CENTER);
        this.paint.setUnderlineText(false);
        this.paint.setColor(-16777216);
        this.paint.setAntiAlias(true);
    }

    public IconDrawable actionBarSize() {
        return sizeDp(24);
    }

    public IconDrawable alpha(int i) {
        setAlpha(i);
        invalidateSelf();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.paint.setColorFilter(null);
    }

    public IconDrawable color(int i) {
        this.paint.setColor(i);
        invalidateSelf();
        return this;
    }

    public IconDrawable colorRes(int i) {
        this.paint.setColor(this.context.getResources().getColor(i));
        invalidateSelf();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int height = bounds.height();
        this.paint.setTextSize(height);
        Rect rect = new Rect();
        String valueOf = String.valueOf(this.icon.character());
        this.paint.getTextBounds(valueOf, 0, 1, rect);
        int height2 = rect.height();
        float exactCenterX = bounds.exactCenterX();
        canvas.drawText(valueOf, exactCenterX, ((((height - height2) / 2.0f) + bounds.top) + height2) - rect.bottom, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.size;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.size;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        int alpha = this.paint.getAlpha();
        int i = Utils.isEnabled(iArr) ? this.alpha : this.alpha / 2;
        this.paint.setAlpha(i);
        return alpha != i;
    }

    public void setStyle(Paint.Style style) {
        this.paint.setStyle(style);
    }

    public IconDrawable sizeDp(int i) {
        return sizePx(Utils.convertDpToPx(this.context, i));
    }

    public IconDrawable sizePx(int i) {
        this.size = i;
        setBounds(0, 0, i, i);
        invalidateSelf();
        return this;
    }

    public IconDrawable sizeRes(int i) {
        return sizePx(this.context.getResources().getDimensionPixelSize(i));
    }
}
