package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KeyAgreeRecipientIdentifier extends ASN1Object implements ASN1Choice {
    private IssuerAndSerialNumber issuerSerial;
    private RecipientKeyIdentifier rKeyID;

    public KeyAgreeRecipientIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.issuerSerial = issuerAndSerialNumber;
        this.rKeyID = null;
    }

    public static KeyAgreeRecipientIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerSerial;
    }

    public RecipientKeyIdentifier getRKeyID() {
        return this.rKeyID;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        IssuerAndSerialNumber issuerAndSerialNumber = this.issuerSerial;
        if (issuerAndSerialNumber != null) {
            return issuerAndSerialNumber.toASN1Primitive();
        }
        return new DERTaggedObject(false, 0, this.rKeyID);
    }

    public static KeyAgreeRecipientIdentifier getInstance(Object obj) {
        if (obj != null && !(obj instanceof KeyAgreeRecipientIdentifier)) {
            if (obj instanceof ASN1Sequence) {
                return new KeyAgreeRecipientIdentifier(IssuerAndSerialNumber.getInstance(obj));
            }
            if (obj instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
                if (aSN1TaggedObject.getTagNo() == 0) {
                    return new KeyAgreeRecipientIdentifier(RecipientKeyIdentifier.getInstance(aSN1TaggedObject, false));
                }
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid KeyAgreeRecipientIdentifier: ")));
        }
        return (KeyAgreeRecipientIdentifier) obj;
    }

    public KeyAgreeRecipientIdentifier(RecipientKeyIdentifier recipientKeyIdentifier) {
        this.issuerSerial = null;
        this.rKeyID = recipientKeyIdentifier;
    }
}
