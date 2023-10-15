package com.bumptech.glide.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends C2339x1<K, V> {
    private int hashCode;

    @Override // p000.C0101E1, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // p000.C0101E1, java.util.Map
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    @Override // p000.C0101E1, java.util.Map
    public V put(K k, V v) {
        this.hashCode = 0;
        return (V) super.put(k, v);
    }

    @Override // p000.C0101E1
    public void putAll(C0101E1<? extends K, ? extends V> c0101e1) {
        this.hashCode = 0;
        super.putAll(c0101e1);
    }

    @Override // p000.C0101E1
    public V removeAt(int i) {
        this.hashCode = 0;
        return (V) super.removeAt(i);
    }

    @Override // p000.C0101E1
    public V setValueAt(int i, V v) {
        this.hashCode = 0;
        return (V) super.setValueAt(i, v);
    }
}
