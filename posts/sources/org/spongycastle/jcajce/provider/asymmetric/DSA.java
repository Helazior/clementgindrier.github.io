package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DSA {
    private static final String PREFIX = "org.spongycastle.jcajce.provider.asymmetric.dsa.";

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyFactory.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
            configurableProvider.addAlgorithm("Signature.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
            configurableProvider.addAlgorithm("Signature.NONEWITHDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
            addSignatureAlgorithm(configurableProvider, "SHA224", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", NISTObjectIdentifiers.dsa_with_sha224);
            addSignatureAlgorithm(configurableProvider, "SHA256", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", NISTObjectIdentifiers.dsa_with_sha256);
            addSignatureAlgorithm(configurableProvider, "SHA384", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", NISTObjectIdentifiers.dsa_with_sha384);
            addSignatureAlgorithm(configurableProvider, "SHA512", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", NISTObjectIdentifiers.dsa_with_sha512);
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA/DSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withDSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DSAwithSHA1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithDSA", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.DSAWithSHA1", "DSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.1.2.840.10040.4.3", "DSA");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            int i = 0;
            while (true) {
                ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = DSAUtil.dsaOids;
                if (i == aSN1ObjectIdentifierArr.length) {
                    return;
                }
                registerOid(configurableProvider, aSN1ObjectIdentifierArr[i], "DSA", keyFactorySpi);
                registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifierArr[i], "DSA");
                i++;
            }
        }
    }
}
