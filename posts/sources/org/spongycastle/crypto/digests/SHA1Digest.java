package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.util.Pack;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SHA1Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;

    /* renamed from: Y1 */
    private static final int f5808Y1 = 1518500249;

    /* renamed from: Y2 */
    private static final int f5809Y2 = 1859775393;

    /* renamed from: Y3 */
    private static final int f5810Y3 = -1894007588;

    /* renamed from: Y4 */
    private static final int f5811Y4 = -899497514;

    /* renamed from: H1 */
    private int f5812H1;

    /* renamed from: H2 */
    private int f5813H2;

    /* renamed from: H3 */
    private int f5814H3;

    /* renamed from: H4 */
    private int f5815H4;

    /* renamed from: H5 */
    private int f5816H5;

    /* renamed from: X */
    private int[] f5817X;
    private int xOff;

    public SHA1Digest() {
        this.f5817X = new int[80];
        reset();
    }

    /* renamed from: f */
    private int m485f(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: g */
    private int m484g(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    /* renamed from: h */
    private int m483h(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f5812H1, bArr, i);
        Pack.intToBigEndian(this.f5813H2, bArr, i + 4);
        Pack.intToBigEndian(this.f5814H3, bArr, i + 8);
        Pack.intToBigEndian(this.f5815H4, bArr, i + 12);
        Pack.intToBigEndian(this.f5816H5, bArr, i + 16);
        reset();
        return 20;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.f5817X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.f5812H1;
        int i4 = this.f5813H2;
        int i5 = this.f5814H3;
        int i6 = this.f5815H4;
        int i7 = this.f5816H5;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int i10 = i9 + 1;
            int m269b = outline.m269b(((i3 << 5) | (i3 >>> 27)) + m485f(i4, i5, i6), this.f5817X[i9], f5808Y1, i7);
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int m269b2 = outline.m269b(((m269b << 5) | (m269b >>> 27)) + m485f(i3, i11, i5), this.f5817X[i10], f5808Y1, i6);
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int m269b3 = outline.m269b(((m269b2 << 5) | (m269b2 >>> 27)) + m485f(m269b, i13, i11), this.f5817X[i12], f5808Y1, i5);
            i7 = (m269b >>> 2) | (m269b << 30);
            int i15 = i14 + 1;
            i4 = outline.m269b(((m269b3 << 5) | (m269b3 >>> 27)) + m485f(m269b2, i7, i13), this.f5817X[i14], f5808Y1, i11);
            i6 = (m269b2 >>> 2) | (m269b2 << 30);
            i3 = outline.m269b(((i4 << 5) | (i4 >>> 27)) + m485f(m269b3, i6, i7), this.f5817X[i15], f5808Y1, i13);
            i5 = (m269b3 >>> 2) | (m269b3 << 30);
            i8++;
            i9 = i15 + 1;
        }
        int i16 = 0;
        while (i16 < 4) {
            int i17 = i9 + 1;
            int m269b4 = outline.m269b(((i3 << 5) | (i3 >>> 27)) + m483h(i4, i5, i6), this.f5817X[i9], f5809Y2, i7);
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int m269b5 = outline.m269b(((m269b4 << 5) | (m269b4 >>> 27)) + m483h(i3, i18, i5), this.f5817X[i17], f5809Y2, i6);
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int m269b6 = outline.m269b(((m269b5 << 5) | (m269b5 >>> 27)) + m483h(m269b4, i20, i18), this.f5817X[i19], f5809Y2, i5);
            i7 = (m269b4 >>> 2) | (m269b4 << 30);
            int i22 = i21 + 1;
            i4 = outline.m269b(((m269b6 << 5) | (m269b6 >>> 27)) + m483h(m269b5, i7, i20), this.f5817X[i21], f5809Y2, i18);
            i6 = (m269b5 >>> 2) | (m269b5 << 30);
            i3 = outline.m269b(((i4 << 5) | (i4 >>> 27)) + m483h(m269b6, i6, i7), this.f5817X[i22], f5809Y2, i20);
            i5 = (m269b6 >>> 2) | (m269b6 << 30);
            i16++;
            i9 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int i24 = i9 + 1;
            int m269b7 = outline.m269b(((i3 << 5) | (i3 >>> 27)) + m484g(i4, i5, i6), this.f5817X[i9], f5810Y3, i7);
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int m269b8 = outline.m269b(((m269b7 << 5) | (m269b7 >>> 27)) + m484g(i3, i25, i5), this.f5817X[i24], f5810Y3, i6);
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int m269b9 = outline.m269b(((m269b8 << 5) | (m269b8 >>> 27)) + m484g(m269b7, i27, i25), this.f5817X[i26], f5810Y3, i5);
            i7 = (m269b7 >>> 2) | (m269b7 << 30);
            int i29 = i28 + 1;
            i4 = outline.m269b(((m269b9 << 5) | (m269b9 >>> 27)) + m484g(m269b8, i7, i27), this.f5817X[i28], f5810Y3, i25);
            i6 = (m269b8 >>> 2) | (m269b8 << 30);
            i3 = outline.m269b(((i4 << 5) | (i4 >>> 27)) + m484g(m269b9, i6, i7), this.f5817X[i29], f5810Y3, i27);
            i5 = (m269b9 >>> 2) | (m269b9 << 30);
            i23++;
            i9 = i29 + 1;
        }
        int i30 = 0;
        while (i30 <= 3) {
            int i31 = i9 + 1;
            int m269b10 = outline.m269b(((i3 << 5) | (i3 >>> 27)) + m483h(i4, i5, i6), this.f5817X[i9], f5811Y4, i7);
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int m269b11 = outline.m269b(((m269b10 << 5) | (m269b10 >>> 27)) + m483h(i3, i32, i5), this.f5817X[i31], f5811Y4, i6);
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int m269b12 = outline.m269b(((m269b11 << 5) | (m269b11 >>> 27)) + m483h(m269b10, i34, i32), this.f5817X[i33], f5811Y4, i5);
            i7 = (m269b10 >>> 2) | (m269b10 << 30);
            int i36 = i35 + 1;
            i4 = outline.m269b(((m269b12 << 5) | (m269b12 >>> 27)) + m483h(m269b11, i7, i34), this.f5817X[i35], f5811Y4, i32);
            i6 = (m269b11 >>> 2) | (m269b11 << 30);
            i3 = outline.m269b(((i4 << 5) | (i4 >>> 27)) + m483h(m269b12, i6, i7), this.f5817X[i36], f5811Y4, i34);
            i5 = (m269b12 >>> 2) | (m269b12 << 30);
            i30++;
            i9 = i36 + 1;
        }
        this.f5812H1 += i3;
        this.f5813H2 += i4;
        this.f5814H3 += i5;
        this.f5815H4 += i6;
        this.f5816H5 += i7;
        this.xOff = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            this.f5817X[i37] = 0;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5817X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f5817X;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f5812H1 = 1732584193;
        this.f5813H2 = -271733879;
        this.f5814H3 = -1732584194;
        this.f5815H4 = 271733878;
        this.f5816H5 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5817X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        int[] iArr = new int[80];
        this.f5817X = iArr;
        this.f5812H1 = sHA1Digest.f5812H1;
        this.f5813H2 = sHA1Digest.f5813H2;
        this.f5814H3 = sHA1Digest.f5814H3;
        this.f5815H4 = sHA1Digest.f5815H4;
        this.f5816H5 = sHA1Digest.f5816H5;
        int[] iArr2 = sHA1Digest.f5817X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.xOff = sHA1Digest.xOff;
    }
}
