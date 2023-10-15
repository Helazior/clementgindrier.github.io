package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import org.json.JSONObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface SettingsSpiCall {
    JSONObject invoke(SettingsRequest settingsRequest, boolean z);
}
