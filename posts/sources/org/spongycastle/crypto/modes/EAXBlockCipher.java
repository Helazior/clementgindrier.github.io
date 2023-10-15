package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private SICBlockCipher cipher;
    private boolean forEncryption;
    private Mac mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonceMac;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        CMac cMac = new CMac(blockCipher);
        this.mac = cMac;
        int i = this.blockSize;
        this.macBlock = new byte[i];
        this.bufBlock = new byte[i * 2];
        this.associatedTextMac = new byte[cMac.getMacSize()];
        this.nonceMac = new byte[this.mac.getMacSize()];
        this.cipher = new SICBlockCipher(blockCipher);
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i = 0;
        this.mac.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = (byte) ((this.nonceMac[i] ^ this.associatedTextMac[i]) ^ bArr[i]);
            i++;
        }
    }

    private int process(byte b, byte[] bArr, int i) {
        int processBlock;
        byte[] bArr2 = this.bufBlock;
        int i2 = this.bufOff;
        int i3 = i2 + 1;
        this.bufOff = i3;
        bArr2[i2] = b;
        if (i3 == bArr2.length) {
            if (this.forEncryption) {
                processBlock = this.cipher.processBlock(bArr2, 0, bArr, i);
                this.mac.update(bArr, i, this.blockSize);
            } else {
                this.mac.update(bArr2, 0, this.blockSize);
                processBlock = this.cipher.processBlock(this.bufBlock, 0, bArr, i);
            }
            int i4 = this.blockSize;
            this.bufOff = i4;
            byte[] bArr3 = this.bufBlock;
            System.arraycopy(bArr3, i4, bArr3, 0, i4);
            return processBlock;
        }
        return 0;
    }

    private boolean verifyMac(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this.macSize; i2++) {
            if (this.macBlock[i2] != bArr[i + i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i) {
        int i2 = this.bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            SICBlockCipher sICBlockCipher = this.cipher;
            byte[] bArr4 = this.bufBlock;
            int i3 = this.blockSize;
            sICBlockCipher.processBlock(bArr4, i3, bArr3, i3);
            System.arraycopy(bArr3, 0, bArr, i, i2);
            this.mac.update(bArr3, 0, i2);
            calculateMac();
            System.arraycopy(this.macBlock, 0, bArr, i + i2, this.macSize);
            reset(false);
            return i2 + this.macSize;
        }
        int i4 = this.macSize;
        if (i2 > i4) {
            this.mac.update(bArr2, 0, i2 - i4);
            this.cipher.processBlock(this.bufBlock, 0, bArr3, 0);
            SICBlockCipher sICBlockCipher2 = this.cipher;
            byte[] bArr5 = this.bufBlock;
            int i5 = this.blockSize;
            sICBlockCipher2.processBlock(bArr5, i5, bArr3, i5);
            System.arraycopy(bArr3, 0, bArr, i, i2 - this.macSize);
        }
        calculateMac();
        if (verifyMac(this.bufBlock, i2 - this.macSize)) {
            reset(false);
            return i2 - this.macSize;
        }
        throw new InvalidCipherTextException("mac check in EAX failed");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        int i = this.macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
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
        return this.cipher.getUnderlyingCipher();
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.bufOff;
        int i3 = this.blockSize;
        return (i2 / i3) * i3;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] iv;
        byte[] bArr;
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            iv = aEADParameters.getNonce();
            bArr = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            parameters = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            bArr = new byte[0];
            this.macSize = this.mac.getMacSize() / 2;
            parameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        byte[] bArr2 = new byte[this.blockSize];
        this.mac.init(parameters);
        int i = this.blockSize;
        bArr2[i - 1] = 1;
        this.mac.update(bArr2, 0, i);
        this.mac.update(bArr, 0, bArr.length);
        this.mac.doFinal(this.associatedTextMac, 0);
        int i2 = this.blockSize;
        bArr2[i2 - 1] = 0;
        this.mac.update(bArr2, 0, i2);
        this.mac.update(iv, 0, iv.length);
        this.mac.doFinal(this.nonceMac, 0);
        int i3 = this.blockSize;
        bArr2[i3 - 1] = 2;
        this.mac.update(bArr2, 0, i3);
        this.cipher.init(true, new ParametersWithIV(parameters, this.nonceMac));
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b, byte[] bArr, int i) {
        return process(b, bArr, i);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 != i2; i5++) {
            i4 += process(bArr[i + i5], bArr2, i3 + i4);
        }
        return i4;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        reset(true);
    }

    private void reset(boolean z) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (z) {
            Arrays.fill(this.macBlock, (byte) 0);
        }
        int i = this.blockSize;
        byte[] bArr = new byte[i];
        bArr[i - 1] = 2;
        this.mac.update(bArr, 0, i);
    }
}
