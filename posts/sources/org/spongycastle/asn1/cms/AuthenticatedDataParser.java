package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1SetParser;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1TaggedObjectParser;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AuthenticatedDataParser {
    private ASN1Encodable nextObject;
    private boolean originatorInfoCalled;
    private ASN1SequenceParser seq;
    private ASN1Integer version;

    public AuthenticatedDataParser(ASN1SequenceParser aSN1SequenceParser) {
        this.seq = aSN1SequenceParser;
        this.version = DERInteger.getInstance(aSN1SequenceParser.readObject());
    }

    public ASN1SetParser getAuthAttrs() {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        if (aSN1Encodable instanceof ASN1TaggedObjectParser) {
            this.nextObject = null;
            return (ASN1SetParser) ((ASN1TaggedObjectParser) aSN1Encodable).getObjectParser(17, false);
        }
        return null;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        if (aSN1Encodable instanceof ASN1TaggedObjectParser) {
            AlgorithmIdentifier algorithmIdentifier = AlgorithmIdentifier.getInstance((ASN1TaggedObject) aSN1Encodable.toASN1Primitive(), false);
            this.nextObject = null;
            return algorithmIdentifier;
        }
        return null;
    }

    public ContentInfoParser getEnapsulatedContentInfo() {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        if (aSN1Encodable != null) {
            this.nextObject = null;
            return new ContentInfoParser((ASN1SequenceParser) aSN1Encodable);
        }
        return null;
    }

    public ASN1OctetString getMac() {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        this.nextObject = null;
        return ASN1OctetString.getInstance(aSN1Encodable.toASN1Primitive());
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        if (aSN1Encodable != null) {
            this.nextObject = null;
            return AlgorithmIdentifier.getInstance(((ASN1SequenceParser) aSN1Encodable).toASN1Primitive());
        }
        return null;
    }

    public OriginatorInfo getOriginatorInfo() {
        this.originatorInfoCalled = true;
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        if ((aSN1Encodable instanceof ASN1TaggedObjectParser) && ((ASN1TaggedObjectParser) aSN1Encodable).getTagNo() == 0) {
            this.nextObject = null;
            return OriginatorInfo.getInstance(((ASN1SequenceParser) ((ASN1TaggedObjectParser) this.nextObject).getObjectParser(16, false)).toASN1Primitive());
        }
        return null;
    }

    public ASN1SetParser getRecipientInfos() {
        if (!this.originatorInfoCalled) {
            getOriginatorInfo();
        }
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1SetParser aSN1SetParser = (ASN1SetParser) this.nextObject;
        this.nextObject = null;
        return aSN1SetParser;
    }

    public ASN1SetParser getUnauthAttrs() {
        if (this.nextObject == null) {
            this.nextObject = this.seq.readObject();
        }
        ASN1Encodable aSN1Encodable = this.nextObject;
        if (aSN1Encodable != null) {
            this.nextObject = null;
            return (ASN1SetParser) ((ASN1TaggedObjectParser) aSN1Encodable).getObjectParser(17, false);
        }
        return null;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }
}
