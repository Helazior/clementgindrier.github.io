package org.spongycastle.asn1.x509.sigi;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.DirectoryString;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PersonalData extends ASN1Object {
    private DERGeneralizedTime dateOfBirth;
    private String gender;
    private BigInteger nameDistinguisher;
    private NameOrPseudonym nameOrPseudonym;
    private DirectoryString placeOfBirth;
    private DirectoryString postalAddress;

    private PersonalData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.nameOrPseudonym = NameOrPseudonym.getInstance(objects.nextElement());
            while (objects.hasMoreElements()) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.nameDistinguisher = DERInteger.getInstance(aSN1TaggedObject, false).getValue();
                } else if (tagNo == 1) {
                    this.dateOfBirth = DERGeneralizedTime.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 2) {
                    this.placeOfBirth = DirectoryString.getInstance(aSN1TaggedObject, true);
                } else if (tagNo == 3) {
                    this.gender = DERPrintableString.getInstance(aSN1TaggedObject, false).getString();
                } else if (tagNo == 4) {
                    this.postalAddress = DirectoryString.getInstance(aSN1TaggedObject, true);
                } else {
                    throw new IllegalArgumentException(outline.m257n(aSN1TaggedObject, outline.m253r("Bad tag number: ")));
                }
            }
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }

    public static PersonalData getInstance(Object obj) {
        if (obj != null && !(obj instanceof PersonalData)) {
            if (obj instanceof ASN1Sequence) {
                return new PersonalData((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (PersonalData) obj;
    }

    public DERGeneralizedTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public BigInteger getNameDistinguisher() {
        return this.nameDistinguisher;
    }

    public NameOrPseudonym getNameOrPseudonym() {
        return this.nameOrPseudonym;
    }

    public DirectoryString getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public DirectoryString getPostalAddress() {
        return this.postalAddress;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.nameOrPseudonym);
        BigInteger bigInteger = this.nameDistinguisher;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, new ASN1Integer(bigInteger)));
        }
        DERGeneralizedTime dERGeneralizedTime = this.dateOfBirth;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERGeneralizedTime));
        }
        DirectoryString directoryString = this.placeOfBirth;
        if (directoryString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, directoryString));
        }
        String str = this.gender;
        if (str != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, new DERPrintableString(str, true)));
        }
        DirectoryString directoryString2 = this.postalAddress;
        if (directoryString2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 4, directoryString2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PersonalData(NameOrPseudonym nameOrPseudonym, BigInteger bigInteger, DERGeneralizedTime dERGeneralizedTime, DirectoryString directoryString, String str, DirectoryString directoryString2) {
        this.nameOrPseudonym = nameOrPseudonym;
        this.dateOfBirth = dERGeneralizedTime;
        this.gender = str;
        this.nameDistinguisher = bigInteger;
        this.postalAddress = directoryString2;
        this.placeOfBirth = directoryString;
    }
}
