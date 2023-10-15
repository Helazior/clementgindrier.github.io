package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.BigIntegers;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsECDHKeyExchange implements TlsKeyExchange {
    public TlsAgreementCredentials agreementCredentials;
    public TlsClientContext context;
    public ECPrivateKeyParameters ecAgreeClientPrivateKey = null;
    public ECPublicKeyParameters ecAgreeServerPublicKey;
    public int keyExchange;
    public AsymmetricKeyParameter serverPublicKey;
    public TlsSigner tlsSigner;

    public TlsECDHKeyExchange(TlsClientContext tlsClientContext, int i) {
        switch (i) {
            case 16:
            case 18:
                this.tlsSigner = null;
                break;
            case 17:
                this.tlsSigner = new TlsECDSASigner();
                break;
            case 19:
                this.tlsSigner = new TlsRSASigner();
                break;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.context = tlsClientContext;
        this.keyExchange = i;
    }

    public boolean areOnSameCurve(ECDomainParameters eCDomainParameters, ECDomainParameters eCDomainParameters2) {
        return eCDomainParameters.getCurve().equals(eCDomainParameters2.getCurve()) && eCDomainParameters.getG().equals(eCDomainParameters2.getG()) && eCDomainParameters.getN().equals(eCDomainParameters2.getN()) && eCDomainParameters.getH().equals(eCDomainParameters2.getH());
    }

    public byte[] calculateECDHBasicAgreement(ECPublicKeyParameters eCPublicKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters) {
        ECDHBasicAgreement eCDHBasicAgreement = new ECDHBasicAgreement();
        eCDHBasicAgreement.init(eCPrivateKeyParameters);
        return BigIntegers.asUnsignedByteArray(eCDHBasicAgreement.calculateAgreement(eCPublicKeyParameters));
    }

    public byte[] externalizeKey(ECPublicKeyParameters eCPublicKeyParameters) {
        return eCPublicKeyParameters.getQ().getEncoded();
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) {
        if (this.agreementCredentials == null) {
            generateEphemeralClientKeyExchange(this.ecAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    public AsymmetricCipherKeyPair generateECKeyPair(ECDomainParameters eCDomainParameters) {
        ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
        eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCDomainParameters, this.context.getSecureRandom()));
        return eCKeyPairGenerator.generateKeyPair();
    }

    public void generateEphemeralClientKeyExchange(ECDomainParameters eCDomainParameters, OutputStream outputStream) {
        AsymmetricCipherKeyPair generateECKeyPair = generateECKeyPair(eCDomainParameters);
        this.ecAgreeClientPrivateKey = (ECPrivateKeyParameters) generateECKeyPair.getPrivate();
        TlsUtils.writeOpaque8(externalizeKey((ECPublicKeyParameters) generateECKeyPair.getPublic()), outputStream);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.ecAgreeServerPublicKey);
        }
        return calculateECDHBasicAgreement(this.ecAgreeServerPublicKey, this.ecAgreeClientPrivateKey);
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
                    this.ecAgreeServerPublicKey = validateECPublicKey((ECPublicKeyParameters) createKey);
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
            if (s != 1 && s != 2) {
                switch (s) {
                    case 64:
                    case 65:
                    case 66:
                        break;
                    default:
                        throw new TlsFatalAlert((short) 47);
                }
            }
        }
    }

    public ECPublicKeyParameters validateECPublicKey(ECPublicKeyParameters eCPublicKeyParameters) {
        return eCPublicKeyParameters;
    }
}
