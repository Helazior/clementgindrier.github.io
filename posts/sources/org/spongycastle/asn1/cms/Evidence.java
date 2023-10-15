package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Evidence extends ASN1Object implements ASN1Choice {
    private TimeStampTokenEvidence tstEvidence;

    public Evidence(TimeStampTokenEvidence timeStampTokenEvidence) {
        this.tstEvidence = timeStampTokenEvidence;
    }

    public static Evidence getInstance(Object obj) {
        if (obj != null && !(obj instanceof Evidence)) {
            if (obj instanceof ASN1TaggedObject) {
                return new Evidence(ASN1TaggedObject.getInstance(obj));
            }
            throw new IllegalArgumentException("unknown object in getInstance");
        }
        return (Evidence) obj;
    }

    public TimeStampTokenEvidence getTstEvidence() {
        return this.tstEvidence;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        TimeStampTokenEvidence timeStampTokenEvidence = this.tstEvidence;
        if (timeStampTokenEvidence != null) {
            return new DERTaggedObject(false, 0, timeStampTokenEvidence);
        }
        return null;
    }

    private Evidence(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.tstEvidence = TimeStampTokenEvidence.getInstance(aSN1TaggedObject, false);
        }
    }
}
