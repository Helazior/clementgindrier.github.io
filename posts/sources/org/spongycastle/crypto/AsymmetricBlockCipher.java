package org.spongycastle.crypto;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface AsymmetricBlockCipher {
    int getInputBlockSize();

    int getOutputBlockSize();

    void init(boolean z, CipherParameters cipherParameters);

    byte[] processBlock(byte[] bArr, int i, int i2);
}
