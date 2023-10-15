package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class V2Form extends ASN1Object {
    public IssuerSerial baseCertificateID;
    public GeneralNames issuerName;
    public ObjectDigestInfo objectDigestInfo;

    public V2Form(GeneralNames generalNames) {
        this.issuerName = generalNames;
    }

    public static V2Form getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getIssuerName() {
        return this.issuerName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.issuerName;
        if (generalNames != null) {
            aSN1EncodableVector.add(generalNames);
        }
        IssuerSerial issuerSerial = this.baseCertificateID;
        if (issuerSerial != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, issuerSerial));
        }
        ObjectDigestInfo objectDigestInfo = this.objectDigestInfo;
        if (objectDigestInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, objectDigestInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static V2Form getInstance(Object obj) {
        if (obj != null && !(obj instanceof V2Form)) {
            if (obj instanceof ASN1Sequence) {
                return new V2Form((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("unknown object in factory: ")));
        }
        return (V2Form) obj;
    }

    public V2Form(ASN1Sequence aSN1Sequence) {
        int i;
        if (aSN1Sequence.size() <= 3) {
            if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
                i = 0;
            } else {
                this.issuerName = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
                i = 1;
            }
            while (i != aSN1Sequence.size()) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.baseCertificateID = IssuerSerial.getInstance(aSN1TaggedObject, false);
                } else if (aSN1TaggedObject.getTagNo() == 1) {
                    this.objectDigestInfo = ObjectDigestInfo.getInstance(aSN1TaggedObject, false);
                } else {
                    throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("Bad tag number: ")));
                }
                i++;
            }
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }
}
