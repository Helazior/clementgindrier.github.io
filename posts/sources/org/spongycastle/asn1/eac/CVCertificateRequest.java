package org.spongycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1ParsingException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CVCertificateRequest extends ASN1Object {
    public static byte[] ZeroArray = {0};
    private static int bodyValid = 1;
    private static int signValid = 2;
    public int ProfileId;
    private CertificateBody certificateBody;
    public byte[] encoded;
    public byte[] encodedAuthorityReference;
    private byte[] outerSignature;
    public String strCertificateHolderReference;
    private int valid;
    private byte[] innerSignature = null;
    public ASN1ObjectIdentifier signOid = null;
    public ASN1ObjectIdentifier keyOid = null;
    public byte[] certificate = null;
    public String overSignerReference = null;
    public PublicKeyDataObject iso7816PubKey = null;

    private CVCertificateRequest(DERApplicationSpecific dERApplicationSpecific) {
        this.outerSignature = null;
        if (dERApplicationSpecific.getApplicationTag() == 103) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
            initCertBody(DERApplicationSpecific.getInstance(aSN1Sequence.getObjectAt(0)));
            this.outerSignature = DERApplicationSpecific.getInstance(aSN1Sequence.getObjectAt(aSN1Sequence.size() - 1)).getContents();
            return;
        }
        initCertBody(dERApplicationSpecific);
    }

    public static CVCertificateRequest getInstance(Object obj) {
        if (obj instanceof CVCertificateRequest) {
            return (CVCertificateRequest) obj;
        }
        if (obj != null) {
            try {
                return new CVCertificateRequest(DERApplicationSpecific.getInstance(obj));
            } catch (IOException e) {
                StringBuilder m253r = outline.m253r("unable to parse data: ");
                m253r.append(e.getMessage());
                throw new ASN1ParsingException(m253r.toString(), e);
            }
        }
        return null;
    }

    private void initCertBody(DERApplicationSpecific dERApplicationSpecific) {
        if (dERApplicationSpecific.getApplicationTag() == 33) {
            Enumeration objects = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16)).getObjects();
            while (objects.hasMoreElements()) {
                DERApplicationSpecific dERApplicationSpecific2 = DERApplicationSpecific.getInstance(objects.nextElement());
                int applicationTag = dERApplicationSpecific2.getApplicationTag();
                if (applicationTag == 55) {
                    this.innerSignature = dERApplicationSpecific2.getContents();
                    this.valid |= signValid;
                } else if (applicationTag == 78) {
                    this.certificateBody = CertificateBody.getInstance(dERApplicationSpecific2);
                    this.valid |= bodyValid;
                } else {
                    StringBuilder m253r = outline.m253r("Invalid tag, not an CV Certificate Request element:");
                    m253r.append(dERApplicationSpecific2.getApplicationTag());
                    throw new IOException(m253r.toString());
                }
            }
            return;
        }
        StringBuilder m253r2 = outline.m253r("not a CARDHOLDER_CERTIFICATE in request:");
        m253r2.append(dERApplicationSpecific.getApplicationTag());
        throw new IOException(m253r2.toString());
    }

    public CertificateBody getCertificateBody() {
        return this.certificateBody;
    }

    public byte[] getInnerSignature() {
        return this.innerSignature;
    }

    public byte[] getOuterSignature() {
        return this.outerSignature;
    }

    public PublicKeyDataObject getPublicKey() {
        return this.certificateBody.getPublicKey();
    }

    public boolean hasOuterSignature() {
        return this.outerSignature != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certificateBody);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, (ASN1Encodable) new DEROctetString(this.innerSignature)));
            return new DERApplicationSpecific(33, aSN1EncodableVector);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }
}
