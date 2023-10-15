package okhttp3.internal.p007ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p007ws.WebSocketReader;

/* renamed from: okhttp3.internal.ws.RealWebSocket */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    public final WebSocketListener listener;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<C2011ne> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    /* renamed from: okhttp3.internal.ws.RealWebSocket$CancelRunnable */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Close */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Close {
        public final long cancelAfterCloseMillis;
        public final int code;
        public final C2011ne reason;

        public Close(int i, C2011ne c2011ne, long j) {
            this.code = i;
            this.reason = c2011ne;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Message */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Message {
        public final C2011ne data;
        public final int formatOpcode;

        public Message(int i, C2011ne c2011ne) {
            this.formatOpcode = i;
            this.data = c2011ne;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$PingRunnable */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Streams */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final InterfaceC1966le sink;
        public final InterfaceC1987me source;

        public Streams(boolean z, InterfaceC1987me interfaceC1987me, InterfaceC1966le interfaceC1966le) {
            this.client = z;
            this.source = interfaceC1987me;
            this.sink = interfaceC1966le;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        if ("GET".equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random;
            this.pingIntervalMillis = j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.key = C2011ne.m554i(bArr).mo562a();
            this.writerRunnable = new Runnable() { // from class: okhttp3.internal.ws.RealWebSocket.1
                @Override // java.lang.Runnable
                public void run() {
                    do {
                        try {
                        } catch (IOException e) {
                            RealWebSocket.this.failWebSocket(e, null);
                            return;
                        }
                    } while (RealWebSocket.this.writeOneFrame());
                }
            };
            return;
        }
        StringBuilder m253r = outline.m253r("Request must be GET: ");
        m253r.append(request.method());
        throw new IllegalArgumentException(m253r.toString());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    public void awaitTermination(int i, TimeUnit timeUnit) {
        this.executor.awaitTermination(i, timeUnit);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void checkResponse(Response response) {
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String mo562a = C2011ne.m557f(this.key + WebSocketProtocol.ACCEPT_MAGIC).mo551l().mo562a();
                    if (mo562a.equals(header3)) {
                        return;
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + mo562a + "' but was '" + header3 + "'");
                }
                throw new ProtocolException(outline.m265f("Expected 'Upgrade' header value 'websocket' but was '", header2, "'"));
            }
            throw new ProtocolException(outline.m265f("Expected 'Connection' header value 'Upgrade' but was '", header, "'"));
        }
        StringBuilder m253r = outline.m253r("Expected HTTP 101 response but was '");
        m253r.append(response.code());
        m253r.append(" ");
        m253r.append(response.message());
        m253r.append("'");
        throw new ProtocolException(m253r.toString());
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return close(i, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.call = newWebSocketCall;
        newWebSocketCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.listener.onOpen(realWebSocket, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, @Nullable Response response) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.listener.onFailure(this, exc, response);
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) {
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.executor = scheduledThreadPoolExecutor;
            if (this.pingIntervalMillis != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j = this.pingIntervalMillis;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.p007ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Streams streams;
        if (i != -1) {
            synchronized (this) {
                if (this.receivedCloseCode == -1) {
                    this.receivedCloseCode = i;
                    this.receivedCloseReason = str;
                    streams = null;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.executor.shutdown();
                        streams = streams2;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.listener.onClosing(this, i, str);
                if (streams != null) {
                    this.listener.onClosed(this, i, str);
                }
                return;
            } finally {
                Util.closeQuietly(streams);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // okhttp3.internal.p007ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) {
        this.listener.onMessage(this, str);
    }

    @Override // okhttp3.internal.p007ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(C2011ne c2011ne) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(c2011ne);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.p007ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(C2011ne c2011ne) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public synchronized boolean pong(C2011ne c2011ne) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(c2011ne);
            runWriter();
            return true;
        }
        return false;
    }

    public boolean processNextFrame() {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return send(C2011ne.m557f(str), 1);
    }

    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public void tearDown() {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    public boolean writeOneFrame() {
        Streams streams;
        String str;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            C2011ne poll = this.pongQueue.poll();
            int i = -1;
            Message message = null;
            if (poll == null) {
                Object poll2 = this.messageAndCloseQueue.poll();
                if (poll2 instanceof Close) {
                    int i2 = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i2 != -1) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        message = poll2;
                        i = i2;
                        streams = streams2;
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) poll2).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                        i = i2;
                        streams = null;
                    }
                } else if (poll2 == null) {
                    return false;
                } else {
                    streams = null;
                    str = null;
                }
                message = poll2;
            } else {
                streams = null;
                str = null;
            }
            try {
                if (poll != null) {
                    webSocketWriter.writePong(poll);
                } else if (message instanceof Message) {
                    C2011ne c2011ne = message.data;
                    InterfaceC0050Be newMessageSink = webSocketWriter.newMessageSink(message.formatOpcode, c2011ne.mo550m());
                    Logger logger = C2263te.f6595a;
                    C2335we c2335we = new C2335we(newMessageSink);
                    c2335we.mo140q(c2011ne);
                    c2335we.close();
                    synchronized (this) {
                        this.queueSize -= c2011ne.mo550m();
                    }
                } else if (message instanceof Close) {
                    Close close = (Close) message;
                    webSocketWriter.writeClose(close.code, close.reason);
                    if (streams != null) {
                        this.listener.onClosed(this, i, str);
                    }
                } else {
                    throw new AssertionError();
                }
                return true;
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void writePingFrame() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i != -1) {
                StringBuilder m253r = outline.m253r("sent ping but didn't receive pong within ");
                m253r.append(this.pingIntervalMillis);
                m253r.append("ms (after ");
                m253r.append(i - 1);
                m253r.append(" successful ping/pongs)");
                failWebSocket(new SocketTimeoutException(m253r.toString()), null);
                return;
            }
            try {
                webSocketWriter.writePing(C2011ne.f5561f);
            } catch (IOException e) {
                failWebSocket(e, null);
            }
        }
    }

    public synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.validateCloseCode(i);
        C2011ne c2011ne = null;
        if (str != null) {
            c2011ne = C2011ne.m557f(str);
            if (c2011ne.f5562a.length > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(i, c2011ne, j));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.p007ws.WebSocketReader.FrameCallback
    public void onReadMessage(C2011ne c2011ne) {
        this.listener.onMessage(this, c2011ne);
    }

    @Override // okhttp3.WebSocket
    public boolean send(C2011ne c2011ne) {
        Objects.requireNonNull(c2011ne, "bytes == null");
        return send(c2011ne, 2);
    }

    private synchronized boolean send(C2011ne c2011ne, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + c2011ne.mo550m() > MAX_QUEUE_SIZE) {
                close(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, null);
                return false;
            }
            this.queueSize += c2011ne.mo550m();
            this.messageAndCloseQueue.add(new Message(i, c2011ne));
            runWriter();
            return true;
        }
        return false;
    }
}
