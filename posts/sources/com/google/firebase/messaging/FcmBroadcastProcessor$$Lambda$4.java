package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$4 implements Continuation {
    public static final Continuation $instance = new FcmBroadcastProcessor$$Lambda$4();

    private FcmBroadcastProcessor$$Lambda$4() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$bindToMessagingService$3$FcmBroadcastProcessor(task);
    }
}
