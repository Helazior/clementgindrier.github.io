package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$4 implements ComponentFactory {
    private static final DefaultHeartBeatInfo$$Lambda$4 instance = new DefaultHeartBeatInfo$$Lambda$4();

    private DefaultHeartBeatInfo$$Lambda$4() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatInfo.lambda$component$4(componentContainer);
    }
}
