package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f6125a;

    /* renamed from: p */
    private BigInteger f6126p;

    /* renamed from: q */
    private BigInteger f6127q;

    /* renamed from: x */
    private BigInteger f6128x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f6128x = bigInteger;
        this.f6126p = bigInteger2;
        this.f6127q = bigInteger3;
        this.f6125a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f6125a;
    }

    public BigInteger getP() {
        return this.f6126p;
    }

    public BigInteger getQ() {
        return this.f6127q;
    }

    public BigInteger getX() {
        return this.f6128x;
    }
}
