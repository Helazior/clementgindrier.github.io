package org.spongycastle.asn1.isismtt.ocsp;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.X509CertificateStructure;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RequestedCertificate extends ASN1Object implements ASN1Choice {
    public static final int attributeCertificate = 1;
    public static final int certificate = -1;
    public static final int publicKeyCertificate = 0;
    private byte[] attributeCert;
    private X509CertificateStructure cert;
    private byte[] publicKeyCert;

    private RequestedCertificate(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.publicKeyCert = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.attributeCert = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else {
            throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("unknown tag number: ")));
        }
    }

    public static RequestedCertificate getInstance(Object obj) {
        if (obj != null && !(obj instanceof RequestedCertificate)) {
            if (obj instanceof ASN1Sequence) {
                return new RequestedCertificate(X509CertificateStructure.getInstance(obj));
            }
            if (obj instanceof ASN1TaggedObject) {
                return new RequestedCertificate((ASN1TaggedObject) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (RequestedCertificate) obj;
    }

    public byte[] getCertificateBytes() {
        X509CertificateStructure x509CertificateStructure = this.cert;
        if (x509CertificateStructure != null) {
            try {
                return x509CertificateStructure.getEncoded();
            } catch (IOException e) {
                throw new IllegalStateException(outline.m268c("can't decode certificate: ", e));
            }
        }
        byte[] bArr = this.publicKeyCert;
        return bArr != null ? bArr : this.attributeCert;
    }

    public int getType() {
        if (this.cert != null) {
            return -1;
        }
        return this.publicKeyCert != null ? 0 : 1;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        byte[] bArr = this.publicKeyCert;
        if (bArr != null) {
            return new DERTaggedObject(0, new DEROctetString(bArr));
        }
        byte[] bArr2 = this.attributeCert;
        if (bArr2 != null) {
            return new DERTaggedObject(1, new DEROctetString(bArr2));
        }
        return this.cert.toASN1Primitive();
    }

    public RequestedCertificate(X509CertificateStructure x509CertificateStructure) {
        this.cert = x509CertificateStructure;
    }

    public static RequestedCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public RequestedCertificate(int i, byte[] bArr) {
        this(new DERTaggedObject(i, new DEROctetString(bArr)));
    }
}
