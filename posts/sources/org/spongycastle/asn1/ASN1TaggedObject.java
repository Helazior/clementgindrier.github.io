package org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    public boolean empty = false;
    public boolean explicit;
    public ASN1Encodable obj;
    public int tagNo;

    public ASN1TaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        this.explicit = true;
        this.obj = null;
        if (aSN1Encodable instanceof ASN1Choice) {
            this.explicit = true;
        } else {
            this.explicit = z;
        }
        this.tagNo = i;
        if (this.explicit) {
            this.obj = aSN1Encodable;
            return;
        }
        boolean z2 = aSN1Encodable.toASN1Primitive() instanceof ASN1Set;
        this.obj = aSN1Encodable;
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return (ASN1TaggedObject) aSN1TaggedObject.getObject();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            if (this.tagNo == aSN1TaggedObject.tagNo && this.empty == aSN1TaggedObject.empty && this.explicit == aSN1TaggedObject.explicit) {
                ASN1Encodable aSN1Encodable = this.obj;
                return aSN1Encodable == null ? aSN1TaggedObject.obj == null : aSN1Encodable.toASN1Primitive().equals(aSN1TaggedObject.obj.toASN1Primitive());
            }
            return false;
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream);

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public ASN1Primitive getObject() {
        ASN1Encodable aSN1Encodable = this.obj;
        if (aSN1Encodable != null) {
            return aSN1Encodable.toASN1Primitive();
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable getObjectParser(int i, boolean z) {
        if (i != 4) {
            if (i != 16) {
                if (i != 17) {
                    if (z) {
                        return getObject();
                    }
                    throw new RuntimeException(outline.m273H("implicit tagging not implemented for tag: ", i));
                }
                return ASN1Set.getInstance(this, z).parser();
            }
            return ASN1Sequence.getInstance(this, z).parser();
        }
        return ASN1OctetString.getInstance(this, z).parser();
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.tagNo;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        int i = this.tagNo;
        ASN1Encodable aSN1Encodable = this.obj;
        return aSN1Encodable != null ? i ^ aSN1Encodable.hashCode() : i;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("[");
        m253r.append(this.tagNo);
        m253r.append("]");
        m253r.append(this.obj);
        return m253r.toString();
    }

    public static ASN1TaggedObject getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1TaggedObject)) {
            if (obj instanceof byte[]) {
                try {
                    return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
                } catch (IOException e) {
                    StringBuilder m253r = outline.m253r("failed to construct tagged object from byte[]: ");
                    m253r.append(e.getMessage());
                    throw new IllegalArgumentException(m253r.toString());
                }
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("unknown object in getInstance: ")));
        }
        return (ASN1TaggedObject) obj;
    }
}
