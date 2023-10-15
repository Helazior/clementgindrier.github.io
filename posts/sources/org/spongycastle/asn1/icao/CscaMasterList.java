package org.spongycastle.asn1.icao;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.x509.X509CertificateStructure;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CscaMasterList extends ASN1Object {
    private X509CertificateStructure[] certList;
    private ASN1Integer version;

    private CscaMasterList(ASN1Sequence aSN1Sequence) {
        int i = 0;
        this.version = new ASN1Integer(0);
        if (aSN1Sequence != null && aSN1Sequence.size() != 0) {
            if (aSN1Sequence.size() == 2) {
                this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
                ASN1Set aSN1Set = ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
                this.certList = new X509CertificateStructure[aSN1Set.size()];
                while (true) {
                    X509CertificateStructure[] x509CertificateStructureArr = this.certList;
                    if (i >= x509CertificateStructureArr.length) {
                        return;
                    }
                    x509CertificateStructureArr[i] = X509CertificateStructure.getInstance(aSN1Set.getObjectAt(i));
                    i++;
                }
            } else {
                throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Incorrect sequence size: ")));
            }
        } else {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
    }

    private X509CertificateStructure[] copyCertList(X509CertificateStructure[] x509CertificateStructureArr) {
        int length = x509CertificateStructureArr.length;
        X509CertificateStructure[] x509CertificateStructureArr2 = new X509CertificateStructure[length];
        for (int i = 0; i != length; i++) {
            x509CertificateStructureArr2[i] = x509CertificateStructureArr[i];
        }
        return x509CertificateStructureArr2;
    }

    public static CscaMasterList getInstance(Object obj) {
        if (obj instanceof CscaMasterList) {
            return (CscaMasterList) obj;
        }
        if (obj != null) {
            return new CscaMasterList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X509CertificateStructure[] getCertStructs() {
        return copyCertList(this.certList);
    }

    public int getVersion() {
        return this.version.getValue().intValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            X509CertificateStructure[] x509CertificateStructureArr = this.certList;
            if (i < x509CertificateStructureArr.length) {
                aSN1EncodableVector2.add(x509CertificateStructureArr[i]);
                i++;
            } else {
                aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
                return new DERSequence(aSN1EncodableVector);
            }
        }
    }

    public CscaMasterList(X509CertificateStructure[] x509CertificateStructureArr) {
        this.version = new ASN1Integer(0);
        this.certList = copyCertList(x509CertificateStructureArr);
    }
}
