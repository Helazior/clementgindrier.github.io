package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SignerIdentifier extends ASN1Object implements ASN1Choice {

    /* renamed from: id */
    private ASN1Encodable f5643id;

    public SignerIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f5643id = issuerAndSerialNumber;
    }

    public static SignerIdentifier getInstance(Object obj) {
        if (obj != null && !(obj instanceof SignerIdentifier)) {
            if (obj instanceof IssuerAndSerialNumber) {
                return new SignerIdentifier((IssuerAndSerialNumber) obj);
            }
            if (obj instanceof ASN1OctetString) {
                return new SignerIdentifier((ASN1OctetString) obj);
            }
            if (obj instanceof ASN1Primitive) {
                return new SignerIdentifier((ASN1Primitive) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Illegal object in SignerIdentifier: ")));
        }
        return (SignerIdentifier) obj;
    }

    public ASN1Encodable getId() {
        ASN1Encodable aSN1Encodable = this.f5643id;
        return aSN1Encodable instanceof ASN1TaggedObject ? ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Encodable, false) : aSN1Encodable;
    }

    public boolean isTagged() {
        return this.f5643id instanceof ASN1TaggedObject;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f5643id.toASN1Primitive();
    }

    public SignerIdentifier(ASN1OctetString aSN1OctetString) {
        this.f5643id = new DERTaggedObject(false, 0, aSN1OctetString);
    }

    public SignerIdentifier(ASN1Primitive aSN1Primitive) {
        this.f5643id = aSN1Primitive;
    }
}
