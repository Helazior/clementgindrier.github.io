package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBoolean;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DeclarationOfMajority extends ASN1Object implements ASN1Choice {
    public static final int dateOfBirth = 2;
    public static final int fullAgeAtCountry = 1;
    public static final int notYoungerThan = 0;
    private ASN1TaggedObject declaration;

    public DeclarationOfMajority(int i) {
        this.declaration = new DERTaggedObject(false, 0, new ASN1Integer(i));
    }

    public static DeclarationOfMajority getInstance(Object obj) {
        if (obj != null && !(obj instanceof DeclarationOfMajority)) {
            if (obj instanceof ASN1TaggedObject) {
                return new DeclarationOfMajority((ASN1TaggedObject) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (DeclarationOfMajority) obj;
    }

    public ASN1Sequence fullAgeAtCountry() {
        if (this.declaration.getTagNo() != 1) {
            return null;
        }
        return ASN1Sequence.getInstance(this.declaration, false);
    }

    public DERGeneralizedTime getDateOfBirth() {
        if (this.declaration.getTagNo() != 2) {
            return null;
        }
        return DERGeneralizedTime.getInstance(this.declaration, false);
    }

    public int getType() {
        return this.declaration.getTagNo();
    }

    public int notYoungerThan() {
        if (this.declaration.getTagNo() != 0) {
            return -1;
        }
        return DERInteger.getInstance(this.declaration, false).getValue().intValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.declaration;
    }

    public DeclarationOfMajority(boolean z, String str) {
        if (str.length() > 2) {
            throw new IllegalArgumentException("country can only be 2 characters");
        }
        if (z) {
            this.declaration = new DERTaggedObject(false, 1, new DERSequence(new DERPrintableString(str, true)));
            return;
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(DERBoolean.FALSE);
        aSN1EncodableVector.add(new DERPrintableString(str, true));
        this.declaration = new DERTaggedObject(false, 1, new DERSequence(aSN1EncodableVector));
    }

    public DeclarationOfMajority(DERGeneralizedTime dERGeneralizedTime) {
        this.declaration = new DERTaggedObject(false, 2, dERGeneralizedTime);
    }

    private DeclarationOfMajority(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() <= 2) {
            this.declaration = aSN1TaggedObject;
            return;
        }
        throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("Bad tag number: ")));
    }
}
