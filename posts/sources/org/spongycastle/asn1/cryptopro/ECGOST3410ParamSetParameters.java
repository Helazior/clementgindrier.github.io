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
public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    public ASN1Integer f5644a;

    /* renamed from: b */
    public ASN1Integer f5645b;

    /* renamed from: p */
    public ASN1Integer f5646p;

    /* renamed from: q */
    public ASN1Integer f5647q;

    /* renamed from: x */
    public ASN1Integer f5648x;

    /* renamed from: y */
    public ASN1Integer f5649y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f5644a = new ASN1Integer(bigInteger);
        this.f5645b = new ASN1Integer(bigInteger2);
        this.f5646p = new ASN1Integer(bigInteger3);
        this.f5647q = new ASN1Integer(bigInteger4);
        this.f5648x = new ASN1Integer(i);
        this.f5649y = new ASN1Integer(bigInteger5);
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.f5644a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f5646p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5647q.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5644a);
        aSN1EncodableVector.add(this.f5645b);
        aSN1EncodableVector.add(this.f5646p);
        aSN1EncodableVector.add(this.f5647q);
        aSN1EncodableVector.add(this.f5648x);
        aSN1EncodableVector.add(this.f5649y);
        return new DERSequence(aSN1EncodableVector);
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj != null && !(obj instanceof ECGOST3410ParamSetParameters)) {
            if (obj instanceof ASN1Sequence) {
                return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid GOST3410Parameter: ")));
        }
        return (ECGOST3410ParamSetParameters) obj;
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5644a = (ASN1Integer) objects.nextElement();
        this.f5645b = (ASN1Integer) objects.nextElement();
        this.f5646p = (ASN1Integer) objects.nextElement();
        this.f5647q = (ASN1Integer) objects.nextElement();
        this.f5648x = (ASN1Integer) objects.nextElement();
        this.f5649y = (ASN1Integer) objects.nextElement();
    }
}
