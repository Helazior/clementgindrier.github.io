package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class FirebaseMessagingRegistrar$$Lambda$1 implements Transformer {
    public static final Transformer $instance = new FirebaseMessagingRegistrar$$Lambda$1();

    private FirebaseMessagingRegistrar$$Lambda$1() {
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
