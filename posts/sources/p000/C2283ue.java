package p000;

/* renamed from: ue */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2283ue implements InterfaceC0050Be {
    @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // p000.InterfaceC0050Be, java.io.Flushable
    public void flush() {
    }

    @Override // p000.InterfaceC0050Be
    public C0097De timeout() {
        return C0097De.NONE;
    }

    @Override // p000.InterfaceC0050Be
    public void write(C1946ke c1946ke, long j) {
        c1946ke.skip(j);
    }
}
