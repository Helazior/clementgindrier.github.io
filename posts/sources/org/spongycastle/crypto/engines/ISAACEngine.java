package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ISAACEngine implements StreamCipher {
    private final int sizeL = 8;
    private final int stateArraySize = 256;
    private int[] engineState = null;
    private int[] results = null;

    /* renamed from: a */
    private int f5914a = 0;

    /* renamed from: b */
    private int f5915b = 0;

    /* renamed from: c */
    private int f5916c = 0;
    private int index = 0;
    private byte[] keyStream = new byte[1024];
    private byte[] workingKey = null;
    private boolean initialised = false;

    private int byteToIntLittle(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        return (bArr[i3 + 1] << 24) | i4 | ((bArr[i3] & 255) << 16);
    }

    private byte[] intToByteLittle(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    private byte[] intToByteLittle(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            System.arraycopy(intToByteLittle(iArr[i]), 0, bArr, i2, 4);
            i++;
            i2 += 4;
        }
        return bArr;
    }

    private void isaac() {
        int i = this.f5915b;
        int i2 = this.f5916c + 1;
        this.f5916c = i2;
        this.f5915b = i + i2;
        for (int i3 = 0; i3 < 256; i3++) {
            int[] iArr = this.engineState;
            int i4 = iArr[i3];
            int i5 = i3 & 3;
            if (i5 == 0) {
                int i6 = this.f5914a;
                this.f5914a = i6 ^ (i6 << 13);
            } else if (i5 == 1) {
                int i7 = this.f5914a;
                this.f5914a = i7 ^ (i7 >>> 6);
            } else if (i5 == 2) {
                int i8 = this.f5914a;
                this.f5914a = i8 ^ (i8 << 2);
            } else if (i5 == 3) {
                int i9 = this.f5914a;
                this.f5914a = i9 ^ (i9 >>> 16);
            }
            int i10 = this.f5914a + iArr[(i3 + 128) & 255];
            this.f5914a = i10;
            int i11 = iArr[(i4 >>> 2) & 255] + i10 + this.f5915b;
            iArr[i3] = i11;
            int[] iArr2 = this.results;
            int i12 = iArr[(i11 >>> 10) & 255] + i4;
            this.f5915b = i12;
            iArr2[i3] = i12;
        }
    }

    private void mix(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.results == null) {
            this.results = new int[256];
        }
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.engineState;
            this.results[i] = 0;
            iArr[i] = 0;
        }
        this.f5916c = 0;
        this.f5915b = 0;
        this.f5914a = 0;
        this.index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i2 = 0; i2 < length; i2 += 4) {
            this.results[i2 >> 2] = byteToIntLittle(bArr2, i2);
        }
        int[] iArr2 = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            iArr2[i3] = -1640531527;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            mix(iArr2);
        }
        int i5 = 0;
        while (i5 < 2) {
            for (int i6 = 0; i6 < 256; i6 += 8) {
                for (int i7 = 0; i7 < 8; i7++) {
                    iArr2[i7] = iArr2[i7] + (i5 < 1 ? this.results[i6 + i7] : this.engineState[i6 + i7]);
                }
                mix(iArr2);
                for (int i8 = 0; i8 < 8; i8++) {
                    this.engineState[i6 + i8] = iArr2[i8];
                }
            }
            i5++;
        }
        isaac();
        this.initialised = true;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException(outline.m256o(cipherParameters, outline.m253r("invalid parameter passed to ISAAC init - ")));
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (this.initialised) {
            if (i + i2 <= bArr.length) {
                if (i3 + i2 > bArr2.length) {
                    throw new DataLengthException("output buffer too short");
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    if (this.index == 0) {
                        isaac();
                        this.keyStream = intToByteLittle(this.results);
                    }
                    byte[] bArr3 = this.keyStream;
                    int i5 = this.index;
                    bArr2[i4 + i3] = (byte) (bArr3[i5] ^ bArr[i4 + i]);
                    this.index = (i5 + 1) & 1023;
                }
                return;
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        if (this.index == 0) {
            isaac();
            this.keyStream = intToByteLittle(this.results);
        }
        byte[] bArr = this.keyStream;
        int i = this.index;
        byte b2 = (byte) (b ^ bArr[i]);
        this.index = (i + 1) & 1023;
        return b2;
    }
}
