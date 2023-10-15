package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.x509.ExtendedPKIXParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) {
        ExtendedPKIXParameters extendedPKIXParameters;
        X500Principal x500Principal;
        PublicKey cAPublicKey;
        int i;
        HashSet hashSet;
        List<PKIXCertPathChecker> list;
        HashSet hashSet2;
        if (certPathParameters instanceof PKIXParameters) {
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
            } else {
                extendedPKIXParameters = ExtendedPKIXParameters.getInstance((PKIXParameters) certPathParameters);
            }
            if (extendedPKIXParameters.getTrustAnchors() != null) {
                List<? extends Certificate> certificates = certPath.getCertificates();
                int size = certificates.size();
                if (!certificates.isEmpty()) {
                    Set<String> initialPolicies = extendedPKIXParameters.getInitialPolicies();
                    try {
                        TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), extendedPKIXParameters.getTrustAnchors(), extendedPKIXParameters.getSigProvider());
                        if (findTrustAnchor != null) {
                            int i2 = size + 1;
                            ArrayList[] arrayListArr = new ArrayList[i2];
                            for (int i3 = 0; i3 < i2; i3++) {
                                arrayListArr[i3] = new ArrayList();
                            }
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add("2.5.29.32.0");
                            PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, null, new HashSet(), "2.5.29.32.0", false);
                            arrayListArr[0].add(pKIXPolicyNode);
                            PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                            HashSet hashSet4 = new HashSet();
                            int i4 = extendedPKIXParameters.isExplicitPolicyRequired() ? 0 : i2;
                            int i5 = extendedPKIXParameters.isAnyPolicyInhibited() ? 0 : i2;
                            if (extendedPKIXParameters.isPolicyMappingInhibited()) {
                                i2 = 0;
                            }
                            X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                            try {
                                if (trustedCert != null) {
                                    x500Principal = CertPathValidatorUtilities.getSubjectPrincipal(trustedCert);
                                    cAPublicKey = trustedCert.getPublicKey();
                                } else {
                                    x500Principal = new X500Principal(findTrustAnchor.getCAName());
                                    cAPublicKey = findTrustAnchor.getCAPublicKey();
                                }
                                try {
                                    AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(cAPublicKey);
                                    algorithmIdentifier.getObjectId();
                                    algorithmIdentifier.getParameters();
                                    if (extendedPKIXParameters.getTargetConstraints() != null) {
                                        i = i2;
                                        if (!extendedPKIXParameters.getTargetConstraints().match((X509Certificate) certificates.get(0))) {
                                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath, 0);
                                        }
                                    } else {
                                        i = i2;
                                    }
                                    List<PKIXCertPathChecker> certPathCheckers = extendedPKIXParameters.getCertPathCheckers();
                                    for (PKIXCertPathChecker pKIXCertPathChecker : certPathCheckers) {
                                        pKIXCertPathChecker.init(false);
                                        certPathCheckers = certPathCheckers;
                                    }
                                    List<PKIXCertPathChecker> list2 = certPathCheckers;
                                    X500Principal x500Principal2 = x500Principal;
                                    PublicKey publicKey = cAPublicKey;
                                    int size2 = certificates.size() - 1;
                                    PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                    int i6 = i4;
                                    int i7 = i5;
                                    X509Certificate x509Certificate = null;
                                    int i8 = size;
                                    int i9 = i;
                                    X509Certificate x509Certificate2 = trustedCert;
                                    int i10 = i9;
                                    while (size2 >= 0) {
                                        int i11 = size - size2;
                                        X509Certificate x509Certificate3 = (X509Certificate) certificates.get(size2);
                                        boolean z = size2 == certificates.size() + (-1);
                                        List<? extends Certificate> list3 = certificates;
                                        int i12 = i8;
                                        TrustAnchor trustAnchor = findTrustAnchor;
                                        List<PKIXCertPathChecker> list4 = list2;
                                        int i13 = i7;
                                        Set<String> set = initialPolicies;
                                        int i14 = i6;
                                        ExtendedPKIXParameters extendedPKIXParameters2 = extendedPKIXParameters;
                                        int i15 = i10;
                                        int i16 = size2;
                                        RFC3280CertPathUtilities.processCertA(certPath, extendedPKIXParameters, size2, publicKey, z, x500Principal2, x509Certificate2);
                                        RFC3280CertPathUtilities.processCertBC(certPath, i16, pKIXNameConstraintValidator);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath, i16, RFC3280CertPathUtilities.processCertD(certPath, i16, hashSet4, pKIXPolicyNode2, arrayListArr, i13));
                                        RFC3280CertPathUtilities.processCertF(certPath, i16, processCertE, i14);
                                        if (i11 == size) {
                                            list = list4;
                                            pKIXPolicyNode2 = processCertE;
                                            i8 = i12;
                                            i7 = i13;
                                            i6 = i14;
                                            i10 = i15;
                                        } else if (x509Certificate3 != null && x509Certificate3.getVersion() == 1) {
                                            throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath, i16);
                                        } else {
                                            RFC3280CertPathUtilities.prepareNextCertA(certPath, i16);
                                            PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath, i16, arrayListArr, processCertE, i15);
                                            RFC3280CertPathUtilities.prepareNextCertG(certPath, i16, pKIXNameConstraintValidator);
                                            int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath, i16, i14);
                                            int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath, i16, i15);
                                            int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath, i16, i13);
                                            int prepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath, i16, prepareNextCertH1);
                                            int prepareNextCertI2 = RFC3280CertPathUtilities.prepareNextCertI2(certPath, i16, prepareNextCertH2);
                                            i7 = RFC3280CertPathUtilities.prepareNextCertJ(certPath, i16, prepareNextCertH3);
                                            RFC3280CertPathUtilities.prepareNextCertK(certPath, i16);
                                            int prepareNextCertM = RFC3280CertPathUtilities.prepareNextCertM(certPath, i16, RFC3280CertPathUtilities.prepareNextCertL(certPath, i16, i12));
                                            RFC3280CertPathUtilities.prepareNextCertN(certPath, i16);
                                            Set<String> criticalExtensionOIDs = x509Certificate3.getCriticalExtensionOIDs();
                                            if (criticalExtensionOIDs != null) {
                                                hashSet2 = new HashSet(criticalExtensionOIDs);
                                                hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                            } else {
                                                hashSet2 = new HashSet();
                                            }
                                            list = list4;
                                            RFC3280CertPathUtilities.prepareNextCertO(certPath, i16, hashSet2, list);
                                            X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate3);
                                            try {
                                                PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i16);
                                                AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                algorithmIdentifier2.getObjectId();
                                                algorithmIdentifier2.getParameters();
                                                pKIXPolicyNode2 = prepareCertB;
                                                x500Principal2 = subjectPrincipal;
                                                publicKey = nextWorkingKey;
                                                x509Certificate2 = x509Certificate3;
                                                i10 = prepareNextCertI2;
                                                i8 = prepareNextCertM;
                                                i6 = prepareNextCertI1;
                                            } catch (CertPathValidatorException e) {
                                                throw new CertPathValidatorException("Next working key could not be retrieved.", e, certPath, i16);
                                            }
                                        }
                                        int i17 = i16 - 1;
                                        findTrustAnchor = trustAnchor;
                                        list2 = list;
                                        x509Certificate = x509Certificate3;
                                        certificates = list3;
                                        initialPolicies = set;
                                        size2 = i17;
                                        extendedPKIXParameters = extendedPKIXParameters2;
                                    }
                                    ExtendedPKIXParameters extendedPKIXParameters3 = extendedPKIXParameters;
                                    int i18 = size2;
                                    Set<String> set2 = initialPolicies;
                                    List<PKIXCertPathChecker> list5 = list2;
                                    TrustAnchor trustAnchor2 = findTrustAnchor;
                                    int i19 = i18 + 1;
                                    int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath, i19, RFC3280CertPathUtilities.wrapupCertA(i6, x509Certificate));
                                    Set<String> criticalExtensionOIDs2 = x509Certificate.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs2 != null) {
                                        hashSet = new HashSet(criticalExtensionOIDs2);
                                        hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                        hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                        hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                        hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                        hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                        hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                        hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                        hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    RFC3280CertPathUtilities.wrapupCertF(certPath, i19, list5, hashSet);
                                    X509Certificate x509Certificate4 = x509Certificate;
                                    PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, extendedPKIXParameters3, set2, i19, arrayListArr, pKIXPolicyNode2, hashSet4);
                                    if (wrapupCertB <= 0 && wrapupCertG == null) {
                                        throw new CertPathValidatorException("Path processing failed on policy.", null, certPath, i18);
                                    }
                                    return new PKIXCertPathValidatorResult(trustAnchor2, wrapupCertG, x509Certificate4.getPublicKey());
                                } catch (CertPathValidatorException e2) {
                                    throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e2, certPath, -1);
                                }
                            } catch (IllegalArgumentException e3) {
                                throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e3, certPath, -1);
                            }
                        }
                        throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath, -1);
                    } catch (AnnotatedException e4) {
                        throw new CertPathValidatorException(e4.getMessage(), e4, certPath, certificates.size() - 1);
                    }
                }
                throw new CertPathValidatorException("Certification path is empty.", null, certPath, 0);
            }
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        StringBuilder m253r = outline.m253r("Parameters must be a ");
        m253r.append(PKIXParameters.class.getName());
        m253r.append(" instance.");
        throw new InvalidAlgorithmParameterException(m253r.toString());
    }
}
