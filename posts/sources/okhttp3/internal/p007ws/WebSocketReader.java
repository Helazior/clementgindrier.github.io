package okhttp3.internal.p007ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p000.C1946ke;

/* renamed from: okhttp3.internal.ws.WebSocketReader */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class WebSocketReader {
    public boolean closed;
    public final FrameCallback frameCallback;
    public long frameLength;
    public final boolean isClient;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    private final C1946ke.C1948b maskCursor;
    private final byte[] maskKey;
    public int opcode;
    public final InterfaceC1987me source;
    private final C1946ke controlFrameBuffer = new C1946ke();
    private final C1946ke messageFrameBuffer = new C1946ke();

    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(C2011ne c2011ne);

        void onReadPing(C2011ne c2011ne);

        void onReadPong(C2011ne c2011ne);
    }

    public WebSocketReader(boolean z, InterfaceC1987me interfaceC1987me, FrameCallback frameCallback) {
        Objects.requireNonNull(interfaceC1987me, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.isClient = z;
        this.source = interfaceC1987me;
        this.frameCallback = frameCallback;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new C1946ke.C1948b();
    }

    private void readControlFrame() {
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.mo83r(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.m669L(this.maskCursor);
                this.maskCursor.m650E(0L);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                C1946ke c1946ke = this.controlFrameBuffer;
                long j2 = c1946ke.f5398b;
                if (j2 != 1) {
                    if (j2 != 0) {
                        s = c1946ke.readShort();
                        str = this.controlFrameBuffer.m666O();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.m668M());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.m668M());
                return;
            default:
                StringBuilder m253r = outline.m253r("Unknown control opcode: ");
                m253r.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(m253r.toString());
        }
    }

    /* JADX WARN: Finally extract failed */
    private void readHeader() {
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                int readByte = this.source.readByte() & 255;
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = readByte & 15;
                boolean z = (readByte & 128) != 0;
                this.isFinalFrame = z;
                boolean z2 = (readByte & 8) != 0;
                this.isControlFrame = z2;
                if (z2 && !z) {
                    throw new ProtocolException("Control frames must be final.");
                }
                boolean z3 = (readByte & 64) != 0;
                boolean z4 = (readByte & 32) != 0;
                boolean z5 = (readByte & 16) != 0;
                if (!z3 && !z4 && !z5) {
                    int readByte2 = this.source.readByte() & 255;
                    boolean z6 = (readByte2 & 128) != 0;
                    if (z6 == this.isClient) {
                        throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = readByte2 & 127;
                    this.frameLength = j;
                    if (j == 126) {
                        this.frameLength = this.source.readShort() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                    } else if (j == 127) {
                        long readLong = this.source.readLong();
                        this.frameLength = readLong;
                        if (readLong < 0) {
                            StringBuilder m253r = outline.m253r("Frame length 0x");
                            m253r.append(Long.toHexString(this.frameLength));
                            m253r.append(" > 0x7FFFFFFFFFFFFFFF");
                            throw new ProtocolException(m253r.toString());
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    }
                    if (z6) {
                        this.source.readFully(this.maskKey);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("Reserved flags are unsupported.");
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        }
        throw new IOException("closed");
    }

    private void readMessage() {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.mo83r(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.m669L(this.maskCursor);
                    this.maskCursor.m650E(this.messageFrameBuffer.f5398b - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                StringBuilder m253r = outline.m253r("Expected continuation opcode. Got: ");
                m253r.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(m253r.toString());
            }
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            StringBuilder m253r = outline.m253r("Unknown opcode: ");
            m253r.append(Integer.toHexString(i));
            throw new ProtocolException(m253r.toString());
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.m666O());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.m668M());
        }
    }

    private void readUntilNonControlFrame() {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            }
            readControlFrame();
        }
    }

    public void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
