package p000;

/* renamed from: pe */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2184pe implements InterfaceC0073Ce {
    private final InterfaceC0073Ce delegate;

    public AbstractC2184pe(InterfaceC0073Ce interfaceC0073Ce) {
        if (interfaceC0073Ce != null) {
            this.delegate = interfaceC0073Ce;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final InterfaceC0073Ce delegate() {
        return this.delegate;
    }

    @Override // p000.InterfaceC0073Ce
    public long read(C1946ke c1946ke, long j) {
        return this.delegate.read(c1946ke, j);
    }

    @Override // p000.InterfaceC0073Ce
    public C0097De timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
