package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    private KeyDerivationFunc func;
    private EncryptionScheme scheme;

    public PBES2Parameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(((ASN1Encodable) objects.nextElement()).toASN1Primitive());
        ASN1Encodable objectAt = aSN1Sequence2.getObjectAt(0);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_PBKDF2;
        if (objectAt.equals(aSN1ObjectIdentifier)) {
            this.func = new KeyDerivationFunc(aSN1ObjectIdentifier, PBKDF2Params.getInstance(aSN1Sequence2.getObjectAt(1)));
        } else {
            this.func = new KeyDerivationFunc(aSN1Sequence2);
        }
        this.scheme = (EncryptionScheme) EncryptionScheme.getInstance(objects.nextElement());
    }

    public static PBES2Parameters getInstance(Object obj) {
        if (obj != null && !(obj instanceof PBES2Parameters)) {
            if (obj instanceof ASN1Sequence) {
                return new PBES2Parameters((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("unknown object in factory: ")));
        }
        return (PBES2Parameters) obj;
    }

    public EncryptionScheme getEncryptionScheme() {
        return this.scheme;
    }

    public KeyDerivationFunc getKeyDerivationFunc() {
        return this.func;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.func);
        aSN1EncodableVector.add(this.scheme);
        return new DERSequence(aSN1EncodableVector);
    }
}
