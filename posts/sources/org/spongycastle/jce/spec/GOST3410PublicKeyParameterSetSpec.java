package org.spongycastle.jce.spec;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f6129a;

    /* renamed from: p */
    private BigInteger f6130p;

    /* renamed from: q */
    private BigInteger f6131q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6130p = bigInteger;
        this.f6131q = bigInteger2;
        this.f6129a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GOST3410PublicKeyParameterSetSpec) {
            GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
            return this.f6129a.equals(gOST3410PublicKeyParameterSetSpec.f6129a) && this.f6130p.equals(gOST3410PublicKeyParameterSetSpec.f6130p) && this.f6131q.equals(gOST3410PublicKeyParameterSetSpec.f6131q);
        }
        return false;
    }

    public BigInteger getA() {
        return this.f6129a;
    }

    public BigInteger getP() {
        return this.f6130p;
    }

    public BigInteger getQ() {
        return this.f6131q;
    }

    public int hashCode() {
        return (this.f6129a.hashCode() ^ this.f6130p.hashCode()) ^ this.f6131q.hashCode();
    }
}
