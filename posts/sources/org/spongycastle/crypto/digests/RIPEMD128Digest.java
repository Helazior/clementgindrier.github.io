package org.spongycastle.crypto.digests;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RIPEMD128Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: H0 */
    private int f5777H0;

    /* renamed from: H1 */
    private int f5778H1;

    /* renamed from: H2 */
    private int f5779H2;

    /* renamed from: H3 */
    private int f5780H3;

    /* renamed from: X */
    private int[] f5781X;
    private int xOff;

    public RIPEMD128Digest() {
        this.f5781X = new int[16];
        reset();
    }

    /* renamed from: F1 */
    private int m515F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(i + m510f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: F2 */
    private int m514F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(outline.m269b(i, m509f2(i2, i3, i4), i5, 1518500249), i6);
    }

    /* renamed from: F3 */
    private int m513F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(outline.m269b(i, m508f3(i2, i3, i4), i5, 1859775393), i6);
    }

    /* renamed from: F4 */
    private int m512F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(outline.m269b(i, m507f4(i2, i3, i4), i5, -1894007588), i6);
    }

    private int FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(i + m510f1(i2, i3, i4) + i5, i6);
    }

    private int FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(outline.m269b(i, m509f2(i2, i3, i4), i5, 1836072691), i6);
    }

    private int FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(outline.m269b(i, m508f3(i2, i3, i4), i5, 1548603684), i6);
    }

    private int FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m511RL(outline.m269b(i, m507f4(i2, i3, i4), i5, 1352829926), i6);
    }

    /* renamed from: RL */
    private int m511RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: f1 */
    private int m510f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m509f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m508f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m507f4(int i, int i2, int i3) {
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
        unpackWord(this.f5777H0, bArr, i);
        unpackWord(this.f5778H1, bArr, i + 4);
        unpackWord(this.f5779H2, bArr, i + 8);
        unpackWord(this.f5780H3, bArr, i + 12);
        reset();
        return 16;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD128";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i = this.f5777H0;
        int i2 = this.f5778H1;
        int i3 = this.f5779H2;
        int i4 = this.f5780H3;
        int m515F1 = m515F1(i, i2, i3, i4, this.f5781X[0], 11);
        int m515F12 = m515F1(i4, m515F1, i2, i3, this.f5781X[1], 14);
        int m515F13 = m515F1(i3, m515F12, m515F1, i2, this.f5781X[2], 15);
        int m515F14 = m515F1(i2, m515F13, m515F12, m515F1, this.f5781X[3], 12);
        int m515F15 = m515F1(m515F1, m515F14, m515F13, m515F12, this.f5781X[4], 5);
        int m515F16 = m515F1(m515F12, m515F15, m515F14, m515F13, this.f5781X[5], 8);
        int m515F17 = m515F1(m515F13, m515F16, m515F15, m515F14, this.f5781X[6], 7);
        int m515F18 = m515F1(m515F14, m515F17, m515F16, m515F15, this.f5781X[7], 9);
        int m515F19 = m515F1(m515F15, m515F18, m515F17, m515F16, this.f5781X[8], 11);
        int m515F110 = m515F1(m515F16, m515F19, m515F18, m515F17, this.f5781X[9], 13);
        int m515F111 = m515F1(m515F17, m515F110, m515F19, m515F18, this.f5781X[10], 14);
        int m515F112 = m515F1(m515F18, m515F111, m515F110, m515F19, this.f5781X[11], 15);
        int m515F113 = m515F1(m515F19, m515F112, m515F111, m515F110, this.f5781X[12], 6);
        int m515F114 = m515F1(m515F110, m515F113, m515F112, m515F111, this.f5781X[13], 7);
        int m515F115 = m515F1(m515F111, m515F114, m515F113, m515F112, this.f5781X[14], 9);
        int m515F116 = m515F1(m515F112, m515F115, m515F114, m515F113, this.f5781X[15], 8);
        int m514F2 = m514F2(m515F113, m515F116, m515F115, m515F114, this.f5781X[7], 7);
        int m514F22 = m514F2(m515F114, m514F2, m515F116, m515F115, this.f5781X[4], 6);
        int m514F23 = m514F2(m515F115, m514F22, m514F2, m515F116, this.f5781X[13], 8);
        int m514F24 = m514F2(m515F116, m514F23, m514F22, m514F2, this.f5781X[1], 13);
        int m514F25 = m514F2(m514F2, m514F24, m514F23, m514F22, this.f5781X[10], 11);
        int m514F26 = m514F2(m514F22, m514F25, m514F24, m514F23, this.f5781X[6], 9);
        int m514F27 = m514F2(m514F23, m514F26, m514F25, m514F24, this.f5781X[15], 7);
        int m514F28 = m514F2(m514F24, m514F27, m514F26, m514F25, this.f5781X[3], 15);
        int m514F29 = m514F2(m514F25, m514F28, m514F27, m514F26, this.f5781X[12], 7);
        int m514F210 = m514F2(m514F26, m514F29, m514F28, m514F27, this.f5781X[0], 12);
        int m514F211 = m514F2(m514F27, m514F210, m514F29, m514F28, this.f5781X[9], 15);
        int m514F212 = m514F2(m514F28, m514F211, m514F210, m514F29, this.f5781X[5], 9);
        int m514F213 = m514F2(m514F29, m514F212, m514F211, m514F210, this.f5781X[2], 11);
        int m514F214 = m514F2(m514F210, m514F213, m514F212, m514F211, this.f5781X[14], 7);
        int m514F215 = m514F2(m514F211, m514F214, m514F213, m514F212, this.f5781X[11], 13);
        int m514F216 = m514F2(m514F212, m514F215, m514F214, m514F213, this.f5781X[8], 12);
        int m513F3 = m513F3(m514F213, m514F216, m514F215, m514F214, this.f5781X[3], 11);
        int m513F32 = m513F3(m514F214, m513F3, m514F216, m514F215, this.f5781X[10], 13);
        int m513F33 = m513F3(m514F215, m513F32, m513F3, m514F216, this.f5781X[14], 6);
        int m513F34 = m513F3(m514F216, m513F33, m513F32, m513F3, this.f5781X[4], 7);
        int m513F35 = m513F3(m513F3, m513F34, m513F33, m513F32, this.f5781X[9], 14);
        int m513F36 = m513F3(m513F32, m513F35, m513F34, m513F33, this.f5781X[15], 9);
        int m513F37 = m513F3(m513F33, m513F36, m513F35, m513F34, this.f5781X[8], 13);
        int m513F38 = m513F3(m513F34, m513F37, m513F36, m513F35, this.f5781X[1], 15);
        int m513F39 = m513F3(m513F35, m513F38, m513F37, m513F36, this.f5781X[2], 14);
        int m513F310 = m513F3(m513F36, m513F39, m513F38, m513F37, this.f5781X[7], 8);
        int m513F311 = m513F3(m513F37, m513F310, m513F39, m513F38, this.f5781X[0], 13);
        int m513F312 = m513F3(m513F38, m513F311, m513F310, m513F39, this.f5781X[6], 6);
        int m513F313 = m513F3(m513F39, m513F312, m513F311, m513F310, this.f5781X[13], 5);
        int m513F314 = m513F3(m513F310, m513F313, m513F312, m513F311, this.f5781X[11], 12);
        int m513F315 = m513F3(m513F311, m513F314, m513F313, m513F312, this.f5781X[5], 7);
        int m513F316 = m513F3(m513F312, m513F315, m513F314, m513F313, this.f5781X[12], 5);
        int m512F4 = m512F4(m513F313, m513F316, m513F315, m513F314, this.f5781X[1], 11);
        int m512F42 = m512F4(m513F314, m512F4, m513F316, m513F315, this.f5781X[9], 12);
        int m512F43 = m512F4(m513F315, m512F42, m512F4, m513F316, this.f5781X[11], 14);
        int m512F44 = m512F4(m513F316, m512F43, m512F42, m512F4, this.f5781X[10], 15);
        int m512F45 = m512F4(m512F4, m512F44, m512F43, m512F42, this.f5781X[0], 14);
        int m512F46 = m512F4(m512F42, m512F45, m512F44, m512F43, this.f5781X[8], 15);
        int m512F47 = m512F4(m512F43, m512F46, m512F45, m512F44, this.f5781X[12], 9);
        int m512F48 = m512F4(m512F44, m512F47, m512F46, m512F45, this.f5781X[4], 8);
        int m512F49 = m512F4(m512F45, m512F48, m512F47, m512F46, this.f5781X[13], 9);
        int m512F410 = m512F4(m512F46, m512F49, m512F48, m512F47, this.f5781X[3], 14);
        int m512F411 = m512F4(m512F47, m512F410, m512F49, m512F48, this.f5781X[7], 5);
        int m512F412 = m512F4(m512F48, m512F411, m512F410, m512F49, this.f5781X[15], 6);
        int m512F413 = m512F4(m512F49, m512F412, m512F411, m512F410, this.f5781X[14], 8);
        int m512F414 = m512F4(m512F410, m512F413, m512F412, m512F411, this.f5781X[5], 6);
        int m512F415 = m512F4(m512F411, m512F414, m512F413, m512F412, this.f5781X[6], 5);
        int m512F416 = m512F4(m512F412, m512F415, m512F414, m512F413, this.f5781X[2], 12);
        int FF4 = FF4(i, i2, i3, i4, this.f5781X[5], 8);
        int FF42 = FF4(i4, FF4, i2, i3, this.f5781X[14], 9);
        int FF43 = FF4(i3, FF42, FF4, i2, this.f5781X[7], 9);
        int FF44 = FF4(i2, FF43, FF42, FF4, this.f5781X[0], 11);
        int FF45 = FF4(FF4, FF44, FF43, FF42, this.f5781X[9], 13);
        int FF46 = FF4(FF42, FF45, FF44, FF43, this.f5781X[2], 15);
        int FF47 = FF4(FF43, FF46, FF45, FF44, this.f5781X[11], 15);
        int FF48 = FF4(FF44, FF47, FF46, FF45, this.f5781X[4], 5);
        int FF49 = FF4(FF45, FF48, FF47, FF46, this.f5781X[13], 7);
        int FF410 = FF4(FF46, FF49, FF48, FF47, this.f5781X[6], 7);
        int FF411 = FF4(FF47, FF410, FF49, FF48, this.f5781X[15], 8);
        int FF412 = FF4(FF48, FF411, FF410, FF49, this.f5781X[8], 11);
        int FF413 = FF4(FF49, FF412, FF411, FF410, this.f5781X[1], 14);
        int FF414 = FF4(FF410, FF413, FF412, FF411, this.f5781X[10], 14);
        int FF415 = FF4(FF411, FF414, FF413, FF412, this.f5781X[3], 12);
        int FF416 = FF4(FF412, FF415, FF414, FF413, this.f5781X[12], 6);
        int FF3 = FF3(FF413, FF416, FF415, FF414, this.f5781X[6], 9);
        int FF32 = FF3(FF414, FF3, FF416, FF415, this.f5781X[11], 13);
        int FF33 = FF3(FF415, FF32, FF3, FF416, this.f5781X[3], 15);
        int FF34 = FF3(FF416, FF33, FF32, FF3, this.f5781X[7], 7);
        int FF35 = FF3(FF3, FF34, FF33, FF32, this.f5781X[0], 12);
        int FF36 = FF3(FF32, FF35, FF34, FF33, this.f5781X[13], 8);
        int FF37 = FF3(FF33, FF36, FF35, FF34, this.f5781X[5], 9);
        int FF38 = FF3(FF34, FF37, FF36, FF35, this.f5781X[10], 11);
        int FF39 = FF3(FF35, FF38, FF37, FF36, this.f5781X[14], 7);
        int FF310 = FF3(FF36, FF39, FF38, FF37, this.f5781X[15], 7);
        int FF311 = FF3(FF37, FF310, FF39, FF38, this.f5781X[8], 12);
        int FF312 = FF3(FF38, FF311, FF310, FF39, this.f5781X[12], 7);
        int FF313 = FF3(FF39, FF312, FF311, FF310, this.f5781X[4], 6);
        int FF314 = FF3(FF310, FF313, FF312, FF311, this.f5781X[9], 15);
        int FF315 = FF3(FF311, FF314, FF313, FF312, this.f5781X[1], 13);
        int FF316 = FF3(FF312, FF315, FF314, FF313, this.f5781X[2], 11);
        int FF2 = FF2(FF313, FF316, FF315, FF314, this.f5781X[15], 9);
        int FF22 = FF2(FF314, FF2, FF316, FF315, this.f5781X[5], 7);
        int FF23 = FF2(FF315, FF22, FF2, FF316, this.f5781X[1], 15);
        int FF24 = FF2(FF316, FF23, FF22, FF2, this.f5781X[3], 11);
        int FF25 = FF2(FF2, FF24, FF23, FF22, this.f5781X[7], 8);
        int FF26 = FF2(FF22, FF25, FF24, FF23, this.f5781X[14], 6);
        int FF27 = FF2(FF23, FF26, FF25, FF24, this.f5781X[6], 6);
        int FF28 = FF2(FF24, FF27, FF26, FF25, this.f5781X[9], 14);
        int FF29 = FF2(FF25, FF28, FF27, FF26, this.f5781X[11], 12);
        int FF210 = FF2(FF26, FF29, FF28, FF27, this.f5781X[8], 13);
        int FF211 = FF2(FF27, FF210, FF29, FF28, this.f5781X[12], 5);
        int FF212 = FF2(FF28, FF211, FF210, FF29, this.f5781X[2], 14);
        int FF213 = FF2(FF29, FF212, FF211, FF210, this.f5781X[10], 13);
        int FF214 = FF2(FF210, FF213, FF212, FF211, this.f5781X[0], 13);
        int FF215 = FF2(FF211, FF214, FF213, FF212, this.f5781X[4], 7);
        int FF216 = FF2(FF212, FF215, FF214, FF213, this.f5781X[13], 5);
        int FF1 = FF1(FF213, FF216, FF215, FF214, this.f5781X[8], 15);
        int FF12 = FF1(FF214, FF1, FF216, FF215, this.f5781X[6], 5);
        int FF13 = FF1(FF215, FF12, FF1, FF216, this.f5781X[4], 8);
        int FF14 = FF1(FF216, FF13, FF12, FF1, this.f5781X[1], 11);
        int FF15 = FF1(FF1, FF14, FF13, FF12, this.f5781X[3], 14);
        int FF16 = FF1(FF12, FF15, FF14, FF13, this.f5781X[11], 14);
        int FF17 = FF1(FF13, FF16, FF15, FF14, this.f5781X[15], 6);
        int FF18 = FF1(FF14, FF17, FF16, FF15, this.f5781X[0], 14);
        int FF19 = FF1(FF15, FF18, FF17, FF16, this.f5781X[5], 6);
        int FF110 = FF1(FF16, FF19, FF18, FF17, this.f5781X[12], 9);
        int FF111 = FF1(FF17, FF110, FF19, FF18, this.f5781X[2], 12);
        int FF112 = FF1(FF18, FF111, FF110, FF19, this.f5781X[13], 9);
        int FF113 = FF1(FF19, FF112, FF111, FF110, this.f5781X[9], 12);
        int FF114 = FF1(FF110, FF113, FF112, FF111, this.f5781X[7], 5);
        int FF115 = FF1(FF111, FF114, FF113, FF112, this.f5781X[10], 15);
        int FF116 = FF1(FF112, FF115, FF114, FF113, this.f5781X[14], 8);
        this.f5778H1 = this.f5779H2 + m512F414 + FF113;
        this.f5779H2 = this.f5780H3 + m512F413 + FF116;
        this.f5780H3 = this.f5777H0 + m512F416 + FF115;
        this.f5777H0 = m512F415 + this.f5778H1 + FF114;
        this.xOff = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f5781X;
            if (i5 == iArr.length) {
                return;
            }
            iArr[i5] = 0;
            i5++;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5781X;
        iArr[14] = (int) ((-1) & j);
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f5781X;
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
        this.f5777H0 = 1732584193;
        this.f5778H1 = -271733879;
        this.f5779H2 = -1732584194;
        this.f5780H3 = 271733878;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5781X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public RIPEMD128Digest(RIPEMD128Digest rIPEMD128Digest) {
        super(rIPEMD128Digest);
        int[] iArr = new int[16];
        this.f5781X = iArr;
        this.f5777H0 = rIPEMD128Digest.f5777H0;
        this.f5778H1 = rIPEMD128Digest.f5778H1;
        this.f5779H2 = rIPEMD128Digest.f5779H2;
        this.f5780H3 = rIPEMD128Digest.f5780H3;
        int[] iArr2 = rIPEMD128Digest.f5781X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.xOff = rIPEMD128Digest.xOff;
    }
}
