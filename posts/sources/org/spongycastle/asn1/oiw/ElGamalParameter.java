package org.spongycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ElGamalParameter extends ASN1Object {

    /* renamed from: g */
    public ASN1Integer f5668g;

    /* renamed from: p */
    public ASN1Integer f5669p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f5669p = new ASN1Integer(bigInteger);
        this.f5668g = new ASN1Integer(bigInteger2);
    }

    public BigInteger getG() {
        return this.f5668g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f5669p.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5669p);
        aSN1EncodableVector.add(this.f5668g);
        return new DERSequence(aSN1EncodableVector);
    }

    public ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5669p = (ASN1Integer) objects.nextElement();
        this.f5668g = (ASN1Integer) objects.nextElement();
    }
}
