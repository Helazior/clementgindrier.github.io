package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.oned.rss.expanded.decoders.DecodedChar;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DecodedBitStreamParser {

    /* renamed from: AL */
    private static final int f3907AL = 28;

    /* renamed from: AS */
    private static final int f3908AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final BigInteger[] EXP900;

    /* renamed from: LL */
    private static final int f3909LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;

    /* renamed from: ML */
    private static final int f3910ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;

    /* renamed from: PL */
    private static final int f3911PL = 25;

    /* renamed from: PS */
    private static final int f3912PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = {';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', '.', DecodedChar.FNC1, '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '\r', '\t', ',', ':', '#', '-', '.', DecodedChar.FNC1, '/', '+', '%', '*', '=', '^'};

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15081 {

        /* renamed from: $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode */
        public static final /* synthetic */ int[] f3913x45bba1d;

        static {
            Mode.values();
            int[] iArr = new int[6];
            f3913x45bba1d = iArr;
            try {
                Mode mode = Mode.ALPHA;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3913x45bba1d;
                Mode mode2 = Mode.LOWER;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f3913x45bba1d;
                Mode mode3 = Mode.MIXED;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f3913x45bba1d;
                Mode mode4 = Mode.PUNCT;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f3913x45bba1d;
                Mode mode5 = Mode.ALPHA_SHIFT;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f3913x45bba1d;
                Mode mode6 = Mode.PUNCT_SHIFT;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
            i++;
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i, int[] iArr, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5 = MACRO_PDF417_TERMINATOR;
        int i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        long j = 900;
        int i7 = 6;
        if (i != BYTE_COMPACTION_MODE_LATCH) {
            if (i == BYTE_COMPACTION_MODE_LATCH_6) {
                int i8 = i2;
                boolean z = false;
                int i9 = 0;
                long j2 = 0;
                while (i8 < iArr[0] && !z) {
                    int i10 = i8 + 1;
                    int i11 = iArr[i8];
                    if (i11 < TEXT_COMPACTION_MODE_LATCH) {
                        i9++;
                        j2 = (j2 * 900) + i11;
                    } else if (i11 == TEXT_COMPACTION_MODE_LATCH || i11 == BYTE_COMPACTION_MODE_LATCH || i11 == NUMERIC_COMPACTION_MODE_LATCH || i11 == BYTE_COMPACTION_MODE_LATCH_6 || i11 == 928 || i11 == i6 || i11 == i5) {
                        i8 = i10 - 1;
                        z = true;
                        if (i9 % 5 != 0 && i9 > 0) {
                            char[] cArr = new char[6];
                            for (int i12 = 0; i12 < 6; i12++) {
                                cArr[5 - i12] = (char) (j2 & 255);
                                j2 >>= 8;
                            }
                            sb.append(cArr);
                            i9 = 0;
                        }
                        i5 = MACRO_PDF417_TERMINATOR;
                        i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    }
                    i8 = i10;
                    if (i9 % 5 != 0) {
                    }
                    i5 = MACRO_PDF417_TERMINATOR;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                }
                return i8;
            }
            return i2;
        }
        char[] cArr2 = new char[6];
        int[] iArr2 = new int[6];
        int i13 = i2 + 1;
        int i14 = iArr[i2];
        long j3 = 0;
        boolean z2 = false;
        loop0: while (true) {
            i3 = 0;
            while (i13 < iArr[0] && !z2) {
                int i15 = i3 + 1;
                iArr2[i3] = i14;
                j3 = (j3 * j) + i14;
                int i16 = i13 + 1;
                i14 = iArr[i13];
                if (i14 == TEXT_COMPACTION_MODE_LATCH || i14 == BYTE_COMPACTION_MODE_LATCH || i14 == NUMERIC_COMPACTION_MODE_LATCH || i14 == BYTE_COMPACTION_MODE_LATCH_6 || i14 == 928 || i14 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i14 == MACRO_PDF417_TERMINATOR) {
                    i13 = i16 - 1;
                    i14 = i14;
                    i3 = i15;
                    j = 900;
                    i7 = 6;
                    z2 = true;
                } else if (i15 % 5 != 0 || i15 <= 0) {
                    i14 = i14;
                    i3 = i15;
                    i13 = i16;
                    j = 900;
                    i7 = 6;
                } else {
                    int i17 = 0;
                    while (i17 < i7) {
                        cArr2[5 - i17] = (char) (j3 % 256);
                        j3 >>= 8;
                        i17++;
                        i14 = i14;
                        i7 = 6;
                    }
                    sb.append(cArr2);
                    i13 = i16;
                    j = 900;
                    i7 = 6;
                }
            }
        }
        if (i13 != iArr[0] || i14 >= TEXT_COMPACTION_MODE_LATCH) {
            i4 = i3;
        } else {
            i4 = i3 + 1;
            iArr2[i3] = i14;
        }
        for (int i18 = 0; i18 < i4; i18++) {
            sb.append((char) iArr2[i18]);
        }
        return i13;
    }

    public static DecoderResult decode(int[] iArr, String str) {
        int byteCompaction;
        int i = 2;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (i < iArr[0]) {
            if (i2 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                byteCompaction = byteCompaction(i2, iArr, i, sb);
            } else if (i2 == BYTE_COMPACTION_MODE_LATCH_6) {
                byteCompaction = byteCompaction(i2, iArr, i, sb);
            } else if (i2 != 928) {
                switch (i2) {
                    case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                        byteCompaction = textCompaction(iArr, i, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        byteCompaction = byteCompaction(i2, iArr, i, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                        byteCompaction = numericCompaction(iArr, i, sb);
                        break;
                    default:
                        byteCompaction = textCompaction(iArr, i - 1, sb);
                        break;
                }
            } else {
                byteCompaction = decodeMacroBlock(iArr, i, pDF417ResultMetadata);
            }
            if (byteCompaction < iArr.length) {
                i = byteCompaction + 1;
                i2 = iArr[byteCompaction];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    private static String decodeBase900toBase10(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = 0;
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int i3 = textCompaction + 1;
                int[] iArr3 = new int[iArr[0] - i3];
                boolean z = false;
                int i4 = 0;
                while (i3 < iArr[0] && !z) {
                    int i5 = i3 + 1;
                    int i6 = iArr[i3];
                    if (i6 < TEXT_COMPACTION_MODE_LATCH) {
                        iArr3[i4] = i6;
                        i3 = i5;
                        i4++;
                    } else if (i6 == MACRO_PDF417_TERMINATOR) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i3 = i5 + 1;
                        z = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i4));
                return i3;
            } else if (iArr[textCompaction] == MACRO_PDF417_TERMINATOR) {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            } else {
                return textCompaction;
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        int i2;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            int ordinal = mode2.ordinal();
            char c = ' ';
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal != 4) {
                                if (ordinal == 5) {
                                    if (i4 < 29) {
                                        c = PUNCT_CHARS[i4];
                                        mode2 = mode3;
                                    } else if (i4 == 29) {
                                        mode2 = Mode.ALPHA;
                                    } else {
                                        if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                            sb.append((char) iArr2[i3]);
                                        } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                            mode2 = Mode.ALPHA;
                                        }
                                        mode2 = mode3;
                                    }
                                }
                                c = 0;
                            } else {
                                if (i4 < 26) {
                                    c = (char) (i4 + 65);
                                } else if (i4 != 26) {
                                    if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                        mode2 = Mode.ALPHA;
                                        c = 0;
                                    }
                                    mode2 = mode3;
                                    c = 0;
                                }
                                mode2 = mode3;
                            }
                        } else if (i4 < 29) {
                            c = PUNCT_CHARS[i4];
                        } else {
                            if (i4 == 29) {
                                mode2 = Mode.ALPHA;
                            } else if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                mode2 = Mode.ALPHA;
                            }
                            c = 0;
                        }
                    } else if (i4 < 25) {
                        c = MIXED_CHARS[i4];
                    } else {
                        if (i4 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i4 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c = 0;
                                Mode mode4 = mode;
                                mode3 = mode2;
                                mode2 = mode4;
                            } else if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c = 0;
                    }
                } else if (i4 < 26) {
                    i2 = i4 + 97;
                    c = (char) i2;
                } else if (i4 != 26) {
                    if (i4 == 27) {
                        mode = Mode.ALPHA_SHIFT;
                    } else {
                        if (i4 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i4 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                        } else if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                    }
                    c = 0;
                    Mode mode42 = mode;
                    mode3 = mode2;
                    mode2 = mode42;
                }
            } else if (i4 < 26) {
                i2 = i4 + 65;
                c = (char) i2;
            } else if (i4 != 26) {
                if (i4 == 27) {
                    mode2 = Mode.LOWER;
                } else if (i4 == 28) {
                    mode2 = Mode.MIXED;
                } else if (i4 == 29) {
                    mode = Mode.PUNCT_SHIFT;
                    c = 0;
                    Mode mode422 = mode;
                    mode3 = mode2;
                    mode2 = mode422;
                } else if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                    sb.append((char) iArr2[i3]);
                } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                    mode2 = Mode.ALPHA;
                }
                c = 0;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                i3--;
                z = true;
            }
            if (i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                            iArr2[i2] = TEXT_COMPACTION_MODE_LATCH;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                            break;
                        default:
                            switch (i4) {
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }
}
