package org.spongycastle.x509.extension;

import java.security.InvalidKeyException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SubjectKeyIdentifierStructure extends SubjectKeyIdentifier {
    public SubjectKeyIdentifierStructure(byte[] bArr) {
        super((ASN1OctetString) X509ExtensionUtil.fromExtensionValue(bArr));
    }

    private static ASN1OctetString fromPublicKey(PublicKey publicKey) {
        try {
            return (ASN1OctetString) new SubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())).toASN1Object();
        } catch (Exception e) {
            throw new InvalidKeyException(outline.m275F(e, outline.m253r("Exception extracting key details: ")));
        }
    }

    public SubjectKeyIdentifierStructure(PublicKey publicKey) {
        super(fromPublicKey(publicKey));
    }
}
