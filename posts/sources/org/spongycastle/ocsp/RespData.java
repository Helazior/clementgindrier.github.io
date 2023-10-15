package org.spongycastle.ocsp;

import java.security.cert.X509Extension;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.ocsp.ResponseData;
import org.spongycastle.asn1.ocsp.SingleResponse;
import org.spongycastle.asn1.x509.X509Extensions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RespData implements X509Extension {
    public ResponseData data;

    public RespData(ResponseData responseData) {
        this.data = responseData;
    }

    private Set getExtensionOIDs(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions responseExtensions = getResponseExtensions();
        if (responseExtensions != null) {
            Enumeration oids = responseExtensions.oids();
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                if (z == responseExtensions.getExtension(dERObjectIdentifier).isCritical()) {
                    hashSet.add(dERObjectIdentifier.getId());
                }
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        org.spongycastle.asn1.x509.X509Extension extension;
        X509Extensions responseExtensions = getResponseExtensions();
        if (responseExtensions == null || (extension = responseExtensions.getExtension(new DERObjectIdentifier(str))) == null) {
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

    public Date getProducedAt() {
        try {
            return this.data.getProducedAt().getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("ParseException:");
            m253r.append(e.getMessage());
            throw new IllegalStateException(m253r.toString());
        }
    }

    public RespID getResponderId() {
        return new RespID(this.data.getResponderID());
    }

    public X509Extensions getResponseExtensions() {
        return X509Extensions.getInstance(this.data.getResponseExtensions());
    }

    public SingleResp[] getResponses() {
        ASN1Sequence responses = this.data.getResponses();
        int size = responses.size();
        SingleResp[] singleRespArr = new SingleResp[size];
        for (int i = 0; i != size; i++) {
            singleRespArr[i] = new SingleResp(SingleResponse.getInstance(responses.getObjectAt(i)));
        }
        return singleRespArr;
    }

    public int getVersion() {
        return this.data.getVersion().getValue().intValue() + 1;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }
}
