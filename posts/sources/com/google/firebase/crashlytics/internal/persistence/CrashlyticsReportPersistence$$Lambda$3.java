package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class CrashlyticsReportPersistence$$Lambda$3 implements FilenameFilter {
    private static final CrashlyticsReportPersistence$$Lambda$3 instance = new CrashlyticsReportPersistence$$Lambda$3();

    private CrashlyticsReportPersistence$$Lambda$3() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
    }
}
