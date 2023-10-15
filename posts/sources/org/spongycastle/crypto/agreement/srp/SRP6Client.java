package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SRP6Client {

    /* renamed from: A */
    public BigInteger f5723A;

    /* renamed from: B */
    public BigInteger f5724B;

    /* renamed from: N */
    public BigInteger f5725N;

    /* renamed from: S */
    public BigInteger f5726S;

    /* renamed from: a */
    public BigInteger f5727a;
    public Digest digest;

    /* renamed from: g */
    public BigInteger f5728g;
    public SecureRandom random;

    /* renamed from: u */
    public BigInteger f5729u;

    /* renamed from: x */
    public BigInteger f5730x;

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f5725N, this.f5728g);
        return this.f5724B.subtract(this.f5728g.modPow(this.f5730x, this.f5725N).multiply(calculateK).mod(this.f5725N)).mod(this.f5725N).modPow(this.f5729u.multiply(this.f5730x).add(this.f5727a), this.f5725N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f5725N, bigInteger);
        this.f5724B = validatePublicValue;
        this.f5729u = SRP6Util.calculateU(this.digest, this.f5725N, this.f5723A, validatePublicValue);
        BigInteger calculateS = calculateS();
        this.f5726S = calculateS;
        return calculateS;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f5730x = SRP6Util.calculateX(this.digest, this.f5725N, bArr, bArr2, bArr3);
        BigInteger selectPrivateValue = selectPrivateValue();
        this.f5727a = selectPrivateValue;
        BigInteger modPow = this.f5728g.modPow(selectPrivateValue, this.f5725N);
        this.f5723A = modPow;
        return modPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest, SecureRandom secureRandom) {
        this.f5725N = bigInteger;
        this.f5728g = bigInteger2;
        this.digest = digest;
        this.random = secureRandom;
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f5725N, this.f5728g, this.random);
    }
}
