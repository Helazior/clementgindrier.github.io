package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.util.Pack;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SHA256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: K */
    public static final int[] f5828K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: H1 */
    private int f5829H1;

    /* renamed from: H2 */
    private int f5830H2;

    /* renamed from: H3 */
    private int f5831H3;

    /* renamed from: H4 */
    private int f5832H4;

    /* renamed from: H5 */
    private int f5833H5;

    /* renamed from: H6 */
    private int f5834H6;

    /* renamed from: H7 */
    private int f5835H7;

    /* renamed from: H8 */
    private int f5836H8;

    /* renamed from: X */
    private int[] f5837X;
    private int xOff;

    public SHA256Digest() {
        this.f5837X = new int[64];
        reset();
    }

    /* renamed from: Ch */
    private int m481Ch(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private int Maj(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    private int Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private int Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private int Theta0(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private int Theta1(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f5829H1, bArr, i);
        Pack.intToBigEndian(this.f5830H2, bArr, i + 4);
        Pack.intToBigEndian(this.f5831H3, bArr, i + 8);
        Pack.intToBigEndian(this.f5832H4, bArr, i + 12);
        Pack.intToBigEndian(this.f5833H5, bArr, i + 16);
        Pack.intToBigEndian(this.f5834H6, bArr, i + 20);
        Pack.intToBigEndian(this.f5835H7, bArr, i + 24);
        Pack.intToBigEndian(this.f5836H8, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-256";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f5837X;
            int Theta1 = Theta1(iArr[i - 2]);
            int[] iArr2 = this.f5837X;
            iArr[i] = Theta1 + iArr2[i - 7] + Theta0(iArr2[i - 15]) + this.f5837X[i - 16];
        }
        int i2 = this.f5829H1;
        int i3 = this.f5830H2;
        int i4 = this.f5831H3;
        int i5 = this.f5832H4;
        int i6 = this.f5833H5;
        int i7 = this.f5834H6;
        int i8 = this.f5835H7;
        int i9 = this.f5836H8;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int Sum1 = Sum1(i6) + m481Ch(i6, i7, i8);
            int[] iArr3 = f5828K;
            int i12 = Sum1 + iArr3[i10] + this.f5837X[i10] + i9;
            int i13 = i5 + i12;
            int Sum0 = Sum0(i2) + Maj(i2, i3, i4) + i12;
            int i14 = i10 + 1;
            int Sum12 = Sum1(i13) + m481Ch(i13, i6, i7) + iArr3[i14] + this.f5837X[i14] + i8;
            int i15 = i4 + Sum12;
            int Sum02 = Sum0(Sum0) + Maj(Sum0, i2, i3) + Sum12;
            int i16 = i14 + 1;
            int Sum13 = Sum1(i15) + m481Ch(i15, i13, i6) + iArr3[i16] + this.f5837X[i16] + i7;
            int i17 = i3 + Sum13;
            int Sum03 = Sum0(Sum02) + Maj(Sum02, Sum0, i2) + Sum13;
            int i18 = i16 + 1;
            int Sum14 = Sum1(i17) + m481Ch(i17, i15, i13) + iArr3[i18] + this.f5837X[i18] + i6;
            int i19 = i2 + Sum14;
            int Sum04 = Sum0(Sum03) + Maj(Sum03, Sum02, Sum0) + Sum14;
            int i20 = i18 + 1;
            int Sum15 = Sum1(i19) + m481Ch(i19, i17, i15) + iArr3[i20] + this.f5837X[i20] + i13;
            i9 = Sum0 + Sum15;
            i5 = Sum0(Sum04) + Maj(Sum04, Sum03, Sum02) + Sum15;
            int i21 = i20 + 1;
            int Sum16 = Sum1(i9) + m481Ch(i9, i19, i17) + iArr3[i21] + this.f5837X[i21] + i15;
            i8 = Sum02 + Sum16;
            i4 = Sum0(i5) + Maj(i5, Sum04, Sum03) + Sum16;
            int i22 = i21 + 1;
            int Sum17 = Sum1(i8) + m481Ch(i8, i9, i19) + iArr3[i22] + this.f5837X[i22] + i17;
            i7 = Sum03 + Sum17;
            i3 = Sum0(i4) + Maj(i4, i5, Sum04) + Sum17;
            int i23 = i22 + 1;
            int Sum18 = Sum1(i7) + m481Ch(i7, i8, i9) + iArr3[i23] + this.f5837X[i23] + i19;
            i6 = Sum04 + Sum18;
            i2 = Sum0(i3) + Maj(i3, i4, i5) + Sum18;
            i10 = i23 + 1;
        }
        this.f5829H1 += i2;
        this.f5830H2 += i3;
        this.f5831H3 += i4;
        this.f5832H4 += i5;
        this.f5833H5 += i6;
        this.f5834H6 += i7;
        this.f5835H7 += i8;
        this.f5836H8 += i9;
        this.xOff = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            this.f5837X[i24] = 0;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5837X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f5837X;
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
        this.f5829H1 = 1779033703;
        this.f5830H2 = -1150833019;
        this.f5831H3 = 1013904242;
        this.f5832H4 = -1521486534;
        this.f5833H5 = 1359893119;
        this.f5834H6 = -1694144372;
        this.f5835H7 = 528734635;
        this.f5836H8 = 1541459225;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5837X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        int[] iArr = new int[64];
        this.f5837X = iArr;
        this.f5829H1 = sHA256Digest.f5829H1;
        this.f5830H2 = sHA256Digest.f5830H2;
        this.f5831H3 = sHA256Digest.f5831H3;
        this.f5832H4 = sHA256Digest.f5832H4;
        this.f5833H5 = sHA256Digest.f5833H5;
        this.f5834H6 = sHA256Digest.f5834H6;
        this.f5835H7 = sHA256Digest.f5835H7;
        this.f5836H8 = sHA256Digest.f5836H8;
        int[] iArr2 = sHA256Digest.f5837X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.xOff = sHA256Digest.xOff;
    }
}
