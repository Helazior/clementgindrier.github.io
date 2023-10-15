package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f6009g;

    /* renamed from: l */
    private int f6010l;

    /* renamed from: p */
    private BigInteger f6011p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ElGamalParameters) {
            ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
            return elGamalParameters.getP().equals(this.f6011p) && elGamalParameters.getG().equals(this.f6009g) && elGamalParameters.getL() == this.f6010l;
        }
        return false;
    }

    public BigInteger getG() {
        return this.f6009g;
    }

    public int getL() {
        return this.f6010l;
    }

    public BigInteger getP() {
        return this.f6011p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f6010l;
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f6009g = bigInteger2;
        this.f6011p = bigInteger;
        this.f6010l = i;
    }
}
