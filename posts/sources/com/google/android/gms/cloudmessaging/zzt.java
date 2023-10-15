package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class zzt implements Continuation {
    public static final Continuation zza = new zzt();

    private zzt() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return Rpc.zza(task);
    }
}
