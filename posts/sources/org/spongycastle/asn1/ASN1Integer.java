package org.spongycastle.asn1;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1Integer extends DERInteger {
    public ASN1Integer(byte[] bArr) {
        super(bArr);
    }

    public ASN1Integer(BigInteger bigInteger) {
        super(bigInteger);
    }

    public ASN1Integer(int i) {
        super(i);
    }
}
