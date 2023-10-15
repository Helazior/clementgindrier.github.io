package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class MessagingAnalytics$$Lambda$0 implements Transformer {
    public static final Transformer $instance = new MessagingAnalytics$$Lambda$0();

    private MessagingAnalytics$$Lambda$0() {
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
