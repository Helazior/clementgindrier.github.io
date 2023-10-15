package org.spongycastle.crypto.tls;

import java.util.Hashtable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TlsClient {
    TlsAuthentication getAuthentication();

    TlsCipher getCipher();

    int[] getCipherSuites();

    Hashtable getClientExtensions();

    ProtocolVersion getClientVersion();

    TlsCompression getCompression();

    short[] getCompressionMethods();

    TlsKeyExchange getKeyExchange();

    void init(TlsClientContext tlsClientContext);

    void notifySecureRenegotiation(boolean z);

    void notifySelectedCipherSuite(int i);

    void notifySelectedCompressionMethod(short s);

    void notifyServerVersion(ProtocolVersion protocolVersion);

    void notifySessionID(byte[] bArr);

    void processServerExtensions(Hashtable hashtable);
}
