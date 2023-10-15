package org.spongycastle.asn1;

import java.util.Vector;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1EncodableVector {

    /* renamed from: v */
    public Vector f5637v = new Vector();

    public void add(ASN1Encodable aSN1Encodable) {
        this.f5637v.addElement(aSN1Encodable);
    }

    public ASN1Encodable get(int i) {
        return (ASN1Encodable) this.f5637v.elementAt(i);
    }

    public int size() {
        return this.f5637v.size();
    }
}
