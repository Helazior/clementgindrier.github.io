package okhttp3.internal.p007ws;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import p000.C1946ke;

/* renamed from: okhttp3.internal.ws.WebSocketWriter */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class WebSocketWriter {
    public boolean activeWriter;
    public final C1946ke buffer = new C1946ke();
    public final FrameSink frameSink = new FrameSink();
    public final boolean isClient;
    private final C1946ke.C1948b maskCursor;
    private final byte[] maskKey;
    public final Random random;
    public final InterfaceC1966le sink;
    public final C1946ke sinkBuffer;
    public boolean writerClosed;

    /* renamed from: okhttp3.internal.ws.WebSocketWriter$FrameSink */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class FrameSink implements InterfaceC0050Be {
        public boolean closed;
        public long contentLength;
        public int formatOpcode;
        public boolean isFirstFrame;

        public FrameSink() {
        }

        @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f5398b, this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException("closed");
        }

        @Override // p000.InterfaceC0050Be, java.io.Flushable
        public void flush() {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f5398b, this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        @Override // p000.InterfaceC0050Be
        public C0097De timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // p000.InterfaceC0050Be
        public void write(C1946ke c1946ke, long j) {
            boolean z;
            long m674G;
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(c1946ke, j);
                if (this.isFirstFrame) {
                    long j2 = this.contentLength;
                    if (j2 != -1 && WebSocketWriter.this.buffer.f5398b > j2 - 8192) {
                        z = true;
                        m674G = WebSocketWriter.this.buffer.m674G();
                        if (m674G > 0 || z) {
                            return;
                        }
                        WebSocketWriter.this.writeMessageFrame(this.formatOpcode, m674G, this.isFirstFrame, false);
                        this.isFirstFrame = false;
                        return;
                    }
                }
                z = false;
                m674G = WebSocketWriter.this.buffer.m674G();
                if (m674G > 0) {
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    public WebSocketWriter(boolean z, InterfaceC1966le interfaceC1966le, Random random) {
        Objects.requireNonNull(interfaceC1966le, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.isClient = z;
        this.sink = interfaceC1966le;
        this.sinkBuffer = interfaceC1966le.mo91a();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new C1946ke.C1948b() : null;
    }

    private void writeControlFrame(int i, C2011ne c2011ne) {
        if (!this.writerClosed) {
            int mo550m = c2011ne.mo550m();
            if (mo550m <= 125) {
                this.sinkBuffer.m660U(i | 128);
                if (this.isClient) {
                    this.sinkBuffer.m660U(mo550m | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.m662S(this.maskKey);
                    if (mo550m > 0) {
                        C1946ke c1946ke = this.sinkBuffer;
                        long j = c1946ke.f5398b;
                        c1946ke.m663R(c2011ne);
                        this.sinkBuffer.m669L(this.maskCursor);
                        this.maskCursor.m650E(j);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.m660U(mo550m);
                    this.sinkBuffer.m663R(c2011ne);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    public InterfaceC0050Be newMessageSink(int i, long j) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink = this.frameSink;
            frameSink.formatOpcode = i;
            frameSink.contentLength = j;
            frameSink.isFirstFrame = true;
            frameSink.closed = false;
            return frameSink;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public void writeClose(int i, C2011ne c2011ne) {
        C2011ne c2011ne2 = C2011ne.f5561f;
        if (i != 0 || c2011ne != null) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            C1946ke c1946ke = new C1946ke();
            c1946ke.m655Z(i);
            if (c2011ne != null) {
                c1946ke.m663R(c2011ne);
            }
            c2011ne2 = c1946ke.m668M();
        }
        try {
            writeControlFrame(8, c2011ne2);
        } finally {
            this.writerClosed = true;
        }
    }

    public void writeMessageFrame(int i, long j, boolean z, boolean z2) {
        if (!this.writerClosed) {
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.sinkBuffer.m660U(i);
            int i2 = this.isClient ? 128 : 0;
            if (j <= 125) {
                this.sinkBuffer.m660U(((int) j) | i2);
            } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.m660U(i2 | 126);
                this.sinkBuffer.m655Z((int) j);
            } else {
                this.sinkBuffer.m660U(i2 | 127);
                this.sinkBuffer.m656Y(j);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.m662S(this.maskKey);
                if (j > 0) {
                    C1946ke c1946ke = this.sinkBuffer;
                    long j2 = c1946ke.f5398b;
                    c1946ke.write(this.buffer, j);
                    this.sinkBuffer.m669L(this.maskCursor);
                    this.maskCursor.m650E(j2);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j);
            }
            this.sink.mo145f();
            return;
        }
        throw new IOException("closed");
    }

    public void writePing(C2011ne c2011ne) {
        writeControlFrame(9, c2011ne);
    }

    public void writePong(C2011ne c2011ne) {
        writeControlFrame(10, c2011ne);
    }
}
