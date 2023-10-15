package org.spongycastle.crypto.tls;

import java.util.Hashtable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PSKTlsClient implements TlsClient {
    public TlsCipherFactory cipherFactory;
    public TlsClientContext context;
    public TlsPSKIdentity pskIdentity;
    public int selectedCipherSuite;
    public int selectedCompressionMethod;

    public PSKTlsClient(TlsPSKIdentity tlsPSKIdentity) {
        this(new DefaultTlsCipherFactory(), tlsPSKIdentity);
    }

    public TlsKeyExchange createPSKKeyExchange(int i) {
        return new TlsPSKKeyExchange(this.context, i, this.pskIdentity);
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public TlsAuthentication getAuthentication() {
        return null;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public TlsCipher getCipher() {
        switch (this.selectedCipherSuite) {
            case CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA /* 139 */:
            case CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA /* 143 */:
            case CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA /* 147 */:
                return this.cipherFactory.createCipher(this.context, 7, 2);
            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA /* 140 */:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA /* 144 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA /* 148 */:
                return this.cipherFactory.createCipher(this.context, 8, 2);
            case CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA /* 141 */:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA /* 145 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA /* 149 */:
                return this.cipherFactory.createCipher(this.context, 9, 2);
            case CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA /* 142 */:
            case CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA /* 146 */:
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public int[] getCipherSuites() {
        return new int[]{CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA};
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public Hashtable getClientExtensions() {
        return null;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public ProtocolVersion getClientVersion() {
        return ProtocolVersion.TLSv10;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public TlsCompression getCompression() {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public TlsKeyExchange getKeyExchange() {
        switch (this.selectedCipherSuite) {
            case CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA /* 139 */:
            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA /* 140 */:
            case CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA /* 141 */:
                return createPSKKeyExchange(13);
            case CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA /* 142 */:
            case CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA /* 146 */:
            default:
                throw new TlsFatalAlert((short) 80);
            case CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA /* 143 */:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA /* 144 */:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA /* 145 */:
                return createPSKKeyExchange(14);
            case CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA /* 147 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA /* 148 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA /* 149 */:
                return createPSKKeyExchange(15);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void notifySecureRenegotiation(boolean z) {
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void notifySelectedCipherSuite(int i) {
        this.selectedCipherSuite = i;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void notifySelectedCompressionMethod(short s) {
        this.selectedCompressionMethod = s;
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void notifyServerVersion(ProtocolVersion protocolVersion) {
        if (!ProtocolVersion.TLSv10.equals(protocolVersion)) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void notifySessionID(byte[] bArr) {
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public void processServerExtensions(Hashtable hashtable) {
    }

    public PSKTlsClient(TlsCipherFactory tlsCipherFactory, TlsPSKIdentity tlsPSKIdentity) {
        this.cipherFactory = tlsCipherFactory;
        this.pskIdentity = tlsPSKIdentity;
    }
}
