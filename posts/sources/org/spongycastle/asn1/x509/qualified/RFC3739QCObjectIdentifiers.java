package org.spongycastle.asn1.x509.qualified;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface RFC3739QCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_qcs;
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v1;
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v2;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.11");
        id_qcs = aSN1ObjectIdentifier;
        id_qcs_pkixQCSyntax_v1 = aSN1ObjectIdentifier.branch("1");
        id_qcs_pkixQCSyntax_v2 = aSN1ObjectIdentifier.branch("2");
    }
}
