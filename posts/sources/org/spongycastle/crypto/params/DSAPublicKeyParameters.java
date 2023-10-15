package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DSAPublicKeyParameters extends DSAKeyParameters {

    /* renamed from: y */
    private BigInteger f6003y;

    public DSAPublicKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(false, dSAParameters);
        this.f6003y = bigInteger;
    }

    public BigInteger getY() {
        return this.f6003y;
    }
}
