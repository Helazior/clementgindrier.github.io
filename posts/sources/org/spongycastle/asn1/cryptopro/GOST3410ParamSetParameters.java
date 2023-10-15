package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    public ASN1Integer f5651a;
    public int keySize;

    /* renamed from: p */
    public ASN1Integer f5652p;

    /* renamed from: q */
    public ASN1Integer f5653q;

    public GOST3410ParamSetParameters(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.keySize = i;
        this.f5652p = new ASN1Integer(bigInteger);
        this.f5653q = new ASN1Integer(bigInteger2);
        this.f5651a = new ASN1Integer(bigInteger3);
    }

    public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.f5651a.getPositiveValue();
    }

    public int getKeySize() {
        return this.keySize;
    }

    public int getLKeySize() {
        return this.keySize;
    }

    public BigInteger getP() {
        return this.f5652p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5653q.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(this.keySize));
        aSN1EncodableVector.add(this.f5652p);
        aSN1EncodableVector.add(this.f5653q);
        aSN1EncodableVector.add(this.f5651a);
        return new DERSequence(aSN1EncodableVector);
    }

    public static GOST3410ParamSetParameters getInstance(Object obj) {
        if (obj != null && !(obj instanceof GOST3410ParamSetParameters)) {
            if (obj instanceof ASN1Sequence) {
                return new GOST3410ParamSetParameters((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid GOST3410Parameter: ")));
        }
        return (GOST3410ParamSetParameters) obj;
    }

    public GOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.keySize = ((ASN1Integer) objects.nextElement()).getValue().intValue();
        this.f5652p = (ASN1Integer) objects.nextElement();
        this.f5653q = (ASN1Integer) objects.nextElement();
        this.f5651a = (ASN1Integer) objects.nextElement();
    }
}
