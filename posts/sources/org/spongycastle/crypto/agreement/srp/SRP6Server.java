package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SRP6Server {

    /* renamed from: A */
    public BigInteger f5731A;

    /* renamed from: B */
    public BigInteger f5732B;

    /* renamed from: N */
    public BigInteger f5733N;

    /* renamed from: S */
    public BigInteger f5734S;

    /* renamed from: b */
    public BigInteger f5735b;
    public Digest digest;

    /* renamed from: g */
    public BigInteger f5736g;
    public SecureRandom random;

    /* renamed from: u */
    public BigInteger f5737u;

    /* renamed from: v */
    public BigInteger f5738v;

    private BigInteger calculateS() {
        return this.f5738v.modPow(this.f5737u, this.f5733N).multiply(this.f5731A).mod(this.f5733N).modPow(this.f5735b, this.f5733N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.f5733N, bigInteger);
        this.f5731A = validatePublicValue;
        this.f5737u = SRP6Util.calculateU(this.digest, this.f5733N, validatePublicValue, this.f5732B);
        BigInteger calculateS = calculateS();
        this.f5734S = calculateS;
        return calculateS;
    }

    public BigInteger generateServerCredentials() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f5733N, this.f5736g);
        this.f5735b = selectPrivateValue();
        BigInteger mod = calculateK.multiply(this.f5738v).mod(this.f5733N).add(this.f5736g.modPow(this.f5735b, this.f5733N)).mod(this.f5733N);
        this.f5732B = mod;
        return mod;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest, SecureRandom secureRandom) {
        this.f5733N = bigInteger;
        this.f5736g = bigInteger2;
        this.f5738v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest;
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f5733N, this.f5736g, this.random);
    }
}
