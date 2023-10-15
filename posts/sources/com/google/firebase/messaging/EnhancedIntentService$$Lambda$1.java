package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class EnhancedIntentService$$Lambda$1 implements Executor {
    public static final Executor $instance = new EnhancedIntentService$$Lambda$1();

    private EnhancedIntentService$$Lambda$1() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
