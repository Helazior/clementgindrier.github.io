package org.spongycastle.crypto.tls;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LegacyTlsClient extends DefaultTlsClient {
    public CertificateVerifyer verifyer;

    public LegacyTlsClient(CertificateVerifyer certificateVerifyer) {
        this.verifyer = certificateVerifyer;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public TlsAuthentication getAuthentication() {
        return new LegacyTlsAuthentication(this.verifyer);
    }
}
