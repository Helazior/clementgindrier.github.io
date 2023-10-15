package org.spongycastle.crypto.tls;

import java.security.SecureRandom;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TlsClientContext {
    ProtocolVersion getClientVersion();

    SecureRandom getSecureRandom();

    SecurityParameters getSecurityParameters();

    ProtocolVersion getServerVersion();

    Object getUserObject();

    void setUserObject(Object obj);
}
