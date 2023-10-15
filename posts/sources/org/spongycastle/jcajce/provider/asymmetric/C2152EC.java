package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.eac.EACObjectIdentifiers;
import org.spongycastle.asn1.p012x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.p016ec.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.EC */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2152EC {
    private static final String PREFIX = "org.spongycastle.jcajce.provider.asymmetric.ec.";

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.EC$Mappings */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyAgreement.ECDH", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH");
            configurableProvider.addAlgorithm("KeyAgreement.ECDHC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC");
            configurableProvider.addAlgorithm("KeyAgreement.ECMQV", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV");
            StringBuilder sb = new StringBuilder();
            sb.append("KeyAgreement.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme;
            StringBuilder m246y = outline.m246y(sb, aSN1ObjectIdentifier, configurableProvider, "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF", "KeyAgreement.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme;
            m246y.append(aSN1ObjectIdentifier2);
            configurableProvider.addAlgorithm(m246y.toString(), "org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDF");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = X9ObjectIdentifiers.id_ecPublicKey;
            registerOid(configurableProvider, aSN1ObjectIdentifier3, "EC", new KeyFactorySpi.C2154EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier, "EC", new KeyFactorySpi.C2154EC());
            registerOid(configurableProvider, aSN1ObjectIdentifier2, "ECMQV", new KeyFactorySpi.ECMQV());
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier3, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "EC");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier2, "EC");
            configurableProvider.addAlgorithm("KeyFactory.EC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$EC");
            configurableProvider.addAlgorithm("KeyFactory.ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDSA");
            configurableProvider.addAlgorithm("KeyFactory.ECDH", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDH");
            configurableProvider.addAlgorithm("KeyFactory.ECDHC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDHC");
            configurableProvider.addAlgorithm("KeyFactory.ECMQV", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECMQV");
            configurableProvider.addAlgorithm("KeyPairGenerator.EC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDH", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECDHC", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECIES", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH");
            configurableProvider.addAlgorithm("KeyPairGenerator.ECMQV", "org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV");
            configurableProvider.addAlgorithm("Signature.ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA");
            configurableProvider.addAlgorithm("Signature.NONEwithECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withECDSA", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAwithSHA1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHECDSA", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAWITHSHA1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithECDSA", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.ECDSAWithSHA1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.2.840.10045.4.1", "ECDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + TeleTrusTObjectIdentifiers.ecSignWithSha1, "ECDSA");
            addSignatureAlgorithm(configurableProvider, "SHA224", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224", X9ObjectIdentifiers.ecdsa_with_SHA224);
            addSignatureAlgorithm(configurableProvider, "SHA256", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256", X9ObjectIdentifiers.ecdsa_with_SHA256);
            addSignatureAlgorithm(configurableProvider, "SHA384", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384", X9ObjectIdentifiers.ecdsa_with_SHA384);
            addSignatureAlgorithm(configurableProvider, "SHA512", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512", X9ObjectIdentifiers.ecdsa_with_SHA512);
            addSignatureAlgorithm(configurableProvider, "RIPEMD160", "ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160", TeleTrusTObjectIdentifiers.ecSignWithRipemd160);
            configurableProvider.addAlgorithm("Signature.SHA1WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR");
            configurableProvider.addAlgorithm("Signature.SHA224WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224");
            configurableProvider.addAlgorithm("Signature.SHA256WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256");
            configurableProvider.addAlgorithm("Signature.SHA384WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384");
            configurableProvider.addAlgorithm("Signature.SHA512WITHECNR", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512");
            addSignatureAlgorithm(configurableProvider, "SHA1", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1);
            addSignatureAlgorithm(configurableProvider, "SHA224", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224", EACObjectIdentifiers.id_TA_ECDSA_SHA_224);
            addSignatureAlgorithm(configurableProvider, "SHA256", "CVC-ECDSA", "org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256", EACObjectIdentifiers.id_TA_ECDSA_SHA_256);
        }
    }
}
