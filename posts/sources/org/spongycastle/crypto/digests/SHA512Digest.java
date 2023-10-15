package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.util.Pack;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public SHA512Digest() {
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f5754H1, bArr, i);
        Pack.longToBigEndian(this.f5755H2, bArr, i + 8);
        Pack.longToBigEndian(this.f5756H3, bArr, i + 16);
        Pack.longToBigEndian(this.f5757H4, bArr, i + 24);
        Pack.longToBigEndian(this.f5758H5, bArr, i + 32);
        Pack.longToBigEndian(this.f5759H6, bArr, i + 40);
        Pack.longToBigEndian(this.f5760H7, bArr, i + 48);
        Pack.longToBigEndian(this.f5761H8, bArr, i + 56);
        reset();
        return 64;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-512";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    @Override // org.spongycastle.crypto.digests.LongDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f5754H1 = 7640891576956012808L;
        this.f5755H2 = -4942790177534073029L;
        this.f5756H3 = 4354685564936845355L;
        this.f5757H4 = -6534734903238641935L;
        this.f5758H5 = 5840696475078001361L;
        this.f5759H6 = -7276294671716946913L;
        this.f5760H7 = 2270897969802886507L;
        this.f5761H8 = 6620516959819538809L;
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }
}
