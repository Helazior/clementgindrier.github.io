package p000;

import java.util.HashMap;
import p000.C1990n1;

/* renamed from: m1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1974m1<K, V> extends C1990n1<K, V> {

    /* renamed from: f */
    public HashMap<K, C1990n1.C1993c<K, V>> f5479f = new HashMap<>();

    @Override // p000.C1990n1
    /* renamed from: a */
    public C1990n1.C1993c<K, V> mo587a(K k) {
        return this.f5479f.get(k);
    }

    public boolean contains(K k) {
        return this.f5479f.containsKey(k);
    }

    @Override // p000.C1990n1
    /* renamed from: d */
    public V mo584d(K k, V v) {
        C1990n1.C1993c<K, V> c1993c = this.f5479f.get(k);
        if (c1993c != null) {
            return c1993c.f5513b;
        }
        this.f5479f.put(k, m585c(k, v));
        return null;
    }

    @Override // p000.C1990n1
    /* renamed from: e */
    public V mo583e(K k) {
        V v = (V) super.mo583e(k);
        this.f5479f.remove(k);
        return v;
    }
}
