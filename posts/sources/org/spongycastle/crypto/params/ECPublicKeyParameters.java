package org.spongycastle.crypto.params;

import org.spongycastle.math.p017ec.ECPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: Q */
    public ECPoint f6008Q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f6008Q = eCPoint;
    }

    public ECPoint getQ() {
        return this.f6008Q;
    }
}
