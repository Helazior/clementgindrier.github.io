package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.crypto.util.Pack;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class GCMUtil {
    public static int[] asInts(byte[] bArr) {
        return new int[]{Pack.bigEndianToInt(bArr, 0), Pack.bigEndianToInt(bArr, 4), Pack.bigEndianToInt(bArr, 8), Pack.bigEndianToInt(bArr, 12)};
    }

    public static void multiply(byte[] bArr, byte[] bArr2) {
        byte[] clone = Arrays.clone(bArr);
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = bArr2[i];
            for (int i2 = 7; i2 >= 0; i2--) {
                if (((1 << i2) & b) != 0) {
                    xor(bArr3, clone);
                }
                boolean z = (clone[15] & 1) != 0;
                shiftRight(clone);
                if (z) {
                    clone[0] = (byte) (clone[0] ^ (-31));
                }
            }
        }
        System.arraycopy(bArr3, 0, bArr, 0, 16);
    }

    public static void multiplyP(int[] iArr) {
        boolean z = (iArr[3] & 1) != 0;
        shiftRight(iArr);
        if (z) {
            iArr[0] = iArr[0] ^ (-520093696);
        }
    }

    public static void multiplyP8(int[] iArr) {
        int i = iArr[3];
        shiftRightN(iArr, 8);
        for (int i2 = 7; i2 >= 0; i2--) {
            if (((1 << i2) & i) != 0) {
                iArr[0] = iArr[0] ^ ((-520093696) >>> (7 - i2));
            }
        }
    }

    public static byte[] oneAsBytes() {
        byte[] bArr = new byte[16];
        bArr[0] = Byte.MIN_VALUE;
        return bArr;
    }

    public static int[] oneAsInts() {
        int[] iArr = new int[4];
        iArr[0] = Integer.MIN_VALUE;
        return iArr;
    }

    public static void shiftRight(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = bArr[i] & 255;
            bArr[i] = (byte) (i2 | (i3 >>> 1));
            i++;
            if (i == 16) {
                return;
            }
            i2 = (i3 & 1) << 7;
        }
    }

    public static void shiftRightN(int[] iArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = iArr[i2];
            iArr[i2] = i3 | (i4 >>> i);
            i2++;
            if (i2 == 4) {
                return;
            }
            i3 = i4 << (32 - i);
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 15; i >= 0; i--) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public static void xor(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            iArr[i] = iArr[i] ^ iArr2[i];
        }
    }

    public static void shiftRight(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = iArr[i];
            iArr[i] = i2 | (i3 >>> 1);
            i++;
            if (i == 4) {
                return;
            }
            i2 = i3 << 31;
        }
    }
}
