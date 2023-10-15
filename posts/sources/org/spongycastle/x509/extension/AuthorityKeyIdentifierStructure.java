package org.spongycastle.x509.extension;

import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509Extension;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jce.PrincipalUtil;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AuthorityKeyIdentifierStructure extends AuthorityKeyIdentifier {
    public AuthorityKeyIdentifierStructure(byte[] bArr) {
        super((ASN1Sequence) X509ExtensionUtil.fromExtensionValue(bArr));
    }

    private static ASN1Sequence fromCertificate(X509Certificate x509Certificate) {
        try {
            if (x509Certificate.getVersion() != 3) {
                return (ASN1Sequence) new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()), new GeneralNames(new GeneralName(PrincipalUtil.getIssuerX509Principal(x509Certificate))), x509Certificate.getSerialNumber()).toASN1Object();
            }
            GeneralName generalName = new GeneralName(PrincipalUtil.getIssuerX509Principal(x509Certificate));
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.SubjectKeyIdentifier.getId());
            if (extensionValue != null) {
                return (ASN1Sequence) new AuthorityKeyIdentifier(((ASN1OctetString) X509ExtensionUtil.fromExtensionValue(extensionValue)).getOctets(), new GeneralNames(generalName), x509Certificate.getSerialNumber()).toASN1Object();
            }
            return (ASN1Sequence) new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()), new GeneralNames(generalName), x509Certificate.getSerialNumber()).toASN1Object();
        } catch (Exception e) {
            throw new CertificateParsingException(outline.m275F(e, outline.m253r("Exception extracting certificate details: ")));
        }
    }

    private static ASN1Sequence fromKey(PublicKey publicKey) {
        try {
            return (ASN1Sequence) new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(publicKey.getEncoded()).readObject())).toASN1Object();
        } catch (Exception e) {
            throw new InvalidKeyException("can't process key: " + e);
        }
    }

    public AuthorityKeyIdentifierStructure(X509Extension x509Extension) {
        super((ASN1Sequence) x509Extension.getParsedValue());
    }

    public AuthorityKeyIdentifierStructure(Extension extension) {
        super((ASN1Sequence) extension.getParsedValue());
    }

    public AuthorityKeyIdentifierStructure(X509Certificate x509Certificate) {
        super(fromCertificate(x509Certificate));
    }

    public AuthorityKeyIdentifierStructure(PublicKey publicKey) {
        super(fromKey(publicKey));
    }
}
