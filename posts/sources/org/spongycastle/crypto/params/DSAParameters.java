package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f5999g;

    /* renamed from: p */
    private BigInteger f6000p;

    /* renamed from: q */
    private BigInteger f6001q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f5999g = bigInteger3;
        this.f6000p = bigInteger;
        this.f6001q = bigInteger2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DSAParameters) {
            DSAParameters dSAParameters = (DSAParameters) obj;
            return dSAParameters.getP().equals(this.f6000p) && dSAParameters.getQ().equals(this.f6001q) && dSAParameters.getG().equals(this.f5999g);
        }
        return false;
    }

    public BigInteger getG() {
        return this.f5999g;
    }

    public BigInteger getP() {
        return this.f6000p;
    }

    public BigInteger getQ() {
        return this.f6001q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f5999g = bigInteger3;
        this.f6000p = bigInteger;
        this.f6001q = bigInteger2;
        this.validation = dSAValidationParameters;
    }
}
