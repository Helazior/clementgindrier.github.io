package p000;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: xe */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2358xe implements InterfaceC1987me {

    /* renamed from: a */
    public final C1946ke f6847a = new C1946ke();

    /* renamed from: b */
    public final InterfaceC0073Ce f6848b;

    /* renamed from: c */
    public boolean f6849c;

    public C2358xe(InterfaceC0073Ce interfaceC0073Ce) {
        Objects.requireNonNull(interfaceC0073Ce, "source == null");
        this.f6848b = interfaceC0073Ce;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: A */
    public boolean mo96A(long j, C2011ne c2011ne) {
        int mo550m = c2011ne.mo550m();
        if (!this.f6849c) {
            if (j < 0 || mo550m < 0 || c2011ne.mo550m() - 0 < mo550m) {
                return false;
            }
            for (int i = 0; i < mo550m; i++) {
                long j2 = i + j;
                if (!mo89h(1 + j2) || this.f6847a.m672I(j2) != c2011ne.mo556g(0 + i)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // p000.InterfaceC1987me
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo95B() {
        /*
            r6 = this;
            r0 = 1
            r6.mo79w(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.mo89h(r3)
            if (r3 == 0) goto L4a
            ke r3 = r6.f6847a
            long r4 = (long) r1
            byte r3 = r3.m672I(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            ke r0 = r6.f6847a
            long r0 = r0.mo95B()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2358xe.mo95B():long");
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: C */
    public String mo94C(Charset charset) {
        if (charset != null) {
            this.f6847a.mo147c(this.f6848b);
            C1946ke c1946ke = this.f6847a;
            Objects.requireNonNull(c1946ke);
            try {
                return c1946ke.m667N(c1946ke.f5398b, charset);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: D */
    public InputStream mo93D() {
        return new C2359a();
    }

    /* renamed from: E */
    public long m92E(byte b, long j, long j2) {
        if (this.f6849c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long m671J = this.f6847a.m671J(b, j, j2);
            if (m671J == -1) {
                C1946ke c1946ke = this.f6847a;
                long j3 = c1946ke.f5398b;
                if (j3 >= j2 || this.f6848b.read(c1946ke, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return m671J;
            }
        }
        return -1L;
    }

    @Override // p000.InterfaceC1987me, p000.InterfaceC1966le
    /* renamed from: a */
    public C1946ke mo91a() {
        return this.f6847a;
    }

    @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f6849c) {
            return;
        }
        this.f6849c = true;
        this.f6848b.close();
        this.f6847a.m676E();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: e */
    public C2011ne mo90e(long j) {
        if (mo89h(j)) {
            return this.f6847a.mo90e(j);
        }
        throw new EOFException();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: h */
    public boolean mo89h(long j) {
        C1946ke c1946ke;
        if (j >= 0) {
            if (!this.f6849c) {
                do {
                    c1946ke = this.f6847a;
                    if (c1946ke.f5398b >= j) {
                        return true;
                    }
                } while (this.f6848b.read(c1946ke, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f6849c;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: j */
    public String mo88j() {
        return mo80v(RecyclerView.FOREVER_NS);
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: k */
    public byte[] mo87k() {
        this.f6847a.mo147c(this.f6848b);
        return this.f6847a.mo87k();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: l */
    public int mo86l() {
        mo79w(4L);
        return this.f6847a.mo86l();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: m */
    public boolean mo85m() {
        if (this.f6849c) {
            throw new IllegalStateException("closed");
        }
        return this.f6847a.mo85m() && this.f6848b.read(this.f6847a, 8192L) == -1;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: o */
    public byte[] mo84o(long j) {
        if (mo89h(j)) {
            return this.f6847a.mo84o(j);
        }
        throw new EOFException();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: r */
    public void mo83r(C1946ke c1946ke, long j) {
        try {
            if (mo89h(j)) {
                C1946ke c1946ke2 = this.f6847a;
                long j2 = c1946ke2.f5398b;
                if (j2 >= j) {
                    c1946ke.write(c1946ke2, j);
                    return;
                } else {
                    c1946ke.write(c1946ke2, j2);
                    throw new EOFException();
                }
            }
            throw new EOFException();
        } catch (EOFException e) {
            c1946ke.mo147c(this.f6847a);
            throw e;
        }
    }

    @Override // p000.InterfaceC0073Ce
    public long read(C1946ke c1946ke, long j) {
        if (c1946ke != null) {
            if (j >= 0) {
                if (!this.f6849c) {
                    C1946ke c1946ke2 = this.f6847a;
                    if (c1946ke2.f5398b == 0 && this.f6848b.read(c1946ke2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f6847a.read(c1946ke, Math.min(j, this.f6847a.f5398b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // p000.InterfaceC1987me
    public byte readByte() {
        mo79w(1L);
        return this.f6847a.readByte();
    }

    @Override // p000.InterfaceC1987me
    public void readFully(byte[] bArr) {
        try {
            mo79w(bArr.length);
            this.f6847a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                C1946ke c1946ke = this.f6847a;
                long j = c1946ke.f5398b;
                if (j > 0) {
                    int m670K = c1946ke.m670K(bArr, i, (int) j);
                    if (m670K == -1) {
                        throw new AssertionError();
                    }
                    i += m670K;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // p000.InterfaceC1987me
    public int readInt() {
        mo79w(4L);
        return this.f6847a.readInt();
    }

    @Override // p000.InterfaceC1987me
    public long readLong() {
        mo79w(8L);
        return this.f6847a.readLong();
    }

    @Override // p000.InterfaceC1987me
    public short readShort() {
        mo79w(2L);
        return this.f6847a.readShort();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: s */
    public short mo82s() {
        mo79w(2L);
        return this.f6847a.mo82s();
    }

    @Override // p000.InterfaceC1987me
    public void skip(long j) {
        if (this.f6849c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            C1946ke c1946ke = this.f6847a;
            if (c1946ke.f5398b == 0 && this.f6848b.read(c1946ke, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f6847a.f5398b);
            this.f6847a.skip(min);
            j -= min;
        }
    }

    @Override // p000.InterfaceC0073Ce
    public C0097De timeout() {
        return this.f6848b.timeout();
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("buffer(");
        m253r.append(this.f6848b);
        m253r.append(")");
        return m253r.toString();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: u */
    public long mo81u() {
        byte m672I;
        mo79w(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo89h(i2)) {
                break;
            }
            m672I = this.f6847a.m672I(i);
            if ((m672I < 48 || m672I > 57) && !(i == 0 && m672I == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(m672I)));
        }
        return this.f6847a.mo81u();
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: v */
    public String mo80v(long j) {
        if (j >= 0) {
            long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
            long m92E = m92E((byte) 10, 0L, j2);
            if (m92E != -1) {
                return this.f6847a.m665P(m92E);
            }
            if (j2 < RecyclerView.FOREVER_NS && mo89h(j2) && this.f6847a.m672I(j2 - 1) == 13 && mo89h(1 + j2) && this.f6847a.m672I(j2) == 10) {
                return this.f6847a.m665P(j2);
            }
            C1946ke c1946ke = new C1946ke();
            C1946ke c1946ke2 = this.f6847a;
            c1946ke2.m673H(c1946ke, 0L, Math.min(32L, c1946ke2.f5398b));
            StringBuilder m253r = outline.m253r("\\n not found: limit=");
            m253r.append(Math.min(this.f6847a.f5398b, j));
            m253r.append(" content=");
            m253r.append(c1946ke.m668M().mo555h());
            m253r.append((char) 8230);
            throw new EOFException(m253r.toString());
        }
        throw new IllegalArgumentException(outline.m272I("limit < 0: ", j));
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: w */
    public void mo79w(long j) {
        if (!mo89h(j)) {
            throw new EOFException();
        }
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: z */
    public long mo78z(byte b) {
        return m92E(b, 0L, RecyclerView.FOREVER_NS);
    }

    /* renamed from: xe$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2359a extends InputStream {
        public C2359a() {
        }

        @Override // java.io.InputStream
        public int available() {
            C2358xe c2358xe = C2358xe.this;
            if (!c2358xe.f6849c) {
                return (int) Math.min(c2358xe.f6847a.f5398b, 2147483647L);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            C2358xe.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            C2358xe c2358xe = C2358xe.this;
            if (!c2358xe.f6849c) {
                C1946ke c1946ke = c2358xe.f6847a;
                if (c1946ke.f5398b == 0 && c2358xe.f6848b.read(c1946ke, 8192L) == -1) {
                    return -1;
                }
                return C2358xe.this.f6847a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return C2358xe.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!C2358xe.this.f6849c) {
                C0123Ee.m2457b(bArr.length, i, i2);
                C2358xe c2358xe = C2358xe.this;
                C1946ke c1946ke = c2358xe.f6847a;
                if (c1946ke.f5398b == 0 && c2358xe.f6848b.read(c1946ke, 8192L) == -1) {
                    return -1;
                }
                return C2358xe.this.f6847a.m670K(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        C1946ke c1946ke = this.f6847a;
        if (c1946ke.f5398b == 0 && this.f6848b.read(c1946ke, 8192L) == -1) {
            return -1;
        }
        return this.f6847a.read(byteBuffer);
    }
}
