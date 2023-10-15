package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEREnumerated;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ObjectDigestInfo extends ASN1Object {
    public static final int otherObjectDigest = 2;
    public static final int publicKey = 0;
    public static final int publicKeyCert = 1;
    public AlgorithmIdentifier digestAlgorithm;
    public ASN1Enumerated digestedObjectType;
    public DERBitString objectDigest;
    public ASN1ObjectIdentifier otherObjectTypeID;

    public ObjectDigestInfo(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.digestedObjectType = new ASN1Enumerated(i);
        if (i == 2) {
            this.otherObjectTypeID = aSN1ObjectIdentifier;
        }
        this.digestAlgorithm = algorithmIdentifier;
        this.objectDigest = new DERBitString(bArr);
    }

    public static ObjectDigestInfo getInstance(Object obj) {
        if (obj instanceof ObjectDigestInfo) {
            return (ObjectDigestInfo) obj;
        }
        if (obj != null) {
            return new ObjectDigestInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public DEREnumerated getDigestedObjectType() {
        return this.digestedObjectType;
    }

    public DERBitString getObjectDigest() {
        return this.objectDigest;
    }

    public ASN1ObjectIdentifier getOtherObjectTypeID() {
        return this.otherObjectTypeID;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.digestedObjectType);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.otherObjectTypeID;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        aSN1EncodableVector.add(this.digestAlgorithm);
        aSN1EncodableVector.add(this.objectDigest);
        return new DERSequence(aSN1EncodableVector);
    }

    public static ObjectDigestInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private ObjectDigestInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 4 && aSN1Sequence.size() >= 3) {
            int i = 0;
            this.digestedObjectType = DEREnumerated.getInstance(aSN1Sequence.getObjectAt(0));
            if (aSN1Sequence.size() == 4) {
                this.otherObjectTypeID = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
                i = 1;
            }
            this.digestAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 1));
            this.objectDigest = DERBitString.getInstance(aSN1Sequence.getObjectAt(i + 2));
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }
}
