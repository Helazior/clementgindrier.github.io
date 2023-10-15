package org.spongycastle.asn1.p012x9;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERInteger;

/* renamed from: org.spongycastle.asn1.x9.DHPublicKey */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHPublicKey extends ASN1Object {

    /* renamed from: y */
    private ASN1Integer f5713y;

    public DHPublicKey(ASN1Integer aSN1Integer) {
        if (aSN1Integer != null) {
            this.f5713y = aSN1Integer;
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    public static DHPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(DERInteger.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Integer getY() {
        return this.f5713y;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f5713y;
    }

    public static DHPublicKey getInstance(Object obj) {
        if (obj != null && !(obj instanceof DHPublicKey)) {
            if (obj instanceof ASN1Integer) {
                return new DHPublicKey((ASN1Integer) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid DHPublicKey: ")));
        }
        return (DHPublicKey) obj;
    }
}
