package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Target extends ASN1Object implements ASN1Choice {
    public static final int targetGroup = 1;
    public static final int targetName = 0;
    private GeneralName targGroup;
    private GeneralName targName;

    private Target(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.targName = GeneralName.getInstance(aSN1TaggedObject, true);
        } else if (tagNo == 1) {
            this.targGroup = GeneralName.getInstance(aSN1TaggedObject, true);
        } else {
            throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("unknown tag: ")));
        }
    }

    public static Target getInstance(Object obj) {
        if (obj != null && !(obj instanceof Target)) {
            if (obj instanceof ASN1TaggedObject) {
                return new Target((ASN1TaggedObject) obj);
            }
            StringBuilder m253r = outline.m253r("unknown object in factory: ");
            m253r.append(obj.getClass());
            throw new IllegalArgumentException(m253r.toString());
        }
        return (Target) obj;
    }

    public GeneralName getTargetGroup() {
        return this.targGroup;
    }

    public GeneralName getTargetName() {
        return this.targName;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        GeneralName generalName = this.targName;
        if (generalName != null) {
            return new DERTaggedObject(true, 0, generalName);
        }
        return new DERTaggedObject(true, 1, this.targGroup);
    }

    public Target(int i, GeneralName generalName) {
        this(new DERTaggedObject(i, generalName));
    }
}
