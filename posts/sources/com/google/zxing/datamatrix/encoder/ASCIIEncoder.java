package com.google.zxing.datamatrix.encoder;

import org.kxml2.wap.Wbxml;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ASCIIEncoder implements Encoder {
    private static char encodeASCIIDigits(char c, char c2) {
        if (HighLevelEncoder.isDigit(c) && HighLevelEncoder.isDigit(c2)) {
            return (char) ((c2 - '0') + ((c - '0') * 10) + Wbxml.EXT_T_2);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.msg, encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.msg.charAt(encoderContext.pos), encoderContext.msg.charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.msg, encoderContext.pos, getEncodingMode());
        if (lookAheadTest == getEncodingMode()) {
            if (HighLevelEncoder.isExtendedASCII(currentChar)) {
                encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
                encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
                encoderContext.pos++;
                return;
            }
            encoderContext.writeCodeword((char) (currentChar + 1));
            encoderContext.pos++;
        } else if (lookAheadTest == 1) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
            encoderContext.signalEncoderChange(1);
        } else if (lookAheadTest == 2) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
            encoderContext.signalEncoderChange(2);
        } else if (lookAheadTest == 3) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
            encoderContext.signalEncoderChange(3);
        } else if (lookAheadTest == 4) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
            encoderContext.signalEncoderChange(4);
        } else if (lookAheadTest == 5) {
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
            encoderContext.signalEncoderChange(5);
        } else {
            throw new IllegalStateException(outline.m273H("Illegal mode: ", lookAheadTest));
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 0;
    }
}
