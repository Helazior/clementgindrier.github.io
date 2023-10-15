package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.PolicyInformation;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OtherSigningCertificate extends ASN1Object {
    public ASN1Sequence certs;
    public ASN1Sequence policies;

    private OtherSigningCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1 && aSN1Sequence.size() <= 2) {
            this.certs = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0));
            if (aSN1Sequence.size() > 1) {
                this.policies = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }

    public static OtherSigningCertificate getInstance(Object obj) {
        if (obj instanceof OtherSigningCertificate) {
            return (OtherSigningCertificate) obj;
        }
        if (obj != null) {
            return new OtherSigningCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OtherCertID[] getCerts() {
        OtherCertID[] otherCertIDArr = new OtherCertID[this.certs.size()];
        for (int i = 0; i != this.certs.size(); i++) {
            otherCertIDArr[i] = OtherCertID.getInstance(this.certs.getObjectAt(i));
        }
        return otherCertIDArr;
    }

    public PolicyInformation[] getPolicies() {
        ASN1Sequence aSN1Sequence = this.policies;
        if (aSN1Sequence == null) {
            return null;
        }
        PolicyInformation[] policyInformationArr = new PolicyInformation[aSN1Sequence.size()];
        for (int i = 0; i != this.policies.size(); i++) {
            policyInformationArr[i] = PolicyInformation.getInstance(this.policies.getObjectAt(i));
        }
        return policyInformationArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certs);
        ASN1Sequence aSN1Sequence = this.policies;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public OtherSigningCertificate(OtherCertID otherCertID) {
        this.certs = new DERSequence(otherCertID);
    }
}
