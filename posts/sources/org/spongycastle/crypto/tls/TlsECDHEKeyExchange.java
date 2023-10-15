package org.spongycastle.crypto.tls;

import java.io.InputStream;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.p013io.SignerInputStream;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsECDHEKeyExchange extends TlsECDHKeyExchange {
    public TlsECDHEKeyExchange(TlsClientContext tlsClientContext, int i) {
        super(tlsClientContext, i);
    }

    public Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner.createVerifyer(this.serverPublicKey);
        byte[] bArr = securityParameters.clientRandom;
        createVerifyer.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.serverRandom;
        createVerifyer.update(bArr2, 0, bArr2.length);
        return createVerifyer;
    }

    @Override // org.spongycastle.crypto.tls.TlsECDHKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) {
        if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsECDHKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) {
        Signer initSigner = initSigner(this.tlsSigner, this.context.getSecurityParameters());
        SignerInputStream signerInputStream = new SignerInputStream(inputStream, initSigner);
        if (TlsUtils.readUint8(signerInputStream) == 3) {
            ECDomainParameters eCParameters = NamedCurve.getECParameters(TlsUtils.readUint16(signerInputStream));
            byte[] readOpaque8 = TlsUtils.readOpaque8(signerInputStream);
            if (initSigner.verifySignature(TlsUtils.readOpaque16(inputStream))) {
                this.ecAgreeServerPublicKey = validateECPublicKey(new ECPublicKeyParameters(eCParameters.getCurve().decodePoint(readOpaque8), eCParameters));
                return;
            }
            throw new TlsFatalAlert((short) 42);
        }
        throw new TlsFatalAlert((short) 40);
    }

    @Override // org.spongycastle.crypto.tls.TlsECDHKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerKeyExchange() {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsECDHKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) {
        short[] certificateTypes;
        for (short s : certificateRequest.getCertificateTypes()) {
            if (s != 1 && s != 2 && s != 64) {
                throw new TlsFatalAlert((short) 47);
            }
        }
    }
}
