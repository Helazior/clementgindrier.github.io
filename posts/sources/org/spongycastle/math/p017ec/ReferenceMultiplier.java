package org.spongycastle.math.p017ec;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.ReferenceMultiplier */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ReferenceMultiplier implements ECMultiplier {
    @Override // org.spongycastle.math.p017ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int bitLength = bigInteger.bitLength();
        for (int i = 0; i < bitLength; i++) {
            if (bigInteger.testBit(i)) {
                infinity = infinity.add(eCPoint);
            }
            eCPoint = eCPoint.twice();
        }
        return infinity;
    }
}
