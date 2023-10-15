package org.spongycastle.asn1.p012x9;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* renamed from: org.spongycastle.asn1.x9.DHDomainParameters */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHDomainParameters extends ASN1Object {

    /* renamed from: g */
    private ASN1Integer f5709g;

    /* renamed from: j */
    private ASN1Integer f5710j;

    /* renamed from: p */
    private ASN1Integer f5711p;

    /* renamed from: q */
    private ASN1Integer f5712q;
    private DHValidationParms validationParms;

    public DHDomainParameters(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3, ASN1Integer aSN1Integer4, DHValidationParms dHValidationParms) {
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (aSN1Integer2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (aSN1Integer3 != null) {
            this.f5711p = aSN1Integer;
            this.f5709g = aSN1Integer2;
            this.f5712q = aSN1Integer3;
            this.f5710j = aSN1Integer4;
            this.validationParms = dHValidationParms;
            return;
        }
        throw new IllegalArgumentException("'q' cannot be null");
    }

    public static DHDomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private static ASN1Encodable getNext(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (ASN1Encodable) enumeration.nextElement();
        }
        return null;
    }

    public ASN1Integer getG() {
        return this.f5709g;
    }

    public ASN1Integer getJ() {
        return this.f5710j;
    }

    public ASN1Integer getP() {
        return this.f5711p;
    }

    public ASN1Integer getQ() {
        return this.f5712q;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5711p);
        aSN1EncodableVector.add(this.f5709g);
        aSN1EncodableVector.add(this.f5712q);
        ASN1Integer aSN1Integer = this.f5710j;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        DHValidationParms dHValidationParms = this.validationParms;
        if (dHValidationParms != null) {
            aSN1EncodableVector.add(dHValidationParms);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj != null && !(obj instanceof DHDomainParameters)) {
            if (obj instanceof ASN1Sequence) {
                return new DHDomainParameters((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("Invalid DHDomainParameters: ")));
        }
        return (DHDomainParameters) obj;
    }

    private DHDomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 3 && aSN1Sequence.size() <= 5) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f5711p = DERInteger.getInstance(objects.nextElement());
            this.f5709g = DERInteger.getInstance(objects.nextElement());
            this.f5712q = DERInteger.getInstance(objects.nextElement());
            ASN1Encodable next = getNext(objects);
            if (next != null && (next instanceof ASN1Integer)) {
                this.f5710j = DERInteger.getInstance(next);
                next = getNext(objects);
            }
            if (next != null) {
                this.validationParms = DHValidationParms.getInstance(next.toASN1Primitive());
                return;
            }
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }
}
