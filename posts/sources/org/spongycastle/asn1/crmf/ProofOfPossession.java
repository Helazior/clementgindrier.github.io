package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    private ASN1Encodable obj;
    private int tagNo;

    private ProofOfPossession(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.tagNo = tagNo;
        if (tagNo == 0) {
            this.obj = DERNull.INSTANCE;
        } else if (tagNo == 1) {
            this.obj = POPOSigningKey.getInstance(aSN1TaggedObject, false);
        } else if (tagNo != 2 && tagNo != 3) {
            StringBuilder m253r = outline.m253r("unknown tag: ");
            m253r.append(this.tagNo);
            throw new IllegalArgumentException(m253r.toString());
        } else {
            this.obj = POPOPrivKey.getInstance(aSN1TaggedObject, false);
        }
    }

    public static ProofOfPossession getInstance(Object obj) {
        if (obj != null && !(obj instanceof ProofOfPossession)) {
            if (obj instanceof ASN1TaggedObject) {
                return new ProofOfPossession((ASN1TaggedObject) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid object: ")));
        }
        return (ProofOfPossession) obj;
    }

    public ASN1Encodable getObject() {
        return this.obj;
    }

    public int getType() {
        return this.tagNo;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }

    public ProofOfPossession() {
        this.tagNo = 0;
        this.obj = DERNull.INSTANCE;
    }

    public ProofOfPossession(POPOSigningKey pOPOSigningKey) {
        this.tagNo = 1;
        this.obj = pOPOSigningKey;
    }

    public ProofOfPossession(int i, POPOPrivKey pOPOPrivKey) {
        this.tagNo = i;
        this.obj = pOPOPrivKey;
    }
}
