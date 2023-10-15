package org.spongycastle.jcajce.provider.asymmetric.p016ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.p012x9.X962NamedCurves;
import org.spongycastle.asn1.p012x9.X9ECParameters;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.p017ec.ECCurve;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECDH extends C2155EC {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.CONFIGURATION);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECDHC extends C2155EC {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.CONFIGURATION);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECDSA extends C2155EC {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.CONFIGURATION);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECMQV extends C2155EC {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public KeyPairGeneratorSpi(String str) {
        super(str);
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2155EC extends KeyPairGeneratorSpi {
        private static Hashtable ecParameters;
        public String algorithm;
        public int certainty;
        public ProviderConfiguration configuration;
        public Object ecParams;
        public ECKeyPairGenerator engine;
        public boolean initialised;
        public ECKeyGenerationParameters param;
        public SecureRandom random;
        public int strength;

        static {
            Hashtable hashtable = new Hashtable();
            ecParameters = hashtable;
            hashtable.put(new Integer(192), new ECGenParameterSpec("prime192v1"));
            ecParameters.put(new Integer(239), new ECGenParameterSpec("prime239v1"));
            ecParameters.put(new Integer(256), new ECGenParameterSpec("prime256v1"));
            ecParameters.put(new Integer(224), new ECGenParameterSpec("P-224"));
            ecParameters.put(new Integer(384), new ECGenParameterSpec("P-384"));
            ecParameters.put(new Integer(521), new ECGenParameterSpec("P-521"));
        }

        public C2155EC() {
            super("EC");
            this.engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.certainty = 50;
            this.random = new SecureRandom();
            this.initialised = false;
            this.algorithm = "EC";
            this.configuration = BouncyCastleProvider.CONFIGURATION;
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            if (this.initialised) {
                AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
                ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) generateKeyPair.getPublic();
                ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) generateKeyPair.getPrivate();
                Object obj = this.ecParams;
                if (obj instanceof ECParameterSpec) {
                    ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                    BCECPublicKey bCECPublicKey = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec, this.configuration);
                    return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.configuration));
                } else if (obj == null) {
                    return new KeyPair(new BCECPublicKey(this.algorithm, eCPublicKeyParameters, this.configuration), new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, this.configuration));
                } else {
                    java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) obj;
                    BCECPublicKey bCECPublicKey2 = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec2, this.configuration);
                    return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey2, eCParameterSpec2, this.configuration));
                }
            }
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.random = secureRandom;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) ecParameters.get(new Integer(i));
            if (eCGenParameterSpec != null) {
                try {
                    initialize(eCGenParameterSpec, secureRandom);
                    return;
                } catch (InvalidAlgorithmParameterException unused) {
                    throw new InvalidParameterException("key size not configurable.");
                }
            }
            throw new InvalidParameterException("unknown key size.");
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            String name;
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
                this.ecParams = algorithmParameterSpec;
                ECKeyGenerationParameters eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN()), secureRandom);
                this.param = eCKeyGenerationParameters;
                this.engine.init(eCKeyGenerationParameters);
                this.initialised = true;
            } else if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
                java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
                this.ecParams = algorithmParameterSpec;
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec2.getCurve());
                ECKeyGenerationParameters eCKeyGenerationParameters2 = new ECKeyGenerationParameters(new ECDomainParameters(convertCurve, EC5Util.convertPoint(convertCurve, eCParameterSpec2.getGenerator(), false), eCParameterSpec2.getOrder(), BigInteger.valueOf(eCParameterSpec2.getCofactor())), secureRandom);
                this.param = eCKeyGenerationParameters2;
                this.engine.init(eCKeyGenerationParameters2);
                this.initialised = true;
            } else {
                boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
                if (!z && !(algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                    if (algorithmParameterSpec == null && this.configuration.getEcImplicitlyCa() != null) {
                        ECParameterSpec ecImplicitlyCa = this.configuration.getEcImplicitlyCa();
                        this.ecParams = algorithmParameterSpec;
                        ECKeyGenerationParameters eCKeyGenerationParameters3 = new ECKeyGenerationParameters(new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN()), secureRandom);
                        this.param = eCKeyGenerationParameters3;
                        this.engine.init(eCKeyGenerationParameters3);
                        this.initialised = true;
                        return;
                    } else if (algorithmParameterSpec == null && this.configuration.getEcImplicitlyCa() == null) {
                        throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                    } else {
                        throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
                    }
                }
                if (z) {
                    name = ((ECGenParameterSpec) algorithmParameterSpec).getName();
                } else {
                    name = ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName();
                }
                String str = name;
                X9ECParameters byName = X962NamedCurves.getByName(str);
                if (byName == null) {
                    byName = SECNamedCurves.getByName(str);
                    if (byName == null) {
                        byName = NISTNamedCurves.getByName(str);
                    }
                    if (byName == null) {
                        byName = TeleTrusTNamedCurves.getByName(str);
                    }
                    if (byName == null) {
                        try {
                            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(str);
                            X9ECParameters byOID = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
                            if (byOID == null) {
                                byOID = SECNamedCurves.getByOID(aSN1ObjectIdentifier);
                            }
                            if (byOID == null) {
                                byOID = NISTNamedCurves.getByOID(aSN1ObjectIdentifier);
                            }
                            byName = byOID == null ? TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier) : byOID;
                            if (byName == null) {
                                throw new InvalidAlgorithmParameterException("unknown curve OID: " + str);
                            }
                        } catch (IllegalArgumentException unused) {
                            throw new InvalidAlgorithmParameterException(outline.m266e("unknown curve name: ", str));
                        }
                    }
                }
                ECNamedCurveSpec eCNamedCurveSpec = new ECNamedCurveSpec(str, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), null);
                this.ecParams = eCNamedCurveSpec;
                ECNamedCurveSpec eCNamedCurveSpec2 = eCNamedCurveSpec;
                ECCurve convertCurve2 = EC5Util.convertCurve(eCNamedCurveSpec2.getCurve());
                ECKeyGenerationParameters eCKeyGenerationParameters4 = new ECKeyGenerationParameters(new ECDomainParameters(convertCurve2, EC5Util.convertPoint(convertCurve2, eCNamedCurveSpec2.getGenerator(), false), eCNamedCurveSpec2.getOrder(), BigInteger.valueOf(eCNamedCurveSpec2.getCofactor())), secureRandom);
                this.param = eCKeyGenerationParameters4;
                this.engine.init(eCKeyGenerationParameters4);
                this.initialised = true;
            }
        }

        public C2155EC(String str, ProviderConfiguration providerConfiguration) {
            super(str);
            this.engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.certainty = 50;
            this.random = new SecureRandom();
            this.initialised = false;
            this.algorithm = str;
            this.configuration = providerConfiguration;
        }
    }
}
