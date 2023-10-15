package com.nhaarman.listviewanimations.itemmanipulation.dragdrop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BitmapUtils {
    private BitmapUtils() {
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
