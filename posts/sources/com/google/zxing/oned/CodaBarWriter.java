package com.google.zxing.oned;

import java.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] START_CHARS = {'A', 'B', 'C', 'D'};
    private static final char[] END_CHARS = {'T', 'N', '*', 'E'};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int i;
        char[] cArr = START_CHARS;
        if (CodaBarReader.arrayContains(cArr, Character.toUpperCase(str.charAt(0)))) {
            char[] cArr2 = END_CHARS;
            if (CodaBarReader.arrayContains(cArr2, Character.toUpperCase(str.charAt(str.length() - 1)))) {
                int i2 = 20;
                char[] cArr3 = {'/', ':', '+', '.'};
                for (int i3 = 1; i3 < str.length() - 1; i3++) {
                    if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                        i2 += 9;
                    } else if (!CodaBarReader.arrayContains(cArr3, str.charAt(i3))) {
                        StringBuilder m253r = outline.m253r("Cannot encode : '");
                        m253r.append(str.charAt(i3));
                        m253r.append('\'');
                        throw new IllegalArgumentException(m253r.toString());
                    } else {
                        i2 += 10;
                    }
                }
                boolean[] zArr = new boolean[(str.length() - 1) + i2];
                int i4 = 0;
                for (int i5 = 0; i5 < str.length(); i5++) {
                    char upperCase = Character.toUpperCase(str.charAt(i5));
                    if (i5 == str.length() - 1) {
                        if (upperCase == '*') {
                            upperCase = 'C';
                        } else if (upperCase == 'E') {
                            upperCase = 'D';
                        } else if (upperCase == 'N') {
                            upperCase = 'B';
                        } else if (upperCase == 'T') {
                            upperCase = 'A';
                        }
                    }
                    int i6 = 0;
                    while (true) {
                        char[] cArr4 = CodaBarReader.ALPHABET;
                        if (i6 >= cArr4.length) {
                            i = 0;
                            break;
                        } else if (upperCase == cArr4[i6]) {
                            i = CodaBarReader.CHARACTER_ENCODINGS[i6];
                            break;
                        } else {
                            i6++;
                        }
                    }
                    int i7 = 0;
                    boolean z = true;
                    while (true) {
                        int i8 = 0;
                        while (i7 < 7) {
                            zArr[i4] = z;
                            i4++;
                            if (((i >> (6 - i7)) & 1) == 0 || i8 == 1) {
                                z = !z;
                                i7++;
                            } else {
                                i8++;
                            }
                        }
                        break;
                    }
                    if (i5 < str.length() - 1) {
                        zArr[i4] = false;
                        i4++;
                    }
                }
                return zArr;
            }
            StringBuilder m253r2 = outline.m253r("Codabar should end with one of the following: ");
            m253r2.append(Arrays.toString(cArr2));
            throw new IllegalArgumentException(m253r2.toString());
        }
        StringBuilder m253r3 = outline.m253r("Codabar should start with one of the following: ");
        m253r3.append(Arrays.toString(cArr));
        throw new IllegalArgumentException(m253r3.toString());
    }
}
