package org.spongycastle.crypto.engines;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.lang.reflect.Array;
import org.spongycastle.asn1.eac.EACTags;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.p017ec.Tnaf;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: m1 */
    private static final int f5881m1 = -2139062144;

    /* renamed from: m2 */
    private static final int f5882m2 = 2139062143;

    /* renamed from: m3 */
    private static final int f5883m3 = 27;

    /* renamed from: C0 */
    private int f5884C0;

    /* renamed from: C1 */
    private int f5885C1;

    /* renamed from: C2 */
    private int f5886C2;

    /* renamed from: C3 */
    private int f5887C3;
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    /* renamed from: S */
    private static final byte[] f5879S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};

    /* renamed from: Si */
    private static final byte[] f5880Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, EACTags.SECURE_MESSAGING_TEMPLATE, BaseTransientBottomBar.ANIMATION_DURATION, 239, 197, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};

    private int FFmulX(int i) {
        return (((i & f5881m1) >>> 7) * 27) ^ ((f5882m2 & i) << 1);
    }

    private void decryptBlock(int[][] iArr) {
        int i = this.f5884C0;
        int i2 = this.ROUNDS;
        this.f5884C0 = i ^ iArr[i2][0];
        this.f5885C1 ^= iArr[i2][1];
        this.f5886C2 ^= iArr[i2][2];
        this.f5887C3 ^= iArr[i2][3];
        int i3 = i2 - 1;
        while (i3 > 1) {
            byte[] bArr = f5880Si;
            int inv_mcol = inv_mcol((((bArr[this.f5884C0 & 255] & 255) ^ ((bArr[(this.f5887C3 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5886C2 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5885C1 >> 24) & 255] << 24)) ^ iArr[i3][0];
            int inv_mcol2 = inv_mcol((((bArr[this.f5885C1 & 255] & 255) ^ ((bArr[(this.f5884C0 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5887C3 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5886C2 >> 24) & 255] << 24)) ^ iArr[i3][1];
            int inv_mcol3 = inv_mcol((((bArr[this.f5886C2 & 255] & 255) ^ ((bArr[(this.f5885C1 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5884C0 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5887C3 >> 24) & 255] << 24)) ^ iArr[i3][2];
            int i4 = i3 - 1;
            int inv_mcol4 = iArr[i3][3] ^ inv_mcol((((bArr[this.f5887C3 & 255] & 255) ^ ((bArr[(this.f5886C2 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5885C1 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5884C0 >> 24) & 255] << 24));
            this.f5884C0 = inv_mcol((((bArr[inv_mcol & 255] & 255) ^ ((bArr[(inv_mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr[(inv_mcol3 >> 16) & 255] & 255) << 16)) ^ (bArr[(inv_mcol2 >> 24) & 255] << 24)) ^ iArr[i4][0];
            this.f5885C1 = inv_mcol((((bArr[inv_mcol2 & 255] & 255) ^ ((bArr[(inv_mcol >> 8) & 255] & 255) << 8)) ^ ((bArr[(inv_mcol4 >> 16) & 255] & 255) << 16)) ^ (bArr[(inv_mcol3 >> 24) & 255] << 24)) ^ iArr[i4][1];
            this.f5886C2 = inv_mcol((((bArr[inv_mcol3 & 255] & 255) ^ ((bArr[(inv_mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr[(inv_mcol >> 16) & 255] & 255) << 16)) ^ (bArr[(inv_mcol4 >> 24) & 255] << 24)) ^ iArr[i4][2];
            i3 = i4 - 1;
            this.f5887C3 = inv_mcol((bArr[(inv_mcol >> 24) & 255] << 24) ^ (((bArr[inv_mcol4 & 255] & 255) ^ ((bArr[(inv_mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr[(inv_mcol2 >> 16) & 255] & 255) << 16))) ^ iArr[i4][3];
        }
        byte[] bArr2 = f5880Si;
        int inv_mcol5 = inv_mcol((((bArr2[this.f5884C0 & 255] & 255) ^ ((bArr2[(this.f5887C3 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5886C2 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5885C1 >> 24) & 255] << 24)) ^ iArr[i3][0];
        int inv_mcol6 = inv_mcol((((bArr2[this.f5885C1 & 255] & 255) ^ ((bArr2[(this.f5884C0 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5887C3 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5886C2 >> 24) & 255] << 24)) ^ iArr[i3][1];
        int inv_mcol7 = inv_mcol((((bArr2[this.f5886C2 & 255] & 255) ^ ((bArr2[(this.f5885C1 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5884C0 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5887C3 >> 24) & 255] << 24)) ^ iArr[i3][2];
        int inv_mcol8 = iArr[i3][3] ^ inv_mcol((((bArr2[this.f5887C3 & 255] & 255) ^ ((bArr2[(this.f5886C2 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5885C1 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5884C0 >> 24) & 255] << 24));
        this.f5884C0 = ((((bArr2[inv_mcol5 & 255] & 255) ^ ((bArr2[(inv_mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(inv_mcol7 >> 16) & 255] & 255) << 16)) ^ (bArr2[(inv_mcol6 >> 24) & 255] << 24)) ^ iArr[0][0];
        this.f5885C1 = iArr[0][1] ^ ((((bArr2[inv_mcol6 & 255] & 255) ^ ((bArr2[(inv_mcol5 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(inv_mcol8 >> 16) & 255] & 255) << 16)) ^ (bArr2[(inv_mcol7 >> 24) & 255] << 24));
        this.f5886C2 = ((((bArr2[inv_mcol7 & 255] & 255) ^ ((bArr2[(inv_mcol6 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(inv_mcol5 >> 16) & 255] & 255) << 16)) ^ (bArr2[(inv_mcol8 >> 24) & 255] << 24)) ^ iArr[0][2];
        this.f5887C3 = iArr[0][3] ^ ((bArr2[(inv_mcol5 >> 24) & 255] << 24) ^ (((bArr2[inv_mcol8 & 255] & 255) ^ ((bArr2[(inv_mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(inv_mcol6 >> 16) & 255] & 255) << 16)));
    }

    private void encryptBlock(int[][] iArr) {
        this.f5884C0 ^= iArr[0][0];
        this.f5885C1 ^= iArr[0][1];
        this.f5886C2 ^= iArr[0][2];
        this.f5887C3 ^= iArr[0][3];
        int i = 1;
        while (i < this.ROUNDS - 1) {
            byte[] bArr = f5879S;
            int mcol = mcol((((bArr[this.f5884C0 & 255] & 255) ^ ((bArr[(this.f5885C1 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5886C2 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5887C3 >> 24) & 255] << 24)) ^ iArr[i][0];
            int mcol2 = mcol((((bArr[this.f5885C1 & 255] & 255) ^ ((bArr[(this.f5886C2 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5887C3 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5884C0 >> 24) & 255] << 24)) ^ iArr[i][1];
            int mcol3 = mcol((((bArr[this.f5886C2 & 255] & 255) ^ ((bArr[(this.f5887C3 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5884C0 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5885C1 >> 24) & 255] << 24)) ^ iArr[i][2];
            int i2 = i + 1;
            int mcol4 = iArr[i][3] ^ mcol((((bArr[this.f5887C3 & 255] & 255) ^ ((bArr[(this.f5884C0 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f5885C1 >> 16) & 255] & 255) << 16)) ^ (bArr[(this.f5886C2 >> 24) & 255] << 24));
            this.f5884C0 = mcol((((bArr[mcol & 255] & 255) ^ ((bArr[(mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr[(mcol3 >> 16) & 255] & 255) << 16)) ^ (bArr[(mcol4 >> 24) & 255] << 24)) ^ iArr[i2][0];
            this.f5885C1 = mcol((((bArr[mcol2 & 255] & 255) ^ ((bArr[(mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr[(mcol4 >> 16) & 255] & 255) << 16)) ^ (bArr[(mcol >> 24) & 255] << 24)) ^ iArr[i2][1];
            this.f5886C2 = mcol((((bArr[mcol3 & 255] & 255) ^ ((bArr[(mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr[(mcol >> 16) & 255] & 255) << 16)) ^ (bArr[(mcol2 >> 24) & 255] << 24)) ^ iArr[i2][2];
            this.f5887C3 = mcol((((bArr[mcol4 & 255] & 255) ^ ((bArr[(mcol >> 8) & 255] & 255) << 8)) ^ ((bArr[(mcol2 >> 16) & 255] & 255) << 16)) ^ (bArr[(mcol3 >> 24) & 255] << 24)) ^ iArr[i2][3];
            i = i2 + 1;
        }
        byte[] bArr2 = f5879S;
        int mcol5 = mcol((((bArr2[this.f5884C0 & 255] & 255) ^ ((bArr2[(this.f5885C1 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5886C2 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5887C3 >> 24) & 255] << 24)) ^ iArr[i][0];
        int mcol6 = mcol((((bArr2[this.f5885C1 & 255] & 255) ^ ((bArr2[(this.f5886C2 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5887C3 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5884C0 >> 24) & 255] << 24)) ^ iArr[i][1];
        int mcol7 = mcol((((bArr2[this.f5886C2 & 255] & 255) ^ ((bArr2[(this.f5887C3 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5884C0 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5885C1 >> 24) & 255] << 24)) ^ iArr[i][2];
        int i3 = i + 1;
        int mcol8 = iArr[i][3] ^ mcol((((bArr2[this.f5887C3 & 255] & 255) ^ ((bArr2[(this.f5884C0 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f5885C1 >> 16) & 255] & 255) << 16)) ^ (bArr2[(this.f5886C2 >> 24) & 255] << 24));
        this.f5884C0 = iArr[i3][0] ^ ((((bArr2[mcol5 & 255] & 255) ^ ((bArr2[(mcol6 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(mcol7 >> 16) & 255] & 255) << 16)) ^ (bArr2[(mcol8 >> 24) & 255] << 24));
        this.f5885C1 = ((((bArr2[mcol6 & 255] & 255) ^ ((bArr2[(mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(mcol8 >> 16) & 255] & 255) << 16)) ^ (bArr2[(mcol5 >> 24) & 255] << 24)) ^ iArr[i3][1];
        this.f5886C2 = ((((bArr2[mcol7 & 255] & 255) ^ ((bArr2[(mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(mcol5 >> 16) & 255] & 255) << 16)) ^ (bArr2[(mcol6 >> 24) & 255] << 24)) ^ iArr[i3][2];
        this.f5887C3 = iArr[i3][3] ^ ((((bArr2[mcol8 & 255] & 255) ^ ((bArr2[(mcol5 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(mcol6 >> 16) & 255] & 255) << 16)) ^ (bArr2[(mcol7 >> 24) & 255] << 24));
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            int i = length + 6;
            this.ROUNDS = i;
            int[][] iArr = (int[][]) Array.newInstance(int.class, i + 1, 4);
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                iArr[i3 >> 2][i3 & 3] = (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | (bArr[i2 + 3] << 24);
                i2 += 4;
                i3++;
            }
            int i4 = (this.ROUNDS + 1) << 2;
            for (int i5 = length; i5 < i4; i5++) {
                int i6 = i5 - 1;
                int i7 = iArr[i6 >> 2][i6 & 3];
                int i8 = i5 % length;
                if (i8 == 0) {
                    i7 = subWord(shift(i7, 8)) ^ rcon[(i5 / length) - 1];
                } else if (length > 6 && i8 == 4) {
                    i7 = subWord(i7);
                }
                int i9 = i5 - length;
                iArr[i5 >> 2][i5 & 3] = i7 ^ iArr[i9 >> 2][i9 & 3];
            }
            if (!z) {
                for (int i10 = 1; i10 < this.ROUNDS; i10++) {
                    for (int i11 = 0; i11 < 4; i11++) {
                        iArr[i10][i11] = inv_mcol(iArr[i10][i11]);
                    }
                }
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    private int inv_mcol(int i) {
        int FFmulX = FFmulX(i);
        int FFmulX2 = FFmulX(FFmulX);
        int FFmulX3 = FFmulX(FFmulX2);
        int i2 = i ^ FFmulX3;
        int shift = shift(FFmulX ^ i2, 8);
        return shift(i2, 24) ^ ((shift ^ (FFmulX3 ^ (FFmulX ^ FFmulX2))) ^ shift(FFmulX2 ^ i2, 16));
    }

    private int mcol(int i) {
        int FFmulX = FFmulX(i);
        return shift(i, 24) ^ ((FFmulX ^ shift(i ^ FFmulX, 8)) ^ shift(i, 16));
    }

    private void packBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.f5884C0;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.f5885C1;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.f5886C2;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.f5887C3;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    private int shift(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private int subWord(int i) {
        byte[] bArr = f5879S;
        return (bArr[(i >> 24) & 255] << 24) | (bArr[i & 255] & 255) | ((bArr[(i >> 8) & 255] & 255) << 8) | ((bArr[(i >> 16) & 255] & 255) << 16);
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.f5884C0 = i3;
        int i4 = i2 + 1;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        this.f5884C0 = i5;
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.f5884C0 = i7;
        int i8 = i6 + 1;
        this.f5884C0 = i7 | (bArr[i6] << 24);
        int i9 = i8 + 1;
        int i10 = bArr[i8] & 255;
        this.f5885C1 = i10;
        int i11 = i9 + 1;
        int i12 = ((bArr[i9] & 255) << 8) | i10;
        this.f5885C1 = i12;
        int i13 = i11 + 1;
        int i14 = i12 | ((bArr[i11] & 255) << 16);
        this.f5885C1 = i14;
        int i15 = i13 + 1;
        this.f5885C1 = i14 | (bArr[i13] << 24);
        int i16 = i15 + 1;
        int i17 = bArr[i15] & 255;
        this.f5886C2 = i17;
        int i18 = i16 + 1;
        int i19 = ((bArr[i16] & 255) << 8) | i17;
        this.f5886C2 = i19;
        int i20 = i18 + 1;
        int i21 = i19 | ((bArr[i18] & 255) << 16);
        this.f5886C2 = i21;
        int i22 = i20 + 1;
        this.f5886C2 = i21 | (bArr[i20] << 24);
        int i23 = i22 + 1;
        int i24 = bArr[i22] & 255;
        this.f5887C3 = i24;
        int i25 = i23 + 1;
        int i26 = ((bArr[i23] & 255) << 8) | i24;
        this.f5887C3 = i26;
        int i27 = i26 | ((bArr[i25] & 255) << 16);
        this.f5887C3 = i27;
        this.f5887C3 = (bArr[i25 + 1] << 24) | i27;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "AES";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException(outline.m256o(cipherParameters, outline.m253r("invalid parameter passed to AES init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.WorkingKey != null) {
            if (i + 16 <= bArr.length) {
                if (i2 + 16 <= bArr2.length) {
                    if (this.forEncryption) {
                        unpackBlock(bArr, i);
                        encryptBlock(this.WorkingKey);
                        packBlock(bArr2, i2);
                        return 16;
                    }
                    unpackBlock(bArr, i);
                    decryptBlock(this.WorkingKey);
                    packBlock(bArr2, i2);
                    return 16;
                }
                throw new DataLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException("AES engine not initialised");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
