package p000;

/* renamed from: n2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1997n2<T> {

    /* renamed from: a */
    public final Object[] f5521a;

    /* renamed from: b */
    public int f5522b;

    public C1997n2(int i) {
        if (i > 0) {
            this.f5521a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    /* renamed from: a */
    public T m579a() {
        int i = this.f5522b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f5521a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f5522b = i - 1;
            return t;
        }
        return null;
    }

    /* renamed from: b */
    public boolean m578b(T t) {
        int i = this.f5522b;
        Object[] objArr = this.f5521a;
        if (i < objArr.length) {
            objArr[i] = t;
            this.f5522b = i + 1;
            return true;
        }
        return false;
    }
}
