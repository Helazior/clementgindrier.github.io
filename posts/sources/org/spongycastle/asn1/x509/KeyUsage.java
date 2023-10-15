package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.DERBitString;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KeyUsage extends DERBitString {
    public static final int cRLSign = 2;
    public static final int dataEncipherment = 16;
    public static final int decipherOnly = 32768;
    public static final int digitalSignature = 128;
    public static final int encipherOnly = 1;
    public static final int keyAgreement = 8;
    public static final int keyCertSign = 4;
    public static final int keyEncipherment = 32;
    public static final int nonRepudiation = 64;

    public KeyUsage(int i) {
        super(DERBitString.getBytes(i), DERBitString.getPadBits(i));
    }

    public static DERBitString getInstance(Object obj) {
        if (obj instanceof KeyUsage) {
            return (KeyUsage) obj;
        }
        if (obj instanceof X509Extension) {
            return new KeyUsage(DERBitString.getInstance(X509Extension.convertValueToObject((X509Extension) obj)));
        }
        return new KeyUsage(DERBitString.getInstance(obj));
    }

    @Override // org.spongycastle.asn1.DERBitString
    public String toString() {
        if (this.data.length == 1) {
            StringBuilder m253r = outline.m253r("KeyUsage: 0x");
            m253r.append(Integer.toHexString(this.data[0] & 255));
            return m253r.toString();
        }
        StringBuilder m253r2 = outline.m253r("KeyUsage: 0x");
        byte[] bArr = this.data;
        m253r2.append(Integer.toHexString((bArr[0] & 255) | ((bArr[1] & 255) << 8)));
        return m253r2.toString();
    }

    public KeyUsage(DERBitString dERBitString) {
        super(dERBitString.getBytes(), dERBitString.getPadBits());
    }
}
