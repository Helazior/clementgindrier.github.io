package org.spongycastle.asn1.esf;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTCTime;
import org.spongycastle.asn1.x500.X500Name;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CrlIdentifier extends ASN1Object {
    private DERUTCTime crlIssuedTime;
    private X500Name crlIssuer;
    private ASN1Integer crlNumber;

    private CrlIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 2 && aSN1Sequence.size() <= 3) {
            this.crlIssuer = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
            this.crlIssuedTime = DERUTCTime.getInstance(aSN1Sequence.getObjectAt(1));
            if (aSN1Sequence.size() > 2) {
                this.crlNumber = DERInteger.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static CrlIdentifier getInstance(Object obj) {
        if (obj instanceof CrlIdentifier) {
            return (CrlIdentifier) obj;
        }
        if (obj != null) {
            return new CrlIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTCTime getCrlIssuedTime() {
        return this.crlIssuedTime;
    }

    public X500Name getCrlIssuer() {
        return this.crlIssuer;
    }

    public BigInteger getCrlNumber() {
        ASN1Integer aSN1Integer = this.crlNumber;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.crlIssuer.toASN1Primitive());
        aSN1EncodableVector.add(this.crlIssuedTime);
        ASN1Integer aSN1Integer = this.crlNumber;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CrlIdentifier(X500Name x500Name, DERUTCTime dERUTCTime) {
        this(x500Name, dERUTCTime, null);
    }

    public CrlIdentifier(X500Name x500Name, DERUTCTime dERUTCTime, BigInteger bigInteger) {
        this.crlIssuer = x500Name;
        this.crlIssuedTime = dERUTCTime;
        if (bigInteger != null) {
            this.crlNumber = new ASN1Integer(bigInteger);
        }
    }
}
