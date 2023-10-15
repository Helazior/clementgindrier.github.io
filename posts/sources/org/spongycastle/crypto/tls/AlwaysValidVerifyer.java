package org.spongycastle.crypto.tls;

import org.spongycastle.asn1.x509.X509CertificateStructure;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AlwaysValidVerifyer implements CertificateVerifyer {
    @Override // org.spongycastle.crypto.tls.CertificateVerifyer
    public boolean isValid(X509CertificateStructure[] x509CertificateStructureArr) {
        return true;
    }
}
