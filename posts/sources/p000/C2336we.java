package p000;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: we */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2335we implements InterfaceC1966le {

    /* renamed from: a */
    public final C1946ke f6794a = new C1946ke();

    /* renamed from: b */
    public final InterfaceC0050Be f6795b;

    /* renamed from: c */
    public boolean f6796c;

    public C2335we(InterfaceC0050Be interfaceC0050Be) {
        Objects.requireNonNull(interfaceC0050Be, "sink == null");
        this.f6795b = interfaceC0050Be;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: a */
    public C1946ke mo91a() {
        return this.f6794a;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: b */
    public InterfaceC1966le mo148b(byte[] bArr, int i, int i2) {
        if (!this.f6796c) {
            this.f6794a.m661T(bArr, i, i2);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: c */
    public long mo147c(InterfaceC0073Ce interfaceC0073Ce) {
        long j = 0;
        while (true) {
            long read = interfaceC0073Ce.read(this.f6794a, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            mo139t();
        }
    }

    @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f6796c) {
            return;
        }
        Throwable th = null;
        try {
            C1946ke c1946ke = this.f6794a;
            long j = c1946ke.f5398b;
            if (j > 0) {
                this.f6795b.write(c1946ke, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f6795b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f6796c = true;
        if (th == null) {
            return;
        }
        Charset charset = C0123Ee.f428a;
        throw th;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: d */
    public InterfaceC1966le mo146d(long j) {
        if (!this.f6796c) {
            this.f6794a.mo146d(j);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: f */
    public InterfaceC1966le mo145f() {
        if (!this.f6796c) {
            C1946ke c1946ke = this.f6794a;
            long j = c1946ke.f5398b;
            if (j > 0) {
                this.f6795b.write(c1946ke, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le, p000.InterfaceC0050Be, java.io.Flushable
    public void flush() {
        if (!this.f6796c) {
            C1946ke c1946ke = this.f6794a;
            long j = c1946ke.f5398b;
            if (j > 0) {
                this.f6795b.write(c1946ke, j);
            }
            this.f6795b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: g */
    public InterfaceC1966le mo144g(int i) {
        if (!this.f6796c) {
            this.f6794a.m655Z(i);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: i */
    public InterfaceC1966le mo143i(int i) {
        if (!this.f6796c) {
            this.f6794a.m657X(i);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f6796c;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: n */
    public InterfaceC1966le mo142n(int i) {
        if (!this.f6796c) {
            this.f6794a.m660U(i);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: p */
    public InterfaceC1966le mo141p(byte[] bArr) {
        if (!this.f6796c) {
            this.f6794a.m662S(bArr);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: q */
    public InterfaceC1966le mo140q(C2011ne c2011ne) {
        if (!this.f6796c) {
            this.f6794a.m663R(c2011ne);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: t */
    public InterfaceC1966le mo139t() {
        if (!this.f6796c) {
            long m674G = this.f6794a.m674G();
            if (m674G > 0) {
                this.f6795b.write(this.f6794a, m674G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC0050Be
    public C0097De timeout() {
        return this.f6795b.timeout();
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("buffer(");
        m253r.append(this.f6795b);
        m253r.append(")");
        return m253r.toString();
    }

    @Override // p000.InterfaceC0050Be
    public void write(C1946ke c1946ke, long j) {
        if (!this.f6796c) {
            this.f6794a.write(c1946ke, j);
            mo139t();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: x */
    public InterfaceC1966le mo138x(String str) {
        if (!this.f6796c) {
            this.f6794a.m653b0(str);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: y */
    public InterfaceC1966le mo137y(long j) {
        if (!this.f6796c) {
            this.f6794a.mo137y(j);
            mo139t();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!this.f6796c) {
            int write = this.f6794a.write(byteBuffer);
            mo139t();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
