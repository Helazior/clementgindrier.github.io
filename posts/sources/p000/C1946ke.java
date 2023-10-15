package p000;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: ke */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1946ke implements InterfaceC1987me, InterfaceC1966le, Cloneable, ByteChannel {

    /* renamed from: c */
    public static final byte[] f5396c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable

    /* renamed from: a */
    public C2393ye f5397a;

    /* renamed from: b */
    public long f5398b;

    /* renamed from: ke$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1947a extends InputStream {
        public C1947a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C1946ke.this.f5398b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            C1946ke c1946ke = C1946ke.this;
            if (c1946ke.f5398b > 0) {
                return c1946ke.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C1946ke.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return C1946ke.this.m670K(bArr, i, i2);
        }
    }

    /* renamed from: ke$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1948b implements Closeable {

        /* renamed from: a */
        public C1946ke f5400a;

        /* renamed from: b */
        public boolean f5401b;

        /* renamed from: c */
        public C2393ye f5402c;

        /* renamed from: f */
        public byte[] f5404f;

        /* renamed from: d */
        public long f5403d = -1;

        /* renamed from: g */
        public int f5405g = -1;

        /* renamed from: h */
        public int f5406h = -1;

        /* renamed from: E */
        public int m650E(long j) {
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i >= 0) {
                C1946ke c1946ke = this.f5400a;
                long j2 = c1946ke.f5398b;
                if (j <= j2) {
                    if (i != 0 && j != j2) {
                        long j3 = 0;
                        C2393ye c2393ye = c1946ke.f5397a;
                        C2393ye c2393ye2 = this.f5402c;
                        if (c2393ye2 != null) {
                            long j4 = this.f5403d - (this.f5405g - c2393ye2.f6889b);
                            if (j4 > j) {
                                j2 = j4;
                                c2393ye2 = c2393ye;
                                c2393ye = c2393ye2;
                            } else {
                                j3 = j4;
                            }
                        } else {
                            c2393ye2 = c2393ye;
                        }
                        if (j2 - j > j - j3) {
                            while (true) {
                                int i2 = c2393ye2.f6890c;
                                int i3 = c2393ye2.f6889b;
                                if (j < (i2 - i3) + j3) {
                                    break;
                                }
                                j3 += i2 - i3;
                                c2393ye2 = c2393ye2.f6893f;
                            }
                        } else {
                            while (j2 > j) {
                                c2393ye = c2393ye.f6894g;
                                j2 -= c2393ye.f6890c - c2393ye.f6889b;
                            }
                            c2393ye2 = c2393ye;
                            j3 = j2;
                        }
                        if (this.f5401b && c2393ye2.f6891d) {
                            C2393ye c2393ye3 = new C2393ye((byte[]) c2393ye2.f6888a.clone(), c2393ye2.f6889b, c2393ye2.f6890c, false, true);
                            C1946ke c1946ke2 = this.f5400a;
                            if (c1946ke2.f5397a == c2393ye2) {
                                c1946ke2.f5397a = c2393ye3;
                            }
                            c2393ye2.m48b(c2393ye3);
                            c2393ye3.f6894g.m49a();
                            c2393ye2 = c2393ye3;
                        }
                        this.f5402c = c2393ye2;
                        this.f5403d = j;
                        this.f5404f = c2393ye2.f6888a;
                        int i4 = c2393ye2.f6889b + ((int) (j - j3));
                        this.f5405g = i4;
                        int i5 = c2393ye2.f6890c;
                        this.f5406h = i5;
                        return i5 - i4;
                    }
                    this.f5402c = null;
                    this.f5403d = j;
                    this.f5404f = null;
                    this.f5405g = -1;
                    this.f5406h = -1;
                    return -1;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.f5400a.f5398b)));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5400a != null) {
                this.f5400a = null;
                this.f5402c = null;
                this.f5403d = -1L;
                this.f5404f = null;
                this.f5405g = -1;
                this.f5406h = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: A */
    public boolean mo96A(long j, C2011ne c2011ne) {
        int mo550m = c2011ne.mo550m();
        if (j < 0 || mo550m < 0 || this.f5398b - j < mo550m || c2011ne.mo550m() - 0 < mo550m) {
            return false;
        }
        for (int i = 0; i < mo550m; i++) {
            if (m672I(i + j) != c2011ne.mo556g(0 + i)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b A[EDGE_INSN: B:42:0x009b->B:38:0x009b ?: BREAK  , SYNTHETIC] */
    @Override // p000.InterfaceC1987me
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo95B() {
        /*
            r15 = this;
            long r0 = r15.f5398b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La2
            r0 = 0
            r1 = 0
            r4 = r2
        Lb:
            ye r6 = r15.f5397a
            byte[] r7 = r6.f6888a
            int r8 = r6.f6889b
            int r9 = r6.f6890c
        L13:
            if (r8 >= r9) goto L87
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L39
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-97)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6c
            r11 = 70
            if (r10 > r11) goto L6c
            int r11 = r10 + (-65)
        L37:
            int r11 = r11 + 10
        L39:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L49
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L49:
            ke r0 = new ke
            r0.<init>()
            ke r0 = r0.mo146d(r4)
            r0.m660U(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = p000.outline.m253r(r2)
            java.lang.String r0 = r0.m666O()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L6c:
            if (r0 == 0) goto L70
            r1 = 1
            goto L87
        L70:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r1 = p000.outline.m253r(r1)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L87:
            if (r8 != r9) goto L93
            ye r7 = r6.m49a()
            r15.f5397a = r7
            p000.C2410ze.m1a(r6)
            goto L95
        L93:
            r6.f6889b = r8
        L95:
            if (r1 != 0) goto L9b
            ye r6 = r15.f5397a
            if (r6 != 0) goto Lb
        L9b:
            long r1 = r15.f5398b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f5398b = r1
            return r4
        La2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1946ke.mo95B():long");
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: C */
    public String mo94C(Charset charset) {
        try {
            return m667N(this.f5398b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: D */
    public InputStream mo93D() {
        return new C1947a();
    }

    /* renamed from: E */
    public void m676E() {
        try {
            skip(this.f5398b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: F */
    public C1946ke clone() {
        C1946ke c1946ke = new C1946ke();
        if (this.f5398b == 0) {
            return c1946ke;
        }
        C2393ye m47c = this.f5397a.m47c();
        c1946ke.f5397a = m47c;
        m47c.f6894g = m47c;
        m47c.f6893f = m47c;
        C2393ye c2393ye = this.f5397a;
        while (true) {
            c2393ye = c2393ye.f6893f;
            if (c2393ye != this.f5397a) {
                c1946ke.f5397a.f6894g.m48b(c2393ye.m47c());
            } else {
                c1946ke.f5398b = this.f5398b;
                return c1946ke;
            }
        }
    }

    /* renamed from: G */
    public long m674G() {
        long j = this.f5398b;
        if (j == 0) {
            return 0L;
        }
        C2393ye c2393ye = this.f5397a.f6894g;
        int i = c2393ye.f6890c;
        return (i >= 8192 || !c2393ye.f6892e) ? j : j - (i - c2393ye.f6889b);
    }

    /* renamed from: H */
    public C1946ke m673H(C1946ke c1946ke, long j, long j2) {
        if (c1946ke != null) {
            C0123Ee.m2457b(this.f5398b, j, j2);
            if (j2 == 0) {
                return this;
            }
            c1946ke.f5398b += j2;
            C2393ye c2393ye = this.f5397a;
            while (true) {
                int i = c2393ye.f6890c;
                int i2 = c2393ye.f6889b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                c2393ye = c2393ye.f6893f;
            }
            while (j2 > 0) {
                C2393ye m47c = c2393ye.m47c();
                int i3 = (int) (m47c.f6889b + j);
                m47c.f6889b = i3;
                m47c.f6890c = Math.min(i3 + ((int) j2), m47c.f6890c);
                C2393ye c2393ye2 = c1946ke.f5397a;
                if (c2393ye2 == null) {
                    m47c.f6894g = m47c;
                    m47c.f6893f = m47c;
                    c1946ke.f5397a = m47c;
                } else {
                    c2393ye2.f6894g.m48b(m47c);
                }
                j2 -= m47c.f6890c - m47c.f6889b;
                c2393ye = c2393ye.f6893f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: I */
    public byte m672I(long j) {
        int i;
        C0123Ee.m2457b(this.f5398b, j, 1L);
        long j2 = this.f5398b;
        if (j2 - j > j) {
            C2393ye c2393ye = this.f5397a;
            while (true) {
                int i2 = c2393ye.f6890c;
                int i3 = c2393ye.f6889b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return c2393ye.f6888a[i3 + ((int) j)];
                }
                j -= j3;
                c2393ye = c2393ye.f6893f;
            }
        } else {
            long j4 = j - j2;
            C2393ye c2393ye2 = this.f5397a;
            do {
                c2393ye2 = c2393ye2.f6894g;
                int i4 = c2393ye2.f6890c;
                i = c2393ye2.f6889b;
                j4 += i4 - i;
            } while (j4 < 0);
            return c2393ye2.f6888a[i + ((int) j4)];
        }
    }

    /* renamed from: J */
    public long m671J(byte b, long j, long j2) {
        C2393ye c2393ye;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f5398b;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (c2393ye = this.f5397a) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    c2393ye = c2393ye.f6894g;
                    j4 -= c2393ye.f6890c - c2393ye.f6889b;
                }
            } else {
                while (true) {
                    long j6 = (c2393ye.f6890c - c2393ye.f6889b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    c2393ye = c2393ye.f6893f;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = c2393ye.f6888a;
                int min = (int) Math.min(c2393ye.f6890c, (c2393ye.f6889b + j5) - j4);
                for (int i = (int) ((c2393ye.f6889b + j7) - j4); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - c2393ye.f6889b) + j4;
                    }
                }
                j4 += c2393ye.f6890c - c2393ye.f6889b;
                c2393ye = c2393ye.f6893f;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f5398b), Long.valueOf(j), Long.valueOf(j2)));
    }

    /* renamed from: K */
    public int m670K(byte[] bArr, int i, int i2) {
        C0123Ee.m2457b(bArr.length, i, i2);
        C2393ye c2393ye = this.f5397a;
        if (c2393ye == null) {
            return -1;
        }
        int min = Math.min(i2, c2393ye.f6890c - c2393ye.f6889b);
        System.arraycopy(c2393ye.f6888a, c2393ye.f6889b, bArr, i, min);
        int i3 = c2393ye.f6889b + min;
        c2393ye.f6889b = i3;
        this.f5398b -= min;
        if (i3 == c2393ye.f6890c) {
            this.f5397a = c2393ye.m49a();
            C2410ze.m1a(c2393ye);
        }
        return min;
    }

    /* renamed from: L */
    public C1948b m669L(C1948b c1948b) {
        if (c1948b.f5400a == null) {
            c1948b.f5400a = this;
            c1948b.f5401b = true;
            return c1948b;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    /* renamed from: M */
    public C2011ne m668M() {
        return new C2011ne(mo87k());
    }

    /* renamed from: N */
    public String m667N(long j, Charset charset) {
        C0123Ee.m2457b(this.f5398b, 0L, j);
        if (charset != null) {
            if (j <= 2147483647L) {
                if (j == 0) {
                    return "";
                }
                C2393ye c2393ye = this.f5397a;
                if (c2393ye.f6889b + j > c2393ye.f6890c) {
                    return new String(mo84o(j), charset);
                }
                String str = new String(c2393ye.f6888a, c2393ye.f6889b, (int) j, charset);
                int i = (int) (c2393ye.f6889b + j);
                c2393ye.f6889b = i;
                this.f5398b -= j;
                if (i == c2393ye.f6890c) {
                    this.f5397a = c2393ye.m49a();
                    C2410ze.m1a(c2393ye);
                }
                return str;
            }
            throw new IllegalArgumentException(outline.m272I("byteCount > Integer.MAX_VALUE: ", j));
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: O */
    public String m666O() {
        try {
            return m667N(this.f5398b, C0123Ee.f428a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: P */
    public String m665P(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (m672I(j2) == 13) {
                String m667N = m667N(j2, C0123Ee.f428a);
                skip(2L);
                return m667N;
            }
        }
        String m667N2 = m667N(j, C0123Ee.f428a);
        skip(1L);
        return m667N2;
    }

    /* renamed from: Q */
    public C2393ye m664Q(int i) {
        if (i >= 1 && i <= 8192) {
            C2393ye c2393ye = this.f5397a;
            if (c2393ye == null) {
                C2393ye m0b = C2410ze.m0b();
                this.f5397a = m0b;
                m0b.f6894g = m0b;
                m0b.f6893f = m0b;
                return m0b;
            }
            C2393ye c2393ye2 = c2393ye.f6894g;
            if (c2393ye2.f6890c + i > 8192 || !c2393ye2.f6892e) {
                C2393ye m0b2 = C2410ze.m0b();
                c2393ye2.m48b(m0b2);
                return m0b2;
            }
            return c2393ye2;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: R */
    public C1946ke m663R(C2011ne c2011ne) {
        if (c2011ne != null) {
            c2011ne.mo545r(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: S */
    public C1946ke m662S(byte[] bArr) {
        if (bArr != null) {
            m661T(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: T */
    public C1946ke m661T(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            C0123Ee.m2457b(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C2393ye m664Q = m664Q(1);
                int min = Math.min(i3 - i, 8192 - m664Q.f6890c);
                System.arraycopy(bArr, i, m664Q.f6888a, m664Q.f6890c, min);
                i += min;
                m664Q.f6890c += min;
            }
            this.f5398b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: U */
    public C1946ke m660U(int i) {
        C2393ye m664Q = m664Q(1);
        byte[] bArr = m664Q.f6888a;
        int i2 = m664Q.f6890c;
        m664Q.f6890c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5398b++;
        return this;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: V */
    public C1946ke mo137y(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            m660U(48);
            return this;
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                m653b0("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        C2393ye m664Q = m664Q(i2);
        byte[] bArr = m664Q.f6888a;
        int i3 = m664Q.f6890c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f5396c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        m664Q.f6890c += i2;
        this.f5398b += i2;
        return this;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: W */
    public C1946ke mo146d(long j) {
        if (j == 0) {
            m660U(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C2393ye m664Q = m664Q(numberOfTrailingZeros);
        byte[] bArr = m664Q.f6888a;
        int i = m664Q.f6890c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f5396c[(int) (15 & j)];
            j >>>= 4;
        }
        m664Q.f6890c += numberOfTrailingZeros;
        this.f5398b += numberOfTrailingZeros;
        return this;
    }

    /* renamed from: X */
    public C1946ke m657X(int i) {
        C2393ye m664Q = m664Q(4);
        byte[] bArr = m664Q.f6888a;
        int i2 = m664Q.f6890c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        m664Q.f6890c = i5 + 1;
        this.f5398b += 4;
        return this;
    }

    /* renamed from: Y */
    public C1946ke m656Y(long j) {
        C2393ye m664Q = m664Q(8);
        byte[] bArr = m664Q.f6888a;
        int i = m664Q.f6890c;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        m664Q.f6890c = i8 + 1;
        this.f5398b += 8;
        return this;
    }

    /* renamed from: Z */
    public C1946ke m655Z(int i) {
        C2393ye m664Q = m664Q(2);
        byte[] bArr = m664Q.f6888a;
        int i2 = m664Q.f6890c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        m664Q.f6890c = i3 + 1;
        this.f5398b += 2;
        return this;
    }

    @Override // p000.InterfaceC1987me, p000.InterfaceC1966le
    /* renamed from: a */
    public C1946ke mo91a() {
        return this;
    }

    /* renamed from: a0 */
    public C1946ke m654a0(String str, int i, int i2, Charset charset) {
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                } else if (charset != null) {
                    if (charset.equals(C0123Ee.f428a)) {
                        m652c0(str, i, i2);
                        return this;
                    }
                    byte[] bytes = str.substring(i, i2).getBytes(charset);
                    m661T(bytes, 0, bytes.length);
                    return this;
                } else {
                    throw new IllegalArgumentException("charset == null");
                }
            }
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        throw new IllegalAccessError(outline.m273H("beginIndex < 0: ", i));
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: b */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo148b(byte[] bArr, int i, int i2) {
        m661T(bArr, i, i2);
        return this;
    }

    /* renamed from: b0 */
    public C1946ke m653b0(String str) {
        m652c0(str, 0, str.length());
        return this;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: c */
    public long mo147c(InterfaceC0073Ce interfaceC0073Ce) {
        if (interfaceC0073Ce == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = interfaceC0073Ce.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    /* renamed from: c0 */
    public C1946ke m652c0(String str, int i, int i2) {
        char charAt;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                while (i < i2) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 128) {
                        C2393ye m664Q = m664Q(1);
                        byte[] bArr = m664Q.f6888a;
                        int i3 = m664Q.f6890c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt2;
                        while (true) {
                            i = i4;
                            if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                break;
                            }
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                        int i5 = m664Q.f6890c;
                        int i6 = (i3 + i) - i5;
                        m664Q.f6890c = i5 + i6;
                        this.f5398b += i6;
                    } else {
                        if (charAt2 < 2048) {
                            m660U((charAt2 >> 6) | 192);
                            m660U((charAt2 & '?') | 128);
                        } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                            int i7 = i + 1;
                            char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                            if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                                m660U((i8 >> 18) | 240);
                                m660U(((i8 >> 12) & 63) | 128);
                                m660U(((i8 >> 6) & 63) | 128);
                                m660U((i8 & 63) | 128);
                                i += 2;
                            } else {
                                m660U(63);
                                i = i7;
                            }
                        } else {
                            m660U((charAt2 >> '\f') | 224);
                            m660U(((charAt2 >> 6) & 63) | 128);
                            m660U((charAt2 & '?') | 128);
                        }
                        i++;
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        throw new IllegalArgumentException(outline.m273H("beginIndex < 0: ", i));
    }

    @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d0 */
    public C1946ke m651d0(int i) {
        if (i < 128) {
            m660U(i);
        } else if (i < 2048) {
            m660U((i >> 6) | 192);
            m660U((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                m660U(63);
            } else {
                m660U((i >> 12) | 224);
                m660U(((i >> 6) & 63) | 128);
                m660U((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            m660U((i >> 18) | 240);
            m660U(((i >> 12) & 63) | 128);
            m660U(((i >> 6) & 63) | 128);
            m660U((i & 63) | 128);
        } else {
            StringBuilder m253r = outline.m253r("Unexpected code point: ");
            m253r.append(Integer.toHexString(i));
            throw new IllegalArgumentException(m253r.toString());
        }
        return this;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: e */
    public C2011ne mo90e(long j) {
        return new C2011ne(mo84o(j));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1946ke) {
            C1946ke c1946ke = (C1946ke) obj;
            long j = this.f5398b;
            if (j != c1946ke.f5398b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            C2393ye c2393ye = this.f5397a;
            C2393ye c2393ye2 = c1946ke.f5397a;
            int i = c2393ye.f6889b;
            int i2 = c2393ye2.f6889b;
            while (j2 < this.f5398b) {
                long min = Math.min(c2393ye.f6890c - i, c2393ye2.f6890c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (c2393ye.f6888a[i] != c2393ye2.f6888a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == c2393ye.f6890c) {
                    c2393ye = c2393ye.f6893f;
                    i = c2393ye.f6889b;
                }
                if (i2 == c2393ye2.f6890c) {
                    c2393ye2 = c2393ye2.f6893f;
                    i2 = c2393ye2.f6889b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: f */
    public InterfaceC1966le mo145f() {
        return this;
    }

    @Override // p000.InterfaceC1966le, p000.InterfaceC0050Be, java.io.Flushable
    public void flush() {
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: g */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo144g(int i) {
        m655Z(i);
        return this;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: h */
    public boolean mo89h(long j) {
        return this.f5398b >= j;
    }

    public int hashCode() {
        C2393ye c2393ye = this.f5397a;
        if (c2393ye == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c2393ye.f6890c;
            for (int i3 = c2393ye.f6889b; i3 < i2; i3++) {
                i = (i * 31) + c2393ye.f6888a[i3];
            }
            c2393ye = c2393ye.f6893f;
        } while (c2393ye != this.f5397a);
        return i;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: i */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo143i(int i) {
        m657X(i);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: j */
    public String mo88j() {
        return mo80v(RecyclerView.FOREVER_NS);
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: k */
    public byte[] mo87k() {
        try {
            return mo84o(this.f5398b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: l */
    public int mo86l() {
        int readInt = readInt();
        Charset charset = C0123Ee.f428a;
        return ((readInt & 255) << 24) | (((-16777216) & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: m */
    public boolean mo85m() {
        return this.f5398b == 0;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: n */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo142n(int i) {
        m660U(i);
        return this;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: o */
    public byte[] mo84o(long j) {
        C0123Ee.m2457b(this.f5398b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException(outline.m272I("byteCount > Integer.MAX_VALUE: ", j));
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: p */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo141p(byte[] bArr) {
        m662S(bArr);
        return this;
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: q */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo140q(C2011ne c2011ne) {
        m663R(c2011ne);
        return this;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: r */
    public void mo83r(C1946ke c1946ke, long j) {
        long j2 = this.f5398b;
        if (j2 >= j) {
            c1946ke.write(this, j);
        } else {
            c1946ke.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        C2393ye c2393ye = this.f5397a;
        if (c2393ye == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), c2393ye.f6890c - c2393ye.f6889b);
        byteBuffer.put(c2393ye.f6888a, c2393ye.f6889b, min);
        int i = c2393ye.f6889b + min;
        c2393ye.f6889b = i;
        this.f5398b -= min;
        if (i == c2393ye.f6890c) {
            this.f5397a = c2393ye.m49a();
            C2410ze.m1a(c2393ye);
        }
        return min;
    }

    @Override // p000.InterfaceC1987me
    public byte readByte() {
        long j = this.f5398b;
        if (j != 0) {
            C2393ye c2393ye = this.f5397a;
            int i = c2393ye.f6889b;
            int i2 = c2393ye.f6890c;
            int i3 = i + 1;
            byte b = c2393ye.f6888a[i];
            this.f5398b = j - 1;
            if (i3 == i2) {
                this.f5397a = c2393ye.m49a();
                C2410ze.m1a(c2393ye);
            } else {
                c2393ye.f6889b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // p000.InterfaceC1987me
    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int m670K = m670K(bArr, i, bArr.length - i);
            if (m670K == -1) {
                throw new EOFException();
            }
            i += m670K;
        }
    }

    @Override // p000.InterfaceC1987me
    public int readInt() {
        long j = this.f5398b;
        if (j >= 4) {
            C2393ye c2393ye = this.f5397a;
            int i = c2393ye.f6889b;
            int i2 = c2393ye.f6890c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = c2393ye.f6888a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.f5398b = j - 4;
            if (i8 == i2) {
                this.f5397a = c2393ye.m49a();
                C2410ze.m1a(c2393ye);
            } else {
                c2393ye.f6889b = i8;
            }
            return i9;
        }
        StringBuilder m253r = outline.m253r("size < 4: ");
        m253r.append(this.f5398b);
        throw new IllegalStateException(m253r.toString());
    }

    @Override // p000.InterfaceC1987me
    public long readLong() {
        long j = this.f5398b;
        if (j >= 8) {
            C2393ye c2393ye = this.f5397a;
            int i = c2393ye.f6889b;
            int i2 = c2393ye.f6890c;
            if (i2 - i < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = c2393ye.f6888a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (bArr[i3] & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j3 = (bArr[i9] & 255) | j2 | ((bArr[i] & 255) << 56) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8);
            this.f5398b = j - 8;
            if (i10 == i2) {
                this.f5397a = c2393ye.m49a();
                C2410ze.m1a(c2393ye);
            } else {
                c2393ye.f6889b = i10;
            }
            return j3;
        }
        StringBuilder m253r = outline.m253r("size < 8: ");
        m253r.append(this.f5398b);
        throw new IllegalStateException(m253r.toString());
    }

    @Override // p000.InterfaceC1987me
    public short readShort() {
        long j = this.f5398b;
        if (j >= 2) {
            C2393ye c2393ye = this.f5397a;
            int i = c2393ye.f6889b;
            int i2 = c2393ye.f6890c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = c2393ye.f6888a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f5398b = j - 2;
            if (i4 == i2) {
                this.f5397a = c2393ye.m49a();
                C2410ze.m1a(c2393ye);
            } else {
                c2393ye.f6889b = i4;
            }
            return (short) i5;
        }
        StringBuilder m253r = outline.m253r("size < 2: ");
        m253r.append(this.f5398b);
        throw new IllegalStateException(m253r.toString());
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: s */
    public short mo82s() {
        short readShort = readShort();
        Charset charset = C0123Ee.f428a;
        int i = readShort & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    @Override // p000.InterfaceC1987me
    public void skip(long j) {
        C2393ye c2393ye;
        while (j > 0) {
            if (this.f5397a != null) {
                int min = (int) Math.min(j, c2393ye.f6890c - c2393ye.f6889b);
                long j2 = min;
                this.f5398b -= j2;
                j -= j2;
                C2393ye c2393ye2 = this.f5397a;
                int i = c2393ye2.f6889b + min;
                c2393ye2.f6889b = i;
                if (i == c2393ye2.f6890c) {
                    this.f5397a = c2393ye2.m49a();
                    C2410ze.m1a(c2393ye2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: t */
    public InterfaceC1966le mo139t() {
        return this;
    }

    @Override // p000.InterfaceC0073Ce
    public C0097De timeout() {
        return C0097De.NONE;
    }

    public String toString() {
        C2011ne c0030Ae;
        long j = this.f5398b;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                c0030Ae = C2011ne.f5561f;
            } else {
                c0030Ae = new C0030Ae(this, i);
            }
            return c0030Ae.toString();
        }
        StringBuilder m253r = outline.m253r("size > Integer.MAX_VALUE: ");
        m253r.append(this.f5398b);
        throw new IllegalArgumentException(m253r.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        r1 = new p000.C1946ke().m659V(r3);
        r1.m660U(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r8 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        r3 = p000.outline.m253r("Number too large: ");
        r3.append(r1.m666O());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        r17.f5398b -= r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b7, code lost:
        if (r8 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bb, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    @Override // p000.InterfaceC1987me
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo81u() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f5398b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lbc
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L14:
            ye r10 = r0.f5397a
            byte[] r11 = r10.f6888a
            int r12 = r10.f6889b
            int r13 = r10.f6890c
        L1c:
            if (r12 >= r13) goto L95
            r14 = r11[r12]
            r15 = 48
            if (r14 < r15) goto L65
            r15 = 57
            if (r14 > r15) goto L65
            int r15 = 48 - r14
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3d
            if (r16 != 0) goto L36
            long r1 = (long) r15
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L36
            goto L3d
        L36:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r15
            long r3 = r3 + r1
            goto L6f
        L3d:
            ke r1 = new ke
            r1.<init>()
            ke r1 = r1.mo137y(r3)
            r1.m660U(r14)
            if (r8 != 0) goto L4e
            r1.readByte()
        L4e:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = "Number too large: "
            java.lang.StringBuilder r3 = p000.outline.m253r(r3)
            java.lang.String r1 = r1.m666O()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L65:
            r1 = 45
            if (r14 != r1) goto L79
            if (r7 != 0) goto L79
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L6f:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L1c
        L79:
            if (r7 == 0) goto L7e
            r1 = 1
            r9 = 1
            goto L95
        L7e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r2 = p000.outline.m253r(r2)
            java.lang.String r3 = java.lang.Integer.toHexString(r14)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L95:
            if (r12 != r13) goto La1
            ye r1 = r10.m49a()
            r0.f5397a = r1
            p000.C2410ze.m1a(r10)
            goto La3
        La1:
            r10.f6889b = r12
        La3:
            if (r9 != 0) goto Lb1
            ye r1 = r0.f5397a
            if (r1 != 0) goto Laa
            goto Lb1
        Laa:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L14
        Lb1:
            long r1 = r0.f5398b
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.f5398b = r1
            if (r8 == 0) goto Lba
            goto Lbb
        Lba:
            long r3 = -r3
        Lbb:
            return r3
        Lbc:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1946ke.mo81u():long");
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: v */
    public String mo80v(long j) {
        if (j >= 0) {
            long j2 = RecyclerView.FOREVER_NS;
            if (j != RecyclerView.FOREVER_NS) {
                j2 = j + 1;
            }
            long m671J = m671J((byte) 10, 0L, j2);
            if (m671J != -1) {
                return m665P(m671J);
            }
            if (j2 < this.f5398b && m672I(j2 - 1) == 13 && m672I(j2) == 10) {
                return m665P(j2);
            }
            C1946ke c1946ke = new C1946ke();
            m673H(c1946ke, 0L, Math.min(32L, this.f5398b));
            StringBuilder m253r = outline.m253r("\\n not found: limit=");
            m253r.append(Math.min(this.f5398b, j));
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
        if (this.f5398b < j) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                C2393ye m664Q = m664Q(1);
                int min = Math.min(i, 8192 - m664Q.f6890c);
                byteBuffer.get(m664Q.f6888a, m664Q.f6890c, min);
                i -= min;
                m664Q.f6890c += min;
            }
            this.f5398b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // p000.InterfaceC1966le
    /* renamed from: x */
    public /* bridge */ /* synthetic */ InterfaceC1966le mo138x(String str) {
        m653b0(str);
        return this;
    }

    @Override // p000.InterfaceC1987me
    /* renamed from: z */
    public long mo78z(byte b) {
        return m671J(b, 0L, RecyclerView.FOREVER_NS);
    }

    @Override // p000.InterfaceC0050Be
    public void write(C1946ke c1946ke, long j) {
        C2393ye m0b;
        if (c1946ke == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (c1946ke != this) {
            C0123Ee.m2457b(c1946ke.f5398b, 0L, j);
            while (j > 0) {
                C2393ye c2393ye = c1946ke.f5397a;
                if (j < c2393ye.f6890c - c2393ye.f6889b) {
                    C2393ye c2393ye2 = this.f5397a;
                    C2393ye c2393ye3 = c2393ye2 != null ? c2393ye2.f6894g : null;
                    if (c2393ye3 != null && c2393ye3.f6892e) {
                        if ((c2393ye3.f6890c + j) - (c2393ye3.f6891d ? 0 : c2393ye3.f6889b) <= 8192) {
                            c2393ye.m46d(c2393ye3, (int) j);
                            c1946ke.f5398b -= j;
                            this.f5398b += j;
                            return;
                        }
                    }
                    int i = (int) j;
                    Objects.requireNonNull(c2393ye);
                    if (i > 0 && i <= c2393ye.f6890c - c2393ye.f6889b) {
                        if (i >= 1024) {
                            m0b = c2393ye.m47c();
                        } else {
                            m0b = C2410ze.m0b();
                            System.arraycopy(c2393ye.f6888a, c2393ye.f6889b, m0b.f6888a, 0, i);
                        }
                        m0b.f6890c = m0b.f6889b + i;
                        c2393ye.f6889b += i;
                        c2393ye.f6894g.m48b(m0b);
                        c1946ke.f5397a = m0b;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                C2393ye c2393ye4 = c1946ke.f5397a;
                long j2 = c2393ye4.f6890c - c2393ye4.f6889b;
                c1946ke.f5397a = c2393ye4.m49a();
                C2393ye c2393ye5 = this.f5397a;
                if (c2393ye5 == null) {
                    this.f5397a = c2393ye4;
                    c2393ye4.f6894g = c2393ye4;
                    c2393ye4.f6893f = c2393ye4;
                } else {
                    c2393ye5.f6894g.m48b(c2393ye4);
                    C2393ye c2393ye6 = c2393ye4.f6894g;
                    if (c2393ye6 != c2393ye4) {
                        if (c2393ye6.f6892e) {
                            int i2 = c2393ye4.f6890c - c2393ye4.f6889b;
                            if (i2 <= (8192 - c2393ye6.f6890c) + (c2393ye6.f6891d ? 0 : c2393ye6.f6889b)) {
                                c2393ye4.m46d(c2393ye6, i2);
                                c2393ye4.m49a();
                                C2410ze.m1a(c2393ye4);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
                c1946ke.f5398b -= j2;
                this.f5398b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // p000.InterfaceC0073Ce
    public long read(C1946ke c1946ke, long j) {
        if (c1946ke != null) {
            if (j >= 0) {
                long j2 = this.f5398b;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                c1946ke.write(this, j);
                return j;
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }
        throw new IllegalArgumentException("sink == null");
    }
}
