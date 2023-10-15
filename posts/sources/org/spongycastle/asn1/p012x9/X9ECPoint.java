package org.spongycastle.asn1.p012x9;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.p017ec.ECCurve;
import org.spongycastle.math.p017ec.ECPoint;

/* renamed from: org.spongycastle.asn1.x9.X9ECPoint */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class X9ECPoint extends ASN1Object {

    /* renamed from: p */
    public ECPoint f5717p;

    public X9ECPoint(ECPoint eCPoint) {
        this.f5717p = eCPoint;
    }

    public ECPoint getPoint() {
        return this.f5717p;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.f5717p.getEncoded());
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this.f5717p = eCCurve.decodePoint(aSN1OctetString.getOctets());
    }
}
