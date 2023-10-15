package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class Registrar$$Lambda$1 implements ComponentFactory {
    public static final ComponentFactory $instance = new Registrar$$Lambda$1();

    private Registrar$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return Registrar.lambda$getComponents$1$Registrar(componentContainer);
    }
}
