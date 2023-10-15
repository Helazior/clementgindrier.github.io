package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.spongycastle.asn1.eac.EACTags;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Encoder {
    private static final int[][] CHAR_MAP;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int[][] LATCH_TABLE;
    private static final int[] NB_BITS;
    private static final int[] NB_BITS_COMPACT;
    private static final int[][] SHIFT_TABLE;
    private static final int TABLE_BINARY = 5;
    private static final int TABLE_DIGIT = 2;
    private static final int TABLE_LOWER = 1;
    private static final int TABLE_MIXED = 3;
    private static final int TABLE_PUNCT = 4;
    private static final int TABLE_UPPER = 0;
    private static final int[] WORD_SIZE;

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, 5, 256);
        CHAR_MAP = iArr;
        SHIFT_TABLE = (int[][]) Array.newInstance(int.class, 6, 6);
        LATCH_TABLE = (int[][]) Array.newInstance(int.class, 6, 6);
        int i = 1;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            CHAR_MAP[0][i2] = (i2 - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            CHAR_MAP[1][i3] = (i3 - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            CHAR_MAP[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr2 = CHAR_MAP;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            CHAR_MAP[3][iArr3[i5]] = i5;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, EACTags.SECURE_MESSAGING_TEMPLATE};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr4[i6] > 0) {
                CHAR_MAP[4][iArr4[i6]] = i6;
            }
        }
        for (int[] iArr5 : SHIFT_TABLE) {
            Arrays.fill(iArr5, -1);
        }
        for (int[] iArr6 : LATCH_TABLE) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = SHIFT_TABLE;
        iArr7[0][4] = 0;
        int[][] iArr8 = LATCH_TABLE;
        iArr8[0][1] = 28;
        iArr8[0][3] = 29;
        iArr8[0][2] = 30;
        iArr7[0][5] = 31;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr8[1][3] = 29;
        iArr8[1][2] = 30;
        iArr7[1][5] = 31;
        iArr7[3][4] = 0;
        iArr8[3][1] = 28;
        iArr8[3][0] = 29;
        iArr8[3][4] = 30;
        iArr7[3][5] = 31;
        iArr8[4][0] = 31;
        iArr7[2][4] = 0;
        iArr8[2][0] = 30;
        iArr7[2][0] = 31;
        NB_BITS_COMPACT = new int[5];
        int i7 = 1;
        while (true) {
            int[] iArr9 = NB_BITS_COMPACT;
            if (i7 >= iArr9.length) {
                break;
            }
            iArr9[i7] = ((i7 * 16) + 88) * i7;
            i7++;
        }
        NB_BITS = new int[33];
        while (true) {
            int[] iArr10 = NB_BITS;
            if (i >= iArr10.length) {
                WORD_SIZE = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
                return;
            } else {
                iArr10[i] = ((i * 16) + 112) * i;
                i++;
            }
        }
    }

    private Encoder() {
    }

    public static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    public static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    public static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = 0;
        if (z) {
            while (i2 < 7) {
                if (bitArray.get(i2)) {
                    int i3 = i / 2;
                    bitMatrix.set((i3 - 3) + i2, i3 - 5);
                }
                if (bitArray.get(i2 + 7)) {
                    int i4 = i / 2;
                    bitMatrix.set(i4 + 5, (i4 - 3) + i2);
                }
                if (bitArray.get(20 - i2)) {
                    int i5 = i / 2;
                    bitMatrix.set((i5 - 3) + i2, i5 + 5);
                }
                if (bitArray.get(27 - i2)) {
                    int i6 = i / 2;
                    bitMatrix.set(i6 - 5, (i6 - 3) + i2);
                }
                i2++;
            }
            return;
        }
        while (i2 < 10) {
            if (bitArray.get(i2)) {
                int i7 = i / 2;
                bitMatrix.set((i2 / 5) + (i7 - 5) + i2, i7 - 7);
            }
            if (bitArray.get(i2 + 10)) {
                int i8 = i / 2;
                bitMatrix.set(i8 + 7, (i2 / 5) + (i8 - 5) + i2);
            }
            if (bitArray.get(29 - i2)) {
                int i9 = i / 2;
                bitMatrix.set((i2 / 5) + (i9 - 5) + i2, i9 + 7);
            }
            if (bitArray.get(39 - i2)) {
                int i10 = i / 2;
                bitMatrix.set(i10 - 7, (i2 / 5) + (i10 - 5) + i2);
            }
            i2++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33);
    }

    public static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int size = ((bitArray.getSize() + i2) - 1) / i2;
        for (int size2 = (size * i2) - bitArray.getSize(); size2 > 0; size2--) {
            bitArray.appendBit(true);
        }
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : bitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    public static GenericGF getGF(int i) {
        if (i != 4) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 10) {
                        if (i != 12) {
                            return null;
                        }
                        return GenericGF.AZTEC_DATA_12;
                    }
                    return GenericGF.AZTEC_DATA_10;
                }
                return GenericGF.AZTEC_DATA_8;
            }
            return GenericGF.AZTEC_DATA_6;
        }
        return GenericGF.AZTEC_PARAM;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b2 A[LOOP:5: B:123:0x01b0->B:124:0x01b2, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.common.BitArray highLevelEncode(byte[] r20) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.Encoder.highLevelEncode(byte[]):com.google.zxing.common.BitArray");
    }

    public static void outputWord(BitArray bitArray, int i, int i2) {
        if (i == 2) {
            bitArray.appendBits(i2, 4);
        } else if (i < 5) {
            bitArray.appendBits(i2, 5);
        } else {
            bitArray.appendBits(i2, 8);
        }
    }

    public static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
            } else {
                bitArray2.appendBits(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }

    public static AztecCode encode(byte[] bArr, int i) {
        int[] iArr;
        boolean z;
        int i2;
        int i3;
        BitArray highLevelEncode = highLevelEncode(bArr);
        int size = ((highLevelEncode.getSize() * i) / 100) + 11;
        int size2 = highLevelEncode.getSize() + size;
        int i4 = 0;
        BitArray bitArray = null;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            iArr = NB_BITS_COMPACT;
            if (i5 >= iArr.length) {
                break;
            }
            if (iArr[i5] >= size2) {
                int[] iArr2 = WORD_SIZE;
                if (i6 != iArr2[i5]) {
                    i6 = iArr2[i5];
                    bitArray = stuffBits(highLevelEncode, i6);
                }
                i7 = iArr[i5];
                if (bitArray.getSize() + size <= iArr[i5]) {
                    break;
                }
            }
            i5++;
        }
        if (i5 == iArr.length) {
            i5 = 1;
            while (true) {
                int[] iArr3 = NB_BITS;
                if (i5 >= iArr3.length) {
                    break;
                }
                if (iArr3[i5] >= size2) {
                    int[] iArr4 = WORD_SIZE;
                    if (i6 != iArr4[i5]) {
                        int i8 = iArr4[i5];
                        i6 = i8;
                        bitArray = stuffBits(highLevelEncode, i8);
                    }
                    i7 = iArr3[i5];
                    if (bitArray.getSize() + size <= iArr3[i5]) {
                        break;
                    }
                }
                i5++;
            }
            z = false;
        } else {
            z = true;
        }
        if (i5 != NB_BITS.length) {
            int size3 = ((bitArray.getSize() + i6) - 1) / i6;
            ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i6));
            int i9 = i7 / i6;
            int[] bitsToWords = bitsToWords(bitArray, i6, i9);
            reedSolomonEncoder.encode(bitsToWords, i9 - size3);
            BitArray bitArray2 = new BitArray();
            bitArray2.appendBits(0, i7 % i6);
            for (int i10 : bitsToWords) {
                bitArray2.appendBits(i10, i6);
            }
            BitArray generateModeMessage = generateModeMessage(z, i5, size3);
            int i11 = z ? (i5 * 4) + 11 : (i5 * 4) + 14;
            int[] iArr5 = new int[i11];
            int i12 = 2;
            if (z) {
                for (int i13 = 0; i13 < i11; i13++) {
                    iArr5[i13] = i13;
                }
                i2 = i11;
            } else {
                int i14 = i11 / 2;
                i2 = (((i14 - 1) / 15) * 2) + i11 + 1;
                int i15 = i2 / 2;
                for (int i16 = 0; i16 < i14; i16++) {
                    iArr5[(i14 - i16) - 1] = (i15 - i3) - 1;
                    iArr5[i14 + i16] = (i16 / 15) + i16 + i15 + 1;
                }
            }
            BitMatrix bitMatrix = new BitMatrix(i2);
            int i17 = 0;
            int i18 = 0;
            while (i17 < i5) {
                int i19 = (i5 - i17) * 4;
                int i20 = z ? i19 + 9 : i19 + 12;
                int i21 = 0;
                while (i21 < i20) {
                    int i22 = i21 * 2;
                    while (i4 < i12) {
                        if (bitArray2.get(i18 + i22 + i4)) {
                            int i23 = i17 * 2;
                            bitMatrix.set(iArr5[i23 + i4], iArr5[i23 + i21]);
                        }
                        if (bitArray2.get((i20 * 2) + i18 + i22 + i4)) {
                            int i24 = i17 * 2;
                            bitMatrix.set(iArr5[i24 + i21], iArr5[((i11 - 1) - i24) - i4]);
                        }
                        if (bitArray2.get((i20 * 4) + i18 + i22 + i4)) {
                            int i25 = (i11 - 1) - (i17 * 2);
                            bitMatrix.set(iArr5[i25 - i4], iArr5[i25 - i21]);
                        }
                        if (bitArray2.get((i20 * 6) + i18 + i22 + i4)) {
                            int i26 = i17 * 2;
                            bitMatrix.set(iArr5[((i11 - 1) - i26) - i21], iArr5[i26 + i4]);
                        }
                        i4++;
                        i12 = 2;
                    }
                    i21++;
                    i4 = 0;
                    i12 = 2;
                }
                i18 += i20 * 8;
                i17++;
                i4 = 0;
                i12 = 2;
            }
            drawModeMessage(bitMatrix, z, i2, generateModeMessage);
            if (z) {
                drawBullsEye(bitMatrix, i2 / 2, 5);
            } else {
                int i27 = i2 / 2;
                drawBullsEye(bitMatrix, i27, 7);
                int i28 = 0;
                int i29 = 0;
                while (i28 < (i11 / 2) - 1) {
                    for (int i30 = i27 & 1; i30 < i2; i30 += 2) {
                        int i31 = i27 - i29;
                        bitMatrix.set(i31, i30);
                        int i32 = i27 + i29;
                        bitMatrix.set(i32, i30);
                        bitMatrix.set(i30, i31);
                        bitMatrix.set(i30, i32);
                    }
                    i28 += 15;
                    i29 += 16;
                }
            }
            AztecCode aztecCode = new AztecCode();
            aztecCode.setCompact(z);
            aztecCode.setSize(i2);
            aztecCode.setLayers(i5);
            aztecCode.setCodeWords(size3);
            aztecCode.setMatrix(bitMatrix);
            return aztecCode;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
    }
}
