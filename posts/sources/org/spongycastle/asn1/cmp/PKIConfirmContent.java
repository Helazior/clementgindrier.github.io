package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PKIConfirmContent extends ASN1Object {
    private ASN1Null val;

    private PKIConfirmContent(ASN1Null aSN1Null) {
        this.val = aSN1Null;
    }

    public static PKIConfirmContent getInstance(Object obj) {
        if (obj != null && !(obj instanceof PKIConfirmContent)) {
            if (obj instanceof ASN1Null) {
                return new PKIConfirmContent((ASN1Null) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid object: ")));
        }
        return (PKIConfirmContent) obj;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.val;
    }

    public PKIConfirmContent() {
        this.val = DERNull.INSTANCE;
    }
}
