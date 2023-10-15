package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.engines.AESWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AES {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class AESCMAC extends BaseMac {
        public AESCMAC() {
            super(new CMac(new AESFastEngine()));
        }
    }

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
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES", BouncyCastleProvider.PROVIDER_NAME);
                algorithmParameters.init(new IvParameterSpec(bArr));
                return algorithmParameters;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "AES IV";
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new AESFastEngine()), 128);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new AESFastEngine());
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(192);
        }

        public KeyGen(int i) {
            super("AES", i, new CipherKeyGenerator());
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
        private static final String PREFIX = AES.class.getName();
        private static final String wrongAES128 = "2.16.840.1.101.3.4.2";
        private static final String wrongAES192 = "2.16.840.1.101.3.4.22";
        private static final String wrongAES256 = "2.16.840.1.101.3.4.42";

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            outline.m277D(sb, str, "$AlgParams", configurableProvider, "AlgorithmParameters.AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes128_CBC;
            StringBuilder m246y = outline.m246y(sb2, aSN1ObjectIdentifier, configurableProvider, "AES", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes192_CBC;
            StringBuilder m246y2 = outline.m246y(m246y, aSN1ObjectIdentifier2, configurableProvider, "AES", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes256_CBC;
            StringBuilder m246y3 = outline.m246y(m246y2, aSN1ObjectIdentifier3, configurableProvider, "AES", str);
            m246y3.append("$AlgParamGen");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.AES", m246y3.toString());
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier2, "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier3, "AES");
            outline.m277D(new StringBuilder(), str, "$ECB", configurableProvider, "Cipher.AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_aes128_ECB;
            sb3.append(aSN1ObjectIdentifier4);
            StringBuilder m250u = outline.m250u(str, "$ECB", configurableProvider, sb3.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_aes192_ECB;
            m250u.append(aSN1ObjectIdentifier5);
            StringBuilder m250u2 = outline.m250u(str, "$ECB", configurableProvider, m250u.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_aes256_ECB;
            m250u2.append(aSN1ObjectIdentifier6);
            StringBuilder m250u3 = outline.m250u(str, "$ECB", configurableProvider, m250u2.toString(), "Cipher.");
            m250u3.append(aSN1ObjectIdentifier);
            StringBuilder m250u4 = outline.m250u(str, "$CBC", configurableProvider, m250u3.toString(), "Cipher.");
            m250u4.append(aSN1ObjectIdentifier2);
            StringBuilder m250u5 = outline.m250u(str, "$CBC", configurableProvider, m250u4.toString(), "Cipher.");
            m250u5.append(aSN1ObjectIdentifier3);
            StringBuilder m250u6 = outline.m250u(str, "$CBC", configurableProvider, m250u5.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_aes128_OFB;
            m250u6.append(aSN1ObjectIdentifier7);
            StringBuilder m250u7 = outline.m250u(str, "$OFB", configurableProvider, m250u6.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_aes192_OFB;
            m250u7.append(aSN1ObjectIdentifier8);
            StringBuilder m250u8 = outline.m250u(str, "$OFB", configurableProvider, m250u7.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_aes256_OFB;
            m250u8.append(aSN1ObjectIdentifier9);
            StringBuilder m250u9 = outline.m250u(str, "$OFB", configurableProvider, m250u8.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_aes128_CFB;
            m250u9.append(aSN1ObjectIdentifier10);
            StringBuilder m250u10 = outline.m250u(str, "$CFB", configurableProvider, m250u9.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.id_aes192_CFB;
            m250u10.append(aSN1ObjectIdentifier11);
            StringBuilder m250u11 = outline.m250u(str, "$CFB", configurableProvider, m250u10.toString(), "Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_aes256_CFB;
            m250u11.append(aSN1ObjectIdentifier12);
            StringBuilder m248w = outline.m248w(outline.m250u(str, "$CFB", configurableProvider, m250u11.toString(), str), "$Wrap", configurableProvider, "Cipher.AESWRAP", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_aes128_wrap;
            StringBuilder m246y4 = outline.m246y(m248w, aSN1ObjectIdentifier13, configurableProvider, "AESWRAP", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.id_aes192_wrap;
            StringBuilder m246y5 = outline.m246y(m246y4, aSN1ObjectIdentifier14, configurableProvider, "AESWRAP", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.id_aes256_wrap;
            StringBuilder m248w2 = outline.m248w(outline.m248w(outline.m248w(outline.m248w(outline.m248w(outline.m246y(m246y5, aSN1ObjectIdentifier15, configurableProvider, "AESWRAP", str), "$RFC3211Wrap", configurableProvider, "Cipher.AESRFC3211WRAP", str), "$KeyGen", configurableProvider, "KeyGenerator.AES", str), "$KeyGen128", configurableProvider, "KeyGenerator.2.16.840.1.101.3.4.2", str), "$KeyGen192", configurableProvider, "KeyGenerator.2.16.840.1.101.3.4.22", str), "$KeyGen256", configurableProvider, "KeyGenerator.2.16.840.1.101.3.4.42", "KeyGenerator.");
            m248w2.append(aSN1ObjectIdentifier4);
            StringBuilder m250u12 = outline.m250u(str, "$KeyGen128", configurableProvider, m248w2.toString(), "KeyGenerator.");
            m250u12.append(aSN1ObjectIdentifier);
            StringBuilder m250u13 = outline.m250u(str, "$KeyGen128", configurableProvider, m250u12.toString(), "KeyGenerator.");
            m250u13.append(aSN1ObjectIdentifier7);
            StringBuilder m250u14 = outline.m250u(str, "$KeyGen128", configurableProvider, m250u13.toString(), "KeyGenerator.");
            m250u14.append(aSN1ObjectIdentifier10);
            StringBuilder m250u15 = outline.m250u(str, "$KeyGen128", configurableProvider, m250u14.toString(), "KeyGenerator.");
            m250u15.append(aSN1ObjectIdentifier5);
            StringBuilder m250u16 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u15.toString(), "KeyGenerator.");
            m250u16.append(aSN1ObjectIdentifier2);
            StringBuilder m250u17 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u16.toString(), "KeyGenerator.");
            m250u17.append(aSN1ObjectIdentifier8);
            StringBuilder m250u18 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u17.toString(), "KeyGenerator.");
            m250u18.append(aSN1ObjectIdentifier11);
            StringBuilder m250u19 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u18.toString(), "KeyGenerator.");
            m250u19.append(aSN1ObjectIdentifier6);
            StringBuilder m250u20 = outline.m250u(str, "$KeyGen256", configurableProvider, m250u19.toString(), "KeyGenerator.");
            m250u20.append(aSN1ObjectIdentifier3);
            StringBuilder m250u21 = outline.m250u(str, "$KeyGen256", configurableProvider, m250u20.toString(), "KeyGenerator.");
            m250u21.append(aSN1ObjectIdentifier9);
            StringBuilder m250u22 = outline.m250u(str, "$KeyGen256", configurableProvider, m250u21.toString(), "KeyGenerator.");
            m250u22.append(aSN1ObjectIdentifier12);
            StringBuilder m248w3 = outline.m248w(outline.m250u(str, "$KeyGen256", configurableProvider, m250u22.toString(), str), "$KeyGen", configurableProvider, "KeyGenerator.AESWRAP", "KeyGenerator.");
            m248w3.append(aSN1ObjectIdentifier13);
            StringBuilder m250u23 = outline.m250u(str, "$KeyGen128", configurableProvider, m248w3.toString(), "KeyGenerator.");
            m250u23.append(aSN1ObjectIdentifier14);
            StringBuilder m250u24 = outline.m250u(str, "$KeyGen192", configurableProvider, m250u23.toString(), "KeyGenerator.");
            m250u24.append(aSN1ObjectIdentifier15);
            StringBuilder m250u25 = outline.m250u(str, "$KeyGen256", configurableProvider, m250u24.toString(), str);
            m250u25.append("$AESCMAC");
            configurableProvider.addAlgorithm("Mac.AESCMAC", m250u25.toString());
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESFastEngine()), 16);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new AESWrapEngine());
        }
    }

    private AES() {
    }
}
