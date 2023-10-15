package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.spongycastle.crypto.Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SRP6VerifierGenerator {

    /* renamed from: N */
    public BigInteger f5739N;
    public Digest digest;

    /* renamed from: g */
    public BigInteger f5740g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f5740g.modPow(SRP6Util.calculateX(this.digest, this.f5739N, bArr, bArr2, bArr3), this.f5739N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest) {
        this.f5739N = bigInteger;
        this.f5740g = bigInteger2;
        this.digest = digest;
    }
}
