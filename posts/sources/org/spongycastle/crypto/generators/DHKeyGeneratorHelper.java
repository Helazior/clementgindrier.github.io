package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.util.BigIntegers;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHKeyGeneratorHelper {
    public static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    public BigInteger calculatePrivate(DHParameters dHParameters, SecureRandom secureRandom) {
        BigInteger p = dHParameters.getP();
        int l = dHParameters.getL();
        if (l != 0) {
            return new BigInteger(l, secureRandom).setBit(l - 1);
        }
        BigInteger bigInteger = TWO;
        int m = dHParameters.getM();
        BigInteger shiftLeft = m != 0 ? ONE.shiftLeft(m - 1) : bigInteger;
        BigInteger subtract = p.subtract(bigInteger);
        BigInteger q = dHParameters.getQ();
        if (q != null) {
            subtract = q.subtract(bigInteger);
        }
        return BigIntegers.createRandomInRange(shiftLeft, subtract, secureRandom);
    }

    public BigInteger calculatePublic(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.getG().modPow(bigInteger, dHParameters.getP());
    }
}
