package org.spongycastle.ocsp;

import java.security.MessageDigest;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.ocsp.ResponderID;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RespID {

    /* renamed from: id */
    public ResponderID f6169id;

    public RespID(ResponderID responderID) {
        this.f6169id = responderID;
    }

    public boolean equals(Object obj) {
        if (obj instanceof RespID) {
            return this.f6169id.equals(((RespID) obj).f6169id);
        }
        return false;
    }

    public int hashCode() {
        return this.f6169id.hashCode();
    }

    public ResponderID toASN1Object() {
        return this.f6169id;
    }

    public RespID(X500Principal x500Principal) {
        this.f6169id = new ResponderID(X500Name.getInstance(x500Principal.getEncoded()));
    }

    public RespID(PublicKey publicKey) {
        try {
            MessageDigest createDigestInstance = OCSPUtil.createDigestInstance("SHA1", null);
            createDigestInstance.update(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getPublicKeyData().getBytes());
            this.f6169id = new ResponderID(new DEROctetString(createDigestInstance.digest()));
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }
}
