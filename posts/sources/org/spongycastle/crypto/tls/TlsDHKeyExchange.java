package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsDHKeyExchange implements TlsKeyExchange {
    public static final BigInteger ONE = BigInteger.valueOf(1);
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public TlsAgreementCredentials agreementCredentials;
    public TlsClientContext context;
    public int keyExchange;
    public TlsSigner tlsSigner;
    public AsymmetricKeyParameter serverPublicKey = null;
    public DHPublicKeyParameters dhAgreeServerPublicKey = null;
    public DHPrivateKeyParameters dhAgreeClientPrivateKey = null;

    public TlsDHKeyExchange(TlsClientContext tlsClientContext, int i) {
        if (i == 3) {
            this.tlsSigner = new TlsDSSSigner();
        } else if (i == 5) {
            this.tlsSigner = new TlsRSASigner();
        } else if (i != 7 && i != 9) {
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        } else {
            this.tlsSigner = null;
        }
        this.context = tlsClientContext;
        this.keyExchange = i;
    }

    public boolean areCompatibleParameters(DHParameters dHParameters, DHParameters dHParameters2) {
        return dHParameters.getP().equals(dHParameters2.getP()) && dHParameters.getG().equals(dHParameters2.getG());
    }

    public byte[] calculateDHBasicAgreement(DHPublicKeyParameters dHPublicKeyParameters, DHPrivateKeyParameters dHPrivateKeyParameters) {
        return TlsDHUtils.calculateDHBasicAgreement(dHPublicKeyParameters, dHPrivateKeyParameters);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) {
        if (this.agreementCredentials == null) {
            generateEphemeralClientKeyExchange(this.dhAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    public AsymmetricCipherKeyPair generateDHKeyPair(DHParameters dHParameters) {
        return TlsDHUtils.generateDHKeyPair(this.context.getSecureRandom(), dHParameters);
    }

    public void generateEphemeralClientKeyExchange(DHParameters dHParameters, OutputStream outputStream) {
        this.dhAgreeClientPrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), dHParameters, outputStream);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.dhAgreeServerPublicKey);
        }
        return calculateDHBasicAgreement(this.dhAgreeServerPublicKey, this.dhAgreeClientPrivateKey);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) {
        X509CertificateStructure x509CertificateStructure = certificate.certs[0];
        try {
            AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(x509CertificateStructure.getSubjectPublicKeyInfo());
            this.serverPublicKey = createKey;
            TlsSigner tlsSigner = this.tlsSigner;
            if (tlsSigner == null) {
                try {
                    this.dhAgreeServerPublicKey = validateDHPublicKey((DHPublicKeyParameters) createKey);
                    TlsUtils.validateKeyUsage(x509CertificateStructure, 8);
                } catch (ClassCastException unused) {
                    throw new TlsFatalAlert((short) 46);
                }
            } else if (tlsSigner.isValidPublicKey(createKey)) {
                TlsUtils.validateKeyUsage(x509CertificateStructure, 128);
            } else {
                throw new TlsFatalAlert((short) 46);
            }
        } catch (RuntimeException unused2) {
            throw new TlsFatalAlert((short) 43);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipClientCredentials() {
        this.agreementCredentials = null;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerCertificate() {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerKeyExchange() {
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) {
        short[] certificateTypes;
        for (short s : certificateRequest.getCertificateTypes()) {
            if (s != 1 && s != 2 && s != 3 && s != 4 && s != 64) {
                throw new TlsFatalAlert((short) 47);
            }
        }
    }

    public DHPublicKeyParameters validateDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        return TlsDHUtils.validateDHPublicKey(dHPublicKeyParameters);
    }
}
