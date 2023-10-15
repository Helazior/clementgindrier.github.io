package org.spongycastle.crypto.tls;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LegacyTlsAuthentication implements TlsAuthentication {
    public CertificateVerifyer verifyer;

    public LegacyTlsAuthentication(CertificateVerifyer certificateVerifyer) {
        this.verifyer = certificateVerifyer;
    }

    @Override // org.spongycastle.crypto.tls.TlsAuthentication
    public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) {
        return null;
    }

    @Override // org.spongycastle.crypto.tls.TlsAuthentication
    public void notifyServerCertificate(Certificate certificate) {
        if (!this.verifyer.isValid(certificate.getCerts())) {
            throw new TlsFatalAlert((short) 90);
        }
    }
}
