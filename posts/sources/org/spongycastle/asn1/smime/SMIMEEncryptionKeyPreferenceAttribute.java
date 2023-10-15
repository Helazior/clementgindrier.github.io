package org.spongycastle.asn1.smime;

import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.cms.RecipientKeyIdentifier;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SMIMEEncryptionKeyPreferenceAttribute extends Attribute {
    public SMIMEEncryptionKeyPreferenceAttribute(IssuerAndSerialNumber issuerAndSerialNumber) {
        super(SMIMEAttributes.encrypKeyPref, (ASN1Set) new DERSet(new DERTaggedObject(false, 0, issuerAndSerialNumber)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(RecipientKeyIdentifier recipientKeyIdentifier) {
        super(SMIMEAttributes.encrypKeyPref, (ASN1Set) new DERSet(new DERTaggedObject(false, 1, recipientKeyIdentifier)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(ASN1OctetString aSN1OctetString) {
        super(SMIMEAttributes.encrypKeyPref, (ASN1Set) new DERSet(new DERTaggedObject(false, 2, aSN1OctetString)));
    }
}
