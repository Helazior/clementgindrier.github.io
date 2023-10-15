package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBoolean;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BasicConstraints extends ASN1Object {

    /* renamed from: cA */
    public DERBoolean f5693cA;
    public ASN1Integer pathLenConstraint;

    private BasicConstraints(ASN1Sequence aSN1Sequence) {
        this.f5693cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (aSN1Sequence.size() == 0) {
            this.f5693cA = null;
            this.pathLenConstraint = null;
            return;
        }
        if (aSN1Sequence.getObjectAt(0) instanceof DERBoolean) {
            this.f5693cA = DERBoolean.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.f5693cA = null;
            this.pathLenConstraint = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() > 1) {
            if (this.f5693cA != null) {
                this.pathLenConstraint = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
                return;
            }
            throw new IllegalArgumentException("wrong sequence in constructor");
        }
    }

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getPathLenConstraint() {
        ASN1Integer aSN1Integer = this.pathLenConstraint;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public boolean isCA() {
        DERBoolean dERBoolean = this.f5693cA;
        return dERBoolean != null && dERBoolean.isTrue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERBoolean dERBoolean = this.f5693cA;
        if (dERBoolean != null) {
            aSN1EncodableVector.add(dERBoolean);
        }
        ASN1Integer aSN1Integer = this.pathLenConstraint;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        if (this.pathLenConstraint == null) {
            if (this.f5693cA == null) {
                return "BasicConstraints: isCa(false)";
            }
            StringBuilder m253r = outline.m253r("BasicConstraints: isCa(");
            m253r.append(isCA());
            m253r.append(")");
            return m253r.toString();
        }
        StringBuilder m253r2 = outline.m253r("BasicConstraints: isCa(");
        m253r2.append(isCA());
        m253r2.append("), pathLenConstraint = ");
        m253r2.append(this.pathLenConstraint.getValue());
        return m253r2.toString();
    }

    public static BasicConstraints getInstance(Object obj) {
        if (obj instanceof BasicConstraints) {
            return (BasicConstraints) obj;
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        if (obj != null) {
            return new BasicConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BasicConstraints(boolean z) {
        this.f5693cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        if (z) {
            this.f5693cA = new DERBoolean(true);
        } else {
            this.f5693cA = null;
        }
        this.pathLenConstraint = null;
    }

    public BasicConstraints(int i) {
        this.f5693cA = new DERBoolean(false);
        this.pathLenConstraint = null;
        this.f5693cA = new DERBoolean(true);
        this.pathLenConstraint = new ASN1Integer(i);
    }
}
