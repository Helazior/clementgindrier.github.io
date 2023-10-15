package org.spongycastle.math.ntru.polynomial;

import java.math.BigInteger;
import org.spongycastle.math.ntru.euclid.BigIntEuclidean;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ModularResultant extends Resultant {
    public BigInteger modulus;

    public ModularResultant(BigIntPolynomial bigIntPolynomial, BigInteger bigInteger, BigInteger bigInteger2) {
        super(bigIntPolynomial, bigInteger);
        this.modulus = bigInteger2;
    }

    public static ModularResultant combineRho(ModularResultant modularResultant, ModularResultant modularResultant2) {
        BigInteger bigInteger = modularResultant.modulus;
        BigInteger bigInteger2 = modularResultant2.modulus;
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        BigIntEuclidean calculate = BigIntEuclidean.calculate(bigInteger2, bigInteger);
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) modularResultant.rho.clone();
        bigIntPolynomial.mult(calculate.f6159x.multiply(bigInteger2));
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) modularResultant2.rho.clone();
        bigIntPolynomial2.mult(calculate.f6160y.multiply(bigInteger));
        bigIntPolynomial.add(bigIntPolynomial2);
        bigIntPolynomial.mod(multiply);
        return new ModularResultant(bigIntPolynomial, null, multiply);
    }
}
