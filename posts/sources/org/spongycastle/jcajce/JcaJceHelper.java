package org.spongycastle.jcajce;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface JcaJceHelper {
    AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str);

    AlgorithmParameters createAlgorithmParameters(String str);

    CertificateFactory createCertificateFactory(String str);

    Cipher createCipher(String str);

    MessageDigest createDigest(String str);

    KeyAgreement createKeyAgreement(String str);

    KeyFactory createKeyFactory(String str);

    KeyGenerator createKeyGenerator(String str);

    KeyPairGenerator createKeyPairGenerator(String str);

    Mac createMac(String str);

    Signature createSignature(String str);
}
