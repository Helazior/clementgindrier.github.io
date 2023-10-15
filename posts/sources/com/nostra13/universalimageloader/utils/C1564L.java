package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

/* renamed from: com.nostra13.universalimageloader.utils.L */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1564L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    private C1564L() {
    }

    /* renamed from: d */
    public static void m1070d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    /* renamed from: e */
    public static void m1068e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    /* renamed from: i */
    public static void m1066i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    private static void log(int i, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format(LOG_FORMAT, str, Log.getStackTraceString(th));
            }
            Log.println(i, ImageLoader.TAG, str);
        }
    }

    /* renamed from: w */
    public static void m1065w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void writeDebugLogs(boolean z) {
        writeDebugLogs = z;
    }

    public static void writeLogs(boolean z) {
        writeLogs = z;
    }

    /* renamed from: e */
    public static void m1069e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    /* renamed from: e */
    public static void m1067e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }
}
