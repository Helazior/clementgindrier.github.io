package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CertificatePair extends ASN1Object {
    private X509CertificateStructure forward;
    private X509CertificateStructure reverse;

    private CertificatePair(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 1 && aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
        }
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.forward = X509CertificateStructure.getInstance(aSN1TaggedObject, true);
            } else if (aSN1TaggedObject.getTagNo() == 1) {
                this.reverse = X509CertificateStructure.getInstance(aSN1TaggedObject, true);
            } else {
                throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("Bad tag number: ")));
            }
        }
    }

    public static CertificatePair getInstance(Object obj) {
        if (obj != null && !(obj instanceof CertificatePair)) {
            if (obj instanceof ASN1Sequence) {
                return new CertificatePair((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (CertificatePair) obj;
    }

    public X509CertificateStructure getForward() {
        return this.forward;
    }

    public X509CertificateStructure getReverse() {
        return this.reverse;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        X509CertificateStructure x509CertificateStructure = this.forward;
        if (x509CertificateStructure != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, x509CertificateStructure));
        }
        X509CertificateStructure x509CertificateStructure2 = this.reverse;
        if (x509CertificateStructure2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(1, x509CertificateStructure2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificatePair(X509CertificateStructure x509CertificateStructure, X509CertificateStructure x509CertificateStructure2) {
        this.forward = x509CertificateStructure;
        this.reverse = x509CertificateStructure2;
    }
}
