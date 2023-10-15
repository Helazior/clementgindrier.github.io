package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CombinedHash implements Digest {
    public TlsClientContext context;
    public MD5Digest md5;
    public SHA1Digest sha1;

    public CombinedHash() {
        this.md5 = new MD5Digest();
        this.sha1 = new SHA1Digest();
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        TlsClientContext tlsClientContext = this.context;
        if (tlsClientContext != null) {
            if (!(tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion())) {
                ssl3Complete(this.md5, SSL3Mac.MD5_IPAD, SSL3Mac.MD5_OPAD);
                ssl3Complete(this.sha1, SSL3Mac.SHA1_IPAD, SSL3Mac.SHA1_OPAD);
            }
        }
        return this.sha1.doFinal(bArr, i + 16) + this.md5.doFinal(bArr, i);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.md5.getAlgorithmName() + " and " + this.sha1.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 36;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.md5.reset();
        this.sha1.reset();
    }

    public void ssl3Complete(Digest digest, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.context.getSecurityParameters().masterSecret;
        digest.update(bArr3, 0, bArr3.length);
        digest.update(bArr, 0, bArr.length);
        int digestSize = digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        digest.doFinal(bArr4, 0);
        digest.update(bArr3, 0, bArr3.length);
        digest.update(bArr2, 0, bArr2.length);
        digest.update(bArr4, 0, digestSize);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b) {
        this.md5.update(b);
        this.sha1.update(b);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.md5.update(bArr, i, i2);
        this.sha1.update(bArr, i, i2);
    }

    public CombinedHash(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
        this.md5 = new MD5Digest();
        this.sha1 = new SHA1Digest();
    }

    public CombinedHash(CombinedHash combinedHash) {
        this.context = combinedHash.context;
        this.md5 = new MD5Digest(combinedHash.md5);
        this.sha1 = new SHA1Digest(combinedHash.sha1);
    }
}
