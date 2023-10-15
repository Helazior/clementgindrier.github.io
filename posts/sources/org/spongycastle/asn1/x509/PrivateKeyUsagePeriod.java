package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PrivateKeyUsagePeriod extends ASN1Object {
    private DERGeneralizedTime _notAfter;
    private DERGeneralizedTime _notBefore;

    private PrivateKeyUsagePeriod(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (aSN1TaggedObject.getTagNo() == 0) {
                this._notBefore = DERGeneralizedTime.getInstance(aSN1TaggedObject, false);
            } else if (aSN1TaggedObject.getTagNo() == 1) {
                this._notAfter = DERGeneralizedTime.getInstance(aSN1TaggedObject, false);
            }
        }
    }

    public static PrivateKeyUsagePeriod getInstance(Object obj) {
        if (obj instanceof PrivateKeyUsagePeriod) {
            return (PrivateKeyUsagePeriod) obj;
        }
        if (obj != null) {
            return new PrivateKeyUsagePeriod(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERGeneralizedTime getNotAfter() {
        return this._notAfter;
    }

    public DERGeneralizedTime getNotBefore() {
        return this._notBefore;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERGeneralizedTime dERGeneralizedTime = this._notBefore;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, dERGeneralizedTime));
        }
        DERGeneralizedTime dERGeneralizedTime2 = this._notAfter;
        if (dERGeneralizedTime2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERGeneralizedTime2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
