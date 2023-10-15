package p000;

import java.io.Closeable;
import java.io.Flushable;

/* renamed from: Be */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface InterfaceC0050Be extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.io.Flushable
    void flush();

    C0097De timeout();

    void write(C1946ke c1946ke, long j);
}
