package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.X509Certificate;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {
    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) {
        if (certPathParameters instanceof ExtendedPKIXParameters) {
            ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
            Selector targetConstraints = extendedPKIXParameters.getTargetConstraints();
            if (targetConstraints instanceof X509AttributeCertStoreSelector) {
                X509AttributeCertificate attributeCert = ((X509AttributeCertStoreSelector) targetConstraints).getAttributeCert();
                CertPath processAttrCert1 = RFC3281CertPathUtilities.processAttrCert1(attributeCert, extendedPKIXParameters);
                CertPathValidatorResult processAttrCert2 = RFC3281CertPathUtilities.processAttrCert2(certPath, extendedPKIXParameters);
                X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(0);
                RFC3281CertPathUtilities.processAttrCert3(x509Certificate, extendedPKIXParameters);
                RFC3281CertPathUtilities.processAttrCert4(x509Certificate, extendedPKIXParameters);
                RFC3281CertPathUtilities.processAttrCert5(attributeCert, extendedPKIXParameters);
                RFC3281CertPathUtilities.processAttrCert7(attributeCert, certPath, processAttrCert1, extendedPKIXParameters);
                RFC3281CertPathUtilities.additionalChecks(attributeCert, extendedPKIXParameters);
                try {
                    RFC3281CertPathUtilities.checkCRLs(attributeCert, extendedPKIXParameters, x509Certificate, CertPathValidatorUtilities.getValidCertDateFromValidityModel(extendedPKIXParameters, null, -1), certPath.getCertificates());
                    return processAttrCert2;
                } catch (AnnotatedException e) {
                    throw new ExtCertPathValidatorException("Could not get validity date from attribute certificate.", e);
                }
            }
            StringBuilder m253r = outline.m253r("TargetConstraints must be an instance of ");
            m253r.append(X509AttributeCertStoreSelector.class.getName());
            m253r.append(" for ");
            m253r.append(getClass().getName());
            m253r.append(" class.");
            throw new InvalidAlgorithmParameterException(m253r.toString());
        }
        StringBuilder m253r2 = outline.m253r("Parameters must be a ");
        m253r2.append(ExtendedPKIXParameters.class.getName());
        m253r2.append(" instance.");
        throw new InvalidAlgorithmParameterException(m253r2.toString());
    }
}
