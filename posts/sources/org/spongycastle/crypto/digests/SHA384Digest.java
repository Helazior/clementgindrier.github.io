package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.util.Pack;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SHA384Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 48;

    public SHA384Digest() {
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
        reset();
        return 48;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-384";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 48;
    }

    @Override // org.spongycastle.crypto.digests.LongDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f5754H1 = -3766243637369397544L;
        this.f5755H2 = 7105036623409894663L;
        this.f5756H3 = -7973340178411365097L;
        this.f5757H4 = 1526699215303891257L;
        this.f5758H5 = 7436329637833083697L;
        this.f5759H6 = -8163818279084223215L;
        this.f5760H7 = -2662702644619276377L;
        this.f5761H8 = 5167115440072839076L;
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
    }
}
