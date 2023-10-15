package org.spongycastle.crypto.tls;

import java.security.SecureRandom;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsClientContextImpl implements TlsClientContext {
    private SecureRandom secureRandom;
    private SecurityParameters securityParameters;
    private ProtocolVersion clientVersion = null;
    private ProtocolVersion serverVersion = null;
    private Object userObject = null;

    public TlsClientContextImpl(SecureRandom secureRandom, SecurityParameters securityParameters) {
        this.secureRandom = secureRandom;
        this.securityParameters = securityParameters;
    }

    @Override // org.spongycastle.crypto.tls.TlsClientContext
    public ProtocolVersion getClientVersion() {
        return this.clientVersion;
    }

    @Override // org.spongycastle.crypto.tls.TlsClientContext
    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }

    @Override // org.spongycastle.crypto.tls.TlsClientContext
    public SecurityParameters getSecurityParameters() {
        return this.securityParameters;
    }

    @Override // org.spongycastle.crypto.tls.TlsClientContext
    public ProtocolVersion getServerVersion() {
        return this.serverVersion;
    }

    @Override // org.spongycastle.crypto.tls.TlsClientContext
    public Object getUserObject() {
        return this.userObject;
    }

    public void setClientVersion(ProtocolVersion protocolVersion) {
        this.clientVersion = protocolVersion;
    }

    public void setServerVersion(ProtocolVersion protocolVersion) {
        this.serverVersion = protocolVersion;
    }

    @Override // org.spongycastle.crypto.tls.TlsClientContext
    public void setUserObject(Object obj) {
        this.userObject = obj;
    }
}
