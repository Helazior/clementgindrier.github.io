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
public class ECGOST3410Signer implements DSA {
    public ECKeyParameters key;
    public SecureRandom random;

    @Override // org.spongycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger = new BigInteger(1, bArr2);
        BigInteger n = this.key.getParameters().getN();
        while (true) {
            BigInteger bigInteger2 = new BigInteger(n.bitLength(), this.random);
            BigInteger bigInteger3 = ECConstants.ZERO;
            if (!bigInteger2.equals(bigInteger3)) {
                BigInteger mod = this.key.getParameters().getG().multiply(bigInteger2).getX().toBigInteger().mod(n);
                if (mod.equals(bigInteger3)) {
                    continue;
                } else {
                    BigInteger mod2 = bigInteger2.multiply(bigInteger).add(((ECPrivateKeyParameters) this.key).getD().multiply(mod)).mod(n);
                    if (!mod2.equals(bigInteger3)) {
                        return new BigInteger[]{mod, mod2};
                    }
                }
            }
        }
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
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        BigInteger n = this.key.getParameters().getN();
        BigInteger bigInteger4 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger3.modInverse(n);
        return ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), bigInteger2.multiply(modInverse).mod(n), ((ECPublicKeyParameters) this.key).getQ(), n.subtract(bigInteger).multiply(modInverse).mod(n)).getX().toBigInteger().mod(n).equals(bigInteger);
    }
}
