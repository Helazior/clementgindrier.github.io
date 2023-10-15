package org.spongycastle.asn1.eac;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERObjectIdentifier;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class PublicKeyDataObject extends ASN1Object {
    public static PublicKeyDataObject getInstance(Object obj) {
        if (obj instanceof PublicKeyDataObject) {
            return (PublicKeyDataObject) obj;
        }
        if (obj != null) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(obj);
            if (DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0)).m528on(EACObjectIdentifiers.id_TA_ECDSA)) {
                return new ECDSAPublicKey(aSN1Sequence);
            }
            return new RSAPublicKey(aSN1Sequence);
        }
        return null;
    }

    public abstract ASN1ObjectIdentifier getUsage();
}
