package org.spongycastle.crypto.params;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IESWithCipherParameters extends IESParameters {
    private int cipherKeySize;

    public IESWithCipherParameters(byte[] bArr, byte[] bArr2, int i, int i2) {
        super(bArr, bArr2, i);
        this.cipherKeySize = i2;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }
}
