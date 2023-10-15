package p000;

/* renamed from: C4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0056C4<T> implements InterfaceC0037B4<T> {

    /* renamed from: a */
    public final Object[] f228a;

    /* renamed from: b */
    public int f229b;

    public C0056C4(int i) {
        if (i > 0) {
            this.f228a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // p000.InterfaceC0037B4
    public T acquire() {
        int i = this.f229b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f228a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f229b = i - 1;
            return t;
        }
        return null;
    }

    @Override // p000.InterfaceC0037B4
    public boolean release(T t) {
        int i;
        boolean z;
        int i2 = 0;
        while (true) {
            i = this.f229b;
            if (i2 >= i) {
                z = false;
                break;
            } else if (this.f228a[i2] == t) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            Object[] objArr = this.f228a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.f229b = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
