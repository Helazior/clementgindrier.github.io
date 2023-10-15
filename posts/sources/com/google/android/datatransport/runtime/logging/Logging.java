package com.google.android.datatransport.runtime.logging;

import android.util.Log;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Logging {
    private Logging() {
    }

    /* renamed from: d */
    public static void m1116d(String str, String str2) {
        Log.d(getTag(str), str2);
    }

    /* renamed from: e */
    public static void m1112e(String str, String str2, Throwable th) {
        Log.e(getTag(str), str2, th);
    }

    private static String getTag(String str) {
        return outline.m266e("TransportRuntime.", str);
    }

    /* renamed from: i */
    public static void m1111i(String str, String str2) {
        Log.i(getTag(str), str2);
    }

    /* renamed from: w */
    public static void m1110w(String str, String str2, Object obj) {
        Log.w(getTag(str), String.format(str2, obj));
    }

    /* renamed from: d */
    public static void m1115d(String str, String str2, Object obj) {
        Log.d(getTag(str), String.format(str2, obj));
    }

    /* renamed from: d */
    public static void m1114d(String str, String str2, Object obj, Object obj2) {
        Log.d(getTag(str), String.format(str2, obj, obj2));
    }

    /* renamed from: d */
    public static void m1113d(String str, String str2, Object... objArr) {
        Log.d(getTag(str), String.format(str2, objArr));
    }
}
