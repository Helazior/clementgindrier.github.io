package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface CrashlyticsLifecycleEvents {
    void onBeginSession(String str, long j);

    void onCustomKey(String str, String str2);

    void onLog(long j, String str);

    void onUserId(String str);
}
