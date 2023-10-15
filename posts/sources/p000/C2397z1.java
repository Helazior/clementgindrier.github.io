package p000;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p000.AbstractC0077D1;

/* renamed from: z1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2396z1<E> implements Collection<E>, Set<E> {

    /* renamed from: f */
    public static final int[] f6903f = new int[0];

    /* renamed from: g */
    public static final Object[] f6904g = new Object[0];

    /* renamed from: h */
    public static Object[] f6905h;

    /* renamed from: i */
    public static int f6906i;

    /* renamed from: j */
    public static Object[] f6907j;

    /* renamed from: k */
    public static int f6908k;

    /* renamed from: a */
    public int[] f6909a;

    /* renamed from: b */
    public Object[] f6910b;

    /* renamed from: c */
    public int f6911c;

    /* renamed from: d */
    public AbstractC0077D1<E, E> f6912d;

    public C2396z1() {
        this(0);
    }

    /* renamed from: b */
    public static void m11b(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C2396z1.class) {
                if (f6908k < 10) {
                    objArr[0] = f6907j;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f6907j = objArr;
                    f6908k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C2396z1.class) {
                if (f6906i < 10) {
                    objArr[0] = f6905h;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f6905h = objArr;
                    f6906i++;
                }
            }
        }
    }

    /* renamed from: a */
    public final void m12a(int i) {
        if (i == 8) {
            synchronized (C2396z1.class) {
                Object[] objArr = f6907j;
                if (objArr != null) {
                    this.f6910b = objArr;
                    f6907j = (Object[]) objArr[0];
                    this.f6909a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f6908k--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C2396z1.class) {
                Object[] objArr2 = f6905h;
                if (objArr2 != null) {
                    this.f6910b = objArr2;
                    f6905h = (Object[]) objArr2[0];
                    this.f6909a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f6906i--;
                    return;
                }
            }
        }
        this.f6909a = new int[i];
        this.f6910b = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int m10c;
        if (e == null) {
            m10c = m9d();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            m10c = m10c(e, hashCode);
        }
        if (m10c >= 0) {
            return false;
        }
        int i2 = ~m10c;
        int i3 = this.f6911c;
        int[] iArr = this.f6909a;
        if (i3 >= iArr.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            Object[] objArr = this.f6910b;
            m12a(i4);
            int[] iArr2 = this.f6909a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f6910b, 0, objArr.length);
            }
            m11b(iArr, objArr, this.f6911c);
        }
        int i5 = this.f6911c;
        if (i2 < i5) {
            int[] iArr3 = this.f6909a;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f6910b;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f6911c - i2);
        }
        this.f6909a[i2] = i;
        this.f6910b[i2] = e;
        this.f6911c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f6911c;
        int[] iArr = this.f6909a;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f6910b;
            m12a(size);
            int i = this.f6911c;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f6909a, 0, i);
                System.arraycopy(objArr, 0, this.f6910b, 0, this.f6911c);
            }
            m11b(iArr, objArr, this.f6911c);
        }
        for (E e : collection) {
            z |= add(e);
        }
        return z;
    }

    /* renamed from: c */
    public final int m10c(Object obj, int i) {
        int i2 = this.f6911c;
        if (i2 == 0) {
            return -1;
        }
        int m2597a = C0015A1.m2597a(this.f6909a, i2, i);
        if (m2597a >= 0 && !obj.equals(this.f6910b[m2597a])) {
            int i3 = m2597a + 1;
            while (i3 < i2 && this.f6909a[i3] == i) {
                if (obj.equals(this.f6910b[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = m2597a - 1; i4 >= 0 && this.f6909a[i4] == i; i4--) {
                if (obj.equals(this.f6910b[i4])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return m2597a;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.f6911c;
        if (i != 0) {
            m11b(this.f6909a, this.f6910b, i);
            this.f6909a = f6903f;
            this.f6910b = f6904g;
            this.f6911c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final int m9d() {
        int i = this.f6911c;
        if (i == 0) {
            return -1;
        }
        int m2597a = C0015A1.m2597a(this.f6909a, i, 0);
        if (m2597a >= 0 && this.f6910b[m2597a] != null) {
            int i2 = m2597a + 1;
            while (i2 < i && this.f6909a[i2] == 0) {
                if (this.f6910b[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = m2597a - 1; i3 >= 0 && this.f6909a[i3] == 0; i3--) {
                if (this.f6910b[i3] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return m2597a;
    }

    /* renamed from: e */
    public E m8e(int i) {
        Object[] objArr = this.f6910b;
        E e = (E) objArr[i];
        int i2 = this.f6911c;
        if (i2 <= 1) {
            m11b(this.f6909a, objArr, i2);
            this.f6909a = f6903f;
            this.f6910b = f6904g;
            this.f6911c = 0;
        } else {
            int[] iArr = this.f6909a;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                m12a(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.f6911c--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f6909a, 0, i);
                    System.arraycopy(objArr, 0, this.f6910b, 0, i);
                }
                int i3 = this.f6911c;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.f6909a, i, i3 - i);
                    System.arraycopy(objArr, i4, this.f6910b, i, this.f6911c - i);
                }
            } else {
                int i5 = i2 - 1;
                this.f6911c = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.f6910b;
                    System.arraycopy(objArr2, i6, objArr2, i, this.f6911c - i);
                }
                this.f6910b[this.f6911c] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f6911c != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f6911c; i++) {
                try {
                    if (!set.contains(this.f6910b[i])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f6909a;
        int i = this.f6911c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? m9d() : m10c(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f6911c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        if (this.f6912d == null) {
            this.f6912d = new C2362y1(this);
        }
        AbstractC0077D1<E, E> abstractC0077D1 = this.f6912d;
        if (abstractC0077D1.f319b == null) {
            abstractC0077D1.f319b = new AbstractC0077D1.C0080c();
        }
        return abstractC0077D1.f319b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            m8e(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f6911c - 1; i >= 0; i--) {
            if (!collection.contains(this.f6910b[i])) {
                m8e(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f6911c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.f6911c;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f6910b, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6911c * 14);
        sb.append('{');
        for (int i = 0; i < this.f6911c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.f6910b[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C2396z1(int i) {
        if (i == 0) {
            this.f6909a = f6903f;
            this.f6910b = f6904g;
        } else {
            m12a(i);
        }
        this.f6911c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f6911c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f6911c));
        }
        System.arraycopy(this.f6910b, 0, tArr, 0, this.f6911c);
        int length = tArr.length;
        int i = this.f6911c;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }
}
