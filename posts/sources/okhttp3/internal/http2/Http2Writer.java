package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final C1946ke hpackBuffer;
    public final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final InterfaceC1966le sink;

    public Http2Writer(InterfaceC1966le interfaceC1966le, boolean z) {
        this.sink = interfaceC1966le;
        this.client = z;
        C1946ke c1946ke = new C1946ke();
        this.hpackBuffer = c1946ke;
        this.hpackWriter = new Hpack.Writer(c1946ke);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.maxFrameSize, j);
            long j2 = min;
            j -= j2;
            frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }

    private static void writeMedium(InterfaceC1966le interfaceC1966le, int i) {
        interfaceC1966le.mo142n((i >>> 16) & 255);
        interfaceC1966le.mo142n((i >>> 8) & 255);
        interfaceC1966le.mo142n(i & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() {
        if (!this.closed) {
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.mo555h()));
                }
                this.sink.mo141p(Http2.CONNECTION_PREFACE.mo547p());
                this.sink.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public synchronized void data(boolean z, int i, C1946ke c1946ke, int i2) {
        if (!this.closed) {
            dataFrame(i, z ? (byte) 1 : (byte) 0, c1946ke, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public void dataFrame(int i, byte b, C1946ke c1946ke, int i2) {
        frameHeader(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.sink.write(c1946ke, i2);
        }
    }

    public synchronized void flush() {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void frameHeader(int i, int i2, byte b, byte b2) {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i, i2, b, b2));
        }
        int i3 = this.maxFrameSize;
        if (i2 > i3) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
        }
        writeMedium(this.sink, i2);
        this.sink.mo142n(b & 255);
        this.sink.mo142n(b2 & 255);
        this.sink.mo143i(i & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) {
        if (!this.closed) {
            if (errorCode.httpCode != -1) {
                frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.sink.mo143i(i);
                this.sink.mo143i(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.mo141p(bArr);
                }
                this.sink.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void headers(int i, List<Header> list) {
        if (!this.closed) {
            headers(false, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z, int i, int i2) {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.sink.mo143i(i);
            this.sink.mo143i(i2);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void pushPromise(int i, int i2, List<Header> list) {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long j = this.hpackBuffer.f5398b;
            int min = (int) Math.min(this.maxFrameSize - 4, j);
            long j2 = min;
            int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            frameHeader(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
            this.sink.mo143i(i2 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j2);
            if (i3 > 0) {
                writeContinuationFrames(i, j - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int i, ErrorCode errorCode) {
        if (!this.closed) {
            if (errorCode.httpCode != -1) {
                frameHeader(i, 4, (byte) 3, (byte) 0);
                this.sink.mo143i(errorCode.httpCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void settings(Settings settings) {
        if (!this.closed) {
            int i = 0;
            frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.isSet(i)) {
                    this.sink.mo144g(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.sink.mo143i(settings.get(i));
                }
                i++;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synReply(boolean z, int i, List<Header> list) {
        if (!this.closed) {
            headers(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synStream(boolean z, int i, int i2, List<Header> list) {
        if (!this.closed) {
            headers(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void windowUpdate(int i, long j) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            frameHeader(i, 4, (byte) 8, (byte) 0);
            this.sink.mo143i((int) j);
            this.sink.flush();
        } else {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
    }

    public void headers(boolean z, int i, List<Header> list) {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long j = this.hpackBuffer.f5398b;
            int min = (int) Math.min(this.maxFrameSize, j);
            long j2 = min;
            int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            frameHeader(i, min, (byte) 1, b);
            this.sink.write(this.hpackBuffer, j2);
            if (i2 > 0) {
                writeContinuationFrames(i, j - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
