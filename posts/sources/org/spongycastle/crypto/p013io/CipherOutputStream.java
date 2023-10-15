package org.spongycastle.crypto.p013io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.StreamCipher;

/* renamed from: org.spongycastle.crypto.io.CipherOutputStream */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CipherOutputStream extends FilterOutputStream {
    private byte[] buf;
    private BufferedBlockCipher bufferedBlockCipher;
    private byte[] oneByte;
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.bufferedBlockCipher = bufferedBlockCipher;
        this.buf = new byte[bufferedBlockCipher.getBlockSize()];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        byte[] bArr;
        int doFinal;
        try {
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null && (doFinal = this.bufferedBlockCipher.doFinal((bArr = new byte[bufferedBlockCipher.getOutputSize(0)]), 0)) != 0) {
                ((FilterOutputStream) this).out.write(bArr, 0, doFinal);
            }
            flush();
            super.close();
        } catch (Exception e) {
            throw new IOException(outline.m275F(e, outline.m253r("Error closing stream: ")));
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        super.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.oneByte;
        byte b = (byte) i;
        bArr[0] = b;
        BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
        if (bufferedBlockCipher != null) {
            int processBytes = bufferedBlockCipher.processBytes(bArr, 0, 1, this.buf, 0);
            if (processBytes != 0) {
                ((FilterOutputStream) this).out.write(this.buf, 0, processBytes);
                return;
            }
            return;
        }
        ((FilterOutputStream) this).out.write(this.streamCipher.returnByte(b));
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.streamCipher = streamCipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
        if (bufferedBlockCipher != null) {
            byte[] bArr2 = new byte[bufferedBlockCipher.getOutputSize(i2)];
            int processBytes = this.bufferedBlockCipher.processBytes(bArr, i, i2, bArr2, 0);
            if (processBytes != 0) {
                ((FilterOutputStream) this).out.write(bArr2, 0, processBytes);
                return;
            }
            return;
        }
        byte[] bArr3 = new byte[i2];
        this.streamCipher.processBytes(bArr, i, i2, bArr3, 0);
        ((FilterOutputStream) this).out.write(bArr3, 0, i2);
    }
}
