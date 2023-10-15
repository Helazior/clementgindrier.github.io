package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zaci {
    public final RegisterListenerMethod<Api.AnyClient, ?> zaa;
    public final UnregisterListenerMethod<Api.AnyClient, ?> zab;
    public final Runnable zac;

    public zaci(RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, Runnable runnable) {
        this.zaa = registerListenerMethod;
        this.zab = unregisterListenerMethod;
        this.zac = runnable;
    }
}
