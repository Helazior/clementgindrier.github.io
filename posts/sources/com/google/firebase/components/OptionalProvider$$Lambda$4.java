package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class OptionalProvider$$Lambda$4 implements Deferred.DeferredHandler {
    private static final OptionalProvider$$Lambda$4 instance = new OptionalProvider$$Lambda$4();

    private OptionalProvider$$Lambda$4() {
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        OptionalProvider.lambda$static$0(provider);
    }
}
