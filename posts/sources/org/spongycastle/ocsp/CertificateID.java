package org.spongycastle.ocsp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.ocsp.CertID;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jce.PrincipalUtil;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CertificateID {
    public static final String HASH_SHA1 = "1.3.14.3.2.26";

    /* renamed from: id */
    private final CertID f6167id;

    public CertificateID(CertID certID) {
        if (certID != null) {
            this.f6167id = certID;
            return;
        }
        throw new IllegalArgumentException("'id' cannot be null");
    }

    private static CertID createCertID(AlgorithmIdentifier algorithmIdentifier, X509Certificate x509Certificate, ASN1Integer aSN1Integer, String str) {
        try {
            MessageDigest createDigestInstance = OCSPUtil.createDigestInstance(algorithmIdentifier.getAlgorithm().getId(), str);
            createDigestInstance.update(PrincipalUtil.getSubjectX509Principal(x509Certificate).getEncoded());
            DEROctetString dEROctetString = new DEROctetString(createDigestInstance.digest());
            createDigestInstance.update(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()).getPublicKeyData().getBytes());
            return new CertID(algorithmIdentifier, dEROctetString, new DEROctetString(createDigestInstance.digest()), aSN1Integer);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.f6167id.getHashAlgorithm(), certificateID.f6167id.getIssuerNameHash(), certificateID.f6167id.getIssuerKeyHash(), new ASN1Integer(bigInteger)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificateID) {
            return this.f6167id.toASN1Primitive().equals(((CertificateID) obj).f6167id.toASN1Primitive());
        }
        return false;
    }

    public String getHashAlgOID() {
        return this.f6167id.getHashAlgorithm().getObjectId().getId();
    }

    public byte[] getIssuerKeyHash() {
        return this.f6167id.getIssuerKeyHash().getOctets();
    }

    public byte[] getIssuerNameHash() {
        return this.f6167id.getIssuerNameHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.f6167id.getSerialNumber().getValue();
    }

    public int hashCode() {
        return this.f6167id.toASN1Primitive().hashCode();
    }

    public boolean matchesIssuer(X509Certificate x509Certificate, String str) {
        return createCertID(this.f6167id.getHashAlgorithm(), x509Certificate, this.f6167id.getSerialNumber(), str).equals(this.f6167id);
    }

    public CertID toASN1Object() {
        return this.f6167id;
    }

    public CertificateID(String str, X509Certificate x509Certificate, BigInteger bigInteger, String str2) {
        this.f6167id = createCertID(new AlgorithmIdentifier(new DERObjectIdentifier(str), DERNull.INSTANCE), x509Certificate, new ASN1Integer(bigInteger), str2);
    }

    public CertificateID(String str, X509Certificate x509Certificate, BigInteger bigInteger) {
        this(str, x509Certificate, bigInteger, "SC");
    }
}
