package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.X509CertStoreSelector;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi {
    private Exception certPathException;

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.security.cert.CertPathBuilderResult build(java.security.cert.X509Certificate r6, org.spongycastle.x509.ExtendedPKIXBuilderParameters r7, java.util.List r8) {
        /*
            r5 = this;
            boolean r0 = r8.contains(r6)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.Set r0 = r7.getExcludedCerts()
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L13
            return r1
        L13:
            int r0 = r7.getMaxPathLength()
            r2 = -1
            if (r0 == r2) goto L27
            int r0 = r8.size()
            int r0 = r0 + (-1)
            int r2 = r7.getMaxPathLength()
            if (r0 <= r2) goto L27
            return r1
        L27:
            r8.add(r6)
            java.lang.String r0 = "X.509"
            java.lang.String r2 = org.spongycastle.jce.provider.BouncyCastleProvider.PROVIDER_NAME     // Catch: java.lang.Exception -> Lc5
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0, r2)     // Catch: java.lang.Exception -> Lc5
            java.lang.String r2 = "PKIX"
            java.lang.String r3 = org.spongycastle.jce.provider.BouncyCastleProvider.PROVIDER_NAME     // Catch: java.lang.Exception -> Lc5
            java.security.cert.CertPathValidator r2 = java.security.cert.CertPathValidator.getInstance(r2, r3)     // Catch: java.lang.Exception -> Lc5
            java.util.Set r3 = r7.getTrustAnchors()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.lang.String r4 = r7.getSigProvider()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.security.cert.TrustAnchor r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.findTrustAnchor(r6, r3, r4)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            if (r3 == 0) goto L76
            java.security.cert.CertPath r0 = r0.generateCertPath(r8)     // Catch: java.lang.Exception -> L6d
            java.security.cert.CertPathValidatorResult r7 = r2.validate(r0, r7)     // Catch: java.lang.Exception -> L64
            java.security.cert.PKIXCertPathValidatorResult r7 = (java.security.cert.PKIXCertPathValidatorResult) r7     // Catch: java.lang.Exception -> L64
            java.security.cert.PKIXCertPathBuilderResult r2 = new java.security.cert.PKIXCertPathBuilderResult     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.security.cert.TrustAnchor r3 = r7.getTrustAnchor()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.security.cert.PolicyNode r4 = r7.getPolicyTree()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.security.PublicKey r7 = r7.getPublicKey()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            r2.<init>(r0, r3, r4, r7)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            return r2
        L64:
            r7 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.lang.String r2 = "Certification path could not be validated."
            r0.<init>(r2, r7)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            throw r0     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
        L6d:
            r7 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.lang.String r2 = "Certification path could not be constructed from certificate list."
            r0.<init>(r2, r7)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            throw r0     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
        L76:
            org.spongycastle.jce.provider.CertPathValidatorUtilities.addAdditionalStoresFromAltNames(r6, r7)     // Catch: java.security.cert.CertificateParsingException -> Lb3 org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.util.HashSet r0 = new java.util.HashSet     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            r0.<init>()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.util.Collection r2 = org.spongycastle.jce.provider.CertPathValidatorUtilities.findIssuerCerts(r6, r7)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Laa
            r0.addAll(r2)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Laa
            boolean r2 = r0.isEmpty()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            if (r2 != 0) goto La2
            java.util.Iterator r0 = r0.iterator()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
        L8f:
            boolean r2 = r0.hasNext()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            if (r2 == 0) goto Lbf
            if (r1 != 0) goto Lbf
            java.lang.Object r2 = r0.next()     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.security.cert.CertPathBuilderResult r1 = r5.build(r2, r7, r8)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            goto L8f
        La2:
            org.spongycastle.jce.provider.AnnotatedException r7 = new org.spongycastle.jce.provider.AnnotatedException     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.lang.String r0 = "No issuer certificate for certificate in certification path found."
            r7.<init>(r0)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            throw r7     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
        Laa:
            r7 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.lang.String r2 = "Cannot find issuer certificate for certificate in certification path."
            r0.<init>(r2, r7)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            throw r0     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
        Lb3:
            r7 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            java.lang.String r2 = "No additiontal X.509 stores can be added from certificate locations."
            r0.<init>(r2, r7)     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
            throw r0     // Catch: org.spongycastle.jce.provider.AnnotatedException -> Lbc
        Lbc:
            r7 = move-exception
            r5.certPathException = r7
        Lbf:
            if (r1 != 0) goto Lc4
            r8.remove(r6)
        Lc4:
            return r1
        Lc5:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "Exception creating support classes."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXCertPathBuilderSpi.build(java.security.cert.X509Certificate, org.spongycastle.x509.ExtendedPKIXBuilderParameters, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) {
        ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters;
        Exception exc;
        if (!(certPathParameters instanceof PKIXBuilderParameters) && !(certPathParameters instanceof ExtendedPKIXBuilderParameters)) {
            StringBuilder m253r = outline.m253r("Parameters must be an instance of ");
            m253r.append(PKIXBuilderParameters.class.getName());
            m253r.append(" or ");
            m253r.append(ExtendedPKIXBuilderParameters.class.getName());
            m253r.append(".");
            throw new InvalidAlgorithmParameterException(m253r.toString());
        }
        if (certPathParameters instanceof ExtendedPKIXBuilderParameters) {
            extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
        } else {
            extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) ExtendedPKIXBuilderParameters.getInstance((PKIXBuilderParameters) certPathParameters);
        }
        ArrayList arrayList = new ArrayList();
        Selector targetConstraints = extendedPKIXBuilderParameters.getTargetConstraints();
        if (targetConstraints instanceof X509CertStoreSelector) {
            try {
                Collection findCertificates = CertPathValidatorUtilities.findCertificates((X509CertStoreSelector) targetConstraints, extendedPKIXBuilderParameters.getStores());
                findCertificates.addAll(CertPathValidatorUtilities.findCertificates((X509CertStoreSelector) targetConstraints, extendedPKIXBuilderParameters.getCertStores()));
                if (!findCertificates.isEmpty()) {
                    CertPathBuilderResult certPathBuilderResult = null;
                    Iterator it = findCertificates.iterator();
                    while (it.hasNext() && certPathBuilderResult == null) {
                        certPathBuilderResult = build((X509Certificate) it.next(), extendedPKIXBuilderParameters, arrayList);
                    }
                    if (certPathBuilderResult == null && (exc = this.certPathException) != null) {
                        if (exc instanceof AnnotatedException) {
                            throw new CertPathBuilderException(this.certPathException.getMessage(), this.certPathException.getCause());
                        }
                        throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.certPathException);
                    } else if (certPathBuilderResult == null && this.certPathException == null) {
                        throw new CertPathBuilderException("Unable to find certificate chain.");
                    } else {
                        return certPathBuilderResult;
                    }
                }
                throw new CertPathBuilderException("No certificate found matching targetContraints.");
            } catch (AnnotatedException e) {
                throw new ExtCertPathBuilderException("Error finding target certificate.", e);
            }
        }
        StringBuilder m253r2 = outline.m253r("TargetConstraints must be an instance of ");
        m253r2.append(X509CertStoreSelector.class.getName());
        m253r2.append(" for ");
        m253r2.append(getClass().getName());
        m253r2.append(" class.");
        throw new CertPathBuilderException(m253r2.toString());
    }
}
