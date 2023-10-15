package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$2 implements Callable {
    private final DefaultHeartBeatInfo arg$1;

    private DefaultHeartBeatInfo$$Lambda$2(DefaultHeartBeatInfo defaultHeartBeatInfo) {
        this.arg$1 = defaultHeartBeatInfo;
    }

    public static Callable lambdaFactory$(DefaultHeartBeatInfo defaultHeartBeatInfo) {
        return new DefaultHeartBeatInfo$$Lambda$2(defaultHeartBeatInfo);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return DefaultHeartBeatInfo.lambda$getAndClearStoredHeartBeatInfo$2(this.arg$1);
    }
}
