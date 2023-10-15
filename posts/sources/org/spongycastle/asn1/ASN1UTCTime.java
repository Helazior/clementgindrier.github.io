package org.spongycastle.asn1;

import java.util.Date;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1UTCTime extends DERUTCTime {
    public ASN1UTCTime(byte[] bArr) {
        super(bArr);
    }

    public ASN1UTCTime(Date date) {
        super(date);
    }

    public ASN1UTCTime(String str) {
        super(str);
    }
}
