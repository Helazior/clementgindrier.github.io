package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.p017ec.ECCurve;
import org.spongycastle.math.p017ec.ECPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: G */
    private ECPoint f6115G;
    private ECCurve curve;

    /* renamed from: h */
    private BigInteger f6116h;

    /* renamed from: n */
    private BigInteger f6117n;
    private byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.f6115G = eCPoint;
        this.f6117n = bigInteger;
        this.f6116h = BigInteger.valueOf(1L);
        this.seed = null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
            return getCurve().equals(eCParameterSpec.getCurve()) && getG().equals(eCParameterSpec.getG());
        }
        return false;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f6115G;
    }

    public BigInteger getH() {
        return this.f6116h;
    }

    public BigInteger getN() {
        return this.f6117n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.f6115G = eCPoint;
        this.f6117n = bigInteger;
        this.f6116h = bigInteger2;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f6115G = eCPoint;
        this.f6117n = bigInteger;
        this.f6116h = bigInteger2;
        this.seed = bArr;
    }
}
