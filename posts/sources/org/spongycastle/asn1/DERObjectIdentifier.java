package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DERObjectIdentifier extends ASN1Primitive {
    private static ASN1ObjectIdentifier[][] cache = new ASN1ObjectIdentifier[255];
    private byte[] body;
    public String identifier;

    public DERObjectIdentifier(byte[] bArr) {
        long j;
        StringBuffer stringBuffer = new StringBuffer();
        BigInteger bigInteger = null;
        long j2 = 0;
        boolean z = true;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (j2 < 36028797018963968L) {
                j2 = (j2 * 128) + (i2 & 127);
                if ((i2 & 128) == 0) {
                    if (z) {
                        int i3 = ((int) j2) / 40;
                        if (i3 != 0) {
                            if (i3 != 1) {
                                stringBuffer.append('2');
                                j = 80;
                            } else {
                                stringBuffer.append('1');
                                j = 40;
                            }
                            j2 -= j;
                        } else {
                            stringBuffer.append('0');
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j2 = 0;
                }
            } else {
                bigInteger = (bigInteger == null ? BigInteger.valueOf(j2) : bigInteger).shiftLeft(7).or(BigInteger.valueOf(i2 & 127));
                if ((i2 & 128) == 0) {
                    stringBuffer.append('.');
                    stringBuffer.append(bigInteger);
                    bigInteger = null;
                    j2 = 0;
                }
            }
        }
        this.identifier = stringBuffer.toString();
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        writeField(byteArrayOutputStream, Integer.parseInt(oIDTokenizer.nextToken()) + (Integer.parseInt(oIDTokenizer.nextToken()) * 40));
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken = oIDTokenizer.nextToken();
            if (nextToken.length() < 18) {
                writeField(byteArrayOutputStream, Long.parseLong(nextToken));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(nextToken));
            }
        }
    }

    public static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        if (bArr.length < 3) {
            return new ASN1ObjectIdentifier(bArr);
        }
        int i = bArr[bArr.length - 2] & 255;
        ASN1ObjectIdentifier[][] aSN1ObjectIdentifierArr = cache;
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr2 = aSN1ObjectIdentifierArr[i];
        if (aSN1ObjectIdentifierArr2 == null) {
            aSN1ObjectIdentifierArr2 = new ASN1ObjectIdentifier[255];
            aSN1ObjectIdentifierArr[i] = aSN1ObjectIdentifierArr2;
        }
        int i2 = bArr[bArr.length - 1] & 255;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = aSN1ObjectIdentifierArr2[i2];
        if (aSN1ObjectIdentifier == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(bArr);
            aSN1ObjectIdentifierArr2[i2] = aSN1ObjectIdentifier2;
            return aSN1ObjectIdentifier2;
        } else if (Arrays.areEqual(bArr, aSN1ObjectIdentifier.getBody())) {
            return aSN1ObjectIdentifier;
        } else {
            int i3 = (i + 1) % 256;
            ASN1ObjectIdentifier[][] aSN1ObjectIdentifierArr3 = cache;
            ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr4 = aSN1ObjectIdentifierArr3[i3];
            if (aSN1ObjectIdentifierArr4 == null) {
                aSN1ObjectIdentifierArr4 = new ASN1ObjectIdentifier[255];
                aSN1ObjectIdentifierArr3[i3] = aSN1ObjectIdentifierArr4;
            }
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = aSN1ObjectIdentifierArr4[i2];
            if (aSN1ObjectIdentifier3 == null) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(bArr);
                aSN1ObjectIdentifierArr4[i2] = aSN1ObjectIdentifier4;
                return aSN1ObjectIdentifier4;
            } else if (Arrays.areEqual(bArr, aSN1ObjectIdentifier3.getBody())) {
                return aSN1ObjectIdentifier3;
            } else {
                int i4 = (i2 + 1) % 256;
                ASN1ObjectIdentifier aSN1ObjectIdentifier5 = aSN1ObjectIdentifierArr4[i4];
                if (aSN1ObjectIdentifier5 != null) {
                    return Arrays.areEqual(bArr, aSN1ObjectIdentifier5.getBody()) ? aSN1ObjectIdentifier5 : new ASN1ObjectIdentifier(bArr);
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(bArr);
                aSN1ObjectIdentifierArr4[i4] = aSN1ObjectIdentifier6;
                return aSN1ObjectIdentifier6;
            }
        }
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1ObjectIdentifier)) {
            if (obj instanceof DERObjectIdentifier) {
                return new ASN1ObjectIdentifier(((DERObjectIdentifier) obj).getId());
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (ASN1ObjectIdentifier) obj;
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        boolean z = false;
        for (int length = str.length() - 1; length >= 2; length--) {
            char charAt2 = str.charAt(length);
            if ('0' <= charAt2 && charAt2 <= '9') {
                z = true;
            } else if (charAt2 != '.' || !z) {
                return false;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERObjectIdentifier) {
            return this.identifier.equals(((DERObjectIdentifier) aSN1Primitive).identifier);
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        byte[] body = getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(body.length);
        aSN1OutputStream.write(body);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getId();
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof DERObjectIdentifier)) {
            return fromOctetString(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
        }
        return getInstance(object);
    }

    public DERObjectIdentifier(String str) {
        if (isValidIdentifier(str)) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException(outline.m265f("string ", str, " not an OID"));
    }
}
