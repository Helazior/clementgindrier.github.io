package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.math.p017ec.Tnaf;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOFBBlockCipher implements BlockCipher {

    /* renamed from: C1 */
    public static final int f5976C1 = 16843012;

    /* renamed from: C2 */
    public static final int f5977C2 = 16843009;

    /* renamed from: IV */
    private byte[] f5978IV;

    /* renamed from: N3 */
    public int f5979N3;

    /* renamed from: N4 */
    public int f5980N4;
    private final int blockSize;
    private final BlockCipher cipher;
    public boolean firstStep = true;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        if (blockSize == 8) {
            this.f5978IV = new byte[blockCipher.getBlockSize()];
            this.ofbV = new byte[blockCipher.getBlockSize()];
            this.ofbOutV = new byte[blockCipher.getBlockSize()];
            return;
        }
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    private int bytesToint(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & (-16777216)) + ((bArr[i + 2] << Tnaf.POW_2_WIDTH) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255);
    }

    private void intTobytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCTR";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.firstStep = true;
        this.f5979N3 = 0;
        this.f5980N4 = 0;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.f5978IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.f5978IV;
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
            if (parametersWithIV.getParameters() != null) {
                this.cipher.init(true, parametersWithIV.getParameters());
                return;
            }
            return;
        }
        reset();
        if (cipherParameters != null) {
            this.cipher.init(true, cipherParameters);
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 <= bArr.length) {
            if (i3 + i2 <= bArr2.length) {
                if (this.firstStep) {
                    this.firstStep = false;
                    this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
                    this.f5979N3 = bytesToint(this.ofbOutV, 0);
                    this.f5980N4 = bytesToint(this.ofbOutV, 4);
                }
                int i4 = this.f5979N3 + f5977C2;
                this.f5979N3 = i4;
                this.f5980N4 += f5976C1;
                intTobytes(i4, this.ofbV, 0);
                intTobytes(this.f5980N4, this.ofbV, 4);
                this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
                int i5 = 0;
                while (true) {
                    int i6 = this.blockSize;
                    if (i5 < i6) {
                        bArr2[i2 + i5] = (byte) (this.ofbOutV[i5] ^ bArr[i + i5]);
                        i5++;
                    } else {
                        byte[] bArr3 = this.ofbV;
                        System.arraycopy(bArr3, i6, bArr3, 0, bArr3.length - i6);
                        byte[] bArr4 = this.ofbOutV;
                        byte[] bArr5 = this.ofbV;
                        int length = bArr5.length;
                        int i7 = this.blockSize;
                        System.arraycopy(bArr4, 0, bArr5, length - i7, i7);
                        return this.blockSize;
                    }
                }
            } else {
                throw new DataLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.f5978IV;
        System.arraycopy(bArr, 0, this.ofbV, 0, bArr.length);
        this.cipher.reset();
    }
}
