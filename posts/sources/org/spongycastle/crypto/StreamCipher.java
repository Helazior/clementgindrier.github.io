package org.spongycastle.crypto;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean z, CipherParameters cipherParameters);

    void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    void reset();

    byte returnByte(byte b);
}
