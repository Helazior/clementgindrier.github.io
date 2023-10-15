package org.kobjects.p008io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.kobjects.io.BoundInputStream */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BoundInputStream extends InputStream {

    /* renamed from: is */
    public InputStream f5631is;
    public int remaining;

    public BoundInputStream(InputStream inputStream, int i) {
        this.f5631is = inputStream;
        this.remaining = i;
    }

    @Override // java.io.InputStream
    public int available() {
        int available = this.f5631is.available();
        int i = this.remaining;
        return available < i ? available : i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f5631is.close();
        } catch (IOException unused) {
        }
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.remaining;
        if (i <= 0) {
            return -1;
        }
        this.remaining = i - 1;
        return this.f5631is.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = this.remaining;
        if (i2 > i3) {
            i2 = i3;
        }
        int read = this.f5631is.read(bArr, i, i2);
        if (read > 0) {
            this.remaining -= read;
        }
        return read;
    }
}
