package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECPrivateKeyParameters extends ECKeyParameters {

    /* renamed from: d */
    public BigInteger f6007d;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        this.f6007d = bigInteger;
    }

    public BigInteger getD() {
        return this.f6007d;
    }
}
