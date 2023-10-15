package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class VMPCEngine implements StreamCipher {
    public byte[] workingIV;
    public byte[] workingKey;

    /* renamed from: n */
    public byte f5946n = 0;

    /* renamed from: P */
    public byte[] f5945P = null;

    /* renamed from: s */
    public byte f5947s = 0;

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv != null && iv.length >= 1 && iv.length <= 768) {
                    byte[] key = keyParameter.getKey();
                    this.workingKey = key;
                    initKey(key, this.workingIV);
                    return;
                }
                throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    public void initKey(byte[] bArr, byte[] bArr2) {
        this.f5947s = (byte) 0;
        this.f5945P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f5945P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f5945P;
            int i3 = i2 & 255;
            byte b = bArr3[(this.f5947s + bArr3[i3] + bArr[i2 % bArr.length]) & 255];
            this.f5947s = b;
            byte b2 = bArr3[i3];
            bArr3[i3] = bArr3[b & 255];
            bArr3[b & 255] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f5945P;
            int i5 = i4 & 255;
            byte b3 = bArr4[(this.f5947s + bArr4[i5] + bArr2[i4 % bArr2.length]) & 255];
            this.f5947s = b3;
            byte b4 = bArr4[i5];
            bArr4[i5] = bArr4[b3 & 255];
            bArr4[b3 & 255] = b4;
        }
        this.f5946n = (byte) 0;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 <= bArr.length) {
            if (i3 + i2 > bArr2.length) {
                throw new DataLengthException("output buffer too short");
            }
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr3 = this.f5945P;
                byte b = this.f5947s;
                byte b2 = this.f5946n;
                byte b3 = bArr3[(b + bArr3[b2 & 255]) & 255];
                this.f5947s = b3;
                byte b4 = bArr3[(bArr3[bArr3[b3 & 255] & 255] + 1) & 255];
                byte b5 = bArr3[b2 & 255];
                bArr3[b2 & 255] = bArr3[b3 & 255];
                bArr3[b3 & 255] = b5;
                this.f5946n = (byte) ((b2 + 1) & 255);
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ b4);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        byte[] bArr = this.f5945P;
        byte b2 = this.f5947s;
        byte b3 = this.f5946n;
        byte b4 = bArr[(b2 + bArr[b3 & 255]) & 255];
        this.f5947s = b4;
        byte b5 = bArr[(bArr[bArr[b4 & 255] & 255] + 1) & 255];
        byte b6 = bArr[b3 & 255];
        bArr[b3 & 255] = bArr[b4 & 255];
        bArr[b4 & 255] = b6;
        this.f5946n = (byte) ((b3 + 1) & 255);
        return (byte) (b ^ b5);
    }
}
