package org.spongycastle.asn1;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DLTaggedObject extends ASN1TaggedObject {
    private static final byte[] ZERO_BYTES = new byte[0];

    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // org.spongycastle.asn1.ASN1TaggedObject, org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        if (!this.empty) {
            ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
            if (this.explicit) {
                aSN1OutputStream.writeTag(160, this.tagNo);
                aSN1OutputStream.writeLength(dLObject.encodedLength());
                aSN1OutputStream.writeObject(dLObject);
                return;
            }
            aSN1OutputStream.writeTag(dLObject.isConstructed() ? 160 : 128, this.tagNo);
            aSN1OutputStream.writeImplicitObject(dLObject);
            return;
        }
        aSN1OutputStream.writeEncoded(160, this.tagNo, ZERO_BYTES);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        if (!this.empty) {
            int encodedLength = this.obj.toASN1Primitive().toDLObject().encodedLength();
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
        return this.obj.toASN1Primitive().toDLObject().isConstructed();
    }
}
