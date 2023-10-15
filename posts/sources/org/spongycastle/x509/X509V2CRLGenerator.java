package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.asn1.x509.V2TBSCertListGenerator;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.X509CRLObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class X509V2CRLGenerator {
    private AlgorithmIdentifier sigAlgId;
    private DERObjectIdentifier sigOID;
    private String signatureAlgorithm;
    private V2TBSCertListGenerator tbsGen = new V2TBSCertListGenerator();
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ExtCRLException extends CRLException {
        public Throwable cause;

        public ExtCRLException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    private TBSCertList generateCertList() {
        if (!this.extGenerator.isEmpty()) {
            this.tbsGen.setExtensions(this.extGenerator.generate());
        }
        return this.tbsGen.generateTBSCertList();
    }

    private X509CRL generateJcaObject(TBSCertList tBSCertList, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertList);
        aSN1EncodableVector.add(this.sigAlgId);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return new X509CRLObject(new CertificateList(new DERSequence(aSN1EncodableVector)));
    }

    public void addCRL(X509CRL x509crl) {
        Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
        if (revokedCertificates != null) {
            for (X509CRLEntry x509CRLEntry : revokedCertificates) {
                try {
                    this.tbsGen.addCRLEntry(ASN1Sequence.getInstance(new ASN1InputStream(x509CRLEntry.getEncoded()).readObject()));
                } catch (IOException e) {
                    StringBuilder m253r = outline.m253r("exception processing encoding of CRL: ");
                    m253r.append(e.toString());
                    throw new CRLException(m253r.toString());
                }
            }
        }
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i) {
        this.tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), i);
    }

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) {
        addExtension(new DERObjectIdentifier(str), z, aSN1Encodable);
    }

    public X509CRL generate(PrivateKey privateKey) {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey) {
        try {
            return generateX509CRL(privateKey, "SC", null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator getSignatureAlgNames() {
        return X509Util.getAlgNames();
    }

    public void reset() {
        this.tbsGen = new V2TBSCertListGenerator();
        this.extGenerator.reset();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.tbsGen.setIssuer(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException(outline.m268c("can't process principal: ", e));
        }
    }

    public void setNextUpdate(Date date) {
        this.tbsGen.setNextUpdate(new Time(date));
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
        try {
            DERObjectIdentifier algorithmOID = X509Util.getAlgorithmOID(str);
            this.sigOID = algorithmOID;
            AlgorithmIdentifier sigAlgID = X509Util.getSigAlgID(algorithmOID, str);
            this.sigAlgId = sigAlgID;
            this.tbsGen.setSignature(sigAlgID);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void setThisUpdate(Date date) {
        this.tbsGen.setThisUpdate(new Time(date));
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i, Date date2) {
        this.tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), i, new DERGeneralizedTime(date2));
    }

    public void addExtension(DERObjectIdentifier dERObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(dERObjectIdentifier.getId()), z, aSN1Encodable);
    }

    public X509CRL generate(PrivateKey privateKey, SecureRandom secureRandom) {
        TBSCertList generateCertList = generateCertList();
        try {
            return generateJcaObject(generateCertList, X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, privateKey, secureRandom, generateCertList));
        } catch (IOException e) {
            throw new ExtCRLException("cannot generate CRL encoding", e);
        }
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, X509Extensions x509Extensions) {
        this.tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), Extensions.getInstance(x509Extensions));
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        addExtension(new DERObjectIdentifier(str), z, bArr);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, SecureRandom secureRandom) {
        try {
            return generateX509CRL(privateKey, "SC", secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public void setIssuerDN(X509Name x509Name) {
        this.tbsGen.setIssuer(x509Name);
    }

    public void addExtension(DERObjectIdentifier dERObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(dERObjectIdentifier.getId()), z, bArr);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str) {
        return generateX509CRL(privateKey, str, null);
    }

    public X509CRL generate(PrivateKey privateKey, String str) {
        return generate(privateKey, str, null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str, SecureRandom secureRandom) {
        try {
            return generate(privateKey, str, secureRandom);
        } catch (InvalidKeyException e) {
            throw e;
        } catch (NoSuchProviderException e2) {
            throw e2;
        } catch (SignatureException e3) {
            throw e3;
        } catch (GeneralSecurityException e4) {
            throw new SecurityException("exception: " + e4);
        }
    }

    public X509CRL generate(PrivateKey privateKey, String str, SecureRandom secureRandom) {
        TBSCertList generateCertList = generateCertList();
        try {
            return generateJcaObject(generateCertList, X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, str, privateKey, secureRandom, generateCertList));
        } catch (IOException e) {
            throw new ExtCRLException("cannot generate CRL encoding", e);
        }
    }
}
