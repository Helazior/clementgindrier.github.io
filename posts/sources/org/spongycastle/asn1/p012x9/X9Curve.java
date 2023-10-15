package org.spongycastle.asn1.p012x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.p017ec.ECCurve;

/* renamed from: org.spongycastle.asn1.x9.X9Curve */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    private ECCurve curve;
    private ASN1ObjectIdentifier fieldIdentifier;
    private byte[] seed;

    public X9Curve(ECCurve eCCurve) {
        this.fieldIdentifier = null;
        this.curve = eCCurve;
        this.seed = null;
        setFieldIdentifier();
    }

    private void setFieldIdentifier() {
        ECCurve eCCurve = this.curve;
        if (eCCurve instanceof ECCurve.C2160Fp) {
            this.fieldIdentifier = X9ObjectIdentifiers.prime_field;
        } else if (eCCurve instanceof ECCurve.F2m) {
            this.fieldIdentifier = X9ObjectIdentifiers.characteristic_two_field;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.fieldIdentifier.equals(X9ObjectIdentifiers.prime_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getB()).toASN1Primitive());
        } else if (this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getB()).toASN1Primitive());
        }
        byte[] bArr = this.seed;
        if (bArr != null) {
            aSN1EncodableVector.add(new DERBitString(bArr));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.fieldIdentifier = null;
        this.curve = eCCurve;
        this.seed = bArr;
        setFieldIdentifier();
    }

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int intValue;
        int i;
        int i2;
        this.fieldIdentifier = null;
        ASN1ObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.fieldIdentifier = identifier;
        if (identifier.equals(X9ObjectIdentifiers.prime_field)) {
            BigInteger value = ((ASN1Integer) x9FieldID.getParameters()).getValue();
            this.curve = new ECCurve.C2160Fp(value, new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        } else if (this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(x9FieldID.getParameters());
            int intValue2 = ((ASN1Integer) aSN1Sequence2.getObjectAt(0)).getValue().intValue();
            if (((ASN1ObjectIdentifier) aSN1Sequence2.getObjectAt(1)).equals(X9ObjectIdentifiers.tpBasis)) {
                i = ((ASN1Integer) aSN1Sequence2.getObjectAt(2)).getValue().intValue();
                i2 = 0;
                intValue = 0;
            } else {
                DERSequence dERSequence = (DERSequence) aSN1Sequence2.getObjectAt(2);
                int intValue3 = ((ASN1Integer) dERSequence.getObjectAt(0)).getValue().intValue();
                int intValue4 = ((ASN1Integer) dERSequence.getObjectAt(1)).getValue().intValue();
                intValue = ((ASN1Integer) dERSequence.getObjectAt(2)).getValue().intValue();
                i = intValue3;
                i2 = intValue4;
            }
            int i3 = i;
            int i4 = i2;
            int i5 = intValue;
            this.curve = new ECCurve.F2m(intValue2, i3, i4, i5, new X9FieldElement(intValue2, i3, i4, i5, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(intValue2, i3, i4, i5, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        }
        if (aSN1Sequence.size() == 3) {
            this.seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }
}
