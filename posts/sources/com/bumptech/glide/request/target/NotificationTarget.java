package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2) {
        this(context, i, remoteViews, notification, i2, null);
    }

    private void setBitmap(Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    private void update() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.context.getSystemService("notification"))).notify(this.notificationTag, this.notificationId, this.notification);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        setBitmap(null);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, notification, i2, str);
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        setBitmap(bitmap);
    }

    public NotificationTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, Notification notification, int i4, String str) {
        super(i, i2);
        this.context = (Context) Preconditions.checkNotNull(context, "Context must not be null!");
        this.notification = (Notification) Preconditions.checkNotNull(notification, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.viewId = i3;
        this.notificationId = i4;
        this.notificationTag = str;
    }
}
