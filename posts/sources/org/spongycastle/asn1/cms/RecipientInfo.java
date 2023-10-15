package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RecipientInfo extends ASN1Object implements ASN1Choice {
    public ASN1Encodable info;

    public RecipientInfo(KeyTransRecipientInfo keyTransRecipientInfo) {
        this.info = keyTransRecipientInfo;
    }

    public static RecipientInfo getInstance(Object obj) {
        if (obj != null && !(obj instanceof RecipientInfo)) {
            if (obj instanceof ASN1Sequence) {
                return new RecipientInfo((ASN1Sequence) obj);
            }
            if (obj instanceof ASN1TaggedObject) {
                return new RecipientInfo((ASN1TaggedObject) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("unknown object in factory: ")));
        }
        return (RecipientInfo) obj;
    }

    private KEKRecipientInfo getKEKInfo(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.isExplicit()) {
            return KEKRecipientInfo.getInstance(aSN1TaggedObject, true);
        }
        return KEKRecipientInfo.getInstance(aSN1TaggedObject, false);
    }

    public ASN1Encodable getInfo() {
        ASN1Encodable aSN1Encodable = this.info;
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo != 1) {
                if (tagNo != 2) {
                    if (tagNo != 3) {
                        if (tagNo == 4) {
                            return OtherRecipientInfo.getInstance(aSN1TaggedObject, false);
                        }
                        throw new IllegalStateException("unknown tag");
                    }
                    return PasswordRecipientInfo.getInstance(aSN1TaggedObject, false);
                }
                return getKEKInfo(aSN1TaggedObject);
            }
            return KeyAgreeRecipientInfo.getInstance(aSN1TaggedObject, false);
        }
        return KeyTransRecipientInfo.getInstance(aSN1Encodable);
    }

    public ASN1Integer getVersion() {
        ASN1Encodable aSN1Encodable = this.info;
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo != 1) {
                if (tagNo != 2) {
                    if (tagNo != 3) {
                        if (tagNo == 4) {
                            return new ASN1Integer(0);
                        }
                        throw new IllegalStateException("unknown tag");
                    }
                    return PasswordRecipientInfo.getInstance(aSN1TaggedObject, false).getVersion();
                }
                return getKEKInfo(aSN1TaggedObject).getVersion();
            }
            return KeyAgreeRecipientInfo.getInstance(aSN1TaggedObject, false).getVersion();
        }
        return KeyTransRecipientInfo.getInstance(aSN1Encodable).getVersion();
    }

    public boolean isTagged() {
        return this.info instanceof ASN1TaggedObject;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.info.toASN1Primitive();
    }

    public RecipientInfo(KeyAgreeRecipientInfo keyAgreeRecipientInfo) {
        this.info = new DERTaggedObject(false, 1, keyAgreeRecipientInfo);
    }

    public RecipientInfo(KEKRecipientInfo kEKRecipientInfo) {
        this.info = new DERTaggedObject(false, 2, kEKRecipientInfo);
    }

    public RecipientInfo(PasswordRecipientInfo passwordRecipientInfo) {
        this.info = new DERTaggedObject(false, 3, passwordRecipientInfo);
    }

    public RecipientInfo(OtherRecipientInfo otherRecipientInfo) {
        this.info = new DERTaggedObject(false, 4, otherRecipientInfo);
    }

    public RecipientInfo(ASN1Primitive aSN1Primitive) {
        this.info = aSN1Primitive;
    }
}
