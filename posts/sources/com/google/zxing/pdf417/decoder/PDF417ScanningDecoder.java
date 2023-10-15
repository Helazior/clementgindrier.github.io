package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.p004ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) {
        if (detectionResultRowIndicatorColumn == null) {
            return null;
        }
        int[] rowHeights = detectionResultRowIndicatorColumn.getRowHeights();
        int max = getMax(rowHeights);
        int i = 0;
        int i2 = 0;
        for (int i3 : rowHeights) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i4 = 0; i2 > 0 && codewords[i4] == null; i4++) {
            i2--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i > 0 && codewords[length2] == null; length2--) {
            i--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i2, i, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeRowCount = (detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeRowCount) {
                barcodeValueArr[0][1].setValue(barcodeRowCount);
            }
        } else if (barcodeRowCount >= 1 && barcodeRowCount <= 928) {
            barcodeValueArr[0][1].setValue(barcodeRowCount);
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (((z && i6 >= i) || (!z && i6 < i2)) && z == bitMatrix.get(i6, i4)) {
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        DetectionResultColumn[] detectionResultColumns;
        Codeword[] codewords;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (int i = 0; i < barcodeValueArr.length; i++) {
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                barcodeValueArr[i][i2] = new BarcodeValue();
            }
        }
        int i3 = -1;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            i3++;
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && codeword.getRowNumber() != -1) {
                        barcodeValueArr[codeword.getRowNumber()][i3].setValue(codeword.getValue());
                    }
                }
            }
        }
        return barcodeValueArr;
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); i++) {
            int i2 = 0;
            while (i2 < detectionResult.getBarcodeColumnCount()) {
                int i3 = i2 + 1;
                int[] value = createBarcodeMatrix[i][i3].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i) + i2;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return decodeCodewords(iArr, i, iArr2);
                } catch (ChecksumException unused) {
                    if (length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        } else if (iArr5[i5] < iArr4[i5].length - 1) {
                            iArr5[i5] = iArr5[i5] + 1;
                            break;
                        } else {
                            iArr5[i5] = 0;
                            if (i5 == length - 1) {
                                throw ChecksumException.getChecksumInstance();
                            }
                            i5++;
                        }
                    }
                    i2 = i3;
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        DetectionResultColumn detectionResultRowIndicatorColumn;
        int i3;
        int i4;
        int i5;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
        DetectionResult detectionResult = null;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        for (int i6 = 0; i6 < 2; i6++) {
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, i2);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, i2);
            }
            detectionResult = merge(detectionResultRowIndicatorColumn2, detectionResultRowIndicatorColumn3);
            if (detectionResult != null) {
                if (i6 == 0 && (detectionResult.getBoundingBox().getMinY() < boundingBox.getMinY() || detectionResult.getBoundingBox().getMaxY() > boundingBox.getMaxY())) {
                    boundingBox = detectionResult.getBoundingBox();
                } else {
                    detectionResult.setBoundingBox(boundingBox);
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn2);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn3);
        boolean z = detectionResultRowIndicatorColumn2 != null;
        int i7 = i;
        int i8 = i2;
        for (int i9 = 1; i9 <= barcodeColumnCount; i9++) {
            int i10 = z ? i9 : barcodeColumnCount - i9;
            if (detectionResult.getDetectionResultColumn(i10) == null) {
                if (i10 != 0 && i10 != barcodeColumnCount) {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                } else {
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, i10 == 0);
                }
                detectionResult.setDetectionResultColumn(i10, detectionResultRowIndicatorColumn);
                int i11 = -1;
                int minY = boundingBox.getMinY();
                int i12 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i10, minY, z);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i3 = startColumn;
                    } else if (i12 == i11) {
                        i4 = i12;
                        i5 = minY;
                        i12 = i4;
                        minY = i5 + 1;
                        i11 = -1;
                    } else {
                        i3 = i12;
                    }
                    i4 = i12;
                    int i13 = minY;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, i3, i13, i7, i8);
                    i5 = i13;
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(i5, detectCodeword);
                        i7 = Math.min(i7, detectCodeword.getWidth());
                        i8 = Math.max(i8, detectCodeword.getWidth());
                        i12 = i3;
                        minY = i5 + 1;
                        i11 = -1;
                    }
                    i12 = i4;
                    minY = i5 + 1;
                    i11 = -1;
                }
            }
        }
        return createDecoderResult(detectionResult);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int correctErrors = correctErrors(iArr, iArr2, i2);
            verifyCodewordCount(iArr, i2);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, adjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int bitCountSum = PDF417Common.getBitCountSum(moduleBitCount);
        if (z) {
            i7 = adjustCodewordStartColumn + bitCountSum;
        } else {
            for (int i8 = 0; i8 < (moduleBitCount.length >> 1); i8++) {
                int i9 = moduleBitCount[i8];
                moduleBitCount[i8] = moduleBitCount[(moduleBitCount.length - 1) - i8];
                moduleBitCount[(moduleBitCount.length - 1) - i8] = i9;
            }
            adjustCodewordStartColumn -= bitCountSum;
            i7 = adjustCodewordStartColumn;
        }
        if (checkCodewordSkew(bitCountSum, i5, i6)) {
            int decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount);
            int codeword = PDF417Common.getCodeword(decodedValue);
            if (codeword == -1) {
                return null;
            }
            return new Codeword(adjustCodewordStartColumn, i7, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        if (detectionResultRowIndicatorColumn == null || detectionResultRowIndicatorColumn.getBarcodeMetadata() == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        } else if (detectionResultRowIndicatorColumn2 != null && detectionResultRowIndicatorColumn2.getBarcodeMetadata() != null) {
            BarcodeMetadata barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata();
            BarcodeMetadata barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
            if (barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
                return barcodeMetadata;
            }
            return null;
        } else {
            return detectionResultRowIndicatorColumn.getBarcodeMetadata();
        }
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getMax(int[] iArr) {
        int i = -1;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (r10 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r11 == r9) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r10 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r11 != r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
        if (r4 != 7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] getModuleBitCount(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L10
            if (r11 < r9) goto L14
        L10:
            if (r10 != 0) goto L28
            if (r11 < r8) goto L28
        L14:
            if (r4 >= r0) goto L28
            boolean r6 = r7.get(r11, r12)
            if (r6 != r5) goto L23
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L23:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L28:
            if (r4 == r0) goto L38
            if (r10 == 0) goto L2e
            if (r11 == r9) goto L32
        L2e:
            if (r10 != 0) goto L36
            if (r11 != r8) goto L36
        L32:
            r7 = 7
            if (r4 != r7) goto L36
            goto L38
        L36:
            r7 = 0
            return r7
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.getModuleBitCount(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int[]");
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        int endX;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            for (int y = (int) resultPoint.getY(); y <= boundingBox.getMaxY() && y >= boundingBox.getMinY(); y += i4) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    if (z) {
                        endX = detectCodeword.getStartX();
                    } else {
                        endX = detectCodeword.getEndX();
                    }
                    x = endX;
                }
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        Codeword[] codewords;
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        Codeword codeword = isValidBarcodeColumn(detectionResult, i4) ? detectionResult.getDetectionResultColumn(i4).getCodeword(i2) : null;
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (isValidBarcodeColumn(detectionResult, i)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                    if (codeword2 != null) {
                        return ((codeword2.getEndX() - codeword2.getStartX()) * i3 * i5) + (z ? codeword2.getEndX() : codeword2.getStartX());
                    }
                }
                i5++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < barcodeValueArr.length; i++) {
            formatter.format("Row %2d: ", Integer.valueOf(i));
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                BarcodeValue barcodeValue = barcodeValueArr[i][i2];
                if (barcodeValue.getValue().length == 0) {
                    formatter.format("        ", null);
                } else {
                    formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                }
            }
            formatter.format("\n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static void verifyCodewordCount(int[] iArr, int i) {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw FormatException.getFormatInstance();
            }
            if (i2 == 0) {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
