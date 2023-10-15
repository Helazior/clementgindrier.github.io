package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Logger {
    private int logLevel = 4;
    private final String tag;
    public static final String TAG = "FirebaseCrashlytics";
    public static final Logger DEFAULT_LOGGER = new Logger(TAG);

    public Logger(String str) {
        this.tag = str;
    }

    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    /* renamed from: d */
    public void m1083d(String str, Throwable th) {
        if (canLog(3)) {
            Log.d(this.tag, str, th);
        }
    }

    /* renamed from: e */
    public void m1081e(String str, Throwable th) {
        if (canLog(6)) {
            Log.e(this.tag, str, th);
        }
    }

    /* renamed from: i */
    public void m1079i(String str, Throwable th) {
        if (canLog(4)) {
            Log.i(this.tag, str, th);
        }
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    /* renamed from: v */
    public void m1077v(String str, Throwable th) {
        if (canLog(2)) {
            Log.v(this.tag, str, th);
        }
    }

    /* renamed from: w */
    public void m1075w(String str, Throwable th) {
        if (canLog(5)) {
            Log.w(this.tag, str, th);
        }
    }

    public void log(int i, String str, boolean z) {
        if (z || canLog(i)) {
            Log.println(i, this.tag, str);
        }
    }

    /* renamed from: d */
    public void m1084d(String str) {
        m1083d(str, null);
    }

    /* renamed from: e */
    public void m1082e(String str) {
        m1081e(str, null);
    }

    /* renamed from: i */
    public void m1080i(String str) {
        m1079i(str, null);
    }

    /* renamed from: v */
    public void m1078v(String str) {
        m1077v(str, null);
    }

    /* renamed from: w */
    public void m1076w(String str) {
        m1075w(str, null);
    }
}
