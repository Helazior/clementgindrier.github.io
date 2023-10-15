package org.spongycastle.ocsp;

import java.security.cert.X509Extension;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.ocsp.CertStatus;
import org.spongycastle.asn1.ocsp.RevokedInfo;
import org.spongycastle.asn1.ocsp.SingleResponse;
import org.spongycastle.asn1.x509.X509Extensions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SingleResp implements X509Extension {
    public SingleResponse resp;

    public SingleResp(SingleResponse singleResponse) {
        this.resp = singleResponse;
    }

    private Set getExtensionOIDs(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions singleExtensions = getSingleExtensions();
        if (singleExtensions != null) {
            Enumeration oids = singleExtensions.oids();
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                if (z == singleExtensions.getExtension(dERObjectIdentifier).isCritical()) {
                    hashSet.add(dERObjectIdentifier.getId());
                }
            }
        }
        return hashSet;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.resp.getCertID());
    }

    public Object getCertStatus() {
        CertStatus certStatus = this.resp.getCertStatus();
        if (certStatus.getTagNo() == 0) {
            return null;
        }
        if (certStatus.getTagNo() == 1) {
            return new RevokedStatus(RevokedInfo.getInstance(certStatus.getStatus()));
        }
        return new UnknownStatus();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        org.spongycastle.asn1.x509.X509Extension extension;
        X509Extensions singleExtensions = getSingleExtensions();
        if (singleExtensions == null || (extension = singleExtensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new RuntimeException(outline.m275F(e, outline.m253r("error encoding ")));
        }
    }

    public Date getNextUpdate() {
        if (this.resp.getNextUpdate() == null) {
            return null;
        }
        try {
            return this.resp.getNextUpdate().getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("ParseException: ");
            m253r.append(e.getMessage());
            throw new IllegalStateException(m253r.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public X509Extensions getSingleExtensions() {
        return X509Extensions.getInstance(this.resp.getSingleExtensions());
    }

    public Date getThisUpdate() {
        try {
            return this.resp.getThisUpdate().getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("ParseException: ");
            m253r.append(e.getMessage());
            throw new IllegalStateException(m253r.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }
}
