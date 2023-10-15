package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DERBoolean extends ASN1Primitive {
    private byte[] value;
    private static final byte[] TRUE_VALUE = {-1};
    private static final byte[] FALSE_VALUE = {0};
    public static final ASN1Boolean FALSE = new ASN1Boolean(false);
    public static final ASN1Boolean TRUE = new ASN1Boolean(true);

    public DERBoolean(byte[] bArr) {
        if (bArr.length == 1) {
            if (bArr[0] == 0) {
                this.value = FALSE_VALUE;
                return;
            } else if (bArr[0] == 255) {
                this.value = TRUE_VALUE;
                return;
            } else {
                this.value = Arrays.clone(bArr);
                return;
            }
        }
        throw new IllegalArgumentException("byte value should have 1 byte in it");
    }

    public static ASN1Boolean fromOctetString(byte[] bArr) {
        if (bArr.length == 1) {
            if (bArr[0] == 0) {
                return FALSE;
            }
            if (bArr[0] == 255) {
                return TRUE;
            }
            return new ASN1Boolean(bArr);
        }
        throw new IllegalArgumentException("byte value should have 1 byte in it");
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1Boolean)) {
            if (obj instanceof DERBoolean) {
                return ((DERBoolean) obj).isTrue() ? TRUE : FALSE;
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (ASN1Boolean) obj;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive != null && (aSN1Primitive instanceof DERBoolean) && this.value[0] == ((DERBoolean) aSN1Primitive).value[0];
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(1, this.value);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return 3;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.value[0];
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        return this.value[0] != 0;
    }

    public String toString() {
        return this.value[0] != 0 ? "TRUE" : "FALSE";
    }

    public static ASN1Boolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }

    public static DERBoolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof DERBoolean)) {
            return fromOctetString(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }

    public DERBoolean(boolean z) {
        this.value = z ? TRUE_VALUE : FALSE_VALUE;
    }
}
