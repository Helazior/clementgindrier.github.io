package org.spongycastle.util.encoders;

import java.io.OutputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Encoder {
    int decode(String str, OutputStream outputStream);

    int decode(byte[] bArr, int i, int i2, OutputStream outputStream);

    int encode(byte[] bArr, int i, int i2, OutputStream outputStream);
}
