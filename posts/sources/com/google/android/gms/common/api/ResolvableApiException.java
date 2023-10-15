package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public void startResolutionForResult(Activity activity, int i) {
        getStatus().startResolutionForResult(activity, i);
    }
}
