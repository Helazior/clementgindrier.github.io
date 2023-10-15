package org.spongycastle.crypto.tls;

import java.io.InputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsInputStream extends InputStream {
    private byte[] buf = new byte[1];
    private TlsProtocolHandler handler;

    public TlsInputStream(TlsProtocolHandler tlsProtocolHandler) {
        this.handler = null;
        this.handler = tlsProtocolHandler;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.handler.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.handler.readApplicationData(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.buf) < 0) {
            return -1;
        }
        return this.buf[0] & 255;
    }
}
