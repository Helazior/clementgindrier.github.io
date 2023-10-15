package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DSAParameter extends ASN1Object {

    /* renamed from: g */
    public ASN1Integer f5694g;

    /* renamed from: p */
    public ASN1Integer f5695p;

    /* renamed from: q */
    public ASN1Integer f5696q;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f5695p = new ASN1Integer(bigInteger);
        this.f5696q = new ASN1Integer(bigInteger2);
        this.f5694g = new ASN1Integer(bigInteger3);
    }

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getG() {
        return this.f5694g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f5695p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5696q.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5695p);
        aSN1EncodableVector.add(this.f5696q);
        aSN1EncodableVector.add(this.f5694g);
        return new DERSequence(aSN1EncodableVector);
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj != null && !(obj instanceof DSAParameter)) {
            if (obj instanceof ASN1Sequence) {
                return new DSAParameter((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid DSAParameter: ")));
        }
        return (DSAParameter) obj;
    }

    public DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f5695p = DERInteger.getInstance(objects.nextElement());
            this.f5696q = DERInteger.getInstance(objects.nextElement());
            this.f5694g = DERInteger.getInstance(objects.nextElement());
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }
}
