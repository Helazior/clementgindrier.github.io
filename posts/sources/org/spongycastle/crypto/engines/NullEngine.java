package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NullEngine implements BlockCipher {
    public static final int BLOCK_SIZE = 1;
    private boolean initialised;

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Null";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 1;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.initialised = true;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.initialised) {
            if (i + 1 <= bArr.length) {
                if (i2 + 1 <= bArr2.length) {
                    for (int i3 = 0; i3 < 1; i3++) {
                        bArr2[i2 + i3] = bArr[i + i3];
                    }
                    return 1;
                }
                throw new DataLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException("Null engine not initialised");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
