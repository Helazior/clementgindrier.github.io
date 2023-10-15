package org.spongycastle.asn1.p012x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.p017ec.ECCurve;
import org.spongycastle.math.p017ec.ECPoint;

/* renamed from: org.spongycastle.asn1.x9.X9ECParameters */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private ECCurve curve;
    private X9FieldID fieldID;

    /* renamed from: g */
    private ECPoint f5714g;

    /* renamed from: h */
    private BigInteger f5715h;

    /* renamed from: n */
    private BigInteger f5716n;
    private byte[] seed;

    private X9ECParameters(ASN1Sequence aSN1Sequence) {
        if ((aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) && ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().equals(ONE)) {
            X9Curve x9Curve = new X9Curve(new X9FieldID((ASN1Sequence) aSN1Sequence.getObjectAt(1)), (ASN1Sequence) aSN1Sequence.getObjectAt(2));
            ECCurve curve = x9Curve.getCurve();
            this.curve = curve;
            this.f5714g = new X9ECPoint(curve, (ASN1OctetString) aSN1Sequence.getObjectAt(3)).getPoint();
            this.f5716n = ((ASN1Integer) aSN1Sequence.getObjectAt(4)).getValue();
            this.seed = x9Curve.getSeed();
            if (aSN1Sequence.size() == 6) {
                this.f5715h = ((ASN1Integer) aSN1Sequence.getObjectAt(5)).getValue();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("bad version in X9ECParameters");
    }

    public static X9ECParameters getInstance(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        if (obj != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f5714g;
    }

    public BigInteger getH() {
        BigInteger bigInteger = this.f5715h;
        return bigInteger == null ? ONE : bigInteger;
    }

    public BigInteger getN() {
        return this.f5716n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(1));
        aSN1EncodableVector.add(this.fieldID);
        aSN1EncodableVector.add(new X9Curve(this.curve, this.seed));
        aSN1EncodableVector.add(new X9ECPoint(this.f5714g));
        aSN1EncodableVector.add(new ASN1Integer(this.f5716n));
        BigInteger bigInteger = this.f5715h;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ONE, null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f5714g = eCPoint;
        this.f5716n = bigInteger;
        this.f5715h = bigInteger2;
        this.seed = bArr;
        if (eCCurve instanceof ECCurve.C2160Fp) {
            this.fieldID = new X9FieldID(((ECCurve.C2160Fp) eCCurve).getQ());
        } else if (eCCurve instanceof ECCurve.F2m) {
            ECCurve.F2m f2m = (ECCurve.F2m) eCCurve;
            this.fieldID = new X9FieldID(f2m.getM(), f2m.getK1(), f2m.getK2(), f2m.getK3());
        }
    }
}
