package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PGPCFBBlockCipher implements BlockCipher {

    /* renamed from: FR */
    private byte[] f5984FR;
    private byte[] FRE;

    /* renamed from: IV */
    private byte[] f5985IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;
    private boolean inlineIv;
    private byte[] tmp;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.cipher = blockCipher;
        this.inlineIv = z;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f5985IV = new byte[blockSize];
        this.f5984FR = new byte[blockSize];
        this.FRE = new byte[blockSize];
        this.tmp = new byte[blockSize];
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 <= bArr.length) {
            if (i3 + i2 <= bArr2.length) {
                int i4 = 0;
                this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                for (int i5 = 0; i5 < this.blockSize; i5++) {
                    bArr2[i2 + i5] = encryptByte(bArr[i + i5], i5);
                }
                while (true) {
                    int i6 = this.blockSize;
                    if (i4 >= i6) {
                        return i6;
                    }
                    this.f5984FR[i4] = bArr[i + i4];
                    i4++;
                }
            } else {
                throw new DataLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    private int decryptBlockWithIV(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4 = this.blockSize;
        if (i + i4 <= bArr.length) {
            if (i2 + i4 <= bArr2.length) {
                int i5 = this.count;
                if (i5 == 0) {
                    for (int i6 = 0; i6 < this.blockSize; i6++) {
                        this.f5984FR[i6] = bArr[i + i6];
                    }
                    this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                    this.count += this.blockSize;
                    return 0;
                } else if (i5 == i4) {
                    System.arraycopy(bArr, i, this.tmp, 0, i4);
                    byte[] bArr3 = this.f5984FR;
                    System.arraycopy(bArr3, 2, bArr3, 0, this.blockSize - 2);
                    byte[] bArr4 = this.f5984FR;
                    int i7 = this.blockSize;
                    byte[] bArr5 = this.tmp;
                    bArr4[i7 - 2] = bArr5[0];
                    bArr4[i7 - 1] = bArr5[1];
                    this.cipher.processBlock(bArr4, 0, this.FRE, 0);
                    int i8 = 0;
                    while (true) {
                        int i9 = this.blockSize;
                        if (i8 < i9 - 2) {
                            bArr2[i2 + i8] = encryptByte(this.tmp[i8 + 2], i8);
                            i8++;
                        } else {
                            System.arraycopy(this.tmp, 2, this.f5984FR, 0, i9 - 2);
                            this.count += 2;
                            return this.blockSize - 2;
                        }
                    }
                } else {
                    if (i5 >= i4 + 2) {
                        System.arraycopy(bArr, i, this.tmp, 0, i4);
                        bArr2[i2 + 0] = encryptByte(this.tmp[0], this.blockSize - 2);
                        bArr2[i2 + 1] = encryptByte(this.tmp[1], this.blockSize - 1);
                        System.arraycopy(this.tmp, 0, this.f5984FR, this.blockSize - 2, 2);
                        this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                        int i10 = 0;
                        while (true) {
                            i3 = this.blockSize;
                            if (i10 >= i3 - 2) {
                                break;
                            }
                            bArr2[i2 + i10 + 2] = encryptByte(this.tmp[i10 + 2], i10);
                            i10++;
                        }
                        System.arraycopy(this.tmp, 2, this.f5984FR, 0, i3 - 2);
                    }
                    return this.blockSize;
                }
            } else {
                throw new DataLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 <= bArr.length) {
            if (i3 + i2 <= bArr2.length) {
                int i4 = 0;
                this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                for (int i5 = 0; i5 < this.blockSize; i5++) {
                    bArr2[i2 + i5] = encryptByte(bArr[i + i5], i5);
                }
                while (true) {
                    int i6 = this.blockSize;
                    if (i4 >= i6) {
                        return i6;
                    }
                    this.f5984FR[i4] = bArr2[i2 + i4];
                    i4++;
                }
            } else {
                throw new DataLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    private int encryptBlockWithIV(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4;
        int i5 = this.blockSize;
        if (i + i5 <= bArr.length) {
            if (i2 + i5 <= bArr2.length) {
                int i6 = this.count;
                if (i6 == 0) {
                    this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                    int i7 = 0;
                    while (true) {
                        i4 = this.blockSize;
                        if (i7 >= i4) {
                            break;
                        }
                        bArr2[i2 + i7] = encryptByte(this.f5985IV[i7], i7);
                        i7++;
                    }
                    System.arraycopy(bArr2, i2, this.f5984FR, 0, i4);
                    this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                    int i8 = this.blockSize;
                    bArr2[i2 + i8] = encryptByte(this.f5985IV[i8 - 2], 0);
                    int i9 = this.blockSize;
                    bArr2[i2 + i9 + 1] = encryptByte(this.f5985IV[i9 - 1], 1);
                    System.arraycopy(bArr2, i2 + 2, this.f5984FR, 0, this.blockSize);
                    this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                    int i10 = 0;
                    while (true) {
                        int i11 = this.blockSize;
                        if (i10 < i11) {
                            bArr2[outline.m269b(i11, i2, 2, i10)] = encryptByte(bArr[i + i10], i10);
                            i10++;
                        } else {
                            System.arraycopy(bArr2, i2 + i11 + 2, this.f5984FR, 0, i11);
                            int i12 = this.count;
                            int i13 = this.blockSize;
                            this.count = (i13 * 2) + 2 + i12;
                            return (i13 * 2) + 2;
                        }
                    }
                } else {
                    if (i6 >= i5 + 2) {
                        this.cipher.processBlock(this.f5984FR, 0, this.FRE, 0);
                        int i14 = 0;
                        while (true) {
                            i3 = this.blockSize;
                            if (i14 >= i3) {
                                break;
                            }
                            bArr2[i2 + i14] = encryptByte(bArr[i + i14], i14);
                            i14++;
                        }
                        System.arraycopy(bArr2, i2, this.f5984FR, 0, i3);
                    }
                    return this.blockSize;
                }
            } else {
                throw new DataLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    private byte encryptByte(byte b, int i) {
        return (byte) (b ^ this.FRE[i]);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        if (this.inlineIv) {
            return this.cipher.getAlgorithmName() + "/PGPCFBwithIV";
        }
        return this.cipher.getAlgorithmName() + "/PGPCFB";
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
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.f5985IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.f5985IV;
                    if (i >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i] = 0;
                    i++;
                }
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            this.cipher.init(true, parametersWithIV.getParameters());
            return;
        }
        reset();
        this.cipher.init(true, cipherParameters);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.inlineIv ? this.forEncryption ? encryptBlockWithIV(bArr, i, bArr2, i2) : decryptBlockWithIV(bArr, i, bArr2, i2) : this.forEncryption ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        this.count = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f5984FR;
            if (i != bArr.length) {
                if (this.inlineIv) {
                    bArr[i] = 0;
                } else {
                    bArr[i] = this.f5985IV[i];
                }
                i++;
            } else {
                this.cipher.reset();
                return;
            }
        }
    }
}
