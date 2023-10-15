package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TlsKeyExchange {
    void generateClientKeyExchange(OutputStream outputStream);

    byte[] generatePremasterSecret();

    void processClientCredentials(TlsCredentials tlsCredentials);

    void processServerCertificate(Certificate certificate);

    void processServerKeyExchange(InputStream inputStream);

    void skipClientCredentials();

    void skipServerCertificate();

    void skipServerKeyExchange();

    void validateCertificateRequest(CertificateRequest certificateRequest);
}
