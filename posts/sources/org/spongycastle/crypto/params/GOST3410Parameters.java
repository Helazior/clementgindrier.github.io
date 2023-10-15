package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a */
    private BigInteger f6014a;

    /* renamed from: p */
    private BigInteger f6015p;

    /* renamed from: q */
    private BigInteger f6016q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6015p = bigInteger;
        this.f6016q = bigInteger2;
        this.f6014a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GOST3410Parameters) {
            GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
            return gOST3410Parameters.getP().equals(this.f6015p) && gOST3410Parameters.getQ().equals(this.f6016q) && gOST3410Parameters.getA().equals(this.f6014a);
        }
        return false;
    }

    public BigInteger getA() {
        return this.f6014a;
    }

    public BigInteger getP() {
        return this.f6015p;
    }

    public BigInteger getQ() {
        return this.f6016q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f6015p.hashCode() ^ this.f6016q.hashCode()) ^ this.f6014a.hashCode();
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f6014a = bigInteger3;
        this.f6015p = bigInteger;
        this.f6016q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }
}
