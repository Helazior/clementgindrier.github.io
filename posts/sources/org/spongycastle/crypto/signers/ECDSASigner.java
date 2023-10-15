package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.p017ec.ECAlgorithms;
import org.spongycastle.math.p017ec.ECConstants;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECDSASigner implements ECConstants, DSA {
    public ECKeyParameters key;
    public SecureRandom random;

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        int bitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        if (bitLength >= length) {
            return new BigInteger(1, bArr);
        }
        return new BigInteger(1, bArr).shiftRight(length - bitLength);
    }

    @Override // org.spongycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger bigInteger;
        BigInteger mod;
        BigInteger mod2;
        BigInteger n = this.key.getParameters().getN();
        BigInteger calculateE = calculateE(n, bArr);
        do {
            int bitLength = n.bitLength();
            while (true) {
                BigInteger bigInteger2 = new BigInteger(bitLength, this.random);
                bigInteger = ECConstants.ZERO;
                if (!bigInteger2.equals(bigInteger) && bigInteger2.compareTo(n) < 0) {
                    mod = this.key.getParameters().getG().multiply(bigInteger2).getX().toBigInteger().mod(n);
                    if (!mod.equals(bigInteger)) {
                        mod2 = bigInteger2.modInverse(n).multiply(calculateE.add(((ECPrivateKeyParameters) this.key).getD().multiply(mod))).mod(n);
                    }
                }
            }
        } while (mod2.equals(bigInteger));
        return new BigInteger[]{mod, mod2};
    }

    @Override // org.spongycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
                return;
            }
            this.random = new SecureRandom();
            this.key = (ECPrivateKeyParameters) cipherParameters;
            return;
        }
        this.key = (ECPublicKeyParameters) cipherParameters;
    }

    @Override // org.spongycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n = this.key.getParameters().getN();
        BigInteger calculateE = calculateE(n, bArr);
        BigInteger bigInteger3 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger2.modInverse(n);
        return ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), calculateE.multiply(modInverse).mod(n), ((ECPublicKeyParameters) this.key).getQ(), bigInteger.multiply(modInverse).mod(n)).getX().toBigInteger().mod(n).equals(bigInteger);
    }
}
