package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.DESedeWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESedeKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DESede {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("DES", BouncyCastleProvider.PROVIDER_NAME);
                algorithmParameters.init(new IvParameterSpec(bArr));
                return algorithmParameters;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 64);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CBCMAC extends BaseMac {
        public CBCMAC() {
            super(new CBCBlockCipherMac(new DESedeEngine()));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new DESedeEngine()));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DESede64 extends BaseMac {
        public DESede64() {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DESede64with7816d4 extends BaseMac {
        public DESede64with7816d4() {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64, new ISO7816d4Padding()));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DESedeCFB8 extends BaseMac {
        public DESedeCFB8() {
            super(new CFBBlockCipherMac(new DESedeEngine()));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new DESedeEngine());
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("DESede", null);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof DESedeKeySpec) {
                return new SecretKeySpec(((DESedeKeySpec) keySpec).getKey(), "DESede");
            }
            return super.engineGenerateSecret(keySpec);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) {
            if (cls != null) {
                if (secretKey != null) {
                    if (SecretKeySpec.class.isAssignableFrom(cls)) {
                        return new SecretKeySpec(secretKey.getEncoded(), this.algName);
                    }
                    if (DESedeKeySpec.class.isAssignableFrom(cls)) {
                        byte[] encoded = secretKey.getEncoded();
                        try {
                            if (encoded.length == 16) {
                                byte[] bArr = new byte[24];
                                System.arraycopy(encoded, 0, bArr, 0, 16);
                                System.arraycopy(encoded, 0, bArr, 16, 8);
                                return new DESedeKeySpec(bArr);
                            }
                            return new DESedeKeySpec(encoded);
                        } catch (Exception e) {
                            throw new InvalidKeySpecException(e.toString());
                        }
                    }
                    throw new InvalidKeySpecException("Invalid KeySpec");
                }
                throw new InvalidKeySpecException("key parameter is null");
            }
            throw new InvalidKeySpecException("keySpec parameter is null");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGenerator extends BaseKeyGenerator {
        private boolean keySizeSet;

        public KeyGenerator() {
            super("DESede", 192, new DESedeKeyGenerator());
            this.keySizeSet = false;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator, javax.crypto.KeyGeneratorSpi
        public SecretKey engineGenerateKey() {
            if (this.uninitialised) {
                this.engine.init(new KeyGenerationParameters(new SecureRandom(), this.defaultKeySize));
                this.uninitialised = false;
            }
            if (!this.keySizeSet) {
                byte[] generateKey = this.engine.generateKey();
                System.arraycopy(generateKey, 0, generateKey, 16, 8);
                return new SecretKeySpec(generateKey, this.algName);
            }
            return new SecretKeySpec(this.engine.generateKey(), this.algName);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator, javax.crypto.KeyGeneratorSpi
        public void engineInit(int i, SecureRandom secureRandom) {
            super.engineInit(i, secureRandom);
            this.keySizeSet = true;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class KeyGenerator3 extends BaseKeyGenerator {
        public KeyGenerator3() {
            super("DESede3", 192, new DESedeKeyGenerator());
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Mappings extends AlgorithmProvider {
        private static final String PACKAGE = "org.spongycastle.jcajce.provider.symmetric";
        private static final String PREFIX = DESede.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            StringBuilder m249v = outline.m249v(sb, str, "$ECB", configurableProvider, "Cipher.DESEDE");
            m249v.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.des_EDE3_CBC;
            m249v.append(aSN1ObjectIdentifier);
            StringBuilder m248w = outline.m248w(outline.m250u(str, "$CBC", configurableProvider, m249v.toString(), str), "$Wrap", configurableProvider, "Cipher.DESEDEWRAP", "Cipher.");
            m248w.append(PKCSObjectIdentifiers.id_alg_CMS3DESwrap);
            StringBuilder m250u = outline.m250u(str, "$Wrap", configurableProvider, m248w.toString(), str);
            m250u.append("$RFC3211");
            configurableProvider.addAlgorithm("Cipher.DESEDERFC3211WRAP", m250u.toString());
            if (configurableProvider.hasAlgorithm("MessageDigest", "SHA-1")) {
                StringBuilder m246y = outline.m246y(outline.m248w(outline.m248w(outline.m248w(outline.m248w(outline.m250u(str, "$PBEWithSHAAndDES3Key", configurableProvider, "Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", str), "$BrokePBEWithSHAAndDES3Key", configurableProvider, "Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", str), "$OldPBEWithSHAAndDES3Key", configurableProvider, "Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", str), "$PBEWithSHAAndDES2Key", configurableProvider, "Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", str), "$BrokePBEWithSHAAndDES2Key", configurableProvider, "Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", "Alg.Alias.Cipher."), PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, configurableProvider, "PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "Alg.Alias.Cipher.");
                m246y.append(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC);
                configurableProvider.addAlgorithm(m246y.toString(), "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            }
            StringBuilder m250u2 = outline.m250u(str, "$KeyGenerator", configurableProvider, "KeyGenerator.DESEDE", "KeyGenerator.");
            m250u2.append(aSN1ObjectIdentifier);
            StringBuilder m248w2 = outline.m248w(outline.m248w(outline.m248w(outline.m250u(str, "$KeyGenerator3", configurableProvider, m250u2.toString(), str), "$KeyGenerator", configurableProvider, "KeyGenerator.DESEDEWRAP", str), "$KeyFactory", configurableProvider, "SecretKeyFactory.DESEDE", str), "$CMAC", configurableProvider, "Mac.DESEDECMAC", str);
            m248w2.append("$CBCMAC");
            configurableProvider.addAlgorithm("Mac.DESEDEMAC", m248w2.toString());
            configurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
            configurableProvider.addAlgorithm("Mac.DESEDEMAC/CFB8", str + "$DESedeCFB8");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
            outline.m277D(new StringBuilder(), str, "$DESede64", configurableProvider, "Mac.DESEDEMAC64");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
            configurableProvider.addAlgorithm("Mac.DESEDEMAC64WITHISO7816-4PADDING", str + "$DESede64with7816d4");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.addAlgorithm("AlgorithmParameters.DESEDE", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, "DESEDE");
            StringBuilder m249v2 = outline.m249v(new StringBuilder(), str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.DESEDE");
            m249v2.append("Alg.Alias.AlgorithmParameterGenerator.");
            m249v2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(m249v2.toString(), "DESEDE");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class PBEWithSHAAndDES2Key extends BaseBlockCipher {
        public PBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class PBEWithSHAAndDES3Key extends BaseBlockCipher {
        public PBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RFC3211 extends BaseWrapCipher {
        public RFC3211() {
            super(new RFC3211WrapEngine(new DESedeEngine()), 8);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new DESedeWrapEngine());
        }
    }

    private DESede() {
    }
}
