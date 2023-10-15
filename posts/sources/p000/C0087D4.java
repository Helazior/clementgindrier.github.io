package p000;

/* renamed from: D4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0087D4<T> extends C0056C4<T> {

    /* renamed from: c */
    public final Object f348c;

    public C0087D4(int i) {
        super(i);
        this.f348c = new Object();
    }

    @Override // p000.C0056C4, p000.InterfaceC0037B4
    public T acquire() {
        T t;
        synchronized (this.f348c) {
            t = (T) super.acquire();
        }
        return t;
    }

    @Override // p000.C0056C4, p000.InterfaceC0037B4
    public boolean release(T t) {
        boolean release;
        synchronized (this.f348c) {
            release = super.release(t);
        }
        return release;
    }
}
