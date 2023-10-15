package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class V2AttributeCertificateInfoGenerator {
    private DERGeneralizedTime endDate;
    private Extensions extensions;
    private Holder holder;
    private AttCertIssuer issuer;
    private DERBitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;
    private DERGeneralizedTime startDate;
    private ASN1Integer version = new ASN1Integer(1);
    private ASN1EncodableVector attributes = new ASN1EncodableVector();

    public void addAttribute(String str, ASN1Encodable aSN1Encodable) {
        this.attributes.add(new Attribute(new ASN1ObjectIdentifier(str), new DERSet(aSN1Encodable)));
    }

    public AttributeCertificateInfo generateAttributeCertificateInfo() {
        if (this.serialNumber != null && this.signature != null && this.issuer != null && this.startDate != null && this.endDate != null && this.holder != null && this.attributes != null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(this.version);
            aSN1EncodableVector.add(this.holder);
            aSN1EncodableVector.add(this.issuer);
            aSN1EncodableVector.add(this.signature);
            aSN1EncodableVector.add(this.serialNumber);
            aSN1EncodableVector.add(new AttCertValidityPeriod(this.startDate, this.endDate));
            aSN1EncodableVector.add(new DERSequence(this.attributes));
            DERBitString dERBitString = this.issuerUniqueID;
            if (dERBitString != null) {
                aSN1EncodableVector.add(dERBitString);
            }
            Extensions extensions = this.extensions;
            if (extensions != null) {
                aSN1EncodableVector.add(extensions);
            }
            return AttributeCertificateInfo.getInstance(new DERSequence(aSN1EncodableVector));
        }
        throw new IllegalStateException("not all mandatory fields set in V2 AttributeCertificateInfo generator");
    }

    public void setEndDate(DERGeneralizedTime dERGeneralizedTime) {
        this.endDate = dERGeneralizedTime;
    }

    public void setExtensions(X509Extensions x509Extensions) {
        this.extensions = Extensions.getInstance(x509Extensions.toASN1Primitive());
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public void setIssuer(AttCertIssuer attCertIssuer) {
        this.issuer = attCertIssuer;
    }

    public void setIssuerUniqueID(DERBitString dERBitString) {
        this.issuerUniqueID = dERBitString;
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.serialNumber = aSN1Integer;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setStartDate(DERGeneralizedTime dERGeneralizedTime) {
        this.startDate = dERGeneralizedTime;
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }
}
