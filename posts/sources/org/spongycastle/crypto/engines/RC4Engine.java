package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RC4Engine implements StreamCipher {
    private static final int STATE_LENGTH = 256;
    private byte[] engineState = null;

    /* renamed from: x */
    private int f5921x = 0;

    /* renamed from: y */
    private int f5922y = 0;
    private byte[] workingKey = null;

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        this.f5921x = 0;
        this.f5922y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.engineState[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.engineState;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "RC4";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException(outline.m256o(cipherParameters, outline.m253r("invalid parameter passed to RC4 init - ")));
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 <= bArr.length) {
            if (i3 + i2 > bArr2.length) {
                throw new DataLengthException("output buffer too short");
            }
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (this.f5921x + 1) & 255;
                this.f5921x = i5;
                byte[] bArr3 = this.engineState;
                int i6 = (bArr3[i5] + this.f5922y) & 255;
                this.f5922y = i6;
                byte b = bArr3[i5];
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b;
                bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + bArr3[i6]) & 255] ^ bArr[i4 + i]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        int i = (this.f5921x + 1) & 255;
        this.f5921x = i;
        byte[] bArr = this.engineState;
        int i2 = (bArr[i] + this.f5922y) & 255;
        this.f5922y = i2;
        byte b2 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b2;
        return (byte) (b ^ bArr[(bArr[i] + bArr[i2]) & 255]);
    }
}
