package com.google.firebase.crashlytics.internal.settings.model;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SessionSettingsData {
    public final int maxCompleteSessionsCount;
    public final int maxCustomExceptionEvents;

    public SessionSettingsData(int i, int i2) {
        this.maxCustomExceptionEvents = i;
        this.maxCompleteSessionsCount = i2;
    }
}
