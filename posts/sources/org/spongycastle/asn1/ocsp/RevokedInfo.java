package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEREnumerated;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.CRLReason;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RevokedInfo extends ASN1Object {
    private CRLReason revocationReason;
    private DERGeneralizedTime revocationTime;

    public RevokedInfo(DERGeneralizedTime dERGeneralizedTime, CRLReason cRLReason) {
        this.revocationTime = dERGeneralizedTime;
        this.revocationReason = cRLReason;
    }

    public static RevokedInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public CRLReason getRevocationReason() {
        return this.revocationReason;
    }

    public DERGeneralizedTime getRevocationTime() {
        return this.revocationTime;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.revocationTime);
        CRLReason cRLReason = this.revocationReason;
        if (cRLReason != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, cRLReason));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static RevokedInfo getInstance(Object obj) {
        if (obj instanceof RevokedInfo) {
            return (RevokedInfo) obj;
        }
        if (obj != null) {
            return new RevokedInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private RevokedInfo(ASN1Sequence aSN1Sequence) {
        this.revocationTime = (DERGeneralizedTime) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.size() > 1) {
            this.revocationReason = CRLReason.getInstance(DEREnumerated.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true));
        }
    }
}
