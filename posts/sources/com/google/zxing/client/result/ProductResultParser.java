package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ProductResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public ProductParsedResult parse(Result result) {
        BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat == BarcodeFormat.UPC_A || barcodeFormat == BarcodeFormat.UPC_E || barcodeFormat == BarcodeFormat.EAN_8 || barcodeFormat == BarcodeFormat.EAN_13) {
            String massagedText = ResultParser.getMassagedText(result);
            int length = massagedText.length();
            for (int i = 0; i < length; i++) {
                char charAt = massagedText.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
            }
            return new ProductParsedResult(massagedText, barcodeFormat == BarcodeFormat.UPC_E ? UPCEReader.convertUPCEtoUPCA(massagedText) : massagedText);
        }
        return null;
    }
}
