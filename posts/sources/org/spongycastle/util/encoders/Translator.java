package org.spongycastle.util.encoders;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Translator {
    int decode(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    int encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    int getDecodedBlockSize();

    int getEncodedBlockSize();
}
