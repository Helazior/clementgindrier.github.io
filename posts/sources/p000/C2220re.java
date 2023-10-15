package p000;

import java.io.EOFException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: re */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2220re implements InterfaceC0073Ce {

    /* renamed from: b */
    public final InterfaceC1987me f6361b;

    /* renamed from: c */
    public final Inflater f6362c;

    /* renamed from: d */
    public final C2242se f6363d;

    /* renamed from: a */
    public int f6360a = 0;

    /* renamed from: f */
    public final CRC32 f6364f = new CRC32();

    public C2220re(InterfaceC0073Ce interfaceC0073Ce) {
        if (interfaceC0073Ce != null) {
            Inflater inflater = new Inflater(true);
            this.f6362c = inflater;
            Logger logger = C2263te.f6595a;
            C2358xe c2358xe = new C2358xe(interfaceC0073Ce);
            this.f6361b = c2358xe;
            this.f6363d = new C2242se(c2358xe, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: E */
    public final void m417E(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    /* renamed from: F */
    public final void m416F(C1946ke c1946ke, long j, long j2) {
        int i;
        C2393ye c2393ye = c1946ke.f5397a;
        while (true) {
            int i2 = c2393ye.f6890c;
            int i3 = c2393ye.f6889b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            c2393ye = c2393ye.f6893f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(c2393ye.f6890c - i, j2);
            this.f6364f.update(c2393ye.f6888a, (int) (c2393ye.f6889b + j), min);
            j2 -= min;
            c2393ye = c2393ye.f6893f;
            j = 0;
        }
    }

    @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6363d.close();
    }

    @Override // p000.InterfaceC0073Ce
    public long read(C1946ke c1946ke, long j) {
        long j2;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return 0L;
            }
            if (this.f6360a == 0) {
                this.f6361b.mo79w(10L);
                byte m672I = this.f6361b.mo91a().m672I(3L);
                boolean z = ((m672I >> 1) & 1) == 1;
                if (z) {
                    m416F(this.f6361b.mo91a(), 0L, 10L);
                }
                m417E("ID1ID2", 8075, this.f6361b.readShort());
                this.f6361b.skip(8L);
                if (((m672I >> 2) & 1) == 1) {
                    this.f6361b.mo79w(2L);
                    if (z) {
                        m416F(this.f6361b.mo91a(), 0L, 2L);
                    }
                    long mo82s = this.f6361b.mo91a().mo82s();
                    this.f6361b.mo79w(mo82s);
                    if (z) {
                        j2 = mo82s;
                        m416F(this.f6361b.mo91a(), 0L, mo82s);
                    } else {
                        j2 = mo82s;
                    }
                    this.f6361b.skip(j2);
                }
                if (((m672I >> 3) & 1) == 1) {
                    long mo78z = this.f6361b.mo78z((byte) 0);
                    if (mo78z != -1) {
                        if (z) {
                            m416F(this.f6361b.mo91a(), 0L, mo78z + 1);
                        }
                        this.f6361b.skip(mo78z + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((m672I >> 4) & 1) == 1) {
                    long mo78z2 = this.f6361b.mo78z((byte) 0);
                    if (mo78z2 != -1) {
                        if (z) {
                            m416F(this.f6361b.mo91a(), 0L, mo78z2 + 1);
                        }
                        this.f6361b.skip(mo78z2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    m417E("FHCRC", this.f6361b.mo82s(), (short) this.f6364f.getValue());
                    this.f6364f.reset();
                }
                this.f6360a = 1;
            }
            if (this.f6360a == 1) {
                long j3 = c1946ke.f5398b;
                long read = this.f6363d.read(c1946ke, j);
                if (read != -1) {
                    m416F(c1946ke, j3, read);
                    return read;
                }
                this.f6360a = 2;
            }
            if (this.f6360a == 2) {
                m417E("CRC", this.f6361b.mo86l(), (int) this.f6364f.getValue());
                m417E("ISIZE", this.f6361b.mo86l(), (int) this.f6362c.getBytesWritten());
                this.f6360a = 3;
                if (!this.f6361b.mo85m()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
    }

    @Override // p000.InterfaceC0073Ce
    public C0097De timeout() {
        return this.f6361b.timeout();
    }
}
