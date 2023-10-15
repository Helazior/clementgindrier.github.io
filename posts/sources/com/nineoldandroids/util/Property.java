package com.nineoldandroids.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class Property<T, V> {
    private final String mName;
    private final Class<V> mType;

    public Property(Class<V> cls, String str) {
        this.mName = str;
        this.mType = cls;
    }

    /* renamed from: of */
    public static <T, V> Property<T, V> m1073of(Class<T> cls, Class<V> cls2, String str) {
        return new ReflectiveProperty(cls, cls2, str);
    }

    public abstract V get(T t);

    public String getName() {
        return this.mName;
    }

    public Class<V> getType() {
        return this.mType;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(T t, V v) {
        StringBuilder m253r = outline.m253r("Property ");
        m253r.append(getName());
        m253r.append(" is read-only");
        throw new UnsupportedOperationException(m253r.toString());
    }
}
