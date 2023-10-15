package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.DERBitString;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NetscapeCertType extends DERBitString {
    public static final int objectSigning = 16;
    public static final int objectSigningCA = 1;
    public static final int reserved = 8;
    public static final int smime = 32;
    public static final int smimeCA = 2;
    public static final int sslCA = 4;
    public static final int sslClient = 128;
    public static final int sslServer = 64;

    public NetscapeCertType(int i) {
        super(DERBitString.getBytes(i), DERBitString.getPadBits(i));
    }

    @Override // org.spongycastle.asn1.DERBitString
    public String toString() {
        StringBuilder m253r = outline.m253r("NetscapeCertType: 0x");
        m253r.append(Integer.toHexString(this.data[0] & 255));
        return m253r.toString();
    }

    public NetscapeCertType(DERBitString dERBitString) {
        super(dERBitString.getBytes(), dERBitString.getPadBits());
    }
}
