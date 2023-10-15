package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.DERUTCTime;
import org.spongycastle.asn1.x500.X500Name;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class V3TBSCertificateGenerator {
    private boolean altNamePresentAndCritical;
    public Time endDate;
    public Extensions extensions;
    public X500Name issuer;
    private DERBitString issuerUniqueID;
    public ASN1Integer serialNumber;
    public AlgorithmIdentifier signature;
    public Time startDate;
    public X500Name subject;
    public SubjectPublicKeyInfo subjectPublicKeyInfo;
    private DERBitString subjectUniqueID;
    public DERTaggedObject version = new DERTaggedObject(true, 0, new ASN1Integer(2));

    public TBSCertificate generateTBSCertificate() {
        if (this.serialNumber != null && this.signature != null && this.issuer != null && this.startDate != null && this.endDate != null && ((this.subject != null || this.altNamePresentAndCritical) && this.subjectPublicKeyInfo != null)) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(this.version);
            aSN1EncodableVector.add(this.serialNumber);
            aSN1EncodableVector.add(this.signature);
            aSN1EncodableVector.add(this.issuer);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(this.startDate);
            aSN1EncodableVector2.add(this.endDate);
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            X500Name x500Name = this.subject;
            if (x500Name != null) {
                aSN1EncodableVector.add(x500Name);
            } else {
                aSN1EncodableVector.add(new DERSequence());
            }
            aSN1EncodableVector.add(this.subjectPublicKeyInfo);
            DERBitString dERBitString = this.issuerUniqueID;
            if (dERBitString != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERBitString));
            }
            DERBitString dERBitString2 = this.subjectUniqueID;
            if (dERBitString2 != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 2, dERBitString2));
            }
            Extensions extensions = this.extensions;
            if (extensions != null) {
                aSN1EncodableVector.add(new DERTaggedObject(true, 3, extensions));
            }
            return TBSCertificate.getInstance(new DERSequence(aSN1EncodableVector));
        }
        throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
    }

    public void setEndDate(DERUTCTime dERUTCTime) {
        this.endDate = new Time(dERUTCTime);
    }

    public void setExtensions(X509Extensions x509Extensions) {
        setExtensions(Extensions.getInstance(x509Extensions));
    }

    public void setIssuer(X509Name x509Name) {
        this.issuer = X500Name.getInstance(x509Name);
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

    public void setStartDate(DERUTCTime dERUTCTime) {
        this.startDate = new Time(dERUTCTime);
    }

    public void setSubject(X509Name x509Name) {
        this.subject = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
    }

    public void setSubjectUniqueID(DERBitString dERBitString) {
        this.subjectUniqueID = dERBitString;
    }

    public void setEndDate(Time time) {
        this.endDate = time;
    }

    public void setExtensions(Extensions extensions) {
        Extension extension;
        this.extensions = extensions;
        if (extensions == null || (extension = extensions.getExtension(Extension.subjectAlternativeName)) == null || !extension.isCritical()) {
            return;
        }
        this.altNamePresentAndCritical = true;
    }

    public void setIssuer(X500Name x500Name) {
        this.issuer = x500Name;
    }

    public void setStartDate(Time time) {
        this.startDate = time;
    }

    public void setSubject(X500Name x500Name) {
        this.subject = x500Name;
    }
}
