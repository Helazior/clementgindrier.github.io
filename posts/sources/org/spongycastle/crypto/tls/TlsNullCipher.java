package org.spongycastle.crypto.tls;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsNullCipher implements TlsCipher {
    public byte[] copyData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(short s, byte[] bArr, int i, int i2) {
        return copyData(bArr, i, i2);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(short s, byte[] bArr, int i, int i2) {
        return copyData(bArr, i, i2);
    }
}
