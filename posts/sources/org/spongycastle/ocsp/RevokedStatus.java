package org.spongycastle.ocsp;

import java.text.ParseException;
import java.util.Date;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.ocsp.RevokedInfo;
import org.spongycastle.asn1.x509.CRLReason;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RevokedStatus implements CertificateStatus {
    public RevokedInfo info;

    public RevokedStatus(RevokedInfo revokedInfo) {
        this.info = revokedInfo;
    }

    public int getRevocationReason() {
        if (this.info.getRevocationReason() != null) {
            return this.info.getRevocationReason().getValue().intValue();
        }
        throw new IllegalStateException("attempt to get a reason where none is available");
    }

    public Date getRevocationTime() {
        try {
            return this.info.getRevocationTime().getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("ParseException:");
            m253r.append(e.getMessage());
            throw new IllegalStateException(m253r.toString());
        }
    }

    public boolean hasRevocationReason() {
        return this.info.getRevocationReason() != null;
    }

    public RevokedStatus(Date date, int i) {
        this.info = new RevokedInfo(new DERGeneralizedTime(date), CRLReason.lookup(i));
    }
}
