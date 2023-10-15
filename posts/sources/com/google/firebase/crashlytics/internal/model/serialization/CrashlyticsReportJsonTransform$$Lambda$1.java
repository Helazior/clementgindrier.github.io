package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform$$Lambda$1 implements CrashlyticsReportJsonTransform.ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$1 instance = new CrashlyticsReportJsonTransform$$Lambda$1();

    private CrashlyticsReportJsonTransform$$Lambda$1() {
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.access$lambda$0(jsonReader);
    }
}
