package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.asn1.x509.Certificate;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CMPCertificate extends ASN1Object implements ASN1Choice {
    private AttributeCertificate x509v2AttrCert;
    private Certificate x509v3PKCert;

    public CMPCertificate(AttributeCertificate attributeCertificate) {
        this.x509v2AttrCert = attributeCertificate;
    }

    public static CMPCertificate getInstance(Object obj) {
        if (obj != null && !(obj instanceof CMPCertificate)) {
            if (obj instanceof ASN1Sequence) {
                return new CMPCertificate(Certificate.getInstance(obj));
            }
            if (obj instanceof ASN1TaggedObject) {
                return new CMPCertificate(AttributeCertificate.getInstance(((ASN1TaggedObject) obj).getObject()));
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid object: ")));
        }
        return (CMPCertificate) obj;
    }

    public AttributeCertificate getX509v2AttrCert() {
        return this.x509v2AttrCert;
    }

    public Certificate getX509v3PKCert() {
        return this.x509v3PKCert;
    }

    public boolean isX509v3PKCert() {
        return this.x509v3PKCert != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        AttributeCertificate attributeCertificate = this.x509v2AttrCert;
        if (attributeCertificate != null) {
            return new DERTaggedObject(true, 1, attributeCertificate);
        }
        return this.x509v3PKCert.toASN1Primitive();
    }

    public CMPCertificate(Certificate certificate) {
        if (certificate.getVersionNumber() == 3) {
            this.x509v3PKCert = certificate;
            return;
        }
        throw new IllegalArgumentException("only version 3 certificates allowed");
    }
}
