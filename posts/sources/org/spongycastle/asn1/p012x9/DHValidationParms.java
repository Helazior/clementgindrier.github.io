package org.spongycastle.asn1.p012x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* renamed from: org.spongycastle.asn1.x9.DHValidationParms */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHValidationParms extends ASN1Object {
    private ASN1Integer pgenCounter;
    private DERBitString seed;

    public DHValidationParms(DERBitString dERBitString, ASN1Integer aSN1Integer) {
        if (dERBitString == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        }
        if (aSN1Integer != null) {
            this.seed = dERBitString;
            this.pgenCounter = aSN1Integer;
            return;
        }
        throw new IllegalArgumentException("'pgenCounter' cannot be null");
    }

    public static DHValidationParms getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Integer getPgenCounter() {
        return this.pgenCounter;
    }

    public DERBitString getSeed() {
        return this.seed;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.seed);
        aSN1EncodableVector.add(this.pgenCounter);
        return new DERSequence(aSN1EncodableVector);
    }

    public static DHValidationParms getInstance(Object obj) {
        if (obj != null && !(obj instanceof DHDomainParameters)) {
            if (obj instanceof ASN1Sequence) {
                return new DHValidationParms((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid DHValidationParms: ")));
        }
        return (DHValidationParms) obj;
    }

    private DHValidationParms(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.seed = DERBitString.getInstance(aSN1Sequence.getObjectAt(0));
            this.pgenCounter = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }
}
