package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f6120g;

    /* renamed from: p */
    private BigInteger f6121p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f6121p = bigInteger;
        this.f6120g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f6120g;
    }

    public BigInteger getP() {
        return this.f6121p;
    }
}
