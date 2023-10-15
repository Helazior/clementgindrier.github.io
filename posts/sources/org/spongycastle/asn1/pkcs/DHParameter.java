package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHParameter extends ASN1Object {

    /* renamed from: g */
    public ASN1Integer f5670g;

    /* renamed from: l */
    public ASN1Integer f5671l;

    /* renamed from: p */
    public ASN1Integer f5672p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f5672p = new ASN1Integer(bigInteger);
        this.f5670g = new ASN1Integer(bigInteger2);
        if (i != 0) {
            this.f5671l = new ASN1Integer(i);
        } else {
            this.f5671l = null;
        }
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f5670g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer aSN1Integer = this.f5671l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f5672p.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5672p);
        aSN1EncodableVector.add(this.f5670g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.f5671l);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5672p = DERInteger.getInstance(objects.nextElement());
        this.f5670g = DERInteger.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.f5671l = (ASN1Integer) objects.nextElement();
        } else {
            this.f5671l = null;
        }
    }
}
