package org.spongycastle.crypto.signers;

import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RSADigestSigner implements Signer {
    private static final Hashtable oidMap;
    private final AlgorithmIdentifier algId;
    private final Digest digest;
    private boolean forSigning;
    private final AsymmetricBlockCipher rsaEngine = new PKCS1Encoding(new RSABlindedEngine());

    static {
        Hashtable hashtable = new Hashtable();
        oidMap = hashtable;
        hashtable.put("RIPEMD128", TeleTrusTObjectIdentifiers.ripemd128);
        hashtable.put("RIPEMD160", TeleTrusTObjectIdentifiers.ripemd160);
        hashtable.put("RIPEMD256", TeleTrusTObjectIdentifiers.ripemd256);
        hashtable.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
        hashtable.put("SHA-224", NISTObjectIdentifiers.id_sha224);
        hashtable.put("SHA-256", NISTObjectIdentifiers.id_sha256);
        hashtable.put("SHA-384", NISTObjectIdentifiers.id_sha384);
        hashtable.put("SHA-512", NISTObjectIdentifiers.id_sha512);
        hashtable.put("MD2", PKCSObjectIdentifiers.md2);
        hashtable.put("MD4", PKCSObjectIdentifiers.md4);
        hashtable.put("MD5", PKCSObjectIdentifiers.md5);
    }

    public RSADigestSigner(Digest digest) {
        this.digest = digest;
        this.algId = new AlgorithmIdentifier((ASN1ObjectIdentifier) oidMap.get(digest.getAlgorithmName()), (ASN1Encodable) DERNull.INSTANCE);
    }

    private byte[] derEncode(byte[] bArr) {
        return new DigestInfo(this.algId, bArr).getEncoded(ASN1Encoding.DER);
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.forSigning) {
            byte[] bArr = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr, 0);
            try {
                byte[] derEncode = derEncode(bArr);
                return this.rsaEngine.processBlock(derEncode, 0, derEncode.length);
            } catch (IOException e) {
                StringBuilder m253r = outline.m253r("unable to encode signature: ");
                m253r.append(e.getMessage());
                throw new CryptoException(m253r.toString(), e);
            }
        }
        throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "withRSA";
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forSigning = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("verification requires public key");
        }
        reset();
        this.rsaEngine.init(z, cipherParameters);
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b) {
        this.digest.update(b);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            int digestSize = this.digest.getDigestSize();
            byte[] bArr2 = new byte[digestSize];
            this.digest.doFinal(bArr2, 0);
            try {
                byte[] processBlock = this.rsaEngine.processBlock(bArr, 0, bArr.length);
                byte[] derEncode = derEncode(bArr2);
                if (processBlock.length == derEncode.length) {
                    return Arrays.constantTimeAreEqual(processBlock, derEncode);
                }
                if (processBlock.length == derEncode.length - 2) {
                    int length = (processBlock.length - digestSize) - 2;
                    int length2 = (derEncode.length - digestSize) - 2;
                    derEncode[1] = (byte) (derEncode[1] - 2);
                    derEncode[3] = (byte) (derEncode[3] - 2);
                    int i = 0;
                    for (int i2 = 0; i2 < digestSize; i2++) {
                        i |= processBlock[length + i2] ^ derEncode[length2 + i2];
                    }
                    for (int i3 = 0; i3 < length; i3++) {
                        i |= processBlock[i3] ^ derEncode[i3];
                    }
                    return i == 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        throw new IllegalStateException("RSADigestSigner not initialised for verification");
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
