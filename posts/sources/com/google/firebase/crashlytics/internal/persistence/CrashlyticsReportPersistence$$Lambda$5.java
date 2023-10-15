package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class CrashlyticsReportPersistence$$Lambda$5 implements Comparator {
    private static final CrashlyticsReportPersistence$$Lambda$5 instance = new CrashlyticsReportPersistence$$Lambda$5();

    private CrashlyticsReportPersistence$$Lambda$5() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((File) obj2).getName().compareTo(((File) obj).getName());
        return compareTo;
    }
}
