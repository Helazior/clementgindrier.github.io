package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DERApplicationSpecific extends ASN1Primitive {
    private final boolean isConstructed;
    private final byte[] octets;
    private final int tag;

    public DERApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = bArr;
    }

    public static DERApplicationSpecific getInstance(Object obj) {
        if (obj != null && !(obj instanceof DERApplicationSpecific)) {
            if (obj instanceof byte[]) {
                try {
                    return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
                } catch (IOException e) {
                    StringBuilder m253r = outline.m253r("failed to construct object from byte[]: ");
                    m253r.append(e.getMessage());
                    throw new IllegalArgumentException(m253r.toString());
                }
            }
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Sequence) {
                    return (DERApplicationSpecific) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("unknown object in getInstance: ")));
        }
        return (DERApplicationSpecific) obj;
    }

    private int getLengthOfHeader(byte[] bArr) {
        int i = bArr[1] & 255;
        if (i != 128 && i > 127) {
            int i2 = i & 127;
            if (i2 <= 4) {
                return i2 + 2;
            }
            throw new IllegalStateException(outline.m273H("DER length more than 4 bytes: ", i2));
        }
        return 2;
    }

    private byte[] replaceTagNumber(int i, byte[] bArr) {
        int i2;
        if ((bArr[0] & 31) == 31) {
            i2 = 2;
            int i3 = bArr[1] & 255;
            if ((i3 & 127) == 0) {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
            while (i3 >= 0 && (i3 & 128) != 0) {
                i3 = bArr[i2] & 255;
                i2++;
            }
        } else {
            i2 = 1;
        }
        int length = (bArr.length - i2) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, 1, length - 1);
        bArr2[0] = (byte) i;
        return bArr2;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERApplicationSpecific) {
            DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) aSN1Primitive;
            return this.isConstructed == dERApplicationSpecific.isConstructed && this.tag == dERApplicationSpecific.tag && Arrays.areEqual(this.octets, dERApplicationSpecific.octets);
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.octets.length) + StreamUtil.calculateTagLength(this.tag) + this.octets.length;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return this.octets;
    }

    public ASN1Primitive getObject() {
        return new ASN1InputStream(getContents()).readObject();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        boolean z = this.isConstructed;
        return ((z ? 1 : 0) ^ this.tag) ^ Arrays.hashCode(this.octets);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return this.isConstructed;
    }

    public ASN1Primitive getObject(int i) {
        if (i < 31) {
            byte[] encoded = getEncoded();
            byte[] replaceTagNumber = replaceTagNumber(i, encoded);
            if ((encoded[0] & 32) != 0) {
                replaceTagNumber[0] = (byte) (replaceTagNumber[0] | 32);
            }
            return new ASN1InputStream(replaceTagNumber).readObject();
        }
        throw new IOException("unsupported tag number");
    }

    public DERApplicationSpecific(int i, byte[] bArr) {
        this(false, i, bArr);
    }

    public DERApplicationSpecific(int i, ASN1Encodable aSN1Encodable) {
        this(true, i, aSN1Encodable);
    }

    public DERApplicationSpecific(boolean z, int i, ASN1Encodable aSN1Encodable) {
        ASN1Primitive aSN1Primitive = aSN1Encodable.toASN1Primitive();
        byte[] encoded = aSN1Primitive.getEncoded(ASN1Encoding.DER);
        this.isConstructed = z || (aSN1Primitive instanceof ASN1Set) || (aSN1Primitive instanceof ASN1Sequence);
        this.tag = i;
        if (z) {
            this.octets = encoded;
            return;
        }
        int lengthOfHeader = getLengthOfHeader(encoded);
        int length = encoded.length - lengthOfHeader;
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, lengthOfHeader, bArr, 0, length);
        this.octets = bArr;
    }

    public DERApplicationSpecific(int i, ASN1EncodableVector aSN1EncodableVector) {
        this.tag = i;
        this.isConstructed = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 != aSN1EncodableVector.size(); i2++) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.get(i2)).getEncoded(ASN1Encoding.DER));
            } catch (IOException e) {
                throw new ASN1ParsingException(outline.m268c("malformed object: ", e), e);
            }
        }
        this.octets = byteArrayOutputStream.toByteArray();
    }
}
