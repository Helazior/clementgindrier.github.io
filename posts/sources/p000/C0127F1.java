package p000;

/* renamed from: F1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0127F1<E> implements Cloneable {

    /* renamed from: f */
    public static final Object f432f = new Object();

    /* renamed from: a */
    public boolean f433a;

    /* renamed from: b */
    public int[] f434b;

    /* renamed from: c */
    public Object[] f435c;

    /* renamed from: d */
    public int f436d;

    public C0127F1() {
        this(10);
    }

    /* renamed from: a */
    public void m2456a(int i, E e) {
        int i2 = this.f436d;
        if (i2 != 0 && i <= this.f434b[i2 - 1]) {
            m2450g(i, e);
            return;
        }
        if (this.f433a && i2 >= this.f434b.length) {
            m2454c();
        }
        int i3 = this.f436d;
        if (i3 >= this.f434b.length) {
            int m2593e = C0015A1.m2593e(i3 + 1);
            int[] iArr = new int[m2593e];
            Object[] objArr = new Object[m2593e];
            int[] iArr2 = this.f434b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f435c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f434b = iArr;
            this.f435c = objArr;
        }
        this.f434b[i3] = i;
        this.f435c[i3] = e;
        this.f436d = i3 + 1;
    }

    /* renamed from: b */
    public C0127F1<E> clone() {
        try {
            C0127F1<E> c0127f1 = (C0127F1) super.clone();
            c0127f1.f434b = (int[]) this.f434b.clone();
            c0127f1.f435c = (Object[]) this.f435c.clone();
            return c0127f1;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: c */
    public final void m2454c() {
        int i = this.f436d;
        int[] iArr = this.f434b;
        Object[] objArr = this.f435c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f432f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f433a = false;
        this.f436d = i2;
    }

    /* renamed from: d */
    public E m2453d(int i) {
        return m2452e(i, null);
    }

    /* renamed from: e */
    public E m2452e(int i, E e) {
        int m2597a = C0015A1.m2597a(this.f434b, this.f436d, i);
        if (m2597a >= 0) {
            Object[] objArr = this.f435c;
            if (objArr[m2597a] != f432f) {
                return (E) objArr[m2597a];
            }
        }
        return e;
    }

    /* renamed from: f */
    public int m2451f(int i) {
        if (this.f433a) {
            m2454c();
        }
        return this.f434b[i];
    }

    /* renamed from: g */
    public void m2450g(int i, E e) {
        int m2597a = C0015A1.m2597a(this.f434b, this.f436d, i);
        if (m2597a >= 0) {
            this.f435c[m2597a] = e;
            return;
        }
        int i2 = ~m2597a;
        int i3 = this.f436d;
        if (i2 < i3) {
            Object[] objArr = this.f435c;
            if (objArr[i2] == f432f) {
                this.f434b[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f433a && i3 >= this.f434b.length) {
            m2454c();
            i2 = ~C0015A1.m2597a(this.f434b, this.f436d, i);
        }
        int i4 = this.f436d;
        if (i4 >= this.f434b.length) {
            int m2593e = C0015A1.m2593e(i4 + 1);
            int[] iArr = new int[m2593e];
            Object[] objArr2 = new Object[m2593e];
            int[] iArr2 = this.f434b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f435c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f434b = iArr;
            this.f435c = objArr2;
        }
        int i5 = this.f436d;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f434b;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.f435c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f436d - i2);
        }
        this.f434b[i2] = i;
        this.f435c[i2] = e;
        this.f436d++;
    }

    /* renamed from: h */
    public void m2449h(int i) {
        int m2597a = C0015A1.m2597a(this.f434b, this.f436d, i);
        if (m2597a >= 0) {
            Object[] objArr = this.f435c;
            Object obj = objArr[m2597a];
            Object obj2 = f432f;
            if (obj != obj2) {
                objArr[m2597a] = obj2;
                this.f433a = true;
            }
        }
    }

    /* renamed from: i */
    public int m2448i() {
        if (this.f433a) {
            m2454c();
        }
        return this.f436d;
    }

    /* renamed from: j */
    public E m2447j(int i) {
        if (this.f433a) {
            m2454c();
        }
        return (E) this.f435c[i];
    }

    public String toString() {
        if (m2448i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f436d * 28);
        sb.append('{');
        for (int i = 0; i < this.f436d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m2451f(i));
            sb.append('=');
            E m2447j = m2447j(i);
            if (m2447j != this) {
                sb.append(m2447j);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0127F1(int i) {
        this.f433a = false;
        if (i == 0) {
            this.f434b = C0015A1.f111a;
            this.f435c = C0015A1.f113c;
            return;
        }
        int m2593e = C0015A1.m2593e(i);
        this.f434b = new int[m2593e];
        this.f435c = new Object[m2593e];
    }
}
