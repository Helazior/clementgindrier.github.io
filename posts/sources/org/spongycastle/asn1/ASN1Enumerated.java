package org.spongycastle.asn1;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1Enumerated extends DEREnumerated {
    public ASN1Enumerated(byte[] bArr) {
        super(bArr);
    }

    public ASN1Enumerated(BigInteger bigInteger) {
        super(bigInteger);
    }

    public ASN1Enumerated(int i) {
        super(i);
    }
}
