package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class SchemaManager$$Lambda$4 implements SchemaManager.Migration {
    private static final SchemaManager$$Lambda$4 instance = new SchemaManager$$Lambda$4();

    private SchemaManager$$Lambda$4() {
    }

    public static SchemaManager.Migration lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$3(sQLiteDatabase);
    }
}
