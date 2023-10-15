package com.google.firebase.messaging;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class FirebaseMessagingRegistrar$$Lambda$0 implements ComponentFactory {
    public static final ComponentFactory $instance = new FirebaseMessagingRegistrar$$Lambda$0();

    private FirebaseMessagingRegistrar$$Lambda$0() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FirebaseMessagingRegistrar.lambda$getComponents$0$FirebaseMessagingRegistrar(componentContainer);
    }
}
