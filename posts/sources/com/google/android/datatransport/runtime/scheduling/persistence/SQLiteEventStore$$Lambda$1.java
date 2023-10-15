package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class SQLiteEventStore$$Lambda$1 implements SQLiteEventStore.Producer {
    private final SchemaManager arg$1;

    private SQLiteEventStore$$Lambda$1(SchemaManager schemaManager) {
        this.arg$1 = schemaManager;
    }

    public static SQLiteEventStore.Producer lambdaFactory$(SchemaManager schemaManager) {
        return new SQLiteEventStore$$Lambda$1(schemaManager);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    public Object produce() {
        return this.arg$1.getWritableDatabase();
    }
}
