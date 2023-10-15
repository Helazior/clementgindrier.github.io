package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class MultiFormatWriter implements Writer {

    /* renamed from: com.google.zxing.MultiFormatWriter$1 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15021 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$BarcodeFormat;

        static {
            BarcodeFormat.values();
            int[] iArr = new int[17];
            $SwitchMap$com$google$zxing$BarcodeFormat = iArr;
            try {
                BarcodeFormat barcodeFormat = BarcodeFormat.EAN_8;
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat2 = BarcodeFormat.EAN_13;
                iArr2[7] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat3 = BarcodeFormat.UPC_A;
                iArr3[14] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat4 = BarcodeFormat.QR_CODE;
                iArr4[11] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat5 = BarcodeFormat.CODE_39;
                iArr5[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat6 = BarcodeFormat.CODE_128;
                iArr6[4] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat7 = BarcodeFormat.ITF;
                iArr7[8] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat8 = BarcodeFormat.PDF_417;
                iArr8[10] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat9 = BarcodeFormat.CODABAR;
                iArr9[1] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat10 = BarcodeFormat.DATA_MATRIX;
                iArr10[5] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$com$google$zxing$BarcodeFormat;
                BarcodeFormat barcodeFormat11 = BarcodeFormat.AZTEC;
                iArr11[0] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Writer eAN8Writer;
        switch (barcodeFormat.ordinal()) {
            case 0:
                eAN8Writer = new AztecWriter();
                break;
            case 1:
                eAN8Writer = new CodaBarWriter();
                break;
            case 2:
                eAN8Writer = new Code39Writer();
                break;
            case 3:
            case 9:
            case 12:
            case 13:
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
            case 4:
                eAN8Writer = new Code128Writer();
                break;
            case 5:
                eAN8Writer = new DataMatrixWriter();
                break;
            case 6:
                eAN8Writer = new EAN8Writer();
                break;
            case 7:
                eAN8Writer = new EAN13Writer();
                break;
            case 8:
                eAN8Writer = new ITFWriter();
                break;
            case 10:
                eAN8Writer = new PDF417Writer();
                break;
            case 11:
                eAN8Writer = new QRCodeWriter();
                break;
            case 14:
                eAN8Writer = new UPCAWriter();
                break;
        }
        return eAN8Writer.encode(str, barcodeFormat, i, i2, map);
    }
}
