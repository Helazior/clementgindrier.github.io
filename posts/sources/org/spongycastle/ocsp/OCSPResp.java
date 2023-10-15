package org.spongycastle.ocsp;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ocsp.BasicOCSPResponse;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.asn1.ocsp.OCSPResponse;
import org.spongycastle.asn1.ocsp.ResponseBytes;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OCSPResp {
    private OCSPResponse resp;

    public OCSPResp(OCSPResponse oCSPResponse) {
        this.resp = oCSPResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OCSPResp) {
            return this.resp.equals(((OCSPResp) obj).resp);
        }
        return false;
    }

    public byte[] getEncoded() {
        return this.resp.getEncoded();
    }

    public Object getResponseObject() {
        ResponseBytes responseBytes = this.resp.getResponseBytes();
        if (responseBytes == null) {
            return null;
        }
        if (responseBytes.getResponseType().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
            try {
                return new BasicOCSPResp(BasicOCSPResponse.getInstance(ASN1Primitive.fromByteArray(responseBytes.getResponse().getOctets())));
            } catch (Exception e) {
                throw new OCSPException("problem decoding object: " + e, e);
            }
        }
        return responseBytes.getResponse();
    }

    public int getStatus() {
        return this.resp.getResponseStatus().getValue().intValue();
    }

    public int hashCode() {
        return this.resp.hashCode();
    }

    public OCSPResp(byte[] bArr) {
        this(new ASN1InputStream(bArr));
    }

    public OCSPResp(InputStream inputStream) {
        this(new ASN1InputStream(inputStream));
    }

    private OCSPResp(ASN1InputStream aSN1InputStream) {
        try {
            this.resp = OCSPResponse.getInstance(aSN1InputStream.readObject());
        } catch (ClassCastException e) {
            StringBuilder m253r = outline.m253r("malformed response: ");
            m253r.append(e.getMessage());
            throw new IOException(m253r.toString());
        } catch (IllegalArgumentException e2) {
            StringBuilder m253r2 = outline.m253r("malformed response: ");
            m253r2.append(e2.getMessage());
            throw new IOException(m253r2.toString());
        }
    }
}
