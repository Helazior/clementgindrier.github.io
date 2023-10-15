package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    private static AppSettingsData buildAppDataFrom(JSONObject jSONObject) {
        return new AppSettingsData(jSONObject.getString(SettingsJsonConstants.APP_STATUS_KEY), jSONObject.getString("url"), jSONObject.getString(SettingsJsonConstants.APP_REPORTS_URL_KEY), jSONObject.getString(SettingsJsonConstants.APP_NDK_REPORTS_URL_KEY), jSONObject.optBoolean(SettingsJsonConstants.APP_UPDATE_REQUIRED_KEY, false));
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, true));
    }

    private static SessionSettingsData buildSessionDataFrom(JSONObject jSONObject) {
        return new SessionSettingsData(jSONObject.optInt(SettingsJsonConstants.SETTINGS_MAX_CUSTOM_EXCEPTION_EVENTS_KEY, 8), 4);
    }

    public static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        JSONObject jSONObject = new JSONObject();
        return new SettingsData(getExpiresAtFrom(currentTimeProvider, 3600L, jSONObject), null, buildSessionDataFrom(jSONObject), buildFeaturesSessionDataFrom(jSONObject), 0, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has(SettingsJsonConstants.EXPIRES_AT_KEY)) {
            return jSONObject.optLong(SettingsJsonConstants.EXPIRES_AT_KEY);
        }
        return (j * 1000) + currentTimeProvider.getCurrentTimeMillis();
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) {
        return new JSONObject().put(SettingsJsonConstants.APP_STATUS_KEY, appSettingsData.status).put("url", appSettingsData.url).put(SettingsJsonConstants.APP_REPORTS_URL_KEY, appSettingsData.reportsUrl).put(SettingsJsonConstants.APP_NDK_REPORTS_URL_KEY, appSettingsData.ndkReportsUrl).put(SettingsJsonConstants.APP_UPDATE_REQUIRED_KEY, appSettingsData.updateRequired);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        return new JSONObject().put(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, featuresSettingsData.collectReports);
    }

    private JSONObject toSessionJson(SessionSettingsData sessionSettingsData) {
        return new JSONObject().put(SettingsJsonConstants.SETTINGS_MAX_CUSTOM_EXCEPTION_EVENTS_KEY, sessionSettingsData.maxCustomExceptionEvents).put(SettingsJsonConstants.SETTINGS_MAX_COMPLETE_SESSIONS_COUNT_KEY, sessionSettingsData.maxCompleteSessionsCount);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(SettingsJsonConstants.SETTINGS_VERSION, 0);
        int optInt2 = jSONObject.optInt(SettingsJsonConstants.CACHE_DURATION_KEY, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
        return new SettingsData(getExpiresAtFrom(currentTimeProvider, optInt2, jSONObject), buildAppDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.APP_KEY)), buildSessionDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.SESSION_KEY)), buildFeaturesSessionDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.FEATURES_KEY)), optInt, optInt2);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public JSONObject toJson(SettingsData settingsData) {
        return new JSONObject().put(SettingsJsonConstants.EXPIRES_AT_KEY, settingsData.expiresAtMillis).put(SettingsJsonConstants.CACHE_DURATION_KEY, settingsData.cacheDuration).put(SettingsJsonConstants.SETTINGS_VERSION, settingsData.settingsVersion).put(SettingsJsonConstants.FEATURES_KEY, toFeaturesJson(settingsData.featuresData)).put(SettingsJsonConstants.APP_KEY, toAppJson(settingsData.appData)).put(SettingsJsonConstants.SESSION_KEY, toSessionJson(settingsData.sessionData));
    }
}
