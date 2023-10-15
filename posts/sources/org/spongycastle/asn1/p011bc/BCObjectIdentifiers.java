package org.spongycastle.asn1.p011bc;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

/* renamed from: org.spongycastle.asn1.bc.BCObjectIdentifiers */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface BCObjectIdentifiers {

    /* renamed from: bc */
    public static final ASN1ObjectIdentifier f5640bc;
    public static final ASN1ObjectIdentifier bc_pbe;
    public static final ASN1ObjectIdentifier bc_pbe_sha1;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs5;
    public static final ASN1ObjectIdentifier bc_pbe_sha224;
    public static final ASN1ObjectIdentifier bc_pbe_sha256;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs5;
    public static final ASN1ObjectIdentifier bc_pbe_sha384;
    public static final ASN1ObjectIdentifier bc_pbe_sha512;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        f5640bc = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId() + ".1");
        bc_pbe = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2.getId() + ".1");
        bc_pbe_sha1 = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2.getId() + ".2.1");
        bc_pbe_sha256 = aSN1ObjectIdentifier4;
        bc_pbe_sha384 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2.getId() + ".2.2");
        bc_pbe_sha512 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2.getId() + ".2.3");
        bc_pbe_sha224 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2.getId() + ".2.4");
        bc_pbe_sha1_pkcs5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3.getId() + ".1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3.getId() + ".2");
        bc_pbe_sha1_pkcs12 = aSN1ObjectIdentifier5;
        bc_pbe_sha256_pkcs5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4.getId() + ".1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4.getId() + ".2");
        bc_pbe_sha256_pkcs12 = aSN1ObjectIdentifier6;
        bc_pbe_sha1_pkcs12_aes128_cbc = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5.getId() + ".1.2");
        bc_pbe_sha1_pkcs12_aes192_cbc = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5.getId() + ".1.22");
        bc_pbe_sha1_pkcs12_aes256_cbc = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5.getId() + ".1.42");
        bc_pbe_sha256_pkcs12_aes128_cbc = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6.getId() + ".1.2");
        bc_pbe_sha256_pkcs12_aes192_cbc = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6.getId() + ".1.22");
        bc_pbe_sha256_pkcs12_aes256_cbc = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6.getId() + ".1.42");
    }
}
