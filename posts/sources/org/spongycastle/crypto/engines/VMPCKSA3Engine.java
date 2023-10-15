package org.spongycastle.crypto.engines;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class VMPCKSA3Engine extends VMPCEngine {
    @Override // org.spongycastle.crypto.engines.VMPCEngine, org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC-KSA3";
    }

    @Override // org.spongycastle.crypto.engines.VMPCEngine
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
        for (int i6 = 0; i6 < 768; i6++) {
            byte[] bArr5 = this.f5945P;
            int i7 = i6 & 255;
            byte b5 = bArr5[(this.f5947s + bArr5[i7] + bArr[i6 % bArr.length]) & 255];
            this.f5947s = b5;
            byte b6 = bArr5[i7];
            bArr5[i7] = bArr5[b5 & 255];
            bArr5[b5 & 255] = b6;
        }
        this.f5946n = (byte) 0;
    }
}
