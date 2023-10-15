package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NameConstraints extends ASN1Object {
    private ASN1Sequence excluded;
    private ASN1Sequence permitted;

    private NameConstraints(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.permitted = ASN1Sequence.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 1) {
                this.excluded = ASN1Sequence.getInstance(aSN1TaggedObject, false);
            }
        }
    }

    private DERSequence createSequence(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.add((GeneralSubtree) elements.nextElement());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static NameConstraints getInstance(Object obj) {
        if (obj instanceof NameConstraints) {
            return (NameConstraints) obj;
        }
        if (obj != null) {
            return new NameConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Sequence getExcludedSubtrees() {
        return this.excluded;
    }

    public ASN1Sequence getPermittedSubtrees() {
        return this.permitted;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Sequence aSN1Sequence = this.permitted;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Sequence));
        }
        ASN1Sequence aSN1Sequence2 = this.excluded;
        if (aSN1Sequence2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Sequence2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public NameConstraints(Vector vector, Vector vector2) {
        if (vector != null) {
            this.permitted = createSequence(vector);
        }
        if (vector2 != null) {
            this.excluded = createSequence(vector2);
        }
    }
}
