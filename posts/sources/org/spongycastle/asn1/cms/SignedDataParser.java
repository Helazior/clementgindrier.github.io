package org.spongycastle.asn1.cms;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1SetParser;
import org.spongycastle.asn1.ASN1TaggedObjectParser;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SignedDataParser {
    private boolean _certsCalled;
    private boolean _crlsCalled;
    private Object _nextObject;
    private ASN1SequenceParser _seq;
    private ASN1Integer _version;

    private SignedDataParser(ASN1SequenceParser aSN1SequenceParser) {
        this._seq = aSN1SequenceParser;
        this._version = (ASN1Integer) aSN1SequenceParser.readObject();
    }

    public static SignedDataParser getInstance(Object obj) {
        if (obj instanceof ASN1Sequence) {
            return new SignedDataParser(((ASN1Sequence) obj).parser());
        }
        if (obj instanceof ASN1SequenceParser) {
            return new SignedDataParser((ASN1SequenceParser) obj);
        }
        throw new IOException(outline.m274G(obj, outline.m253r("unknown object encountered: ")));
    }

    public ASN1SetParser getCertificates() {
        this._certsCalled = true;
        ASN1Encodable readObject = this._seq.readObject();
        this._nextObject = readObject;
        if ((readObject instanceof ASN1TaggedObjectParser) && ((ASN1TaggedObjectParser) readObject).getTagNo() == 0) {
            ASN1SetParser aSN1SetParser = (ASN1SetParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(17, false);
            this._nextObject = null;
            return aSN1SetParser;
        }
        return null;
    }

    public ASN1SetParser getCrls() {
        if (this._certsCalled) {
            this._crlsCalled = true;
            if (this._nextObject == null) {
                this._nextObject = this._seq.readObject();
            }
            Object obj = this._nextObject;
            if ((obj instanceof ASN1TaggedObjectParser) && ((ASN1TaggedObjectParser) obj).getTagNo() == 1) {
                ASN1SetParser aSN1SetParser = (ASN1SetParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(17, false);
                this._nextObject = null;
                return aSN1SetParser;
            }
            return null;
        }
        throw new IOException("getCerts() has not been called.");
    }

    public ASN1SetParser getDigestAlgorithms() {
        ASN1Encodable readObject = this._seq.readObject();
        if (readObject instanceof ASN1Set) {
            return ((ASN1Set) readObject).parser();
        }
        return (ASN1SetParser) readObject;
    }

    public ContentInfoParser getEncapContentInfo() {
        return new ContentInfoParser((ASN1SequenceParser) this._seq.readObject());
    }

    public ASN1SetParser getSignerInfos() {
        if (this._certsCalled && this._crlsCalled) {
            if (this._nextObject == null) {
                this._nextObject = this._seq.readObject();
            }
            return (ASN1SetParser) this._nextObject;
        }
        throw new IOException("getCerts() and/or getCrls() has not been called.");
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}
