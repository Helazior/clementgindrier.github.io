package org.spongycastle.asn1;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    public ASN1ObjectIdentifier(String str) {
        super(str);
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(getId() + "." + str);
    }

    /* renamed from: on */
    public boolean m528on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String id = getId();
        String id2 = aSN1ObjectIdentifier.getId();
        return id.length() > id2.length() && id.charAt(id2.length()) == '.' && id.startsWith(id2);
    }

    public ASN1ObjectIdentifier(byte[] bArr) {
        super(bArr);
    }
}
