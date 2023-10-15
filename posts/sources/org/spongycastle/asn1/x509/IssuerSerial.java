package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IssuerSerial extends ASN1Object {
    public GeneralNames issuer;
    public DERBitString issuerUID;
    public ASN1Integer serial;

    public IssuerSerial(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 2 && aSN1Sequence.size() != 3) {
            throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
        }
        this.issuer = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
        this.serial = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() == 3) {
            this.issuerUID = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static IssuerSerial getInstance(Object obj) {
        if (obj != null && !(obj instanceof IssuerSerial)) {
            if (obj instanceof ASN1Sequence) {
                return new IssuerSerial((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (IssuerSerial) obj;
    }

    public GeneralNames getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUID() {
        return this.issuerUID;
    }

    public ASN1Integer getSerial() {
        return this.serial;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.serial);
        DERBitString dERBitString = this.issuerUID;
        if (dERBitString != null) {
            aSN1EncodableVector.add(dERBitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static IssuerSerial getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public IssuerSerial(GeneralNames generalNames, ASN1Integer aSN1Integer) {
        this.issuer = generalNames;
        this.serial = aSN1Integer;
    }
}
