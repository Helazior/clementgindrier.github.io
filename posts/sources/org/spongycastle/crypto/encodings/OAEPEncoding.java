package org.spongycastle.crypto.encodings;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest hash;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, new SHA1Digest(), null);
    }

    private void ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        this.hash.reset();
        int i4 = 0;
        do {
            ItoOSP(i4, bArr4);
            this.mgf1Hash.update(bArr, i, i2);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i4 * digestSize, digestSize);
            i4++;
        } while (i4 < i3 / digestSize);
        int i5 = digestSize * i4;
        if (i5 < i3) {
            ItoOSP(i4, bArr4);
            this.mgf1Hash.update(bArr, i, i2);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i5, i3 - i5);
        }
        return bArr2;
    }

    public byte[] decodeBlock(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        byte[] processBlock = this.engine.processBlock(bArr, i, i2);
        if (processBlock.length < this.engine.getOutputBlockSize()) {
            int outputBlockSize = this.engine.getOutputBlockSize();
            byte[] bArr3 = new byte[outputBlockSize];
            System.arraycopy(processBlock, 0, bArr3, outputBlockSize - processBlock.length, processBlock.length);
            processBlock = bArr3;
        }
        int length = processBlock.length;
        byte[] bArr4 = this.defHash;
        if (length >= (bArr4.length * 2) + 1) {
            byte[] maskGeneratorFunction1 = maskGeneratorFunction1(processBlock, bArr4.length, processBlock.length - bArr4.length, bArr4.length);
            int i3 = 0;
            while (true) {
                bArr2 = this.defHash;
                if (i3 == bArr2.length) {
                    break;
                }
                processBlock[i3] = (byte) (processBlock[i3] ^ maskGeneratorFunction1[i3]);
                i3++;
            }
            byte[] maskGeneratorFunction12 = maskGeneratorFunction1(processBlock, 0, bArr2.length, processBlock.length - bArr2.length);
            for (int length2 = this.defHash.length; length2 != processBlock.length; length2++) {
                processBlock[length2] = (byte) (processBlock[length2] ^ maskGeneratorFunction12[length2 - this.defHash.length]);
            }
            int i4 = 0;
            while (true) {
                byte[] bArr5 = this.defHash;
                if (i4 != bArr5.length) {
                    if (bArr5[i4] != processBlock[bArr5.length + i4]) {
                        throw new InvalidCipherTextException("data hash wrong");
                    }
                    i4++;
                } else {
                    int length3 = bArr5.length * 2;
                    while (length3 != processBlock.length && processBlock[length3] == 0) {
                        length3++;
                    }
                    if (length3 < processBlock.length - 1 && processBlock[length3] == 1) {
                        int i5 = length3 + 1;
                        int length4 = processBlock.length - i5;
                        byte[] bArr6 = new byte[length4];
                        System.arraycopy(processBlock, i5, bArr6, 0, length4);
                        return bArr6;
                    }
                    throw new InvalidCipherTextException(outline.m273H("data start wrong ", length3));
                }
            }
        } else {
            throw new InvalidCipherTextException("data too short");
        }
    }

    public byte[] encodeBlock(byte[] bArr, int i, int i2) {
        int length = (this.defHash.length * 2) + getInputBlockSize() + 1;
        byte[] bArr2 = new byte[length];
        int i3 = length - i2;
        System.arraycopy(bArr, i, bArr2, i3, i2);
        bArr2[i3 - 1] = 1;
        byte[] bArr3 = this.defHash;
        System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
        int length2 = this.defHash.length;
        byte[] bArr4 = new byte[length2];
        this.random.nextBytes(bArr4);
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, length2, length - this.defHash.length);
        for (int length3 = this.defHash.length; length3 != length; length3++) {
            bArr2[length3] = (byte) (bArr2[length3] ^ maskGeneratorFunction1[length3 - this.defHash.length]);
        }
        System.arraycopy(bArr4, 0, bArr2, 0, this.defHash.length);
        byte[] bArr5 = this.defHash;
        byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr2, bArr5.length, length - bArr5.length, bArr5.length);
        for (int i4 = 0; i4 != this.defHash.length; i4++) {
            bArr2[i4] = (byte) (bArr2[i4] ^ maskGeneratorFunction12[i4]);
        }
        return this.engine.processBlock(bArr2, 0, length);
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize - 1) - (this.defHash.length * 2) : inputBlockSize;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.random = ((ParametersWithRandom) cipherParameters).getRandom();
        } else {
            this.random = new SecureRandom();
        }
        this.engine.init(z, cipherParameters);
        this.forEncryption = z;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        if (this.forEncryption) {
            return encodeBlock(bArr, i, i2);
        }
        return decodeBlock(bArr, i, i2);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.hash = digest;
        this.mgf1Hash = digest2;
        this.defHash = new byte[digest.getDigestSize()];
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(this.defHash, 0);
    }
}
