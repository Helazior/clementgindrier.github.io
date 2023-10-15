package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SICBlockCipher implements BlockCipher {

    /* renamed from: IV */
    private byte[] f5986IV;
    private final int blockSize;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f5986IV = new byte[blockSize];
        this.counter = new byte[blockSize];
        this.counterOut = new byte[blockSize];
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.f5986IV;
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
            reset();
            if (parametersWithIV.getParameters() != null) {
                this.cipher.init(true, parametersWithIV.getParameters());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("SIC mode requires ParametersWithIV");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.counterOut;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr2[i2 + i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            i3++;
        }
        int i4 = 1;
        for (int length = this.counter.length - 1; length >= 0; length--) {
            byte[] bArr4 = this.counter;
            int i5 = (bArr4[length] & 255) + i4;
            i4 = i5 > 255 ? 1 : 0;
            bArr4[length] = (byte) i5;
        }
        return this.counter.length;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.f5986IV;
        byte[] bArr2 = this.counter;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
    }
}
