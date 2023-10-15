package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void flushBuffer() {
        int i = this.index;
        if (i > 0) {
            this.out.write(this.buffer, 0, i);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        maybeFlushBuffer();
    }

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.out = outputStream;
        this.arrayPool = arrayPool;
        this.buffer = (byte[]) arrayPool.get(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.index;
            if (i6 == 0 && i4 >= this.buffer.length) {
                this.out.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.buffer.length - i6);
            System.arraycopy(bArr, i5, this.buffer, this.index, min);
            this.index += min;
            i3 += min;
            maybeFlushBuffer();
        } while (i3 < i2);
    }
}
