package org.spongycastle.math.p017ec;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.FpNafMultiplier */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FpNafMultiplier implements ECMultiplier {
    @Override // org.spongycastle.math.p017ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        BigInteger multiply = bigInteger.multiply(BigInteger.valueOf(3L));
        ECPoint negate = eCPoint.negate();
        ECPoint eCPoint2 = eCPoint;
        for (int bitLength = multiply.bitLength() - 2; bitLength > 0; bitLength--) {
            eCPoint2 = eCPoint2.twice();
            boolean testBit = multiply.testBit(bitLength);
            if (testBit != bigInteger.testBit(bitLength)) {
                eCPoint2 = eCPoint2.add(testBit ? eCPoint : negate);
            }
        }
        return eCPoint2;
    }
}
