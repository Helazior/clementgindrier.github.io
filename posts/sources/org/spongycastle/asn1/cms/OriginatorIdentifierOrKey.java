package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OriginatorIdentifierOrKey extends ASN1Object implements ASN1Choice {

    /* renamed from: id */
    private ASN1Encodable f5641id;

    public OriginatorIdentifierOrKey(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f5641id = issuerAndSerialNumber;
    }

    public static OriginatorIdentifierOrKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
    }

    public ASN1Encodable getId() {
        return this.f5641id;
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        ASN1Encodable aSN1Encodable = this.f5641id;
        if (aSN1Encodable instanceof IssuerAndSerialNumber) {
            return (IssuerAndSerialNumber) aSN1Encodable;
        }
        return null;
    }

    public OriginatorPublicKey getOriginatorKey() {
        ASN1Encodable aSN1Encodable = this.f5641id;
        if ((aSN1Encodable instanceof ASN1TaggedObject) && ((ASN1TaggedObject) aSN1Encodable).getTagNo() == 1) {
            return OriginatorPublicKey.getInstance((ASN1TaggedObject) this.f5641id, false);
        }
        return null;
    }

    public SubjectKeyIdentifier getSubjectKeyIdentifier() {
        ASN1Encodable aSN1Encodable = this.f5641id;
        if ((aSN1Encodable instanceof ASN1TaggedObject) && ((ASN1TaggedObject) aSN1Encodable).getTagNo() == 0) {
            return SubjectKeyIdentifier.getInstance((ASN1TaggedObject) this.f5641id, false);
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f5641id.toASN1Primitive();
    }

    public OriginatorIdentifierOrKey(ASN1OctetString aSN1OctetString) {
        this(new SubjectKeyIdentifier(aSN1OctetString.getOctets()));
    }

    public static OriginatorIdentifierOrKey getInstance(Object obj) {
        if (obj != null && !(obj instanceof OriginatorIdentifierOrKey)) {
            if (obj instanceof IssuerAndSerialNumber) {
                return new OriginatorIdentifierOrKey((IssuerAndSerialNumber) obj);
            }
            if (obj instanceof SubjectKeyIdentifier) {
                return new OriginatorIdentifierOrKey((SubjectKeyIdentifier) obj);
            }
            if (obj instanceof OriginatorPublicKey) {
                return new OriginatorIdentifierOrKey((OriginatorPublicKey) obj);
            }
            if (obj instanceof ASN1TaggedObject) {
                return new OriginatorIdentifierOrKey((ASN1TaggedObject) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid OriginatorIdentifierOrKey: ")));
        }
        return (OriginatorIdentifierOrKey) obj;
    }

    public OriginatorIdentifierOrKey(SubjectKeyIdentifier subjectKeyIdentifier) {
        this.f5641id = new DERTaggedObject(false, 0, subjectKeyIdentifier);
    }

    public OriginatorIdentifierOrKey(OriginatorPublicKey originatorPublicKey) {
        this.f5641id = new DERTaggedObject(false, 1, originatorPublicKey);
    }

    public OriginatorIdentifierOrKey(ASN1Primitive aSN1Primitive) {
        this.f5641id = aSN1Primitive;
    }
}
