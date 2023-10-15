package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.crypto.digests.SHA1Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SubjectKeyIdentifier extends ASN1Object {
    private byte[] keyidentifier;

    public SubjectKeyIdentifier(byte[] bArr) {
        this.keyidentifier = bArr;
    }

    public static SubjectKeyIdentifier createSHA1KeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new SubjectKeyIdentifier(subjectPublicKeyInfo);
    }

    public static SubjectKeyIdentifier createTruncatedSHA1KeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        byte[] digest = getDigest(subjectPublicKeyInfo);
        byte[] bArr = new byte[8];
        System.arraycopy(digest, digest.length - 8, bArr, 0, 8);
        bArr[0] = (byte) (bArr[0] & 15);
        bArr[0] = (byte) (bArr[0] | 64);
        return new SubjectKeyIdentifier(bArr);
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        return bArr;
    }

    public static SubjectKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1OctetString.getInstance(aSN1TaggedObject, z));
    }

    public byte[] getKeyIdentifier() {
        return this.keyidentifier;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.keyidentifier);
    }

    public static SubjectKeyIdentifier getInstance(Object obj) {
        if (obj instanceof SubjectKeyIdentifier) {
            return (SubjectKeyIdentifier) obj;
        }
        if (obj != null) {
            return new SubjectKeyIdentifier(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public SubjectKeyIdentifier(ASN1OctetString aSN1OctetString) {
        this.keyidentifier = aSN1OctetString.getOctets();
    }

    public SubjectKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.keyidentifier = getDigest(subjectPublicKeyInfo);
    }
}
