package com.squareup.picasso;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public enum MemoryPolicy {
    NO_CACHE(1),
    NO_STORE(2);
    
    public final int index;

    MemoryPolicy(int i) {
        this.index = i;
    }

    public static boolean shouldReadFromMemoryCache(int i) {
        return (i & NO_CACHE.index) == 0;
    }

    public static boolean shouldWriteToMemoryCache(int i) {
        return (i & NO_STORE.index) == 0;
    }
}
