package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.jce.provider.X509CRLObject;
import org.spongycastle.jce.provider.X509CertificateObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CertificateFactory extends CertificateFactorySpi {
    private static final PEMUtil PEM_CERT_PARSER = new PEMUtil("CERTIFICATE");
    private static final PEMUtil PEM_CRL_PARSER = new PEMUtil("CRL");
    private ASN1Set sData = null;
    private int sDataObjectCount = 0;
    private InputStream currentStream = null;
    private ASN1Set sCrlData = null;
    private int sCrlDataObjectCount = 0;
    private InputStream currentCrlStream = null;

    private CRL getCRL() {
        ASN1Set aSN1Set = this.sCrlData;
        if (aSN1Set == null || this.sCrlDataObjectCount >= aSN1Set.size()) {
            return null;
        }
        ASN1Set aSN1Set2 = this.sCrlData;
        int i = this.sCrlDataObjectCount;
        this.sCrlDataObjectCount = i + 1;
        return createCRL(CertificateList.getInstance(aSN1Set2.getObjectAt(i)));
    }

    private Certificate getCertificate() {
        if (this.sData != null) {
            while (this.sDataObjectCount < this.sData.size()) {
                ASN1Set aSN1Set = this.sData;
                int i = this.sDataObjectCount;
                this.sDataObjectCount = i + 1;
                ASN1Encodable objectAt = aSN1Set.getObjectAt(i);
                if (objectAt instanceof ASN1Sequence) {
                    return new X509CertificateObject(X509CertificateStructure.getInstance(objectAt));
                }
            }
            return null;
        }
        return null;
    }

    private CRL readDERCRL(ASN1InputStream aSN1InputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1InputStream.readObject();
        if (aSN1Sequence.size() > 1 && (aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) && aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            this.sCrlData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCRLs();
            return getCRL();
        }
        return createCRL(CertificateList.getInstance(aSN1Sequence));
    }

    private Certificate readDERCertificate(ASN1InputStream aSN1InputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1InputStream.readObject();
        if (aSN1Sequence.size() > 1 && (aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) && aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            this.sData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
            return getCertificate();
        }
        return new X509CertificateObject(X509CertificateStructure.getInstance(aSN1Sequence));
    }

    private CRL readPEMCRL(InputStream inputStream) {
        ASN1Sequence readPEMObject = PEM_CRL_PARSER.readPEMObject(inputStream);
        if (readPEMObject != null) {
            return createCRL(CertificateList.getInstance(readPEMObject));
        }
        return null;
    }

    private Certificate readPEMCertificate(InputStream inputStream) {
        ASN1Sequence readPEMObject = PEM_CERT_PARSER.readPEMObject(inputStream);
        if (readPEMObject != null) {
            return new X509CertificateObject(X509CertificateStructure.getInstance(readPEMObject));
        }
        return null;
    }

    public CRL createCRL(CertificateList certificateList) {
        return new X509CRLObject(certificateList);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) {
        InputStream inputStream2 = this.currentCrlStream;
        if (inputStream2 == null) {
            this.currentCrlStream = inputStream;
            this.sCrlData = null;
            this.sCrlDataObjectCount = 0;
        } else if (inputStream2 != inputStream) {
            this.currentCrlStream = inputStream;
            this.sCrlData = null;
            this.sCrlDataObjectCount = 0;
        }
        try {
            ASN1Set aSN1Set = this.sCrlData;
            if (aSN1Set != null) {
                if (this.sCrlDataObjectCount != aSN1Set.size()) {
                    return getCRL();
                }
                this.sCrlData = null;
                this.sCrlDataObjectCount = 0;
                return null;
            }
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
            int read = pushbackInputStream.read();
            if (read == -1) {
                return null;
            }
            pushbackInputStream.unread(read);
            if (read != 48) {
                return readPEMCRL(pushbackInputStream);
            }
            return readDERCRL(new ASN1InputStream((InputStream) pushbackInputStream, true));
        } catch (CRLException e) {
            throw e;
        } catch (Exception e2) {
            throw new CRLException(e2.toString());
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCRLs(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            CRL engineGenerateCRL = engineGenerateCRL(inputStream);
            if (engineGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCRL);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) {
        InputStream inputStream2 = this.currentStream;
        if (inputStream2 == null) {
            this.currentStream = inputStream;
            this.sData = null;
            this.sDataObjectCount = 0;
        } else if (inputStream2 != inputStream) {
            this.currentStream = inputStream;
            this.sData = null;
            this.sDataObjectCount = 0;
        }
        try {
            ASN1Set aSN1Set = this.sData;
            if (aSN1Set != null) {
                if (this.sDataObjectCount != aSN1Set.size()) {
                    return getCertificate();
                }
                this.sData = null;
                this.sDataObjectCount = 0;
                return null;
            }
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
            int read = pushbackInputStream.read();
            if (read == -1) {
                return null;
            }
            pushbackInputStream.unread(read);
            if (read != 48) {
                return readPEMCertificate(pushbackInputStream);
            }
            return readDERCertificate(new ASN1InputStream(pushbackInputStream));
        } catch (Exception e) {
            throw new ExCertificateException(e);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCertificates(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate engineGenerateCertificate = engineGenerateCertificate(inputStream);
            if (engineGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCertificate);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator engineGetCertPathEncodings() {
        return null;
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ExCertificateException extends CertificateException {
        private Throwable cause;

        public ExCertificateException(Throwable th) {
            this.cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public ExCertificateException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) {
        return new PKIXCertPath(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List list) {
        for (Object obj : list) {
            if (obj != null && !(obj instanceof X509Certificate)) {
                StringBuilder m253r = outline.m253r("list contains non X509Certificate object while creating CertPath\n");
                m253r.append(obj.toString());
                throw new CertificateException(m253r.toString());
            }
        }
        return new PKIXCertPath(list);
    }
}
