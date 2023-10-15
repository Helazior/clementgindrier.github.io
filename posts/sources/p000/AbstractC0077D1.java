package p000;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: D1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0077D1<K, V> {

    /* renamed from: a */
    public AbstractC0077D1<K, V>.C0079b f318a;

    /* renamed from: b */
    public AbstractC0077D1<K, V>.C0080c f319b;

    /* renamed from: c */
    public AbstractC0077D1<K, V>.C0082e f320c;

    /* renamed from: D1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0078a<T> implements Iterator<T> {

        /* renamed from: a */
        public final int f321a;

        /* renamed from: b */
        public int f322b;

        /* renamed from: c */
        public int f323c;

        /* renamed from: d */
        public boolean f324d = false;

        public C0078a(int i) {
            this.f321a = i;
            this.f322b = AbstractC0077D1.this.mo74d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f323c < this.f322b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) AbstractC0077D1.this.mo76b(this.f323c, this.f321a);
                this.f323c++;
                this.f324d = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f324d) {
                int i = this.f323c - 1;
                this.f323c = i;
                this.f322b--;
                this.f324d = false;
                AbstractC0077D1.this.mo70h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: D1$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0079b implements Set<Map.Entry<K, V>> {
        public C0079b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int mo74d = AbstractC0077D1.this.mo74d();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC0077D1.this.mo71g(entry.getKey(), entry.getValue());
            }
            return mo74d != AbstractC0077D1.this.mo74d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0077D1.this.mo77a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int mo73e = AbstractC0077D1.this.mo73e(entry.getKey());
                if (mo73e < 0) {
                    return false;
                }
                return C0015A1.m2595c(AbstractC0077D1.this.mo76b(mo73e, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0077D1.m2490k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int mo74d = AbstractC0077D1.this.mo74d() - 1; mo74d >= 0; mo74d--) {
                Object mo76b = AbstractC0077D1.this.mo76b(mo74d, 0);
                Object mo76b2 = AbstractC0077D1.this.mo76b(mo74d, 1);
                i += (mo76b == null ? 0 : mo76b.hashCode()) ^ (mo76b2 == null ? 0 : mo76b2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0077D1.this.mo74d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0081d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0077D1.this.mo74d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: D1$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0080c implements Set<K> {
        public C0080c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0077D1.this.mo77a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0077D1.this.mo73e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return AbstractC0077D1.m2491j(AbstractC0077D1.this.mo75c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0077D1.m2490k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int mo74d = AbstractC0077D1.this.mo74d() - 1; mo74d >= 0; mo74d--) {
                Object mo76b = AbstractC0077D1.this.mo76b(mo74d, 0);
                i += mo76b == null ? 0 : mo76b.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0077D1.this.mo74d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new C0078a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int mo73e = AbstractC0077D1.this.mo73e(obj);
            if (mo73e >= 0) {
                AbstractC0077D1.this.mo70h(mo73e);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return AbstractC0077D1.m2489l(AbstractC0077D1.this.mo75c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return AbstractC0077D1.m2488m(AbstractC0077D1.this.mo75c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0077D1.this.mo74d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0077D1.this.m2487n(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0077D1.this.m2486o(tArr, 0);
        }
    }

    /* renamed from: D1$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0081d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        public int f328a;

        /* renamed from: c */
        public boolean f330c = false;

        /* renamed from: b */
        public int f329b = -1;

        public C0081d() {
            this.f328a = AbstractC0077D1.this.mo74d() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f330c) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return C0015A1.m2595c(entry.getKey(), AbstractC0077D1.this.mo76b(this.f329b, 0)) && C0015A1.m2595c(entry.getValue(), AbstractC0077D1.this.mo76b(this.f329b, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f330c) {
                return (K) AbstractC0077D1.this.mo76b(this.f329b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f330c) {
                return (V) AbstractC0077D1.this.mo76b(this.f329b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f329b < this.f328a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f330c) {
                Object mo76b = AbstractC0077D1.this.mo76b(this.f329b, 0);
                Object mo76b2 = AbstractC0077D1.this.mo76b(this.f329b, 1);
                return (mo76b == null ? 0 : mo76b.hashCode()) ^ (mo76b2 != null ? mo76b2.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                this.f329b++;
                this.f330c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f330c) {
                AbstractC0077D1.this.mo70h(this.f329b);
                this.f329b--;
                this.f328a--;
                this.f330c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f330c) {
                return (V) AbstractC0077D1.this.mo69i(this.f329b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: D1$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0082e implements Collection<V> {
        public C0082e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0077D1.this.mo77a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0077D1.this.mo72f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0077D1.this.mo74d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new C0078a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int mo72f = AbstractC0077D1.this.mo72f(obj);
            if (mo72f >= 0) {
                AbstractC0077D1.this.mo70h(mo72f);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int mo74d = AbstractC0077D1.this.mo74d();
            int i = 0;
            boolean z = false;
            while (i < mo74d) {
                if (collection.contains(AbstractC0077D1.this.mo76b(i, 1))) {
                    AbstractC0077D1.this.mo70h(i);
                    i--;
                    mo74d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int mo74d = AbstractC0077D1.this.mo74d();
            int i = 0;
            boolean z = false;
            while (i < mo74d) {
                if (!collection.contains(AbstractC0077D1.this.mo76b(i, 1))) {
                    AbstractC0077D1.this.mo70h(i);
                    i--;
                    mo74d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0077D1.this.mo74d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0077D1.this.m2487n(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0077D1.this.m2486o(tArr, 1);
        }
    }

    /* renamed from: j */
    public static <K, V> boolean m2491j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static <T> boolean m2490k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: l */
    public static <K, V> boolean m2489l(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: m */
    public static <K, V> boolean m2488m(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: a */
    public abstract void mo77a();

    /* renamed from: b */
    public abstract Object mo76b(int i, int i2);

    /* renamed from: c */
    public abstract Map<K, V> mo75c();

    /* renamed from: d */
    public abstract int mo74d();

    /* renamed from: e */
    public abstract int mo73e(Object obj);

    /* renamed from: f */
    public abstract int mo72f(Object obj);

    /* renamed from: g */
    public abstract void mo71g(K k, V v);

    /* renamed from: h */
    public abstract void mo70h(int i);

    /* renamed from: i */
    public abstract V mo69i(int i, V v);

    /* renamed from: n */
    public Object[] m2487n(int i) {
        int mo74d = mo74d();
        Object[] objArr = new Object[mo74d];
        for (int i2 = 0; i2 < mo74d; i2++) {
            objArr[i2] = mo76b(i2, i);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o */
    public <T> T[] m2486o(T[] tArr, int i) {
        int mo74d = mo74d();
        if (tArr.length < mo74d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), mo74d));
        }
        for (int i2 = 0; i2 < mo74d; i2++) {
            tArr[i2] = mo76b(i2, i);
        }
        if (tArr.length > mo74d) {
            tArr[mo74d] = null;
        }
        return tArr;
    }
}
