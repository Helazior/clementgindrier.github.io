package org.spongycastle.math.ntru.euclid;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BigIntEuclidean {
    public BigInteger gcd;

    /* renamed from: x */
    public BigInteger f6159x;

    /* renamed from: y */
    public BigInteger f6160y;

    private BigIntEuclidean() {
    }

    public static BigIntEuclidean calculate(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ZERO;
        BigInteger bigInteger4 = BigInteger.ONE;
        BigInteger bigInteger5 = bigInteger4;
        BigInteger bigInteger6 = bigInteger3;
        BigInteger bigInteger7 = bigInteger;
        BigInteger bigInteger8 = bigInteger2;
        while (!bigInteger8.equals(BigInteger.ZERO)) {
            BigInteger[] divideAndRemainder = bigInteger7.divideAndRemainder(bigInteger8);
            BigInteger bigInteger9 = divideAndRemainder[0];
            BigInteger bigInteger10 = divideAndRemainder[1];
            BigInteger subtract = bigInteger5.subtract(bigInteger9.multiply(bigInteger6));
            bigInteger7 = bigInteger8;
            bigInteger8 = bigInteger10;
            BigInteger bigInteger11 = bigInteger4;
            bigInteger4 = bigInteger3.subtract(bigInteger9.multiply(bigInteger4));
            bigInteger3 = bigInteger11;
            bigInteger5 = bigInteger6;
            bigInteger6 = subtract;
        }
        BigIntEuclidean bigIntEuclidean = new BigIntEuclidean();
        bigIntEuclidean.f6159x = bigInteger5;
        bigIntEuclidean.f6160y = bigInteger3;
        bigIntEuclidean.gcd = bigInteger7;
        return bigIntEuclidean;
    }
}
