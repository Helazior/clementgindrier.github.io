package org.spongycastle.jce.spec;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECPrivateKeySpec extends ECKeySpec {

    /* renamed from: d */
    private BigInteger f6118d;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f6118d = bigInteger;
    }

    public BigInteger getD() {
        return this.f6118d;
    }
}
