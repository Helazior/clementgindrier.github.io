package p000;

import java.util.zip.Inflater;

/* renamed from: se */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2242se implements InterfaceC0073Ce {

    /* renamed from: a */
    public final InterfaceC1987me f6419a;

    /* renamed from: b */
    public final Inflater f6420b;

    /* renamed from: c */
    public int f6421c;

    /* renamed from: d */
    public boolean f6422d;

    public C2242se(InterfaceC1987me interfaceC1987me, Inflater inflater) {
        this.f6419a = interfaceC1987me;
        this.f6420b = inflater;
    }

    /* renamed from: E */
    public final void m395E() {
        int i = this.f6421c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f6420b.getRemaining();
        this.f6421c -= remaining;
        this.f6419a.skip(remaining);
    }

    @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f6422d) {
            return;
        }
        this.f6420b.end();
        this.f6422d = true;
        this.f6419a.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        m395E();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
        if (r0.f6889b != r0.f6890c) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
        r7.f5397a = r0.m49a();
        p000.C2410ze.m1a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        return -1;
     */
    @Override // p000.InterfaceC0073Ce
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(p000.C1946ke r7, long r8) {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto Lb1
            boolean r3 = r6.f6422d
            if (r3 != 0) goto La9
            if (r2 != 0) goto Ld
            return r0
        Ld:
            java.util.zip.Inflater r0 = r6.f6420b
            boolean r0 = r0.needsInput()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L18
            goto L43
        L18:
            r6.m395E()
            java.util.zip.Inflater r0 = r6.f6420b
            int r0 = r0.getRemaining()
            if (r0 != 0) goto La1
            me r0 = r6.f6419a
            boolean r0 = r0.mo85m()
            if (r0 == 0) goto L2d
            r1 = 1
            goto L43
        L2d:
            me r0 = r6.f6419a
            ke r0 = r0.mo91a()
            ye r0 = r0.f5397a
            int r3 = r0.f6890c
            int r4 = r0.f6889b
            int r3 = r3 - r4
            r6.f6421c = r3
            java.util.zip.Inflater r5 = r6.f6420b
            byte[] r0 = r0.f6888a
            r5.setInput(r0, r4, r3)
        L43:
            ye r0 = r7.m664Q(r2)     // Catch: java.util.zip.DataFormatException -> L9a
            int r2 = r0.f6890c     // Catch: java.util.zip.DataFormatException -> L9a
            int r2 = 8192 - r2
            long r2 = (long) r2     // Catch: java.util.zip.DataFormatException -> L9a
            long r2 = java.lang.Math.min(r8, r2)     // Catch: java.util.zip.DataFormatException -> L9a
            int r3 = (int) r2     // Catch: java.util.zip.DataFormatException -> L9a
            java.util.zip.Inflater r2 = r6.f6420b     // Catch: java.util.zip.DataFormatException -> L9a
            byte[] r4 = r0.f6888a     // Catch: java.util.zip.DataFormatException -> L9a
            int r5 = r0.f6890c     // Catch: java.util.zip.DataFormatException -> L9a
            int r2 = r2.inflate(r4, r5, r3)     // Catch: java.util.zip.DataFormatException -> L9a
            if (r2 <= 0) goto L69
            int r8 = r0.f6890c     // Catch: java.util.zip.DataFormatException -> L9a
            int r8 = r8 + r2
            r0.f6890c = r8     // Catch: java.util.zip.DataFormatException -> L9a
            long r8 = r7.f5398b     // Catch: java.util.zip.DataFormatException -> L9a
            long r0 = (long) r2     // Catch: java.util.zip.DataFormatException -> L9a
            long r8 = r8 + r0
            r7.f5398b = r8     // Catch: java.util.zip.DataFormatException -> L9a
            return r0
        L69:
            java.util.zip.Inflater r2 = r6.f6420b     // Catch: java.util.zip.DataFormatException -> L9a
            boolean r2 = r2.finished()     // Catch: java.util.zip.DataFormatException -> L9a
            if (r2 != 0) goto L85
            java.util.zip.Inflater r2 = r6.f6420b     // Catch: java.util.zip.DataFormatException -> L9a
            boolean r2 = r2.needsDictionary()     // Catch: java.util.zip.DataFormatException -> L9a
            if (r2 == 0) goto L7a
            goto L85
        L7a:
            if (r1 != 0) goto L7d
            goto Ld
        L7d:
            java.io.EOFException r7 = new java.io.EOFException     // Catch: java.util.zip.DataFormatException -> L9a
            java.lang.String r8 = "source exhausted prematurely"
            r7.<init>(r8)     // Catch: java.util.zip.DataFormatException -> L9a
            throw r7     // Catch: java.util.zip.DataFormatException -> L9a
        L85:
            r6.m395E()     // Catch: java.util.zip.DataFormatException -> L9a
            int r8 = r0.f6889b     // Catch: java.util.zip.DataFormatException -> L9a
            int r9 = r0.f6890c     // Catch: java.util.zip.DataFormatException -> L9a
            if (r8 != r9) goto L97
            ye r8 = r0.m49a()     // Catch: java.util.zip.DataFormatException -> L9a
            r7.f5397a = r8     // Catch: java.util.zip.DataFormatException -> L9a
            p000.C2410ze.m1a(r0)     // Catch: java.util.zip.DataFormatException -> L9a
        L97:
            r7 = -1
            return r7
        L9a:
            r7 = move-exception
            java.io.IOException r8 = new java.io.IOException
            r8.<init>(r7)
            throw r8
        La1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "?"
            r7.<init>(r8)
            throw r7
        La9:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "closed"
            r7.<init>(r8)
            throw r7
        Lb1:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "byteCount < 0: "
            java.lang.String r8 = p000.outline.m272I(r0, r8)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2242se.read(ke, long):long");
    }

    @Override // p000.InterfaceC0073Ce
    public C0097De timeout() {
        return this.f6419a.timeout();
    }
}
