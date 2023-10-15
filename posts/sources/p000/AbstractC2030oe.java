package p000;

/* renamed from: oe */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2030oe implements InterfaceC0050Be {
    private final InterfaceC0050Be delegate;

    public AbstractC2030oe(InterfaceC0050Be interfaceC0050Be) {
        if (interfaceC0050Be != null) {
            this.delegate = interfaceC0050Be;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final InterfaceC0050Be delegate() {
        return this.delegate;
    }

    @Override // p000.InterfaceC0050Be, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // p000.InterfaceC0050Be
    public C0097De timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    @Override // p000.InterfaceC0050Be
    public void write(C1946ke c1946ke, long j) {
        this.delegate.write(c1946ke, j);
    }
}
