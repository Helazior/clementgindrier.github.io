package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f6061dP;

    /* renamed from: dQ */
    private BigInteger f6062dQ;

    /* renamed from: e */
    private BigInteger f6063e;

    /* renamed from: p */
    private BigInteger f6064p;

    /* renamed from: q */
    private BigInteger f6065q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f6063e = bigInteger2;
        this.f6064p = bigInteger4;
        this.f6065q = bigInteger5;
        this.f6061dP = bigInteger6;
        this.f6062dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.f6061dP;
    }

    public BigInteger getDQ() {
        return this.f6062dQ;
    }

    public BigInteger getP() {
        return this.f6064p;
    }

    public BigInteger getPublicExponent() {
        return this.f6063e;
    }

    public BigInteger getQ() {
        return this.f6065q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
