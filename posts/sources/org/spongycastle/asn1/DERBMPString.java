package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DERBMPString extends ASN1Primitive implements ASN1String {
    private char[] string;

    public DERBMPString(byte[] bArr) {
        int length = bArr.length / 2;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            int i2 = i * 2;
            cArr[i] = (char) ((bArr[i2 + 1] & 255) | (bArr[i2] << 8));
        }
        this.string = cArr;
    }

    public static DERBMPString getInstance(Object obj) {
        if (obj != null && !(obj instanceof DERBMPString)) {
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (DERBMPString) obj;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERBMPString) {
            return Arrays.areEqual(this.string, ((DERBMPString) aSN1Primitive).string);
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.write(30);
        aSN1OutputStream.writeLength(this.string.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.string;
            if (i == cArr.length) {
                return;
            }
            char c = cArr[i];
            aSN1OutputStream.write((byte) (c >> '\b'));
            aSN1OutputStream.write((byte) c);
            i++;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return (this.string.length * 2) + StreamUtil.calculateBodyLength(this.string.length * 2) + 1;
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return new String(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof DERBMPString)) {
            return new DERBMPString(ASN1OctetString.getInstance(object).getOctets());
        }
        return getInstance(object);
    }

    public DERBMPString(char[] cArr) {
        this.string = cArr;
    }

    public DERBMPString(String str) {
        this.string = str.toCharArray();
    }
}
