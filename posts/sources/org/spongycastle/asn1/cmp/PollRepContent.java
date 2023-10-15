package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PollRepContent extends ASN1Object {
    private ASN1Integer certReqId;
    private ASN1Integer checkAfter;
    private PKIFreeText reason;

    private PollRepContent(ASN1Sequence aSN1Sequence) {
        this.certReqId = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.checkAfter = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.reason = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static PollRepContent getInstance(Object obj) {
        if (obj instanceof PollRepContent) {
            return (PollRepContent) obj;
        }
        if (obj != null) {
            return new PollRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public ASN1Integer getCheckAfter() {
        return this.checkAfter;
    }

    public PKIFreeText getReason() {
        return this.reason;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certReqId);
        aSN1EncodableVector.add(this.checkAfter);
        PKIFreeText pKIFreeText = this.reason;
        if (pKIFreeText != null) {
            aSN1EncodableVector.add(pKIFreeText);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
