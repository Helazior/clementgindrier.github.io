package org.spongycastle.crypto.util;

import java.io.InputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.p012x9.DHDomainParameters;
import org.spongycastle.asn1.p012x9.DHPublicKey;
import org.spongycastle.asn1.p012x9.DHValidationParms;
import org.spongycastle.asn1.p012x9.X962NamedCurves;
import org.spongycastle.asn1.p012x9.X962Parameters;
import org.spongycastle.asn1.p012x9.X9ECParameters;
import org.spongycastle.asn1.p012x9.X9ECPoint;
import org.spongycastle.asn1.p012x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPublicKey;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.DHValidationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PublicKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] bArr) {
        return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        X9ECParameters x9ECParameters;
        AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
        if (!algorithm.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption) && !algorithm.getAlgorithm().equals(X509ObjectIdentifiers.id_ea_rsa)) {
            DSAParameters dSAParameters = null;
            if (algorithm.getAlgorithm().equals(X9ObjectIdentifiers.dhpublicnumber)) {
                BigInteger value = DHPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey()).getY().getValue();
                DHDomainParameters dHDomainParameters = DHDomainParameters.getInstance(algorithm.getParameters());
                BigInteger value2 = dHDomainParameters.getP().getValue();
                BigInteger value3 = dHDomainParameters.getG().getValue();
                BigInteger value4 = dHDomainParameters.getQ().getValue();
                BigInteger value5 = dHDomainParameters.getJ() != null ? dHDomainParameters.getJ().getValue() : null;
                DHValidationParms validationParms = dHDomainParameters.getValidationParms();
                return new DHPublicKeyParameters(value, new DHParameters(value2, value3, value4, value5, validationParms != null ? new DHValidationParameters(validationParms.getSeed().getBytes(), validationParms.getPgenCounter().getValue().intValue()) : null));
            } else if (algorithm.getAlgorithm().equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
                DHParameter dHParameter = DHParameter.getInstance(algorithm.getParameters());
                DERInteger dERInteger = (DERInteger) subjectPublicKeyInfo.parsePublicKey();
                BigInteger l = dHParameter.getL();
                return new DHPublicKeyParameters(dERInteger.getValue(), new DHParameters(dHParameter.getP(), dHParameter.getG(), null, l != null ? l.intValue() : 0));
            } else if (algorithm.getAlgorithm().equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
                ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) algorithm.getParameters());
                return new ElGamalPublicKeyParameters(((DERInteger) subjectPublicKeyInfo.parsePublicKey()).getValue(), new ElGamalParameters(elGamalParameter.getP(), elGamalParameter.getG()));
            } else if (!algorithm.getAlgorithm().equals(X9ObjectIdentifiers.id_dsa) && !algorithm.getAlgorithm().equals(OIWObjectIdentifiers.dsaWithSHA1)) {
                if (algorithm.getAlgorithm().equals(X9ObjectIdentifiers.id_ecPublicKey)) {
                    X962Parameters x962Parameters = new X962Parameters((ASN1Primitive) algorithm.getParameters());
                    if (x962Parameters.isNamedCurve()) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x962Parameters.getParameters();
                        x9ECParameters = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
                        if (x9ECParameters == null && (x9ECParameters = SECNamedCurves.getByOID(aSN1ObjectIdentifier)) == null && (x9ECParameters = NISTNamedCurves.getByOID(aSN1ObjectIdentifier)) == null) {
                            x9ECParameters = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
                        }
                    } else {
                        x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
                    }
                    return new ECPublicKeyParameters(new X9ECPoint(x9ECParameters.getCurve(), new DEROctetString(subjectPublicKeyInfo.getPublicKeyData().getBytes())).getPoint(), new ECDomainParameters(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed()));
                }
                throw new RuntimeException("algorithm identifier in key not recognised");
            } else {
                DERInteger dERInteger2 = (DERInteger) subjectPublicKeyInfo.parsePublicKey();
                ASN1Encodable parameters = algorithm.getParameters();
                if (parameters != null) {
                    DSAParameter dSAParameter = DSAParameter.getInstance(parameters.toASN1Primitive());
                    dSAParameters = new DSAParameters(dSAParameter.getP(), dSAParameter.getQ(), dSAParameter.getG());
                }
                return new DSAPublicKeyParameters(dERInteger2.getValue(), dSAParameters);
            }
        }
        RSAPublicKey rSAPublicKey = RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
        return new RSAKeyParameters(false, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
    }
}
