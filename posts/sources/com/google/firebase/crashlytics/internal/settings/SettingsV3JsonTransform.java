package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SettingsV3JsonTransform implements SettingsJsonTransform {
    private static final String CRASHLYTICS_APP_URL = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
    private static final String CRASHLYTICS_APP_URL_FORMAT = "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s";
    private static final String NDK_REPORTS_URL_FORMAT = "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps";
    private static final String REPORTS_URL_FORMAT = "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports";

    private static AppSettingsData buildAppDataFrom(JSONObject jSONObject, JSONObject jSONObject2) {
        String string = jSONObject2.getString(SettingsJsonConstants.APP_STATUS_KEY);
        boolean equals = AppSettingsData.STATUS_NEW.equals(string);
        String string2 = jSONObject.getString(SettingsJsonConstants.FABRIC_BUNDLE_ID);
        String string3 = jSONObject.getString(SettingsJsonConstants.FABRIC_ORGANIZATION_ID);
        String format = equals ? CRASHLYTICS_APP_URL : String.format(Locale.US, CRASHLYTICS_APP_URL_FORMAT, string2);
        Locale locale = Locale.US;
        return new AppSettingsData(string, format, String.format(locale, REPORTS_URL_FORMAT, string2), String.format(locale, NDK_REPORTS_URL_FORMAT, string2), string2, string3, jSONObject2.optBoolean(SettingsJsonConstants.APP_UPDATE_REQUIRED_KEY, false), jSONObject2.optInt(SettingsJsonConstants.APP_REPORT_UPLOAD_VARIANT_KEY, 0), jSONObject2.optInt(SettingsJsonConstants.APP_NATIVE_REPORT_UPLOAD_VARIANT_KEY, 0));
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, true));
    }

    private static SessionSettingsData defaultSessionData() {
        return new SessionSettingsData(8, 4);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has(SettingsJsonConstants.EXPIRES_AT_KEY)) {
            return jSONObject.optLong(SettingsJsonConstants.EXPIRES_AT_KEY);
        }
        return (j * 1000) + currentTimeProvider.getCurrentTimeMillis();
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) {
        return new JSONObject().put(SettingsJsonConstants.APP_STATUS_KEY, appSettingsData.status).put(SettingsJsonConstants.APP_UPDATE_REQUIRED_KEY, appSettingsData.updateRequired).put(SettingsJsonConstants.APP_REPORT_UPLOAD_VARIANT_KEY, appSettingsData.reportUploadVariant).put(SettingsJsonConstants.APP_NATIVE_REPORT_UPLOAD_VARIANT_KEY, appSettingsData.nativeReportUploadVariant);
    }

    private JSONObject toFabricJson(AppSettingsData appSettingsData) {
        return new JSONObject().put(SettingsJsonConstants.FABRIC_BUNDLE_ID, appSettingsData.bundleId).put(SettingsJsonConstants.FABRIC_ORGANIZATION_ID, appSettingsData.organizationId);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        return new JSONObject().put(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, featuresSettingsData.collectReports);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt(SettingsJsonConstants.SETTINGS_VERSION, 0);
        int optInt2 = jSONObject.optInt(SettingsJsonConstants.CACHE_DURATION_KEY, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
        return new SettingsData(getExpiresAtFrom(currentTimeProvider, optInt2, jSONObject), buildAppDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.FABRIC_KEY), jSONObject.getJSONObject(SettingsJsonConstants.APP_KEY)), defaultSessionData(), buildFeaturesSessionDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.FEATURES_KEY)), optInt, optInt2);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public JSONObject toJson(SettingsData settingsData) {
        return new JSONObject().put(SettingsJsonConstants.EXPIRES_AT_KEY, settingsData.expiresAtMillis).put(SettingsJsonConstants.CACHE_DURATION_KEY, settingsData.cacheDuration).put(SettingsJsonConstants.SETTINGS_VERSION, settingsData.settingsVersion).put(SettingsJsonConstants.FEATURES_KEY, toFeaturesJson(settingsData.featuresData)).put(SettingsJsonConstants.APP_KEY, toAppJson(settingsData.appData)).put(SettingsJsonConstants.FABRIC_KEY, toFabricJson(settingsData.appData));
    }
}
