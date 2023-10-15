package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.agreement.srp.SRP6Client;
import org.spongycastle.crypto.agreement.srp.SRP6Util;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.p013io.SignerInputStream;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.BigIntegers;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsSRPKeyExchange implements TlsKeyExchange {
    public TlsClientContext context;
    public byte[] identity;
    public int keyExchange;
    public byte[] password;
    public TlsSigner tlsSigner;
    public AsymmetricKeyParameter serverPublicKey = null;

    /* renamed from: s */
    public byte[] f6074s = null;

    /* renamed from: B */
    public BigInteger f6073B = null;
    public SRP6Client srpClient = new SRP6Client();

    public TlsSRPKeyExchange(TlsClientContext tlsClientContext, int i, byte[] bArr, byte[] bArr2) {
        switch (i) {
            case 21:
                this.tlsSigner = null;
                break;
            case 22:
                this.tlsSigner = new TlsDSSSigner();
                break;
            case 23:
                this.tlsSigner = new TlsRSASigner();
                break;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.context = tlsClientContext;
        this.keyExchange = i;
        this.identity = bArr;
        this.password = bArr2;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) {
        TlsUtils.writeOpaque16(BigIntegers.asUnsignedByteArray(this.srpClient.generateClientCredentials(this.f6074s, this.identity, this.password)), outputStream);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() {
        try {
            return BigIntegers.asUnsignedByteArray(this.srpClient.calculateSecret(this.f6073B));
        } catch (CryptoException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner.createVerifyer(this.serverPublicKey);
        byte[] bArr = securityParameters.clientRandom;
        createVerifyer.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.serverRandom;
        createVerifyer.update(bArr2, 0, bArr2.length);
        return createVerifyer;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) {
        if (this.tlsSigner != null) {
            X509CertificateStructure x509CertificateStructure = certificate.certs[0];
            try {
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(x509CertificateStructure.getSubjectPublicKeyInfo());
                this.serverPublicKey = createKey;
                if (this.tlsSigner.isValidPublicKey(createKey)) {
                    TlsUtils.validateKeyUsage(x509CertificateStructure, 128);
                    return;
                }
                throw new TlsFatalAlert((short) 46);
            } catch (RuntimeException unused) {
                throw new TlsFatalAlert((short) 43);
            }
        }
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) {
        Signer signer;
        InputStream inputStream2;
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        TlsSigner tlsSigner = this.tlsSigner;
        if (tlsSigner != null) {
            signer = initSigner(tlsSigner, securityParameters);
            inputStream2 = new SignerInputStream(inputStream, signer);
        } else {
            signer = null;
            inputStream2 = inputStream;
        }
        byte[] readOpaque16 = TlsUtils.readOpaque16(inputStream2);
        byte[] readOpaque162 = TlsUtils.readOpaque16(inputStream2);
        byte[] readOpaque8 = TlsUtils.readOpaque8(inputStream2);
        byte[] readOpaque163 = TlsUtils.readOpaque16(inputStream2);
        if (signer != null && !signer.verifySignature(TlsUtils.readOpaque16(inputStream))) {
            throw new TlsFatalAlert((short) 42);
        }
        BigInteger bigInteger = new BigInteger(1, readOpaque16);
        BigInteger bigInteger2 = new BigInteger(1, readOpaque162);
        this.f6074s = readOpaque8;
        try {
            this.f6073B = SRP6Util.validatePublicValue(bigInteger, new BigInteger(1, readOpaque163));
            this.srpClient.init(bigInteger, bigInteger2, new SHA1Digest(), this.context.getSecureRandom());
        } catch (CryptoException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipClientCredentials() {
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerCertificate() {
        if (this.tlsSigner != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerKeyExchange() {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) {
        throw new TlsFatalAlert((short) 10);
    }
}
