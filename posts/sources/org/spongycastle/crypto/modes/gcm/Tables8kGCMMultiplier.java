package org.spongycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.spongycastle.crypto.util.Pack;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Tables8kGCMMultiplier implements GCMMultiplier {

    /* renamed from: M */
    private final int[][][] f5990M = (int[][][]) Array.newInstance(int[].class, 32, 16);

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        int[][][] iArr = this.f5990M;
        iArr[0][0] = new int[4];
        iArr[1][0] = new int[4];
        iArr[1][8] = GCMUtil.asInts(bArr);
        for (int i = 4; i >= 1; i >>= 1) {
            int[] iArr2 = new int[4];
            System.arraycopy(this.f5990M[1][i + i], 0, iArr2, 0, 4);
            GCMUtil.multiplyP(iArr2);
            this.f5990M[1][i] = iArr2;
        }
        int[] iArr3 = new int[4];
        System.arraycopy(this.f5990M[1][1], 0, iArr3, 0, 4);
        GCMUtil.multiplyP(iArr3);
        this.f5990M[0][8] = iArr3;
        for (int i2 = 4; i2 >= 1; i2 >>= 1) {
            int[] iArr4 = new int[4];
            System.arraycopy(this.f5990M[0][i2 + i2], 0, iArr4, 0, 4);
            GCMUtil.multiplyP(iArr4);
            this.f5990M[0][i2] = iArr4;
        }
        int i3 = 0;
        while (true) {
            for (int i4 = 2; i4 < 16; i4 += i4) {
                for (int i5 = 1; i5 < i4; i5++) {
                    int[] iArr5 = new int[4];
                    System.arraycopy(this.f5990M[i3][i4], 0, iArr5, 0, 4);
                    GCMUtil.xor(iArr5, this.f5990M[i3][i5]);
                    this.f5990M[i3][i4 + i5] = iArr5;
                }
            }
            i3++;
            if (i3 == 32) {
                return;
            }
            if (i3 > 1) {
                this.f5990M[i3][0] = new int[4];
                for (int i6 = 8; i6 > 0; i6 >>= 1) {
                    int[] iArr6 = new int[4];
                    System.arraycopy(this.f5990M[i3 - 2][i6], 0, iArr6, 0, 4);
                    GCMUtil.multiplyP8(iArr6);
                    this.f5990M[i3][i6] = iArr6;
                }
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i = 15; i >= 0; i--) {
            int[][][] iArr2 = this.f5990M;
            int i2 = i + i;
            int[] iArr3 = iArr2[i2][bArr[i] & 15];
            iArr[0] = iArr[0] ^ iArr3[0];
            iArr[1] = iArr[1] ^ iArr3[1];
            iArr[2] = iArr[2] ^ iArr3[2];
            iArr[3] = iArr3[3] ^ iArr[3];
            int[] iArr4 = iArr2[i2 + 1][(bArr[i] & 240) >>> 4];
            iArr[0] = iArr[0] ^ iArr4[0];
            iArr[1] = iArr[1] ^ iArr4[1];
            iArr[2] = iArr[2] ^ iArr4[2];
            iArr[3] = iArr[3] ^ iArr4[3];
        }
        Pack.intToBigEndian(iArr, bArr, 0);
    }
}
