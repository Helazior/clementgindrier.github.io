package com.google.zxing.datamatrix.encoder;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Base256Encoder implements Encoder {
    private static char randomize255State(char c, int i) {
        int i2 = ((i * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 255) + 1 + c;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            int i = encoderContext.pos + 1;
            encoderContext.pos = i;
            int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.msg, i, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z = encoderContext.symbolInfo.dataCapacity - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length > 249 && length <= 1555) {
                sb.setCharAt(0, (char) ((length / BaseTransientBottomBar.ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % BaseTransientBottomBar.ANIMATION_DURATION));
            } else {
                throw new IllegalStateException(outline.m273H("Message length not in valid ranges: ", length));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i2), encoderContext.getCodewordCount() + 1));
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }
}
