package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.util.Pack;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GCMBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] ZEROES = new byte[16];

    /* renamed from: A */
    private byte[] f5972A;

    /* renamed from: H */
    private byte[] f5973H;

    /* renamed from: J0 */
    private byte[] f5974J0;

    /* renamed from: S */
    private byte[] f5975S;
    private byte[] bufBlock;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] counter;
    private boolean forEncryption;
    private byte[] initS;
    private byte[] macBlock;
    private int macSize;
    private GCMMultiplier multiplier;
    private byte[] nonce;
    private long totalLength;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    private void gCTRBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3;
        for (int i3 = 15; i3 >= 12; i3--) {
            byte[] bArr4 = this.counter;
            byte b = (byte) ((bArr4[i3] + 1) & 255);
            bArr4[i3] = b;
            if (b != 0) {
                break;
            }
        }
        byte[] bArr5 = new byte[16];
        this.cipher.processBlock(this.counter, 0, bArr5, 0);
        if (this.forEncryption) {
            System.arraycopy(ZEROES, i, bArr5, i, 16 - i);
            bArr3 = bArr5;
        } else {
            bArr3 = bArr;
        }
        for (int i4 = i - 1; i4 >= 0; i4--) {
            bArr5[i4] = (byte) (bArr5[i4] ^ bArr[i4]);
            bArr2[i2 + i4] = bArr5[i4];
        }
        xor(this.f5975S, bArr3);
        this.multiplier.multiplyH(this.f5975S);
        this.totalLength += i;
    }

    private byte[] gHASH(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < bArr.length; i += 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, i, bArr3, 0, Math.min(bArr.length - i, 16));
            xor(bArr2, bArr3);
            this.multiplier.multiplyH(bArr2);
        }
        return bArr2;
    }

    private static void packLength(long j, byte[] bArr, int i) {
        Pack.intToBigEndian((int) (j >>> 32), bArr, i);
        Pack.intToBigEndian((int) j, bArr, i + 4);
    }

    private int process(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.bufBlock;
        int i2 = this.bufOff;
        int i3 = i2 + 1;
        this.bufOff = i3;
        bArr2[i2] = b;
        if (i3 == bArr2.length) {
            gCTRBlock(bArr2, 16, bArr, i);
            if (!this.forEncryption) {
                byte[] bArr3 = this.bufBlock;
                System.arraycopy(bArr3, 16, bArr3, 0, this.macSize);
            }
            this.bufOff = this.bufBlock.length - 16;
            return 16;
        }
        return 0;
    }

    private static void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 15; i >= 0; i--) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i) {
        int i2 = this.bufOff;
        if (!this.forEncryption) {
            int i3 = this.macSize;
            if (i2 < i3) {
                throw new InvalidCipherTextException("data too short");
            }
            i2 -= i3;
        }
        if (i2 > 0) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(this.bufBlock, 0, bArr2, 0, i2);
            gCTRBlock(bArr2, i2, bArr, i);
        }
        byte[] bArr3 = new byte[16];
        packLength(this.f5972A.length * 8, bArr3, 0);
        packLength(this.totalLength * 8, bArr3, 8);
        xor(this.f5975S, bArr3);
        this.multiplier.multiplyH(this.f5975S);
        byte[] bArr4 = new byte[16];
        this.cipher.processBlock(this.f5974J0, 0, bArr4, 0);
        xor(bArr4, this.f5975S);
        int i4 = this.macSize;
        byte[] bArr5 = new byte[i4];
        this.macBlock = bArr5;
        System.arraycopy(bArr4, 0, bArr5, 0, i4);
        if (this.forEncryption) {
            System.arraycopy(this.macBlock, 0, bArr, i + this.bufOff, this.macSize);
            i2 += this.macSize;
        } else {
            int i5 = this.macSize;
            byte[] bArr6 = new byte[i5];
            System.arraycopy(this.bufBlock, i2, bArr6, 0, i5);
            if (!Arrays.constantTimeAreEqual(this.macBlock, bArr6)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        reset(false);
        return i2;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i) {
        if (this.forEncryption) {
            return i + this.bufOff + this.macSize;
        }
        return (i + this.bufOff) - this.macSize;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i) {
        return ((i + this.bufOff) / 16) * 16;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        this.forEncryption = z;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.f5972A = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize >= 96 && macSize <= 128 && macSize % 8 == 0) {
                this.macSize = macSize / 8;
                keyParameter = aEADParameters.getKey();
            } else {
                throw new IllegalArgumentException(outline.m273H("Invalid value for MAC size: ", macSize));
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.f5972A = null;
            this.macSize = 16;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        this.bufBlock = new byte[z ? 16 : this.macSize + 16];
        byte[] bArr = this.nonce;
        if (bArr != null && bArr.length >= 1) {
            if (this.f5972A == null) {
                this.f5972A = new byte[0];
            }
            if (keyParameter != null) {
                this.cipher.init(true, keyParameter);
            }
            byte[] bArr2 = new byte[16];
            this.f5973H = bArr2;
            this.cipher.processBlock(ZEROES, 0, bArr2, 0);
            this.multiplier.init(this.f5973H);
            this.initS = gHASH(this.f5972A);
            byte[] bArr3 = this.nonce;
            if (bArr3.length == 12) {
                byte[] bArr4 = new byte[16];
                this.f5974J0 = bArr4;
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                this.f5974J0[15] = 1;
            } else {
                this.f5974J0 = gHASH(bArr3);
                byte[] bArr5 = new byte[16];
                packLength(this.nonce.length * 8, bArr5, 8);
                xor(this.f5974J0, bArr5);
                this.multiplier.multiplyH(this.f5974J0);
            }
            this.f5975S = Arrays.clone(this.initS);
            this.counter = Arrays.clone(this.f5974J0);
            this.bufOff = 0;
            this.totalLength = 0L;
            return;
        }
        throw new IllegalArgumentException("IV must be at least 1 byte");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b, byte[] bArr, int i) {
        return process(b, bArr, i);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 != i2; i5++) {
            byte[] bArr3 = this.bufBlock;
            int i6 = this.bufOff;
            int i7 = i6 + 1;
            this.bufOff = i7;
            bArr3[i6] = bArr[i + i5];
            if (i7 == bArr3.length) {
                gCTRBlock(bArr3, 16, bArr2, i3 + i4);
                if (!this.forEncryption) {
                    byte[] bArr4 = this.bufBlock;
                    System.arraycopy(bArr4, 16, bArr4, 0, this.macSize);
                }
                this.bufOff = this.bufBlock.length - 16;
                i4 += 16;
            }
        }
        return i4;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        reset(true);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() == 16) {
            gCMMultiplier = gCMMultiplier == null ? new Tables8kGCMMultiplier() : gCMMultiplier;
            this.cipher = blockCipher;
            this.multiplier = gCMMultiplier;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    private void reset(boolean z) {
        this.f5975S = Arrays.clone(this.initS);
        this.counter = Arrays.clone(this.f5974J0);
        this.bufOff = 0;
        this.totalLength = 0L;
        byte[] bArr = this.bufBlock;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        if (z) {
            this.macBlock = null;
        }
        this.cipher.reset();
    }
}
