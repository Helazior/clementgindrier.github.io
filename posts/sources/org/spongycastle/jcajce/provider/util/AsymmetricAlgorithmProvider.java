package org.spongycastle.jcajce.provider.util;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AsymmetricAlgorithmProvider extends AlgorithmProvider {
    public void addSignatureAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String m265f = outline.m265f(str, "WITH", str2);
        String m265f2 = outline.m265f(str, "with", str2);
        String m265f3 = outline.m265f(str, "With", str2);
        String m265f4 = outline.m265f(str, "/", str2);
        configurableProvider.addAlgorithm("Signature." + m265f, str3);
        configurableProvider.addAlgorithm("Alg.Alias.Signature." + m265f2, m265f);
        configurableProvider.addAlgorithm("Alg.Alias.Signature." + m265f3, m265f);
        configurableProvider.addAlgorithm("Alg.Alias.Signature." + m265f4, m265f);
        StringBuilder sb = new StringBuilder();
        sb.append("Alg.Alias.Signature.");
        StringBuilder m246y = outline.m246y(sb, aSN1ObjectIdentifier, configurableProvider, m265f, "Alg.Alias.Signature.OID.");
        m246y.append(aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(m246y.toString(), m265f);
    }

    public void registerOid(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        configurableProvider.addAlgorithm("Alg.Alias.KeyFactory." + aSN1ObjectIdentifier, str);
        configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator." + aSN1ObjectIdentifier, str);
        configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    public void registerOidAlgorithmParameters(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, str);
        configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, str);
    }
}
