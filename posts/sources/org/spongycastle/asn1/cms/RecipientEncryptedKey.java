package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RecipientEncryptedKey extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientIdentifier identifier;

    private RecipientEncryptedKey(ASN1Sequence aSN1Sequence) {
        this.identifier = KeyAgreeRecipientIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.encryptedKey = (ASN1OctetString) aSN1Sequence.getObjectAt(1);
    }

    public static RecipientEncryptedKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public KeyAgreeRecipientIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.identifier);
        aSN1EncodableVector.add(this.encryptedKey);
        return new DERSequence(aSN1EncodableVector);
    }

    public static RecipientEncryptedKey getInstance(Object obj) {
        if (obj != null && !(obj instanceof RecipientEncryptedKey)) {
            if (obj instanceof ASN1Sequence) {
                return new RecipientEncryptedKey((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid RecipientEncryptedKey: ")));
        }
        return (RecipientEncryptedKey) obj;
    }

    public RecipientEncryptedKey(KeyAgreeRecipientIdentifier keyAgreeRecipientIdentifier, ASN1OctetString aSN1OctetString) {
        this.identifier = keyAgreeRecipientIdentifier;
        this.encryptedKey = aSN1OctetString;
    }
}
