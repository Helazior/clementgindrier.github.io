package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ActivityLifecycleObserver {
    @KeepForSdk
    /* renamed from: of */
    public static final ActivityLifecycleObserver m1109of(Activity activity) {
        return new zab(zaa.zaa(activity));
    }

    @KeepForSdk
    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable runnable);
}
