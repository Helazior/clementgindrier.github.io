package org.spongycastle.crypto;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i, int i2);

    Digest getDigest();

    void init(DerivationParameters derivationParameters);
}
