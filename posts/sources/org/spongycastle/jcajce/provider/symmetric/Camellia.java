package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.CamelliaWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Camellia {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("Camellia", BouncyCastleProvider.PROVIDER_NAME);
                algorithmParameters.init(new IvParameterSpec(bArr));
                return algorithmParameters;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Camellia parameter generation.");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Camellia IV";
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new CamelliaEngine()), 128);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new CamelliaEngine());
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("Camellia", i, new CipherKeyGenerator());
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(192);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = Camellia.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            StringBuilder m249v = outline.m249v(sb, str, "$AlgParams", configurableProvider, "AlgorithmParameters.CAMELLIA");
            m249v.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NTTObjectIdentifiers.id_camellia128_cbc;
            StringBuilder m246y = outline.m246y(m249v, aSN1ObjectIdentifier, configurableProvider, "CAMELLIA", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NTTObjectIdentifiers.id_camellia192_cbc;
            StringBuilder m246y2 = outline.m246y(m246y, aSN1ObjectIdentifier2, configurableProvider, "CAMELLIA", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NTTObjectIdentifiers.id_camellia256_cbc;
            StringBuilder m248w = outline.m248w(outline.m246y(outline.m246y(outline.m246y(outline.m248w(outline.m246y(m246y2, aSN1ObjectIdentifier3, configurableProvider, "CAMELLIA", str), "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.CAMELLIA", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier, configurableProvider, "CAMELLIA", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier2, configurableProvider, "CAMELLIA", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier3, configurableProvider, "CAMELLIA", str), "$ECB", configurableProvider, "Cipher.CAMELLIA", "Cipher.");
            m248w.append(aSN1ObjectIdentifier);
            StringBuilder m250u = outline.m250u(str, "$CBC", configurableProvider, m248w.toString(), "Cipher.");
            m250u.append(aSN1ObjectIdentifier2);
            StringBuilder m250u2 = outline.m250u(str, "$CBC", configurableProvider, m250u.toString(), "Cipher.");
            m250u2.append(aSN1ObjectIdentifier3);
            StringBuilder m248w2 = outline.m248w(outline.m248w(outline.m250u(str, "$CBC", configurableProvider, m250u2.toString(), str), "$RFC3211Wrap", configurableProvider, "Cipher.CAMELLIARFC3211WRAP", str), "$Wrap", configurableProvider, "Cipher.CAMELLIAWRAP", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.id_camellia128_wrap;
            StringBuilder m246y3 = outline.m246y(m248w2, aSN1ObjectIdentifier4, configurableProvider, "CAMELLIAWRAP", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.id_camellia192_wrap;
            StringBuilder m246y4 = outline.m246y(m246y3, aSN1ObjectIdentifier5, configurableProvider, "CAMELLIAWRAP", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.id_camellia256_wrap;
            StringBuilder m248w3 = outline.m248w(outline.m246y(m246y4, aSN1ObjectIdentifier6, configurableProvider, "CAMELLIAWRAP", str), "$KeyGen", configurableProvider, "KeyGenerator.CAMELLIA", "KeyGenerator.");
            m248w3.append(aSN1ObjectIdentifier4);
            StringBuilder m250u3 = outline.m250u(str, "$KeyGen128", configurableProvider, m248w3.toString(), "KeyGenerator.");
            m250u3.append(aSN1ObjectIdentifier5);
            StringBuilder m250u4 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u3.toString(), "KeyGenerator.");
            m250u4.append(aSN1ObjectIdentifier6);
            StringBuilder m250u5 = outline.m250u(str, "$KeyGen256", configurableProvider, m250u4.toString(), "KeyGenerator.");
            m250u5.append(aSN1ObjectIdentifier);
            StringBuilder m250u6 = outline.m250u(str, "$KeyGen128", configurableProvider, m250u5.toString(), "KeyGenerator.");
            m250u6.append(aSN1ObjectIdentifier2);
            StringBuilder m250u7 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u6.toString(), "KeyGenerator.");
            m250u7.append(aSN1ObjectIdentifier3);
            String sb2 = m250u7.toString();
            configurableProvider.addAlgorithm(sb2, str + "$KeyGen256");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new CamelliaEngine()), 16);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new CamelliaWrapEngine());
        }
    }

    private Camellia() {
    }
}
