package org.spongycastle.asn1.smime;

import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.Attribute;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SMIMECapabilitiesAttribute extends Attribute {
    public SMIMECapabilitiesAttribute(SMIMECapabilityVector sMIMECapabilityVector) {
        super(SMIMEAttributes.smimeCapabilities, (ASN1Set) new DERSet(new DERSequence(sMIMECapabilityVector.toASN1EncodableVector())));
    }
}
