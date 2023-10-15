package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f6132a;

    /* renamed from: p */
    private BigInteger f6133p;

    /* renamed from: q */
    private BigInteger f6134q;

    /* renamed from: y */
    private BigInteger f6135y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f6135y = bigInteger;
        this.f6133p = bigInteger2;
        this.f6134q = bigInteger3;
        this.f6132a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f6132a;
    }

    public BigInteger getP() {
        return this.f6133p;
    }

    public BigInteger getQ() {
        return this.f6134q;
    }

    public BigInteger getY() {
        return this.f6135y;
    }
}
