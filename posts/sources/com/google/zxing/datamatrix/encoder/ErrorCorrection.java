package com.google.zxing.datamatrix.encoder;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import org.kxml2.wap.Wbxml;
import org.spongycastle.asn1.x509.DisplayText;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, 205, 12, Wbxml.EXT_2, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, 45, 18, 186, 83, 185}, new int[]{83, Wbxml.OPAQUE, 100, 39, 188, 75, 66, 61, 241, 213, 109, Wbxml.EXT_T_1, 94, 254, 225, 48, 90, 188}, new int[]{15, Wbxml.OPAQUE, 244, 9, 233, 71, 168, 2, 188, 160, 153, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, Wbxml.EXT_1}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, 110, 213, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, Wbxml.EXT_T_2, BaseTransientBottomBar.ANIMATION_DURATION, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, Wbxml.EXT_1, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, Wbxml.LITERAL_A, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 118, 23, 37, 90, 170, 205, Wbxml.STR_T, 88, 120, 100, 66, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, 186, 240, 82, 44, 176, 87, 187, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 160, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 69, 213, 92, 253, 225, 19}, new int[]{HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 9, 223, 238, 12, 17, 220, 208, 100, 29, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, Wbxml.LITERAL_A, 54, 228, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 218, 234, 117, 203, 29, 232, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 46}, new int[]{242, 93, 169, 50, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 210, 39, 118, 202, 188, 201, 189, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 108, Wbxml.LITERAL_AC, 37, 185, 112, 134, 230, 245, 63, 197, 190, BaseTransientBottomBar.ANIMATION_DURATION, 106, 185, 221, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 64, 114, 71, 161, 44, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 6, 27, 218, 51, 63, 87, 10, 40, Wbxml.EXT_T_2, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 159, 56, 89, 33, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, Wbxml.LITERAL_A, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= MODULO_VALUE;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        int length = str.length();
        int i = symbolInfo.dataCapacity;
        if (length == i) {
            StringBuilder sb = new StringBuilder(i + symbolInfo.errorCodewords);
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.errorCodewords));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i2 = 0;
                while (i2 < interleavedBlockCount) {
                    int i3 = i2 + 1;
                    iArr[i2] = symbolInfo.getDataLengthForInterleavedBlock(i3);
                    iArr2[i2] = symbolInfo.getErrorLengthForInterleavedBlock(i3);
                    iArr3[i2] = 0;
                    if (i2 > 0) {
                        iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                    }
                    i2 = i3;
                }
                for (int i4 = 0; i4 < interleavedBlockCount; i4++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i4]);
                    for (int i5 = i4; i5 < symbolInfo.dataCapacity; i5 += interleavedBlockCount) {
                        sb2.append(str.charAt(i5));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i4]);
                    int i6 = i4;
                    int i7 = 0;
                    while (i6 < iArr2[i4] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.dataCapacity + i6, createECCBlock.charAt(i7));
                        i6 += interleavedBlockCount;
                        i7++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int[] iArr2 = FACTORS[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                int charAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (charAt != 0 && iArr2[i7] != 0) {
                        char c = cArr[i7 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                    } else {
                        cArr[i7] = cArr[i7 - 1];
                    }
                    i7--;
                }
                if (charAt != 0 && iArr2[0] != 0) {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException(outline.m273H("Illegal number of error correction codewords specified: ", i3));
    }
}
