package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class SingleCheck<T> implements Provider<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((Provider) Preconditions.checkNotNull(p));
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.instance;
        if (t == UNINITIALIZED) {
            Provider<T> provider = this.provider;
            if (provider == null) {
                return (T) this.instance;
            }
            T t2 = provider.get();
            this.instance = t2;
            this.provider = null;
            return t2;
        }
        return t;
    }
}
