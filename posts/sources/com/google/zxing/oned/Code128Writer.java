package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    private static boolean isDigits(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int length = charSequence.length();
        while (i < i3 && i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != 241) {
                    return false;
                }
                i3++;
            }
            i++;
        }
        return i3 <= length;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i3 < length) {
                int i7 = 100;
                int i8 = isDigits(str, i3, i5 == 99 ? 2 : 4) ? 99 : 100;
                if (i8 == i5) {
                    if (i5 != 100) {
                        switch (str.charAt(i3)) {
                            case 241:
                                i7 = 102;
                                break;
                            case 242:
                                i7 = 97;
                                break;
                            case 243:
                                i7 = 96;
                                break;
                            case 244:
                                break;
                            default:
                                int i9 = i3 + 2;
                                i7 = Integer.parseInt(str.substring(i3, i9));
                                i3 = i9;
                                break;
                        }
                    } else {
                        i7 = str.charAt(i3) - ' ';
                    }
                    i3++;
                } else {
                    i7 = i5 == 0 ? i8 == 100 ? 104 : 105 : i8;
                    i5 = i8;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i7]);
                i4 += i7 * i6;
                if (i3 != 0) {
                    i6++;
                }
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            arrayList.add(iArr[i4 % 103]);
            arrayList.add(iArr[106]);
            Iterator it = arrayList.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                for (int i11 : (int[]) it.next()) {
                    i10 += i11;
                }
            }
            boolean[] zArr = new boolean[i10];
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i += OneDimensionalCodeWriter.appendPattern(zArr, i, (int[]) it2.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException(outline.m273H("Contents length should be between 1 and 80 characters, but got ", length));
    }
}
