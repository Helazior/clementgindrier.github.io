package org.spongycastle.crypto.digests;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RIPEMD256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: H0 */
    private int f5788H0;

    /* renamed from: H1 */
    private int f5789H1;

    /* renamed from: H2 */
    private int f5790H2;

    /* renamed from: H3 */
    private int f5791H3;

    /* renamed from: H4 */
    private int f5792H4;

    /* renamed from: H5 */
    private int f5793H5;

    /* renamed from: H6 */
    private int f5794H6;

    /* renamed from: H7 */
    private int f5795H7;

    /* renamed from: X */
    private int[] f5796X;
    private int xOff;

    public RIPEMD256Digest() {
        this.f5796X = new int[16];
        reset();
    }

    /* renamed from: F1 */
    private int m500F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(i + m495f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: F2 */
    private int m499F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(outline.m269b(i, m494f2(i2, i3, i4), i5, 1518500249), i6);
    }

    /* renamed from: F3 */
    private int m498F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(outline.m269b(i, m493f3(i2, i3, i4), i5, 1859775393), i6);
    }

    /* renamed from: F4 */
    private int m497F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(outline.m269b(i, m492f4(i2, i3, i4), i5, -1894007588), i6);
    }

    private int FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(i + m495f1(i2, i3, i4) + i5, i6);
    }

    private int FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(outline.m269b(i, m494f2(i2, i3, i4), i5, 1836072691), i6);
    }

    private int FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(outline.m269b(i, m493f3(i2, i3, i4), i5, 1548603684), i6);
    }

    private int FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m496RL(outline.m269b(i, m492f4(i2, i3, i4), i5, 1352829926), i6);
    }

    /* renamed from: RL */
    private int m496RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: f1 */
    private int m495f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m494f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m493f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m492f4(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.f5788H0, bArr, i);
        unpackWord(this.f5789H1, bArr, i + 4);
        unpackWord(this.f5790H2, bArr, i + 8);
        unpackWord(this.f5791H3, bArr, i + 12);
        unpackWord(this.f5792H4, bArr, i + 16);
        unpackWord(this.f5793H5, bArr, i + 20);
        unpackWord(this.f5794H6, bArr, i + 24);
        unpackWord(this.f5795H7, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD256";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i = this.f5788H0;
        int i2 = this.f5789H1;
        int i3 = this.f5790H2;
        int i4 = this.f5791H3;
        int i5 = this.f5792H4;
        int i6 = this.f5793H5;
        int i7 = this.f5794H6;
        int i8 = this.f5795H7;
        int m500F1 = m500F1(i, i2, i3, i4, this.f5796X[0], 11);
        int m500F12 = m500F1(i4, m500F1, i2, i3, this.f5796X[1], 14);
        int m500F13 = m500F1(i3, m500F12, m500F1, i2, this.f5796X[2], 15);
        int m500F14 = m500F1(i2, m500F13, m500F12, m500F1, this.f5796X[3], 12);
        int m500F15 = m500F1(m500F1, m500F14, m500F13, m500F12, this.f5796X[4], 5);
        int m500F16 = m500F1(m500F12, m500F15, m500F14, m500F13, this.f5796X[5], 8);
        int m500F17 = m500F1(m500F13, m500F16, m500F15, m500F14, this.f5796X[6], 7);
        int m500F18 = m500F1(m500F14, m500F17, m500F16, m500F15, this.f5796X[7], 9);
        int m500F19 = m500F1(m500F15, m500F18, m500F17, m500F16, this.f5796X[8], 11);
        int m500F110 = m500F1(m500F16, m500F19, m500F18, m500F17, this.f5796X[9], 13);
        int m500F111 = m500F1(m500F17, m500F110, m500F19, m500F18, this.f5796X[10], 14);
        int m500F112 = m500F1(m500F18, m500F111, m500F110, m500F19, this.f5796X[11], 15);
        int m500F113 = m500F1(m500F19, m500F112, m500F111, m500F110, this.f5796X[12], 6);
        int m500F114 = m500F1(m500F110, m500F113, m500F112, m500F111, this.f5796X[13], 7);
        int m500F115 = m500F1(m500F111, m500F114, m500F113, m500F112, this.f5796X[14], 9);
        int m500F116 = m500F1(m500F112, m500F115, m500F114, m500F113, this.f5796X[15], 8);
        int FF4 = FF4(i5, i6, i7, i8, this.f5796X[5], 8);
        int FF42 = FF4(i8, FF4, i6, i7, this.f5796X[14], 9);
        int FF43 = FF4(i7, FF42, FF4, i6, this.f5796X[7], 9);
        int FF44 = FF4(i6, FF43, FF42, FF4, this.f5796X[0], 11);
        int FF45 = FF4(FF4, FF44, FF43, FF42, this.f5796X[9], 13);
        int FF46 = FF4(FF42, FF45, FF44, FF43, this.f5796X[2], 15);
        int FF47 = FF4(FF43, FF46, FF45, FF44, this.f5796X[11], 15);
        int FF48 = FF4(FF44, FF47, FF46, FF45, this.f5796X[4], 5);
        int FF49 = FF4(FF45, FF48, FF47, FF46, this.f5796X[13], 7);
        int FF410 = FF4(FF46, FF49, FF48, FF47, this.f5796X[6], 7);
        int FF411 = FF4(FF47, FF410, FF49, FF48, this.f5796X[15], 8);
        int FF412 = FF4(FF48, FF411, FF410, FF49, this.f5796X[8], 11);
        int FF413 = FF4(FF49, FF412, FF411, FF410, this.f5796X[1], 14);
        int FF414 = FF4(FF410, FF413, FF412, FF411, this.f5796X[10], 14);
        int FF415 = FF4(FF411, FF414, FF413, FF412, this.f5796X[3], 12);
        int FF416 = FF4(FF412, FF415, FF414, FF413, this.f5796X[12], 6);
        int m499F2 = m499F2(FF413, m500F116, m500F115, m500F114, this.f5796X[7], 7);
        int m499F22 = m499F2(m500F114, m499F2, m500F116, m500F115, this.f5796X[4], 6);
        int m499F23 = m499F2(m500F115, m499F22, m499F2, m500F116, this.f5796X[13], 8);
        int m499F24 = m499F2(m500F116, m499F23, m499F22, m499F2, this.f5796X[1], 13);
        int m499F25 = m499F2(m499F2, m499F24, m499F23, m499F22, this.f5796X[10], 11);
        int m499F26 = m499F2(m499F22, m499F25, m499F24, m499F23, this.f5796X[6], 9);
        int m499F27 = m499F2(m499F23, m499F26, m499F25, m499F24, this.f5796X[15], 7);
        int m499F28 = m499F2(m499F24, m499F27, m499F26, m499F25, this.f5796X[3], 15);
        int m499F29 = m499F2(m499F25, m499F28, m499F27, m499F26, this.f5796X[12], 7);
        int m499F210 = m499F2(m499F26, m499F29, m499F28, m499F27, this.f5796X[0], 12);
        int m499F211 = m499F2(m499F27, m499F210, m499F29, m499F28, this.f5796X[9], 15);
        int m499F212 = m499F2(m499F28, m499F211, m499F210, m499F29, this.f5796X[5], 9);
        int m499F213 = m499F2(m499F29, m499F212, m499F211, m499F210, this.f5796X[2], 11);
        int m499F214 = m499F2(m499F210, m499F213, m499F212, m499F211, this.f5796X[14], 7);
        int m499F215 = m499F2(m499F211, m499F214, m499F213, m499F212, this.f5796X[11], 13);
        int m499F216 = m499F2(m499F212, m499F215, m499F214, m499F213, this.f5796X[8], 12);
        int FF3 = FF3(m500F113, FF416, FF415, FF414, this.f5796X[6], 9);
        int FF32 = FF3(FF414, FF3, FF416, FF415, this.f5796X[11], 13);
        int FF33 = FF3(FF415, FF32, FF3, FF416, this.f5796X[3], 15);
        int FF34 = FF3(FF416, FF33, FF32, FF3, this.f5796X[7], 7);
        int FF35 = FF3(FF3, FF34, FF33, FF32, this.f5796X[0], 12);
        int FF36 = FF3(FF32, FF35, FF34, FF33, this.f5796X[13], 8);
        int FF37 = FF3(FF33, FF36, FF35, FF34, this.f5796X[5], 9);
        int FF38 = FF3(FF34, FF37, FF36, FF35, this.f5796X[10], 11);
        int FF39 = FF3(FF35, FF38, FF37, FF36, this.f5796X[14], 7);
        int FF310 = FF3(FF36, FF39, FF38, FF37, this.f5796X[15], 7);
        int FF311 = FF3(FF37, FF310, FF39, FF38, this.f5796X[8], 12);
        int FF312 = FF3(FF38, FF311, FF310, FF39, this.f5796X[12], 7);
        int FF313 = FF3(FF39, FF312, FF311, FF310, this.f5796X[4], 6);
        int FF314 = FF3(FF310, FF313, FF312, FF311, this.f5796X[9], 15);
        int FF315 = FF3(FF311, FF314, FF313, FF312, this.f5796X[1], 13);
        int FF316 = FF3(FF312, FF315, FF314, FF313, this.f5796X[2], 11);
        int m498F3 = m498F3(m499F213, FF316, m499F215, m499F214, this.f5796X[3], 11);
        int m498F32 = m498F3(m499F214, m498F3, FF316, m499F215, this.f5796X[10], 13);
        int m498F33 = m498F3(m499F215, m498F32, m498F3, FF316, this.f5796X[14], 6);
        int m498F34 = m498F3(FF316, m498F33, m498F32, m498F3, this.f5796X[4], 7);
        int m498F35 = m498F3(m498F3, m498F34, m498F33, m498F32, this.f5796X[9], 14);
        int m498F36 = m498F3(m498F32, m498F35, m498F34, m498F33, this.f5796X[15], 9);
        int m498F37 = m498F3(m498F33, m498F36, m498F35, m498F34, this.f5796X[8], 13);
        int m498F38 = m498F3(m498F34, m498F37, m498F36, m498F35, this.f5796X[1], 15);
        int m498F39 = m498F3(m498F35, m498F38, m498F37, m498F36, this.f5796X[2], 14);
        int m498F310 = m498F3(m498F36, m498F39, m498F38, m498F37, this.f5796X[7], 8);
        int m498F311 = m498F3(m498F37, m498F310, m498F39, m498F38, this.f5796X[0], 13);
        int m498F312 = m498F3(m498F38, m498F311, m498F310, m498F39, this.f5796X[6], 6);
        int m498F313 = m498F3(m498F39, m498F312, m498F311, m498F310, this.f5796X[13], 5);
        int m498F314 = m498F3(m498F310, m498F313, m498F312, m498F311, this.f5796X[11], 12);
        int m498F315 = m498F3(m498F311, m498F314, m498F313, m498F312, this.f5796X[5], 7);
        int m498F316 = m498F3(m498F312, m498F315, m498F314, m498F313, this.f5796X[12], 5);
        int FF2 = FF2(FF313, m499F216, FF315, FF314, this.f5796X[15], 9);
        int FF22 = FF2(FF314, FF2, m499F216, FF315, this.f5796X[5], 7);
        int FF23 = FF2(FF315, FF22, FF2, m499F216, this.f5796X[1], 15);
        int FF24 = FF2(m499F216, FF23, FF22, FF2, this.f5796X[3], 11);
        int FF25 = FF2(FF2, FF24, FF23, FF22, this.f5796X[7], 8);
        int FF26 = FF2(FF22, FF25, FF24, FF23, this.f5796X[14], 6);
        int FF27 = FF2(FF23, FF26, FF25, FF24, this.f5796X[6], 6);
        int FF28 = FF2(FF24, FF27, FF26, FF25, this.f5796X[9], 14);
        int FF29 = FF2(FF25, FF28, FF27, FF26, this.f5796X[11], 12);
        int FF210 = FF2(FF26, FF29, FF28, FF27, this.f5796X[8], 13);
        int FF211 = FF2(FF27, FF210, FF29, FF28, this.f5796X[12], 5);
        int FF212 = FF2(FF28, FF211, FF210, FF29, this.f5796X[2], 14);
        int FF213 = FF2(FF29, FF212, FF211, FF210, this.f5796X[10], 13);
        int FF214 = FF2(FF210, FF213, FF212, FF211, this.f5796X[0], 13);
        int FF215 = FF2(FF211, FF214, FF213, FF212, this.f5796X[4], 7);
        int FF216 = FF2(FF212, FF215, FF214, FF213, this.f5796X[13], 5);
        int m497F4 = m497F4(m498F313, m498F316, FF215, m498F314, this.f5796X[1], 11);
        int m497F42 = m497F4(m498F314, m497F4, m498F316, FF215, this.f5796X[9], 12);
        int m497F43 = m497F4(FF215, m497F42, m497F4, m498F316, this.f5796X[11], 14);
        int m497F44 = m497F4(m498F316, m497F43, m497F42, m497F4, this.f5796X[10], 15);
        int m497F45 = m497F4(m497F4, m497F44, m497F43, m497F42, this.f5796X[0], 14);
        int m497F46 = m497F4(m497F42, m497F45, m497F44, m497F43, this.f5796X[8], 15);
        int m497F47 = m497F4(m497F43, m497F46, m497F45, m497F44, this.f5796X[12], 9);
        int m497F48 = m497F4(m497F44, m497F47, m497F46, m497F45, this.f5796X[4], 8);
        int m497F49 = m497F4(m497F45, m497F48, m497F47, m497F46, this.f5796X[13], 9);
        int m497F410 = m497F4(m497F46, m497F49, m497F48, m497F47, this.f5796X[3], 14);
        int m497F411 = m497F4(m497F47, m497F410, m497F49, m497F48, this.f5796X[7], 5);
        int m497F412 = m497F4(m497F48, m497F411, m497F410, m497F49, this.f5796X[15], 6);
        int m497F413 = m497F4(m497F49, m497F412, m497F411, m497F410, this.f5796X[14], 8);
        int m497F414 = m497F4(m497F410, m497F413, m497F412, m497F411, this.f5796X[5], 6);
        int m497F415 = m497F4(m497F411, m497F414, m497F413, m497F412, this.f5796X[6], 5);
        int m497F416 = m497F4(m497F412, m497F415, m497F414, m497F413, this.f5796X[2], 12);
        int FF1 = FF1(FF213, FF216, m498F315, FF214, this.f5796X[8], 15);
        int FF12 = FF1(FF214, FF1, FF216, m498F315, this.f5796X[6], 5);
        int FF13 = FF1(m498F315, FF12, FF1, FF216, this.f5796X[4], 8);
        int FF14 = FF1(FF216, FF13, FF12, FF1, this.f5796X[1], 11);
        int FF15 = FF1(FF1, FF14, FF13, FF12, this.f5796X[3], 14);
        int FF16 = FF1(FF12, FF15, FF14, FF13, this.f5796X[11], 14);
        int FF17 = FF1(FF13, FF16, FF15, FF14, this.f5796X[15], 6);
        int FF18 = FF1(FF14, FF17, FF16, FF15, this.f5796X[0], 14);
        int FF19 = FF1(FF15, FF18, FF17, FF16, this.f5796X[5], 6);
        int FF110 = FF1(FF16, FF19, FF18, FF17, this.f5796X[12], 9);
        int FF111 = FF1(FF17, FF110, FF19, FF18, this.f5796X[2], 12);
        int FF112 = FF1(FF18, FF111, FF110, FF19, this.f5796X[13], 9);
        int FF113 = FF1(FF19, FF112, FF111, FF110, this.f5796X[9], 12);
        int FF114 = FF1(FF110, FF113, FF112, FF111, this.f5796X[7], 5);
        int FF115 = FF1(FF111, FF114, FF113, FF112, this.f5796X[10], 15);
        int FF116 = FF1(FF112, FF115, FF114, FF113, this.f5796X[14], 8);
        this.f5788H0 += m497F413;
        this.f5789H1 += m497F416;
        this.f5790H2 += m497F415;
        this.f5791H3 += FF114;
        this.f5792H4 += FF113;
        this.f5793H5 += FF116;
        this.f5794H6 += FF115;
        this.f5795H7 += m497F414;
        this.xOff = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.f5796X;
            if (i9 == iArr.length) {
                return;
            }
            iArr[i9] = 0;
            i9++;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5796X;
        iArr[14] = (int) ((-1) & j);
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f5796X;
        int i2 = this.xOff;
        int i3 = i2 + 1;
        this.xOff = i3;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        if (i3 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f5788H0 = 1732584193;
        this.f5789H1 = -271733879;
        this.f5790H2 = -1732584194;
        this.f5791H3 = 271733878;
        this.f5792H4 = 1985229328;
        this.f5793H5 = -19088744;
        this.f5794H6 = -1985229329;
        this.f5795H7 = 19088743;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5796X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super(rIPEMD256Digest);
        int[] iArr = new int[16];
        this.f5796X = iArr;
        this.f5788H0 = rIPEMD256Digest.f5788H0;
        this.f5789H1 = rIPEMD256Digest.f5789H1;
        this.f5790H2 = rIPEMD256Digest.f5790H2;
        this.f5791H3 = rIPEMD256Digest.f5791H3;
        this.f5792H4 = rIPEMD256Digest.f5792H4;
        this.f5793H5 = rIPEMD256Digest.f5793H5;
        this.f5794H6 = rIPEMD256Digest.f5794H6;
        this.f5795H7 = rIPEMD256Digest.f5795H7;
        int[] iArr2 = rIPEMD256Digest.f5796X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.xOff = rIPEMD256Digest.xOff;
    }
}
