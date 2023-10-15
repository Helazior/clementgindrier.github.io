package org.spongycastle.asn1.ocsp;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CrlID extends ASN1Object {
    private ASN1Integer crlNum;
    private ASN1GeneralizedTime crlTime;
    private DERIA5String crlUrl;

    private CrlID(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.crlUrl = DERIA5String.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.crlNum = DERInteger.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 2) {
                this.crlTime = DERGeneralizedTime.getInstance(aSN1TaggedObject, true);
            } else {
                throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("unknown tag number: ")));
            }
        }
    }

    public static CrlID getInstance(Object obj) {
        if (obj instanceof CrlID) {
            return (CrlID) obj;
        }
        if (obj != null) {
            return new CrlID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCrlNum() {
        return this.crlNum;
    }

    public ASN1GeneralizedTime getCrlTime() {
        return this.crlTime;
    }

    public DERIA5String getCrlUrl() {
        return this.crlUrl;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERIA5String dERIA5String = this.crlUrl;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, dERIA5String));
        }
        ASN1Integer aSN1Integer = this.crlNum;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, aSN1Integer));
        }
        ASN1GeneralizedTime aSN1GeneralizedTime = this.crlTime;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, aSN1GeneralizedTime));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
