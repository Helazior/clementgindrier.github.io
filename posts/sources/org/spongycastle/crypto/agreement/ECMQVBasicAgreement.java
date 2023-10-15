package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.math.p017ec.ECAlgorithms;
import org.spongycastle.math.p017ec.ECConstants;
import org.spongycastle.math.p017ec.ECPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECMQVBasicAgreement implements BasicAgreement {
    public MQVPrivateParameters privParams;

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        ECPoint q;
        BigInteger n = eCDomainParameters.getN();
        int bitLength = (n.bitLength() + 1) / 2;
        BigInteger shiftLeft = ECConstants.ONE.shiftLeft(bitLength);
        if (eCPublicKeyParameters == null) {
            q = eCDomainParameters.getG().multiply(eCPrivateKeyParameters2.getD());
        } else {
            q = eCPublicKeyParameters.getQ();
        }
        BigInteger mod = eCPrivateKeyParameters.getD().multiply(q.getX().toBigInteger().mod(shiftLeft).setBit(bitLength)).mod(n).add(eCPrivateKeyParameters2.getD()).mod(n);
        BigInteger bit = eCPublicKeyParameters3.getQ().getX().toBigInteger().mod(shiftLeft).setBit(bitLength);
        BigInteger mod2 = eCDomainParameters.getH().multiply(mod).mod(n);
        ECPoint sumOfTwoMultiplies = ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters2.getQ(), bit.multiply(mod2).mod(n), eCPublicKeyParameters3.getQ(), mod2);
        if (sumOfTwoMultiplies.isInfinity()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        }
        return sumOfTwoMultiplies;
    }

    @Override // org.spongycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        return calculateMqvAgreement(staticPrivateKey.getParameters(), staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).getX().toBigInteger();
    }

    @Override // org.spongycastle.crypto.BasicAgreement
    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters) cipherParameters;
    }
}
