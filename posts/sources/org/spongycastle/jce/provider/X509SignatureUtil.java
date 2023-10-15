package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.p012x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class X509SignatureUtil {
    private static final ASN1Null derNull = new DERNull();

    private static String getDigestAlgName(DERObjectIdentifier dERObjectIdentifier) {
        return PKCSObjectIdentifiers.md5.equals(dERObjectIdentifier) ? "MD5" : OIWObjectIdentifiers.idSHA1.equals(dERObjectIdentifier) ? "SHA1" : NISTObjectIdentifiers.id_sha224.equals(dERObjectIdentifier) ? "SHA224" : NISTObjectIdentifiers.id_sha256.equals(dERObjectIdentifier) ? "SHA256" : NISTObjectIdentifiers.id_sha384.equals(dERObjectIdentifier) ? "SHA384" : NISTObjectIdentifiers.id_sha512.equals(dERObjectIdentifier) ? "SHA512" : TeleTrusTObjectIdentifiers.ripemd128.equals(dERObjectIdentifier) ? "RIPEMD128" : TeleTrusTObjectIdentifiers.ripemd160.equals(dERObjectIdentifier) ? "RIPEMD160" : TeleTrusTObjectIdentifiers.ripemd256.equals(dERObjectIdentifier) ? "RIPEMD256" : CryptoProObjectIdentifiers.gostR3411.equals(dERObjectIdentifier) ? "GOST3411" : dERObjectIdentifier.getId();
    }

    public static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters != null && !derNull.equals(parameters)) {
            if (algorithmIdentifier.getObjectId().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
                return outline.m262i(new StringBuilder(), getDigestAlgName(RSASSAPSSparams.getInstance(parameters).getHashAlgorithm().getObjectId()), "withRSAandMGF1");
            } else if (algorithmIdentifier.getObjectId().equals(X9ObjectIdentifiers.ecdsa_with_SHA2)) {
                return outline.m262i(new StringBuilder(), getDigestAlgName((DERObjectIdentifier) ASN1Sequence.getInstance(parameters).getObjectAt(0)), "withECDSA");
            }
        }
        return algorithmIdentifier.getObjectId().getId();
    }

    public static void setSignatureParameters(Signature signature, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || derNull.equals(aSN1Encodable)) {
            return;
        }
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
        try {
            algorithmParameters.init(aSN1Encodable.toASN1Primitive().getEncoded());
            if (signature.getAlgorithm().endsWith("MGF1")) {
                try {
                    signature.setParameter(algorithmParameters.getParameterSpec(PSSParameterSpec.class));
                } catch (GeneralSecurityException e) {
                    StringBuilder m253r = outline.m253r("Exception extracting parameters: ");
                    m253r.append(e.getMessage());
                    throw new SignatureException(m253r.toString());
                }
            }
        } catch (IOException e2) {
            StringBuilder m253r2 = outline.m253r("IOException decoding parameters: ");
            m253r2.append(e2.getMessage());
            throw new SignatureException(m253r2.toString());
        }
    }
}
