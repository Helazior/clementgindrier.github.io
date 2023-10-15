package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zaaf {
    private final ApiKey<?> zaa;
    private final TaskCompletionSource<Boolean> zab = new TaskCompletionSource<>();

    public zaaf(ApiKey<?> apiKey) {
        this.zaa = apiKey;
    }

    public final ApiKey<?> zaa() {
        return this.zaa;
    }

    public final TaskCompletionSource<Boolean> zab() {
        return this.zab;
    }
}
