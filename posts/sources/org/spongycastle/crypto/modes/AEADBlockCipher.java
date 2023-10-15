package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface AEADBlockCipher {
    int doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i);

    BlockCipher getUnderlyingCipher();

    int getUpdateOutputSize(int i);

    void init(boolean z, CipherParameters cipherParameters);

    int processByte(byte b, byte[] bArr, int i);

    int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    void reset();
}
