package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.MissingNativeComponent;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FirebaseCrashlytics {
    private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    public static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    private final CrashlyticsCore core;

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.firebase.crashlytics.CrashlyticsAnalyticsListener] */
    /* JADX WARN: Type inference failed for: r13v7, types: [com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger] */
    /* JADX WARN: Type inference failed for: r14v13, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
    public static FirebaseCrashlytics init(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsConnector analyticsConnector) {
        DisabledBreadcrumbSource disabledBreadcrumbSource;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger;
        DisabledBreadcrumbSource disabledBreadcrumbSource2;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger2;
        Logger logger = Logger.getLogger();
        StringBuilder m253r = outline.m253r("Initializing Firebase Crashlytics ");
        m253r.append(CrashlyticsCore.getVersion());
        logger.m1080i(m253r.toString());
        Context applicationContext = firebaseApp.getApplicationContext();
        IdManager idManager = new IdManager(applicationContext, applicationContext.getPackageName(), firebaseInstallationsApi);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        if (crashlyticsNativeComponent == null) {
            crashlyticsNativeComponent = new MissingNativeComponent();
        }
        CrashlyticsNativeComponent crashlyticsNativeComponent2 = crashlyticsNativeComponent;
        if (analyticsConnector != null) {
            ?? crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
            ?? crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
            if (subscribeToAnalyticsEvents(analyticsConnector, crashlyticsAnalyticsListener) != null) {
                Logger.getLogger().m1084d("Registered Firebase Analytics listener.");
                ?? breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                ?? blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                crashlyticsAnalyticsListener.setBreadcrumbEventReceiver(breadcrumbAnalyticsEventReceiver);
                crashlyticsAnalyticsListener.setCrashlyticsOriginEventReceiver(blockingAnalyticsEventLogger);
                unavailableAnalyticsEventLogger2 = blockingAnalyticsEventLogger;
                disabledBreadcrumbSource2 = breadcrumbAnalyticsEventReceiver;
            } else {
                Logger.getLogger().m1076w("Could not register Firebase Analytics listener; a listener is already registered.");
                unavailableAnalyticsEventLogger2 = crashlyticsOriginAnalyticsEventLogger;
                disabledBreadcrumbSource2 = new DisabledBreadcrumbSource();
            }
            unavailableAnalyticsEventLogger = unavailableAnalyticsEventLogger2;
            disabledBreadcrumbSource = disabledBreadcrumbSource2;
        } else {
            Logger.getLogger().m1084d("Firebase Analytics is not available.");
            disabledBreadcrumbSource = new DisabledBreadcrumbSource();
            unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        }
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponent2, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
        String applicationId = firebaseApp.getOptions().getApplicationId();
        String mappingFileId = CommonUtils.getMappingFileId(applicationContext);
        Logger logger2 = Logger.getLogger();
        logger2.m1084d("Mapping file ID is: " + mappingFileId);
        try {
            AppData create = AppData.create(applicationContext, idManager, applicationId, mappingFileId, new ResourceUnityVersionProvider(applicationContext));
            Logger logger3 = Logger.getLogger();
            StringBuilder m253r2 = outline.m253r("Installer package name is: ");
            m253r2.append(create.installerPackageName);
            logger3.m1078v(m253r2.toString());
            ExecutorService buildSingleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
            final SettingsController create2 = SettingsController.create(applicationContext, applicationId, idManager, new HttpRequestFactory(), create.versionCode, create.versionName, dataCollectionArbiter);
            create2.loadSettingsData(buildSingleThreadExecutorService).continueWith(buildSingleThreadExecutorService, new Continuation<Void, Object>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.1
                @Override // com.google.android.gms.tasks.Continuation
                public Object then(Task<Void> task) {
                    if (task.isSuccessful()) {
                        return null;
                    }
                    Logger.getLogger().m1081e("Error fetching settings.", task.getException());
                    return null;
                }
            });
            final boolean onPreExecute = crashlyticsCore.onPreExecute(create, create2);
            Tasks.call(buildSingleThreadExecutorService, new Callable<Void>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    if (onPreExecute) {
                        crashlyticsCore.doBackgroundInitializationAsync(create2);
                        return null;
                    }
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getLogger().m1081e("Error retrieving app package info.", e);
            return null;
        }
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector analyticsConnector, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", crashlyticsAnalyticsListener);
        if (registerAnalyticsConnectorListener == null) {
            Logger.getLogger().m1084d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(LEGACY_CRASH_ANALYTICS_ORIGIN, crashlyticsAnalyticsListener);
            if (registerAnalyticsConnectorListener != null) {
                Logger.getLogger().m1076w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(String str) {
        this.core.log(str);
    }

    public void recordException(Throwable th) {
        if (th == null) {
            Logger.getLogger().m1076w("A null value was passed to recordException. Ignoring.");
        } else {
            this.core.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(String str, boolean z) {
        this.core.setCustomKey(str, Boolean.toString(z));
    }

    public void setCustomKeys(CustomKeysAndValues customKeysAndValues) {
        this.core.setCustomKeys(customKeysAndValues.keysAndValues);
    }

    public void setUserId(String str) {
        this.core.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(String str, double d) {
        this.core.setCustomKey(str, Double.toString(d));
    }

    public void setCustomKey(String str, float f) {
        this.core.setCustomKey(str, Float.toString(f));
    }

    public void setCustomKey(String str, int i) {
        this.core.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(String str, long j) {
        this.core.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(String str, String str2) {
        this.core.setCustomKey(str, str2);
    }
}
