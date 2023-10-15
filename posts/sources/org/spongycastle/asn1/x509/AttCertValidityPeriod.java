package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AttCertValidityPeriod extends ASN1Object {
    public DERGeneralizedTime notAfterTime;
    public DERGeneralizedTime notBeforeTime;

    private AttCertValidityPeriod(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.notBeforeTime = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(0));
            this.notAfterTime = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }

    public static AttCertValidityPeriod getInstance(Object obj) {
        if (obj instanceof AttCertValidityPeriod) {
            return (AttCertValidityPeriod) obj;
        }
        if (obj != null) {
            return new AttCertValidityPeriod(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERGeneralizedTime getNotAfterTime() {
        return this.notAfterTime;
    }

    public DERGeneralizedTime getNotBeforeTime() {
        return this.notBeforeTime;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.notBeforeTime);
        aSN1EncodableVector.add(this.notAfterTime);
        return new DERSequence(aSN1EncodableVector);
    }

    public AttCertValidityPeriod(DERGeneralizedTime dERGeneralizedTime, DERGeneralizedTime dERGeneralizedTime2) {
        this.notBeforeTime = dERGeneralizedTime;
        this.notAfterTime = dERGeneralizedTime2;
    }
}
