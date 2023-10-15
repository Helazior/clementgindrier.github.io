package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DefaultTlsSignerCredentials implements TlsSignerCredentials {
    public Certificate clientCert;
    public AsymmetricKeyParameter clientPrivateKey;
    public TlsSigner clientSigner;
    public TlsClientContext context;

    public DefaultTlsSignerCredentials(TlsClientContext tlsClientContext, Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate != null) {
            if (certificate.certs.length == 0) {
                throw new IllegalArgumentException("'clientCertificate' cannot be empty");
            }
            if (asymmetricKeyParameter != null) {
                if (asymmetricKeyParameter.isPrivate()) {
                    if (asymmetricKeyParameter instanceof RSAKeyParameters) {
                        this.clientSigner = new TlsRSASigner();
                    } else if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
                        this.clientSigner = new TlsDSSSigner();
                    } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                        this.clientSigner = new TlsECDSASigner();
                    } else {
                        StringBuilder m253r = outline.m253r("'clientPrivateKey' type not supported: ");
                        m253r.append(asymmetricKeyParameter.getClass().getName());
                        throw new IllegalArgumentException(m253r.toString());
                    }
                    this.context = tlsClientContext;
                    this.clientCert = certificate;
                    this.clientPrivateKey = asymmetricKeyParameter;
                    return;
                }
                throw new IllegalArgumentException("'clientPrivateKey' must be private");
            }
            throw new IllegalArgumentException("'clientPrivateKey' cannot be null");
        }
        throw new IllegalArgumentException("'clientCertificate' cannot be null");
    }

    @Override // org.spongycastle.crypto.tls.TlsSignerCredentials
    public byte[] generateCertificateSignature(byte[] bArr) {
        try {
            return this.clientSigner.calculateRawSignature(this.context.getSecureRandom(), this.clientPrivateKey, bArr);
        } catch (CryptoException unused) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.clientCert;
    }
}
