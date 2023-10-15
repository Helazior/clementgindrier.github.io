package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.DERIA5String;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class VerisignCzagExtension extends DERIA5String {
    public VerisignCzagExtension(DERIA5String dERIA5String) {
        super(dERIA5String.getString());
    }

    @Override // org.spongycastle.asn1.DERIA5String
    public String toString() {
        StringBuilder m253r = outline.m253r("VerisignCzagExtension: ");
        m253r.append(getString());
        return m253r.toString();
    }
}
