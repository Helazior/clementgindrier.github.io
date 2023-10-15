package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$5 implements ThreadFactory {
    private static final DefaultHeartBeatInfo$$Lambda$5 instance = new DefaultHeartBeatInfo$$Lambda$5();

    private DefaultHeartBeatInfo$$Lambda$5() {
    }

    public static ThreadFactory lambdaFactory$() {
        return instance;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.lambda$static$0(runnable);
    }
}
