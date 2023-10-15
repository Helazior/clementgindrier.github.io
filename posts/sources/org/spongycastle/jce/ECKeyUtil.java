package org.spongycastle.jce;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.p012x9.X962Parameters;
import org.spongycastle.asn1.p012x9.X9ECParameters;
import org.spongycastle.asn1.p012x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.p016ec.ECUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECKeyUtil {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class UnexpectedException extends RuntimeException {
        private Throwable cause;

        public UnexpectedException(Throwable th) {
            super(th.toString());
            this.cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public static PrivateKey privateToExplicitParameters(PrivateKey privateKey, String str) {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return privateToExplicitParameters(privateKey, provider);
        }
        throw new NoSuchProviderException(outline.m266e("cannot find provider: ", str));
    }

    public static PublicKey publicToExplicitParameters(PublicKey publicKey, String str) {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return publicToExplicitParameters(publicKey, provider);
        }
        throw new NoSuchProviderException(outline.m266e("cannot find provider: ", str));
    }

    public static PrivateKey privateToExplicitParameters(PrivateKey privateKey, Provider provider) {
        X9ECParameters x9ECParameters;
        try {
            PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(privateKey.getEncoded()));
            if (!privateKeyInfo.getAlgorithmId().getObjectId().equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
                X962Parameters x962Parameters = X962Parameters.getInstance(privateKeyInfo.getAlgorithmId().getParameters());
                if (x962Parameters.isNamedCurve()) {
                    X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(DERObjectIdentifier.getInstance(x962Parameters.getParameters()));
                    x9ECParameters = new X9ECParameters(namedCurveByOid.getCurve(), namedCurveByOid.getG(), namedCurveByOid.getN(), namedCurveByOid.getH());
                } else if (!x962Parameters.isImplicitlyCA()) {
                    return privateKey;
                } else {
                    ProviderConfiguration providerConfiguration = BouncyCastleProvider.CONFIGURATION;
                    x9ECParameters = new X9ECParameters(providerConfiguration.getEcImplicitlyCa().getCurve(), providerConfiguration.getEcImplicitlyCa().getG(), providerConfiguration.getEcImplicitlyCa().getN(), providerConfiguration.getEcImplicitlyCa().getH());
                }
                return KeyFactory.getInstance(privateKey.getAlgorithm(), provider).generatePrivate(new PKCS8EncodedKeySpec(new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable) new X962Parameters(x9ECParameters)), privateKeyInfo.parsePrivateKey()).getEncoded()));
            }
            throw new UnsupportedEncodingException("cannot convert GOST key to explicit parameters.");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException(e3);
        }
    }

    public static PublicKey publicToExplicitParameters(PublicKey publicKey, Provider provider) {
        X9ECParameters x9ECParameters;
        try {
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(publicKey.getEncoded()));
            if (!subjectPublicKeyInfo.getAlgorithmId().getObjectId().equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
                X962Parameters x962Parameters = X962Parameters.getInstance(subjectPublicKeyInfo.getAlgorithmId().getParameters());
                if (x962Parameters.isNamedCurve()) {
                    X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(DERObjectIdentifier.getInstance(x962Parameters.getParameters()));
                    x9ECParameters = new X9ECParameters(namedCurveByOid.getCurve(), namedCurveByOid.getG(), namedCurveByOid.getN(), namedCurveByOid.getH());
                } else if (!x962Parameters.isImplicitlyCA()) {
                    return publicKey;
                } else {
                    ProviderConfiguration providerConfiguration = BouncyCastleProvider.CONFIGURATION;
                    x9ECParameters = new X9ECParameters(providerConfiguration.getEcImplicitlyCa().getCurve(), providerConfiguration.getEcImplicitlyCa().getG(), providerConfiguration.getEcImplicitlyCa().getN(), providerConfiguration.getEcImplicitlyCa().getH());
                }
                return KeyFactory.getInstance(publicKey.getAlgorithm(), provider).generatePublic(new X509EncodedKeySpec(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable) new X962Parameters(x9ECParameters)), subjectPublicKeyInfo.getPublicKeyData().getBytes()).getEncoded()));
            }
            throw new IllegalArgumentException("cannot convert GOST key to explicit parameters.");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException(e3);
        }
    }
}
