package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.BigIntegers;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IESEngine {
    public BasicAgreement agree;
    public BufferedBlockCipher cipher;
    public boolean forEncryption;
    public DerivationFunction kdf;
    public Mac mac;
    public byte[] macBuf;
    public IESParameters param;
    public CipherParameters privParam;
    public CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = null;
    }

    private byte[] decryptBlock(byte[] bArr, int i, int i2, byte[] bArr2) {
        byte[] bArr3;
        KeyParameter keyParameter;
        KDFParameters kDFParameters = new KDFParameters(bArr2, this.param.getDerivationV());
        int macKeySize = this.param.getMacKeySize();
        this.kdf.init(kDFParameters);
        int macSize = i2 - this.mac.getMacSize();
        int i3 = 0;
        if (this.cipher == null) {
            int i4 = macKeySize / 8;
            byte[] generateKdfBytes = generateKdfBytes(kDFParameters, macSize + i4);
            bArr3 = new byte[macSize];
            for (int i5 = 0; i5 != macSize; i5++) {
                bArr3[i5] = (byte) (bArr[i + i5] ^ generateKdfBytes[i5]);
            }
            keyParameter = new KeyParameter(generateKdfBytes, macSize, i4);
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            int i6 = macKeySize / 8;
            byte[] generateKdfBytes2 = generateKdfBytes(kDFParameters, cipherKeySize + i6);
            this.cipher.init(false, new KeyParameter(generateKdfBytes2, 0, cipherKeySize));
            byte[] bArr4 = new byte[this.cipher.getOutputSize(macSize)];
            int processBytes = this.cipher.processBytes(bArr, i, macSize, bArr4, 0);
            int doFinal = this.cipher.doFinal(bArr4, processBytes) + processBytes;
            byte[] bArr5 = new byte[doFinal];
            System.arraycopy(bArr4, 0, bArr5, 0, doFinal);
            KeyParameter keyParameter2 = new KeyParameter(generateKdfBytes2, cipherKeySize, i6);
            bArr3 = bArr5;
            keyParameter = keyParameter2;
        }
        byte[] encodingV = this.param.getEncodingV();
        this.mac.init(keyParameter);
        this.mac.update(bArr, i, macSize);
        this.mac.update(encodingV, 0, encodingV.length);
        this.mac.doFinal(this.macBuf, 0);
        int i7 = i + macSize;
        while (true) {
            byte[] bArr6 = this.macBuf;
            if (i3 >= bArr6.length) {
                return bArr3;
            }
            if (bArr6[i3] != bArr[i7 + i3]) {
                throw new InvalidCipherTextException("Mac codes failed to equal.");
            }
            i3++;
        }
    }

    private byte[] encryptBlock(byte[] bArr, int i, int i2, byte[] bArr2) {
        byte[] bArr3;
        KeyParameter keyParameter;
        KDFParameters kDFParameters = new KDFParameters(bArr2, this.param.getDerivationV());
        int macKeySize = this.param.getMacKeySize();
        if (this.cipher == null) {
            int i3 = macKeySize / 8;
            byte[] generateKdfBytes = generateKdfBytes(kDFParameters, i2 + i3);
            bArr3 = new byte[this.mac.getMacSize() + i2];
            for (int i4 = 0; i4 != i2; i4++) {
                bArr3[i4] = (byte) (bArr[i + i4] ^ generateKdfBytes[i4]);
            }
            keyParameter = new KeyParameter(generateKdfBytes, i2, i3);
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            int i5 = macKeySize / 8;
            byte[] generateKdfBytes2 = generateKdfBytes(kDFParameters, cipherKeySize + i5);
            this.cipher.init(true, new KeyParameter(generateKdfBytes2, 0, cipherKeySize));
            byte[] bArr4 = new byte[this.cipher.getOutputSize(i2)];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr4, 0);
            i2 = this.cipher.doFinal(bArr4, processBytes) + processBytes;
            byte[] bArr5 = new byte[this.mac.getMacSize() + i2];
            System.arraycopy(bArr4, 0, bArr5, 0, i2);
            KeyParameter keyParameter2 = new KeyParameter(generateKdfBytes2, cipherKeySize, i5);
            bArr3 = bArr5;
            keyParameter = keyParameter2;
        }
        byte[] encodingV = this.param.getEncodingV();
        this.mac.init(keyParameter);
        this.mac.update(bArr3, 0, i2);
        this.mac.update(encodingV, 0, encodingV.length);
        this.mac.doFinal(bArr3, i2);
        return bArr3;
    }

    private byte[] generateKdfBytes(KDFParameters kDFParameters, int i) {
        byte[] bArr = new byte[i];
        this.kdf.init(kDFParameters);
        this.kdf.generateBytes(bArr, 0, i);
        return bArr;
    }

    public void init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.param = (IESParameters) cipherParameters3;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) {
        this.agree.init(this.privParam);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.agree.calculateAgreement(this.pubParam));
        return this.forEncryption ? encryptBlock(bArr, i, i2, asUnsignedByteArray) : decryptBlock(bArr, i, i2, asUnsignedByteArray);
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }
}
