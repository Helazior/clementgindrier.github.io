package org.spongycastle.asn1.eac;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1ParsingException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CVCertificate extends ASN1Object {
    public static String ReferenceEncoding = "ISO-8859-1";
    private static int bodyValid = 1;
    private static int signValid = 2;
    public static final byte version_1 = 0;
    private CertificateBody certificateBody;
    private byte[] signature;
    private int valid;

    public CVCertificate(ASN1InputStream aSN1InputStream) {
        initFrom(aSN1InputStream);
    }

    public static CVCertificate getInstance(Object obj) {
        if (obj instanceof CVCertificate) {
            return (CVCertificate) obj;
        }
        if (obj != null) {
            try {
                return new CVCertificate(DERApplicationSpecific.getInstance(obj));
            } catch (IOException e) {
                StringBuilder m253r = outline.m253r("unable to parse data: ");
                m253r.append(e.getMessage());
                throw new ASN1ParsingException(m253r.toString(), e);
            }
        }
        return null;
    }

    private void initFrom(ASN1InputStream aSN1InputStream) {
        while (true) {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject == null) {
                return;
            }
            if (readObject instanceof DERApplicationSpecific) {
                setPrivateData((DERApplicationSpecific) readObject);
            } else {
                throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
            }
        }
    }

    private void setPrivateData(DERApplicationSpecific dERApplicationSpecific) {
        this.valid = 0;
        if (dERApplicationSpecific.getApplicationTag() == 33) {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(dERApplicationSpecific.getContents());
            while (true) {
                ASN1Primitive readObject = aSN1InputStream.readObject();
                if (readObject == null) {
                    return;
                }
                if (readObject instanceof DERApplicationSpecific) {
                    DERApplicationSpecific dERApplicationSpecific2 = (DERApplicationSpecific) readObject;
                    int applicationTag = dERApplicationSpecific2.getApplicationTag();
                    if (applicationTag == 55) {
                        this.signature = dERApplicationSpecific2.getContents();
                        this.valid |= signValid;
                    } else if (applicationTag == 78) {
                        this.certificateBody = CertificateBody.getInstance(dERApplicationSpecific2);
                        this.valid |= bodyValid;
                    } else {
                        StringBuilder m253r = outline.m253r("Invalid tag, not an Iso7816CertificateStructure :");
                        m253r.append(dERApplicationSpecific2.getApplicationTag());
                        throw new IOException(m253r.toString());
                    }
                } else {
                    throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
                }
            }
        } else {
            StringBuilder m253r2 = outline.m253r("not a CARDHOLDER_CERTIFICATE :");
            m253r2.append(dERApplicationSpecific.getApplicationTag());
            throw new IOException(m253r2.toString());
        }
    }

    public CertificationAuthorityReference getAuthorityReference() {
        return this.certificateBody.getCertificationAuthorityReference();
    }

    public CertificateBody getBody() {
        return this.certificateBody;
    }

    public int getCertificateType() {
        return this.certificateBody.getCertificateType();
    }

    public PackedDate getEffectiveDate() {
        return this.certificateBody.getCertificateEffectiveDate();
    }

    public PackedDate getExpirationDate() {
        return this.certificateBody.getCertificateExpirationDate();
    }

    public ASN1ObjectIdentifier getHolderAuthorization() {
        return this.certificateBody.getCertificateHolderAuthorization().getOid();
    }

    public Flags getHolderAuthorizationRights() {
        return new Flags(this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 31);
    }

    public int getHolderAuthorizationRole() {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 192;
    }

    public CertificateHolderReference getHolderReference() {
        return this.certificateBody.getCertificateHolderReference();
    }

    public int getRole() {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights();
    }

    public byte[] getSignature() {
        return this.signature;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.valid != (signValid | bodyValid)) {
            return null;
        }
        aSN1EncodableVector.add(this.certificateBody);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, (ASN1Encodable) new DEROctetString(this.signature)));
            return new DERApplicationSpecific(33, aSN1EncodableVector);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }

    private CVCertificate(DERApplicationSpecific dERApplicationSpecific) {
        setPrivateData(dERApplicationSpecific);
    }

    public CVCertificate(CertificateBody certificateBody, byte[] bArr) {
        this.certificateBody = certificateBody;
        this.signature = bArr;
        int i = this.valid | bodyValid;
        this.valid = i;
        this.valid = i | signValid;
    }
}
