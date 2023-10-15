package org.spongycastle.math.p017ec;

import java.math.BigInteger;
import org.spongycastle.math.p017ec.ECCurve;

/* renamed from: org.spongycastle.math.ec.ECAlgorithms */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECAlgorithms {
    private static ECPoint implShamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        int max = Math.max(bigInteger.bitLength(), bigInteger2.bitLength());
        ECPoint add = eCPoint.add(eCPoint2);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        for (int i = max - 1; i >= 0; i--) {
            infinity = infinity.twice();
            if (bigInteger.testBit(i)) {
                if (bigInteger2.testBit(i)) {
                    infinity = infinity.add(add);
                } else {
                    infinity = infinity.add(eCPoint);
                }
            } else if (bigInteger2.testBit(i)) {
                infinity = infinity.add(eCPoint2);
            }
        }
        return infinity;
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            return implShamirsTrick(eCPoint, bigInteger, eCPoint2, bigInteger2);
        }
        throw new IllegalArgumentException("P and Q must be on same curve");
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        if (curve.equals(eCPoint2.getCurve())) {
            if ((curve instanceof ECCurve.F2m) && ((ECCurve.F2m) curve).isKoblitz()) {
                return eCPoint.multiply(bigInteger).add(eCPoint2.multiply(bigInteger2));
            }
            return implShamirsTrick(eCPoint, bigInteger, eCPoint2, bigInteger2);
        }
        throw new IllegalArgumentException("P and Q must be on same curve");
    }
}
