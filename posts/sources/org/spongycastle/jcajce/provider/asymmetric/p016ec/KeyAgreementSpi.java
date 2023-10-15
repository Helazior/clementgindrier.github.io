package org.spongycastle.jcajce.provider.asymmetric.p016ec;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.p012x9.X9IntegerConverter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHCBasicAgreement;
import org.spongycastle.crypto.agreement.ECMQVBasicAgreement;
import org.spongycastle.crypto.agreement.kdf.DHKDFParameters;
import org.spongycastle.crypto.agreement.kdf.ECDHKEKGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.MQVPrivateKey;
import org.spongycastle.jce.interfaces.MQVPublicKey;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable algorithms;
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private BasicAgreement agreement;
    private String kaAlgorithm;
    private DerivationFunction kdf;
    private ECDomainParameters parameters;
    private BigInteger result;

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2153DH extends KeyAgreementSpi {
        public C2153DH() {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), null);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), null);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDF */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class MQVwithSHA1KDF extends KeyAgreementSpi {
        public MQVwithSHA1KDF() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Integer num = new Integer(128);
        Integer num2 = new Integer(192);
        Integer num3 = new Integer(256);
        hashtable.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), num);
        hashtable.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), num2);
        hashtable.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), num3);
        hashtable.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), num);
        hashtable.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), num2);
        hashtable.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), num3);
        hashtable.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), num2);
    }

    public KeyAgreementSpi(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.agreement = basicAgreement;
        this.kdf = derivationFunction;
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(bigInteger, x9IntegerConverter.getByteLength(this.parameters.getG().getX()));
    }

    private static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    private void initFromKey(Key key) {
        if (this.agreement instanceof ECMQVBasicAgreement) {
            if (key instanceof MQVPrivateKey) {
                MQVPrivateKey mQVPrivateKey = (MQVPrivateKey) key;
                ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter(mQVPrivateKey.getStaticPrivateKey());
                MQVPrivateParameters mQVPrivateParameters = new MQVPrivateParameters(eCPrivateKeyParameters, (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter(mQVPrivateKey.getEphemeralPrivateKey()), mQVPrivateKey.getEphemeralPublicKey() != null ? (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPrivateKey.getEphemeralPublicKey()) : null);
                this.parameters = eCPrivateKeyParameters.getParameters();
                this.agreement.init(mQVPrivateParameters);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.kaAlgorithm);
            sb.append(" key agreement requires ");
            throw new InvalidKeyException(outline.m262i(sb, getSimpleName(MQVPrivateKey.class), " for initialisation"));
        } else if (key instanceof ECPrivateKey) {
            ECPrivateKeyParameters eCPrivateKeyParameters2 = (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter((PrivateKey) key);
            this.parameters = eCPrivateKeyParameters2.getParameters();
            this.agreement.init(eCPrivateKeyParameters2);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.kaAlgorithm);
            sb2.append(" key agreement requires ");
            throw new InvalidKeyException(outline.m262i(sb2, getSimpleName(ECPrivateKey.class), " for initialisation"));
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) {
        CipherParameters generatePublicKeyParameter;
        if (this.parameters != null) {
            if (z) {
                if (this.agreement instanceof ECMQVBasicAgreement) {
                    if (key instanceof MQVPublicKey) {
                        MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                        generatePublicKeyParameter = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getStaticKey()), (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey()));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.kaAlgorithm);
                        sb.append(" key agreement requires ");
                        throw new InvalidKeyException(outline.m262i(sb, getSimpleName(MQVPublicKey.class), " for doPhase"));
                    }
                } else if (key instanceof ECPublicKey) {
                    generatePublicKeyParameter = ECUtil.generatePublicKeyParameter((PublicKey) key);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.kaAlgorithm);
                    sb2.append(" key agreement requires ");
                    throw new InvalidKeyException(outline.m262i(sb2, getSimpleName(ECPublicKey.class), " for doPhase"));
                }
                this.result = this.agreement.calculateAgreement(generatePublicKeyParameter);
                return null;
            }
            throw new IllegalStateException(outline.m262i(new StringBuilder(), this.kaAlgorithm, " can only be between two parties."));
        }
        throw new IllegalStateException(outline.m262i(new StringBuilder(), this.kaAlgorithm, " not initialised."));
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        if (this.kdf == null) {
            return bigIntToBytes(this.result);
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        initFromKey(key);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) {
        initFromKey(key);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.kaAlgorithm);
        sb.append(" key agreement: need ");
        throw new ShortBufferException(outline.m263h(sb, engineGenerateSecret.length, " bytes"));
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        byte[] bigIntToBytes = bigIntToBytes(this.result);
        if (this.kdf != null) {
            Hashtable hashtable = algorithms;
            if (hashtable.containsKey(str)) {
                int intValue = ((Integer) hashtable.get(str)).intValue();
                DHKDFParameters dHKDFParameters = new DHKDFParameters(new DERObjectIdentifier(str), intValue, bigIntToBytes);
                int i = intValue / 8;
                bigIntToBytes = new byte[i];
                this.kdf.init(dHKDFParameters);
                this.kdf.generateBytes(bigIntToBytes, 0, i);
            } else {
                throw new NoSuchAlgorithmException(outline.m266e("unknown algorithm encountered: ", str));
            }
        }
        return new SecretKeySpec(bigIntToBytes, str);
    }
}
