package p000;

/* renamed from: B1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0034B1<E> implements Cloneable {

    /* renamed from: f */
    public static final Object f169f = new Object();

    /* renamed from: a */
    public boolean f170a = false;

    /* renamed from: b */
    public long[] f171b;

    /* renamed from: c */
    public Object[] f172c;

    /* renamed from: d */
    public int f173d;

    public C0034B1() {
        int m2592f = C0015A1.m2592f(10);
        this.f171b = new long[m2592f];
        this.f172c = new Object[m2592f];
    }

    /* renamed from: a */
    public void m2570a(long j, E e) {
        int i = this.f173d;
        if (i != 0 && j <= this.f171b[i - 1]) {
            m2564g(j, e);
            return;
        }
        if (this.f170a && i >= this.f171b.length) {
            m2567d();
        }
        int i2 = this.f173d;
        if (i2 >= this.f171b.length) {
            int m2592f = C0015A1.m2592f(i2 + 1);
            long[] jArr = new long[m2592f];
            Object[] objArr = new Object[m2592f];
            long[] jArr2 = this.f171b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f172c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f171b = jArr;
            this.f172c = objArr;
        }
        this.f171b[i2] = j;
        this.f172c[i2] = e;
        this.f173d = i2 + 1;
    }

    /* renamed from: b */
    public void m2569b() {
        int i = this.f173d;
        Object[] objArr = this.f172c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f173d = 0;
        this.f170a = false;
    }

    /* renamed from: c */
    public C0034B1<E> clone() {
        try {
            C0034B1<E> c0034b1 = (C0034B1) super.clone();
            c0034b1.f171b = (long[]) this.f171b.clone();
            c0034b1.f172c = (Object[]) this.f172c.clone();
            return c0034b1;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    public final void m2567d() {
        int i = this.f173d;
        long[] jArr = this.f171b;
        Object[] objArr = this.f172c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f169f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f170a = false;
        this.f173d = i2;
    }

    /* renamed from: e */
    public E m2566e(long j) {
        return m2565f(j, null);
    }

    /* renamed from: f */
    public E m2565f(long j, E e) {
        int m2596b = C0015A1.m2596b(this.f171b, this.f173d, j);
        if (m2596b >= 0) {
            Object[] objArr = this.f172c;
            if (objArr[m2596b] != f169f) {
                return (E) objArr[m2596b];
            }
        }
        return e;
    }

    /* renamed from: g */
    public void m2564g(long j, E e) {
        int m2596b = C0015A1.m2596b(this.f171b, this.f173d, j);
        if (m2596b >= 0) {
            this.f172c[m2596b] = e;
            return;
        }
        int i = ~m2596b;
        int i2 = this.f173d;
        if (i < i2) {
            Object[] objArr = this.f172c;
            if (objArr[i] == f169f) {
                this.f171b[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f170a && i2 >= this.f171b.length) {
            m2567d();
            i = ~C0015A1.m2596b(this.f171b, this.f173d, j);
        }
        int i3 = this.f173d;
        if (i3 >= this.f171b.length) {
            int m2592f = C0015A1.m2592f(i3 + 1);
            long[] jArr = new long[m2592f];
            Object[] objArr2 = new Object[m2592f];
            long[] jArr2 = this.f171b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f172c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f171b = jArr;
            this.f172c = objArr2;
        }
        int i4 = this.f173d;
        if (i4 - i != 0) {
            long[] jArr3 = this.f171b;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.f172c;
            System.arraycopy(objArr4, i, objArr4, i5, this.f173d - i);
        }
        this.f171b[i] = j;
        this.f172c[i] = e;
        this.f173d++;
    }

    /* renamed from: h */
    public int m2563h() {
        if (this.f170a) {
            m2567d();
        }
        return this.f173d;
    }

    /* renamed from: i */
    public E m2562i(int i) {
        if (this.f170a) {
            m2567d();
        }
        return (E) this.f172c[i];
    }

    public String toString() {
        if (m2563h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f173d * 28);
        sb.append('{');
        for (int i = 0; i < this.f173d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f170a) {
                m2567d();
            }
            sb.append(this.f171b[i]);
            sb.append('=');
            E m2562i = m2562i(i);
            if (m2562i != this) {
                sb.append(m2562i);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
