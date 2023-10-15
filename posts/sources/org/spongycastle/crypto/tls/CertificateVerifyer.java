package org.spongycastle.crypto.tls;

import org.spongycastle.asn1.x509.X509CertificateStructure;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface CertificateVerifyer {
    boolean isValid(X509CertificateStructure[] x509CertificateStructureArr);
}
