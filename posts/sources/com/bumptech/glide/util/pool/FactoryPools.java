package com.bumptech.glide.util.pool;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface Factory<T> {
        T create();
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class FactoryPool<T> implements InterfaceC0037B4<T> {
        private final Factory<T> factory;
        private final InterfaceC0037B4<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(InterfaceC0037B4<T> interfaceC0037B4, Factory<T> factory, Resetter<T> resetter) {
            this.pool = interfaceC0037B4;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // p000.InterfaceC0037B4
        public T acquire() {
            T acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    StringBuilder m253r = outline.m253r("Created new ");
                    m253r.append(acquire.getClass());
                    Log.v(FactoryPools.TAG, m253r.toString());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().setRecycled(false);
            }
            return acquire;
        }

        @Override // p000.InterfaceC0037B4
        public boolean release(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface Poolable {
        StateVerifier getVerifier();
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface Resetter<T> {
        void reset(T t);
    }

    private FactoryPools() {
    }

    private static <T extends Poolable> InterfaceC0037B4<T> build(InterfaceC0037B4<T> interfaceC0037B4, Factory<T> factory) {
        return build(interfaceC0037B4, factory, emptyResetter());
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    public static <T extends Poolable> InterfaceC0037B4<T> simple(int i, Factory<T> factory) {
        return build(new C0056C4(i), factory);
    }

    public static <T extends Poolable> InterfaceC0037B4<T> threadSafe(int i, Factory<T> factory) {
        return build(new C0087D4(i), factory);
    }

    public static <T> InterfaceC0037B4<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    private static <T> InterfaceC0037B4<T> build(InterfaceC0037B4<T> interfaceC0037B4, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(interfaceC0037B4, factory, resetter);
    }

    public static <T> InterfaceC0037B4<List<T>> threadSafeList(int i) {
        return build(new C0087D4(i), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public /* bridge */ /* synthetic */ void reset(Object obj) {
                reset((List) ((List) obj));
            }

            public void reset(List<T> list) {
                list.clear();
            }
        });
    }
}
