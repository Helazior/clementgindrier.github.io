package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.util.BigIntegers;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DefaultTlsAgreementCredentials implements TlsAgreementCredentials {
    public BasicAgreement basicAgreement;
    public Certificate clientCert;
    public AsymmetricKeyParameter clientPrivateKey;

    public DefaultTlsAgreementCredentials(Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate != null) {
            if (certificate.certs.length == 0) {
                throw new IllegalArgumentException("'clientCertificate' cannot be empty");
            }
            if (asymmetricKeyParameter != null) {
                if (asymmetricKeyParameter.isPrivate()) {
                    if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
                        this.basicAgreement = new DHBasicAgreement();
                    } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                        this.basicAgreement = new ECDHBasicAgreement();
                    } else {
                        StringBuilder m253r = outline.m253r("'clientPrivateKey' type not supported: ");
                        m253r.append(asymmetricKeyParameter.getClass().getName());
                        throw new IllegalArgumentException(m253r.toString());
                    }
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

    @Override // org.spongycastle.crypto.tls.TlsAgreementCredentials
    public byte[] generateAgreement(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.basicAgreement.init(this.clientPrivateKey);
        return BigIntegers.asUnsignedByteArray(this.basicAgreement.calculateAgreement(asymmetricKeyParameter));
    }

    @Override // org.spongycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.clientCert;
    }
}
