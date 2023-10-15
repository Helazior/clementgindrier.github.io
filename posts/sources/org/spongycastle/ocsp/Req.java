package org.spongycastle.ocsp;

import java.security.cert.X509Extension;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.ocsp.Request;
import org.spongycastle.asn1.x509.X509Extensions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Req implements X509Extension {
    private Request req;

    public Req(Request request) {
        this.req = request;
    }

    private Set getExtensionOIDs(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions singleRequestExtensions = getSingleRequestExtensions();
        if (singleRequestExtensions != null) {
            Enumeration oids = singleRequestExtensions.oids();
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                if (z == singleRequestExtensions.getExtension(dERObjectIdentifier).isCritical()) {
                    hashSet.add(dERObjectIdentifier.getId());
                }
            }
        }
        return hashSet;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.req.getReqCert());
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        org.spongycastle.asn1.x509.X509Extension extension;
        X509Extensions singleRequestExtensions = getSingleRequestExtensions();
        if (singleRequestExtensions == null || (extension = singleRequestExtensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new RuntimeException(outline.m275F(e, outline.m253r("error encoding ")));
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public X509Extensions getSingleRequestExtensions() {
        return X509Extensions.getInstance(this.req.getSingleRequestExtensions());
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }
}
