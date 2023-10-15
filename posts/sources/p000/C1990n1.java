package p000;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: n1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1990n1<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    public C1993c<K, V> f5508a;

    /* renamed from: b */
    public C1993c<K, V> f5509b;

    /* renamed from: c */
    public WeakHashMap<InterfaceC1996f<K, V>, Boolean> f5510c = new WeakHashMap<>();

    /* renamed from: d */
    public int f5511d = 0;

    /* renamed from: n1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1991a<K, V> extends AbstractC1995e<K, V> {
        public C1991a(C1993c<K, V> c1993c, C1993c<K, V> c1993c2) {
            super(c1993c, c1993c2);
        }

        @Override // p000.C1990n1.AbstractC1995e
        /* renamed from: b */
        public C1993c<K, V> mo582b(C1993c<K, V> c1993c) {
            return c1993c.f5515d;
        }

        @Override // p000.C1990n1.AbstractC1995e
        /* renamed from: c */
        public C1993c<K, V> mo581c(C1993c<K, V> c1993c) {
            return c1993c.f5514c;
        }
    }

    /* renamed from: n1$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1992b<K, V> extends AbstractC1995e<K, V> {
        public C1992b(C1993c<K, V> c1993c, C1993c<K, V> c1993c2) {
            super(c1993c, c1993c2);
        }

        @Override // p000.C1990n1.AbstractC1995e
        /* renamed from: b */
        public C1993c<K, V> mo582b(C1993c<K, V> c1993c) {
            return c1993c.f5514c;
        }

        @Override // p000.C1990n1.AbstractC1995e
        /* renamed from: c */
        public C1993c<K, V> mo581c(C1993c<K, V> c1993c) {
            return c1993c.f5515d;
        }
    }

    /* renamed from: n1$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1993c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        public final K f5512a;

        /* renamed from: b */
        public final V f5513b;

        /* renamed from: c */
        public C1993c<K, V> f5514c;

        /* renamed from: d */
        public C1993c<K, V> f5515d;

        public C1993c(K k, V v) {
            this.f5512a = k;
            this.f5513b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C1993c) {
                C1993c c1993c = (C1993c) obj;
                return this.f5512a.equals(c1993c.f5512a) && this.f5513b.equals(c1993c.f5513b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5512a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5513b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f5512a.hashCode() ^ this.f5513b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f5512a + "=" + this.f5513b;
        }
    }

    /* renamed from: n1$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1994d implements Iterator<Map.Entry<K, V>>, InterfaceC1996f<K, V> {

        /* renamed from: a */
        public C1993c<K, V> f5516a;

        /* renamed from: b */
        public boolean f5517b = true;

        public C1994d() {
        }

        @Override // p000.C1990n1.InterfaceC1996f
        /* renamed from: a */
        public void mo580a(C1993c<K, V> c1993c) {
            C1993c<K, V> c1993c2 = this.f5516a;
            if (c1993c == c1993c2) {
                C1993c<K, V> c1993c3 = c1993c2.f5515d;
                this.f5516a = c1993c3;
                this.f5517b = c1993c3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5517b) {
                return C1990n1.this.f5508a != null;
            }
            C1993c<K, V> c1993c = this.f5516a;
            return (c1993c == null || c1993c.f5514c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f5517b) {
                this.f5517b = false;
                this.f5516a = C1990n1.this.f5508a;
            } else {
                C1993c<K, V> c1993c = this.f5516a;
                this.f5516a = c1993c != null ? c1993c.f5514c : null;
            }
            return this.f5516a;
        }
    }

    /* renamed from: n1$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC1995e<K, V> implements Iterator<Map.Entry<K, V>>, InterfaceC1996f<K, V> {

        /* renamed from: a */
        public C1993c<K, V> f5519a;

        /* renamed from: b */
        public C1993c<K, V> f5520b;

        public AbstractC1995e(C1993c<K, V> c1993c, C1993c<K, V> c1993c2) {
            this.f5519a = c1993c2;
            this.f5520b = c1993c;
        }

        @Override // p000.C1990n1.InterfaceC1996f
        /* renamed from: a */
        public void mo580a(C1993c<K, V> c1993c) {
            C1993c<K, V> c1993c2 = null;
            if (this.f5519a == c1993c && c1993c == this.f5520b) {
                this.f5520b = null;
                this.f5519a = null;
            }
            C1993c<K, V> c1993c3 = this.f5519a;
            if (c1993c3 == c1993c) {
                this.f5519a = mo582b(c1993c3);
            }
            C1993c<K, V> c1993c4 = this.f5520b;
            if (c1993c4 == c1993c) {
                C1993c<K, V> c1993c5 = this.f5519a;
                if (c1993c4 != c1993c5 && c1993c5 != null) {
                    c1993c2 = mo581c(c1993c4);
                }
                this.f5520b = c1993c2;
            }
        }

        /* renamed from: b */
        public abstract C1993c<K, V> mo582b(C1993c<K, V> c1993c);

        /* renamed from: c */
        public abstract C1993c<K, V> mo581c(C1993c<K, V> c1993c);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5520b != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            C1993c<K, V> c1993c = this.f5520b;
            C1993c<K, V> c1993c2 = this.f5519a;
            this.f5520b = (c1993c == c1993c2 || c1993c2 == null) ? null : mo581c(c1993c);
            return c1993c;
        }
    }

    /* renamed from: n1$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1996f<K, V> {
        /* renamed from: a */
        void mo580a(C1993c<K, V> c1993c);
    }

    /* renamed from: a */
    public C1993c<K, V> mo587a(K k) {
        C1993c<K, V> c1993c = this.f5508a;
        while (c1993c != null && !c1993c.f5512a.equals(k)) {
            c1993c = c1993c.f5514c;
        }
        return c1993c;
    }

    /* renamed from: b */
    public C1990n1<K, V>.C1994d m586b() {
        C1990n1<K, V>.C1994d c1994d = new C1994d();
        this.f5510c.put(c1994d, Boolean.FALSE);
        return c1994d;
    }

    /* renamed from: c */
    public C1993c<K, V> m585c(K k, V v) {
        C1993c<K, V> c1993c = new C1993c<>(k, v);
        this.f5511d++;
        C1993c<K, V> c1993c2 = this.f5509b;
        if (c1993c2 == null) {
            this.f5508a = c1993c;
            this.f5509b = c1993c;
            return c1993c;
        }
        c1993c2.f5514c = c1993c;
        c1993c.f5515d = c1993c2;
        this.f5509b = c1993c;
        return c1993c;
    }

    /* renamed from: d */
    public V mo584d(K k, V v) {
        C1993c<K, V> mo587a = mo587a(k);
        if (mo587a != null) {
            return mo587a.f5513b;
        }
        m585c(k, v);
        return null;
    }

    /* renamed from: e */
    public V mo583e(K k) {
        C1993c<K, V> mo587a = mo587a(k);
        if (mo587a == null) {
            return null;
        }
        this.f5511d--;
        if (!this.f5510c.isEmpty()) {
            for (InterfaceC1996f<K, V> interfaceC1996f : this.f5510c.keySet()) {
                interfaceC1996f.mo580a(mo587a);
            }
        }
        C1993c<K, V> c1993c = mo587a.f5515d;
        if (c1993c != null) {
            c1993c.f5514c = mo587a.f5514c;
        } else {
            this.f5508a = mo587a.f5514c;
        }
        C1993c<K, V> c1993c2 = mo587a.f5514c;
        if (c1993c2 != null) {
            c1993c2.f5515d = c1993c;
        } else {
            this.f5509b = c1993c;
        }
        mo587a.f5514c = null;
        mo587a.f5515d = null;
        return mo587a.f5513b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((p000.C1990n1.AbstractC1995e) r7).hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof p000.C1990n1
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            n1 r7 = (p000.C1990n1) r7
            int r1 = r6.f5511d
            int r3 = r7.f5511d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            n1$e r3 = (p000.C1990n1.AbstractC1995e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            n1$e r4 = (p000.C1990n1.AbstractC1995e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            n1$e r7 = (p000.C1990n1.AbstractC1995e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = 0
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1990n1.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (true) {
            AbstractC1995e abstractC1995e = (AbstractC1995e) it;
            if (!abstractC1995e.hasNext()) {
                return i;
            }
            i += ((Map.Entry) abstractC1995e.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        C1991a c1991a = new C1991a(this.f5508a, this.f5509b);
        this.f5510c.put(c1991a, Boolean.FALSE);
        return c1991a;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            AbstractC1995e abstractC1995e = (AbstractC1995e) it;
            if (abstractC1995e.hasNext()) {
                m253r.append(((Map.Entry) abstractC1995e.next()).toString());
                if (abstractC1995e.hasNext()) {
                    m253r.append(", ");
                }
            } else {
                m253r.append("]");
                return m253r.toString();
            }
        }
    }
}
