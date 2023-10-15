package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AuthorityInformationAccess extends ASN1Object {
    private AccessDescription[] descriptions;

    private AuthorityInformationAccess(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1) {
            this.descriptions = new AccessDescription[aSN1Sequence.size()];
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                this.descriptions[i] = AccessDescription.getInstance(aSN1Sequence.getObjectAt(i));
            }
            return;
        }
        throw new IllegalArgumentException("sequence may not be empty");
    }

    public static AuthorityInformationAccess getInstance(Object obj) {
        if (obj instanceof AuthorityInformationAccess) {
            return (AuthorityInformationAccess) obj;
        }
        if (obj != null) {
            return new AuthorityInformationAccess(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AccessDescription[] getAccessDescriptions() {
        return this.descriptions;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            AccessDescription[] accessDescriptionArr = this.descriptions;
            if (i != accessDescriptionArr.length) {
                aSN1EncodableVector.add(accessDescriptionArr[i]);
                i++;
            } else {
                return new DERSequence(aSN1EncodableVector);
            }
        }
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("AuthorityInformationAccess: Oid(");
        m253r.append(this.descriptions[0].getAccessMethod().getId());
        m253r.append(")");
        return m253r.toString();
    }

    public AuthorityInformationAccess(ASN1ObjectIdentifier aSN1ObjectIdentifier, GeneralName generalName) {
        this.descriptions = r0;
        AccessDescription[] accessDescriptionArr = {new AccessDescription(aSN1ObjectIdentifier, generalName)};
    }
}
