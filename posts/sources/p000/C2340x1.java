package p000;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p000.AbstractC0077D1;

/* renamed from: x1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2339x1<K, V> extends C0101E1<K, V> implements Map<K, V> {
    public AbstractC0077D1<K, V> mCollections;

    /* renamed from: x1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2340a extends AbstractC0077D1<K, V> {
        public C2340a() {
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: a */
        public void mo77a() {
            C2339x1.this.clear();
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: b */
        public Object mo76b(int i, int i2) {
            return C2339x1.this.mArray[(i << 1) + i2];
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: c */
        public Map<K, V> mo75c() {
            return C2339x1.this;
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: d */
        public int mo74d() {
            return C2339x1.this.mSize;
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: e */
        public int mo73e(Object obj) {
            return C2339x1.this.indexOfKey(obj);
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: f */
        public int mo72f(Object obj) {
            return C2339x1.this.indexOfValue(obj);
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: g */
        public void mo71g(K k, V v) {
            C2339x1.this.put(k, v);
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: h */
        public void mo70h(int i) {
            C2339x1.this.removeAt(i);
        }

        @Override // p000.AbstractC0077D1
        /* renamed from: i */
        public V mo69i(int i, V v) {
            return C2339x1.this.setValueAt(i, v);
        }
    }

    public C2339x1() {
    }

    private AbstractC0077D1<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new C2340a();
        }
        return this.mCollections;
    }

    public boolean containsAll(Collection<?> collection) {
        return AbstractC0077D1.m2491j(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        AbstractC0077D1<K, V> collection = getCollection();
        if (collection.f318a == null) {
            collection.f318a = new AbstractC0077D1.C0079b();
        }
        return collection.f318a;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        AbstractC0077D1<K, V> collection = getCollection();
        if (collection.f319b == null) {
            collection.f319b = new AbstractC0077D1.C0080c();
        }
        return collection.f319b;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size() + this.mSize);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return AbstractC0077D1.m2489l(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return AbstractC0077D1.m2488m(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        AbstractC0077D1<K, V> collection = getCollection();
        if (collection.f320c == null) {
            collection.f320c = new AbstractC0077D1.C0082e();
        }
        return collection.f320c;
    }

    public C2339x1(int i) {
        super(i);
    }

    public C2339x1(C0101E1 c0101e1) {
        super(c0101e1);
    }
}
