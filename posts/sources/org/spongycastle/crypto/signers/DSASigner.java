package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DSASigner implements DSA {
    public DSAKeyParameters key;
    public SecureRandom random;

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int bitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(bArr, 0, bArr2, 0, bitLength);
        return new BigInteger(1, bArr2);
    }

    @Override // org.spongycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger bigInteger;
        DSAParameters parameters = this.key.getParameters();
        BigInteger calculateE = calculateE(parameters.getQ(), bArr);
        int bitLength = parameters.getQ().bitLength();
        do {
            bigInteger = new BigInteger(bitLength, this.random);
        } while (bigInteger.compareTo(parameters.getQ()) >= 0);
        BigInteger mod = parameters.getG().modPow(bigInteger, parameters.getP()).mod(parameters.getQ());
        return new BigInteger[]{mod, bigInteger.modInverse(parameters.getQ()).multiply(calculateE.add(((DSAPrivateKeyParameters) this.key).getX().multiply(mod))).mod(parameters.getQ())};
    }

    @Override // org.spongycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (DSAPrivateKeyParameters) parametersWithRandom.getParameters();
                return;
            }
            this.random = new SecureRandom();
            this.key = (DSAPrivateKeyParameters) cipherParameters;
            return;
        }
        this.key = (DSAPublicKeyParameters) cipherParameters;
    }

    @Override // org.spongycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger calculateE = calculateE(parameters.getQ(), bArr);
        BigInteger valueOf = BigInteger.valueOf(0L);
        if (valueOf.compareTo(bigInteger) >= 0 || parameters.getQ().compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || parameters.getQ().compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger2.modInverse(parameters.getQ());
        return parameters.getG().modPow(calculateE.multiply(modInverse).mod(parameters.getQ()), parameters.getP()).multiply(((DSAPublicKeyParameters) this.key).getY().modPow(bigInteger.multiply(modInverse).mod(parameters.getQ()), parameters.getP())).mod(parameters.getP()).mod(parameters.getQ()).equals(bigInteger);
    }
}
