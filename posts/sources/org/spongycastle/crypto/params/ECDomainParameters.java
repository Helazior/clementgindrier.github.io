package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.p017ec.ECConstants;
import org.spongycastle.math.p017ec.ECCurve;
import org.spongycastle.math.p017ec.ECPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECDomainParameters implements ECConstants {

    /* renamed from: G */
    public ECPoint f6004G;
    public ECCurve curve;

    /* renamed from: h */
    public BigInteger f6005h;

    /* renamed from: n */
    public BigInteger f6006n;
    public byte[] seed;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.f6004G = eCPoint;
        this.f6006n = bigInteger;
        this.f6005h = ECConstants.ONE;
        this.seed = null;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f6004G;
    }

    public BigInteger getH() {
        return this.f6005h;
    }

    public BigInteger getN() {
        return this.f6006n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.f6004G = eCPoint;
        this.f6006n = bigInteger;
        this.f6005h = bigInteger2;
        this.seed = null;
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f6004G = eCPoint;
        this.f6006n = bigInteger;
        this.f6005h = bigInteger2;
        this.seed = bArr;
    }
}
