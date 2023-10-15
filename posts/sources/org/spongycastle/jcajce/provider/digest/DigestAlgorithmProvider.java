package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class DigestAlgorithmProvider extends AlgorithmProvider {
    public void addHMACAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        String m266e = outline.m266e("HMAC", str);
        configurableProvider.addAlgorithm("Mac." + m266e, str2);
        configurableProvider.addAlgorithm("Alg.Alias.Mac.HMAC-" + str, m266e);
        configurableProvider.addAlgorithm("Alg.Alias.Mac.HMAC/" + str, m266e);
        configurableProvider.addAlgorithm("KeyGenerator." + m266e, str3);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.HMAC-" + str, m266e);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.HMAC/" + str, m266e);
    }

    public void addHMACAlias(ConfigurableProvider configurableProvider, String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String m266e = outline.m266e("HMAC", str);
        configurableProvider.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier, m266e);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator." + aSN1ObjectIdentifier, m266e);
    }
}
