package com.google.firebase.iid.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;

@KeepForSdk
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface FirebaseInstanceIdInternal {

    @KeepForSdk
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface NewTokenListener {
        @KeepForSdk
        void onNewToken(String str);
    }

    @KeepForSdk
    void addNewTokenListener(NewTokenListener newTokenListener);

    @KeepForSdk
    void deleteToken(String str, String str2);

    @KeepForSdk
    String getId();

    @KeepForSdk
    String getToken();

    @KeepForSdk
    Task<String> getTokenTask();
}
