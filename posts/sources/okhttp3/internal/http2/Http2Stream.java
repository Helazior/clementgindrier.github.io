package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    private boolean hasResponseHeaders;

    /* renamed from: id */
    public final int f5629id;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    public final FramingSink sink;
    private final FramingSource source;
    public long unacknowledgedBytesRead = 0;
    public final StreamTimeout readTimeout = new StreamTimeout();
    public final StreamTimeout writeTimeout = new StreamTimeout();
    public ErrorCode errorCode = null;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class FramingSink implements InterfaceC0050Be {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        public boolean closed;
        public boolean finished;
        private final C1946ke sendBuffer = new C1946ke();

        public FramingSink() {
        }

        private void emitFrame(boolean z) {
            Http2Stream http2Stream;
            long min;
            Http2Stream http2Stream2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (true) {
                    http2Stream = Http2Stream.this;
                    if (http2Stream.bytesLeftInWriteWindow > 0 || this.finished || this.closed || http2Stream.errorCode != null) {
                        break;
                    }
                    http2Stream.waitForIo();
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                min = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.f5398b);
                http2Stream2 = Http2Stream.this;
                http2Stream2.bytesLeftInWriteWindow -= min;
            }
            http2Stream2.writeTimeout.enter();
            try {
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.connection.writeData(http2Stream3.f5629id, z && min == this.sendBuffer.f5398b, this.sendBuffer, min);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                Http2Stream http2Stream = Http2Stream.this;
                if (!http2Stream.sink.finished) {
                    if (this.sendBuffer.f5398b > 0) {
                        while (this.sendBuffer.f5398b > 0) {
                            emitFrame(true);
                        }
                    } else {
                        http2Stream.connection.writeData(http2Stream.f5629id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary();
            }
        }

        @Override // p000.InterfaceC0050Be, java.io.Flushable
        public void flush() {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.f5398b > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // p000.InterfaceC0050Be
        public C0097De timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // p000.InterfaceC0050Be
        public void write(C1946ke c1946ke, long j) {
            this.sendBuffer.write(c1946ke, j);
            while (this.sendBuffer.f5398b >= EMIT_BUFFER_SIZE) {
                emitFrame(false);
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class FramingSource implements InterfaceC0073Ce {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        private final long maxByteCount;
        private final C1946ke receiveBuffer = new C1946ke();
        private final C1946ke readBuffer = new C1946ke();

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void checkNotClosed() {
            if (!this.closed) {
                if (Http2Stream.this.errorCode != null) {
                    throw new StreamResetException(Http2Stream.this.errorCode);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        private void waitUntilReadable() {
            Http2Stream.this.readTimeout.enter();
            while (this.readBuffer.f5398b == 0 && !this.finished && !this.closed) {
                try {
                    Http2Stream http2Stream = Http2Stream.this;
                    if (http2Stream.errorCode != null) {
                        break;
                    }
                    http2Stream.waitForIo();
                } finally {
                    Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (Http2Stream.this) {
                this.closed = true;
                this.readBuffer.m676E();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        @Override // p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            if (j >= 0) {
                synchronized (Http2Stream.this) {
                    waitUntilReadable();
                    checkNotClosed();
                    C1946ke c1946ke2 = this.readBuffer;
                    long j2 = c1946ke2.f5398b;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long read = c1946ke2.read(c1946ke, Math.min(j, j2));
                    Http2Stream http2Stream = Http2Stream.this;
                    long j3 = http2Stream.unacknowledgedBytesRead + read;
                    http2Stream.unacknowledgedBytesRead = j3;
                    if (j3 >= http2Stream.connection.okHttpSettings.getInitialWindowSize() / 2) {
                        Http2Stream http2Stream2 = Http2Stream.this;
                        http2Stream2.connection.writeWindowUpdateLater(http2Stream2.f5629id, http2Stream2.unacknowledgedBytesRead);
                        Http2Stream.this.unacknowledgedBytesRead = 0L;
                    }
                    synchronized (Http2Stream.this.connection) {
                        Http2Connection http2Connection = Http2Stream.this.connection;
                        long j4 = http2Connection.unacknowledgedBytesRead + read;
                        http2Connection.unacknowledgedBytesRead = j4;
                        if (j4 >= http2Connection.okHttpSettings.getInitialWindowSize() / 2) {
                            Http2Connection http2Connection2 = Http2Stream.this.connection;
                            http2Connection2.writeWindowUpdateLater(0, http2Connection2.unacknowledgedBytesRead);
                            Http2Stream.this.connection.unacknowledgedBytesRead = 0L;
                        }
                    }
                    return read;
                }
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }

        public void receive(InterfaceC1987me interfaceC1987me, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.f5398b + j > this.maxByteCount;
                }
                if (z3) {
                    interfaceC1987me.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    interfaceC1987me.skip(j);
                    return;
                } else {
                    long read = interfaceC1987me.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (Http2Stream.this) {
                            C1946ke c1946ke = this.readBuffer;
                            if (c1946ke.f5398b != 0) {
                                z2 = false;
                            }
                            c1946ke.mo147c(this.receiveBuffer);
                            if (z2) {
                                Http2Stream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // p000.InterfaceC0073Ce
        public C0097De timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class StreamTimeout extends C1900ie {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // p000.C1900ie
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p000.C1900ie
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        Objects.requireNonNull(http2Connection, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.f5629id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        FramingSource framingSource = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        FramingSink framingSink = new FramingSink();
        this.sink = framingSink;
        framingSource.finished = z2;
        framingSink.finished = z;
        this.requestHeaders = list;
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.f5629id);
            return true;
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void cancelStreamIfNecessary() {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            FramingSource framingSource = this.source;
            if (!framingSource.finished && framingSource.closed) {
                FramingSink framingSink = this.sink;
                if (framingSink.finished || framingSink.closed) {
                    z = true;
                    isOpen = isOpen();
                }
            }
            z = false;
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (isOpen) {
        } else {
            this.connection.removeStream(this.f5629id);
        }
    }

    public void checkOutNotClosed() {
        FramingSink framingSink = this.sink;
        if (!framingSink.closed) {
            if (!framingSink.finished) {
                if (this.errorCode != null) {
                    throw new StreamResetException(this.errorCode);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void close(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.f5629id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.f5629id, errorCode);
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.f5629id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public InterfaceC0050Be getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public InterfaceC0073Ce getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.f5629id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            FramingSink framingSink = this.sink;
            if (framingSink.finished || framingSink.closed) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
        }
        return true;
    }

    public C0097De readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(InterfaceC1987me interfaceC1987me, int i) {
        this.source.receive(interfaceC1987me, i);
    }

    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.connection.removeStream(this.f5629id);
    }

    public void receiveHeaders(List<Header> list) {
        boolean z;
        synchronized (this) {
            z = true;
            this.hasResponseHeaders = true;
            if (this.responseHeaders == null) {
                this.responseHeaders = list;
                z = isOpen();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.add(null);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.connection.removeStream(this.f5629id);
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public void sendResponseHeaders(List<Header> list, boolean z) {
        Objects.requireNonNull(list, "responseHeaders == null");
        boolean z2 = false;
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (!z) {
                this.sink.finished = true;
                z2 = true;
            }
        }
        this.connection.writeSynReply(this.f5629id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public synchronized List<Header> takeResponseHeaders() {
        List<Header> list;
        if (isLocallyInitiated()) {
            this.readTimeout.enter();
            while (this.responseHeaders == null && this.errorCode == null) {
                waitForIo();
            }
            this.readTimeout.exitAndThrowIfTimedOut();
            list = this.responseHeaders;
            if (list != null) {
                this.responseHeaders = null;
            } else {
                throw new StreamResetException(this.errorCode);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public void waitForIo() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public C0097De writeTimeout() {
        return this.writeTimeout;
    }
}
