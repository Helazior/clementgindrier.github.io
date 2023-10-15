package com.google.zxing.aztec.decoder;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.material.badge.BadgeDrawable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import org.kxml2.wap.Wbxml;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Decoder {
    private int codewordSize;
    private AztecDetectorResult ddata;
    private int invertedBitCount;
    private int numCodewords;
    private static final int[] NB_BITS_COMPACT = {0, 104, 240, 408, 608};
    private static final int[] NB_BITS = {0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 8640, 9408, 10208, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 17760, 18848, 19968};
    private static final int[] NB_DATABLOCK_COMPACT = {0, 17, 40, 51, 76};
    private static final int[] NB_DATABLOCK = {0, 21, 48, 60, 88, 120, 156, Wbxml.LITERAL_AC, 240, 230, 272, 316, 364, 416, 470, 528, 588, 652, 720, 790, 864, 940, 1020, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", "f", "g", "h", "i", "j", "k", "l", "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", CrashlyticsReportDataCapture.SIGNAL_DEFAULT, "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15031 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        static {
            Table.values();
            int[] iArr = new int[6];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                Table table = Table.UPPER;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;
                Table table2 = Table.LOWER;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;
                Table table3 = Table.MIXED;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;
                Table table4 = Table.PUNCT;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;
                Table table5 = Table.DIGIT;
                iArr5[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f0, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean[] correctBits(boolean[] r14) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.correctBits(boolean[]):boolean[]");
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean[] zArr;
        int i;
        if (this.ddata.isCompact()) {
            int nbLayers = this.ddata.getNbLayers();
            int[] iArr = NB_BITS_COMPACT;
            if (nbLayers <= iArr.length) {
                zArr = new boolean[iArr[this.ddata.getNbLayers()]];
                this.numCodewords = NB_DATABLOCK_COMPACT[this.ddata.getNbLayers()];
            } else {
                throw FormatException.getFormatInstance();
            }
        } else {
            int nbLayers2 = this.ddata.getNbLayers();
            int[] iArr2 = NB_BITS;
            if (nbLayers2 <= iArr2.length) {
                zArr = new boolean[iArr2[this.ddata.getNbLayers()]];
                this.numCodewords = NB_DATABLOCK[this.ddata.getNbLayers()];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        int nbLayers3 = this.ddata.getNbLayers();
        int height = bitMatrix.getHeight();
        int i2 = 0;
        int i3 = 0;
        while (nbLayers3 != 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = height * 2;
                if (i4 >= i - 4) {
                    break;
                }
                int i6 = (i4 / 2) + i3;
                zArr[i2 + i4] = bitMatrix.get(i3 + i5, i6);
                zArr[((i + i2) - 4) + i4] = bitMatrix.get(i6, ((i3 + height) - 1) - i5);
                i5 = (i5 + 1) % 2;
                i4++;
            }
            int i7 = 0;
            for (int i8 = i + 1; i8 > 5; i8--) {
                int i9 = i - i8;
                int i10 = ((i8 / 2) + i3) - 1;
                zArr[(((height * 4) + i2) - 8) + i9 + 1] = bitMatrix.get(((i3 + height) - 1) - i7, i10);
                zArr[(((height * 6) + i2) - 12) + i9 + 1] = bitMatrix.get(i10, i3 + i7);
                i7 = (i7 + 1) % 2;
            }
            i3 += 2;
            i2 += (height * 8) - 16;
            nbLayers3--;
            height -= 4;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i) {
        int ordinal = table.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        return ordinal != 4 ? "" : PUNCT_TABLE[i];
                    }
                    return DIGIT_TABLE[i];
                }
                return MIXED_TABLE[i];
            }
            return LOWER_TABLE[i];
        }
        return UPPER_TABLE[i];
    }

    private String getEncodedData(boolean[] zArr) {
        int nbDatablocks = (this.ddata.getNbDatablocks() * this.codewordSize) - this.invertedBitCount;
        if (nbDatablocks <= zArr.length) {
            Table table = Table.UPPER;
            StringBuilder sb = new StringBuilder(20);
            Table table2 = table;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            loop0: while (true) {
                boolean z4 = false;
                while (!z) {
                    if (z2) {
                        z4 = true;
                    } else {
                        table2 = table;
                    }
                    if (!z3) {
                        if (table != Table.BINARY) {
                            int i2 = table == Table.DIGIT ? 4 : 5;
                            if (nbDatablocks - i >= i2) {
                                int readCode = readCode(zArr, i, i2);
                                i += i2;
                                String character = getCharacter(table, readCode);
                                if (character.startsWith("CTRL_")) {
                                    table = getTable(character.charAt(5));
                                    if (character.charAt(6) != 'S') {
                                        continue;
                                    } else if (character.charAt(5) == 'B') {
                                        z2 = true;
                                        z3 = true;
                                        continue;
                                    } else {
                                        z2 = true;
                                        continue;
                                    }
                                } else {
                                    sb.append(character);
                                    continue;
                                }
                                if (z4) {
                                    break;
                                }
                            } else {
                                break loop0;
                            }
                        } else if (nbDatablocks - i >= 8) {
                            int readCode2 = readCode(zArr, i, 8);
                            i += 8;
                            sb.append((char) readCode2);
                            continue;
                            if (z4) {
                                break;
                            }
                        } else {
                            break loop0;
                        }
                    } else if (nbDatablocks - i >= 5) {
                        int readCode3 = readCode(zArr, i, 5);
                        i += 5;
                        if (readCode3 == 0) {
                            if (nbDatablocks - i < 11) {
                                break loop0;
                            }
                            readCode3 = readCode(zArr, i, 11) + 31;
                            i += 11;
                        }
                        int i3 = 0;
                        while (true) {
                            if (i3 >= readCode3) {
                                break;
                            } else if (nbDatablocks - i < 8) {
                                z = true;
                                break;
                            } else {
                                sb.append((char) readCode(zArr, i, 8));
                                i += 8;
                                i3++;
                            }
                        }
                        z3 = false;
                        continue;
                        if (z4) {
                            break;
                        }
                    } else {
                        break loop0;
                    }
                }
                table = table2;
                z2 = false;
            }
            return sb.toString();
        }
        throw FormatException.getFormatInstance();
    }

    private static Table getTable(char c) {
        if (c != 'B') {
            if (c != 'D') {
                if (c != 'P') {
                    if (c != 'L') {
                        if (c != 'M') {
                            return Table.UPPER;
                        }
                        return Table.MIXED;
                    }
                    return Table.LOWER;
                }
                return Table.PUNCT;
            }
            return Table.DIGIT;
        }
        return Table.BINARY;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3++;
            }
        }
        return i3;
    }

    private static BitMatrix removeDashedLines(BitMatrix bitMatrix) {
        int width = ((((bitMatrix.getWidth() - 1) / 2) / 16) * 2) + 1;
        BitMatrix bitMatrix2 = new BitMatrix(bitMatrix.getWidth() - width, bitMatrix.getHeight() - width);
        int i = 0;
        for (int i2 = 0; i2 < bitMatrix.getWidth(); i2++) {
            if (((bitMatrix.getWidth() / 2) - i2) % 16 != 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < bitMatrix.getHeight(); i4++) {
                    if (((bitMatrix.getWidth() / 2) - i4) % 16 != 0) {
                        if (bitMatrix.get(i2, i4)) {
                            bitMatrix2.set(i, i3);
                        }
                        i3++;
                    }
                }
                i++;
            }
        }
        return bitMatrix2;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) {
        this.ddata = aztecDetectorResult;
        BitMatrix bits = aztecDetectorResult.getBits();
        if (!this.ddata.isCompact()) {
            bits = removeDashedLines(this.ddata.getBits());
        }
        return new DecoderResult(null, getEncodedData(correctBits(extractBits(bits))), null, null);
    }
}
