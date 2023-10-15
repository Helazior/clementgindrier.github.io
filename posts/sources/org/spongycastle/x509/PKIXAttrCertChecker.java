package org.spongycastle.x509;

import java.security.cert.CertPath;
import java.util.Collection;
import java.util.Set;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class PKIXAttrCertChecker implements Cloneable {
    public abstract void check(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, Collection collection);

    public abstract Object clone();

    public abstract Set getSupportedExtensions();
}
