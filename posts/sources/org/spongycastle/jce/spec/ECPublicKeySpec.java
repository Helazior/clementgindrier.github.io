package org.spongycastle.jce.spec;

import org.spongycastle.math.p017ec.ECPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q */
    private ECPoint f6119q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f6119q = eCPoint;
    }

    public ECPoint getQ() {
        return this.f6119q;
    }
}
