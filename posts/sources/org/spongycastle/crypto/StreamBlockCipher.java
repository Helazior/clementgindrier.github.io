package org.spongycastle.crypto;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class StreamBlockCipher implements StreamCipher {
    private BlockCipher cipher;
    private byte[] oneByte = new byte[1];

    public StreamBlockCipher(BlockCipher blockCipher) {
        if (blockCipher.getBlockSize() == 1) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("block cipher block size != 1.");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.cipher.init(z, cipherParameters);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i3 + i2 > bArr2.length) {
            throw new DataLengthException("output buffer too small in processBytes()");
        }
        for (int i4 = 0; i4 != i2; i4++) {
            this.cipher.processBlock(bArr, i + i4, bArr2, i3 + i4);
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        this.cipher.reset();
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        byte[] bArr = this.oneByte;
        bArr[0] = b;
        this.cipher.processBlock(bArr, 0, bArr, 0);
        return this.oneByte[0];
    }
}
