package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CMac implements Mac {
    private static final byte CONSTANT_128 = -121;
    private static final byte CONSTANT_64 = 27;

    /* renamed from: L */
    private byte[] f5957L;

    /* renamed from: Lu */
    private byte[] f5958Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    private byte[] doubleLu(byte[] bArr) {
        int i = 0;
        int i2 = (bArr[0] & 255) >> 7;
        byte[] bArr2 = new byte[bArr.length];
        while (i < bArr.length - 1) {
            int i3 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) + ((bArr[i3] & 255) >> 7));
            i = i3;
        }
        bArr2[bArr.length - 1] = (byte) (bArr[bArr.length - 1] << 1);
        if (i2 == 1) {
            int length = bArr.length - 1;
            bArr2[length] = (byte) ((bArr.length == 16 ? CONSTANT_128 : CONSTANT_64) ^ bArr2[length]);
        }
        return bArr2;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.f5958Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.mac;
            if (i2 < bArr3.length) {
                byte[] bArr4 = this.buf;
                bArr4[i2] = (byte) (bArr4[i2] ^ bArr2[i2]);
                i2++;
            } else {
                this.cipher.processBlock(this.buf, 0, bArr3, 0);
                System.arraycopy(this.mac, 0, bArr, i, this.macSize);
                reset();
                return this.macSize;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(true, cipherParameters);
        byte[] bArr = this.ZEROES;
        byte[] bArr2 = new byte[bArr.length];
        this.f5957L = bArr2;
        this.cipher.processBlock(bArr, 0, bArr2, 0);
        byte[] doubleLu = doubleLu(this.f5957L);
        this.f5958Lu = doubleLu;
        this.Lu2 = doubleLu(doubleLu);
        this.cipher.init(true, cipherParameters);
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b) {
        int i = this.bufOff;
        byte[] bArr = this.buf;
        if (i == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i2 = this.bufOff;
        this.bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public CMac(BlockCipher blockCipher, int i) {
        if (i % 8 == 0) {
            if (i <= blockCipher.getBlockSize() * 8) {
                if (blockCipher.getBlockSize() != 8 && blockCipher.getBlockSize() != 16) {
                    throw new IllegalArgumentException("Block size must be either 64 or 128 bits");
                }
                this.cipher = new CBCBlockCipher(blockCipher);
                this.macSize = i / 8;
                this.mac = new byte[blockCipher.getBlockSize()];
                this.buf = new byte[blockCipher.getBlockSize()];
                this.ZEROES = new byte[blockCipher.getBlockSize()];
                this.bufOff = 0;
                return;
            }
            StringBuilder m253r = outline.m253r("MAC size must be less or equal to ");
            m253r.append(blockCipher.getBlockSize() * 8);
            throw new IllegalArgumentException(m253r.toString());
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int blockSize = this.cipher.getBlockSize();
            int i3 = this.bufOff;
            int i4 = blockSize - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.buf, i3, i4);
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
                i2 -= i4;
                i += i4;
                while (i2 > blockSize) {
                    this.cipher.processBlock(bArr, i, this.mac, 0);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
            this.bufOff += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
