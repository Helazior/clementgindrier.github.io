package com.google.zxing;

import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Reader {
    Result decode(BinaryBitmap binaryBitmap);

    Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map);

    void reset();
}
