package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.DERIA5String;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NetscapeRevocationURL extends DERIA5String {
    public NetscapeRevocationURL(DERIA5String dERIA5String) {
        super(dERIA5String.getString());
    }

    @Override // org.spongycastle.asn1.DERIA5String
    public String toString() {
        StringBuilder m253r = outline.m253r("NetscapeRevocationURL: ");
        m253r.append(getString());
        return m253r.toString();
    }
}
