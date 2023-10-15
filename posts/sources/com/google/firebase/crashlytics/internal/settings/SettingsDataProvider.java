package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface SettingsDataProvider {
    Task<AppSettingsData> getAppSettings();

    Settings getSettings();
}
