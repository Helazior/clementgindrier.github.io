package org.spongycastle.asn1;

import java.util.Date;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1GeneralizedTime extends DERGeneralizedTime {
    public ASN1GeneralizedTime(byte[] bArr) {
        super(bArr);
    }

    public ASN1GeneralizedTime(Date date) {
        super(date);
    }

    public ASN1GeneralizedTime(String str) {
        super(str);
    }
}
