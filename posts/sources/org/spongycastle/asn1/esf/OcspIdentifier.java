package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.ocsp.ResponderID;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OcspIdentifier extends ASN1Object {
    private ResponderID ocspResponderID;
    private DERGeneralizedTime producedAt;

    private OcspIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.ocspResponderID = ResponderID.getInstance(aSN1Sequence.getObjectAt(0));
            this.producedAt = (DERGeneralizedTime) aSN1Sequence.getObjectAt(1);
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }

    public static OcspIdentifier getInstance(Object obj) {
        if (obj instanceof OcspIdentifier) {
            return (OcspIdentifier) obj;
        }
        if (obj != null) {
            return new OcspIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ResponderID getOcspResponderID() {
        return this.ocspResponderID;
    }

    public DERGeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.ocspResponderID);
        aSN1EncodableVector.add(this.producedAt);
        return new DERSequence(aSN1EncodableVector);
    }

    public OcspIdentifier(ResponderID responderID, DERGeneralizedTime dERGeneralizedTime) {
        this.ocspResponderID = responderID;
        this.producedAt = dERGeneralizedTime;
    }
}
