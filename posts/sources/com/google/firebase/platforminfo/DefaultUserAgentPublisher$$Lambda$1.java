package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class DefaultUserAgentPublisher$$Lambda$1 implements ComponentFactory {
    private static final DefaultUserAgentPublisher$$Lambda$1 instance = new DefaultUserAgentPublisher$$Lambda$1();

    private DefaultUserAgentPublisher$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
    }
}
