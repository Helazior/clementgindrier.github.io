package org.spongycastle.crypto.p013io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.StreamCipher;

/* renamed from: org.spongycastle.crypto.io.CipherInputStream */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CipherInputStream extends FilterInputStream {
    private static final int INPUT_BUF_SIZE = 2048;
    private byte[] buf;
    private int bufOff;
    private BufferedBlockCipher bufferedBlockCipher;
    private boolean finalized;
    private byte[] inBuf;
    private int maxBuf;
    private StreamCipher streamCipher;

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(inputStream);
        this.bufferedBlockCipher = bufferedBlockCipher;
        this.buf = new byte[bufferedBlockCipher.getOutputSize(2048)];
        this.inBuf = new byte[2048];
    }

    private int nextChunk() {
        int read;
        int available = super.available();
        if (available <= 0) {
            available = 1;
        }
        byte[] bArr = this.inBuf;
        if (available > bArr.length) {
            read = super.read(bArr, 0, bArr.length);
        } else {
            read = super.read(bArr, 0, available);
        }
        if (read < 0) {
            if (this.finalized) {
                return -1;
            }
            try {
                BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
                if (bufferedBlockCipher != null) {
                    this.maxBuf = bufferedBlockCipher.doFinal(this.buf, 0);
                } else {
                    this.maxBuf = 0;
                }
                this.bufOff = 0;
                this.finalized = true;
                if (this.maxBuf == 0) {
                    return -1;
                }
            } catch (Exception e) {
                throw new IOException(outline.m275F(e, outline.m253r("error processing stream: ")));
            }
        } else {
            this.bufOff = 0;
            try {
                BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
                if (bufferedBlockCipher2 != null) {
                    this.maxBuf = bufferedBlockCipher2.processBytes(this.inBuf, 0, read, this.buf, 0);
                } else {
                    this.streamCipher.processBytes(this.inBuf, 0, read, this.buf, 0);
                    this.maxBuf = read;
                }
                if (this.maxBuf == 0) {
                    return nextChunk();
                }
            } catch (Exception e2) {
                throw new IOException(outline.m275F(e2, outline.m253r("error processing stream: ")));
            }
        }
        return this.maxBuf;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.maxBuf - this.bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.bufOff != this.maxBuf || nextChunk() >= 0) {
            byte[] bArr = this.buf;
            int i = this.bufOff;
            this.bufOff = i + 1;
            return bArr[i] & 255;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        if (j <= 0) {
            return 0L;
        }
        int i = this.maxBuf;
        int i2 = this.bufOff;
        long j2 = i - i2;
        if (j > j2) {
            this.bufOff = i;
            return j2;
        }
        int i3 = (int) j;
        this.bufOff = i2 + i3;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher) {
        super(inputStream);
        this.streamCipher = streamCipher;
        this.buf = new byte[2048];
        this.inBuf = new byte[2048];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.bufOff != this.maxBuf || nextChunk() >= 0) {
            int i3 = this.maxBuf;
            int i4 = this.bufOff;
            int i5 = i3 - i4;
            if (i2 > i5) {
                System.arraycopy(this.buf, i4, bArr, i, i5);
                this.bufOff = this.maxBuf;
                return i5;
            }
            System.arraycopy(this.buf, i4, bArr, i, i2);
            this.bufOff += i2;
            return i2;
        }
        return -1;
    }
}
