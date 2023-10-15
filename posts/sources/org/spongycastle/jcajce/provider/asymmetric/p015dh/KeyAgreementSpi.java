package org.spongycastle.jcajce.provider.asymmetric.p015dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.util.Strings;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable algorithms;

    /* renamed from: g */
    private BigInteger f6079g;

    /* renamed from: p */
    private BigInteger f6080p;
    private BigInteger result;

    /* renamed from: x */
    private BigInteger f6081x;

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Integer num = new Integer(64);
        Integer num2 = new Integer(192);
        Integer num3 = new Integer(128);
        Integer num4 = new Integer(256);
        hashtable.put("DES", num);
        hashtable.put("DESEDE", num2);
        hashtable.put("BLOWFISH", num3);
        hashtable.put("AES", num4);
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            return bArr;
        }
        return byteArray;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) {
        if (this.f6081x != null) {
            if (key instanceof DHPublicKey) {
                DHPublicKey dHPublicKey = (DHPublicKey) key;
                if (dHPublicKey.getParams().getG().equals(this.f6079g) && dHPublicKey.getParams().getP().equals(this.f6080p)) {
                    if (z) {
                        this.result = dHPublicKey.getY().modPow(this.f6081x, this.f6080p);
                        return null;
                    }
                    BigInteger modPow = dHPublicKey.getY().modPow(this.f6081x, this.f6080p);
                    this.result = modPow;
                    return new BCDHPublicKey(modPow, dHPublicKey.getParams());
                }
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            }
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        if (this.f6081x != null) {
            return bigIntToBytes(this.result);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec != null) {
                if (algorithmParameterSpec instanceof DHParameterSpec) {
                    DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                    this.f6080p = dHParameterSpec.getP();
                    this.f6079g = dHParameterSpec.getG();
                } else {
                    throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
                }
            } else {
                this.f6080p = dHPrivateKey.getParams().getP();
                this.f6079g = dHPrivateKey.getParams().getG();
            }
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.f6081x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) {
        if (this.f6081x != null) {
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            if (bArr.length - i >= bigIntToBytes.length) {
                System.arraycopy(bigIntToBytes, 0, bArr, i, bigIntToBytes.length);
                return bigIntToBytes.length;
            }
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        if (this.f6081x != null) {
            String upperCase = Strings.toUpperCase(str);
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            Hashtable hashtable = algorithms;
            if (hashtable.containsKey(upperCase)) {
                int intValue = ((Integer) hashtable.get(upperCase)).intValue() / 8;
                byte[] bArr = new byte[intValue];
                System.arraycopy(bigIntToBytes, 0, bArr, 0, intValue);
                if (upperCase.startsWith("DES")) {
                    DESParameters.setOddParity(bArr);
                }
                return new SecretKeySpec(bArr, str);
            }
            return new SecretKeySpec(bigIntToBytes, str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.f6080p = dHPrivateKey.getParams().getP();
            this.f6079g = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.f6081x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
