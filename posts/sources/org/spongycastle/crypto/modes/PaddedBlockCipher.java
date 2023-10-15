package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PaddedBlockCipher extends BufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i) {
        int i2;
        int i3;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i3 = 0;
            } else if ((blockSize * 2) + i <= bArr.length) {
                i3 = this.cipher.processBlock(this.buf, 0, bArr, i);
                this.bufOff = 0;
            } else {
                throw new DataLengthException("output buffer too short");
            }
            byte b = (byte) (blockSize - this.bufOff);
            while (true) {
                int i4 = this.bufOff;
                if (i4 >= blockSize) {
                    break;
                }
                this.buf[i4] = b;
                this.bufOff = i4 + 1;
            }
            i2 = this.cipher.processBlock(this.buf, 0, bArr, i + i3) + i3;
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            byte[] bArr3 = this.buf;
            int i5 = bArr3[blockSize - 1] & 255;
            if (i5 >= 0 && i5 <= blockSize) {
                int i6 = processBlock - i5;
                System.arraycopy(bArr3, 0, bArr, i, i6);
                i2 = i6;
            } else {
                throw new InvalidCipherTextException("pad block corrupted");
            }
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        reset();
        return i2;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int i) {
        int length;
        int i2 = i + this.bufOff;
        byte[] bArr = this.buf;
        int length2 = i2 % bArr.length;
        if (length2 == 0) {
            if (!this.forEncryption) {
                return i2;
            }
            length = bArr.length;
        } else {
            i2 -= length2;
            length = bArr.length;
        }
        return i2 + length;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.bufOff;
        byte[] bArr = this.buf;
        int length = i2 % bArr.length;
        return length == 0 ? i2 - bArr.length : i2 - length;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int processByte(byte b, byte[] bArr, int i) {
        int i2 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i3 = 0;
        if (i2 == bArr2.length) {
            int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i);
            this.bufOff = 0;
            i3 = processBlock;
        }
        byte[] bArr3 = this.buf;
        int i4 = this.bufOff;
        this.bufOff = i4 + 1;
        bArr3[i4] = b;
        return i3;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i2);
            if (updateOutputSize > 0 && updateOutputSize + i3 > bArr2.length) {
                throw new DataLengthException("output buffer too short");
            }
            byte[] bArr3 = this.buf;
            int length = bArr3.length;
            int i4 = this.bufOff;
            int i5 = length - i4;
            int i6 = 0;
            if (i2 > i5) {
                System.arraycopy(bArr, i, bArr3, i4, i5);
                this.bufOff = 0;
                i2 -= i5;
                i += i5;
                i6 = this.cipher.processBlock(this.buf, 0, bArr2, i3) + 0;
                while (i2 > this.buf.length) {
                    i6 += this.cipher.processBlock(bArr, i, bArr2, i3 + i6);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
            this.bufOff += i2;
            return i6;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
