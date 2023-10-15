package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class MarkableInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_LIMIT_INCREMENT = 1024;
    private boolean allowExpire;
    private long defaultMark;

    /* renamed from: in */
    private final InputStream f3935in;
    private long limit;
    private int limitIncrement;
    private long offset;
    private long reset;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void setLimit(long j) {
        try {
            long j2 = this.reset;
            long j3 = this.offset;
            if (j2 < j3 && j3 <= this.limit) {
                this.f3935in.reset();
                this.f3935in.mark((int) (j - this.reset));
                skip(this.reset, this.offset);
            } else {
                this.reset = j3;
                this.f3935in.mark((int) (j - j3));
            }
            this.limit = j;
        } catch (IOException e) {
            throw new IllegalStateException(outline.m268c("Unable to mark: ", e));
        }
    }

    private void skip(long j, long j2) {
        while (j < j2) {
            long skip = this.f3935in.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                }
                skip = 1;
            }
            j += skip;
        }
    }

    public void allowMarksToExpire(boolean z) {
        this.allowExpire = z;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f3935in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3935in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.defaultMark = savePosition(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f3935in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.allowExpire) {
            long j = this.limit;
            if (this.offset + 1 > j) {
                setLimit(j + this.limitIncrement);
            }
        }
        int read = this.f3935in.read();
        if (read != -1) {
            this.offset++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() {
        reset(this.defaultMark);
    }

    public long savePosition(int i) {
        long j = this.offset + i;
        if (this.limit < j) {
            setLimit(j);
        }
        return this.offset;
    }

    public MarkableInputStream(InputStream inputStream, int i) {
        this(inputStream, i, 1024);
    }

    public void reset(long j) {
        if (this.offset <= this.limit && j >= this.reset) {
            this.f3935in.reset();
            skip(this.reset, j);
            this.offset = j;
            return;
        }
        throw new IOException("Cannot reset");
    }

    private MarkableInputStream(InputStream inputStream, int i, int i2) {
        this.defaultMark = -1L;
        this.allowExpire = true;
        this.limitIncrement = -1;
        this.f3935in = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
        this.limitIncrement = i2;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        if (!this.allowExpire) {
            long j2 = this.offset;
            if (j2 + j > this.limit) {
                setLimit(j2 + j + this.limitIncrement);
            }
        }
        long skip = this.f3935in.skip(j);
        this.offset += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        if (!this.allowExpire) {
            long j = this.offset;
            if (bArr.length + j > this.limit) {
                setLimit(j + bArr.length + this.limitIncrement);
            }
        }
        int read = this.f3935in.read(bArr);
        if (read != -1) {
            this.offset += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (!this.allowExpire) {
            long j = this.offset;
            long j2 = i2;
            if (j + j2 > this.limit) {
                setLimit(j + j2 + this.limitIncrement);
            }
        }
        int read = this.f3935in.read(bArr, i, i2);
        if (read != -1) {
            this.offset += read;
        }
        return read;
    }
}
