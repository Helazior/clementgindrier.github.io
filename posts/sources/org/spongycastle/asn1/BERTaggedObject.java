package org.spongycastle.asn1;

import java.util.Enumeration;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObject, org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        Enumeration objects;
        aSN1OutputStream.writeTag(160, this.tagNo);
        aSN1OutputStream.write(128);
        if (!this.empty) {
            if (!this.explicit) {
                ASN1Encodable aSN1Encodable = this.obj;
                if (aSN1Encodable instanceof ASN1OctetString) {
                    if (aSN1Encodable instanceof BEROctetString) {
                        objects = ((BEROctetString) aSN1Encodable).getObjects();
                    } else {
                        objects = new BEROctetString(((ASN1OctetString) aSN1Encodable).getOctets()).getObjects();
                    }
                } else if (aSN1Encodable instanceof ASN1Sequence) {
                    objects = ((ASN1Sequence) aSN1Encodable).getObjects();
                } else if (aSN1Encodable instanceof ASN1Set) {
                    objects = ((ASN1Set) aSN1Encodable).getObjects();
                } else {
                    StringBuilder m253r = outline.m253r("not implemented: ");
                    m253r.append(this.obj.getClass().getName());
                    throw new RuntimeException(m253r.toString());
                }
                while (objects.hasMoreElements()) {
                    aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
                }
            } else {
                aSN1OutputStream.writeObject(this.obj);
            }
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        if (!this.empty) {
            int encodedLength = this.obj.toASN1Primitive().encodedLength();
            if (this.explicit) {
                return StreamUtil.calculateBodyLength(encodedLength) + StreamUtil.calculateTagLength(this.tagNo) + encodedLength;
            }
            return StreamUtil.calculateTagLength(this.tagNo) + (encodedLength - 1);
        }
        return StreamUtil.calculateTagLength(this.tagNo) + 1;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        if (this.empty || this.explicit) {
            return true;
        }
        return this.obj.toASN1Primitive().toDERObject().isConstructed();
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public BERTaggedObject(int i) {
        super(false, i, new BERSequence());
    }
}
