package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$6 implements Continuation {
    public static final Continuation $instance = new FcmBroadcastProcessor$$Lambda$6();

    private FcmBroadcastProcessor$$Lambda$6() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$1$FcmBroadcastProcessor(task);
    }
}
