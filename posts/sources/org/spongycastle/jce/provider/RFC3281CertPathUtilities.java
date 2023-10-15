package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.x509.TargetInformation;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.PKIXAttrCertChecker;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RFC3281CertPathUtilities {
    private static final String TARGET_INFORMATION = X509Extensions.TargetInformation.getId();
    private static final String NO_REV_AVAIL = X509Extensions.NoRevAvail.getId();
    private static final String CRL_DISTRIBUTION_POINTS = X509Extensions.CRLDistributionPoints.getId();
    private static final String AUTHORITY_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();

    public static void additionalChecks(X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters) {
        for (String str : extendedPKIXParameters.getProhibitedACAttributes()) {
            if (x509AttributeCertificate.getAttributes(str) != null) {
                throw new CertPathValidatorException(outline.m265f("Attribute certificate contains prohibited attribute: ", str, "."));
            }
        }
        for (String str2 : extendedPKIXParameters.getNecessaryACAttributes()) {
            if (x509AttributeCertificate.getAttributes(str2) == null) {
                throw new CertPathValidatorException(outline.m265f("Attribute certificate does not contain necessary attribute: ", str2, "."));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void checkCRL(org.spongycastle.asn1.x509.DistributionPoint r22, org.spongycastle.x509.X509AttributeCertificate r23, org.spongycastle.x509.ExtendedPKIXParameters r24, java.util.Date r25, java.security.cert.X509Certificate r26, org.spongycastle.jce.provider.CertStatus r27, org.spongycastle.jce.provider.ReasonsMask r28, java.util.List r29) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.RFC3281CertPathUtilities.checkCRL(org.spongycastle.asn1.x509.DistributionPoint, org.spongycastle.x509.X509AttributeCertificate, org.spongycastle.x509.ExtendedPKIXParameters, java.util.Date, java.security.cert.X509Certificate, org.spongycastle.jce.provider.CertStatus, org.spongycastle.jce.provider.ReasonsMask, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkCRLs(org.spongycastle.x509.X509AttributeCertificate r18, org.spongycastle.x509.ExtendedPKIXParameters r19, java.security.cert.X509Certificate r20, java.util.Date r21, java.util.List r22) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.RFC3281CertPathUtilities.checkCRLs(org.spongycastle.x509.X509AttributeCertificate, org.spongycastle.x509.ExtendedPKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.util.List):void");
    }

    public static CertPath processAttrCert1(X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters) {
        HashSet hashSet = new HashSet();
        if (x509AttributeCertificate.getHolder().getIssuer() != null) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            x509CertStoreSelector.setSerialNumber(x509AttributeCertificate.getHolder().getSerialNumber());
            Principal[] issuer = x509AttributeCertificate.getHolder().getIssuer();
            for (int i = 0; i < issuer.length; i++) {
                try {
                    if (issuer[i] instanceof X500Principal) {
                        x509CertStoreSelector.setIssuer(((X500Principal) issuer[i]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getStores()));
                } catch (IOException e) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e);
                } catch (AnnotatedException e2) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e2);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509AttributeCertificate.getHolder().getEntityNames() != null) {
            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
            Principal[] entityNames = x509AttributeCertificate.getHolder().getEntityNames();
            for (int i2 = 0; i2 < entityNames.length; i2++) {
                try {
                    if (entityNames[i2] instanceof X500Principal) {
                        x509CertStoreSelector2.setIssuer(((X500Principal) entityNames[i2]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector2, extendedPKIXParameters.getStores()));
                } catch (IOException e3) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e3);
                } catch (AnnotatedException e4) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e4);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) ExtendedPKIXBuilderParameters.getInstance(extendedPKIXParameters);
        Iterator it = hashSet.iterator();
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResult = null;
        while (it.hasNext()) {
            X509CertStoreSelector x509CertStoreSelector3 = new X509CertStoreSelector();
            x509CertStoreSelector3.setCertificate((X509Certificate) it.next());
            extendedPKIXBuilderParameters.setTargetConstraints(x509CertStoreSelector3);
            try {
                try {
                    certPathBuilderResult = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).build(ExtendedPKIXBuilderParameters.getInstance(extendedPKIXBuilderParameters));
                } catch (InvalidAlgorithmParameterException e5) {
                    throw new RuntimeException(e5.getMessage());
                } catch (CertPathBuilderException e6) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", e6);
                }
            } catch (NoSuchAlgorithmException e7) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e7);
            } catch (NoSuchProviderException e8) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e8);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResult.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    public static CertPathValidatorResult processAttrCert2(CertPath certPath, ExtendedPKIXParameters extendedPKIXParameters) {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).validate(certPath, extendedPKIXParameters);
            } catch (InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e.getMessage());
            } catch (CertPathValidatorException e2) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e3);
        } catch (NoSuchProviderException e4) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e4);
        }
    }

    public static void processAttrCert3(X509Certificate x509Certificate, ExtendedPKIXParameters extendedPKIXParameters) {
        if (x509Certificate.getKeyUsage() != null && !x509Certificate.getKeyUsage()[0] && !x509Certificate.getKeyUsage()[1]) {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        }
        if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    public static void processAttrCert4(X509Certificate x509Certificate, ExtendedPKIXParameters extendedPKIXParameters) {
        boolean z = false;
        for (TrustAnchor trustAnchor : extendedPKIXParameters.getTrustedACIssuers()) {
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                z = true;
            }
        }
        if (!z) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    public static void processAttrCert5(X509AttributeCertificate x509AttributeCertificate, ExtendedPKIXParameters extendedPKIXParameters) {
        try {
            x509AttributeCertificate.checkValidity(CertPathValidatorUtilities.getValidDate(extendedPKIXParameters));
        } catch (CertificateExpiredException e) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e);
        } catch (CertificateNotYetValidException e2) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e2);
        }
    }

    public static void processAttrCert7(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, ExtendedPKIXParameters extendedPKIXParameters) {
        Set<String> criticalExtensionOIDs = x509AttributeCertificate.getCriticalExtensionOIDs();
        String str = TARGET_INFORMATION;
        if (criticalExtensionOIDs.contains(str)) {
            try {
                TargetInformation.getInstance(CertPathValidatorUtilities.getExtensionValue(x509AttributeCertificate, str));
            } catch (IllegalArgumentException e) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e);
            } catch (AnnotatedException e2) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e2);
            }
        }
        criticalExtensionOIDs.remove(str);
        for (PKIXAttrCertChecker pKIXAttrCertChecker : extendedPKIXParameters.getAttrCertCheckers()) {
            pKIXAttrCertChecker.check(x509AttributeCertificate, certPath, certPath2, criticalExtensionOIDs);
        }
        if (criticalExtensionOIDs.isEmpty()) {
            return;
        }
        throw new CertPathValidatorException("Attribute certificate contains unsupported critical extensions: " + criticalExtensionOIDs);
    }
}
