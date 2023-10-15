package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsPSKKeyExchange implements TlsKeyExchange {
    public TlsClientContext context;
    public int keyExchange;
    public byte[] premasterSecret;
    public TlsPSKIdentity pskIdentity;
    public byte[] psk_identity_hint = null;
    public DHPublicKeyParameters dhAgreeServerPublicKey = null;
    public DHPrivateKeyParameters dhAgreeClientPrivateKey = null;
    public RSAKeyParameters rsaServerPublicKey = null;

    public TlsPSKKeyExchange(TlsClientContext tlsClientContext, int i, TlsPSKIdentity tlsPSKIdentity) {
        switch (i) {
            case 13:
            case 14:
            case 15:
                this.context = tlsClientContext;
                this.keyExchange = i;
                this.pskIdentity = tlsPSKIdentity;
                return;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) {
        byte[] bArr = this.psk_identity_hint;
        if (bArr != null && bArr.length != 0) {
            this.pskIdentity.notifyIdentityHint(bArr);
        } else {
            this.pskIdentity.skipIdentityHint();
        }
        TlsUtils.writeOpaque16(this.pskIdentity.getPSKIdentity(), outputStream);
        int i = this.keyExchange;
        if (i == 15) {
            this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, outputStream);
        } else if (i == 14) {
            this.dhAgreeClientPrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    public byte[] generateOtherSecret(int i) {
        int i2 = this.keyExchange;
        if (i2 == 14) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreeServerPublicKey, this.dhAgreeClientPrivateKey);
        }
        if (i2 == 15) {
            return this.premasterSecret;
        }
        return new byte[i];
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() {
        byte[] psk = this.pskIdentity.getPSK();
        byte[] generateOtherSecret = generateOtherSecret(psk.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(generateOtherSecret.length + 4 + psk.length);
        TlsUtils.writeOpaque16(generateOtherSecret, byteArrayOutputStream);
        TlsUtils.writeOpaque16(psk, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) {
        byte[] readOpaque16 = TlsUtils.readOpaque16(inputStream);
        this.psk_identity_hint = readOpaque16;
        if (this.keyExchange == 14) {
            byte[] readOpaque162 = TlsUtils.readOpaque16(inputStream);
            byte[] readOpaque163 = TlsUtils.readOpaque16(inputStream);
            this.dhAgreeServerPublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(new BigInteger(1, TlsUtils.readOpaque16(inputStream)), new DHParameters(new BigInteger(1, readOpaque162), new BigInteger(1, readOpaque163))));
            return;
        }
        int length = readOpaque16.length;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipClientCredentials() {
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerCertificate() {
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerKeyExchange() {
        this.psk_identity_hint = new byte[0];
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) {
        throw new TlsFatalAlert((short) 10);
    }
}
