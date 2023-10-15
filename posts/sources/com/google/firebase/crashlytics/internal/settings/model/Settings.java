package com.google.firebase.crashlytics.internal.settings.model;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Settings {
    int getCacheDuration();

    long getExpiresAtMillis();

    FeaturesSettingsData getFeaturesData();

    SessionSettingsData getSessionData();

    int getSettingsVersion();

    boolean isExpired(long j);
}
